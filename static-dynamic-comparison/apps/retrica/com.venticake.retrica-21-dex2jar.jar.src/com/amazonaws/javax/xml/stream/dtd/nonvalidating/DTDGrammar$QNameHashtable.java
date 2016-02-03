package com.amazonaws.javax.xml.stream.dtd.nonvalidating;

public final class DTDGrammar$QNameHashtable
{
  private Object[][] fHashTable = new Object[101][];
  
  public int get(String paramString)
  {
    int i = hash(paramString);
    Object[] arrayOfObject = this.fHashTable[((i + 2) % 101)];
    if (arrayOfObject == null) {
      return -1;
    }
    int k = ((int[])(int[])arrayOfObject[0])[0];
    i = 0;
    int j = 1;
    while (i < k)
    {
      if ((String)arrayOfObject[j] == paramString) {
        return ((int[])(int[])arrayOfObject[(j + 1)])[0];
      }
      j += 2;
      i += 1;
    }
    return -1;
  }
  
  protected int hash(String paramString)
  {
    int i = 0;
    if (paramString == null) {
      return 0;
    }
    int k = paramString.length();
    int j = 0;
    while (i < k)
    {
      j = j * 37 + paramString.charAt(i);
      i += 1;
    }
    return 0x7FFFFFF & j;
  }
  
  public void put(String paramString, int paramInt)
  {
    int i = (hash(paramString) + 2) % 101;
    Object[] arrayOfObject2 = this.fHashTable[i];
    Object[] arrayOfObject1;
    if (arrayOfObject2 == null)
    {
      arrayOfObject1 = new Object[9];
      arrayOfObject1[0] = { 1 };
      arrayOfObject1[1] = paramString;
      arrayOfObject1[2] = { paramInt };
      this.fHashTable[i] = arrayOfObject1;
    }
    label231:
    for (;;)
    {
      return;
      int k = ((int[])(int[])arrayOfObject2[0])[0];
      int m = k * 2 + 1;
      arrayOfObject1 = arrayOfObject2;
      if (m == arrayOfObject2.length)
      {
        arrayOfObject1 = new Object[(k + 4) * 2 + 1];
        System.arraycopy(arrayOfObject2, 0, arrayOfObject1, 0, m);
        this.fHashTable[i] = arrayOfObject1;
      }
      i = 0;
      int j = 1;
      if (i < k) {
        if ((String)arrayOfObject1[j] == paramString) {
          ((int[])arrayOfObject1[(j + 1)])[0] = paramInt;
        }
      }
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label231;
        }
        arrayOfObject1[m] = paramString;
        arrayOfObject1[(m + 1)] = { paramInt };
        ((int[])arrayOfObject1[0])[0] = (k + 1);
        return;
        j += 2;
        i += 1;
        break;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/dtd/nonvalidating/DTDGrammar$QNameHashtable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */