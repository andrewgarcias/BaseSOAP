# language: es
@SOAP @Calculator
Característica: restar

  **Como** usuario de la calculadora
  **Quiero** poder restar 2 numeros

  @Restar
  Escenario: Validación de la resta
    Dado que Pepito tiene acceso a la calculadora
    Cuando el intenta realizar una resta
    Entonces el debería ver el resultado correcto de la resta