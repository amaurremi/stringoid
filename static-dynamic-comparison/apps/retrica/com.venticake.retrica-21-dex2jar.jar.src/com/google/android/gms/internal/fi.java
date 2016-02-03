package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class fi
  implements SafeParcelable
{
  public static final fj CREATOR = new fj();
  final int xM;
  final String xQ;
  final String xR;
  final String xS;
  
  fi(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.xM = paramInt;
    this.xQ = paramString1;
    this.xR = paramString2;
    this.xS = paramString3;
  }
  
  public fi(String paramString1, String paramString2, String paramString3)
  {
    this(1, paramString1, paramString2, paramString3);
  }
  
  public int describeContents()
  {
    fj localfj = CREATOR;
    return 0;
  }
  
  public String toString()
  {
    return String.format("DocumentId[packageName=%s, corpusName=%s, uri=%s]", new Object[] { this.xQ, this.xR, this.xS });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    fj localfj = CREATOR;
    fj.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/fi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */