package com.pocket.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.b.c.c;
import com.ideashower.readitlater.views.ThemedTextView;

public class DropDownMessageView
  extends ThemedTextView
  implements com.b.a.b
{
  private static final Interpolator a = new DecelerateInterpolator();
  private static final Interpolator b = new AccelerateInterpolator();
  private final Runnable c = new Runnable()
  {
    public void run()
    {
      DropDownMessageView.a(DropDownMessageView.this);
    }
  };
  private c d;
  private c e;
  private boolean f = true;
  private boolean g = true;
  
  public DropDownMessageView(Context paramContext)
  {
    super(paramContext);
    a(null);
  }
  
  public DropDownMessageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  public DropDownMessageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, com.ideashower.readitlater.b.DropDownMessageView);
      setIsAlignedTop(paramAttributeSet.getBoolean(0, true));
      paramAttributeSet.recycle();
    }
  }
  
  private void b()
  {
    setVisibility(0);
    if (this.f) {}
    for (float f1 = -getHeight();; f1 = getHeight())
    {
      com.b.c.a.e(this, f1);
      this.d = c.a(this).b(0L).f(0.0F).a(333L).a(a).a(this);
      return;
    }
  }
  
  private void c()
  {
    if (this.f) {}
    for (float f1 = -getHeight();; f1 = getHeight())
    {
      this.e = c.a(this).b(4000L).f(f1).a(333L).a(b).a(this);
      return;
    }
  }
  
  public void a()
  {
    Handler localHandler = getHandler();
    if (localHandler == null) {}
    do
    {
      return;
      localHandler.removeCallbacks(this.c);
    } while ((this.e != null) || (this.d == null));
    this.d.a();
    c();
  }
  
  public void a(com.b.a.a parama)
  {
    if (this.d != null)
    {
      this.d = null;
      if (this.g) {
        c();
      }
    }
    while (this.e == null) {
      return;
    }
    this.e = null;
    setVisibility(8);
  }
  
  public void a(CharSequence paramCharSequence, boolean paramBoolean)
  {
    getHandler().removeCallbacks(this.c);
    if (this.e != null) {
      this.e.a();
    }
    if (this.d != null) {
      this.d.a();
    }
    setVisibility(4);
    setText(paramCharSequence);
    this.g = paramBoolean;
    getHandler().post(this.c);
  }
  
  public void b(com.b.a.a parama) {}
  
  public void c(com.b.a.a parama) {}
  
  public void d(com.b.a.a parama) {}
  
  public void setIsAlignedTop(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/DropDownMessageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */