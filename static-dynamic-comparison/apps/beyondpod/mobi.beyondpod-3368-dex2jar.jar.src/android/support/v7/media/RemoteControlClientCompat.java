package android.support.v7.media;

import android.content.Context;
import android.os.Build.VERSION;
import java.lang.ref.WeakReference;

abstract class RemoteControlClientCompat
{
  protected final Context mContext;
  protected final Object mRcc;
  protected VolumeCallback mVolumeCallback;
  
  protected RemoteControlClientCompat(Context paramContext, Object paramObject)
  {
    this.mContext = paramContext;
    this.mRcc = paramObject;
  }
  
  public static RemoteControlClientCompat obtain(Context paramContext, Object paramObject)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return new JellybeanImpl(paramContext, paramObject);
    }
    return new LegacyImpl(paramContext, paramObject);
  }
  
  public Object getRemoteControlClient()
  {
    return this.mRcc;
  }
  
  public void setPlaybackInfo(PlaybackInfo paramPlaybackInfo) {}
  
  public void setVolumeCallback(VolumeCallback paramVolumeCallback)
  {
    this.mVolumeCallback = paramVolumeCallback;
  }
  
  static class JellybeanImpl
    extends RemoteControlClientCompat
  {
    private boolean mRegistered;
    private final Object mRouterObj;
    private final Object mUserRouteCategoryObj;
    private final Object mUserRouteObj;
    
    public JellybeanImpl(Context paramContext, Object paramObject)
    {
      super(paramObject);
      this.mRouterObj = MediaRouterJellybean.getMediaRouter(paramContext);
      this.mUserRouteCategoryObj = MediaRouterJellybean.createRouteCategory(this.mRouterObj, "", false);
      this.mUserRouteObj = MediaRouterJellybean.createUserRoute(this.mRouterObj, this.mUserRouteCategoryObj);
    }
    
    public void setPlaybackInfo(RemoteControlClientCompat.PlaybackInfo paramPlaybackInfo)
    {
      MediaRouterJellybean.UserRouteInfo.setVolume(this.mUserRouteObj, paramPlaybackInfo.volume);
      MediaRouterJellybean.UserRouteInfo.setVolumeMax(this.mUserRouteObj, paramPlaybackInfo.volumeMax);
      MediaRouterJellybean.UserRouteInfo.setVolumeHandling(this.mUserRouteObj, paramPlaybackInfo.volumeHandling);
      MediaRouterJellybean.UserRouteInfo.setPlaybackStream(this.mUserRouteObj, paramPlaybackInfo.playbackStream);
      MediaRouterJellybean.UserRouteInfo.setPlaybackType(this.mUserRouteObj, paramPlaybackInfo.playbackType);
      if (!this.mRegistered)
      {
        this.mRegistered = true;
        MediaRouterJellybean.UserRouteInfo.setVolumeCallback(this.mUserRouteObj, MediaRouterJellybean.createVolumeCallback(new VolumeCallbackWrapper(this)));
        MediaRouterJellybean.UserRouteInfo.setRemoteControlClient(this.mUserRouteObj, this.mRcc);
      }
    }
    
    private static final class VolumeCallbackWrapper
      implements MediaRouterJellybean.VolumeCallback
    {
      private final WeakReference<RemoteControlClientCompat.JellybeanImpl> mImplWeak;
      
      public VolumeCallbackWrapper(RemoteControlClientCompat.JellybeanImpl paramJellybeanImpl)
      {
        this.mImplWeak = new WeakReference(paramJellybeanImpl);
      }
      
      public void onVolumeSetRequest(Object paramObject, int paramInt)
      {
        paramObject = (RemoteControlClientCompat.JellybeanImpl)this.mImplWeak.get();
        if ((paramObject != null) && (((RemoteControlClientCompat.JellybeanImpl)paramObject).mVolumeCallback != null)) {
          ((RemoteControlClientCompat.JellybeanImpl)paramObject).mVolumeCallback.onVolumeSetRequest(paramInt);
        }
      }
      
      public void onVolumeUpdateRequest(Object paramObject, int paramInt)
      {
        paramObject = (RemoteControlClientCompat.JellybeanImpl)this.mImplWeak.get();
        if ((paramObject != null) && (((RemoteControlClientCompat.JellybeanImpl)paramObject).mVolumeCallback != null)) {
          ((RemoteControlClientCompat.JellybeanImpl)paramObject).mVolumeCallback.onVolumeUpdateRequest(paramInt);
        }
      }
    }
  }
  
  static class LegacyImpl
    extends RemoteControlClientCompat
  {
    public LegacyImpl(Context paramContext, Object paramObject)
    {
      super(paramObject);
    }
  }
  
  public static final class PlaybackInfo
  {
    public int playbackStream = 3;
    public int playbackType = 1;
    public int volume;
    public int volumeHandling = 0;
    public int volumeMax;
  }
  
  public static abstract interface VolumeCallback
  {
    public abstract void onVolumeSetRequest(int paramInt);
    
    public abstract void onVolumeUpdateRequest(int paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/android/support/v7/media/RemoteControlClientCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */