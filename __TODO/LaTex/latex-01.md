# LaTeX-01: Overview

## 1. What Is LaTeX?

**LaTeX** is a *typesetting system* widely used for:

-   Academic papers 📄
-   Theses and dissertations
-   Mathematical formulas
-   Technical books and slides

Instead of formatting text by clicking buttons (like in Word), you **write plain text with commands**, and LaTeX handles the layout automatically.

>   Think of LaTeX as:
>   **“content first, formatting later.”**

------

## 2. When Should You Use LaTeX?

LaTeX is especially good if you:

-   Write **math-heavy** documents
-   Care about **professional layout**
-   Need **cross-references**, **citations**, or **bibliographies**
-   Want documents that are **easy to maintain**

Not ideal if you just want quick casual notes.

------

## 3. How LaTeX Works (Big Picture)

LaTeX follows this workflow:

```
.tex file  →  LaTeX compiler  →  PDF
```

You write a `.tex` file, then compile it into a PDF.

Popular compilers:

-   `pdflatex`
-   `xelatex` (recommended for Unicode / Chinese)
-   `lualatex`

------

## 4. Ways to Use LaTeX

### Option 1: Online (Recommended for Beginners)

-   **Overleaf** ([https://www.overleaf.com](https://www.overleaf.com/))
    -   No installation
    -   Real-time preview
    -   Great for collaboration

### Option 2: Local Installation

-   macOS: **MacTeX**
-   Windows: **MiKTeX**
-   Linux: **TeX Live**

------

## 5. Your First LaTeX Document

### Minimal Example

```latex
\documentclass{article}

\begin{document}

Hello, LaTeX!

\end{document}
```

Explanation:

-   `\documentclass{article}` → document type
-   `\begin{document}` → start content
-   `\end{document}` → end content

Compile it, and you get a PDF saying **Hello, LaTeX!**

------

## 6. Document Structure

A typical LaTeX file looks like this:

```latex
\documentclass{article}

% Preamble (settings)
\usepackage{amsmath}

\begin{document}

% Content
\section{Introduction}
This is the introduction.

\end{document}
```

### Two Main Parts

1.  **Preamble**
    -   Document class
    -   Packages
    -   Global settings
2.  **Document body**
    -   Text
    -   Sections
    -   Figures, tables, formulas

------

## 7. Text Formatting Basics

### Paragraphs

Leave a blank line to start a new paragraph.

```latex
This is the first paragraph.

This is the second paragraph.
```

### Bold / Italic

```latex
\textbf{Bold text}
\textit{Italic text}
```

### Line Break

```latex
This is a line.\\
This is a new line.
```

------

## 8. Sections and Headings

```latex
\section{Section}
\subsection{Subsection}
\subsubsection{Subsubsection}
```

LaTeX automatically numbers them.

------

## 9. Lists

### Unordered List

```latex
\begin{itemize}
  \item Apple
  \item Banana
  \item Orange
\end{itemize}
```

### Ordered List

```latex
\begin{enumerate}
  \item First
  \item Second
  \item Third
\end{enumerate}
```

------

## 10. Mathematics (One of LaTeX’s Strengths)

### Inline Math

```latex
Einstein said $E = mc^2$.
```

### Display Math

```latex
\[
E = mc^2
\]
```

### Common Math Commands

```latex
\frac{a}{b}      % fraction
\sqrt{x}        % square root
x^2             % superscript
x_1             % subscript
```

Example:

```latex
\[
\frac{1}{n} \sum_{i=1}^n x_i
\]
```

------

## 11. Figures

```latex
\usepackage{graphicx}

\begin{figure}[h]
  \centering
  \includegraphics[width=0.6\textwidth]{example.png}
  \caption{An example image}
  \label{fig:example}
\end{figure}
```

You can reference it later:

```latex
Figure~\ref{fig:example}
```

------

## 12. Tables

```latex
\begin{tabular}{c c c}
A & B & C \\
1 & 2 & 3 \\
4 & 5 & 6
\end{tabular}
```

For professional tables, later learn:

-   `booktabs`
-   `tabularx`

------

## 13. Packages (Very Important)

Packages extend LaTeX’s functionality.

Common beginner packages:

```latex
\usepackage{amsmath}   % better math
\usepackage{graphicx}  % images
\usepackage{hyperref}  % links
```

------

## 14. Comments

Anything after `%` is a comment.

```latex
% This is a comment
This text will appear. % This will not
```

------

## 15. Common Beginner Mistakes

❌ Forgetting `\end{document}`
❌ Missing a closing brace `{}`
❌ Using Word-style formatting habits
❌ Forgetting to include required packages

LaTeX error messages can look scary—read **the first error**, not the last.

------

## 16. Recommended Learning Path

1.  Basic document structure
2.  Sections and text
3.  Math formulas
4.  Figures and tables
5.  References and bibliography (`biblatex`)
6.  Templates (articles, thesis, Beamer slides)

------

## 17. Where to Go Next

-   Overleaf tutorials
-   LaTeX Wikibook
-   Learn specific templates (paper / thesis / Beamer)

------

## 18. Final Advice

>   LaTeX has a learning curve,
>   but once mastered, it saves **huge amounts of time**.

Write content first.
Let LaTeX handle beauty.