package com.google.analytics.tracking.android;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

class g
  implements j
{
  private static final Object hT = new Object();
  private static g hU;
  private String hV;
  private boolean hW = false;
  private final Object hX = new Object();
  private final Context mContext;
  
  protected g(Context paramContext)
  {
    this.mContext = paramContext;
    jv();
  }
  
  public static void d(Context paramContext)
  {
    synchronized (hT)
    {
      if (hU == null) {
        hU = new g(paramContext);
      }
      return;
    }
  }
  
  public static g js()
  {
    synchronized (hT)
    {
      g localg = hU;
      return localg;
    }
  }
  
  private String jt()
  {
    if (!this.hW) {}
    synchronized (this.hX)
    {
      if (!this.hW) {
        v.C("Waiting for clientId to load");
      }
      try
      {
        do
        {
          this.hX.wait();
        } while (!this.hW);
        v.C("Loaded clientId");
        return this.hV;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          v.A("Exception while waiting for clientId: " + localInterruptedException);
        }
      }
    }
  }
  
  private void jv()
  {
    new Thread("client_id_fetcher")
    {
      public void run()
      {
        synchronized (g.a(g.this))
        {
          g.a(g.this, g.this.jw());
          g.a(g.this, true);
          g.a(g.this).notifyAll();
          return;
        }
      }
    }.start();
  }
  
  private boolean n(String paramString)
  {
    try
    {
      v.C("Storing clientId.");
      FileOutputStream localFileOutputStream = this.mContext.openFileOutput("gaClientId", 0);
      localFileOutputStream.write(paramString.getBytes());
      localFileOutputStream.close();
      return true;
    }
    catch (FileNotFoundException paramString)
    {
      v.A("Error creating clientId file.");
      return false;
    }
    catch (IOException paramString)
    {
      v.A("Error writing to clientId file.");
    }
    return false;
  }
  
  public String getValue(String paramString)
  {
    if ("&cid".equals(paramString)) {
      return jt();
    }
    return null;
  }
  
  protected String ju()
  {
    String str2 = UUID.randomUUID().toString().toLowerCase();
    String str1 = str2;
    if (!n(str2)) {
      str1 = "0";
    }
    return str1;
  }
  
  String jw()
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
        v.A("clientId file seems corrupted, deleting it.");
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
        v.A("Error reading clientId file, deleting it.");
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
        localObject3 = ju();
      }
      return (String)localObject3;
      if (i > 0) {
        continue;
      }
      v.A("clientId file seems empty, deleting it.");
      localFileInputStream.close();
      this.mContext.deleteFile("gaClientId");
      localObject1 = localObject3;
    }
    localObject1 = new String((byte[])localObject1, 0, i);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/analytics/tracking/android/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */