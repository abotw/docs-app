---
title: "HA: Deploy"
icon: simple/homeassistant
status: done
---

## 0. What we’re deploying (important first)

On macOS with Docker, you **cannot** run *Home Assistant OS*.
You will run:

>   ✅ **Home Assistant Container**

That means:

-   ✔ Core HA features (dashboard, automations, integrations)
-   ❌ No “Supervisor / Add-ons” tab
-   ✔ Still very powerful (recommended for Mac users)

You can always migrate later to HA OS on a mini PC / NUC.

## 1. Prerequisites

### Hardware

-   Mac mini **M4** (Apple Silicon, ARM64)

### Software

-   **OrbStack** (installed & running)
-   macOS user with admin rights

If OrbStack works and you can run Docker containers → you’re good.

## 2. Create a persistent data directory

Home Assistant **must** store data outside the container.

Open **Terminal**:

```bash
mkdir -p ~/docker/homeassistant
```

This directory will store:

-   Configuration
-   Automations
-   Database
-   Backups

If the container is deleted, your data stays.

## 3. Choose the correct Home Assistant image

For Apple Silicon:

-   Architecture: **ARM64**
-   Image: `ghcr.io/home-assistant/home-assistant:stable`

Good news 🎉

Home Assistant provides **native ARM images**, so **no emulation needed**.

## 4. Run Home Assistant using Docker (recommended way)

### Option A: Docker CLI (simple & explicit)

```bash
docker run -d \
  --name homeassistant \
  --restart unless-stopped \
  --privileged \
  -e TZ=Asia/Taipei \
  -v ~/docker/homeassistant:/config \
  --network=host \
  ghcr.io/home-assistant/home-assistant:stable
```

### Explanation (important)

| Option                              | Meaning                 |
| ----------------------------------- | ----------------------- |
| `--name homeassistant`              | Container name          |
| `--restart unless-stopped`          | Auto-start on boot      |
| `--privileged`                      | Needed for integrations |
| `TZ=Asia/Shanghai`                  | Correct timezone        |
| `-v ~/docker/homeassistant:/config` | Persistent data         |
| `--network=host`                    | Best device discovery   |
| `stable`                            | Stable HA version       |

>   ⚠️ `--network=host` works **perfectly in OrbStack** (unlike Docker Desktop).

## 5. (Alternative) Deploy using Docker Compose

If you prefer Compose (recommended long-term):

### Create `docker-compose.yml`

```bash
cd ~/docker/homeassistant
nano docker-compose.yml

services:
  homeassistant:
    container_name: homeassistant
    image: ghcr.io/home-assistant/home-assistant:stable
    restart: unless-stopped
    privileged: true
    network_mode: host
    environment:
      - TZ=Asia/Shanghai
    volumes:
      - ./config:/config
```

Then start it:

```bash
docker compose up -d
```

## 6. First boot (be patient)

Home Assistant takes **1–3 minutes** on first start.

Check logs if curious:

```bash
docker logs -f homeassistant
```

Wait until you see something like:

```
Home Assistant initialized
```

## 7. Access Home Assistant

Open your browser:

```
http://localhost:8123
```

Or:

```
http://homeassistant.local:8123
```

You should see the **Home Assistant onboarding screen** 🎉

## 8. Initial setup (first time)

You’ll be guided to:

1.  Create a user
2.  Set location
3.  Set unit system
4.  Auto-discover devices

Home Assistant will immediately scan:

-   Network devices
-   Media players
-   Smart TVs
-   Routers
-   Some smart plugs

## 9. Important OrbStack notes (Mac-specific)

### ✅ Why OrbStack is great for HA

-   Native Apple Silicon performance
-   Proper host networking
-   Low overhead
-   No weird mDNS issues (Bonjour works)

### ⚠️ USB devices (Zigbee / Z-Wave)

macOS **cannot directly pass USB** into Docker reliably.

Solutions:

1.  Use **network-based coordinators** (recommended)
    -   Zigbee over Ethernet
    -   Zigbee2MQTT on another machine
2.  Or run HA OS on dedicated hardware later

For Wi-Fi devices: **no problem at all**.

## 10. Updating Home Assistant (Docker way)

Very simple:

```bash
docker pull ghcr.io/home-assistant/home-assistant:stable
docker stop homeassistant
docker rm homeassistant
```

Then re-run the same `docker run` or:

```bash
docker compose up -d
```

Your config stays untouched.

## 11. Backup strategy (important!)

Since no Supervisor:

-   Your backup is simply `~/docker/homeassistant`

You can:

-   Time Machine it
-   Sync it to NAS
-   Git version control (advanced)

## 12. Common beginner mistakes

❌ Forgetting volume mapping

→ All config lost after restart

❌ Using bridge network

→ Device discovery broken

❌ Expecting “Add-ons tab”

→ That’s HA OS only

## 13. When should you move off macOS?

Mac + Docker is perfect if:

-   You’re learning
-   Mostly Wi-Fi devices
-   Dashboard & automation focused

Move to HA OS if:

-   Heavy Zigbee/Z-Wave
-   24/7 always-on server
-   Want Supervisor & Add-ons

Migration is painless later.

## 14. Final takeaway

**M4 Mac mini + OrbStack + Docker** gives you:

-   ⚡ Fast ARM-native performance
-   🧼 Clean environment
-   🧠 Full Home Assistant core features

It’s one of the **best dev + learning setups** for Home Assistant.

