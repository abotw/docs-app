---
status: done
---

# Git Config

## 1. What is `git config`?

`git config` is the command Git uses to **store and read configuration settings**.

These settings control things like:

-   Your **name and email** (used in commits)
-   Your **default editor**
-   How Git **behaves** (colors, aliases, line endings, etc.)
-   Repository-specific preferences

In short:

>   **If Git feels “personalized”, it’s because of `git config`.**

## 2. Three Levels of Git Configuration

Git config exists at **three different scopes**:

| Level  | Command option | Applies to                 | Stored in        |
| ------ | -------------- | -------------------------- | ---------------- |
| System | `--system`     | All users on this computer | `/etc/gitconfig` |
| Global | `--global`     | Your user account          | `~/.gitconfig`   |
| Local  | `--local`      | One specific repository    | `.git/config`    |

### Priority order (important!)

```
local  >  global  >  system
```

If the same setting exists in multiple levels, **Git uses the most specific one**.

## 3. Your First Git Config (Must-Do)

### Set your name

```bash
git config --global user.name "Your Name"
```

### Set your email

```bash
git config --global user.email "you@example.com"
```

📌 These values appear in **every commit you make**.

Check them:

```bash
git config --global --list
```

## 4. Viewing Git Configuration

### View all effective settings

```bash
git config --list
```

This shows the **final result after merging all levels**.

### View only global config

```bash
git config --global --list
```

### View local (repo-only) config

```bash
git config --local --list
```

(You must be inside a Git repository.)

## 5. Where Are These Configs Stored?

You normally don’t need to edit them manually, but it helps to know:

-   **Global**

    ```
    ~/.gitconfig
    ```

-   **Local**

    ```
    your-repo/.git/config
    ```

You can open them with:

```bash
git config --global --edit
```

or

```bash
git config --local --edit
```

## 6. Common Beginner Configurations

### 6.1 Set a Default Editor

Example: use **VS Code**

```bash
git config --global core.editor "code --wait"
```

Example: use **Vim**

```bash
git config --global core.editor vim
```

### 6.2 Enable Colored Output (Recommended)

```bash
git config --global color.ui auto
```

This makes Git output easier to read.

### 6.3 Fix Line Ending Issues (Cross-platform)

#### On macOS / Linux

```bash
git config --global core.autocrlf input
```

#### On Windows

```bash
git config --global core.autocrlf true
```

This prevents annoying line-ending diffs.

## 7. Git Aliases (Huge Productivity Boost)

Aliases let you create **short commands**.

### Example: `git st` instead of `git status`

```bash
git config --global alias.st status
```

Now you can run:

```bash
git st
```

### More useful aliases

```bash
git config --global alias.co checkout
git config --global alias.br branch
git config --global alias.cm commit
```

## 8. Reading a Specific Config Value

```bash
git config user.name
```

With scope:

```bash
git config --global user.email
git config --local core.editor
```

## 9. Removing or Resetting a Config

### Remove a setting

```bash
git config --global --unset user.email
```

### Remove all values for a key

```bash
git config --global --unset-all alias.st
```

## 10. Local Config vs Global Config (Very Important)

### Example scenario

You work on **open-source** and **company** projects.

Set a company email only for one repo:

```bash
cd company-project
git config --local user.email "you@company.com"
```

Global email remains unchanged.

## 11. How Git Config Looks Internally

Example `.gitconfig` file:

```ini
[user]
    name = Matt Li
    email = matt@example.com

[core]
    editor = code --wait

[alias]
    st = status
    co = checkout
```

INI-style format:
`section.key = value`

## 12. Common Beginner Mistakes

❌ Forgetting `--global`

→ config only applies to one repo

❌ Wrong email

→ GitHub shows “unknown user”

❌ Editing `.gitconfig` with wrong syntax

→ Git errors

✔️ Prefer `git config` command instead of manual editing

## 13. Quick Checklist (Beginner Setup)

```bash
git config --global user.name "Your Name"
git config --global user.email "you@example.com"
git config --global core.editor "code --wait"
git config --global color.ui auto
git config --global alias.st status
```

## 14. Summary

-   `git config` controls **who you are** and **how Git behaves**
-   Three levels: **system / global / local**
-   Always set **name and email**
-   Use **aliases** to work faster
-   Local config is perfect for per-project customization

