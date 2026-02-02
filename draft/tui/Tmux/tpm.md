---
status: done
---

# TPM

## 1. What is TPM?

**[TPM (Tmux Plugin Manager)](https://github.com/tmux-plugins/tpm)** is a plugin manager for **tmux**.

It helps you:

-   Install tmux plugins easily
-   Update plugins with one command
-   Remove plugins cleanly
-   Avoid manually cloning Git repositories

Think of it as:

-   `apt` for Linux packages
-   `brew` for macOS
-   **TPM for tmux plugins**

## 2. Prerequisites

Before using TPM, make sure you have:

### 2.1 tmux installed

Check:

```bash
tmux -V
```

If not installed:

**macOS**

```bash
brew install tmux
```

**Ubuntu / Debian**

```bash
sudo apt install tmux
```

### 2.2 Basic tmux knowledge (recommended)

You should know:

-   How to start tmux: `tmux`
-   Prefix key (default): `Ctrl + b`
-   How to reload config (we’ll show later)

## 3. What Problems Does TPM Solve?

Without TPM:

-   Manually clone plugins into `~/.tmux/plugins`
-   Manually update each plugin
-   Hard to manage multiple plugins

With TPM:

-   Plugins listed in `.tmux.conf`
-   One shortcut to install/update
-   Clean and reproducible setup

## 4. Installing TPM

### 4.1 Clone TPM repository

Run:

```bash
git clone https://github.com/tmux-plugins/tpm ~/.config/tmux/plugins/tpm
```

This installs TPM **itself** (TPM is just another tmux plugin).

## 5. Basic `.tmux.conf` Setup

Open your tmux config file:

```bash
vim ~/.config/tmux/.tmux.conf
```

### 5.1 Minimal TPM configuration

Add this **exact structure**:

```tmux
# List of plugins
set -g @plugin 'tmux-plugins/tpm'
set -g @plugin 'tmux-plugins/tmux-sensible'

# Initialize TPM (keep this at the bottom)
run '~/.config/tmux/plugins/tpm/tpm'
```

⚠️ **Important rule**
`run '~/.config/tmux/plugins/tpm/tpm''`
**must be the last line** in `.tmux.conf`.

### 5.2 What this does

-   `tmux-plugins/tpm` → TPM itself
-   `tmux-plugins/tmux-sensible` → sensible default tmux settings
-   `run ...` → tells tmux to load TPM

## 6. Installing Plugins (First Time)

### 6.1 Reload tmux config

Inside tmux, press:

```
Ctrl + b, then :
```

Type:

```
source-file ~/.config/tmux/.tmux.conf
```

Press Enter.

### 6.2 Install plugins via TPM

Inside tmux, press:

```
PREFIX + I
```

(uppercase **I**)

TPM will:

-   Clone plugins
-   Install them automatically

You should see messages at the bottom of tmux.

## 7. Where Plugins Are Installed

TPM installs plugins to:

```bash
~/.config/tmux/plugins/
```

Example:

```text
~/.tmux/plugins/
├── tpm
├── tmux-sensible
├── tmux-resurrect
└── tmux-continuum
```

## 8. Adding More Plugins

### 8.1 Example: tmux-resurrect (save/restore sessions)

Add to `.tmux.conf`:

```tmux
set -g @plugin 'tmux-plugins/tmux-resurrect'
```

Reload config, then install:

```
Ctrl + b + I
```

### 8.2 Popular beginner plugins

| Plugin                        | Description           |
| ----------------------------- | --------------------- |
| `tmux-plugins/tmux-sensible`  | Safe defaults         |
| `tmux-plugins/tmux-resurrect` | Save/restore sessions |
| `tmux-plugins/tmux-continuum` | Auto-save sessions    |
| `tmux-plugins/tmux-yank`      | Better clipboard      |
| `catppuccin/tmux`             | Theme                 |

## 9. Updating Plugins

Inside tmux:

```
PREFIX + U
```

TPM will:

-   Pull latest versions
-   Update all plugins

## 10. Removing Plugins

### 10.1 Remove from `.tmux.conf`

Delete or comment out:

```tmux
set -g @plugin 'some/plugin'
```

### 10.2 Clean unused plugins

Inside tmux:

```
PREFIX + Alt + u
```

(Removes plugins no longer listed)

## 11. Common TPM Key Bindings

| Action                | Key                  |
| --------------------- | -------------------- |
| Install plugins       | `Ctrl + b + I`       |
| Update plugins        | `Ctrl + b + U`       |
| Remove unused plugins | `Ctrl + b + Alt + u` |

## 12. Troubleshooting

### 12.1 Plugins not installing?

-   Make sure TPM is cloned correctly
-   Make sure `run '~/.tmux/plugins/tpm/tpm'` is **last line**
-   Reload config before installing

### 12.2 Key bindings don’t work?

-   You must be **inside tmux**
-   Prefix key might be customized

## 13. Mental Model (Very Important)

Think of TPM like this:

-   `.tmux.conf` → **plugin list**
-   `Ctrl + b + I` → **install**
-   `Ctrl + b + U` → **update**
-   TPM just runs `git clone` / `git pull` for you

## 14. Minimal Working Example

Final `.tmux.conf`:

```tmux
set -g mouse on

set -g @plugin 'tmux-plugins/tpm'
set -g @plugin 'tmux-plugins/tmux-sensible'
set -g @plugin 'tmux-plugins/tmux-resurrect'

run '~/.config/tmux/plugins/tpm/tpm'
```

## 15. What to Learn Next

After TPM:

-   Custom tmux key bindings
-   Status bar customization
-   Session persistence (resurrect + continuum)
-   Themes