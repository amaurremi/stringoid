package com.vungle.publisher.image;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.IOException;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AssetBitmapFactory
  extends BaseBitmapFactory
{
  @Inject
  Context a;
  
  public Bitmap getBitmap(String paramString)
    throws IOException
  {
    return BitmapFactory.decodeStream(this.a.getAssets().open(paramString), null, getOptions(this.a));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/image/AssetBitmapFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */