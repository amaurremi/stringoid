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
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebView;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.VideoView;
import com.inmobi.commons.internal.Log;

class c
  extends WebChromeClient
{
  c(IMWebView paramIMWebView) {}
  
  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, final JsResult paramJsResult)
  {
    Log.debug("IMRE_3.7.1", "IMWebView-> onJsAlert, " + paramString2);
    try
    {
      new AlertDialog.Builder(paramWebView.getContext()).setTitle(paramString1).setMessage(paramString2).setPositiveButton(17039370, new b(paramJsResult)).setCancelable(false).create().show();
      return true;
    }
    catch (Exception paramWebView)
    {
      for (;;)
      {
        Log.internal("IMRE_3.7.1", "webchrome client exception onJSAlert ", paramWebView);
      }
    }
  }
  
  public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    IMWebView.a(this.a, paramView);
    IMWebView.a(this.a, paramCustomViewCallback);
    Log.debug("IMRE_3.7.1", "onShowCustomView ******************************" + paramView);
    try
    {
      IMWebView.a(this.a, IMWebView.g(this.a), new a());
      IMWebView.g(this.a).setOnTouchListener(new d());
      if ((paramView instanceof FrameLayout))
      {
        IMWebView.a(this.a, (FrameLayout)paramView);
        paramCustomViewCallback = (FrameLayout)IMWebView.h(this.a).findViewById(16908290);
        if ((IMWebView.i(this.a).getFocusedChild() instanceof VideoView))
        {
          IMWebView.a(this.a, (VideoView)IMWebView.i(this.a).getFocusedChild());
          IMWebView.i(this.a).setBackgroundColor(-16777216);
          IMWebView.k(this.a).setOnCompletionListener(IMWebView.j(this.a));
          IMWebView.k(this.a).setOnFocusChangeListener(new c());
          paramCustomViewCallback.addView(IMWebView.g(this.a), new AbsoluteLayout.LayoutParams(-1, -1, 0, 0));
          Log.debug("IMRE_3.7.1", "Registering");
          IMWebView.a(this.a, IMWebView.g(this.a), new e());
          return;
        }
        IMWebView.a(this.a, paramView);
        paramView.setBackgroundColor(-16777216);
        Log.debug("IMRE_3.7.1", "adding " + paramView);
        paramCustomViewCallback.addView(paramView, new AbsoluteLayout.LayoutParams(-1, -1, 0, 0));
        IMWebView.a(this.a, IMWebView.g(this.a), new f());
        return;
      }
    }
    catch (Exception paramView)
    {
      Log.internal("IMRE_3.7.1", "IMWebview onShowCustomView exception ", paramView);
    }
  }
  
  class a
    implements View.OnTouchListener
  {
    a() {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      return false;
    }
  }
  
  class b
    implements DialogInterface.OnClickListener
  {
    b(JsResult paramJsResult) {}
    
    public void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      paramJsResult.confirm();
    }
  }
  
  class c
    implements View.OnFocusChangeListener
  {
    c() {}
    
    public void onFocusChange(View paramView, boolean paramBoolean)
    {
      IMWebView.k(c.this.a).requestFocus();
    }
  }
  
  class d
    implements View.OnTouchListener
  {
    d() {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      return true;
    }
  }
  
  class e
    implements View.OnKeyListener
  {
    e() {}
    
    public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
    {
      if ((4 == paramKeyEvent.getKeyCode()) && (paramKeyEvent.getAction() == 0))
      {
        Log.debug("IMRE_3.7.1", "Back Button pressed when html5 video is playing");
        IMWebView.k(c.this.a).stopPlayback();
        IMWebView.l(c.this.a);
        return true;
      }
      return false;
    }
  }
  
  class f
    implements View.OnKeyListener
  {
    f() {}
    
    public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
    {
      Log.debug("IMRE_3.7.1", "Back Button pressed when html5 video is playing");
      IMWebView.l(c.this.a);
      return true;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/re/container/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */