package android.support.v7.app;

import android.content.Context;
import android.support.v4.view.ActionProvider;
import android.support.v7.media.MediaRouteSelector;
import android.support.v7.media.MediaRouter;
import android.support.v7.media.MediaRouter.Callback;
import android.support.v7.media.MediaRouter.ProviderInfo;
import android.support.v7.media.MediaRouter.RouteInfo;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.lang.ref.WeakReference;

public class MediaRouteActionProvider
  extends ActionProvider
{
  private static final String TAG = "MediaRouteActionProvider";
  private MediaRouteButton mButton;
  private final MediaRouterCallback mCallback;
  private MediaRouteDialogFactory mDialogFactory = MediaRouteDialogFactory.getDefault();
  private final MediaRouter mRouter;
  private MediaRouteSelector mSelector = MediaRouteSelector.EMPTY;
  
  public MediaRouteActionProvider(Context paramContext)
  {
    super(paramContext);
    this.mRouter = MediaRouter.getInstance(paramContext);
    this.mCallback = new MediaRouterCallback(this);
  }
  
  private void refreshRoute()
  {
    refreshVisibility();
  }
  
  public MediaRouteDialogFactory getDialogFactory()
  {
    return this.mDialogFactory;
  }
  
  public MediaRouteButton getMediaRouteButton()
  {
    return this.mButton;
  }
  
  public MediaRouteSelector getRouteSelector()
  {
    return this.mSelector;
  }
  
  public boolean isVisible()
  {
    return this.mRouter.isRouteAvailable(this.mSelector, 1);
  }
  
  public View onCreateActionView()
  {
    if (this.mButton != null) {
      Log.e("MediaRouteActionProvider", "onCreateActionView: this ActionProvider is already associated with a menu item. Don't reuse MediaRouteActionProvider instances! Abandoning the old menu item...");
    }
    this.mButton = onCreateMediaRouteButton();
    this.mButton.setCheatSheetEnabled(true);
    this.mButton.setRouteSelector(this.mSelector);
    this.mButton.setDialogFactory(this.mDialogFactory);
    this.mButton.setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
    return this.mButton;
  }
  
  public MediaRouteButton onCreateMediaRouteButton()
  {
    return new MediaRouteButton(getContext());
  }
  
  public boolean onPerformDefaultAction()
  {
    if (this.mButton != null) {
      return this.mButton.showDialog();
    }
    return false;
  }
  
  public boolean overridesItemVisibility()
  {
    return true;
  }
  
  public void setDialogFactory(MediaRouteDialogFactory paramMediaRouteDialogFactory)
  {
    if (paramMediaRouteDialogFactory == null) {
      throw new IllegalArgumentException("factory must not be null");
    }
    if (this.mDialogFactory != paramMediaRouteDialogFactory)
    {
      this.mDialogFactory = paramMediaRouteDialogFactory;
      if (this.mButton != null) {
        this.mButton.setDialogFactory(paramMediaRouteDialogFactory);
      }
    }
  }
  
  public void setRouteSelector(MediaRouteSelector paramMediaRouteSelector)
  {
    if (paramMediaRouteSelector == null) {
      throw new IllegalArgumentException("selector must not be null");
    }
    if (!this.mSelector.equals(paramMediaRouteSelector))
    {
      if (!this.mSelector.isEmpty()) {
        this.mRouter.removeCallback(this.mCallback);
      }
      if (!paramMediaRouteSelector.isEmpty()) {
        this.mRouter.addCallback(paramMediaRouteSelector, this.mCallback);
      }
      this.mSelector = paramMediaRouteSelector;
      refreshRoute();
      if (this.mButton != null) {
        this.mButton.setRouteSelector(paramMediaRouteSelector);
      }
    }
  }
  
  private static final class MediaRouterCallback
    extends MediaRouter.Callback
  {
    private final WeakReference<MediaRouteActionProvider> mProviderWeak;
    
    public MediaRouterCallback(MediaRouteActionProvider paramMediaRouteActionProvider)
    {
      this.mProviderWeak = new WeakReference(paramMediaRouteActionProvider);
    }
    
    private void refreshRoute(MediaRouter paramMediaRouter)
    {
      MediaRouteActionProvider localMediaRouteActionProvider = (MediaRouteActionProvider)this.mProviderWeak.get();
      if (localMediaRouteActionProvider != null)
      {
        localMediaRouteActionProvider.refreshRoute();
        return;
      }
      paramMediaRouter.removeCallback(this);
    }
    
    public void onProviderAdded(MediaRouter paramMediaRouter, MediaRouter.ProviderInfo paramProviderInfo)
    {
      refreshRoute(paramMediaRouter);
    }
    
    public void onProviderChanged(MediaRouter paramMediaRouter, MediaRouter.ProviderInfo paramProviderInfo)
    {
      refreshRoute(paramMediaRouter);
    }
    
    public void onProviderRemoved(MediaRouter paramMediaRouter, MediaRouter.ProviderInfo paramProviderInfo)
    {
      refreshRoute(paramMediaRouter);
    }
    
    public void onRouteAdded(MediaRouter paramMediaRouter, MediaRouter.RouteInfo paramRouteInfo)
    {
      refreshRoute(paramMediaRouter);
    }
    
    public void onRouteChanged(MediaRouter paramMediaRouter, MediaRouter.RouteInfo paramRouteInfo)
    {
      refreshRoute(paramMediaRouter);
    }
    
    public void onRouteRemoved(MediaRouter paramMediaRouter, MediaRouter.RouteInfo paramRouteInfo)
    {
      refreshRoute(paramMediaRouter);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/android/support/v7/app/MediaRouteActionProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */