# GitHub Actions

## 1. What Is GitHub Actions?

**GitHub Actions** is GitHub’s built-in **CI/CD (Continuous Integration / Continuous Deployment)** system.

In simple terms, it allows you to:

-   Automatically **run commands** when something happens in your repository
-   Examples:
    -   Run tests when you push code
    -   Build a project when you open a Pull Request
    -   Deploy code after merging to `main`

Think of it as:

>   “When **X** happens → automatically do **Y**”

## 2. Key Concepts (Very Important)

Before writing anything, you must understand these 5 concepts.

### 2.1 Workflow

A **workflow** is an automated process.

-   Defined in a YAML file

-   Stored in:

    ```
    .github/workflows/
    ```

Example:

```
.github/workflows/ci.yml
```

### 2.2 Event (Trigger)

An **event** tells GitHub **when to run** the workflow.

Common events:

-   `push` → when you push code
-   `pull_request` → when a PR is opened
-   `workflow_dispatch` → manual trigger (click button)

Example:

```yaml
on: push
```

### 2.3 Job

A **job** is a group of steps that run on the **same machine**.

-   A workflow can have multiple jobs
-   Jobs run **in parallel by default**

Example:

```yaml
jobs:
  build:
    runs-on: ubuntu-latest
```

### 2.4 Step

A **step** is a single task inside a job.

-   Run a command
-   Or use an existing **action**

Example:

```yaml
steps:
  - run: echo "Hello"
```

### 2.5 Action

An **action** is a reusable step written by someone else.

Example:

```yaml
- uses: actions/checkout@v4
```

This action:

-   Clones your repository into the runner

## 3. Your First GitHub Actions Workflow

Let’s create a **Hello World** workflow.

### Step 1: Create the Workflow File

In your repository:

```bash
mkdir -p .github/workflows
touch .github/workflows/hello.yml
```

### Step 2: Write the Workflow

Open `hello.yml` and write:

```yaml
name: Hello GitHub Actions

on: push

jobs:
  say-hello:
    runs-on: ubuntu-latest

    steps:
      - name: Print message
        run: echo "Hello, GitHub Actions!"
```

### Step 3: Push to GitHub

```bash
git add .github/workflows/hello.yml
git commit -m "Add first GitHub Actions workflow"
git push
```

### Step 4: View the Result

1.  Open your repository on GitHub
2.  Click **Actions**
3.  Click your workflow
4.  See the logs 🎉

## 4. Understanding the YAML Structure

```yaml
name: Workflow name

on: event

jobs:
  job-id:
    runs-on: runner
    steps:
      - name: Step name
        run: command
```

| Field     | Meaning           |
| --------- | ----------------- |
| `name`    | Workflow name     |
| `on`      | Trigger event     |
| `jobs`    | All jobs          |
| `runs-on` | OS for the runner |
| `steps`   | Tasks in order    |

## 5. Common Triggers

### 5.1 On Push to a Branch

```yaml
on:
  push:
    branches:
      - main
```

### 5.2 On Pull Request

```yaml
on: pull_request
```

### 5.3 Manual Trigger

```yaml
on: workflow_dispatch
```

This adds a **Run workflow** button.

## 6. Using Marketplace Actions

GitHub has an **Actions Marketplace**.

### Example: Checkout Code

```yaml
- uses: actions/checkout@v4
```

Almost **every workflow needs this**.

### Example: Setup Node.js

```yaml
- uses: actions/setup-node@v4
  with:
    node-version: '20'
```

## 7. Example: Run Tests Automatically

Example for a Node.js project:

```yaml
name: Node CI

on: push

jobs:
  test:
    runs-on: ubuntu-latest

    steps:
      - uses: actions/checkout@v4

      - uses: actions/setup-node@v4
        with:
          node-version: '20'

      - run: npm install
      - run: npm test
```

## 8. Runners (Where Code Runs)

GitHub provides **hosted runners**:

-   `ubuntu-latest`
-   `windows-latest`
-   `macos-latest`

Example:

```yaml
runs-on: ubuntu-latest
```

## 9. Environment Variables

### 9.1 Define Variables

```yaml
env:
  APP_NAME: demo
```

### 9.2 Use Variables

```yaml
run: echo $APP_NAME
```

## 10. Secrets (Very Important)

Never hard-code passwords.

### Step 1: Add Secret

-   Repo → Settings → Secrets → Actions
-   Add:
    -   Name: `TOKEN`
    -   Value: `xxxxx`

### Step 2: Use Secret

```yaml
run: echo "${{ secrets.TOKEN }}"
```

## 11. Common Beginner Mistakes

❌ Forgetting `actions/checkout`

❌ Wrong YAML indentation

❌ Assuming jobs run in order

❌ Putting secrets directly in YAML

## 12. When Should You Use GitHub Actions?

Use it when you want to:

-   Run tests automatically
-   Build firmware / binaries
-   Lint code
-   Auto-deploy
-   Schedule tasks

## 13. Learning Path (Recommended)

1.  Understand workflow structure
2.  Learn triggers (`push`, `PR`)
3.  Learn popular actions
4.  Learn secrets
5.  Learn multi-job workflows

## 14. Summary

-   GitHub Actions = automation for GitHub
-   Workflow = YAML file
-   Event → Job → Steps
-   Extremely powerful and free for small projects