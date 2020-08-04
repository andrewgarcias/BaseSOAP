package com.training.adl.api.tasks;

import com.github.javafaker.Faker;
import com.training.adl.api.constans.Constants;
import com.training.adl.api.helper.HelperGetRequest;
import com.training.adl.api.models.calculator.Subtract;
import com.training.adl.api.utilities.SoapMapper;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Restar implements Task {


    public static Restar twoNumbersselectedRandom() {
        return instrumented(Restar.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Faker faker = new Faker();
        Subtract resta = new Subtract();
        resta.setIntA(faker.random().nextInt(0,100));
        resta.setIntB(faker.random().nextInt(0,100));
        actor.remember(Constants.NUMBERRESTA1,resta.getIntA());
        actor.remember(Constants.NUMBERRESTA2,resta.getIntB());
        actor.remember(Constants.RESULTADORESTA,(resta.getIntA()-resta.getIntB()));
        Serenity.recordReportData().withTitle("El minuendo es: " + resta.getIntA() + " el sustraendo es: "+resta.getIntB()).andContents("y el resulado debe ser: "+(resta.getIntA()-resta.getIntB()));
        actor.attemptsTo(
                Post.to(Constants.RESOURCE).with(request -> request
                        .headers(HelperGetRequest.getHeaderResta())
                        .body(resta))
        );
    }
}
