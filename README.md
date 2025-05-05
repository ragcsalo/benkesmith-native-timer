# benkesmith-native-timer

A Cordova plugin that provides accurate `setTimeout` and `clearTimeout` functionality using native code on Android and iOS. This helps bypass the JavaScript timer throttling that occurs when apps go into the background.

## Features

- Native `setTimeout` using Android `Handler` and iOS `dispatch_after`
- Supports `clearTimeout` using native timer IDs
- Designed for background-safe timing in Cordova apps

## Installation

You can install this plugin from a local path or directly from the GitHub repository:

```bash
cordova plugin add https://github.com/ragcsalo/benkesmith-native-timer.git
