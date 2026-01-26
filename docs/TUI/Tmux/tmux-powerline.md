# tmux Powerline]

## 1. What Is tmux Powerline?

**tmux powerline** is a **status bar framework** for tmux that replaces the default tmux status line with a **rich, informative, and customizable bar**.

It can show:

-   Current session / window / pane
-   Hostname
-   Date & time
-   CPU / memory usage
-   Git branch & status
-   Battery level
-   Network info

Think of it as:

>   “Powerline-style status bar, but designed specifically for tmux.”

## 2. tmux vs tmux Powerline (Quick Comparison)

| Feature           | Default tmux  | tmux Powerline |
| ----------------- | ------------- | -------------- |
| Looks             | Plain text    | Icons + colors |
| Modules           | Hard-coded    | Modular        |
| Customization     | Manual config | Config files   |
| Git / System info | No            | Yes            |

## 3. Prerequisites

### 3.1 tmux

Check:

```bash
tmux -V
```

### 3.2 Python

tmux powerline is written in Python.

Check:

```bash
python3 --version
```

### 3.3 Powerline Fonts (Very Important!)

tmux powerline uses **special glyphs** (triangles, separators).

Install a Nerd Font (recommended):

-   JetBrainsMono Nerd Font
-   FiraCode Nerd Font
-   Hack Nerd Font

After installation:

-   Set your terminal font to the Nerd Font
-   Restart the terminal

Test:

```bash
echo "   "
```

If symbols look broken → font not set correctly.

## 4. Installing tmux Powerline

### Option 1: Git clone (recommended)

```bash
git clone https://github.com/erikw/tmux-powerline.git ~/.tmux-powerline
```

### Option 2: Using package manager (not always up to date)

```bash
pip install tmux-powerline
```

For beginners, **Git clone is safer**.

## 5. Basic tmux Integration

Edit your tmux config:

```bash
vim ~/.tmux.conf
```

Add:

```tmux
run-shell "~/.tmux-powerline/powerline.sh"
```

Reload tmux config:

```bash
tmux source-file ~/.tmux.conf
```

Or restart tmux:

```bash
tmux kill-server
tmux
```

If everything works, your status bar should change immediately.

## 6. How tmux Powerline Works (Concept)

tmux Powerline is built from **segments**.

```
[ segment ] [ segment ] [ segment ]
```

Each segment is a small Python script:

-   `hostname.py`
-   `datetime.py`
-   `cpu.py`
-   `git.py`

They are rendered **left → right**.

## 7. Configuration Structure

Main directory:

```
~/.tmux-powerline/
├── powerline.sh
├── config.py
├── segments/
└── themes/
```

User config (recommended):

```
~/.tmux-powerline/config.py
```

If it doesn’t exist:

```bash
cp ~/.tmux-powerline/config.py.default ~/.tmux-powerline/config.py
```

## 8. Editing the Status Bar Layout

Open:

```bash
vim ~/.tmux-powerline/config.py
```

### Left side example

```python
STATUS_LEFT = [
    'tmux_session',
    'hostname',
    'lan_ip',
]
```

### Right side example

```python
STATUS_RIGHT = [
    'cpu',
    'memory',
    'datetime',
]
```

Save and reload tmux.

## 9. Common Useful Segments

| Segment        | Description    |
| -------------- | -------------- |
| `tmux_session` | Session name   |
| `tmux_window`  | Window index   |
| `hostname`     | Host name      |
| `lan_ip`       | Local IP       |
| `cpu`          | CPU usage      |
| `memory`       | RAM usage      |
| `git`          | Git branch     |
| `datetime`     | Date & time    |
| `battery`      | Laptop battery |

Segments live in:

```
~/.tmux-powerline/segments/
```

------

## 10. Customizing Colors & Theme

Themes are stored in:

```
~/.tmux-powerline/themes/
```

Example:

```bash
ls ~/.tmux-powerline/themes/
```

Open a theme file:

```bash
vim ~/.tmux-powerline/themes/default.py
```

You can:

-   Change foreground / background colors
-   Change separator style
-   Adjust contrast

------

## 11. Performance Tips (Important)

Too many segments can slow tmux.

Good practice:

-   Avoid heavy segments (`weather`, `network`) on remote servers
-   Increase update interval

In `config.py`:

```python
STATUS_INTERVAL = 2   # seconds
```

------

## 12. Troubleshooting

### 12.1 Icons look broken

-   Nerd Font not installed or not selected

### 12.2 Status bar doesn’t appear

Check:

```bash
tmux show-options -g | grep status
```

Ensure:

```tmux
set -g status on
```

### 12.3 Python not found

Edit `powerline.sh` and confirm:

```bash
which python3
```

------

## 13. Minimal Beginner Setup (Recommended)

```python
STATUS_LEFT = [
    'tmux_session',
    'tmux_window',
]

STATUS_RIGHT = [
    'git',
    'datetime',
]
```

Clean, fast, and useful.

------

## 14. When Should You Use tmux Powerline?

Use it if:

-   You live in tmux
-   You want system info at a glance
-   You enjoy customizing your terminal

Avoid it if:

-   You want zero dependencies
-   You use tmux occasionally

------

## 15. What to Learn Next

-   tmux key bindings
-   tmux plugin manager (TPM)
-   Writing your own Powerline segment
-   Alternative: `tmux-powerline-ng`, `tmux-statusline`

------

If you want, I can:

-   Give a **copy-paste minimal config**
-   Explain **writing a custom segment**
-   Compare **tmux powerline vs Starship**
-   Optimize it for **macOS / Linux / SSH servers**

Just tell me 👍