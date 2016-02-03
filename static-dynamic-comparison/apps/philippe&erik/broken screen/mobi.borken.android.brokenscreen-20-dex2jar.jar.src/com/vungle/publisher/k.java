package com.vungle.publisher;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class k
  implements Cloneable
{
  static final l f = new e();
  static final l g = new c();
  private static Class[] l = { Float.TYPE, Float.class, Double.TYPE, Integer.TYPE, Double.class, Integer.class };
  private static Class[] m = { Integer.TYPE, Integer.class, Float.TYPE, Double.TYPE, Float.class, Double.class };
  private static Class[] n = { Double.TYPE, Double.class, Float.TYPE, Integer.TYPE, Float.class, Integer.class };
  private static final HashMap<Class, HashMap<String, Method>> o = new HashMap();
  private static final HashMap<Class, HashMap<String, Method>> p = new HashMap();
  String a;
  protected p b;
  Method c = null;
  Class d;
  public h e = null;
  final ReentrantReadWriteLock h = new ReentrantReadWriteLock();
  final Object[] i = new Object[1];
  public l j;
  private Method k = null;
  private Object q;
  
  private k(p paramp)
  {
    this.b = paramp;
    if (paramp != null) {
      this.a = paramp.a;
    }
  }
  
  private k(String paramString)
  {
    this.a = paramString;
  }
  
  public static k a(p<?, Float> paramp, float... paramVarArgs)
  {
    return new a(paramp, paramVarArgs);
  }
  
  public static k a(p<?, Integer> paramp, int... paramVarArgs)
  {
    return new b(paramp, paramVarArgs);
  }
  
  public static k a(String paramString, float... paramVarArgs)
  {
    return new a(paramString, paramVarArgs);
  }
  
  public static k a(String paramString, int... paramVarArgs)
  {
    return new b(paramString, paramVarArgs);
  }
  
  private Method a(Class paramClass1, String paramString, Class paramClass2)
  {
    Method localMethod1 = null;
    Object localObject = this.a;
    String str = paramString;
    if (localObject != null) {
      if (((String)localObject).length() != 0) {
        break label42;
      }
    }
    label42:
    char c1;
    for (str = paramString;; str = paramString + c1 + str)
    {
      if (paramClass2 != null) {
        break label143;
      }
      try
      {
        paramString = paramClass1.getMethod(str, null);
        return paramString;
      }
      catch (NoSuchMethodException paramString) {}
      c1 = Character.toUpperCase(((String)localObject).charAt(0));
      str = ((String)localObject).substring(1);
    }
    try
    {
      paramClass1 = paramClass1.getDeclaredMethod(str, null);
      try
      {
        paramClass1.setAccessible(true);
        return paramClass1;
      }
      catch (NoSuchMethodException paramClass2) {}
    }
    catch (NoSuchMethodException paramClass1)
    {
      for (;;)
      {
        label143:
        int i2;
        int i1;
        Class localClass;
        label313:
        paramClass1 = null;
      }
    }
    Log.e("PropertyValuesHolder", "Couldn't find no-arg method for property " + this.a + ": " + paramString);
    return paramClass1;
    localObject = new Class[1];
    if (this.d.equals(Float.class))
    {
      paramString = l;
      i2 = paramString.length;
      i1 = 0;
      paramClass2 = localMethod1;
    }
    for (;;)
    {
      if (i1 >= i2) {
        break label313;
      }
      localClass = paramString[i1];
      localObject[0] = localClass;
      try
      {
        localMethod1 = paramClass1.getMethod(str, (Class[])localObject);
        paramClass2 = localMethod1;
        this.d = localClass;
        return localMethod1;
      }
      catch (NoSuchMethodException localNoSuchMethodException1)
      {
        try
        {
          Method localMethod2 = paramClass1.getDeclaredMethod(str, (Class[])localObject);
          paramClass2 = localMethod2;
          localMethod2.setAccessible(true);
          paramClass2 = localMethod2;
          this.d = localClass;
          return localMethod2;
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
          i1 += 1;
        }
      }
      if (this.d.equals(Integer.class))
      {
        paramString = m;
        break;
      }
      if (this.d.equals(Double.class))
      {
        paramString = n;
        break;
      }
      paramString = new Class[1];
      paramString[0] = this.d;
      break;
    }
    Log.e("PropertyValuesHolder", "Couldn't find setter/getter for property " + this.a + " with value type " + this.d);
    return paramClass2;
  }
  
  private Method a(Class paramClass1, HashMap<Class, HashMap<String, Method>> paramHashMap, String paramString, Class paramClass2)
  {
    Method localMethod1 = null;
    try
    {
      this.h.writeLock().lock();
      HashMap localHashMap = (HashMap)paramHashMap.get(paramClass1);
      if (localHashMap != null) {
        localMethod1 = (Method)localHashMap.get(this.a);
      }
      Method localMethod2 = localMethod1;
      if (localMethod1 == null)
      {
        localMethod2 = a(paramClass1, paramString, paramClass2);
        paramString = localHashMap;
        if (localHashMap == null)
        {
          paramString = new HashMap();
          paramHashMap.put(paramClass1, paramString);
        }
        paramString.put(this.a, localMethod2);
      }
      return localMethod2;
    }
    finally
    {
      this.h.writeLock().unlock();
    }
  }
  
  public k a()
  {
    try
    {
      k localk = (k)super.clone();
      localk.a = this.a;
      localk.b = this.b;
      localk.e = this.e.a();
      localk.j = this.j;
      return localk;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  void a(float paramFloat)
  {
    this.q = this.e.a(paramFloat);
  }
  
  public final void a(p paramp)
  {
    this.b = paramp;
  }
  
  void a(Class paramClass)
  {
    this.c = a(paramClass, o, "set", this.d);
  }
  
  final void a(Object paramObject)
  {
    Object localObject;
    if (this.b != null)
    {
      try
      {
        this.b.a(paramObject);
        Iterator localIterator = this.e.e.iterator();
        while (localIterator.hasNext())
        {
          localObject = (g)localIterator.next();
          if (!((g)localObject).d) {
            ((g)localObject).a(this.b.a(paramObject));
          }
        }
        localClass = paramObject.getClass();
      }
      catch (ClassCastException localClassCastException)
      {
        Log.e("PropertyValuesHolder", "No such property (" + this.b.a + ") on target object " + paramObject + ". Trying reflection instead");
        this.b = null;
      }
    }
    else
    {
      Class localClass;
      if (this.c == null) {
        a(localClass);
      }
      localObject = this.e.e.iterator();
      while (((Iterator)localObject).hasNext())
      {
        g localg = (g)((Iterator)localObject).next();
        if (!localg.d)
        {
          if (this.k == null) {
            this.k = a(localClass, p, "get", null);
          }
          try
          {
            localg.a(this.k.invoke(paramObject, new Object[0]));
          }
          catch (InvocationTargetException localInvocationTargetException)
          {
            Log.e("PropertyValuesHolder", localInvocationTargetException.toString());
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            Log.e("PropertyValuesHolder", localIllegalAccessException.toString());
          }
        }
      }
    }
  }
  
  public void a(float... paramVarArgs)
  {
    int i1 = 1;
    this.d = Float.TYPE;
    int i2 = paramVarArgs.length;
    g.a[] arrayOfa = new g.a[Math.max(i2, 2)];
    if (i2 == 1)
    {
      arrayOfa[0] = ((g.a)new g.a());
      arrayOfa[1] = ((g.a)g.a(1.0F, paramVarArgs[0]));
    }
    for (;;)
    {
      this.e = new d(arrayOfa);
      return;
      arrayOfa[0] = ((g.a)g.a(0.0F, paramVarArgs[0]));
      while (i1 < i2)
      {
        arrayOfa[i1] = ((g.a)g.a(i1 / (i2 - 1), paramVarArgs[i1]));
        i1 += 1;
      }
    }
  }
  
  public void a(int... paramVarArgs)
  {
    int i1 = 1;
    this.d = Integer.TYPE;
    int i2 = paramVarArgs.length;
    g.b[] arrayOfb = new g.b[Math.max(i2, 2)];
    if (i2 == 1)
    {
      arrayOfb[0] = ((g.b)new g.b());
      arrayOfb[1] = ((g.b)g.a(1.0F, paramVarArgs[0]));
    }
    for (;;)
    {
      this.e = new f(arrayOfb);
      return;
      arrayOfb[0] = ((g.b)g.a(0.0F, paramVarArgs[0]));
      while (i1 < i2)
      {
        arrayOfb[i1] = ((g.b)g.a(i1 / (i2 - 1), paramVarArgs[i1]));
        i1 += 1;
      }
    }
  }
  
  Object b()
  {
    return this.q;
  }
  
  void b(Object paramObject)
  {
    if (this.b != null) {
      this.b.a(paramObject, b());
    }
    if (this.c != null) {}
    try
    {
      this.i[0] = b();
      this.c.invoke(paramObject, this.i);
      return;
    }
    catch (InvocationTargetException paramObject)
    {
      Log.e("PropertyValuesHolder", ((InvocationTargetException)paramObject).toString());
      return;
    }
    catch (IllegalAccessException paramObject)
    {
      Log.e("PropertyValuesHolder", ((IllegalAccessException)paramObject).toString());
    }
  }
  
  public String toString()
  {
    return this.a + ": " + this.e.toString();
  }
  
  static final class a
    extends k
  {
    d k;
    float l;
    private n m;
    
    public a(p paramp, float... paramVarArgs)
    {
      super((byte)0);
      a(paramVarArgs);
      if ((paramp instanceof n)) {
        this.m = ((n)this.b);
      }
    }
    
    public a(String paramString, float... paramVarArgs)
    {
      super((byte)0);
      a(paramVarArgs);
    }
    
    private a c()
    {
      a locala = (a)super.a();
      locala.k = ((d)locala.e);
      return locala;
    }
    
    final void a(float paramFloat)
    {
      this.l = this.k.b(paramFloat);
    }
    
    final void a(Class paramClass)
    {
      if (this.b != null) {
        return;
      }
      super.a(paramClass);
    }
    
    public final void a(float... paramVarArgs)
    {
      super.a(paramVarArgs);
      this.k = ((d)this.e);
    }
    
    final Object b()
    {
      return Float.valueOf(this.l);
    }
    
    final void b(Object paramObject)
    {
      if (this.m != null) {
        this.m.a(paramObject, this.l);
      }
      do
      {
        return;
        if (this.b != null)
        {
          this.b.a(paramObject, Float.valueOf(this.l));
          return;
        }
      } while (this.c == null);
      try
      {
        this.i[0] = Float.valueOf(this.l);
        this.c.invoke(paramObject, this.i);
        return;
      }
      catch (InvocationTargetException paramObject)
      {
        Log.e("PropertyValuesHolder", ((InvocationTargetException)paramObject).toString());
        return;
      }
      catch (IllegalAccessException paramObject)
      {
        Log.e("PropertyValuesHolder", ((IllegalAccessException)paramObject).toString());
      }
    }
  }
  
  static final class b
    extends k
  {
    f k;
    int l;
    private o m;
    
    public b(p paramp, int... paramVarArgs)
    {
      super((byte)0);
      a(paramVarArgs);
      if ((paramp instanceof o)) {
        this.m = ((o)this.b);
      }
    }
    
    public b(String paramString, int... paramVarArgs)
    {
      super((byte)0);
      a(paramVarArgs);
    }
    
    private b c()
    {
      b localb = (b)super.a();
      localb.k = ((f)localb.e);
      return localb;
    }
    
    final void a(float paramFloat)
    {
      this.l = this.k.b(paramFloat);
    }
    
    final void a(Class paramClass)
    {
      if (this.b != null) {
        return;
      }
      super.a(paramClass);
    }
    
    public final void a(int... paramVarArgs)
    {
      super.a(paramVarArgs);
      this.k = ((f)this.e);
    }
    
    final Object b()
    {
      return Integer.valueOf(this.l);
    }
    
    final void b(Object paramObject)
    {
      if (this.m != null) {
        this.m.a(paramObject, this.l);
      }
      do
      {
        return;
        if (this.b != null)
        {
          this.b.a(paramObject, Integer.valueOf(this.l));
          return;
        }
      } while (this.c == null);
      try
      {
        this.i[0] = Integer.valueOf(this.l);
        this.c.invoke(paramObject, this.i);
        return;
      }
      catch (InvocationTargetException paramObject)
      {
        Log.e("PropertyValuesHolder", ((InvocationTargetException)paramObject).toString());
        return;
      }
      catch (IllegalAccessException paramObject)
      {
        Log.e("PropertyValuesHolder", ((IllegalAccessException)paramObject).toString());
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */