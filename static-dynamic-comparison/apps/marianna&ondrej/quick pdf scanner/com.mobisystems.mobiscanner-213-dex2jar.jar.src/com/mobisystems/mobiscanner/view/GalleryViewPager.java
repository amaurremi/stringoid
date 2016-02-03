package com.mobisystems.mobiscanner.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.jfeinstein.jazzyviewpager.JazzyViewPager;
import com.mobisystems.mobiscanner.common.d;
import com.mobisystems.photoimageview.TouchImageView;

public class GalleryViewPager
  extends JazzyViewPager
{
  private boolean aLw = true;
  
  public GalleryViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public GalleryViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected boolean a(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.aLw) {}
    for (boolean bool = true;; bool = false)
    {
      View localView = super.fF(F());
      if ((localView instanceof ViewGroup))
      {
        paramView = (TouchImageView)d.a((ViewGroup)localView, TouchImageView.class);
        if (paramView != null) {
          bool = paramView.canScrollHorizontally(paramInt1);
        }
        return bool;
      }
      return super.a(paramView, paramBoolean, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    if (this.aLw) {
      bool = super.onInterceptTouchEvent(paramMotionEvent);
    }
    return bool;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.aLw) {
      return super.onTouchEvent(paramMotionEvent);
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/view/GalleryViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */