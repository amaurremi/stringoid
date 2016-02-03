package com.androidwasabi.ads;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

class ImageLoader$SaveImageCacheTask
  extends AsyncTask<String[], Void, Boolean>
{
  private ImageLoader$SaveImageCacheTask(ImageLoader paramImageLoader) {}
  
  private Boolean downloadImageFile(String paramString)
  {
    try
    {
      Object localObject1 = paramString.substring(paramString.lastIndexOf('/') + 1);
      localObject1 = new File(ImageLoader.access$2(this.this$0), (String)localObject1);
      if (!((File)localObject1).exists()) {
        throw new IOException();
      }
    }
    catch (Exception localException)
    {
      try
      {
        for (;;)
        {
          Object localObject2 = (HttpURLConnection)new URL(paramString).openConnection();
          ((HttpURLConnection)localObject2).setDoInput(true);
          ((HttpURLConnection)localObject2).connect();
          InputStream localInputStream = ((HttpURLConnection)localObject2).getInputStream();
          localObject2 = BitmapFactory.decodeStream(localInputStream);
          if (localInputStream != null) {
            localInputStream.close();
          }
          try
          {
            paramString = paramString.substring(paramString.lastIndexOf('/') + 1);
            paramString = new File(ImageLoader.access$2(this.this$0), paramString);
            if (paramString.exists()) {
              paramString.delete();
            }
            paramString = new FileOutputStream(paramString);
            ((Bitmap)localObject2).compress(Bitmap.CompressFormat.PNG, 100, paramString);
            paramString.flush();
            paramString.close();
            return Boolean.valueOf(true);
          }
          catch (Exception paramString)
          {
            long l;
            Log.e("ImageLoader", paramString.toString());
            return Boolean.valueOf(false);
          }
          if (!((File)localObject2).canRead()) {
            throw new IOException();
          }
          if (((File)localObject2).length() == 0L) {
            throw new IOException();
          }
          l = ((File)localObject2).lastModified();
          if (new Date().getTime() - l <= 1209600000L) {
            break;
          }
          ((File)localObject2).delete();
        }
        return Boolean.valueOf(true);
      }
      catch (Exception paramString) {}
    }
    return Boolean.valueOf(false);
  }
  
  protected Boolean doInBackground(String[]... paramVarArgs)
  {
    paramVarArgs = paramVarArgs[0];
    int i = 0;
    try
    {
      for (;;)
      {
        if (i >= paramVarArgs.length) {
          return Boolean.valueOf(true);
        }
        downloadImageFile(paramVarArgs[i]);
        i += 1;
      }
      return Boolean.valueOf(false);
    }
    catch (Exception paramVarArgs) {}
  }
  
  protected void onPostExecute(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue()) {
      if (ImageLoader.access$1(this.this$0) != null) {
        ImageLoader.access$1(this.this$0).onImageCacheLoaded();
      }
    }
    while (ImageLoader.access$1(this.this$0) == null) {
      return;
    }
    ImageLoader.access$1(this.this$0).onImageCacheFailed();
  }
  
  protected void onPreExecute() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/ads/ImageLoader$SaveImageCacheTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */