package com.inmobi.re.container;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebView;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.VideoView;
import com.inmobi.commons.internal.Log;

class a
  extends WebChromeClient
{
  a(IMWebView paramIMWebView) {}
  
  public void onGeolocationPermissionsShowPrompt(final String paramString, final GeolocationPermissions.Callback paramCallback)
  {
    try
    {
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(IMWebView.h(this.a));
      localBuilder.setTitle("Locations access");
      localBuilder.setMessage("Allow location access").setCancelable(true).setPositiveButton("Accept", new g(paramCallback, paramString)).setNegativeButton("Decline", new f(paramCallback, paramString));
      localBuilder.create().show();
      super.onGeolocationPermissionsShowPrompt(paramString, paramCallback);
      return;
    }
    catch (Exception localException)
    {
      Log.internal("[InMobi]-[RE]-4.1.1", "Exception while accessing location from creative ", localException);
      paramCallback.invoke(paramString, false, false);
    }
  }
  
  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, final JsResult paramJsResult)
  {
    Log.debug("[InMobi]-[RE]-4.1.1", "IMWebView-> onJsAlert, " + paramString2);
    try
    {
      new AlertDialog.Builder(paramWebView.getContext()).setTitle(paramString1).setMessage(paramString2).setPositiveButton(17039370, new c(paramJsResult)).setCancelable(false).create().show();
      return true;
    }
    catch (Exception paramWebView)
    {
      for (;;)
      {
        Log.internal("[InMobi]-[RE]-4.1.1", "webchrome client exception onJSAlert ", paramWebView);
      }
    }
  }
  
  public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    IMWebView.a(this.a, paramView);
    IMWebView.a(this.a, paramCustomViewCallback);
    Log.debug("[InMobi]-[RE]-4.1.1", "onShowCustomView ******************************" + paramView);
    try
    {
      IMWebView.a(this.a, IMWebView.g(this.a), new b());
      IMWebView.g(this.a).setOnTouchListener(new e());
      if ((paramView instanceof FrameLayout))
      {
        IMWebView.a(this.a, (FrameLayout)paramView);
        paramCustomViewCallback = (FrameLayout)IMWebView.h(this.a).findViewById(16908290);
        if ((IMWebView.i(this.a).getFocusedChild() instanceof VideoView))
        {
          IMWebView.a(this.a, (VideoView)IMWebView.i(this.a).getFocusedChild());
          IMWebView.i(this.a).setBackgroundColor(-16777216);
          IMWebView.k(this.a).setOnCompletionListener(IMWebView.j(this.a));
          IMWebView.k(this.a).setOnFocusChangeListener(new d());
          paramCustomViewCallback.addView(IMWebView.g(this.a), new AbsoluteLayout.LayoutParams(-1, -1, 0, 0));
          Log.debug("[InMobi]-[RE]-4.1.1", "Registering");
          IMWebView.a(this.a, IMWebView.g(this.a), new h());
          return;
        }
        IMWebView.a(this.a, paramView);
        paramView.setBackgroundColor(-16777216);
        Log.debug("[InMobi]-[RE]-4.1.1", "adding " + paramView);
        paramCustomViewCallback.addView(paramView, new AbsoluteLayout.LayoutParams(-1, -1, 0, 0));
        IMWebView.a(this.a, IMWebView.g(this.a), new a());
        return;
      }
    }
    catch (Exception paramView)
    {
      Log.internal("[InMobi]-[RE]-4.1.1", "IMWebview onShowCustomView exception ", paramView);
    }
  }
  
  class a
    implements View.OnKeyListener
  {
    a() {}
    
    public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
    {
      Log.debug("[InMobi]-[RE]-4.1.1", "Back Button pressed when html5 video is playing");
      IMWebView.l(a.this.a);
      return false;
    }
  }
  
  class b
    implements View.OnTouchListener
  {
    b() {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      return false;
    }
  }
  
  class c
    implements DialogInterface.OnClickListener
  {
    c(JsResult paramJsResult) {}
    
    public void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      paramJsResult.confirm();
    }
  }
  
  class d
    implements View.OnFocusChangeListener
  {
    d() {}
    
    public void onFocusChange(View paramView, boolean paramBoolean)
    {
      IMWebView.k(a.this.a).requestFocus();
    }
  }
  
  class e
    implements View.OnTouchListener
  {
    e() {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      return true;
    }
  }
  
  class f
    implements DialogInterface.OnClickListener
  {
    f(GeolocationPermissions.Callback paramCallback, String paramString) {}
    
    public void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      paramCallback.invoke(paramString, false, false);
    }
  }
  
  class g
    implements DialogInterface.OnClickListener
  {
    g(GeolocationPermissions.Callback paramCallback, String paramString) {}
    
    public void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      paramCallback.invoke(paramString, true, false);
    }
  }
  
  class h
    implements View.OnKeyListener
  {
    h() {}
    
    public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
    {
      if ((4 == paramKeyEvent.getKeyCode()) && (paramKeyEvent.getAction() == 0))
      {
        Log.debug("[InMobi]-[RE]-4.1.1", "Back Button pressed when html5 video is playing");
        IMWebView.k(a.this.a).stopPlayback();
        IMWebView.l(a.this.a);
      }
      return false;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/re/container/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */