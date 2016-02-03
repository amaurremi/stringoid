package org.codehaus.jackson.sym;

import java.util.Arrays;
import org.codehaus.jackson.util.InternCache;

public final class BytesToNameCanonicalizer
{
  protected static final int DEFAULT_TABLE_SIZE = 64;
  static final int INITIAL_COLLISION_LEN = 32;
  static final int LAST_VALID_BUCKET = 254;
  static final int MAX_ENTRIES_FOR_REUSE = 6000;
  protected static final int MAX_TABLE_SIZE = 65536;
  static final int MIN_HASH_SIZE = 16;
  private int _collCount;
  private int _collEnd;
  private BytesToNameCanonicalizer.Bucket[] _collList;
  private boolean _collListShared;
  private int _count;
  final boolean _intern;
  private int[] _mainHash;
  private int _mainHashMask;
  private boolean _mainHashShared;
  private Name[] _mainNames;
  private boolean _mainNamesShared;
  private transient boolean _needRehash;
  final BytesToNameCanonicalizer _parent;
  
  private BytesToNameCanonicalizer(int paramInt, boolean paramBoolean)
  {
    this._parent = null;
    this._intern = paramBoolean;
    int i;
    if (paramInt < 16) {
      i = 16;
    }
    for (;;)
    {
      initTables(i);
      return;
      i = paramInt;
      if ((paramInt - 1 & paramInt) != 0)
      {
        i = j;
        while (i < paramInt) {
          i += i;
        }
      }
    }
  }
  
  private BytesToNameCanonicalizer(BytesToNameCanonicalizer paramBytesToNameCanonicalizer, boolean paramBoolean)
  {
    this._parent = paramBytesToNameCanonicalizer;
    this._intern = paramBoolean;
    this._count = paramBytesToNameCanonicalizer._count;
    this._mainHashMask = paramBytesToNameCanonicalizer._mainHashMask;
    this._mainHash = paramBytesToNameCanonicalizer._mainHash;
    this._mainNames = paramBytesToNameCanonicalizer._mainNames;
    this._collList = paramBytesToNameCanonicalizer._collList;
    this._collCount = paramBytesToNameCanonicalizer._collCount;
    this._collEnd = paramBytesToNameCanonicalizer._collEnd;
    this._needRehash = false;
    this._mainHashShared = true;
    this._mainNamesShared = true;
    this._collListShared = true;
  }
  
  private void _addSymbol(int paramInt, Name paramName)
  {
    if (this._mainHashShared) {
      unshareMain();
    }
    if (this._needRehash) {
      rehash();
    }
    this._count += 1;
    int j = paramInt & this._mainHashMask;
    int i;
    if (this._mainNames[j] == null)
    {
      this._mainHash[j] = (paramInt << 8);
      if (this._mainNamesShared) {
        unshareNames();
      }
      this._mainNames[j] = paramName;
      paramInt = this._mainHash.length;
      if (this._count > paramInt >> 1)
      {
        i = paramInt >> 2;
        if (this._count <= paramInt - i) {
          break label254;
        }
        this._needRehash = true;
      }
    }
    label199:
    label254:
    while (this._collCount < i)
    {
      return;
      if (this._collListShared) {
        unshareCollision();
      }
      this._collCount += 1;
      int k = this._mainHash[j];
      paramInt = k & 0xFF;
      if (paramInt == 0) {
        if (this._collEnd <= 254)
        {
          i = this._collEnd;
          this._collEnd += 1;
          paramInt = i;
          if (i >= this._collList.length)
          {
            expandCollision();
            paramInt = i;
          }
          this._mainHash[j] = (k & 0xFF00 | paramInt + 1);
        }
      }
      for (;;)
      {
        this._collList[paramInt] = new BytesToNameCanonicalizer.Bucket(paramName, this._collList[paramInt]);
        break;
        paramInt = findBestBucket();
        break label199;
        paramInt -= 1;
      }
    }
    this._needRehash = true;
  }
  
  public static final int calcHash(int paramInt)
  {
    paramInt = paramInt >>> 16 ^ paramInt;
    return paramInt ^ paramInt >>> 8;
  }
  
  public static final int calcHash(int paramInt1, int paramInt2)
  {
    paramInt1 = paramInt1 * 31 + paramInt2;
    paramInt1 ^= paramInt1 >>> 16;
    return paramInt1 ^ paramInt1 >>> 8;
  }
  
  public static final int calcHash(int[] paramArrayOfInt, int paramInt)
  {
    int j = paramArrayOfInt[0];
    int i = 1;
    while (i < paramInt)
    {
      j = j * 31 + paramArrayOfInt[i];
      i += 1;
    }
    paramInt = j >>> 16 ^ j;
    return paramInt ^ paramInt >>> 8;
  }
  
  private static Name constructName(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 0) {
      return new Name1(paramString, paramInt1, paramInt2);
    }
    return new Name2(paramString, paramInt1, paramInt2, paramInt3);
  }
  
  private static Name constructName(int paramInt1, String paramString, int[] paramArrayOfInt, int paramInt2)
  {
    if (paramInt2 < 4) {}
    int[] arrayOfInt;
    int i;
    switch (paramInt2)
    {
    default: 
      arrayOfInt = new int[paramInt2];
      i = 0;
    }
    while (i < paramInt2)
    {
      arrayOfInt[i] = paramArrayOfInt[i];
      i += 1;
      continue;
      return new Name1(paramString, paramInt1, paramArrayOfInt[0]);
      return new Name2(paramString, paramInt1, paramArrayOfInt[0], paramArrayOfInt[1]);
      return new Name3(paramString, paramInt1, paramArrayOfInt[0], paramArrayOfInt[1], paramArrayOfInt[2]);
    }
    return new NameN(paramString, paramInt1, arrayOfInt, paramInt2);
  }
  
  public static BytesToNameCanonicalizer createRoot()
  {
    return new BytesToNameCanonicalizer(64, true);
  }
  
  private void expandCollision()
  {
    BytesToNameCanonicalizer.Bucket[] arrayOfBucket = this._collList;
    int i = arrayOfBucket.length;
    this._collList = new BytesToNameCanonicalizer.Bucket[i + i];
    System.arraycopy(arrayOfBucket, 0, this._collList, 0, i);
  }
  
  private int findBestBucket()
  {
    BytesToNameCanonicalizer.Bucket[] arrayOfBucket = this._collList;
    int j = Integer.MAX_VALUE;
    int k = -1;
    int i = 0;
    int n = this._collEnd;
    if (i < n)
    {
      int m = arrayOfBucket[i].length();
      if (m >= j) {
        break label62;
      }
      if (m == 1) {
        return i;
      }
      k = i;
      j = m;
    }
    label62:
    for (;;)
    {
      i += 1;
      break;
      return k;
    }
  }
  
  public static Name getEmptyName()
  {
    return Name1.getEmptyName();
  }
  
  private void initTables(int paramInt)
  {
    this._count = 0;
    this._mainHash = new int[paramInt];
    this._mainNames = new Name[paramInt];
    this._mainHashShared = false;
    this._mainNamesShared = false;
    this._mainHashMask = (paramInt - 1);
    this._collListShared = true;
    this._collList = null;
    this._collEnd = 0;
    this._needRehash = false;
  }
  
  private void markAsShared()
  {
    this._mainHashShared = true;
    this._mainNamesShared = true;
    this._collListShared = true;
  }
  
  private void mergeChild(BytesToNameCanonicalizer paramBytesToNameCanonicalizer)
  {
    for (;;)
    {
      try
      {
        int i = paramBytesToNameCanonicalizer._count;
        int j = this._count;
        if (i <= j) {
          return;
        }
        if (paramBytesToNameCanonicalizer.size() > 6000)
        {
          initTables(64);
          continue;
        }
        this._count = paramBytesToNameCanonicalizer._count;
      }
      finally {}
      this._mainHash = paramBytesToNameCanonicalizer._mainHash;
      this._mainNames = paramBytesToNameCanonicalizer._mainNames;
      this._mainHashShared = true;
      this._mainNamesShared = true;
      this._mainHashMask = paramBytesToNameCanonicalizer._mainHashMask;
      this._collList = paramBytesToNameCanonicalizer._collList;
      this._collCount = paramBytesToNameCanonicalizer._collCount;
      this._collEnd = paramBytesToNameCanonicalizer._collEnd;
    }
  }
  
  private void nukeSymbols()
  {
    this._count = 0;
    Arrays.fill(this._mainHash, 0);
    Arrays.fill(this._mainNames, null);
    Arrays.fill(this._collList, null);
    this._collCount = 0;
    this._collEnd = 0;
  }
  
  private void rehash()
  {
    this._needRehash = false;
    this._mainNamesShared = false;
    int m = this._mainHash.length;
    int i = m + m;
    if (i > 65536) {
      nukeSymbols();
    }
    label334:
    do
    {
      Object localObject;
      int j;
      int n;
      do
      {
        return;
        this._mainHash = new int[i];
        this._mainHashMask = (i - 1);
        localObject = this._mainNames;
        this._mainNames = new Name[i];
        j = 0;
        for (i = 0; j < m; i = k)
        {
          arrayOfBucket = localObject[j];
          k = i;
          if (arrayOfBucket != null)
          {
            k = i + 1;
            i = arrayOfBucket.hashCode();
            n = this._mainHashMask & i;
            this._mainNames[n] = arrayOfBucket;
            this._mainHash[n] = (i << 8);
          }
          j += 1;
        }
        n = this._collEnd;
      } while (n == 0);
      this._collCount = 0;
      this._collEnd = 0;
      this._collListShared = false;
      BytesToNameCanonicalizer.Bucket[] arrayOfBucket = this._collList;
      this._collList = new BytesToNameCanonicalizer.Bucket[arrayOfBucket.length];
      int k = 0;
      while (k < n)
      {
        localObject = arrayOfBucket[k];
        while (localObject != null)
        {
          Name localName = ((BytesToNameCanonicalizer.Bucket)localObject)._name;
          j = localName.hashCode();
          int i1 = this._mainHashMask & j;
          int i2 = this._mainHash[i1];
          if (this._mainNames[i1] == null)
          {
            this._mainHash[i1] = (j << 8);
            this._mainNames[i1] = localName;
            localObject = ((BytesToNameCanonicalizer.Bucket)localObject)._next;
            i += 1;
          }
          else
          {
            this._collCount += 1;
            j = i2 & 0xFF;
            if (j == 0) {
              if (this._collEnd <= 254)
              {
                m = this._collEnd;
                this._collEnd += 1;
                j = m;
                if (m >= this._collList.length)
                {
                  expandCollision();
                  j = m;
                }
                this._mainHash[i1] = (i2 & 0xFF00 | j + 1);
              }
            }
            for (;;)
            {
              this._collList[j] = new BytesToNameCanonicalizer.Bucket(localName, this._collList[j]);
              break;
              j = findBestBucket();
              break label334;
              j -= 1;
            }
          }
        }
        k += 1;
      }
    } while (i == this._count);
    throw new RuntimeException("Internal error: count after rehash " + i + "; should be " + this._count);
  }
  
  private void unshareCollision()
  {
    BytesToNameCanonicalizer.Bucket[] arrayOfBucket = this._collList;
    if (arrayOfBucket == null) {
      this._collList = new BytesToNameCanonicalizer.Bucket[32];
    }
    for (;;)
    {
      this._collListShared = false;
      return;
      int i = arrayOfBucket.length;
      this._collList = new BytesToNameCanonicalizer.Bucket[i];
      System.arraycopy(arrayOfBucket, 0, this._collList, 0, i);
    }
  }
  
  private void unshareMain()
  {
    int[] arrayOfInt = this._mainHash;
    int i = this._mainHash.length;
    this._mainHash = new int[i];
    System.arraycopy(arrayOfInt, 0, this._mainHash, 0, i);
    this._mainHashShared = false;
  }
  
  private void unshareNames()
  {
    Name[] arrayOfName = this._mainNames;
    int i = arrayOfName.length;
    this._mainNames = new Name[i];
    System.arraycopy(arrayOfName, 0, this._mainNames, 0, i);
    this._mainNamesShared = false;
  }
  
  public Name addName(String paramString, int paramInt1, int paramInt2)
  {
    String str = paramString;
    if (this._intern) {
      str = InternCache.instance.intern(paramString);
    }
    if (paramInt2 == 0) {}
    for (int i = calcHash(paramInt1);; i = calcHash(paramInt1, paramInt2))
    {
      paramString = constructName(i, str, paramInt1, paramInt2);
      _addSymbol(i, paramString);
      return paramString;
    }
  }
  
  public Name addName(String paramString, int[] paramArrayOfInt, int paramInt)
  {
    String str = paramString;
    if (this._intern) {
      str = InternCache.instance.intern(paramString);
    }
    int i = calcHash(paramArrayOfInt, paramInt);
    paramString = constructName(i, str, paramArrayOfInt, paramInt);
    _addSymbol(i, paramString);
    return paramString;
  }
  
  public Name findName(int paramInt)
  {
    int i = calcHash(paramInt);
    int j = this._mainHashMask & i;
    int k = this._mainHash[j];
    Object localObject;
    if ((k >> 8 ^ i) << 8 == 0)
    {
      localObject = this._mainNames[j];
      if (localObject != null) {}
    }
    do
    {
      do
      {
        do
        {
          return null;
          if (!((Name)localObject).equals(paramInt)) {
            break;
          }
          return (Name)localObject;
        } while (k == 0);
        j = k & 0xFF;
      } while (j <= 0);
      localObject = this._collList[(j - 1)];
    } while (localObject == null);
    return ((BytesToNameCanonicalizer.Bucket)localObject).find(i, paramInt, 0);
  }
  
  public Name findName(int paramInt1, int paramInt2)
  {
    int i = calcHash(paramInt1, paramInt2);
    int j = this._mainHashMask & i;
    int k = this._mainHash[j];
    Object localObject;
    if ((k >> 8 ^ i) << 8 == 0)
    {
      localObject = this._mainNames[j];
      if (localObject != null) {}
    }
    do
    {
      do
      {
        do
        {
          return null;
          if (!((Name)localObject).equals(paramInt1, paramInt2)) {
            break;
          }
          return (Name)localObject;
        } while (k == 0);
        j = k & 0xFF;
      } while (j <= 0);
      localObject = this._collList[(j - 1)];
    } while (localObject == null);
    return ((BytesToNameCanonicalizer.Bucket)localObject).find(i, paramInt1, paramInt2);
  }
  
  public Name findName(int[] paramArrayOfInt, int paramInt)
  {
    int i = calcHash(paramArrayOfInt, paramInt);
    int j = this._mainHashMask & i;
    int k = this._mainHash[j];
    Object localObject;
    if ((k >> 8 ^ i) << 8 == 0)
    {
      localObject = this._mainNames[j];
      if ((localObject == null) || (((Name)localObject).equals(paramArrayOfInt, paramInt))) {
        return (Name)localObject;
      }
    }
    else if (k == 0)
    {
      return null;
    }
    j = k & 0xFF;
    if (j > 0)
    {
      localObject = this._collList[(j - 1)];
      if (localObject != null) {
        return ((BytesToNameCanonicalizer.Bucket)localObject).find(i, paramArrayOfInt, paramInt);
      }
    }
    return null;
  }
  
  public BytesToNameCanonicalizer makeChild(boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      BytesToNameCanonicalizer localBytesToNameCanonicalizer = new BytesToNameCanonicalizer(this, paramBoolean2);
      return localBytesToNameCanonicalizer;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean maybeDirty()
  {
    return !this._mainHashShared;
  }
  
  public void release()
  {
    if ((maybeDirty()) && (this._parent != null))
    {
      this._parent.mergeChild(this);
      markAsShared();
    }
  }
  
  public int size()
  {
    return this._count;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/sym/BytesToNameCanonicalizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */