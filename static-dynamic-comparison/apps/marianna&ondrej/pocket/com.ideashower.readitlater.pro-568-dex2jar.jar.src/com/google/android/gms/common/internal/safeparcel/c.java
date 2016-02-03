package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class c
{
  public static int a(Parcel paramParcel)
  {
    return b(paramParcel, 20293);
  }
  
  public static void a(Parcel paramParcel, int paramInt)
  {
    c(paramParcel, paramInt);
  }
  
  public static void a(Parcel paramParcel, int paramInt, byte paramByte)
  {
    b(paramParcel, paramInt, 4);
    paramParcel.writeInt(paramByte);
  }
  
  public static void a(Parcel paramParcel, int paramInt, double paramDouble)
  {
    b(paramParcel, paramInt, 8);
    paramParcel.writeDouble(paramDouble);
  }
  
  public static void a(Parcel paramParcel, int paramInt, float paramFloat)
  {
    b(paramParcel, paramInt, 4);
    paramParcel.writeFloat(paramFloat);
  }
  
  public static void a(Parcel paramParcel, int paramInt1, int paramInt2)
  {
    b(paramParcel, paramInt1, 4);
    paramParcel.writeInt(paramInt2);
  }
  
  public static void a(Parcel paramParcel, int paramInt, long paramLong)
  {
    b(paramParcel, paramInt, 8);
    paramParcel.writeLong(paramLong);
  }
  
  public static void a(Parcel paramParcel, int paramInt, Bundle paramBundle, boolean paramBoolean)
  {
    if (paramBundle == null)
    {
      if (paramBoolean) {
        b(paramParcel, paramInt, 0);
      }
      return;
    }
    paramInt = b(paramParcel, paramInt);
    paramParcel.writeBundle(paramBundle);
    c(paramParcel, paramInt);
  }
  
  public static void a(Parcel paramParcel, int paramInt, IBinder paramIBinder, boolean paramBoolean)
  {
    if (paramIBinder == null)
    {
      if (paramBoolean) {
        b(paramParcel, paramInt, 0);
      }
      return;
    }
    paramInt = b(paramParcel, paramInt);
    paramParcel.writeStrongBinder(paramIBinder);
    c(paramParcel, paramInt);
  }
  
  public static void a(Parcel paramParcel1, int paramInt, Parcel paramParcel2, boolean paramBoolean)
  {
    if (paramParcel2 == null)
    {
      if (paramBoolean) {
        b(paramParcel1, paramInt, 0);
      }
      return;
    }
    paramInt = b(paramParcel1, paramInt);
    paramParcel1.appendFrom(paramParcel2, 0, paramParcel2.dataSize());
    c(paramParcel1, paramInt);
  }
  
  public static void a(Parcel paramParcel, int paramInt1, Parcelable paramParcelable, int paramInt2, boolean paramBoolean)
  {
    if (paramParcelable == null)
    {
      if (paramBoolean) {
        b(paramParcel, paramInt1, 0);
      }
      return;
    }
    paramInt1 = b(paramParcel, paramInt1);
    paramParcelable.writeToParcel(paramParcel, paramInt2);
    c(paramParcel, paramInt1);
  }
  
  public static void a(Parcel paramParcel, int paramInt, String paramString, boolean paramBoolean)
  {
    if (paramString == null)
    {
      if (paramBoolean) {
        b(paramParcel, paramInt, 0);
      }
      return;
    }
    paramInt = b(paramParcel, paramInt);
    paramParcel.writeString(paramString);
    c(paramParcel, paramInt);
  }
  
  public static void a(Parcel paramParcel, int paramInt, List paramList, boolean paramBoolean)
  {
    if (paramList == null)
    {
      if (paramBoolean) {
        b(paramParcel, paramInt, 0);
      }
      return;
    }
    paramInt = b(paramParcel, paramInt);
    paramParcel.writeStringList(paramList);
    c(paramParcel, paramInt);
  }
  
  public static void a(Parcel paramParcel, int paramInt, short paramShort)
  {
    b(paramParcel, paramInt, 4);
    paramParcel.writeInt(paramShort);
  }
  
  public static void a(Parcel paramParcel, int paramInt, boolean paramBoolean)
  {
    b(paramParcel, paramInt, 4);
    if (paramBoolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
    }
  }
  
  public static void a(Parcel paramParcel, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramArrayOfByte == null)
    {
      if (paramBoolean) {
        b(paramParcel, paramInt, 0);
      }
      return;
    }
    paramInt = b(paramParcel, paramInt);
    paramParcel.writeByteArray(paramArrayOfByte);
    c(paramParcel, paramInt);
  }
  
  public static void a(Parcel paramParcel, int paramInt1, Parcelable[] paramArrayOfParcelable, int paramInt2, boolean paramBoolean)
  {
    if (paramArrayOfParcelable == null)
    {
      if (paramBoolean) {
        b(paramParcel, paramInt1, 0);
      }
      return;
    }
    int i = b(paramParcel, paramInt1);
    int j = paramArrayOfParcelable.length;
    paramParcel.writeInt(j);
    paramInt1 = 0;
    if (paramInt1 < j)
    {
      Parcelable localParcelable = paramArrayOfParcelable[paramInt1];
      if (localParcelable == null) {
        paramParcel.writeInt(0);
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        a(paramParcel, localParcelable, paramInt2);
      }
    }
    c(paramParcel, i);
  }
  
  public static void a(Parcel paramParcel, int paramInt, String[] paramArrayOfString, boolean paramBoolean)
  {
    if (paramArrayOfString == null)
    {
      if (paramBoolean) {
        b(paramParcel, paramInt, 0);
      }
      return;
    }
    paramInt = b(paramParcel, paramInt);
    paramParcel.writeStringArray(paramArrayOfString);
    c(paramParcel, paramInt);
  }
  
  private static void a(Parcel paramParcel, Parcelable paramParcelable, int paramInt)
  {
    int i = paramParcel.dataPosition();
    paramParcel.writeInt(1);
    int j = paramParcel.dataPosition();
    paramParcelable.writeToParcel(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    paramParcel.setDataPosition(i);
    paramParcel.writeInt(paramInt - j);
    paramParcel.setDataPosition(paramInt);
  }
  
  private static int b(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(0xFFFF0000 | paramInt);
    paramParcel.writeInt(0);
    return paramParcel.dataPosition();
  }
  
  private static void b(Parcel paramParcel, int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 65535)
    {
      paramParcel.writeInt(0xFFFF0000 | paramInt1);
      paramParcel.writeInt(paramInt2);
      return;
    }
    paramParcel.writeInt(paramInt2 << 16 | paramInt1);
  }
  
  public static void b(Parcel paramParcel, int paramInt, List paramList, boolean paramBoolean)
  {
    if (paramList == null)
    {
      if (paramBoolean) {
        b(paramParcel, paramInt, 0);
      }
      return;
    }
    int i = b(paramParcel, paramInt);
    int j = paramList.size();
    paramParcel.writeInt(j);
    paramInt = 0;
    if (paramInt < j)
    {
      Parcelable localParcelable = (Parcelable)paramList.get(paramInt);
      if (localParcelable == null) {
        paramParcel.writeInt(0);
      }
      for (;;)
      {
        paramInt += 1;
        break;
        a(paramParcel, localParcelable, 0);
      }
    }
    c(paramParcel, i);
  }
  
  private static void c(Parcel paramParcel, int paramInt)
  {
    int i = paramParcel.dataPosition();
    paramParcel.setDataPosition(paramInt - 4);
    paramParcel.writeInt(i - paramInt);
    paramParcel.setDataPosition(i);
  }
  
  public static void c(Parcel paramParcel, int paramInt, List paramList, boolean paramBoolean)
  {
    if (paramList == null)
    {
      if (paramBoolean) {
        b(paramParcel, paramInt, 0);
      }
      return;
    }
    paramInt = b(paramParcel, paramInt);
    paramParcel.writeList(paramList);
    c(paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/common/internal/safeparcel/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */