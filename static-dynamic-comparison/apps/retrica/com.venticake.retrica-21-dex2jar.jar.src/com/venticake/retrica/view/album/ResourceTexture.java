package com.venticake.retrica.view.album;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import java.io.IOException;
import java.io.InputStream;

public final class ResourceTexture
  extends Texture
{
  private final int mResourceId;
  private final boolean mScaled;
  
  public ResourceTexture(int paramInt, boolean paramBoolean)
  {
    this.mResourceId = paramInt;
    this.mScaled = paramBoolean;
  }
  
  public boolean isCached()
  {
    return true;
  }
  
  protected Bitmap load(RenderView paramRenderView)
  {
    BitmapFactory.Options localOptions = null;
    if (this.mScaled)
    {
      localOptions = new BitmapFactory.Options();
      localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
      paramRenderView = BitmapFactory.decodeResource(paramRenderView.getResources(), this.mResourceId, localOptions);
    }
    do
    {
      return paramRenderView;
      localInputStream = paramRenderView.getResources().openRawResource(this.mResourceId);
      paramRenderView = localOptions;
    } while (localInputStream == null);
    try
    {
      paramRenderView = new BitmapFactory.Options();
      paramRenderView.inPreferredConfig = Bitmap.Config.ARGB_8888;
      paramRenderView = BitmapFactory.decodeStream(localInputStream, null, paramRenderView);
      try
      {
        localInputStream.close();
        return paramRenderView;
      }
      catch (IOException localIOException1)
      {
        return paramRenderView;
      }
      try
      {
        localInputStream.close();
        throw paramRenderView;
      }
      catch (IOException localIOException2)
      {
        for (;;) {}
      }
    }
    catch (Exception paramRenderView)
    {
      paramRenderView = paramRenderView;
      try
      {
        localInputStream.close();
        return null;
      }
      catch (IOException paramRenderView)
      {
        return null;
      }
    }
    finally
    {
      paramRenderView = finally;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/ResourceTexture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */