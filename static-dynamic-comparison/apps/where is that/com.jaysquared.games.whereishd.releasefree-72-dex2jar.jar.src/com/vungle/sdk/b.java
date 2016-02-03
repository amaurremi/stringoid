package com.vungle.sdk;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.IOException;

final class b
  implements VungleBitmapFactory
{
  public static b a()
  {
    return a.a;
  }
  
  public final Bitmap getBitmap(String paramString)
    throws IOException
  {
    return BitmapFactory.decodeStream(ak.e().getAssets().open(paramString));
  }
  
  static final class a
  {
    static final b a = new b((byte)0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/vungle/sdk/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */