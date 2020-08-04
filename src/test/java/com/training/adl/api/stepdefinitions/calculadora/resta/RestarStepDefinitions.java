package com.training.adl.api.stepdefinitions.calculadora.resta;

import com.training.adl.api.questions.Resultado;
import com.training.adl.api.tasks.Restar;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actors.OnStage;

public class RestarStepDefinitions {
    @Cuando("el intenta realizar una resta")
    public void el_intenta_realizar_una_resta() {
        OnStage.theActorInTheSpotlight().attemptsTo(
        Restar.twoNumbersselectedRandom()
        );
    }

    @Entonces("el debería ver el resultado correcto de la resta")
    public void el_debería_ver_el_resultado_correcto_de_la_resta() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(Resultado.resta()));
        //OnStage.theActorInTheSpotlight()
               // .attemptsTo(Resultado.resta());
    }
}

