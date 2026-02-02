# GitHub SSH

## 1. Why use SSH with GitHub?

When you work with GitHub, your computer needs to **authenticate** (prove who you are).

### Two common methods

| Method  | Problem                                              |
| ------- | ---------------------------------------------------- |
| HTTPS   | Requires typing username/token repeatedly            |
| **SSH** | Login once, then push/pull without typing password ✅ |

👉 **SSH is safer, faster, and more convenient** for daily development.

## 2. What is SSH (in simple terms)?

**SSH = Secure Shell**

Think of it as:

>   A **secure key-based identity card** between your computer and GitHub

-   You keep a **private key** (secret)
-   GitHub stores a **public key** (safe to share)
-   If they match → access granted

🔐 No passwords sent over the internet.

## 3. Check if you already have an SSH key

Open your terminal:

```bash
ls ~/.ssh
```

If you see files like:

```text
id_ed25519
id_ed25519.pub
```

You already have a key → skip to **Step 6**.

If the folder doesn’t exist or is empty → continue.

------

## 4. Generate a new SSH key (recommended)

### 4.1 Run this command

```bash
ssh-keygen -t ed25519 -C "your_email@example.com"
```

Example:

```bash
ssh-keygen -t ed25519 -C "matt@example.com"
```

### 4.2 Answer the prompts

```
Enter file in which to save the key:
```

👉 Press **Enter** (default location is best)

```
Enter passphrase:
```

👉 Optional but recommended

-   Adds extra protection
-   You won’t need to type it often (SSH agent handles it)

------

## 5. Start SSH agent and load your key

### 5.1 Start the agent

```bash
eval "$(ssh-agent -s)"
```

### 5.2 Add your key

```bash
ssh-add ~/.ssh/id_ed25519
```

If successful, you’ll see:

```
Identity added
```

## 6. Add your SSH key to GitHub

### 6.1 Copy your public key

```bash
cat ~/.ssh/id_ed25519.pub
```

Copy **everything**, including:

```
ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAA...
```

### 6.2 Add it on GitHub

1.  Open GitHub → **Settings**

2.  Go to **SSH and GPG keys**

3.  Click **New SSH key**

4.  Paste your key

5.  Title example:

    ```
    MacBook Pro - SSH
    ```

6.  Click **Add SSH key**

## 7. Test your SSH connection

Run:

```bash
ssh -T git@github.com
```

First time:

```
Are you sure you want to continue connecting?
```

👉 Type `yes`

If successful:

```
Hi username! You've successfully authenticated, but GitHub does not provide shell access.
```

🎉 SSH is working!

## 8. Use SSH with GitHub repositories

### 8.1 Clone using SSH (important!)

❌ HTTPS (avoid):

```bash
git clone https://github.com/user/repo.git
```

✅ SSH:

```bash
git clone git@github.com:user/repo.git
```

------

### 8.2 Convert an existing repo to SSH

Inside your repo:

```bash
git remote -v
```

If you see `https://`, change it:

```bash
git remote set-url origin git@github.com:user/repo.git
```

Verify:

```bash
git remote -v
```

------

## 9. Daily workflow (no passwords!)

Once SSH is set up:

```bash
git pull
git add .
git commit -m "update"
git push
```

🚀 No username. No token. No password.

------

## 10. Common problems & fixes

### ❌ Permission denied (publickey)

```bash
ssh-add -l
```

If empty:

```bash
ssh-add ~/.ssh/id_ed25519
```

------

### ❌ Multiple GitHub accounts

Use a config file:

```bash
~/.ssh/config
```

Example:

```text
Host github.com
  User git
  IdentityFile ~/.ssh/id_ed25519
```

------

## 11. Best practices

✔ Use **ed25519**, not RSA
✔ One key per device
✔ Set a passphrase
✔ Never share your private key (`id_ed25519`)

------

## 12. Mental model summary

```
Your computer      GitHub
-------------     ----------
Private Key  →    Public Key
     🔐               🔓
```

If they match → access granted.