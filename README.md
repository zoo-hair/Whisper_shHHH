# Whisper_shHHH 🔐

**Secrets Traveling Unseen** — A Java-based CLI encryption system inspired by historical and custom methods of secret communication.

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg)](CONTRIBUTING.md)

---

## 📖 Table of Contents

- [Theme](#-theme)
- [Project Overview](#-project-overview)
- [Technologies](#-technologies)
- [Features](#-features)
- [Ciphers Implemented](#-ciphers-implemented)
- [Installation](#-installation)
- [How to Run](#-how-to-run)
- [Sample Run](#-sample-run)
- [Project Structure](#-project-structure)
- [Contributing](#-contributing)
- [License](#-license)
- [Judge Notes](#-judge-notes)

---

## 🎭 Theme

**Theme-w9:**  
*"Throughout history, how have secrets traveled unseen — the codes, signals, and signs that let messages slip past watchful eyes?"*

**Our Interpretation:**  
We simulate secret communication across eras using encryption. Each cipher represents a method used historically or conceptually to hide messages, showing how secrets can travel unseen through time and technology.

---

## 🔍 Project Overview

**Whisper_shHHH** is a console-based encryption and decryption tool that demonstrates:

- 📜 **Historical ciphers** (Caesar, Substitution)
- 💻 **Modern simple cryptography** (XOR)
- 🧪 **A custom, original cipher** (**LetHimCook**) based on position-shift logic

The project emphasizes **logic, correctness, and theme relevance**, all implemented in pure Java without external cryptography libraries.

---

## 🛠 Technologies

- **Java SE 24** (JDK 24)
- **Console / CLI** interface
- **No external libraries** — pure Java implementation
- Modular architecture for extensibility

---

## ✨ Features

- 🎯 **Selectable cipher menu** with historical context
- 🔒 **Encrypt / Decrypt** messages with multiple algorithms
- 🔑 **Flexible key inputs** (numeric and string-based)
- 🔢 **Hex output** for non-printable characters (XOR cipher)
- 📚 **Educational context** for each cipher
- ✅ **Input validation** to prevent errors
- 🧩 **Modular design** for future cipher extensions

---

## 🔐 Ciphers Implemented

| Cipher | Type | Key Type | Description |
|--------|------|----------|-------------|
| **Caesar Cipher** | Historical | Numeric | Used by Julius Caesar to hide military messages with a simple shift |
| **XOR Cipher** | Modern | String | Symmetric binary-based encryption, demonstrating modern digital secrecy |
| **Substitution Cipher** | Historical | Alphabet | Classic letter-to-letter substitution used in espionage |
| **LetHimCook** | Custom | String | Position-aware cipher where each character shifts based on position and key; repeated letters encrypt differently |

### 🧪 LetHimCook Cipher (Custom Implementation)

Our original cipher that simulates evolving secrets:
- Each character is shifted by its **position** in the message
- The shift is modified by a **rotating key** derived from the input string
- **Repeated letters encrypt differently** based on their position
- Demonstrates how secrets can "evolve" as they travel

---

## 📥 Installation

### Prerequisites

- Java Development Kit (JDK) 17 or higher
- Terminal/Command Prompt access

### Clone the Repository
```bash
git clone https://github.com/yourusername/Whisper_shHHH.git
cd Whisper_shHHH
```

---

## 🚀 How to Run

### 1. Compile all Java files
```bash
javac src/*.java
```

### 2. Run the program
```bash
java src.Main
```

### 3. Follow the interactive prompts

- Choose **Encrypt** or **Decrypt**
- Select your desired **Cipher**
- Enter your **message**
- Provide the appropriate **key**

> **Example:** For LetHimCook cipher, use any string as a key (e.g., `lol`, `secret`, `hackathon`)

---

## 📺 Sample Run
```
=== Whisper_shHHH ===
Secrets Traveling Unseen

1. Encrypt Message
2. Decrypt Message
3. Exit

Choose option: 1

Choose Cipher:
1. Caesar Cipher (Ancient Rome)
2. XOR Cipher (Modern Digital Secrecy)
3. Substitution Cipher (Historical Espionage)
4. LetHimCook Cipher (Custom Position-Shift)

Select: 4

Enter message: king king king king
Enter key (any string): lol

Encrypted Result:
ÒÙÚÓ ÒÙÚÓ ÒÙÚÓ ÒÙÚÓ

[Theme Note]
Custom cipher that shifts each character by its position and a key 
derived from a string. Each repeated letter encrypts differently, 
simulating how secrets evolve as they travel unseen.

Press ENTER to continue...
```

---

## 📁 Project Structure
```
Whisper_shHHH/
│
├── src/
│   ├── Main.java              # Entry point with menu system
│   ├── CaesarCipher.java      # Caesar cipher implementation
│   ├── XORCipher.java         # XOR cipher implementation
│   ├── SubstitutionCipher.java # Substitution cipher
│   └── LetHimCookCipher.java  # Custom cipher
│
├── README.md                   # This file
├── LICENSE                     # Project license
└── .gitignore                 # Git ignore rules
```

---

## 🤝 Contributing

Contributions are welcome! Here's how you can help:

1. **Fork** the repository
2. Create a **feature branch** (`git checkout -b feature/AmazingCipher`)
3. **Commit** your changes (`git commit -m 'Add Playfair Cipher'`)
4. **Push** to the branch (`git push origin feature/AmazingCipher`)
5. Open a **Pull Request**

Please read [CONTRIBUTING.md](CONTRIBUTING.md) for details on our code of conduct.

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 🏆 Judge Notes

### Theme Alignment

This project directly addresses **Theme-w9** by:
- ✅ Implementing **historical** methods of secret communication (Caesar, Substitution)
- ✅ Demonstrating **modern** digital encryption (XOR)
- ✅ Creating an **original** cipher that shows evolution of secrecy
- ✅ Providing **educational context** for each method

### Technical Highlights

- **No external libraries** — all ciphers implemented from scratch
- **Modular architecture** — easy to extend with new ciphers
- **Input validation** and error handling throughout
- **Educational value** — explains historical context of each cipher
- **Original algorithm** — LetHimCook demonstrates creative problem-solving

### Innovation

The **LetHimCook cipher** is our unique contribution, demonstrating:
- Position-aware encryption
- Key rotation mechanics
- How repeated characters can encrypt differently
- A conceptual model of "evolving secrets"

---

## 👥 Team

- **Developer:** [Team Alpha](https://github.com/zoo-hair)
- **Project Duration:** [2 hours]
- **Event:** [UIU HACKDAY 2026]

---

## 📞 Contact

- **GitHub Issues:** [Report a bug](https://github.com/zoo-hair/Whisper_shHHH/issues)
- **Email:** gerlatofmalitola@gmail.com

---

<div align="center">

**🔐 Keep Your Secrets Safe, Let Them Travel Unseen 🔐**

Made with ❤️ for secure communication

</div>
