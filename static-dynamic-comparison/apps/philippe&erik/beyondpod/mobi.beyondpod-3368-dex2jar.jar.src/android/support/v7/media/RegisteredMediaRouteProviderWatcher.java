package android.support.v7.media;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class RegisteredMediaRouteProviderWatcher
{
  private final Context mContext;
  private final PackageManager mPackageManager;
  private final ArrayList<RegisteredMediaRouteProvider> mProviders = new ArrayList();
  private final MediaRouter mRouter;
  
  public RegisteredMediaRouteProviderWatcher(Context paramContext, MediaRouter paramMediaRouter)
  {
    this.mContext = paramContext;
    this.mRouter = paramMediaRouter;
    this.mPackageManager = paramContext.getPackageManager();
  }
  
  private int findProvider(String paramString1, String paramString2)
  {
    int j = this.mProviders.size();
    int i = 0;
    while (i < j)
    {
      if (((RegisteredMediaRouteProvider)this.mProviders.get(i)).hasComponentName(paramString1, paramString2)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private void scanPackages()
  {
    int i = 0;
    Object localObject1 = new Intent("android.media.MediaRouteProviderService");
    localObject1 = this.mPackageManager.queryIntentServices((Intent)localObject1, 0).iterator();
    int j;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((ResolveInfo)((Iterator)localObject1).next()).serviceInfo;
      if (localObject2 != null)
      {
        j = findProvider(((ServiceInfo)localObject2).packageName, ((ServiceInfo)localObject2).name);
        if (j < 0)
        {
          localObject2 = new RegisteredMediaRouteProvider(this.mContext, new ComponentName(((ServiceInfo)localObject2).packageName, ((ServiceInfo)localObject2).name));
          ((RegisteredMediaRouteProvider)localObject2).start();
          this.mProviders.add(i, localObject2);
          this.mRouter.addProvider((MediaRouteProvider)localObject2);
          i += 1;
        }
        else if (j >= i)
        {
          ((RegisteredMediaRouteProvider)this.mProviders.get(j)).rebindIfDisconnected();
          Collections.swap(this.mProviders, j, i);
          i += 1;
        }
      }
    }
    if (i < this.mProviders.size())
    {
      j = this.mProviders.size() - 1;
      while (j >= i)
      {
        localObject1 = (RegisteredMediaRouteProvider)this.mProviders.get(j);
        this.mRouter.removeProvider((MediaRouteProvider)localObject1);
        this.mProviders.remove(localObject1);
        ((RegisteredMediaRouteProvider)localObject1).stop();
        j -= 1;
      }
    }
  }
  
  public void start()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_CHANGED");
    this.mContext.registerReceiver(new BroadcastReceiver()
    {
      public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        RegisteredMediaRouteProviderWatcher.this.scanPackages();
      }
    }, localIntentFilter);
    scanPackages();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/android/support/v7/media/RegisteredMediaRouteProviderWatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */