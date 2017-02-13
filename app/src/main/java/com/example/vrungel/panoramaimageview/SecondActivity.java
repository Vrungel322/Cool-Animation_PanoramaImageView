package com.example.vrungel.panoramaimageview;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
  private TextView mtvMoreText;


  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_second);
    mtvMoreText = (TextView) findViewById(R.id.tvSecond);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      mtvMoreText.setTransitionName("transitionName");
    }
  }
}
