# Xshell

## 1. What is Xshell?

**Xshell** is a **terminal emulator** for Windows that allows you to connect to **remote Linux/Unix servers** securely.

With Xshell, you can:

-   Connect to servers using **SSH** (most common)
-   Manage multiple remote sessions in one window
-   Use tabs, copy/paste easily
-   Save connection profiles for later use

It is widely used by:

-   Linux beginners
-   System administrators
-   Network engineers
-   Students learning servers and networking

------

## 2. Do You Need Xshell?

You typically use Xshell if:

-   You are on **Windows**
-   You need to connect to a **Linux server**, **VPS**, or **Raspberry Pi**
-   You don’t want to use Windows CMD or PowerShell

If you are on **macOS or Linux**, you usually don’t need Xshell (Terminal is enough).

------

## 3. Download and Install Xshell

1.  Go to the official site:
    **[https://www.netsarang.com](https://www.netsarang.com/)**
2.  Download **Xshell**
3.  Choose **Free for Home/School** (free version)
4.  Install using default options

After installation, open **Xshell**

------

## 4. Understanding the Interface

When you open Xshell, you will see:

-   **Menu bar** (top)
-   **Toolbar** (quick buttons)
-   **Session Manager** (left side, for saved connections)
-   **Terminal area** (main window)

You mainly work in the **terminal area**.

------

## 5. Your First SSH Connection (Most Important Part)

### Step 1: Create a New Session

1.  Click **File → New**
2.  A “New Session” window appears

### Step 2: Fill Basic Information

-   **Name**:
    Example: `My Linux Server`

-   **Protocol**:
    Select **SSH**

-   **Host**:
    Server IP address or domain
    Example:

    ```
    192.168.1.100
    ```

-   **Port Number**:

    ```
    22
    ```

Click **OK**

------

### Step 3: Login

1.  Double-click the session you just created
2.  First time connection → click **Accept** (host key)
3.  Enter:
    -   **Username** (e.g. `root`, `ubuntu`, `pi`)
    -   **Password**
4.  Press **Enter**

If successful, you will see something like:

```text
user@server:~$
```

🎉 You are now connected!

------

## 6. Basic Terminal Usage

Once connected, you type **Linux commands**.

### Common Commands

```bash
ls        # list files
pwd       # show current directory
cd        # change directory
whoami   # show current user
uname -a # show system info
```

Example:

```bash
ls
cd /home
pwd
```

------

## 7. Copy and Paste (Very Important)

-   **Copy**:
    Select text with mouse → automatically copied
-   **Paste**:
    Right-click OR press `Shift + Insert`

⚠️ **Ctrl + V does NOT work** by default in terminals.

------

## 8. Using Tabs (Multiple Servers)

-   Each connection opens in a **tab**
-   You can:
    -   Open multiple servers at once
    -   Switch tabs easily
    -   Right-click tab to rename or close

This is very useful for managing many machines.

------

## 9. Save Username and Authentication (Optional)

To avoid typing username every time:

1.  Right-click your session → **Properties**
2.  Go to **User Authentication**
3.  Enter:
    -   Username
    -   Password (optional)
4.  Click **OK**

⚠️ Saving passwords is convenient but less secure.

------

## 10. Using SSH Key Authentication (Optional, Advanced)

Instead of passwords, Xshell supports **SSH keys**.

Typical flow:

1.  Generate SSH key (on Linux or Xshell)
2.  Upload public key to server
3.  Configure Xshell to use private key

This is:

-   More secure
-   Recommended for servers

(You can learn this later; not required for beginners.)

------

## 11. Useful Settings for Beginners

### Font and Font Size

-   **Tools → Options → Appearance**
-   Choose a readable font (e.g. Consolas)
-   Increase font size for comfort

### Encoding Issues (Chinese / UTF-8)

-   **Properties → Terminal → Encoding**
-   Set to **UTF-8**

------

## 12. Common Beginner Problems

### ❌ Connection Timeout

-   Server IP wrong
-   Network unreachable
-   SSH service not running

### ❌ Permission Denied

-   Wrong username/password
-   SSH login disabled for root

### ❌ Black Screen After Login

-   Shell not configured
-   Server issue (rare)

------

## 13. Xshell vs Other Tools

| Tool             | Platform    | Beginner Friendly |
| ---------------- | ----------- | ----------------- |
| Xshell           | Windows     | ⭐⭐⭐⭐              |
| PuTTY            | Windows     | ⭐⭐⭐               |
| Windows Terminal | Windows     | ⭐⭐⭐               |
| Terminal         | macOS/Linux | ⭐⭐⭐⭐              |

Xshell is more powerful and user-friendly than PuTTY.

------

## 14. When You Should Learn More

After you are comfortable, learn:

-   SSH keys
-   SCP / SFTP file transfer
-   tmux / screen
-   Bash basics

------

## 15. Summary

-   Xshell is a **Windows SSH client**
-   It lets you **control Linux servers remotely**
-   Beginners mainly need:
    -   Host
    -   Username
    -   Password
-   Tabs, copy/paste, and saved sessions make it powerful
