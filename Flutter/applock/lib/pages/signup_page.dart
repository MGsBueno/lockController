import 'dart:convert';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;

class SignupPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Cadastro'),
      ),
      body: SignupForm(), // Mostra o formulário de cadastro
    );
  }
}

class SignupForm extends StatefulWidget {
  @override
  _SignupFormState createState() => _SignupFormState();
}

class _SignupFormState extends State<SignupForm> {
  final TextEditingController usernameController = TextEditingController();
  final TextEditingController passwordController = TextEditingController();

  Future<void> _submitForm() async {
    final String url = 'localhost:8080';
    final Map<String, dynamic> userData = {
      'username': usernameController.text,
      'password': passwordController.text,
      };

    try {
      final response = await http.post(
        Uri.parse(url),
        body: json.encode(userData),
        headers: {'Content-Type': 'application/json'},
      );

      if (response.statusCode == 200) {
        // Se a requisição foi bem-sucedida (código de status 200)
        final responseData = json.decode(response.body);
        // Faça algo com a resposta, se necessário
        print('Resposta do servidor: $responseData');
      } else {
        // Se a requisição falhou, imprima o código de status
        print('Falha na requisição: ${response.statusCode}');
      }
    } catch (e) {
      // Em caso de erro na requisição
      print('Erro: $e');
    }
  }

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: EdgeInsets.all(16.0),
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: <Widget>[
          TextFormField(
            controller: usernameController,
            decoration: InputDecoration(labelText: 'Usuário'),
          ),
          TextFormField(
            controller: passwordController,
            obscureText: true,
            decoration: InputDecoration(labelText: 'Senha'),
          ),
          ElevatedButton(
            onPressed: () {
              _submitForm(); // Envia os dados para o endpoint
            },
            child: Text('Cadastrar'),
          ),
        ],
      ),
    );
  }
}
