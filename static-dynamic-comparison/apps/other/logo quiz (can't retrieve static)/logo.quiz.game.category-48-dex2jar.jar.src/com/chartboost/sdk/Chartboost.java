package com.chartboost.sdk;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.util.SparseBooleanArray;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Libraries.c;
import com.chartboost.sdk.Libraries.f;
import com.chartboost.sdk.Libraries.f.g;
import com.chartboost.sdk.Libraries.h;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.chartboost.sdk.Model.a.b;
import com.chartboost.sdk.impl.i;
import com.chartboost.sdk.impl.i.c;
import com.chartboost.sdk.impl.j;
import com.chartboost.sdk.impl.n;
import java.util.Locale;
import org.json.JSONObject;

public final class Chartboost
{
  private static volatile Chartboost e = null;
  protected h a = null;
  protected i b;
  protected Handler c;
  protected boolean d = false;
  private Context f = null;
  private CBImpressionActivity g = null;
  private a h;
  private com.chartboost.sdk.Model.a i = null;
  private CBPreferences j = null;
  private boolean k = false;
  private SparseBooleanArray l = new SparseBooleanArray();
  private b m = null;
  private long n = 0L;
  private long o = 0L;
  private boolean p = false;
  private Runnable q = new a(null);
  
  private Chartboost()
  {
    e = this;
    this.c = new Handler();
    this.b = new i(null, "main");
    this.h = a.a(this);
    this.m = b.a(this);
    this.j = CBPreferences.getInstance();
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    this.l.put(paramInt, paramBoolean);
  }
  
  private void a(Activity paramActivity, String paramString1, String paramString2, ChartboostDelegate paramChartboostDelegate)
  {
    if ((!this.j.getIgnoreErrors()) && (!CBUtility.b())) {
      throw new IllegalStateException("It is illegal to call this method from any thread other than the UI thread. Please call it from the onCreate() method of your host activity.");
    }
    if ((this.a != null) && (!this.a.b(paramActivity)) && (f()))
    {
      b(this.a);
      a(this.a, false);
    }
    this.c.removeCallbacks(this.q);
    this.a = h.a(paramActivity);
    this.f = paramActivity.getApplicationContext();
    c.a();
    this.j.setAppID(paramString1);
    this.j.setAppSignature(paramString2);
    this.j.setDelegate(paramChartboostDelegate);
    this.b.b();
  }
  
  private void a(Activity paramActivity, boolean paramBoolean)
  {
    if (paramActivity == null) {
      return;
    }
    a(paramActivity.hashCode(), paramBoolean);
  }
  
  private void a(h paramh, boolean paramBoolean)
  {
    if (paramh == null) {
      return;
    }
    a(paramh.a(), paramBoolean);
  }
  
  private void b(h paramh)
  {
    if (!this.j.getImpressionsUseActivities()) {
      c(paramh);
    }
    if (!(paramh.get() instanceof CBImpressionActivity)) {
      a(paramh, false);
    }
    this.n = ((System.nanoTime() / 1000000.0D));
  }
  
  private void b(h paramh, boolean paramBoolean) {}
  
  private void c(h paramh)
  {
    b localb = a();
    if ((d(paramh)) && (localb != null))
    {
      com.chartboost.sdk.Model.a locala = this.h.a();
      if (locala != null)
      {
        localb.b(locala);
        this.i = locala;
      }
      b(paramh, false);
      if ((paramh.get() instanceof CBImpressionActivity)) {
        d();
      }
    }
    if (!(paramh.get() instanceof CBImpressionActivity)) {
      a(paramh, false);
    }
  }
  
  private void cacheInterstitialData(String paramString, CBAPIResponseCallback paramCBAPIResponseCallback)
  {
    d.a(paramString, paramCBAPIResponseCallback);
  }
  
  private void cacheInterstitialDataBatch(String paramString, int paramInt, CBAPIResponseCallback paramCBAPIResponseCallback)
  {
    d.a(paramString, paramInt, paramCBAPIResponseCallback);
  }
  
  private boolean d(Activity paramActivity)
  {
    if (this.j.getImpressionsUseActivities()) {
      if (this.g != paramActivity) {}
    }
    do
    {
      return true;
      return false;
      if (this.a != null) {
        break;
      }
    } while (paramActivity == null);
    return false;
    return this.a.b(paramActivity);
  }
  
  private boolean d(h paramh)
  {
    if (this.j.getImpressionsUseActivities()) {
      if (paramh == null) {
        if (this.g != null) {}
      }
    }
    do
    {
      return true;
      return false;
      return paramh.b(this.g);
      if (this.a != null) {
        break;
      }
    } while (paramh == null);
    return false;
    return this.a.a(paramh);
  }
  
  private boolean f()
  {
    return a(this.a);
  }
  
  public static Chartboost sharedChartboost()
  {
    if (e == null) {}
    try
    {
      if (e == null) {
        e = new Chartboost();
      }
      return e;
    }
    finally {}
  }
  
  private void showInterstitialData(String paramString, CBAPIResponseCallback paramCBAPIResponseCallback)
  {
    d.b(paramString, paramCBAPIResponseCallback);
  }
  
  protected b a()
  {
    if (c() == null) {
      return null;
    }
    return this.m;
  }
  
  protected void a(Activity paramActivity)
  {
    this.f = paramActivity.getApplicationContext();
    if (!(paramActivity instanceof CBImpressionActivity))
    {
      this.a = h.a(paramActivity);
      a(this.a, true);
    }
    for (;;)
    {
      this.c.removeCallbacks(this.q);
      if ((paramActivity != null) && (d(paramActivity))) {
        break;
      }
      return;
      a((CBImpressionActivity)paramActivity);
    }
    b(h.a(paramActivity), true);
    if ((paramActivity instanceof CBImpressionActivity)) {
      this.p = false;
    }
    this.h.a(paramActivity, this.i);
    this.i = null;
  }
  
  protected void a(CBImpressionActivity paramCBImpressionActivity)
  {
    if (!this.k)
    {
      this.f = paramCBImpressionActivity.getApplicationContext();
      this.g = paramCBImpressionActivity;
      this.k = true;
    }
    this.c.removeCallbacks(this.q);
  }
  
  protected void a(com.chartboost.sdk.Model.a parama)
  {
    boolean bool = true;
    if (this.j.getImpressionsUseActivities())
    {
      if (this.k)
      {
        localObject = a();
        if ((c() != null) && (localObject != null))
        {
          ((b)localObject).a(parama);
          return;
        }
        CBLogging.b("Chartboost", "Missing CBViewController to manage the open CBImpressionActivity");
        return;
      }
      if (!f())
      {
        parama.a(CBError.CBImpressionError.NO_HOST_ACTIVITY);
        return;
      }
      localObject = getHostActivity();
      if (localObject == null)
      {
        CBLogging.b("Chartboost", "Failed to display impression as the host activity reference has been lost!");
        parama.a(CBError.CBImpressionError.NO_HOST_ACTIVITY);
        return;
      }
      if ((this.i != null) && (this.i != parama))
      {
        parama.a(CBError.CBImpressionError.IMPRESSION_ALREADY_VISIBLE);
        return;
      }
      this.i = parama;
      parama = new Intent((Context)localObject, CBImpressionActivity.class);
      int i1;
      int i2;
      if ((((Activity)localObject).getWindow().getAttributes().flags & 0x400) != 0)
      {
        i1 = 1;
        if ((((Activity)localObject).getWindow().getAttributes().flags & 0x800) == 0) {
          break label225;
        }
        i2 = 1;
        label178:
        if ((i1 == 0) || (i2 != 0)) {
          break label230;
        }
      }
      for (;;)
      {
        parama.putExtra("paramFullscreen", bool);
        try
        {
          ((Activity)localObject).startActivity(parama);
          this.p = true;
          return;
        }
        catch (ActivityNotFoundException parama)
        {
          throw new RuntimeException("Chartboost impression activity not declared in manifest. Please add the following inside your manifest's <application> tag: \n<activity android:name=\"com.chartboost.sdk.CBImpressionActivity\" android:theme=\"@android:style/Theme.Translucent.NoTitleBar\" android:excludeFromRecents=\"true\" />");
        }
        i1 = 0;
        break;
        label225:
        i2 = 0;
        break label178;
        label230:
        bool = false;
      }
    }
    Object localObject = a();
    if ((localObject != null) && (f()))
    {
      ((b)localObject).a(parama);
      return;
    }
    parama.a(CBError.CBImpressionError.NO_HOST_ACTIVITY);
  }
  
  protected void a(Runnable paramRunnable)
  {
    if (!CBUtility.b())
    {
      this.c.post(paramRunnable);
      return;
    }
    paramRunnable.run();
  }
  
  protected boolean a(h paramh)
  {
    if (paramh == null) {}
    do
    {
      return false;
      paramh = Boolean.valueOf(this.l.get(paramh.a()));
    } while (paramh == null);
    return paramh.booleanValue();
  }
  
  protected void b(Activity paramActivity)
  {
    c(h.a(paramActivity));
  }
  
  protected boolean b()
  {
    if ((this.h.a() != null) && (this.h.a().c == a.b.c))
    {
      a(new Runnable()
      {
        public void run()
        {
          Chartboost.a(Chartboost.this).d();
        }
      });
      return true;
    }
    final b localb = a();
    if ((localb != null) && (localb.a()))
    {
      a(new Runnable()
      {
        public void run()
        {
          localb.a(true);
        }
      });
      return true;
    }
    return false;
  }
  
  protected Activity c()
  {
    if (this.j.getImpressionsUseActivities()) {
      return this.g;
    }
    return getHostActivity();
  }
  
  protected void c(Activity paramActivity)
  {
    b(h.a(paramActivity), false);
  }
  
  public void cacheInterstitial()
  {
    cacheInterstitial("Default");
  }
  
  public void cacheInterstitial(String paramString)
  {
    if (this.a == null) {
      throw new IllegalStateException("The context must be set through the Chartboost method onCreate() before calling cacheInterstitial().");
    }
    this.h.a(paramString);
  }
  
  public void cacheMoreApps()
  {
    if (this.a == null) {
      throw new IllegalStateException("The context must be set through the Chartboost method onCreate() before calling cacheMoreApps().");
    }
    this.h.a(true);
  }
  
  public void clearCache()
  {
    this.h.e();
  }
  
  public void clearImageCache()
  {
    if (getContext() == null) {
      throw new IllegalStateException("The context must be set through the Chartboost method onCreate() before calling clearImageCache().");
    }
    n.a().b();
  }
  
  protected void d()
  {
    if (this.k)
    {
      this.g = null;
      this.k = false;
    }
  }
  
  protected Context e()
  {
    if (this.a != null) {
      return this.a.b();
    }
    return getContext();
  }
  
  public Context getContext()
  {
    return this.f;
  }
  
  public String getDeviceIdentifier()
  {
    return c.b();
  }
  
  protected Activity getHostActivity()
  {
    if (this.a != null) {
      return (Activity)this.a.get();
    }
    return null;
  }
  
  public CBPreferences getPreferences()
  {
    return this.j;
  }
  
  public boolean hasCachedInterstitial()
  {
    return hasCachedInterstitial("Default");
  }
  
  public boolean hasCachedInterstitial(String paramString)
  {
    return this.h.c(paramString);
  }
  
  public boolean hasCachedMoreApps()
  {
    return this.h.c();
  }
  
  public boolean onBackPressed()
  {
    boolean bool = false;
    if ((!this.j.getIgnoreErrors()) && (!CBUtility.b())) {
      throw new IllegalStateException("It is illegal to call this method from any thread other than the UI thread. Please call it from the onBackPressed() method of your host activity.");
    }
    if (this.a == null) {
      throw new IllegalStateException("The Chartboost methods onCreate(), onStart(), onStop(), and onDestroy() must be called in the corresponding methods of your activity in order for Chartboost to function properly.");
    }
    if (this.j.getImpressionsUseActivities())
    {
      if (this.p)
      {
        this.p = false;
        b();
        bool = true;
      }
      return bool;
    }
    return b();
  }
  
  public void onCreate(Activity paramActivity, String paramString1, String paramString2, ChartboostDelegate paramChartboostDelegate)
  {
    a(paramActivity, paramString1, paramString2, paramChartboostDelegate);
  }
  
  public void onDestroy(Activity paramActivity)
  {
    if ((this.a == null) || (this.a.b(paramActivity)))
    {
      this.c.removeCallbacks(this.q);
      this.q = new a(null);
      this.c.postDelayed(this.q, 10000L);
    }
    c(paramActivity);
  }
  
  public void onStart(Activity paramActivity)
  {
    if ((!this.j.getIgnoreErrors()) && (!CBUtility.b())) {
      throw new IllegalStateException("It is illegal to call this method from any thread other than the UI thread. Please call it from the onStart() method of your host activity.");
    }
    this.c.removeCallbacks(this.q);
    if ((this.a != null) && (!this.a.b(paramActivity)) && (f()))
    {
      b(this.a);
      a(this.a, false);
    }
    a(paramActivity, true);
    this.a = h.a(paramActivity);
    this.f = paramActivity.getApplicationContext();
    if (!this.j.getImpressionsUseActivities()) {
      a(paramActivity);
    }
  }
  
  public void onStop(Activity paramActivity)
  {
    if ((!this.j.getIgnoreErrors()) && (!CBUtility.b())) {
      throw new IllegalStateException("It is illegal to call this method from any thread other than the UI thread. Please call it from the onStop() method of your host activity.");
    }
    paramActivity = h.a(paramActivity);
    if (a(paramActivity)) {
      b(paramActivity);
    }
  }
  
  public void showInterstitial()
  {
    showInterstitial("Default");
  }
  
  public void showInterstitial(String paramString)
  {
    if (this.a == null) {
      throw new IllegalStateException("The context must be set through the Chartboost method onCreate() before calling showInterstitial().");
    }
    this.h.b(paramString);
  }
  
  public void showMoreApps()
  {
    if (this.a == null) {
      throw new IllegalStateException("The context must be set through the Chartboost method onCreate() before calling showMoreApps().");
    }
    this.h.b();
  }
  
  public void showMoreAppsData(CBAPIResponseCallback paramCBAPIResponseCallback)
  {
    d.a(paramCBAPIResponseCallback);
  }
  
  public void startSession()
  {
    if (this.a == null) {
      throw new IllegalStateException("The context must be set through the Chartboost method onCreate() before calling startSession().");
    }
    this.d = true;
    long l1 = (System.nanoTime() / 1000000.0D);
    if (l1 - this.n < 10000L) {}
    while (l1 - this.o < 60000L) {
      return;
    }
    this.o = l1;
    Object localObject = CBUtility.a();
    int i1 = ((SharedPreferences)localObject).getInt("cbPrefSessionCount", 0);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt("cbPrefSessionCount", i1 + 1);
    ((SharedPreferences.Editor)localObject).commit();
    localObject = new j("api/install");
    ((j)localObject).a(e());
    ((j)localObject).a(new f.g[] { f.a("status", i.a) });
    this.b.a((j)localObject, new i.c()
    {
      public void a(JSONObject paramAnonymousJSONObject, j paramAnonymousj)
      {
        if (CBUtility.a(Chartboost.this.getContext()))
        {
          paramAnonymousJSONObject = paramAnonymousJSONObject.optString("latest-sdk-version");
          if ((paramAnonymousJSONObject != null) && (!paramAnonymousJSONObject.equals("")) && (!paramAnonymousJSONObject.equals("4.0.1"))) {
            CBLogging.a(String.format(Locale.US, "Chartboost SDK is not up to date. (Current: %s, Latest: %s)\n Download latest SDK at:\n\thttps://www.chartboost.com/support/sdk_download/?os=ios", new Object[] { "4.0.1", paramAnonymousJSONObject }));
          }
        }
      }
    });
  }
  
  public static abstract interface CBAPIResponseCallback
  {
    public abstract void onFailure(CBError.CBImpressionError paramCBImpressionError);
    
    public abstract void onSuccess(JSONObject paramJSONObject);
  }
  
  public static abstract interface CBAgeGateConfirmation
  {
    public abstract void execute(boolean paramBoolean);
  }
  
  private class a
    implements Runnable
  {
    private int b;
    private int c;
    private int d;
    
    private a()
    {
      ChartboostDelegate localChartboostDelegate = a();
      if (Chartboost.c(Chartboost.this) == null)
      {
        i = -1;
        this.b = i;
        if (Chartboost.this.a != null) {
          break label69;
        }
        i = -1;
        label40:
        this.c = i;
        if (localChartboostDelegate != null) {
          break label80;
        }
      }
      label69:
      label80:
      for (int i = j;; i = localChartboostDelegate.hashCode())
      {
        this.d = i;
        return;
        i = Chartboost.c(Chartboost.this).hashCode();
        break;
        i = Chartboost.this.a.hashCode();
        break label40;
      }
    }
    
    private ChartboostDelegate a()
    {
      if (Chartboost.b(Chartboost.this) != null) {
        return Chartboost.b(Chartboost.this).getDelegate();
      }
      return null;
    }
    
    public void run()
    {
      ChartboostDelegate localChartboostDelegate = a();
      if (Chartboost.this.getContext() != null) {
        Chartboost.this.clearImageCache();
      }
      if ((Chartboost.this.a != null) && (Chartboost.this.a.hashCode() == this.c)) {
        Chartboost.this.a = null;
      }
      if ((Chartboost.c(Chartboost.this) != null) && (Chartboost.c(Chartboost.this).hashCode() == this.b)) {
        Chartboost.a(Chartboost.this, null);
      }
      if ((localChartboostDelegate != null) && (localChartboostDelegate.hashCode() == this.d)) {
        Chartboost.b(Chartboost.this).setDelegate(null);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/Chartboost.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */