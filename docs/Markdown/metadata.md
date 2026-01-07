---
status: done
---

# Markdown: Metadata

-   <https://squidfunk.github.io/mkdocs-material/tutorials/blogs/basic/?h=metadata#post-metadata>

## 1. What Is Markdown Metadata?

**Markdown metadata** is **structured information placed at the top of a Markdown file**.
It describes the document **itself**, not the document’s content.

Think of it as:

>   “Information *about* the document, not *in* the document.”

Typical metadata includes:

-   Title
-   Author
-   Date
-   Tags / categories
-   Draft status
-   Language
-   Custom fields used by tools

This metadata is usually written in a block called **front matter**.

------

## 2. Why Do We Need Metadata?

Plain Markdown is great for text, but it doesn’t answer questions like:

-   What is the title of this document?
-   Who wrote it?
-   When was it published?
-   Is this a draft or a final version?
-   How should a website or note app organize it?

Metadata solves this by:

-   Helping **static site generators** (Jekyll, Hugo, MkDocs)
-   Helping **note systems** (Obsidian, Logseq)
-   Helping **document converters** (Pandoc)
-   Enabling **automation and organization**

------

## 3. Where Does Metadata Go?

Metadata is **always placed at the very top of the file**, before any Markdown content.

```markdown
---
title: My First Markdown File
author: Alice
date: 2026-01-07
---
```

After this block, normal Markdown begins.

------

## 4. The Three Most Common Metadata Formats

### 4.1 YAML Front Matter (Most Popular)

**YAML** is the most widely supported format.

#### Syntax

-   Starts with `---`
-   Ends with `---`
-   Uses `key: value` pairs

```markdown
---
title: Markdown Metadata Tutorial
author: Matt Li
date: 2026-01-07
tags:
  - markdown
  - tutorial
  - metadata
draft: false
---
```

#### Key Rules

-   Indentation matters
-   Use spaces, not tabs
-   Lists start with `-`

------

### 4.2 TOML Front Matter (Used by Hugo)

**TOML** is stricter and more explicit.

```markdown
+++
title = "Markdown Metadata Tutorial"
author = "Matt Li"
date = 2026-01-07
tags = ["markdown", "tutorial", "metadata"]
draft = false
+++
```

**Pros**

-   Very clear syntax
-   Less ambiguity

**Cons**

-   Less commonly supported than YAML

------

### 4.3 JSON Front Matter (Rare but Valid)

```markdown
{
  "title": "Markdown Metadata Tutorial",
  "author": "Matt Li",
  "date": "2026-01-07",
  "tags": ["markdown", "tutorial"]
}
```

**Mostly used by**: Pandoc or custom tooling.

------

## 5. Common Metadata Fields (De Facto Standard)

| Field        | Meaning                  |
| ------------ | ------------------------ |
| `title`      | Document title           |
| `author`     | Author name              |
| `date`       | Creation or publish date |
| `tags`       | Keywords                 |
| `categories` | Grouping                 |
| `draft`      | Draft or published       |
| `summary`    | Short description        |
| `lang`       | Language                 |

Example:

```yaml
---
title: SSH Beginner Guide
author: Matt Li
lang: en
tags: [ssh, linux, networking]
draft: true
---
```

------

## 6. How Different Tools Use Metadata

### 6.1 Static Site Generators

#### Jekyll / MkDocs / Hugo

Metadata controls:

-   Page title
-   URL
-   Navigation
-   Theme behavior

```yaml
---
title: About Me
layout: page
permalink: /about/
---
```

------

### 6.2 Obsidian / Knowledge Bases

Obsidian treats metadata as **properties**.

```yaml
---
type: note
status: learning
review: 2026-02-01
---
```

You can:

-   Filter notes
-   Query metadata
-   Build dashboards

------

### 6.3 Pandoc (Document Conversion)

Pandoc metadata affects:

-   PDF title
-   Word document properties
-   LaTeX headers

```yaml
---
title: Operating Systems Notes
author: Matt Li
geometry: margin=2cm
---
```

------

## 7. Accessing Metadata Programmatically

### Example: Python + YAML

```python
import yaml

with open("note.md") as f:
    content = f.read()

front_matter = content.split('---')[1]
data = yaml.safe_load(front_matter)

print(data["title"])
```

This is common in:

-   Static site pipelines
-   Note exporters
-   Search tools

------

## 8. Metadata vs Headings (Important Distinction)

❌ **Not metadata**

```markdown
# My Title
```

✅ **Metadata**

```yaml
---
title: My Title
---
```

Why?

-   Headings are content
-   Metadata is machine-readable structure

------

## 9. Best Practices

1.  **Keep metadata minimal**
2.  **Be consistent across files**
3.  **Use ISO dates** (`YYYY-MM-DD`)
4.  **Avoid spaces in custom keys**
5.  **Document your custom fields**

Good:

```yaml
reading_time: 10
```

Bad:

```yaml
Reading Time: 10
```

------

## 10. When You Don’t Need Metadata

You probably **don’t need metadata** if:

-   Writing a simple README
-   Sharing a short snippet
-   Writing plain notes with no tooling

Use metadata when:

-   You manage many documents
-   You publish or export content
-   You want automation

------

## 11. Minimal Example (Recommended for Beginners)

```markdown
---
title: My Notes
tags: [study, markdown]
---

# Introduction

This is my note content.
```

That’s enough for most use cases.

------

## 12. Summary

-   Markdown metadata = **structured info about a document**
-   Usually written as **YAML front matter**
-   Used by **sites, notes, converters, scripts**
-   Powerful but optional