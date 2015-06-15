package springer.axelshutter.ui;

import java.util.List;

import springer.axelshutter.model.ShutterstockImage;

/**
 * Defines the methods of a view that is capable of displaying a list of images
 */
public interface ImagesView {

    /**
     * Updates the list of images
     *
     * @param images
     */
    void updateImagesList(List<ShutterstockImage> images);

    /**
     * Display a progress while the images are being retrieved
     */
    void showProgress();

    /**
     * Hide the progress
     */
    void hideProgress();

    /**
     * Display an error message in case of error
     * @param error
     */
    void showError(String error);

    ImagesView NONE = new ImagesView() {
        @Override
        public void updateImagesList(List<ShutterstockImage> images) {

        }

        @Override
        public void showProgress() {

        }

        @Override
        public void hideProgress() {

        }

        @Override
        public void showError(String error) {

        }
    };
}
