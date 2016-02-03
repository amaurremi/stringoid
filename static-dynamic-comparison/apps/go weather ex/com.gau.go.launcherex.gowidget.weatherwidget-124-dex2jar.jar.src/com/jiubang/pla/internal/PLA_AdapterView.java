package com.jiubang.pla.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewDebug.CapturedViewProperty;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Adapter;

public abstract class PLA_AdapterView
  extends ViewGroup
{
  @ViewDebug.ExportedProperty
  protected int B = 0;
  int C;
  int D;
  long E = Long.MIN_VALUE;
  long F;
  boolean G = false;
  int H;
  boolean I = false;
  m J;
  n K;
  boolean L;
  @ViewDebug.ExportedProperty
  int M;
  int N;
  int O = -1;
  long P = Long.MIN_VALUE;
  boolean Q = false;
  private int a;
  private View b;
  private boolean c;
  private boolean d;
  
  public PLA_AdapterView(Context paramContext)
  {
    super(paramContext);
  }
  
  public PLA_AdapterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PLA_AdapterView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @SuppressLint({"WrongCall"})
  private void a(boolean paramBoolean)
  {
    if (w()) {
      paramBoolean = false;
    }
    if (paramBoolean)
    {
      if (this.b != null)
      {
        this.b.setVisibility(0);
        setVisibility(8);
      }
      for (;;)
      {
        if (this.L) {
          onLayout(false, getLeft(), getTop(), getRight(), getBottom());
        }
        return;
        setVisibility(0);
      }
    }
    if (this.b != null) {
      this.b.setVisibility(8);
    }
    setVisibility(0);
  }
  
  int a(int paramInt, boolean paramBoolean)
  {
    return paramInt;
  }
  
  public void addView(View paramView)
  {
    throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
  }
  
  public void addView(View paramView, int paramInt)
  {
    throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    throw new UnsupportedOperationException("addView(View, int, LayoutParams) is not supported in AdapterView");
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    throw new UnsupportedOperationException("addView(View, LayoutParams) is not supported in AdapterView");
  }
  
  public int b(View paramView)
  {
    try
    {
      for (;;)
      {
        View localView = (View)paramView.getParent();
        boolean bool = localView.equals(this);
        if (bool) {
          break;
        }
        paramView = localView;
      }
      j = getChildCount();
    }
    catch (ClassCastException paramView)
    {
      return -1;
    }
    int j;
    int i = 0;
    while (i < j)
    {
      if (getChildAt(i).equals(paramView)) {
        return i + this.B;
      }
      i += 1;
    }
    return -1;
  }
  
  public boolean b(View paramView, int paramInt, long paramLong)
  {
    boolean bool = false;
    if (this.J != null)
    {
      playSoundEffect(0);
      this.J.a(this, paramView, paramInt, paramLong);
      bool = true;
    }
    return bool;
  }
  
  protected boolean canAnimate()
  {
    return (super.canAnimate()) && (this.M > 0);
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    boolean bool = false;
    if (paramAccessibilityEvent.getEventType() == 8) {
      paramAccessibilityEvent.setEventType(4);
    }
    View localView = e();
    if (localView != null) {
      bool = localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
    }
    if (!bool)
    {
      if (localView != null) {
        paramAccessibilityEvent.setEnabled(localView.isEnabled());
      }
      paramAccessibilityEvent.setItemCount(u());
      paramAccessibilityEvent.setCurrentItemIndex(t());
    }
    return bool;
  }
  
  protected void dispatchRestoreInstanceState(SparseArray paramSparseArray)
  {
    dispatchThawSelfOnly(paramSparseArray);
  }
  
  protected void dispatchSaveInstanceState(SparseArray paramSparseArray)
  {
    dispatchFreezeSelfOnly(paramSparseArray);
  }
  
  public abstract View e();
  
  void m()
  {
    if ((this.M > 0) && (this.G)) {
      this.G = false;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = getHeight();
  }
  
  public void removeAllViews()
  {
    throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
  }
  
  public void removeView(View paramView)
  {
    throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
  }
  
  public void removeViewAt(int paramInt)
  {
    throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
  }
  
  public abstract Adapter s();
  
  public void setFocusable(boolean paramBoolean)
  {
    boolean bool = true;
    Adapter localAdapter = s();
    int i;
    if ((localAdapter == null) || (localAdapter.getCount() == 0))
    {
      i = 1;
      this.c = paramBoolean;
      if (!paramBoolean) {
        this.d = false;
      }
      if (!paramBoolean) {
        break label69;
      }
      paramBoolean = bool;
      if (i != 0) {
        if (!w()) {
          break label69;
        }
      }
    }
    label69:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      super.setFocusable(paramBoolean);
      return;
      i = 0;
      break;
    }
  }
  
  public void setFocusableInTouchMode(boolean paramBoolean)
  {
    boolean bool = true;
    Adapter localAdapter = s();
    int i;
    if ((localAdapter == null) || (localAdapter.getCount() == 0))
    {
      i = 1;
      this.d = paramBoolean;
      if (paramBoolean) {
        this.c = true;
      }
      if (!paramBoolean) {
        break label69;
      }
      paramBoolean = bool;
      if (i != 0) {
        if (!w()) {
          break label69;
        }
      }
    }
    label69:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      super.setFocusableInTouchMode(paramBoolean);
      return;
      i = 0;
      break;
    }
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    throw new RuntimeException("Don't call setOnClickListener for an AdapterView. You probably want setOnItemClickListener instead");
  }
  
  @ViewDebug.CapturedViewProperty
  public int t()
  {
    return -1;
  }
  
  @ViewDebug.CapturedViewProperty
  public int u()
  {
    return this.M;
  }
  
  public int v()
  {
    return this.B;
  }
  
  boolean w()
  {
    return false;
  }
  
  void x()
  {
    boolean bool2 = false;
    Adapter localAdapter = s();
    int i;
    if ((localAdapter == null) || (localAdapter.getCount() == 0))
    {
      i = 1;
      if ((i != 0) && (!w())) {
        break label111;
      }
      i = 1;
      label38:
      if ((i == 0) || (!this.d)) {
        break label116;
      }
      bool1 = true;
      label51:
      super.setFocusableInTouchMode(bool1);
      if ((i == 0) || (!this.c)) {
        break label121;
      }
    }
    label111:
    label116:
    label121:
    for (boolean bool1 = true;; bool1 = false)
    {
      super.setFocusable(bool1);
      if (this.b != null)
      {
        if (localAdapter != null)
        {
          bool1 = bool2;
          if (!localAdapter.isEmpty()) {}
        }
        else
        {
          bool1 = true;
        }
        a(bool1);
      }
      return;
      i = 0;
      break;
      i = 0;
      break label38;
      bool1 = false;
      break label51;
    }
  }
  
  void y()
  {
    View localView;
    Adapter localAdapter;
    if (getChildCount() > 0)
    {
      this.G = true;
      this.F = this.a;
      localView = getChildAt(0);
      localAdapter = s();
      if ((this.B < 0) || (this.B >= localAdapter.getCount())) {
        break label92;
      }
    }
    label92:
    for (this.E = localAdapter.getItemId(this.B);; this.E = -1L)
    {
      this.D = this.B;
      if (localView != null) {
        this.C = localView.getTop();
      }
      this.H = 1;
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/pla/internal/PLA_AdapterView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */