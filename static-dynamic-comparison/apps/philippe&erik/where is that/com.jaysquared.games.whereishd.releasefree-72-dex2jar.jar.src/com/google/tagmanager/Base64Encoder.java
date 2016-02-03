package com.google.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.common.util.VisibleForTesting;

class Base64Encoder
{
  public static final int DEFAULT = 0;
  public static final int NO_PADDING = 1;
  public static final int URL_SAFE = 2;
  
  public static byte[] decode(String paramString, int paramInt)
  {
    int i = 1;
    if (getSdkVersion() >= 8)
    {
      i = 2;
      if ((paramInt & 0x1) != 0) {
        i = 0x2 | 0x1;
      }
      int j = i;
      if ((paramInt & 0x2) != 0) {
        j = i | 0x8;
      }
      return android.util.Base64.decode(paramString, j);
    }
    if ((paramInt & 0x1) == 0) {
      if ((paramInt & 0x2) == 0) {
        break label67;
      }
    }
    label67:
    for (paramInt = i;; paramInt = 0)
    {
      if (paramInt == 0) {
        break label72;
      }
      return Base64.decodeWebSafe(paramString);
      break;
    }
    label72:
    return Base64.decode(paramString);
  }
  
  public static String encodeToString(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 1;
    if (getSdkVersion() >= 8)
    {
      i = 2;
      if ((paramInt & 0x1) != 0) {
        i = 0x2 | 0x1;
      }
      int j = i;
      if ((paramInt & 0x2) != 0) {
        j = i | 0x8;
      }
      return android.util.Base64.encodeToString(paramArrayOfByte, j);
    }
    boolean bool;
    if ((paramInt & 0x1) == 0)
    {
      bool = true;
      if ((paramInt & 0x2) == 0) {
        break label75;
      }
    }
    label75:
    for (paramInt = i;; paramInt = 0)
    {
      if (paramInt == 0) {
        break label80;
      }
      return Base64.encodeWebSafe(paramArrayOfByte, bool);
      bool = false;
      break;
    }
    label80:
    return Base64.encode(paramArrayOfByte, bool);
  }
  
  @VisibleForTesting
  static int getSdkVersion()
  {
    return Build.VERSION.SDK_INT;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/Base64Encoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */