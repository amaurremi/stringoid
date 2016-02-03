package com.tapjoy.mraid.controller;

import android.R.raw;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.webkit.URLUtil;
import com.tapjoy.TapjoyLog;
import com.tapjoy.mraid.util.ConfigBroadcastReceiver;
import com.tapjoy.mraid.view.MraidView;
import java.lang.reflect.Field;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class Display
  extends Abstract
{
  private static final String TAG = "MRAID Display";
  private boolean bMaxSizeSet = false;
  private Context context;
  private ConfigBroadcastReceiver mBroadCastReceiver;
  private float mDensity;
  private int mMaxHeight = -1;
  private int mMaxWidth = -1;
  private WindowManager mWindowManager;
  
  public Display(MraidView paramMraidView, Context paramContext)
  {
    super(paramMraidView, paramContext);
    this.context = paramContext;
    paramMraidView = new DisplayMetrics();
    this.mWindowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.mWindowManager.getDefaultDisplay().getMetrics(paramMraidView);
    this.mDensity = paramMraidView.density;
  }
  
  private Abstract.Dimensions getDeviceDimensions(Abstract.Dimensions paramDimensions)
  {
    paramDimensions.width = ((int)Math.ceil(this.mDensity * paramDimensions.width));
    paramDimensions.height = ((int)Math.ceil(this.mDensity * paramDimensions.height));
    paramDimensions.x = ((int)(paramDimensions.x * this.mDensity));
    paramDimensions.y = ((int)(paramDimensions.y * this.mDensity));
    if (paramDimensions.height < 0) {
      paramDimensions.height = this.mMraidView.getHeight();
    }
    if (paramDimensions.width < 0) {
      paramDimensions.width = this.mMraidView.getWidth();
    }
    int[] arrayOfInt = new int[2];
    this.mMraidView.getLocationInWindow(arrayOfInt);
    if (paramDimensions.x < 0) {
      paramDimensions.x = arrayOfInt[0];
    }
    if (paramDimensions.y < 0) {
      paramDimensions.y = (arrayOfInt[1] - 0);
    }
    return paramDimensions;
  }
  
  public void close()
  {
    TapjoyLog.d("MRAID Display", "close");
    this.mMraidView.close();
  }
  
  public String dimensions()
  {
    return "{ \"top\" :" + (int)(this.mMraidView.getTop() / this.mDensity) + "," + "\"left\" :" + (int)(this.mMraidView.getLeft() / this.mDensity) + "," + "\"bottom\" :" + (int)(this.mMraidView.getBottom() / this.mDensity) + "," + "\"right\" :" + (int)(this.mMraidView.getRight() / this.mDensity) + "}";
  }
  
  public void expand(String paramString1, String paramString2)
  {
    TapjoyLog.d("MRAID Display", "expand: properties: " + paramString2 + " url: " + paramString1);
    try
    {
      Object localObject = new JSONObject(paramString2);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("width", ((JSONObject)localObject).get("width"));
      localJSONObject.put("height", ((JSONObject)localObject).get("height"));
      localJSONObject.put("x", 0);
      localJSONObject.put("y", 0);
      localObject = (Abstract.Dimensions)getFromJSON(localJSONObject, Abstract.Dimensions.class);
      this.mMraidView.expand(getDeviceDimensions((Abstract.Dimensions)localObject), paramString1, (Abstract.Properties)getFromJSON(new JSONObject(paramString2), Abstract.Properties.class));
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
    if (this.bMaxSizeSet) {
      return "{ width: " + this.mMaxWidth + ", " + "height: " + this.mMaxHeight + "}";
    }
    return getScreenSize();
  }
  
  public int getOrientation()
  {
    int j = this.mWindowManager.getDefaultDisplay().getOrientation();
    int i = -1;
    switch (j)
    {
    }
    for (;;)
    {
      TapjoyLog.d("MRAID Display", "getOrientation: " + i);
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
    this.mWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    return "{ width: " + (int)Math.ceil(localDisplayMetrics.widthPixels / localDisplayMetrics.density) + ", " + "height: " + (int)Math.ceil(localDisplayMetrics.heightPixels / localDisplayMetrics.density) + "}";
  }
  
  public String getSize()
  {
    return this.mMraidView.getSize();
  }
  
  public void hide()
  {
    TapjoyLog.d("MRAID Display", "hide");
    this.mMraidView.hide();
  }
  
  public boolean isVisible()
  {
    return this.mMraidView.getVisibility() == 0;
  }
  
  public void logHTML(String paramString)
  {
    TapjoyLog.d("MRAID Display", paramString);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    String str = "window.mraidview.fireChangeEvent({ orientation: " + paramInt + "});";
    TapjoyLog.d("MRAID Display", str);
    this.mMraidView.injectMraidJavaScript(str);
  }
  
  public void open(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    TapjoyLog.i("MRAID Display", "open: url: " + paramString + " back: " + paramBoolean1 + " forward: " + paramBoolean2 + " refresh: " + paramBoolean3);
    if (!URLUtil.isValidUrl(paramString))
    {
      TapjoyLog.i("MRAID Display", "invalid URL");
      paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
      List localList = this.context.getPackageManager().queryIntentActivities(paramString, 0);
      if (localList.size() == 1)
      {
        this.context.startActivity(paramString);
        return;
      }
      if (localList.size() > 1)
      {
        paramString = Intent.createChooser(paramString, "Select");
        ((Activity)this.context).startActivity(paramString);
        return;
      }
      this.mMraidView.raiseError("Invalid url", "open");
      return;
    }
    this.mMraidView.open(paramString, paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  public void openMap(String paramString, boolean paramBoolean)
  {
    TapjoyLog.d("MRAID Display", "openMap: url: " + paramString);
    this.mMraidView.openMap(paramString, paramBoolean);
  }
  
  public void playAudio(String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString2, String paramString3)
  {
    TapjoyLog.d("MRAID Display", "playAudio: url: " + paramString1 + " autoPlay: " + paramBoolean1 + " controls: " + paramBoolean2 + " loop: " + paramBoolean3 + " position: " + paramBoolean4 + " startStyle: " + paramString2 + " stopStyle: " + paramString3);
    if (!URLUtil.isValidUrl(paramString1))
    {
      this.mMraidView.raiseError("Invalid url", "playAudio");
      return;
    }
    this.mMraidView.playAudio(paramString1, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramString2, paramString3);
  }
  
  public void playVideo(String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int[] paramArrayOfInt, String paramString2, String paramString3)
  {
    TapjoyLog.d("MRAID Display", "playVideo: url: " + paramString1 + " audioMuted: " + paramBoolean1 + " autoPlay: " + paramBoolean2 + " controls: " + paramBoolean3 + " loop: " + paramBoolean4 + " x: " + paramArrayOfInt[0] + " y: " + paramArrayOfInt[1] + " width: " + paramArrayOfInt[2] + " height: " + paramArrayOfInt[3] + " startStyle: " + paramString2 + " stopStyle: " + paramString3);
    paramString2 = null;
    if (paramArrayOfInt[0] != -1)
    {
      paramString2 = new Abstract.Dimensions();
      paramString2.x = paramArrayOfInt[0];
      paramString2.y = paramArrayOfInt[1];
      paramString2.width = paramArrayOfInt[2];
      paramString2.height = paramArrayOfInt[3];
      paramString2 = getDeviceDimensions(paramString2);
    }
    int i = 0;
    paramArrayOfInt = paramString1;
    if (paramString1.contains("android.resource")) {
      paramString1 = paramString1.substring(paramString1.lastIndexOf("/") + 1, paramString1.lastIndexOf("."));
    }
    try
    {
      int j = R.raw.class.getField(paramString1).getInt(null);
      i = j;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
    paramString1 = this.mContext.getPackageName();
    paramArrayOfInt = "android.resource://" + paramString1 + "/" + i;
    this.mMraidView.playVideo(paramArrayOfInt, false, true, true, false, paramString2, "fullscreen", "exit");
  }
  
  public void resize(String paramString)
  {
    int i1 = 0;
    int i2 = 0;
    int n = 0;
    int i3 = 0;
    Object localObject2 = null;
    boolean bool1 = true;
    int m = n;
    int k = i3;
    localObject1 = localObject2;
    int j = i2;
    int i = i1;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      m = n;
      k = i3;
      localObject1 = localObject2;
      j = i2;
      i = i1;
      i1 = localJSONObject.getInt("width");
      m = n;
      k = i3;
      localObject1 = localObject2;
      j = i2;
      i = i1;
      i2 = localJSONObject.getInt("height");
      m = n;
      k = i3;
      localObject1 = localObject2;
      j = i2;
      i = i1;
      n = localJSONObject.getInt("offsetX");
      m = n;
      k = i3;
      localObject1 = localObject2;
      j = i2;
      i = i1;
      i3 = localJSONObject.getInt("offsetY");
      m = n;
      k = i3;
      localObject1 = localObject2;
      j = i2;
      i = i1;
      paramString = localJSONObject.getString("customClosePosition");
      m = n;
      k = i3;
      localObject1 = paramString;
      j = i2;
      i = i1;
      boolean bool2 = localJSONObject.getBoolean("allowOffScreen");
      bool1 = bool2;
      i = i1;
      j = i2;
      k = i3;
      m = n;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = (String)localObject1;
      }
    }
    this.mMraidView.resize((int)(this.mDensity * i), (int)(this.mDensity * j), m, k, paramString, bool1);
  }
  
  public void setMaxSize(int paramInt1, int paramInt2)
  {
    TapjoyLog.i("MRAID Display", "setMaxSize: " + paramInt1 + "x" + paramInt2);
    this.bMaxSizeSet = true;
    this.mMaxWidth = paramInt1;
    this.mMaxHeight = paramInt2;
  }
  
  public void setOrientationProperties(boolean paramBoolean, String paramString)
  {
    TapjoyLog.d("MRAID Display", "setOrientationProperties: allowOrientationChange: " + Boolean.toString(paramBoolean) + " forceOrientation: " + paramString);
    this.mMraidView.setOrientationProperties(paramBoolean, paramString);
  }
  
  public void show()
  {
    TapjoyLog.d("MRAID Display", "show");
    this.mMraidView.show();
  }
  
  public void startConfigurationListener()
  {
    try
    {
      if (this.mBroadCastReceiver == null) {
        this.mBroadCastReceiver = new ConfigBroadcastReceiver(this);
      }
      this.mContext.registerReceiver(this.mBroadCastReceiver, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
      return;
    }
    catch (Exception localException) {}
  }
  
  public void stopAllListeners()
  {
    stopConfigurationListener();
    this.mBroadCastReceiver = null;
  }
  
  public void stopConfigurationListener()
  {
    try
    {
      this.mContext.unregisterReceiver(this.mBroadCastReceiver);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void useCustomClose(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.mMraidView.removeCloseImageButton();
    }
    while (paramBoolean) {
      return;
    }
    this.mMraidView.showCloseImageButton();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/tapjoy/mraid/controller/Display.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */