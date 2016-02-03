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
import com.vungle.publisher.ba;
import com.vungle.publisher.bc;
import com.vungle.publisher.bd;
import com.vungle.publisher.be;
import com.vungle.publisher.br;
import com.vungle.publisher.cg.a;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import com.vungle.publisher.db;
import com.vungle.publisher.dd;
import com.vungle.publisher.di;
import com.vungle.publisher.env.AndroidDevice;
import com.vungle.publisher.env.SdkState.SessionEndListener;
import com.vungle.publisher.env.WrapperFramework;
import com.vungle.publisher.image.AssetBitmapFactory;
import com.vungle.publisher.image.BitmapFactory;
import com.vungle.publisher.net.AndroidNetwork;
import com.vungle.publisher.net.http.HttpTransaction;
import com.vungle.publisher.protocol.RequestConfigHttpRequest.Factory;
import com.vungle.publisher.protocol.RequestConfigHttpResponseHandler;
import com.vungle.publisher.protocol.RequestLocalAdHttpRequest.Factory;
import com.vungle.publisher.protocol.RequestLocalAdHttpResponseHandler;
import com.vungle.publisher.protocol.TrackInstallHttpRequest.Factory;
import com.vungle.publisher.protocol.TrackInstallHttpResponseHandler;
import java.util.Collection;
import java.util.Set;
import javax.inject.Provider;

public final class ConfigurablePublisherModule$$ModuleAdapter
  extends db<ConfigurablePublisherModule>
{
  private static final String[] h = { "members/com.vungle.publisher.env.AndroidDevice", "members/com.vungle.publisher.env.AndroidLocation", "members/com.vungle.publisher.net.AndroidNetwork", "members/com.vungle.publisher.env.AndroidPublisherApp", "members/com.vungle.publisher.ad.AdManager", "members/com.vungle.publisher.FullScreenAdActivity", "members/com.vungle.publisher.service.SessionEventHandler", "members/com.vungle.sdk.VungleAdvert", "members/com.vungle.publisher.VunglePub", "members/com.vungle.sdk.VungleIntentService", "members/com.vungle.publisher.VungleService", "members/com.vungle.publisher.net.http.DownloadHttpRequest$Creator", "members/com.vungle.publisher.net.http.DownloadHttpResponseHandler$Creator", "members/com.vungle.publisher.net.http.FireAndForgetHttpResponseHandler$Creator", "members/com.vungle.publisher.net.http.HttpTransaction$Creator", "members/com.vungle.publisher.net.http.InfiniteRetryHttpResponseHandler$Creator", "members/com.vungle.publisher.protocol.ReportAdHttpResponseHandler$Creator", "members/com.vungle.publisher.protocol.ReportLocalAdHttpRequest$Creator", "members/com.vungle.publisher.protocol.ReportStreamingAdHttpRequest$Creator", "members/com.vungle.publisher.protocol.RequestConfigHttpRequest$Creator", "members/com.vungle.publisher.protocol.RequestConfigHttpResponseHandler$Creator", "members/com.vungle.publisher.protocol.RequestLocalAdHttpRequest$Creator", "members/com.vungle.publisher.protocol.RequestLocalAdHttpResponseHandler$Creator", "members/com.vungle.publisher.protocol.RequestStreamingAdHttpRequest$Creator", "members/com.vungle.publisher.protocol.RequestStreamingAdHttpResponseHandler$Creator", "members/com.vungle.publisher.protocol.SessionEndHttpRequest$Creator", "members/com.vungle.publisher.protocol.SessionStartHttpRequest$Creator", "members/com.vungle.publisher.protocol.TrackEventHttpRequest$Creator", "members/com.vungle.publisher.protocol.TrackInstallHttpRequest$Creator", "members/com.vungle.publisher.protocol.TrackInstallHttpResponseHandler$Creator", "members/com.vungle.publisher.protocol.UnfilledAdHttpRequest$Creator" };
  private static final Class<?>[] i = new Class[0];
  private static final Class<?>[] j = new Class[0];
  
  public ConfigurablePublisherModule$$ModuleAdapter()
  {
    super(ConfigurablePublisherModule.class, h, i, j);
  }
  
  public static final class ProvideAdTempDirectoryProvidesAdapter
    extends dd<String>
    implements Provider<String>
  {
    private final ConfigurablePublisherModule c;
    private cs<Context> d;
    
    public ProvideAdTempDirectoryProvidesAdapter(ConfigurablePublisherModule paramConfigurablePublisherModule)
    {
      super(false, "com.vungle.publisher.inject.ConfigurablePublisherModule", "provideAdTempDirectory");
      this.c = paramConfigurablePublisherModule;
      setLibrary(false);
    }
    
    public final void attach(cy paramcy)
    {
      this.d = paramcy.a("android.content.Context", ConfigurablePublisherModule.class, getClass().getClassLoader());
    }
    
    public final String get()
    {
      ConfigurablePublisherModule localConfigurablePublisherModule = this.c;
      return ConfigurablePublisherModule.a((Context)this.d.get());
    }
    
    public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
    {
      paramSet1.add(this.d);
    }
  }
  
  public static final class ProvideApplicationContextProvidesAdapter
    extends dd<Context>
    implements Provider<Context>
  {
    private final ConfigurablePublisherModule c;
    
    public ProvideApplicationContextProvidesAdapter(ConfigurablePublisherModule paramConfigurablePublisherModule)
    {
      super(false, "com.vungle.publisher.inject.ConfigurablePublisherModule", "provideApplicationContext");
      this.c = paramConfigurablePublisherModule;
      setLibrary(false);
    }
    
    public final Context get()
    {
      return this.c.a;
    }
  }
  
  public static final class ProvideAudioManagerProvidesAdapter
    extends dd<AudioManager>
    implements Provider<AudioManager>
  {
    private final ConfigurablePublisherModule c;
    private cs<Context> d;
    
    public ProvideAudioManagerProvidesAdapter(ConfigurablePublisherModule paramConfigurablePublisherModule)
    {
      super(false, "com.vungle.publisher.inject.ConfigurablePublisherModule", "provideAudioManager");
      this.c = paramConfigurablePublisherModule;
      setLibrary(false);
    }
    
    public final void attach(cy paramcy)
    {
      this.d = paramcy.a("android.content.Context", ConfigurablePublisherModule.class, getClass().getClassLoader());
    }
    
    public final AudioManager get()
    {
      ConfigurablePublisherModule localConfigurablePublisherModule = this.c;
      return ConfigurablePublisherModule.b((Context)this.d.get());
    }
    
    public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
    {
      paramSet1.add(this.d);
    }
  }
  
  public static final class ProvideBitmapFactoryProvidesAdapter
    extends dd<BitmapFactory>
    implements Provider<BitmapFactory>
  {
    private final ConfigurablePublisherModule c;
    private cs<AssetBitmapFactory> d;
    
    public ProvideBitmapFactoryProvidesAdapter(ConfigurablePublisherModule paramConfigurablePublisherModule)
    {
      super(true, "com.vungle.publisher.inject.ConfigurablePublisherModule", "provideBitmapFactory");
      this.c = paramConfigurablePublisherModule;
      setLibrary(false);
    }
    
    public final void attach(cy paramcy)
    {
      this.d = paramcy.a("com.vungle.publisher.image.AssetBitmapFactory", ConfigurablePublisherModule.class, getClass().getClassLoader());
    }
    
    public final BitmapFactory get()
    {
      ConfigurablePublisherModule localConfigurablePublisherModule = this.c;
      AssetBitmapFactory localAssetBitmapFactory = (AssetBitmapFactory)this.d.get();
      if (localConfigurablePublisherModule.c == null) {
        return localAssetBitmapFactory;
      }
      return localConfigurablePublisherModule.c;
    }
    
    public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
    {
      paramSet1.add(this.d);
    }
  }
  
  public static final class ProvideConnectivityManagerProvidesAdapter
    extends dd<ConnectivityManager>
    implements Provider<ConnectivityManager>
  {
    private final ConfigurablePublisherModule c;
    private cs<Context> d;
    
    public ProvideConnectivityManagerProvidesAdapter(ConfigurablePublisherModule paramConfigurablePublisherModule)
    {
      super(false, "com.vungle.publisher.inject.ConfigurablePublisherModule", "provideConnectivityManager");
      this.c = paramConfigurablePublisherModule;
      setLibrary(false);
    }
    
    public final void attach(cy paramcy)
    {
      this.d = paramcy.a("android.content.Context", ConfigurablePublisherModule.class, getClass().getClassLoader());
    }
    
    public final ConnectivityManager get()
    {
      ConfigurablePublisherModule localConfigurablePublisherModule = this.c;
      return ConfigurablePublisherModule.c((Context)this.d.get());
    }
    
    public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
    {
      paramSet1.add(this.d);
    }
  }
  
  public static final class ProvideDeviceProvidesAdapter
    extends dd<bc>
    implements Provider<bc>
  {
    private final ConfigurablePublisherModule c;
    private cs<AndroidDevice> d;
    
    public ProvideDeviceProvidesAdapter(ConfigurablePublisherModule paramConfigurablePublisherModule)
    {
      super(true, "com.vungle.publisher.inject.ConfigurablePublisherModule", "provideDevice");
      this.c = paramConfigurablePublisherModule;
      setLibrary(false);
    }
    
    public final void attach(cy paramcy)
    {
      this.d = paramcy.a("com.vungle.publisher.env.AndroidDevice", ConfigurablePublisherModule.class, getClass().getClassLoader());
    }
    
    public final bc get()
    {
      ConfigurablePublisherModule localConfigurablePublisherModule = this.c;
      return ConfigurablePublisherModule.a((AndroidDevice)this.d.get());
    }
    
    public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
    {
      paramSet1.add(this.d);
    }
  }
  
  public static final class ProvideEventBusProvidesAdapter
    extends dd<di>
    implements Provider<di>
  {
    private final ConfigurablePublisherModule c;
    
    public ProvideEventBusProvidesAdapter(ConfigurablePublisherModule paramConfigurablePublisherModule)
    {
      super(true, "com.vungle.publisher.inject.ConfigurablePublisherModule", "provideEventBus");
      this.c = paramConfigurablePublisherModule;
      setLibrary(false);
    }
    
    public final di get()
    {
      ConfigurablePublisherModule localConfigurablePublisherModule = this.c;
      return ConfigurablePublisherModule.a();
    }
  }
  
  public static final class ProvideFullScreenAdActivityClassProvidesAdapter
    extends dd<Class>
    implements Provider<Class>
  {
    private final ConfigurablePublisherModule c;
    
    public ProvideFullScreenAdActivityClassProvidesAdapter(ConfigurablePublisherModule paramConfigurablePublisherModule)
    {
      super(false, "com.vungle.publisher.inject.ConfigurablePublisherModule", "provideFullScreenAdActivityClass");
      this.c = paramConfigurablePublisherModule;
      setLibrary(false);
    }
    
    public final Class get()
    {
      ConfigurablePublisherModule localConfigurablePublisherModule = this.c;
      if (localConfigurablePublisherModule.d == null) {
        return FullScreenAdActivity.class;
      }
      return localConfigurablePublisherModule.d;
    }
  }
  
  public static final class ProvideLocationProvidesAdapter
    extends dd<bd>
    implements Provider<bd>
  {
    private final ConfigurablePublisherModule c;
    
    public ProvideLocationProvidesAdapter(ConfigurablePublisherModule paramConfigurablePublisherModule)
    {
      super(true, "com.vungle.publisher.inject.ConfigurablePublisherModule", "provideLocation");
      this.c = paramConfigurablePublisherModule;
      setLibrary(false);
    }
    
    public final bd get()
    {
      ConfigurablePublisherModule localConfigurablePublisherModule = this.c;
      return ConfigurablePublisherModule.b();
    }
  }
  
  public static final class ProvideNetworkProvidesAdapter
    extends dd<br>
    implements Provider<br>
  {
    private final ConfigurablePublisherModule c;
    private cs<AndroidNetwork> d;
    
    public ProvideNetworkProvidesAdapter(ConfigurablePublisherModule paramConfigurablePublisherModule)
    {
      super(true, "com.vungle.publisher.inject.ConfigurablePublisherModule", "provideNetwork");
      this.c = paramConfigurablePublisherModule;
      setLibrary(false);
    }
    
    public final void attach(cy paramcy)
    {
      this.d = paramcy.a("com.vungle.publisher.net.AndroidNetwork", ConfigurablePublisherModule.class, getClass().getClassLoader());
    }
    
    public final br get()
    {
      ConfigurablePublisherModule localConfigurablePublisherModule = this.c;
      return ConfigurablePublisherModule.a((AndroidNetwork)this.d.get());
    }
    
    public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
    {
      paramSet1.add(this.d);
    }
  }
  
  public static final class ProvidePublisherAppProvidesAdapter
    extends dd<be>
    implements Provider<be>
  {
    private final ConfigurablePublisherModule c;
    private cs<Context> d;
    private cs<WrapperFramework> e;
    
    public ProvidePublisherAppProvidesAdapter(ConfigurablePublisherModule paramConfigurablePublisherModule)
    {
      super(true, "com.vungle.publisher.inject.ConfigurablePublisherModule", "providePublisherApp");
      this.c = paramConfigurablePublisherModule;
      setLibrary(false);
    }
    
    public final void attach(cy paramcy)
    {
      this.d = paramcy.a("android.content.Context", ConfigurablePublisherModule.class, getClass().getClassLoader());
      this.e = paramcy.a("com.vungle.publisher.env.WrapperFramework", ConfigurablePublisherModule.class, getClass().getClassLoader());
    }
    
    public final be get()
    {
      ConfigurablePublisherModule localConfigurablePublisherModule = this.c;
      Context localContext = (Context)this.d.get();
      WrapperFramework localWrapperFramework = (WrapperFramework)this.e.get();
      return new ba(localContext.getPackageName(), localConfigurablePublisherModule.b, localWrapperFramework);
    }
    
    public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
    {
      paramSet1.add(this.d);
      paramSet1.add(this.e);
    }
  }
  
  public static final class ProvideRequestAdHttpTransactionProvidesAdapter
    extends dd<HttpTransaction>
    implements Provider<HttpTransaction>
  {
    private final ConfigurablePublisherModule c;
    private cs<RequestLocalAdHttpRequest.Factory> d;
    private cs<RequestLocalAdHttpResponseHandler> e;
    
    public ProvideRequestAdHttpTransactionProvidesAdapter(ConfigurablePublisherModule paramConfigurablePublisherModule)
    {
      super(false, "com.vungle.publisher.inject.ConfigurablePublisherModule", "provideRequestAdHttpTransaction");
      this.c = paramConfigurablePublisherModule;
      setLibrary(false);
    }
    
    public final void attach(cy paramcy)
    {
      this.d = paramcy.a("com.vungle.publisher.protocol.RequestLocalAdHttpRequest$Factory", ConfigurablePublisherModule.class, getClass().getClassLoader());
      this.e = paramcy.a("com.vungle.publisher.protocol.RequestLocalAdHttpResponseHandler", ConfigurablePublisherModule.class, getClass().getClassLoader());
    }
    
    public final HttpTransaction get()
    {
      ConfigurablePublisherModule localConfigurablePublisherModule = this.c;
      return ConfigurablePublisherModule.a((RequestLocalAdHttpRequest.Factory)this.d.get(), (RequestLocalAdHttpResponseHandler)this.e.get());
    }
    
    public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
    {
      paramSet1.add(this.d);
      paramSet1.add(this.e);
    }
  }
  
  public static final class ProvideRequestConfigHttpTransactionProvidesAdapter
    extends dd<HttpTransaction>
    implements Provider<HttpTransaction>
  {
    private final ConfigurablePublisherModule c;
    private cs<RequestConfigHttpRequest.Factory> d;
    private cs<RequestConfigHttpResponseHandler> e;
    
    public ProvideRequestConfigHttpTransactionProvidesAdapter(ConfigurablePublisherModule paramConfigurablePublisherModule)
    {
      super(true, "com.vungle.publisher.inject.ConfigurablePublisherModule", "provideRequestConfigHttpTransaction");
      this.c = paramConfigurablePublisherModule;
      setLibrary(false);
    }
    
    public final void attach(cy paramcy)
    {
      this.d = paramcy.a("com.vungle.publisher.protocol.RequestConfigHttpRequest$Factory", ConfigurablePublisherModule.class, getClass().getClassLoader());
      this.e = paramcy.a("com.vungle.publisher.protocol.RequestConfigHttpResponseHandler", ConfigurablePublisherModule.class, getClass().getClassLoader());
    }
    
    public final HttpTransaction get()
    {
      ConfigurablePublisherModule localConfigurablePublisherModule = this.c;
      return ConfigurablePublisherModule.a((RequestConfigHttpRequest.Factory)this.d.get(), (RequestConfigHttpResponseHandler)this.e.get());
    }
    
    public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
    {
      paramSet1.add(this.d);
      paramSet1.add(this.e);
    }
  }
  
  public static final class ProvideSdkStateSharedPreferencesProvidesAdapter
    extends dd<SharedPreferences>
    implements Provider<SharedPreferences>
  {
    private final ConfigurablePublisherModule c;
    private cs<Context> d;
    
    public ProvideSdkStateSharedPreferencesProvidesAdapter(ConfigurablePublisherModule paramConfigurablePublisherModule)
    {
      super(false, "com.vungle.publisher.inject.ConfigurablePublisherModule", "provideSdkStateSharedPreferences");
      this.c = paramConfigurablePublisherModule;
      setLibrary(false);
    }
    
    public final void attach(cy paramcy)
    {
      this.d = paramcy.a("android.content.Context", ConfigurablePublisherModule.class, getClass().getClassLoader());
    }
    
    public final SharedPreferences get()
    {
      ConfigurablePublisherModule localConfigurablePublisherModule = this.c;
      return ConfigurablePublisherModule.d((Context)this.d.get());
    }
    
    public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
    {
      paramSet1.add(this.d);
    }
  }
  
  public static final class ProvideSessionEndListenersProvidesAdapter
    extends dd<Collection<cg.a>>
    implements Provider<Collection<cg.a>>
  {
    private final ConfigurablePublisherModule c;
    private cs<SdkState.SessionEndListener> d;
    
    public ProvideSessionEndListenersProvidesAdapter(ConfigurablePublisherModule paramConfigurablePublisherModule)
    {
      super(true, "com.vungle.publisher.inject.ConfigurablePublisherModule", "provideSessionEndListeners");
      this.c = paramConfigurablePublisherModule;
      setLibrary(false);
    }
    
    public final void attach(cy paramcy)
    {
      this.d = paramcy.a("com.vungle.publisher.env.SdkState$SessionEndListener", ConfigurablePublisherModule.class, getClass().getClassLoader());
    }
    
    public final Collection<cg.a> get()
    {
      ConfigurablePublisherModule localConfigurablePublisherModule = this.c;
      return ConfigurablePublisherModule.a((SdkState.SessionEndListener)this.d.get());
    }
    
    public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
    {
      paramSet1.add(this.d);
    }
  }
  
  public static final class ProvideTelephonyManagerProvidesAdapter
    extends dd<TelephonyManager>
    implements Provider<TelephonyManager>
  {
    private final ConfigurablePublisherModule c;
    private cs<Context> d;
    
    public ProvideTelephonyManagerProvidesAdapter(ConfigurablePublisherModule paramConfigurablePublisherModule)
    {
      super(false, "com.vungle.publisher.inject.ConfigurablePublisherModule", "provideTelephonyManager");
      this.c = paramConfigurablePublisherModule;
      setLibrary(false);
    }
    
    public final void attach(cy paramcy)
    {
      this.d = paramcy.a("android.content.Context", ConfigurablePublisherModule.class, getClass().getClassLoader());
    }
    
    public final TelephonyManager get()
    {
      ConfigurablePublisherModule localConfigurablePublisherModule = this.c;
      return ConfigurablePublisherModule.e((Context)this.d.get());
    }
    
    public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
    {
      paramSet1.add(this.d);
    }
  }
  
  public static final class ProvideTrackInstallHttpTransactionProvidesAdapter
    extends dd<HttpTransaction>
    implements Provider<HttpTransaction>
  {
    private final ConfigurablePublisherModule c;
    private cs<TrackInstallHttpRequest.Factory> d;
    private cs<TrackInstallHttpResponseHandler> e;
    
    public ProvideTrackInstallHttpTransactionProvidesAdapter(ConfigurablePublisherModule paramConfigurablePublisherModule)
    {
      super(false, "com.vungle.publisher.inject.ConfigurablePublisherModule", "provideTrackInstallHttpTransaction");
      this.c = paramConfigurablePublisherModule;
      setLibrary(false);
    }
    
    public final void attach(cy paramcy)
    {
      this.d = paramcy.a("com.vungle.publisher.protocol.TrackInstallHttpRequest$Factory", ConfigurablePublisherModule.class, getClass().getClassLoader());
      this.e = paramcy.a("com.vungle.publisher.protocol.TrackInstallHttpResponseHandler", ConfigurablePublisherModule.class, getClass().getClassLoader());
    }
    
    public final HttpTransaction get()
    {
      ConfigurablePublisherModule localConfigurablePublisherModule = this.c;
      return ConfigurablePublisherModule.a((TrackInstallHttpRequest.Factory)this.d.get(), (TrackInstallHttpResponseHandler)this.e.get());
    }
    
    public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
    {
      paramSet1.add(this.d);
      paramSet1.add(this.e);
    }
  }
  
  public static final class ProvideVungleBaseUrlProvidesAdapter
    extends dd<String>
    implements Provider<String>
  {
    private final ConfigurablePublisherModule c;
    
    public ProvideVungleBaseUrlProvidesAdapter(ConfigurablePublisherModule paramConfigurablePublisherModule)
    {
      super(false, "com.vungle.publisher.inject.ConfigurablePublisherModule", "provideVungleBaseUrl");
      this.c = paramConfigurablePublisherModule;
      setLibrary(false);
    }
    
    public final String get()
    {
      ConfigurablePublisherModule localConfigurablePublisherModule = this.c;
      return ConfigurablePublisherModule.c();
    }
  }
  
  public static final class ProvideVungleServiceClassProvidesAdapter
    extends dd<Class>
    implements Provider<Class>
  {
    private final ConfigurablePublisherModule c;
    
    public ProvideVungleServiceClassProvidesAdapter(ConfigurablePublisherModule paramConfigurablePublisherModule)
    {
      super(false, "com.vungle.publisher.inject.ConfigurablePublisherModule", "provideVungleServiceClass");
      this.c = paramConfigurablePublisherModule;
      setLibrary(false);
    }
    
    public final Class get()
    {
      ConfigurablePublisherModule localConfigurablePublisherModule = this.c;
      if (localConfigurablePublisherModule.e == null) {
        return VungleService.class;
      }
      return localConfigurablePublisherModule.e;
    }
  }
  
  public static final class ProvideWifiManagerProvidesAdapter
    extends dd<WifiManager>
    implements Provider<WifiManager>
  {
    private final ConfigurablePublisherModule c;
    private cs<Context> d;
    
    public ProvideWifiManagerProvidesAdapter(ConfigurablePublisherModule paramConfigurablePublisherModule)
    {
      super(false, "com.vungle.publisher.inject.ConfigurablePublisherModule", "provideWifiManager");
      this.c = paramConfigurablePublisherModule;
      setLibrary(false);
    }
    
    public final void attach(cy paramcy)
    {
      this.d = paramcy.a("android.content.Context", ConfigurablePublisherModule.class, getClass().getClassLoader());
    }
    
    public final WifiManager get()
    {
      ConfigurablePublisherModule localConfigurablePublisherModule = this.c;
      return ConfigurablePublisherModule.f((Context)this.d.get());
    }
    
    public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
    {
      paramSet1.add(this.d);
    }
  }
  
  public static final class ProvideWindowManagerProvidesAdapter
    extends dd<WindowManager>
    implements Provider<WindowManager>
  {
    private final ConfigurablePublisherModule c;
    private cs<Context> d;
    
    public ProvideWindowManagerProvidesAdapter(ConfigurablePublisherModule paramConfigurablePublisherModule)
    {
      super(false, "com.vungle.publisher.inject.ConfigurablePublisherModule", "provideWindowManager");
      this.c = paramConfigurablePublisherModule;
      setLibrary(false);
    }
    
    public final void attach(cy paramcy)
    {
      this.d = paramcy.a("android.content.Context", ConfigurablePublisherModule.class, getClass().getClassLoader());
    }
    
    public final WindowManager get()
    {
      ConfigurablePublisherModule localConfigurablePublisherModule = this.c;
      return ConfigurablePublisherModule.g((Context)this.d.get());
    }
    
    public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
    {
      paramSet1.add(this.d);
    }
  }
  
  public static final class ProvideWrapperFrameworkProvidesAdapter
    extends dd<WrapperFramework>
    implements Provider<WrapperFramework>
  {
    private final ConfigurablePublisherModule c;
    
    public ProvideWrapperFrameworkProvidesAdapter(ConfigurablePublisherModule paramConfigurablePublisherModule)
    {
      super(false, "com.vungle.publisher.inject.ConfigurablePublisherModule", "provideWrapperFramework");
      this.c = paramConfigurablePublisherModule;
      setLibrary(false);
    }
    
    public final WrapperFramework get()
    {
      return this.c.f;
    }
  }
  
  public static final class ProvideWrapperFrameworkVersionProvidesAdapter
    extends dd<String>
    implements Provider<String>
  {
    private final ConfigurablePublisherModule c;
    
    public ProvideWrapperFrameworkVersionProvidesAdapter(ConfigurablePublisherModule paramConfigurablePublisherModule)
    {
      super(false, "com.vungle.publisher.inject.ConfigurablePublisherModule", "provideWrapperFrameworkVersion");
      this.c = paramConfigurablePublisherModule;
      setLibrary(false);
    }
    
    public final String get()
    {
      return this.c.g;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/inject/ConfigurablePublisherModule$$ModuleAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */