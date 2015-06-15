package springer.axelshutter.rest.service;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;
import springer.axelshutter.rest.model.SearchResponseEntity;

/**
 *
 */
public interface ShutterstockApi {
    /**
     * Returns the list of images depending on the parameters
     *
     * @throws retrofit.RetrofitError
     * @see <a href="https://developers.shutterstock.com/guides/search">/v2/images/search</a>
     */
    @GET("/v2/images/search")
    Observable<SearchResponseEntity> getSearchImages(@Query("per_page") int pageSize,
                                                     @Query("page") int page);
}
