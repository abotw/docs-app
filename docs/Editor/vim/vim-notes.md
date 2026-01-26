# Extra Vim Notes

## 1. Introduction to the Ecosystem

-   **Vi Author:** [Bill Joy](https://en.wikipedia.org/wiki/Bill_Joy)
-   **Emacs Author:** [Richard Stallman](https://en.wikipedia.org/wiki/Richard_Stallman)
-   **Modern Alternative:** [Neovim](https://neovim.io/), a refactored version of Vim focusing on extensibility.

## 2. Advanced Workflow

Efficiently managing multiple files and large blocks of text is where Vim shines.

### Window & Tab Management

-   **Navigation:** Use `Ctrl + w` followed by `h/j/k/l` to move between split windows.
-   **Tabs:** * `:tabe <path>`: Open a file in a new tab.
    -   `:tabn` / `:tabp`: Cycle to next/previous tab.

### Buffer Operations

-   **Copy entire file to clipboard:** `ggVG` (Select all) followed by `"+y` (Yank to system clipboard).

------

## 3. Expanding the Toolkit

To turn Vim into a full IDE, explore the following:

-   **Macros:** Record and playback repetitive keystrokes.
-   **Plugin Managers:** Use [VimAwesome](https://vimawesome.com/) to find tools like **CoC** (Conquer of Completion) for LSP support and **UltiSnips** for code snippets.