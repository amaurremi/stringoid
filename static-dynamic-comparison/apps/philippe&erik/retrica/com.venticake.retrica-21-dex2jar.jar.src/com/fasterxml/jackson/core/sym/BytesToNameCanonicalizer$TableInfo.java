package com.fasterxml.jackson.core.sym;

final class BytesToNameCanonicalizer$TableInfo
{
  public final int collCount;
  public final int collEnd;
  public final BytesToNameCanonicalizer.Bucket[] collList;
  public final int count;
  public final int longestCollisionList;
  public final int[] mainHash;
  public final int mainHashMask;
  public final Name[] mainNames;
  
  public BytesToNameCanonicalizer$TableInfo(int paramInt1, int paramInt2, int[] paramArrayOfInt, Name[] paramArrayOfName, BytesToNameCanonicalizer.Bucket[] paramArrayOfBucket, int paramInt3, int paramInt4, int paramInt5)
  {
    this.count = paramInt1;
    this.mainHashMask = paramInt2;
    this.mainHash = paramArrayOfInt;
    this.mainNames = paramArrayOfName;
    this.collList = paramArrayOfBucket;
    this.collCount = paramInt3;
    this.collEnd = paramInt4;
    this.longestCollisionList = paramInt5;
  }
  
  public BytesToNameCanonicalizer$TableInfo(BytesToNameCanonicalizer paramBytesToNameCanonicalizer)
  {
    this.count = paramBytesToNameCanonicalizer._count;
    this.mainHashMask = paramBytesToNameCanonicalizer._mainHashMask;
    this.mainHash = paramBytesToNameCanonicalizer._mainHash;
    this.mainNames = paramBytesToNameCanonicalizer._mainNames;
    this.collList = paramBytesToNameCanonicalizer._collList;
    this.collCount = paramBytesToNameCanonicalizer._collCount;
    this.collEnd = paramBytesToNameCanonicalizer._collEnd;
    this.longestCollisionList = paramBytesToNameCanonicalizer._longestCollisionList;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/core/sym/BytesToNameCanonicalizer$TableInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */