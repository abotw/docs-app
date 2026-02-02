---
title: Docker
icon: simple/docker
status: done
---

## 1. What problem does Docker solve?

Imagine this situation:

-   You write a program on your laptop ✅
-   You send it to a friend → ❌ “It doesn’t run”
-   You deploy it on a server → ❌ “Different OS, different versions”

Why?

Because software depends on:

-   OS
-   Libraries
-   Runtime (Python, Node, Java…)
-   Environment variables

👉 **Docker solves this by packaging everything together.**

>   **Docker = “It runs the same everywhere.”**

## 2. Docker in one sentence

>   **Docker is a tool that packages an application and its environment into a container so it can run anywhere.**

Key word: **container**

## 3. Container vs Virtual Machine (very important)

### Traditional Virtual Machine (VM)

-   Runs a **full OS**
-   Heavy
-   Slow to start
-   High resource usage

### Docker Container

-   Shares the **host OS kernel**
-   Lightweight
-   Starts in seconds (or milliseconds)
-   Uses much less memory

### Simple analogy

-   **VM** = renting a whole house 🏠
-   **Container** = renting a furnished room 🛏️

## 4. Core Docker concepts (must know)

### 1️⃣ Image

-   A **template**
-   Read-only
-   Describes *how* to build the environment

Example:

```text
ubuntu:22.04
nginx:latest
python:3.12
```

👉 Think of an image as a **blueprint**.

### 2️⃣ Container

-   A **running instance** of an image
-   Can start, stop, delete

👉 Image = class

👉 Container = object

### 3️⃣ Dockerfile

-   A **recipe** to build your own image
-   Text file

Example:

```dockerfile
FROM python:3.12
COPY app.py /app.py
CMD ["python", "/app.py"]
```

### 4️⃣ Docker Hub

-   Online **image store**
-   Like GitHub, but for Docker images

Example:

```bash
docker pull nginx
```

## 5. Install Docker (quick overview)

### macOS / Windows

-   Install **Docker Desktop**
-   Includes:
    -   Docker Engine
    -   Docker CLI
    -   Docker Compose

### Linux

```bash
sudo apt install docker.io
```

Check:

```bash
docker --version
```

## 6. Your first Docker command

### Run a container

```bash
docker run hello-world
```

What happens:

1.  Docker checks if image exists locally
2.  If not → pulls from Docker Hub
3.  Creates a container
4.  Runs it
5.  Exits

🎉 Congratulations, Docker is working.

## 7. Running a real service (Nginx example)

```bash
docker run -d -p 8080:80 nginx
```

Explain it **word by word**:

-   `docker run` → create + start container
-   `-d` → detached (run in background)
-   `-p 8080:80` → map ports
    -   host 8080 → container 80
-   `nginx` → image name

Visit:

```
http://localhost:8080
```

## 8. Common daily Docker commands

### List containers

```bash
docker ps
docker ps -a
```

### Stop container

```bash
docker stop <container_id>
```

### Remove container

```bash
docker rm <container_id>
```

### List images

```bash
docker images
```

### Remove image

```bash
docker rmi <image_id>
```

## 9. Volumes (data persistence)

Problem:

-   Container deleted → data gone ❌

Solution:

-   **Volumes**

Example:

```bash
docker run -v ./data:/data busybox
```

Meaning:

-   `./data` (host)
-   `/data` (container)

👉 Data survives container deletion.

## 10. Docker Compose (multiple containers)

When you have:

-   App
-   Database
-   Cache

You don’t want 10 long `docker run` commands.

### docker-compose.yml example

```yaml
services:
  web:
    image: nginx
    ports:
      - "8080:80"
```

Run:

```bash
docker compose up -d
```

Stop:

```bash
docker compose down
```

👉 **One file to manage everything.**

## 11. When should you use Docker?

✅ Use Docker when:

-   You want consistent environments
-   You deploy services
-   You use microservices
-   You hate “works on my machine”

❌ Don’t need Docker when:

-   Very simple scripts
-   Learning programming basics

## 12. Mental model

>   **Docker is not magic.**
>
>   It’s just:
>
>   -   Image → blueprint
>   -   Container → running process
>   -   Volume → data
>   -   Network → communication

Once you get this, Docker stops being scary.

## 13. What to learn next (recommended path)

1.  Docker CLI basics ✅
2.  Dockerfile
3.  Volumes & networks
4.  Docker Compose
5.  Security & best practices



