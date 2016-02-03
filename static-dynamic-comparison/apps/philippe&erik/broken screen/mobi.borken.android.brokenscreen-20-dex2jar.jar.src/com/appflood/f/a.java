package com.appflood.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;

public class a
  extends View
{
  protected String a;
  protected String b;
  protected Bitmap c;
  
  public a(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void a(Bitmap paramBitmap)
  {
    this.c = paramBitmap;
    postInvalidate();
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
    postInvalidate();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appflood/f/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */