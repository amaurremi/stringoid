package com.vungle.publisher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public final class cy
{
  private static final Object a = new Object();
  private final cy b;
  private final Queue<cs<?>> c = new cr();
  private boolean d = true;
  private final List<String> e = new ArrayList();
  private final Map<String, cs<?>> f = new HashMap();
  private volatile Map<String, cs<?>> g = null;
  private final cz h;
  private final b i;
  
  public cy(cz paramcz, b paramb)
  {
    if (paramcz == null) {
      throw new NullPointerException("plugin");
    }
    this.b = null;
    this.h = paramcz;
    this.i = paramb;
  }
  
  private static <T> cs<T> a(cs<T> paramcs)
  {
    if ((!paramcs.b()) || ((paramcs instanceof c))) {
      return paramcs;
    }
    return new c(paramcs, (byte)0);
  }
  
  private void a(String paramString)
  {
    this.e.add(paramString);
  }
  
  private static <K, V> void a(Map<K, V> paramMap, K paramK, V paramV)
  {
    paramV = paramMap.put(paramK, paramV);
    if (paramV != null) {
      paramMap.put(paramK, paramV);
    }
  }
  
  private void c()
  {
    if (!Thread.holdsLock(this)) {
      throw new AssertionError();
    }
  }
  
  public final cs<?> a(String paramString, Object paramObject, ClassLoader paramClassLoader)
  {
    return a(paramString, paramObject, paramClassLoader, true);
  }
  
  public final cs<?> a(String paramString, Object paramObject, ClassLoader paramClassLoader, boolean paramBoolean)
  {
    c();
    cy localcy = this;
    cs localcs1 = null;
    cs localcs2;
    for (;;)
    {
      localcs2 = localcs1;
      if (localcy == null) {
        break;
      }
      localcs1 = (cs)localcy.f.get(paramString);
      if (localcs1 != null)
      {
        localcs2 = localcs1;
        if (localcy == this) {
          break;
        }
        localcs2 = localcs1;
        if (localcs1.isLinked()) {
          break;
        }
        throw new AssertionError();
      }
      localcy = localcy.b;
    }
    if (localcs2 == null)
    {
      paramString = new a(paramString, paramClassLoader, paramObject, paramBoolean, (byte)0);
      paramString.setLibrary(true);
      paramString.setDependedOn(true);
      this.c.add(paramString);
      this.d = false;
      return null;
    }
    if (!localcs2.isLinked()) {
      this.c.add(localcs2);
    }
    localcs2.setLibrary(true);
    localcs2.setDependedOn(true);
    return localcs2;
  }
  
  public final void a()
  {
    c();
    for (;;)
    {
      cs localcs2 = (cs)this.c.poll();
      if (localcs2 == null) {
        break;
      }
      if ((localcs2 instanceof a))
      {
        Object localObject4 = (a)localcs2;
        String str1 = ((a)localObject4).b;
        boolean bool = ((a)localObject4).c;
        if (!this.f.containsKey(str1)) {
          try
          {
            Object localObject1 = localcs2.requiredBy;
            localObject4 = ((a)localObject4).a;
            str2 = cw.a(str1);
            if (str2 != null)
            {
              localObject1 = new cu(str1, localObject1, (ClassLoader)localObject4, str2);
              ((cs)localObject1).setLibrary(localcs2.library());
              ((cs)localObject1).setDependedOn(localcs2.dependedOn());
              if ((str1.equals(((cs)localObject1).provideKey)) || (str1.equals(((cs)localObject1).membersKey))) {
                break label448;
              }
              throw new IllegalStateException("Unable to create binding for " + str1);
            }
          }
          catch (cs.a locala)
          {
            for (;;)
            {
              a(locala.a + " " + locala.getMessage() + " required by " + localcs2.requiredBy);
              this.f.put(str1, cs.UNRESOLVED);
              break;
              str2 = cw.b(str1);
              if (str2 == null) {
                break label315;
              }
              cx localcx = new cx(str1, locala, (ClassLoader)localObject4, str2);
            }
          }
          catch (UnsupportedOperationException localUnsupportedOperationException)
          {
            a("Unsupported: " + localUnsupportedOperationException.getMessage() + " required by " + localcs2.requiredBy);
            this.f.put(str1, cs.UNRESOLVED);
            continue;
            str2 = cw.d(str1);
            if ((str2 == null) || (cw.c(str1))) {
              throw new IllegalArgumentException(str1);
            }
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            String str2;
            do
            {
              a(localIllegalArgumentException.getMessage() + " required by " + localcs2.requiredBy);
              this.f.put(str1, cs.UNRESOLVED);
              break;
              localObject4 = this.h.a(str1, str2, (ClassLoader)localObject4, bool);
              Object localObject2 = localObject4;
            } while (localObject4 != null);
            throw new cs.a(str2, "could not be bound with key " + str1);
          }
          catch (RuntimeException localRuntimeException)
          {
            throw localRuntimeException;
            cs localcs1 = a(localRuntimeException);
            this.c.add(localcs1);
            if (localcs1.provideKey != null) {
              a(this.f, localcs1.provideKey, localcs1);
            }
            if (localcs1.membersKey == null) {
              continue;
            }
            a(this.f, localcs1.membersKey, localcs1);
          }
          catch (Exception localException)
          {
            label315:
            label448:
            throw new RuntimeException(localException);
          }
        }
      }
      else
      {
        this.d = true;
        localcs2.attach(this);
        if (this.d) {
          localcs2.a();
        } else {
          this.c.add(localcs2);
        }
      }
    }
    try
    {
      this.i.a(this.e);
      return;
    }
    finally
    {
      this.e.clear();
    }
  }
  
  public final void a(ct paramct)
  {
    if (this.g != null) {
      throw new IllegalStateException("Cannot install further bindings after calling linkAll().");
    }
    paramct = paramct.b.entrySet().iterator();
    while (paramct.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramct.next();
      this.f.put(localEntry.getKey(), a((cs)localEntry.getValue()));
    }
  }
  
  static final class a
    extends cs<Object>
  {
    final ClassLoader a;
    final String b;
    final boolean c;
    
    private a(String paramString, ClassLoader paramClassLoader, Object paramObject, boolean paramBoolean)
    {
      super(null, false, paramObject);
      this.b = paramString;
      this.a = paramClassLoader;
      this.c = paramBoolean;
    }
    
    public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
    {
      throw new UnsupportedOperationException("Deferred bindings must resolve first.");
    }
    
    public final void injectMembers(Object paramObject)
    {
      throw new UnsupportedOperationException("Deferred bindings must resolve first.");
    }
    
    public final String toString()
    {
      return "DeferredBinding[deferredKey=" + this.b + "]";
    }
  }
  
  public static abstract interface b
  {
    public static final b a = new b()
    {
      public final void a(List<String> paramAnonymousList) {}
    };
    
    public abstract void a(List<String> paramList);
  }
  
  static final class c<T>
    extends cs<T>
  {
    private final cs<T> a;
    private volatile Object b = cy.b();
    
    private c(cs<T> paramcs)
    {
      super(paramcs.membersKey, true, paramcs.requiredBy);
      this.a = paramcs;
    }
    
    protected final void a()
    {
      this.a.a();
    }
    
    public final void attach(cy paramcy)
    {
      this.a.attach(paramcy);
    }
    
    protected final boolean b()
    {
      return true;
    }
    
    public final boolean dependedOn()
    {
      return this.a.dependedOn();
    }
    
    public final T get()
    {
      if (this.b == cy.b()) {}
      try
      {
        if (this.b == cy.b()) {
          this.b = this.a.get();
        }
        return (T)this.b;
      }
      finally {}
    }
    
    public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
    {
      this.a.getDependencies(paramSet1, paramSet2);
    }
    
    public final void injectMembers(T paramT)
    {
      this.a.injectMembers(paramT);
    }
    
    public final boolean isCycleFree()
    {
      return this.a.isCycleFree();
    }
    
    public final boolean isLinked()
    {
      return this.a.isLinked();
    }
    
    public final boolean isVisiting()
    {
      return this.a.isVisiting();
    }
    
    public final boolean library()
    {
      return this.a.library();
    }
    
    public final void setCycleFree(boolean paramBoolean)
    {
      this.a.setCycleFree(paramBoolean);
    }
    
    public final void setDependedOn(boolean paramBoolean)
    {
      this.a.setDependedOn(paramBoolean);
    }
    
    public final void setLibrary(boolean paramBoolean)
    {
      this.a.setLibrary(true);
    }
    
    public final void setVisiting(boolean paramBoolean)
    {
      this.a.setVisiting(paramBoolean);
    }
    
    public final String toString()
    {
      return "@Singleton/" + this.a.toString();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/cy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */