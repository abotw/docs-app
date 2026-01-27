---
title: "Vaultwarden: HTTPS in LAN"
icon: simple/vaultwarden
---

## First: Important Reality Check

### ❌ What you CANNOT do

-   You **cannot** get a trusted HTTPS certificate from Let’s Encrypt **without a domain name**
-   Browsers will **not trust** certificates issued for:
    -   IP addresses (`https://192.168.1.50`)
    -   `.local` hostnames
    -   random names

### ✅ What you CAN do

-   Use **self-signed certificates**
-   Use a **local Certificate Authority (CA)**
-   Make **your own devices trust your CA**
-   Get **green lock HTTPS inside LAN**

This is **exactly how companies do internal HTTPS**.

## Recommended LAN-Only Solution (Beginner-Friendly)

### ✅ **Caddy + Local CA (Trusted by Your Devices)**

Caddy can:

-   act as your **local CA**
-   automatically issue LAN HTTPS certificates
-   work with IP addresses or hostnames
-   be trusted by your devices **after one-time setup**

This is the **cleanest solution**.

------

# Solution A (BEST): Caddy Local CA HTTPS

## 1. How This Works (Concept)

```
Device Browser
   │ (trusted CA)
   ↓
https://vaultwarden.lan
   ↓
Caddy (local CA)
   ↓
Vaultwarden (HTTP)
```

You will:

1.  Let Caddy generate a **local root CA**
2.  Install this CA on your devices (Mac / iPhone / Windows)
3.  Use HTTPS normally in LAN

------

## 2. Pick a LAN Hostname

Choose one (do NOT use `.dev` or real TLDs):

Recommended:

-   `vaultwarden.lan`
-   `vault.local`
-   `bw.home`

We’ll use:

```
vaultwarden.lan
```

------

## 3. Point Hostname to Your Mac mini

### Option 1: Router DNS (Best)

If your router supports custom DNS:

```
vaultwarden.lan → 192.168.1.50
```

### Option 2: Hosts File (Beginner)

On **each client device**:

#### macOS

```bash
sudo nano /etc/hosts
```

Add:

```
192.168.8.240  vaultwarden.lan
```

## 4. Update `docker-compose.yml`

We will use **Caddy with internal CA**.

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
      - "443:443"

    volumes:
      - ./Caddyfile:/etc/caddy/Caddyfile
      - caddy_data:/data
      - caddy_config:/config

volumes:
  caddy_data:
  caddy_config:
```

## 5. Create Caddyfile (Internal HTTPS)

```bash
nano Caddyfile
```

### Caddyfile (LAN HTTPS)

```caddy
vaultwarden.lan {

    tls internal

    encode gzip

    reverse_proxy vaultwarden:80
}
```

What this does:

-   `tls internal` → Caddy acts as **local CA**
-   Certificate valid only in LAN
-   No internet required

Save and exit.

## 6. Start Services

```bash
docker compose up -d
```

Access:

```
https://vaultwarden.lan
```

At this point:

-   HTTPS works
-   Browser shows **certificate warning** ❗

This is expected.

## 7. Trust Caddy’s Local CA (One-Time Setup)

### On macOS (Mac mini & Macs)

Find CA:

```bash
docker exec caddy caddy trust
```

This installs the CA **inside the container**, but we need it on macOS.

Export CA:

```bash
docker cp caddy:/data/caddy/pki/authorities/local/root.crt ./Desktop/caddy-root.crt
```

Install:

1.  Double-click `caddy-root.crt`
2.  Open **Keychain Access**
3.  Install to **System**
4.  Set:
    -   “Always Trust”

Restart browser.

### On iPhone / iPad (Optional)

1.  AirDrop `caddy-root.crt`
2.  Settings → General → VPN & Device Management → Install Profile
3.  Settings → About → Certificate Trust Settings
4.  Enable full trust

### On Windows (Optional)

-   Import certificate into:
    -   **Trusted Root Certification Authorities**

------

## 8. Verify HTTPS

Reload:

```
https://vaultwarden.lan
```

You should see:

-   🔒 Green lock
-   No warning
-   Valid certificate (Issued by “Caddy Local Authority”)

------

## 9. Configure Bitwarden Clients

In Bitwarden apps:

-   Settings → Self-hosted
-   Server URL:

```
https://vaultwarden.lan
```

Works perfectly inside LAN.

------

## 10. Security Notes (Important)

-   CA private key is stored in:

    ```
    caddy_data volume
    ```

-   Anyone with this CA could MITM — **do not expose outside LAN**

-   This is **standard practice for internal services**

------

# Solution B (Alternative): HTTPS by IP (NOT Recommended)

You *can* do:

```caddy
https://192.168.1.50 {
    tls internal
}
```

But:

-   Many clients break
-   Bitwarden apps may reject IP certs
-   Harder to manage

⚠️ Use hostname instead.

------

## Final Recommendation ⭐

For **LAN-only HTTPS without domain**:

| Item          | Choice            |
| ------------- | ----------------- |
| Reverse proxy | Caddy             |
| Certificate   | Local CA          |
| Hostname      | `vaultwarden.lan` |
| Trust method  | Install CA once   |
| Security      | Excellent for LAN |