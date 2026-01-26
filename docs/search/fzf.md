# fzf

## 1. What is fzf?

**fzf** is a **command-line fuzzy finder**.

It lets you:

-   Search files, directories, command history, git commits, etc.
-   Type **partial keywords** instead of exact matches
-   Interactively select items in a **fast, keyboard-driven UI**

Think of it as:

>   “Ctrl + F for your terminal, but much smarter.”

## 2. What “Fuzzy” Means

Traditional search:

```
README
```

fzf fuzzy search:

```
rdm
```

fzf will still match:

```
README.md
```

Because it matches **characters in order**, not strictly contiguous.

## 3. Installing fzf

### macOS (recommended)

```bash
brew install fzf
```

Then enable key bindings:

```bash
$(brew --prefix)/opt/fzf/install
```

>   Choose **yes** for shell key bindings and completion.

### Linux

```bash
sudo apt install fzf
```

or

```bash
sudo pacman -S fzf
```

### Check installation

```bash
fzf --version
```

## 4. Your First fzf Command

### Basic usage

```bash
ls | fzf
```

What happens:

1.  `ls` outputs filenames
2.  `fzf` displays them in an interactive list
3.  You type → list filters instantly
4.  Press **Enter** → selected item is printed

## 5. Basic fzf Interface

When fzf opens:

| Key            | Action         |
| -------------- | -------------- |
| Type           | Fuzzy filter   |
| ↑ / ↓          | Move selection |
| Ctrl + j / k   | Move selection |
| Enter          | Confirm        |
| Esc / Ctrl + c | Exit           |

## 6. Useful Built-in Key Bindings (VERY IMPORTANT)

After installation, fzf integrates deeply with your shell.

### Ctrl + T — File picker

```bash
vim <Ctrl+t>
```

Select a file → it is inserted into the command line.

### Ctrl + R — Command history search

```bash
<Ctrl+r>
```

Search your **shell history interactively**.

This alone makes fzf worth installing.

### Alt + C — Directory jump

```bash
<Alt+c>
```

Quickly jump to any directory.

## 7. Common Practical Examples

### Open a file with vim

```bash
vim $(fzf)
```

### cd into a directory

```bash
cd $(find . -type d | fzf)
```

------

### Kill a process

```bash
ps aux | fzf | awk '{print $2}' | xargs kill
```

------

### Git branch switch

```bash
git branch | fzf | xargs git checkout
```

## 8. Preview Window (Game Changer)

fzf can show a **preview pane**.

### Preview files

```bash
fzf --preview 'cat {}'
```

### Preview directories

```bash
fzf --preview 'ls {}'
```

### Syntax-highlight preview (if you have `bat`)

```bash
fzf --preview 'bat --style=numbers --color=always {}'
```

------

## 9. Search Inside Files (ripgrep + fzf)

Install ripgrep:

```bash
brew install ripgrep
```

Search file contents:

```bash
rg --line-number "" | fzf
```

Advanced:

```bash
rg "" --line-number | fzf --preview 'sed -n {1}p {2}'
```

------

## 10. fzf with Git (Very Common)

### Search git commits

```bash
git log --oneline | fzf
```

### Search changed files

```bash
git status --short | fzf
```

------

## 11. Environment Variables (Simple Customization)

Example:

```bash
export FZF_DEFAULT_OPTS="--height=40% --layout=reverse --border"
```

Common options:

-   `--height=40%` → floating window
-   `--layout=reverse` → prompt at bottom
-   `--border` → nicer UI

------

## 12. fzf Completion

After installation, fzf replaces default shell completion.

Example:

```bash
ssh <Tab>
```

You’ll get an interactive fzf menu.

Works with:

-   `cd`
-   `ssh`
-   `kill`
-   `git checkout`
-   many more

------

## 13. When Should You Use fzf?

Use fzf when:

-   You have **too many files**
-   You forget exact names
-   You want speed without mouse
-   You live in the terminal (Git, SSH, Docker, logs)

------

## 14. fzf vs grep vs find

| Tool | Best for                  |
| ---- | ------------------------- |
| grep | Scriptable text search    |
| find | File system queries       |
| fzf  | **Interactive selection** |

fzf does not replace them — it **enhances them**.

## 15. Minimal Daily Workflow Example

```bash
vim $(fzf)
cd $(find . -type d | fzf)
git checkout $(git branch | fzf)
history | fzf
```

------

## 16. Summary

-   fzf is a **fuzzy interactive selector**
-   Works with **stdin / stdout**
-   Integrates deeply with your shell
-   Key bindings: **Ctrl-T, Ctrl-R, Alt-C**
-   Becomes addictive very quickly 😄

