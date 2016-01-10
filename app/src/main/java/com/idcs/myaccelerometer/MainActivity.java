package com.idcs.myaccelerometer;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
    SensorManager sensorManager;
    double valX, valY, valZ;

    RelativeLayout lOut1;
    TextView lblX,lblY,lblZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        lOut1 = (RelativeLayout)findViewById(R.id.lOut1);

        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            valX = event.values[0];
            valY = event.values[1];
            valZ = event.values[2];
        }

        lblX = (TextView)findViewById(R.id.lblX);
        lblY = (TextView)findViewById(R.id.lblY);
        lblZ = (TextView)findViewById(R.id.lblZ);
        lblX.setText("X: " + String.valueOf(valX));
        lblY.setText("Y: " + String.valueOf(valY));
        lblZ.setText("Z: " + String.valueOf(valZ));

        if (valZ < -8.5)
            lOut1.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        else
            lOut1.setBackgroundColor(getResources().getColor(R.color.colorWhite));
    }
}
