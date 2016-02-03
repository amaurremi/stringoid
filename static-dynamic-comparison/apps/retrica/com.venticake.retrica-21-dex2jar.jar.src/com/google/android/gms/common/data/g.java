package com.google.android.gms.common.data;

import java.util.ArrayList;

public abstract class g<T>
  extends DataBuffer<T>
{
  private boolean EU = false;
  private ArrayList<Integer> EV;
  
  protected g(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  private void fa()
  {
    for (;;)
    {
      int i;
      try
      {
        if (!this.EU)
        {
          int j = this.DG.getCount();
          this.EV = new ArrayList();
          if (j > 0)
          {
            this.EV.add(Integer.valueOf(0));
            String str2 = eZ();
            i = this.DG.ae(0);
            Object localObject1 = this.DG.c(str2, 0, i);
            i = 1;
            if (i < j)
            {
              int k = this.DG.ae(i);
              String str1 = this.DG.c(str2, i, k);
              if (str1.equals(localObject1)) {
                break label145;
              }
              this.EV.add(Integer.valueOf(i));
              localObject1 = str1;
              break label145;
            }
          }
          this.EU = true;
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
  
  int ah(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.EV.size())) {
      throw new IllegalArgumentException("Position " + paramInt + " is out of bounds for this buffer");
    }
    return ((Integer)this.EV.get(paramInt)).intValue();
  }
  
  protected int ai(int paramInt)
  {
    int j;
    if ((paramInt < 0) || (paramInt == this.EV.size()))
    {
      j = 0;
      return j;
    }
    if (paramInt == this.EV.size() - 1) {}
    for (int i = this.DG.getCount() - ((Integer)this.EV.get(paramInt)).intValue();; i = ((Integer)this.EV.get(paramInt + 1)).intValue() - ((Integer)this.EV.get(paramInt)).intValue())
    {
      j = i;
      if (i != 1) {
        break;
      }
      paramInt = ah(paramInt);
      int k = this.DG.ae(paramInt);
      String str = fb();
      j = i;
      if (str == null) {
        break;
      }
      j = i;
      if (this.DG.c(str, paramInt, k) != null) {
        break;
      }
      return 0;
    }
  }
  
  protected abstract T c(int paramInt1, int paramInt2);
  
  protected abstract String eZ();
  
  protected String fb()
  {
    return null;
  }
  
  public final T get(int paramInt)
  {
    fa();
    return (T)c(ah(paramInt), ai(paramInt));
  }
  
  public int getCount()
  {
    fa();
    return this.EV.size();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/common/data/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */