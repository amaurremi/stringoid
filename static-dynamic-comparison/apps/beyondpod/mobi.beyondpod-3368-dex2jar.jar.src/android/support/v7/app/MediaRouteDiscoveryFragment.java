package android.support.v7.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.media.MediaRouteSelector;
import android.support.v7.media.MediaRouter;
import android.support.v7.media.MediaRouter.Callback;

public class MediaRouteDiscoveryFragment
  extends Fragment
{
  private final String ARGUMENT_SELECTOR = "selector";
  private MediaRouter.Callback mCallback;
  private MediaRouter mRouter;
  private MediaRouteSelector mSelector;
  
  private void ensureRouteSelector()
  {
    if (this.mSelector == null)
    {
      Bundle localBundle = getArguments();
      if (localBundle != null) {
        this.mSelector = MediaRouteSelector.fromBundle(localBundle.getBundle("selector"));
      }
      if (this.mSelector == null) {
        this.mSelector = MediaRouteSelector.EMPTY;
      }
    }
  }
  
  private void ensureRouter()
  {
    if (this.mRouter == null) {
      this.mRouter = MediaRouter.getInstance(getActivity());
    }
  }
  
  public MediaRouter getMediaRouter()
  {
    ensureRouter();
    return this.mRouter;
  }
  
  public MediaRouteSelector getRouteSelector()
  {
    ensureRouteSelector();
    return this.mSelector;
  }
  
  public MediaRouter.Callback onCreateCallback()
  {
    new MediaRouter.Callback() {};
  }
  
  public int onPrepareCallbackFlags()
  {
    return 4;
  }
  
  public void onStart()
  {
    super.onStart();
    ensureRouteSelector();
    ensureRouter();
    this.mCallback = onCreateCallback();
    if (this.mCallback != null) {
      this.mRouter.addCallback(this.mSelector, this.mCallback, onPrepareCallbackFlags());
    }
  }
  
  public void onStop()
  {
    if (this.mCallback != null)
    {
      this.mRouter.removeCallback(this.mCallback);
      this.mCallback = null;
    }
    super.onStop();
  }
  
  public void setRouteSelector(MediaRouteSelector paramMediaRouteSelector)
  {
    if (paramMediaRouteSelector == null) {
      throw new IllegalArgumentException("selector must not be null");
    }
    ensureRouteSelector();
    if (!this.mSelector.equals(paramMediaRouteSelector))
    {
      this.mSelector = paramMediaRouteSelector;
      Bundle localBundle2 = getArguments();
      Bundle localBundle1 = localBundle2;
      if (localBundle2 == null) {
        localBundle1 = new Bundle();
      }
      localBundle1.putBundle("selector", paramMediaRouteSelector.asBundle());
      setArguments(localBundle1);
      if (this.mCallback != null)
      {
        this.mRouter.removeCallback(this.mCallback);
        this.mRouter.addCallback(this.mSelector, this.mCallback, 4);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/android/support/v7/app/MediaRouteDiscoveryFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */