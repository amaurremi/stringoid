package com.millennialmedia.android;

import android.util.Log;

public abstract interface RequestListener
{
  public abstract void MMAdOverlayClosed(MMAd paramMMAd);
  
  public abstract void MMAdOverlayLaunched(MMAd paramMMAd);
  
  public abstract void MMAdRequestIsCaching(MMAd paramMMAd);
  
  public abstract void onSingleTap(MMAd paramMMAd);
  
  public abstract void requestCompleted(MMAd paramMMAd);
  
  public abstract void requestFailed(MMAd paramMMAd, MMException paramMMException);
  
  public static class RequestListenerImpl
    implements RequestListener
  {
    public void MMAdOverlayClosed(MMAd paramMMAd)
    {
      Log.i("MillennialMediaSDK", "Millennial Media Ad View overlay closed");
    }
    
    public void MMAdOverlayLaunched(MMAd paramMMAd)
    {
      Log.i("MillennialMediaSDK", "Millennial Media Ad View overlay launched");
    }
    
    public void MMAdRequestIsCaching(MMAd paramMMAd)
    {
      Log.i("MillennialMediaSDK", "Millennial Media Ad View caching request");
    }
    
    public void onSingleTap(MMAd paramMMAd)
    {
      Log.i("MillennialMediaSDK", "Ad tapped");
    }
    
    public void requestCompleted(MMAd paramMMAd)
    {
      Log.i("MillennialMediaSDK", "Ad request succeeded");
    }
    
    public void requestFailed(MMAd paramMMAd, MMException paramMMException)
    {
      Log.i("MillennialMediaSDK", String.format("Ad request failed with error: %d %s.", new Object[] { Integer.valueOf(paramMMException.getCode()), paramMMException.getMessage() }));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/millennialmedia/android/RequestListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */