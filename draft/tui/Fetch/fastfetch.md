# Fastfetch

As a Linux enthusiast, I’m happy to introduce you to **Fastfetch**. If you’ve spent any time in the Linux community, you’ve likely seen screenshots of terminals displaying a colorful ASCII distro logo alongside system specs. For years, **Neofetch** was the king of this, but since it is no longer actively maintained, **Fastfetch** has taken the throne.

Fastfetch is written in C, making it significantly faster and more feature-rich than its predecessor. Here is a beginner's guide to getting it up and running.

## 1. Installation

Fastfetch is available in the official repositories of almost every major Linux distribution. Use the command that matches your system:

| Distribution         | Command                         |
| -------------------- | ------------------------------- |
| **Ubuntu / Debian**  | `sudo apt install fastfetch`    |
| **Arch Linux**       | `sudo pacman -S fastfetch`      |
| **Fedora**           | `sudo dnf install fastfetch`    |
| **openSUSE**         | `sudo zypper install fastfetch` |
| **macOS (Homebrew)** | `brew install fastfetch`        |

## 2. Basic Usage

Once installed, simply type the command to see your system information:

```Bash
fastfetch
```

This will display your OS, Kernel version, Uptime, Packages, Shell, Resolution, DE/WM, CPU, GPU, and Memory.

### Try a Preset

If you want to see everything Fastfetch can possibly detect, run the "all" preset:

```Bash
fastfetch -c all.jsonc
```

## 3. Customizing Your Look

The real fun begins when you start tweaking the output.

### Change the Logo

Don't like your default distro logo? You can force another one or use a small version:

-   **List all logos:** `fastfetch --list-logos`
-   **Use a specific logo:** `fastfetch -l fedora`
-   **Use a small logo:** `fastfetch -l ubuntu_small`

### Generate a Config File

To make your changes permanent, you need a configuration file. Fastfetch uses the **JSONC** format (JSON with comments).

1.  **Generate the default config:**

    ```Bash
    fastfetch --gen-config
    ```

2.  **Edit the file:** The file is located at `~/.config/fastfetch/config.jsonc`. You can open it with any text editor (like Nano or VS Code):

    ```Bash
    nano ~/.config/fastfetch/config.jsonc
    ```

In this file, you can reorder modules, change colors, or add custom "Command" modules to show things like your local weather or the age of your Linux installation.

## 4. Run Fastfetch Automatically

Most users like to see their system info every time they open a terminal. To do this, add `fastfetch` to the end of your shell's configuration file.

-   **For Bash users:** Edit `~/.bashrc`
-   **For Zsh users:** Edit `~/.zshrc`
-   **For Fish users:** Edit `~/.config/fish/config.fish`

Simply add a new line at the very bottom that says `fastfetch`, save the file, and restart your terminal.

### Pro Tip: Symbols and Icons

If you see boxes or weird characters instead of icons, you likely need a **Nerd Font**. Installing a font like *JetBrainsMono Nerd Font* will allow Fastfetch to render the small icons next to your CPU, RAM, and OS names correctly.