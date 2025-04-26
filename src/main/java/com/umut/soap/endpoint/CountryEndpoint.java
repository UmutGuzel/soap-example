package com.umut.soap.endpoint;

import com.example.soap.gen.Country;
import com.example.soap.gen.GetCountryRequest;
import com.example.soap.gen.GetCountryResponse;
import com.umut.soap.service.CountryService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CountryEndpoint {
    private static  final String NAMESPACE_URI = "http://example.com/countries";

    private final CountryService countryService;

    public CountryEndpoint(CountryService countryService){
        this.countryService = countryService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request){
        GetCountryResponse response = new GetCountryResponse();
        Country country = countryService.findCountry(request.getName());
        response.setCountry(country);
        return response;
    }
}
