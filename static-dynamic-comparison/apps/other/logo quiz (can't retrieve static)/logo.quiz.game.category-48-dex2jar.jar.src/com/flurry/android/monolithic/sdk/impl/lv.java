package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.io.OutputStream;

class lv
  extends lu
{
  private final OutputStream a;
  
  private lv(OutputStream paramOutputStream)
  {
    this.a = paramOutputStream;
  }
  
  protected void a()
    throws IOException
  {
    this.a.flush();
  }
  
  protected void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.a.write(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/lv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */