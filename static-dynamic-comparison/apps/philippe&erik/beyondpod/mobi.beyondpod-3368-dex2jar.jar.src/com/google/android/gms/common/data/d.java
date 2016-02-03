package com.google.android.gms.common.data;

import java.util.ArrayList;

public abstract class d<T>
  extends DataBuffer<T>
{
  private boolean nZ = false;
  private ArrayList<Integer> oa;
  
  protected d(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  private int E(int paramInt)
  {
    if ((paramInt < 0) || (paramInt == this.oa.size())) {
      return 0;
    }
    if (paramInt == this.oa.size() - 1) {
      return this.nE.getCount() - ((Integer)this.oa.get(paramInt)).intValue();
    }
    return ((Integer)this.oa.get(paramInt + 1)).intValue() - ((Integer)this.oa.get(paramInt)).intValue();
  }
  
  private void by()
  {
    for (;;)
    {
      int i;
      try
      {
        if (!this.nZ)
        {
          int j = this.nE.getCount();
          this.oa = new ArrayList();
          if (j > 0)
          {
            this.oa.add(Integer.valueOf(0));
            String str2 = getPrimaryDataMarkerColumn();
            i = this.nE.C(0);
            Object localObject1 = this.nE.getString(str2, 0, i);
            i = 1;
            if (i < j)
            {
              int k = this.nE.C(i);
              String str1 = this.nE.getString(str2, i, k);
              if (str1.equals(localObject1)) {
                break label145;
              }
              this.oa.add(Integer.valueOf(i));
              localObject1 = str1;
              break label145;
            }
          }
          this.nZ = true;
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
  
  int D(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.oa.size())) {
      throw new IllegalArgumentException("Position " + paramInt + " is out of bounds for this buffer");
    }
    return ((Integer)this.oa.get(paramInt)).intValue();
  }
  
  protected abstract T a(int paramInt1, int paramInt2);
  
  public final T get(int paramInt)
  {
    by();
    return (T)a(D(paramInt), E(paramInt));
  }
  
  public int getCount()
  {
    by();
    return this.oa.size();
  }
  
  protected abstract String getPrimaryDataMarkerColumn();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/common/data/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */