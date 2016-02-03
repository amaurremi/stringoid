package com.flurry.android.monolithic.sdk.impl;

public class pl
  extends pa
{
  protected final pl c;
  protected String d;
  protected pl e = null;
  
  protected pl(int paramInt, pl parampl)
  {
    this.a = paramInt;
    this.c = parampl;
    this.b = -1;
  }
  
  private final pl a(int paramInt)
  {
    this.a = paramInt;
    this.b = -1;
    this.d = null;
    return this;
  }
  
  public static pl g()
  {
    return new pl(0, null);
  }
  
  public final int a(String paramString)
  {
    if ((this.a != 2) || (this.d != null)) {
      return 4;
    }
    this.d = paramString;
    if (this.b < 0) {
      return 0;
    }
    return 1;
  }
  
  protected final void a(StringBuilder paramStringBuilder)
  {
    if (this.a == 2)
    {
      paramStringBuilder.append('{');
      if (this.d != null)
      {
        paramStringBuilder.append('"');
        paramStringBuilder.append(this.d);
        paramStringBuilder.append('"');
      }
      for (;;)
      {
        paramStringBuilder.append('}');
        return;
        paramStringBuilder.append('?');
      }
    }
    if (this.a == 1)
    {
      paramStringBuilder.append('[');
      paramStringBuilder.append(f());
      paramStringBuilder.append(']');
      return;
    }
    paramStringBuilder.append("/");
  }
  
  public final pl h()
  {
    pl localpl = this.e;
    if (localpl == null)
    {
      localpl = new pl(1, this);
      this.e = localpl;
      return localpl;
    }
    return localpl.a(1);
  }
  
  public final pl i()
  {
    pl localpl = this.e;
    if (localpl == null)
    {
      localpl = new pl(2, this);
      this.e = localpl;
      return localpl;
    }
    return localpl.a(2);
  }
  
  public final pl j()
  {
    return this.c;
  }
  
  public final int k()
  {
    int i = 0;
    if (this.a == 2) {
      if (this.d == null) {
        i = 5;
      }
    }
    do
    {
      int j;
      do
      {
        return i;
        this.d = null;
        this.b += 1;
        return 2;
        if (this.a != 1) {
          break;
        }
        j = this.b;
        this.b += 1;
      } while (j < 0);
      return 1;
      this.b += 1;
    } while (this.b == 0);
    return 3;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    a(localStringBuilder);
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/pl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */