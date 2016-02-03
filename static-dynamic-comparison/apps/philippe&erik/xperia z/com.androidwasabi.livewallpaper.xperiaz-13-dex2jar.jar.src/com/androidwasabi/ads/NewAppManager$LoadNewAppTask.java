package com.androidwasabi.ads;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import com.google.gson.Gson;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

class NewAppManager$LoadNewAppTask
  extends AsyncTask<String, Void, Boolean>
{
  private Bitmap downloadImageFile(String paramString)
  {
    if (NewAppManager.access$5()) {
      try
      {
        Object localObject1 = paramString.substring(paramString.lastIndexOf('/') + 1);
        localObject1 = new File(NewAppManager.access$6(), (String)localObject1);
        if (!((File)localObject1).exists()) {
          throw new IOException();
        }
      }
      catch (Exception localException) {}
    }
    Bitmap localBitmap;
    try
    {
      Object localObject2 = (HttpURLConnection)new URL(paramString).openConnection();
      ((HttpURLConnection)localObject2).setDoInput(true);
      ((HttpURLConnection)localObject2).connect();
      localObject2 = ((HttpURLConnection)localObject2).getInputStream();
      localBitmap = BitmapFactory.decodeStream((InputStream)localObject2);
      if (localObject2 != null) {
        ((InputStream)localObject2).close();
      }
      boolean bool = NewAppManager.access$5();
      localObject2 = localBitmap;
      if (bool) {}
      for (;;)
      {
        try
        {
          paramString = paramString.substring(paramString.lastIndexOf('/') + 1);
          paramString = new File(NewAppManager.access$6(), paramString);
          if (paramString.exists()) {
            paramString.delete();
          }
          paramString = new FileOutputStream(paramString);
          localBitmap.compress(Bitmap.CompressFormat.PNG, 100, paramString);
          paramString.flush();
          paramString.close();
          localObject2 = localBitmap;
          return (Bitmap)localObject2;
        }
        catch (Exception paramString)
        {
          long l;
          BufferedInputStream localBufferedInputStream;
          Log.e("NewAppManager", paramString.toString());
          return localBitmap;
        }
        if (!((File)localObject2).canRead()) {
          throw new IOException();
        }
        l = ((File)localObject2).lastModified();
        if (new Date().getTime() - l > 1209600000L)
        {
          ((File)localObject2).delete();
          break;
        }
        localBufferedInputStream = new BufferedInputStream(new FileInputStream((File)localObject2));
        localBitmap = BitmapFactory.decodeStream(localBufferedInputStream);
        localObject2 = localBitmap;
        if (localBufferedInputStream != null)
        {
          localBufferedInputStream.close();
          return localBitmap;
        }
      }
    }
    catch (Exception paramString) {}
    return null;
  }
  
  private String retrieveStreamString(String paramString)
  {
    Object localObject = new DefaultHttpClient();
    paramString = new HttpGet(paramString);
    try
    {
      localObject = ((DefaultHttpClient)localObject).execute(paramString);
      if (((HttpResponse)localObject).getStatusLine().getStatusCode() != 200) {
        return null;
      }
      localObject = EntityUtils.toString(((HttpResponse)localObject).getEntity(), "UTF-8");
      return (String)localObject;
    }
    catch (IOException localIOException)
    {
      paramString.abort();
    }
    return null;
  }
  
  protected Boolean doInBackground(String... paramVarArgs)
  {
    try
    {
      Object localObject;
      int i;
      if (NewAppManager.access$0().getLong("app_request_time", 0L) <= System.currentTimeMillis())
      {
        paramVarArgs = retrieveStreamString(paramVarArgs[0]);
        if (paramVarArgs != null)
        {
          localObject = NewAppManager.access$0().edit();
          ((SharedPreferences.Editor)localObject).putString("app_cache", paramVarArgs);
          ((SharedPreferences.Editor)localObject).putLong("app_request_time", System.currentTimeMillis() + 86400000L);
          ((SharedPreferences.Editor)localObject).commit();
          NewAppManager.access$1((NewAppManager.AppItem[])new Gson().fromJson(paramVarArgs, NewAppManager.AppItem[].class));
          i = 0;
        }
      }
      for (;;)
      {
        if (i >= NewAppManager.access$2().length)
        {
          return Boolean.valueOf(true);
          paramVarArgs = NewAppManager.access$0().edit();
          paramVarArgs.putString("app_cache", "");
          paramVarArgs.putLong("app_request_time", System.currentTimeMillis() + 86400000L);
          paramVarArgs.commit();
          return Boolean.valueOf(false);
          localObject = NewAppManager.access$0().getString("app_cache", "");
          paramVarArgs = (String[])localObject;
          if (!((String)localObject).equals("")) {
            break;
          }
          return Boolean.valueOf(false);
        }
        paramVarArgs = NewAppManager.access$2()[i];
        paramVarArgs.bitmap = downloadImageFile(paramVarArgs.image);
        i += 1;
      }
      return Boolean.valueOf(false);
    }
    catch (Exception paramVarArgs) {}
  }
  
  protected void onPostExecute(Boolean paramBoolean)
  {
    if ((!paramBoolean.booleanValue()) || (NewAppManager.access$3() != null)) {}
    try
    {
      NewAppManager.access$3().loaded(NewAppManager.access$2());
      for (;;)
      {
        NewAppManager.access$4(false);
        return;
        if (NewAppManager.access$3() != null) {
          try
          {
            NewAppManager.access$3().failToLoad();
          }
          catch (Exception paramBoolean) {}
        }
      }
    }
    catch (Exception paramBoolean)
    {
      for (;;) {}
    }
  }
  
  protected void onPreExecute() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/ads/NewAppManager$LoadNewAppTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */