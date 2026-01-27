# LEDE

## 1. What is LEDE?

-   **LEDE** stands for **Linux Embedded Development Environment**.
-   It is a Linux-based open-source project for creating **custom firmware** for routers and embedded devices.
-   Purpose:
    -   Add new features to your router.
    -   Improve performance and stability.
    -   Customize the device beyond factory firmware limitations.
-   LEDE has merged back into OpenWrt, so most modern references use **OpenWrt**.

**Key idea:** LEDE/OpenWrt turns a standard router into a fully customizable Linux-based device.

## 2. Basic Components

1.  **Kernel**: Linux kernel runs on the device.
2.  **Root filesystem**: Contains the operating system, apps, and configs.
3.  **Packages**: Optional software modules (like VPN, ad-blockers, web server).
4.  **UCI (Unified Configuration Interface)**: A system to manage configurations via command line.
5.  **LuCI**: Optional web interface to manage settings.

## 3. Why Use LEDE?

-   Gain **full control** over your router.
-   Install additional software like:
    -   VPN clients
    -   Network monitoring tools
    -   Ad-blockers
    -   Custom scripts
-   Update firmware more frequently than stock.
-   Improve network security.

## 4. Getting Started

### Step 1: Prerequisites

-   A compatible router (check the [LEDE/OpenWrt device table](https://openwrt.org/toh/start)).
-   A PC running Linux/macOS/Windows.
-   Basic knowledge of networking.
-   Optional: a USB cable if your router supports serial console.

### Step 2: Download LEDE Firmware

-   Go to the official site: [LEDE/OpenWrt Downloads](https://openwrt.org/downloads)
-   Choose your router model.
-   Download **factory firmware** if installing for the first time, **sysupgrade firmware** if upgrading existing LEDE/OpenWrt.

### Step 3: Install the Firmware

1.  Access your router’s web interface (usually at `192.168.1.1`).
2.  Find the **Firmware Upgrade** section.
3.  Upload the downloaded firmware.
4.  Wait for the router to flash and reboot.

**⚠️ Important:** Flashing firmware incorrectly can **brick your router**. Follow instructions carefully.

## 5. First Boot

-   Connect your computer via Ethernet to the router.
-   Default IP: `192.168.1.1`
-   Default username/password: usually empty or `root`.
-   You can test connectivity by pinging `192.168.1.1`.

## 6. Accessing LEDE

1.  **Web Interface (LuCI)**:
    -   Open `http://192.168.1.1` in a browser.
    -   Navigate settings, Wi-Fi, firewall, etc.
2.  **SSH (command line)**:
    -   `ssh root@192.168.1.1`
    -   Recommended for advanced configurations.

## 7. Installing Packages

-   Example: install `htop` to monitor CPU:

```bash
opkg update
opkg install htop
htop
```

-   `opkg` is the package manager in LEDE/OpenWrt.

## 8. Useful Commands

| Command                                  | Purpose                   |
| ---------------------------------------- | ------------------------- |
| `ifconfig` / `ip addr`                   | Show network interfaces   |
| `uci show`                               | Show router configuration |
| `uci set network.lan.ipaddr=192.168.2.1` | Change LAN IP             |
| `/etc/init.d/network restart`            | Apply network changes     |
| `logread`                                | View system log           |
| `reboot`                                 | Reboot router             |

## 9. Next Steps

Once comfortable with basics:

-   Configure Wi-Fi security.
-   Install VPN (OpenVPN/ WireGuard).
-   Set up Ad-blocking.
-   Learn custom firewall rules.
-   Experiment with advanced routing (VLANs, QoS, etc.).

## 10. Tips for Beginners

-   Always backup your configuration: `sysupgrade -b /tmp/backup.tar.gz`
-   Read device-specific flash guides.
-   Test in small steps — avoid changing everything at once.
-   Use the community forums for help: [LEDE Forum](https://forum.openwrt.org/)

