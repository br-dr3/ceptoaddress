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

After build this app with [Maven](https://maven.apache.org/), you will be able to run it.
You can see a swagger-ui if you click [here](http://localhost:8081/). 

Use `Try it out` button to send some message to endpoint. You can see endpoints documentation in Swagger as well.


## Modules
This application uses the `Hexagonal Architecture`, and have some modules to do so.

### ceptoaddress-application
Just the Spring Boot Application main. Its pom do the job of mix all the classes, by importing all the modules inside
it.

### ceptoaddress-domain
A module that shares with other modules the data. Every module should pass its information by using a domain object.

### ceptoaddress-gateway
Controller with endpoint `POST /ceptoaddress/`, which receives a json, like the following:
```json
{
  "customerId": "9061c406-3c44-454e-827b-d2a1d448fd67",
  "postalCode": "00000000"
}
```
This json will be enriched with address info in other module