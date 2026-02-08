---
title: "EndNote: Book"
status: done
---

Book Reference Type (with a Focus on Chinese Books)

## 1. What is “Book” in EndNote?

The **Book** reference type is used for:

-   📘 **Monographs / 专著**
-   📚 Single-volume books
-   📕 Translated books (中译本 / 外文译本)

**Do NOT use Book for:**

-   Chapters in edited books → use **Book Section**
-   Conference proceedings → use **Conference Proceedings**
-   Series volumes with editors only → usually **Edited Book**

## 2. Core Fields of “Book” (Must Know)

### 2.1 Author

**Purpose**

The main intellectual responsibility of the book.

**Chinese books – best practice**

-   Enter **拼音 or 原文中文**, but be consistent across your library.
-   Recommended for international journals: **拼音**

**Format**

```
Li, Ming
Wang, Xiaohong
```

**If you use Chinese characters**

```
李明
王晓红
```

⚠️ **Do not mix** Chinese and pinyin within the same library.

### 2.2 Year

-   Use **numeric year only**

```
2021
```

⚠️ Do NOT include “年”.

### 2.3 Title

**Chinese books**

-   Enter **完整书名（含副标题）**

```
中国现代史研究：方法与视角
```

**English books**

```
The History of Modern China
```

⚠️ No quotation marks. EndNote styles handle formatting.

### 2.4 Place Published

**Chinese convention**

```
北京
上海
```

**English convention**

```
Beijing
Shanghai
```

⚠️ Match the language you use for Publisher.

### 2.5 Publisher

**Chinese books**

```
人民出版社
商务印书馆
```

**English translation styles**

```
People’s Publishing House
Commercial Press
```

✔ For **GB/T 7714**, Chinese names are preferred.

## 3. Fields Especially Important for Chinese Books

### 3.1 Edition

Use **numbers only**, not text.

✔ Correct:

```
2
```

❌ Wrong:

```
第二版
2nd Edition
```

EndNote styles will output:

-   第2版
-   2nd ed.

automatically.

### 3.2 Translator

For **translated books**, this is critical.

**Format**

```
Zhang, Wei
```

or Chinese:

```
张伟
```

📌 The **Author remains the original author**, not the translator.

### 3.3 Translated Title

This field is **very useful for Chinese books**.

#### Recommended usage

| Scenario           | What to put here |
| ------------------ | ---------------- |
| 中文译本           | 原书英文名       |
| 英文论文引用中文书 | 中文书名         |
| 双语参考文献       | 辅助标题         |

**Example**

-   Title:

```
社会契约论
```

-   Translated Title:

```
The Social Contract
```

⚠️ Output depends on citation style support.

### 3.4 Original Publication

Use this for:

-   Original publication year
-   Original publisher (optional)

Example:

```
1762, Amsterdam
```

Used mostly in **humanities citation styles**.

## 4. Less Obvious but Useful Fields

### 4.1 ISBN

Helpful for:

-   De-duplication
-   Metadata checks

Example:

```
978-7-01-020123-4
```

### 4.2 Language

Highly recommended for Chinese books.

```
Chinese
```

Some styles use this to append:

```
[In Chinese]
```

### 4.3 Short Title

Use for:

-   Footnote styles
-   Repeated citations

Example:

```
中国现代史研究
```

## 5. Example: Correctly Entered Chinese Book

### Example 1 — Original Chinese Book

| Field           | Content        |
| --------------- | -------------- |
| Reference Type  | Book           |
| Author          | 李明           |
| Year            | 2019           |
| Title           | 中国近代思想史 |
| Place Published | 北京           |
| Publisher       | 商务印书馆     |
| Edition         | 1              |
| Language        | Chinese        |

### Example 2 — Translated Book (Chinese Edition)

| Field            | Content                |
| ---------------- | ---------------------- |
| Reference Type   | Book                   |
| Author           | Rousseau, Jean-Jacques |
| Year             | 2003                   |
| Title            | 社会契约论             |
| Translated Title | The Social Contract    |
| Translator       | 何兆武                 |
| Place Published  | 北京                   |
| Publisher        | 商务印书馆             |
| Language         | Chinese                |

## 6. Common Mistakes (Very Important)

❌ Putting editors into **Author** for edited volumes

→ Use **Editor** field instead.

❌ Writing “第2版” in Edition

→ Use **2** only.

❌ Using **Book** for a chapter

→ Use **Book Section**.

❌ Mixing Chinese & English punctuation randomly

→ Let **EndNote styles** handle punctuation.

## 7. Chinese Citation Style Notes (GB/T 7714)

If you use **GB/T 7714-2015**:

-   Book format:

```
作者. 书名[M]. 出版地: 出版社, 年.
```

EndNote **can output this correctly**, but **only if fields are clean**.

## 8. Recommended Workflow for Chinese Users

1.  Decide early:
    -   全中文库 **or**
    -   拼音 + 英文
2.  Be consistent with:
    -   Names
    -   Place & Publisher language
3.  Always fill:
    -   Language
    -   Edition
    -   Translator (if any)
4.  Use **Translated Title** wisely for bilingual clarity

