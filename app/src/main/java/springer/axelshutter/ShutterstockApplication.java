package springer.axelshutter;

import android.app.Application;
import android.content.Context;

import dagger.ObjectGraph;
import springer.axelshutter.injection.ShutterstockModule;

/**
 * Application class. Extended for injection implementation
 */
public class ShutterstockApplication extends Application {
    private ObjectGraph objectGraph;

    @Override
    public void onCreate() {
        super.onCreate();

        buildObjectGraphAndInject();

    }

    public void buildObjectGraphAndInject() {
        objectGraph = ObjectGraph.create(new ShutterstockModule());
    }

    public void inject(Object o) {
        objectGraph.inject(o);
    }

    public static ShutterstockApplication get(Context context) {
        return (ShutterstockApplication) context.getApplicationContext();
    }

    public ObjectGraph getApplicationGraph() {
        return objectGraph;
    }
}
