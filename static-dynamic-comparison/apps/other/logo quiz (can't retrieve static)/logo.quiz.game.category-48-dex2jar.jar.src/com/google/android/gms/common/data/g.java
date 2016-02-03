package com.google.android.gms.common.data;

import java.util.ArrayList;

public abstract class g<T>
  extends DataBuffer<T>
{
  private boolean Ki = false;
  private ArrayList<Integer> Kj;
  
  protected g(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  private void gF()
  {
    for (;;)
    {
      int i;
      try
      {
        if (!this.Ki)
        {
          int j = this.IC.getCount();
          this.Kj = new ArrayList();
          if (j > 0)
          {
            this.Kj.add(Integer.valueOf(0));
            String str2 = gE();
            i = this.IC.ar(0);
            Object localObject1 = this.IC.c(str2, 0, i);
            i = 1;
            if (i < j)
            {
              int k = this.IC.ar(i);
              String str1 = this.IC.c(str2, i, k);
              if (str1.equals(localObject1)) {
                break label145;
              }
              this.Kj.add(Integer.valueOf(i));
              localObject1 = str1;
              break label145;
            }
          }
          this.Ki = true;
        }
        else
        {
          return;
        }
      }
      finally {}
      label145:
      i += 1;
    }
  }
  
  int au(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.Kj.size())) {
      throw new IllegalArgumentException("Position " + paramInt + " is out of bounds for this buffer");
    }
    return ((Integer)this.Kj.get(paramInt)).intValue();
  }
  
  protected int av(int paramInt)
  {
    int j;
    if ((paramInt < 0) || (paramInt == this.Kj.size()))
    {
      j = 0;
      return j;
    }
    if (paramInt == this.Kj.size() - 1) {}
    for (int i = this.IC.getCount() - ((Integer)this.Kj.get(paramInt)).intValue();; i = ((Integer)this.Kj.get(paramInt + 1)).intValue() - ((Integer)this.Kj.get(paramInt)).intValue())
    {
      j = i;
      if (i != 1) {
        break;
      }
      paramInt = au(paramInt);
      int k = this.IC.ar(paramInt);
      String str = gG();
      j = i;
      if (str == null) {
        break;
      }
      j = i;
      if (this.IC.c(str, paramInt, k) != null) {
        break;
      }
      return 0;
    }
  }
  
  protected abstract T f(int paramInt1, int paramInt2);
  
  protected abstract String gE();
  
  protected String gG()
  {
    return null;
  }
  
  public final T get(int paramInt)
  {
    gF();
    return (T)f(au(paramInt), av(paramInt));
  }
  
  public int getCount()
  {
    gF();
    return this.Kj.size();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/common/data/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */