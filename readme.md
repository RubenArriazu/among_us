# Servicios y Procesos

## ¿Como puedo descargar este proyecto en mi ordenador?

Lo mejor es utilizar GIT, lo puedes descar [aquí](https://git-scm.com/downloads). Abre una terminal,
situate en el directorio en el que quieras clonar este proyecto y escribe:

```
git clone https://github.com/RubenArriazu/sp.git
```

Si no quieres utilizar GIT puedes descargar un ZIP (con el botón desplegable verde de arriba).

## ¿Que IDE utilizo?

Este proyecto es neutral respecto a cualquier IDE. Es decir, el repositorio no incluye ningun archivo generado
por un IDE en especifico. Utiliza el IDE (o editor) que quieras.

## ¿Como contribuir?

Si encuentras un problema abre un Issue. Si ademas quieres solucionarlo, crea un Pull Request.

## ¿Que version de Java utiliza este proyecto?

Todo el código ha sido desarrollado con Java 17. Lo mas recomendable es utilizar OpenJDK17 (o por ejemplo Amazon Corretto 17).

## Imagenes nativas de Linux con GraalVM

Es posible crear ejecutables nativos para Linux. Solamente hay que modificar los parametros de `java2bin.sh`
y tener Podman (tambien se podria utilizar Docker) instalado. En Linux (con Podman instalado) hay que ejecutar:

```
sh graal-vm.sh
```

