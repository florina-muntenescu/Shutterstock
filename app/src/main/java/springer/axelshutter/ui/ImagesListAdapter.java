package springer.axelshutter.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import springer.axelshutter.R;
import springer.axelshutter.model.ShutterstockImage;

/**
 * Provides the views for the list
 */
public class ImagesListAdapter extends RecyclerView.Adapter<ImagesListAdapter.ViewHolder> {

    private static final String TAG = ImagesListAdapter.class.getSimpleName();

    private List<ShutterstockImage> mDataSet;

    private Context mContext;

    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView mTextview;
        private final ImageView mImageView;

        public ViewHolder(View v) {
            super(v);
            mTextview = (TextView) v.findViewById(R.id.textView);
            mImageView = (ImageView) v.findViewById(R.id.imageView);
        }

        public TextView getTextView() {
            return mTextview;
        }

        public ImageView getImageView() {
            return mImageView;
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet List<ShutterstockImage> containing the data to populate views to be used by RecyclerView.
     */
    public ImagesListAdapter(List<ShutterstockImage> dataSet, Context context) {
        mDataSet = dataSet;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_image_row_item, viewGroup, false);

        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        ShutterstockImage image = mDataSet.get(position);
        String url = image.getAssets().getPreview().getUrl();
        viewHolder.getTextView().setText(image.getDescription());

        Picasso.with(mContext)
                .load(url)
                .placeholder(R.color.primary_material_light)
                .into(viewHolder.getImageView());
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public void update(List<ShutterstockImage> images){
        mDataSet.addAll(images);
        notifyDataSetChanged();
    }
}
