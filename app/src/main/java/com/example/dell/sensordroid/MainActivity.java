package com.example.dell.sensordroid;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv_acc_x , tv_acc_y , tv_acc_z ;
    TextView tv_gyro_x , tv_gyro_y , tv_gyro_z ;
    TextView tv_ori_x, tv_ori_y, tv_ori_z;

    SensorManager mSensorManager;
    Sensor acc , gyro , ori;
    SensorEventListener eventacc , eventgyro, eventori;

    String x_acc, y_acc, z_acc;
    String x_gyro, y_gyro, z_gyro;
    String x_ori, y_ori, z_ori;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_acc_x =findViewById(R.id.tv_acc_x);
        tv_acc_y =findViewById(R.id.tv_acc_y);
        tv_acc_z =findViewById(R.id.tv_acc_z);

        tv_gyro_x =findViewById(R.id.tv_gyro_x);
        tv_gyro_y =findViewById(R.id.tv_gyro_y);
        tv_gyro_z =findViewById(R.id.tv_gyro_z);

        tv_ori_x = findViewById(R.id.tv_ori_x);
        tv_ori_y = findViewById(R.id.tv_ori_y);
        tv_ori_z = findViewById(R.id.tv_ori_z);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        acc =mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        gyro=mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        ori=mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);

        eventacc=new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
               float [] values =event.values;
                String x_acc=" X: " + String.valueOf(values[0]) +" m/s2";
                String y_acc=" Y: " + String.valueOf(values[1]) +" m/s2";
                String z_acc=" Z: " + String.valueOf(values[2]) +" m/s2";

                tv_acc_x.setText(x_acc);
                tv_acc_y.setText(y_acc);
                tv_acc_z.setText(z_acc);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };

        eventgyro=new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                float [] values =event.values;
                String x_gyro=" X: " + String.valueOf(values[0]) +" m/s2";
                String y_gyro=" Y: " + String.valueOf(values[1]) +" m/s2";
                String z_gyro=" Z: " + String.valueOf(values[2]) +" m/s2";

                tv_gyro_x.setText(x_gyro);
                tv_gyro_y.setText(y_gyro);
                tv_gyro_z.setText(z_gyro);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };

        eventori=new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                float [] values =event.values;
                String x_ori=" X: " + String.valueOf(values[0]) +" m/s2";
                String y_ori=" Y: " + String.valueOf(values[1]) +" m/s2";
                String z_ori=" Z: " + String.valueOf(values[2]) +" m/s2";

                tv_ori_x.setText(x_ori);
                tv_ori_y.setText(y_ori);
                tv_ori_z.setText(z_ori);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };


        mSensorManager.registerListener(eventacc,acc,SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(eventgyro,gyro,SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(eventori,ori,SensorManager.SENSOR_DELAY_NORMAL);

    }
}

