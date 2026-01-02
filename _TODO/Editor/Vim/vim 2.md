# Vim

## Some useful Vim commands

| **Command**                      | **Explanation**                                              |
| -------------------------------- | ------------------------------------------------------------ |
| `[ESC]` `#!vim :tabe <filepath>` | Opens the file at `filepath` in a new tab. You can use `[Tab]` for autocompletion |
| `[Esc]` `#!vim :tabn`            | Go to the next tab in the tab bar                            |
| `[Esc]` `#!vim :tabp`            | Go to the previous tab in the tab bar                        |

## Multiple Windows

``` vim
:split filename
:vsplit filename
```

* `CTRL-w` + one of the `hjkl` keys - To navigate between windows.

## 常用 Vim 命令总结

### 复制当前文件全部内容

`ggVG` - 将光标移动到文件的第一行（`gg`），然后选择整个文件的内容（`V`），并将光标移动到文件的最后一行（`G`）。

`"+y` - 将复制选择的内容到系统剪贴板。

`Ctrl + Shift + V` 或右键点击粘贴 - 粘贴内容

# Vimrc

## Reference

- [Vimrc | Albert Wu](http://albertwu.org/cs61a/notes/vimrc.html)

```vim linenums="1"
" Syntax highlighting
syntax on
colorscheme default
filetype plugin indent on

set nu 						" Line numbers
set number " To enable line numbers

" Here are common settings that work well with Python
set expandtab     " Uses spaces instead of tabs
set tabstop=4     " Each tab is 4 spaces
set autoindent

" Key bindings
nnoremap ; :      " Enter command mode by typing semicolon
nnoremap j gj     " Move along rows,
nnoremap k gk     " not lines

set mouse=a 			" To enable your mouse

set nocompatible " which tells Vim not to be compatible with Vi, Vim's predecessor.
```



