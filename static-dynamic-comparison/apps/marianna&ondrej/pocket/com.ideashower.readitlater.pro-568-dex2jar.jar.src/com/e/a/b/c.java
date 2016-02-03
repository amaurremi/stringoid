package com.e.a.b;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c
  implements Closeable
{
  static final Pattern a = Pattern.compile("[a-z0-9_-]{1,64}");
  private static final OutputStream p = new OutputStream()
  {
    public void write(int paramAnonymousInt) {}
  };
  final ThreadPoolExecutor b;
  private final File c;
  private final File d;
  private final File e;
  private final File f;
  private final int g;
  private long h;
  private final int i;
  private long j;
  private Writer k;
  private final LinkedHashMap l;
  private int m;
  private long n;
  private final Callable o;
  
  private d a(String paramString, long paramLong)
  {
    for (;;)
    {
      d locald;
      try
      {
        d();
        d(paramString);
        f localf = (f)this.l.get(paramString);
        if (paramLong != -1L) {
          if (localf != null)
          {
            long l1 = f.e(localf);
            if (l1 == paramLong) {}
          }
          else
          {
            paramString = null;
            return paramString;
          }
        }
        if (localf == null)
        {
          localf = new f(this, paramString, null);
          this.l.put(paramString, localf);
          locald = new d(this, localf, null);
          f.a(localf, locald);
          this.k.write("DIRTY " + paramString + '\n');
          this.k.flush();
          paramString = locald;
          continue;
        }
        locald = f.a(localf);
      }
      finally {}
      if (locald != null) {
        paramString = null;
      }
    }
  }
  
  private void a(d paramd, boolean paramBoolean)
  {
    int i3 = 0;
    f localf;
    try
    {
      localf = d.a(paramd);
      if (f.a(localf) != paramd) {
        throw new IllegalStateException();
      }
    }
    finally {}
    int i2 = i3;
    if (paramBoolean)
    {
      i2 = i3;
      if (!f.d(localf))
      {
        int i1 = 0;
        for (;;)
        {
          i2 = i3;
          if (i1 >= this.i) {
            break;
          }
          if (d.b(paramd)[i1] == 0)
          {
            paramd.b();
            throw new IllegalStateException("Newly created entry didn't create value for index " + i1);
          }
          if (!localf.b(i1).exists())
          {
            paramd.b();
            return;
          }
          i1 += 1;
        }
      }
    }
    for (;;)
    {
      long l1;
      if (i2 < this.i)
      {
        paramd = localf.b(i2);
        if (paramBoolean)
        {
          if (paramd.exists())
          {
            File localFile = localf.a(i2);
            paramd.renameTo(localFile);
            l1 = f.b(localf)[i2];
            long l2 = localFile.length();
            f.b(localf)[i2] = l2;
            this.j = (this.j - l1 + l2);
          }
        }
        else {
          a(paramd);
        }
      }
      else
      {
        this.m += 1;
        f.a(localf, null);
        if ((f.d(localf) | paramBoolean))
        {
          f.a(localf, true);
          this.k.write("CLEAN " + f.c(localf) + localf.a() + '\n');
          if (paramBoolean)
          {
            l1 = this.n;
            this.n = (1L + l1);
            f.a(localf, l1);
          }
        }
        for (;;)
        {
          this.k.flush();
          if ((this.j <= this.h) && (!c())) {
            break;
          }
          this.b.submit(this.o);
          break;
          this.l.remove(f.c(localf));
          this.k.write("REMOVE " + f.c(localf) + '\n');
        }
      }
      i2 += 1;
    }
  }
  
  private static void a(File paramFile)
  {
    if ((paramFile.exists()) && (!paramFile.delete())) {
      throw new IOException();
    }
  }
  
  private static void a(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    if (paramBoolean) {
      a(paramFile2);
    }
    if (!paramFile1.renameTo(paramFile2)) {
      throw new IOException();
    }
  }
  
  private void b()
  {
    for (;;)
    {
      try
      {
        if (this.k != null) {
          this.k.close();
        }
        BufferedWriter localBufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.e), q.d));
        f localf;
        try
        {
          localBufferedWriter.write("libcore.io.DiskLruCache");
          localBufferedWriter.write("\n");
          localBufferedWriter.write("1");
          localBufferedWriter.write("\n");
          localBufferedWriter.write(Integer.toString(this.g));
          localBufferedWriter.write("\n");
          localBufferedWriter.write(Integer.toString(this.i));
          localBufferedWriter.write("\n");
          localBufferedWriter.write("\n");
          Iterator localIterator = this.l.values().iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          localf = (f)localIterator.next();
          if (f.a(localf) != null)
          {
            localBufferedWriter.write("DIRTY " + f.c(localf) + '\n');
            continue;
            localObject1 = finally;
          }
        }
        finally
        {
          localBufferedWriter.close();
        }
        ((Writer)localObject1).write("CLEAN " + f.c(localf) + localf.a() + '\n');
      }
      finally {}
    }
    ((Writer)localObject1).close();
    if (this.d.exists()) {
      a(this.d, this.f, true);
    }
    a(this.e, this.d, false);
    this.f.delete();
    this.k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.d, true), q.d));
  }
  
  private boolean c()
  {
    return (this.m >= 2000) && (this.m >= this.l.size());
  }
  
  private void d()
  {
    if (this.k == null) {
      throw new IllegalStateException("cache is closed");
    }
  }
  
  private void d(String paramString)
  {
    if (!a.matcher(paramString).matches()) {
      throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + paramString + "\"");
    }
  }
  
  private void e()
  {
    while (this.j > this.h) {
      c((String)((Map.Entry)this.l.entrySet().iterator().next()).getKey());
    }
  }
  
  public g a(String paramString)
  {
    label211:
    for (;;)
    {
      try
      {
        d();
        d(paramString);
        f localf = (f)this.l.get(paramString);
        if (localf == null)
        {
          paramString = null;
          return paramString;
        }
        if (!f.d(localf))
        {
          paramString = null;
        }
        else
        {
          InputStream[] arrayOfInputStream = new InputStream[this.i];
          int i1 = 0;
          try
          {
            if (i1 >= this.i) {
              continue;
            }
            arrayOfInputStream[i1] = new FileInputStream(localf.a(i1));
            i1 += 1;
            continue;
            if (arrayOfInputStream[i1] == null) {
              break label211;
            }
          }
          catch (FileNotFoundException paramString)
          {
            i1 = 0;
            if (i1 >= this.i) {
              break label211;
            }
          }
          q.a(arrayOfInputStream[i1]);
          i1 += 1;
          continue;
          this.m += 1;
          this.k.append("READ " + paramString + '\n');
          if (c()) {
            this.b.submit(this.o);
          }
          paramString = new g(this, paramString, f.e(localf), arrayOfInputStream, f.b(localf), null);
          continue;
          paramString = null;
        }
      }
      finally {}
    }
  }
  
  public d b(String paramString)
  {
    return a(paramString, -1L);
  }
  
  public boolean c(String paramString)
  {
    int i1 = 0;
    for (;;)
    {
      try
      {
        d();
        d(paramString);
        f localf = (f)this.l.get(paramString);
        Object localObject;
        if (localf != null)
        {
          localObject = f.a(localf);
          if (localObject == null) {}
        }
        else
        {
          bool = false;
          return bool;
          this.j -= f.b(localf)[i1];
          f.b(localf)[i1] = 0L;
          i1 += 1;
        }
        if (i1 < this.i)
        {
          localObject = localf.a(i1);
          if (((File)localObject).delete()) {
            continue;
          }
          throw new IOException("failed to delete " + localObject);
        }
      }
      finally {}
      this.m += 1;
      this.k.append("REMOVE " + paramString + '\n');
      this.l.remove(paramString);
      if (c()) {
        this.b.submit(this.o);
      }
      boolean bool = true;
    }
  }
  
  public void close()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = this.k;
        if (localObject1 == null) {
          return;
        }
        localObject1 = new ArrayList(this.l.values()).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          f localf = (f)((Iterator)localObject1).next();
          if (f.a(localf) == null) {
            continue;
          }
          f.a(localf).b();
          continue;
        }
        e();
      }
      finally {}
      this.k.close();
      this.k = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */