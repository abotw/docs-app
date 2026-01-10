# tmux

## 1. What is tmux?

**tmux** (Terminal MUltipleXer) lets you:

-   Run **multiple terminal sessions** in one window
-   Split your terminal into **panes**
-   Keep programs running even if you **disconnect from SSH**
-   Reattach to sessions later

Think of tmux as:

>   *A “window manager” for your terminal*

## 2. Why use tmux?

Without tmux:

-   SSH disconnect → all programs stop ❌
-   Only one terminal per window 😐

With tmux:

-   SSH disconnect → programs keep running ✅
-   Multiple panes, windows, sessions 💪
-   Perfect for servers, development, long-running tasks

## 3. Install tmux

### macOS

```bash
brew install tmux
```

### Ubuntu / Debian

```bash
sudo apt install tmux
```

### CentOS / RHEL

```bash
sudo yum install tmux
```

Check installation:

```bash
tmux -V
```

## 4. Basic Concepts (Very Important)

tmux has **3 levels**:

```
Session
 ├─ Window
 │   ├─ Pane
 │   └─ Pane
 └─ Window
     └─ Pane
```

-   **Session** → a workspace
-   **Window** → like a tab
-   **Pane** → split screen inside a window

## 5. Starting tmux

Start tmux:

```bash
tmux
```

You are now **inside a tmux session**.

At the bottom, you’ll see a **status bar**.

## 6. The Prefix Key (Core Idea)

tmux commands start with a **prefix key**.

Default prefix:

```
Ctrl + b
```

Notation in this tutorial:

```
C-b c   → Press Ctrl+b, release, then press c
```

## 7. Sessions

### Create a named session

```bash
tmux new -s mysession
```

### Detach from a session

```
C-b d
```

(detach = leave tmux, session keeps running)

### List sessions

```bash
tmux ls
```

### Attach to a session

```bash
tmux attach -t mysession
```

## 8. Windows (Tabs)

### Create a new window

```
C-b c
```

### Switch windows

```
C-b n   → next window
C-b p   → previous window
C-b 0-9 → jump to window number
```

### Rename window

```
C-b ,
```

## 9. Panes (Splits)

### Split vertically

```
C-b %
```

### Split horizontally

```
C-b "
```

### Move between panes

```
C-b ↑ ↓ ← →
```

### Close a pane

```bash
exit
```

or

```
C-b x
```

## 10. Resize Panes

Hold prefix, then resize:

```
C-b + arrow key
```

Example:

```
C-b ←   (shrink)
C-b →   (expand)
```

## 11. Copy Mode (Scrolling)

tmux does **not** use mouse scrolling by default.

### Enter copy mode

```
C-b [
```

### Navigation

-   Arrow keys / PageUp / PageDown
-   `q` → exit copy mode

(Advanced users often enable mouse mode later)

## 12. Detach vs Exit (Very Important)

| Action  | Result                        |
| ------- | ----------------------------- |
| `C-b d` | Leave tmux, session continues |
| `exit`  | Close pane/window/session     |

⚠️ **Never confuse detach with exit**

## 13. Useful Daily Workflow Example

```bash
tmux new -s work
# split panes
C-b %
C-b "
# run tasks
vim main.c
htop
tail -f app.log
# detach
C-b d
```

Later:

```bash
tmux attach -t work
```

Everything is still there 🎉

## 14. Common Beginner Commands (Cheat Sheet)

| Action           | Key          |
| ---------------- | ------------ |
| New window       | `C-b c`      |
| Split vertical   | `C-b %`      |
| Split horizontal | `C-b "`      |
| Switch pane      | `C-b arrows` |
| Detach           | `C-b d`      |
| List sessions    | `tmux ls`    |
| Kill pane        | `C-b x`      |

## 15. Minimal `.tmux.conf` (Optional)

Create:

```bash
~/.tmux.conf
```

Example:

```conf
# Enable mouse
set -g mouse on

# Faster escape
set -sg escape-time 10

# Better colors
set -g default-terminal "screen-256color"
```

Reload config:

```
C-b :source-file ~/.tmux.conf
```

## 16. When Should You Use tmux?

Use tmux if you:

-   Work on **remote servers**
-   Run **long jobs**
-   Use terminal heavily
-   Want **stable, persistent sessions**

## 17. tmux vs screen (Quick Note)

| tmux               | screen           |
| ------------------ | ---------------- |
| Modern             | Older            |
| Better splits      | Basic splits     |
| Active development | Maintenance mode |

tmux is the recommended choice today.

## 18. Final Advice for Beginners

-   Memorize **5 commands only** first:
    -   `C-b c`
    -   `C-b %`
    -   `C-b "`
    -   `C-b d`
    -   `tmux attach`
-   Use tmux **daily** for one week
-   Don’t customize too early