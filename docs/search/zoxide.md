---
status: done
---

# Zoxide

*A smarter `cd` command*

-   `z`
-   `zi`

## 1. What is zoxide?

**zoxide** is a modern replacement for the `cd` command.

It **learns** which directories you use the most and lets you jump to them **instantly**—without typing long paths.

### Traditional `cd`

```bash
cd ~/Documents/projects/my-awesome-project/src
```

### With zoxide

```bash
z my-awesome
```

That’s it.

## 2. Why use zoxide?

zoxide is useful because it:

-   🧠 **Learns automatically** from your directory usage
-   ⚡ **Saves keystrokes** (jump with partial names)
-   🔍 Uses **frecency** (frequency + recency)
-   🐚 Works with **zsh, bash, fish, nushell**
-   🛠️ Is fast and written in **Rust**

If you frequently `cd` around your system, zoxide is a **huge productivity boost**.

## 3. Installing zoxide

### macOS (Homebrew)

```bash
brew install zoxide
```

### Linux (most distros)

```bash
sudo apt install zoxide
```

or via cargo:

```bash
cargo install zoxide
```

### Verify installation

```bash
zoxide --version
```

## 4. Enable zoxide in your shell

zoxide needs a **small shell hook** to work.

### For zsh (most common on macOS)

Add this to `~/.zshrc`:

```bash
eval "$(zoxide init zsh)"
```

Then reload:

```bash
source ~/.zshrc
```

### For bash

Add to `~/.bashrc`:

```bash
eval "$(zoxide init bash)"
```

### For fish

```bash
zoxide init fish | source
```

## 5. Basic usage

### 5.1 Jump to a directory

```bash
z project
```

zoxide searches your directory history and jumps to the **best match**.

Example:

```bash
z code
z downloads
z dotfiles
```

### 5.2 Partial matching (very powerful)

```bash
z my
```

If you’ve visited:

```
~/my-project
~/my-notes
```

zoxide picks the one you use most often.

### 5.3 Multiple keywords

```bash
z work backend
```

Matches directories containing **both words**.

## 6. How does zoxide learn?

zoxide automatically records directories when you:

-   `cd` into them
-   Use `z` to jump

It does **not** scan your filesystem.
It only learns from **your behavior**.

Over time, it becomes more accurate.

## 7. Useful commands

### List known directories

```bash
zoxide query -l
```

### Show match score

```bash
zoxide query my-project
```

### Jump using interactive selection (fzf)

If you have `fzf` installed:

```bash
zi
```

You get a searchable list of all known directories.

## 8. Replace `cd` completely (optional)

If you want zoxide to feel *native*:

### zsh alias

```bash
alias cd="z"
```

Now every `cd` becomes smart automatically.

⚠️ Optional, but many users love it.

## 9. Common beginner questions

### ❓ Is zoxide safe?

Yes.

-   No background daemon
-   No network access
-   Stores a small local database

### ❓ Where is the data stored?

Usually in:

```
~/.local/share/zoxide/
```

### ❓ Does it slow down the shell?

No.
zoxide is extremely fast.

## 10. Typical workflow example

```bash
cd ~/Documents/projects/website
cd src
cd components
```

Later…

```bash
z website
z components
```

No long paths. No thinking.

## 11. zoxide vs autojump

| Feature     | zoxide | autojump |
| ----------- | ------ | -------- |
| Language    | Rust   | Python   |
| Speed       | ⚡ Fast | Slower   |
| Matching    | Better | Basic    |
| Maintenance | Active | Less     |

zoxide is generally considered the **modern successor**.

## 12. Summary

**zoxide gives you:**

-   Faster navigation
-   Less typing
-   Smarter jumps
-   Zero configuration after setup

If you use the terminal daily, **zoxide is a must-have tool**.

