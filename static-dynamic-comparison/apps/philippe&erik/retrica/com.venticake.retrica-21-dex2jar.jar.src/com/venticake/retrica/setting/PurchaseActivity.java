package com.venticake.retrica.setting;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import com.b.a.a.a.d;
import com.b.a.a.a.e;
import com.b.a.a.a.f;
import com.b.a.a.a.g;
import com.b.a.a.a.h;
import com.b.a.a.a.i;
import com.b.a.a.a.j;
import com.b.a.a.a.l;
import com.venticake.retrica.c;
import java.util.ArrayList;

public class PurchaseActivity
  extends c
{
  d o;
  l p = null;
  Button q = null;
  boolean r = false;
  String s = null;
  g t = new g()
  {
    public void a(h paramAnonymoush, i paramAnonymousi)
    {
      Log.d("iab", "requestInventoryAsync FINISH");
      if (paramAnonymoush.d())
      {
        Log.d("iab", "Failure : " + paramAnonymoush);
        PurchaseActivity.this.a(paramAnonymoush);
        return;
      }
      int i;
      if (paramAnonymousi.c(PurchaseActivity.a(PurchaseActivity.this)))
      {
        paramAnonymoush = paramAnonymousi.b(PurchaseActivity.a(PurchaseActivity.this));
        Log.d("iab", "Purchase: " + paramAnonymoush);
        i = paramAnonymoush.c();
        if (i == 0)
        {
          Log.d("iab", "ALREADY Purchased: " + paramAnonymousi);
          PurchaseActivity.this.q();
          return;
        }
        if (i != 1) {
          break label214;
        }
        Log.d("iab", "CANCELED purchasing: " + paramAnonymousi);
      }
      for (;;)
      {
        PurchaseActivity.this.p = paramAnonymousi.a(PurchaseActivity.a(PurchaseActivity.this));
        Log.d("iab", "READY to be purchased: " + PurchaseActivity.this.p);
        PurchaseActivity.this.r();
        return;
        label214:
        if (i == 2) {
          Log.d("iab", "REFUNDEDpurchasing: " + paramAnonymousi);
        } else {
          Log.d("iab", "INVALID purchase state: " + i);
        }
      }
    }
  };
  e u = new e()
  {
    public void a(h paramAnonymoush, j paramAnonymousj)
    {
      if (paramAnonymoush.d()) {
        if (paramAnonymoush.a() == 7)
        {
          Log.d("iab", "Already OWNED: " + paramAnonymoush.a() + "\n" + paramAnonymoush);
          PurchaseActivity.this.q();
        }
      }
      int i;
      do
      {
        do
        {
          return;
          Log.d("iab", "Error purchasing: " + paramAnonymoush.a() + "\n" + paramAnonymoush);
          PurchaseActivity.this.a(paramAnonymoush);
          return;
        } while (!paramAnonymousj.b().equals(PurchaseActivity.a(PurchaseActivity.this)));
        i = paramAnonymousj.c();
        Log.d("iab", "SUCCESS (purchaseState: " + i + ")");
      } while (i != 0);
      PurchaseActivity.this.q();
    }
  };
  private Handler v;
  private final String w = "PurchaseActivity";
  
  private String s()
  {
    return a.c();
  }
  
  private void t()
  {
    this.o = new d(this, a.b());
    this.o.a(new f()
    {
      public void a(h paramAnonymoush)
      {
        if (!paramAnonymoush.c())
        {
          Log.d("iab", "Problem setting up In-app Billing: " + paramAnonymoush);
          PurchaseActivity.this.c("Problem setting up In-app Billing: (" + paramAnonymoush.a() + ") " + paramAnonymoush.b());
          return;
        }
        Log.d("iab", "IAB is fully set up!");
        new Handler().post(new Runnable()
        {
          public void run()
          {
            PurchaseActivity.c(PurchaseActivity.this);
          }
        });
      }
    });
  }
  
  private void u()
  {
    Log.d("iab", "requestInventoryAsync START");
    this.p = null;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(s());
    try
    {
      this.o.a(true, localArrayList, this.t);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      c("Problem fetching the inventory: " + localException.getLocalizedMessage());
    }
  }
  
  protected void a(h paramh)
  {
    d(paramh.b());
  }
  
  protected void c(String paramString)
  {
    this.r = true;
    this.s = paramString;
    r();
    d(this.s);
  }
  
  protected void d(final String paramString)
  {
    this.v.post(new Runnable()
    {
      public void run()
      {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(jdField_this);
        localBuilder.setTitle("Error");
        localBuilder.setMessage(paramString);
        localBuilder.setPositiveButton(17039370, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            paramAnonymous2DialogInterface.dismiss();
          }
        });
        localBuilder.show();
      }
    });
  }
  
  protected void i()
  {
    finish();
  }
  
  protected void n()
  {
    if (this.r) {}
    while (o()) {
      return;
    }
    try
    {
      this.o.a(this, s(), 10001, this.u);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      c("Problem buying: " + localException.getLocalizedMessage());
    }
  }
  
  protected boolean o()
  {
    return this.p == null;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Log.d("iab", "onActivityResult(" + paramInt1 + "," + paramInt2 + "," + paramIntent);
    if (this.o == null) {
      return;
    }
    if (!this.o.a(paramInt1, paramInt2, paramIntent))
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    Log.d("iab", "onActivityResult handled by IABUtil.");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setFlags(1024, 1024);
    setContentView(2130903067);
    f().a(2130837931);
    this.v = new Handler(Looper.getMainLooper());
    this.q = ((Button)findViewById(2131296396));
    this.q.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        PurchaseActivity.this.n();
      }
    });
    r();
    if (!p()) {
      new Handler().post(new Runnable()
      {
        public void run()
        {
          PurchaseActivity.b(PurchaseActivity.this);
        }
      });
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.o != null) {}
    try
    {
      this.o.a();
      this.o = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    }
    i();
    return true;
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  protected boolean p()
  {
    return a.a().u();
  }
  
  protected void q()
  {
    a.a().f(true);
    r();
  }
  
  protected void r()
  {
    this.v.post(new Runnable()
    {
      public void run()
      {
        PurchaseActivity.this.findViewById(2131296397).setVisibility(8);
        if (PurchaseActivity.this.p())
        {
          PurchaseActivity.this.findViewById(2131296395).setVisibility(8);
          PurchaseActivity.this.findViewById(2131296399).setVisibility(0);
          return;
        }
        if (PurchaseActivity.this.r)
        {
          PurchaseActivity.this.q.setText(2131165287);
          PurchaseActivity.this.findViewById(2131296395).setVisibility(0);
          PurchaseActivity.this.findViewById(2131296399).setVisibility(8);
          return;
        }
        if (PurchaseActivity.this.o())
        {
          PurchaseActivity.this.q.setText(2131165286);
          PurchaseActivity.this.findViewById(2131296395).setVisibility(0);
          PurchaseActivity.this.findViewById(2131296399).setVisibility(8);
          return;
        }
        String str = PurchaseActivity.this.getResources().getString(2131165291);
        if (PurchaseActivity.this.p == null) {}
        for (;;)
        {
          PurchaseActivity.this.q.setText(str);
          PurchaseActivity.this.findViewById(2131296395).setVisibility(0);
          PurchaseActivity.this.findViewById(2131296399).setVisibility(8);
          return;
          str = String.format("%s (%s)", new Object[] { str, PurchaseActivity.this.p.b() });
        }
      }
    });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/setting/PurchaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */