# language: es
@SOAP @Calculator
Característica: sumar

  **Como** usuario de la calculadora
  **Quiero** poder sumar 2 numeros

  @Sumar
  Escenario: Validación de la suma
    Dado que Pepito tiene acceso a la calculadora
    Cuando el intenta realizar una suma
    Entonces el debería ver el resultado correcto de la suma

