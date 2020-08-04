package com.training.adl.api.questions;

import com.training.adl.api.constans.Constants;
import com.training.adl.api.models.calculator.MultiplyResponse;
import com.training.adl.api.utilities.SoapMapper;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TheValue;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import net.serenitybdd.screenplay.rest.questions.TheResponseStatusCode;

import static com.google.common.base.Predicates.equalTo;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class Multiplicacion implements Question {
    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                seeThat(new TheResponseStatusCode(), equalTo(200))
        );

        MultiplyResponse response = LastResponse.received().
                answeredBy(actor).
                as(MultiplyResponse.class);

        actor.should(
                seeThat(TheValue.of("Resultado de la multiplicación ", actor.recall(Constants.RESULTADOMULTIPLICACION)), equalTo(response.getMultiplyResult()))

        );
        return true;
    }
}
