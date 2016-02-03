package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ki;
import java.util.Collections;
import java.util.List;

public class BleDevice
  implements SafeParcelable
{
  public static final Parcelable.Creator<BleDevice> CREATOR = new c();
  private final int BR;
  private final String Ss;
  private final List<String> St;
  private final List<DataType> Su;
  private final String mName;
  
  BleDevice(int paramInt, String paramString1, String paramString2, List<String> paramList, List<DataType> paramList1)
  {
    this.BR = paramInt;
    this.Ss = paramString1;
    this.mName = paramString2;
    this.St = Collections.unmodifiableList(paramList);
    this.Su = Collections.unmodifiableList(paramList1);
  }
  
  private boolean a(BleDevice paramBleDevice)
  {
    return (this.mName.equals(paramBleDevice.mName)) && (this.Ss.equals(paramBleDevice.Ss)) && (ki.a(paramBleDevice.St, this.St)) && (ki.a(this.Su, paramBleDevice.Su));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof BleDevice)) && (a((BleDevice)paramObject)));
  }
  
  public String getAddress()
  {
    return this.Ss;
  }
  
  public List<DataType> getDataTypes()
  {
    return this.Su;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public List<String> getSupportedProfiles()
  {
    return this.St;
  }
  
  int getVersionCode()
  {
    return this.BR;
  }
  
  public int hashCode()
  {
    return m.hashCode(new Object[] { this.mName, this.Ss, this.St, this.Su });
  }
  
  public String toString()
  {
    return m.h(this).a("name", this.mName).a("address", this.Ss).a("dataTypes", this.Su).a("supportedProfiles", this.St).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/data/BleDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */