package com.training.adl.api.stepdefinitions.calculadora.multiplicacion;

import com.training.adl.api.questions.Resultado;
import com.training.adl.api.tasks.Multiplicar;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;

public class multiplicarStepDefinitions {
    @Cuando("el intenta realizar una multiplicación")
    public void el_intenta_realizar_una_multiplicación() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Multiplicar.twoNumbersselectedRandom()
        );
    }

    @Entonces("el debería ver el resultado correcto de la multiplicacion")
    public void el_debería_ver_el_resultado_correcto_de_la_multiplicacion() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(
                Resultado.multiplicacion()));
    }
}
