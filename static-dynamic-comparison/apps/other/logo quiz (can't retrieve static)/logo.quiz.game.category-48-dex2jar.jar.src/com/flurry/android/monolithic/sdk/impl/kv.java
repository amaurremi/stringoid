package com.flurry.android.monolithic.sdk.impl;

import java.util.Arrays;

public class kv
  implements ld, Comparable<kv>
{
  private ji a;
  private byte[] b;
  
  protected kv() {}
  
  public kv(ji paramji)
  {
    a(paramji);
  }
  
  public int a(kv paramkv)
  {
    return lg.a(this.b, 0, this.b.length, paramkv.b, 0, paramkv.b.length);
  }
  
  public ji a()
  {
    return this.a;
  }
  
  protected void a(ji paramji)
  {
    this.a = paramji;
    this.b = new byte[paramji.l()];
  }
  
  public byte[] b()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    while (((paramObject instanceof ld)) && (Arrays.equals(this.b, ((ld)paramObject).b()))) {
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(this.b);
  }
  
  public String toString()
  {
    return Arrays.toString(this.b);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/kv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */