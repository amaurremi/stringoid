package com.androidwasabi.ads;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.Map;

class ImageLoader$2
  implements Runnable
{
  ImageLoader$2(ImageLoader paramImageLoader, String paramString) {}
  
  public void run()
  {
    int i;
    if (ImageLoader.access$3(this.this$0)) {
      try
      {
        i = this.val$imageUrl.lastIndexOf('/');
        Object localObject1 = this.val$imageUrl.substring(i + 1);
        localObject1 = new File(ImageLoader.access$2(this.this$0), (String)localObject1);
        if (!((File)localObject1).exists()) {
          throw new IOException();
        }
      }
      catch (Exception localException1) {}
    }
    for (;;)
    {
      try
      {
        Object localObject2 = (HttpURLConnection)new URL(this.val$imageUrl).openConnection();
        ((HttpURLConnection)localObject2).setDoInput(true);
        ((HttpURLConnection)localObject2).connect();
        localObject4 = ((HttpURLConnection)localObject2).getInputStream();
        localObject2 = BitmapFactory.decodeStream((InputStream)localObject4);
        if (localObject4 != null) {
          ((InputStream)localObject4).close();
        }
        if (localObject2 != null) {
          break label373;
        }
        throw new Exception();
      }
      catch (Exception localException2)
      {
        localObject3 = (ImageLoader.ImageItem)ImageLoader.access$4(this.this$0).get(this.val$imageUrl);
        ((ImageLoader.ImageItem)localObject3).bitmap = null;
        ((ImageLoader.ImageItem)localObject3).loading = Boolean.valueOf(false);
        localObject4 = new Message();
        ((Message)localObject4).obj = localObject3;
        ImageLoader.access$5(this.this$0).sendMessage((Message)localObject4);
        return;
      }
      if (!((File)localObject3).canRead()) {
        throw new IOException();
      }
      long l = ((File)localObject3).lastModified();
      if (new Date().getTime() - l <= 1209600000L) {
        break;
      }
      ((File)localObject3).delete();
    }
    if (((File)localObject3).length() == 0L) {
      throw new IOException();
    }
    Object localObject4 = new BufferedInputStream(new FileInputStream((File)localObject3));
    Object localObject3 = BitmapFactory.decodeStream((InputStream)localObject4);
    if (localObject4 != null) {
      ((InputStream)localObject4).close();
    }
    localObject4 = (ImageLoader.ImageItem)ImageLoader.access$4(this.this$0).get(this.val$imageUrl);
    ((ImageLoader.ImageItem)localObject4).bitmap = ((Bitmap)localObject3);
    ((ImageLoader.ImageItem)localObject4).loading = Boolean.valueOf(false);
    localObject3 = new Message();
    ((Message)localObject3).obj = localObject4;
    ImageLoader.access$5(this.this$0).sendMessage((Message)localObject3);
    return;
    label373:
    boolean bool = ImageLoader.access$3(this.this$0);
    if (bool) {}
    try
    {
      i = this.val$imageUrl.lastIndexOf('/');
      localObject4 = this.val$imageUrl.substring(i + 1);
      localObject4 = new File(ImageLoader.access$2(this.this$0), (String)localObject4);
      if (((File)localObject4).exists()) {
        ((File)localObject4).delete();
      }
      localObject4 = new FileOutputStream((File)localObject4);
      ((Bitmap)localObject3).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject4);
      ((FileOutputStream)localObject4).flush();
      ((FileOutputStream)localObject4).close();
    }
    catch (Exception localException3)
    {
      for (;;)
      {
        Log.e("ImageLoader", localException3.toString());
      }
    }
    localObject4 = (ImageLoader.ImageItem)ImageLoader.access$4(this.this$0).get(this.val$imageUrl);
    ((ImageLoader.ImageItem)localObject4).bitmap = ((Bitmap)localObject3);
    ((ImageLoader.ImageItem)localObject4).loading = Boolean.valueOf(false);
    localObject3 = new Message();
    ((Message)localObject3).obj = localObject4;
    ImageLoader.access$5(this.this$0).sendMessage((Message)localObject3);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/ads/ImageLoader$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */