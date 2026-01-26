# Nginx

*(From Zero to Running Your First Website)*

## 1. What is Nginx?

**Nginx (engine-x)** is a high-performance web server and reverse proxy.

It is commonly used to:

-   Serve **websites** (HTML / CSS / JS)
-   Act as a **reverse proxy** in front of backend services
-   Provide **HTTPS (TLS)** termination
-   Load-balance traffic
-   Serve static files efficiently

### Why people choose Nginx

-   Very **fast** and **low memory usage**
-   Excellent at handling **many concurrent connections**
-   Simple configuration once you understand the structure
-   Widely used in production (Cloudflare, GitHub, Netflix, etc.)

## 2. Nginx vs Apache (Very Short)

| Feature         | Nginx                          | Apache                 |
| --------------- | ------------------------------ | ---------------------- |
| Architecture    | Event-driven                   | Process / Thread based |
| Performance     | Excellent for high concurrency | Good, heavier          |
| Config style    | Declarative                    | Directive-based        |
| Dynamic modules | Limited                        | Very flexible          |

👉 **Beginner advice:**

If you’re building modern services, start with **Nginx**.

## 3. Installing Nginx

### macOS (Homebrew)

```bash
brew install nginx
```

Start it:

```bash
brew services start nginx
```

Test:

```bash
open http://127.0.0.1:8080
```

### Ubuntu / Debian

```bash
sudo apt update
sudo apt install nginx -y
```

Start:

```bash
sudo systemctl start nginx
```

Test:

```bash
curl http://127.0.0.1
```

### Check version

```bash
nginx -v
```

## 4. Important Nginx Directories

| Path                          | Purpose              |
| ----------------------------- | -------------------- |
| `/etc/nginx/nginx.conf`       | Main config file     |
| `/etc/nginx/conf.d/`          | Extra config files   |
| `/etc/nginx/sites-available/` | Virtual hosts        |
| `/etc/nginx/sites-enabled/`   | Enabled sites        |
| `/var/www/html/`              | Default website root |
| `/var/log/nginx/`             | Access & error logs  |

(macOS Homebrew paths are under `/opt/homebrew/etc/nginx/`)

## 5. Nginx Configuration Structure

Nginx config is **hierarchical**.

```nginx
main
 ├── events
 └── http
     ├── server
     │   ├── location
     │   └── location
     └── server
```

### 5.1 Minimal Config Example

```nginx
http {
    server {
        listen 80;
        server_name localhost;

        location / {
            root /var/www/html;
            index index.html;
        }
    }
}
```

## 6. Your First Website (Static Page)

### Step 1: Create files

```bash
sudo mkdir -p /var/www/demo
sudo nano /var/www/demo/index.html
<h1>Hello Nginx!</h1>
<p>This is my first Nginx site.</p>
```

### Step 2: Create a server config

```bash
sudo nano /etc/nginx/sites-available/demo
server {
    listen 80;
    server_name demo.local;

    root /var/www/demo;
    index index.html;

    location / {
        try_files $uri $uri/ =404;
    }
}
```

### Step 3: Enable it

```bash
sudo ln -s /etc/nginx/sites-available/demo /etc/nginx/sites-enabled/
```

### Step 4: Test & reload

```bash
sudo nginx -t
# sudo systemctl reload nginx
brew services restart nginx
```

-   `-t` - test

### Step 5: Test locally

```bash
curl http://127.0.0.1
```

## 7. Understanding `server` and `location`

### `server`

Represents a **virtual host** (like Apache vhost).

```nginx
server {
    listen 80;
    server_name example.com;
}
```

### `location`

Handles **URL matching rules**.

```nginx
location /api/ {
    proxy_pass http://127.0.0.1:3000;
}
```

Common match types:

| Type                   | Meaning       |
| ---------------------- | ------------- |
| `location /`           | Prefix match  |
| `location = /`         | Exact match   |
| `location ~ \.php$`    | Regex         |
| `location ^~ /static/` | Prefer prefix |

## 8. Nginx as a Reverse Proxy (Very Important)

### Scenario

-   Frontend: Nginx
-   Backend app: `http://127.0.0.1:3000`

```nginx
location / {
    proxy_pass http://127.0.0.1:3000;
    proxy_set_header Host $host;
    proxy_set_header X-Real-IP $remote_addr;
}
```

👉 This is how Nginx is used with:

-   Node.js
-   Python (FastAPI / Django)
-   Go
-   Docker containers
-   Vaultwarden, ShareLaTeX, etc.

## 9. Enable HTTPS (Basic Idea)

Nginx does HTTPS **termination**.

```nginx
server {
    listen 443 ssl;
    server_name example.com;

    ssl_certificate     cert.pem;
    ssl_certificate_key key.pem;

    location / {
        proxy_pass http://127.0.0.1:3000;
    }
}
```

In practice, certificates come from:

-   **Let’s Encrypt**
-   **Tailscale HTTPS**
-   **Self-signed (LAN only)**

## 10. Common Nginx Commands

```bash
nginx -t          # test config
nginx -s reload   # reload without downtime
nginx -s stop     # stop
nginx -s quit     # graceful stop
```

Systemd:

```bash
sudo systemctl status nginx
```

## 11. Reading Logs (Very Important)

```bash
tail -f /var/log/nginx/access.log
tail -f /var/log/nginx/error.log
```

👉 **If something doesn’t work, check `error.log` first.**

## 12. Typical Beginner Mistakes

❌ Forgetting to reload Nginx

❌ Wrong `root` path

❌ Port already in use

❌ Missing `proxy_set_header`

❌ Syntax error → Nginx won’t start

Always run:

```bash
nginx -t
```

## 13. When You Should Use Nginx

Use Nginx if you need:

-   Multiple services on one server
-   HTTPS
-   Reverse proxy
-   Static file hosting
-   High performance

## 14. What to Learn Next

Recommended next steps:

1.  Reverse proxy for multiple services
2.  HTTPS with Let’s Encrypt
3.  Docker + Nginx
4.  Nginx + Tailscale
5.  Security headers
6.  Rate limiting

## 15. Summary (One Sentence)

>   Nginx is a fast, reliable front door for your services, handling traffic, security, and performance so your apps don’t have to.