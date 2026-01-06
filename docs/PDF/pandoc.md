# Pandoc

*A universal document converter for the command line*

## 1. What is Pandoc?

**Pandoc** is a **command-line document converter**.

It allows you to convert documents between formats such as:

-   Markdown ↔ HTML
-   Markdown ↔ PDF
-   Markdown ↔ Word (`.docx`)
-   Word ↔ Markdown
-   LaTeX ↔ PDF
-   Markdown ↔ slides (PPT, reveal.js, beamer)

👉 Pandoc is often called **“the Swiss Army knife of document formats.”**

------

## 2. When should you use Pandoc?

Use Pandoc when you want to:

-   Write once (usually in **Markdown**) and publish everywhere
-   Convert Word documents into clean Markdown
-   Generate PDFs from text
-   Build technical docs, notes, reports, or books
-   Automate document workflows

Pandoc is **not a WYSIWYG editor**.
You write text → Pandoc converts it.

------

## 3. Installing Pandoc

### macOS (Homebrew)

```bash
brew install pandoc
```

Verify:

```bash
pandoc --version
```

------

### Linux (Debian / Ubuntu)

```bash
sudo apt install pandoc
```

------

### Windows

-   Download installer from the official Pandoc website
-   Or install via **WSL** (recommended)

------

## 4. The core idea: input → output

Basic command format:

```bash
pandoc input.md -o output.html
```

Pandoc **detects formats automatically** from file extensions.

------

## 5. Your first Pandoc example

Create a file `hello.md`:

```markdown
# Hello Pandoc

This is my first document.

- Simple
- Clean
- Powerful
```

Convert to HTML:

```bash
pandoc hello.md -o hello.html
```

Open `hello.html` in your browser 🎉

------

## 6. Markdown → PDF (very common)

### Step 1: Install a PDF engine

Pandoc needs a PDF engine such as:

-   `wkhtmltopdf`
-   `xelatex` (via TeX Live)
-   `weasyprint`

For beginners on macOS:

```bash
brew install --cask basictex
```

Restart terminal, then:

```bash
pandoc hello.md -o hello.pdf
```

------

## 7. Markdown → Word (.docx)

```bash
pandoc report.md -o report.docx
```

📌 This is extremely useful when:

-   You write in Markdown
-   Others require Word files

------

## 8. Word (.docx) → Markdown

```bash
pandoc input.docx -o output.md
```

Great for:

-   Cleaning up old documents
-   Migrating to Markdown-based workflows

------

## 9. Using a specific input or output format

Sometimes extensions are unclear.

```bash
pandoc -f markdown -t html input.txt -o output.html
```

-   `-f` → from
-   `-t` → to

------

## 10. Adding a title, author, and date (YAML header)

Pandoc supports **metadata** via a YAML block.

```markdown
---
title: My Report
author: Matt Li
date: 2026-01-06
---

# Introduction

Content goes here.
```

Pandoc automatically uses this metadata.

------

## 11. Styling HTML output

### Use a CSS file

```bash
pandoc input.md -o output.html --css=style.css
```

### Generate standalone HTML

```bash
pandoc input.md -o output.html --standalone
```

------

## 12. Styling PDF output

### Change fonts (XeLaTeX)

```bash
pandoc input.md -o output.pdf \
  --pdf-engine=xelatex \
  -V mainfont="Times New Roman"
```

------

## 13. Converting multiple files

```bash
pandoc chapter1.md chapter2.md chapter3.md -o book.pdf
```

Order matters 📘

------

## 14. Code blocks and syntax highlighting

```python
def hello():
    print("Hello")
```

Pandoc automatically highlights code in HTML and PDF.

## 15. Tables in Pandoc Markdown

```markdown
| Name | Score |
|------|-------|
| Alice | 90 |
| Bob   | 85 |
```

Pandoc converts tables cleanly across formats.

------

## 16. Creating slides

### Markdown → PowerPoint

```bash
pandoc slides.md -o slides.pptx
```

### Markdown → Reveal.js slides

```bash
pandoc slides.md -t revealjs -o slides.html
```

------

## 17. Common beginner mistakes

❌ Expecting live preview
✅ Pandoc is a **converter**, not an editor

------

❌ PDF fails to generate
✅ Install a **PDF engine**

------

❌ Ugly output
✅ Use templates, CSS, or themes

------

## 18. Useful everyday commands

| Task           | Command                       |
| -------------- | ----------------------------- |
| MD → HTML      | `pandoc a.md -o a.html`       |
| MD → PDF       | `pandoc a.md -o a.pdf`        |
| MD → Word      | `pandoc a.md -o a.docx`       |
| Word → MD      | `pandoc a.docx -o a.md`       |
| Multiple files | `pandoc a.md b.md -o out.pdf` |

------

## 19. When Pandoc shines the most

-   Writing **technical documentation**
-   Academic writing
-   Blogging with Markdown
-   Note systems (Obsidian, MkDocs, Hugo)
-   Automated report generation

(You already use Markdown-based tools, so Pandoc fits very naturally.)

------

## 20. Where to go next

-   Templates (`--template`)
-   Filters (Lua / Python)
-   Citations & BibTeX
-   Cross-references
-   Book-level projects