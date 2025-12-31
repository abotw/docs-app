# Overleaf-01: Ref

## 1. The Two Common Ways to Reference in Overleaf

### Method 1 (Recommended): **BibTeX / `.bib` file**

-   Best for academic papers, theses, and long documents
-   Clean separation of **content** and **references**
-   Easy to reuse and manage

### Method 2: **Manual `thebibliography`**

-   Simple and quick
-   Suitable for short documents or reports
-   Not scalable

------

## 2. Method 1: Using BibTeX (Standard Workflow)

### Step 1: Create a `.bib` File

In Overleaf:

-   Click **“+” → New File**
-   Name it `references.bib`

Example `references.bib`:

```bibtex
@article{knuth1984texbook,
  author  = {Donald E. Knuth},
  title   = {The TeXbook},
  year    = {1984},
  publisher = {Addison-Wesley}
}
```

>   `knuth1984texbook` is the **citation key**.

------

### Step 2: Cite in Your `.tex` File

```latex
This book is fundamental to \LaTeX{} \cite{knuth1984texbook}.
```

Common citation commands:

```latex
\cite{key}        % numeric or author-year
\citep{key}       % (author, year)  [natbib]
\citet{key}       % author (year)   [natbib]
```

------

### Step 3: Add Bibliography to the Document

At the **end of your `.tex` file**:

```latex
\bibliographystyle{plain}
\bibliography{references}
```

Compile sequence in Overleaf (automatic):

```
LaTeX → BibTeX → LaTeX → LaTeX
```

Overleaf handles this for you.

------

## 3. Common Bibliography Styles

| Style     | Description                  |
| --------- | ---------------------------- |
| `plain`   | Numeric, sorted by author    |
| `unsrt`   | Numeric, order of appearance |
| `alpha`   | Author-year code             |
| `apalike` | APA-like                     |

Example:

```latex
\bibliographystyle{unsrt}
```

------

## 4. Method 2: Manual References (`thebibliography`)

Useful for **short documents**.

```latex
\begin{thebibliography}{9}

\bibitem{knuth}
Donald E. Knuth,
\textit{The TeXbook},
Addison-Wesley, 1984.

\end{thebibliography}
```

Cite it with:

```latex
\cite{knuth}
```

------

## 5. Referencing with `biblatex` (Modern Alternative)

More flexible, but slightly advanced.

### Preamble:

```latex
\usepackage[backend=biber,style=authoryear]{biblatex}
\addbibresource{references.bib}
```

### Cite:

```latex
\cite{knuth1984texbook}
```

### Print bibliography:

```latex
\printbibliography
```

Overleaf supports **Biber** automatically.

------

## 6. Where to Get BibTeX Entries

-   **Google Scholar** → “Cite” → BibTeX
-   **arXiv**
-   **IEEE Xplore / ACM DL**
-   **Zotero / Mendeley**

------

## 7. Common Beginner Mistakes

❌ Forgetting to add `\bibliography{}`
❌ Citation key mismatch
❌ Editing `.bib` but not recompiling
❌ Using BibTeX syntax inside `.tex`

------

## 8. Minimal Working Example

```latex
\documentclass{article}

\begin{document}

This is a citation example \cite{knuth1984texbook}.

\bibliographystyle{plain}
\bibliography{references}

\end{document}
```

