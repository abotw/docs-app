# Make & Makefile

## 1. What is `make`?

`make` is a **build automation tool**.
It is mainly used to **compile programs**, but it can automate **any repetitive command-line task**.

Typical use cases:

-   Compile C / C++ programs
-   Build projects with multiple source files
-   Run tests
-   Clean generated files
-   Automate workflows

Instead of typing long commands every time, you write rules once in a file called **Makefile**, then run:

```bash
make
```

------

## 2. Why use `make`?

Without `make` (example in C):

```bash
gcc main.c util.c math.c -o app
```

Problems:

-   Long commands
-   Easy to forget flags
-   Recompiles everything even if only one file changed

With `make`:

-   Only rebuilds **what changed**
-   Commands are documented
-   One command: `make`

------

## 3. What is a Makefile?

A **Makefile** is a text file named exactly:

```text
Makefile
```

or

```text
makefile
```

It contains **rules** that tell `make`:

-   **what** to build
-   **how** to build it
-   **when** to rebuild it

------

## 4. Basic Makefile Structure

A rule looks like this:

```makefile
target: dependencies
<TAB>command
```

⚠️ **Important**:

-   The command **must start with a TAB**, not spaces.

### Example:

```makefile
hello:
	echo "Hello, Make!"
```

Run it:

```bash
make hello
```

Output:

```text
Hello, Make!
```

------

## 5. Your First Real Example (C Program)

### Files:

```
.
├── main.c
└── Makefile
```

### `main.c`

```c
#include <stdio.h>

int main() {
    printf("Hello, Make!\n");
    return 0;
}
```

### `Makefile`

```makefile
app: main.c
	gcc main.c -o app
```

Run:

```bash
make
```

Result:

```text
gcc main.c -o app
```

Now run your program:

```bash
./app
```

------

## 6. Targets, Dependencies, Commands (Core Idea)

```makefile
app: main.c
	gcc main.c -o app
```

-   **Target**: `app` (what you want)
-   **Dependency**: `main.c` (what it depends on)
-   **Command**: how to build it

Meaning:

>   If `main.c` changes, rebuild `app`.

------

## 7. Multiple Source Files

### Files:

```
.
├── main.c
├── util.c
├── util.h
└── Makefile
```

### Makefile (simple version)

```makefile
app: main.o util.o
	gcc main.o util.o -o app

main.o: main.c util.h
	gcc -c main.c

util.o: util.c util.h
	gcc -c util.c
```

Run:

```bash
make
```

Only changed `.c` files are recompiled.

------

## 8. Variables (Very Important)

Variables make Makefiles **clean and reusable**.

### Example:

```makefile
CC = gcc
CFLAGS = -Wall -g
TARGET = app

$(TARGET): main.c
	$(CC) $(CFLAGS) main.c -o $(TARGET)
```

Use variables with:

```makefile
$(VARIABLE_NAME)
```

------

## 9. Common Built-in Variables

| Variable   | Meaning          |
| ---------- | ---------------- |
| `CC`       | C compiler       |
| `CXX`      | C++ compiler     |
| `CFLAGS`   | C compiler flags |
| `CXXFLAGS` | C++ flags        |
| `LDFLAGS`  | Linker flags     |

------

## 10. Automatic Variables

Very useful shortcuts:

| Variable | Meaning          |
| -------- | ---------------- |
| `$@`     | Target name      |
| `$<`     | First dependency |
| `$^`     | All dependencies |

### Example:

```makefile
app: main.c
	gcc $< -o $@
```

------

## 11. Default Target

The **first target** in a Makefile is the default:

```makefile
all: app
```

Running:

```bash
make
```

is the same as:

```bash
make all
```

------

## 12. Phony Targets (`.PHONY`)

Some targets are **not files** (like `clean`).

```makefile
.PHONY: clean

clean:
	rm -f *.o app
```

Run:

```bash
make clean
```

------

## 13. A Clean & Practical Makefile (Recommended)

```makefile
CC = gcc
CFLAGS = -Wall -g
TARGET = app
OBJS = main.o util.o

$(TARGET): $(OBJS)
	$(CC) $(OBJS) -o $(TARGET)

%.o: %.c
	$(CC) $(CFLAGS) -c $< -o $@

.PHONY: clean
clean:
	rm -f $(OBJS) $(TARGET)
```

------

## 14. How `make` Decides What to Rebuild

`make` compares:

-   file **timestamps**

Rules:

-   If a dependency is **newer** than the target → rebuild
-   If target does not exist → build

This is why `make` is fast.

------

## 15. Common Beginner Mistakes

❌ Using spaces instead of TAB
❌ Forgetting `.PHONY`
❌ Hardcoding commands everywhere
❌ One giant rule instead of multiple rules

------

## 16. When Should You Learn `make`?

You should use `make` if:

-   You write C / C++
-   You compile projects often
-   You want reproducible builds
-   You use Linux / macOS

------

## 17. What to Learn Next

After basics, explore:

-   Pattern rules (`%.o: %.c`)
-   Include dependencies (`-MMD`)
-   Recursive make
-   Make vs CMake vs Meson

------

## 18. One-Sentence Summary

>   **Make is a tool that rebuilds only what is necessary, using rules written in a Makefile.**