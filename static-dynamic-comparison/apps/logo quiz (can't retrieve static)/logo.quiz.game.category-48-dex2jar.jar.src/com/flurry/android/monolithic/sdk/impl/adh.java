package com.flurry.android.monolithic.sdk.impl;

public final class adh
  extends adi
{
  protected final afm[] a;
  protected final String[] b;
  
  protected adh(Class<?> paramClass)
  {
    this(paramClass, null, null, null, null);
  }
  
  protected adh(Class<?> paramClass, String[] paramArrayOfString, afm[] paramArrayOfafm, Object paramObject1, Object paramObject2)
  {
    super(paramClass, 0, paramObject1, paramObject2);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      this.b = null;
      this.a = null;
      return;
    }
    this.b = paramArrayOfString;
    this.a = paramArrayOfafm;
  }
  
  public static adh d(Class<?> paramClass)
  {
    return new adh(paramClass, null, null, null, null);
  }
  
  public adh a(Object paramObject)
  {
    return new adh(this.d, this.b, this.a, this.f, paramObject);
  }
  
  protected afm a(Class<?> paramClass)
  {
    return new adh(paramClass, this.b, this.a, this.f, this.g);
  }
  
  protected String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.d.getName());
    if ((this.a != null) && (this.a.length > 0))
    {
      localStringBuilder.append('<');
      int j = 1;
      afm[] arrayOfafm = this.a;
      int k = arrayOfafm.length;
      int i = 0;
      if (i < k)
      {
        afm localafm = arrayOfafm[i];
        if (j != 0) {
          j = 0;
        }
        for (;;)
        {
          localStringBuilder.append(localafm.m());
          i += 1;
          break;
          localStringBuilder.append(',');
        }
      }
      localStringBuilder.append('>');
    }
    return localStringBuilder.toString();
  }
  
  public String a(int paramInt)
  {
    if ((paramInt < 0) || (this.b == null) || (paramInt >= this.b.length)) {
      return null;
    }
    return this.b[paramInt];
  }
  
  public adh b(Object paramObject)
  {
    if (paramObject == this.f) {
      return this;
    }
    return new adh(this.d, this.b, this.a, paramObject, this.g);
  }
  
  public afm b(int paramInt)
  {
    if ((paramInt < 0) || (this.a == null) || (paramInt >= this.a.length)) {
      return null;
    }
    return this.a[paramInt];
  }
  
  public afm b(Class<?> paramClass)
  {
    throw new IllegalArgumentException("Internal error: SimpleType.narrowContentsBy() should never be called");
  }
  
  public afm c(Class<?> paramClass)
  {
    throw new IllegalArgumentException("Internal error: SimpleType.widenContentsBy() should never be called");
  }
  
  public afm e(Object paramObject)
  {
    throw new IllegalArgumentException("Simple types have no content types; can not call withContenTypeHandler()");
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    Object localObject;
    label92:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return bool1;
                bool1 = bool2;
              } while (paramObject == null);
              bool1 = bool2;
            } while (paramObject.getClass() != getClass());
            localObject = (adh)paramObject;
            bool1 = bool2;
          } while (((adh)localObject).d != this.d);
          paramObject = this.a;
          localObject = ((adh)localObject).a;
          if (paramObject != null) {
            break label92;
          }
          if (localObject == null) {
            break;
          }
          bool1 = bool2;
        } while (localObject.length != 0);
        return true;
        bool1 = bool2;
      } while (localObject == null);
      bool1 = bool2;
    } while (paramObject.length != localObject.length);
    int j = paramObject.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label147;
      }
      bool1 = bool2;
      if (!paramObject[i].equals(localObject[i])) {
        break;
      }
      i += 1;
    }
    label147:
    return true;
  }
  
  public boolean f()
  {
    return false;
  }
  
  public int h()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.length;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(40);
    localStringBuilder.append("[simple type, class ").append(a()).append(']');
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/adh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */