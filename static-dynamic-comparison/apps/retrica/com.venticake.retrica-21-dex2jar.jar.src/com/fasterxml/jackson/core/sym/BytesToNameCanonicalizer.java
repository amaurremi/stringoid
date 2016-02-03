package com.fasterxml.jackson.core.sym;

import com.fasterxml.jackson.core.util.InternCache;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public final class BytesToNameCanonicalizer
{
  protected int _collCount;
  protected int _collEnd;
  protected BytesToNameCanonicalizer.Bucket[] _collList;
  private boolean _collListShared;
  protected int _count;
  private final int _hashSeed;
  protected final boolean _intern;
  protected int _longestCollisionList;
  protected int[] _mainHash;
  protected int _mainHashMask;
  private boolean _mainHashShared;
  protected Name[] _mainNames;
  private boolean _mainNamesShared;
  private transient boolean _needRehash;
  protected final BytesToNameCanonicalizer _parent;
  protected final AtomicReference<BytesToNameCanonicalizer.TableInfo> _tableInfo;
  
  private BytesToNameCanonicalizer(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    this._parent = null;
    this._hashSeed = paramInt2;
    this._intern = paramBoolean;
    if (paramInt1 < 16) {
      paramInt2 = 16;
    }
    for (;;)
    {
      this._tableInfo = new AtomicReference(initTableInfo(paramInt2));
      return;
      paramInt2 = paramInt1;
      if ((paramInt1 - 1 & paramInt1) != 0)
      {
        paramInt2 = i;
        while (paramInt2 < paramInt1) {
          paramInt2 += paramInt2;
        }
      }
    }
  }
  
  private BytesToNameCanonicalizer(BytesToNameCanonicalizer paramBytesToNameCanonicalizer, boolean paramBoolean, int paramInt, BytesToNameCanonicalizer.TableInfo paramTableInfo)
  {
    this._parent = paramBytesToNameCanonicalizer;
    this._hashSeed = paramInt;
    this._intern = paramBoolean;
    this._tableInfo = null;
    this._count = paramTableInfo.count;
    this._mainHashMask = paramTableInfo.mainHashMask;
    this._mainHash = paramTableInfo.mainHash;
    this._mainNames = paramTableInfo.mainNames;
    this._collList = paramTableInfo.collList;
    this._collCount = paramTableInfo.collCount;
    this._collEnd = paramTableInfo.collEnd;
    this._longestCollisionList = paramTableInfo.longestCollisionList;
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
          break label288;
        }
        this._needRehash = true;
      }
    }
    label199:
    label288:
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
        paramName = new BytesToNameCanonicalizer.Bucket(paramName, this._collList[paramInt]);
        this._collList[paramInt] = paramName;
        this._longestCollisionList = Math.max(paramName.length(), this._longestCollisionList);
        if (this._longestCollisionList <= 255) {
          break;
        }
        reportTooManyCollisions(255);
        break;
        paramInt = findBestBucket();
        break label199;
        paramInt -= 1;
      }
    }
    this._needRehash = true;
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
    long l = System.currentTimeMillis();
    int i = (int)l;
    return createRoot((int)(l >>> 32) + i | 0x1);
  }
  
  protected static BytesToNameCanonicalizer createRoot(int paramInt)
  {
    return new BytesToNameCanonicalizer(64, true, paramInt);
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
  
  private BytesToNameCanonicalizer.TableInfo initTableInfo(int paramInt)
  {
    return new BytesToNameCanonicalizer.TableInfo(0, paramInt - 1, new int[paramInt], new Name[paramInt], null, 0, 0, 0);
  }
  
  private void mergeChild(BytesToNameCanonicalizer.TableInfo paramTableInfo)
  {
    int i = paramTableInfo.count;
    BytesToNameCanonicalizer.TableInfo localTableInfo2 = (BytesToNameCanonicalizer.TableInfo)this._tableInfo.get();
    if (i <= localTableInfo2.count) {
      return;
    }
    BytesToNameCanonicalizer.TableInfo localTableInfo1;
    if (i <= 6000)
    {
      localTableInfo1 = paramTableInfo;
      if (paramTableInfo.longestCollisionList <= 63) {}
    }
    else
    {
      localTableInfo1 = initTableInfo(64);
    }
    this._tableInfo.compareAndSet(localTableInfo2, localTableInfo1);
  }
  
  private void nukeSymbols()
  {
    this._count = 0;
    this._longestCollisionList = 0;
    Arrays.fill(this._mainHash, 0);
    Arrays.fill(this._mainNames, null);
    Arrays.fill(this._collList, null);
    this._collCount = 0;
    this._collEnd = 0;
  }
  
  private void rehash()
  {
    int n = 0;
    this._needRehash = false;
    this._mainNamesShared = false;
    int m = this._mainHash.length;
    int i = m + m;
    if (i > 65536) {
      nukeSymbols();
    }
    label349:
    do
    {
      return;
      this._mainHash = new int[i];
      this._mainHashMask = (i - 1);
      Object localObject1 = this._mainNames;
      this._mainNames = new Name[i];
      int j = 0;
      int k;
      for (i = 0; j < m; i = k)
      {
        arrayOfBucket = localObject1[j];
        k = i;
        if (arrayOfBucket != null)
        {
          k = i + 1;
          i = arrayOfBucket.hashCode();
          i1 = this._mainHashMask & i;
          this._mainNames[i1] = arrayOfBucket;
          this._mainHash[i1] = (i << 8);
        }
        j += 1;
      }
      int i1 = this._collEnd;
      if (i1 == 0)
      {
        this._longestCollisionList = 0;
        return;
      }
      this._collCount = 0;
      this._collEnd = 0;
      this._collListShared = false;
      BytesToNameCanonicalizer.Bucket[] arrayOfBucket = this._collList;
      this._collList = new BytesToNameCanonicalizer.Bucket[arrayOfBucket.length];
      m = 0;
      j = n;
      while (m < i1)
      {
        localObject1 = arrayOfBucket[m];
        while (localObject1 != null)
        {
          Object localObject2 = ((BytesToNameCanonicalizer.Bucket)localObject1)._name;
          k = ((Name)localObject2).hashCode();
          int i2 = this._mainHashMask & k;
          int i3 = this._mainHash[i2];
          if (this._mainNames[i2] == null)
          {
            this._mainHash[i2] = (k << 8);
            this._mainNames[i2] = localObject2;
            localObject1 = ((BytesToNameCanonicalizer.Bucket)localObject1)._next;
            i += 1;
          }
          else
          {
            this._collCount += 1;
            k = i3 & 0xFF;
            if (k == 0) {
              if (this._collEnd <= 254)
              {
                n = this._collEnd;
                this._collEnd += 1;
                k = n;
                if (n >= this._collList.length)
                {
                  expandCollision();
                  k = n;
                }
                this._mainHash[i2] = (i3 & 0xFF00 | k + 1);
              }
            }
            for (;;)
            {
              localObject2 = new BytesToNameCanonicalizer.Bucket((Name)localObject2, this._collList[k]);
              this._collList[k] = localObject2;
              j = Math.max(j, ((BytesToNameCanonicalizer.Bucket)localObject2).length());
              break;
              k = findBestBucket();
              break label349;
              k -= 1;
            }
          }
        }
        m += 1;
      }
      this._longestCollisionList = j;
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
  
  public Name addName(String paramString, int[] paramArrayOfInt, int paramInt)
  {
    String str = paramString;
    if (this._intern) {
      str = InternCache.instance.intern(paramString);
    }
    int i;
    if (paramInt < 3) {
      if (paramInt == 1) {
        i = calcHash(paramArrayOfInt[0]);
      }
    }
    for (;;)
    {
      paramString = constructName(i, str, paramArrayOfInt, paramInt);
      _addSymbol(i, paramString);
      return paramString;
      i = calcHash(paramArrayOfInt[0], paramArrayOfInt[1]);
      continue;
      i = calcHash(paramArrayOfInt, paramInt);
    }
  }
  
  public int calcHash(int paramInt)
  {
    paramInt = this._hashSeed ^ paramInt;
    paramInt += (paramInt >>> 15);
    return paramInt ^ paramInt >>> 9;
  }
  
  public int calcHash(int paramInt1, int paramInt2)
  {
    paramInt1 = (paramInt1 >>> 15 ^ paramInt1) + paramInt2 * 33 ^ this._hashSeed;
    return paramInt1 + (paramInt1 >>> 7);
  }
  
  public int calcHash(int[] paramArrayOfInt, int paramInt)
  {
    int i = 3;
    if (paramInt < 3) {
      throw new IllegalArgumentException();
    }
    int j = paramArrayOfInt[0] ^ this._hashSeed;
    j = ((j + (j >>> 9)) * 33 + paramArrayOfInt[1]) * 65599;
    j = j + (j >>> 15) ^ paramArrayOfInt[2];
    j += (j >>> 17);
    while (i < paramInt)
    {
      j = j * 31 ^ paramArrayOfInt[i];
      j += (j >>> 3);
      j ^= j << 7;
      i += 1;
    }
    paramInt = (j >>> 15) + j;
    return paramInt ^ paramInt << 9;
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
    if (paramInt2 == 0) {}
    int k;
    Object localObject;
    for (int i = calcHash(paramInt1);; i = calcHash(paramInt1, paramInt2))
    {
      j = this._mainHashMask & i;
      k = this._mainHash[j];
      if ((k >> 8 ^ i) << 8 != 0) {
        break label79;
      }
      localObject = this._mainNames[j];
      if (localObject != null) {
        break;
      }
      return null;
    }
    if (((Name)localObject).equals(paramInt1, paramInt2))
    {
      return (Name)localObject;
      label79:
      if (k == 0) {
        return null;
      }
    }
    int j = k & 0xFF;
    if (j > 0)
    {
      localObject = this._collList[(j - 1)];
      if (localObject != null) {
        return ((BytesToNameCanonicalizer.Bucket)localObject).find(i, paramInt1, paramInt2);
      }
    }
    return null;
  }
  
  public Name findName(int[] paramArrayOfInt, int paramInt)
  {
    int i = 0;
    int j;
    Object localObject;
    if (paramInt < 3)
    {
      j = paramArrayOfInt[0];
      if (paramInt < 2)
      {
        paramInt = i;
        localObject = findName(j, paramInt);
      }
    }
    int k;
    do
    {
      do
      {
        return (Name)localObject;
        paramInt = paramArrayOfInt[1];
        break;
        i = calcHash(paramArrayOfInt, paramInt);
        j = this._mainHashMask & i;
        k = this._mainHash[j];
        if ((k >> 8 ^ i) << 8 != 0) {
          break label145;
        }
        localName = this._mainNames[j];
        localObject = localName;
      } while (localName == null);
      localObject = localName;
    } while (localName.equals(paramArrayOfInt, paramInt));
    label145:
    while (k != 0)
    {
      Name localName;
      j = k & 0xFF;
      if (j <= 0) {
        break;
      }
      localObject = this._collList[(j - 1)];
      if (localObject == null) {
        break;
      }
      return ((BytesToNameCanonicalizer.Bucket)localObject).find(i, paramArrayOfInt, paramInt);
    }
    return null;
    return null;
  }
  
  public BytesToNameCanonicalizer makeChild(boolean paramBoolean1, boolean paramBoolean2)
  {
    return new BytesToNameCanonicalizer(this, paramBoolean2, this._hashSeed, (BytesToNameCanonicalizer.TableInfo)this._tableInfo.get());
  }
  
  public boolean maybeDirty()
  {
    return !this._mainHashShared;
  }
  
  public void release()
  {
    if ((this._parent != null) && (maybeDirty()))
    {
      this._parent.mergeChild(new BytesToNameCanonicalizer.TableInfo(this));
      this._mainHashShared = true;
      this._mainNamesShared = true;
      this._collListShared = true;
    }
  }
  
  protected void reportTooManyCollisions(int paramInt)
  {
    throw new IllegalStateException("Longest collision chain in symbol table (of size " + this._count + ") now exceeds maximum, " + paramInt + " -- suspect a DoS attack based on hash collisions");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/core/sym/BytesToNameCanonicalizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */