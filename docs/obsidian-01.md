---
name: "Obsidian-01: Intro"
icon: simple/obsidian
---

## 1. What Is Obsidian?

**Obsidian** is a **local, Markdown-based note-taking app** designed for building a **personal knowledge base**.

Key ideas:

-   Your notes are **plain text files (`.md`)**
-   Notes live in **folders on your computer**
-   You can **link notes together** like a wiki
-   Obsidian helps you **think in connections**, not just folders

Think of Obsidian as:

>   **Finder + Markdown + Wiki + Knowledge Graph**

------

## 2. Why Choose Obsidian?

### Advantages

-   📁 **Local first** (your data is yours)
-   ⚡ Very fast
-   🔗 Powerful linking between notes
-   🧩 Huge plugin ecosystem
-   🖥 Works on macOS / Windows / Linux / Mobile

### Who Is It For?

-   Students (CS, engineering, languages, exams)
-   Researchers
-   Programmers
-   Writers
-   Anyone who wants structured thinking

------

## 3. Installing Obsidian

1.  Go to **[https://obsidian.md](https://obsidian.md/)**
2.  Download for your OS
3.  Install and launch

No account required.

------

## 4. Vault: The Core Concept

When Obsidian starts, it asks you to create or open a **Vault**.

### What is a Vault?

A **Vault = a normal folder** on your computer.

Inside:

-   Notes (`.md` files)
-   Subfolders
-   Attachments (images, PDFs)

You can:

-   Open the folder with Finder / Explorer
-   Back it up with Git, iCloud, OneDrive, etc.

📌 **Important**: Obsidian does not lock your data.

------

## 5. Markdown Basics (Enough to Start)

Obsidian uses **Markdown**, but you only need a little.

### Headings

```md
# Title
## Section
### Subsection
```

### Bold / Italic

```md
**bold**
*italic*
```

### Lists

```md
- item
- item

1. first
2. second
```

### Code

~~~md
`inline code`

```python
print("Hello")
---

## 6. Creating Notes

### Method 1: New Note Button
- Click **New note**
- Type a name
- Start writing

### Method 2: Quick Create
- Press `Cmd + N` (macOS)
- Press `Ctrl + N` (Windows/Linux)

---

## 7. Linking Notes (The Soul of Obsidian)

### Basic Link
```md
[[Computer Organization]]
~~~

-   If the note exists → link
-   If not → Obsidian offers to create it

### Why This Is Powerful

-   No fixed hierarchy
-   One note can belong to many topics
-   Your knowledge grows organically

Example:

```md
CPU scheduling is discussed in [[Operating System]].
```

------

## 8. Backlinks (Automatic Context)

Open any note and you’ll see **Backlinks**:

>   “Which notes mention this note?”

This means:

-   You don’t have to organize everything upfront
-   Obsidian builds context automatically

------

## 9. Graph View (Optional but Fun)

-   Click **Graph View**
-   See notes as dots, links as lines

Good for:

-   Big-picture understanding
-   Finding isolated notes
-   Motivation 😄

⚠️ Don’t over-focus on it early.

------

## 10. Folder vs Linking (Beginner Rule)

**Use folders lightly.**

Recommended:

```
Notes/
  Inbox/
  Courses/
  Projects/
  Daily/
```

Let **links** do the real organization.

Rule of thumb:

>   Folders = coarse structure
>   Links = real thinking

------

## 11. Tags (#)

Tags are lightweight labels.

```md
#os #exam #important
```

Use for:

-   Status (`#todo`, `#draft`)
-   Type (`#definition`, `#example`)
-   Priority (`#important`)

Don’t replace links with tags.

------

## 12. Daily Notes (Highly Recommended)

Enable:

-   Settings → Core plugins → Daily notes

Why?

-   Low friction writing
-   Logs your thinking
-   Natural backlinks later

Example:

```md
## Today
- Studied [[Instruction Pipeline]]
- Confused about [[Cache Coherence]]
```

------

## 13. Must-Have Settings for Beginners

### Editor

-   Enable **Live Preview**
-   Enable **Spell check**

### Files & Links

-   New link format: `[[Note Name]]`
-   Attachment folder: `assets/`

------

## 14. Beginner Plugin Suggestions

Start simple.

### Core Plugins

-   Backlinks ✅
-   Daily Notes ✅
-   Command Palette ✅

### Community Plugins (Optional)

-   **Calendar** – daily notes navigation
-   **Omnisearch** – better search
-   **Table of Contents** – auto headings

⚠️ Avoid plugin overload early.

------

## 15. A Simple Workflow Example

### Studying a Course

1.  Create a course note
    `[[Operating System]]`
2.  Create topic notes
    `[[Process]]`, `[[Thread]]`, `[[Scheduling]]`
3.  Link them naturally
4.  Review backlinks before exams

------

## 16. Common Beginner Mistakes

❌ Over-structuring folders
❌ Writing very long notes
❌ Obsessing over graph view
❌ Installing too many plugins
❌ Trying to be “perfect”

✅ Start messy
✅ Write small notes
✅ Link naturally
✅ Improve gradually

------

## 17. Obsidian Mindset

Think less about:

>   “Where should this note go?”

Think more about:

>   “What does this note connect to?”

That’s the Obsidian way.