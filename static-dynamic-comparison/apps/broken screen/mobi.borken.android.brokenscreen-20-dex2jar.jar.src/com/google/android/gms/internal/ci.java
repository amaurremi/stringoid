package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.d.a;
import com.google.android.gms.dynamic.e;

public final class ci
  implements SafeParcelable
{
  public static final ch CREATOR = new ch();
  public final ew kO;
  public final String nZ;
  public final String oA;
  public final cm oB;
  public final int oC;
  public final be oD;
  public final String oE;
  public final w oF;
  public final int orientation;
  public final cf ot;
  public final u ou;
  public final cj ov;
  public final ey ow;
  public final bb ox;
  public final String oy;
  public final boolean oz;
  public final int versionCode;
  
  ci(int paramInt1, cf paramcf, IBinder paramIBinder1, IBinder paramIBinder2, IBinder paramIBinder3, IBinder paramIBinder4, String paramString1, boolean paramBoolean, String paramString2, IBinder paramIBinder5, int paramInt2, int paramInt3, String paramString3, ew paramew, IBinder paramIBinder6, String paramString4, w paramw)
  {
    this.versionCode = paramInt1;
    this.ot = paramcf;
    this.ou = ((u)e.e(d.a.ag(paramIBinder1)));
    this.ov = ((cj)e.e(d.a.ag(paramIBinder2)));
    this.ow = ((ey)e.e(d.a.ag(paramIBinder3)));
    this.ox = ((bb)e.e(d.a.ag(paramIBinder4)));
    this.oy = paramString1;
    this.oz = paramBoolean;
    this.oA = paramString2;
    this.oB = ((cm)e.e(d.a.ag(paramIBinder5)));
    this.orientation = paramInt2;
    this.oC = paramInt3;
    this.nZ = paramString3;
    this.kO = paramew;
    this.oD = ((be)e.e(d.a.ag(paramIBinder6)));
    this.oE = paramString4;
    this.oF = paramw;
  }
  
  public ci(cf paramcf, u paramu, cj paramcj, cm paramcm, ew paramew)
  {
    this.versionCode = 4;
    this.ot = paramcf;
    this.ou = paramu;
    this.ov = paramcj;
    this.ow = null;
    this.ox = null;
    this.oy = null;
    this.oz = false;
    this.oA = null;
    this.oB = paramcm;
    this.orientation = -1;
    this.oC = 4;
    this.nZ = null;
    this.kO = paramew;
    this.oD = null;
    this.oE = null;
    this.oF = null;
  }
  
  public ci(u paramu, cj paramcj, bb parambb, cm paramcm, ey paramey, boolean paramBoolean, int paramInt, String paramString, ew paramew, be parambe)
  {
    this.versionCode = 4;
    this.ot = null;
    this.ou = paramu;
    this.ov = paramcj;
    this.ow = paramey;
    this.ox = parambb;
    this.oy = null;
    this.oz = paramBoolean;
    this.oA = null;
    this.oB = paramcm;
    this.orientation = paramInt;
    this.oC = 3;
    this.nZ = paramString;
    this.kO = paramew;
    this.oD = parambe;
    this.oE = null;
    this.oF = null;
  }
  
  public ci(u paramu, cj paramcj, bb parambb, cm paramcm, ey paramey, boolean paramBoolean, int paramInt, String paramString1, String paramString2, ew paramew, be parambe)
  {
    this.versionCode = 4;
    this.ot = null;
    this.ou = paramu;
    this.ov = paramcj;
    this.ow = paramey;
    this.ox = parambb;
    this.oy = paramString2;
    this.oz = paramBoolean;
    this.oA = paramString1;
    this.oB = paramcm;
    this.orientation = paramInt;
    this.oC = 3;
    this.nZ = null;
    this.kO = paramew;
    this.oD = parambe;
    this.oE = null;
    this.oF = null;
  }
  
  public ci(u paramu, cj paramcj, cm paramcm, ey paramey, int paramInt, ew paramew, String paramString, w paramw)
  {
    this.versionCode = 4;
    this.ot = null;
    this.ou = paramu;
    this.ov = paramcj;
    this.ow = paramey;
    this.ox = null;
    this.oy = null;
    this.oz = false;
    this.oA = null;
    this.oB = paramcm;
    this.orientation = paramInt;
    this.oC = 1;
    this.nZ = null;
    this.kO = paramew;
    this.oD = null;
    this.oE = paramString;
    this.oF = paramw;
  }
  
  public ci(u paramu, cj paramcj, cm paramcm, ey paramey, boolean paramBoolean, int paramInt, ew paramew)
  {
    this.versionCode = 4;
    this.ot = null;
    this.ou = paramu;
    this.ov = paramcj;
    this.ow = paramey;
    this.ox = null;
    this.oy = null;
    this.oz = paramBoolean;
    this.oA = null;
    this.oB = paramcm;
    this.orientation = paramInt;
    this.oC = 2;
    this.nZ = null;
    this.kO = paramew;
    this.oD = null;
    this.oE = null;
    this.oF = null;
  }
  
  public static ci a(Intent paramIntent)
  {
    try
    {
      paramIntent = paramIntent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
      paramIntent.setClassLoader(ci.class.getClassLoader());
      paramIntent = (ci)paramIntent.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
      return paramIntent;
    }
    catch (Exception paramIntent) {}
    return null;
  }
  
  public static void a(Intent paramIntent, ci paramci)
  {
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", paramci);
    paramIntent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", localBundle);
  }
  
  IBinder aP()
  {
    return e.h(this.ou).asBinder();
  }
  
  IBinder aQ()
  {
    return e.h(this.ov).asBinder();
  }
  
  IBinder aR()
  {
    return e.h(this.ow).asBinder();
  }
  
  IBinder aS()
  {
    return e.h(this.ox).asBinder();
  }
  
  IBinder aT()
  {
    return e.h(this.oD).asBinder();
  }
  
  IBinder aU()
  {
    return e.h(this.oB).asBinder();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ch.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/ci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */