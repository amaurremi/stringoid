package com.mobisystems.mobiscanner.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.mobisystems.mobiscanner.image.i;

public class RecyclingImageView
  extends ImageView
{
  boolean aLX = false;
  
  public RecyclingImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public RecyclingImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private static void a(Drawable paramDrawable, boolean paramBoolean)
  {
    if ((paramDrawable instanceof i)) {
      ((i)paramDrawable).bp(paramBoolean);
    }
    for (;;)
    {
      return;
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
    if (!this.aLX)
    {
      super.setImageDrawable(paramDrawable);
      a(paramDrawable, true);
    }
    for (;;)
    {
      a(localDrawable, false);
      return;
      a(paramDrawable, true);
      a(paramDrawable, false);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/view/RecyclingImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */