package com.mocoplex.adlib;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ZoomButtonsController;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AdlibNoZoomWebView
  extends WebView
{
  private ZoomButtonsController a = null;
  
  public AdlibNoZoomWebView(Context paramContext)
  {
    super(paramContext);
    b();
    a();
  }
  
  public AdlibNoZoomWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
    a();
  }
  
  public AdlibNoZoomWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
    a();
  }
  
  private void a()
  {
    if (Build.VERSION.SDK_INT <= 10)
    {
      requestFocus(130);
      setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            return false;
            if (!paramAnonymousView.hasFocus()) {
              paramAnonymousView.requestFocus();
            }
          }
        }
      });
    }
  }
  
  private void b()
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      getSettings().setBuiltInZoomControls(true);
      getSettings().setDisplayZoomControls(false);
      return;
    }
    try
    {
      this.a = ((ZoomButtonsController)Class.forName("android.webkit.WebView").getMethod("getZoomButtonsController", new Class[0]).invoke(this, null));
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localClassNotFoundException.printStackTrace();
      return;
    }
    catch (SecurityException localSecurityException)
    {
      localSecurityException.printStackTrace();
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      localNoSuchMethodException.printStackTrace();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localIllegalArgumentException.printStackTrace();
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      localInvocationTargetException.printStackTrace();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    if (this.a != null) {
      this.a.setVisible(false);
    }
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mocoplex/adlib/AdlibNoZoomWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */