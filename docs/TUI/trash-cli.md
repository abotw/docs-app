# trash-cli

A Safe “Trash Bin” for the Command Line

## 1. What is `trash-cli`?

`trash-cli` is a command-line tool that **moves files to the system Trash instead of deleting them permanently**.

Think of it as:

-   `rm` → **delete forever**
-   `trash-put` → **move to Trash (recoverable)**

It follows the **FreeDesktop.org Trash specification**, which means:

-   Files are moved to the same Trash used by your desktop environment
-   You can restore them later

If you’ve ever typed `rm -rf` and immediately regretted it…
`trash-cli` is for you.

## 2. Why use `trash-cli` instead of `rm`?

### Problems with `rm`

-   ❌ Permanent deletion
-   ❌ No undo
-   ❌ Easy to make fatal mistakes

### Advantages of `trash-cli`

-   ✅ Safe: files go to Trash
-   ✅ Recoverable
-   ✅ Works in scripts and terminal workflows
-   ✅ Familiar commands

**Rule of thumb**

>   Use `rm` only when you are *absolutely sure*.
>   Use `trash-cli` for everyday work.

## 3. Installation

### macOS (Homebrew)

```bash
brew install trash
```

### Debian / Ubuntu

```bash
sudo apt install trash-cli
```

### Arch Linux

```bash
sudo pacman -S trash-cli
```

### Python (pip)

```bash
pip install trash-cli
```

Verify:

```bash
trash-put --version
```

## 4. Core Commands Overview

| Command         | Purpose                         |
| --------------- | ------------------------------- |
| `trash-put`     | Move files/directories to Trash |
| `trash-list`    | List items in Trash             |
| `trash-restore` | Restore items from Trash        |
| `trash-rm`      | Permanently delete from Trash   |
| `trash-empty`   | Empty the Trash                 |

## 5. Move Files to Trash

### Delete a file (safely)

```bash
trash-put file.txt
```

### Delete multiple files

```bash
trash-put a.txt b.txt c.txt
```

### Delete a directory

```bash
trash-put my_folder
```

>   Unlike `rm`, **no `-r` is required**.

## 6. List Trash Contents

```bash
trash-list
```

Example output:

```text
2026-01-25 10:12:44 /home/user/docs/notes.txt
2026-01-25 10:15:02 /home/user/tmp/test
```

You see:

-   Deletion time
-   Original path

This makes recovery much easier.

## 7. Restore Files from Trash

### Restore interactively

```bash
trash-restore
```

You’ll see a numbered list:

```text
0 /home/user/docs/notes.txt
1 /home/user/tmp/test
```

Enter the number to restore.

### Restore to original location

By default, files return to their **original path**.

## 8. Permanently Delete (Careful!)

### Remove a specific trashed item

```bash
trash-rm
```

Interactive selection again — safer than guessing.

### Empty the entire Trash

```bash
trash-empty
```

Empty Trash older than 7 days:

```bash
trash-empty 7
```

## 9. Replacing `rm` with `trash-put` (Recommended)

### Create a safer alias

Add this to your shell config (`~/.zshrc` or `~/.bashrc`):

```bash
alias rm='trash-put'
```

Reload:

```bash
source ~/.zshrc
```

Now:

```bash
rm file.txt
```

👉 goes to Trash instead of permanent deletion.

### Still need real `rm`?

Use:

```bash
\rm file.txt
```

## 10. Using `trash-cli` in Scripts

Example:

```bash
for f in *.log; do
  trash-put "$f"
done
```

Benefits:

-   No accidental data loss
-   Easy recovery if script logic is wrong

## 11. Where Are Trashed Files Stored?

On Linux:

```text
~/.local/share/Trash/
```

Structure:

```text
Trash/
├── files/
├── info/
```

You normally **should not touch this manually**.

## 12. Common Pitfalls

### ❌ “It didn’t free disk space!”

-   Trashed files still occupy space
-   Use `trash-empty` to free it

### ❌ “I deleted something on another disk”

-   Trash is **per filesystem**
-   External drives have their own Trash

### ❌ “Name conflict on restore”

-   If a file already exists at the original path, restore may fail
-   Move or rename first

## 13. When NOT to Use `trash-cli`

-   System cleanup scripts (`/tmp`, build artifacts)
-   Containers or minimal servers (no Trash spec)
-   When you truly want **irreversible deletion**

In those cases, use:

```bash
rm -rf
```

—but double check.

## 14. Summary

-   `trash-cli` = **undoable deletion in the terminal**
-   Ideal replacement for everyday `rm`
-   Simple commands, big safety improvement

**Best practice**

>   Alias `rm` → `trash-put`,
>   and sleep better at night 😌