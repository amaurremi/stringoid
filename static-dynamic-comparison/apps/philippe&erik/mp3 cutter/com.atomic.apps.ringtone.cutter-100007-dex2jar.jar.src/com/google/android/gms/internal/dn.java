package com.google.android.gms.internal;

import android.util.Base64;

public class dn
{
  public String a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    return Base64.encodeToString(paramArrayOfByte, 11);
  }
  
  public byte[] a(String paramString, boolean paramBoolean)
  {
    return Base64.decode(paramString, 2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/dn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */