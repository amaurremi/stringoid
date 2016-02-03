package com.pocket.m.b;

import android.util.SparseArray;
import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.g.m;
import com.ideashower.readitlater.util.e;
import com.pocket.p.i;
import com.pocket.p.j;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class b
  extends m
{
  private final File b;
  private final o c;
  private boolean d;
  private String e;
  
  private b(a parama, File paramFile, o paramo, boolean paramBoolean)
  {
    this.b = paramFile;
    this.c = paramo;
    this.d = paramBoolean;
  }
  
  private SparseArray a(o paramo)
  {
    SparseArray localSparseArray = null;
    if (paramo != null) {
      localSparseArray = paramo.W();
    }
    paramo = localSparseArray;
    if (localSparseArray == null)
    {
      paramo = localSparseArray;
      if (a.b(this.a) != null) {
        paramo = com.pocket.m.a.b(a.b(this.a));
      }
    }
    return paramo;
  }
  
  private String a(String paramString, o paramo)
  {
    Object localObject1 = paramString.replaceAll("(?i)<title.*/title>", "<title></title>");
    Object localObject2 = a(paramo);
    paramString = (String)localObject1;
    int j;
    int i;
    if (localObject2 != null)
    {
      paramString = (String)localObject1;
      if (((SparseArray)localObject2).size() > 0)
      {
        j = ((SparseArray)localObject2).size();
        i.a();
        i = 0;
        paramString = (String)localObject1;
        if (i < j)
        {
          paramString = (com.ideashower.readitlater.e.a)((SparseArray)localObject2).valueAt(i);
          if (this.d)
          {
            j localj = i.a(paramString);
            if (localj == null) {
              break label575;
            }
            a.a(this.a).add(localj);
            paramString = ((String)localObject1).replaceFirst(String.format("<div[^>]*id=\"RIL_IMG_%s\"[^>]*></div>", new Object[] { Integer.valueOf(paramString.b()) }), "IMG_" + localj.a);
          }
        }
      }
    }
    for (;;)
    {
      i += 1;
      localObject1 = paramString;
      break;
      paramString = ((String)localObject1).replaceFirst(String.format("<div[^>]*id=\"RIL_IMG_%s\"[^>]*></div>", new Object[] { Integer.valueOf(paramString.b()) }), "<img src=" + paramString.a() + "/>");
      continue;
      localObject1 = b(paramo);
      paramo = paramString;
      if (localObject1 != null)
      {
        paramo = paramString;
        if (((SparseArray)localObject1).size() > 0)
        {
          j = ((SparseArray)localObject1).size();
          i = 0;
          while (i < j)
          {
            localObject2 = (com.ideashower.readitlater.e.b)((SparseArray)localObject1).valueAt(i);
            switch (((com.ideashower.readitlater.e.b)localObject2).d())
            {
            default: 
              i += 1;
              break;
            case 1: 
            case 2: 
            case 3: 
            case 4: 
              for (paramo = "http://www.youtube.com/watch?v=" + ((com.ideashower.readitlater.e.b)localObject2).c();; paramo = "http://www.vimeo.com/" + ((com.ideashower.readitlater.e.b)localObject2).c())
              {
                paramString = paramString.replaceFirst(String.format("<div[^>]*id=\"RIL_VIDEO_%s\"[^>]*></div>", new Object[] { Integer.valueOf(((com.ideashower.readitlater.e.b)localObject2).b()) }), String.format("<p>See Video: <a href='%s'>%s</a></p>", new Object[] { paramo, paramo }));
                break;
              }
            }
          }
          paramo = paramString;
        }
      }
      if (this.d) {}
      for (paramString = Pattern.compile("<([a-z0-9]+)(?<!img)(?<!a) [^>]*>", 2);; paramString = Pattern.compile("<([a-z0-9]+)(?<!img) [^>]*>", 2))
      {
        paramString = paramString.matcher(paramo);
        paramo = new StringBuffer();
        while (paramString.find()) {
          paramString.appendReplacement(paramo, "<" + paramString.group(1) + ">");
        }
      }
      paramString.appendTail(paramo);
      paramString = paramo.toString();
      paramString = Pattern.compile("<(br|hr)>", 2).matcher(paramString);
      paramo = new StringBuffer();
      while (paramString.find()) {
        paramString.appendReplacement(paramo, "<" + paramString.group(1) + "/>");
      }
      paramString.appendTail(paramo);
      return paramo.toString().replaceAll("(?i)</?div>", "");
      label575:
      paramString = (String)localObject1;
    }
  }
  
  private SparseArray b(o paramo)
  {
    SparseArray localSparseArray = null;
    if (paramo != null) {
      localSparseArray = paramo.V();
    }
    paramo = localSparseArray;
    if (localSparseArray == null) {
      paramo = com.pocket.m.a.c(a.b(this.a));
    }
    return paramo;
  }
  
  protected void a()
  {
    if (!this.b.exists()) {
      return;
    }
    try
    {
      this.e = a(org.apache.a.b.b.e(this.b), this.c);
      return;
    }
    catch (IOException localIOException)
    {
      e.a(localIOException);
    }
  }
  
  protected void a(boolean paramBoolean, Throwable paramThrowable)
  {
    if (this.k.get()) {
      return;
    }
    a.a(this.a, paramBoolean, this.e);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/m/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */