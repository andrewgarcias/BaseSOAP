package com.training.adl.api.tasks;

import com.github.javafaker.Faker;
import com.training.adl.api.constans.Constants;
import com.training.adl.api.helper.HelperGetRequest;
import com.training.adl.api.models.calculator.Multiply;
import com.training.adl.api.utilities.SoapMapper;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Multiplicar implements Task {
    public static Multiplicar twoNumbersselectedRandom() {
        return instrumented(Multiplicar.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Faker faker = new Faker();
        Multiply multiply = new Multiply();
        multiply.setIntA(faker.random().nextInt(0,100));
        multiply.setIntB(faker.random().nextInt(0,100));
        actor.remember(Constants.NUMBERMULTIPLICACIONA1,multiply.getIntA());
        actor.remember(Constants.NUMBERMULTIPLICACIONA2,multiply.getIntB());
        actor.remember(Constants.RESULTADOMULTIPLICACION,(multiply.getIntA()*multiply.getIntB()));
        Serenity.recordReportData().withTitle("El Multiplicando es: " + multiply.getIntA() + " el Multiplicador es: "+multiply.getIntB()).andContents("y el resulado debe ser: "+(multiply.getIntA()*multiply.getIntB()));
        actor.attemptsTo(
                Post.to(Constants.RESOURCE).with(request -> request
                        .headers(HelperGetRequest.getHeaderMultiplicacion())
                        .body(multiply))
        );
    }
}
