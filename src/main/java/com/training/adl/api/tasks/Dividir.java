package com.training.adl.api.tasks;

import com.github.javafaker.Faker;
import com.training.adl.api.constans.Constants;
import com.training.adl.api.helper.HelperGetRequest;
import com.training.adl.api.models.calculator.Divide;
import com.training.adl.api.utilities.SoapMapper;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Dividir implements Task {

    public static Dividir twoNumbersselectedRandom() {
        return instrumented (Dividir.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Faker faker = new Faker();
        Divide divide = new Divide();
        divide.setIntA(faker.random().nextInt(1,100));
        divide.setIntB(faker.random().nextInt(1,3));
        actor.remember(Constants.NUMBERDIVISIONA1,divide.getIntA());
        actor.remember(Constants.NUMBERDIVISIONA2,divide.getIntB());
        actor.remember(Constants.RESULTADODIVISION,(divide.getIntA()/divide.getIntB()));
        Serenity.recordReportData().withTitle("El Dividendo es: " + divide.getIntA() + " el Divisor es: "+divide.getIntB()).andContents("y el resulado debe ser: "+(divide.getIntA()/divide.getIntB()));
        actor.attemptsTo(
                Post.to(Constants.RESOURCE).with(request -> request
                        .headers(HelperGetRequest.getHeaderDivision())
                        .body(divide))
        );
    }
}
