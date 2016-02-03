package com.pocket.billing.google;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.ideashower.readitlater.objects.ErrorReport;
import com.pocket.billing.c;
import com.pocket.c.ag;
import com.pocket.p.o;

public class d
{
  private static final boolean a = com.ideashower.readitlater.util.e.a(false);
  private final com.pocket.billing.a b;
  private final Activity c;
  private ServiceConnection d;
  private com.android.c.a.a e;
  private g f;
  private boolean g;
  private boolean h;
  private GooglePremiumProduct i;
  
  public d(Activity paramActivity, com.pocket.billing.a parama, Bundle paramBundle)
  {
    this.c = paramActivity;
    this.b = parama;
    if (paramBundle != null) {
      this.i = ((GooglePremiumProduct)paramBundle.getParcelable("pendingPurchase"));
    }
    c();
  }
  
  private com.pocket.billing.b a(int paramInt, ErrorReport paramErrorReport)
  {
    switch (paramInt)
    {
    default: 
      if (com.ideashower.readitlater.a.g.k()) {
        return new com.pocket.billing.b(c.a, paramErrorReport);
      }
      break;
    case 1: 
      return new com.pocket.billing.b(c.b, paramErrorReport);
    case 6: 
      return new com.pocket.billing.b(c.c, paramErrorReport);
    case 7: 
      return new com.pocket.billing.b(c.d, paramErrorReport);
    }
    return new com.pocket.billing.b(c.c, paramErrorReport);
  }
  
  private void a(int paramInt)
  {
    if ((this.e != null) && (this.d != null))
    {
      this.c.unbindService(this.d);
      this.f = null;
      this.e = null;
      this.d = null;
    }
    if (this.g)
    {
      this.g = false;
      this.b.a(a(paramInt, null));
    }
  }
  
  private void a(g paramg)
  {
    this.f = paramg;
    d();
  }
  
  private void c()
  {
    if (this.d != null) {
      return;
    }
    this.d = new ServiceConnection()
    {
      public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        if (d.a(d.this)) {
          return;
        }
        int i;
        try
        {
          d.a(d.this, com.android.c.a.b.a(paramAnonymousIBinder));
          i = d.b(d.this).a(3, "com.ideashower.readitlater.pro", "subs");
          if (i == 0)
          {
            new e(d.b(d.this), new f()
            {
              public void a(int paramAnonymous2Int)
              {
                d.a(d.this, paramAnonymous2Int);
              }
              
              public void a(g paramAnonymous2g)
              {
                d.a(d.this, paramAnonymous2g);
              }
            }).h();
            return;
          }
        }
        catch (RemoteException paramAnonymousComponentName)
        {
          com.ideashower.readitlater.util.e.a(paramAnonymousComponentName, true);
          d.a(d.this, -1);
          return;
        }
        d.a(d.this, i);
      }
      
      public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        if (d.a(d.this)) {}
      }
    };
    Intent localIntent = a.a(this.c);
    if (o.b(this.c, localIntent))
    {
      this.c.bindService(localIntent, this.d, 1);
      return;
    }
    this.d = null;
    a(3);
  }
  
  private void d()
  {
    if (this.g)
    {
      this.g = false;
      this.b.a(this.f);
    }
  }
  
  private void e() {}
  
  public void a()
  {
    this.h = true;
    if ((this.e != null) && (this.d != null))
    {
      this.c.unbindService(this.d);
      this.f = null;
      this.e = null;
      this.d = null;
    }
  }
  
  public void a(Bundle paramBundle)
  {
    paramBundle.putParcelable("pendingPurchase", this.i);
  }
  
  public void a(com.pocket.billing.d paramd)
  {
    if (this.h) {
      return;
    }
    if (this.e == null) {
      throw new RuntimeException("Not connected.");
    }
    if (!(paramd instanceof GooglePremiumProduct)) {
      throw new RuntimeException("Wrong product type " + paramd);
    }
    paramd = (GooglePremiumProduct)paramd;
    a(paramd.f(), paramd.g(), paramd);
  }
  
  public void a(GooglePremiumProduct paramGooglePremiumProduct, String paramString1, String paramString2, ag paramag)
  {
    this.b.a();
    h.a(paramGooglePremiumProduct, paramString1, paramString2, paramag, new i()
    {
      public void a()
      {
        d.c(d.this).b();
      }
      
      public void a(ErrorReport paramAnonymousErrorReport)
      {
        d.c(d.this).a(paramAnonymousErrorReport);
      }
    });
  }
  
  public void a(String paramString1, String paramString2, GooglePremiumProduct paramGooglePremiumProduct)
  {
    if (a) {
      e();
    }
    try
    {
      paramString1 = this.e.a(3, "com.ideashower.readitlater.pro", paramString1, paramString2, a.b());
      int j = a.a(paramString1);
      if (j == 0)
      {
        paramString1 = (PendingIntent)paramString1.getParcelable("BUY_INTENT");
        this.i = paramGooglePremiumProduct;
        this.c.startIntentSenderForResult(paramString1.getIntentSender(), 29034382, new Intent(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue());
        return;
      }
      this.b.b(a(j, null));
      return;
    }
    catch (Exception paramString1)
    {
      com.ideashower.readitlater.util.e.a(paramString1, true);
      this.b.b(a(-1, new ErrorReport(paramString1, -1)));
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.h) {}
    while (paramInt1 != 29034382) {
      return false;
    }
    if (paramInt2 == 0)
    {
      this.b.b(new com.pocket.billing.b(c.b));
      return true;
    }
    if (paramInt2 != -1)
    {
      this.b.b(new com.pocket.billing.b(c.c));
      return true;
    }
    paramInt1 = a.a(paramIntent);
    String str = paramIntent.getStringExtra("INAPP_PURCHASE_DATA");
    paramIntent = paramIntent.getStringExtra("INAPP_DATA_SIGNATURE");
    if (paramInt1 != 0)
    {
      this.b.b(a(paramInt1, null));
      return true;
    }
    if ((str == null) || (paramIntent == null))
    {
      this.b.b(a(-1, new ErrorReport(-1, "missing data")));
      return true;
    }
    a(this.i, str, paramIntent, ag.a);
    return true;
  }
  
  public void b()
  {
    if (this.h) {}
    do
    {
      return;
      this.g = true;
      if (this.f != null)
      {
        d();
        return;
      }
    } while (this.d != null);
    c();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/billing/google/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */