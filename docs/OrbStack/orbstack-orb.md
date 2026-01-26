# OrbStack: orb

**Goal:** Learn how to use the `orb` command to manage OrbStack, Linux machines, and Docker containers on macOS.

## 1. Introduction

OrbStack is a lightweight, fast alternative to Docker Desktop for macOS. Its CLI, **`orb`**, allows you to:

-   Start and stop OrbStack
-   Create and manage Linux machines
-   Run commands in VMs
-   Transfer files between macOS and VMs
-   Automate workflows without using the GUI

Think of `orb` as your **terminal control center** for OrbStack.

------

## **2. Installation**

If you haven’t installed OrbStack yet:

```bash
brew install orbstack
```

This installs both OrbStack and the `orb` CLI. After installation, `orb` will be ready to use.

------

## **3. Starting and Stopping OrbStack**

### Start OrbStack

```bash
orb
```

or

```bash
orb start
```

-   Starts the OrbStack background service.
-   Makes Linux machines and Docker ready to use.

### Stop OrbStack

```bash
orb stop
```

-   Stops the OrbStack service.

## 4. Managing Linux Machines

OrbStack lets you create lightweight Linux virtual machines (VMs).

### Create a Linux machine

```bash
orb create/add/new ubuntu my-machine
```

-   Creates a VM named `my-machine` with an Ubuntu image.

```
orb new -a amd64 ubuntu:22.04 ubuntu-vm
```

### List all machines

```bash
orb list
```

-   Shows all created machines and their status (running or stopped).

## 5. Accessing Machines and Running Commands

### Open a shell in a machine

```bash
orb -m my-machine
```

-   `-m` - machine
-   Opens a terminal inside `my-machine`.

Specify a user:

```bash
orb -m my-machine -u username
```

### Run a single command

```bash
orb uname -a
```

-   Runs `uname -a` in the default machine.

For a specific machine:

```bash
orb -m my-machine uname -a
```

------

## **6. File Transfers Between macOS and Linux Machines**

### Push a file from macOS to a VM

```bash
orb push ~/project/file.txt /home/user/
```

### Pull a file from VM to macOS

```bash
orb pull /home/user/log.txt ~/
```

This is useful to sync project files without SSH or shared folders.

## 7. Other Useful Commands

| Command              | Description                       |
| -------------------- | --------------------------------- |
| `orb version`        | Show OrbStack version             |
| `orb config`         | Modify OrbStack settings          |
| `orb restart docker` | Restart only the Docker engine    |
| `orb help`           | Display help and list commands    |
| `orb completion`     | Generate shell completion scripts |

---

| Command       | Description |
| ------------- | ----------- |
| `orb delete`  |             |
| `exit`        |             |
| `orb default` |             |

## 8. Beginner Tips

1.  **Docker Compatibility:** OrbStack works with Docker CLI, so you can use familiar `docker` commands.
2.  **Automation:** All `orb` commands can be used in scripts or CI workflows without opening the GUI.
3.  **Help:** Use `orb help` anytime to see available commands:

```bash
orb help
```

## 9. Summary

With the `orb` CLI, you can:

-   Start/stop OrbStack
-   Create, list, start, and stop Linux machines
-   Run commands inside VMs
-   Transfer files between host and guest
-   Automate your workflow efficiently

`orb` empowers developers to manage their OrbStack environment fully from the terminal.

