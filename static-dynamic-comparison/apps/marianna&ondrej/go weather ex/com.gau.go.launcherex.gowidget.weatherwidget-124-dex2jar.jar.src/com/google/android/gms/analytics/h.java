package com.google.android.gms.analytics;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

class h
  implements m
{
  private static final Object sf = new Object();
  private static h st;
  private final Context mContext;
  private String su;
  private boolean sv = false;
  private final Object sw = new Object();
  
  protected h(Context paramContext)
  {
    this.mContext = paramContext;
    ce();
  }
  
  private boolean D(String paramString)
  {
    try
    {
      aa.y("Storing clientId.");
      FileOutputStream localFileOutputStream = this.mContext.openFileOutput("gaClientId", 0);
      localFileOutputStream.write(paramString.getBytes());
      localFileOutputStream.close();
      return true;
    }
    catch (FileNotFoundException paramString)
    {
      aa.w("Error creating clientId file.");
      return false;
    }
    catch (IOException paramString)
    {
      aa.w("Error writing to clientId file.");
    }
    return false;
  }
  
  public static h cb()
  {
    synchronized (sf)
    {
      h localh = st;
      return localh;
    }
  }
  
  private String cc()
  {
    if (!this.sv) {}
    synchronized (this.sw)
    {
      if (!this.sv) {
        aa.y("Waiting for clientId to load");
      }
      try
      {
        do
        {
          this.sw.wait();
        } while (!this.sv);
        aa.y("Loaded clientId");
        return this.su;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          aa.w("Exception while waiting for clientId: " + localInterruptedException);
        }
      }
    }
  }
  
  private void ce()
  {
    new Thread("client_id_fetcher")
    {
      public void run()
      {
        synchronized (h.a(h.this))
        {
          h.a(h.this, h.this.cf());
          h.a(h.this, true);
          h.a(h.this).notifyAll();
          return;
        }
      }
    }.start();
  }
  
  public static void n(Context paramContext)
  {
    synchronized (sf)
    {
      if (st == null) {
        st = new h(paramContext);
      }
      return;
    }
  }
  
  public boolean C(String paramString)
  {
    return "&cid".equals(paramString);
  }
  
  protected String cd()
  {
    String str2 = UUID.randomUUID().toString().toLowerCase();
    String str1 = str2;
    try
    {
      if (!D(str2)) {
        str1 = "0";
      }
      return str1;
    }
    catch (Exception localException) {}
    return null;
  }
  
  String cf()
  {
    localObject4 = null;
    Object localObject3 = null;
    for (;;)
    {
      try
      {
        localFileInputStream = this.mContext.openFileInput("gaClientId");
        localObject1 = new byte[''];
        i = localFileInputStream.read((byte[])localObject1, 0, 128);
        if (localFileInputStream.available() <= 0) {
          continue;
        }
        aa.w("clientId file seems corrupted, deleting it.");
        localFileInputStream.close();
        this.mContext.deleteFile("gaClientId");
        localObject1 = localObject3;
      }
      catch (IOException localIOException1)
      {
        try
        {
          FileInputStream localFileInputStream;
          Object localObject1;
          int i;
          localFileInputStream.close();
        }
        catch (IOException localIOException2)
        {
          Object localObject2;
          continue;
        }
        catch (FileNotFoundException localFileNotFoundException3) {}
        localIOException1 = localIOException1;
        localObject2 = localObject4;
        aa.w("Error reading clientId file, deleting it.");
        this.mContext.deleteFile("gaClientId");
        continue;
        continue;
      }
      catch (FileNotFoundException localFileNotFoundException1)
      {
        FileNotFoundException localFileNotFoundException2 = localFileNotFoundException3;
        continue;
      }
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = cd();
      }
      return (String)localObject3;
      if (i > 0) {
        continue;
      }
      aa.w("clientId file seems empty, deleting it.");
      localFileInputStream.close();
      this.mContext.deleteFile("gaClientId");
      localObject1 = localObject3;
    }
    localObject1 = new String((byte[])localObject1, 0, i);
  }
  
  public String getValue(String paramString)
  {
    if ("&cid".equals(paramString)) {
      return cc();
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/analytics/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */