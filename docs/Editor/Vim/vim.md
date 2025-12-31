# Vim

![Vimlogo](https://upload.wikimedia.org/wikipedia/commons/9/9f/Vimlogo.svg)
- Vim author: [Bram Moolenaar](https://nl.wikipedia.org/wiki/Bram_Moolenaar)
	- website: [https://www.moolenaar.net/](https://www.moolenaar.net/)
- Vi author: [Bill Joy](https://en.wikipedia.org/wiki/Bill_Joy)
- Emacs author: [Richard Stallman](https://en.wikipedia.org/wiki/Richard_Stallman)

- Normal 模式下，命令驱动。
- 阅读 ⇒ 修改 ⇒ 移动光标
## Vim Modes, Vim 工作模式

1. Normal
2. Command, 命令模式
	- `:command`
	- `:syntax on|off` / `:syntax enable`
	- `:set nu` / `:set number`
3. Insert / Edit, 插入模式
	- `-- INSERT --`
	- `i` - insert mode
	- `I` - insert at BOL (beginning of line)
4. Visual
---

![vim-modes](https://github.com/nilp0inter/Vim-for-Muggles/raw/master/modes.png)

---
![[Pasted image 20240505152928.png]]

---

- Vim Modes Transition Diagram in SVG.[https://gist.github.com/darcyparker/1886716](https://gist.github.com/darcyparker/1886716).
- [https://github.com/nilp0inter/Vim-for-Muggles?tab=readme-ov-file#modes](https://github.com/nilp0inter/Vim-for-Muggles?tab=readme-ov-file#modes)
## Vim basics

``` sh
$ vimtutor

# If file exits, then open the file, otherwise create the file
$ vim filename
```

| Key stroke | Description                            |
| ---------- | -------------------------------------- |
| `:w`       | Write (save) the current file          |
| `:wq`      | Write (save) the current file and exit |
| `:q!`      | Quit, ignoring all changes             |
| `i`        | Go into insert mode                    |
| `Esc`      | Go back to normal mode                 |
| `hjkl`     | Move cursor left, down, up, right      |
| `u`        | Undo last change                       |
| `x`        | Delete character                       |

## Advanced

- [Vim](https://www.vim.org/)
    - [宏](https://vim.fandom.com/wiki/Macros)
    - [重映射](https://vim.fandom.com/wiki/Mapping_keys_in_Vim_-_Tutorial_(Part_1))
    - [Snippets](https://github.com/SirVer/ultisnips)
    - [COC插件](https://github.com/neoclide/coc.nvim)
    - [Vim插件](https://vimawesome.com/)
- [Emacs](https://www.gnu.org/software/emacs/)
- **[Emacs vs. Vim](https://www.diffen.com/difference/Emacs_vs_Vim)**
- [neovim](https://neovim.io/)
