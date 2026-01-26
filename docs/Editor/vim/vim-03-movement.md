---
status: done
---

# Vim: Movement

## 1. The Mental Model: *Motion = Addressing Text*

In Vim, **movement is not navigation**—it is **addressing**.

A motion answers:

>   *“Which text do I want?”*

That’s why motions compose with operators:

```
d + motion
c + motion
y + motion
```

Mastery = choosing the *smallest, most precise* motion.

## 2. Character-Level Precision

### `f F t T` — The Most Underrated Motions

```vim
f{char}   " move to next {char}
F{char}   " move backward to {char}
t{char}   " move before {char}
T{char}   " move backward before {char}
```

Repeatable with:

```
;   repeat in same direction
,   repeat in opposite direction
```

**Key insight**

>   Prefer `df,` over `dw dw dw`.

Example:

```
foo(bar, baz, qux)
    ^ cursor
df,   " deletes until the comma
```

## 3. Word Motions (Semantic Precision)

| Motion  | Meaning                |
| ------- | ---------------------- |
| `w`     | next word start        |
| `e`     | end of word            |
| `b`     | previous word          |
| `W E B` | WORD (space-separated) |

**Advanced rule**

-   Use `w/e/b` in **code**
-   Use `W/E/B` in **logs, prose, config**

## 4. Line Motions Beyond `0` and `$`

### Smart Line Navigation

```vim
^   " first non-blank character
0   " absolute column 0
$   " end of line
g_  " last non-blank character
```

**Power combo**

```vim
d^   " delete indentation
dg_  " delete trailing whitespace
```

## 5. Vertical Precision: Screen vs File

### Screen-Relative Motions

```vim
H   " top of screen
M   " middle of screen
L   " bottom of screen
```

### Logical Line vs Display Line

```vim
j k     " logical lines
gj gk   " visual (wrapped) lines
```

**Rule**

>   Use `gj/gk` when `wrap` is on.

## 6. Paragraphs, Sentences, and Blocks

### Structural Motions

```vim
{   " previous paragraph
}   " next paragraph

(   " previous sentence
)   " next sentence
```

### Code-Oriented Text Objects

```vim
%   " jump to matching (), {}, []
```

**Operator usage**

```vim
d%   " delete entire block
y}   " yank paragraph
```

## 7. Text Objects: The Real Power

Text objects work **without moving the cursor**.

### Core Pattern

```
operator + (i | a) + object
```

| Object | Meaning            |
| ------ | ------------------ |
| `iw`   | inner word         |
| `aw`   | a word             |
| `ip`   | inner paragraph    |
| `ap`   | a paragraph        |
| `i(`   | inside parentheses |
| `a"`   | including quotes   |

### Examples

```vim
ci"   " change inside quotes
da(   " delete surrounding parentheses
yi{   " yank inside braces
```

**Advanced mindset**

>   Stop moving. Start selecting *concepts*.

## 8. Search as a Motion Engine

### Forward / Backward

```vim
/word
?word
```

Repeat:

```
n   next
N   previous
```

### Search as an Operator Motion

```vim
d/foo<Enter>
c/bar<Enter>
```

### Word Under Cursor

```vim
*   search forward
#   search backward
```

## 9. Jumps, Marks, and the Jump List

### Jump List Navigation

```vim
Ctrl-o   " jump backward
Ctrl-i   " jump forward
```

### Marks (Personal Teleportation)

```vim
ma   " set mark a
'a   " jump to line of mark a
`a   " jump to exact position
```

**Advanced use**

-   Drop marks before refactors
-   Use marks like bookmarks, not labels

## 10. Folding & Structural Movement

```vim
[z   " start of fold
]z   " end of fold
zj   " next fold
zk   " previous fold
```

------

## 11. Macros Love Deterministic Movement

Macros fail when movement is vague.

**Bad**

```vim
3w
```

**Good**

```vim
f=ci"
```

Rule:

>   If a macro breaks, your motion was imprecise.

## 12. The Golden Rule of Vim Movement

>   **Never count when you can describe.**
>   **Never move when you can select.**

Bad:

```vim
5j2w
```

Good:

```vim
/return<Enter>
```

## 13. Practice Drills (Advanced)

### Drill 1: No Arrow Keys

Navigate a file using only:

```
f t / ? % { } H M L
```

### Drill 2: Text Object Only

Refactor code using:

```
ci( ci{ da" yiw
```

### Drill 3: Zero Cursor Travel

Try editing without using `hjkl`.

## Final Thought

Vim mastery is not speed of fingers, but **precision of intent**.

When movement becomes *language*, Vim becomes effortless.