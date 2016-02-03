package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

@rz
public final class vu
  extends wa<Character>
{
  public vu(Class<Character> paramClass, Character paramCharacter)
  {
    super(paramClass, paramCharacter);
  }
  
  public Character b(ow paramow, qm paramqm)
    throws IOException, oz
  {
    pb localpb = paramow.e();
    if (localpb == pb.i)
    {
      int i = paramow.t();
      if ((i >= 0) && (i <= 65535)) {
        return Character.valueOf((char)i);
      }
    }
    else if (localpb == pb.h)
    {
      paramow = paramow.k();
      if (paramow.length() == 1) {
        return Character.valueOf(paramow.charAt(0));
      }
      if (paramow.length() == 0) {
        return (Character)c();
      }
    }
    throw paramqm.a(this.q, localpb);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/vu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */