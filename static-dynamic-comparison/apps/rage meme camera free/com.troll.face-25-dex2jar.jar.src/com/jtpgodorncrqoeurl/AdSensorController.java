package com.jtpgodorncrqoeurl;

import android.content.Context;
import android.util.Log;

public class AdSensorController
  extends AdController
{
  private AdAccelListener c = new AdAccelListener(paramContext, this);
  private float d = 0.0F;
  private float e = 0.0F;
  private float f = 0.0F;
  
  public AdSensorController(AdView paramAdView, Context paramContext)
  {
    super(paramAdView, paramContext);
  }
  
  public float getHeading()
  {
    Log.d("AdOrmmaSensorController", "getHeading: " + this.c.getHeading());
    return this.c.getHeading();
  }
  
  public String getTilt()
  {
    String str = "{ x : \"" + this.d + "\", y : \"" + this.e + "\", z : \"" + this.f + "\"}";
    Log.d("AdOrmmaSensorController", "getTilt: " + str);
    return str;
  }
  
  public void onHeadingChange(float paramFloat)
  {
    String str = "window.ormmaview.fireChangeEvent({ heading: " + (int)(paramFloat * 57.29577951308232D) + "});";
    Log.d("AdOrmmaSensorController", str);
    this.b.injectJavaScript(str);
  }
  
  public void onShake()
  {
    this.b.injectJavaScript("Ormma.gotShake()");
  }
  
  public void onTilt(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.d = paramFloat1;
    this.e = paramFloat2;
    this.f = paramFloat3;
    String str = "window.ormmaview.fireChangeEvent({ tilt: " + getTilt() + "})";
    Log.d("AdOrmmaSensorController", str);
    this.b.injectJavaScript(str);
  }
  
  public void startHeadingListener()
  {
    this.c.startTrackingHeading();
  }
  
  public void startShakeListener()
  {
    this.c.startTrackingShake();
  }
  
  public void startTiltListener()
  {
    this.c.startTrackingTilt();
  }
  
  public void stopAllListeners()
  {
    this.c.stopAllListeners();
  }
  
  public void stopHeadingListener()
  {
    this.c.stopTrackingHeading();
  }
  
  public void stopShakeListener()
  {
    this.c.stopTrackingShake();
  }
  
  public void stopTiltListener()
  {
    this.c.stopTrackingTilt();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/jtpgodorncrqoeurl/AdSensorController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */