package org.codehaus.jackson.sym;

import java.util.Arrays;
import org.codehaus.jackson.util.InternCache;

public final class CharsToNameCanonicalizer
{
  protected static final int DEFAULT_TABLE_SIZE = 64;
  static final int MAX_ENTRIES_FOR_REUSE = 12000;
  protected static final int MAX_TABLE_SIZE = 65536;
  static final CharsToNameCanonicalizer sBootstrapSymbolTable = new CharsToNameCanonicalizer();
  protected CharsToNameCanonicalizer.Bucket[] _buckets;
  protected final boolean _canonicalize;
  protected boolean _dirty;
  protected int _indexMask;
  protected final boolean _intern;
  protected CharsToNameCanonicalizer _parent;
  protected int _size;
  protected int _sizeThreshold;
  protected String[] _symbols;
  
  private CharsToNameCanonicalizer()
  {
    this._canonicalize = true;
    this._intern = true;
    this._dirty = true;
    initTables(64);
  }
  
  private CharsToNameCanonicalizer(CharsToNameCanonicalizer paramCharsToNameCanonicalizer, boolean paramBoolean1, boolean paramBoolean2, String[] paramArrayOfString, CharsToNameCanonicalizer.Bucket[] paramArrayOfBucket, int paramInt)
  {
    this._parent = paramCharsToNameCanonicalizer;
    this._canonicalize = paramBoolean1;
    this._intern = paramBoolean2;
    this._symbols = paramArrayOfString;
    this._buckets = paramArrayOfBucket;
    this._size = paramInt;
    paramInt = paramArrayOfString.length;
    this._sizeThreshold = (paramInt - (paramInt >> 2));
    this._indexMask = (paramInt - 1);
    this._dirty = false;
  }
  
  public static int calcHash(String paramString)
  {
    int j = paramString.charAt(0);
    int i = 1;
    int k = paramString.length();
    while (i < k)
    {
      j = j * 31 + paramString.charAt(i);
      i += 1;
    }
    return j;
  }
  
  public static int calcHash(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfChar[0];
    paramInt1 = 1;
    while (paramInt1 < paramInt2)
    {
      i = i * 31 + paramArrayOfChar[paramInt1];
      paramInt1 += 1;
    }
    return i;
  }
  
  private void copyArrays()
  {
    Object localObject = this._symbols;
    int i = localObject.length;
    this._symbols = new String[i];
    System.arraycopy(localObject, 0, this._symbols, 0, i);
    localObject = this._buckets;
    i = localObject.length;
    this._buckets = new CharsToNameCanonicalizer.Bucket[i];
    System.arraycopy(localObject, 0, this._buckets, 0, i);
  }
  
  public static CharsToNameCanonicalizer createRoot()
  {
    return sBootstrapSymbolTable.makeOrphan();
  }
  
  private void initTables(int paramInt)
  {
    this._symbols = new String[paramInt];
    this._buckets = new CharsToNameCanonicalizer.Bucket[paramInt >> 1];
    this._indexMask = (paramInt - 1);
    this._size = 0;
    this._sizeThreshold = (paramInt - (paramInt >> 2));
  }
  
  private CharsToNameCanonicalizer makeOrphan()
  {
    return new CharsToNameCanonicalizer(null, true, true, this._symbols, this._buckets, this._size);
  }
  
  /* Error */
  private void mergeChild(CharsToNameCanonicalizer paramCharsToNameCanonicalizer)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual 91	org/codehaus/jackson/sym/CharsToNameCanonicalizer:size	()I
    //   6: sipush 12000
    //   9: if_icmple +17 -> 26
    //   12: aload_0
    //   13: bipush 64
    //   15: invokespecial 44	org/codehaus/jackson/sym/CharsToNameCanonicalizer:initTables	(I)V
    //   18: aload_0
    //   19: iconst_0
    //   20: putfield 40	org/codehaus/jackson/sym/CharsToNameCanonicalizer:_dirty	Z
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_1
    //   27: invokevirtual 91	org/codehaus/jackson/sym/CharsToNameCanonicalizer:size	()I
    //   30: aload_0
    //   31: invokevirtual 91	org/codehaus/jackson/sym/CharsToNameCanonicalizer:size	()I
    //   34: if_icmple -11 -> 23
    //   37: aload_0
    //   38: aload_1
    //   39: getfield 49	org/codehaus/jackson/sym/CharsToNameCanonicalizer:_symbols	[Ljava/lang/String;
    //   42: putfield 49	org/codehaus/jackson/sym/CharsToNameCanonicalizer:_symbols	[Ljava/lang/String;
    //   45: aload_0
    //   46: aload_1
    //   47: getfield 51	org/codehaus/jackson/sym/CharsToNameCanonicalizer:_buckets	[Lorg/codehaus/jackson/sym/CharsToNameCanonicalizer$Bucket;
    //   50: putfield 51	org/codehaus/jackson/sym/CharsToNameCanonicalizer:_buckets	[Lorg/codehaus/jackson/sym/CharsToNameCanonicalizer$Bucket;
    //   53: aload_0
    //   54: aload_1
    //   55: getfield 53	org/codehaus/jackson/sym/CharsToNameCanonicalizer:_size	I
    //   58: putfield 53	org/codehaus/jackson/sym/CharsToNameCanonicalizer:_size	I
    //   61: aload_0
    //   62: aload_1
    //   63: getfield 55	org/codehaus/jackson/sym/CharsToNameCanonicalizer:_sizeThreshold	I
    //   66: putfield 55	org/codehaus/jackson/sym/CharsToNameCanonicalizer:_sizeThreshold	I
    //   69: aload_0
    //   70: aload_1
    //   71: getfield 57	org/codehaus/jackson/sym/CharsToNameCanonicalizer:_indexMask	I
    //   74: putfield 57	org/codehaus/jackson/sym/CharsToNameCanonicalizer:_indexMask	I
    //   77: goto -59 -> 18
    //   80: astore_1
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_1
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	CharsToNameCanonicalizer
    //   0	85	1	paramCharsToNameCanonicalizer	CharsToNameCanonicalizer
    // Exception table:
    //   from	to	target	type
    //   2	18	80	finally
    //   18	23	80	finally
    //   26	77	80	finally
  }
  
  private void rehash()
  {
    int m = this._symbols.length;
    int i = m + m;
    if (i > 65536)
    {
      this._size = 0;
      Arrays.fill(this._symbols, null);
      Arrays.fill(this._buckets, null);
      this._dirty = true;
    }
    int j;
    label160:
    do
    {
      return;
      Object localObject = this._symbols;
      CharsToNameCanonicalizer.Bucket[] arrayOfBucket = this._buckets;
      this._symbols = new String[i];
      this._buckets = new CharsToNameCanonicalizer.Bucket[i >> 1];
      this._indexMask = (i - 1);
      this._sizeThreshold += this._sizeThreshold;
      j = 0;
      i = 0;
      String str;
      if (j < m)
      {
        str = localObject[j];
        k = i;
        if (str != null)
        {
          k = i + 1;
          i = calcHash(str) & this._indexMask;
          if (this._symbols[i] != null) {
            break label160;
          }
          this._symbols[i] = str;
        }
        for (;;)
        {
          j += 1;
          i = k;
          break;
          i >>= 1;
          this._buckets[i] = new CharsToNameCanonicalizer.Bucket(str, this._buckets[i]);
        }
      }
      int k = 0;
      j = i;
      i = k;
      while (i < m >> 1)
      {
        localObject = arrayOfBucket[i];
        if (localObject != null)
        {
          j += 1;
          str = ((CharsToNameCanonicalizer.Bucket)localObject).getSymbol();
          k = calcHash(str) & this._indexMask;
          if (this._symbols[k] == null) {
            this._symbols[k] = str;
          }
          for (;;)
          {
            localObject = ((CharsToNameCanonicalizer.Bucket)localObject).getNext();
            break;
            k >>= 1;
            this._buckets[k] = new CharsToNameCanonicalizer.Bucket(str, this._buckets[k]);
          }
        }
        i += 1;
      }
    } while (j == this._size);
    throw new Error("Internal error on SymbolTable.rehash(): had " + this._size + " entries; now have " + j + ".");
  }
  
  public String findSymbol(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 < 1) {
      return "";
    }
    if (!this._canonicalize) {
      return new String(paramArrayOfChar, paramInt1, paramInt2);
    }
    int i = paramInt3 & this._indexMask;
    Object localObject = this._symbols[i];
    if (localObject != null)
    {
      if (((String)localObject).length() == paramInt2)
      {
        paramInt3 = 0;
        if (((String)localObject).charAt(paramInt3) != paramArrayOfChar[(paramInt1 + paramInt3)]) {}
        for (;;)
        {
          if (paramInt3 != paramInt2) {
            break label109;
          }
          return (String)localObject;
          int j = paramInt3 + 1;
          paramInt3 = j;
          if (j < paramInt2) {
            break;
          }
          paramInt3 = j;
        }
      }
      label109:
      localObject = this._buckets[(i >> 1)];
      if (localObject != null)
      {
        localObject = ((CharsToNameCanonicalizer.Bucket)localObject).find(paramArrayOfChar, paramInt1, paramInt2);
        if (localObject != null) {
          return (String)localObject;
        }
      }
    }
    if (!this._dirty)
    {
      copyArrays();
      this._dirty = true;
      paramInt3 = i;
    }
    for (;;)
    {
      this._size += 1;
      localObject = new String(paramArrayOfChar, paramInt1, paramInt2);
      paramArrayOfChar = (char[])localObject;
      if (this._intern) {
        paramArrayOfChar = InternCache.instance.intern((String)localObject);
      }
      if (this._symbols[paramInt3] == null)
      {
        this._symbols[paramInt3] = paramArrayOfChar;
        return paramArrayOfChar;
        if (this._size >= this._sizeThreshold)
        {
          rehash();
          paramInt3 = calcHash(paramArrayOfChar, paramInt1, paramInt2) & this._indexMask;
        }
      }
      else
      {
        paramInt1 = paramInt3 >> 1;
        this._buckets[paramInt1] = new CharsToNameCanonicalizer.Bucket(paramArrayOfChar, this._buckets[paramInt1]);
        return paramArrayOfChar;
      }
      paramInt3 = i;
    }
  }
  
  public CharsToNameCanonicalizer makeChild(boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      CharsToNameCanonicalizer localCharsToNameCanonicalizer = new CharsToNameCanonicalizer(this, paramBoolean1, paramBoolean2, this._symbols, this._buckets, this._size);
      return localCharsToNameCanonicalizer;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean maybeDirty()
  {
    return this._dirty;
  }
  
  public void release()
  {
    if (!maybeDirty()) {}
    while (this._parent == null) {
      return;
    }
    this._parent.mergeChild(this);
    this._dirty = false;
  }
  
  public int size()
  {
    return this._size;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/sym/CharsToNameCanonicalizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */