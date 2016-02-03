package com.vungle.publisher.env;

import android.content.Context;
import android.media.AudioManager;
import android.net.wifi.WifiManager;
import android.view.WindowManager;
import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class AndroidDevice$$InjectAdapter
  extends cs<AndroidDevice>
  implements cp<AndroidDevice>, Provider<AndroidDevice>
{
  private cs<AudioManager> a;
  private cs<WindowManager> b;
  private cs<Context> c;
  private cs<WifiManager> d;
  
  public AndroidDevice$$InjectAdapter()
  {
    super("com.vungle.publisher.env.AndroidDevice", "members/com.vungle.publisher.env.AndroidDevice", true, AndroidDevice.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.c = paramcy.a("android.content.Context", AndroidDevice.class, getClass().getClassLoader());
    this.d = paramcy.a("android.net.wifi.WifiManager", AndroidDevice.class, getClass().getClassLoader());
    this.a = paramcy.a("android.media.AudioManager", AndroidDevice.class, getClass().getClassLoader());
    this.b = paramcy.a("android.view.WindowManager", AndroidDevice.class, getClass().getClassLoader());
  }
  
  public final AndroidDevice get()
  {
    Object localObject = (Context)this.c.get();
    this.d.get();
    localObject = new AndroidDevice((Context)localObject);
    injectMembers((AndroidDevice)localObject);
    return (AndroidDevice)localObject;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet1.add(this.c);
    paramSet1.add(this.d);
    paramSet2.add(this.a);
    paramSet2.add(this.b);
  }
  
  public final void injectMembers(AndroidDevice paramAndroidDevice)
  {
    paramAndroidDevice.a = ((AudioManager)this.a.get());
    paramAndroidDevice.b = ((WindowManager)this.b.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/env/AndroidDevice$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */