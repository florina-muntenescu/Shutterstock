package springer.axelshutter.rest.service;

import android.os.Build;

import retrofit.RequestInterceptor;

/**
 * Interceptor for all requests done to the Shutterstock API.
 * Since we need to be authenticated to send a request, the interceptor will intercept the request
 * and add the authentication header
 */
public class ShutterstockRequestInterceptor implements RequestInterceptor {

    private static final String AUTH_VALUE = "Basic YjU5ZmQ4NDQxZTYxODc2MTBiM2E6ZmI5YzE5NzI5YjY5ZGFkMDUxZDJjZmY0NGI4M2E3Yjk4ZTc4NDYyOA==";


    @Override
    public void intercept(RequestFacade request) {
        request.addHeader("Authorization", AUTH_VALUE);
        request.addHeader("User-Agent", getUserAgent());
    }


    private String getUserAgent(){
        return "AxelShutterstock " + getDeviceTypeIdentifier();
    }

    /**
     * @return a string identifying the type (model) of the device the application is running on
     */
    private String getDeviceTypeIdentifier() {
        return Build.MANUFACTURER + "/" + Build.MODEL;
    }
}
