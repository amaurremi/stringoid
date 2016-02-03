package android.support.v7.media;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.support.v7.mediarouter.R.string;
import android.view.Display;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

abstract class SystemMediaRouteProvider
  extends MediaRouteProvider
{
  public static final String DEFAULT_ROUTE_ID = "DEFAULT_ROUTE";
  public static final String PACKAGE_NAME = "android";
  private static final String TAG = "SystemMediaRouteProvider";
  
  protected SystemMediaRouteProvider(Context paramContext)
  {
    super(paramContext, new MediaRouteProvider.ProviderMetadata("android"));
  }
  
  public static SystemMediaRouteProvider obtain(Context paramContext, SyncCallback paramSyncCallback)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return new JellybeanMr2Impl(paramContext, paramSyncCallback);
    }
    if (Build.VERSION.SDK_INT >= 17) {
      return new JellybeanMr1Impl(paramContext, paramSyncCallback);
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return new JellybeanImpl(paramContext, paramSyncCallback);
    }
    return new LegacyImpl(paramContext);
  }
  
  public void onSyncRouteAdded(MediaRouter.RouteInfo paramRouteInfo) {}
  
  public void onSyncRouteChanged(MediaRouter.RouteInfo paramRouteInfo) {}
  
  public void onSyncRouteRemoved(MediaRouter.RouteInfo paramRouteInfo) {}
  
  public void onSyncRouteSelected(MediaRouter.RouteInfo paramRouteInfo) {}
  
  static class JellybeanImpl
    extends SystemMediaRouteProvider
    implements MediaRouterJellybean.Callback, MediaRouterJellybean.VolumeCallback
  {
    private static final ArrayList<IntentFilter> LIVE_AUDIO_CONTROL_FILTERS;
    private static final ArrayList<IntentFilter> LIVE_VIDEO_CONTROL_FILTERS;
    protected boolean mActiveScan;
    protected final Object mCallbackObj;
    protected boolean mCallbackRegistered;
    private MediaRouterJellybean.GetDefaultRouteWorkaround mGetDefaultRouteWorkaround;
    protected int mRouteTypes;
    protected final Object mRouterObj;
    private MediaRouterJellybean.SelectRouteWorkaround mSelectRouteWorkaround;
    private final SystemMediaRouteProvider.SyncCallback mSyncCallback;
    protected final ArrayList<SystemRouteRecord> mSystemRouteRecords = new ArrayList();
    protected final Object mUserRouteCategoryObj;
    protected final ArrayList<UserRouteRecord> mUserRouteRecords = new ArrayList();
    protected final Object mVolumeCallbackObj;
    
    static
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addCategory("android.media.intent.category.LIVE_AUDIO");
      LIVE_AUDIO_CONTROL_FILTERS = new ArrayList();
      LIVE_AUDIO_CONTROL_FILTERS.add(localIntentFilter);
      localIntentFilter = new IntentFilter();
      localIntentFilter.addCategory("android.media.intent.category.LIVE_VIDEO");
      LIVE_VIDEO_CONTROL_FILTERS = new ArrayList();
      LIVE_VIDEO_CONTROL_FILTERS.add(localIntentFilter);
    }
    
    public JellybeanImpl(Context paramContext, SystemMediaRouteProvider.SyncCallback paramSyncCallback)
    {
      super();
      this.mSyncCallback = paramSyncCallback;
      this.mRouterObj = MediaRouterJellybean.getMediaRouter(paramContext);
      this.mCallbackObj = createCallbackObj();
      this.mVolumeCallbackObj = createVolumeCallbackObj();
      paramContext = paramContext.getResources();
      this.mUserRouteCategoryObj = MediaRouterJellybean.createRouteCategory(this.mRouterObj, paramContext.getString(R.string.mr_user_route_category_name), false);
      updateSystemRoutes();
    }
    
    private boolean addSystemRouteNoPublish(Object paramObject)
    {
      if ((getUserRouteRecord(paramObject) == null) && (findSystemRouteRecord(paramObject) < 0))
      {
        paramObject = new SystemRouteRecord(paramObject, assignRouteId(paramObject));
        updateSystemRouteDescriptor((SystemRouteRecord)paramObject);
        this.mSystemRouteRecords.add(paramObject);
        return true;
      }
      return false;
    }
    
    private String assignRouteId(Object paramObject)
    {
      if (getDefaultRoute() == paramObject)
      {
        i = 1;
        if (i == 0) {
          break label32;
        }
      }
      label32:
      for (paramObject = "DEFAULT_ROUTE";; paramObject = String.format(Locale.US, "ROUTE_%08x", new Object[] { Integer.valueOf(getRouteName(paramObject).hashCode()) }))
      {
        if (findSystemRouteRecordByDescriptorId((String)paramObject) >= 0) {
          break label62;
        }
        return (String)paramObject;
        i = 0;
        break;
      }
      label62:
      int i = 2;
      for (;;)
      {
        String str = String.format(Locale.US, "%s_%d", new Object[] { paramObject, Integer.valueOf(i) });
        if (findSystemRouteRecordByDescriptorId(str) < 0) {
          return str;
        }
        i += 1;
      }
    }
    
    private void updateSystemRoutes()
    {
      boolean bool = false;
      Iterator localIterator = MediaRouterJellybean.getRoutes(this.mRouterObj).iterator();
      while (localIterator.hasNext()) {
        bool |= addSystemRouteNoPublish(localIterator.next());
      }
      if (bool) {
        publishRoutes();
      }
    }
    
    protected Object createCallbackObj()
    {
      return MediaRouterJellybean.createCallback(this);
    }
    
    protected Object createVolumeCallbackObj()
    {
      return MediaRouterJellybean.createVolumeCallback(this);
    }
    
    protected int findSystemRouteRecord(Object paramObject)
    {
      int j = this.mSystemRouteRecords.size();
      int i = 0;
      while (i < j)
      {
        if (((SystemRouteRecord)this.mSystemRouteRecords.get(i)).mRouteObj == paramObject) {
          return i;
        }
        i += 1;
      }
      return -1;
    }
    
    protected int findSystemRouteRecordByDescriptorId(String paramString)
    {
      int j = this.mSystemRouteRecords.size();
      int i = 0;
      while (i < j)
      {
        if (((SystemRouteRecord)this.mSystemRouteRecords.get(i)).mRouteDescriptorId.equals(paramString)) {
          return i;
        }
        i += 1;
      }
      return -1;
    }
    
    protected int findUserRouteRecord(MediaRouter.RouteInfo paramRouteInfo)
    {
      int j = this.mUserRouteRecords.size();
      int i = 0;
      while (i < j)
      {
        if (((UserRouteRecord)this.mUserRouteRecords.get(i)).mRoute == paramRouteInfo) {
          return i;
        }
        i += 1;
      }
      return -1;
    }
    
    protected Object getDefaultRoute()
    {
      if (this.mGetDefaultRouteWorkaround == null) {
        this.mGetDefaultRouteWorkaround = new MediaRouterJellybean.GetDefaultRouteWorkaround();
      }
      return this.mGetDefaultRouteWorkaround.getDefaultRoute(this.mRouterObj);
    }
    
    protected String getRouteName(Object paramObject)
    {
      paramObject = MediaRouterJellybean.RouteInfo.getName(paramObject, getContext());
      if (paramObject != null) {
        return paramObject.toString();
      }
      return "";
    }
    
    protected UserRouteRecord getUserRouteRecord(Object paramObject)
    {
      paramObject = MediaRouterJellybean.RouteInfo.getTag(paramObject);
      if ((paramObject instanceof UserRouteRecord)) {
        return (UserRouteRecord)paramObject;
      }
      return null;
    }
    
    protected void onBuildSystemRouteDescriptor(SystemRouteRecord paramSystemRouteRecord, MediaRouteDescriptor.Builder paramBuilder)
    {
      int i = MediaRouterJellybean.RouteInfo.getSupportedTypes(paramSystemRouteRecord.mRouteObj);
      if ((i & 0x1) != 0) {
        paramBuilder.addControlFilters(LIVE_AUDIO_CONTROL_FILTERS);
      }
      if ((i & 0x2) != 0) {
        paramBuilder.addControlFilters(LIVE_VIDEO_CONTROL_FILTERS);
      }
      paramBuilder.setPlaybackType(MediaRouterJellybean.RouteInfo.getPlaybackType(paramSystemRouteRecord.mRouteObj));
      paramBuilder.setPlaybackStream(MediaRouterJellybean.RouteInfo.getPlaybackStream(paramSystemRouteRecord.mRouteObj));
      paramBuilder.setVolume(MediaRouterJellybean.RouteInfo.getVolume(paramSystemRouteRecord.mRouteObj));
      paramBuilder.setVolumeMax(MediaRouterJellybean.RouteInfo.getVolumeMax(paramSystemRouteRecord.mRouteObj));
      paramBuilder.setVolumeHandling(MediaRouterJellybean.RouteInfo.getVolumeHandling(paramSystemRouteRecord.mRouteObj));
    }
    
    public MediaRouteProvider.RouteController onCreateRouteController(String paramString)
    {
      int i = findSystemRouteRecordByDescriptorId(paramString);
      if (i >= 0) {
        return new SystemRouteController(((SystemRouteRecord)this.mSystemRouteRecords.get(i)).mRouteObj);
      }
      return null;
    }
    
    public void onDiscoveryRequestChanged(MediaRouteDiscoveryRequest paramMediaRouteDiscoveryRequest)
    {
      int i = 0;
      int j = 0;
      boolean bool = false;
      if (paramMediaRouteDiscoveryRequest != null)
      {
        List localList = paramMediaRouteDiscoveryRequest.getSelector().getControlCategories();
        int m = localList.size();
        int k = 0;
        i = j;
        j = k;
        if (j < m)
        {
          String str = (String)localList.get(j);
          if (str.equals("android.media.intent.category.LIVE_AUDIO")) {
            i |= 0x1;
          }
          for (;;)
          {
            j += 1;
            break;
            if (str.equals("android.media.intent.category.LIVE_VIDEO")) {
              i |= 0x2;
            } else {
              i |= 0x800000;
            }
          }
        }
        bool = paramMediaRouteDiscoveryRequest.isActiveScan();
      }
      if ((this.mRouteTypes != i) || (this.mActiveScan != bool))
      {
        this.mRouteTypes = i;
        this.mActiveScan = bool;
        updateCallback();
        updateSystemRoutes();
      }
    }
    
    public void onRouteAdded(Object paramObject)
    {
      if (addSystemRouteNoPublish(paramObject)) {
        publishRoutes();
      }
    }
    
    public void onRouteChanged(Object paramObject)
    {
      if (getUserRouteRecord(paramObject) == null)
      {
        int i = findSystemRouteRecord(paramObject);
        if (i >= 0)
        {
          updateSystemRouteDescriptor((SystemRouteRecord)this.mSystemRouteRecords.get(i));
          publishRoutes();
        }
      }
    }
    
    public void onRouteGrouped(Object paramObject1, Object paramObject2, int paramInt) {}
    
    public void onRouteRemoved(Object paramObject)
    {
      if (getUserRouteRecord(paramObject) == null)
      {
        int i = findSystemRouteRecord(paramObject);
        if (i >= 0)
        {
          this.mSystemRouteRecords.remove(i);
          publishRoutes();
        }
      }
    }
    
    public void onRouteSelected(int paramInt, Object paramObject)
    {
      if (paramObject != MediaRouterJellybean.getSelectedRoute(this.mRouterObj, 8388611)) {}
      do
      {
        do
        {
          return;
          UserRouteRecord localUserRouteRecord = getUserRouteRecord(paramObject);
          if (localUserRouteRecord != null)
          {
            localUserRouteRecord.mRoute.select();
            return;
          }
          paramInt = findSystemRouteRecord(paramObject);
        } while (paramInt < 0);
        paramObject = (SystemRouteRecord)this.mSystemRouteRecords.get(paramInt);
        paramObject = this.mSyncCallback.getSystemRouteByDescriptorId(((SystemRouteRecord)paramObject).mRouteDescriptorId);
      } while (paramObject == null);
      ((MediaRouter.RouteInfo)paramObject).select();
    }
    
    public void onRouteUngrouped(Object paramObject1, Object paramObject2) {}
    
    public void onRouteUnselected(int paramInt, Object paramObject) {}
    
    public void onRouteVolumeChanged(Object paramObject)
    {
      if (getUserRouteRecord(paramObject) == null)
      {
        int i = findSystemRouteRecord(paramObject);
        if (i >= 0)
        {
          SystemRouteRecord localSystemRouteRecord = (SystemRouteRecord)this.mSystemRouteRecords.get(i);
          i = MediaRouterJellybean.RouteInfo.getVolume(paramObject);
          if (i != localSystemRouteRecord.mRouteDescriptor.getVolume())
          {
            localSystemRouteRecord.mRouteDescriptor = new MediaRouteDescriptor.Builder(localSystemRouteRecord.mRouteDescriptor).setVolume(i).build();
            publishRoutes();
          }
        }
      }
    }
    
    public void onSyncRouteAdded(MediaRouter.RouteInfo paramRouteInfo)
    {
      if (paramRouteInfo.getProviderInstance() != this)
      {
        Object localObject = MediaRouterJellybean.createUserRoute(this.mRouterObj, this.mUserRouteCategoryObj);
        paramRouteInfo = new UserRouteRecord(paramRouteInfo, localObject);
        MediaRouterJellybean.RouteInfo.setTag(localObject, paramRouteInfo);
        MediaRouterJellybean.UserRouteInfo.setVolumeCallback(localObject, this.mVolumeCallbackObj);
        updateUserRouteProperties(paramRouteInfo);
        this.mUserRouteRecords.add(paramRouteInfo);
        MediaRouterJellybean.addUserRoute(this.mRouterObj, localObject);
      }
      int i;
      do
      {
        return;
        i = findSystemRouteRecord(MediaRouterJellybean.getSelectedRoute(this.mRouterObj, 8388611));
      } while ((i < 0) || (!((SystemRouteRecord)this.mSystemRouteRecords.get(i)).mRouteDescriptorId.equals(paramRouteInfo.getDescriptorId())));
      paramRouteInfo.select();
    }
    
    public void onSyncRouteChanged(MediaRouter.RouteInfo paramRouteInfo)
    {
      if (paramRouteInfo.getProviderInstance() != this)
      {
        int i = findUserRouteRecord(paramRouteInfo);
        if (i >= 0) {
          updateUserRouteProperties((UserRouteRecord)this.mUserRouteRecords.get(i));
        }
      }
    }
    
    public void onSyncRouteRemoved(MediaRouter.RouteInfo paramRouteInfo)
    {
      if (paramRouteInfo.getProviderInstance() != this)
      {
        int i = findUserRouteRecord(paramRouteInfo);
        if (i >= 0)
        {
          paramRouteInfo = (UserRouteRecord)this.mUserRouteRecords.remove(i);
          MediaRouterJellybean.RouteInfo.setTag(paramRouteInfo.mRouteObj, null);
          MediaRouterJellybean.UserRouteInfo.setVolumeCallback(paramRouteInfo.mRouteObj, null);
          MediaRouterJellybean.removeUserRoute(this.mRouterObj, paramRouteInfo.mRouteObj);
        }
      }
    }
    
    public void onSyncRouteSelected(MediaRouter.RouteInfo paramRouteInfo)
    {
      if (!paramRouteInfo.isSelected()) {}
      int i;
      do
      {
        do
        {
          return;
          if (paramRouteInfo.getProviderInstance() == this) {
            break;
          }
          i = findUserRouteRecord(paramRouteInfo);
        } while (i < 0);
        selectRoute(((UserRouteRecord)this.mUserRouteRecords.get(i)).mRouteObj);
        return;
        i = findSystemRouteRecordByDescriptorId(paramRouteInfo.getDescriptorId());
      } while (i < 0);
      selectRoute(((SystemRouteRecord)this.mSystemRouteRecords.get(i)).mRouteObj);
    }
    
    public void onVolumeSetRequest(Object paramObject, int paramInt)
    {
      paramObject = getUserRouteRecord(paramObject);
      if (paramObject != null) {
        ((UserRouteRecord)paramObject).mRoute.requestSetVolume(paramInt);
      }
    }
    
    public void onVolumeUpdateRequest(Object paramObject, int paramInt)
    {
      paramObject = getUserRouteRecord(paramObject);
      if (paramObject != null) {
        ((UserRouteRecord)paramObject).mRoute.requestUpdateVolume(paramInt);
      }
    }
    
    protected void publishRoutes()
    {
      MediaRouteProviderDescriptor.Builder localBuilder = new MediaRouteProviderDescriptor.Builder();
      int j = this.mSystemRouteRecords.size();
      int i = 0;
      while (i < j)
      {
        localBuilder.addRoute(((SystemRouteRecord)this.mSystemRouteRecords.get(i)).mRouteDescriptor);
        i += 1;
      }
      setDescriptor(localBuilder.build());
    }
    
    protected void selectRoute(Object paramObject)
    {
      if (this.mSelectRouteWorkaround == null) {
        this.mSelectRouteWorkaround = new MediaRouterJellybean.SelectRouteWorkaround();
      }
      this.mSelectRouteWorkaround.selectRoute(this.mRouterObj, 8388611, paramObject);
    }
    
    protected void updateCallback()
    {
      if (this.mCallbackRegistered)
      {
        this.mCallbackRegistered = false;
        MediaRouterJellybean.removeCallback(this.mRouterObj, this.mCallbackObj);
      }
      if (this.mRouteTypes != 0)
      {
        this.mCallbackRegistered = true;
        MediaRouterJellybean.addCallback(this.mRouterObj, this.mRouteTypes, this.mCallbackObj);
      }
    }
    
    protected void updateSystemRouteDescriptor(SystemRouteRecord paramSystemRouteRecord)
    {
      MediaRouteDescriptor.Builder localBuilder = new MediaRouteDescriptor.Builder(paramSystemRouteRecord.mRouteDescriptorId, getRouteName(paramSystemRouteRecord.mRouteObj));
      onBuildSystemRouteDescriptor(paramSystemRouteRecord, localBuilder);
      paramSystemRouteRecord.mRouteDescriptor = localBuilder.build();
    }
    
    protected void updateUserRouteProperties(UserRouteRecord paramUserRouteRecord)
    {
      MediaRouterJellybean.UserRouteInfo.setName(paramUserRouteRecord.mRouteObj, paramUserRouteRecord.mRoute.getName());
      MediaRouterJellybean.UserRouteInfo.setPlaybackType(paramUserRouteRecord.mRouteObj, paramUserRouteRecord.mRoute.getPlaybackType());
      MediaRouterJellybean.UserRouteInfo.setPlaybackStream(paramUserRouteRecord.mRouteObj, paramUserRouteRecord.mRoute.getPlaybackStream());
      MediaRouterJellybean.UserRouteInfo.setVolume(paramUserRouteRecord.mRouteObj, paramUserRouteRecord.mRoute.getVolume());
      MediaRouterJellybean.UserRouteInfo.setVolumeMax(paramUserRouteRecord.mRouteObj, paramUserRouteRecord.mRoute.getVolumeMax());
      MediaRouterJellybean.UserRouteInfo.setVolumeHandling(paramUserRouteRecord.mRouteObj, paramUserRouteRecord.mRoute.getVolumeHandling());
    }
    
    protected final class SystemRouteController
      extends MediaRouteProvider.RouteController
    {
      private final Object mRouteObj;
      
      public SystemRouteController(Object paramObject)
      {
        this.mRouteObj = paramObject;
      }
      
      public void onSetVolume(int paramInt)
      {
        MediaRouterJellybean.RouteInfo.requestSetVolume(this.mRouteObj, paramInt);
      }
      
      public void onUpdateVolume(int paramInt)
      {
        MediaRouterJellybean.RouteInfo.requestUpdateVolume(this.mRouteObj, paramInt);
      }
    }
    
    protected static final class SystemRouteRecord
    {
      public MediaRouteDescriptor mRouteDescriptor;
      public final String mRouteDescriptorId;
      public final Object mRouteObj;
      
      public SystemRouteRecord(Object paramObject, String paramString)
      {
        this.mRouteObj = paramObject;
        this.mRouteDescriptorId = paramString;
      }
    }
    
    protected static final class UserRouteRecord
    {
      public final MediaRouter.RouteInfo mRoute;
      public final Object mRouteObj;
      
      public UserRouteRecord(MediaRouter.RouteInfo paramRouteInfo, Object paramObject)
      {
        this.mRoute = paramRouteInfo;
        this.mRouteObj = paramObject;
      }
    }
  }
  
  private static class JellybeanMr1Impl
    extends SystemMediaRouteProvider.JellybeanImpl
    implements MediaRouterJellybeanMr1.Callback
  {
    private MediaRouterJellybeanMr1.ActiveScanWorkaround mActiveScanWorkaround;
    private MediaRouterJellybeanMr1.IsConnectingWorkaround mIsConnectingWorkaround;
    
    public JellybeanMr1Impl(Context paramContext, SystemMediaRouteProvider.SyncCallback paramSyncCallback)
    {
      super(paramSyncCallback);
    }
    
    protected Object createCallbackObj()
    {
      return MediaRouterJellybeanMr1.createCallback(this);
    }
    
    protected boolean isConnecting(SystemMediaRouteProvider.JellybeanImpl.SystemRouteRecord paramSystemRouteRecord)
    {
      if (this.mIsConnectingWorkaround == null) {
        this.mIsConnectingWorkaround = new MediaRouterJellybeanMr1.IsConnectingWorkaround();
      }
      return this.mIsConnectingWorkaround.isConnecting(paramSystemRouteRecord.mRouteObj);
    }
    
    protected void onBuildSystemRouteDescriptor(SystemMediaRouteProvider.JellybeanImpl.SystemRouteRecord paramSystemRouteRecord, MediaRouteDescriptor.Builder paramBuilder)
    {
      super.onBuildSystemRouteDescriptor(paramSystemRouteRecord, paramBuilder);
      if (!MediaRouterJellybeanMr1.RouteInfo.isEnabled(paramSystemRouteRecord.mRouteObj)) {
        paramBuilder.setEnabled(false);
      }
      if (isConnecting(paramSystemRouteRecord)) {
        paramBuilder.setConnecting(true);
      }
      paramSystemRouteRecord = MediaRouterJellybeanMr1.RouteInfo.getPresentationDisplay(paramSystemRouteRecord.mRouteObj);
      if (paramSystemRouteRecord != null) {
        paramBuilder.setPresentationDisplayId(paramSystemRouteRecord.getDisplayId());
      }
    }
    
    public void onRoutePresentationDisplayChanged(Object paramObject)
    {
      int i = findSystemRouteRecord(paramObject);
      SystemMediaRouteProvider.JellybeanImpl.SystemRouteRecord localSystemRouteRecord;
      if (i >= 0)
      {
        localSystemRouteRecord = (SystemMediaRouteProvider.JellybeanImpl.SystemRouteRecord)this.mSystemRouteRecords.get(i);
        paramObject = MediaRouterJellybeanMr1.RouteInfo.getPresentationDisplay(paramObject);
        if (paramObject == null) {
          break label74;
        }
      }
      label74:
      for (i = ((Display)paramObject).getDisplayId();; i = -1)
      {
        if (i != localSystemRouteRecord.mRouteDescriptor.getPresentationDisplayId())
        {
          localSystemRouteRecord.mRouteDescriptor = new MediaRouteDescriptor.Builder(localSystemRouteRecord.mRouteDescriptor).setPresentationDisplayId(i).build();
          publishRoutes();
        }
        return;
      }
    }
    
    protected void updateCallback()
    {
      super.updateCallback();
      if (this.mActiveScanWorkaround == null) {
        this.mActiveScanWorkaround = new MediaRouterJellybeanMr1.ActiveScanWorkaround(getContext(), getHandler());
      }
      MediaRouterJellybeanMr1.ActiveScanWorkaround localActiveScanWorkaround = this.mActiveScanWorkaround;
      if (this.mActiveScan) {}
      for (int i = this.mRouteTypes;; i = 0)
      {
        localActiveScanWorkaround.setActiveScanRouteTypes(i);
        return;
      }
    }
  }
  
  private static class JellybeanMr2Impl
    extends SystemMediaRouteProvider.JellybeanMr1Impl
  {
    public JellybeanMr2Impl(Context paramContext, SystemMediaRouteProvider.SyncCallback paramSyncCallback)
    {
      super(paramSyncCallback);
    }
    
    protected Object getDefaultRoute()
    {
      return MediaRouterJellybeanMr2.getDefaultRoute(this.mRouterObj);
    }
    
    protected boolean isConnecting(SystemMediaRouteProvider.JellybeanImpl.SystemRouteRecord paramSystemRouteRecord)
    {
      return MediaRouterJellybeanMr2.RouteInfo.isConnecting(paramSystemRouteRecord.mRouteObj);
    }
    
    protected void onBuildSystemRouteDescriptor(SystemMediaRouteProvider.JellybeanImpl.SystemRouteRecord paramSystemRouteRecord, MediaRouteDescriptor.Builder paramBuilder)
    {
      super.onBuildSystemRouteDescriptor(paramSystemRouteRecord, paramBuilder);
      paramSystemRouteRecord = MediaRouterJellybeanMr2.RouteInfo.getDescription(paramSystemRouteRecord.mRouteObj);
      if (paramSystemRouteRecord != null) {
        paramBuilder.setDescription(paramSystemRouteRecord.toString());
      }
    }
    
    protected void selectRoute(Object paramObject)
    {
      MediaRouterJellybean.selectRoute(this.mRouterObj, 8388611, paramObject);
    }
    
    protected void updateCallback()
    {
      int i = 1;
      if (this.mCallbackRegistered) {
        MediaRouterJellybean.removeCallback(this.mRouterObj, this.mCallbackObj);
      }
      this.mCallbackRegistered = true;
      Object localObject1 = this.mRouterObj;
      int j = this.mRouteTypes;
      Object localObject2 = this.mCallbackObj;
      if (this.mActiveScan) {}
      for (;;)
      {
        MediaRouterJellybeanMr2.addCallback(localObject1, j, localObject2, i | 0x2);
        return;
        i = 0;
      }
    }
    
    protected void updateUserRouteProperties(SystemMediaRouteProvider.JellybeanImpl.UserRouteRecord paramUserRouteRecord)
    {
      super.updateUserRouteProperties(paramUserRouteRecord);
      MediaRouterJellybeanMr2.UserRouteInfo.setDescription(paramUserRouteRecord.mRouteObj, paramUserRouteRecord.mRoute.getDescription());
    }
  }
  
  static class LegacyImpl
    extends SystemMediaRouteProvider
  {
    private static final ArrayList<IntentFilter> CONTROL_FILTERS;
    private static final int PLAYBACK_STREAM = 3;
    private final AudioManager mAudioManager;
    private int mLastReportedVolume = -1;
    private final VolumeChangeReceiver mVolumeChangeReceiver;
    
    static
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addCategory("android.media.intent.category.LIVE_AUDIO");
      localIntentFilter.addCategory("android.media.intent.category.LIVE_VIDEO");
      CONTROL_FILTERS = new ArrayList();
      CONTROL_FILTERS.add(localIntentFilter);
    }
    
    public LegacyImpl(Context paramContext)
    {
      super();
      this.mAudioManager = ((AudioManager)paramContext.getSystemService("audio"));
      this.mVolumeChangeReceiver = new VolumeChangeReceiver();
      paramContext.registerReceiver(this.mVolumeChangeReceiver, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
      publishRoutes();
    }
    
    private void publishRoutes()
    {
      Object localObject = getContext().getResources();
      int i = this.mAudioManager.getStreamMaxVolume(3);
      this.mLastReportedVolume = this.mAudioManager.getStreamVolume(3);
      localObject = new MediaRouteDescriptor.Builder("DEFAULT_ROUTE", ((Resources)localObject).getString(R.string.mr_system_route_name)).addControlFilters(CONTROL_FILTERS).setPlaybackStream(3).setPlaybackType(0).setVolumeHandling(1).setVolumeMax(i).setVolume(this.mLastReportedVolume).build();
      setDescriptor(new MediaRouteProviderDescriptor.Builder().addRoute((MediaRouteDescriptor)localObject).build());
    }
    
    public MediaRouteProvider.RouteController onCreateRouteController(String paramString)
    {
      if (paramString.equals("DEFAULT_ROUTE")) {
        return new DefaultRouteController();
      }
      return null;
    }
    
    final class DefaultRouteController
      extends MediaRouteProvider.RouteController
    {
      DefaultRouteController() {}
      
      public void onSetVolume(int paramInt)
      {
        SystemMediaRouteProvider.LegacyImpl.this.mAudioManager.setStreamVolume(3, paramInt, 0);
        SystemMediaRouteProvider.LegacyImpl.this.publishRoutes();
      }
      
      public void onUpdateVolume(int paramInt)
      {
        int i = SystemMediaRouteProvider.LegacyImpl.this.mAudioManager.getStreamVolume(3);
        if (Math.min(SystemMediaRouteProvider.LegacyImpl.this.mAudioManager.getStreamMaxVolume(3), Math.max(0, i + paramInt)) != i) {
          SystemMediaRouteProvider.LegacyImpl.this.mAudioManager.setStreamVolume(3, i, 0);
        }
        SystemMediaRouteProvider.LegacyImpl.this.publishRoutes();
      }
    }
    
    final class VolumeChangeReceiver
      extends BroadcastReceiver
    {
      public static final String EXTRA_VOLUME_STREAM_TYPE = "android.media.EXTRA_VOLUME_STREAM_TYPE";
      public static final String EXTRA_VOLUME_STREAM_VALUE = "android.media.EXTRA_VOLUME_STREAM_VALUE";
      public static final String VOLUME_CHANGED_ACTION = "android.media.VOLUME_CHANGED_ACTION";
      
      VolumeChangeReceiver() {}
      
      public void onReceive(Context paramContext, Intent paramIntent)
      {
        if ((paramIntent.getAction().equals("android.media.VOLUME_CHANGED_ACTION")) && (paramIntent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3))
        {
          int i = paramIntent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_VALUE", -1);
          if ((i >= 0) && (i != SystemMediaRouteProvider.LegacyImpl.this.mLastReportedVolume)) {
            SystemMediaRouteProvider.LegacyImpl.this.publishRoutes();
          }
        }
      }
    }
  }
  
  public static abstract interface SyncCallback
  {
    public abstract MediaRouter.RouteInfo getSystemRouteByDescriptorId(String paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/android/support/v7/media/SystemMediaRouteProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */