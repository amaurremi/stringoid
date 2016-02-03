package com.google.gson.internal;

import com.google.gson.m;
import com.google.gson.n;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class c
  implements n, Cloneable
{
  public static final c afc = new c();
  private double afd = -1.0D;
  private int afe = 136;
  private boolean aff = true;
  private boolean afg;
  private List<com.google.gson.a> afh = Collections.emptyList();
  private List<com.google.gson.a> afi = Collections.emptyList();
  
  private boolean a(com.google.gson.a.c paramc)
  {
    return (paramc == null) || (paramc.zH() <= this.afd);
  }
  
  private boolean a(com.google.gson.a.c paramc, com.google.gson.a.d paramd)
  {
    return (a(paramc)) && (a(paramd));
  }
  
  private boolean a(com.google.gson.a.d paramd)
  {
    return (paramd == null) || (paramd.zH() > this.afd);
  }
  
  private boolean q(Class<?> paramClass)
  {
    return (!Enum.class.isAssignableFrom(paramClass)) && ((paramClass.isAnonymousClass()) || (paramClass.isLocalClass()));
  }
  
  private boolean r(Class<?> paramClass)
  {
    return (paramClass.isMemberClass()) && (!s(paramClass));
  }
  
  private boolean s(Class<?> paramClass)
  {
    return (paramClass.getModifiers() & 0x8) != 0;
  }
  
  public <T> m<T> a(final com.google.gson.d paramd, final com.google.gson.b.a<T> parama)
  {
    Class localClass = parama.zZ();
    final boolean bool1 = b(localClass, true);
    final boolean bool2 = b(localClass, false);
    if ((!bool1) && (!bool2)) {
      return null;
    }
    new m()
    {
      private m<T> aeL;
      
      private m<T> zK()
      {
        m localm = this.aeL;
        if (localm != null) {
          return localm;
        }
        localm = d.afo.a(paramd, c.this, parama);
        this.aeL = localm;
        return localm;
      }
      
      public void a(com.google.gson.stream.b paramAnonymousb, T paramAnonymousT)
      {
        if (bool1)
        {
          paramAnonymousb.zX();
          return;
        }
        zK().a(paramAnonymousb, paramAnonymousT);
      }
      
      public T b(com.google.gson.stream.a paramAnonymousa)
      {
        if (bool2)
        {
          paramAnonymousa.skipValue();
          return null;
        }
        return (T)zK().b(paramAnonymousa);
      }
    };
  }
  
  public boolean a(Field paramField, boolean paramBoolean)
  {
    if ((this.afe & paramField.getModifiers()) != 0) {
      return true;
    }
    if ((this.afd != -1.0D) && (!a((com.google.gson.a.c)paramField.getAnnotation(com.google.gson.a.c.class), (com.google.gson.a.d)paramField.getAnnotation(com.google.gson.a.d.class)))) {
      return true;
    }
    if (paramField.isSynthetic()) {
      return true;
    }
    if (this.afg)
    {
      localObject = (com.google.gson.a.a)paramField.getAnnotation(com.google.gson.a.a.class);
      if (localObject != null)
      {
        if (!paramBoolean) {
          break label97;
        }
        if (((com.google.gson.a.a)localObject).zF()) {
          break label106;
        }
      }
      label97:
      while (!((com.google.gson.a.a)localObject).zG()) {
        return true;
      }
    }
    label106:
    if ((!this.aff) && (r(paramField.getType()))) {
      return true;
    }
    if (q(paramField.getType())) {
      return true;
    }
    if (paramBoolean) {}
    for (Object localObject = this.afh; !((List)localObject).isEmpty(); localObject = this.afi)
    {
      paramField = new com.google.gson.b(paramField);
      localObject = ((List)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!((com.google.gson.a)((Iterator)localObject).next()).a(paramField));
      return true;
    }
    return false;
  }
  
  public boolean b(Class<?> paramClass, boolean paramBoolean)
  {
    if ((this.afd != -1.0D) && (!a((com.google.gson.a.c)paramClass.getAnnotation(com.google.gson.a.c.class), (com.google.gson.a.d)paramClass.getAnnotation(com.google.gson.a.d.class)))) {
      return true;
    }
    if ((!this.aff) && (r(paramClass))) {
      return true;
    }
    if (q(paramClass)) {
      return true;
    }
    if (paramBoolean) {}
    for (Object localObject = this.afh;; localObject = this.afi)
    {
      localObject = ((List)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!((com.google.gson.a)((Iterator)localObject).next()).m(paramClass));
      return true;
    }
    return false;
  }
  
  protected c zJ()
  {
    try
    {
      c localc = (c)super.clone();
      return localc;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/gson/internal/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */