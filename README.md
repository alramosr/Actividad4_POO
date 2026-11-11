# Universidad Nacional de Colombia

**Programación Orientada a Objetos 2026-2S**

## Actividad 4: Excepciones y Archivos - Valor 20%

*   **Nombre del estudiante:** Alejandro Ramos Rincón
*   **Docente:** Walter Hugo Arboleda Mazo

---

### Descripción del Repositorio

Este repositorio contiene la solución a la **Actividad 4** del curso de Programación Orientada a Objetos. Los ejercicios fueron desarrollados en el lenguaje de programación **Java** mediante **interfaz gráfica de usuario** (librería swing), aplicando el manejo de excepciones (`try`, `catch`, `finally`, `throw` y catchs múltiples), la validación de campos y la lectura de archivos de texto.

El proyecto incluye el código fuente de los siguientes ejercicios basados en el libro *Ejercicios de programación orientada a objetos con Java y UML* de Leonardo Bermón Angarita:

*   **Ejercicio 6.4:** Excepciones (clase PruebaExcepciones).
*   **Ejercicio 6.5:** Lanzamiento de excepciones (clase Vendedor).
*   **Ejercicio 6.6:** Catchs múltiples (clase CalculosNumericos).
*   **Ejercicio 6.7:** Validación de campos (clases EquipoMaratonProgramacion y Programador).
*   **Ejercicio 6.8:** Lectura de archivos (clase LeerArchivo).

### Estructura
El código fuente se encuentra en la carpeta `Codigo fuente`. Cada ejercicio está organizado en su respectivo paquete y cuenta con una clase `Main` que contiene el método `main`. Las clases del modelo tienen métodos get y set para cada atributo; las ventanas extienden `JFrame` e implementan `ActionListener`:

| Paquete | Clases |
|---|---|
| `Ejercicio6_4` | `PruebaExcepciones`, `VentanaPrincipal`, `Main` |
| `Ejercicio6_5` | `Vendedor`, `VentanaPrincipal`, `Main` |
| `Ejercicio6_6` | `CalculosNumericos`, `VentanaPrincipal`, `Main` |
| `Ejercicio6_7` | `EquipoMaratonProgramacion`, `Programador`, `VentanaPrincipal`, `Main` |
| `Ejercicio6_8` | `LeerArchivo`, `VentanaPrincipal`, `Main` (y el archivo de texto `prueba.txt`) |

### Documentos y recursos
| Archivo / carpeta | Contenido |
|---|---|
| `Actividad4_POO.pdf` | Documento de entrega: código fuente, diagramas de clases y de casos de uso, e imágenes de la interfaz de usuario de cada ejercicio |
| `Codigo fuente/` | Código fuente de los ejercicios 6.4 a 6.8 (paquetes `Ejercicio6_4` a `Ejercicio6_8`) |
| `Diagramas/` | Diagramas de clases y de casos de uso en draw.io (`.xml`) y exportados a PNG (`.drawio.png`) |
| `Interfaz/` | Imágenes de la interfaz de usuario de cada ejercicio |

En el documento se omiten los métodos get y set, tanto en el código como en los diagramas de clases; el código fuente completo está en la carpeta `Codigo fuente`.
