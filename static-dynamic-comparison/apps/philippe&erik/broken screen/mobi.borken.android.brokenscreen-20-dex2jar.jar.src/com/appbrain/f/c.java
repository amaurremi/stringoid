package com.appbrain.f;

import android.content.Context;
import android.util.SparseArray;
import cmn.ac;
import cmn.ac.a;
import cmn.j;
import com.appbrain.b.g;
import com.appbrain.b.m;
import com.appbrain.c.a;
import com.appbrain.g.a.a;
import com.appbrain.g.a.a.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class c
{
  private static String b = "There was a network error, please try again.";
  protected Context a;
  private final d c = new d(new b());
  private ac d;
  private final List e = new ArrayList();
  
  protected c(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
  }
  
  protected a.a.a a(g paramg, String paramString)
  {
    a.a.a locala = a.a.H();
    locala.a(com.appbrain.b.c.a(paramg.b()));
    locala.a(paramString);
    locala.a(j.a(this.a).f());
    paramg = this.e.iterator();
    while (paramg.hasNext())
    {
      paramString = (a)paramg.next();
      m localm = paramString.a();
      if (localm != null)
      {
        locala.b(localm.a());
        locala.b(paramString.b());
      }
    }
    return locala;
  }
  
  protected final void a(ac.a parama)
  {
    this.d = new ac(parama);
  }
  
  protected byte[] b(g paramg, String paramString)
  {
    Object localObject = paramString;
    if (paramString.indexOf('$') != -1) {
      localObject = paramString.substring(paramString.lastIndexOf('$') + 1);
    }
    paramg = a(paramg, (String)localObject);
    paramg = this.d.a((String)localObject, this.c.a(paramg).b());
    if (paramg == null) {
      paramg = null;
    }
    while (paramg.b != null)
    {
      throw new a(paramg.b);
      localObject = a.a.a(paramg);
      this.c.a((a.a)localObject);
      paramg = b.a((a.a)localObject);
      if (((a.a)localObject).G() != 0)
      {
        if (((a.a)localObject).G() != ((a.a)localObject).F()) {
          throw new IllegalStateException("RPC extension count not matching " + ((a.a)localObject).G() + " " + ((a.a)localObject).F());
        }
        paramString = new SparseArray(((a.a)localObject).G());
        int i = 0;
        while (i < ((a.a)localObject).G())
        {
          paramString.put(((a.a)localObject).a(i), ((a.a)localObject).b(i));
          i += 1;
        }
        localObject = this.e.iterator();
        while (((Iterator)localObject).hasNext()) {
          paramString.get(((a)((Iterator)localObject).next()).b());
        }
      }
    }
    return paramg.a;
  }
  
  public static abstract interface a
  {
    public abstract m a();
    
    public abstract int b();
  }
  
  public static final class b
  {
    public final byte[] a;
    public final String b;
    
    private b(byte[] paramArrayOfByte, String paramString)
    {
      this.a = paramArrayOfByte;
      this.b = paramString;
    }
    
    public static b a(a.a parama)
    {
      String str = null;
      byte[] arrayOfByte;
      if (parama.u())
      {
        arrayOfByte = null;
        if (parama.q()) {
          if (parama.s().length() <= 0) {
            break label54;
          }
        }
      }
      label54:
      for (str = parama.s();; str = c.a())
      {
        return new b(arrayOfByte, str);
        arrayOfByte = parama.i().c();
        break;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/f/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */