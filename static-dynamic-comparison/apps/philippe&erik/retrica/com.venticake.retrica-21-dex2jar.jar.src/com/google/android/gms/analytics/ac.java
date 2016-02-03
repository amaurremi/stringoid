package com.google.android.gms.analytics;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

class ac
  implements ag
{
  private static ac a;
  private static final Object b = new Object();
  private final Context c;
  private String d;
  private boolean e = false;
  private final Object f = new Object();
  
  protected ac(Context paramContext)
  {
    this.c = paramContext;
    f();
  }
  
  public static ac a()
  {
    synchronized (b)
    {
      ac localac = a;
      return localac;
    }
  }
  
  public static void a(Context paramContext)
  {
    synchronized (b)
    {
      if (a == null) {
        a = new ac(paramContext);
      }
      return;
    }
  }
  
  private boolean c(String paramString)
  {
    try
    {
      aa.C("Storing clientId.");
      FileOutputStream localFileOutputStream = this.c.openFileOutput("gaClientId", 0);
      localFileOutputStream.write(paramString.getBytes());
      localFileOutputStream.close();
      return true;
    }
    catch (FileNotFoundException paramString)
    {
      aa.A("Error creating clientId file.");
      return false;
    }
    catch (IOException paramString)
    {
      aa.A("Error writing to clientId file.");
    }
    return false;
  }
  
  private String e()
  {
    if (!this.e) {}
    synchronized (this.f)
    {
      if (!this.e) {
        aa.C("Waiting for clientId to load");
      }
      try
      {
        do
        {
          this.f.wait();
        } while (!this.e);
        aa.C("Loaded clientId");
        return this.d;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          aa.A("Exception while waiting for clientId: " + localInterruptedException);
        }
      }
    }
  }
  
  private void f()
  {
    new Thread("client_id_fetcher")
    {
      public void run()
      {
        synchronized (ac.a(ac.this))
        {
          ac.a(ac.this, ac.this.d());
          ac.a(ac.this, true);
          ac.a(ac.this).notifyAll();
          return;
        }
      }
    }.start();
  }
  
  public String a(String paramString)
  {
    if ("&cid".equals(paramString)) {
      return e();
    }
    return null;
  }
  
  String b()
  {
    synchronized (this.f)
    {
      this.d = c();
      String str = this.d;
      return str;
    }
  }
  
  public boolean b(String paramString)
  {
    return "&cid".equals(paramString);
  }
  
  protected String c()
  {
    String str2 = UUID.randomUUID().toString().toLowerCase();
    String str1 = str2;
    try
    {
      if (!c(str2)) {
        str1 = "0";
      }
      return str1;
    }
    catch (Exception localException) {}
    return null;
  }
  
  String d()
  {
    localObject4 = null;
    Object localObject3 = null;
    for (;;)
    {
      try
      {
        localFileInputStream = this.c.openFileInput("gaClientId");
        localObject1 = new byte[''];
        i = localFileInputStream.read((byte[])localObject1, 0, 128);
        if (localFileInputStream.available() <= 0) {
          continue;
        }
        aa.A("clientId file seems corrupted, deleting it.");
        localFileInputStream.close();
        this.c.deleteFile("gaClientId");
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
          aa.C("Loaded client id from disk.");
        }
        catch (IOException localIOException2)
        {
          Object localObject2;
          continue;
        }
        catch (FileNotFoundException localFileNotFoundException3) {}
        localIOException1 = localIOException1;
        localObject2 = localObject4;
        aa.A("Error reading clientId file, deleting it.");
        this.c.deleteFile("gaClientId");
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
        localObject3 = c();
      }
      return (String)localObject3;
      if (i > 0) {
        continue;
      }
      aa.A("clientId file seems empty, deleting it.");
      localFileInputStream.close();
      this.c.deleteFile("gaClientId");
      localObject1 = localObject3;
    }
    localObject1 = new String((byte[])localObject1, 0, i);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/analytics/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */