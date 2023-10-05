# Documentación de la Aplicación de Android

## Introducción
- **Nombre de la Aplicación**: Video Juegos
- **Versión de la Aplicación**: 1.0.0
- **Fecha de Creación**: 2023-10-05
- **Desarrollador**: Alejandro Gallego Henao

## Descripción General
- **Descripción**: La aplicación es un proyecto diseñado como parte de una prueba técnica que tiene como objetivo demostrar un profundo entendimiento y dominio de una serie de tecnologías y conceptos clave en el desarrollo de aplicaciones Android. Estos incluyen Jetpack Compose para la creación de interfaces de usuario modernas y atractivas, el sistema de navegación de Android para la gestión de flujos de pantalla, la arquitectura MVVM (Model-View-ViewModel) para una separación limpia de la lógica de negocio y la presentación, y la arquitectura Clean para una organización modular y mantenible del código.

La modularización también es una parte esencial de esta prueba, lo que significa que la aplicación está dividida en módulos funcionales independientes para promover la reutilización del código y facilitar la escalabilidad. En resumen, esta aplicación sirve como un escaparate de habilidades avanzadas en el desarrollo de aplicaciones Android, destacando la capacidad de crear una solución técnica sólida y eficiente en un entorno moderno y modularizado.

## Clean Architecture

La **Clean Architecture**, también conocida como Arquitectura Limpia, es un patrón de arquitectura de software utilizado en el desarrollo de aplicaciones. Su objetivo principal es crear sistemas de software altamente mantenibles y escalables al establecer una organización clara y una separación de responsabilidades entre los diferentes componentes de una aplicación.

### Principios Fundamentales

1. **Independencia de Frameworks**: La Clean Architecture se basa en la idea de que las capas internas del sistema no deben depender de ningún framework o tecnología específica. Esto permite adaptarse a nuevos frameworks o actualizaciones tecnológicas sin afectar la funcionalidad central.

2. **Separación de Responsabilidades**: La arquitectura divide la aplicación en capas bien definidas, como la Capa de Presentación (UI), la Capa de Negocio (Lógica de Aplicación) y la Capa de Datos (Acceso a Datos). Cada capa tiene un propósito claro y no mezcla sus preocupaciones.

3. **Independencia de la Fuente de Datos**: Clean Architecture fomenta la independencia de la fuente de datos, lo que significa que la lógica de la aplicación no está acoplada directamente a una base de datos, API u otra fuente de datos. Esto facilita cambios en la fuente de datos sin afectar la lógica de la aplicación.

4. **Pruebas Unitarias**: La arquitectura facilita las pruebas unitarias al permitir que cada componente se pruebe de manera aislada. Esto mejora la calidad del software y permite la detección temprana de errores.

5. **Inversión de Dependencias**: Clean Architecture sigue el principio de Inversión de Dependencias, que establece que las dependencias de alto nivel no deben depender de detalles de implementación de bajo nivel, sino que ambas deben depender de abstracciones. Esto facilita la sustitución de componentes y la inyección de dependencias.

### Beneficios

La Clean Architecture proporciona una base sólida para el desarrollo de aplicaciones, lo que resulta en sistemas más mantenibles, escalables y adaptables a medida que evoluciona el software. Esta metodología es esencial para crear aplicaciones de alta calidad y facilita la colaboración y el desarrollo continuo.

En resumen, Clean Architecture es un enfoque arquitectónico que promueve la organización clara, la independencia tecnológica y la separación de responsabilidades en el desarrollo de aplicaciones, lo que contribuye a la creación de software robusto y de alta calidad.

- **Módulos**: 
    - [Nombre del Módulo 1]: app    
    - [Nombre del Módulo 2]: core_ui
    - [Nombre del Módulo 3]: data
    - [Nombre del Módulo 4]: funcionalidades
                         ## -- detalles
                         ## -- favoritos
                         ## -- inicio
                         ## -- listado

## Patrones de Diseño
- **MVVM (Model-View-ViewModel)**: El patron de diseño MVVM se trabajo dentro de cada modulo


La Clean Architecture es un patrón de diseño de software que separa la lógica de negocio de la capa de presentación. Esto hace que la aplicación sea más modular y más fácil de probar. Jetpack Compose es una herramienta moderna para construir interfaces de usuario nativas en Android. Es declarativa y componible, lo que facilita la creación de interfaces de usuario complejas con menos código. Kotlin es un lenguaje de programación moderno y completamente interoperable con Java. Es conciso, expresivo y seguro. Las coroutines son un modelo de concurrencia ligero que facilita la escritura de código asincrónico. Flow es una biblioteca de programación reactiva que facilita la manipulación de flujos de datos. Hilt es una biblioteca de inyección de dependencias que simplifica la gestión de dependencias en aplicaciones Android. Las pruebas unitarias son una técnica de prueba de software que se utiliza para verificar la corrección de unidades individuales de código.

Este proyecto es un buen ejemplo de cómo utilizar tecnologías Android modernas para construir una aplicación de alta calidad. Está bien diseñado, fácil de probar y utiliza las últimas herramientas y tecnologías.


### Tecnologías Utilizadas

Intenté construir esta aplicación siguiendo estos principios, que son:

- rendimiento
- legibilidad
- mantenibilidad
- testabilidad
- escalabilidad
- simplicidad

Las herramientas que he utilizado para implementar la Clean Architecture en Android son:

- **Clean Architecture**: La Clean Architecture es un patrón de diseño de software que separa la lógica de negocio de la capa de presentación. Esto hace que la aplicación sea más modular y más fácil de probar.
- **MVVM**: Se sigue la arquitectura MVVM para evitar el código repetitivo. Donde View, ViewModel, Repository se utilizan claramente para mantener el principio SOLID.
- **Kotlin**: Kotlin es un lenguaje de programación moderno y completamente interoperable con Java. Es conciso, expresivo y seguro. (https://kotlinlang.org/)
- **Coroutines**: Para reducir las tareas en el hilo principal, podemos dividir la tarea en varios hilos de forma asíncrona utilizando Kotlin Coroutines con el ciclo de vida. (https://developer.android.com/kotlin/coroutines)
- **Hilt**: Hilt es una biblioteca de inyección de dependencias que simplifica la gestión de dependencias en aplicaciones Android.
- **Jetpack Compose Navigation**: Jetpack Compose Navigation es una biblioteca de navegación declarativa que facilita la navegación entre diferentes pantallas en tu aplicación. Es declarativo, lo que significa que puedes describir tu navegación en función de lo que deseas que ocurra, en lugar de cómo deseas que ocurra. Esto facilita la creación de flujos de navegación complejos con menos código.
- **Kotlin Flow**: En las coroutines, un flow es un tipo que puede emitir múltiples valores de forma secuencial, a diferencia de las funciones suspendidas que devuelven solo un valor. (https://developer.android.com/kotlin/flow)
- **Retrofit**: Biblioteca para llamadas de red. (https://square.github.io/retrofit/)
- **Pruebas Unitarias**: Las pruebas unitarias son una técnica de prueba de software que se utiliza para verificar la corrección de unidades individuales de código. He utilizado Junit4 y Mockk con fines de prueba unitaria.

#### Especificación de la API
Para este repositorio, he utilizado una API de video juegos.

# API de FreeToGame - Documentación

La documentación completa de la API de FreeToGame está disponible en el siguiente enlace: [Documentación de la API FreeToGame](https://www.freetogame.com/api-doc). Esta documentación proporciona información detallada sobre cómo interactuar con la API y cómo utilizar sus recursos para acceder a datos relacionados con videojuegos.

## Puntos de Acceso Principales

### Lista de Videojuegos (GET /api/games)
- Este punto de acceso le permite obtener una lista de videojuegos disponibles en FreeToGame.
- Puede utilizar esta API para recuperar información general sobre los videojuegos, como nombre, género, plataforma y fecha de lanzamiento.
- Es útil para crear listas de videojuegos, realizar búsquedas y mostrar información básica sobre los juegos.

### Detalle de Videojuego por ID (GET /api/game?id=43)
- Con este punto de acceso, puede obtener detalles específicos de un videojuego utilizando su ID.
- Proporciona información detallada sobre un juego, como su descripción, capturas de pantalla, requisitos del sistema y más.
- Puede ser utilizado para mostrar información completa sobre un videojuego en particular.

## Uso de la API

La documentación detalla cómo autenticarse (si es necesario), los parámetros de consulta requeridos y los ejemplos de respuestas que puede esperar de la API. Para obtener información detallada sobre cómo utilizar la API de FreeToGame, consulte la [Documentación de la API FreeToGame](https://www.freetogame.com/api-doc).

En resumen, la API de FreeToGame ofrece una forma de acceder a datos relacionados con videojuegos, lo que la hace valiosa para desarrolladores de aplicaciones y sitios web de juegos que desean mostrar información actualizada sobre videojuegos disponibles en FreeToGame. La documentación proporciona orientación sobre cómo utilizar estos recursos de manera efectiva.

