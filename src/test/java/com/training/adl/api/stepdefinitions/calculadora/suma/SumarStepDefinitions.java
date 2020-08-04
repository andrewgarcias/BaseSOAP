package com.training.adl.api.stepdefinitions.calculadora.suma;

import com.training.adl.api.constans.Constants;
import com.training.adl.api.questions.Resultado;
import com.training.adl.api.tasks.Sumar;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class SumarStepDefinitions {



    @Dado("que {word} tiene acceso a la calculadora")
    public void que_Pepito_tiene_acceso_a_la_calculadora(String actorName) {
        //OnStage.theActorCalled(actorName).whoCan(CallAnApi.at(OnStage.theActorInTheSpotlight().recall(Constants.SOAP_BASE_URL)));
        OnStage.theActorCalled(actorName);
    }

    @Cuando("el intenta realizar una suma")
    public void el_intenta_realizar_una_suma() {

        OnStage.theActorInTheSpotlight().attemptsTo(
                Sumar.twoNumbersselectedRandom()
        );
    }

    @Entonces("el debería ver el resultado correcto de la suma")
    public void el_debería_ver_el_resultado_correcto_de_la_suma() {
       OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(
               Resultado.suma()));


    }
}
