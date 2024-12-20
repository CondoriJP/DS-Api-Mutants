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
En donde recibirás como parámetro un array de Strings que representan cada fila de una tabla.
de (NxN) con la secuencia del ADN. Las letras de los Strings solo pueden ser: (A,T,C,G), las
cuáles representan cada base nitrogenada del ADN.

Sabrás si un humano es mutante, si encuentras más de una secuencia de cuatro letras.
iguales, de forma oblicua, horizontal o vertical.

```java
String[] MUTANT = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
```
En este caso, el llamado a la función isMutant(dna) devuelve “true”.
### Instalación
La API `DS-Api-Mutants` utiliza una base de datos en memoria `H2` y usa como caché `Redis` en la rama principal `API-CACHE`; ambos pueden ejecutarse en contenedores `Docker`. Otra versión es la API `DS-Api-Mutants`, que utiliza una base de datos en memoria `H2` y no incorpora caché; la rama es `API-SIN-CACHE` y está corriendo en Render.

- Instalar la versión con caché:
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
Ctrl + C
```

- Instalar la versión sin caché:
```bash
git clone https://github.com/CondoriJP/DS-Api-Mutants/tree/API-CACHE
```
Contenerizar la API:
```bash
docker buildx build -t mutants:1.0 .
```
Iniciar API Mutants:
```bash
docker run -p 8080:6666 --name api-mutants mutants:1.0
```

### Local
En este repositorio se encuentra el proyecto con sus dos versiones, con caché (`API-CACHE`) y sin ella (`API-SIN-CACHE`). Clonar e instalar la que se desea utilizar.

- Consola H2
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

Está habilitado un servicio `/mutant/`, el cual recibe mediante un `POST` un JSON con el siguiente formato:

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
También está habilitado el uso de estadísticas mediante la URI `/stats` mediante un `GET`, el cual devuelve un JSON con el siguiente formato:

```Json
{
"countMutant": integer,
"countHuman": integer,
"ratio": double
}
```
### Render

En Render se utiliza la rama `API-SIN-CACHE` debido a que no se puede utilizar Docker Compose.
La URL provista de Render del deploy es `https://ds-api-mutants.onrender.com`.

Se puede acceder a H2-console mediante la URL `https://ds-api-mutants.onrender.com/h2-console/`.

Para API Swagger mediante la URL `https://ds-api-mutants.onrender.com/swagger-ui/index.html`.

Por lo que también están los servicios:

- Verificar DNAs

POST: `https://ds-api-mutants.onrender.com/mutant/`

- Estadísticas

GET: `https://ds-api-mutants.onrender.com/stats`

### Información
- Pruebas de carga con JMeter

Se realizaron pruebas de carga con JMeter, se realizaron 3 pruebas con 100, 500 y 1000 peticiones concurrentes, y se obtuvieron los siguientes resultados:
- 100 peticiones concurrentes
  ![Alt text](./documents/JMeter_Test_100.png?raw=true "100 test")
- 500 peticiones concurrentes
  ![Alt text](./documents/JMeter_Test_500.png?raw=true "500 test")
- 1000 peticiones concurrentes
  ![Alt text](./documents/JMeter_Test_1000.png?raw=true "1000 test")


- Diagrama de secuencia

Se ilustra el diagrama de secuencia para el servicio `/mutant/`.

![Alt text](./documents/DSecuencia_Mutants.png?raw=true "DSecuencia")