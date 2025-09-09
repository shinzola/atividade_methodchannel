# Flutter MethodChannel Example

Um exemplo de projeto Flutter que demonstra como usar **MethodChannel** para se comunicar com código nativo Android (Kotlin), mostrando **Toast** e **AlertDialog** a partir do Flutter.

---

## 📌 Funcionalidades

- Mostrar uma **mensagem Toast** no Android através do Flutter.
- Exibir um **AlertDialog** nativo no Android a partir do Flutter.
- Uso do **MethodChannel** para comunicação Flutter ↔ Kotlin.
- Demonstração de passagem de **parâmetros** do Flutter para o Android.

---

## 🛠 Tecnologias usadas

- Flutter 3.x
- Dart
- Kotlin 1.8+
- Android Studio (ou VSCode com Flutter e Dart)

---

## 🏗 Estrutura do projeto

meu_app/
├─ lib/
│ └─ main.dart # Código Flutter principal
└─ android/
└─ app/
└─ src/main/kotlin/com/example/atividade2/
└─ MainActivity.kt # Código Kotlin nativo

## ⚡ Como executar

# Clone o repositório:

- git clone https://github.com/seu_usuario/flutter_methodchannel_example.git

# Entre na pasta do projeto:

- cd flutter_methodchannel_example

# Baixe as dependências:

- flutter pub get

# Rode no Android:

- flutter run
