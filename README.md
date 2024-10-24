# CepToAddress

## Description
This application have the purpose to receive a customer and its PostalCode (CEP in Brazil)
and transform it in a valid Address using the [BrasilAPI](https://brasilapi.com.br/) to do so.

Each call to `BrasilAPI` will be saved in a database.

Also it puts the data retrieved to a sqs queue, called `customer-cep`

![](artifacts/ceptoaddress-arch.png)


## Run Local
In order to run local you should have [Docker](https://www.docker.com/) installed.

After that, you can enter inside `local` folder, and run

```shell
docker compose up -d
```

it will be created a mysql, a localstack and a wiremock container.

## Modules
This application uses the `Hexagonal Architecture`, and have some modules to do so.

### Application
Just the Spring Boot Application main. Its pom do the job of mix all the classes, by importing all the modules inside
it.