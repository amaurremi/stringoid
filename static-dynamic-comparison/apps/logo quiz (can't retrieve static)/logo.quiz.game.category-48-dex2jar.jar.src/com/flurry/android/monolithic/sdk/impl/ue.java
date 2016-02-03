package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

@rz
public class ue
  extends wv<Class<?>>
{
  public ue()
  {
    super(Class.class);
  }
  
  public Class<?> b(ow paramow, qm paramqm)
    throws IOException, oz
  {
    Object localObject = paramow.e();
    if (localObject == pb.h)
    {
      localObject = paramow.k();
      if (((String)localObject).indexOf('.') < 0)
      {
        if ("int".equals(localObject)) {
          return Integer.TYPE;
        }
        if ("long".equals(localObject)) {
          return Long.TYPE;
        }
        if ("float".equals(localObject)) {
          return Float.TYPE;
        }
        if ("double".equals(localObject)) {
          return Double.TYPE;
        }
        if ("boolean".equals(localObject)) {
          return Boolean.TYPE;
        }
        if ("byte".equals(localObject)) {
          return Byte.TYPE;
        }
        if ("char".equals(localObject)) {
          return Character.TYPE;
        }
        if ("short".equals(localObject)) {
          return Short.TYPE;
        }
        if ("void".equals(localObject)) {
          return Void.TYPE;
        }
      }
      try
      {
        paramow = Class.forName(paramow.k());
        return paramow;
      }
      catch (ClassNotFoundException paramow)
      {
        throw paramqm.a(this.q, paramow);
      }
    }
    throw paramqm.a(this.q, (pb)localObject);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */