package android.support.v7.media;

import android.os.Bundle;

public final class MediaRouteDiscoveryRequest
{
  private static final String KEY_ACTIVE_SCAN = "activeScan";
  private static final String KEY_SELECTOR = "selector";
  private final Bundle mBundle;
  private MediaRouteSelector mSelector;
  
  private MediaRouteDiscoveryRequest(Bundle paramBundle)
  {
    this.mBundle = paramBundle;
  }
  
  public MediaRouteDiscoveryRequest(MediaRouteSelector paramMediaRouteSelector, boolean paramBoolean)
  {
    if (paramMediaRouteSelector == null) {
      throw new IllegalArgumentException("selector must not be null");
    }
    this.mBundle = new Bundle();
    this.mSelector = paramMediaRouteSelector;
    this.mBundle.putBundle("selector", paramMediaRouteSelector.asBundle());
    this.mBundle.putBoolean("activeScan", paramBoolean);
  }
  
  private void ensureSelector()
  {
    if (this.mSelector == null)
    {
      this.mSelector = MediaRouteSelector.fromBundle(this.mBundle.getBundle("selector"));
      if (this.mSelector == null) {
        this.mSelector = MediaRouteSelector.EMPTY;
      }
    }
  }
  
  public static MediaRouteDiscoveryRequest fromBundle(Bundle paramBundle)
  {
    if (paramBundle != null) {
      return new MediaRouteDiscoveryRequest(paramBundle);
    }
    return null;
  }
  
  public Bundle asBundle()
  {
    return this.mBundle;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof MediaRouteDiscoveryRequest))
    {
      paramObject = (MediaRouteDiscoveryRequest)paramObject;
      bool1 = bool2;
      if (getSelector().equals(((MediaRouteDiscoveryRequest)paramObject).getSelector()))
      {
        bool1 = bool2;
        if (isActiveScan() == ((MediaRouteDiscoveryRequest)paramObject).isActiveScan()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public MediaRouteSelector getSelector()
  {
    ensureSelector();
    return this.mSelector;
  }
  
  public int hashCode()
  {
    int j = getSelector().hashCode();
    if (isActiveScan()) {}
    for (int i = 1;; i = 0) {
      return i ^ j;
    }
  }
  
  public boolean isActiveScan()
  {
    return this.mBundle.getBoolean("activeScan");
  }
  
  public boolean isValid()
  {
    ensureSelector();
    return this.mSelector.isValid();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DiscoveryRequest{ selector=").append(getSelector());
    localStringBuilder.append(", activeScan=").append(isActiveScan());
    localStringBuilder.append(", isValid=").append(isValid());
    localStringBuilder.append(" }");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/android/support/v7/media/MediaRouteDiscoveryRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */