package com.fasterxml.jackson.core.sym;

import com.fasterxml.jackson.core.util.InternCache;
import java.util.Arrays;

public final class CharsToNameCanonicalizer
{
  static final CharsToNameCanonicalizer sBootstrapSymbolTable = new CharsToNameCanonicalizer();
  protected CharsToNameCanonicalizer.Bucket[] _buckets;
  protected final boolean _canonicalize;
  protected boolean _dirty;
  private final int _hashSeed;
  protected int _indexMask;
  protected final boolean _intern;
  protected int _longestCollisionList;
  protected CharsToNameCanonicalizer _parent;
  protected int _size;
  protected int _sizeThreshold;
  protected String[] _symbols;
  
  private CharsToNameCanonicalizer()
  {
    this._canonicalize = true;
    this._intern = true;
    this._dirty = true;
    this._hashSeed = 0;
    this._longestCollisionList = 0;
    initTables(64);
  }
  
  private CharsToNameCanonicalizer(CharsToNameCanonicalizer paramCharsToNameCanonicalizer, boolean paramBoolean1, boolean paramBoolean2, String[] paramArrayOfString, CharsToNameCanonicalizer.Bucket[] paramArrayOfBucket, int paramInt1, int paramInt2, int paramInt3)
  {
    this._parent = paramCharsToNameCanonicalizer;
    this._canonicalize = paramBoolean1;
    this._intern = paramBoolean2;
    this._symbols = paramArrayOfString;
    this._buckets = paramArrayOfBucket;
    this._size = paramInt1;
    this._hashSeed = paramInt2;
    paramInt1 = paramArrayOfString.length;
    this._sizeThreshold = _thresholdSize(paramInt1);
    this._indexMask = (paramInt1 - 1);
    this._longestCollisionList = paramInt3;
    this._dirty = false;
  }
  
  private static int _thresholdSize(int paramInt)
  {
    return paramInt - (paramInt >> 2);
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
    long l = System.currentTimeMillis();
    int i = (int)l;
    return createRoot((int)(l >>> 32) + i | 0x1);
  }
  
  protected static CharsToNameCanonicalizer createRoot(int paramInt)
  {
    return sBootstrapSymbolTable.makeOrphan(paramInt);
  }
  
  private void initTables(int paramInt)
  {
    this._symbols = new String[paramInt];
    this._buckets = new CharsToNameCanonicalizer.Bucket[paramInt >> 1];
    this._indexMask = (paramInt - 1);
    this._size = 0;
    this._longestCollisionList = 0;
    this._sizeThreshold = _thresholdSize(paramInt);
  }
  
  private CharsToNameCanonicalizer makeOrphan(int paramInt)
  {
    return new CharsToNameCanonicalizer(null, true, true, this._symbols, this._buckets, this._size, paramInt, this._longestCollisionList);
  }
  
  private void mergeChild(CharsToNameCanonicalizer paramCharsToNameCanonicalizer)
  {
    if ((paramCharsToNameCanonicalizer.size() > 12000) || (paramCharsToNameCanonicalizer._longestCollisionList > 63)) {
      try
      {
        initTables(64);
        this._dirty = false;
        return;
      }
      finally {}
    }
    if (paramCharsToNameCanonicalizer.size() > size()) {
      try
      {
        this._symbols = paramCharsToNameCanonicalizer._symbols;
        this._buckets = paramCharsToNameCanonicalizer._buckets;
        this._size = paramCharsToNameCanonicalizer._size;
        this._sizeThreshold = paramCharsToNameCanonicalizer._sizeThreshold;
        this._indexMask = paramCharsToNameCanonicalizer._indexMask;
        this._longestCollisionList = paramCharsToNameCanonicalizer._longestCollisionList;
        this._dirty = false;
        return;
      }
      finally {}
    }
  }
  
  private void rehash()
  {
    int i1 = this._symbols.length;
    int i = i1 + i1;
    if (i > 65536)
    {
      this._size = 0;
      Arrays.fill(this._symbols, null);
      Arrays.fill(this._buckets, null);
      this._dirty = true;
    }
    int k;
    label169:
    do
    {
      return;
      Object localObject1 = this._symbols;
      CharsToNameCanonicalizer.Bucket[] arrayOfBucket = this._buckets;
      this._symbols = new String[i];
      this._buckets = new CharsToNameCanonicalizer.Bucket[i >> 1];
      this._indexMask = (i - 1);
      this._sizeThreshold = _thresholdSize(i);
      k = 0;
      i = 0;
      int j = 0;
      Object localObject2;
      if (k < i1)
      {
        localObject2 = localObject1[k];
        m = i;
        int n = j;
        if (localObject2 != null)
        {
          n = j + 1;
          j = _hashToIndex(calcHash((String)localObject2));
          if (this._symbols[j] != null) {
            break label169;
          }
          this._symbols[j] = localObject2;
        }
        for (m = i;; m = Math.max(i, ((CharsToNameCanonicalizer.Bucket)localObject2).length()))
        {
          k += 1;
          i = m;
          j = n;
          break;
          j >>= 1;
          localObject2 = new CharsToNameCanonicalizer.Bucket((String)localObject2, this._buckets[j]);
          this._buckets[j] = localObject2;
        }
      }
      int m = 0;
      k = j;
      j = m;
      while (j < i1 >> 1)
      {
        localObject1 = arrayOfBucket[j];
        if (localObject1 != null)
        {
          k += 1;
          localObject2 = ((CharsToNameCanonicalizer.Bucket)localObject1).getSymbol();
          m = _hashToIndex(calcHash((String)localObject2));
          if (this._symbols[m] == null) {
            this._symbols[m] = localObject2;
          }
          for (;;)
          {
            localObject1 = ((CharsToNameCanonicalizer.Bucket)localObject1).getNext();
            break;
            m >>= 1;
            localObject2 = new CharsToNameCanonicalizer.Bucket((String)localObject2, this._buckets[m]);
            this._buckets[m] = localObject2;
            i = Math.max(i, ((CharsToNameCanonicalizer.Bucket)localObject2).length());
          }
        }
        j += 1;
      }
      this._longestCollisionList = i;
    } while (k == this._size);
    throw new Error("Internal error on SymbolTable.rehash(): had " + this._size + " entries; now have " + k + ".");
  }
  
  public int _hashToIndex(int paramInt)
  {
    return (paramInt >>> 15) + paramInt & this._indexMask;
  }
  
  public int calcHash(String paramString)
  {
    int k = paramString.length();
    int i = this._hashSeed;
    int j = 0;
    while (j < k)
    {
      int m = paramString.charAt(j);
      j += 1;
      i = m + i * 33;
    }
    j = i;
    if (i == 0) {
      j = 1;
    }
    return j;
  }
  
  public int calcHash(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    paramInt1 = this._hashSeed;
    int i = 0;
    while (i < paramInt2)
    {
      int j = paramArrayOfChar[i];
      i += 1;
      paramInt1 = j + paramInt1 * 33;
    }
    paramInt2 = paramInt1;
    if (paramInt1 == 0) {
      paramInt2 = 1;
    }
    return paramInt2;
  }
  
  public String findSymbol(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 < 1)
    {
      localObject = "";
      return (String)localObject;
    }
    if (!this._canonicalize) {
      return new String(paramArrayOfChar, paramInt1, paramInt2);
    }
    int i = _hashToIndex(paramInt3);
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
            break label112;
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
      label112:
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
      localObject = new String(paramArrayOfChar, paramInt1, paramInt2);
      paramArrayOfChar = (char[])localObject;
      if (this._intern) {
        paramArrayOfChar = InternCache.instance.intern((String)localObject);
      }
      this._size += 1;
      if (this._symbols[paramInt3] == null)
      {
        this._symbols[paramInt3] = paramArrayOfChar;
        return paramArrayOfChar;
        if (this._size >= this._sizeThreshold)
        {
          rehash();
          paramInt3 = _hashToIndex(calcHash(paramArrayOfChar, paramInt1, paramInt2));
        }
      }
      else
      {
        paramInt1 = paramInt3 >> 1;
        localObject = new CharsToNameCanonicalizer.Bucket(paramArrayOfChar, this._buckets[paramInt1]);
        this._buckets[paramInt1] = localObject;
        this._longestCollisionList = Math.max(((CharsToNameCanonicalizer.Bucket)localObject).length(), this._longestCollisionList);
        localObject = paramArrayOfChar;
        if (this._longestCollisionList <= 255) {
          break;
        }
        reportTooManyCollisions(255);
        return paramArrayOfChar;
      }
      paramInt3 = i;
    }
  }
  
  public int hashSeed()
  {
    return this._hashSeed;
  }
  
  public CharsToNameCanonicalizer makeChild(boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      String[] arrayOfString = this._symbols;
      CharsToNameCanonicalizer.Bucket[] arrayOfBucket = this._buckets;
      int i = this._size;
      int j = this._hashSeed;
      int k = this._longestCollisionList;
      return new CharsToNameCanonicalizer(this, paramBoolean1, paramBoolean2, arrayOfString, arrayOfBucket, i, j, k);
    }
    finally {}
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
  
  protected void reportTooManyCollisions(int paramInt)
  {
    throw new IllegalStateException("Longest collision chain in symbol table (of size " + this._size + ") now exceeds maximum, " + paramInt + " -- suspect a DoS attack based on hash collisions");
  }
  
  public int size()
  {
    return this._size;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/core/sym/CharsToNameCanonicalizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */