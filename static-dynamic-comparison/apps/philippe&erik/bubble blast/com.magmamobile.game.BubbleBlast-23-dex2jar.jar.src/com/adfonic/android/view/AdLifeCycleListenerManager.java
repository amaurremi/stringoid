package com.adfonic.android.view;

import android.app.Activity;
import android.content.Context;
import com.adfonic.android.AdListener;

public class AdLifeCycleListenerManager
{
  private AdListener adListener;
  
  private Activity getActivityForCallback(Context paramContext)
  {
    if (getAdListener() == null) {
      return null;
    }
    if (paramContext == null) {
      return null;
    }
    try
    {
      paramContext = (Activity)paramContext;
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  private void runOnUiThread(Context paramContext, Runnable paramRunnable)
  {
    paramContext = getActivityForCallback(paramContext);
    if (paramContext == null) {
      return;
    }
    try
    {
      paramContext.runOnUiThread(paramRunnable);
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public AdListener getAdListener()
  {
    return this.adListener;
  }
  
  public void onAdClick(Context paramContext)
  {
    runOnUiThread(paramContext, new Runnable()
    {
      public void run()
      {
        try
        {
          AdLifeCycleListenerManager.this.getAdListener().onClick();
          return;
        }
        catch (Throwable localThrowable) {}
      }
    });
  }
  
  public void onAdReceived(Context paramContext)
  {
    runOnUiThread(paramContext, new Runnable()
    {
      public void run()
      {
        try
        {
          AdLifeCycleListenerManager.this.getAdListener().onReceivedAd();
          return;
        }
        catch (Throwable localThrowable) {}
      }
    });
  }
  
  public void onDismissScreen(Context paramContext)
  {
    runOnUiThread(paramContext, new Runnable()
    {
      public void run()
      {
        try
        {
          AdLifeCycleListenerManager.this.getAdListener().onDismissScreen();
          return;
        }
        catch (Throwable localThrowable) {}
      }
    });
  }
  
  public void onPresentScreen(Context paramContext)
  {
    runOnUiThread(paramContext, new Runnable()
    {
      public void run()
      {
        try
        {
          AdLifeCycleListenerManager.this.getAdListener().onPresentScreen();
          return;
        }
        catch (Throwable localThrowable) {}
      }
    });
  }
  
  public void onThrowable(Context paramContext)
  {
    runOnUiThread(paramContext, new Runnable()
    {
      public void run()
      {
        try
        {
          AdLifeCycleListenerManager.this.getAdListener().onInternalError();
          return;
        }
        catch (Throwable localThrowable) {}
      }
    });
  }
  
  public void setAdListener(AdListener paramAdListener)
  {
    this.adListener = paramAdListener;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/adfonic/android/view/AdLifeCycleListenerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */