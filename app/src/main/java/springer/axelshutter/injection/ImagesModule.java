package springer.axelshutter.injection;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import springer.axelshutter.rest.service.ShutterstockApi;
import springer.axelshutter.ui.ImagesActivity;
import springer.axelshutter.ui.ImagesInteractor;
import springer.axelshutter.ui.ImagesPresenter;

/**
 * Injection module for the Images
 */
@Module(
        injects = {ImagesActivity.class},
        addsTo = ShutterstockModule.class)
public class ImagesModule {

    @Provides
    @Singleton
    ImagesPresenter provideImagesPresenter(ShutterstockApi shutterstockApi) {
        ImagesInteractor imagesInteractor = new ImagesInteractor(shutterstockApi);
        return new ImagesPresenter(imagesInteractor);
    }

}
