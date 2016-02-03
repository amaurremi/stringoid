package com.gau.go.launcherex.gowidget.a;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.getjar.sdk.Account;
import com.getjar.sdk.GetjarClient;
import com.getjar.sdk.GetjarClient.Builder;
import com.getjar.sdk.GetjarConnectionCallbacks;
import com.getjar.sdk.GetjarConnectionResult;
import com.getjar.sdk.GetjarVoucherRedeemedResult;
import com.getjar.sdk.OnGetjarLicensesReceivedListener;
import com.getjar.sdk.OnGetjarVoucherRedeemedListener;
import com.getjar.sdk.OnGetjarWorkFinishedListener;
import com.gtp.a.a.b.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class g
  extends Handler
  implements GetjarConnectionCallbacks, OnGetjarLicensesReceivedListener, OnGetjarVoucherRedeemedListener, OnGetjarWorkFinishedListener
{
  private static volatile g e;
  private static ExecutorService h = ;
  public ArrayList a;
  public ArrayList b;
  public ArrayList c;
  public ArrayList d;
  private GetjarClient f = new GetjarClient.Builder("31b94dfe-cc60-4f25-9238-6315a93e624a", paramActivity.getApplicationContext(), paramActivity.getIntent(), this, this).setAccountPickerTitle(paramActivity.getString(2131166053)).create();
  private ConcurrentLinkedQueue g = new ConcurrentLinkedQueue();
  
  private g(Activity paramActivity)
  {
    List localList = this.f.getAvailableAccounts();
    if ((localList.size() == 1) && (y.i(paramActivity.getApplicationContext()))) {
      this.f.setCurrentAccount(((Account)localList.get(0)).getName(), "getjar.android_account");
    }
    this.a = new ArrayList();
    this.b = new ArrayList();
    this.d = new ArrayList();
    this.c = new ArrayList();
  }
  
  public static g a(Activity paramActivity)
  {
    if (e == null) {
      e = new g(paramActivity);
    }
    return e;
  }
  
  public void a()
  {
    this.f.getLicenses(this);
  }
  
  public void a(Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("getjar", false)))
    {
      paramIntent = new f(paramIntent);
      if (!this.g.contains(paramIntent)) {
        this.g.add(paramIntent);
      }
    }
    b();
  }
  
  public void a(i parami)
  {
    if (!this.a.contains(parami)) {
      this.a.add(parami);
    }
  }
  
  public void a(j paramj)
  {
    if (!this.c.contains(paramj)) {
      this.c.add(paramj);
    }
  }
  
  public void a(k paramk)
  {
    if (!this.d.contains(paramk)) {
      this.d.add(paramk);
    }
  }
  
  public void a(l paraml)
  {
    if (!this.b.contains(paraml)) {
      this.b.add(paraml);
    }
  }
  
  public void b()
  {
    if (this.f.isConnected()) {
      h.execute(new h(this));
    }
  }
  
  public void b(i parami)
  {
    this.a.remove(parami);
  }
  
  public void b(j paramj)
  {
    this.c.remove(paramj);
  }
  
  public void b(k paramk)
  {
    this.d.remove(paramk);
  }
  
  public void b(l paraml)
  {
    this.b.remove(paraml);
  }
  
  public GetjarClient c()
  {
    return this.f;
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    this.f.connect();
  }
  
  public void onConnected()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      c.a("adid", "InterstitialAdvertisementHandler: GlobalGetjar : " + this.f.getCurrentAccount().getName() + " onConnected");
      locali.a();
    }
  }
  
  public void onConnectionFailed(GetjarConnectionResult paramGetjarConnectionResult)
  {
    c.a("adid", "InterstitialAdvertisementHandler: GlobalGetjar - onConnectionFailed");
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).a(paramGetjarConnectionResult);
    }
  }
  
  public void onLicensesReceived(int paramInt, List paramList)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((j)localIterator.next()).a(paramInt, paramList);
    }
  }
  
  public void onVoucherRedeemed(int paramInt, GetjarVoucherRedeemedResult paramGetjarVoucherRedeemedResult)
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      ((k)localIterator.next()).a(paramInt, paramGetjarVoucherRedeemedResult);
    }
  }
  
  public void onWorkFinished(Intent paramIntent)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((l)localIterator.next()).a(paramIntent);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */