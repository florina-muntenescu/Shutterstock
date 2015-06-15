package springer.axelshutter.ui;

import com.google.gson.Gson;

import junit.framework.TestCase;

import rx.Observable;
import springer.axelshutter.rest.model.SearchResponseEntity;

import static org.mockito.Matchers.anyList;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Tests for {@link ImagesPresenter}
 */
public class ImagesPresenterTest extends TestCase {

    public static final int DEFAULT_TIMEOUT = 5000;

    private Gson mGson = new Gson();

    public void testShowProgressIsCalled() {
        ImagesInteractor interactor = generateSuccessImagesInteractor();
        ImagesPresenter presenter = new ImagesPresenter(interactor);
        ImagesView view = mock(ImagesView.class);
        presenter.start(view);

        verify(view).showProgress();
    }

    public void testUpdateImagesListIsCalled() {
        ImagesInteractor interactor = generateSuccessImagesInteractor();
        ImagesPresenter presenter = new ImagesPresenter(interactor);
        ImagesView view = mock(ImagesView.class);
        presenter.start(view);

        verify(view).showProgress();
        verify(view, timeout(DEFAULT_TIMEOUT)).updateImagesList(anyList());
    }

    public void testShowErrorIsCalled() {
        ImagesInteractor interactor = generateErrorImageInteractor();
        ImagesPresenter presenter = new ImagesPresenter(interactor);
        ImagesView view = mock(ImagesView.class);
        presenter.start(view);

        verify(view).showProgress();
        verify(view, timeout(DEFAULT_TIMEOUT)).showError(anyString());
    }


    private ImagesInteractor generateSuccessImagesInteractor() {
        ImagesInteractor interactor = mock(ImagesInteractor.class);
        when(interactor.getNext()).thenReturn(Observable.<SearchResponseEntity>just(
                generateSearchResponseEntity()));

        return interactor;
    }

    private ImagesInteractor generateErrorImageInteractor() {
        ImagesInteractor interactor = mock(ImagesInteractor.class);
        when(interactor.getNext()).thenReturn(Observable.<SearchResponseEntity>error(new RuntimeException("error")));

        return interactor;
    }

    private SearchResponseEntity generateSearchResponseEntity() {
        return mGson.fromJson(RESPONSE, SearchResponseEntity.class);
    }


    private static final String RESPONSE = "{\n" +
            "    \"page\": 1,\n" +
            "    \"per_page\": 5,\n" +
            "    \"total_count\": 55293938,\n" +
            "    \"search_id\": \"jWOLyajSqivHYCg8dXWpLw\",\n" +
            "    \"data\": [\n" +
            "        {\n" +
            "            \"id\": \"273096269\",\n" +
            "            \"aspect\": 1.5455,\n" +
            "            \"assets\": {\n" +
            "                \"preview\": {\n" +
            "                    \"height\": 291,\n" +
            "                    \"url\": \"http://image.shutterstock.com/display_pic_with_logo/559519/273096269/stock-photo-young-mother-in-home-office-with-computer-and-her-daugher-273096269.jpg\",\n" +
            "                    \"width\": 450\n" +
            "                },\n" +
            "                \"small_thumb\": {\n" +
            "                    \"height\": 65,\n" +
            "                    \"url\": \"http://thumb7.shutterstock.com/thumb_small/559519/273096269/stock-photo-young-mother-in-home-office-with-computer-and-her-daugher-273096269.jpg\",\n" +
            "                    \"width\": 100\n" +
            "                },\n" +
            "                \"large_thumb\": {\n" +
            "                    \"height\": 97,\n" +
            "                    \"url\": \"http://thumb7.shutterstock.com/thumb_large/559519/273096269/stock-photo-young-mother-in-home-office-with-computer-and-her-daugher-273096269.jpg\",\n" +
            "                    \"width\": 150\n" +
            "                }\n" +
            "            },\n" +
            "            \"contributor\": {\n" +
            "                \"id\": \"559519\"\n" +
            "            },\n" +
            "            \"description\": \"Young mother in home office with computer and her daugher\",\n" +
            "            \"image_type\": \"photo\",\n" +
            "            \"media_type\": \"image\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": \"268450493\",\n" +
            "            \"aspect\": 1.5,\n" +
            "            \"assets\": {\n" +
            "                \"preview\": {\n" +
            "                    \"height\": 300,\n" +
            "                    \"url\": \"http://image.shutterstock.com/display_pic_with_logo/2324765/268450493/stock-photo-silhouette-of-cropped-shot-of-a-young-man-working-from-home-using-smart-phone-and-notebook-computer-268450493.jpg\",\n" +
            "                    \"width\": 450\n" +
            "                },\n" +
            "                \"small_thumb\": {\n" +
            "                    \"height\": 67,\n" +
            "                    \"url\": \"http://thumb10.shutterstock.com/thumb_small/2324765/268450493/stock-photo-silhouette-of-cropped-shot-of-a-young-man-working-from-home-using-smart-phone-and-notebook-computer-268450493.jpg\",\n" +
            "                    \"width\": 100\n" +
            "                },\n" +
            "                \"large_thumb\": {\n" +
            "                    \"height\": 100,\n" +
            "                    \"url\": \"http://thumb10.shutterstock.com/thumb_large/2324765/268450493/stock-photo-silhouette-of-cropped-shot-of-a-young-man-working-from-home-using-smart-phone-and-notebook-computer-268450493.jpg\",\n" +
            "                    \"width\": 150\n" +
            "                }\n" +
            "            },\n" +
            "            \"contributor\": {\n" +
            "                \"id\": \"2324765\"\n" +
            "            },\n" +
            "            \"description\": \"Silhouette of cropped shot of a young man working from home using smart phone and notebook computer, man's hands using smart phone in interior, man at his workplace using technology, flare light\",\n" +
            "            \"image_type\": \"photo\",\n" +
            "            \"media_type\": \"image\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": \"275666651\",\n" +
            "            \"aspect\": 1.4979,\n" +
            "            \"assets\": {\n" +
            "                \"preview\": {\n" +
            "                    \"height\": 300,\n" +
            "                    \"url\": \"http://image.shutterstock.com/display_pic_with_logo/828115/275666651/stock-photo-two-business-people-shaking-hands-as-successful-agreement-in-real-estate-agency-office-concept-of-275666651.jpg\",\n" +
            "                    \"width\": 450\n" +
            "                },\n" +
            "                \"small_thumb\": {\n" +
            "                    \"height\": 67,\n" +
            "                    \"url\": \"http://thumb7.shutterstock.com/thumb_small/828115/275666651/stock-photo-two-business-people-shaking-hands-as-successful-agreement-in-real-estate-agency-office-concept-of-275666651.jpg\",\n" +
            "                    \"width\": 100\n" +
            "                },\n" +
            "                \"large_thumb\": {\n" +
            "                    \"height\": 100,\n" +
            "                    \"url\": \"http://thumb7.shutterstock.com/thumb_large/828115/275666651/stock-photo-two-business-people-shaking-hands-as-successful-agreement-in-real-estate-agency-office-concept-of-275666651.jpg\",\n" +
            "                    \"width\": 150\n" +
            "                }\n" +
            "            },\n" +
            "            \"contributor\": {\n" +
            "                \"id\": \"828115\"\n" +
            "            },\n" +
            "            \"description\": \"Two business people shaking hands as successful agreement in real estate agency office. Concept of housing purchase and insurance. \",\n" +
            "            \"image_type\": \"photo\",\n" +
            "            \"media_type\": \"image\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": \"271745117\",\n" +
            "            \"aspect\": 1.447,\n" +
            "            \"assets\": {\n" +
            "                \"preview\": {\n" +
            "                    \"height\": 310,\n" +
            "                    \"url\": \"http://image.shutterstock.com/display_pic_with_logo/1428518/271745117/stock-photo-young-hipster-fashion-guy-with-computer-tablet-sitting-next-his-car-during-road-trip-concept-of-271745117.jpg\",\n" +
            "                    \"width\": 450\n" +
            "                },\n" +
            "                \"small_thumb\": {\n" +
            "                    \"height\": 69,\n" +
            "                    \"url\": \"http://thumb10.shutterstock.com/thumb_small/1428518/271745117/stock-photo-young-hipster-fashion-guy-with-computer-tablet-sitting-next-his-car-during-road-trip-concept-of-271745117.jpg\",\n" +
            "                    \"width\": 100\n" +
            "                },\n" +
            "                \"large_thumb\": {\n" +
            "                    \"height\": 104,\n" +
            "                    \"url\": \"http://thumb10.shutterstock.com/thumb_large/1428518/271745117/stock-photo-young-hipster-fashion-guy-with-computer-tablet-sitting-next-his-car-during-road-trip-concept-of-271745117.jpg\",\n" +
            "                    \"width\": 150\n" +
            "                }\n" +
            "            },\n" +
            "            \"contributor\": {\n" +
            "                \"id\": \"1428518\"\n" +
            "            },\n" +
            "            \"description\": \"Young hipster fashion guy with computer tablet sitting next his car during road trip - Concept of new trends and technology mixed with vintage lifestyle - Traveler man on retro nostalgic filtered look\",\n" +
            "            \"image_type\": \"photo\",\n" +
            "            \"media_type\": \"image\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": \"267153857\",\n" +
            "            \"aspect\": 1.1426,\n" +
            "            \"assets\": {\n" +
            "                \"preview\": {\n" +
            "                    \"height\": 393,\n" +
            "                    \"url\": \"http://image.shutterstock.com/display_pic_with_logo/1293919/267153857/stock-vector-set-luxury-logos-template-flourishes-calligraphic-elegant-ornament-lines-business-sign-identity-267153857.jpg\",\n" +
            "                    \"width\": 450\n" +
            "                },\n" +
            "                \"small_thumb\": {\n" +
            "                    \"height\": 88,\n" +
            "                    \"url\": \"http://thumb10.shutterstock.com/thumb_small/1293919/267153857/stock-vector-set-luxury-logos-template-flourishes-calligraphic-elegant-ornament-lines-business-sign-identity-267153857.jpg\",\n" +
            "                    \"width\": 100\n" +
            "                },\n" +
            "                \"large_thumb\": {\n" +
            "                    \"height\": 131,\n" +
            "                    \"url\": \"http://thumb10.shutterstock.com/thumb_large/1293919/267153857/stock-vector-set-luxury-logos-template-flourishes-calligraphic-elegant-ornament-lines-business-sign-identity-267153857.jpg\",\n" +
            "                    \"width\": 150\n" +
            "                }\n" +
            "            },\n" +
            "            \"contributor\": {\n" +
            "                \"id\": \"1293919\"\n" +
            "            },\n" +
            "            \"description\": \"Set Luxury Logos template flourishes calligraphic elegant ornament lines. Business sign, identity for Restaurant, Royalty, Boutique, Hotel, Heraldic, Jewelry, Fashion and other vector illustration\",\n" +
            "            \"image_type\": \"vector\",\n" +
            "            \"media_type\": \"image\"\n" +
            "        }\n" +
            "    ]\n" +
            "}";
}
