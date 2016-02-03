package com.jumptap.adtag.callbacks;

import android.util.Log;
import android.webkit.JavascriptInterface;
import com.jumptap.adtag.events.EventManager;
import com.jumptap.adtag.listeners.JtAdViewInnerListener;

public class EmptyBodyChecker
{
  private EventManager eventManager = null;
  private JtAdViewInnerListener innerListener = null;
  
  public EmptyBodyChecker(JtAdViewInnerListener paramJtAdViewInnerListener, EventManager paramEventManager)
  {
    this.eventManager = paramEventManager;
    this.innerListener = paramJtAdViewInnerListener;
  }
  
  @JavascriptInterface
  public void checkBody(String paramString)
  {
    if (paramString.length() == 0)
    {
      Log.d("JtAd", "Ad was not found.");
      if (this.innerListener != null) {
        this.innerListener.onNoAdFound();
      }
    }
    while (this.innerListener == null) {
      return;
    }
    this.innerListener.onNewAd();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/jumptap/adtag/callbacks/EmptyBodyChecker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */