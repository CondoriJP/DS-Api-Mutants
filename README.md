# Desarrollo de Software
- Universidad Tecnológica Nacional - Facultad Regional Mendoza
- Juan Pablo Condori Tellez - 3K10 - 2025
# Tabla de Contenidos
- [Introducción](#introducción)
- [Instalación](#instalación)
- [Local](#local)
- [Render](#render)
- [Información](#información)

### Introducción
Magneto quiere reclutar la mayor cantidad de mutantes para poder luchar contra los X-Mens.

Te ha contratado a ti para que desarrolles un proyecto que detecte si un humano es mutante basándose en su secuencia de ADN.

Para eso te ha pedido crear un programa con un método o función con la siguiente firma:

```java
boolean isMutant(String[] dna);
```
En donde recibirás como parámetro un array de Strings que representan cada fila de una tabla
de (NxN) con la secuencia del ADN. Las letras de los Strings solo pueden ser: (A,T,C,G), las
cuales representa cada base nitrogenada del ADN.

Sabrás si un humano es mutante, si encuentras más de una secuencia de cuatro letras
iguales, de forma oblicua, horizontal o vertical.

```java
String[] MUTANT = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
```
En este caso el llamado a la función isMutant(dna) devuelve “true”.
### Instalación
La API `DS-Api-Mutants` utiliza un base de datos en memoria `H2` y usa como cache `redis` en la rama principal `API-CACHE`, habos pueden ejecutarse en contenedores `docker`. Otra version es la API `DS-Api-Mutants` que utiliza un base de datos en memoria `H2` y no incorpora cache, la rama es `API-SIN-CACHE` y esta corriendo en Render.

- Instalar la versión con cache:
	```bash
	git clone https://github.com/CondoriJP/DS-Api-Mutants/tree/API-CACHE
	```
	Armar contenedor API + Redis (Docker Compose)
	```bash
	docker compose up --build --no-start
	```
	Iniciar contenedor compuesto
	```bash
	docker compose up
	```
	Detener el contenedor
	```bash
	Ctl + C
	```

- Instalar la versión sin cache:
	```bash
	git clone https://github.com/CondoriJP/DS-Api-Mutants/tree/API-CACHE
	```
	Contenizar la API:
	```bash
	docker buildx build -t api-mutants:1.0 .
	```
	Iniciar API Mutants:
	```bash
	docker run -p 8080:8080 --name mutants api-mutants:1.0
	```

### Local
Este repositorio se encuentra el proyecto con sus dos versiones, con cache (`API-CACHE`) y sin ella (`API-SIN-CACHE`). Clonar e instalar la que se desea utilizar.

- H2 Console
```url
http://localhost:8080/h2-console/
```
Configuración

url: `jdbc:h2:mem:mutantsdb`

User: `admin`

Pass: `pass`

- API Swagger
```url
http://localhost:8080/swagger-ui/index.html
```

- Pruebas

Esta  habilitado un servicio `/mutant/` el cual recibe mediante un `POST` un JSON con el siguiente formato:

```Json
{
    "dna": [
      "ATGCGA",
      "CAGTGC",
      "TTATGT",
      "AGAAGG",
      "CCCCTA",
      "TCACTG"
    ]
  }
```
Tambien esta habilitado es uso de estadisticas mediante la uri `/stats` mediante un `GET`, el cual devuelve un JSON con el siguiente formato:

```Json
{
    "countMutant": integer,
	"countHuman": integer,
	"ratio": double
}
```
### Render

### Información