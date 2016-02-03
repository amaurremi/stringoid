package com.google.gson.b;

import com.google.gson.internal..Gson.Types;
import java.lang.reflect.Type;

public class a<T>
{
  final Type agh;
  final Class<? super T> ahj;
  final int ahk;
  
  protected a()
  {
    this.agh = u(getClass());
    this.ahj = .Gson.Types.l(this.agh);
    this.ahk = this.agh.hashCode();
  }
  
  a(Type paramType)
  {
    this.agh = .Gson.Types.k((Type)com.google.gson.internal.a.ad(paramType));
    this.ahj = .Gson.Types.l(this.agh);
    this.ahk = this.agh.hashCode();
  }
  
  public static a<?> p(Type paramType)
  {
    return new a(paramType);
  }
  
  static Type u(Class<?> paramClass)
  {
    paramClass = paramClass.getGenericSuperclass();
    if ((paramClass instanceof Class)) {
      throw new RuntimeException("Missing type parameter.");
    }
    return .Gson.Types.k(((java.lang.reflect.ParameterizedType)paramClass).getActualTypeArguments()[0]);
  }
  
  public static <T> a<T> v(Class<T> paramClass)
  {
    return new a(paramClass);
  }
  
  public final Type Aa()
  {
    return this.agh;
  }
  
  public final boolean equals(Object paramObject)
  {
    return ((paramObject instanceof a)) && (.Gson.Types.a(this.agh, ((a)paramObject).agh));
  }
  
  public final int hashCode()
  {
    return this.ahk;
  }
  
  public final String toString()
  {
    return .Gson.Types.m(this.agh);
  }
  
  public final Class<? super T> zZ()
  {
    return this.ahj;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/gson/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */