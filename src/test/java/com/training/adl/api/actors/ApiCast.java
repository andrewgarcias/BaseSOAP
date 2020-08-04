package com.training.adl.api.actors;

import com.training.adl.api.TestEnvironments;
import com.training.adl.api.constans.Constants;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

public class ApiCast extends Cast {
    private final TestEnvironments testEnvironments;

    public ApiCast(EnvironmentVariables environmentVariables) {
        this.testEnvironments = new TestEnvironments(environmentVariables);
    }

    @Override
    public Actor actorNamed(String actorName, Ability... abilities) {
        Actor theActor = null;
        theActor = super.actorNamed(actorName, CallAnApi.at(testEnvironments.getRestBaseUrl()))
                .describedAs("Usuario que ha obtenido los privilegios para usar la calculadora");
        theActor.remember(Constants.SOAP_BASE_URL, testEnvironments.getRestBaseUrl());
        //theActor.whoCan(CallAnApi.at(testEnvironments.getRestBaseUrl()));
        return theActor;
    }
}
