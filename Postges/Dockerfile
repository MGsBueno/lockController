# Use a imagem oficial do PostgreSQL como base
FROM postgres:latest

# Atualize e instale as dependências necessárias para o servidor Java
RUN apt-get update && apt-get install -y \
    openjdk-17-jdk-headless \
    # Outras dependências, se necessário
    && rm -rf /var/lib/apt/lists/*


COPY init.sql /docker-entrypoint-initdb.d/


# Copie os arquivos do seu servidor Java RPC para o contêiner
EXPOSE 5432 

# Comando para iniciar o PostgreSQL e o servidor Java RPC quando o contêiner for iniciado
CMD service postgresql start 