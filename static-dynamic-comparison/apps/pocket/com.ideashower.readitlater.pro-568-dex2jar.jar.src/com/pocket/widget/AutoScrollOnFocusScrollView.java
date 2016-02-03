package com.pocket.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalFocusChangeListener;
import android.widget.EditText;
import android.widget.ScrollView;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.util.z;

public class AutoScrollOnFocusScrollView
  extends ScrollView
  implements ViewTreeObserver.OnGlobalFocusChangeListener
{
  private final int[] a = new int[2];
  private final Runnable b = new Runnable()
  {
    public void run()
    {
      AutoScrollOnFocusScrollView.a(AutoScrollOnFocusScrollView.this, AutoScrollOnFocusScrollView.a(AutoScrollOnFocusScrollView.this));
    }
  };
  private int c;
  private int d;
  private View e;
  private ViewGroup f;
  private boolean g;
  
  public AutoScrollOnFocusScrollView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AutoScrollOnFocusScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AutoScrollOnFocusScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    this.e = null;
    if ((getContext() instanceof Activity))
    {
      View localView = ((Activity)getContext()).getCurrentFocus();
      if ((localView instanceof EditText))
      {
        this.e = localView;
        a(localView);
      }
    }
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {}
    label206:
    for (;;)
    {
      return;
      int j = getScrollY();
      int i;
      if ((this.g) && (this.f != null) && (this.f.getVisibility() == 0) && (this.f.getHeight() < getHeight()))
      {
        i = (int)((getHeight() - this.f.getHeight()) / 2.0F);
        i = z.a(this.f, this, this.a) - i;
      }
      for (;;)
      {
        if (i == j) {
          break label206;
        }
        scrollTo(getScrollX(), i);
        if (getHandler() == null) {
          break;
        }
        getHandler().post(this.b);
        return;
        int k = z.a(paramView, this, this.a);
        i = Math.max(0, k - this.c);
        k = k + paramView.getHeight() + this.d;
        if ((getHeight() + j >= k) && (j <= i)) {
          i = getScrollY();
        } else if (i < j) {
          i -= j.a(5.0F);
        } else {
          i = k + j.a(5.0F) - getHeight();
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    getViewTreeObserver().addOnGlobalFocusChangeListener(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    getViewTreeObserver().removeOnGlobalFocusChangeListener(this);
  }
  
  public void onGlobalFocusChanged(View paramView1, View paramView2)
  {
    this.g = false;
    if ((paramView2 instanceof EditText))
    {
      a();
      return;
    }
    this.e = null;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt4 - paramInt2 > j.a(120.0F)) {}
    for (boolean bool = true;; bool = false)
    {
      this.g = bool;
      a();
      return;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.e = null;
    this.g = false;
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setIdealFocusGroup(ViewGroup paramViewGroup)
  {
    this.f = paramViewGroup;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/AutoScrollOnFocusScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */