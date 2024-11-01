# Desarrollo de Software
- Universidad Tecnológica Nacional - Facultad Regional Mendoza
- Juan Pablo Condori Tellez- 2025
## Tabla de Contenidos
	- [Introducción](#Introducción)
- [Instalación](#Instalación)

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
La API `DS-Api-Mutants` utiliza un base de datos en memoria `H2` y usa como cache `redis`, habos pueden ejecutarse en contenedores `docker`.

Contenezar la API:
```bash
docker buildx build -t api-mutants:1.0 .
```

Iniciar API:
```bash
docker run -p 8080:8080 --name mutants api-mutants:1.0
```

Iniciar redis:
```bash
docker run -p 6379:6379 --name cache redis
```
