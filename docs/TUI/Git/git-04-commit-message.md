---
status: done
---

# Git-04: Commit Messages

## 1. Why Commit Messages Matter

A Git commit message is not just a note for yourself — it’s a **communication tool** for:

-   Your future self (3 months later 😅)
-   Your teammates
-   Code reviewers
-   Debugging and `git bisect`
-   Understanding project history (`git log`)

**Bad commit message**

```
fix stuff
```

**Good commit message**

```
fix login failure when password contains spaces
```

Good messages save time, reduce confusion, and make projects easier to maintain.

## 2. The Basic Structure of a Commit Message

A well-written commit message usually has this structure:

```
<subject>

<body>
```

Example:

```
add password length validation

Reject passwords shorter than 8 characters
during user registration.
```

### Rules at a glance

-   **Subject line**: short, clear, one line
-   **Body**: optional, explains *what* and *why*
-   Separate subject and body with a **blank line**

## 3. Writing a Good Subject Line (Most Important)

### 3.1 Use the Imperative Mood

Write the subject like a command.

✅ Correct:

```
add user authentication
fix memory leak
remove unused config
```

❌ Incorrect:

```
added user authentication
fixes memory leak
removed unused config
```

👉 Think:

>   “If applied, this commit will **add**, **fix**, or **remove** something.”

### 3.2 Keep It Short (≤ 50 characters)

Good:

```
fix crash when opening empty file
```

Too long:

```
fix an issue where the application crashes when the user tries to open an empty file
```

Short messages are easier to scan in `git log`.

### 3.3 Be Specific, Not Vague

❌ Bad:

```
update code
fix bug
change logic
```

✅ Good:

```
fix null pointer in config loader
update README installation steps
change retry logic for network requests
```

### 3.4 Don’t End with a Period

✅

```
add user profile page
```

❌

```
add user profile page.
```

This is a widely followed convention.

## 4. Writing the Commit Body (When Needed)

You **don’t always need a body**.
Add one when the change is:

-   Non-obvious
-   Complex
-   Bug-related
-   Design-related

### 4.1 What to Write in the Body

Answer these questions:

-   **What** changed?
-   **Why** was it changed?
-   **How** does it fix the problem?

Example:

```
fix incorrect timeout calculation

The timeout was calculated in seconds but
used as milliseconds, causing premature
request failures.
```

### 4.2 Formatting Rules for the Body

-   Wrap lines at **72 characters**
-   Use full sentences
-   Keep it readable

## 5. Common Commit Message Patterns

### 5.1 Feature

```
add dark mode toggle
```

### 5.2 Bug Fix

```
fix crash when config file is missing
```

### 5.3 Refactor (no behavior change)

```
refactor user service initialization
```

### 5.4 Documentation

```
update README with Docker instructions
```

### 5.5 Tests

```
add tests for login validation
```

## 6. Using Commit Types (Optional but Popular)

Some projects use a **type prefix**:

```
type: subject
```

Common types:

-   `feat` – new feature
-   `fix` – bug fix
-   `docs` – documentation
-   `refactor` – code restructuring
-   `test` – tests
-   `chore` – tooling, configs

Examples:

```
feat: add search API
fix: handle empty input correctly
docs: update contribution guide
```

⚠️ Use this **only if your project/team agrees**.

## 7. Real Examples: Bad vs Good

### Example 1

❌

```
bug fix
```

✅

```
fix division by zero in average score calculation
```

### Example 2

❌

```
update
```

✅

```
update dependencies to latest versions
```

### Example 3

❌

```
final version
```

✅

```
remove debug logs from production build
```

## 8. How to Write Commit Messages in Practice

### Command line

```
git commit
```

This opens an editor so you can write:

```
add file upload validation

Reject files larger than 10MB to
prevent server overload.
```

### One-line commit (small changes)

```
git commit -m "fix typo in error message"
```

## 9. A Simple Checklist Before You Commit

Before pressing save, ask yourself:

-    Does the subject explain **what** changed?
-    Is it short and clear?
-    Is it written in imperative mood?
-    Would a teammate understand it without context?

If yes → ✅ good commit message.

## 10. Summary (Golden Rules)

-   One commit = one clear purpose
-   Subject line is the most important part
-   Be clear, specific, and concise
-   Write commit messages for **humans**, not Git

>   **Good code matters.
>   Good commit messages make good code maintainable.**

