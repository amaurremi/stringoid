package com.google.android.b.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import com.google.android.b.a.a.al;
import com.google.android.b.a.a.au;
import com.google.android.b.a.a.aw;
import com.google.android.b.a.a.ax;
import com.google.android.b.a.a.c;
import com.google.android.b.a.a.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public final class l
  extends ViewGroup
  implements i
{
  private final m a;
  private final Set b;
  private final n c;
  private com.google.android.b.a.a.f d;
  private au e;
  private View f;
  private al g;
  private i h;
  private Bundle i;
  private f j;
  private boolean k;
  
  l(Context paramContext, AttributeSet paramAttributeSet, int paramInt, n paramn)
  {
    super((Context)d.a(paramContext, "context cannot be null"), paramAttributeSet, paramInt);
    this.c = ((n)d.a(paramn, "listener cannot be null"));
    if (getBackground() == null) {
      setBackgroundColor(-16777216);
    }
    setClipToPadding(false);
    this.g = new al(paramContext);
    requestTransparentRegion(this.g);
    addView(this.g);
    this.b = new HashSet();
    this.a = new m(this, (byte)0);
  }
  
  private void a(View paramView)
  {
    if ((paramView == this.g) || ((this.e != null) && (paramView == this.f))) {}
    for (int m = 1; m == 0; m = 0) {
      throw new UnsupportedOperationException("No views can be added on top of the player");
    }
  }
  
  private void a(b paramb)
  {
    this.e = null;
    this.g.c();
    if (this.j != null)
    {
      this.j.a(this.h, paramb);
      this.j = null;
    }
  }
  
  final void a()
  {
    if (this.e != null) {
      this.e.f();
    }
  }
  
  final void a(final Activity paramActivity, i parami, String paramString, f paramf, Bundle paramBundle)
  {
    if ((this.e != null) || (this.j != null)) {
      return;
    }
    d.a(paramActivity, "activity cannot be null");
    this.h = ((i)d.a(parami, "provider cannot be null"));
    this.j = ((f)d.a(paramf, "listener cannot be null"));
    this.i = paramBundle;
    this.g.b();
    this.d = c.a().a(getContext(), paramString, new aw()new ax
    {
      public final void a()
      {
        if (l.a(l.this) != null) {
          l.a(l.this, paramActivity);
        }
        l.b(l.this);
      }
      
      public final void b()
      {
        if ((!l.c(l.this)) && (l.d(l.this) != null)) {
          l.d(l.this).j();
        }
        l.e(l.this).a();
        if (l.this.indexOfChild(l.e(l.this)) < 0)
        {
          l.this.addView(l.e(l.this));
          l.this.removeView(l.f(l.this));
        }
        l.g(l.this);
        l.h(l.this);
        l.b(l.this);
      }
    }, new ax()
    {
      public final void a(b paramAnonymousb)
      {
        l.a(l.this, paramAnonymousb);
        l.b(l.this);
      }
    });
    this.d.e();
  }
  
  final void a(boolean paramBoolean)
  {
    if (this.e != null)
    {
      this.e.c(paramBoolean);
      b(paramBoolean);
    }
  }
  
  public final void addFocusables(ArrayList paramArrayList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    super.addFocusables(localArrayList, paramInt);
    paramArrayList.addAll(localArrayList);
    this.b.clear();
    this.b.addAll(localArrayList);
  }
  
  public final void addFocusables(ArrayList paramArrayList, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    super.addFocusables(localArrayList, paramInt1, paramInt2);
    paramArrayList.addAll(localArrayList);
    this.b.clear();
    this.b.addAll(localArrayList);
  }
  
  public final void addView(View paramView)
  {
    a(paramView);
    super.addView(paramView);
  }
  
  public final void addView(View paramView, int paramInt)
  {
    a(paramView);
    super.addView(paramView, paramInt);
  }
  
  public final void addView(View paramView, int paramInt1, int paramInt2)
  {
    a(paramView);
    super.addView(paramView, paramInt1, paramInt2);
  }
  
  public final void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    a(paramView);
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  public final void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    a(paramView);
    super.addView(paramView, paramLayoutParams);
  }
  
  final void b()
  {
    if (this.e != null) {
      this.e.g();
    }
  }
  
  final void b(boolean paramBoolean)
  {
    this.k = true;
    if (this.e != null) {
      this.e.b(paramBoolean);
    }
  }
  
  final void c()
  {
    if (this.e != null) {
      this.e.h();
    }
  }
  
  public final void clearChildFocus(View paramView)
  {
    if (hasFocusable())
    {
      requestFocus();
      return;
    }
    super.clearChildFocus(paramView);
  }
  
  final void d()
  {
    if (this.e != null) {
      this.e.i();
    }
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (this.e != null)
    {
      if (paramKeyEvent.getAction() == 0) {
        if ((this.e.a(paramKeyEvent.getKeyCode(), paramKeyEvent)) || (super.dispatchKeyEvent(paramKeyEvent))) {
          bool = true;
        }
      }
      do
      {
        return bool;
        if (paramKeyEvent.getAction() != 1) {
          break;
        }
      } while ((!this.e.b(paramKeyEvent.getKeyCode(), paramKeyEvent)) && (!super.dispatchKeyEvent(paramKeyEvent)));
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  final Bundle e()
  {
    if (this.e == null) {
      return this.i;
    }
    return this.e.l();
  }
  
  public final void focusableViewAvailable(View paramView)
  {
    super.focusableViewAvailable(paramView);
    this.b.add(paramView);
  }
  
  protected final void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    getViewTreeObserver().addOnGlobalFocusChangeListener(this.a);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.e != null) {
      this.e.a(paramConfiguration);
    }
  }
  
  protected final void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    getViewTreeObserver().removeOnGlobalFocusChangeListener(this.a);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getChildCount() > 0) {
      getChildAt(0).layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
    }
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      localView.measure(paramInt1, paramInt2);
      setMeasuredDimension(localView.getMeasuredWidth(), localView.getMeasuredHeight());
      return;
    }
    setMeasuredDimension(0, 0);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public final void requestChildFocus(View paramView1, View paramView2)
  {
    super.requestChildFocus(paramView1, paramView2);
    this.b.add(paramView2);
  }
  
  public final void setClipToPadding(boolean paramBoolean) {}
  
  public final void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/b/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */