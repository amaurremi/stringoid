package com.badlogic.gdx.c;

import com.badlogic.gdx.e;
import com.badlogic.gdx.g;
import com.badlogic.gdx.utils.s;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class a
{
  protected File b;
  protected com.badlogic.gdx.f c;
  
  protected a() {}
  
  protected a(String paramString, com.badlogic.gdx.f paramf)
  {
    this.c = paramf;
    this.b = new File(paramString);
  }
  
  public InputStream a()
  {
    Object localObject;
    if ((this.c == com.badlogic.gdx.f.a) || ((this.c == com.badlogic.gdx.f.b) && (!f().exists())) || ((this.c == com.badlogic.gdx.f.e) && (!f().exists())))
    {
      InputStream localInputStream = a.class.getResourceAsStream("/" + this.b.getPath().replace('\\', '/'));
      localObject = localInputStream;
      if (localInputStream != null) {
        break label153;
      }
      throw new com.badlogic.gdx.utils.f("File not found: " + this.b + " (" + this.c + ")");
    }
    try
    {
      localObject = new FileInputStream(f());
      label153:
      return (InputStream)localObject;
    }
    catch (Exception localException)
    {
      if (f().isDirectory()) {
        throw new com.badlogic.gdx.utils.f("Cannot open a stream to a directory: " + this.b + " (" + this.c + ")", localException);
      }
      throw new com.badlogic.gdx.utils.f("Error reading file: " + this.b + " (" + this.c + ")", localException);
    }
  }
  
  public long b()
  {
    if ((this.c == com.badlogic.gdx.f.a) || ((this.c == com.badlogic.gdx.f.b) && (!this.b.exists())))
    {
      InputStream localInputStream = a();
      try
      {
        int i = localInputStream.available();
        long l = i;
        s.a(localInputStream);
        return l;
      }
      catch (Exception localException)
      {
        localException = localException;
        s.a(localInputStream);
        return 0L;
      }
      finally
      {
        localObject = finally;
        s.a(localInputStream);
        throw ((Throwable)localObject);
      }
    }
    return f().length();
  }
  
  public String c()
  {
    return this.b.getPath().replace('\\', '/');
  }
  
  public String d()
  {
    return this.b.getName();
  }
  
  public String e()
  {
    String str = this.b.getName();
    int i = str.lastIndexOf('.');
    if (i == -1) {
      return "";
    }
    return str.substring(i + 1);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof a)) {}
    do
    {
      return false;
      paramObject = (a)paramObject;
    } while ((this.c != ((a)paramObject).c) || (!c().equals(((a)paramObject).c())));
    return true;
  }
  
  public File f()
  {
    if (this.c == com.badlogic.gdx.f.c) {
      return new File(g.e.a(), this.b.getPath());
    }
    return this.b;
  }
  
  public byte[] g()
  {
    int j = (int)b();
    int i = j;
    if (j == 0) {
      i = 512;
    }
    Object localObject1 = new byte[i];
    InputStream localInputStream = a();
    i = 0;
    try
    {
      j = localInputStream.read((byte[])localObject1, i, localObject1.length - i);
      if (j == -1) {
        j = i;
      }
      int k;
      do
      {
        s.a(localInputStream);
        localObject3 = localObject1;
        if (j < localObject1.length)
        {
          localObject3 = new byte[j];
          System.arraycopy(localObject1, 0, localObject3, 0, j);
        }
        return (byte[])localObject3;
        i += j;
        if (i != localObject1.length) {
          break;
        }
        k = localInputStream.read();
        j = i;
      } while (k == -1);
      Object localObject3 = new byte[localObject1.length * 2];
      System.arraycopy(localObject1, 0, localObject3, 0, i);
      j = i + 1;
      localObject3[i] = ((byte)k);
      localObject1 = localObject3;
      i = j;
      for (;;)
      {
        break;
      }
    }
    catch (IOException localIOException)
    {
      throw new com.badlogic.gdx.utils.f("Error reading file: " + this, localIOException);
    }
    finally
    {
      s.a(localInputStream);
    }
  }
  
  public int hashCode()
  {
    return (this.c.hashCode() + 37) * 67 + c().hashCode();
  }
  
  public String toString()
  {
    return this.b.getPath().replace('\\', '/');
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */