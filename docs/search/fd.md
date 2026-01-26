---
status: done
---

# fd

*A faster, simpler replacement for `find`*

## 1. What is `fd`?

**`fd`** is a command-line tool for **finding files and directories**.

Think of it as:

>   **`find`, but human-friendly**

`fd` is designed with **sane defaults**, clear syntax, and excellent performance.

## 2. Why use `fd`?

Compared to `find`, `fd`:

-   ⚡ Is **much faster**
-   ✨ Has **simple syntax**
-   🧠 Uses **smart defaults**
-   🚫 Respects `.gitignore`
-   🎨 Has colored output
-   🦀 Written in **Rust**

## 3. Installing `fd`

### macOS (Homebrew)

```bash
brew install fd
```

>   On macOS, the binary is usually named `fd`.

### Linux

```bash
sudo apt install fd-find
```

On some distros, use:

```bash
fdisk --version
```

Then create an alias:

```bash
alias fd=fdfind
```

## 4. Basic usage

### 4.1 Find files by name

```bash
fd main
```

Finds all files and directories with `main` in the name.

### 4.2 Find only files

```bash
fd -t f main
```

### Find only directories

```bash
fd -t d src
```

### 4.3 Search in a specific directory

```bash
fd main src/
```

## 5. Pattern matching (very important)

By default, `fd` uses **regular expressions**.

### Simple substring match

```bash
fd test
```

Matches:

```
test.c
my_test_file.txt
```

### Exact match

```bash
fd '^main$'
```

### File extension

```bash
fd '\.c$'
```

## 6. Case sensitivity

-   Case-sensitive by default

### Case-insensitive search

```bash
fd -i readme
```

## 7. Ignore rules

By default, `fd` ignores:

-   `.gitignore`
-   `.ignore`
-   `.fdignore`
-   Hidden files

### Include hidden files

```bash
fd -H config
```

### Ignore `.gitignore`

```bash
fd -I main
```

## 8. Excluding paths

### Exclude a directory

```bash
fd main -E target
```

### Exclude multiple paths

```bash
fd main -E node_modules -E .git
```

## 9. Run commands on results (`-x`)

One of the most powerful features.

### Example: delete matched files

```bash
fd '\.tmp$' -x rm
```

### Format:

```bash
fd PATTERN -x command {}
```

### Example: open files in editor

```bash
fd '\.c$' -x vim
```

## 10. Combine `fd` with `rg`

Find files first, then search inside them:

```bash
fd '\.c$' | xargs rg malloc
```

## 11. Limit search depth

### Search only current directory

```bash
fd main -d 1
```

## 12. Show full paths

```bash
fd main -p
```

## 13. fd vs find (quick comparison)

| Feature            | fd   | find |
| ------------------ | ---- | ---- |
| Simple syntax      | ✅    | ❌    |
| Fast               | ⚡    | 🐢    |
| `.gitignore` aware | ✅    | ❌    |
| Colored output     | ✅    | ❌    |

## 14. Common beginner mistakes

### ❌ Using `*`

```bash
fd *.c   # ❌
```

### ✅ Correct

```bash
fd '\.c$'
```

### ❌ Expecting glob behavior

Remember: **regex, not glob**.

## 15. Typical workflow examples

```bash
fd readme
fd '\.md$'
fd -t d src
fd test -E build
fd '\.log$' -x rm
```

## 16. Summary

**`fd`** gives you:

-   Faster file searches
-   Cleaner syntax
-   Safer defaults
-   Less typing

Once you try it, going back to `find` feels painful.

## 17. Recommended tool combo

| Task               | Tool      |
| ------------------ | --------- |
| Jump directories   | `zoxide`  |
| Find files         | `fd`      |
| Search content     | `ripgrep` |
| Interactive filter | `fzf`     |

A modern terminal stack 🚀

