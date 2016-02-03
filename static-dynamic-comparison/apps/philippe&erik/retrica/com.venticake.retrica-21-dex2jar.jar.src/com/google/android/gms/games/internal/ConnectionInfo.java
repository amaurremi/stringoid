package com.google.android.gms.games.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ConnectionInfo
  implements SafeParcelable
{
  public static final ConnectionInfoCreator CREATOR = new ConnectionInfoCreator();
  private final String Nn;
  private final int No;
  private final int xM;
  
  public ConnectionInfo(int paramInt1, String paramString, int paramInt2)
  {
    this.xM = paramInt1;
    this.Nn = paramString;
    this.No = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String gW()
  {
    return this.Nn;
  }
  
  public int gX()
  {
    return this.No;
  }
  
  public int getVersionCode()
  {
    return this.xM;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ConnectionInfoCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/ConnectionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */