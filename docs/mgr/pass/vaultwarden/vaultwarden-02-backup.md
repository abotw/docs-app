---
title: "Vaultwarden: Backup"
icon: simple/vaultwarden
status: done
---

## 0. Why Vaultwarden Backups Matter (Reality Check)

Vaultwarden stores **everything that matters** in just a few places:

-   Your **encrypted vault data**
-   **User accounts & orgs**
-   **Attachments**
-   **Keys & settings**

If you lose these and **don’t have a backup**, recovery is **impossible** — encryption means no second chances.

>   Rule #1: *Vaultwarden backups are more important than server backups.*

## 1. What Exactly Needs to Be Backed Up

### Core components (must-have)

| Component                | Why it matters                     |
| ------------------------ | ---------------------------------- |
| `db.sqlite3`             | Contains all vault metadata        |
| `attachments/`           | File uploads (secure notes, files) |
| `rsa_key.*`              | Server-side encryption keys        |
| `config.json` / env vars | Required for restore consistency   |

### Typical Docker layout

```text
/vaultwarden/
├── db.sqlite3
├── attachments/
├── rsa_key.pem
├── rsa_key.pub.pem
├── config.json
```

⚠️ **If you lose `rsa_key.pem`, all data is permanently unreadable.**

## 2. Backup Strategies (Choose One or Combine)

### Strategy A — Cold File Backup (Most Common)

-   Stop container
-   Copy files
-   Restart container

**Pros:** safest

**Cons:** brief downtime

### Strategy B — Hot Backup (No Downtime)

-   Copy files while running
-   SQLite-safe if done correctly

**Pros:** no service interruption

**Cons:** must be careful

### Strategy C — Logical Export (User-level)

-   Bitwarden clients export vaults

**Pros:** portable

**Cons:** *not* a server backup

>   Best practice: **A + B + periodic user exports**

## 3. Proper Hot Backup (SQLite-Safe)

### Step 1: Ensure WAL mode (recommended)

Vaultwarden uses SQLite WAL by default. Confirm:

```bash
sqlite3 db.sqlite3 "PRAGMA journal_mode;"
```

Expected:

```
wal
```

### Step 2: Snapshot required files

```bash
tar -czf vaultwarden-backup-$(date +%F).tar.gz \
  db.sqlite3 \
  db.sqlite3-wal \
  db.sqlite3-shm \
  attachments/ \
  rsa_key.pem \
  rsa_key.pub.pem
```

✔ This produces a **consistent backup**.

## 4. Cold Backup (Safest Method)

```bash
docker stop vaultwarden

tar -czf vaultwarden-backup-$(date +%F).tar.gz \
  /path/to/vaultwarden/

docker start vaultwarden
```

Downtime: usually **< 5 seconds**

## 5. Docker Compose Users (Recommended Setup)

### Example volume mapping

```yaml
volumes:
  - ./vw-data:/data
```

Backup command:

```bash
tar -czf vw-backup-$(date +%F).tar.gz vw-data/
```

💡 Tip: keep backups **outside** Docker volumes.

## 6. Automating Backups (cron + script)

### Backup script

```bash
#!/bin/bash
BACKUP_DIR="/backups/vaultwarden"
DATA_DIR="/vaultwarden"
DATE=$(date +%F)

mkdir -p "$BACKUP_DIR"

tar -czf "$BACKUP_DIR/vw-$DATE.tar.gz" \
  "$DATA_DIR/db.sqlite3" \
  "$DATA_DIR/db.sqlite3-wal" \
  "$DATA_DIR/attachments" \
  "$DATA_DIR/rsa_key.pem" \
  "$DATA_DIR/rsa_key.pub.pem"
```

### Cron (daily at 3 AM)

```bash
0 3 * * * /usr/local/bin/vw-backup.sh
```

## 7. Encryption & Off-Site Storage (Highly Recommended)

### Encrypt backup (GPG)

```bash
gpg -c vw-2026-02-05.tar.gz
```

### Off-site ideas

-   NAS snapshot
-   rsync to another server
-   rclone → Google Drive / S3 / OneDrive
-   Immutable storage (best)

>   **2-1-1 rule**
>
>   2 copies, 1 off-site, 1 encrypted

## 8. Restore Test (Don’t Skip This)

### Restore procedure

```bash
docker stop vaultwarden
rm -rf /vaultwarden/*
tar -xzf vw-backup-YYYY-MM-DD.tar.gz -C /vaultwarden
docker start vaultwarden
```

### Verification checklist

-   Web UI loads
-   Can log in
-   Attachments open
-   Organizations intact

🚨 If you’ve **never tested restore**, your backup is *theoretical*.

## 9. Disaster Scenarios & What Saves You

| Scenario              | Required backup        |
| --------------------- | ---------------------- |
| Server disk failure   | Full directory backup  |
| Accidental delete     | Recent snapshot        |
| Ransomware            | Offline copy           |
| Corrupted DB          | Multiple dated backups |
| Forgot admin password | Restore DB             |

## 10. What NOT to Rely On

❌ Bitwarden client export only

❌ VM snapshot without file awareness

❌ Cloud provider backup alone

❌ Single copy on same disk

## 11. Advanced Tips (Power Users)

-   Enable **filesystem snapshots** (ZFS/Btrfs)
-   Use **read-only backup user**
-   Rotate backups (e.g. keep 30 days)
-   Monitor backup success (email/Telegram)
-   Version-lock Vaultwarden during restore

## 12. Minimal Checklist (Print This)

-    `db.sqlite3` backed up
-    `attachments/` backed up
-    `rsa_key.pem` backed up
-    Off-site copy exists
-    Restore tested

