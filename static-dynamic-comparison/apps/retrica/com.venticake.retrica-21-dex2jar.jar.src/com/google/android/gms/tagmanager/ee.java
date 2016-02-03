package com.google.android.gms.tagmanager;

import java.util.Arrays;

class ee
{
  final String a;
  final byte[] b;
  
  ee(String paramString, byte[] paramArrayOfByte)
  {
    this.a = paramString;
    this.b = paramArrayOfByte;
  }
  
  public String toString()
  {
    return "KeyAndSerialized: key = " + this.a + " serialized hash = " + Arrays.hashCode(this.b);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/ee.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */