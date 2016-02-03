package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.ads.search.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class am
  implements SafeParcelable
{
  public static final n xv = new n();
  public final int backgroundColor;
  public final int versionCode;
  public final int xA;
  public final int xB;
  public final int xC;
  public final String xD;
  public final int xE;
  public final String xF;
  public final int xG;
  public final int xH;
  public final String xI;
  public final int xw;
  public final int xx;
  public final int xy;
  public final int xz;
  
  am(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, String paramString1, int paramInt10, String paramString2, int paramInt11, int paramInt12, String paramString3)
  {
    this.versionCode = paramInt1;
    this.xw = paramInt2;
    this.backgroundColor = paramInt3;
    this.xx = paramInt4;
    this.xy = paramInt5;
    this.xz = paramInt6;
    this.xA = paramInt7;
    this.xB = paramInt8;
    this.xC = paramInt9;
    this.xD = paramString1;
    this.xE = paramInt10;
    this.xF = paramString2;
    this.xG = paramInt11;
    this.xH = paramInt12;
    this.xI = paramString3;
  }
  
  public am(a parama)
  {
    this.versionCode = 1;
    this.xw = parama.kw();
    this.backgroundColor = parama.getBackgroundColor();
    this.xx = parama.kx();
    this.xy = parama.ky();
    this.xz = parama.kz();
    this.xA = parama.kA();
    this.xB = parama.kB();
    this.xC = parama.kC();
    this.xD = parama.kD();
    this.xE = parama.kE();
    this.xF = parama.kF();
    this.xG = parama.kG();
    this.xH = parama.kH();
    this.xI = parama.getQuery();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    n.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */