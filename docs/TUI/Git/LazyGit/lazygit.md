# LazyGit

*A simple, powerful terminal UI for Git*

## 1. What is LazyGit?

**LazyGit** is a **terminal-based Git UI** (TUI).

Instead of typing long Git commands like:

```bash
git status
git add .
git commit -m "message"
git push
```

you use **keyboard shortcuts** in an interactive interface.

Think of LazyGit as:

>   **`htop` for Git**
>   or
>   **a Git GUI that lives inside your terminal**

### Why people love LazyGit

-   🚀 Very fast once you learn it
-   🧠 Helps you *see* what Git is doing
-   ⌨️ Keyboard-driven (no mouse)
-   🧼 Cleaner than memorizing many Git commands
-   🔥 Perfect for daily Git usage

## 2. Who Should Use LazyGit?

LazyGit is great if you:

-   Are learning Git and want visual feedback
-   Already know basic Git but want speed
-   Live in the terminal (tmux, Neovim, zsh, etc.)
-   Don’t want a heavy GUI like SourceTree

## 3. Install LazyGit

### macOS (recommended)

```bash
brew install lazygit
```

### Linux (example)

```bash
sudo apt install lazygit
```

### Verify installation

```bash
lazygit --version
```

## 4. Start LazyGit

Go to **any Git repository**:

```bash
cd your-project
lazygit
```

You will see a **split-panel UI**.

## 5. Understanding the Interface (Very Important)

LazyGit is divided into **panels**.

### Common panels you’ll see:

```
┌─────────────┬────────────────┐
│ Status      │ Files          │
│ (left)      │ (right)        │
├─────────────┼────────────────┤
│ Commits     │ Diff           │
└─────────────┴────────────────┘
```

### Key panels explained

#### 1️⃣ Status panel

-   Branch name
-   Staged / unstaged file counts
-   Working tree state

#### 2️⃣ Files panel (most used)

-   Modified files
-   Staged files
-   Untracked files

#### 3️⃣ Commits panel

-   Git commit history
-   Select commits to inspect, reset, or rebase

#### 4️⃣ Diff panel

-   Shows file or commit differences

## 6. Navigation Basics

### Move around

| Key   | Action        |
| ----- | ------------- |
| `↑ ↓` | Move up/down  |
| `← →` | Switch panels |
| `Tab` | Cycle panels  |
| `q`   | Quit LazyGit  |

👉 **If you ever forget keys, press `?`**

## 7. Basic Workflow (Daily Use)

Let’s walk through a **typical Git workflow**.

### Step 1: Check status

```bash
lazygit
```

You’ll immediately see:

-   Changed files
-   Current branch
-   Whether your branch is ahead/behind

No need for `git status`.

### Step 2: Stage files

In the **Files panel**:

| Action         | Key     |
| -------------- | ------- |
| Stage a file   | `space` |
| Unstage a file | `space` |
| Stage all      | `a`     |

You can **see staged vs unstaged instantly**.

### Step 3: View diff

Select a file → diff appears automatically.

| Action              | Key     |
| ------------------- | ------- |
| Toggle line staging | `enter` |
| Stage selected hunk | `space` |

👉 This is great for **partial commits**.

### Step 4: Commit

Press:

```text
c
```

-   Enter commit message
-   Save & exit editor

Done 🎉

### Step 5: Push / Pull

| Action | Key  |
| ------ | ---- |
| Push   | `P`  |
| Pull   | `p`  |
| Fetch  | `f`  |

LazyGit shows progress and errors clearly.

## 8. Branch Management (Easy Mode)

Go to **Branches panel**.

| Action          | Key     |
| --------------- | ------- |
| Create branch   | `n`     |
| Checkout branch | `space` |
| Delete branch   | `d`     |
| Rename branch   | `r`     |

Much easier than remembering:

```bash
git checkout -b
git branch -d
```

------

## 9. Working with Commits

In the **Commits panel**:

| Action             | Key     |
| ------------------ | ------- |
| View commit diff   | `enter` |
| Revert commit      | `t`     |
| Reset to commit    | `r`     |
| Interactive rebase | `i`     |

⚠️ Be careful with reset/rebase on shared branches.

------

## 10. Stash (Quick Save Work)

| Action        | Key     |
| ------------- | ------- |
| Stash changes | `s`     |
| Apply stash   | `space` |
| Drop stash    | `d`     |

Great when you need to switch tasks quickly.

------

## 11. Most Important Keys to Remember

### Absolute essentials

| Key     | Meaning        |
| ------- | -------------- |
| `?`     | Help           |
| `space` | Stage / select |
| `c`     | Commit         |
| `P`     | Push           |
| `p`     | Pull           |
| `q`     | Quit           |

If you remember just these, you’re productive already.

------

## 12. Tips for Beginners

### ✅ Use `?` often

LazyGit is **self-documenting**.

### ✅ Don’t panic

LazyGit runs **real Git commands**.
Nothing magical or unsafe by default.

### ✅ Learn gradually

You don’t need to master everything on day one.

------

## 13. LazyGit vs Git CLI

| Task          | Git CLI        | LazyGit |
| ------------- | -------------- | ------- |
| Status        | `git status`   | auto    |
| Stage file    | `git add file` | `space` |
| Commit        | `git commit`   | `c`     |
| View diff     | `git diff`     | auto    |
| Branch switch | `git checkout` | `space` |

LazyGit doesn’t replace Git — it **makes Git easier**.

------

## 14. When NOT to Use LazyGit

-   Writing Git scripts
-   Automation / CI
-   Very advanced Git plumbing

Use **CLI + LazyGit together**.

------

## 15. Final Advice

>   **Use LazyGit every day for 1 week.**
>   After that, you’ll feel slow without it.

If you want, I can:

-   Create a **LazyGit cheat sheet**
-   Explain **LazyGit + tmux workflow**
-   Teach **Git concepts visually using LazyGit**
-   Show **common mistakes and how LazyGit helps**

Just tell me 👍