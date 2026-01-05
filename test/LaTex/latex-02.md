

# LaTeX-02: References

## 1. What “References” Mean in LaTeX

In LaTeX, **references** usually include:

1.  **Cross-references inside the document**
    -   Sections
    -   Figures
    -   Tables
    -   Equations
2.  **Bibliographic references**
    -   Books
    -   Papers
    -   Websites

LaTeX handles both **automatically**, ensuring:

-   Correct numbering
-   Consistent formatting
-   Easy updates

------

## 2. Internal Cross-References (label & ref)

### Core Idea

LaTeX uses a **three-step mechanism**:

```latex
\label{key}
\ref{key}
\pageref{key}
```

-   `\label{}` → define a reference point
-   `\ref{}` → reference the number
-   `\pageref{}` → reference the page number

------

### Example: Section Reference

```latex
\section{Introduction}
\label{sec:intro}

As discussed in Section~\ref{sec:intro}, ...
```

📌 Best practice:

-   Put `\label` **right after** `\section`, `\caption`, or equation.

------

### Example: Figure Reference

```latex
\begin{figure}[h]
  \centering
  \includegraphics[width=0.5\textwidth]{example.png}
  \caption{System architecture}
  \label{fig:arch}
\end{figure}

Figure~\ref{fig:arch} shows the overall design.
```

------

### Example: Equation Reference

```latex
\begin{equation}
E = mc^2
\label{eq:einstein}
\end{equation}

Equation~\ref{eq:einstein} is well known.
```

------

## 3. Naming Conventions for Labels (Very Important)

Good label naming avoids confusion in large documents.

Common conventions:

```text
sec:intro
fig:architecture
tab:results
eq:newton
```

Pattern:

```
type:description
```

This makes references readable and maintainable.

------

## 4. Hyperlinks with `hyperref`

To make references clickable, use:

```latex
\usepackage{hyperref}
```

Now:

-   Section references
-   Figure references
-   Citations

become **clickable links in the PDF**.

Recommended order:

```latex
\usepackage{hyperref} % load this last
```

------

## 5. Bibliography: The Big Picture

There are **two main approaches**:

| Method                | Recommendation             |
| --------------------- | -------------------------- |
| `thebibliography`     | Small documents            |
| **BibTeX / biblatex** | Medium & large documents ✅ |

We focus on **biblatex**, which is modern and flexible.

------

## 6. Using `biblatex` (Recommended)

### Step 1: Load the Package

```latex
\usepackage[
  backend=biber,
  style=authoryear
]{biblatex}

\addbibresource{references.bib}
```

-   `backend=biber` → modern backend
-   `style=authoryear` → author–year style

------

### Step 2: Create a `.bib` File

File: `references.bib`

```bibtex
@book{knuth1984texbook,
  author    = {Donald E. Knuth},
  title     = {The TeXbook},
  year      = {1984},
  publisher = {Addison-Wesley}
}

@article{lamport1994latex,
  author  = {Leslie Lamport},
  title   = {LaTeX: A Document Preparation System},
  journal = {Addison-Wesley},
  year    = {1994}
}
```

Each entry has a **citation key**:

```
knuth1984texbook
lamport1994latex
```

------

## 7. Citing References in the Text

### Basic Citation

```latex
\cite{knuth1984texbook}
```

### Author–Year Style

```latex
\textcite{lamport1994latex}
```

### Multiple Citations

```latex
\cite{knuth1984texbook,lamport1994latex}
```

LaTeX handles formatting automatically.

------

## 8. Printing the Bibliography

Where you want the reference list:

```latex
\printbibliography
```

Usually at the end of the document.

------

## 9. Compilation Workflow (Very Important)

When using `biblatex + biber`:

```
xelatex main.tex
biber main
xelatex main.tex
xelatex main.tex
```

Overleaf does this automatically.

------

## 10. Common Citation Styles

Popular styles:

```latex
style=numeric
style=authoryear
style=ieee
style=apa
style=mla
```

Example:

```latex
\usepackage[style=ieee,backend=biber]{biblatex}
```

------

## 11. Referencing Without Showing Numbers

Sometimes you want text only:

```latex
\nameref{sec:intro}
```

This prints the **section title** instead of the number
(requires `hyperref`).

------

## 12. Common Problems & Solutions

### “Citation undefined”

✔ Run LaTeX multiple times
✔ Check citation keys
✔ Ensure `.bib` file is added

------

### References not clickable

✔ Load `hyperref`
✔ Load it **last**

------

### Wrong bibliography style

✔ Change `style=...`
✔ Recompile fully

------

## 13. Best Practices for Large Documents

-   Keep **all references in one `.bib` file**
-   Use consistent label prefixes
-   Never hard-code numbers
-   Let LaTeX manage everything

------

## 14. Minimal Working Example

```latex
\documentclass{article}

\usepackage{graphicx}
\usepackage{hyperref}
\usepackage[
  backend=biber,
  style=authoryear
]{biblatex}

\addbibresource{references.bib}

\begin{document}

\section{Introduction}
\label{sec:intro}

LaTeX was introduced by \textcite{lamport1994latex}.

\printbibliography

\end{document}
```

------

## 15. Final Advice

>   If you type numbers manually, you’re doing it wrong.

Once you master LaTeX references:

-   Large documents become easy
-   Reordering sections is painless
-   Formatting stays consistent forever