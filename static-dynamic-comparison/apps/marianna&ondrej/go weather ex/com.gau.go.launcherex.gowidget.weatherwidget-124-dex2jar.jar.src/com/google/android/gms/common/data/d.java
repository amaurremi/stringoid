package com.google.android.gms.common.data;

import java.util.ArrayList;

public abstract class d<T>
  extends DataBuffer<T>
{
  private boolean BW = false;
  private ArrayList<Integer> BX;
  
  protected d(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  private void eu()
  {
    for (;;)
    {
      int i;
      try
      {
        if (!this.BW)
        {
          int j = this.BB.getCount();
          this.BX = new ArrayList();
          if (j > 0)
          {
            this.BX.add(Integer.valueOf(0));
            String str2 = getPrimaryDataMarkerColumn();
            i = this.BB.G(0);
            Object localObject1 = this.BB.getString(str2, 0, i);
            i = 1;
            if (i < j)
            {
              int k = this.BB.G(i);
              String str1 = this.BB.getString(str2, i, k);
              if (str1.equals(localObject1)) {
                break label145;
              }
              this.BX.add(Integer.valueOf(i));
              localObject1 = str1;
              break label145;
            }
          }
          this.BW = true;
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
  
  int H(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.BX.size())) {
      throw new IllegalArgumentException("Position " + paramInt + " is out of bounds for this buffer");
    }
    return ((Integer)this.BX.get(paramInt)).intValue();
  }
  
  protected int I(int paramInt)
  {
    if ((paramInt < 0) || (paramInt == this.BX.size())) {
      return 0;
    }
    if (paramInt == this.BX.size() - 1) {
      return this.BB.getCount() - ((Integer)this.BX.get(paramInt)).intValue();
    }
    return ((Integer)this.BX.get(paramInt + 1)).intValue() - ((Integer)this.BX.get(paramInt)).intValue();
  }
  
  protected abstract T c(int paramInt1, int paramInt2);
  
  public final T get(int paramInt)
  {
    eu();
    return (T)c(H(paramInt), I(paramInt));
  }
  
  public int getCount()
  {
    eu();
    return this.BX.size();
  }
  
  protected abstract String getPrimaryDataMarkerColumn();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/common/data/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */