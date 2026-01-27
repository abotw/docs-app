# PDF.js

*A simple guide to viewing PDFs in the browser with JavaScript*

## 1. What is PDF.js?

**PDF.js** is an **open-source JavaScript library** developed by **Mozilla** that allows you to **render PDF files directly in a web browser** using **HTML5 and Canvas**, without any plugins.

In short:

>   **PDF.js lets your website display PDFs like a native viewer.**

------

## 2. What can PDF.js do?

With PDF.js, you can:

-   📄 Display PDF files in a browser
-   🔍 Zoom in/out
-   📑 Navigate pages
-   🔎 Search text
-   🖱 Select and copy text
-   📱 Work on desktop & mobile browsers

PDF.js is **read-only** (no editing).

------

## 3. When should you use PDF.js?

Use PDF.js when you want to:

-   Embed PDFs in a **web app**
-   Build a **custom PDF viewer**
-   Avoid browser-dependent PDF plugins
-   Control UI/UX (buttons, layout, behavior)

Do **not** use PDF.js if you want:

-   PDF editing
-   Server-side PDF processing

------

## 4. How PDF.js works (conceptually)

PDF.js does **not** show PDFs directly.

Instead, it:

1.  Parses the PDF file
2.  Converts pages into drawing instructions
3.  Renders them using **Canvas or SVG**

This is why it works everywhere modern browsers work.

------

## 5. Getting PDF.js

### Option 1: Use CDN (best for beginners)

```html
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdf.js/4.0.379/pdf.min.js"></script>
```

------

### Option 2: Download from GitHub

-   Repository: `mozilla/pdf.js`
-   Use when building serious projects or offline apps

------

## 6. Your first PDF.js example (minimal)

### HTML

```html
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>PDF.js Demo</title>
</head>
<body>
  <canvas id="pdf-canvas"></canvas>

  <script src="https://cdnjs.cloudflare.com/ajax/libs/pdf.js/4.0.379/pdf.min.js"></script>
  <script src="app.js"></script>
</body>
</html>
```

------

### JavaScript (`app.js`)

```javascript
const url = 'example.pdf';

pdfjsLib.GlobalWorkerOptions.workerSrc =
  'https://cdnjs.cloudflare.com/ajax/libs/pdf.js/4.0.379/pdf.worker.min.js';

pdfjsLib.getDocument(url).promise.then(pdf => {
  return pdf.getPage(1);
}).then(page => {
  const scale = 1.5;
  const viewport = page.getViewport({ scale });

  const canvas = document.getElementById('pdf-canvas');
  const context = canvas.getContext('2d');

  canvas.height = viewport.height;
  canvas.width = viewport.width;

  const renderContext = {
    canvasContext: context,
    viewport: viewport
  };

  page.render(renderContext);
});
```

Open this HTML file in a browser and you’ll see page 1 rendered 🎉

------

## 7. Understanding the key concepts

### `getDocument()`

Loads the PDF file.

```javascript
pdfjsLib.getDocument(url)
```

------

### `getPage(pageNumber)`

Loads a specific page (1-based index).

------

### `getViewport({ scale })`

Controls zoom level.

------

### `page.render()`

Draws the page onto a `<canvas>`.

------

## 8. Rendering multiple pages

Basic idea:

```javascript
for (let i = 1; i <= pdf.numPages; i++) {
  pdf.getPage(i).then(renderPage);
}
```

Each page usually gets **its own canvas**.

------

## 9. Adding zoom support

```javascript
let scale = 1;

function renderPage(page) {
  const viewport = page.getViewport({ scale });
  ...
}

zoomInBtn.onclick = () => {
  scale += 0.2;
  renderPage(currentPage);
};
```

------

## 10. Page navigation (prev / next)

```javascript
let currentPage = 1;

function loadPage(num) {
  pdf.getPage(num).then(renderPage);
}

nextBtn.onclick = () => {
  if (currentPage < pdf.numPages) {
    currentPage++;
    loadPage(currentPage);
  }
};
```

------

## 11. Text selection & search (important!)

PDF.js separates **text layer** from **canvas**.

To enable text selection:

-   Render the **text layer**
-   Use `TextLayerBuilder`

This is how real PDF viewers work.

------

## 12. Using the built-in PDF.js viewer

If you **don’t want to write code**, PDF.js already provides a full viewer.

### Example usage:

```text
/web/viewer.html?file=example.pdf
```

Features included:

-   Zoom
-   Search
-   Page thumbnails
-   Keyboard shortcuts

Perfect for:

-   Internal tools
-   Quick embedding

------

## 13. Common beginner mistakes

❌ Forgetting `pdf.worker.js`
✅ Always set `GlobalWorkerOptions.workerSrc`

------

❌ Trying to edit PDFs
✅ PDF.js is **viewer only**

------

❌ Rendering everything on one canvas
✅ Use **one canvas per page**

------

## 14. Performance tips

-   Render pages **on demand**
-   Use `IntersectionObserver` for lazy loading
-   Avoid huge scale values
-   Cache rendered pages

------

## 15. Typical real-world use cases

-   📚 Online course materials
-   📄 Document preview systems
-   🧾 Invoice viewers
-   🔍 PDF search platforms
-   📑 Knowledge bases

------

## 16. PDF.js vs other tools

| Tool      | Purpose                      |
| --------- | ---------------------------- |
| PDF.js    | Browser PDF viewer           |
| qpdf      | PDF structure manipulation   |
| Pandoc    | Document conversion          |
| Adobe SDK | Full commercial PDF solution |

(They complement each other.)

------

## 17. Where to go next

-   Text layer & search
-   Annotations
-   Thumbnails
-   Custom toolbar UI
-   React / Vue integration