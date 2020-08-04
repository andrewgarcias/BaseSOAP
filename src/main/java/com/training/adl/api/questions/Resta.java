package com.training.adl.api.questions;

import com.training.adl.api.constans.Constants;
import com.training.adl.api.models.calculator.SubtractResponse;
import com.training.adl.api.utilities.SoapMapper;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TheValue;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import net.serenitybdd.screenplay.rest.questions.TheResponseStatusCode;

import static com.google.common.base.Predicates.equalTo;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class Resta implements Question {


    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                seeThat(new TheResponseStatusCode(), equalTo(200))
        );

        SubtractResponse response = LastResponse.received().
                answeredBy(actor).
                as(SubtractResponse.class);

        actor.should(
                seeThat(TheValue.of("Resultado de la resta ", actor.recall(Constants.RESULTADORESTA)), equalTo(response.getSubtractResult()))

        );
        return true;

    }
}
