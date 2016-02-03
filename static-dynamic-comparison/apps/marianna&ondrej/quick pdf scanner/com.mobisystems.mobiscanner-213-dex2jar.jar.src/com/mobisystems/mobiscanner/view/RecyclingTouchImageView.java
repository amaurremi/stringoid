package com.mobisystems.mobiscanner.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import com.mobisystems.mobiscanner.image.i;
import com.mobisystems.mobiscanner.image.j;
import com.mobisystems.photoimageview.TouchImageView;

public class RecyclingTouchImageView
  extends TouchImageView
{
  boolean aLX = false;
  
  public RecyclingTouchImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public RecyclingTouchImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RecyclingTouchImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private static void a(Drawable paramDrawable, boolean paramBoolean)
  {
    if ((paramDrawable instanceof i)) {
      ((i)paramDrawable).bp(paramBoolean);
    }
    for (;;)
    {
      return;
      if ((paramDrawable instanceof j))
      {
        ((j)paramDrawable).bp(paramBoolean);
        return;
      }
      if ((paramDrawable instanceof LayerDrawable))
      {
        paramDrawable = (LayerDrawable)paramDrawable;
        int i = 0;
        int j = paramDrawable.getNumberOfLayers();
        while (i < j)
        {
          a(paramDrawable.getDrawable(i), paramBoolean);
          i += 1;
        }
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    setImageDrawable(null);
    this.aLX = true;
    super.onDetachedFromWindow();
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    Drawable localDrawable = getDrawable();
    if (!this.aLX) {}
    for (;;)
    {
      try
      {
        super.setImageDrawable(paramDrawable);
        a(paramDrawable, true);
        i = 1;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        i = 0;
        continue;
      }
      if (i == 0)
      {
        a(paramDrawable, true);
        a(paramDrawable, false);
      }
      a(localDrawable, false);
      return;
      int i = 0;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/view/RecyclingTouchImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */