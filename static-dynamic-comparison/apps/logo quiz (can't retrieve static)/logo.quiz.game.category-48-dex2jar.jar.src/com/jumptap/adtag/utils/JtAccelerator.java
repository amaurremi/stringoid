package com.jumptap.adtag.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import java.util.List;

public class JtAccelerator
  implements SensorEventListener
{
  private Sensor accSensor = null;
  Context context;
  boolean isAccelStarted = false;
  private long lastUpdate = -1L;
  private SensorManager sensorManager;
  int updateFrequency = -1;
  WebView webView;
  
  public JtAccelerator(Context paramContext, WebView paramWebView)
  {
    this.context = paramContext;
    this.webView = paramWebView;
    this.sensorManager = ((SensorManager)paramContext.getSystemService("sensor"));
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if ((paramSensorEvent == null) || (paramSensorEvent.sensor.getType() != 1) || (paramSensorEvent.values.length < 3)) {}
    long l;
    do
    {
      return;
      l = System.currentTimeMillis();
    } while ((this.lastUpdate != -1L) && (l - this.lastUpdate <= this.updateFrequency));
    this.lastUpdate = l;
    paramSensorEvent = paramSensorEvent.values;
    float f1 = paramSensorEvent[0];
    float f2 = paramSensorEvent[1];
    float f3 = paramSensorEvent[2];
    this.webView.loadUrl("javascript:gotAccel(" + f1 + ", " + f2 + "," + f3 + " )");
  }
  
  @JavascriptInterface
  public void start(int paramInt)
  {
    this.updateFrequency = paramInt;
    if (!this.isAccelStarted)
    {
      List localList = this.sensorManager.getSensorList(1);
      if (localList.size() > 0) {
        this.accSensor = ((Sensor)localList.get(0));
      }
      this.sensorManager.registerListener(this, this.accSensor, 1);
    }
  }
  
  @JavascriptInterface
  public void stop()
  {
    if (this.isAccelStarted) {
      this.sensorManager.unregisterListener(this);
    }
    this.isAccelStarted = false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/jumptap/adtag/utils/JtAccelerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */