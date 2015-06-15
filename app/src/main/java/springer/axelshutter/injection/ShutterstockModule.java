package springer.axelshutter.injection;

import dagger.Module;
import dagger.Provides;
import springer.axelshutter.rest.RestClient;
import springer.axelshutter.rest.service.ShutterstockApi;

/**
 * Shutterstock module. Provides the Shutterstock API
 */
@Module(
        library = true
)
public class ShutterstockModule {
    @Provides
    ShutterstockApi provideShutterstockApi() {
        RestClient restClient = new RestClient();
        return restClient.getShutterstockApi();
    }
}
