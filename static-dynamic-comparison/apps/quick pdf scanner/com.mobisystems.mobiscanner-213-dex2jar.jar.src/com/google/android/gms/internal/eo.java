package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.common.c.a;
import com.google.android.gms.common.c.b;
import java.util.Locale;

public class eo
  extends cs<em>
{
  private final eq<em> MJ = new a(null);
  private final en MO = new en(paramContext, this.MJ);
  private final fg MP;
  private final String MQ;
  private final String qS;
  
  public eo(Context paramContext, c.a parama, c.b paramb, String paramString)
  {
    super(paramContext, parama, paramb, new String[0]);
    this.MQ = paramString;
    this.qS = null;
    this.MP = new fg(getContext(), Locale.getDefault(), this.MJ);
  }
  
  protected em D(IBinder paramIBinder)
  {
    return em.a.C(paramIBinder);
  }
  
  protected void a(cx paramcx, cs.d paramd)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("client_name", this.MQ);
    paramcx.e(paramd, 4323000, getContext().getPackageName(), localBundle);
  }
  
  public void disconnect()
  {
    synchronized (this.MO)
    {
      if (isConnected())
      {
        this.MO.removeAllListeners();
        this.MO.rg();
      }
      super.disconnect();
      return;
    }
  }
  
  protected String nl()
  {
    return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
  }
  
  protected String nm()
  {
    return "com.google.android.location.internal.GoogleLocationManagerService.START";
  }
  
  public Location rf()
  {
    return this.MO.rf();
  }
  
  private final class a
    implements eq<em>
  {
    private a() {}
    
    public void lf()
    {
      eo.a(eo.this);
    }
    
    public em rh()
    {
      return (em)eo.b(eo.this);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/eo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */