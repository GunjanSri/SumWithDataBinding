package com.example.gunjansrivastava.activitylifecycle;

import android.content.Context;
import android.widget.Toast;

public class AppVisibilityManager implements OnAppVisibilityListener{
    private static final AppVisibilityManager ourInstance = new AppVisibilityManager();
    private static Context context;

    public static AppVisibilityManager getInstance(Context context) {
        AppVisibilityManager.context = context;
        return ourInstance;
    }

    private AppVisibilityManager() {
    }

    @Override
    public void onAppInForeground() {
        Toast.makeText(context,context.getClass().getSimpleName()+"is in foreground", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onAppInBackground() {
        Toast.makeText(context,context.getClass().getSimpleName()+"is in background", Toast.LENGTH_LONG).show();
    }
}
