package com.pocket.list.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;

public class c
{
  public final Bitmap a;
  public final Drawable b;
  public final Drawable c;
  
  public c(Context paramContext)
  {
    paramContext = paramContext.getResources();
    this.b = paramContext.getDrawable(2130837770);
    this.b.setBounds(0, 0, this.b.getIntrinsicWidth(), this.b.getIntrinsicHeight());
    this.c = paramContext.getDrawable(2130837771);
    this.c.setBounds(0, 0, this.c.getIntrinsicWidth(), this.c.getIntrinsicHeight());
    this.a = BitmapFactory.decodeResource(paramContext, 2130837914);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/list/widget/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */