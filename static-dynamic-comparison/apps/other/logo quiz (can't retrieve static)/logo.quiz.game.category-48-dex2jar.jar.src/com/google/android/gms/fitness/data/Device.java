package com.google.android.gms.fitness.data;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.kv;

public final class Device
  implements SafeParcelable
{
  public static final Parcelable.Creator<Device> CREATOR = new i();
  public static final int TYPE_CHEST_STRAP = 4;
  public static final int TYPE_PHONE = 1;
  public static final int TYPE_SCALE = 5;
  public static final int TYPE_TABLET = 2;
  public static final int TYPE_UNKNOWN = 0;
  public static final int TYPE_WATCH = 3;
  private final int BR;
  private final int FD;
  private final String SQ;
  private final String SR;
  private final String SS;
  private final String Sq;
  
  Device(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2)
  {
    this.BR = paramInt1;
    this.SQ = ((String)n.i(paramString1));
    this.SR = ((String)n.i(paramString2));
    this.Sq = "";
    this.SS = ((String)n.i(paramString4));
    this.FD = paramInt2;
  }
  
  public Device(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this(1, paramString1, paramString2, "", paramString3, paramInt);
  }
  
  public Device(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    this(paramString1, paramString2, paramString4, paramInt);
  }
  
  private static int M(Context paramContext)
  {
    int j = 0;
    int i = j;
    switch (O(paramContext))
    {
    default: 
      if (Q(paramContext)) {
        i = 1;
      }
      break;
    case 8: 
    case 9: 
    case 10: 
      do
      {
        return i;
        i = j;
      } while (!N(paramContext));
      return 3;
    }
    return 2;
  }
  
  public static boolean N(Context paramContext)
  {
    return (paramContext.getResources().getConfiguration().uiMode & 0xF) == 6;
  }
  
  private static int O(Context paramContext)
  {
    return P(paramContext) % 1000 / 100 + 5;
  }
  
  private static int P(Context paramContext)
  {
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Log.w("Fitness", "Could not find package info for Google Play Services");
    }
    return -1;
  }
  
  private static boolean Q(Context paramContext)
  {
    return ((TelephonyManager)paramContext.getSystemService("phone")).getPhoneType() != 0;
  }
  
  private boolean a(Device paramDevice)
  {
    return (m.equal(this.SQ, paramDevice.SQ)) && (m.equal(this.SR, paramDevice.SR)) && (m.equal(this.Sq, paramDevice.Sq)) && (m.equal(this.SS, paramDevice.SS)) && (this.FD == paramDevice.FD);
  }
  
  public static Device getLocalDevice(Context paramContext)
  {
    int i = M(paramContext);
    return new Device(Build.MANUFACTURER, Build.MODEL, Build.VERSION.RELEASE, Build.SERIAL, i);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof Device)) && (a((Device)paramObject)));
  }
  
  public String getManufacturer()
  {
    return this.SQ;
  }
  
  public String getModel()
  {
    return this.SR;
  }
  
  String getStreamIdentifier()
  {
    return String.format("%s:%s:%s", new Object[] { this.SQ, this.SR, this.SS });
  }
  
  public int getType()
  {
    return this.FD;
  }
  
  public String getUid()
  {
    return this.SS;
  }
  
  public String getVersion()
  {
    return this.Sq;
  }
  
  int getVersionCode()
  {
    return this.BR;
  }
  
  public int hashCode()
  {
    return m.hashCode(new Object[] { this.SQ, this.SR, this.Sq, this.SS, Integer.valueOf(this.FD) });
  }
  
  Device iM()
  {
    return new Device(kv.bq(this.SQ), kv.bq(this.SR), kv.bq(this.Sq), this.SS, this.FD);
  }
  
  public String iN()
  {
    if (kv.iU()) {
      return this.SS;
    }
    return kv.bq(this.SS);
  }
  
  public String toString()
  {
    return String.format("Device{%s:%s:%s}", new Object[] { getStreamIdentifier(), this.Sq, Integer.valueOf(this.FD) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    i.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/data/Device.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */