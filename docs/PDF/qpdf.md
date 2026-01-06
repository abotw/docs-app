# qpdf

*A practical guide to working with PDF files from the command line*

## 1. What is qpdf?

**qpdf** is a **command-line tool and library** for **transforming and inspecting PDF files**.

It is commonly used to:

-   🔓 Remove PDF passwords (if you have permission)
-   🔐 Add encryption and passwords
-   📄 Merge multiple PDFs into one
-   ✂️ Split PDFs by pages
-   🔄 Reorder, rotate, or extract pages
-   🔍 Inspect PDF structure (advanced usage)

👉 qpdf **does not edit text or images visually**.
Think of it as a **PDF structural tool**, not a PDF editor.

------

## 2. When should you use qpdf?

Use qpdf when you want to:

-   Work with PDFs **in scripts or terminal**
-   Batch-process many PDF files
-   Handle encrypted PDFs safely
-   Prepare PDFs for other tools (printing, OCR, archiving)

If you prefer **GUI editing**, qpdf is not the right tool.

------

## 3. Installing qpdf

### macOS (Homebrew)

```bash
brew install qpdf
```

Verify:

```bash
qpdf --version
```

------

### Linux (Debian / Ubuntu)

```bash
sudo apt install qpdf
```

------

### Windows

-   Download from the official site
-   Or use **WSL** (recommended for beginners on Windows)

------

## 4. Basic command format

```bash
qpdf [options] input.pdf output.pdf
```

📌 qpdf **never modifies the original file** unless you explicitly overwrite it.

------

## 5. Removing a PDF password

If you **know the password**:

```bash
qpdf --password=secret input.pdf output.pdf
```

If the PDF has **no password but is restricted**:

```bash
qpdf --decrypt input.pdf output.pdf
```

📌 This removes **usage restrictions**, not copyright.

------

## 6. Adding password protection (encryption)

### Add a user password

```bash
qpdf --encrypt userpass ownerpass 256 input.pdf encrypted.pdf
```

-   `userpass` → password to open the PDF
-   `ownerpass` → password with full permissions
-   `256` → encryption strength (recommended)

Example:

```bash
qpdf --encrypt 1234 admin 256 report.pdf report-protected.pdf
```

------

## 7. Merging multiple PDFs

```bash
qpdf a.pdf b.pdf c.pdf merged.pdf
```

📌 Order matters: `a.pdf` → `b.pdf` → `c.pdf`

------

## 8. Splitting a PDF (extract pages)

### Extract pages 1–3

```bash
qpdf input.pdf --pages . 1-3 -- output.pdf
```

### Extract specific pages

```bash
qpdf input.pdf --pages . 1,3,5 -- output.pdf
```

📌 `.` means “from the input file itself”.

------

## 9. Reordering pages

Example: page order → 3, 1, 2

```bash
qpdf input.pdf --pages . 3,1,2 -- reordered.pdf
```

------

## 10. Rotating pages

### Rotate all pages 90° clockwise

```bash
qpdf --rotate=+90 input.pdf rotated.pdf
```

### Rotate only certain pages

```bash
qpdf input.pdf --rotate=+90:1-3 -- output.pdf
```

------

## 11. Checking PDF information

### Basic inspection

```bash
qpdf --show-npages file.pdf
```

Output example:

```text
12
```

### Check encryption status

```bash
qpdf --show-encryption file.pdf
```

------

## 12. Overwriting the original file (use carefully!)

```bash
qpdf input.pdf --decrypt --replace-input
```

⚠️ This **modifies the original file**.
Always keep backups.

------

## 13. Common beginner mistakes

❌ Forgetting `--` before output when using `--pages`
✅ Always use:

```bash
-- output.pdf
```

------

❌ Expecting qpdf to edit text or images
✅ qpdf works on **PDF structure only**

------

❌ Losing the original file
✅ Always test without `--replace-input`

------

## 14. Typical real-world use cases

-   📚 Remove password before OCR processing
-   🖨 Fix PDFs that won’t print correctly
-   📦 Merge lecture slides into one file
-   🔐 Protect PDFs before sharing
-   🧪 Batch PDF processing in scripts

------

## 15. Quick command cheat sheet

| Task            | Command                                 |
| --------------- | --------------------------------------- |
| Remove password | `qpdf --decrypt in.pdf out.pdf`         |
| Add password    | `qpdf --encrypt u o 256 in.pdf out.pdf` |
| Merge PDFs      | `qpdf a.pdf b.pdf out.pdf`              |
| Extract pages   | `qpdf in.pdf --pages . 1-3 -- out.pdf`  |
| Rotate pages    | `qpdf --rotate=+90 in.pdf out.pdf`      |
| Page count      | `qpdf --show-npages in.pdf`             |

------

## 16. Where to go next

-   Learn **batch processing with shell scripts**
-   Combine qpdf with:
    -   `ocrmypdf`
    -   `pdftoppm`
    -   `imagemagick`
-   Explore advanced inspection options (`--qdf`, `--json`)