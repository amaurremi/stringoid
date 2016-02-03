package com.mobisystems.photoimageview;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class GalleryViewPager
  extends ViewPager
{
  private boolean aLw = true;
  
  public GalleryViewPager(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GalleryViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected boolean a(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.aLw) {
      return true;
    }
    if ((paramView instanceof TouchImageView)) {
      return ((TouchImageView)paramView).canScrollHorizontally(paramInt1);
    }
    return super.a(paramView, paramBoolean, paramInt1, paramInt2, paramInt3);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.aLw) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.aLw) {
      return super.onTouchEvent(paramMotionEvent);
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/photoimageview/GalleryViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */