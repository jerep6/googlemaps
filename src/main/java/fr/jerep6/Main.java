package fr.jerep6;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;

import java.io.IOException;

public class Main {
    private static String KEY = "YOUR_API_KEY";
    public static void main(String[] args) throws InterruptedException, ApiException, IOException {

        GeoApiContext contextDefault = new GeoApiContext() .setApiKey(KEY);
        GeoApiContext contextCustom = new GeoApiContext(new OkHttpRequestWithCustomHeaderHandler()).setApiKey(KEY);


        System.out.println("0 résultat car pas de header Accept-language => " + makeGeocodeRequest(contextDefault).length);
        System.out.println("1 résultat car header Accept-language fr => " + makeGeocodeRequest(contextCustom).length);
    }

    public static  GeocodingResult[] makeGeocodeRequest(GeoApiContext context) throws InterruptedException, ApiException, IOException {
        return GeocodingApi.geocode(context,
                "LES MATALS 09120 SAINT FELIX DE RIEUTORT").region("FR").await();
    }


}
