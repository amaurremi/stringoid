package com.vungle.publisher.inject;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.view.WindowManager;
import com.vungle.publisher.FullScreenAdActivity;
import com.vungle.publisher.VungleService;
import com.vungle.publisher.az;
import com.vungle.publisher.bc;
import com.vungle.publisher.bd;
import com.vungle.publisher.bj;
import com.vungle.publisher.bk;
import com.vungle.publisher.bn;
import com.vungle.publisher.br;
import com.vungle.publisher.cg.a;
import com.vungle.publisher.di;
import com.vungle.publisher.env.AndroidDevice;
import com.vungle.publisher.env.SdkState.SessionEndListener;
import com.vungle.publisher.env.WrapperFramework;
import com.vungle.publisher.image.BitmapFactory;
import com.vungle.publisher.inject.annotations.AdTempDirectory;
import com.vungle.publisher.inject.annotations.RequestConfigHttpTransaction;
import com.vungle.publisher.inject.annotations.RequestLocalAdHttpTransaction;
import com.vungle.publisher.inject.annotations.SdkStateSharedPreferences;
import com.vungle.publisher.inject.annotations.TrackInstallHttpTransaction;
import com.vungle.publisher.inject.annotations.VungleBaseUrl;
import com.vungle.publisher.log.Logger;
import com.vungle.publisher.net.AndroidNetwork;
import com.vungle.publisher.net.http.HttpTransaction;
import com.vungle.publisher.protocol.RequestConfigHttpRequest.Factory;
import com.vungle.publisher.protocol.RequestConfigHttpResponseHandler;
import com.vungle.publisher.protocol.RequestLocalAdHttpRequest.Factory;
import com.vungle.publisher.protocol.RequestLocalAdHttpResponseHandler;
import com.vungle.publisher.protocol.TrackInstallHttpRequest.Factory;
import com.vungle.publisher.protocol.TrackInstallHttpResponseHandler;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Singleton;

class ConfigurablePublisherModule
  implements bn
{
  Context a;
  String b;
  BitmapFactory c;
  Class<? extends FullScreenAdActivity> d;
  Class<? extends VungleService> e;
  WrapperFramework f;
  String g;
  private boolean h;
  
  @Singleton
  static bc a(AndroidDevice paramAndroidDevice)
  {
    return paramAndroidDevice;
  }
  
  @Singleton
  static br a(AndroidNetwork paramAndroidNetwork)
  {
    return paramAndroidNetwork;
  }
  
  @Singleton
  static di a()
  {
    di.b = "VungleEvent";
    return new di();
  }
  
  @RequestConfigHttpTransaction
  @Singleton
  static HttpTransaction a(RequestConfigHttpRequest.Factory paramFactory, RequestConfigHttpResponseHandler paramRequestConfigHttpResponseHandler)
  {
    return new HttpTransaction(paramFactory.d(), paramRequestConfigHttpResponseHandler);
  }
  
  @RequestLocalAdHttpTransaction
  static HttpTransaction a(RequestLocalAdHttpRequest.Factory paramFactory, RequestLocalAdHttpResponseHandler paramRequestLocalAdHttpResponseHandler)
  {
    return new HttpTransaction(paramFactory.d(), paramRequestLocalAdHttpResponseHandler);
  }
  
  @TrackInstallHttpTransaction
  static HttpTransaction a(TrackInstallHttpRequest.Factory paramFactory, TrackInstallHttpResponseHandler paramTrackInstallHttpResponseHandler)
  {
    return new HttpTransaction(paramFactory.d(), paramTrackInstallHttpResponseHandler);
  }
  
  @AdTempDirectory
  static String a(Context paramContext)
  {
    paramContext = paramContext.getExternalFilesDir(null);
    if (paramContext == null) {
      throw new bj();
    }
    return bk.a(new Object[] { paramContext.getAbsolutePath(), ".vungle" });
  }
  
  @Singleton
  static Collection<cg.a> a(SdkState.SessionEndListener paramSessionEndListener)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramSessionEndListener);
    return localArrayList;
  }
  
  static AudioManager b(Context paramContext)
  {
    paramContext = (AudioManager)paramContext.getSystemService("audio");
    if (paramContext == null) {
      Logger.d("VungleDevice", "AudioManager not avaialble");
    }
    return paramContext;
  }
  
  @Singleton
  static bd b()
  {
    return new az();
  }
  
  public static ConnectivityManager c(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      Logger.d("VungleDevice", "ConnectivityManager not available");
    }
    return paramContext;
  }
  
  @VungleBaseUrl
  static String c()
  {
    return "http://api.vungle.com/api/v1/";
  }
  
  @SdkStateSharedPreferences
  static SharedPreferences d(Context paramContext)
  {
    return paramContext.getSharedPreferences("VUNGLE_PUB_APP_INFO", 0);
  }
  
  static TelephonyManager e(Context paramContext)
  {
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext == null) {
      Logger.d("VungleDevice", "TelephonyManager not avaialble");
    }
    return paramContext;
  }
  
  static WifiManager f(Context paramContext)
  {
    paramContext = (WifiManager)paramContext.getSystemService("wifi");
    if (paramContext == null) {
      Logger.d("VungleDevice", "WifiManager not avaialble");
    }
    return paramContext;
  }
  
  static WindowManager g(Context paramContext)
  {
    paramContext = (WindowManager)paramContext.getSystemService("window");
    if (paramContext == null) {
      Logger.d("VungleDevice", "WindowManager not available");
    }
    return paramContext;
  }
  
  public final void a(Context paramContext, String paramString)
  {
    if (this.h)
    {
      Logger.d("VungleInject", "publisher module already initialized");
      return;
    }
    Logger.d("VungleInject", "initializing publisher module");
    this.a = paramContext.getApplicationContext();
    this.b = paramString;
    this.h = true;
  }
  
  public final void a(Class<? extends FullScreenAdActivity> paramClass)
  {
    if (this.h)
    {
      Logger.d("VungleInject", "full screen ad activity class in publisher module NOT set - already initialized");
      return;
    }
    Logger.d("VungleInject", "setting full screen ad activity class in publisher module: " + this.e);
    this.d = paramClass;
  }
  
  public final void b(Class<? extends VungleService> paramClass)
  {
    if (this.h)
    {
      Logger.d("VungleInject", "service class in publisher module NOT set - already initialized");
      return;
    }
    Logger.d("VungleInject", "setting service class in publisher module: " + paramClass);
    this.e = paramClass;
  }
  
  public void setBitmapFactory(BitmapFactory paramBitmapFactory)
  {
    if (this.h)
    {
      Logger.d("VungleInject", "BitmapFactory in publisher module NOT set - already initialized");
      return;
    }
    Logger.d("VungleInject", "setting BitmapFactory in publisher module: " + paramBitmapFactory);
    this.c = paramBitmapFactory;
  }
  
  public void setWrapperFramework(WrapperFramework paramWrapperFramework)
  {
    if (this.h)
    {
      Logger.d("VungleInject", "wrapper framework in publisher module NOT set - already initialized");
      return;
    }
    Logger.d("VungleInject", "setting framework in publisher module: " + paramWrapperFramework);
    this.f = paramWrapperFramework;
  }
  
  public void setWrapperFrameworkVersion(String paramString)
  {
    if (this.h)
    {
      Logger.d("VungleInject", "wrapper framework version in publisher module NOT set - already initialized");
      return;
    }
    Logger.d("VungleInject", "setting framework in publisher module: " + paramString);
    this.g = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/inject/ConfigurablePublisherModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */