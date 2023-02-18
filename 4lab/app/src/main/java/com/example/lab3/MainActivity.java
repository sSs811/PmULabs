package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.Image;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener
{
    private ImageView imDin;
    private TextView textView;
    private float current = 0f;
private SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init()
    {

imDin = findViewById(R.id.imDin);
textView = findViewById(R.id.textView);
sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);


    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION), SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float degree = Math.round(event.values[0]);
        textView.setText("Отклонение от севера: " + Float.toString(degree) + " градусов");
        RotateAnimation ra = new RotateAnimation(current, -degree, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        ra.setDuration(210);
        ra.setFillAfter(true);
        imDin.startAnimation(ra);
        current = -degree;

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}