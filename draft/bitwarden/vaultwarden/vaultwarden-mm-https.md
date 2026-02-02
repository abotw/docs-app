---
title: "Vaultwarden: Adding HTTPS"
icon: simple/vaultwarden
---

## 1. What We Are Going to Do (Big Picture)

Right now you have:

```
Browser ──HTTP──> Vaultwarden (port 8081)
```

After this tutorial:

```
Browser ──HTTPS──> Caddy (443)
                      ↓
                  Vaultwarden (8081)
```

Caddy will:

-   automatically request TLS certificates
-   renew certificates automatically
-   forward traffic to Vaultwarden securely

## 2. Prerequisites (Very Important)

You **must have**:

### ✅ A domain name

Examples:

-   `vault.example.com`
-   `bw.yourdomain.net`

### ✅ Public IP or reachable network

One of the following:

-   Home broadband with **port forwarding**
-   VPS
-   Cloudflare Tunnel (alternative, explained later)

### ⚠️ HTTPS Requirements

Let’s Encrypt needs:

-   Port **80** (HTTP)
-   Port **443** (HTTPS)

Open or forward these ports to your Mac mini.

## 3. Check Your Current Vaultwarden Setup

Vaultwarden should still be running on **HTTP**:

```
http://localhost:8081
```

Do **NOT** enable HTTPS inside Vaultwarden itself.
Vaultwarden will stay **HTTP-only**, Caddy handles HTTPS.

## 4. Update `docker-compose.yml` (Vaultwarden)

We will **remove direct public exposure** later, but for now keep it simple.

Your Vaultwarden service should look like this:

```yaml
services:
  vaultwarden:
    image: vaultwarden/server:latest
    container_name: vaultwarden
    restart: unless-stopped

    ports:
      - "127.0.0.1:8081:80"

    volumes:
      - ./data:/data

    environment:
      WEBSOCKET_ENABLED: "true"
      SIGNUPS_ALLOWED: "false"
```

### Why `127.0.0.1`?

-   Vaultwarden is only accessible **locally**
-   External access must go through **Caddy**
-   Better security

Restart Vaultwarden:

```bash
docker compose down
docker compose up -d
```

## 5. Add Caddy to Docker Compose

Edit `docker-compose.yml`:

```bash
nano docker-compose.yml
```

### Full HTTPS Setup (Vaultwarden + Caddy)

```yaml
services:
  vaultwarden:
    image: vaultwarden/server:latest
    container_name: vaultwarden
    restart: unless-stopped

    volumes:
      - ./data:/data

    environment:
      WEBSOCKET_ENABLED: "true"
      SIGNUPS_ALLOWED: "false"

  caddy:
    image: caddy:latest
    container_name: caddy
    restart: unless-stopped

    ports:
      - "80:80"
      - "443:443"

    volumes:
      - ./Caddyfile:/etc/caddy/Caddyfile
      - caddy_data:/data
      - caddy_config:/config

volumes:
  caddy_data:
  caddy_config:
```

Save and exit.

## 6. Create the Caddyfile (HTTPS Configuration)

Create a file named `Caddyfile`:

```bash
nano Caddyfile
```

### Example Caddyfile (Replace Domain!)

```caddy
vault.example.com {

    encode gzip

    reverse_proxy vaultwarden:80 {
        header_up X-Real-IP {remote_host}
        header_up X-Forwarded-For {remote_host}
        header_up X-Forwarded-Proto {scheme}
    }
}
```

⚠️ Replace:

```
vault.example.com
```

with **your real domain name**.

Save and exit.

## 7. DNS Configuration (Critical Step)

In your domain DNS provider:

Add an **A record**:

| Type | Name  | Value          |
| ---- | ----- | -------------- |
| A    | vault | Your public IP |

Example:

```
vault.example.com → 203.xxx.xxx.xxx
```

Wait until DNS resolves (5–10 minutes usually).

Test:

```bash
ping vault.example.com
```

------

## 8. Start Everything

From `~/vaultwarden`:

```bash
docker compose up -d
```

Check logs:

```bash
docker logs caddy
```

You should see:

-   “certificate obtained successfully”
-   “TLS handshake completed”

------

## 9. Access Vaultwarden via HTTPS 🎉

Open browser:

```
https://vault.example.com
```

You should see:

-   🔒 HTTPS lock
-   Valid certificate (Let’s Encrypt)

------

## 10. Configure Bitwarden Clients (HTTPS)

In Bitwarden apps:

-   Settings → Self-hosted
-   Server URL:

```
https://vault.example.com
```

Login normally.

------

## 11. Enable WebSocket Support (Already Done)

Vaultwarden needs WebSockets for:

-   live sync
-   browser extensions

Caddy supports this **automatically** — no extra config needed.

------

## 12. Firewall & Port Forwarding Checklist

On your router:

-   Forward **80 → Mac mini**
-   Forward **443 → Mac mini**

On macOS:

-   Allow Docker in firewall
-   Allow incoming connections

------

## 13. Security Hardening (Recommended)

### Disable HTTP Access (Optional)

Caddy automatically redirects HTTP → HTTPS.

### Admin Panel

Access:

```
https://vault.example.com/admin
```

Only accessible with `ADMIN_TOKEN`.

------

## 14. Backup Reminder (Do Not Skip)

Backup:

```
~/vaultwarden/data/
```

Caddy certs:

-   Stored automatically in Docker volumes

------

## 15. Common HTTPS Problems

### ❌ Certificate not issued

-   Port 80/443 blocked
-   DNS not pointing to correct IP

### ❌ 502 Bad Gateway

-   Vaultwarden container not running
-   Wrong reverse proxy target

### ❌ Safari warns about certificate

-   DNS not fully propagated yet

------

## 16. Safer Alternatives (If You Don’t Want Port Forwarding)

If exposing ports feels risky, I strongly recommend:

-   **Tailscale (VPN-based HTTPS)**
-   **Cloudflare Tunnel (no public IP needed)**

I can write **step-by-step tutorials** for both.

------

## 17. Final Result ✅

You now have:

-   🔐 End-to-end HTTPS
-   🔁 Automatic certificate renewal
-   🧠 Secure Bitwarden-compatible server
-   ⚡ Perfectly optimized for M4 Mac mini

------

If you want next:

-   **Cloudflare Tunnel version**
-   **Tailscale private-only setup**
-   **Advanced security hardening**
-   **Email / SMTP setup**

Just tell me 👌