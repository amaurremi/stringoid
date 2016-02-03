package com.flurry.android.monolithic.sdk.impl;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public abstract class xo
  extends xk
{
  protected final xp[] d;
  
  protected xo(xp paramxp, xp[] paramArrayOfxp)
  {
    super(paramxp);
    this.d = paramArrayOfxp;
  }
  
  protected afm a(adj paramadj, TypeVariable<?>[] paramArrayOfTypeVariable)
  {
    Object localObject = paramadj;
    if (paramArrayOfTypeVariable != null)
    {
      localObject = paramadj;
      if (paramArrayOfTypeVariable.length > 0)
      {
        adj localadj = paramadj.a();
        int j = paramArrayOfTypeVariable.length;
        int i = 0;
        localObject = localadj;
        if (i < j)
        {
          localObject = paramArrayOfTypeVariable[i];
          localadj.b(((TypeVariable)localObject).getName());
          paramadj = localObject.getBounds()[0];
          if (paramadj == null) {}
          for (paramadj = adk.b();; paramadj = localadj.a(paramadj))
          {
            localadj.a(((TypeVariable)localObject).getName(), paramadj);
            i += 1;
            break;
          }
        }
      }
    }
    return ((adj)localObject).a(c());
  }
  
  protected xn a(int paramInt, xp paramxp)
  {
    this.d[paramInt] = paramxp;
    return c(paramInt);
  }
  
  public abstract Object a(Object paramObject)
    throws Exception;
  
  public abstract Object a(Object[] paramArrayOfObject)
    throws Exception;
  
  public final <A extends Annotation> A a(Class<A> paramClass)
  {
    return this.b.a(paramClass);
  }
  
  public final void a(int paramInt, Annotation paramAnnotation)
  {
    xp localxp2 = this.d[paramInt];
    xp localxp1 = localxp2;
    if (localxp2 == null)
    {
      localxp1 = new xp();
      this.d[paramInt] = localxp1;
    }
    localxp1.b(paramAnnotation);
  }
  
  public final void a(Annotation paramAnnotation)
  {
    this.b.b(paramAnnotation);
  }
  
  public abstract Type b(int paramInt);
  
  public final void b(Annotation paramAnnotation)
  {
    this.b.a(paramAnnotation);
  }
  
  public final xn c(int paramInt)
  {
    return new xn(this, b(paramInt), this.d[paramInt], paramInt);
  }
  
  public abstract Object g()
    throws Exception;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/xo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */