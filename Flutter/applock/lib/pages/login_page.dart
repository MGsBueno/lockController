import 'package:flutter/material.dart';

class LoginPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Login'),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Text(
              'Página de Login',
              style: TextStyle(fontSize: 24.0),
            ),
            // Adicione campos de entrada, botões, etc. para o login
          ],
        ),
      ),
    );
  }
}
