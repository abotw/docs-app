# Vim-02: Vimrc

-   [Vimrc by Albert Wu](http://albertwu.org/cs61a/notes/vimrc.html)

```
" --- General Settings ---
set nocompatible           " Break compatibility with Vi for more features
syntax on                  " Enable syntax highlighting
set nu                     " Show line numbers
set mouse=a                " Enable mouse support

" --- Python & Indentation ---
filetype plugin indent on  " Load filetype-specific indents
set expandtab              " Convert tabs to spaces
set tabstop=4              " 1 tab = 4 spaces
set autoindent             " Follow indentation of previous line

" --- Key Remaps ---
nnoremap ; :               " Use semicolon to enter command mode
nnoremap j gj              " Move by visual line, not file line
nnoremap k gk              " Useful for wrapped text
```

## 1. What is `.vimrc`?

`.vimrc` is Vim’s **configuration file**.
It tells Vim how to behave every time it starts.

Think of it as:

-   Vim’s *settings panel*
-   Written in **plain text**
-   Loaded automatically at startup

With a vimrc, you can:

-   Enable line numbers
-   Improve indentation
-   Change search behavior
-   Customize key mappings
-   Load plugins

------

## 2. Where is `.vimrc`?

### On macOS / Linux

```bash
~/.vimrc
```

### On Windows

```text
C:\Users\<YourName>\_vimrc
```

### Create it if it doesn’t exist

```bash
touch ~/.vimrc
```

Open it:

```bash
vim ~/.vimrc
```

------

## 3. Basic Vimrc Syntax

### Comments

```vim
" This is a comment
```

### Setting an option

```vim
set number
```

### Disabling an option

```vim
set nonumber
```

### Key mapping

```vim
nnoremap <key> <command>
```

------

## 4. Must-Have Settings for Beginners

### 4.1 Line Numbers

```vim
set number
```

Relative line numbers (optional but powerful):

```vim
set relativenumber
```

------

### 4.2 Better Indentation

```vim
set tabstop=4
set shiftwidth=4
set expandtab
set autoindent
```

What this means:

-   Tab = 4 spaces
-   Indentation stays consistent
-   Tabs become spaces (recommended)

------

### 4.3 Search Improvements

```vim
set ignorecase
set smartcase
set incsearch
set hlsearch
```

Behavior:

-   Case-insensitive search
-   Case-sensitive only if uppercase is used
-   Highlight matches
-   Search as you type

Clear highlight:

```vim
nnoremap <Esc> :nohlsearch<CR>
```

------

### 4.4 Better Navigation

```vim
set cursorline
set scrolloff=5
```

-   Highlights current line
-   Keeps cursor away from screen edges

------

### 4.5 Enable Mouse (Optional)

```vim
set mouse=a
```

Useful in terminal Vim.

------

## 5. Quality-of-Life Settings

```vim
set showcmd
set showmode
set wildmenu
set wildmode=longest:full,full
```

These improve command-line completion and feedback.

------

## 6. Key Mappings (Beginner Safe)

### Save file quickly

```vim
nnoremap <leader>w :w<CR>
```

### Quit quickly

```vim
nnoremap <leader>q :q<CR>
```

### Set leader key

```vim
let mapleader=" "
```

Now press:

```
Space + w   → save
Space + q   → quit
```

------

## 7. Basic Plugin Management (Optional)

### Using vim-plug (Recommended)

#### Install vim-plug

```bash
curl -fLo ~/.vim/autoload/plug.vim --create-dirs \
https://raw.githubusercontent.com/junegunn/vim-plug/master/plug.vim
```

#### Plugin section in `.vimrc`

```vim
call plug#begin('~/.vim/plugged')

Plug 'preservim/nerdtree'
Plug 'tpope/vim-commentary'

call plug#end()
```

Install plugins inside Vim:

```vim
:PlugInstall
```

------

## 8. A Minimal Beginner `.vimrc` (Recommended Start)

```vim
" === Basic Settings ===
set number
set relativenumber
set cursorline
set mouse=a

" === Indentation ===
set tabstop=4
set shiftwidth=4
set expandtab
set autoindent

" === Search ===
set ignorecase
set smartcase
set incsearch
set hlsearch

" === UI ===
set showcmd
set wildmenu

" === Key Mappings ===
let mapleader=" "
nnoremap <leader>w :w<CR>
nnoremap <leader>q :q<CR>
nnoremap <Esc> :nohlsearch<CR>
```

------

## 9. Reload Vimrc Without Restarting

```vim
:source ~/.vimrc
```

Or add this mapping:

```vim
nnoremap <leader>r :source ~/.vimrc<CR>
```

------

## 10. How to Learn Vimrc Gradually

Beginner strategy:

1.  Start **small**
2.  Add **one setting at a time**
3.  Test it
4.  Keep what feels useful

Never copy huge vimrc files blindly.

------

## 11. Common Beginner Mistakes

❌ Over-customizing early
❌ Copying “ultimate vimrc” configs
❌ Not understanding mappings
❌ Mixing Vim and Neovim configs

------

## 12. Vim vs Neovim Note

-   Vim uses: `~/.vimrc`
-   Neovim uses: `~/.config/nvim/init.vim`

Most settings are identical.

------

## 13. Next Steps

Once comfortable:

-   Learn modes deeply
-   Explore plugins (`fzf`, `treesitter`, `lsp`)
-   Split config into files
-   Migrate to Neovim if desired

