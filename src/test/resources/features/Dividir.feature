# language: es
@SOAP @Calculator
Característica: Dividir

  **Como** usuario de la calculadora
  **Quiero** poder dividir 2 numeros

  @Dividir
  Escenario: Validación de la divición
    Dado que Pepito tiene acceso a la calculadora
    Cuando el intenta realizar una division
    Entonces el debería ver el resultado correcto de la division