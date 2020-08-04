package com.training.adl.api.helper;



import java.util.HashMap;
import java.util.Map;

public class HelperGetRequest {

    public static Map<String, Object> getHeaderSuma() {

        Map<String, Object> headers = new HashMap<>();
        headers.put("Content-Type","text/xml;charset=UTF-8");
        headers.put("SOAPAction","http://tempuri.org/Add");
        return headers;

    }

    public static Map<String, Object> getHeaderResta() {

        Map<String, Object> headers = new HashMap<>();
        headers.put("Content-Type","text/xml;charset=UTF-8");
        headers.put("SOAPAction","http://tempuri.org/Subtract");
        return headers;

    }

    public static Map<String, Object> getHeaderMultiplicacion(){

        Map<String, Object> headers = new HashMap<>();
        headers.put("Content-Type","text/xml;charset=UTF-8");
        headers.put("SOAPAction","http://tempuri.org/Multiply");
        return headers;

    }
    public static Map<String, Object> getHeaderDivision(){

        Map<String, Object> headers = new HashMap<>();
        headers.put("Content-Type","text/xml;charset=UTF-8");
        headers.put("SOAPAction","http://tempuri.org/Divide");
        return headers;

    }

    public static Map<String, Object> getHeaderForGet() {
        Map<String, Object> headers = new HashMap<>();
        headers.put("User-Agent", "PostmanRuntime/7.25.0");
        headers.put("Accept", "*/*");
        headers.put("Cache-Control", "no-cache");
       //headers.put("Cookie", "PHPSESSID=baf3228658903e614c5531b917a9e0d6; ezoref_133674=; ezoadgid_133674=-1; ezoab_133674=mod10-c; active_template::133674=pub_site.1591321456");

        return headers;
    }

}
