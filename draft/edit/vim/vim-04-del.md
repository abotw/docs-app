---
status: done
---

# Vim: Delete

Deleting text in Vim is fast and powerful once you understand **motions + operators**.

In Vim, **delete is not just “remove”** — it usually **cuts** text into a register, so you can paste it later.

## 1. The Core Idea: `operator + motion`

In Vim:

```
d  +  motion
```

-   `d` → delete (cut) operator
-   `motion` → how far / what to delete

Examples:

-   `dw` → delete a word
    -   `w` - **w**ord
-   `d$` → delete to end of line
    -   `$` - end of line
-   `d}` → delete to next paragraph

This pattern is the key to Vim mastery.

## 2. Basic Delete Commands (Most Used)

### Delete a character

| Command | Meaning                        |
| ------- | ------------------------------ |
| `x`     | delete character under cursor  |
| `X`     | delete character before cursor |

### Delete words

| Command | Meaning                       |
| ------- | ----------------------------- |
| `dw`    | delete word (from cursor)     |
| `de`    | delete to **e**nd of word     |
| `db`    | delete **b**ackward word      |
| `dW`    | delete WORD (space-separated) |

### Delete lines

| Command | Meaning                           |
| ------- | --------------------------------- |
| `dd`    | delete current line               |
| `2dd`   | delete 2 lines                    |
| `D`     | delete from cursor to end of line |
| `d$`    | same as `D`                       |

>   💡 `dd` is one of the most frequently used Vim commands.

## 3. Delete with Motions (Powerful)

| Command  | Meaning                       |
| -------- | ----------------------------- |
| `d0`     | delete to beginning of line   |
| `d^`     | delete to first **non-blank** |
| `d$`     | delete to end of **line**     |
| `dG`     | delete to end of **file**     |
| `dgg`    | delete to beginning of file   |
| `d}`     | delete paragraph              |
| `d/word` | delete until “word”           |

## 4. Delete Inside / Around Text Objects

Text objects make Vim extremely precise.

### Syntax

```
d + (i / a) + object
```

| Command | Meaning                      |
| ------- | ---------------------------- |
| `diw`   | delete inside word           |
| `daw`   | delete a word (with space)   |
| `di"`   | delete inside quotes         |
| `da"`   | delete quotes + content      |
| `di(`   | delete inside parentheses    |
| `da(`   | delete parentheses + content |
| `dit`   | delete inside HTML **t**ag   |

Example:

```html
<p>Hello world</p>
```

Cursor on `Hello`:

-   `dit` → leaves `<p></p>`
-   `dat` → removes the entire `<p>...</p>`

## 5. Visual Mode Deletion

1.  Enter visual mode:
    -   `v` → character
    -   `V` → line
    -   `Ctrl + v` → block
2.  Select text
3.  Press `d`

This is intuitive and beginner-friendly.

## 6. Delete Without Copying (Black Hole Register)

By default, delete **yanks** text.
If you want to delete **without affecting paste**:

```
"_d
```

Examples:

-   `"_dd` → delete line without overwriting clipboard
-   `"_dw` → delete word silently

This is extremely useful when cleaning code.

## 7. Delete vs Change (`c`)

| Command | Difference                 |
| ------- | -------------------------- |
| `d`     | delete                     |
| `c`     | delete + enter insert mode |

Examples:

-   `cw` → change word
-   `cc` → change line
-   `C` → change to end of line

Think:

>   **`c` = `d` + `i`**

## 8. Undo & Recovery

Mistakes are cheap in Vim.

| Command    | Meaning             |
| ---------- | ------------------- |
| `u`        | undo                |
| `Ctrl + r` | redo                |
| `p`        | paste deleted text  |
| `P`        | paste before cursor |

## 9. Common Beginner Mistakes

❌ Using `x` repeatedly

✅ Use `dw`, `dd`, `d$`

❌ Holding backspace

✅ Stay in Normal mode and delete with commands

❌ Entering Insert mode to delete

✅ Delete first, then insert

## 10. Cheat Sheet (Must Remember)

```
x      delete char
dd     delete line
dw     delete word
d$     delete to end of line
diw    delete inside word
di"    delete inside quotes
"_d    delete without yanking
u      undo
```

## Final Advice

If you remember **only one rule**, remember this:

>   **Vim deletion = operator (`d`) + motion**

Once this clicks, Vim stops being hard — it becomes fast.