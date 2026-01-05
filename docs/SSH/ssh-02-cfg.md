# SSH-02: Config

## 1. What is SSH?

SSH (**Secure Shell**) is a protocol to securely connect to another computer over a network. It’s commonly used to:

-   Log in to remote servers.
-   Transfer files securely (with `scp` or `sftp`).
-   Forward ports or run remote commands.

------

## **2. Basic SSH Usage**

The simplest SSH command:

```bash
ssh username@hostname
```

Example:

```bash
ssh alice@192.168.1.100
```

-   `alice` → username on the remote machine
-   `192.168.1.100` → IP or hostname of the remote machine

If it’s your first time connecting, SSH will ask to trust the host’s fingerprint:

```
The authenticity of host '192.168.1.100 (192.168.1.100)' can't be established.
ECDSA key fingerprint is SHA256:...
Are you sure you want to continue connecting (yes/no)?
```

Type `yes` to continue.

------

## **3. Using SSH Keys (Passwordless Login)**

SSH keys allow passwordless login and are more secure.

### Step 1: Generate a key pair

```bash
ssh-keygen -t ed25519 -C "your_email@example.com"
```

-   Press **Enter** to accept default file location (`~/.ssh/id_ed25519`)
-   Optionally set a passphrase for extra security

### Step 2: Copy the public key to the remote host

```bash
ssh-copy-id username@hostname
```

Or manually:

```bash
cat ~/.ssh/id_ed25519.pub | ssh username@hostname "mkdir -p ~/.ssh && cat >> ~/.ssh/authorized_keys"
```

Now you can login without a password:

```bash
ssh username@hostname
```

------

## **4. Introduction to `~/.ssh/config`**

The **SSH config file** allows you to define shortcuts and custom settings for different hosts.

Open or create the file:

```bash
nano ~/.ssh/config
```

Each entry has this format:

```text
Host shortname
    HostName remote.server.com
    User username
    Port 22
    IdentityFile ~/.ssh/id_ed25519
```

-   `Host` → alias for your server (you’ll use `ssh shortname`)
-   `HostName` → actual hostname or IP
-   `User` → username on the remote host
-   `Port` → SSH port (default 22)
-   `IdentityFile` → path to your private key (if not default)

### Example:

```text
Host work
    HostName 192.168.1.100
    User alice
    IdentityFile ~/.ssh/id_ed25519

Host personal
    HostName myserver.example.com
    User bob
    Port 2222
    IdentityFile ~/.ssh/id_rsa
```

Now you can simply do:

```bash
ssh work
ssh personal
```

No need to type username, port, or path to key each time.

------

## **5. Useful SSH Config Options**

| Option                     | Description                                                  |
| -------------------------- | ------------------------------------------------------------ |
| `ForwardAgent yes`         | Forward your SSH agent (useful if connecting from remote to another server) |
| `Compression yes`          | Enable compression for slower connections                    |
| `ServerAliveInterval 60`   | Send keep-alive packets every 60 seconds to prevent timeout  |
| `ProxyJump user@jump.host` | Connect via a jump/bastion host                              |

Example with a jump host:

```text
Host internal-server
    HostName 10.0.0.50
    User alice
    ProxyJump jumpuser@jump.host.com
```

Then:

```bash
ssh internal-server
```

------

## **6. Testing Your SSH Config**

Check which settings are applied:

```bash
ssh -v work
```

`-v` shows debug information and which key is being used.

------

## **7. Tips for Beginners**

1.  **Permissions matter**:

    ```bash
    chmod 700 ~/.ssh
    chmod 600 ~/.ssh/id_ed25519
    chmod 644 ~/.ssh/id_ed25519.pub
    ```

2.  **Always use `~/.ssh/config` for multiple hosts** to save typing.

3.  **Keep private keys safe**; never share them.

4.  **Use different keys for different services** (e.g., GitHub vs. servers).

