# Joshuto-01: Intro

## 1. What Is Joshuto?

**Joshuto** is a **terminal-based file manager** written in Rust.
It lets you browse, open, copy, move, and manage files **entirely with the keyboard**, making it very efficient once you get used to it.

### Why use Joshuto?

-   ⚡ Very fast (written in Rust)
-   ⌨️ Keyboard-centric workflow
-   🧩 Highly configurable
-   🖥️ Works well over SSH
-   🐧 Great for Linux & macOS terminal users

If you like tools such as `vim`, `ranger`, or `lf`, you’ll feel at home.

## 2. Installing Joshuto

### macOS (Homebrew)

```bash
brew install joshuto
```

### Linux (Cargo – recommended)

```bash
cargo install joshuto
```

Make sure Cargo’s bin directory is in your `PATH`:

```bash
export PATH="$HOME/.cargo/bin:$PATH"
```

### Verify Installation

```bash
joshuto --version
```

## 3. Starting Joshuto

Simply run:

```bash
joshuto
```

Joshuto opens in your **current directory**.

You will see:

-   A file list in the center
-   A status bar at the bottom
-   A preview pane (for files like text, images, PDFs)

## 4. Basic Interface Overview

Joshuto uses **modes**, similar to Vim.

| Mode         | Purpose                        |
| ------------ | ------------------------------ |
| Normal mode  | Navigate files and directories |
| Command mode | Run commands (like `:` in Vim) |
| Search mode  | Search for files               |

You start in **Normal mode**.

## 5. Essential Navigation Keys

### Move Around

| Key  | Action                      |
| ---- | --------------------------- |
| `j`  | Move down                   |
| `k`  | Move up                     |
| `h`  | Go to parent directory      |
| `l`  | Enter directory / open file |
| `gg` | Go to top                   |
| `G`  | Go to bottom                |

👉 These are **Vim-style keys**.

## 6. Opening Files

| Key           | Action                                |
| ------------- | ------------------------------------- |
| `l` / `Enter` | Open file or enter directory          |
| `o`           | Open file with system default program |

Examples:

-   Text files → opened in `$EDITOR`
-   Images / PDFs → opened in system viewer

## 7. File Operations (Core Features)

### Copy / Cut / Paste

| Key  | Action      |
| ---- | ----------- |
| `y`  | Yank (copy) |
| `x`  | Cut (move)  |
| `p`  | Paste       |

### Delete Files

```text
d
```

Joshuto will ask for confirmation.

## 8. Create Files and Directories

| Key  | Action                 |
| ---- | ---------------------- |
| `a`  | Create a new file      |
| `A`  | Create a new directory |

You’ll be prompted to enter a name.

## 9. Renaming Files

```text
r
```

Type the new filename and press `Enter`.

## 10. Searching for Files

### Start search

```text
/
```

Type part of a filename:

```text
config
```

Press:

-   `n` → next match
-   `N` → previous match

## 11. Command Mode

Enter command mode:

```text
:
```

Common commands:

```text
:quit        # quit joshuto
:cd ~/Downloads
:help
```

You can quit anytime with:

```text
q
```

## 12. Configuration Basics

Joshuto config files are stored in:

```text
~/.config/joshuto/
```

Generate default config:

```bash
joshuto --print-config > ~/.config/joshuto/joshuto.toml
```

Common things you can configure:

-   Key bindings
-   Preview behavior
-   File sorting
-   Hidden file visibility

## 13. Showing Hidden Files

Toggle hidden files:

```text
zh
```

Files starting with `.` will appear.

## 14. Preview Pane

Joshuto can preview:

-   Text files
-   Images
-   PDFs
-   Archives

If preview doesn’t work, install helpers:

```bash
brew install bat exa ueberzug
```

(or equivalent Linux packages)

## 15. Useful Tips for Beginners

✅ Start slow — only memorize **j / k / h / l** first

✅ Use Joshuto for **daily navigation** to build muscle memory

✅ Combine with:

-   `tmux`
-   `vim`
-   `ssh`

## 16. When Should You Use Joshuto?

Joshuto is perfect if you:

-   Work in terminals often
-   Use SSH servers
-   Prefer keyboard over mouse
-   Like Vim-style workflows

If you prefer GUI file managers, Joshuto may feel hard at first—but very rewarding.

## 17. Summary

-   Joshuto is a **fast, keyboard-driven terminal file manager**
-   Uses **Vim-style navigation**
-   Ideal for **developers, sysadmins, and Linux/macOS users**
-   Highly configurable and SSH-friendly

