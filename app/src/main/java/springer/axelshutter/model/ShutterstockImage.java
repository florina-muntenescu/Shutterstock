package springer.axelshutter.model;

import com.google.gson.annotations.SerializedName;

/**
 * Represents a shutterstock image.
 * Strip the data received from BE and save only the necessary data
 */
public class ShutterstockImage {

    @SerializedName("assets")
    private ShutterstockAssets mAssets;
    @SerializedName("description")
    private String mDescription;

    public ShutterstockAssets getAssets() {
        return mAssets;
    }

    public String getDescription() {
        return mDescription;
    }
}
