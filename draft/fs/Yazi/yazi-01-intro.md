# Yazi

*A fast, modern terminal file manager*

## 1. What is Yazi?

**Yazi** is a **terminal-based file manager** written in **Rust**.
You can think of it as a modern alternative to tools like:

-   `ranger`
-   `nnn`
-   `lf`

### Key features

-   ⚡ **Very fast** (written in Rust, async I/O)
-   🖥️ **TUI interface** (runs inside your terminal)
-   🖼️ **Image preview support** (Kitty, iTerm2, WezTerm, etc.)
-   📁 **Vi-style keybindings**
-   🔌 **Highly configurable** (TOML + Lua)
-   🧩 **Plugin system**

If you like Vim, tmux, and terminal workflows, Yazi fits in perfectly.

## 2. Installing Yazi

### On macOS (Homebrew)

```bash
brew install yazi ffmpegthumbnailer unar jq poppler
```

>   Extra tools are for previews (images, videos, PDFs, archives).

### On Arch Linux

```bash
sudo pacman -S yazi ffmpegthumbnailer unar jq poppler
```

### On Ubuntu / Debian

```bash
sudo apt install yazi ffmpegthumbnailer unar jq poppler
```

>   If your distro doesn’t have Yazi yet, you can install it via `cargo`.

## 3. Starting Yazi

Open a terminal and run:

```bash
yazi
```

You’ll see a **three-column layout**:

```
┌──────────┬────────────┬──────────────┐
│ Parent   │ Current    │ Preview      │
│ Dir      │ Directory  │ (file/image) │
└──────────┴────────────┴──────────────┘
```

-   **Left**: parent directory
-   **Middle**: current directory
-   **Right**: file preview

## 4. Basic Navigation (Most Important)

Yazi uses **Vim-style keys**.

### Move around

| Key  | Action                      |
| ---- | --------------------------- |
| `j`  | Move down                   |
| `k`  | Move up                     |
| `h`  | Go to parent directory      |
| `l`  | Enter directory / open file |
| `gg` | Go to top                   |
| `G`  | Go to bottom                |

👉 If you know Vim, this will feel natural.

## 5. Opening Files

| Key           | Action                       |
| ------------- | ---------------------------- |
| `l` / `Enter` | Open file or enter directory |
| `o`           | Open with system default app |
| `O`           | Choose program to open with  |

Example:

-   Press `o` on a PDF → opens in your PDF viewer
-   Press `o` on an image → opens image viewer

------

## 6. File Operations (Copy, Move, Delete)

### Select files

| Key     | Action                 |
| ------- | ---------------------- |
| `Space` | Select / unselect file |
| `v`     | Visual select mode     |

### Operations

| Key  | Action                 |
| ---- | ---------------------- |
| `y`  | Yank (copy)            |
| `x`  | Cut (move)             |
| `p`  | Paste                  |
| `d`  | Delete (move to trash) |
| `D`  | Delete permanently     |

💡 Yazi will ask for confirmation before destructive actions.

------

## 7. Searching and Filtering

### File name search

```text
/
```

Type part of a filename, press `Enter`.

### Live filtering

```text
f
```

Filters files as you type.

------

## 8. Preview System (One of Yazi’s Best Features)

Yazi supports previews for:

-   📷 Images
-   🎥 Videos (thumbnails)
-   📄 PDFs
-   📦 Archives (`.zip`, `.tar`)
-   📜 Text files

### Toggle preview

```text
z
```

If your terminal supports graphics (Kitty, iTerm2, WezTerm), image previews will appear inline.

------

## 9. Tabs and Marks

### Tabs

| Key       | Action      |
| --------- | ----------- |
| `t`       | New tab     |
| `[` / `]` | Switch tabs |
| `q`       | Close tab   |

### Marks (like bookmarks)

| Key       | Action       |
| --------- | ------------ |
| `m` + key | Set mark     |
| `'` + key | Jump to mark |

Example:

```text
m a   → mark current dir as "a"
' a   → jump to it
```

------

## 10. Configuration Basics

Yazi config lives in:

```bash
~/.config/yazi/
```

Important files:

```text
yazi.toml   # core behavior
keymap.toml # key bindings
theme.toml  # colors and UI
```

Generate default config:

```bash
yazi --init
```

------

## 11. Common Beginner Customizations

### Change editor

In `yazi.toml`:

```toml
[opener]
edit = [
  { run = "nvim \"$@\"", desc = "Neovim", block = true }
]
```

Now pressing `l` on a text file opens it in `nvim`.

------

## 12. Useful Tips for Beginners

-   🧠 **Think of Yazi as Vim + Finder**
-   ⌨️ Keyboard-driven → very fast after muscle memory
-   🖼️ Use a modern terminal for previews
-   📁 Combine Yazi with `tmux` for best experience
-   🔁 Use `:q` or `q` to exit

------

## 13. When Should You Use Yazi?

Use Yazi if you:

-   Work mostly in the terminal
-   Like Vim keybindings
-   Need fast navigation in large directories
-   Want previews without leaving terminal

Avoid it if you:

-   Prefer mouse-heavy workflows
-   Need drag-and-drop
-   Are uncomfortable with keyboard shortcuts

------

## 14. Next Steps

Once you’re comfortable, explore:

-   Custom keybindings
-   Lua plugins
-   Git integration
-   Advanced preview rules