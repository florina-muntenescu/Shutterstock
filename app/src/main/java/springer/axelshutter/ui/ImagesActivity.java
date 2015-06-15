package springer.axelshutter.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.ObjectGraph;
import springer.axelshutter.R;
import springer.axelshutter.ShutterstockApplication;
import springer.axelshutter.injection.ImagesModule;
import springer.axelshutter.model.ShutterstockImage;

public class ImagesActivity extends AppCompatActivity implements ImagesView {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;

    private ProgressBar mProgressBar;

    private ImagesListAdapter mAdapter;

    @Inject
    ImagesPresenter mImagesPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        buildGraphAndInjectSelf();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);

        mLayoutManager = new LinearLayoutManager(this);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mProgressBar = (ProgressBar) findViewById(R.id.progress);

        int scrollPosition = 0;
        // If a layout manager has already been set, getNextImages current scroll position.
        if (mRecyclerView.getLayoutManager() != null) {
            scrollPosition = ((LinearLayoutManager) mRecyclerView.getLayoutManager())
                    .findFirstCompletelyVisibleItemPosition();
        }
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.scrollToPosition(scrollPosition);

        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int visibleItemCount = mLayoutManager.getChildCount();
                int totalItemCount = mLayoutManager.getItemCount();
                int pastVisiblesItems = ((LinearLayoutManager)mLayoutManager).findLastVisibleItemPosition();

                mImagesPresenter.listScrolled(visibleItemCount, pastVisiblesItems, totalItemCount);
            }
        });

        mAdapter = new ImagesListAdapter(new ArrayList<ShutterstockImage>(), this);
        mRecyclerView.setAdapter(mAdapter);

        mImagesPresenter.start(this);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mImagesPresenter != null) {
            mImagesPresenter.stop();
        }
    }

    private void buildGraphAndInjectSelf() {
        ObjectGraph objectGraph = getApplicationGraph().plus(new ImagesModule());
        objectGraph.inject(this);
    }

    public ObjectGraph getApplicationGraph() {
        return ((ShutterstockApplication) getApplicationContext()).getApplicationGraph();
    }

    @Override
    public void updateImagesList(List<ShutterstockImage> images) {
        mAdapter.update(images);
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getApplicationContext(), getString(R.string.error, error), Toast.LENGTH_LONG);
    }
}
