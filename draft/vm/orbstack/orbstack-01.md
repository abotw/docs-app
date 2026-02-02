---
title: OrbStack
status: done
---

## 1. What is OrbStack?

OrbStack is a **lightweight container and virtual machine manager for macOS**, designed to make running Docker containers and Linux virtual machines simple and fast. Think of it as a combination of:

-   **Docker Desktop**, for containers.
-   **Lightweight VMs**, for running full Linux environments.
-   **Mac-native integration**, so it’s optimized for Apple Silicon (M1/M2/M4) Macs.

**Key features:**

-   Runs Linux containers and VMs on macOS without heavy overhead.
-   Supports **Docker CLI**, **docker-compose**, and **kubectl**.
-   Provides a simple GUI and fast networking.
-   Uses macOS virtualization frameworks for better performance.

## 2. Installing OrbStack

1.  Go to the official website: [https://orbstack.dev](https://orbstack.dev/)
2.  Download the latest macOS version (supports Apple Silicon and Intel Macs).
3.  Open the `.dmg` file and drag **OrbStack.app** to your Applications folder.
4.  Launch **OrbStack**.
    You might need to approve kernel extensions or allow network permissions on macOS for proper virtualization.

**Tip:** OrbStack installation is much lighter than Docker Desktop—no extra background daemons or heavy system services.

## 3. OrbStack GUI Overview

When you open OrbStack, you’ll see:

-   **Containers tab**: Lists all running containers (Docker-compatible).
-   **Images tab**: Shows all Docker images you have downloaded.
-   **VMs tab**: Lets you run full Linux VMs.
-   **Settings tab**: Configure resources like CPU, RAM, disk, and network.

## 4. Using OrbStack with Docker

OrbStack supports **Docker commands** natively. Here’s how to get started:

1.  Open **Terminal**.
2.  Check OrbStack Docker support:

```bash
docker version
```

You should see client and server versions.

3.   Pull a Docker image:

```bash
docker pull hello-world
```

4.   Run a container:

```bash
docker run hello-world
```

This verifies your Docker environment works.

**Tip:** You can also use `docker-compose` and other Docker CLI commands as usual.

## 5. Running a Linux VM in OrbStack

OrbStack can run full Linux virtual machines:

1.  Go to the **VMs tab**.
2.  Click **+ New VM**.
3.  Choose a Linux distribution (e.g., Ubuntu 22.04) or import your own ISO.
4.  Allocate **CPU, memory, and storage**.
5.  Click **Start**.

Once running, you can connect via **SSH** or the built-in console in OrbStack.

## 6. Networking and File Sharing

OrbStack integrates with macOS networking:

-   **Containers** share the host network by default.
-   **VMs** can use NAT or bridged networking.
-   File sharing allows you to mount macOS folders inside containers or VMs:

```bash
# Example: Docker volume
docker run -v ~/Projects:/app ubuntu ls /app
```

## 7. Tips for Beginners

-   **Lightweight**: OrbStack is faster and uses less memory than Docker Desktop.
-   **Apple Silicon optimized**: Works natively on M1/M2/M4.
-   **Compatibility**: Most Docker images run without modification.
-   **Quick restart**: Containers and VMs start almost instantly.
-   **Check logs**: Use the OrbStack GUI to view logs of containers or VMs if something fails.

## 8. Example Workflow

Here’s a beginner-friendly example:

```bash
# 1. Pull Ubuntu image
docker pull ubuntu:22.04

# 2. Start a container interactively
docker run -it ubuntu:22.04 /bin/bash

# 3. Update packages inside container
apt update && apt upgrade -y

# 4. Exit the container
exit
```

You’ve now successfully run a Linux environment inside OrbStack!

## 9. Conclusion

OrbStack is a **fast, lightweight, and macOS-friendly solution** for running Docker containers and Linux VMs. Beginners can start with containers, then move to full VMs as needed. Its simplicity and speed make it ideal for Apple Silicon Macs.