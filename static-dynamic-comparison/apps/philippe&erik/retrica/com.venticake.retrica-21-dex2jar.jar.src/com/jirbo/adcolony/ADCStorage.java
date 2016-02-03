package com.jirbo.adcolony;

import android.app.Activity;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;

public class ADCStorage
{
  d a;
  String b;
  String c;
  String d;
  File e;
  File f;
  
  ADCStorage(d paramd)
  {
    this.a = paramd;
  }
  
  double a(String paramString)
  {
    try
    {
      paramString = new StatFs(paramString);
      long l = paramString.getBlockSize();
      int i = paramString.getAvailableBlocks();
      return i * l;
    }
    catch (RuntimeException paramString) {}
    return 0.0D;
  }
  
  void a()
  {
    l.a.b("Configuring storage");
    int j = 1;
    int i = j;
    if (d() != null)
    {
      i = j;
      if (a(d()) > a(c()) + 1048576.0D)
      {
        i = j;
        if (a(c()) < 3.145728E7D) {
          i = 0;
        }
      }
    }
    if (i != 0)
    {
      l.b.b("Using internal storage:");
      this.b = (c() + "/adc/");
    }
    for (;;)
    {
      this.c = (this.b + "media/");
      l.a.b(this.c);
      this.e = new File(this.c);
      if (!this.e.isDirectory())
      {
        this.e.delete();
        this.e.mkdirs();
      }
      if (this.e.isDirectory()) {
        break;
      }
      a.a("Cannot create media folder.");
      return;
      this.b = (d() + "/.adc2/" + ab.d() + "/");
      l.b.b("Using external storage:");
    }
    if (a(this.c) < 2.097152E7D)
    {
      a.a("Not enough space to store temporary files (" + a(this.c) + " bytes available).");
      return;
    }
    this.d = (c() + "/adc/data/");
    if (a.n == 0) {
      this.d = (this.b + "data/");
    }
    l.a.a("Internal data path: ").b(this.d);
    this.f = new File(this.d);
    if (!this.f.isDirectory()) {
      this.f.delete();
    }
    this.f.mkdirs();
  }
  
  void b()
  {
    if ((this.e == null) || (this.f == null)) {
      return;
    }
    if (!this.e.isDirectory()) {
      this.e.delete();
    }
    if (!this.f.isDirectory()) {
      this.f.delete();
    }
    this.e.mkdirs();
    this.f.mkdirs();
  }
  
  String c()
  {
    return AdColony.activity().getFilesDir().getAbsolutePath();
  }
  
  String d()
  {
    if ("mounted".equals(Environment.getExternalStorageState())) {
      return Environment.getExternalStorageDirectory().getAbsolutePath();
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/ADCStorage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */