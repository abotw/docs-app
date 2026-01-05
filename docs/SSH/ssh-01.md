# SSH-01: Intro

## 1. **What is SSH?**

SSH (Secure Shell) is a network protocol that allows you to securely connect to a remote computer over an unsecured network. It encrypts data, protecting passwords and commands from eavesdropping.

**Key uses of SSH:**

-   Remote command-line access
-   Secure file transfer
-   Port forwarding / tunneling
-   Managing servers remotely

------

## 2. **How SSH Works**

1.  **Client-Server Model**: Your computer is the SSH client; the remote machine is the SSH server.
2.  **Authentication**:
    -   **Password-based**: Enter username and password.
    -   **Key-based**: Use a public/private key pair for passwordless login.
3.  **Encryption**: All data between client and server is encrypted.

------

## 3. **Installing SSH**

### **Linux / macOS**

Open terminal and run:

```bash
# SSH client is usually pre-installed
ssh -V
```

If not installed:

```bash
# Ubuntu/Debian
sudo apt install openssh-client

# CentOS/RHEL
sudo yum install openssh-clients
```

### **Windows**

-   **Windows 10+**: SSH client is built-in (`ssh` in PowerShell)
-   **Alternative GUI clients**: [PuTTY](https://www.putty.org/), [MobaXterm](https://mobaxterm.mobatek.net/)

### **SSH Server**

On the machine you want to connect to:

```bash
# Ubuntu/Debian
sudo apt install openssh-server
sudo systemctl enable ssh
sudo systemctl start ssh

# Check status
sudo systemctl status ssh
```

------

## 4. **Basic SSH Commands**

### **Connect to a remote server**

```bash
ssh username@remote_ip
```

Example:

```bash
ssh matt@192.168.1.100
```

-   Prompts for password (unless using key-based authentication)
-   After login, you get a remote shell.

------

### **Specify a custom port**

SSH usually uses port 22. If the server uses a different port:

```bash
ssh -p 2222 username@remote_ip
```

------

### **Run a command without login**

```bash
ssh username@remote_ip "ls -l /home/matt"
```

-   Executes the command remotely and prints output locally.

------

### **Copy files using SCP (Secure Copy)**

```bash
# Copy local file to remote server
scp localfile.txt username@remote_ip:/remote/path/

# Copy remote file to local
scp username@remote_ip:/remote/path/remotefile.txt ./localpath/
```

------

### **Use SSH Key Authentication (Passwordless Login)**

1.  **Generate a key pair on your client**

```bash
ssh-keygen -t ed25519 -C "your_email@example.com"
# Or RSA if ed25519 not supported
ssh-keygen -t rsa -b 4096 -C "your_email@example.com"
```

1.  **Copy public key to remote server**

```bash
ssh-copy-id username@remote_ip
```

-   Or manually append `~/.ssh/id_ed25519.pub` to `~/.ssh/authorized_keys` on the server.

1.  **Login without password**

```bash
ssh username@remote_ip
```

------

### **SSH Config File for Convenience**

Edit `~/.ssh/config`:

```text
Host myserver
    HostName 192.168.1.100
    User matt
    Port 2222
    IdentityFile ~/.ssh/id_ed25519
```

Then connect with:

```bash
ssh myserver
```

------

## 5. **Advanced SSH Usage**

### **Port Forwarding / Tunneling**

-   **Local port forwarding**:

```bash
ssh -L 8080:localhost:80 username@remote_ip
```

Access `http://localhost:8080` on your computer to reach remote server's port 80.

-   **Remote port forwarding**:

```bash
ssh -R 9090:localhost:3000 username@remote_ip
```

Makes your local service accessible via remote port 9090.

------

### **SSH Multiplexing (Reuse Connections)**

Add to `~/.ssh/config`:

```text
Host myserver
    HostName 192.168.1.100
    User matt
    ControlMaster auto
    ControlPath ~/.ssh/cm_socket/%r@%h:%p
    ControlPersist 10m
```

-   Speeds up repeated SSH connections.

------

## 6. **Tips for Beginners**

1.  Always prefer **key-based authentication** over passwords.
2.  Avoid root login directly; use a normal user and `sudo`.
3.  Use SSH config to save typing and manage multiple servers.
4.  Remember to secure your private key (`chmod 600 ~/.ssh/id_ed25519`).

------

## 7. **Common Problems**

-   **Connection refused** → Check SSH service on the server.
-   **Permission denied** → Check username, password, or key permissions.
-   **Timeout** → Check firewall or network issues.

------

SSH is a fundamental tool for developers, sysadmins, and anyone managing remote servers. Mastering it will make remote operations secure, efficient, and flexible.