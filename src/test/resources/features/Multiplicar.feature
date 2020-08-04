# language: es
@SOAP @Calculator
Característica: multiplicar

  **Como** usuario de la calculadora
  **Quiero** poder multiplicar 2 numeros

  @Multiplicar
  Escenario: Validación de la multiplicación
    Dado que Pepito tiene acceso a la calculadora
    Cuando el intenta realizar una multiplicación
    Entonces el debería ver el resultado correcto de la multiplicacion

