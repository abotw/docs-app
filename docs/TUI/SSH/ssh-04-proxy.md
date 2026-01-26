# SSH: Proxy

## 1. What is an SSH Proxy?

An **SSH proxy** allows your local computer to route internet traffic through a remote server via SSH. This can be useful for:

-   Accessing websites blocked in your country.
-   Securing your traffic on public networks.
-   Testing network setups.

There are two main types of SSH proxies:

1.  **SOCKS Proxy (dynamic port forwarding)** – most common, works with browsers or any software that supports SOCKS.
2.  **HTTP/HTTPS Proxy (local forwarding)** – less common, used for specific cases.

We'll focus on the **SOCKS proxy**, as it’s easiest to use for web browsing.

## 2. Prerequisites

-   A **remote SSH server** (with public IP or accessible on your network).
-   SSH client installed on your computer:
    -   macOS / Linux: already available via terminal (`ssh`).
    -   Windows: use [PuTTY](https://www.putty.org/) or `ssh` in PowerShell.
-   Browser that supports SOCKS proxies (Firefox is simplest for testing).

## 3. Creating an SSH SOCKS Proxy

Use the `-D` option in SSH for dynamic port forwarding:

```bash
ssh -D [local_port] [user]@[remote_host]
```

**Example:**

```bash
ssh -D 1080 mql@192.168.1.100
```

-   `-D 1080` → sets up a **SOCKS proxy** on your local machine at port `1080`.
-   `mql` → your SSH username on the remote server.
-   `192.168.1.100` → IP of the SSH server.

Once connected, **all traffic you route through this proxy goes through the remote server**.

## 4. Configuring Your Browser

### **Firefox (easy test)**

1.  Open **Preferences → Network Settings → Settings…**
2.  Select **Manual proxy configuration**.
3.  In **SOCKS Host**, enter:
    -   `Host`: `127.0.0.1`
    -   `Port`: `1080` (or the port you chose)
4.  Choose **SOCKS v5**
5.  Optional: check **Proxy DNS when using SOCKS v5** to avoid DNS leaks.
6.  Save settings.
7.  Browse and verify via [https://whatismyipaddress.com](https://whatismyipaddress.com/) – it should show the remote server's IP.

## 5. Running the Proxy in Background

On Linux/macOS, you can run the SSH proxy without keeping the terminal open:

```bash
ssh -f -N -D 1080 mql@192.168.1.100
```

-   `-f` → run in background.
-   `-N` → don’t execute remote commands.

This keeps the SOCKS proxy active while freeing your terminal.

## 6. Optional: Using Proxy for Command-Line Tools

You can route CLI tools through the proxy with `proxychains` or `curl`:

**Curl example:**

```bash
curl --socks5 127.0.0.1:1080 https://ifconfig.me
```

## 7. Troubleshooting

-   **Cannot connect to SSH:** Check IP, username, firewall.
-   **Browser not showing new IP:** Make sure the browser is configured to use SOCKS v5.
-   **Port in use:** Pick another local port (e.g., 1081, 1085).
-   **SSH disconnects:** Use `ServerAliveInterval` in `~/.ssh/config`:

```text
Host myproxy
  HostName 192.168.1.100
  User mql
  DynamicForward 1080
  ServerAliveInterval 60
```

Then connect via:

```bash
ssh myproxy
```

## ✅ **Summary**

1.  SSH proxy uses **dynamic port forwarding** (`ssh -D`) to route traffic.
2.  Configure your browser or tools to use `127.0.0.1:<port>` as SOCKS5 proxy.
3.  Optional: run SSH in background or configure in `~/.ssh/config`.
4.  Verify your traffic goes through the remote server.