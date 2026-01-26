# Tailscale CLI

*A practical guide to Tailscale commands, concepts, and daily usage*

------

## 1. What is Tailscale (in one minute)

**Tailscale = secure private network using WireGuard + your identity**

-   Creates a **private mesh VPN** between your devices
-   No port forwarding, no public IP required
-   Authentication via Google / GitHub / Microsoft / etc.
-   Devices get **stable private IPs** (`100.x.y.z`)
-   Works across:
    -   Home LAN
    -   Cloud servers
    -   NAT / CGNAT networks

Think of it as:

>   “All my devices are on the same LAN, no matter where they are.”

## 2. Installing Tailscale (CLI-first)

### macOS (Homebrew)

```bash
brew install tailscale
```

### Linux (recommended)

```bash
curl -fsSL https://tailscale.com/install.sh | sh
```

### Verify installation

```bash
tailscale version
```

## 3. Core Concepts (important before commands)

| Term              | Meaning                           |
| ----------------- | --------------------------------- |
| **Tailnet**       | Your private Tailscale network    |
| **Node**          | A device logged into Tailscale    |
| **100.x IP**      | Tailscale private IP              |
| **Control plane** | Tailscale coordination server     |
| **Data plane**    | Encrypted WireGuard traffic       |
| **ACL**           | Access control rules              |
| **Exit Node**     | Device acting as internet gateway |
| **Subnet Router** | Exposes LAN behind a node         |

------

## 4. Basic CLI Workflow (must-know)

### Login

```bash
tailscale up
```

-   Opens browser for authentication
-   Device joins your Tailnet

### Check status

```bash
tailscale status
```

Example output:

```text
100.64.0.1   macmini      online
100.64.0.2   laptop       active
100.64.0.3   server       idle
```

### Get your Tailscale IP

```bash
tailscale ip
```

or (more detail):

```bash
tailscale status --json
```

------

### Logout

```bash
tailscale down
```

------

## 5. Common Daily Commands

### Check connection health

```bash
tailscale ping <hostname>
```

Example:

```bash
tailscale ping macmini
```

-   Tests **WireGuard path**, not ICMP

------

### Show local node info

```bash
tailscale status --self
```

------

### Enable auto-start

```bash
tailscale set --accept-dns=true
```

------

## 6. Hostnames & MagicDNS

### Enable MagicDNS (once)

Admin Console → **DNS → Enable MagicDNS**

Then you can:

```bash
ssh user@macmini
curl http://server
```

Instead of:

```bash
ssh user@100.64.0.1
```

------

## 7. Tailscale Serve (expose services)

### Basic HTTP service

```bash
tailscale serve http://127.0.0.1:8080
```

Now accessible via:

```
https://<hostname>.<tailnet>.ts.net
```

------

### Serve on a path

```bash
tailscale serve /app http://127.0.0.1:3000
```

Access:

```
https://host.ts.net/app
```

### 建立路径映射

```sh
# 建立路径映射
tailscale serve --bg --set-path /git http://localhost:8080
# 清理映射
tailscale server --set-path /git off
```

### Check serve status

```bash
tailscale serve status
```

### Stop serving

```bash
tailscale serve reset
```

## 8. Exit Node (advanced but common)

### Enable exit node on a machine

```bash
tailscale up --advertise-exit-node
```

### Use an exit node

```bash
tailscale up --exit-node=<hostname>
```

### Disable exit node

```bash
tailscale up --exit-node=
```

Use case:

-   Secure public Wi-Fi
-   Route traffic via home server

------

## 9. Subnet Router (LAN access)

### Example: expose `192.168.1.0/24`

```bash
tailscale up --advertise-routes=192.168.1.0/24
```

Approve route in admin console.

Then from another device:

```bash
ping 192.168.1.10
```

------

## 10. ACL & Permissions (overview)

ACL file lives in:

```
Admin Console → Access Controls
```

Example:

```json
{
  "acls": [
    {
      "action": "accept",
      "src": ["group:admins"],
      "dst": ["*:*"]
    }
  ]
}
```

CLI side:

```bash
tailscale status --json
```

Used to debug ACL issues.

------

## 11. Troubleshooting Commands

### Check daemon

```bash
tailscale status
```

### Restart daemon (Linux)

```bash
sudo systemctl restart tailscaled
```

### Debug logs

```bash
tailscale bugreport
```

### NAT / relay info

```bash
tailscale netcheck
```

------

## 12. Common Beginner Mistakes

❌ Thinking it’s a traditional VPN
❌ Expecting ICMP ping to work
❌ Forgetting to approve subnet routes
❌ Using `tailscale serve` without HTTPS expectations
❌ Confusing Funnel vs Serve

------

## 13. Minimal Command Cheat Sheet

```bash
tailscale up
tailscale down
tailscale status
tailscale ip
tailscale ping host
tailscale serve status
tailscale serve reset
tailscale netcheck
```

------

## 14. Typical Beginner Setup Example

**Goal**: Access home Mac mini remotely

1.  Install Tailscale

2.  `tailscale up`

3.  Enable MagicDNS

4.  SSH:

    ```bash
    ssh user@macmini
    ```

5.  Serve local service:

    ```bash
    tailscale serve http://127.0.0.1:8080
    ```

No port forwarding. No router config. 🔐

------

## 15. What to Learn Next

-   `tailscale funnel` (public HTTPS)
-   ACL deep-dive
-   SSH with `tailscale ssh`
-   Using Tailscale with Docker / OrbStack
-   Reverse proxy + Tailscale (nginx, caddy)

