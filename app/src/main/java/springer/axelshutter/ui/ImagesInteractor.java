package springer.axelshutter.ui;

import rx.Observable;
import springer.axelshutter.rest.model.SearchResponseEntity;
import springer.axelshutter.rest.service.ShutterstockApi;

/**
 * Handles the communication to the API
 */
public class ImagesInteractor {
    private static final int PAGE_SIZE = 10;

    private int mLastRequestedPage;

    private ShutterstockApi mShutterstockApi;

    public ImagesInteractor(ShutterstockApi api) {
        mShutterstockApi = api;
    }

    Observable<SearchResponseEntity> getNext() {
        return mShutterstockApi.getSearchImages(mLastRequestedPage++, PAGE_SIZE);
    }
}
