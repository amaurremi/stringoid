package com.google.android.gms.internal;

import java.util.Arrays;

public final class mg
{
  final byte[] anc;
  final int tag;
  
  mg(int paramInt, byte[] paramArrayOfByte)
  {
    this.tag = paramInt;
    this.anc = paramArrayOfByte;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof mg)) {
        return false;
      }
      paramObject = (mg)paramObject;
    } while ((this.tag == ((mg)paramObject).tag) && (Arrays.equals(this.anc, ((mg)paramObject).anc)));
    return false;
  }
  
  public int hashCode()
  {
    return (this.tag + 527) * 31 + Arrays.hashCode(this.anc);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/mg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */