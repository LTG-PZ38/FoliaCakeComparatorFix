# FoliaCakeComparatorFix

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![Minecraft](https://img.shields.io/badge/Minecraft-1.20%2B-green.svg)](https://www.minecraft.net)
[![Folia](https://img.shields.io/badge/Folia-supported-orange.svg)](https://github.com/PaperMC/Folia)

A lightweight patch that fixes incorrect redstone comparator behavior on
**Folia** servers running the **Cake** plugin framework.

---

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Requirements](#requirements)
- [Installation](#installation)
- [Configuration](#configuration)
- [Building from Source](#building-from-source)
- [Compatibility](#compatibility)
- [FAQ](#faq)
- [License](#license)

---

## Overview

Folia introduces region-based multithreading to the Paper server, which changes
how block updates and scheduled tasks are dispatched. On some setups this causes
**redstone comparators to lag, desync, or fail to update** when they read
inventory contents, containers, or comparator-specific block states.

`FoliaCakeComparatorFix` is a small, focused patch that restores correct
comparator signal propagation on Folia by:

- Scheduling comparator updates on the correct owning region thread
- Preventing cross-region reads that silently return stale data
- Coalescing duplicate updates to avoid redundant recomputation

The plugin is designed to be **drop-in**: no commands, no permissions, and no
world edits required.

---

## Features

- ✅ Fixes comparator signal desync on container-backed inventories
- ✅ Correct region-thread scheduling for comparator updates
- ✅ Thread-safe, no global locks
- ✅ Zero-config — works out of the box
- ✅ No commands or permissions
- ✅ Compatible with Cake's plugin loader
---

## Requirements

| Component | Version |
| --------- | ------- |
| Server    | Folia 1.20+ (or any Folia fork) |
| Framework | Cake (matching your server build) |
| Java      | 17 or newer |

> This plugin will **not** work on vanilla Paper, Purpur, or Spigot. Folia is required.

---

## Installation

1. Download the latest `FoliaCakeComparatorFix-x.y.z.jar` from the
   [Releases](../../releases) page.
2. Drop the JAR into your server's `plugins/` directory.
3. Restart the server.
4. Done — no further configuration needed.

---

## Configuration

This plugin ships with **no configuration file**. If a config is added in a
future release, it will be created automatically at
`plugins/FoliaCakeComparatorFix/config.yml` on first startup.


---

## Building from Source

```bash
git clone https://github.com/LTG-PZ38/FoliaCakeComparatorFix.git
cd FoliaCakeComparatorFix
./gradlew build          # or: mvn clean package
