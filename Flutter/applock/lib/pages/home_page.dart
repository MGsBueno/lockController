import 'package:flutter/material.dart';

class HomePage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Home'),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Text(
              'Página Inicial',
              style: TextStyle(fontSize: 24.0),
            ),
            // Adicione conteúdo da página inicial
          ],
        ),
      ),
    );
  }
}
