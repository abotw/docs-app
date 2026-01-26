# Neofetch

Hello! As a Linux expert, I’m happy to introduce you to one of the most beloved "ritual" tools in the Linux community: **Neofetch**.

If you have ever seen a screenshot of a Linux desktop with a colorful ASCII art logo and a list of system specifications in the terminal, you were likely looking at Neofetch. It is a command-line tool that displays information about your operating system, software, and hardware in a visually pleasing way.

## 1. What is Neofetch?

Neofetch is a system information tool written in `bash`. Its primary purpose is to be used in screenshots (often called "linux porn") to show other users what distribution you are running, your theme, your icons, and your hardware specs.

### Key Information Displayed:

-   **OS**: Your Linux distribution (e.g., Ubuntu, Arch, Fedora).
-   **Host**: Your laptop or motherboard model.
-   **Kernel**: The version of the Linux kernel you are running.
-   **Uptime**: How long your system has been running since the last boot.
-   **Packages**: The number of installed packages and the managers used (apt, pacman, etc.).
-   **Shell**: Your current terminal shell (bash, zsh, etc.).
-   **Resolution**: Your screen resolution.
-   **DE/WM**: Your Desktop Environment (GNOME, KDE) or Window Manager (i3, Sway).
-   **CPU/GPU/Memory**: Your core hardware specs.

## 2. How to Install Neofetch

Neofetch is available in the official repositories of almost every Linux distribution. Open your terminal and run the command that matches your OS:

| **Distribution**           | **Command**                    |
| -------------------------- | ------------------------------ |
| **Ubuntu / Debian / Mint** | `sudo apt install neofetch`    |
| **Fedora**                 | `sudo dnf install neofetch`    |
| **Arch Linux**             | `sudo pacman -S neofetch`      |
| **openSUSE**               | `sudo zypper install neofetch` |
| **macOS (Homebrew)**       | `brew install neofetch`        |

## 3. How to Use Neofetch

Once installed, using it is incredibly simple. Just type the following into your terminal:

```Bash
neofetch
```

The tool will scan your system and instantly generate the logo and info list.

## 4. Beginner Customization

The beauty of Neofetch is its flexibility. Here are a few common ways to tweak it:

### Change the Logo

If you want to see a different distribution's logo (perhaps for fun), you can force it:

```Bash
neofetch --ascii_distro arch
```

### Hide Certain Information

If you don't want to show your GPU or Memory, you can use flags:

```Bash
neofetch --off --cpu --memory
```

### Make it Automatic

Many Linux users like to see Neofetch every time they open their terminal. To do this, you can add it to your shell's configuration file:

1.  Open your `.bashrc` file: `nano ~/.bashrc`
2.  Scroll to the very bottom and add a new line that simply says `neofetch`.
3.  Save and exit (Ctrl+O, Enter, Ctrl+X).
4.  Now, every time you open a new terminal window, your system info will greet you.

## 5. Is Neofetch still maintained?

As a pro tip: The original Neofetch project was recently archived by its creator, meaning it no longer receives updates. However, because it is a simple bash script, it still works perfectly on almost all systems. If you are looking for modern, faster alternatives written in languages like Rust or C++, you might also want to check out **Fastfetch** or **Hyfetch**.