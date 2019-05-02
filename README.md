# marcoscervera-sistema-solar

examen de ingreso Mercado Libre.

## [Entorno]

java 8
mysql 5.7
maven
SpringBoot 2

## [Descripcion General]

Este proyecto genera predicciones meteorologicas y las expone en una api rest para poder ser visualizado.
Estas predicciones meteorologicas son generadas en un proceso batch, tomando por dia la posicion de cada planeta. Una vez obtenida la posicion de los planetas se verifica si ocurre una sequia, un periodo de lluvia o si el clima se encuentra en condiciones optimas que luego de procesarlas son guardadas en la base de datos.
Las respuestas son respondidas en un segundo batch que loguea las preguntas con su respuesta correspondiente

## [API REST]

URL: localhost:8080/'PLANET_NAME'/weather?day='DAY'

PLANET_NAME: Ferengi - Betasoide - Vulcano
DAY: n <= 3600
