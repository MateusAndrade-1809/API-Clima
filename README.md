# API-Clima

API REST desenvolvida em Java com Spring Boot para consultar e disponibilizar informações climáticas atuais de Belo Horizonte - MG utilizando a API Open-Meteo.

## Sobre o projeto

Este projeto foi criado como uma API simples de clima. A aplicação disponibiliza uma rota HTTP que consulta dados reais na Open-Meteo e retorna uma resposta em JSON com temperatura, velocidade do vento e horário da medição.

## Tecnologias utilizadas

- Java 21
- Spring Boot
- Maven
- Open-Meteo API

## Estrutura do projeto

```text
src/main/java/com/clima/API_clima
├── ApiClimaApplication.java
├── controller
│   └── ClimaController.java
├── service
│   └── ClimaService.java
├── dto
│   ├── ClimaDTO.java
│   └── ErroDTO.java
└── exception
    └── ClimaIndisponivelException.java
```

## Como funciona

1. O usuário acessa a rota `/clima`.
2. O `ClimaController` recebe a requisição.
3. O controller chama o `ClimaService`.
4. O service consulta a API Open-Meteo.
5. Os dados recebidos são organizados em um `ClimaDTO`.
6. O Spring Boot transforma o DTO em JSON e devolve a resposta.

## Como executar

Abra o terminal na pasta raiz do projeto, onde está o arquivo `pom.xml`, e execute:

```powershell
.\mvnw.cmd spring-boot:run
```

Quando a aplicação iniciar, acesse:

```text
http://localhost:8080/clima
```

## Endpoint disponível

### `GET /clima`

Retorna o clima atual de Belo Horizonte - MG.

Exemplo de resposta:

```json
{
  "cidade": "Belo Horizonte - MG",
  "temperatura": 19.3,
  "unidadeTemperatura": "°C",
  "velocidadeVento": 6.3,
  "unidadeVento": "km/h",
  "horario": "2026-08-27T19:30"
}
```

Os valores de temperatura, vento e horário podem mudar conforme os dados atuais retornados pela Open-Meteo.

## Tratamento de erro

Se a Open-Meteo estiver indisponível, sem internet ou retornar dados incompletos, a API responde com erro `503 Service Unavailable`.

Exemplo:

```json
{
  "mensagem": "Nao foi possivel buscar o clima agora.",
  "detalhe": "Erro ao consultar a Open-Meteo."
}
```

## Como testar

Para compilar o projeto e executar os testes:

```powershell
.\mvnw.cmd test
```

## Fonte dos dados

Os dados climáticos são fornecidos pela Open-Meteo:

```text
https://open-meteo.com/
```
