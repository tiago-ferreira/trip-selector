### Trip Selector

```
$ tree .
. package base br.com.mio.di.bao.trip.selector
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