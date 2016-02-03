package com.google.android.gms.analytics;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

class h
  implements l
{
  private static h xQ;
  private static final Object xz = new Object();
  private final Context mContext;
  private String xR;
  private boolean xS = false;
  private final Object xT = new Object();
  
  protected h(Context paramContext)
  {
    this.mContext = paramContext;
    dV();
  }
  
  private boolean ad(String paramString)
  {
    try
    {
      z.V("Storing clientId.");
      FileOutputStream localFileOutputStream = this.mContext.openFileOutput("gaClientId", 0);
      localFileOutputStream.write(paramString.getBytes());
      localFileOutputStream.close();
      return true;
    }
    catch (FileNotFoundException paramString)
    {
      z.T("Error creating clientId file.");
      return false;
    }
    catch (IOException paramString)
    {
      z.T("Error writing to clientId file.");
    }
    return false;
  }
  
  public static h dR()
  {
    synchronized (xz)
    {
      h localh = xQ;
      return localh;
    }
  }
  
  private String dT()
  {
    if (!this.xS) {}
    synchronized (this.xT)
    {
      if (!this.xS) {
        z.V("Waiting for clientId to load");
      }
      try
      {
        do
        {
          this.xT.wait();
        } while (!this.xS);
        z.V("Loaded clientId");
        return this.xR;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          z.T("Exception while waiting for clientId: " + localInterruptedException);
        }
      }
    }
  }
  
  private void dV()
  {
    new Thread("client_id_fetcher")
    {
      public void run()
      {
        synchronized (h.a(h.this))
        {
          h.a(h.this, h.this.dW());
          h.a(h.this, true);
          h.a(h.this).notifyAll();
          return;
        }
      }
    }.start();
  }
  
  public static void y(Context paramContext)
  {
    synchronized (xz)
    {
      if (xQ == null) {
        xQ = new h(paramContext);
      }
      return;
    }
  }
  
  public boolean ac(String paramString)
  {
    return "&cid".equals(paramString);
  }
  
  String dS()
  {
    synchronized (this.xT)
    {
      this.xR = dU();
      String str = this.xR;
      return str;
    }
  }
  
  protected String dU()
  {
    String str2 = UUID.randomUUID().toString().toLowerCase();
    String str1 = str2;
    try
    {
      if (!ad(str2)) {
        str1 = "0";
      }
      return str1;
    }
    catch (Exception localException) {}
    return null;
  }
  
  String dW()
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
        z.T("clientId file seems corrupted, deleting it.");
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
          z.V("Loaded client id from disk.");
        }
        catch (IOException localIOException2)
        {
          Object localObject2;
          continue;
        }
        catch (FileNotFoundException localFileNotFoundException3) {}
        localIOException1 = localIOException1;
        localObject2 = localObject4;
        z.T("Error reading clientId file, deleting it.");
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
        localObject3 = dU();
      }
      return (String)localObject3;
      if (i > 0) {
        continue;
      }
      z.T("clientId file seems empty, deleting it.");
      localFileInputStream.close();
      this.mContext.deleteFile("gaClientId");
      localObject1 = localObject3;
    }
    localObject1 = new String((byte[])localObject1, 0, i);
  }
  
  public String getValue(String paramString)
  {
    if ("&cid".equals(paramString)) {
      return dT();
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/analytics/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */