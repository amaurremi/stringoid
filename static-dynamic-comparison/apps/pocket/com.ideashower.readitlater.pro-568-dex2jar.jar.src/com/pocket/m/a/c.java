package com.pocket.m.a;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.h.a;
import com.ideashower.readitlater.h.i;
import com.ideashower.readitlater.util.e;
import java.io.File;
import java.io.IOException;

public class c
{
  private final String a;
  private final String b;
  private final String c;
  private final String d;
  private final String e;
  private final String f;
  private final String g;
  private final String h;
  private final String i;
  private final String j;
  private final String k;
  private final boolean l;
  
  public c()
  {
    this("RIL_offline", true);
  }
  
  public c(String paramString, boolean paramBoolean)
  {
    Object localObject;
    long l1;
    if ((paramBoolean) && (i.a(a.W))) {
      if ((paramBoolean) && ("mounted".equals(Environment.getExternalStorageState())))
      {
        localObject = new StatFs(Environment.getDataDirectory().getPath());
        l1 = ((StatFs)localObject).getAvailableBlocks();
        l1 = ((StatFs)localObject).getBlockSize() * l1;
        if (l1 < 78643200L)
        {
          paramBoolean = bool1;
          localObject = i.b();
          if (!paramBoolean) {
            ((com.ideashower.readitlater.h.l)localObject).a(a.L, false);
          }
          ((com.ideashower.readitlater.h.l)localObject).a(a.W, false);
          ((com.ideashower.readitlater.h.l)localObject).a();
          label117:
          this.l = paramBoolean;
          this.a = File.separator;
          this.k = g.c().getFilesDir().getAbsolutePath();
          this.i = (this.k + this.a + paramString);
          this.j = (Environment.getExternalStorageDirectory().toString() + "/Android/data/" + g.c().getPackageName() + "/files");
          this.h = (this.j + this.a + paramString);
          if (!this.l) {
            break label490;
          }
          this.b = this.j;
        }
      }
    }
    for (this.c = this.h;; this.c = this.i)
    {
      this.d = (this.b + this.a + "RIL_clean_up");
      this.e = (this.c + this.a + "RIL_pages");
      this.f = (this.c + this.a + "RIL_assets");
      this.g = (this.b + this.a + "RIL_temp");
      if ((this.l) && (!i.a(a.M))) {
        f();
      }
      return;
      localObject = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
      long l2 = ((StatFs)localObject).getAvailableBlocks();
      paramBoolean = bool1;
      if (((StatFs)localObject).getBlockSize() * l2 >= l1) {
        break;
      }
      paramBoolean = false;
      break;
      if (paramBoolean)
      {
        paramBoolean = bool2;
        if (i.a(a.L)) {
          break label117;
        }
      }
      paramBoolean = false;
      break label117;
      label490:
      this.b = this.k;
    }
  }
  
  public static String c(String paramString)
  {
    if ("mounted".equals(Environment.getExternalStorageState())) {
      return Environment.getExternalStorageDirectory().toString() + "/Android/data/" + g.c().getPackageName() + "/files/" + paramString + ".jpg";
    }
    return null;
  }
  
  public String a()
  {
    return this.c;
  }
  
  public String a(int paramInt)
  {
    return this.e + this.a + paramInt;
  }
  
  public String a(String paramString)
  {
    return new File(this.g + this.a + l.b(paramString)).toString();
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    paramString = new File(paramString).listFiles();
    if (paramString != null)
    {
      int m = 0;
      while (m < paramString.length)
      {
        String str = paramString[m].getAbsolutePath();
        if ((paramString[m].isDirectory()) && ((paramBoolean) || (str.indexOf("RIL_clean_up") != -1))) {
          l.a(paramString[m]);
        }
        m += 1;
      }
    }
  }
  
  public String b()
  {
    return "RIL_assets";
  }
  
  public String b(int paramInt)
  {
    return a(paramInt) + this.a + "web.html";
  }
  
  public String b(String paramString)
  {
    return "file://" + paramString;
  }
  
  public String c()
  {
    return this.f;
  }
  
  public String c(int paramInt)
  {
    return "file://" + b(paramInt);
  }
  
  public String d(int paramInt)
  {
    return a(paramInt) + this.a + "text.html";
  }
  
  public void d()
  {
    int n = i.a(a.ae) + 1;
    int m = n;
    if (n > 9000) {
      m = 0;
    }
    i.b().a(a.ae, m).a();
    if (!new File(this.c).renameTo(new File(this.d + String.valueOf(m)))) {}
  }
  
  public String e(int paramInt)
  {
    return "file://" + d(paramInt);
  }
  
  public void e()
  {
    String str;
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      str = this.j;
      if (this.l) {
        break label44;
      }
    }
    label44:
    for (boolean bool = true;; bool = false)
    {
      a(str, bool);
      a(this.k, this.l);
      return;
    }
  }
  
  protected void f()
  {
    new File(this.c).mkdirs();
    try
    {
      File localFile = new File(this.b, ".nomedia");
      if ((new File(this.b, ".nomedia").createNewFile()) || (localFile.exists())) {
        i.b().a(a.M, true).a();
      }
      return;
    }
    catch (IOException localIOException)
    {
      e.a(localIOException);
    }
  }
  
  public boolean g()
  {
    return this.l;
  }
  
  public boolean h()
  {
    if (!this.l) {}
    for (Object localObject = Environment.getDataDirectory();; localObject = Environment.getExternalStorageDirectory())
    {
      localObject = new StatFs(((File)localObject).getPath());
      long l1 = ((StatFs)localObject).getAvailableBlocks();
      if (((StatFs)localObject).getBlockSize() * l1 > 2097152L) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public int i()
  {
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      if (new File(this.c).exists()) {
        return 1;
      }
      return 3;
    }
    return 2;
  }
  
  public String j()
  {
    if (this.l) {
      return g.a(2131493527);
    }
    return g.a(2131493526);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/m/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */