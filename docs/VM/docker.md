# Docker

## 1. What Is Docker?

**Docker** is a tool that lets you package an application **together with everything it needs to run** (code, runtime, libraries, configs) into a single unit called a **container**.

>   👉 *“Works on my machine” problems disappear.*

### Why Docker Exists

Before Docker:

-   Apps depended on OS versions
-   Dependency conflicts were common
-   Deployment was painful

With Docker:

-   Same app runs **anywhere**
-   Fast startup (seconds)
-   Lightweight (uses OS kernel)

## 2. Core Concepts (Very Important)

### 2.1 Image vs Container

| Term          | Meaning                          |
| ------------- | -------------------------------- |
| **Image**     | A *template* (read-only)         |
| **Container** | A *running instance* of an image |

📌 Think of it like:

-   **Image** = Class
-   **Container** = Object

### 2.2 Docker Engine

Docker runs a background service:

-   Builds images
-   Runs containers
-   Manages networks & storage

You interact with it using the `docker` command.

### 2.3 Registry (Docker Hub)

A **registry** stores images.

-   Default registry: **Docker Hub**
-   Similar to GitHub, but for images

Example:

```
nginx
redis
mysql
ubuntu
```

## 3. Installing Docker

### 3.1 macOS / Windows (Recommended)

Install **Docker Desktop**:

-   Includes Docker Engine + CLI + GUI

After installation, verify:

```bash
docker version
docker info
```

### 3.2 Linux (Quick View)

On Linux:

```bash
sudo apt install docker.io
sudo systemctl enable --now docker
```

Run without sudo:

```bash
sudo usermod -aG docker $USER
```

(Log out and back in)

## 4. Your First Docker Command

### 4.1 Hello World

```bash
docker run hello-world
```

What happened?

1.  Docker looked for the image locally
2.  Didn’t find it
3.  Pulled it from Docker Hub
4.  Created and ran a container
5.  Container exited

✔ Docker is working!

------

## 5. Running Real Containers

### 5.1 Run Ubuntu

```bash
docker run -it ubuntu bash
```

-   `-i` → interactive
-   `-t` → terminal
-   `bash` → command inside container

Now you are **inside a Linux container**.

Exit:

```bash
exit
```

------

### 5.2 Run Nginx Web Server

```bash
docker run -d -p 8080:80 nginx
```

Explanation:

-   `-d` → background
-   `-p 8080:80` → host:container port
-   `nginx` → image name

Open browser:

```
http://localhost:8080
```

------

## 6. Managing Containers

### 6.1 List Containers

```bash
docker ps
docker ps -a
```

------

### 6.2 Stop / Start / Remove

```bash
docker stop <container_id>
docker start <container_id>
docker rm <container_id>
```

Remove running container:

```bash
docker rm -f <container_id>
```

------

## 7. Managing Images

### 7.1 List Images

```bash
docker images
```

------

### 7.2 Remove Images

```bash
docker rmi nginx
```

Remove unused images:

```bash
docker image prune
```

------

## 8. Dockerfile (Build Your Own Image)

A **Dockerfile** describes how to build an image.

### 8.1 Simple Example (Python App)

Create `app.py`:

```python
print("Hello from Docker!")
```

Create `Dockerfile`:

```dockerfile
FROM python:3.11-slim
WORKDIR /app
COPY app.py .
CMD ["python", "app.py"]
```

Build image:

```bash
docker build -t my-python-app .
```

Run it:

```bash
docker run my-python-app
```

------

## 9. Volumes (Persistent Data)

Containers are **ephemeral** (data disappears).

### 9.1 Bind Mount

```bash
docker run -v $(pwd):/data ubuntu ls /data
```

-   Host directory ↔ container directory

------

### 9.2 Named Volume

```bash
docker volume create mydata
docker run -v mydata:/data ubuntu
```

------

## 10. Docker Networking (Basic)

### 10.1 Port Mapping

```bash
-p host_port:container_port
```

Example:

```bash
docker run -p 3306:3306 mysql
```

------

### 10.2 Container-to-Container

Docker creates a **bridge network** by default.
Containers can communicate by name.

------

## 11. Docker Compose (Multiple Containers)

Docker Compose manages **multiple containers** as one app.

### 11.1 Example: Web + Redis

```
docker-compose.yml
version: "3"
services:
  web:
    image: nginx
    ports:
      - "8080:80"

  redis:
    image: redis
```

Start:

```bash
docker compose up -d
```

Stop:

```bash
docker compose down
```

------

## 12. Common Beginner Mistakes ⚠️

❌ Treating containers like VMs
✔ Containers are lightweight processes

❌ Storing data inside containers
✔ Use volumes

❌ Running everything as root
✔ Use non-root users when possible

❌ Huge images
✔ Use `alpine` or `slim` images

## 13. When Should You Use Docker?

Use Docker when:

-   You want **reproducible environments**
-   You deploy apps frequently
-   You use microservices
-   You work in teams

Avoid Docker when:

-   You need GUI apps
-   Ultra-low latency kernel tuning is required

## 14. Docker Learning Path (Recommended)

1️⃣ Docker CLI basics

2️⃣ Dockerfile best practices

3️⃣ Volumes & networking

4️⃣ Docker Compose

5️⃣ Image optimization

6️⃣ Security (rootless, scanning)

7️⃣ Kubernetes (next step 🚀)

## 15. Summary (One Paragraph)

Docker lets you package applications and dependencies into containers that run consistently across environments. Images define how containers are built, containers run processes, volumes store data, and Docker Compose orchestrates multiple services. Once you understand these concepts, Docker becomes an essential productivity tool.