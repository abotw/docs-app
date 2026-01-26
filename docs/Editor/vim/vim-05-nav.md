---
status: done
---

# Vim: Navigation

Vim is famous (and sometimes feared 😄) for its keyboard-centric navigation. Once you understand how movement works, editing becomes *much* faster than using a mouse.

This tutorial focuses **only on navigation**—no editing yet.

## 1. The Golden Rule: Normal Mode

Most navigation in Vim happens in **Normal mode**.

-   Press `Esc` to make sure you’re in Normal mode
-   If nothing appears when you type, you’re probably in Normal mode ✅

>   **Tip:** When confused, press `Esc` twice.

## 2. Basic Cursor Movement (The Core)

### The famous `hjkl` keys

```
h  ←  left
j  ↓  down
k  ↑  up
l  →  right
```

Why not arrow keys?

-   `hjkl` keep your fingers on the home row
-   Faster, more precise, more Vim-like

>   You *can* use arrow keys, but learning `hjkl` is worth it.

## 3. Move by Words (Much Faster)

### Word-wise navigation

| Key  | Action                               |
| ---- | ------------------------------------ |
| `w`  | Move to **start of next word**       |
| `e`  | Move to **end of current/next word** |
| `b`  | Move to **start of previous word**   |

Example:

```
This is a simple sentence.
^
```

-   Press `w` → jumps word by word
-   Press `e` → lands at word endings

### Big words (ignore punctuation)

| Key  | Action                      |
| ---- | --------------------------- |
| `W`  | Next WORD (space-separated) |
| `B`  | Previous WORD               |
| `E`  | End of WORD                 |

Useful for URLs, paths, or code like:

```
foo_bar-baz.qux
```

## 4. Move Within a Line

### Line navigation

| Key  | Action                        |
| ---- | ----------------------------- |
| `0`  | Start of line                 |
| `^`  | First **non-blank** character |
| `$`  | End of line                   |

Most common:

-   `^` → jump to code indentation
-   `$` → jump to line end

## 5. Move by Lines

### Vertical jumps

| Key         | Action                   |
| ----------- | ------------------------ |
| `gg`        | Go to **top of file**    |
| `G`         | Go to **bottom of file** |
| `:{number}` | Go to line number        |

Examples:

```
gg      → first line
G       → last line
:42     → line 42
```

## 6. Screen-Based Movement

Sometimes you want to move relative to what you *see*.

| Key  | Action           |
| ---- | ---------------- |
| `H`  | Top of screen    |
| `M`  | Middle of screen |
| `L`  | Bottom of screen |

Think:

-   **H**igh
-   **M**iddle
-   **L**ow

## 7. Scrolling Without Moving the Cursor

| Key        | Action                    |
| ---------- | ------------------------- |
| `Ctrl + u` | Scroll up half a screen   |
| `Ctrl + d` | Scroll down half a screen |
| `Ctrl + b` | Scroll up one screen      |
| `Ctrl + f` | Scroll down one screen    |

>   `u` = **u**p, `d` = **d**own
>   `b` = **b**ack, `f` = forward

## 8. Jumping to Characters (Extremely Useful)

### Find characters in a line

| Key       | Action                            |
| --------- | --------------------------------- |
| `f{char}` | Jump **to** next `{char}`         |
| `F{char}` | Jump **backward to** `{char}`     |
| `t{char}` | Jump **before** `{char}`          |
| `T{char}` | Jump **backward before** `{char}` |

Example:

```
let result = foo(bar, baz);
```

-   `f(` → jumps to `(`
-   `t(` → jumps just before `(`
-   `f,` → jumps to the comma

Repeat:

-   `;` → repeat last `f/t`
-   `,` → repeat in opposite direction

## 9. Searching to Navigate

### Forward / backward search

| Key     | Action          |
| ------- | --------------- |
| `/text` | Search forward  |
| `?text` | Search backward |
| `n`     | Next match      |
| `N`     | Previous match  |

Example:

```
/main
n
n
```

This is one of the **fastest ways to navigate large files**.

## 10. Matching Pairs (Code Navigation)

| Key  | Action                |
| ---- | --------------------- |
| `%`  | Jump to matching pair |

Works on:

```
( )   { }   [ ]
if / else
```

Example:

```
if (x > 0) {
    do_something();
}
```

Place cursor on `{` → press `%` → jumps to `}`

## 11. Jump History (Go Back / Forward)

Vim remembers where you’ve been.

| Key        | Action           |
| ---------- | ---------------- |
| `Ctrl + o` | Jump **back**    |
| `Ctrl + i` | Jump **forward** |

Similar to browser back/forward.

## 12. Counts: Multiply Your Movements

Most motions accept a number.

| Command | Meaning              |
| ------- | -------------------- |
| `5j`    | Move down 5 lines    |
| `3w`    | Move forward 3 words |
| `10G`   | Go to line 10        |

This is **core Vim power**: *operators × motions × counts*.

## 13. A Minimal Navigation Cheat Sheet

```
h j k l     basic movement
w b e       word movement
0 ^ $       line movement
gg G        file movement
Ctrl-u/d    scroll
f t ; ,     character jumps
/ ? n N     search
%           matching pairs
```

## 14. How to Practice (Recommended)

Open any file and practice **only navigation**:

1.  No editing
2.  No mouse
3.  No arrow keys

Suggested drill:

-   `gg` → `G`
-   `/` search → `n`, `N`
-   `f`, `t`, `;`
-   `Ctrl-u`, `Ctrl-d`

## 15. What to Learn Next

After navigation, the natural next steps are:

-   **Editing operators** (`d`, `c`, `y`)
-   **Text objects** (`iw`, `ip`, `i(`)
-   **Visual mode**

