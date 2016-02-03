package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.d.a;
import com.google.android.gms.dynamic.e;

public final class ch
  implements SafeParcelable
{
  public static final cg CREATOR = new cg();
  public final ev kQ;
  public final String oA;
  public final boolean oB;
  public final String oC;
  public final cl oD;
  public final int oE;
  public final bd oF;
  public final String oG;
  public final v oH;
  public final String ob;
  public final int orientation;
  public final ce ov;
  public final t ow;
  public final ci ox;
  public final ex oy;
  public final ba oz;
  public final int versionCode;
  
  ch(int paramInt1, ce paramce, IBinder paramIBinder1, IBinder paramIBinder2, IBinder paramIBinder3, IBinder paramIBinder4, String paramString1, boolean paramBoolean, String paramString2, IBinder paramIBinder5, int paramInt2, int paramInt3, String paramString3, ev paramev, IBinder paramIBinder6, String paramString4, v paramv)
  {
    this.versionCode = paramInt1;
    this.ov = paramce;
    this.ow = ((t)e.e(d.a.ag(paramIBinder1)));
    this.ox = ((ci)e.e(d.a.ag(paramIBinder2)));
    this.oy = ((ex)e.e(d.a.ag(paramIBinder3)));
    this.oz = ((ba)e.e(d.a.ag(paramIBinder4)));
    this.oA = paramString1;
    this.oB = paramBoolean;
    this.oC = paramString2;
    this.oD = ((cl)e.e(d.a.ag(paramIBinder5)));
    this.orientation = paramInt2;
    this.oE = paramInt3;
    this.ob = paramString3;
    this.kQ = paramev;
    this.oF = ((bd)e.e(d.a.ag(paramIBinder6)));
    this.oG = paramString4;
    this.oH = paramv;
  }
  
  public ch(ce paramce, t paramt, ci paramci, cl paramcl, ev paramev)
  {
    this.versionCode = 4;
    this.ov = paramce;
    this.ow = paramt;
    this.ox = paramci;
    this.oy = null;
    this.oz = null;
    this.oA = null;
    this.oB = false;
    this.oC = null;
    this.oD = paramcl;
    this.orientation = -1;
    this.oE = 4;
    this.ob = null;
    this.kQ = paramev;
    this.oF = null;
    this.oG = null;
    this.oH = null;
  }
  
  public ch(t paramt, ci paramci, ba paramba, cl paramcl, ex paramex, boolean paramBoolean, int paramInt, String paramString, ev paramev, bd parambd)
  {
    this.versionCode = 4;
    this.ov = null;
    this.ow = paramt;
    this.ox = paramci;
    this.oy = paramex;
    this.oz = paramba;
    this.oA = null;
    this.oB = paramBoolean;
    this.oC = null;
    this.oD = paramcl;
    this.orientation = paramInt;
    this.oE = 3;
    this.ob = paramString;
    this.kQ = paramev;
    this.oF = parambd;
    this.oG = null;
    this.oH = null;
  }
  
  public ch(t paramt, ci paramci, ba paramba, cl paramcl, ex paramex, boolean paramBoolean, int paramInt, String paramString1, String paramString2, ev paramev, bd parambd)
  {
    this.versionCode = 4;
    this.ov = null;
    this.ow = paramt;
    this.ox = paramci;
    this.oy = paramex;
    this.oz = paramba;
    this.oA = paramString2;
    this.oB = paramBoolean;
    this.oC = paramString1;
    this.oD = paramcl;
    this.orientation = paramInt;
    this.oE = 3;
    this.ob = null;
    this.kQ = paramev;
    this.oF = parambd;
    this.oG = null;
    this.oH = null;
  }
  
  public ch(t paramt, ci paramci, cl paramcl, ex paramex, int paramInt, ev paramev, String paramString, v paramv)
  {
    this.versionCode = 4;
    this.ov = null;
    this.ow = paramt;
    this.ox = paramci;
    this.oy = paramex;
    this.oz = null;
    this.oA = null;
    this.oB = false;
    this.oC = null;
    this.oD = paramcl;
    this.orientation = paramInt;
    this.oE = 1;
    this.ob = null;
    this.kQ = paramev;
    this.oF = null;
    this.oG = paramString;
    this.oH = paramv;
  }
  
  public ch(t paramt, ci paramci, cl paramcl, ex paramex, boolean paramBoolean, int paramInt, ev paramev)
  {
    this.versionCode = 4;
    this.ov = null;
    this.ow = paramt;
    this.ox = paramci;
    this.oy = paramex;
    this.oz = null;
    this.oA = null;
    this.oB = paramBoolean;
    this.oC = null;
    this.oD = paramcl;
    this.orientation = paramInt;
    this.oE = 2;
    this.ob = null;
    this.kQ = paramev;
    this.oF = null;
    this.oG = null;
    this.oH = null;
  }
  
  public static ch a(Intent paramIntent)
  {
    try
    {
      paramIntent = paramIntent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
      paramIntent.setClassLoader(ch.class.getClassLoader());
      paramIntent = (ch)paramIntent.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
      return paramIntent;
    }
    catch (Exception paramIntent) {}
    return null;
  }
  
  public static void a(Intent paramIntent, ch paramch)
  {
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", paramch);
    paramIntent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", localBundle);
  }
  
  IBinder aU()
  {
    return e.h(this.ow).asBinder();
  }
  
  IBinder aV()
  {
    return e.h(this.ox).asBinder();
  }
  
  IBinder aW()
  {
    return e.h(this.oy).asBinder();
  }
  
  IBinder aX()
  {
    return e.h(this.oz).asBinder();
  }
  
  IBinder aY()
  {
    return e.h(this.oF).asBinder();
  }
  
  IBinder aZ()
  {
    return e.h(this.oD).asBinder();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    cg.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */