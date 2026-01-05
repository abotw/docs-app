# MkDocs

-   <https://shafish.cn/blog/mkdocs/>
-   <https://note.tonycrane.cc/cs/tools/mkdocs/>

## **1. What is MkDocs?**

MkDocs is a **static site generator** specifically for **project documentation**. It takes Markdown files and converts them into a fully navigable website. Key points:

* Uses **Markdown** for writing content.
* Provides **themes** to make your docs look nice.
* Can be hosted easily on **GitHub Pages** or other static site hosts.
* Good for **software projects, personal docs, knowledge bases**.

---

## **2. Installing MkDocs**

MkDocs is written in Python, so you need Python installed (version ≥ 3.7).

**Step 1: Check Python**

```bash
python3 --version
```

**Step 2: Install MkDocs via pip**

```bash
pip install mkdocs
```

**Step 3: Verify installation**

```bash
mkdocs --version
```

You should see something like:

```
mkdocs, version 1.x.x
```

---

## **3. Creating a New MkDocs Project**

**Step 1: Create a new project**

```bash
mkdocs new my-docs
cd my-docs
```

This creates a structure like:

```
my-docs/
    mkdocs.yml      # configuration file
    docs/
        index.md    # main page in Markdown
```

**Step 2: Serve the site locally**

```bash
mkdocs serve
```

Open `http://127.0.0.1:8000/` in your browser. You now see your documentation website **live locally**. Changes you make to `.md` files are reflected immediately.

---

## **4. Editing Documentation**

Inside the `docs/` folder:

* `index.md` → homepage
* You can create more Markdown files, e.g., `about.md`, `setup.md`

**Example `about.md`:**

```markdown
# About This Project

This project is a sample documentation site using MkDocs.

## Features

- Easy to write
- Supports Markdown
- Can be published online
```

---

## **5. Configuring Navigation**

Edit `mkdocs.yml` to set up your sidebar navigation:

```yaml
site_name: My Docs
nav:
  - Home: index.md
  - About: about.md
```

Optional settings:

* `site_url` → base URL for hosting.
* `theme` → choose a theme, e.g., `readthedocs` or `material`.

**Example using Material theme:**

```yaml
theme:
  name: material
```

---

## **6. Previewing Your Site**

Run again:

```bash
mkdocs serve
```

Then visit `http://127.0.0.1:8000/`.

---

## **7. Building the Static Site**

Once ready for deployment:

```bash
mkdocs build
```

This generates a `site/` folder with **all static HTML files**. You can now host it anywhere (GitHub Pages, Netlify, etc.).

---

## **8. Deploying to GitHub Pages**

**Step 1: Initialize git in your project**

```bash
git init
git add .
git commit -m "Initial docs"
```

**Step 2: Deploy**

```bash
mkdocs gh-deploy
```

This will:

* Build the site
* Push it to `gh-pages` branch of your repo
* Your docs are now live at `https://username.github.io/repo-name/`

---

## **9. Adding More Features**

* **Search**: Enabled by default in Material theme.
* **Markdown extensions**: e.g., tables, footnotes
* **Plugins**: e.g., `mkdocs-awesome-pages-plugin`, `mkdocs-mermaid2-plugin` for diagrams
* **Themes**: Material, ReadTheDocs, Cinder, etc.

Install plugins via pip and add them to `mkdocs.yml`:

```yaml
plugins:
  - search
  - awesome-pages
```

---

## **10. Tips for Beginners**

* Keep your Markdown files organized in folders.
* Use `mkdocs serve` often to preview changes.
* Start simple with default theme, switch to Material once comfortable.
* Use GitHub Pages for free hosting.
* Explore Markdown extensions to enrich your docs.

---

## ✅ **Summary Workflow**

```bash
# 1. Create project
mkdocs new my-docs
cd my-docs

# 2. Serve locally
mkdocs serve

# 3. Add/edit docs in docs/*.md
# 4. Update mkdocs.yml for nav/theme

# 5. Build static site
mkdocs build

# 6. Deploy online
mkdocs gh-deploy
```