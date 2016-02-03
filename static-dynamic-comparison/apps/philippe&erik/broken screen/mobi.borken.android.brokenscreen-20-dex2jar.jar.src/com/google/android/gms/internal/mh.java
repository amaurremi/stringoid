package com.google.android.gms.internal;

import java.util.Arrays;

public final class mh
{
  final byte[] amZ;
  final int tag;
  
  mh(int paramInt, byte[] paramArrayOfByte)
  {
    this.tag = paramInt;
    this.amZ = paramArrayOfByte;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof mh)) {
        return false;
      }
      paramObject = (mh)paramObject;
    } while ((this.tag == ((mh)paramObject).tag) && (Arrays.equals(this.amZ, ((mh)paramObject).amZ)));
    return false;
  }
  
  public int hashCode()
  {
    return (this.tag + 527) * 31 + Arrays.hashCode(this.amZ);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/mh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */