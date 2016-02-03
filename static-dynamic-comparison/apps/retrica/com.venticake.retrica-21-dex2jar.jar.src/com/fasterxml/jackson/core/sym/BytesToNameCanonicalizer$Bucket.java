package com.fasterxml.jackson.core.sym;

final class BytesToNameCanonicalizer$Bucket
{
  private final int _length;
  protected final Name _name;
  protected final Bucket _next;
  
  BytesToNameCanonicalizer$Bucket(Name paramName, Bucket paramBucket)
  {
    this._name = paramName;
    this._next = paramBucket;
    if (paramBucket == null) {}
    for (int i = 1;; i = paramBucket._length + 1)
    {
      this._length = i;
      return;
    }
  }
  
  public Name find(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject;
    if ((this._name.hashCode() == paramInt1) && (this._name.equals(paramInt2, paramInt3)))
    {
      localObject = this._name;
      return (Name)localObject;
    }
    for (Bucket localBucket = this._next;; localBucket = localBucket._next)
    {
      if (localBucket == null) {
        break label83;
      }
      Name localName = localBucket._name;
      if (localName.hashCode() == paramInt1)
      {
        localObject = localName;
        if (localName.equals(paramInt2, paramInt3)) {
          break;
        }
      }
    }
    label83:
    return null;
  }
  
  public Name find(int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    Object localObject;
    if ((this._name.hashCode() == paramInt1) && (this._name.equals(paramArrayOfInt, paramInt2)))
    {
      localObject = this._name;
      return (Name)localObject;
    }
    for (Bucket localBucket = this._next;; localBucket = localBucket._next)
    {
      if (localBucket == null) {
        break label83;
      }
      Name localName = localBucket._name;
      if (localName.hashCode() == paramInt1)
      {
        localObject = localName;
        if (localName.equals(paramArrayOfInt, paramInt2)) {
          break;
        }
      }
    }
    label83:
    return null;
  }
  
  public int length()
  {
    return this._length;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/core/sym/BytesToNameCanonicalizer$Bucket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */