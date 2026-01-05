# Vimrc

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

