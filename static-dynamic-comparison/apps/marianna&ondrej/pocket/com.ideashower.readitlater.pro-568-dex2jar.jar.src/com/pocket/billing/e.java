package com.pocket.billing;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.ideashower.readitlater.a.as;
import com.ideashower.readitlater.objects.ErrorReport;
import com.ideashower.readitlater.util.k;
import com.pocket.billing.google.GooglePremiumProduct;
import com.pocket.c.ag;

public class e
  implements a
{
  private final com.pocket.billing.google.d a;
  private final Activity b;
  private final f c;
  private boolean d;
  private boolean e;
  private com.pocket.billing.google.g f;
  private g g;
  
  public e(Activity paramActivity, f paramf, Bundle paramBundle)
  {
    this.b = paramActivity;
    this.c = paramf;
    this.a = new com.pocket.billing.google.d(paramActivity, this, paramBundle);
    this.a.b();
  }
  
  private void a(g paramg)
  {
    if (this.g == paramg) {
      return;
    }
    this.g = paramg;
    this.c.a(paramg);
  }
  
  private boolean a(GooglePremiumProduct paramGooglePremiumProduct)
  {
    if ((paramGooglePremiumProduct != null) && (paramGooglePremiumProduct.d()))
    {
      this.a.a(paramGooglePremiumProduct, paramGooglePremiumProduct.e(), null, ag.b);
      return true;
    }
    return false;
  }
  
  private void g()
  {
    new AlertDialog.Builder(this.b).setTitle(2131493577).setMessage(this.b.getString(2131493576, new Object[] { this.b.getString(2131492898) })).setPositiveButton(2131492924, null).setNegativeButton(2131492898, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        k.a(e.a(e.this), k.a(), "Android: Already Subscribed", null, true, null, null);
      }
    }).show();
  }
  
  private void h()
  {
    new AlertDialog.Builder(this.b).setTitle(2131493585).setMessage(this.b.getString(2131493584, new Object[] { this.b.getString(2131492898) })).setPositiveButton(2131492924, null).setNegativeButton(2131492898, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        k.a(e.a(e.this), k.a(), "Android: No Subscription Found", null, true, null, null);
      }
    }).show();
  }
  
  private void i()
  {
    new AlertDialog.Builder(this.b).setTitle(2131493579).setMessage(2131493578).setPositiveButton(2131492924, null).setNegativeButton(2131492898, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        k.a(e.a(e.this), k.a(), "Android: Purchase Not Successful", null, true, null, null);
      }
    }).show();
  }
  
  public void a()
  {
    a(g.c);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.a.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(Bundle paramBundle)
  {
    this.a.a(paramBundle);
  }
  
  public void a(ErrorReport paramErrorReport)
  {
    a(g.d);
    paramErrorReport = new AlertDialog.Builder(this.b).setTitle(2131493575).setMessage(2131493574).setPositiveButton(2131492924, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        com.ideashower.readitlater.a.g.a(e.a(e.this), "http://help.getpocket.com/customer/portal/articles/1531047");
      }
    }).create();
    paramErrorReport.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        e.b(e.this).e();
      }
    });
    paramErrorReport.show();
  }
  
  public void a(b paramb)
  {
    if (this.g == g.b)
    {
      a(g.d);
      h();
    }
    for (;;)
    {
      this.c.a();
      return;
      a(g.d);
      if (!this.d)
      {
        if (paramb.a() == c.a) {}
        for (boolean bool = true;; bool = false)
        {
          this.e = bool;
          break;
        }
      }
      switch (7.a[paramb.a().ordinal()])
      {
      case 3: 
      default: 
        break;
      case 1: 
        this.c.b();
        break;
      case 2: 
        i();
      }
    }
  }
  
  public void a(d paramd)
  {
    if (as.m())
    {
      g();
      this.c.a(g.d);
      this.c.a(false);
      return;
    }
    if (!com.ideashower.readitlater.a.g.k())
    {
      i();
      this.c.a(g.d);
      this.c.a(false);
      return;
    }
    a(g.a);
    this.a.a(paramd);
  }
  
  public void a(com.pocket.billing.google.g paramg)
  {
    this.f = paramg;
    this.c.a(paramg);
    if (this.g == g.b) {
      d();
    }
  }
  
  public void b()
  {
    as.a(new com.pocket.user.d(as.k().h()).b(1).a());
    a(g.d);
    this.c.d();
  }
  
  public void b(final b paramb)
  {
    a(g.d);
    switch (7.a[paramb.a().ordinal()])
    {
    default: 
      new AlertDialog.Builder(this.b).setTitle(2131493583).setMessage(2131493582).setPositiveButton(2131492924, null).setNegativeButton(2131492898, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          k.a(e.a(e.this), k.a(), "Android: Purchase Not Successful", null, true, paramb.b(), null);
        }
      }).show();
      this.c.a(false);
      return;
    case 4: 
      if (as.m()) {
        g();
      }
      for (;;)
      {
        this.c.a(false);
        return;
        d();
      }
    }
    this.c.a(true);
  }
  
  public void c()
  {
    this.d = true;
    if (this.e)
    {
      this.c.b();
      return;
    }
    if (!com.ideashower.readitlater.a.g.k())
    {
      i();
      this.c.a();
      return;
    }
    this.a.b();
  }
  
  public void d()
  {
    if (as.m()) {
      b();
    }
    do
    {
      return;
      if (!com.ideashower.readitlater.a.g.k())
      {
        a(g.d);
        i();
        this.c.a(false);
        return;
      }
      if (this.f == null) {
        break;
      }
    } while ((a(this.f.b())) || (a(this.f.a())));
    a(g.d);
    h();
    this.c.a(false);
    return;
    a(g.b);
    this.a.b();
  }
  
  public boolean e()
  {
    a(g.d);
    return this.e;
  }
  
  public void f()
  {
    if (this.a != null) {
      this.a.a();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/billing/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */