package com.chartboost.sdk.Libraries;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
{
  private static j a = new j();
  private static i b = new i(null);
  private static f c = new f(null);
  private static b d = new b(null);
  private static h e = new h(null);
  
  public static a a()
  {
    return b;
  }
  
  public static a a(a... paramVarArgs)
  {
    return new k(paramVarArgs);
  }
  
  public static a a(g... paramVarArgs)
  {
    return new d(paramVarArgs);
  }
  
  public static g a(String paramString, a parama)
  {
    return new g(paramString, parama);
  }
  
  public static abstract class a
  {
    private String a = null;
    
    public abstract String a();
    
    public abstract boolean a(Object paramObject);
    
    public boolean a(Object paramObject, StringBuilder paramStringBuilder)
    {
      boolean bool = a(paramObject);
      if (!bool) {
        if (this.a == null) {
          break label30;
        }
      }
      label30:
      for (paramObject = this.a;; paramObject = a())
      {
        paramStringBuilder.append((String)paramObject);
        return bool;
      }
    }
  }
  
  private static class b
    extends f.a
  {
    public String a()
    {
      return "object must be a boolean.";
    }
    
    public boolean a(Object paramObject)
    {
      return (Boolean.class.isInstance(paramObject)) || (Boolean.TYPE.isInstance(paramObject));
    }
  }
  
  public static abstract class c
    extends f.a
  {}
  
  private static class d
    extends f.a
  {
    protected f.g[] a;
    protected String b = null;
    
    public d(f.g[] paramArrayOfg)
    {
      this.a = paramArrayOfg;
    }
    
    public String a()
    {
      if (this.b != null) {
        return this.b;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("object must contain the following key-value schema: {\n");
      int i = 0;
      while (i < this.a.length)
      {
        localStringBuilder.append("<");
        localStringBuilder.append(f.g.a(this.a[i]));
        localStringBuilder.append(": [");
        localStringBuilder.append(f.g.b(this.a[i]).a());
        localStringBuilder.append("]>");
        if (i < this.a.length - 1) {
          localStringBuilder.append(",\n");
        }
        i += 1;
      }
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
    
    public boolean a(Object paramObject)
    {
      Object localObject1;
      Object localObject2;
      if ((paramObject instanceof Map))
      {
        paramObject = (Map)paramObject;
        localObject1 = ((Map)paramObject).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          if (!(((Map.Entry)localObject2).getKey() instanceof String)) {
            this.b = ("key '" + ((Map.Entry)localObject2).getKey().toString() + "' is not a string");
          }
        }
      }
      int i;
      while (!(paramObject instanceof JSONObject))
      {
        return false;
        if ((this.a != null) && (this.a.length >= 1))
        {
          i = 0;
          while (i < this.a.length)
          {
            localObject1 = f.g.a(this.a[i]);
            localObject2 = f.g.b(this.a[i]);
            if (!((Map)paramObject).containsKey(localObject1))
            {
              if (!((f.a)localObject2).a(null))
              {
                this.b = ("no key for required mapping '" + (String)localObject1 + "' : <" + ((f.a)localObject2).a() + ">");
                return false;
              }
            }
            else if (!((f.a)localObject2).a(((Map)paramObject).get(localObject1)))
            {
              this.b = ("key '" + (String)localObject1 + "' fails to match: <" + ((f.a)localObject2).a() + ">");
              return false;
            }
            i += 1;
          }
        }
        return true;
      }
      paramObject = (JSONObject)paramObject;
      if ((this.a != null) && (this.a.length >= 1))
      {
        i = 0;
        while (i < this.a.length)
        {
          localObject1 = f.g.a(this.a[i]);
          localObject2 = f.g.b(this.a[i]);
          try
          {
            if (!((f.a)localObject2).a(((JSONObject)paramObject).get((String)localObject1)))
            {
              this.b = ("key '" + (String)localObject1 + "' fails to match: <" + ((f.a)localObject2).a() + ">");
              return false;
            }
          }
          catch (JSONException localJSONException)
          {
            if (!((f.a)localObject2).a(null))
            {
              this.b = ("no key for required mapping '" + (String)localObject1 + "' : <" + ((f.a)localObject2).a() + ">");
              return false;
            }
            i += 1;
          }
        }
      }
      return true;
    }
  }
  
  private static class e
    extends f.a
  {
    private Class<?> a;
    
    public e(Class<?> paramClass)
    {
      this.a = paramClass;
    }
    
    public String a()
    {
      return "object must be an instance of " + this.a.getName() + ".";
    }
    
    public boolean a(Object paramObject)
    {
      return this.a.isInstance(paramObject);
    }
  }
  
  private static class f
    extends f.a
  {
    public String a()
    {
      return "object must be a number w/o decimals (int, long, short, or byte).";
    }
    
    public boolean a(Object paramObject)
    {
      return (Integer.class.isInstance(paramObject)) || (Long.class.isInstance(paramObject)) || (Short.class.isInstance(paramObject)) || (Byte.class.isInstance(paramObject)) || (BigInteger.class.isInstance(paramObject)) || (Integer.TYPE.isInstance(paramObject)) || (Long.TYPE.isInstance(paramObject)) || (Short.TYPE.isInstance(paramObject)) || (Byte.TYPE.isInstance(paramObject));
    }
  }
  
  public static class g
  {
    private String a;
    private f.a b;
    
    public g(String paramString, f.a parama)
    {
      this.a = paramString;
      this.b = parama;
    }
  }
  
  private static class h
    extends f.a
  {
    public String a()
    {
      return "object must be null.";
    }
    
    public boolean a(Object paramObject)
    {
      return (paramObject == null) || (paramObject == JSONObject.NULL);
    }
  }
  
  private static class i
    extends f.a
  {
    public String a()
    {
      return "object must be a number (primitive type or derived from Number).";
    }
    
    public boolean a(Object paramObject)
    {
      return ((paramObject instanceof Number)) || (Integer.TYPE.isInstance(paramObject)) || (Long.TYPE.isInstance(paramObject)) || (Short.TYPE.isInstance(paramObject)) || (Float.TYPE.isInstance(paramObject)) || (Double.TYPE.isInstance(paramObject)) || (Byte.TYPE.isInstance(paramObject));
    }
  }
  
  private static class j
    extends f.e
  {
    public j()
    {
      super();
    }
  }
  
  private static class k
    extends f.a
  {
    protected String a = null;
    private f.a[] b;
    
    public k(f.a[] paramArrayOfa)
    {
      this.b = paramArrayOfa;
    }
    
    public String a()
    {
      if (this.a != null) {
        return this.a;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("object must match ALL of the following: ");
      int i = 0;
      while (i < this.b.length)
      {
        localStringBuilder.append("<");
        localStringBuilder.append(this.b[i].a());
        localStringBuilder.append(">");
        if (i < this.b.length - 1) {
          localStringBuilder.append(", ");
        }
        i += 1;
      }
      return localStringBuilder.toString();
    }
    
    public boolean a(Object paramObject)
    {
      int i = 0;
      while (i < this.b.length)
      {
        if (!this.b[i].a(paramObject))
        {
          this.a = ("object failed to match: <" + this.b[i].a() + ">");
          return false;
        }
        i += 1;
      }
      return true;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/Libraries/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */