package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.util.Arrays;

public final class aer
  extends afg
{
  static final aer c = new aer(new byte[0]);
  final byte[] d;
  
  public aer(byte[] paramArrayOfByte)
  {
    this.d = paramArrayOfByte;
  }
  
  public static aer a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    if (paramArrayOfByte.length == 0) {
      return c;
    }
    return new aer(paramArrayOfByte);
  }
  
  public final void a(or paramor, ru paramru)
    throws IOException, oz
  {
    paramor.a(this.d);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramObject == null);
      bool1 = bool2;
    } while (paramObject.getClass() != getClass());
    return Arrays.equals(((aer)paramObject).d, this.d);
  }
  
  public int hashCode()
  {
    if (this.d == null) {
      return -1;
    }
    return this.d.length;
  }
  
  public String m()
  {
    return oo.a().a(this.d, false);
  }
  
  public String toString()
  {
    return oo.a().a(this.d, true);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/aer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */