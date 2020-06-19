package com.howlingsails.healthcare.fhirgather.controllers;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.client.api.IClientInterceptor;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import ca.uhn.fhir.rest.client.interceptor.BasicAuthInterceptor;
import ca.uhn.fhir.rest.gclient.IFetchConformanceUntyped;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FHIRGatherer {

    @RequestMapping("/test")
    public String tryItOut() {
        FhirContext fhirContext = FhirContext.forR4();
        // TODO: Add Server URL
        String serverUrlBase = "http://<<NOWHERE>/R4?";
        IGenericClient client = fhirContext.newRestfulGenericClient(serverUrlBase);

        // Create an HTTP basic auth interceptor per https://hapifhir.io/hapi-fhir/docs/interceptors/built_in_client_interceptors.html
        String username = "foobar";
        String password = "boobear";
        IClientInterceptor authInterceptor = new BasicAuthInterceptor(username, password);
        client.registerInterceptor(authInterceptor);

        Gson gson = new Gson();
        IFetchConformanceUntyped cap = client.capabilities();

        return "Hello FHIRoto  -]:-)>\n" + gson.toJson(cap);
    }
}
