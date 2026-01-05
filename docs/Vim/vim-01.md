# Vim-01: Intro

## 1. What is Vim?

**Vim** (Vi IMproved) is a **modal text editor** widely used on Linux, macOS, servers, and via SSH.

Why people use Vim:

-   Extremely fast once learned
-   Works everywhere (even without GUI)
-   Keyboard-driven (no mouse required)
-   Ideal for programming and system administration

>   ⚠️ Vim has a learning curve because it uses **modes**.

------

## 2. Installing Vim

### macOS

```bash
brew install vim
```

### Ubuntu / Debian

```bash
sudo apt install vim
```

### CentOS / RHEL

```bash
sudo yum install vim
```

### Windows

-   Install **Vim for Windows**
-   Or use Vim inside **WSL / PowerShell**

------

## 3. Start Vim

```bash
vim filename.txt
```

If the file doesn’t exist, Vim will create it.

------

## 4. Vim Modes (MOST IMPORTANT)

Vim works with **modes**:

| Mode        | Purpose                     |
| ----------- | --------------------------- |
| **Normal**  | Navigation & commands       |
| **Insert**  | Typing text                 |
| **Visual**  | Selecting text              |
| **Command** | Saving, quitting, searching |

You always start in **Normal mode**.

### Switch Modes

| Key   | Action         |
| ----- | -------------- |
| `i`   | Insert mode    |
| `Esc` | Back to Normal |
| `v`   | Visual mode    |
| `:`   | Command mode   |

------

## 5. Insert Mode (Typing Text)

In **Normal mode**, press:

```text
i
```

Now you can type like a normal editor.

To exit Insert mode:

```text
Esc
```

------

## 6. Move the Cursor (Normal Mode)

### Basic Movement

```
h  left
j  down
k  up
l  right
```

### Faster Movement

| Key  | Meaning        |          |
| ---- | -------------- | -------- |
| `w`  | next word      | **w**ord |
| `b`  | previous word  | **b**ack |
| `0`  | start of line  |          |
| `$`  | end of line    |          |
| `gg` | top of file    | **g**o   |
| `G`  | bottom of file | **G**o   |
| `:n` | go to line n   |          |

Example:

```text
:42
```

------

## 7. Save & Quit (Command Mode)

Press `Esc` first.

| Command | Meaning             |
| ------- | ------------------- |
| `:w`    | save                |
| `:q`    | quit                |
| `:wq`   | save & quit         |
| `:q!`   | quit without saving |

------

## 8. Editing Text

### Delete

| Command | Action           |
| ------- | ---------------- |
| `x`     | delete character |
| `dd`    | delete line      |
| `dw`    | delete word      |

### Copy & Paste

| Command | Action      |
| ------- | ----------- |
| `yy`    | copy line   |
| `p`     | paste below |
| `P`     | paste above |

### Undo / Redo

| Command    | Action |
| ---------- | ------ |
| `u`        | undo   |
| `Ctrl + r` | redo   |

------

## 9. Visual Mode (Select Text)

Press:

```text
v
```

Then move cursor to select text.

Useful commands:

| Key  | Action           |
| ---- | ---------------- |
| `y`  | copy selection   |
| `d`  | delete selection |

------

## 10. Search & Replace

### Search

```text
/word
```

-   `n` → next match
-   `N` → previous match

### Replace

```text
:%s/old/new/g
```

Replace only current line:

```text
:s/old/new/
```

------

## 11. Open Multiple Files

```bash
vim file1 file2
```

Switch files:

```text
:next
:prev
```

------

## 12. Split Windows

### Horizontal

```text
:split
```

### Vertical

```text
:vsplit
```

Move between splits:

```
Ctrl + w + h/j/k/l
```

------

## 13. Useful Settings (Beginner Friendly)

Edit config:

```bash
vim ~/.vimrc
```

Add:

```vim
set number
set relativenumber
set tabstop=4
set shiftwidth=4
set expandtab
set mouse=a
syntax on
```

Reload:

```text
:source ~/.vimrc
```

------

## 14. Learn Vim the Right Way

### Built-in Tutorial (HIGHLY RECOMMENDED)

```bash
vimtutor
```

30 minutes → huge improvement.

### Practice Tips

-   Don’t use arrow keys
-   Always return to **Normal mode**
-   Think in *actions*, not typing

------

## 15. Common Beginner Mistakes

❌ Forgetting to press `Esc`
❌ Using arrow keys
❌ Trying to learn everything at once
❌ Panic when stuck (use `:q!` 😄)

------

## 16. Minimal Cheat Sheet

```
i        insert
Esc      normal mode
:wq      save & quit
dd       delete line
yy       copy line
p        paste
/word    search
u        undo
```

------

## 17. When Should You Use Vim?

Perfect for:

-   SSH / servers
-   Config files
-   Programming
-   Low-resource environments