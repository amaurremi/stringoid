package com.jtpgodorncrqoeurl;

import android.content.Context;
import android.content.IntentFilter;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.URLUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class AdDisplayController
  extends AdController
{
  private WindowManager c;
  private boolean d = false;
  private int e = -1;
  private int f = -1;
  private AdConfigurationBroadcastReceiver g;
  private float h;
  
  public AdDisplayController(AdView paramAdView, Context paramContext)
  {
    super(paramAdView, paramContext);
    paramAdView = new DisplayMetrics();
    this.c = ((WindowManager)paramContext.getSystemService("window"));
    this.c.getDefaultDisplay().getMetrics(paramAdView);
    this.h = paramAdView.density;
  }
  
  private AdController.Dimensions a(AdController.Dimensions paramDimensions)
  {
    paramDimensions.width = ((int)(paramDimensions.width * this.h));
    paramDimensions.height = ((int)(paramDimensions.height * this.h));
    paramDimensions.x = ((int)(paramDimensions.x * this.h));
    paramDimensions.y = ((int)(paramDimensions.y * this.h));
    if (paramDimensions.height < 0) {
      paramDimensions.height = this.b.getHeight();
    }
    if (paramDimensions.width < 0) {
      paramDimensions.width = this.b.getWidth();
    }
    int[] arrayOfInt = new int[2];
    this.b.getLocationInWindow(arrayOfInt);
    if (paramDimensions.x < 0) {
      paramDimensions.x = arrayOfInt[0];
    }
    if (paramDimensions.y < 0) {
      paramDimensions.y = arrayOfInt[1];
    }
    return paramDimensions;
  }
  
  public void close()
  {
    Log.d("AdOrmmaDisplayController", "close");
    this.b.close();
  }
  
  public String dimensions()
  {
    return "{ \"top\" :" + (int)(this.b.getTop() / this.h) + ",\"left\" :" + (int)(this.b.getLeft() / this.h) + ",\"bottom\" :" + (int)(this.b.getBottom() / this.h) + ",\"right\" :" + (int)(this.b.getRight() / this.h) + "}";
  }
  
  public void expand(String paramString1, String paramString2, String paramString3)
  {
    Log.d("AdOrmmaDisplayController", "expand: dimensions: " + paramString1 + " url: " + paramString2 + " properties: " + paramString3);
    try
    {
      paramString1 = (AdController.Dimensions)a(new JSONObject(paramString1), AdController.Dimensions.class);
      this.b.expand(a(paramString1), paramString2, (AdController.Properties)a(new JSONObject(paramString3), AdController.Properties.class));
      return;
    }
    catch (NumberFormatException paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    catch (NullPointerException paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    catch (IllegalAccessException paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    catch (InstantiationException paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public String getMaxSize()
  {
    if (this.d) {
      return "{ width: " + this.e + ", height: " + this.f + "}";
    }
    return getScreenSize();
  }
  
  public int getOrientation()
  {
    int j = this.c.getDefaultDisplay().getOrientation();
    int i = -1;
    switch (j)
    {
    }
    for (;;)
    {
      Log.d("AdOrmmaDisplayController", "getOrientation: " + i);
      return i;
      i = 0;
      continue;
      i = 90;
      continue;
      i = 180;
      continue;
      i = 270;
    }
  }
  
  public String getScreenSize()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    this.c.getDefaultDisplay().getMetrics(localDisplayMetrics);
    return "{ width: " + (int)(localDisplayMetrics.widthPixels / localDisplayMetrics.density) + ", height: " + (int)(localDisplayMetrics.heightPixels / localDisplayMetrics.density) + "}";
  }
  
  public String getSize()
  {
    return this.b.getSize();
  }
  
  public void hide()
  {
    Log.d("AdOrmmaDisplayController", "hide");
    this.b.hide();
  }
  
  public boolean isVisible()
  {
    return this.b.getVisibility() == 0;
  }
  
  public void logHTML(String paramString)
  {
    Log.d("AdOrmmaDisplayController", paramString);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    String str = "window.ormmaview.fireChangeEvent({ orientation: " + paramInt + "});";
    Log.d("AdOrmmaDisplayController", str);
    this.b.injectJavaScript(str);
  }
  
  public void open(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Log.d("AdOrmmaDisplayController", "open: url: " + paramString + " back: " + paramBoolean1 + " forward: " + paramBoolean2 + " refresh: " + paramBoolean3);
    if (!URLUtil.isValidUrl(paramString))
    {
      this.b.raiseError("Invalid url", "open");
      return;
    }
    this.b.open(paramString, paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  public void openMap(String paramString, boolean paramBoolean)
  {
    Log.d("AdOrmmaDisplayController", "openMap: url: " + paramString);
    this.b.openMap(paramString, paramBoolean);
  }
  
  public void playAudio(String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString2, String paramString3)
  {
    Log.d("AdOrmmaDisplayController", "playAudio: url: " + paramString1 + " autoPlay: " + paramBoolean1 + " controls: " + paramBoolean2 + " loop: " + paramBoolean3 + " position: " + paramBoolean4 + " startStyle: " + paramString2 + " stopStyle: " + paramString3);
    if (!URLUtil.isValidUrl(paramString1))
    {
      this.b.raiseError("Invalid url", "playAudio");
      return;
    }
    this.b.playAudio(paramString1, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramString2, paramString3);
  }
  
  public void playVideo(String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int[] paramArrayOfInt, String paramString2, String paramString3)
  {
    Log.d("AdOrmmaDisplayController", "playVideo: url: " + paramString1 + " audioMuted: " + paramBoolean1 + " autoPlay: " + paramBoolean2 + " controls: " + paramBoolean3 + " loop: " + paramBoolean4 + " x: " + paramArrayOfInt[0] + " y: " + paramArrayOfInt[1] + " width: " + paramArrayOfInt[2] + " height: " + paramArrayOfInt[3] + " startStyle: " + paramString2 + " stopStyle: " + paramString3);
    AdController.Dimensions localDimensions = null;
    Log.i("ODCVideoPlayer", "Video URL - " + paramString1);
    if (paramArrayOfInt[0] != -1)
    {
      localDimensions = new AdController.Dimensions();
      localDimensions.x = paramArrayOfInt[0];
      localDimensions.y = paramArrayOfInt[1];
      localDimensions.width = paramArrayOfInt[2];
      localDimensions.height = paramArrayOfInt[3];
      localDimensions = a(localDimensions);
    }
    if (!URLUtil.isValidUrl(paramString1))
    {
      this.b.raiseError("Invalid url", "playVideo");
      return;
    }
    this.b.playVideo(paramString1, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, localDimensions, paramString2, paramString3);
  }
  
  public void resize(int paramInt1, int paramInt2)
  {
    Log.d("AdOrmmaDisplayController", "resize: width: " + paramInt1 + " height: " + paramInt2);
    if (((this.f > 0) && (paramInt2 > this.f)) || ((this.e > 0) && (paramInt1 > this.e)))
    {
      this.b.raiseError("Maximum size exceeded", "resize");
      return;
    }
    this.b.resize((int)(this.h * paramInt1), (int)(this.h * paramInt2));
  }
  
  public void setMaxSize(int paramInt1, int paramInt2)
  {
    this.d = true;
    this.e = paramInt1;
    this.f = paramInt2;
  }
  
  public void show()
  {
    Log.d("AdOrmmaDisplayController", "show");
    this.b.show();
  }
  
  public void startConfigurationListener()
  {
    try
    {
      if (this.g == null) {
        this.g = new AdConfigurationBroadcastReceiver(this);
      }
      this.a.registerReceiver(this.g, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
      return;
    }
    catch (Exception localException) {}
  }
  
  public void stopAllListeners()
  {
    stopConfigurationListener();
    this.g = null;
  }
  
  public void stopConfigurationListener()
  {
    try
    {
      this.a.unregisterReceiver(this.g);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/jtpgodorncrqoeurl/AdDisplayController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */