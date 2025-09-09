import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() {
  runApp(const MainApp());
}

class MainApp extends StatelessWidget {
  const MainApp({super.key});
  static const toast = MethodChannel('Toast');

  void showToast() async {
    try {
      await toast.invokeMethod('showToast', {
        "message": "Olá, eu sou um Toast!",
      });
    } on PlatformException catch (e) {
      debugPrint("Erro: ${e.message}");
    }
  }

  void showDialog() async {
    try {
      await toast.invokeMethod('showDialog', {
        "title": "Alerta",
        "message": "Isso é um AlertDialog",
      });
    } on PlatformException catch (e) {
      debugPrint("Erro: ${e.message}");
    }
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center, // eixo vertical
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              Container(
                child: FloatingActionButton(
                  onPressed: () {
                    showToast();
                  },
                  child: Text("Botão Toast"),
                ),
                width: 120,
              ),
              SizedBox(height: 20.0),
              Container(
                child: FloatingActionButton(
                  onPressed: () {
                    showDialog();
                  },
                  child: Text("Botão Dialog"),
                ),
                width: 120,
              ),
            ],
          ),
        ),
      ),
      debugShowCheckedModeBanner: false,
    );
  }
}
