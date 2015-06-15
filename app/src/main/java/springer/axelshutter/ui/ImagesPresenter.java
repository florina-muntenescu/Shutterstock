package springer.axelshutter.ui;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import springer.axelshutter.model.ShutterstockImage;
import springer.axelshutter.rest.model.SearchResponseEntity;

/**
 * Presenter that tells the view what to display
 */
public class ImagesPresenter {

    private static final int ITEM_THRESHOLD = 10;

    private final ImagesInteractor mImagesInteractor;

    private Subscription mImageSearchSubscription;

    private ImagesView mView = ImagesView.NONE;

    private List<ShutterstockImage> mShutterstockImageList;

    public ImagesPresenter(ImagesInteractor imagesInteractor) {
        mImagesInteractor = imagesInteractor;
        mShutterstockImageList = new ArrayList<>();
    }

    public void start(ImagesView view) {
        mView = view;
        if(mShutterstockImageList.isEmpty()){
            getNextImages();
        }
    }

    public void stop() {
        mView = ImagesView.NONE;
        mImageSearchSubscription.unsubscribe();
    }

    public void getNextImages() {
        mView.showProgress();
        mImageSearchSubscription = getImages();
    }

    public void listScrolled(int visible, int pastVisible, int total){
        if(visible + pastVisible + ITEM_THRESHOLD >= total){
            getNextImages();
        }
    }
    /**
     * Issues request to the backend in order to send email receipt to the customer
     */
    private Subscription getImages() {
        final Observable<SearchResponseEntity> observable = mImagesInteractor.getNext();
        return observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SearchImagesSubscriber());
    }

    /**
     * Subscriber used to handle error or success case of the "send receipt" BE request
     */
    private class SearchImagesSubscriber implements Observer<SearchResponseEntity> {

        private SearchImagesSubscriber() {
        }

        @Override
        public void onCompleted() {
            // nothing to do here
        }

        @Override
        public void onError(Throwable e) {
            mView.hideProgress();
            mView.showError(e.getMessage());
        }

        @Override
        public void onNext(SearchResponseEntity responseEntity) {
            mShutterstockImageList = responseEntity.getData();
            mView.hideProgress();
            mView.updateImagesList(mShutterstockImageList);
        }


    }
}
