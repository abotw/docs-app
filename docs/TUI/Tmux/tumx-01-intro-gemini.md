---
status: done
---

Welcome to the world of **tmux** (terminal multiplexer). If you’ve ever felt the pain of a SSH connection dropping and losing your work, or if you're tired of having twenty terminal windows open at once, tmux is about to become your new best friend.

Think of tmux as a "window manager" for your terminal. It allows you to create multiple sessions, windows, and panes within a single terminal window.

## 1. Why use tmux?

-   **Persistence:** You can disconnect from a server, go home, and reconnect later to find everything exactly as you left it.
-   **Organization:** Split your screen into multiple "panes" to see your code, logs, and a database shell all at once.
-   **Flexibility:** It works on almost any Unix-like system (Linux, macOS, BSD).

## 2. Getting Started: The Basics

First, make sure it's installed. On macOS, use `brew install tmux`. On Ubuntu/Debian, use `sudo apt install tmux`.

### Starting and Exiting

-   **Start a session:** Type `tmux` in your terminal.
-   **Exit a session:** Type `exit` or press `Ctrl+d` (this kills the session).
-   **Detach from a session:** Press `Ctrl+b` then `d`. Your session keeps running in the background!
-   **Reattach to a session:** Type `tmux attach`.

## 3. The Secret Weapon: The Prefix

In tmux, almost every command starts with a **Prefix**. By default, this is:

>   **`Ctrl+b`**

You press these together, release them, and then press the **command key**.

### Essential Commands

| **Action**             | **Key Combination**                  |
| ---------------------- | ------------------------------------ |
| **Split Vertically**   | `Prefix` + `%`                       |
| **Split Horizontally** | `Prefix` + `"`                       |
| **Switch Panes**       | `Prefix` + `Arrow Keys`              |
| **New Window**         | `Prefix` + `c`                       |
| **Switch Window**      | `Prefix` + `0-9` (the window number) |
| **Close Pane**         | `Prefix` + `x`                       |

## 4. The Hierarchy: Sessions, Windows, and Panes

To master tmux, you need to understand how it organizes your work:

1.  **Sessions:** A collection of windows (e.g., "Work Project" or "System Monitoring").
2.  **Windows:** Like tabs in a web browser. Each window takes up the whole screen.
3.  **Panes:** Divisions within a window. This is where the magic of "split-screen" happens.

## 5. Pro Tip: Naming your Sessions

Don't just run `tmux`. If you have multiple projects, name them so you can find them later:

```Bash
# Start a named session
tmux new -s my_project

# List all running sessions
tmux ls

# Attach to a specific session
tmux attach -t my_project
```

## 6. A "Quick Start" Cheat Sheet

If you're feeling overwhelmed, just remember these three steps for your first day:

1.  Type `tmux` to start.
2.  Use `Ctrl+b` then `%` to split your screen so you can watch two things at once.
3.  Use `Ctrl+b` then `d` when you're done for the day; your work will be waiting for you tomorrow.