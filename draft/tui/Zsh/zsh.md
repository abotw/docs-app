---
author: gpt
status: done
---

# Zsh

## 1. What is Zsh?

**Zsh (Z shell)** is a powerful command-line shell, similar to `bash`, but with **more features, better usability, and strong customization support**.

You can think of it as:

-   Bash **plus** smarter completion
-   Better history and globbing
-   Easier customization

💡 On **macOS**, Zsh is the **default shell** since macOS **Catalina**.

## 2. Why Use Zsh?

Compared with `bash`, Zsh offers:

-   ✅ Smarter **tab completion**
-   ✅ Powerful **command history**
-   ✅ Flexible **themes & prompts**
-   ✅ Plugin system (via frameworks like **Oh My Zsh**)
-   ✅ Better **globbing** (file matching)

If you spend time in the terminal, Zsh saves you time every day.

## 3. Check If You Are Using Zsh

Run this command:

```sh
echo $SHELL
```

If you see:

```text
/bin/zsh
```

🎉 You’re already using Zsh.

To check the version:

```sh
zsh --version
```

## 4. Installing Zsh

### On macOS

Zsh is already installed.

If not (rare):

```sh
brew install zsh
```

### On Ubuntu / Debian

```sh
sudo apt update
sudo apt install zsh
```

### On Arch Linux

```sh
sudo pacman -S zsh
```

## 5. Make Zsh Your Default Shell

If Zsh is installed but not default:

```sh
chsh -s $(which zsh)
```

Log out and log back in to apply the change.

## 6. Zsh Configuration Files (Important!)

Zsh is configured mainly through:

| File              | Purpose                           |
| ----------------- | --------------------------------- |
| `~/.zshrc`        | Main config file (most important) |
| **`~/.zprofile`** | **Login shell config**            |
| **`~/.zshenv`**   | **Environment variables**         |
| `~/.zlogin`       | Rarely used                       |

👉 **Beginners mainly edit `~/.zshrc`**

Open it with:

```sh
nano ~/.zshrc
# or
vim ~/.zshrc
```

## 7. Basic Zsh Features You’ll Love

### 7.1 Powerful Tab Completion

Try typing:

```sh
ls /u
```

Press **Tab**, Zsh will complete:

```sh
ls /usr/
```

It also works for:

-   Commands
-   Options
-   Git branches
-   Paths

### 7.2 Command History Search

Press:

```text
Ctrl + R
```

Then type part of a command you used before.
Zsh searches history **interactively**.

Example:

```text
(reverse-i-search)`git': git status
```

Press Enter to run it.

### 7.3 Better History Behavior

Zsh can:

-   Share history across terminals
-   Avoid duplicate commands
-   Save timestamps

Example `.zshrc` settings:

```sh
HISTSIZE=10000
SAVEHIST=10000
setopt SHARE_HISTORY
setopt HIST_IGNORE_ALL_DUPS
```

## 8. Globbing (File Matching) in Zsh

Zsh has **very powerful globbing**.

### Example 1: List all `.txt` files recursively

```sh
ls **/*.txt
```

### Example 2: Exclude files

```sh
ls *.js~test.js
```

This is much more powerful than Bash.

## 9. Aliases (Shortcuts)

Aliases let you create shortcuts for long commands.

Example:

```sh
alias ll="ls -lah"
alias gs="git status"
alias gp="git pull"
```

Put them in `~/.zshrc`, then reload:

```sh
source ~/.zshrc
```

## 10. Environment Variables

Set variables in `.zshrc`:

```sh
export EDITOR=vim
export LANG=en_US.UTF-8
```

Check a variable:

```sh
echo $EDITOR
```

## 11. Prompt (What You See Before Typing)

Example prompt:

```text
name@hostname ~/projects %
```

Zsh prompts are **highly customizable**.

Simple example:

```sh
PROMPT='%n@%m %~ %# '
```

-   `%n` → username
-   `%m` → hostname
-   `%~` → current directory
-   `%#` → prompt symbol

## 12. Oh My Zsh (Optional but Popular)

**Oh My Zsh** is a Zsh configuration framework.

It provides:

-   Themes
-   Plugins
-   Sensible defaults

Install with:

```sh
sh -c "$(curl -fsSL https://raw.githubusercontent.com/ohmyzsh/ohmyzsh/master/tools/install.sh)"
```

📌 After installing:

-   Config file is still `~/.zshrc`
-   You can enable plugins like `git`, `z`, `sudo`

Example:

```sh
plugins=(git z sudo)
```

## 13. Useful Built-in Zsh Plugins (Oh My Zsh)

| Plugin              | What it does                    |
| ------------------- | ------------------------------- |
| `git`               | Git aliases & completion        |
| `z`                 | Jump to frequently used dirs    |
| `sudo`              | Press `Esc` twice to add `sudo` |
| `colored-man-pages` | Colorized man pages             |

## 14. Reload Zsh Config

After editing `.zshrc`:

```sh
source ~/.zshrc
```

Or restart the terminal.

## 15. Common Beginner Mistakes

❌ Editing `.bashrc` instead of `.zshrc`

❌ Forgetting to `source ~/.zshrc`

❌ Installing too many plugins (slows startup)

❌ Copy-pasting configs without understanding them

## 16. Zsh vs Bash (Quick Comparison)

| Feature          | Bash    | Zsh             |
| ---------------- | ------- | --------------- |
| Default on macOS | ❌       | ✅               |
| Completion       | Basic   | Advanced        |
| Globbing         | Limited | Powerful        |
| Customization    | Medium  | Excellent       |
| Learning curve   | Easy    | Easy → Powerful |

## 17. What to Learn Next

Once you’re comfortable:

-   🔹 Zsh keybindings
-   🔹 Advanced globbing
-   🔹 Custom functions
-   🔹 Starship prompt
-   🔹 Zsh autosuggestions & syntax highlighting

## Summary

-   Zsh is a **modern, powerful shell**
-   It’s beginner-friendly but scales well
-   Start with:
    -   `.zshrc`
    -   Aliases
    -   Completion
-   Add Oh My Zsh only if you want convenience
