# Git-02: gitignore

## 1. What Is `.gitignore`?

`.gitignore` is a **text file** that tells Git:

>   “Do NOT track these files or folders.”

Git will completely **ignore** matching files:

-   They won’t be added by `git add .`
-   They won’t be committed
-   They won’t be pushed to GitHub

------

## 2. Why Do We Need `.gitignore`?

Some files should **never** be stored in Git:

-   Compiled files (e.g. `.o`, `.exe`)
-   Temporary files
-   Log files
-   IDE settings
-   OS-generated files
-   Secrets (API keys, passwords)

Without `.gitignore`, your repo becomes:

-   Messy
-   Unsafe
-   Hard to review

------

## 3. Where Is `.gitignore` Located?

Usually:

-   In the **root directory** of your Git repository

Example:

```
my_project/
├── .gitignore
├── main.c
├── build/
└── README.md
```

You can also have **multiple `.gitignore` files**, but beginners should start with **one at the root**.

------

## 4. Creating a `.gitignore` File

```bash
touch .gitignore
```

Or open it directly:

```bash
nano .gitignore
```

------

## 5. Basic `.gitignore` Rules

Each line is **one rule**.

### Ignore a file by name

```
secret.txt
```

### Ignore all files with an extension

```
*.log
```

### Ignore a directory

```
build/
```

### Ignore everything inside a directory

```
node_modules/
```

------

## 6. Common Patterns Explained

### Wildcard `*`

Matches any characters:

```
*.tmp
```

### Ignore files in any folder

```
**/*.log
```

### Ignore only in the root

```
/config.json
```

### Ignore files starting with a name

```
debug*
```

------

## 7. Comments in `.gitignore`

Use `#` for comments:

```
# Log files
*.log

# Build output
build/
```

Comments are ignored by Git.

------

## 8. Negation: “Ignore Everything Except…”

Use `!` to **re-include** a file.

Example:

```
*.log
!important.log
```

Git ignores all `.log` files **except** `important.log`.

------

## 9. Very Important Rule (Beginner Trap 🚨)

>   `.gitignore` does **NOT** affect files that are already tracked.

### Example problem:

You already committed `debug.log`, then add:

```
*.log
```

Git will **still track `debug.log`**.

### Fix it:

```bash
git rm --cached debug.log
git commit -m "Stop tracking debug.log"
```

Now `.gitignore` works.

------

## 10. Check What Git Is Ignoring

```bash
git status --ignored
```

This shows:

-   Ignored files
-   Untracked files
-   Tracked files

Very useful for debugging `.gitignore`.

------

## 11. Typical `.gitignore` Examples

### C / C++ Project

```
# Compiled files
*.o
*.out
*.exe

# Build directories
build/
cmake-build-*/

# Debug
*.log
```

------

### Python Project

```
__pycache__/
*.pyc
.venv/
.env
```

------

### Node.js Project

```
node_modules/
npm-debug.log
```

------

### macOS

```
.DS_Store
```

------

## 12. Global `.gitignore` (Optional)

You can ignore files **for all projects** on your system.

### Create a global ignore file

```bash
nano ~/.gitignore_global
```

### Add rules

```
.DS_Store
*.swp
```

### Tell Git to use it

```bash
git config --global core.excludesfile ~/.gitignore_global
```

------

## 13. Best Practices

✅ Add `.gitignore` **early**
✅ Keep it **simple and readable**
✅ Never commit secrets
✅ Use comments
✅ Review before pushing

------

## 14. Common Beginner Mistakes

❌ Forgetting `.gitignore` doesn’t remove tracked files
❌ Ignoring too much
❌ Putting passwords in Git
❌ Copying a huge `.gitignore` without understanding it

------

## 15. Quick Checklist

Before committing, ask yourself:

-   Can this file be regenerated?
-   Is this file machine-specific?
-   Does this file contain secrets?

If yes → **ignore it**.

------

## 16. One-Sentence Summary

>   `.gitignore` is Git’s “do not track” list that keeps your repository clean, safe, and professional.