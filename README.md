# Hardware_API
HARDWARE_API é uma API Restful desenvolvida em Spring Boot que permite recuperar informações sobre diversos hardwares. A API suporta formatos de resposta em JSON, YAML e XML, oferecendo flexibilidade aos consumidores.

**#Recursos Disponíveis**

A API HARDWARE_API disponibiliza os seguintes recursos:

/hardwares: Recupera uma lista de todos os hardwares disponíveis.
/hardwares/{id}: Recupera informações detalhadas de um hardware específico com base no ID.
Formatos de Resposta
A API suporta os seguintes formatos de resposta:

JSON: Utilize o cabeçalho "Accept: application/json" para receber a resposta em JSON.
YAML: Utilize o cabeçalho "Accept: application/x-yaml" para receber a resposta em YAML.
XML: Utilize o cabeçalho "Accept: application/xml" para receber a resposta em XML.
Executando a API

**Para executar a API HARDWARE_API, siga as etapas abaixo:**

Certifique-se de ter o Java Development Kit (JDK) instalado em sua máquina.
Faça o download do código-fonte do projeto ou clone-o através do comando git clone <[URL do repositório](https://github.com/Hugo-Nobr/Hardware_API)>.
Navegue até o diretório raiz do projeto.
Execute o comando ./mvnw spring-boot:run para iniciar a aplicação.
A API estará disponível em http://localhost:8080.
Exemplos de Uso
Recuperar todos os hardwares
URL: GET http://localhost:8080/hardwares

**Resposta em JSON:**

[
  {
    "id": 1,
    "nome": "Hardware 1",
    "tipo": "Tipo 1",
    "preco": 100.0
  },
  {
    "id": 2,
    "nome": "Hardware 2",
    "tipo": "Tipo 2",
    "preco": 150.0
  },
  ...
]
**Resposta em YAML:**

- id: 1
  nome: Hardware 1
  tipo: Tipo 1
  preco: 100.0
- id: 2
  nome: Hardware 2
  tipo: Tipo 2
  preco: 150.0
...

**Resposta em XML:**

<hardwares>
  <hardware>
    <id>1</id>
    <nome>Hardware 1</nome>
    <tipo>Tipo 1</tipo>
    <preco>100.0</preco>
  </hardware>
  <hardware>
    <id>2</id>
    <nome>Hardware 2</nome>
    <tipo>Tipo 2</tipo>
    <preco>150.0</preco>
  </hardware>
  ...
</hardwares>

**#Recuperar um hardware específico**
URL: GET http://localhost:8080/hardwares/1

**Resposta em JSON:**

{
  "id": 1,
  "nome": "Hardware 1",
  "tipo": "Tipo 1",
  "preco": 100.0
}

**Resposta em YAML:**

id: 1
nome: Hardware 1
tipo: Tipo 1
preco: 100.0


**xml**
<hardware>
  <id>1</id>
  <nome>Hardware 1</nome>
  <tipo>Tipo 1</tipo>
  <preco>100.0</preco>
</hardware>


**Contribuição**
Se você deseja contribuir para o desenvolvimento da API HARDWARE_API, fique à vontade para fazer um fork do repositório, implementar melhorias e enviar um pull request.
