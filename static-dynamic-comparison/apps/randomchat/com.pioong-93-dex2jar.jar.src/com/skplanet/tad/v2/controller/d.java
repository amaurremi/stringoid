package com.skplanet.tad.v2.controller;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.skplanet.tad.common.a;
import com.skplanet.tad.controller.d.a;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;

public class d
  extends AsyncTask
{
  private com.skplanet.tad.controller.d a;
  private d.a b = d.a.a;
  
  public d(com.skplanet.tad.controller.d paramd)
  {
    this.a = paramd;
  }
  
  private Bitmap[] a(String[] paramArrayOfString)
    throws ClientProtocolException, IllegalArgumentException, IOException, Throwable
  {
    Bitmap[] arrayOfBitmap = new Bitmap[paramArrayOfString.length];
    int i = 0;
    if (i >= arrayOfBitmap.length) {
      return arrayOfBitmap;
    }
    System.setProperty("http.keepAlive", "false");
    Object localObject = new DefaultHttpClient();
    if ((paramArrayOfString[i] == null) || (TextUtils.isEmpty(paramArrayOfString[i]))) {
      a.d("AdImageLoader.download(), urls[i] == null || TextUtils.isEmpty(urls[i])");
    }
    for (;;)
    {
      i += 1;
      break;
      HttpGet localHttpGet = new HttpGet(paramArrayOfString[i]);
      localHttpGet.addHeader("Connection", "close");
      a.c("AdImageLoader.download(), urls[i]:" + paramArrayOfString[i]);
      HttpConnectionParams.setConnectionTimeout(localHttpGet.getParams(), 10000);
      HttpConnectionParams.setSoTimeout(localHttpGet.getParams(), 10000);
      a.c("AdImageLoader.download(), before execute");
      localObject = ((DefaultHttpClient)localObject).execute(localHttpGet);
      a.c("AdImageLoader.download(), after execute");
      if (localObject == null)
      {
        a.d("AdImageLoader.download(), response == null");
        return null;
      }
      if (((HttpResponse)localObject).getStatusLine().getStatusCode() != 200)
      {
        a.d("AdImageLoader.download(), response.getStatusLine().getStatusCode() != 200");
        return null;
      }
      arrayOfBitmap[i] = BitmapFactory.decodeStream(new BufferedHttpEntity(((HttpResponse)localObject).getEntity()).getContent());
    }
  }
  
  protected void a(Bitmap[] paramArrayOfBitmap)
  {
    if (this.a != null)
    {
      if (paramArrayOfBitmap == null) {
        this.a.a(this.b);
      }
    }
    else {
      return;
    }
    this.a.a(paramArrayOfBitmap);
  }
  
  protected Bitmap[] a(String[]... paramVarArgs)
  {
    Bitmap[] arrayOfBitmap = (Bitmap[])null;
    try
    {
      paramVarArgs = a(paramVarArgs[0]);
      return paramVarArgs;
    }
    catch (ClientProtocolException paramVarArgs)
    {
      a.d("AdImageLoader.doInBackground(), ClientProtocolException");
      this.b = d.a.b;
      return arrayOfBitmap;
    }
    catch (IllegalArgumentException paramVarArgs)
    {
      a.d("AdImageLoader.doInBackground(), IllegalArgumentException");
      this.b = d.a.b;
      return arrayOfBitmap;
    }
    catch (IOException paramVarArgs)
    {
      a.d("AdImageLoader.doInBackground(), IOException");
      this.b = d.a.b;
      return arrayOfBitmap;
    }
    catch (Throwable paramVarArgs)
    {
      a.d("AdImageLoader.doInBackground(), Throwable");
      this.b = d.a.b;
    }
    return arrayOfBitmap;
  }
  
  protected void onPreExecute() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/v2/controller/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */