package com.example.gunjansrivastava.activitylifecycle;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.gunjansrivastava.activitylifecycle.databinding.ActivityMainBinding;
import com.example.gunjansrivastava.activitylifecycle.viewmodel.AddNumberViewModel;

public class MainActivity extends AppCompatActivity {

    AppVisibilityManager appVisibilityManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appVisibilityManager = AppVisibilityManager.getInstance(this);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.setPresenter(new AddNumberViewModel());
    }

    @Override
    protected void onStop() {
        super.onStop();
        appVisibilityManager.onAppInBackground();
    }

    @Override
    protected void onStart() {
        super.onStart();
        appVisibilityManager.onAppInForeground();
    }
}
