package com.google.android.gms.common.data;

import java.util.ArrayList;

public abstract class g<T>
  extends DataBuffer<T>
{
  private boolean ER = false;
  private ArrayList<Integer> ES;
  
  protected g(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  private void eV()
  {
    for (;;)
    {
      int i;
      try
      {
        if (!this.ER)
        {
          int j = this.DD.getCount();
          this.ES = new ArrayList();
          if (j > 0)
          {
            this.ES.add(Integer.valueOf(0));
            String str2 = eU();
            i = this.DD.ae(0);
            Object localObject1 = this.DD.c(str2, 0, i);
            i = 1;
            if (i < j)
            {
              int k = this.DD.ae(i);
              String str1 = this.DD.c(str2, i, k);
              if (str1.equals(localObject1)) {
                break label145;
              }
              this.ES.add(Integer.valueOf(i));
              localObject1 = str1;
              break label145;
            }
          }
          this.ER = true;
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
    if ((paramInt < 0) || (paramInt >= this.ES.size())) {
      throw new IllegalArgumentException("Position " + paramInt + " is out of bounds for this buffer");
    }
    return ((Integer)this.ES.get(paramInt)).intValue();
  }
  
  protected int ai(int paramInt)
  {
    int j;
    if ((paramInt < 0) || (paramInt == this.ES.size()))
    {
      j = 0;
      return j;
    }
    if (paramInt == this.ES.size() - 1) {}
    for (int i = this.DD.getCount() - ((Integer)this.ES.get(paramInt)).intValue();; i = ((Integer)this.ES.get(paramInt + 1)).intValue() - ((Integer)this.ES.get(paramInt)).intValue())
    {
      j = i;
      if (i != 1) {
        break;
      }
      paramInt = ah(paramInt);
      int k = this.DD.ae(paramInt);
      String str = eW();
      j = i;
      if (str == null) {
        break;
      }
      j = i;
      if (this.DD.c(str, paramInt, k) != null) {
        break;
      }
      return 0;
    }
  }
  
  protected abstract T c(int paramInt1, int paramInt2);
  
  protected abstract String eU();
  
  protected String eW()
  {
    return null;
  }
  
  public final T get(int paramInt)
  {
    eV();
    return (T)c(ah(paramInt), ai(paramInt));
  }
  
  public int getCount()
  {
    eV();
    return this.ES.size();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/common/data/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */