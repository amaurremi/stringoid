package com.amazonaws.javax.xml.stream.xerces.util;

public class SymbolTable
{
  protected SymbolTable.Entry[] fBuckets = null;
  protected int fTableSize;
  protected char[] symbolAsArray = null;
  
  public SymbolTable()
  {
    this(173);
  }
  
  public SymbolTable(int paramInt)
  {
    this.fTableSize = paramInt;
    this.fBuckets = new SymbolTable.Entry[this.fTableSize];
  }
  
  public String addSymbol(String paramString)
  {
    int i = hash(paramString);
    int j = i % this.fTableSize;
    int k = paramString.length();
    for (SymbolTable.Entry localEntry = this.fBuckets[j]; localEntry != null; localEntry = localEntry.next) {
      if ((k == localEntry.characters.length) && (i == localEntry.hashCode) && (paramString.regionMatches(0, localEntry.symbol, 0, k)))
      {
        this.symbolAsArray = localEntry.characters;
        return localEntry.symbol;
      }
    }
    paramString = new SymbolTable.Entry(paramString, this.fBuckets[j]);
    paramString.hashCode = i;
    this.symbolAsArray = paramString.characters;
    this.fBuckets[j] = paramString;
    return paramString.symbol;
  }
  
  public String addSymbol(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int j = hash(paramArrayOfChar, paramInt1, paramInt2);
    int k = j % this.fTableSize;
    SymbolTable.Entry localEntry = this.fBuckets[k];
    if (localEntry != null)
    {
      int i;
      if ((paramInt2 == localEntry.characters.length) && (j == localEntry.hashCode)) {
        i = 0;
      }
      for (;;)
      {
        if (i >= paramInt2) {
          break label97;
        }
        if (paramArrayOfChar[(paramInt1 + i)] != localEntry.characters[i])
        {
          localEntry = localEntry.next;
          break;
        }
        i += 1;
      }
      label97:
      this.symbolAsArray = localEntry.characters;
      return localEntry.symbol;
    }
    paramArrayOfChar = new SymbolTable.Entry(paramArrayOfChar, paramInt1, paramInt2, this.fBuckets[k]);
    this.fBuckets[k] = paramArrayOfChar;
    paramArrayOfChar.hashCode = j;
    this.symbolAsArray = paramArrayOfChar.characters;
    return paramArrayOfChar.symbol;
  }
  
  public char[] getCharArray()
  {
    return this.symbolAsArray;
  }
  
  public int hash(String paramString)
  {
    int i = 0;
    int k = paramString.length();
    int j = 0;
    while (i < k)
    {
      j = j * 37 + paramString.charAt(i);
      i += 1;
    }
    return 0x7FFFFFF & j;
  }
  
  public int hash(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = 0;
    while (i < paramInt2)
    {
      j = j * 37 + paramArrayOfChar[(paramInt1 + i)];
      i += 1;
    }
    return 0x7FFFFFF & j;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/xerces/util/SymbolTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */