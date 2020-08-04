package com.training.adl.api.tasks;

import com.github.javafaker.Faker;

import com.training.adl.api.constans.Constants;
import com.training.adl.api.helper.HelperGetRequest;
import com.training.adl.api.models.calculator.Add;
import lombok.SneakyThrows;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class  Sumar implements Task {
    public static Sumar twoNumbersselectedRandom() {
        return instrumented(Sumar.class);
    }




    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {


        Faker faker = new Faker();
        Add suma = new Add();
        suma.setIntA(faker.random().nextInt(0,100));
        suma.setIntB(faker.random().nextInt(0,100));
        actor.remember(Constants.NUMBERSUMA1,suma.getIntA());
        actor.remember(Constants.NUMBERSUMA2,suma.getIntB());
        actor.remember(Constants.RESULTADOSUMA,(suma.getIntA()+suma.getIntB()));

        Serenity.recordReportData().withTitle("El primer numero a sumar es:" + suma.getIntA() + " el segundo numero a sumar es: "+suma.getIntB()).andContents("y el resulado debe ser: "+(suma.getIntA()+suma.getIntB()));
        actor.attemptsTo(
                            Post.to(Constants.RESOURCE).with(request -> request
                                    .headers(HelperGetRequest.getHeaderSuma())
                                    .body(suma))
                        );

    }
}
