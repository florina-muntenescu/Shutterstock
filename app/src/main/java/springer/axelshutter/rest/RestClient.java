package springer.axelshutter.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;
import springer.axelshutter.rest.service.ShutterstockApi;
import springer.axelshutter.rest.service.ShutterstockRequestInterceptor;

/**
 * RestClient
 */
public class RestClient {

    private static final String BASE_URL = "https://api.shutterstock.com";

    private ShutterstockApi mShutterstockApi;

    public RestClient(){
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'")
                .create();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(BASE_URL)
                .setConverter(new GsonConverter(gson))
                .setRequestInterceptor(new ShutterstockRequestInterceptor()) // This is the important line ;)
                .build();

        mShutterstockApi = restAdapter.create(ShutterstockApi.class);
    }

    public ShutterstockApi getShutterstockApi() {
        return mShutterstockApi;
    }
}
