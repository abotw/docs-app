---
title: "EndNote: Ref Types"
status: done
---

## 1. What Is a Reference Type?

In **EndNote**, a **Reference Type** defines:

-   **What kind of source** a reference is (book, journal article, thesis, etc.)
-   **Which fields are available** for that source
-   **How those fields are interpreted** by citation styles

>   💡 In short:
>
>   **Reference Type = “Template” that tells EndNote how to store and format a reference**

Examples:

-   *Journal Article* → has *Journal, Volume, Issue*
-   *Book* → has *Publisher, Place Published*
-   *Thesis* → has *Degree, University*

## 2. Why Reference Type Matters (Very Important)

Choosing the **correct reference type** affects:

### ① Citation Formatting Accuracy

-   APA, MLA, Chicago, Vancouver, etc. **depend on reference type**
-   Wrong type = missing or misplaced elements

### ② Field Availability

-   Fields differ by reference type
-   Example:
    -   *Book* → **Publisher**
    -   *Journal Article* → **Journal**
    -   *Web Page* → **URL, Access Date**

### ③ Export & Compatibility

-   Bibliographies exported to Word, LaTeX, or other tools rely on reference type

## 3. Core Reference Types You Must Know

### 3.1 Journal Article (Most Common)

**Use when:** The source is published in a scholarly journal.

**Key fields**

-   Author
-   Year
-   Title
-   Journal
-   Volume
-   Issue
-   Pages
-   DOI

**Correct example**

```
Author: Smith, John
Year: 2022
Title: Language acquisition in adults
Journal: Applied Linguistics
Volume: 43
Issue: 2
Pages: 210–230
DOI: 10.xxxx/xxxx
```

❌ **Do NOT use** for:

-   Conference proceedings
-   Magazine articles (unless academic)

### 3.2 Book

**Use when:** A whole book written by one or more authors.

**Key fields**

-   Author
-   Year
-   Title
-   Publisher
-   Place Published
-   Edition

📌 For **translated books**:

-   Use **Translated Title** for the translated name
-   Original title often goes in:
    -   `Original Title` (if available), or
    -   `Title` (original) + `Translated Title`

### 3.3 Book Section (Book Chapter)

**Use when:** One chapter in an edited book.

**Key fields**

-   Author (chapter author)
-   Year
-   Title (chapter title)
-   Editor
-   Book Title
-   Pages
-   Publisher

⚠️ Common mistake:

>   ❌ Using *Book* instead of *Book Section*

### 3.4 Conference Paper / Proceedings

**Conference Paper**

-   Individual paper presented at a conference

**Conference Proceedings**

-   Whole published proceedings volume

**Key fields**

-   Author
-   Year
-   Title
-   Conference Name
-   Place Published
-   Publisher

### 3.5 Thesis / Dissertation

**Use when:** Academic degree work.

**Key fields**

-   Author
-   Year
-   Title
-   Degree
-   University
-   Place Published

Example:

```
Degree: PhD dissertation
University: University of Cambridge
```

### 3.6 Web Page

**Use when:** Online-only sources without formal publication structure.

**Key fields**

-   Author / Corporate Author
-   Year
-   Title
-   URL
-   Access Date

⚠️ Use sparingly for academic writing if a better type exists.

### 3.7 Report

**Use when:** Institutional or government publications.

**Key fields**

-   Author / Institution
-   Year
-   Title
-   Report Number
-   Publisher
-   URL (optional)

Examples:

-   OECD reports
-   Government white papers

## 4. Less Common but Useful Reference Types

| Reference Type       | Use Case              |
| -------------------- | --------------------- |
| Magazine Article     | Popular magazines     |
| Newspaper Article    | Newspapers            |
| Preprint             | arXiv / bioRxiv       |
| Dataset              | Research data         |
| Software             | Software tools        |
| Patent               | Patent documents      |
| Manuscript           | Unpublished work      |
| Map                  | Cartographic material |
| Audiovisual Material | Videos, films         |

## 5. How EndNote Chooses Fields (Behind the Scenes)

-   Each reference type has a **fixed field structure**
-   Citation styles decide:
    -   which fields are used
    -   in what order
    -   with what punctuation

Example:

-   APA style:
    -   Uses *DOI* for Journal Article
    -   Ignores *URL* if DOI exists

## 6. Custom Reference Types (Advanced)

You can **customize reference types**, but with caution.

### Where to configure:

**EndNote → Settings / Preferences → Reference Types**

You can:

-   Rename reference types
-   Enable / disable types
-   Add custom fields

⚠️ **Best practice**

-   Do **NOT** heavily customize if:
    -   You sync across devices
    -   You collaborate with others
    -   You submit manuscripts to journals

## 7. Choosing the Right Reference Type (Decision Guide)

| Source                  | Correct Type     |
| ----------------------- | ---------------- |
| Journal PDF             | Journal Article  |
| Book (whole)            | Book             |
| Chapter in edited book  | Book Section     |
| arXiv paper             | Preprint         |
| Government PDF          | Report           |
| Blog post               | Web Page         |
| Master’s / PhD work     | Thesis           |
| Conference presentation | Conference Paper |

## 8. Common Mistakes (Very Common)

❌ Using **Journal Article** for everything

❌ Putting journal name in *Publisher*

❌ Using *Web Page* for published PDFs

❌ Mixing Book and Book Section

❌ Ignoring DOI field

## 9. Expert Best Practices

✔ Always choose the **most specific reference type**

✔ Fill **all relevant fields**, not just the minimum

✔ Keep **one consistent rule** for translated works

✔ Use **DOI whenever available**

✔ Fix reference type **before** writing the paper

## 10. Final Mental Model

>   **Reference Type = Structure**
>
>   **Fields = Data**
>
>   **Citation Style = Presentation**

