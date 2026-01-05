# Extra Vim Notes

![Vimlogo](https://upload.wikimedia.org/wikipedia/commons/9/9f/Vimlogo.svg)

## 1. Introduction to the Ecosystem

Vim (Vi IMproved) is a highly configurable text editor built to enable efficient text editing. It is the successor to `vi` and often compared with `Emacs`.

-   **Vim Author:** [Bram Moolenaar](https://nl.wikipedia.org/wiki/Bram_Moolenaar)
    -   website: [https://www.moolenaar.net/](https://www.moolenaar.net/)

-   **Vi Author:** [Bill Joy](https://en.wikipedia.org/wiki/Bill_Joy)
-   **Emacs Author:** [Richard Stallman](https://en.wikipedia.org/wiki/Richard_Stallman)
-   **Modern Alternative:** [Neovim](https://neovim.io/), a refactored version of Vim focusing on extensibility.

------

## 2. The Modal Philosophy

Unlike standard editors, Vim is **modal**. It is designed around the idea that developers spend more time reading and navigating than typing.

![vim-modes](https://github.com/nilp0inter/Vim-for-Muggles/raw/master/modes.png)

### Primary Modes

1.  **Normal Mode:** The default mode for navigation and manipulation. Commands are "driven" by keystrokes.
2.  **Insert Mode:** Used for typing text. Enter via `i` (at cursor) or `I` (beginning of line).
3.  **Command Mode:** Accessed via `:`, used for system-level commands like saving or settings.
4.  **Visual Mode:** Used for selecting blocks of text.

---

-   [Vim Modes Transition Diagram in SVG](https://gist.github.com/darcyparker/1886716)
-   <https://github.com/nilp0inter/Vim-for-Muggles?tab=readme-ov-file#modes>

## 3. Getting Started: Essentials

To learn interactively, run the command `$ vimtutor` in your terminal.

### Basic Navigation & File Operations

| **Key**         | **Action**                                |
| --------------- | ----------------------------------------- |
| `h` `j` `k` `l` | Move cursor Left, Down, Up, Right         |
| `i` / `Esc`     | Enter Insert Mode / Return to Normal Mode |
| `x`             | Delete a single character                 |
| `u`             | Undo the last action                      |
| `:w`            | Save (Write) the file                     |
| `:wq`           | Save and Quit                             |
| `:q!`           | Quit without saving                       |

------

## 4. Advanced Workflow

Efficiently managing multiple files and large blocks of text is where Vim shines.

### Window & Tab Management

-   **Splits:** Use `:split filename` (horizontal) or `:vsplit filename` (vertical) to view multiple files.
-   **Navigation:** Use `Ctrl + w` followed by `h/j/k/l` to move between split windows.
-   **Tabs:** * `:tabe <path>`: Open a file in a new tab.
    -   `:tabn` / `:tabp`: Cycle to next/previous tab.

### Buffer Operations

-   **Copy entire file to clipboard:** `ggVG` (Select all) followed by `"+y` (Yank to system clipboard).

------

## 5. Expanding the Toolkit

To turn Vim into a full IDE, explore the following:

-   **Macros:** Record and playback repetitive keystrokes.
-   **Plugin Managers:** Use [VimAwesome](https://vimawesome.com/) to find tools like **CoC** (Conquer of Completion) for LSP support and **UltiSnips** for code snippets.