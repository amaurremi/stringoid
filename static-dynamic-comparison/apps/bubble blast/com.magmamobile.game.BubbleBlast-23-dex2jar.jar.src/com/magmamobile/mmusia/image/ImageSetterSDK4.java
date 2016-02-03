package com.magmamobile.mmusia.image;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class ImageSetterSDK4
{
  public static void setImage(Drawable paramDrawable, ImageView paramImageView)
  {
    try
    {
      paramDrawable = ((BitmapDrawable)paramDrawable).getBitmap();
      paramDrawable.setDensity(160);
      paramImageView.setImageBitmap(paramDrawable);
      return;
    }
    catch (Exception paramDrawable)
    {
      paramDrawable.printStackTrace();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/mmusia/image/ImageSetterSDK4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */