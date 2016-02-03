package com.ideashower.readitlater.util;

import android.util.SparseArray;

public class t
{
  public static void a(SparseArray paramSparseArray1, SparseArray paramSparseArray2)
  {
    int j = paramSparseArray2.size();
    int i = 0;
    while (i < j)
    {
      paramSparseArray1.put(paramSparseArray2.keyAt(i), paramSparseArray2.valueAt(i));
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/util/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */