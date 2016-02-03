package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.io.InputStream;

public class ly
{
  private static final ly b = new ma(null);
  int a = 8192;
  
  public static ly a()
  {
    return b;
  }
  
  public ll a(InputStream paramInputStream, ll paramll)
  {
    if ((paramll == null) || (!paramll.getClass().equals(ll.class))) {
      return new ll(paramInputStream, this.a);
    }
    return paramll.a(paramInputStream, this.a);
  }
  
  public ll a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, ll paramll)
  {
    if ((paramll == null) || (!paramll.getClass().equals(ll.class))) {
      return new ll(paramArrayOfByte, paramInt1, paramInt2);
    }
    return paramll.a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public ll a(byte[] paramArrayOfByte, ll paramll)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length, paramll);
  }
  
  public mh a(ji paramji1, ji paramji2, lx paramlx)
    throws IOException
  {
    return new mh(paramji1, paramji2, paramlx);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ly.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */