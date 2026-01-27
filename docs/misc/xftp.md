# Xftp

## 1. What is Xftp?

**Xftp** is a **graphical file transfer tool** for Windows used to transfer files between your computer and a **remote Linux/Unix server**.

It mainly uses:

-   **SFTP** (Secure File Transfer Protocol, most common)
-   **FTP / FTPS** (less common, less secure)

Xftp is often used together with **Xshell**:

-   **Xshell** → run commands
-   **Xftp** → upload/download files

------

## 2. Do You Need Xftp?

You need Xftp if:

-   You are using **Windows**
-   You want to **upload or download files** from a Linux server
-   You prefer a **graphical interface** instead of command-line `scp`

Typical use cases:

-   Upload configuration files
-   Download logs
-   Transfer programs, scripts, or documents

------

## 3. Download and Install Xftp

1.  Go to:
    **[https://www.netsarang.com](https://www.netsarang.com/)**
2.  Download **Xftp**
3.  Choose **Free for Home/School**
4.  Install with default options

After installation, open **Xftp**

------

## 4. Understanding the Interface

Xftp uses a **dual-pane layout**:

-   **Left panel** → Your **local computer**
-   **Right panel** → The **remote server**
-   **Top toolbar** → Connect, upload, download, refresh

This design makes file transfer very intuitive.

------

## 5. Your First SFTP Connection (Most Important)

### Step 1: Create a New Session

1.  Click **File → New**
2.  New Session window opens

### Step 2: Basic Settings

Fill in:

-   **Name**:
    Example: `My Linux Server`

-   **Protocol**:
    Select **SFTP**

-   **Host**:
    Server IP or domain
    Example:

    ```
    192.168.1.100
    ```

-   **Port**:

    ```
    22
    ```

Click **OK**

------

### Step 3: Login

1.  Double-click the session
2.  First connection → click **Accept**
3.  Enter:
    -   **Username**
    -   **Password**
4.  Click **OK**

After login:

-   Right panel shows server files
-   Left panel shows your local files

🎉 Connection successful!

------

## 6. Upload and Download Files

### Upload (Local → Server)

1.  Select file(s) in **left panel**
2.  Drag to **right panel**
3.  Release mouse

### Download (Server → Local)

1.  Select file(s) in **right panel**
2.  Drag to **left panel**

You can also:

-   Right-click → Upload / Download

------

## 7. Create, Delete, Rename Files

### On Remote Server

-   **Right-click** in right panel:
    -   New Folder
    -   Rename
    -   Delete
    -   Change permissions

⚠️ Be careful: deleting remote files is permanent.

------

## 8. File Permissions (Important for Linux)

Linux files have permissions like:

```text
-rw-r--r--
```

### Change Permissions in Xftp

1.  Right-click a file → **Properties**
2.  Modify:
    -   Read / Write / Execute
3.  Click **OK**

Example:

-   Make script executable:
    -   Check **Execute** permission

------

## 9. Text File Editing (Simple Way)

Xftp allows basic editing:

1.  Right-click file → **Edit**
2.  File opens in text editor
3.  Save → automatically uploaded to server

Good for:

-   Config files
-   Small scripts

------

## 10. Transfer Speed and Queue

-   Large files go into **transfer queue**
-   You can:
    -   Pause
    -   Resume
    -   Cancel transfers

Very useful for unstable networks.

------

## 11. Using Xshell + Xftp Together (Recommended)

If you have **Xshell installed**:

-   Right-click in Xshell terminal
-   Choose **Open Xftp**

Xftp will:

-   Reuse the same SSH connection
-   Automatically log in

This is the best workflow.

------

## 12. Common Beginner Problems

### ❌ Permission Denied

-   You don’t have write permission
-   Try uploading to your home directory

### ❌ Cannot Connect

-   SSH service not running
-   Wrong port or IP

### ❌ Garbled File Names

-   Encoding issue
-   Set UTF-8 encoding

------

## 13. Xftp vs Other Tools

| Tool      | Platform       | GUI  | Secure |
| --------- | -------------- | ---- | ------ |
| Xftp      | Windows        | Yes  | Yes    |
| FileZilla | Cross-platform | Yes  | Yes    |
| scp       | Command-line   | No   | Yes    |

Xftp is very smooth and integrates well with Xshell.

------

## 14. Best Practices for Beginners

-   Always use **SFTP**, not FTP
-   Avoid editing large config files directly
-   Keep backups before overwriting files
-   Use home directory instead of `/etc` or `/root`

------

## 15. Summary

-   Xftp is a **graphical file transfer tool**
-   Uses **SFTP** over SSH
-   Drag-and-drop makes it beginner-friendly
-   Works best with **Xshell**

