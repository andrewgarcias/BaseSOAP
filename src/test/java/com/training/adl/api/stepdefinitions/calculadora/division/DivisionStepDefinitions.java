package com.training.adl.api.stepdefinitions.calculadora.division;

import com.training.adl.api.questions.Resultado;
import com.training.adl.api.tasks.Dividir;
import com.training.adl.api.tasks.Sumar;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;

public class DivisionStepDefinitions {
    @Cuando("el intenta realizar una division")
    public void el_intenta_realizar_una_division() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Dividir.twoNumbersselectedRandom()
        );
    }

    @Entonces("el debería ver el resultado correcto de la division")
    public void el_debería_ver_el_resultado_correcto_de_la_division() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(
                Resultado.division()));
    }
}
