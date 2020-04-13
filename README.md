### Trip Selector


## Pacotes classes java
```
$ tree .
. src/main/java
. base br.com.mio.di.bao.trip.selector
├── default
│   └── TripSelectorApplication.java -> Classe utlizada para iniciar a aplicação e subir o contexto do Spring Boot
├── config 
│   └── SwaggerConfig.java -> Classe responsável por fazer as configurações do swagger para documentação da API.
├── contoller
│   └── TripController.java -> Classe onde possui os métodos que vão ser expostos pela API.
├── converter
│   └── TripConverter.java -> Classe usada para transformar a String que foi lida a partir do arquivo de entrada, em um objeto Java.
├── model
│   └── Trip.java -> Classe com o modelo do objeto java para manipulação na aplicação.
└── service
│   └── TripService.java -> Classe com as regras de negocio.
└── util
│   └── FileReader.java -> Classe utilitária para leitura de arquivo.
│   └── FileWriter.java -> Classe utilitária para escrita em arquivo.
```

## Pacotes resources java
. src/main/java
. application.properties

### Propriedades 

```properties character.to.split=,  ``` -> Ao fazer a leitura do arquivo de entrada, indica qual caracter vai ser usado para separar a String e montar um objeto java

- **As 2 propriedades abaixo trabalham em conjunto, caso queira ler o arquivo de entrada em um diretório local da máquina, preciso adicionar a primeira propriedade como false e na segunda colocar o caminho completo do diretório da máquina seguido com o nome do arquivo**


#### Lendo a partir diretório local da máquina
```properties
trip.file.is.on.the.aplication.resources=false
trip.file.path=/home/tiago/Downloads/test-backend/input-file.txt
```

#### Lendo a partir do resources da aplicação


```properties 
trip.file.is.on.the.aplication.resources=true 
trip.file.path=input-file.txt
```

