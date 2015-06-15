package springer.axelshutter.model;

import com.google.gson.annotations.SerializedName;

public class ShutterstockAssets {

    @SerializedName("preview")
    private ImageAsset mPreview;

    public ImageAsset getPreview() {
        return mPreview;
    }

}
