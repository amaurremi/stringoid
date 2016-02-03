package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

@rz
final class vg
  extends ve<byte[]>
{
  public vg()
  {
    super(byte[].class);
  }
  
  private final byte[] c(ow paramow, qm paramqm)
    throws IOException, oz
  {
    if ((paramow.e() == pb.h) && (paramqm.a(ql.q)) && (paramow.k().length() == 0)) {
      return null;
    }
    if (!paramqm.a(ql.o)) {
      throw paramqm.b(this.q);
    }
    pb localpb = paramow.e();
    if ((localpb == pb.i) || (localpb == pb.j)) {}
    for (int i = paramow.r();; i = 0)
    {
      return new byte[] { i };
      if (localpb != pb.m) {
        throw paramqm.b(this.q.getComponentType());
      }
    }
  }
  
  public byte[] b(ow paramow, qm paramqm)
    throws IOException, oz
  {
    Object localObject = paramow.e();
    if (localObject == pb.h) {
      return paramow.a(paramqm.c());
    }
    if (localObject == pb.g)
    {
      localObject = paramow.z();
      if (localObject == null) {
        return null;
      }
      if ((localObject instanceof byte[])) {
        return (byte[])localObject;
      }
    }
    if (!paramow.j()) {
      return c(paramow, paramqm);
    }
    ads localads = paramqm.h().b();
    localObject = (byte[])localads.a();
    int j = 0;
    pb localpb = paramow.b();
    int i;
    if (localpb != pb.e) {
      if ((localpb == pb.i) || (localpb == pb.j))
      {
        i = paramow.r();
        label132:
        if (j < localObject.length) {
          break label214;
        }
        localObject = (byte[])localads.a(localObject, j);
        j = 0;
      }
    }
    label214:
    for (;;)
    {
      int k = j + 1;
      localObject[j] = i;
      j = k;
      break;
      if (localpb != pb.m) {
        throw paramqm.b(this.q.getComponentType());
      }
      i = 0;
      break label132;
      return (byte[])localads.b(localObject, j);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/vg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */