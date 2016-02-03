package com.actionbarsherlock.internal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.PopupWindow;
import java.lang.reflect.Field;

public class PopupWindowCompat
  extends PopupWindow
{
  private static final ViewTreeObserver.OnScrollChangedListener NOP = new ViewTreeObserver.OnScrollChangedListener()
  {
    public void onScrollChanged() {}
  };
  private static final Field superListenerField;
  private ViewTreeObserver.OnScrollChangedListener mSuperScrollListener;
  private ViewTreeObserver mViewTreeObserver;
  
  static
  {
    Object localObject = null;
    try
    {
      Field localField = PopupWindow.class.getDeclaredField("mOnScrollChangedListener");
      localObject = localField;
      localField.setAccessible(true);
      localObject = localField;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;) {}
    }
    superListenerField = (Field)localObject;
  }
  
  public PopupWindowCompat()
  {
    init();
  }
  
  public PopupWindowCompat(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
    init();
  }
  
  public PopupWindowCompat(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public PopupWindowCompat(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public PopupWindowCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  public PopupWindowCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    init();
  }
  
  public PopupWindowCompat(View paramView)
  {
    super(paramView);
    init();
  }
  
  public PopupWindowCompat(View paramView, int paramInt1, int paramInt2)
  {
    super(paramView, paramInt1, paramInt2);
    init();
  }
  
  public PopupWindowCompat(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramView, paramInt1, paramInt2, paramBoolean);
    init();
  }
  
  private void init()
  {
    if (superListenerField != null) {}
    try
    {
      this.mSuperScrollListener = ((ViewTreeObserver.OnScrollChangedListener)superListenerField.get(this));
      superListenerField.set(this, NOP);
      return;
    }
    catch (Exception localException)
    {
      this.mSuperScrollListener = null;
    }
  }
  
  private void registerListener(View paramView)
  {
    if (this.mSuperScrollListener != null) {
      if (paramView.getWindowToken() == null) {
        break label73;
      }
    }
    label73:
    for (paramView = paramView.getViewTreeObserver();; paramView = null)
    {
      if (paramView != this.mViewTreeObserver)
      {
        if ((this.mViewTreeObserver != null) && (this.mViewTreeObserver.isAlive())) {
          this.mViewTreeObserver.removeOnScrollChangedListener(this.mSuperScrollListener);
        }
        this.mViewTreeObserver = paramView;
        if (paramView != null) {
          paramView.addOnScrollChangedListener(this.mSuperScrollListener);
        }
      }
      return;
    }
  }
  
  private void unregisterListener()
  {
    if ((this.mSuperScrollListener != null) && (this.mViewTreeObserver != null))
    {
      if (this.mViewTreeObserver.isAlive()) {
        this.mViewTreeObserver.removeOnScrollChangedListener(this.mSuperScrollListener);
      }
      this.mViewTreeObserver = null;
    }
  }
  
  public void dismiss()
  {
    super.dismiss();
    unregisterListener();
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2)
  {
    super.showAsDropDown(paramView, paramInt1, paramInt2);
    registerListener(paramView);
  }
  
  public void showAtLocation(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.showAtLocation(paramView, paramInt1, paramInt2, paramInt3);
    unregisterListener();
  }
  
  public void update(View paramView, int paramInt1, int paramInt2)
  {
    super.update(paramView, paramInt1, paramInt2);
    registerListener(paramView);
  }
  
  public void update(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.update(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
    registerListener(paramView);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/actionbarsherlock/internal/widget/PopupWindowCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */