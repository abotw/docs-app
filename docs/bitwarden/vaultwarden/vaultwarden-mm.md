---
title: "Vaultwarden: Deploying on M4 Mac mini"
icon: simple/vaultwarden
---

## 0. What is Vaultwarden (and why use it)?

**Vaultwarden** is:

-   A **lightweight, open-source Bitwarden server** implementation
-   Written in Rust, very resource-efficient
-   Perfect for **self-hosting at home** or on a personal server

Compared to the official Bitwarden server:

-   Much simpler to deploy
-   Lower CPU / RAM usage
-   Ideal for Mac mini, Raspberry Pi, VPS, etc.

⚠️ **Important note**
Vaultwarden is **unofficial**, but widely used and well-maintained.

## 1. What You Need Before Starting

### Hardware

-   ✅ **M4 Mac mini** (Apple Silicon, ARM64)
-   At least **8 GB RAM** recommended

### Software

-   macOS Sonoma or newer
-   Docker Desktop for Mac (Apple Silicon version)
-   Terminal (built-in)

### Network (choose one)

-   🟢 **Local use only** (LAN / localhost)
-   🌍 **Remote access** (requires domain + HTTPS, explained later)

## 2. Install Docker Desktop (Apple Silicon)

### Step 1: Download Docker

Go to Docker official website and download:

>   Docker Desktop for **Mac (Apple chip)**

Install it normally (drag to Applications).

### Step 2: Start Docker

-   Open **Docker Desktop**
-   Wait until you see **“Docker is running”**

Verify in Terminal:

```bash
docker version
```

If you see version info → Docker is ready ✅

## 3. Prepare a Working Directory

We’ll keep everything clean and organized.

```bash
mkdir -p ~/vaultwarden
cd ~/vaultwarden
```

Directory structure (later):

```
vaultwarden/
├── docker-compose.yml
└── data/
```

## 4. Create `docker-compose.yml`

This is the **core configuration file**.

Create and edit:

```bash
nano docker-compose.yml
```

### Minimal Beginner Configuration (Recommended)

```yaml
version: "3.8"

services:
  vaultwarden:
    image: vaultwarden/server:latest
    container_name: vaultwarden
    restart: unless-stopped

    ports:
      - "8080:80"

    volumes:
      - ./data:/data

    environment:
      WEBSOCKET_ENABLED: "true"
      SIGNUPS_ALLOWED: "true"
```

### Explanation (Very Important)

| Item                | Meaning                                    |
| ------------------- | ------------------------------------------ |
| `image`             | Vaultwarden official Docker image          |
| `8080:80`           | Host port 8080 → container port 80         |
| `./data:/data`      | Persistent storage (passwords stored here) |
| `WEBSOCKET_ENABLED` | Needed for browser extension sync          |
| `SIGNUPS_ALLOWED`   | Allow account creation (disable later)     |

Save and exit:

```
Ctrl + O → Enter
Ctrl + X
```

## 5. Start Vaultwarden Server

Run:

```bash
docker compose up -d
```

Check status:

```bash
docker ps
```

You should see:

```
vaultwarden   Up   0.0.0.0:8080->80/tcp
```

## 6. Access Vaultwarden Web UI

Open browser and visit:

```
http://localhost:8080
```

You should see:

✅ **Vaultwarden Web Vault (Bitwarden UI)**

## 7. Create Your First Account

1.  Click **Create Account**
2.  Use a **strong master password**
3.  Remember it — **cannot be recovered**

⚠️ If this server is public later, **disable signups** after creating your account.

## 8. Install Bitwarden Clients

Vaultwarden works with **official Bitwarden apps**.

### Recommended Clients

-   Bitwarden Browser Extension (Chrome / Firefox / Safari)
-   Bitwarden Desktop App
-   Bitwarden Mobile App (iOS / Android)

### Configure Client

In Bitwarden client:

1.  Accessing → **Self-hosted**

2.  Server URL:

    ```
    https://vaultwarden.lan
    ```

    or

    ```
    http://localhost:8080
    ```

Login with your account.

## 9. Find Your Mac mini LAN IP (Local Use)

```bash
ipconfig getifaddr en0
```

Example:

```
192.168.1.50
```

Then access from other devices:

```
http://192.168.1.50:8080
```

------

## 10. Disable Public Signup (Important)

After your account is created:

Edit config:

```bash
nano docker-compose.yml
```

Change:

```yaml
SIGNUPS_ALLOWED: "false"
```

Restart:

```bash
docker compose down
docker compose up -d
```

------

## 11. Enable Admin Panel (Optional but Recommended)

Add **admin token** (random & strong):

```bash
openssl rand -base64 48
```

Edit `docker-compose.yml`:

```yaml
environment:
  WEBSOCKET_ENABLED: "true"
  SIGNUPS_ALLOWED: "false"
  ADMIN_TOKEN: "PASTE_GENERATED_TOKEN"
```

Restart:

```bash
docker compose up -d
```

Admin panel:

```
http://localhost:8080/admin
```

------

## 12. Data Backup (Very Important)

Your passwords are stored in:

```
~/vaultwarden/data/
```

Backup this folder regularly:

-   Time Machine
-   External disk
-   Encrypted cloud backup

------

## 13. (Advanced) Expose to Internet with HTTPS (Overview)

⚠️ **Do NOT expose without HTTPS**

Typical stack:

```
Internet
  ↓
Nginx / Caddy (HTTPS)
  ↓
Vaultwarden (localhost)
```

Recommended for beginners:

-   **Caddy** (automatic HTTPS)
-   Domain name
-   Port forwarding on router

If you want, I can provide:

-   ✅ Caddy + Vaultwarden config
-   ✅ ZeroTier / Tailscale private access
-   ✅ Cloudflare Tunnel (no port forwarding)

------

## 14. Common Problems & Fixes

### Container won’t start

```bash
docker logs vaultwarden
```

### Port conflict

Change:

```yaml
"8081:80"
```

### Apple Silicon compatibility

Vaultwarden **fully supports ARM64** ✅

------

## 15. Security Best Practices (Summary)

-   Use **strong master password**
-   Disable signups
-   Enable admin token
-   Backup `data/`
-   Use HTTPS for remote access
-   Prefer **private VPN (Tailscale)** for beginners

------

## 16. What You’ve Achieved 🎉

-   ✅ Self-hosted Bitwarden-compatible password manager
-   ✅ Running efficiently on M4 Mac mini
-   ✅ Full control of your data

------

If you want next steps, I can:

-   Help you **add HTTPS (Caddy)**
-   Show **Tailscale / ZeroTier private access**
-   Harden security for **public deployment**
-   Migrate from **official Bitwarden cloud**

Just tell me 👍