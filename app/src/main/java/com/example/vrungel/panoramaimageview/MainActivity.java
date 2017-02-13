package com.example.vrungel.panoramaimageview;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.gjiazhe.panoramaimageview.GyroscopeObserver;
import com.gjiazhe.panoramaimageview.PanoramaImageView;

public class MainActivity extends AppCompatActivity {

  private GyroscopeObserver mGyroscopeObserver;
  private TextView mTextView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mGyroscopeObserver = new GyroscopeObserver();
    mGyroscopeObserver.setMaxRotateRadian(Math.PI / 2);

    PanoramaImageView panoramaImageView =
        (PanoramaImageView) findViewById(R.id.panorama_image_view);
    mTextView = (TextView) findViewById(R.id.tvText);

    panoramaImageView.setGyroscopeObserver(mGyroscopeObserver);

    panoramaImageView.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        ActivityOptions transitionActivityOptions = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
          transitionActivityOptions =
              ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, mTextView,
                  "transitionName");
          startActivity(new Intent(MainActivity.this, SecondActivity.class),
              transitionActivityOptions.toBundle());
        }
      }
    });
  }

  @Override protected void onResume() {
    super.onResume();
    mGyroscopeObserver.register(this);
  }

  @Override protected void onPause() {
    super.onPause();
    mGyroscopeObserver.unregister();
  }
}
