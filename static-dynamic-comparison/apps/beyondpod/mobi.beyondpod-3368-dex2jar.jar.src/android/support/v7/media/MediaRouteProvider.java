package android.support.v7.media;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;

public abstract class MediaRouteProvider
{
  private static final int MSG_DELIVER_DESCRIPTOR_CHANGED = 1;
  private static final int MSG_DELIVER_DISCOVERY_REQUEST_CHANGED = 2;
  private Callback mCallback;
  private final Context mContext;
  private MediaRouteProviderDescriptor mDescriptor;
  private MediaRouteDiscoveryRequest mDiscoveryRequest;
  private final ProviderHandler mHandler = new ProviderHandler(null);
  private final ProviderMetadata mMetadata;
  private boolean mPendingDescriptorChange;
  private boolean mPendingDiscoveryRequestChange;
  
  public MediaRouteProvider(Context paramContext)
  {
    this(paramContext, null);
  }
  
  MediaRouteProvider(Context paramContext, ProviderMetadata paramProviderMetadata)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("context must not be null");
    }
    this.mContext = paramContext;
    if (paramProviderMetadata == null)
    {
      this.mMetadata = new ProviderMetadata(paramContext.getPackageName());
      return;
    }
    this.mMetadata = paramProviderMetadata;
  }
  
  private void deliverDescriptorChanged()
  {
    this.mPendingDescriptorChange = false;
    if (this.mCallback != null) {
      this.mCallback.onDescriptorChanged(this, this.mDescriptor);
    }
  }
  
  private void deliverDiscoveryRequestChanged()
  {
    this.mPendingDiscoveryRequestChange = false;
    onDiscoveryRequestChanged(this.mDiscoveryRequest);
  }
  
  public final Context getContext()
  {
    return this.mContext;
  }
  
  public final MediaRouteProviderDescriptor getDescriptor()
  {
    return this.mDescriptor;
  }
  
  public final MediaRouteDiscoveryRequest getDiscoveryRequest()
  {
    return this.mDiscoveryRequest;
  }
  
  public final Handler getHandler()
  {
    return this.mHandler;
  }
  
  public final ProviderMetadata getMetadata()
  {
    return this.mMetadata;
  }
  
  public RouteController onCreateRouteController(String paramString)
  {
    return null;
  }
  
  public void onDiscoveryRequestChanged(MediaRouteDiscoveryRequest paramMediaRouteDiscoveryRequest) {}
  
  public final void setCallback(Callback paramCallback)
  {
    MediaRouter.checkCallingThread();
    this.mCallback = paramCallback;
  }
  
  public final void setDescriptor(MediaRouteProviderDescriptor paramMediaRouteProviderDescriptor)
  {
    
    if (this.mDescriptor != paramMediaRouteProviderDescriptor)
    {
      this.mDescriptor = paramMediaRouteProviderDescriptor;
      if (!this.mPendingDescriptorChange)
      {
        this.mPendingDescriptorChange = true;
        this.mHandler.sendEmptyMessage(1);
      }
    }
  }
  
  public final void setDiscoveryRequest(MediaRouteDiscoveryRequest paramMediaRouteDiscoveryRequest)
  {
    
    if ((this.mDiscoveryRequest == paramMediaRouteDiscoveryRequest) || ((this.mDiscoveryRequest != null) && (this.mDiscoveryRequest.equals(paramMediaRouteDiscoveryRequest)))) {}
    do
    {
      return;
      this.mDiscoveryRequest = paramMediaRouteDiscoveryRequest;
    } while (this.mPendingDiscoveryRequestChange);
    this.mPendingDiscoveryRequestChange = true;
    this.mHandler.sendEmptyMessage(2);
  }
  
  public static abstract class Callback
  {
    public void onDescriptorChanged(MediaRouteProvider paramMediaRouteProvider, MediaRouteProviderDescriptor paramMediaRouteProviderDescriptor) {}
  }
  
  private final class ProviderHandler
    extends Handler
  {
    private ProviderHandler() {}
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        return;
      case 1: 
        MediaRouteProvider.this.deliverDescriptorChanged();
        return;
      }
      MediaRouteProvider.this.deliverDiscoveryRequestChanged();
    }
  }
  
  public static final class ProviderMetadata
  {
    private final String mPackageName;
    
    public ProviderMetadata(String paramString)
    {
      if (TextUtils.isEmpty(paramString)) {
        throw new IllegalArgumentException("packageName must not be null or empty");
      }
      this.mPackageName = paramString;
    }
    
    public String getPackageName()
    {
      return this.mPackageName;
    }
    
    public String toString()
    {
      return "ProviderMetadata{ packageName=" + this.mPackageName + " }";
    }
  }
  
  public static abstract class RouteController
  {
    public boolean onControlRequest(Intent paramIntent, MediaRouter.ControlRequestCallback paramControlRequestCallback)
    {
      return false;
    }
    
    public void onRelease() {}
    
    public void onSelect() {}
    
    public void onSetVolume(int paramInt) {}
    
    public void onUnselect() {}
    
    public void onUpdateVolume(int paramInt) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/android/support/v7/media/MediaRouteProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */