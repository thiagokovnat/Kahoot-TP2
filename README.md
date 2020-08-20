[![Build Status](https://travis-ci.org/thiagokovnat/Kahoot-TP2.svg?branch=master)](https://travis-ci.org/thiagokovnat/Kahoot-TP2.svg?branch=master)
[![codecov](https://codecov.io/gh/thiagokovnat/Kahoot-TP2/branch/master/graph/badge.svg)](https://codecov.io/gh/thiagokovnat/Kahoot-TP2)
<br />

# TP2 Algoritmos 3: Kahoot

Trabajo Práctico número 2 de la materia Algoritmos y Programación III de FIUBA.

Recreacion del juego de preguntas Kahoot. Incluye preguntas Verdadero/Falso, Multiple Choice, Ordered Choice y Group Choice junto a distintos multiplicadores y bonificaciones

## Grupo 

* **Thiago Kovnat** - [GitHub](https://github.com/thiagokovnat)
* **Lucas Sebastián Leoni** - [GitHub](https://github.com/lucassleoni)
* **Jonathan David Rosenblatt** - [GitHub](https://github.com/jonathan-r0)
* **Santiago Locatelli** - [GitHub](https://github.com/santiagolocatelli)
* **Matías Alberto Venglar** - [GitHub](https://github.com/matias-av)

Corrector: **Sebastián Blázquez**

<img src="https://github.com/thiagokovnat/Kahoot-TP2/blob/master/screenshots/mainScreen.png?raw=true">


<img src="https://github.com/thiagokovnat/Kahoot-TP2/blob/master/screenshots/pregunta.png?raw=true">


### Pre-requisitos

Listado de software/herramientas necesarias para el proyecto

```
java 11
maven 3.6.0
...
```

## Ejecutando las pruebas

Explicación de como ejecutar las pruebas

```
mvn test -B
...
```

## Ejecutando la aplicación

Explicación de como ejecutar la aplicación

```
mvn javafx:run
...
```

## Pruebas

### Entrega 0 (21/7)

- Planteo de modelo tentativo
- Una Pregunta de Verdadero/Falso clásico puede crearse indicándole cual es la respuesta correcta: 
- Una Pregunta de Verdadero/Falso clásico recibe una lista de respuestas y asigna correctamente puntos a los jugadores que respondieron correctamente:

### Entrega 1 (28/7)

- Una Pregunta de Verdadero/Falso con penalidad puede crearse indicándole cual es la respuesta correcta:
- Una Pregunta de Múltiple Choice clásico puede crearse indicándole cuales son las opciones correctas:
- Una Pregunta de Múltiple Choice con puntaje parcial puede crearse indicándole cuales son las opciones correctas:
- Una Pregunta de Verdadero/Falso con penalidad recibe una lista de respuestas y asigna correctamente puntos a los jugadores que respondieron correctamente, y resta correctamente puntos a los jugadores que respondieron en forma incorrecta:
- Una Pregunta de Multiple Choice clasico recibe una lista de respuestas y asigna correctamente puntos a los jugadores que respondieron correctamente:
- Una Pregunta de Multiple Choice con puntaje parcial recibe una lista de respuestas y asigna correctamente puntos a los jugadores según las opciones correctas que hayan respondido:

### Entrega 2 (4/8)

- Pruebas similares a las de la entrega 1, con el resto de los tipos de preguntas:
- Agregado de multiplicadores a cada tipo de pregunta, verificando que cumplan con el efecto indicado (x2 o x3):
- Planteo inicial de interfaz gráfica, pantalla donde se muestra una pregunta con sus opciones:

### Entrega 3 (11/8)

- Modelo del juego terminado
- Interfaz gráfica inicial básica: comienzo del juego y visualización del tablero e interfaz de usuario básica
- Modelo del manejo de turnos en el juego

### Entrega 4 (18/8)

- Trabajo practico terminado con interfaz grafica final e informe completo

## Licencia

Este repositorio está bajo la Licencia MIT
