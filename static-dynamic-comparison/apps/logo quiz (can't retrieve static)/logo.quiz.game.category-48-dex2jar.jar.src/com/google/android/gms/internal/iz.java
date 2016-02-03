package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import com.google.android.gms.common.internal.m;

public final class iz
  extends ja<a, Drawable>
{
  public iz()
  {
    super(10);
  }
  
  public static final class a
  {
    public final int Li;
    public final int Lj;
    
    public a(int paramInt1, int paramInt2)
    {
      this.Li = paramInt1;
      this.Lj = paramInt2;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = true;
      boolean bool1;
      if (!(paramObject instanceof a)) {
        bool1 = false;
      }
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (this == paramObject);
        paramObject = (a)paramObject;
        if (((a)paramObject).Li != this.Li) {
          break;
        }
        bool1 = bool2;
      } while (((a)paramObject).Lj == this.Lj);
      return false;
    }
    
    public int hashCode()
    {
      return m.hashCode(new Object[] { Integer.valueOf(this.Li), Integer.valueOf(this.Lj) });
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/iz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */