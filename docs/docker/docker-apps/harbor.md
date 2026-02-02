---
title: Harbor
author: gpt
status: done
---

## 1. What Is Harbor?

**Harbor** is an **open-source, enterprise-grade container registry** used to store, manage, and serve container images (Docker/OCI) and Helm charts. It is built on top of the standard Docker Registry but adds a lot of enterprise features you won’t find in the vanilla registry. ([OneDPM](https://onedpm.github.io/rancher-handbook/registry/harbor-introduction.html?utm_source=chatgpt.com))

### 🔑 Key Points

-   Harbor stores **container images** and **OCI artifacts** (like Helm charts). ([瑞恩笔记](https://www.rzzz.net/cicd/harbor/harbor.html?utm_source=chatgpt.com))
-   It provides a **Web UI**, **access control & RBAC**, **audit logs**, **vulnerability scanning**, and **replication** between registries. ([OneDPM](https://onedpm.github.io/rancher-handbook/registry/harbor-introduction.html?utm_source=chatgpt.com))
-   It’s widely used in **DevOps/CICD** pipelines in enterprises and internal infrastructure. ([瑞恩笔记](https://www.rzzz.net/cicd/harbor/harbor.html?utm_source=chatgpt.com))

## 2. Why Use Harbor?

Compared with a simple Docker Registry:

✅ **Web UI** to browse images

✅ **Role-Based Access Control (RBAC)**

✅ **LDAP/AD integration**

✅ **Vulnerability scanning** (e.g., Trivy)

✅ **Mirroring/replication** between multiple Harbor instances

✅ **Project-level isolation**

✅ **Helm chart repository support** ([瑞恩笔记](https://www.rzzz.net/cicd/harbor/harbor.html?utm_source=chatgpt.com))

These features make Harbor suitable for teams and enterprises that need secure and manageable image storage. ([OneDPM](https://onedpm.github.io/rancher-handbook/registry/harbor-introduction.html?utm_source=chatgpt.com))

## 3. Prerequisites

Before installing Harbor, make sure you have:

🔹 A VM/server with **Linux** (e.g., Ubuntu/CentOS)

🔹 **Docker** installed (Docker 20.10+ recommended)

🔹 **docker-compose** installed

🔹 **40 GB+ disk space** (more if you store lots of images) ([王楚江](https://wangchujiang.com/docker-tutorial/harbor.html?utm_source=chatgpt.com))

## 4. Installing Harbor (Quick Guide)

Harbor provides **installers** that automate deployment using Docker and docker-compose. Official docs cover a full install process. ([Harbor](https://goharbor.io/docs/2.1.0/install-config/?utm_source=chatgpt.com))

### 1) Download the Harbor Installer

Go to the **Harbor releases** page on GitHub and fetch the latest version:

```bash
wget https://github.com/goharbor/harbor/releases/download/<version>/harbor-online-installer-<version>.tgz
tar -zxvf harbor-online-installer-<version>.tgz
cd harbor
```

### 2) Configure Harbor

Copy the sample config file:

```bash
cp harbor.yml.tmpl harbor.yml
```

Then edit **harbor.yml**:

-   Set your server’s hostname or IP under `hostname:`
-   Optionally set **HTTPS certificates** if you want secure access
-   Define the **admin password** ([腾讯云](https://cloud.tencent.com/developer/article/1835882?utm_source=chatgpt.com))

### 3) Run the Installer

Once configured:

```bash
sudo ./install.sh
```

This generates docker-compose files and starts all Harbor microservices automatically. ([腾讯云](https://cloud.tencent.com/developer/article/1835882?utm_source=chatgpt.com))

## 5. Logging Into Harbor

After installation completes:

1.  Open a browser to `http://<your-host>:<port>`
2.  Login with default credentials:
    -   **Username**: `admin`
    -   **Password**: what you set in `harbor.yml` ([腾讯云](https://cloud.tencent.com/developer/article/1835882?utm_source=chatgpt.com))

## 6. Pushing and Pulling Images

Once Harbor is up, you can push and pull container images just like any other registry.

### Example (replace with your host/project):

```bash
docker login <your-harbor-host>
docker pull nginx:latest
docker tag nginx:latest <your-harbor-host>/library/nginx:latest
docker push <your-harbor-host>/library/nginx:latest
```

If you’re using **HTTP** instead of HTTPS, you may need to mark the registry as insecure in your Docker daemon config (`insecure-registries`). ([王楚江](https://wangchujiang.com/docker-tutorial/harbor.html?utm_source=chatgpt.com))

## 7. Useful Harbor Features

### 🗂 Projects & Repositories

Harbor groups images into **projects**. Each project can be **public** or **private** and has fine-grained access control. ([瑞恩笔记](https://www.rzzz.net/cicd/harbor/harbor.html?utm_source=chatgpt.com))

### 🔍 Vulnerability Scanning

Harbor integrates scanners (Trivy, Clair) that analyze images for CVEs and report findings directly in the UI. ([瑞恩笔记](https://www.rzzz.net/cicd/harbor/harbor.html?utm_source=chatgpt.com))

------

### 🔁 Replication

Harbor can **replicate images across multiple Harbor instances** (useful for multi-region/high-availability setups). ([瑞恩笔记](https://www.rzzz.net/cicd/harbor/harbor.html?utm_source=chatgpt.com))

## 8. Tips for Beginners

✅ Use **HTTPS** in production (prevents insecure registry issues). ([Harbor](https://goharbor.io/docs/2.1.0/install-config/?utm_source=chatgpt.com))

✅ Back up Harbor’s **PostgreSQL database** and **image storage** regularly.

✅ Explore Harbor’s **Web UI first** — it’s a great way to understand projects and images visually.

✅ Integrate Harbor with your **CI/CD pipelines** (GitLab, GitHub Actions, etc.) for automated pushing.

## 9. Where to Learn More

✔ Official docs (install, admin, API, replication): https://goharbor.io/docs/ ([Harbor](https://goharbor.io/docs/2.0.0/?utm_source=chatgpt.com))

✔ GitHub repo with installers and examples: https://github.com/goharbor/harbors