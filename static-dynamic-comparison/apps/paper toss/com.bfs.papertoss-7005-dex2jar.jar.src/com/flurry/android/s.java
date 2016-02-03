package com.flurry.android;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

final class s
  extends LinearLayout
{
  public s(CatalogActivity paramCatalogActivity, Context paramContext)
  {
    super(paramContext);
    setBackgroundColor(-1);
    AdImage localAdImage = CatalogActivity.c(paramCatalogActivity).l();
    if (localAdImage != null)
    {
      paramCatalogActivity = new ImageView(paramContext);
      paramCatalogActivity.setId(10000);
      byte[] arrayOfByte = localAdImage.e;
      if (arrayOfByte != null) {
        paramCatalogActivity.setImageBitmap(BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length));
      }
      r.a(paramContext, paramCatalogActivity, r.a(paramContext, localAdImage.b), r.a(paramContext, localAdImage.c));
      paramContext = new LinearLayout.LayoutParams(-2, -2);
      paramContext.setMargins(0, 0, 0, -3);
      setGravity(3);
      addView(paramCatalogActivity, paramContext);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/flurry/android/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */