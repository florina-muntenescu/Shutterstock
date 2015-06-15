package springer.axelshutter.rest.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import springer.axelshutter.model.ShutterstockImage;

/**
 * Response received for a search call on the Shutterstock API
 */
public class SearchResponseEntity {
    @SerializedName("data")
    private List<ShutterstockImage> mData;

    public List<ShutterstockImage> getData() {
        return mData;
    }
}
