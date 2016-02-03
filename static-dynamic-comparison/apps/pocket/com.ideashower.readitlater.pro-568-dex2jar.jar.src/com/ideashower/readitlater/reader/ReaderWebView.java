package com.ideashower.readitlater.reader;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.webkit.WebView.HitTestResult;
import android.widget.Toast;
import com.ideashower.readitlater.util.a;
import com.ideashower.readitlater.views.BaseWebView;
import com.ideashower.readitlater.views.ba;
import com.ideashower.readitlater.views.f;
import com.ideashower.readitlater.views.n;
import com.ideashower.readitlater.views.o;
import com.pocket.webkit.JsInterface;
import com.pocket.webkit.b;

public class ReaderWebView
  extends BaseWebView
  implements b
{
  protected u a;
  protected v b;
  private n i;
  private boolean j;
  
  public ReaderWebView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ReaderWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ReaderWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean a()
  {
    return true;
  }
  
  protected void b()
  {
    super.b();
    setOnLongClickListener(new View.OnLongClickListener()
    {
      public boolean onLongClick(View paramAnonymousView)
      {
        paramAnonymousView = ReaderWebView.this.getHitTestResult();
        int i = paramAnonymousView.getType();
        if (((i == 1) || (i == 7)) && (ReaderWebView.this.a != null))
        {
          ReaderWebView.this.performHapticFeedback(0);
          ReaderWebView.this.a.a(paramAnonymousView.getExtra());
          return true;
        }
        return false;
      }
    });
    this.i = new n(getContext());
    JsInterface.removeSearchBoxInterface(this);
  }
  
  public void c() {}
  
  public void d()
  {
    if (a.q()) {
      setIsSelectingText(false);
    }
  }
  
  public boolean e()
  {
    return this.j;
  }
  
  public boolean f()
  {
    return (this.j) && (a.q());
  }
  
  public n getPaging()
  {
    return this.i;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.i != null) && (this.i.a(paramMotionEvent)))
    {
      if (this.d != null) {
        this.d.a();
      }
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setIsSelectingText(boolean paramBoolean)
  {
    if (this.j == paramBoolean) {}
    do
    {
      return;
      this.j = paramBoolean;
      if ((paramBoolean) && (a.d())) {
        Toast.makeText(getContext(), 2131493768, 1).show();
      }
      this.e.a(paramBoolean);
    } while (this.b == null);
    this.b.a(paramBoolean);
  }
  
  public void setOnLongClickLinkListener(u paramu)
  {
    this.a = paramu;
  }
  
  public void setOnTextSelectionChangeListener(v paramv)
  {
    this.b = paramv;
  }
  
  public void setSwipeListener(o paramo)
  {
    this.i.a(paramo);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/reader/ReaderWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */