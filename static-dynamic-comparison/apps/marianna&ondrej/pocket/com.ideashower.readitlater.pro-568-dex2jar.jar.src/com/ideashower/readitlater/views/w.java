package com.ideashower.readitlater.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;

public class w
  extends ImageView
{
  public w(Context paramContext)
  {
    super(paramContext);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    Object localObject = getDrawable();
    if ((localObject != null) && ((localObject instanceof BitmapDrawable)))
    {
      localObject = ((BitmapDrawable)getDrawable()).getBitmap();
      if (localObject != null) {
        ((Bitmap)localObject).recycle();
      }
    }
    super.setImageBitmap(paramBitmap);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */