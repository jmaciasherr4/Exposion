# Exposion — MDD: UML a Código con UmpleOnline

Ciclo completo de Ingeniería Dirigida por Modelos (MDD) aplicado al Proyecto Fin
de Curso: Sistema de Gestión de Camaronera — Módulo de Gestión de Piscinas y
Ciclos de Cultivo.

**Asignatura:** Ingeniería de Requisitos (ISR-401) — UTEQ, 2026–2027 PPA
**Docente:** Ing. Gleiston Guerrero Ulloa, PhD.

## Integrantes del equipo

| Integrante | Responsabilidad |
|---|---|
| Alvia Villegas, Erick Adalberto | Roundtrip, trazabilidad |
| Arboleda Yanza, Francisco Javier | Modelado UML y construcción del archivo `.ump` |
| Calle Delgado, Kamila Annabella | Configuración del generador y verificación del código Java |
| Macías Herrera, Josthyn Esteban | Investigación teórica, justificación de la herramienta y coordinación del repositorio |

## Descripción del sistema y del subsistema modelado

El sistema completo del PFC es un Sistema de Gestión de Camaronera. El
subsistema modelado en esta actividad es el módulo de **Gestión de Piscinas y
Ciclos de Cultivo**: administra camaroneras, sus piscinas, los ciclos de
cultivo de cada piscina (muestreos, alimentación y cosecha) y los empleados
(técnicos de campo y administradores) que operan sobre ellos.

## Herramienta empleada

- **Nombre:** UmpleOnline
- **URL:** https://try.umple.org (también accesible en https://cruise.umple.org/umpleonline/)
- **Versión de la interfaz web:** v1.37.0.8639.f07c3e9b7
- **Versión del motor de compilación Umple:** 1.37.0.8639.dcaf9c798
  *(ambos identificadores corresponden a la misma release 1.37.0.8639, pero a
  componentes distintos de la herramienta: interfaz web y motor de generación
  de código, respectivamente — ver Sección 5.1 de `Documento/secciones_5_6.tex`
  para el detalle).*
- **Fecha de acceso:** 20 de julio de 2026.
- **Lenguaje objetivo:** Java.

## Requisitos previos

- Conexión a internet (UmpleOnline es una herramienta web, no requiere instalación local).
- **JDK 11 o superior** para compilar y ejecutar el código Java generado.
  Verificado con `javac 21.0.11` en Windows 11.
- Distribución LaTeX (TeX Live, MiKTeX, o similar) con `pdflatex` para compilar
  el informe.

## Estructura del repositorio

```
Exposion/
├── README.md
├── Documento/
│   ├── Informe.tex              # Documento evidencia principal
│   ├── secciones_5_6.tex        # Secciones 5 y 6 (Configuración del generador; Proceso y verificación)
│   └── referencias.bib
├── modelo/
│   └── camaronera.ump           # Modelo de origen en sintaxis Umple
├── plantillas/
│   └── opciones-generacion.md   # Parametrización del proceso de generación
├── generado/
│   └── ec/uteq/camaronera/piscinas/   # Código Java generado por UmpleOnline (NO EDITAR)
├── manual/
│   └── ec/uteq/camaronera/piscinas/DemoPiscinas.java  # Unidad demostrable (código manual)
└── evidencias/
    └── capturas/                # Capturas del proceso completo (01 a 04)
```

## Cómo reproducir la generación de código

1. Abrir https://cruise.umple.org/umpleonline/ en el navegador.
2. Copiar el contenido de `modelo/camaronera.ump` y pegarlo en el panel
   izquierdo (código del modelo).
3. Verificar que el diagrama de clases se renderice a la derecha sin errores.
4. En el panel **GENERATE**, seleccionar **Java Code** y hacer clic en
   **Generate It**.
5. Descargar el paquete generado (**Download Files**, panel **SAVE & LOAD**).
6. Descomprimir el paquete conservando el árbol de carpetas, de forma que los
   `.java` queden en `generado/ec/uteq/camaronera/piscinas/`.

**Importante:** los archivos dentro de `generado/` no deben editarse a mano —
toda regeneración los sobrescribe por completo (Umple no usa bloques
protegidos). Cualquier cambio de dominio se hace en `modelo/camaronera.ump` y
se regenera desde ahí. El único código escrito manualmente por el equipo vive
en `manual/`, fuera del árbol regenerado.

## Cómo compilar y ejecutar la unidad demostrable

Desde la raíz del repositorio, con el JDK instalado:

```bash
javac -d out generado/ec/uteq/camaronera/piscinas/*.java \
      manual/ec/uteq/camaronera/piscinas/DemoPiscinas.java
java -cp out ec.uteq.camaronera.piscinas.DemoPiscinas
```

Salida esperada:

```
Muestreos del ciclo: 1
```

Esto confirma que el código generado compila sin errores y que la asociación
CicloCultivo–Muestreo funciona conforme al modelo. Evidencia en
`evidencias/capturas/04-compilacion-salida.png`.

## Cómo compilar el informe (`.tex` → `.pdf`)

El documento principal es `Documento/Informe.tex`, que incorpora
`Documento/secciones_5_6.tex`. Requiere `pdflatex` (o `xelatex`/`lualatex`) y
al menos **2 pasadas** para resolver referencias cruzadas y la bibliografía:

```bash
cd Documento
pdflatex Informe.tex
bibtex Informe
pdflatex Informe.tex
pdflatex Informe.tex
```

El resultado es `Documento/Informe.pdf`.

## Evidencia del proceso (capturas)

| Archivo | Contenido |
|---|---|
| `evidencias/capturas/01-panel-dividido.png` | Modelo cargado en UmpleOnline, diagrama de clases renderizado sin errores. |
| `evidencias/capturas/02-descarga.png` | Resultado de la generación de código Java (clase `Piscina`). |
| `evidencias/capturas/03-arbol-generado.png` | Árbol de los 10 archivos `.java` generados. |
| `evidencias/capturas/04-compilacion-salida.png` | Compilación y ejecución de `DemoPiscinas`, con la salida `Muestreos del ciclo: 1`. |

## Responsabilidades individuales

Ver la tabla de integrantes arriba y el detalle de commits en la pestaña
**Insights → Contributors** de este repositorio, así como la Sección 11
("Reparto del trabajo por integrante") del documento evidencia.
