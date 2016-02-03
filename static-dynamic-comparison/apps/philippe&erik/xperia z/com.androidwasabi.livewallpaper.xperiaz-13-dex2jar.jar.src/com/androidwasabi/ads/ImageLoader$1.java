package com.androidwasabi.ads;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

class ImageLoader$1
  extends Handler
{
  ImageLoader$1(ImageLoader paramImageLoader) {}
  
  public void handleMessage(Message paramMessage)
  {
    try
    {
      paramMessage = (ImageLoader.ImageItem)paramMessage.obj;
      paramMessage.loading = Boolean.valueOf(false);
      if (paramMessage.bitmap != null)
      {
        if (ImageLoader.access$0(this.this$0) != null) {
          ImageLoader.access$0(this.this$0).onImageLoaded(paramMessage.bitmap, paramMessage.data);
        }
      }
      else if (ImageLoader.access$0(this.this$0) != null)
      {
        ImageLoader.access$0(this.this$0).onImageFailed();
        return;
      }
    }
    catch (Exception paramMessage)
    {
      Log.e("ImageLoader", paramMessage.toString());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/ads/ImageLoader$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */