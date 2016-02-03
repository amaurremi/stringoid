package com.google.android.gms.location;

import android.content.Context;
import android.location.Location;
import com.google.android.gms.common.c;
import com.google.android.gms.common.c.a;
import com.google.android.gms.common.c.b;
import com.google.android.gms.internal.eo;

public class d
  implements c
{
  private final eo Ub;
  
  public d(Context paramContext, c.a parama, c.b paramb)
  {
    this.Ub = new eo(paramContext, parama, paramb, "location");
  }
  
  public void connect()
  {
    this.Ub.connect();
  }
  
  public void disconnect()
  {
    this.Ub.disconnect();
  }
  
  public boolean isConnected()
  {
    return this.Ub.isConnected();
  }
  
  public Location rf()
  {
    return this.Ub.rf();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/location/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */