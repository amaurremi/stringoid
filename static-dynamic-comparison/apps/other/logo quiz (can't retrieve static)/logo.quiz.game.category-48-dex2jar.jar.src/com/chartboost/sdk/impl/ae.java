package com.chartboost.sdk.impl;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SimpleTimeZone;
import java.util.UUID;
import java.util.regex.Pattern;

public class ae
{
  public static ag a()
  {
    ac localac = b();
    localac.a(Date.class, new i(localac));
    localac.a(ax.class, new g(localac));
    localac.a(ay.class, new h(null));
    localac.a(byte[].class, new h(null));
    return localac;
  }
  
  static ac b()
  {
    ac localac = new ac();
    localac.a(Object[].class, new m(localac));
    localac.a(Boolean.class, new q(null));
    localac.a(az.class, new a(localac));
    localac.a(ba.class, new b(localac));
    localac.a(z.class, new d(localac));
    localac.a(aa.class, new e(localac));
    localac.a(Iterable.class, new f(localac));
    localac.a(Map.class, new j(localac));
    localac.a(bb.class, new k(localac));
    localac.a(bc.class, new l(localac));
    localac.a(Number.class, new q(null));
    localac.a(bd.class, new n(localac));
    localac.a(Pattern.class, new o(localac));
    localac.a(String.class, new p(null));
    localac.a(UUID.class, new r(localac));
    return localac;
  }
  
  private static class a
    extends ae.c
  {
    a(ag paramag)
    {
      super();
    }
    
    public void a(Object paramObject, StringBuilder paramStringBuilder)
    {
      paramObject = (az)paramObject;
      x localx = new x();
      localx.a("$code", ((az)paramObject).a());
      this.a.a(localx, paramStringBuilder);
    }
  }
  
  private static class b
    extends ae.c
  {
    b(ag paramag)
    {
      super();
    }
    
    public void a(Object paramObject, StringBuilder paramStringBuilder)
    {
      paramObject = (ba)paramObject;
      x localx = new x();
      localx.a("$code", ((ba)paramObject).a());
      localx.a("$scope", ((ba)paramObject).b());
      this.a.a(localx, paramStringBuilder);
    }
  }
  
  private static abstract class c
    extends ab
  {
    protected final ag a;
    
    c(ag paramag)
    {
      this.a = paramag;
    }
  }
  
  private static class d
    extends ae.c
  {
    d(ag paramag)
    {
      super();
    }
    
    public void a(Object paramObject, StringBuilder paramStringBuilder)
    {
      paramStringBuilder.append("{ ");
      paramObject = (z)paramObject;
      Iterator localIterator = ((z)paramObject).keySet().iterator();
      int i = 1;
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (i != 0) {
          i = 0;
        }
        for (;;)
        {
          ad.a(paramStringBuilder, str);
          paramStringBuilder.append(" : ");
          this.a.a(((z)paramObject).a(str), paramStringBuilder);
          break;
          paramStringBuilder.append(" , ");
        }
      }
      paramStringBuilder.append("}");
    }
  }
  
  private static class e
    extends ae.c
  {
    e(ag paramag)
    {
      super();
    }
    
    public void a(Object paramObject, StringBuilder paramStringBuilder)
    {
      paramObject = (aa)paramObject;
      x localx = new x();
      localx.a("$ref", ((aa)paramObject).b());
      localx.a("$id", ((aa)paramObject).a());
      this.a.a(localx, paramStringBuilder);
    }
  }
  
  private static class f
    extends ae.c
  {
    f(ag paramag)
    {
      super();
    }
    
    public void a(Object paramObject, StringBuilder paramStringBuilder)
    {
      int i = 1;
      paramStringBuilder.append("[ ");
      paramObject = ((Iterable)paramObject).iterator();
      if (((Iterator)paramObject).hasNext())
      {
        Object localObject = ((Iterator)paramObject).next();
        if (i != 0) {
          i = 0;
        }
        for (;;)
        {
          this.a.a(localObject, paramStringBuilder);
          break;
          paramStringBuilder.append(" , ");
        }
      }
      paramStringBuilder.append("]");
    }
  }
  
  private static class g
    extends ae.c
  {
    g(ag paramag)
    {
      super();
    }
    
    public void a(Object paramObject, StringBuilder paramStringBuilder)
    {
      paramObject = (ax)paramObject;
      x localx = new x();
      localx.a("$ts", Integer.valueOf(((ax)paramObject).a()));
      localx.a("$inc", Integer.valueOf(((ax)paramObject).b()));
      this.a.a(localx, paramStringBuilder);
    }
  }
  
  private static class h
    extends ab
  {
    public void a(Object paramObject, StringBuilder paramStringBuilder)
    {
      paramStringBuilder.append("<Binary Data>");
    }
  }
  
  private static class i
    extends ae.c
  {
    i(ag paramag)
    {
      super();
    }
    
    public void a(Object paramObject, StringBuilder paramStringBuilder)
    {
      paramObject = (Date)paramObject;
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
      localSimpleDateFormat.setCalendar(new GregorianCalendar(new SimpleTimeZone(0, "GMT")));
      this.a.a(new x("$date", localSimpleDateFormat.format((Date)paramObject)), paramStringBuilder);
    }
  }
  
  private static class j
    extends ae.c
  {
    j(ag paramag)
    {
      super();
    }
    
    public void a(Object paramObject, StringBuilder paramStringBuilder)
    {
      paramStringBuilder.append("{ ");
      paramObject = ((Map)paramObject).entrySet().iterator();
      int i = 1;
      if (((Iterator)paramObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)paramObject).next();
        if (i != 0) {
          i = 0;
        }
        for (;;)
        {
          ad.a(paramStringBuilder, localEntry.getKey().toString());
          paramStringBuilder.append(" : ");
          this.a.a(localEntry.getValue(), paramStringBuilder);
          break;
          paramStringBuilder.append(" , ");
        }
      }
      paramStringBuilder.append("}");
    }
  }
  
  private static class k
    extends ae.c
  {
    k(ag paramag)
    {
      super();
    }
    
    public void a(Object paramObject, StringBuilder paramStringBuilder)
    {
      this.a.a(new x("$maxKey", Integer.valueOf(1)), paramStringBuilder);
    }
  }
  
  private static class l
    extends ae.c
  {
    l(ag paramag)
    {
      super();
    }
    
    public void a(Object paramObject, StringBuilder paramStringBuilder)
    {
      this.a.a(new x("$minKey", Integer.valueOf(1)), paramStringBuilder);
    }
  }
  
  private static class m
    extends ae.c
  {
    m(ag paramag)
    {
      super();
    }
    
    public void a(Object paramObject, StringBuilder paramStringBuilder)
    {
      paramStringBuilder.append("[ ");
      int i = 0;
      while (i < Array.getLength(paramObject))
      {
        if (i > 0) {
          paramStringBuilder.append(" , ");
        }
        this.a.a(Array.get(paramObject, i), paramStringBuilder);
        i += 1;
      }
      paramStringBuilder.append("]");
    }
  }
  
  private static class n
    extends ae.c
  {
    n(ag paramag)
    {
      super();
    }
    
    public void a(Object paramObject, StringBuilder paramStringBuilder)
    {
      this.a.a(new x("$oid", paramObject.toString()), paramStringBuilder);
    }
  }
  
  private static class o
    extends ae.c
  {
    o(ag paramag)
    {
      super();
    }
    
    public void a(Object paramObject, StringBuilder paramStringBuilder)
    {
      x localx = new x();
      localx.a("$regex", paramObject.toString());
      if (((Pattern)paramObject).flags() != 0) {
        localx.a("$options", y.a(((Pattern)paramObject).flags()));
      }
      this.a.a(localx, paramStringBuilder);
    }
  }
  
  private static class p
    extends ab
  {
    public void a(Object paramObject, StringBuilder paramStringBuilder)
    {
      ad.a(paramStringBuilder, (String)paramObject);
    }
  }
  
  private static class q
    extends ab
  {
    public void a(Object paramObject, StringBuilder paramStringBuilder)
    {
      paramStringBuilder.append(paramObject.toString());
    }
  }
  
  private static class r
    extends ae.c
  {
    r(ag paramag)
    {
      super();
    }
    
    public void a(Object paramObject, StringBuilder paramStringBuilder)
    {
      paramObject = (UUID)paramObject;
      x localx = new x();
      localx.a("$uuid", ((UUID)paramObject).toString());
      this.a.a(localx, paramStringBuilder);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/impl/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */