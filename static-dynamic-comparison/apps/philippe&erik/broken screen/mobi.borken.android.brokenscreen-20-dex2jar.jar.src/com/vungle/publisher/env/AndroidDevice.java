package com.vungle.publisher.env;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.Settings.Secure;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.vungle.publisher.bc;
import com.vungle.publisher.log.Logger;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AndroidDevice
  implements bc
{
  @Inject
  AudioManager a;
  @Inject
  WindowManager b;
  private final String c;
  private final String d;
  private String e;
  
  @Inject
  public AndroidDevice(Context paramContext)
  {
    this.c = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    this.d = Build.VERSION.RELEASE;
    try
    {
      if (Build.VERSION.SDK_INT >= 9) {
        this.e = Build.SERIAL;
      }
      return;
    }
    catch (NoSuchFieldError paramContext)
    {
      Logger.d("VungleDevice", "serial number not available");
    }
  }
  
  public final String a()
  {
    return this.c;
  }
  
  public final String b()
  {
    return this.d;
  }
  
  public final DisplayMetrics c()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    try
    {
      this.b.getDefaultDisplay().getMetrics(localDisplayMetrics);
      return localDisplayMetrics;
    }
    catch (Exception localException)
    {
      Logger.d("VungleDevice", "error getting display metrics", localException);
    }
    return localDisplayMetrics;
  }
  
  public final String d()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (Build.MANUFACTURER == null)
      {
        str = "";
        localStringBuilder = localStringBuilder.append(str).append(",");
        if (Build.MODEL != null) {
          break label53;
        }
      }
      label53:
      for (String str = "";; str = Build.MODEL)
      {
        return str;
        str = Build.MANUFACTURER;
        break;
      }
      return null;
    }
    catch (Exception localException)
    {
      Logger.d("VungleDevice", "error getting device model", localException);
    }
  }
  
  public final String e()
  {
    return this.e;
  }
  
  public final Float f()
  {
    try
    {
      float f = this.a.getStreamVolume(3) / this.a.getStreamMaxVolume(3);
      return Float.valueOf(f);
    }
    catch (Exception localException)
    {
      Logger.d("VungleDevice", "error getting volume info", localException);
    }
    return null;
  }
  
  public final boolean g()
  {
    return "mounted".equals(Environment.getExternalStorageState());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/env/AndroidDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */