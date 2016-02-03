package com.millennialmedia.android;

import android.content.Context;

public final class MMInterstitial
  implements MMAd
{
  MMAdImpl adImpl;
  int externalId;
  
  public MMInterstitial(Context paramContext)
  {
    this.adImpl = new MMInterstitialAdImpl(paramContext.getApplicationContext());
    this.adImpl.adType = "i";
  }
  
  private void fetchInternal()
  {
    if (isAdAvailable())
    {
      MMSDK.Log.d("Ad already fetched and ready for display...");
      MMSDK.Event.requestFailed(this.adImpl, new MMException(17));
      return;
    }
    MMSDK.Log.d("Fetching new ad...");
    this.adImpl.requestAd();
  }
  
  public boolean display()
  {
    return display(false);
  }
  
  public boolean display(boolean paramBoolean)
  {
    if (!MMSDK.isUiThread()) {
      MMSDK.Log.e(MMException.getErrorCodeMessage(3));
    }
    int i;
    do
    {
      do
      {
        return false;
        try
        {
          i = displayInternal();
          if ((i == 0) || (!paramBoolean)) {
            break;
          }
          throw new MMException(i);
        }
        catch (Exception localException) {}
      } while (!paramBoolean);
      throw new MMException(localException);
    } while (i != 0);
    return true;
  }
  
  int displayInternal()
  {
    try
    {
      MMAdImplController.assignAdViewController(this.adImpl);
      if (this.adImpl.controller != null)
      {
        int i = this.adImpl.controller.display(this.adImpl);
        return i;
      }
    }
    catch (Exception localException)
    {
      MMSDK.Log.e("There was an exception displaying a cached ad. %s", new Object[] { localException.getMessage() });
      localException.printStackTrace();
    }
    return 100;
  }
  
  public void fetch()
  {
    if ((this.adImpl != null) && (this.adImpl.requestListener != null))
    {
      fetch(this.adImpl.mmRequest, this.adImpl.requestListener);
      return;
    }
    fetchInternal();
  }
  
  public void fetch(MMRequest paramMMRequest)
  {
    if ((this.adImpl != null) && (this.adImpl.requestListener != null))
    {
      fetch(paramMMRequest, this.adImpl.requestListener);
      return;
    }
    fetchInternal();
  }
  
  public void fetch(MMRequest paramMMRequest, RequestListener paramRequestListener)
  {
    if (this.adImpl != null)
    {
      this.adImpl.mmRequest = paramMMRequest;
      this.adImpl.requestListener = paramRequestListener;
    }
    fetchInternal();
  }
  
  public String getApid()
  {
    return this.adImpl.getApid();
  }
  
  public boolean getIgnoresDensityScaling()
  {
    return this.adImpl.getIgnoresDensityScaling();
  }
  
  public RequestListener getListener()
  {
    return this.adImpl.getListener();
  }
  
  public MMRequest getMMRequest()
  {
    return this.adImpl.getMMRequest();
  }
  
  public boolean isAdAvailable()
  {
    boolean bool = true;
    if (!MMSDK.isUiThread()) {
      MMSDK.Log.e(MMException.getErrorCodeMessage(3));
    }
    for (;;)
    {
      return false;
      try
      {
        MMAdImplController.assignAdViewController(this.adImpl);
        if (this.adImpl.controller == null) {
          continue;
        }
        int i = this.adImpl.controller.isAdAvailable(this.adImpl);
        if (i == 0) {}
        for (;;)
        {
          return bool;
          bool = false;
        }
        return false;
      }
      catch (Exception localException)
      {
        MMSDK.Log.e("There was an exception checking for a cached ad. %s", new Object[] { localException.getMessage() });
        localException.printStackTrace();
      }
    }
  }
  
  public void setApid(String paramString)
  {
    this.adImpl.setApid(paramString);
  }
  
  public void setIgnoresDensityScaling(boolean paramBoolean)
  {
    this.adImpl.setIgnoresDensityScaling(paramBoolean);
  }
  
  public void setListener(RequestListener paramRequestListener)
  {
    this.adImpl.setListener(paramRequestListener);
  }
  
  public void setMMRequest(MMRequest paramMMRequest)
  {
    this.adImpl.setMMRequest(paramMMRequest);
  }
  
  class MMInterstitialAdImpl
    extends MMAdImpl
  {
    public MMInterstitialAdImpl(Context paramContext)
    {
      super();
      this.adProperties = new AdProperties(getContext());
    }
    
    MMInterstitial getCallingAd()
    {
      return MMInterstitial.this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/millennialmedia/android/MMInterstitial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */