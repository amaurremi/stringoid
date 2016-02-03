package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

@rz
public class wy
  extends wv<String>
{
  public wy()
  {
    super(String.class);
  }
  
  public String b(ow paramow, qm paramqm)
    throws IOException, oz
  {
    pb localpb = paramow.e();
    if (localpb == pb.h) {
      return paramow.k();
    }
    if (localpb == pb.g)
    {
      paramow = paramow.z();
      if (paramow == null) {
        return null;
      }
      if ((paramow instanceof byte[])) {
        return oo.a().a((byte[])paramow, false);
      }
      return paramow.toString();
    }
    if (localpb.d()) {
      return paramow.k();
    }
    throw paramqm.a(this.q, localpb);
  }
  
  public String b(ow paramow, qm paramqm, rw paramrw)
    throws IOException, oz
  {
    return b(paramow, paramqm);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/wy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */