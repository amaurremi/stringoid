package org.codehaus.jackson.sym;

final class BytesToNameCanonicalizer$Bucket
{
  protected final Name _name;
  protected final Bucket _next;
  
  BytesToNameCanonicalizer$Bucket(Name paramName, Bucket paramBucket)
  {
    this._name = paramName;
    this._next = paramBucket;
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
    int i = 1;
    for (Bucket localBucket = this._next; localBucket != null; localBucket = localBucket._next) {
      i += 1;
    }
    return i;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/sym/BytesToNameCanonicalizer$Bucket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */