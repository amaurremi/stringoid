package com.ideashower.readitlater.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.ideashower.readitlater.util.a;
import com.ideashower.readitlater.util.j;

public class GSFImageView
  extends UrlImageView
{
  private int a;
  
  public GSFImageView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public GSFImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public GSFImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void b()
  {
    this.a = j.a(1.0F);
    setPadding(this.a, this.a, this.a, this.a);
    setPlaceHolder(2130837612);
    setBackgroundColor(getResources().getColor(2131165406));
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    if ((a.d()) && (paramDrawable != null) && ((paramDrawable instanceof BitmapDrawable)) && (((BitmapDrawable)paramDrawable).getBitmap().getConfig() == Bitmap.Config.ARGB_8888)) {
      paramDrawable.setDither(true);
    }
    super.setImageDrawable(paramDrawable);
  }
  
  public void setImageResource(int paramInt)
  {
    setImageBitmap(BitmapFactory.decodeResource(getResources(), paramInt, getBitmapOptions()));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/GSFImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */