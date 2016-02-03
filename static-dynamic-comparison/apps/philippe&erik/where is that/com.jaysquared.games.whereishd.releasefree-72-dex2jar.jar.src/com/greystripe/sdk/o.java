package com.greystripe.sdk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore.Images.Media;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

final class o
  extends Thread
{
  o(m paramm, String paramString) {}
  
  public final void run()
  {
    try
    {
      Object localObject3 = new URL(this.a);
      Object localObject2 = ((URL)localObject3).openConnection();
      ((URLConnection)localObject2).setUseCaches(false);
      ((URLConnection)localObject2).getContentLength();
      int i = ((URL)localObject3).toString().lastIndexOf('/');
      Object localObject1 = "gsImage.bin";
      if (i >= 0) {
        localObject1 = ((URL)localObject3).toString().substring(i + 1);
      }
      localObject1 = new File(c.o(this.b.a).getFilesDir(), (String)localObject1);
      localObject2 = new BufferedInputStream(((URLConnection)localObject2).getInputStream());
      localObject3 = new FileOutputStream((File)localObject1);
      BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream((OutputStream)localObject3, 512);
      byte[] arrayOfByte = new byte['Ȁ'];
      while (!isInterrupted())
      {
        i = ((BufferedInputStream)localObject2).read(arrayOfByte, 0, arrayOfByte.length);
        if (i < 0) {
          break;
        }
        localBufferedOutputStream.write(arrayOfByte, 0, i);
      }
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      localMalformedURLException.printStackTrace();
      return;
      localBufferedOutputStream.close();
      ((FileOutputStream)localObject3).close();
      ((BufferedInputStream)localObject2).close();
      if ((!isInterrupted()) && (MediaStore.Images.Media.insertImage(c.o(this.b.a).getContentResolver(), localMalformedURLException.getPath(), "", "") != null))
      {
        c.o(this.b.a).sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED", Uri.parse("file://" + Environment.getExternalStorageDirectory())));
        this.b.a.f();
      }
      localMalformedURLException.delete();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/greystripe/sdk/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */