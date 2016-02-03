package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

@rz
final class vh
  extends ve<char[]>
{
  public vh()
  {
    super(char[].class);
  }
  
  public char[] b(ow paramow, qm paramqm)
    throws IOException, oz
  {
    Object localObject1 = paramow.e();
    if (localObject1 == pb.h)
    {
      paramqm = paramow.l();
      int i = paramow.n();
      int j = paramow.m();
      paramow = new char[j];
      System.arraycopy(paramqm, i, paramow, 0, j);
      return paramow;
    }
    if (paramow.j())
    {
      localObject1 = new StringBuilder(64);
      for (;;)
      {
        Object localObject2 = paramow.b();
        if (localObject2 == pb.e) {
          break;
        }
        if (localObject2 != pb.h) {
          throw paramqm.b(Character.TYPE);
        }
        localObject2 = paramow.k();
        if (((String)localObject2).length() != 1) {
          throw qw.a(paramow, "Can not convert a JSON String of length " + ((String)localObject2).length() + " into a char element of char array");
        }
        ((StringBuilder)localObject1).append(((String)localObject2).charAt(0));
      }
      return ((StringBuilder)localObject1).toString().toCharArray();
    }
    if (localObject1 == pb.g)
    {
      paramow = paramow.z();
      if (paramow == null) {
        return null;
      }
      if ((paramow instanceof char[])) {
        return (char[])paramow;
      }
      if ((paramow instanceof String)) {
        return ((String)paramow).toCharArray();
      }
      if ((paramow instanceof byte[])) {
        return oo.a().a((byte[])paramow, false).toCharArray();
      }
    }
    throw paramqm.b(this.q);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/vh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */