package com.google.android.gms.internal;

class pi
{
  private static final pj awB = new pj();
  private boolean awC = false;
  private int[] awD;
  private pj[] awE;
  private int mSize;
  
  public pi()
  {
    this(10);
  }
  
  public pi(int paramInt)
  {
    paramInt = idealIntArraySize(paramInt);
    this.awD = new int[paramInt];
    this.awE = new pj[paramInt];
    this.mSize = 0;
  }
  
  private boolean a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      if (paramArrayOfInt1[i] != paramArrayOfInt2[i]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private boolean a(pj[] paramArrayOfpj1, pj[] paramArrayOfpj2, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      if (!paramArrayOfpj1[i].equals(paramArrayOfpj2[i])) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private int gF(int paramInt)
  {
    int i = 0;
    int j = this.mSize - 1;
    while (i <= j)
    {
      int k = i + j >>> 1;
      int m = this.awD[k];
      if (m < paramInt) {
        i = k + 1;
      } else if (m > paramInt) {
        j = k - 1;
      } else {
        return k;
      }
    }
    return i ^ 0xFFFFFFFF;
  }
  
  private void gc()
  {
    int m = this.mSize;
    int[] arrayOfInt = this.awD;
    pj[] arrayOfpj = this.awE;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      pj localpj = arrayOfpj[i];
      k = j;
      if (localpj != awB)
      {
        if (i != j)
        {
          arrayOfInt[j] = arrayOfInt[i];
          arrayOfpj[j] = localpj;
          arrayOfpj[i] = null;
        }
        k = j + 1;
      }
      i += 1;
    }
    this.awC = false;
    this.mSize = j;
  }
  
  private int idealByteArraySize(int paramInt)
  {
    int i = 4;
    for (;;)
    {
      int j = paramInt;
      if (i < 32)
      {
        if (paramInt <= (1 << i) - 12) {
          j = (1 << i) - 12;
        }
      }
      else {
        return j;
      }
      i += 1;
    }
  }
  
  private int idealIntArraySize(int paramInt)
  {
    return idealByteArraySize(paramInt * 4) / 4;
  }
  
  public void a(int paramInt, pj parampj)
  {
    int i = gF(paramInt);
    if (i >= 0)
    {
      this.awE[i] = parampj;
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    if ((j < this.mSize) && (this.awE[j] == awB))
    {
      this.awD[j] = paramInt;
      this.awE[j] = parampj;
      return;
    }
    i = j;
    if (this.awC)
    {
      i = j;
      if (this.mSize >= this.awD.length)
      {
        gc();
        i = gF(paramInt) ^ 0xFFFFFFFF;
      }
    }
    if (this.mSize >= this.awD.length)
    {
      j = idealIntArraySize(this.mSize + 1);
      int[] arrayOfInt = new int[j];
      pj[] arrayOfpj = new pj[j];
      System.arraycopy(this.awD, 0, arrayOfInt, 0, this.awD.length);
      System.arraycopy(this.awE, 0, arrayOfpj, 0, this.awE.length);
      this.awD = arrayOfInt;
      this.awE = arrayOfpj;
    }
    if (this.mSize - i != 0)
    {
      System.arraycopy(this.awD, i, this.awD, i + 1, this.mSize - i);
      System.arraycopy(this.awE, i, this.awE, i + 1, this.mSize - i);
    }
    this.awD[i] = paramInt;
    this.awE[i] = parampj;
    this.mSize += 1;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof pi)) {
        return false;
      }
      paramObject = (pi)paramObject;
      if (size() != ((pi)paramObject).size()) {
        return false;
      }
    } while ((a(this.awD, ((pi)paramObject).awD, this.mSize)) && (a(this.awE, ((pi)paramObject).awE, this.mSize)));
    return false;
  }
  
  public pj gD(int paramInt)
  {
    paramInt = gF(paramInt);
    if ((paramInt < 0) || (this.awE[paramInt] == awB)) {
      return null;
    }
    return this.awE[paramInt];
  }
  
  public pj gE(int paramInt)
  {
    if (this.awC) {
      gc();
    }
    return this.awE[paramInt];
  }
  
  public int hashCode()
  {
    if (this.awC) {
      gc();
    }
    int j = 17;
    int i = 0;
    while (i < this.mSize)
    {
      j = (j * 31 + this.awD[i]) * 31 + this.awE[i].hashCode();
      i += 1;
    }
    return j;
  }
  
  public boolean isEmpty()
  {
    return size() == 0;
  }
  
  public int size()
  {
    if (this.awC) {
      gc();
    }
    return this.mSize;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/pi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */