package com.mapbar.android.location;

import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;

final class e
  extends PhoneStateListener
{
  e(b paramb) {}
  
  public final void onCellLocationChanged(CellLocation paramCellLocation)
  {
    b.a(this.a, paramCellLocation);
    b.a(this.a, b.c(this.a).getNeighboringCellInfoGemini(1));
    k.a(b.b(this.a)).c();
  }
  
  public final void onServiceStateChanged(ServiceState paramServiceState)
  {
    b.a(this.a, paramServiceState);
  }
  
  public final void onSignalStrengthChanged(int paramInt)
  {
    l.m = paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/android/location/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */