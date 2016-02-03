package com.tapjoy.mraid.listener;

import android.graphics.Bitmap;
import android.webkit.ConsoleMessage;
import android.webkit.WebView;

public abstract interface MraidViewListener
{
  public abstract boolean onClose();
  
  public abstract boolean onConsoleMessage(ConsoleMessage paramConsoleMessage);
  
  public abstract boolean onEventFired();
  
  public abstract boolean onExpand();
  
  public abstract boolean onExpandClose();
  
  public abstract void onPageFinished(WebView paramWebView, String paramString);
  
  public abstract void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap);
  
  public abstract boolean onReady();
  
  public abstract void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2);
  
  public abstract boolean onResize();
  
  public abstract boolean onResizeClose();
  
  public abstract boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/tapjoy/mraid/listener/MraidViewListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */