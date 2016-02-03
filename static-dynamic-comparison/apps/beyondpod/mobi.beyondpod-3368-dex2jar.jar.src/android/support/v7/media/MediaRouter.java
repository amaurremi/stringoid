package android.support.v7.media;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.hardware.display.DisplayManagerCompat;
import android.util.Log;
import android.view.Display;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class MediaRouter
{
  public static final int AVAILABILITY_FLAG_IGNORE_DEFAULT_ROUTE = 1;
  public static final int CALLBACK_FLAG_PERFORM_ACTIVE_SCAN = 1;
  public static final int CALLBACK_FLAG_REQUEST_DISCOVERY = 4;
  public static final int CALLBACK_FLAG_UNFILTERED_EVENTS = 2;
  private static final boolean DEBUG = Log.isLoggable("MediaRouter", 3);
  private static final String TAG = "MediaRouter";
  static GlobalMediaRouter sGlobal;
  final ArrayList<CallbackRecord> mCallbackRecords = new ArrayList();
  final Context mContext;
  
  MediaRouter(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  static void checkCallingThread()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      throw new IllegalStateException("The media router service must only be accessed on the application's main thread.");
    }
  }
  
  static <T> boolean equal(T paramT1, T paramT2)
  {
    return (paramT1 == paramT2) || ((paramT1 != null) && (paramT2 != null) && (paramT1.equals(paramT2)));
  }
  
  private int findCallbackRecord(Callback paramCallback)
  {
    int j = this.mCallbackRecords.size();
    int i = 0;
    while (i < j)
    {
      if (((CallbackRecord)this.mCallbackRecords.get(i)).mCallback == paramCallback) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static MediaRouter getInstance(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("context must not be null");
    }
    checkCallingThread();
    if (sGlobal == null)
    {
      sGlobal = new GlobalMediaRouter(paramContext.getApplicationContext());
      sGlobal.start();
    }
    return sGlobal.getRouter(paramContext);
  }
  
  public void addCallback(MediaRouteSelector paramMediaRouteSelector, Callback paramCallback)
  {
    addCallback(paramMediaRouteSelector, paramCallback, 0);
  }
  
  public void addCallback(MediaRouteSelector paramMediaRouteSelector, Callback paramCallback, int paramInt)
  {
    if (paramMediaRouteSelector == null) {
      throw new IllegalArgumentException("selector must not be null");
    }
    if (paramCallback == null) {
      throw new IllegalArgumentException("callback must not be null");
    }
    checkCallingThread();
    if (DEBUG) {
      Log.d("MediaRouter", "addCallback: selector=" + paramMediaRouteSelector + ", callback=" + paramCallback + ", flags=" + Integer.toHexString(paramInt));
    }
    int i = findCallbackRecord(paramCallback);
    if (i < 0)
    {
      paramCallback = new CallbackRecord(this, paramCallback);
      this.mCallbackRecords.add(paramCallback);
    }
    for (;;)
    {
      i = 0;
      if (((paramCallback.mFlags ^ 0xFFFFFFFF) & paramInt) != 0)
      {
        paramCallback.mFlags |= paramInt;
        i = 1;
      }
      if (!paramCallback.mSelector.contains(paramMediaRouteSelector))
      {
        paramCallback.mSelector = new MediaRouteSelector.Builder(paramCallback.mSelector).addSelector(paramMediaRouteSelector).build();
        i = 1;
      }
      if (i != 0) {
        sGlobal.updateDiscoveryRequest();
      }
      return;
      paramCallback = (CallbackRecord)this.mCallbackRecords.get(i);
    }
  }
  
  public void addProvider(MediaRouteProvider paramMediaRouteProvider)
  {
    if (paramMediaRouteProvider == null) {
      throw new IllegalArgumentException("providerInstance must not be null");
    }
    checkCallingThread();
    if (DEBUG) {
      Log.d("MediaRouter", "addProvider: " + paramMediaRouteProvider);
    }
    sGlobal.addProvider(paramMediaRouteProvider);
  }
  
  public void addRemoteControlClient(Object paramObject)
  {
    if (paramObject == null) {
      throw new IllegalArgumentException("remoteControlClient must not be null");
    }
    checkCallingThread();
    if (DEBUG) {
      Log.d("MediaRouter", "addRemoteControlClient: " + paramObject);
    }
    sGlobal.addRemoteControlClient(paramObject);
  }
  
  public RouteInfo getDefaultRoute()
  {
    checkCallingThread();
    return sGlobal.getDefaultRoute();
  }
  
  public List<ProviderInfo> getProviders()
  {
    checkCallingThread();
    return sGlobal.getProviders();
  }
  
  public List<RouteInfo> getRoutes()
  {
    checkCallingThread();
    return sGlobal.getRoutes();
  }
  
  public RouteInfo getSelectedRoute()
  {
    checkCallingThread();
    return sGlobal.getSelectedRoute();
  }
  
  public boolean isRouteAvailable(MediaRouteSelector paramMediaRouteSelector, int paramInt)
  {
    if (paramMediaRouteSelector == null) {
      throw new IllegalArgumentException("selector must not be null");
    }
    checkCallingThread();
    return sGlobal.isRouteAvailable(paramMediaRouteSelector, paramInt);
  }
  
  public void removeCallback(Callback paramCallback)
  {
    if (paramCallback == null) {
      throw new IllegalArgumentException("callback must not be null");
    }
    checkCallingThread();
    if (DEBUG) {
      Log.d("MediaRouter", "removeCallback: callback=" + paramCallback);
    }
    int i = findCallbackRecord(paramCallback);
    if (i >= 0)
    {
      this.mCallbackRecords.remove(i);
      sGlobal.updateDiscoveryRequest();
    }
  }
  
  public void removeProvider(MediaRouteProvider paramMediaRouteProvider)
  {
    if (paramMediaRouteProvider == null) {
      throw new IllegalArgumentException("providerInstance must not be null");
    }
    checkCallingThread();
    if (DEBUG) {
      Log.d("MediaRouter", "removeProvider: " + paramMediaRouteProvider);
    }
    sGlobal.removeProvider(paramMediaRouteProvider);
  }
  
  public void removeRemoteControlClient(Object paramObject)
  {
    if (paramObject == null) {
      throw new IllegalArgumentException("remoteControlClient must not be null");
    }
    if (DEBUG) {
      Log.d("MediaRouter", "removeRemoteControlClient: " + paramObject);
    }
    sGlobal.removeRemoteControlClient(paramObject);
  }
  
  public void selectRoute(RouteInfo paramRouteInfo)
  {
    if (paramRouteInfo == null) {
      throw new IllegalArgumentException("route must not be null");
    }
    checkCallingThread();
    if (DEBUG) {
      Log.d("MediaRouter", "selectRoute: " + paramRouteInfo);
    }
    sGlobal.selectRoute(paramRouteInfo);
  }
  
  public RouteInfo updateSelectedRoute(MediaRouteSelector paramMediaRouteSelector)
  {
    if (paramMediaRouteSelector == null) {
      throw new IllegalArgumentException("selector must not be null");
    }
    checkCallingThread();
    if (DEBUG) {
      Log.d("MediaRouter", "updateSelectedRoute: " + paramMediaRouteSelector);
    }
    RouteInfo localRouteInfo2 = sGlobal.getSelectedRoute();
    RouteInfo localRouteInfo1 = localRouteInfo2;
    if (!localRouteInfo2.isDefault())
    {
      localRouteInfo1 = localRouteInfo2;
      if (!localRouteInfo2.matchesSelector(paramMediaRouteSelector))
      {
        localRouteInfo1 = sGlobal.getDefaultRoute();
        sGlobal.selectRoute(localRouteInfo1);
      }
    }
    return localRouteInfo1;
  }
  
  public static abstract class Callback
  {
    public void onProviderAdded(MediaRouter paramMediaRouter, MediaRouter.ProviderInfo paramProviderInfo) {}
    
    public void onProviderChanged(MediaRouter paramMediaRouter, MediaRouter.ProviderInfo paramProviderInfo) {}
    
    public void onProviderRemoved(MediaRouter paramMediaRouter, MediaRouter.ProviderInfo paramProviderInfo) {}
    
    public void onRouteAdded(MediaRouter paramMediaRouter, MediaRouter.RouteInfo paramRouteInfo) {}
    
    public void onRouteChanged(MediaRouter paramMediaRouter, MediaRouter.RouteInfo paramRouteInfo) {}
    
    public void onRoutePresentationDisplayChanged(MediaRouter paramMediaRouter, MediaRouter.RouteInfo paramRouteInfo) {}
    
    public void onRouteRemoved(MediaRouter paramMediaRouter, MediaRouter.RouteInfo paramRouteInfo) {}
    
    public void onRouteSelected(MediaRouter paramMediaRouter, MediaRouter.RouteInfo paramRouteInfo) {}
    
    public void onRouteUnselected(MediaRouter paramMediaRouter, MediaRouter.RouteInfo paramRouteInfo) {}
    
    public void onRouteVolumeChanged(MediaRouter paramMediaRouter, MediaRouter.RouteInfo paramRouteInfo) {}
  }
  
  private static final class CallbackRecord
  {
    public final MediaRouter.Callback mCallback;
    public int mFlags;
    public final MediaRouter mRouter;
    public MediaRouteSelector mSelector;
    
    public CallbackRecord(MediaRouter paramMediaRouter, MediaRouter.Callback paramCallback)
    {
      this.mRouter = paramMediaRouter;
      this.mCallback = paramCallback;
      this.mSelector = MediaRouteSelector.EMPTY;
    }
    
    public boolean filterRouteEvent(MediaRouter.RouteInfo paramRouteInfo)
    {
      return ((this.mFlags & 0x2) != 0) || (paramRouteInfo.matchesSelector(this.mSelector));
    }
  }
  
  public static abstract class ControlRequestCallback
  {
    public void onError(String paramString, Bundle paramBundle) {}
    
    public void onResult(Bundle paramBundle) {}
  }
  
  private static final class GlobalMediaRouter
    implements SystemMediaRouteProvider.SyncCallback
  {
    private final Context mApplicationContext;
    private final MediaRouter mApplicationRouter;
    private final CallbackHandler mCallbackHandler = new CallbackHandler(null);
    private MediaRouter.RouteInfo mDefaultRoute;
    private MediaRouteDiscoveryRequest mDiscoveryRequest;
    private final DisplayManagerCompat mDisplayManager;
    private final RemoteControlClientCompat.PlaybackInfo mPlaybackInfo = new RemoteControlClientCompat.PlaybackInfo();
    private final ProviderCallback mProviderCallback = new ProviderCallback(null);
    private final ArrayList<MediaRouter.ProviderInfo> mProviders = new ArrayList();
    private RegisteredMediaRouteProviderWatcher mRegisteredProviderWatcher;
    private final ArrayList<RemoteControlClientRecord> mRemoteControlClients = new ArrayList();
    private final ArrayList<WeakReference<MediaRouter>> mRouters = new ArrayList();
    private final ArrayList<MediaRouter.RouteInfo> mRoutes = new ArrayList();
    private MediaRouter.RouteInfo mSelectedRoute;
    private MediaRouteProvider.RouteController mSelectedRouteController;
    private final SystemMediaRouteProvider mSystemProvider;
    
    GlobalMediaRouter(Context paramContext)
    {
      this.mApplicationContext = paramContext;
      this.mDisplayManager = DisplayManagerCompat.getInstance(paramContext);
      this.mApplicationRouter = getRouter(paramContext);
      this.mSystemProvider = SystemMediaRouteProvider.obtain(paramContext, this);
      addProvider(this.mSystemProvider);
    }
    
    private String assignRouteUniqueId(MediaRouter.ProviderInfo paramProviderInfo, String paramString)
    {
      paramProviderInfo = paramProviderInfo.getPackageName() + ":" + paramString;
      if (findRouteByUniqueId(paramProviderInfo) < 0) {
        return paramProviderInfo;
      }
      int i = 2;
      for (;;)
      {
        paramString = String.format(Locale.US, "%s_%d", new Object[] { paramProviderInfo, Integer.valueOf(i) });
        if (findRouteByUniqueId(paramString) < 0) {
          return paramString;
        }
        i += 1;
      }
    }
    
    private MediaRouter.RouteInfo chooseFallbackRoute()
    {
      Iterator localIterator = this.mRoutes.iterator();
      while (localIterator.hasNext())
      {
        MediaRouter.RouteInfo localRouteInfo = (MediaRouter.RouteInfo)localIterator.next();
        if ((localRouteInfo != this.mDefaultRoute) && (isSystemLiveAudioOnlyRoute(localRouteInfo)) && (isRouteSelectable(localRouteInfo))) {
          return localRouteInfo;
        }
      }
      return this.mDefaultRoute;
    }
    
    private int findProviderInfo(MediaRouteProvider paramMediaRouteProvider)
    {
      int j = this.mProviders.size();
      int i = 0;
      while (i < j)
      {
        if (MediaRouter.ProviderInfo.access$500((MediaRouter.ProviderInfo)this.mProviders.get(i)) == paramMediaRouteProvider) {
          return i;
        }
        i += 1;
      }
      return -1;
    }
    
    private int findRemoteControlClientRecord(Object paramObject)
    {
      int j = this.mRemoteControlClients.size();
      int i = 0;
      while (i < j)
      {
        if (((RemoteControlClientRecord)this.mRemoteControlClients.get(i)).getRemoteControlClient() == paramObject) {
          return i;
        }
        i += 1;
      }
      return -1;
    }
    
    private int findRouteByUniqueId(String paramString)
    {
      int j = this.mRoutes.size();
      int i = 0;
      while (i < j)
      {
        if (MediaRouter.RouteInfo.access$700((MediaRouter.RouteInfo)this.mRoutes.get(i)).equals(paramString)) {
          return i;
        }
        i += 1;
      }
      return -1;
    }
    
    private boolean isRouteSelectable(MediaRouter.RouteInfo paramRouteInfo)
    {
      return (MediaRouter.RouteInfo.access$800(paramRouteInfo) != null) && (MediaRouter.RouteInfo.access$300(paramRouteInfo));
    }
    
    private boolean isSystemDefaultRoute(MediaRouter.RouteInfo paramRouteInfo)
    {
      return (paramRouteInfo.getProviderInstance() == this.mSystemProvider) && (MediaRouter.RouteInfo.access$000(paramRouteInfo).equals("DEFAULT_ROUTE"));
    }
    
    private boolean isSystemLiveAudioOnlyRoute(MediaRouter.RouteInfo paramRouteInfo)
    {
      return (paramRouteInfo.getProviderInstance() == this.mSystemProvider) && (paramRouteInfo.supportsControlCategory("android.media.intent.category.LIVE_AUDIO")) && (!paramRouteInfo.supportsControlCategory("android.media.intent.category.LIVE_VIDEO"));
    }
    
    private void setSelectedRouteInternal(MediaRouter.RouteInfo paramRouteInfo)
    {
      if (this.mSelectedRoute != paramRouteInfo)
      {
        if (this.mSelectedRoute != null)
        {
          if (MediaRouter.DEBUG) {
            Log.d("MediaRouter", "Route unselected: " + this.mSelectedRoute);
          }
          this.mCallbackHandler.post(263, this.mSelectedRoute);
          if (this.mSelectedRouteController != null)
          {
            this.mSelectedRouteController.onUnselect();
            this.mSelectedRouteController.onRelease();
            this.mSelectedRouteController = null;
          }
        }
        this.mSelectedRoute = paramRouteInfo;
        if (this.mSelectedRoute != null)
        {
          this.mSelectedRouteController = paramRouteInfo.getProviderInstance().onCreateRouteController(MediaRouter.RouteInfo.access$000(paramRouteInfo));
          if (this.mSelectedRouteController != null) {
            this.mSelectedRouteController.onSelect();
          }
          if (MediaRouter.DEBUG) {
            Log.d("MediaRouter", "Route selected: " + this.mSelectedRoute);
          }
          this.mCallbackHandler.post(262, this.mSelectedRoute);
        }
        updatePlaybackInfoFromSelectedRoute();
      }
    }
    
    private void updatePlaybackInfoFromSelectedRoute()
    {
      if (this.mSelectedRoute != null)
      {
        this.mPlaybackInfo.volume = this.mSelectedRoute.getVolume();
        this.mPlaybackInfo.volumeMax = this.mSelectedRoute.getVolumeMax();
        this.mPlaybackInfo.volumeHandling = this.mSelectedRoute.getVolumeHandling();
        this.mPlaybackInfo.playbackStream = this.mSelectedRoute.getPlaybackStream();
        this.mPlaybackInfo.playbackType = this.mSelectedRoute.getPlaybackType();
        int j = this.mRemoteControlClients.size();
        int i = 0;
        while (i < j)
        {
          ((RemoteControlClientRecord)this.mRemoteControlClients.get(i)).updatePlaybackInfo();
          i += 1;
        }
      }
    }
    
    private void updateProviderContents(MediaRouter.ProviderInfo paramProviderInfo, MediaRouteProviderDescriptor paramMediaRouteProviderDescriptor)
    {
      if (paramProviderInfo.updateDescriptor(paramMediaRouteProviderDescriptor))
      {
        int j = 0;
        boolean bool3 = false;
        boolean bool2 = false;
        boolean bool1 = bool3;
        int i = j;
        if (paramMediaRouteProviderDescriptor != null)
        {
          if (!paramMediaRouteProviderDescriptor.isValid()) {
            break label552;
          }
          paramMediaRouteProviderDescriptor = paramMediaRouteProviderDescriptor.getRoutes();
          int m = paramMediaRouteProviderDescriptor.size();
          j = 0;
          i = 0;
          bool1 = bool2;
          if (j < m)
          {
            MediaRouteDescriptor localMediaRouteDescriptor = (MediaRouteDescriptor)paramMediaRouteProviderDescriptor.get(j);
            Object localObject = localMediaRouteDescriptor.getId();
            int n = paramProviderInfo.findRouteByDescriptorId((String)localObject);
            ArrayList localArrayList;
            int k;
            if (n < 0)
            {
              localObject = new MediaRouter.RouteInfo(paramProviderInfo, (String)localObject, assignRouteUniqueId(paramProviderInfo, (String)localObject));
              localArrayList = MediaRouter.ProviderInfo.access$600(paramProviderInfo);
              k = i + 1;
              localArrayList.add(i, localObject);
              this.mRoutes.add(localObject);
              ((MediaRouter.RouteInfo)localObject).updateDescriptor(localMediaRouteDescriptor);
              if (MediaRouter.DEBUG) {
                Log.d("MediaRouter", "Route added: " + localObject);
              }
              this.mCallbackHandler.post(257, localObject);
              i = k;
              bool2 = bool1;
            }
            for (;;)
            {
              j += 1;
              bool1 = bool2;
              break;
              if (n < i)
              {
                Log.w("MediaRouter", "Ignoring route descriptor with duplicate id: " + localMediaRouteDescriptor);
                bool2 = bool1;
              }
              else
              {
                localObject = (MediaRouter.RouteInfo)MediaRouter.ProviderInfo.access$600(paramProviderInfo).get(n);
                localArrayList = MediaRouter.ProviderInfo.access$600(paramProviderInfo);
                k = i + 1;
                Collections.swap(localArrayList, n, i);
                n = ((MediaRouter.RouteInfo)localObject).updateDescriptor(localMediaRouteDescriptor);
                bool2 = bool1;
                i = k;
                if (n != 0)
                {
                  if ((n & 0x1) != 0)
                  {
                    if (MediaRouter.DEBUG) {
                      Log.d("MediaRouter", "Route changed: " + localObject);
                    }
                    this.mCallbackHandler.post(259, localObject);
                  }
                  if ((n & 0x2) != 0)
                  {
                    if (MediaRouter.DEBUG) {
                      Log.d("MediaRouter", "Route volume changed: " + localObject);
                    }
                    this.mCallbackHandler.post(260, localObject);
                  }
                  if ((n & 0x4) != 0)
                  {
                    if (MediaRouter.DEBUG) {
                      Log.d("MediaRouter", "Route presentation display changed: " + localObject);
                    }
                    this.mCallbackHandler.post(261, localObject);
                  }
                  bool2 = bool1;
                  i = k;
                  if (localObject == this.mSelectedRoute)
                  {
                    bool2 = true;
                    i = k;
                  }
                }
              }
            }
          }
        }
        for (;;)
        {
          j = MediaRouter.ProviderInfo.access$600(paramProviderInfo).size() - 1;
          while (j >= i)
          {
            paramMediaRouteProviderDescriptor = (MediaRouter.RouteInfo)MediaRouter.ProviderInfo.access$600(paramProviderInfo).get(j);
            paramMediaRouteProviderDescriptor.updateDescriptor(null);
            this.mRoutes.remove(paramMediaRouteProviderDescriptor);
            j -= 1;
          }
          label552:
          Log.w("MediaRouter", "Ignoring invalid provider descriptor: " + paramMediaRouteProviderDescriptor);
          bool1 = bool3;
          i = j;
        }
        updateSelectedRouteIfNeeded(bool1);
        j = MediaRouter.ProviderInfo.access$600(paramProviderInfo).size() - 1;
        while (j >= i)
        {
          paramMediaRouteProviderDescriptor = (MediaRouter.RouteInfo)MediaRouter.ProviderInfo.access$600(paramProviderInfo).remove(j);
          if (MediaRouter.DEBUG) {
            Log.d("MediaRouter", "Route removed: " + paramMediaRouteProviderDescriptor);
          }
          this.mCallbackHandler.post(258, paramMediaRouteProviderDescriptor);
          j -= 1;
        }
        if (MediaRouter.DEBUG) {
          Log.d("MediaRouter", "Provider changed: " + paramProviderInfo);
        }
        this.mCallbackHandler.post(515, paramProviderInfo);
      }
    }
    
    private void updateProviderDescriptor(MediaRouteProvider paramMediaRouteProvider, MediaRouteProviderDescriptor paramMediaRouteProviderDescriptor)
    {
      int i = findProviderInfo(paramMediaRouteProvider);
      if (i >= 0) {
        updateProviderContents((MediaRouter.ProviderInfo)this.mProviders.get(i), paramMediaRouteProviderDescriptor);
      }
    }
    
    private void updateSelectedRouteIfNeeded(boolean paramBoolean)
    {
      if ((this.mDefaultRoute != null) && (!isRouteSelectable(this.mDefaultRoute)))
      {
        Log.i("MediaRouter", "Clearing the default route because it is no longer selectable: " + this.mDefaultRoute);
        this.mDefaultRoute = null;
      }
      if ((this.mDefaultRoute == null) && (!this.mRoutes.isEmpty()))
      {
        Iterator localIterator = this.mRoutes.iterator();
        while (localIterator.hasNext())
        {
          MediaRouter.RouteInfo localRouteInfo = (MediaRouter.RouteInfo)localIterator.next();
          if ((isSystemDefaultRoute(localRouteInfo)) && (isRouteSelectable(localRouteInfo)))
          {
            this.mDefaultRoute = localRouteInfo;
            Log.i("MediaRouter", "Found default route: " + this.mDefaultRoute);
          }
        }
      }
      if ((this.mSelectedRoute != null) && (!isRouteSelectable(this.mSelectedRoute)))
      {
        Log.i("MediaRouter", "Unselecting the current route because it is no longer selectable: " + this.mSelectedRoute);
        setSelectedRouteInternal(null);
      }
      if (this.mSelectedRoute == null) {
        setSelectedRouteInternal(chooseFallbackRoute());
      }
      while (!paramBoolean) {
        return;
      }
      updatePlaybackInfoFromSelectedRoute();
    }
    
    public void addProvider(MediaRouteProvider paramMediaRouteProvider)
    {
      if (findProviderInfo(paramMediaRouteProvider) < 0)
      {
        MediaRouter.ProviderInfo localProviderInfo = new MediaRouter.ProviderInfo(paramMediaRouteProvider);
        this.mProviders.add(localProviderInfo);
        if (MediaRouter.DEBUG) {
          Log.d("MediaRouter", "Provider added: " + localProviderInfo);
        }
        this.mCallbackHandler.post(513, localProviderInfo);
        updateProviderContents(localProviderInfo, paramMediaRouteProvider.getDescriptor());
        paramMediaRouteProvider.setCallback(this.mProviderCallback);
        paramMediaRouteProvider.setDiscoveryRequest(this.mDiscoveryRequest);
      }
    }
    
    public void addRemoteControlClient(Object paramObject)
    {
      if (findRemoteControlClientRecord(paramObject) < 0)
      {
        paramObject = new RemoteControlClientRecord(paramObject);
        this.mRemoteControlClients.add(paramObject);
      }
    }
    
    public ContentResolver getContentResolver()
    {
      return this.mApplicationContext.getContentResolver();
    }
    
    public MediaRouter.RouteInfo getDefaultRoute()
    {
      if (this.mDefaultRoute == null) {
        throw new IllegalStateException("There is no default route.  The media router has not yet been fully initialized.");
      }
      return this.mDefaultRoute;
    }
    
    public Display getDisplay(int paramInt)
    {
      return this.mDisplayManager.getDisplay(paramInt);
    }
    
    public Context getProviderContext(String paramString)
    {
      if (paramString.equals("android")) {
        return this.mApplicationContext;
      }
      try
      {
        paramString = this.mApplicationContext.createPackageContext(paramString, 4);
        return paramString;
      }
      catch (PackageManager.NameNotFoundException paramString) {}
      return null;
    }
    
    public List<MediaRouter.ProviderInfo> getProviders()
    {
      return this.mProviders;
    }
    
    public MediaRouter getRouter(Context paramContext)
    {
      int i = this.mRouters.size();
      MediaRouter localMediaRouter;
      do
      {
        for (;;)
        {
          i -= 1;
          if (i < 0) {
            break label60;
          }
          localMediaRouter = (MediaRouter)((WeakReference)this.mRouters.get(i)).get();
          if (localMediaRouter != null) {
            break;
          }
          this.mRouters.remove(i);
        }
      } while (localMediaRouter.mContext != paramContext);
      return localMediaRouter;
      label60:
      paramContext = new MediaRouter(paramContext);
      this.mRouters.add(new WeakReference(paramContext));
      return paramContext;
    }
    
    public List<MediaRouter.RouteInfo> getRoutes()
    {
      return this.mRoutes;
    }
    
    public MediaRouter.RouteInfo getSelectedRoute()
    {
      if (this.mSelectedRoute == null) {
        throw new IllegalStateException("There is no currently selected route.  The media router has not yet been fully initialized.");
      }
      return this.mSelectedRoute;
    }
    
    public MediaRouter.RouteInfo getSystemRouteByDescriptorId(String paramString)
    {
      int i = findProviderInfo(this.mSystemProvider);
      if (i >= 0)
      {
        MediaRouter.ProviderInfo localProviderInfo = (MediaRouter.ProviderInfo)this.mProviders.get(i);
        i = localProviderInfo.findRouteByDescriptorId(paramString);
        if (i >= 0) {
          return (MediaRouter.RouteInfo)MediaRouter.ProviderInfo.access$600(localProviderInfo).get(i);
        }
      }
      return null;
    }
    
    public boolean isRouteAvailable(MediaRouteSelector paramMediaRouteSelector, int paramInt)
    {
      int j = this.mRoutes.size();
      int i = 0;
      if (i < j)
      {
        MediaRouter.RouteInfo localRouteInfo = (MediaRouter.RouteInfo)this.mRoutes.get(i);
        if (((paramInt & 0x1) != 0) && (localRouteInfo.isDefault())) {}
        while (!localRouteInfo.matchesSelector(paramMediaRouteSelector))
        {
          i += 1;
          break;
        }
        return true;
      }
      return false;
    }
    
    public void removeProvider(MediaRouteProvider paramMediaRouteProvider)
    {
      int i = findProviderInfo(paramMediaRouteProvider);
      if (i >= 0)
      {
        paramMediaRouteProvider.setCallback(null);
        paramMediaRouteProvider.setDiscoveryRequest(null);
        paramMediaRouteProvider = (MediaRouter.ProviderInfo)this.mProviders.get(i);
        updateProviderContents(paramMediaRouteProvider, null);
        if (MediaRouter.DEBUG) {
          Log.d("MediaRouter", "Provider removed: " + paramMediaRouteProvider);
        }
        this.mCallbackHandler.post(514, paramMediaRouteProvider);
        this.mProviders.remove(i);
      }
    }
    
    public void removeRemoteControlClient(Object paramObject)
    {
      int i = findRemoteControlClientRecord(paramObject);
      if (i >= 0) {
        ((RemoteControlClientRecord)this.mRemoteControlClients.remove(i)).disconnect();
      }
    }
    
    public void requestSetVolume(MediaRouter.RouteInfo paramRouteInfo, int paramInt)
    {
      if ((paramRouteInfo == this.mSelectedRoute) && (this.mSelectedRouteController != null)) {
        this.mSelectedRouteController.onSetVolume(paramInt);
      }
    }
    
    public void requestUpdateVolume(MediaRouter.RouteInfo paramRouteInfo, int paramInt)
    {
      if ((paramRouteInfo == this.mSelectedRoute) && (this.mSelectedRouteController != null)) {
        this.mSelectedRouteController.onUpdateVolume(paramInt);
      }
    }
    
    public void selectRoute(MediaRouter.RouteInfo paramRouteInfo)
    {
      if (!this.mRoutes.contains(paramRouteInfo))
      {
        Log.w("MediaRouter", "Ignoring attempt to select removed route: " + paramRouteInfo);
        return;
      }
      if (!MediaRouter.RouteInfo.access$300(paramRouteInfo))
      {
        Log.w("MediaRouter", "Ignoring attempt to select disabled route: " + paramRouteInfo);
        return;
      }
      setSelectedRouteInternal(paramRouteInfo);
    }
    
    public void sendControlRequest(MediaRouter.RouteInfo paramRouteInfo, Intent paramIntent, MediaRouter.ControlRequestCallback paramControlRequestCallback)
    {
      if ((paramRouteInfo == this.mSelectedRoute) && (this.mSelectedRouteController != null) && (this.mSelectedRouteController.onControlRequest(paramIntent, paramControlRequestCallback))) {}
      while (paramControlRequestCallback == null) {
        return;
      }
      paramControlRequestCallback.onError(null, null);
    }
    
    public void start()
    {
      this.mRegisteredProviderWatcher = new RegisteredMediaRouteProviderWatcher(this.mApplicationContext, this.mApplicationRouter);
      this.mRegisteredProviderWatcher.start();
    }
    
    public void updateDiscoveryRequest()
    {
      int k = 0;
      boolean bool1 = false;
      Object localObject = new MediaRouteSelector.Builder();
      int n;
      MediaRouter localMediaRouter;
      for (int m = this.mRouters.size();; m = n)
      {
        n = m - 1;
        if (n < 0) {
          break label169;
        }
        localMediaRouter = (MediaRouter)((WeakReference)this.mRouters.get(n)).get();
        if (localMediaRouter != null) {
          break;
        }
        this.mRouters.remove(n);
      }
      int i1 = localMediaRouter.mCallbackRecords.size();
      int j = 0;
      int i = k;
      boolean bool2 = bool1;
      for (;;)
      {
        bool1 = bool2;
        k = i;
        m = n;
        if (j >= i1) {
          break;
        }
        MediaRouter.CallbackRecord localCallbackRecord = (MediaRouter.CallbackRecord)localMediaRouter.mCallbackRecords.get(j);
        ((MediaRouteSelector.Builder)localObject).addSelector(localCallbackRecord.mSelector);
        if ((localCallbackRecord.mFlags & 0x1) != 0)
        {
          bool2 = true;
          i = 1;
        }
        if ((localCallbackRecord.mFlags & 0x4) != 0) {
          i = 1;
        }
        j += 1;
      }
      label169:
      if (k != 0)
      {
        localObject = ((MediaRouteSelector.Builder)localObject).build();
        if ((this.mDiscoveryRequest == null) || (!this.mDiscoveryRequest.getSelector().equals(localObject)) || (this.mDiscoveryRequest.isActiveScan() != bool1)) {
          break label223;
        }
      }
      label223:
      do
      {
        return;
        localObject = MediaRouteSelector.EMPTY;
        break;
        if ((!((MediaRouteSelector)localObject).isEmpty()) || (bool1)) {
          break label327;
        }
      } while (this.mDiscoveryRequest == null);
      label327:
      for (this.mDiscoveryRequest = null;; this.mDiscoveryRequest = new MediaRouteDiscoveryRequest((MediaRouteSelector)localObject, bool1))
      {
        if (MediaRouter.DEBUG) {
          Log.d("MediaRouter", "Updated discovery request: " + this.mDiscoveryRequest);
        }
        j = this.mProviders.size();
        i = 0;
        while (i < j)
        {
          MediaRouter.ProviderInfo.access$500((MediaRouter.ProviderInfo)this.mProviders.get(i)).setDiscoveryRequest(this.mDiscoveryRequest);
          i += 1;
        }
        break;
      }
    }
    
    private final class CallbackHandler
      extends Handler
    {
      public static final int MSG_PROVIDER_ADDED = 513;
      public static final int MSG_PROVIDER_CHANGED = 515;
      public static final int MSG_PROVIDER_REMOVED = 514;
      public static final int MSG_ROUTE_ADDED = 257;
      public static final int MSG_ROUTE_CHANGED = 259;
      public static final int MSG_ROUTE_PRESENTATION_DISPLAY_CHANGED = 261;
      public static final int MSG_ROUTE_REMOVED = 258;
      public static final int MSG_ROUTE_SELECTED = 262;
      public static final int MSG_ROUTE_UNSELECTED = 263;
      public static final int MSG_ROUTE_VOLUME_CHANGED = 260;
      private static final int MSG_TYPE_MASK = 65280;
      private static final int MSG_TYPE_PROVIDER = 512;
      private static final int MSG_TYPE_ROUTE = 256;
      private final ArrayList<MediaRouter.CallbackRecord> mTempCallbackRecords = new ArrayList();
      
      private CallbackHandler() {}
      
      private void invokeCallback(MediaRouter.CallbackRecord paramCallbackRecord, int paramInt, Object paramObject)
      {
        MediaRouter localMediaRouter = paramCallbackRecord.mRouter;
        MediaRouter.Callback localCallback = paramCallbackRecord.mCallback;
        switch (0xFF00 & paramInt)
        {
        default: 
        case 256: 
          do
          {
            return;
            paramObject = (MediaRouter.RouteInfo)paramObject;
          } while (!paramCallbackRecord.filterRouteEvent((MediaRouter.RouteInfo)paramObject));
          switch (paramInt)
          {
          default: 
            return;
          case 257: 
            localCallback.onRouteAdded(localMediaRouter, (MediaRouter.RouteInfo)paramObject);
            return;
          case 258: 
            localCallback.onRouteRemoved(localMediaRouter, (MediaRouter.RouteInfo)paramObject);
            return;
          case 259: 
            localCallback.onRouteChanged(localMediaRouter, (MediaRouter.RouteInfo)paramObject);
            return;
          case 260: 
            localCallback.onRouteVolumeChanged(localMediaRouter, (MediaRouter.RouteInfo)paramObject);
            return;
          case 261: 
            localCallback.onRoutePresentationDisplayChanged(localMediaRouter, (MediaRouter.RouteInfo)paramObject);
            return;
          case 262: 
            localCallback.onRouteSelected(localMediaRouter, (MediaRouter.RouteInfo)paramObject);
            return;
          }
          localCallback.onRouteUnselected(localMediaRouter, (MediaRouter.RouteInfo)paramObject);
          return;
        }
        paramCallbackRecord = (MediaRouter.ProviderInfo)paramObject;
        switch (paramInt)
        {
        default: 
          return;
        case 513: 
          localCallback.onProviderAdded(localMediaRouter, paramCallbackRecord);
          return;
        case 514: 
          localCallback.onProviderRemoved(localMediaRouter, paramCallbackRecord);
          return;
        }
        localCallback.onProviderChanged(localMediaRouter, paramCallbackRecord);
      }
      
      private void syncWithSystemProvider(int paramInt, Object paramObject)
      {
        switch (paramInt)
        {
        case 260: 
        case 261: 
        default: 
          return;
        case 257: 
          MediaRouter.GlobalMediaRouter.this.mSystemProvider.onSyncRouteAdded((MediaRouter.RouteInfo)paramObject);
          return;
        case 258: 
          MediaRouter.GlobalMediaRouter.this.mSystemProvider.onSyncRouteRemoved((MediaRouter.RouteInfo)paramObject);
          return;
        case 259: 
          MediaRouter.GlobalMediaRouter.this.mSystemProvider.onSyncRouteChanged((MediaRouter.RouteInfo)paramObject);
          return;
        }
        MediaRouter.GlobalMediaRouter.this.mSystemProvider.onSyncRouteSelected((MediaRouter.RouteInfo)paramObject);
      }
      
      public void handleMessage(Message paramMessage)
      {
        int j = paramMessage.what;
        paramMessage = paramMessage.obj;
        syncWithSystemProvider(j, paramMessage);
        for (;;)
        {
          try
          {
            i = MediaRouter.GlobalMediaRouter.this.mRouters.size();
            i -= 1;
            if (i < 0) {
              break;
            }
            MediaRouter localMediaRouter = (MediaRouter)((WeakReference)MediaRouter.GlobalMediaRouter.this.mRouters.get(i)).get();
            if (localMediaRouter == null) {
              MediaRouter.GlobalMediaRouter.this.mRouters.remove(i);
            } else {
              this.mTempCallbackRecords.addAll(localMediaRouter.mCallbackRecords);
            }
          }
          finally
          {
            this.mTempCallbackRecords.clear();
          }
        }
        int k = this.mTempCallbackRecords.size();
        int i = 0;
        while (i < k)
        {
          invokeCallback((MediaRouter.CallbackRecord)this.mTempCallbackRecords.get(i), j, paramMessage);
          i += 1;
        }
        this.mTempCallbackRecords.clear();
      }
      
      public void post(int paramInt, Object paramObject)
      {
        obtainMessage(paramInt, paramObject).sendToTarget();
      }
    }
    
    private final class ProviderCallback
      extends MediaRouteProvider.Callback
    {
      private ProviderCallback() {}
      
      public void onDescriptorChanged(MediaRouteProvider paramMediaRouteProvider, MediaRouteProviderDescriptor paramMediaRouteProviderDescriptor)
      {
        MediaRouter.GlobalMediaRouter.this.updateProviderDescriptor(paramMediaRouteProvider, paramMediaRouteProviderDescriptor);
      }
    }
    
    private final class RemoteControlClientRecord
      implements RemoteControlClientCompat.VolumeCallback
    {
      private boolean mDisconnected;
      private final RemoteControlClientCompat mRccCompat;
      
      public RemoteControlClientRecord(Object paramObject)
      {
        this.mRccCompat = RemoteControlClientCompat.obtain(MediaRouter.GlobalMediaRouter.this.mApplicationContext, paramObject);
        this.mRccCompat.setVolumeCallback(this);
        updatePlaybackInfo();
      }
      
      public void disconnect()
      {
        this.mDisconnected = true;
        this.mRccCompat.setVolumeCallback(null);
      }
      
      public Object getRemoteControlClient()
      {
        return this.mRccCompat.getRemoteControlClient();
      }
      
      public void onVolumeSetRequest(int paramInt)
      {
        if ((!this.mDisconnected) && (MediaRouter.GlobalMediaRouter.this.mSelectedRoute != null)) {
          MediaRouter.GlobalMediaRouter.this.mSelectedRoute.requestSetVolume(paramInt);
        }
      }
      
      public void onVolumeUpdateRequest(int paramInt)
      {
        if ((!this.mDisconnected) && (MediaRouter.GlobalMediaRouter.this.mSelectedRoute != null)) {
          MediaRouter.GlobalMediaRouter.this.mSelectedRoute.requestUpdateVolume(paramInt);
        }
      }
      
      public void updatePlaybackInfo()
      {
        this.mRccCompat.setPlaybackInfo(MediaRouter.GlobalMediaRouter.this.mPlaybackInfo);
      }
    }
  }
  
  public static final class ProviderInfo
  {
    private MediaRouteProviderDescriptor mDescriptor;
    private final MediaRouteProvider.ProviderMetadata mMetadata;
    private final MediaRouteProvider mProviderInstance;
    private Resources mResources;
    private boolean mResourcesNotAvailable;
    private final ArrayList<MediaRouter.RouteInfo> mRoutes = new ArrayList();
    
    ProviderInfo(MediaRouteProvider paramMediaRouteProvider)
    {
      this.mProviderInstance = paramMediaRouteProvider;
      this.mMetadata = paramMediaRouteProvider.getMetadata();
    }
    
    int findRouteByDescriptorId(String paramString)
    {
      int j = this.mRoutes.size();
      int i = 0;
      while (i < j)
      {
        if (MediaRouter.RouteInfo.access$000((MediaRouter.RouteInfo)this.mRoutes.get(i)).equals(paramString)) {
          return i;
        }
        i += 1;
      }
      return -1;
    }
    
    public String getPackageName()
    {
      return this.mMetadata.getPackageName();
    }
    
    public MediaRouteProvider getProviderInstance()
    {
      MediaRouter.checkCallingThread();
      return this.mProviderInstance;
    }
    
    Resources getResources()
    {
      String str;
      if ((this.mResources == null) && (!this.mResourcesNotAvailable))
      {
        str = getPackageName();
        Context localContext = MediaRouter.sGlobal.getProviderContext(str);
        if (localContext == null) {
          break label44;
        }
        this.mResources = localContext.getResources();
      }
      for (;;)
      {
        return this.mResources;
        label44:
        Log.w("MediaRouter", "Unable to obtain resources for route provider package: " + str);
        this.mResourcesNotAvailable = true;
      }
    }
    
    public List<MediaRouter.RouteInfo> getRoutes()
    {
      MediaRouter.checkCallingThread();
      return this.mRoutes;
    }
    
    public String toString()
    {
      return "MediaRouter.RouteProviderInfo{ packageName=" + getPackageName() + " }";
    }
    
    boolean updateDescriptor(MediaRouteProviderDescriptor paramMediaRouteProviderDescriptor)
    {
      if (this.mDescriptor != paramMediaRouteProviderDescriptor)
      {
        this.mDescriptor = paramMediaRouteProviderDescriptor;
        return true;
      }
      return false;
    }
  }
  
  public static final class RouteInfo
  {
    static final int CHANGE_GENERAL = 1;
    static final int CHANGE_PRESENTATION_DISPLAY = 4;
    static final int CHANGE_VOLUME = 2;
    public static final int PLAYBACK_TYPE_LOCAL = 0;
    public static final int PLAYBACK_TYPE_REMOTE = 1;
    public static final int PLAYBACK_VOLUME_FIXED = 0;
    public static final int PLAYBACK_VOLUME_VARIABLE = 1;
    private boolean mConnecting;
    private final ArrayList<IntentFilter> mControlFilters = new ArrayList();
    private String mDescription;
    private MediaRouteDescriptor mDescriptor;
    private final String mDescriptorId;
    private boolean mEnabled;
    private Bundle mExtras;
    private String mName;
    private int mPlaybackStream;
    private int mPlaybackType;
    private Display mPresentationDisplay;
    private int mPresentationDisplayId = -1;
    private final MediaRouter.ProviderInfo mProvider;
    private final String mUniqueId;
    private int mVolume;
    private int mVolumeHandling;
    private int mVolumeMax;
    
    RouteInfo(MediaRouter.ProviderInfo paramProviderInfo, String paramString1, String paramString2)
    {
      this.mProvider = paramProviderInfo;
      this.mDescriptorId = paramString1;
      this.mUniqueId = paramString2;
    }
    
    public List<IntentFilter> getControlFilters()
    {
      return this.mControlFilters;
    }
    
    public String getDescription()
    {
      return this.mDescription;
    }
    
    String getDescriptorId()
    {
      return this.mDescriptorId;
    }
    
    public Bundle getExtras()
    {
      return this.mExtras;
    }
    
    public String getId()
    {
      return this.mUniqueId;
    }
    
    public String getName()
    {
      return this.mName;
    }
    
    public int getPlaybackStream()
    {
      return this.mPlaybackStream;
    }
    
    public int getPlaybackType()
    {
      return this.mPlaybackType;
    }
    
    public Display getPresentationDisplay()
    {
      
      if ((this.mPresentationDisplayId >= 0) && (this.mPresentationDisplay == null)) {
        this.mPresentationDisplay = MediaRouter.sGlobal.getDisplay(this.mPresentationDisplayId);
      }
      return this.mPresentationDisplay;
    }
    
    public MediaRouter.ProviderInfo getProvider()
    {
      return this.mProvider;
    }
    
    MediaRouteProvider getProviderInstance()
    {
      return this.mProvider.getProviderInstance();
    }
    
    public int getVolume()
    {
      return this.mVolume;
    }
    
    public int getVolumeHandling()
    {
      return this.mVolumeHandling;
    }
    
    public int getVolumeMax()
    {
      return this.mVolumeMax;
    }
    
    public boolean isConnecting()
    {
      return this.mConnecting;
    }
    
    public boolean isDefault()
    {
      MediaRouter.checkCallingThread();
      return MediaRouter.sGlobal.getDefaultRoute() == this;
    }
    
    public boolean isEnabled()
    {
      return this.mEnabled;
    }
    
    public boolean isSelected()
    {
      MediaRouter.checkCallingThread();
      return MediaRouter.sGlobal.getSelectedRoute() == this;
    }
    
    public boolean matchesSelector(MediaRouteSelector paramMediaRouteSelector)
    {
      if (paramMediaRouteSelector == null) {
        throw new IllegalArgumentException("selector must not be null");
      }
      MediaRouter.checkCallingThread();
      return paramMediaRouteSelector.matchesControlFilters(this.mControlFilters);
    }
    
    public void requestSetVolume(int paramInt)
    {
      MediaRouter.checkCallingThread();
      MediaRouter.sGlobal.requestSetVolume(this, Math.min(this.mVolumeMax, Math.max(0, paramInt)));
    }
    
    public void requestUpdateVolume(int paramInt)
    {
      
      if (paramInt != 0) {
        MediaRouter.sGlobal.requestUpdateVolume(this, paramInt);
      }
    }
    
    public void select()
    {
      MediaRouter.checkCallingThread();
      MediaRouter.sGlobal.selectRoute(this);
    }
    
    public void sendControlRequest(Intent paramIntent, MediaRouter.ControlRequestCallback paramControlRequestCallback)
    {
      if (paramIntent == null) {
        throw new IllegalArgumentException("intent must not be null");
      }
      MediaRouter.checkCallingThread();
      MediaRouter.sGlobal.sendControlRequest(this, paramIntent, paramControlRequestCallback);
    }
    
    public boolean supportsControlAction(String paramString1, String paramString2)
    {
      if (paramString1 == null) {
        throw new IllegalArgumentException("category must not be null");
      }
      if (paramString2 == null) {
        throw new IllegalArgumentException("action must not be null");
      }
      MediaRouter.checkCallingThread();
      int j = this.mControlFilters.size();
      int i = 0;
      while (i < j)
      {
        IntentFilter localIntentFilter = (IntentFilter)this.mControlFilters.get(i);
        if ((localIntentFilter.hasCategory(paramString1)) && (localIntentFilter.hasAction(paramString2))) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    
    public boolean supportsControlCategory(String paramString)
    {
      if (paramString == null) {
        throw new IllegalArgumentException("category must not be null");
      }
      MediaRouter.checkCallingThread();
      int j = this.mControlFilters.size();
      int i = 0;
      while (i < j)
      {
        if (((IntentFilter)this.mControlFilters.get(i)).hasCategory(paramString)) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    
    public boolean supportsControlRequest(Intent paramIntent)
    {
      if (paramIntent == null) {
        throw new IllegalArgumentException("intent must not be null");
      }
      MediaRouter.checkCallingThread();
      ContentResolver localContentResolver = MediaRouter.sGlobal.getContentResolver();
      int j = this.mControlFilters.size();
      int i = 0;
      while (i < j)
      {
        if (((IntentFilter)this.mControlFilters.get(i)).match(localContentResolver, paramIntent, true, "MediaRouter") >= 0) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    
    public String toString()
    {
      return "MediaRouter.RouteInfo{ uniqueId=" + this.mUniqueId + ", name=" + this.mName + ", description=" + this.mDescription + ", enabled=" + this.mEnabled + ", connecting=" + this.mConnecting + ", playbackType=" + this.mPlaybackType + ", playbackStream=" + this.mPlaybackStream + ", volumeHandling=" + this.mVolumeHandling + ", volume=" + this.mVolume + ", volumeMax=" + this.mVolumeMax + ", presentationDisplayId=" + this.mPresentationDisplayId + ", extras=" + this.mExtras + ", providerPackageName=" + this.mProvider.getPackageName() + " }";
    }
    
    int updateDescriptor(MediaRouteDescriptor paramMediaRouteDescriptor)
    {
      int k = 0;
      int j = 0;
      int i = k;
      if (this.mDescriptor != paramMediaRouteDescriptor)
      {
        this.mDescriptor = paramMediaRouteDescriptor;
        i = k;
        if (paramMediaRouteDescriptor != null)
        {
          if (!MediaRouter.equal(this.mName, paramMediaRouteDescriptor.getName()))
          {
            this.mName = paramMediaRouteDescriptor.getName();
            j = 0x0 | 0x1;
          }
          i = j;
          if (!MediaRouter.equal(this.mDescription, paramMediaRouteDescriptor.getDescription()))
          {
            this.mDescription = paramMediaRouteDescriptor.getDescription();
            i = j | 0x1;
          }
          j = i;
          if (this.mEnabled != paramMediaRouteDescriptor.isEnabled())
          {
            this.mEnabled = paramMediaRouteDescriptor.isEnabled();
            j = i | 0x1;
          }
          i = j;
          if (this.mConnecting != paramMediaRouteDescriptor.isConnecting())
          {
            this.mConnecting = paramMediaRouteDescriptor.isConnecting();
            i = j | 0x1;
          }
          j = i;
          if (!this.mControlFilters.equals(paramMediaRouteDescriptor.getControlFilters()))
          {
            this.mControlFilters.clear();
            this.mControlFilters.addAll(paramMediaRouteDescriptor.getControlFilters());
            j = i | 0x1;
          }
          i = j;
          if (this.mPlaybackType != paramMediaRouteDescriptor.getPlaybackType())
          {
            this.mPlaybackType = paramMediaRouteDescriptor.getPlaybackType();
            i = j | 0x1;
          }
          j = i;
          if (this.mPlaybackStream != paramMediaRouteDescriptor.getPlaybackStream())
          {
            this.mPlaybackStream = paramMediaRouteDescriptor.getPlaybackStream();
            j = i | 0x1;
          }
          i = j;
          if (this.mVolumeHandling != paramMediaRouteDescriptor.getVolumeHandling())
          {
            this.mVolumeHandling = paramMediaRouteDescriptor.getVolumeHandling();
            i = j | 0x3;
          }
          j = i;
          if (this.mVolume != paramMediaRouteDescriptor.getVolume())
          {
            this.mVolume = paramMediaRouteDescriptor.getVolume();
            j = i | 0x3;
          }
          i = j;
          if (this.mVolumeMax != paramMediaRouteDescriptor.getVolumeMax())
          {
            this.mVolumeMax = paramMediaRouteDescriptor.getVolumeMax();
            i = j | 0x3;
          }
          j = i;
          if (this.mPresentationDisplayId != paramMediaRouteDescriptor.getPresentationDisplayId())
          {
            this.mPresentationDisplayId = paramMediaRouteDescriptor.getPresentationDisplayId();
            this.mPresentationDisplay = null;
            j = i | 0x5;
          }
          i = j;
          if (!MediaRouter.equal(this.mExtras, paramMediaRouteDescriptor.getExtras()))
          {
            this.mExtras = paramMediaRouteDescriptor.getExtras();
            i = j | 0x1;
          }
        }
      }
      return i;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/android/support/v7/media/MediaRouter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */