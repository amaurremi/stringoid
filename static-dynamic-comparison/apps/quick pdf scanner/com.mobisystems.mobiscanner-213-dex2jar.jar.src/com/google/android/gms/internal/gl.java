package com.google.android.gms.internal;

import java.util.Arrays;

public final class gl
{
  final byte[] Tb;
  final int tag;
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof gl)) {
        return false;
      }
      paramObject = (gl)paramObject;
    } while ((this.tag == ((gl)paramObject).tag) && (Arrays.equals(this.Tb, ((gl)paramObject).Tb)));
    return false;
  }
  
  public int hashCode()
  {
    return (this.tag + 527) * 31 + Arrays.hashCode(this.Tb);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/gl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */