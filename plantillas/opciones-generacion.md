# Opciones de generación — Módulo de Piscinas (Camaronera)

Este archivo documenta la parametrización del proceso de generación de
código a partir del modelo UML, conforme a la Sección 5 del documento
evidencia (`Informe.tex`).

## 1. Herramienta

- **Nombre:** UmpleOnline
- **URL:** https://try.umple.org
- **Versión exacta:** v1.37.0.8639.f07c3e9b7
- **Fecha de acceso:** 20 de julio de 2026

## 2. Fuente única de generación

- **Archivo modelo:** `modelo/camaronera.ump`
- **Commit de referencia (hash completo):**
  `0a2d178385b027df7bca755653b2804fbe7a812d`
- El archivo no se duplica en otras carpetas del repositorio para
  evitar divergencias entre el modelo y el código generado.

## 3. Opción de generación utilizada

- **Generador:** Java Code (menú *Generate* de UmpleOnline).
- **Namespace declarado:** `ec.uteq.camaronera.piscinas`
  (primera línea de `modelo/camaronera.ump`).

## 4. Generadores descartados y motivo

| Generador descartado | Motivo |
|---|---|
| `UmpleToSql` | La persistencia está fuera del alcance de este módulo. |
| Generación de pruebas | Solo disponible vía compilador por línea de comandos, no en el panel web de UmpleOnline. La verificación funcional se realizó mediante la unidad demostrable `DemoPiscinas.java`. |

## 5. Política ante regeneración

Umple sobrescribe por completo las clases modeladas al regenerar; no
incluye bloques protegidos. Regla adoptada por el equipo:

- Prohibido editar archivos dentro de `generado/`.
- Todo cambio de dominio nace en `modelo/camaronera.ump` y se
  regenera.
- El código escrito a mano (`DemoPiscinas.java`) vive exclusivamente
  en `manual/`, fuera del árbol regenerado.

## 6. Procedimiento de exportación

1. Generar: *Generate → Java Code* en UmpleOnline.
2. Descargar: opción *Download Files* del panel **SAVE & LOAD**.
3. Descomprimir el paquete en `generado/`, conservando el árbol de
   paquetes `ec/uteq/camaronera/piscinas/`.
