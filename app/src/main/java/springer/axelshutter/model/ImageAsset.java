package springer.axelshutter.model;

import com.google.gson.annotations.SerializedName;

/**
 * Represents an image asset received from Shutterstock api
 * e.g.
 * {
 * "height": 300,
 * "url": "http://image.shutterstock.com/display_pic_with_logo/828115/275666651/stock-photo-two-business-people-shaking-hands-as-successful-agreement-in-real-estate-agency-office-concept-of-275666651.jpg",
 * "width": 450
 * }
 */
public class ImageAsset {
    @SerializedName("height")
    private int mHeight;
    @SerializedName("width")
    private int mWidth;
    @SerializedName("url")
    private String mUrl;

    public int getHeight() {
        return mHeight;
    }

    public int getWidth() {
        return mWidth;
    }

    public String getUrl() {
        return mUrl;
    }
}
