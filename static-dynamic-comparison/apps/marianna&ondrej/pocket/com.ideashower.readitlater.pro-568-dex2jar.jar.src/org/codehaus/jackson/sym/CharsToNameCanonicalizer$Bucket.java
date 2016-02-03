package org.codehaus.jackson.sym;

final class CharsToNameCanonicalizer$Bucket
{
  private final String _symbol;
  private final Bucket mNext;
  
  public CharsToNameCanonicalizer$Bucket(String paramString, Bucket paramBucket)
  {
    this._symbol = paramString;
    this.mNext = paramBucket;
  }
  
  public String find(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    String str = this._symbol;
    for (Bucket localBucket = this.mNext;; localBucket = localBucket.getNext())
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
    return this.mNext;
  }
  
  public String getSymbol()
  {
    return this._symbol;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/sym/CharsToNameCanonicalizer$Bucket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */