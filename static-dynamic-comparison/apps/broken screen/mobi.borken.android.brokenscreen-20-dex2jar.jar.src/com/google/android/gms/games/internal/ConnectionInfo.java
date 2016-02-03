package com.google.android.gms.games.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ConnectionInfo
  implements SafeParcelable
{
  public static final ConnectionInfoCreator CREATOR = new ConnectionInfoCreator();
  private final String Nk;
  private final int Nl;
  private final int xJ;
  
  public ConnectionInfo(int paramInt1, String paramString, int paramInt2)
  {
    this.xJ = paramInt1;
    this.Nk = paramString;
    this.Nl = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String gR()
  {
    return this.Nk;
  }
  
  public int gS()
  {
    return this.Nl;
  }
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ConnectionInfoCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/internal/ConnectionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */