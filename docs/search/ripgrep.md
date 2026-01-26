---
status: done
---

# Ripgrep (`rg`)

*A fast, modern replacement for `grep`*

## 1. What is ripgrep?

**ripgrep** (command: `rg`) is a search tool that lets you **search text inside files**.

Think of it as:

>   **`grep`, but much faster and smarter**

It is especially popular among developers because it:

-   Is extremely **fast**
-   Respects `.gitignore` automatically
-   Has simple, intuitive syntax

## 2. Why use ripgrep?

Compared to traditional `grep`, ripgrep:

-   ⚡ Searches **very fast** (written in Rust)
-   🚫 Automatically ignores `.gitignore` files
-   📁 Searches directories **recursively by default**
-   🧠 Has sane defaults (no extra flags needed)
-   🛠️ Works well with editors (VS Code, Neovim, etc.)

## 3. Installing ripgrep

### macOS (Homebrew)

```bash
brew install ripgrep
```

### Linux

```bash
sudo apt install ripgrep
```

### Verify installation

```bash
rg --version
```

## 4. Basic usage

### 4.1 Search for a word in the current directory

```bash
rg main
```

This:

-   Searches **all files**
-   Recursively
-   Skips ignored files (`.gitignore`, `.ignore`)

### 4.2 Search in a specific directory

```bash
rg main src/
```

### 4.3 Search in a specific file

```bash
rg main main.c
```

## 5. Understanding the output

Example:

```bash
src/main.c
12:int main() {
```

Meaning:

```
[file path]
[line number]:[matched line]
```

Matches are **highlighted** automatically.

## 6. Case sensitivity

### Case-sensitive (default)

```bash
rg Hello
```

### Case-insensitive

```bash
rg -i hello
```

## 7. Search using regular expressions

ripgrep supports **regex by default**.

### Example: match `foo` or `bar`

```bash
rg "foo|bar"
```

### Match numbers

```bash
rg "\d+"
```

(No `-E` needed!)

## 8. Search only certain file types

### By file extension

```bash
rg main -g "*.c"
```

### Exclude files

```bash
rg main -g "!*.test.js"
```

## 9. Search hidden files

By default, hidden files are ignored.

### Include hidden files

```bash
rg --hidden
```

### Ignore `.gitignore`

```bash
rg --no-ignore
```

## 10. Show only file names

### Files that contain matches

```bash
rg -l main
```

### Files that do NOT contain matches

```bash
rg -L main
```

## 11. Count matches

### Count matching lines per file

```bash
rg -c main
```

### Count total matches

```bash
rg -c main | awk -F: '{sum+=$2} END {print sum}'
```

## 12. Preview matches interactively (with fzf)

If you have `fzf` installed:

```bash
rg main | fzf
```

Or with preview:

```bash
rg main --line-number | fzf --preview 'bat --highlight-line {2} {1}'
```

## 13. Common beginner mistakes

### ❌ Using `rg *`

ripgrep **does not need `\*`**.

✅ Correct:

```bash
rg keyword
```

### ❌ Forgetting regex behavior

`.` means “any character”.

To search literal dots:

```bash
rg "\."
```

## 14. ripgrep vs grep (quick comparison)

| Feature              | rg   | grep |
| -------------------- | ---- | ---- |
| Recursive by default | ✅    | ❌    |
| `.gitignore` aware   | ✅    | ❌    |
| Speed                | ⚡    | 🐢    |
| Regex by default     | ✅    | ❌    |

## 15. When should you use ripgrep?

Use `rg` when you want to:

-   Search codebases
-   Find functions, variables, strings
-   Replace `grep -R`
-   Work fast in the terminal

## 16. Typical workflow example

```bash
rg malloc
rg TODO
rg "error|fail"
rg main src/
```

Fast. Simple. Powerful.

## 17. Summary

**ripgrep (`rg`)** is:

-   Fast
-   Simple
-   Powerful
-   Developer-friendly

If you work with text or code, it’s one of the **most useful CLI tools** you can learn.