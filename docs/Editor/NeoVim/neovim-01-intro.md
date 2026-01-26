# Neovim-01: Intro

## 1. What Is Neovim?

**Neovim (nvim)** is a modern, improved version of **Vim**, a powerful terminal-based text editor.

Compared with Vim, Neovim provides:

-   🚀 Faster and more maintainable core
-   🔌 Better plugin system (**Lua-based**)
-   🧠 Built-in **LSP** (Language Server Protocol)
-   🧩 First-class support for modern tooling
-   🖥️ Works well in terminal, SSH, tmux, VS Code, etc.

If you like **keyboard-driven editing**, Neovim is worth learning.

## 2. Installing Neovim

### On macOS (Homebrew)

```bash
brew install neovim
```

### On Ubuntu / Debian

```bash
sudo apt update
sudo apt install neovim
```

### On CentOS / Rocky / AlmaLinux

```bash
sudo dnf install neovim
```

### Check installation

```bash
nvim --version
```

## 3. Starting Neovim

Open Neovim:

```bash
nvim
```

Open a file:

```bash
nvim hello.txt
```

You will see a **blank screen** — this is normal.

## 4. Neovim’s Core Concept: Modes

Neovim is **modal**. This is the most important idea.

| Mode    | Purpose                |
| ------- | ---------------------- |
| Normal  | Navigate, delete, copy |
| Insert  | Insert text            |
| Visual  | Select text            |
| Command | Run commands           |

### Switching Modes

-   `i` → Insert mode
-   `Esc` → Normal mode
-   `v` → Visual mode
-   `:` → Command mode

📌 **Rule**:

>   When in doubt, press `Esc`.

## 5. Basic Movement (Normal Mode)

| Key  | Action |
| ---- | ------ |
| `h`  | Left   |
| `j`  | Down   |
| `k`  | Up     |
| `l`  | Right  |

### Word & Line Movement

| Key  | Action        |
| ---- | ------------- |
| `w`  | Next word     |
| `b`  | Previous word |
| `0`  | Line start    |
| `$`  | Line end      |
| `gg` | File start    |
| `G`  | File end      |

## 6. Editing Text

### Insert Text

-   `i` → Insert before cursor
-   `a` → Insert after cursor
    -   **a**ppend

-   `o` → New line bel**o**w
-   `O` → New line ab**o**ve

### Delete & Undo

| Key            | Action           |
| -------------- | ---------------- |
| `x`            | Delete character |
| `dd`           | Delete line      |
| `dw`           | Delete word      |
| `u`            | Undo             |
| **`Ctrl + r`** | **Redo**         |

## 7. Copy, Cut, Paste

| Key  | Action              |
| ---- | ------------------- |
| `yy` | Copy (yank) line    |
| `dd` | Cut line            |
| `p`  | Paste after cursor  |
| `P`  | Paste before cursor |

## 8. Saving and Quitting

Command mode (`:`):

| Command | Meaning          |
| ------- | ---------------- |
| `:w`    | Save (**W**rite) |
| `:q`    | **Q**uit         |
| `:wq`   | Save & quit      |
| `:q!`   | Force quit       |
| `:wqa`  | Save & quit all  |

## 9. Neovim Configuration Basics

Neovim uses **Lua** for configuration.

### Config file location

```text
~/.config/nvim/init.lua
```

Create it:

```bash
mkdir -p ~/.config/nvim
nvim ~/.config/nvim/init.lua
```

### Minimal `init.lua`

```lua
-- line numbers
vim.opt.number = true
vim.opt.relativenumber = true

-- indentation
vim.opt.tabstop = 4
vim.opt.shiftwidth = 4
vim.opt.expandtab = true

-- better behavior
vim.opt.mouse = "a"
vim.opt.clipboard = "unnamedplus"
```

Reload config:

```vim
:source %
```

## 10. Installing Plugins (Beginner Way)

Use **lazy.nvim** (recommended for beginners).

### Install lazy.nvim

```bash
git clone https://github.com/folke/lazy.nvim.git \
~/.local/share/nvim/lazy/lazy.nvim
```

### Basic plugin setup

Add to `init.lua`:

```lua
vim.opt.rtp:prepend(
  vim.fn.stdpath("data") .. "/lazy/lazy.nvim"
)

require("lazy").setup({
  "nvim-lua/plenary.nvim",
  "nvim-treesitter/nvim-treesitter",
  "nvim-telescope/telescope.nvim",
})
```

Restart Neovim and plugins will auto-install.

## 11. Essential Plugins for Beginners

| Plugin         | Purpose                    |
| -------------- | -------------------------- |
| telescope.nvim | File & text search         |
| treesitter     | Better syntax highlighting |
| nvim-lspconfig | Language Server support    |
| nvim-cmp       | Auto-completion            |
| lualine.nvim   | Status line                |

You don’t need everything on day one.

## 12. Learning Neovim Efficiently

### Built-in tutor

```bash
nvim +Tutor
```

### Daily practice tips

-   Use Neovim for **small tasks first**
-   Don’t memorize everything
-   Learn **motions + operators** (`d + w`, `c + i + w`)
-   Avoid mouse, trust the keyboard

## 13. Common Beginner Mistakes

❌ Staying in Insert mode too long

❌ Using arrow keys

❌ Installing too many plugins early

❌ Copying complex configs without understanding

## 14. Neovim vs Vim (Quick Summary)

| Feature             | Vim           | Neovim      |
| ------------------- | ------------- | ----------- |
| **Config language** | **Vimscript** | **Lua**     |
| Built-in LSP        | ❌             | ✅           |
| Plugin ecosystem    | Good          | Better      |
| Community           | Large         | Very active |

## 15. Final Advice

Neovim is not hard — **it’s different**.

>   Learn a little every day,
>   and Neovim will feel natural sooner than you expect.
