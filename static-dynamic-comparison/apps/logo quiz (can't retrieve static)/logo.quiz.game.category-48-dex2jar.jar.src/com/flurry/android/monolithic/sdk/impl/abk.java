package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

@rz
public class abk
  extends abt<Object>
  implements rp
{
  protected final Method a;
  protected ra<Object> b;
  protected final qc c;
  protected boolean d;
  
  public abk(Method paramMethod, ra<Object> paramra, qc paramqc)
  {
    super(Object.class);
    this.a = paramMethod;
    this.b = paramra;
    this.c = paramqc;
  }
  
  public void a(ru paramru)
    throws qw
  {
    if ((this.b == null) && ((paramru.a(rr.h)) || (Modifier.isFinal(this.a.getReturnType().getModifiers()))))
    {
      afm localafm = paramru.a(this.a.getGenericReturnType());
      this.b = paramru.a(localafm, false, this.c);
      this.d = a(localafm, this.b);
    }
  }
  
  public void a(Object paramObject, or paramor, ru paramru)
    throws IOException, oq
  {
    try
    {
      Object localObject = this.a.invoke(paramObject, new Object[0]);
      if (localObject == null)
      {
        paramru.a(paramor);
        return;
      }
      ra localra2 = this.b;
      ra localra1 = localra2;
      if (localra2 == null) {
        localra1 = paramru.a(localObject.getClass(), true, this.c);
      }
      localra1.a(localObject, paramor, paramru);
      return;
    }
    catch (IOException paramObject)
    {
      throw ((Throwable)paramObject);
      while (((paramor instanceof InvocationTargetException)) && (paramor.getCause() != null)) {
        paramor = paramor.getCause();
      }
      if ((paramor instanceof Error)) {
        throw ((Error)paramor);
      }
      throw qw.a(paramor, paramObject, this.a.getName() + "()");
    }
    catch (Exception paramor)
    {
      for (;;) {}
    }
  }
  
  public void a(Object paramObject, or paramor, ru paramru, rx paramrx)
    throws IOException, oz
  {
    try
    {
      localObject = this.a.invoke(paramObject, new Object[0]);
      if (localObject == null)
      {
        paramru.a(paramor);
        return;
      }
      ra localra = this.b;
      if (localra != null)
      {
        if (this.d) {
          paramrx.a(paramObject, paramor);
        }
        localra.a(localObject, paramor, paramru, paramrx);
        if (!this.d) {
          return;
        }
        paramrx.d(paramObject, paramor);
      }
    }
    catch (IOException paramObject)
    {
      Object localObject;
      throw ((Throwable)paramObject);
      paramru.a(localObject.getClass(), true, this.c).a(localObject, paramor, paramru);
      return;
    }
    catch (Exception paramor)
    {
      while (((paramor instanceof InvocationTargetException)) && (paramor.getCause() != null)) {
        paramor = paramor.getCause();
      }
      if ((paramor instanceof Error)) {
        throw ((Error)paramor);
      }
      throw qw.a(paramor, paramObject, this.a.getName() + "()");
    }
  }
  
  protected boolean a(afm paramafm, ra<?> paramra)
  {
    Class localClass = paramafm.p();
    if (paramafm.t()) {
      if ((localClass == Integer.TYPE) || (localClass == Boolean.TYPE) || (localClass == Double.TYPE)) {
        break label59;
      }
    }
    label59:
    while (paramra.getClass().getAnnotation(rz.class) == null) {
      do
      {
        return false;
      } while ((localClass != String.class) && (localClass != Integer.class) && (localClass != Boolean.class) && (localClass != Double.class));
    }
    return true;
  }
  
  public String toString()
  {
    return "(@JsonValue serializer for method " + this.a.getDeclaringClass() + "#" + this.a.getName() + ")";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/abk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */