package com.facebook.ads.internal;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

class AdAnalogData$AdSensorEventListener
        implements SensorEventListener {
    public void onAccuracyChanged(Sensor paramSensor, int paramInt) {
    }

    public void onSensorChanged(SensorEvent paramSensorEvent) {
        if (paramSensorEvent.sensor == AdAnalogData.access$100()) {
            AdAnalogData.access$202(paramSensorEvent.values);
        }
        for (; ; ) {
            AdAnalogData.stopUpdate(this);
            return;
            if (paramSensorEvent.sensor == AdAnalogData.access$300()) {
                AdAnalogData.access$402(paramSensorEvent.values);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/ads/internal/AdAnalogData$AdSensorEventListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */