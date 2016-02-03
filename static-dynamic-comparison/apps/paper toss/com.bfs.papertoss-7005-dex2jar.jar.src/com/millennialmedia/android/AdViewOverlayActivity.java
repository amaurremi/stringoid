package com.millennialmedia.android;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;

public class AdViewOverlayActivity
  extends MMBaseActivity
{
  private SensorEventListener accelerometerEventListener = new SensorEventListener()
  {
    private long currentTime = 0L;
    private float force = 0.0F;
    private float lastX = 0.0F;
    private float lastY = 0.0F;
    private float lastZ = 0.0F;
    private long prevShakeTime = 0L;
    private long prevTime = 0L;
    private long timeDifference = 0L;
    private float x = 0.0F;
    private float y = 0.0F;
    private float z = 0.0F;
    
    public void onAccuracyChanged(Sensor paramAnonymousSensor, int paramAnonymousInt) {}
    
    public void onSensorChanged(SensorEvent paramAnonymousSensorEvent)
    {
      this.currentTime = paramAnonymousSensorEvent.timestamp;
      this.x = paramAnonymousSensorEvent.values[0];
      this.y = paramAnonymousSensorEvent.values[1];
      this.z = paramAnonymousSensorEvent.values[2];
      this.timeDifference = (this.currentTime - this.prevTime);
      if (this.timeDifference > 500L)
      {
        AdViewOverlayActivity.this.didAccelerate(this.x, this.y, this.z);
        this.force = (Math.abs(this.x + this.y + this.z - this.lastX - this.lastY - this.lastZ) / (float)this.timeDifference);
        AdViewOverlayActivity.this.didAccelerate(this.x, this.y, this.z);
        if (this.force > 0.2F)
        {
          if (this.currentTime - this.prevShakeTime >= 1000L) {
            AdViewOverlayActivity.this.didShake(this.force);
          }
          this.prevShakeTime = this.currentTime;
        }
        this.lastX = this.x;
        this.lastY = this.y;
        this.lastZ = this.z;
        this.prevTime = this.currentTime;
      }
    }
  };
  private final int interval = 1000;
  private AdViewOverlayView mmOverlay;
  private SensorManager sensorManager;
  private OverlaySettings settings;
  private final float threshold = 0.2F;
  
  private void didAccelerate(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    MMAdViewSDK.Log.v("Accelerometer x:%fy:%fz:%f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3) });
    this.mmOverlay.injectJS("javascript:didAccelerate(" + paramFloat1 + "," + paramFloat2 + "," + paramFloat3 + ")");
  }
  
  private void didShake(float paramFloat)
  {
    MMAdViewSDK.Log.v("Phone shaken: %f", new Object[] { Float.valueOf(paramFloat) });
    this.mmOverlay.injectJS("javascript:didShake(" + paramFloat + ")");
  }
  
  private void startAccelerating()
  {
    this.sensorManager = ((SensorManager)getSystemService("sensor"));
    if (!Boolean.valueOf(this.sensorManager.registerListener(this.accelerometerEventListener, this.sensorManager.getDefaultSensor(1), 1)).booleanValue())
    {
      MMAdViewSDK.Log.w("Accelerometer not supported by this device. Unregistering listener.");
      this.sensorManager.unregisterListener(this.accelerometerEventListener, this.sensorManager.getDefaultSensor(1));
      this.accelerometerEventListener = null;
      this.sensorManager = null;
    }
  }
  
  private void stopAccelerating()
  {
    try
    {
      if ((this.sensorManager != null) && (this.accelerometerEventListener != null)) {
        this.sensorManager.unregisterListener(this.accelerometerEventListener, this.sensorManager.getDefaultSensor(1));
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void finish()
  {
    MMAdViewSDK.Event.overlayClosed(this.activity);
    super.finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    setTheme(16973840);
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    getWindow().setBackgroundDrawable(new ColorDrawable(0));
    getWindow().clearFlags(1024);
    getWindow().addFlags(2048);
    getWindow().addFlags(16777216);
    this.settings = ((OverlaySettings)getIntent().getParcelableExtra("settings"));
    if (this.settings == null) {
      this.settings = new OverlaySettings();
    }
    this.settings.log();
    if ((this.settings.orientation != null) && (this.settings.orientation.equalsIgnoreCase("landscape"))) {
      setRequestedOrientation(0);
    }
    for (;;)
    {
      paramBundle = getIntent();
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getData();
        if (paramBundle != null) {
          MMAdViewSDK.Log.v("Path: %s", new Object[] { paramBundle.getLastPathSegment() });
        }
      }
      this.mmOverlay = new AdViewOverlayView(this.activity, this.settings);
      setContentView(this.mmOverlay);
      if (getLastNonConfigurationInstance() == null) {
        this.mmOverlay.loadWebContent(getIntent().getDataString());
      }
      this.settings.state = "expanded";
      return;
      if ((this.settings.orientation != null) && (this.settings.orientation.equalsIgnoreCase("portrait"))) {
        setRequestedOrientation(1);
      } else {
        setRequestedOrientation(2);
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    MMAdViewSDK.Log.d("Overlay onDestroy");
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      if (!this.mmOverlay.goBack()) {
        this.mmOverlay.dismiss(true);
      }
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    MMAdViewSDK.Log.d("Overlay onPause");
    if (this.settings.canAccelerate) {
      stopAccelerating();
    }
    MMMedia.Audio.sharedAudio(this.activity).stop();
    setResult(0);
    this.settings.state = "hidden";
    super.onPause();
  }
  
  protected void onResume()
  {
    MMAdViewSDK.Log.d("Overlay onResume");
    if (this.settings.canAccelerate) {
      startAccelerating();
    }
    this.settings.state = "expanded";
    super.onResume();
  }
  
  public Object onRetainNonConfigurationInstance()
  {
    return this.mmOverlay.getNonConfigurationInstance();
  }
  
  protected void onStop()
  {
    super.onStop();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/millennialmedia/android/AdViewOverlayActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */