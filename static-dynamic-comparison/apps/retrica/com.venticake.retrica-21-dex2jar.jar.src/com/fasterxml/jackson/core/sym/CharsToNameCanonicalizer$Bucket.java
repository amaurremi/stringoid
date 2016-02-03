package com.fasterxml.jackson.core.sym;

final class CharsToNameCanonicalizer$Bucket
{
  private final int _length;
  private final Bucket _next;
  private final String _symbol;
  
  public CharsToNameCanonicalizer$Bucket(String paramString, Bucket paramBucket)
  {
    this._symbol = paramString;
    this._next = paramBucket;
    if (paramBucket == null) {}
    for (int i = 1;; i = paramBucket._length + 1)
    {
      this._length = i;
      return;
    }
  }
  
  public String find(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    String str = this._symbol;
    for (Bucket localBucket = this._next;; localBucket = localBucket.getNext())
    {
      if (str.length() == paramInt2)
      {
        int i = 0;
        if (str.charAt(i) != paramArrayOfChar[(paramInt1 + i)]) {}
        for (;;)
        {
          if (i != paramInt2) {
            break label72;
          }
          return str;
          int j = i + 1;
          i = j;
          if (j < paramInt2) {
            break;
          }
          i = j;
        }
      }
      label72:
      if (localBucket == null) {
        return null;
      }
      str = localBucket.getSymbol();
    }
  }
  
  public Bucket getNext()
  {
    return this._next;
  }
  
  public String getSymbol()
  {
    return this._symbol;
  }
  
  public int length()
  {
    return this._length;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/core/sym/CharsToNameCanonicalizer$Bucket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */