# Git-01: Intro

## 1. What Is Git?

**Git** is a **version control system**.

In simple terms, Git helps you:

-   Track changes in your files
-   Go back to earlier versions
-   Work on features without breaking the main code
-   Collaborate with others safely

Think of Git as **“save history + undo + collaboration”** for code.

------

## 2. Why Do We Need Git?

Without Git:

-   You might have files like
    `final_v1`, `final_v2`, `final_final`, `final_final_real`
-   You can’t easily see *what changed*
-   Collaboration becomes painful

With Git:

-   Every change is recorded
-   You can compare versions
-   You can experiment safely
-   You can recover from mistakes

------

## 3. Git vs GitHub (Important!)

Many beginners confuse these two.

| Term                | What it is                          |
| ------------------- | ----------------------------------- |
| **Git**             | A tool on your computer             |
| **GitHub / GitLab** | Websites that host Git repositories |

👉 Git works **without the internet**.
👉 GitHub is **optional**, but useful for sharing.

------

## 4. Installing Git

### Check if Git is already installed

```bash
git --version
```

### Install Git

-   **macOS**:

    ```bash
    brew install git
    ```

-   **Ubuntu / Debian**:

    ```bash
    sudo apt install git
    ```

-   **Windows**:

    -   Download from [https://git-scm.com](https://git-scm.com/)
    -   Use “Git Bash” after installation

------

## 5. Basic Git Concepts (Very Important)

### Repository (repo)

A **repository** is a folder managed by Git.

### Working Directory

Your normal files on disk.

### Staging Area

A “waiting area” before saving changes.

### Commit

A **snapshot** of your project at a point in time.

```
Working Directory → Staging Area → Commit
```

------

## 6. Your First Git Repository

### Step 1: Create a project folder

```bash
mkdir my_project
cd my_project
```

### Step 2: Initialize Git

```bash
git init
```

Now your folder is a **Git repository** 🎉

------

## 7. Checking Git Status

```bash
git status
```

This command tells you:

-   Which files changed
-   Which files are staged
-   What Git wants you to do next

👉 **Use this command a lot.**

------

## 8. Adding Files to Git

### Create a file

```bash
echo "Hello Git" > hello.txt
```

### Check status

```bash
git status
```

You’ll see `hello.txt` is **untracked**.

### Stage the file

```bash
git add hello.txt
```

or stage everything:

```bash
git add .
```

------

## 9. Making Your First Commit

```bash
git commit -m "Add hello.txt"
```

-   `-m` means **message**
-   Message should describe **what you changed**

✅ Now Git has saved a snapshot.

------

## 10. Viewing History

```bash
git log
```

You’ll see:

-   Commit ID
-   Author
-   Date
-   Commit message

Short version:

```bash
git log --oneline
```

------

## 11. Modifying Files

### Edit the file

```bash
echo "Git is awesome" >> hello.txt
```

### Check changes

```bash
git diff
```

### Stage and commit again

```bash
git add hello.txt
git commit -m "Update hello.txt content"
```

------

## 12. Ignoring Files (`.gitignore`)

Some files should **never** be tracked:

-   Build output
-   Logs
-   Passwords
-   OS files

Create `.gitignore`:

```bash
nano .gitignore
```

Example:

```
*.log
node_modules/
.env
```

------

## 13. Branches (Safe Experimenting)

A **branch** is a separate line of development.

### View branches

```bash
git branch
```

### Create a new branch

```bash
git branch feature1
```

### Switch to it

```bash
git switch feature1
```

Now you can experiment **without affecting main**.

------

## 14. Merging Branches

### Go back to main

```bash
git switch main
```

### Merge feature branch

```bash
git merge feature1
```

Git combines the changes automatically (most of the time).

------

## 15. Connecting to GitHub (Optional)

### Add remote repository

```bash
git remote add origin https://github.com/username/repo.git
```

### Push code to GitHub

```bash
git push -u origin main
```

### Pull changes from GitHub

```bash
git pull
```

------

## 16. Most Important Commands (Cheat Sheet)

```bash
git init        # create repo
git status      # check status
git add .       # stage changes
git commit -m   # save snapshot
git log         # view history
git diff        # see changes
git branch      # manage branches
git switch      # switch branches
git merge       # merge branches
```

------

## 17. Common Beginner Mistakes

❌ Forgetting to commit
❌ Writing unclear commit messages
❌ Working only on `main`
❌ Not checking `git status`
❌ Deleting `.git` folder

------

## 18. How to Learn Git Properly

Best approach:

1.  Use Git **every day**
2.  Make small commits
3.  Break things and recover
4.  Read error messages carefully

Git is **not hard**, it’s just **unfamiliar at first**.