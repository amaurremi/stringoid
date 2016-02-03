package mobi.beyondpod.ui.core.mediarouter;

import android.support.v7.media.MediaRouter;
import android.support.v7.media.MediaRouter.Callback;
import android.support.v7.media.MediaRouter.ProviderInfo;
import android.support.v7.media.MediaRouter.RouteInfo;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.services.player.impl.ChromecastDevice;

public class MediaRouteDiscoveryFragment
  extends android.support.v7.app.MediaRouteDiscoveryFragment
{
  public static final String DISCOVERY_FRAGMENT_TAG = "DiscoveryFragment";
  private static final String TAG = "MediaRouteDiscoveryFragment";
  IDiscoveryFragmentOwner _Owner;
  
  public MediaRouter.Callback onCreateCallback()
  {
    new MediaRouter.Callback()
    {
      public void onProviderAdded(MediaRouter paramAnonymousMediaRouter, MediaRouter.ProviderInfo paramAnonymousProviderInfo)
      {
        CoreHelper.WriteTraceEntryInDebug("MediaRouteDiscoveryFragment", "onRouteProviderAdded: provider=" + paramAnonymousProviderInfo);
      }
      
      public void onProviderChanged(MediaRouter paramAnonymousMediaRouter, MediaRouter.ProviderInfo paramAnonymousProviderInfo)
      {
        CoreHelper.WriteTraceEntryInDebug("MediaRouteDiscoveryFragment", "onRouteProviderChanged: provider=" + paramAnonymousProviderInfo);
      }
      
      public void onProviderRemoved(MediaRouter paramAnonymousMediaRouter, MediaRouter.ProviderInfo paramAnonymousProviderInfo)
      {
        CoreHelper.WriteTraceEntryInDebug("MediaRouteDiscoveryFragment", "onRouteProviderRemoved: provider=" + paramAnonymousProviderInfo);
      }
      
      public void onRoutePresentationDisplayChanged(MediaRouter paramAnonymousMediaRouter, MediaRouter.RouteInfo paramAnonymousRouteInfo)
      {
        CoreHelper.WriteTraceEntryInDebug("MediaRouteDiscoveryFragment", "onRoutePresentationDisplayChanged: route=" + paramAnonymousRouteInfo);
      }
      
      public void onRouteSelected(MediaRouter paramAnonymousMediaRouter, MediaRouter.RouteInfo paramAnonymousRouteInfo)
      {
        CoreHelper.WriteTraceEntryInDebug("MediaRouteDiscoveryFragment", "Media Route Selected: route=" + paramAnonymousRouteInfo);
        if (!paramAnonymousRouteInfo.supportsControlCategory(ChromecastDevice.CastControlCategory())) {}
        do
        {
          for (;;)
          {
            return;
            if (!ChromecastDevice.checkGooglePlaySevices(MediaRouteDiscoveryFragment.this.getActivity(), false))
            {
              CoreHelper.WriteTraceEntry("MediaRouteDiscoveryFragment", "Device is not running a requred version of Google Play Services! Please update from Google Play store");
              if (MediaRouteDiscoveryFragment.this._Owner != null) {
                MediaRouteDiscoveryFragment.this._Owner.onIncompatiblePlayServices();
              }
            }
            else
            {
              try
              {
                if (!BeyondPodApplication.GetInstance().ChromecastDevice().connectToDevice(paramAnonymousRouteInfo.getId())) {
                  break label143;
                }
                if (MediaRouteDiscoveryFragment.this._Owner != null)
                {
                  MediaRouteDiscoveryFragment.this._Owner.onConnectedToDevice(paramAnonymousRouteInfo.getName());
                  return;
                }
              }
              catch (IllegalAccessException paramAnonymousMediaRouter) {}
            }
          }
        } while (MediaRouteDiscoveryFragment.this._Owner == null);
        MediaRouteDiscoveryFragment.this._Owner.onConnectionRefused();
        return;
        label143:
        CoreHelper.WriteTraceEntry("MediaRouteDiscoveryFragment", "Selected route is not a CAST route (probably bluetooth device)! Nothing to do!");
      }
      
      public void onRouteUnselected(MediaRouter paramAnonymousMediaRouter, MediaRouter.RouteInfo paramAnonymousRouteInfo)
      {
        CoreHelper.WriteTraceEntryInDebug("MediaRouteDiscoveryFragment", "Media Route Unselected: route=" + paramAnonymousRouteInfo);
        if ((BeyondPodApplication.GetInstance().ChromecastDevice().disconnectFromDevice()) && (MediaRouteDiscoveryFragment.this._Owner != null)) {
          MediaRouteDiscoveryFragment.this._Owner.onDisconnectFromDevice();
        }
      }
      
      public void onRouteVolumeChanged(MediaRouter paramAnonymousMediaRouter, MediaRouter.RouteInfo paramAnonymousRouteInfo)
      {
        CoreHelper.WriteTraceEntryInDebug("MediaRouteDiscoveryFragment", "onRouteVolumeChanged: route=" + paramAnonymousRouteInfo);
      }
    };
  }
  
  public int onPrepareCallbackFlags()
  {
    return super.onPrepareCallbackFlags() | 0x2;
  }
  
  public void setOwner(IDiscoveryFragmentOwner paramIDiscoveryFragmentOwner)
  {
    this._Owner = paramIDiscoveryFragmentOwner;
  }
  
  public static abstract interface IDiscoveryFragmentOwner
  {
    public abstract void onConnectedToDevice(String paramString);
    
    public abstract void onConnectionRefused();
    
    public abstract void onDisconnectFromDevice();
    
    public abstract void onIncompatiblePlayServices();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/mediarouter/MediaRouteDiscoveryFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */