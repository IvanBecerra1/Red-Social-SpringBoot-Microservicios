
# Spring Cloud Load Balancer + Eureka — Mini Social Network

## Descripción

Este proyecto demuestra, mediante un escenario práctico, cómo implementar comunicación entre microservicios utilizando **Service Registry**, **Service Discovery** y **Client-Side Load Balancing** con el ecosistema de Spring Cloud.

Se modela una aplicación tipo red social compuesta por dos microservicios principales: uno encargado de la gestión de usuarios y otro de la gestión de publicaciones. La comunicación entre ambos se realiza **sin conocer direcciones físicas ni puertos**, sino a través del registro dinámico en Eureka y el balanceo automático de instancias.

---

## Objetivos del proyecto

Aplicar en un ejemplo real los siguientes patrones de arquitectura de microservicios:

- Service Registry con Eureka Server
- Service Discovery con Eureka Client
- Client-Side Load Balancing con Spring Cloud LoadBalancer
- Comunicación declarativa entre microservicios mediante OpenFeign
- Desacople total entre servicios evitando URLs hardcodeadas

---

## Escenario planteado

La aplicación representa una red social compuesta por:

| Servicio | Responsabilidad |
|---|---|
| Users Service | Gestión de usuarios |
| Posts Service | Gestión de publicaciones |

El **Users Service** necesita consumir información del **Posts Service** para obtener todos los posteos de un usuario determinado.

En lugar de invocar a Posts mediante una URL fija como:

```
http://localhost:8084/posts
```

la comunicación se realiza utilizando el nombre lógico del servicio registrado en Eureka:

```
http://POST-SERVICE/posts
```

Eureka resuelve qué instancia está disponible y Spring Cloud LoadBalancer decide a cuál redirigir la petición.

---

## Arquitectura del sistema

```
               +-------------------+
               |   Eureka Server   |
               |      :8761        |
               +---------+---------+
                         |
          registers      |      registers
                         |
+------------------+     |     +------------------+
|   Users Service  |<----+---->|   Posts Service  |
|      :8083       |  Feign +  |  :8084 / :8085   |
|                  | LoadBalancer| (múltiples)    |
+------------------+            +------------------+
```

---

## Módulos del proyecto

### eureka-sv
Servidor de registro donde se inscriben dinámicamente los microservicios.

### post-service
Microservicio encargado de la gestión de publicaciones. Puede ejecutarse en múltiples instancias para demostrar el balanceo de carga.

### users-service
Microservicio encargado de la gestión de usuarios y del consumo del servicio de publicaciones mediante Feign.

---

## Ejecución del proyecto

1. Levantar Eureka Server.
2. Levantar una o más instancias del Posts Service en distintos puertos.
3. Levantar el Users Service.
4. Realizar peticiones al Users Service y observar el balanceo en los logs del Posts Service.

---

## Configuración clave

```
eureka.client.service-url.defaultZone=http://localhost:8761/eureka/
```

---

## Autor

Proyecto desarrollado como práctica de arquitectura de microservicios con Spring Cloud.
