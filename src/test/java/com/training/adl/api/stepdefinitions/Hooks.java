/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package com.training.adl.api.stepdefinitions;


import com.training.adl.api.actors.ApiCast;
import com.training.adl.api.utilities.SoapMapper;
import io.cucumber.java.Before;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.util.EnvironmentVariables;


public class Hooks {
    private EnvironmentVariables environmentVariables;

    @Before(value = "@Calculator", order = 0)
    public void settingTheStage() {
        SerenityRest.objectMapper(SoapMapper.xml());
        OnStage.setTheStage(
            new ApiCast(environmentVariables));
    }
}
