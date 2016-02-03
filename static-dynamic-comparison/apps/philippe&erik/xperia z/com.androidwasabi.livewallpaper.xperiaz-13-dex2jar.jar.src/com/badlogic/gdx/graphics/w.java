package com.badlogic.gdx.graphics;

public final class w
{
  public final int a;
  private final v[] b;
  private long c = -1L;
  
  public w(v... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      throw new IllegalArgumentException("attributes must be >= 1");
    }
    v[] arrayOfv = new v[paramVarArgs.length];
    int i = 0;
    while (i < paramVarArgs.length)
    {
      arrayOfv[i] = paramVarArgs[i];
      i += 1;
    }
    this.b = arrayOfv;
    c();
    this.a = b();
  }
  
  private int b()
  {
    int j = 0;
    int i = 0;
    if (j < this.b.length)
    {
      v localv = this.b[j];
      localv.c = i;
      if (localv.a == 4) {
        i += 4;
      }
      for (;;)
      {
        j += 1;
        break;
        i += localv.b * 4;
      }
    }
    return i;
  }
  
  private void c()
  {
    int i = 0;
    int j = 0;
    int k;
    for (int m = 0; i < this.b.length; m = k)
    {
      v localv = this.b[i];
      k = m;
      if (localv.a == 1)
      {
        if (m != 0) {
          throw new IllegalArgumentException("two position attributes were specified");
        }
        k = 1;
      }
      if ((localv.a != 8) || (localv.a != 2))
      {
        m = j;
        if (localv.a != 4) {}
      }
      else
      {
        if (localv.b != 4) {
          throw new IllegalArgumentException("color attribute must have 4 components");
        }
        if (j != 0) {
          throw new IllegalArgumentException("two color attributes were specified");
        }
        m = 1;
      }
      i += 1;
      j = m;
    }
    if (m == 0) {
      throw new IllegalArgumentException("no position attribute was specified");
    }
  }
  
  public int a()
  {
    return this.b.length;
  }
  
  public v a(int paramInt)
  {
    return this.b[paramInt];
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof w)) {}
    do
    {
      return false;
      paramObject = (w)paramObject;
    } while (this.b.length != ((w)paramObject).a());
    int i = 0;
    for (;;)
    {
      if (i >= this.b.length) {
        break label62;
      }
      if (!this.b[i].a(paramObject.b[i])) {
        break;
      }
      i += 1;
    }
    label62:
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    int i = 0;
    while (i < this.b.length)
    {
      localStringBuilder.append("(");
      localStringBuilder.append(this.b[i].d);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.b[i].a);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.b[i].b);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.b[i].c);
      localStringBuilder.append(")");
      localStringBuilder.append("\n");
      i += 1;
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/graphics/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */