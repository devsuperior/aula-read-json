# JSON File Reading and Navigation

## Objective
The objective of this project is to demonstrate how to read a JSON file in text mode and navigate through its objects. The implementation is provided in the following programming languages: JavaScript (js), Python, Java, and C#.

## Steps

### JavaScript

Para o JS utilizamos o ``export`` para exportar o conteúdo do jsonData como um módulo. Neste caso, usamos a sintaxe da ECMAScript Modules (ESM).

```javascript
// file.json
export const jsonData = [
    ...
];

// read-file.json
import { jsonData } from "./file.js";
```

### Python

Ocorreram alguns problemas utilizando a lib ``datetime`` do Python na leitura do valor do timestamp no formato UTC (ISO 8601 format). 

```python
ValueError: Invalid isoformat string: '2023-12-06T16:34:56Z'
```
- *method doesn't directly support the 'Z' notation for Zulu time (UTC)*.


Para lidar com este erro, é necessário utilizar a lib ``python-dateutil``. Para isso, é necessário seguir os passos abaixo para instalar o mesmo

```bash
pip install python-dateutil
```

Em seguida, no código é necessário utilizar a função abaixo:

```python
from dateutil import parser

# Function to parse the timestamp into a datetime object
def parse_timestamp(timestamp):
    return parser.isoparse(timestamp)

for course in jsonData:
    print(f"Curso: {course['title']}")

    for lesson in course['lessons']:
        print(f"  Aula {lesson['id']}: {lesson['title']}")
        print(f"    Media: {lesson['media']}")
        print(f"    Timestamp: {parse_timestamp(lesson['timestamp'])}")

    print()
```

### Java

####  Lidar com campo do tipo timestamp

A lib do ```Jackson``` não está configurado para lidar com tipos de data/hora do Java 8 (java.time.Instant) por padrão, para corrigir, seguir os passos abaixo:

- Adicionar o módulo **jackson-datatype-jsr310** ao seu projeto.

    ```xml
    <dependency>
        <groupId>com.fasterxml.jackson.datatype</groupId>
        <artifactId>jackson-datatype-jsr310</artifactId>
        <version>2.13.0</version>
    </dependency>
    ```
- Configurar o **ObjectMapper** para registrar o módulo. 

    ```java
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        
        objectMapper.registerModule(new JavaTimeModule());
        ...
    }
    ```

#### *Deserialize* um array JSON para um objeto 

Você pode fazer isso usando o método readValue com a classe TypeReference

Utilizar o método **readValue** com a classe **TypeReference**, conforme exemplo abaixo:

```java
List<Course> courses = objectMapper.readValue(jsonFile, new TypeReference<List<Course>>() {});
```
### C#

#### Adicionar a lib Newtonsoft.Json
Para adicionar a lib ```Newtonsoft.Json``` usando o NuGet Package Manager ou o dotnet CLI:
    
```bash
dotnet add package Newtonsoft.Json
```

#### Passos para incluir arquivo JSON:

1. Adicione o arquivo JSON ao projeto:
    - Crie ou copie seu arquivo JSON para o diretório do seu projeto.
    - No Visual Studio, clique com o botão direito do mouse no diretório do projeto no Solution Explorer.
    - Escolha "Add" > "Existing Item" e selecione seu arquivo JSON.

2. Configure a cópia para o diretório de saída:
    - Selecione o arquivo JSON no Solution Explorer.
    - No painel de propriedades, defina a propriedade "Copy to Output Directory" para "Copy if newer" ou "Copy always".

- Dessa forma, o arquivo JSON será copiado para o diretório de saída (por exemplo, bin\Debug ou bin\Release) quando você compilar o projeto, e você pode usar o caminho relativo para acessá-lo durante a execução do aplicativo.



