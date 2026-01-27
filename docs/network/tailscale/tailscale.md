# Tailscale

*A Zero-Config VPN for Everyone*

## 1. What Is Tailscale?

**Tailscale** is a **modern VPN** that lets your devices securely connect to each other **as if they were on the same local network**, no matter where they are.

Instead of:

-   opening ports
-   configuring routers
-   setting up servers manually

Tailscale creates a **private mesh network** between your devices using **WireGuard**.

### In one sentence:

>   Tailscale lets your laptop, phone, server, and router talk to each other securely from anywhere.

## 2. What Problems Does Tailscale Solve?

Traditional VPNs are hard because:

-   NAT & firewalls block connections
-   Port forwarding is risky
-   Public IPs cost money
-   Configs are complex

Tailscale solves this by:

-   Automatically punching through NAT
-   Using encrypted peer-to-peer connections
-   Falling back to relay servers when needed
-   Managing identity via your existing login (Google, GitHub, Microsoft, etc.)

## 3. How Tailscale Works (Simple Explanation)

### Core ideas:

| Component         | Meaning                                   |
| ----------------- | ----------------------------------------- |
| **Device (Node)** | Any machine running Tailscale             |
| **Tailnet**       | Your private Tailscale network            |
| **WireGuard**     | The VPN **protocol**                      |
| **Control Plane** | Tailscale’s coordination server           |
| **DERP**          | Relay servers for NAT-restricted networks |

### Connection flow:

1.  Devices authenticate via your account
2.  Tailscale assigns **private IPs** (100.x.y.z)
3.  Devices try **direct encrypted connections**
4.  If blocked → use **DERP relay**

🔐 **End-to-end encrypted** (even Tailscale can’t see your traffic)

## 4. Typical Use Cases

### Personal

-   Access home PC from anywhere
-   SSH into Raspberry Pi remotely
-   Share files securely
-   Avoid public Wi-Fi risks

### Developer / IT

-   Remote SSH & RDP
-   Private Kubernetes access
-   Internal dashboards
-   CI/CD infrastructure

### Networking

-   Replace OpenVPN / IPSec
-   Site-to-site VPN
-   Access LAN devices remotely

## 5. Supported Platforms

Tailscale runs on:

-   **Windows**
-   **macOS**
-   **Linux**
-   **iOS / Android**
-   **OpenWrt**
-   **Synology / QNAP**
-   **Docker / Kubernetes**

## 6. Installing Tailscale (Beginner Steps)

### Step 1: Create an Account

Go to the Tailscale website and sign in using:

-   Google
-   GitHub
-   Microsoft
-   Apple

This account controls your **tailnet**.

### Step 2: Install on Your First Device

#### macOS

```bash
brew install tailscale
sudo tailscale up
```

Or install via the official GUI app.

#### Linux

```bash
curl -fsSL https://tailscale.com/install.sh | sh
sudo tailscale up
```

#### Windows

-   Download installer
-   Sign in via browser

### Step 3: Add Another Device

Repeat installation on another device and **log in with the same account**.

🎉 Done!
Your devices can now reach each other.

## 7. Understanding Tailscale IPs

Each device gets a stable private IP:

```
100.x.y.z
```

Example:

```bash
ping 100.64.0.1
ssh user@100.64.0.2
```

No LAN, no public IP, no port forwarding needed.

## 8. Basic Usage Examples

### SSH into a Remote Machine

```bash
ssh user@100.x.y.z
```

### Access Web Services

```
http://100.x.y.z:8080
```

### RDP / VNC / SMB

Works just like a LAN.

## 9. MagicDNS (Beginner Friendly Feature)

Instead of IPs, use hostnames:

```text
laptop.tailnet-name.ts.net
```

Enable in admin panel:

```
Settings → DNS → Enable MagicDNS
```

Now:

```bash
ssh user@raspberrypi
```

## 10. Exit Nodes (Optional but Powerful)

An **Exit Node** lets you route **all traffic** through one device.

Use case:

-   Secure public Wi-Fi
-   Access home country network
-   Full VPN replacement

### Enable exit node:

```bash
sudo tailscale up --advertise-exit-node
```

### Use it on another device:

```bash
tailscale up --exit-node=home-server
```

## 11. Subnet Router (Access LAN Devices)

Use one device to expose an entire LAN.

Example:

-   Access printer, NAS, router UI remotely

```bash
sudo tailscale up --advertise-routes=192.168.1.0/24
```

Approve routes in admin panel.

## 12. ACLs (Access Control Lists)

Define who can access what.

Example:

```json
{
  "acls": [
    {
      "action": "accept",
      "src": ["user@example.com"],
      "dst": ["100.64.0.0/10:*"]
    }
  ]
}
```

Zero-trust networking made simple.

------

## 13. Security Model (Why It’s Safe)

-   WireGuard encryption
-   Device-level keys
-   Identity-based access
-   No shared secrets
-   Automatic key rotation

Even if Tailscale servers are compromised:
➡ **Your traffic remains private**

## 14. Free vs Paid

### Free Plan

-   Up to **100 devices**
-   1 user
-   All core features

### Paid

-   Teams
-   ACL management
-   SSO
-   Audit logs

For personal users → **Free is enough**

## 15. Tailscale vs Traditional VPN

| Feature       | Tailscale     | OpenVPN      |
| ------------- | ------------- | ------------ |
| Config effort | ⭐ Very low    | ❌ High       |
| NAT traversal | ✅ Automatic   | ❌ Manual     |
| Performance   | ⭐⭐⭐⭐          | ⭐⭐⭐          |
| Identity      | Account-based | Certificates |
| Scalability   | Excellent     | Complex      |

------

## 16. Common Beginner Mistakes

❌ Expecting Tailscale to bypass censorship

❌ Thinking it’s a proxy

❌ Mixing public VPN concepts

❌ Forgetting ACL approval

❌ Not enabling MagicDNS

## 17. When You SHOULD Use Tailscale

✅ Remote access

✅ Secure private networking

✅ Replace self-hosted VPN

✅ Home lab / dev environments

## 18. When You Should NOT Use Tailscale

❌ Circumvent geo-blocking

❌ Anonymous browsing

❌ Public VPN replacement for privacy

## 19. Summary

Tailscale is:

-   Simple
-   Secure
-   Fast
-   Zero-config
-   Developer-friendly

If you understand **LAN networking**, Tailscale feels like magic.
