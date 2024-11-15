# Projeto Final Arquitetura Java [24E4_2] - Cadastro de Autores e Livros

Este projeto faz parte da disciplina de **Arquitetura Java** e será desenvolvido em quatro etapas. Esta é a **primeira entrega**, na qual implementamos a funcionalidade de **Cadastro de Autores e Livros**, que permite registrar autores com seus respectivos livros (Eletronico e físico) em um sistema básico utilizando Spring Boot.

## Funcionalidades Entregues

### Feature 1: Cadastro de Autores e Livros
Nesta primeira entrega, foram implementadas as seguintes funcionalidades:

- **Cadastro de Autores**: Cada Autor possui possui nome e data de nascimento e coleção de livros.
- **Cadastro de Livros**: Dois tipos de livros podem ser cadastrados:
  - **E-Livro**: Livro digital, com informações de número de downloads.
  - **Físico**: O bom e velho livro, informando se é capa dura ou não.
- **Leitura de Arquivo**: O sistema lê um arquivo de texto com informações de autor, livro, editora, endereço e realiza o cadastro automático no sistema.
- **Listagem de Autores e Livro**: Exibe os Autores cadastrados, bem como seus livros associados.

### Estrutura do Projeto

- **`br.edu.infnet.eder.EderApplication`**: Classe principal do projeto Spring Boot.
- **`br.edu.infnet.eder.Loader`**: Classe responsável por carregar dados iniciais a partir de um arquivo de texto.
- **Domínio**:
  - `Autor`: Representa o autor e contém uma lista de livros.
  - `Livro`: Classe abstrata para representar o livro.
  - `ELivro`: Subclasse de `Livro` que representa os livros do tipo digital (e-book).
  - `Fisico`: Subclasse de `Livro` que representa os livros do tipo fisico.
  - `Editora` : Representa a editora responsável por publicar o livro, esta contem uma coleção de Livros publicados e o seu endereço.
  - `Endereco`: Representa o endereço do `Editora`.
- **Serviço**:
  - `AutorService`: Classe que gerencia a inclusão e recuperação dos autores cadastrados.

### Arquivo de Entrada

Os autores e livros são cadastrados automaticamente a partir do arquivo `arquivos/base.txt`. O arquivo deve seguir o seguinte formato: 

V;ordem;nome;nascimento
E;ordem;ordemVetor;nome;enderecoweb
LF;ordem;ordemEditora;nomelivro;valor;temEstoque;ehCapaDura
LE;ordem;ordemEditora;nomeLivro;valor;enderecoDownload;numerodownloads

### Exemplo:

A;1;Monteiro Lobato;1882-04-18\
E;1;1;FTD;www.ftd.com.br\
E;1;2;FTD;www.ftd.com.br\
LF;1;1;Picapau Amarelo;123.1;true;true\
LE;2;1;Picapau Amarelo;109.99;www.amazon.com;10\



### Tecnologias Utilizadas

- **Java 11**
- **Spring Boot 2.7.5**
- **Maven**

### Como Executar

1. Clone este repositório.
2. Certifique-se de que o Java 11 e o Maven estão instalados em sua máquina.
3. Compile o projeto executando:
mvn clean install

4. Execute o projeto com o comando:
mvn spring-boot

5. O sistema irá carregar os dados a partir do arquivo `arquivos/base.txt` e exibir a lista de autores e seus livros no console.

## Autor

- **Eder Reis** - br.edu.infnet
