# Zim (zimfw)

## 1. What Is Zim?

**Zim**, also called **zimfw**, is a **Zsh configuration framework and plugin manager**.

It is similar in purpose to **Oh My Zsh**, but with different goals:

-   ⚡ Faster startup
-   🧼 Cleaner design
-   🔧 Minimal and modular
-   🧠 Closer to “plain Zsh” philosophy

👉 If you want **control, speed, and simplicity**, Zim is a great choice.

## 2. Zim vs Oh My Zsh (Quick Overview)

| Feature            | Oh My Zsh              | Zim                 |
| ------------------ | ---------------------- | ------------------- |
| Startup speed      | Slower (many defaults) | Faster              |
| Philosophy         | “Batteries included”   | Minimal & modular   |
| Plugin loading     | Git-based              | Git + smart caching |
| Config style       | Opinionated            | Transparent         |
| Good for beginners | ✅                      | ✅ (with less magic) |

## 3. Prerequisites

Before installing Zim, make sure:

-   ✅ Zsh is installed
-   ✅ Zsh is your default shell

Check:

```sh
zsh --version
echo $SHELL
```

You should see `/bin/zsh`.

## 4. Installing Zim

### One-line Install (Recommended)

Run:

```sh
curl -fsSL https://raw.githubusercontent.com/zimfw/install/master/install.zsh | zsh
```

What this does:

-   Installs `zimfw`
-   Creates default config files
-   Sets up a basic module list

After installation, restart your terminal.

## 5. Important Files Created by Zim

After installation, you’ll see these files:

| File           | Purpose                              |
| -------------- | ------------------------------------ |
| `~/.zshrc`     | Main Zsh config                      |
| **`~/.zimrc`** | **Zim module list (very important)** |
| `~/.zshenv`    | Environment variables                |
| `~/.zim/`      | Zim modules directory                |

📌 **You mainly edit `~/.zimrc` and `~/.zshrc`**

## 6. Understanding `.zimrc`

`.zimrc` defines **which modules (plugins) are loaded**.

Open it:

```sh
vim ~/.zimrc
```

Example default content:

```sh
zmodule environment
zmodule git
zmodule utility
zmodule completion
zmodule prompt-pwd
```

Each `zmodule` line loads **one module**.

## 7. Installing and Updating Modules

### 7.1 Install / Update All Modules

After editing `.zimrc`, run:

```sh
zimfw install
```

To update modules later:

```sh
zimfw update
```

To recompile for speed:

```sh
zimfw compile
```

## 8. Commonly Used Zim Modules

### 8.1 Git Module

```sh
zmodule git
```

Provides:

-   Git aliases
-   Git-aware completion
-   Branch info for prompts

------

### 8.2 Completion Module (Highly Recommended)

```sh
zmodule completion
```

Adds:

-   Smart tab completion
-   Menu selection
-   Case-insensitive matching

------

### 8.3 Utility Module

```sh
zmodule utility
```

Adds useful Zsh helpers like:

-   Directory stack helpers
-   Safer defaults

------

### 8.4 Autosuggestions

```sh
zmodule zsh-users/zsh-autosuggestions
```

Shows gray suggestions from history as you type.

------

### 8.5 Syntax Highlighting

```sh
zmodule zsh-users/zsh-syntax-highlighting
```

-   Commands turn green if valid
-   Errors turn red

⚠️ This module **must be last** in `.zimrc`.

## 9. Example Beginner `.zimrc`

```sh
zmodule environment
zmodule git
zmodule utility
zmodule completion

zmodule zsh-users/zsh-autosuggestions
zmodule zsh-users/zsh-syntax-highlighting
```

Then run:

```sh
zimfw install
zimfw compile
```

Restart your terminal.

------

## 10. Prompt in Zim

Zim includes simple prompts, but you can also use **external prompts**.

### Built-in Prompt Example

```sh
zmodule prompt-pwd
```

### Using Starship (Optional)

Install Starship:

```sh
brew install starship
```

Add to `.zshrc`:

```sh
eval "$(starship init zsh)"
```

Zim works very well with Starship.

## 11. Where to Put Aliases and Variables

### Aliases → `.zshrc`

```sh
alias ll="ls -lah"
alias gs="git status"
```

### Environment Variables → `.zshenv`

```sh
export EDITOR=vim
export LANG=en_US.UTF-8
```

## 12. Reload Configuration

After changes:

```sh
source ~/.zshrc
```

or restart the terminal.

## 13. Zim Command Cheatsheet

| Command           | Meaning          |
| ----------------- | ---------------- |
| `zimfw install`   | Install modules  |
| `zimfw update`    | Update modules   |
| `zimfw compile`   | Speed up startup |
| `zimfw uninstall` | Remove Zim       |
| `zimfw help`      | Show help        |

------

## 14. Common Beginner Mistakes

❌ Editing `.zshrc` instead of `.zimrc` for modules
❌ Forgetting `zimfw install` after changing `.zimrc`
❌ Putting syntax highlighting in the middle (must be last)
❌ Installing too many modules unnecessarily

------

## 15. Why Choose Zim?

Zim is ideal if you want:

-   🚀 Fast shell startup
-   🧩 Modular plugin control
-   🧠 Less hidden magic
-   🔧 Zsh-first experience

It scales well from **beginner → advanced user**.

------

## 16. What to Learn Next

-   Zsh keybindings
-   Writing your own Zsh functions
-   Advanced completion styles
-   Starship prompt customization
-   Profiling Zsh startup time

------

## Summary

-   **Zim = lightweight Zsh framework**
-   Modules are managed in `.zimrc`
-   Simple workflow:
    1.  Edit `.zimrc`
    2.  Run `zimfw install`
    3.  Restart shell
-   Fast, clean, and powerful
