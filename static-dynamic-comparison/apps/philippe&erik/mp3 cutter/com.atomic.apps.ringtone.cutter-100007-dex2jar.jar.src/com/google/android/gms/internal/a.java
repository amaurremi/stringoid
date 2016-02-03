package com.google.android.gms.internal;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;
import com.atomic.apps.ringtone.cutter.aa;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener
{
  private static final long m = TimeUnit.MILLISECONDS.toNanos(100L);
  private final Object a = new Object();
  private final WeakReference b;
  private WeakReference c;
  private final WeakReference d;
  private final dE e;
  private final Context f;
  private final g g;
  private boolean h;
  private final WindowManager i;
  private final PowerManager j;
  private final KeyguardManager k;
  private f l;
  private long n = Long.MIN_VALUE;
  private boolean o;
  private BroadcastReceiver p;
  private HashSet q = new HashSet();
  
  public a(ak paramak, bA parambA)
  {
    this(paramak, parambA, parambA.b.h(), parambA.b, new g(parambA.b.getContext(), parambA.b.h()));
  }
  
  private a(ak paramak, bA parambA, dx paramdx, View paramView, g paramg)
  {
    this.b = new WeakReference(parambA);
    this.d = new WeakReference(paramView);
    this.c = new WeakReference(null);
    this.o = true;
    this.e = new dE(Integer.toString(parambA.hashCode()), paramdx, paramak.b, parambA.j);
    this.g = paramg;
    this.i = ((WindowManager)paramView.getContext().getSystemService("window"));
    this.j = ((PowerManager)paramView.getContext().getApplicationContext().getSystemService("power"));
    this.k = ((KeyguardManager)paramView.getContext().getSystemService("keyguard"));
    this.f = paramView.getContext().getApplicationContext();
    paramg.a("http://googleads.g.doubleclick.net/mads/static/sdk/native/sdk-core-v40.html");
    this.g.a(new h(this));
    paramak = this.g;
    paramak.a("/updateActiveView", new c(this));
    paramak.a("/activeViewPingSent", new d(this));
    paramak.a("/visibilityChanged", new e(this));
    paramak.a("/viewabilityChanged", I.a);
    aa.c("Tracking ad unit: " + this.e.d());
  }
  
  private static int a(int paramInt, DisplayMetrics paramDisplayMetrics)
  {
    float f1 = paramDisplayMetrics.density;
    return (int)(paramInt / f1);
  }
  
  protected static void a(g paramg)
  {
    paramg.b("/viewabilityChanged");
    paramg.b("/visibilityChanged");
    paramg.b("/activeViewPingSent");
    paramg.b("/updateActiveView");
  }
  
  private void a(JSONObject paramJSONObject)
  {
    JSONArray localJSONArray = new JSONArray();
    JSONObject localJSONObject = new JSONObject();
    localJSONArray.put(paramJSONObject);
    localJSONObject.put("units", localJSONArray);
    this.g.a("AFMA_updateActiveView", localJSONObject);
  }
  
  private void e()
  {
    if (this.l != null) {
      this.l.a(this);
    }
  }
  
  private JSONObject f()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("afmaVersion", this.e.b()).put("activeViewJSON", this.e.c()).put("timestamp", TimeUnit.NANOSECONDS.toMillis(System.nanoTime())).put("adFormat", this.e.a()).put("hashCode", this.e.d());
    return localJSONObject;
  }
  
  protected final void a()
  {
    synchronized (this.a)
    {
      if (this.p != null) {
        return;
      }
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      this.p = new b(this);
      this.f.registerReceiver(this.p, localIntentFilter);
      return;
    }
  }
  
  public final void a(dD paramdD)
  {
    this.q.add(paramdD);
  }
  
  public final void a(f paramf)
  {
    synchronized (this.a)
    {
      this.l = paramf;
      return;
    }
  }
  
  protected final void a(boolean paramBoolean)
  {
    Iterator localIterator = this.q.iterator();
    while (localIterator.hasNext()) {
      ((dD)localIterator.next()).a(paramBoolean);
    }
  }
  
  public final void b()
  {
    for (;;)
    {
      synchronized (this.a)
      {
        if (this.o)
        {
          ??? = (ViewTreeObserver)this.c.get();
          if ((??? != null) && (((ViewTreeObserver)???).isAlive())) {
            break label127;
          }
          synchronized (this.a)
          {
            if (this.p != null)
            {
              this.f.unregisterReceiver(this.p);
              this.p = null;
            }
          }
        }
      }
      try
      {
        ??? = f();
        ((JSONObject)???).put("doneReasonCode", "u");
        a((JSONObject)???);
        this.o = false;
        e();
        aa.c("Untracked ad unit: " + this.e.d());
        return;
        label127:
        ((ViewTreeObserver)???).removeOnScrollChangedListener(this);
        ((ViewTreeObserver)???).removeGlobalOnLayoutListener(this);
        continue;
        localObject3 = finally;
        throw ((Throwable)localObject3);
        localObject4 = finally;
        throw ((Throwable)localObject4);
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          aa.a("JSON Failure while processing active view data.", localJSONException);
        }
      }
    }
  }
  
  protected final void b(boolean paramBoolean)
  {
    long l1;
    synchronized (this.a)
    {
      if ((!this.h) || (!this.o)) {
        return;
      }
      l1 = System.nanoTime();
      if ((paramBoolean) && (this.n + m > l1)) {
        return;
      }
    }
    this.n = l1;
    Object localObject4 = (bA)this.b.get();
    Object localObject3 = (View)this.d.get();
    int i1;
    if (localObject3 != null)
    {
      if (localObject4 == null) {
        break label770;
      }
      while (i1 != 0)
      {
        b();
        return;
        i1 = 0;
      }
    }
    for (;;)
    {
      try
      {
        Object localObject6 = new int[2];
        localObject4 = new int[2];
        ((View)localObject3).getLocationOnScreen((int[])localObject6);
        ((View)localObject3).getLocationInWindow((int[])localObject4);
        localObject4 = f();
        Object localObject5 = ((View)localObject3).getContext().getResources().getDisplayMetrics();
        Rect localRect1 = new Rect();
        localRect1.left = localObject6[0];
        localRect1.top = localObject6[1];
        localRect1.right = (localRect1.left + ((View)localObject3).getWidth());
        localRect1.bottom = (localRect1.top + ((View)localObject3).getHeight());
        localObject6 = new Rect();
        ((Rect)localObject6).right = this.i.getDefaultDisplay().getWidth();
        ((Rect)localObject6).bottom = this.i.getDefaultDisplay().getHeight();
        Rect localRect2 = new Rect();
        paramBoolean = ((View)localObject3).getGlobalVisibleRect(localRect2, null);
        Rect localRect3 = new Rect();
        ((View)localObject3).getLocalVisibleRect(localRect3);
        localObject5 = ((JSONObject)localObject4).put("viewBox", new JSONObject().put("top", a(((Rect)localObject6).top, (DisplayMetrics)localObject5)).put("bottom", a(((Rect)localObject6).bottom, (DisplayMetrics)localObject5)).put("left", a(((Rect)localObject6).left, (DisplayMetrics)localObject5)).put("right", a(((Rect)localObject6).right, (DisplayMetrics)localObject5))).put("adBox", new JSONObject().put("top", a(localRect1.top, (DisplayMetrics)localObject5)).put("bottom", a(localRect1.bottom, (DisplayMetrics)localObject5)).put("left", a(localRect1.left, (DisplayMetrics)localObject5)).put("right", a(localRect1.right, (DisplayMetrics)localObject5))).put("globalVisibleBox", new JSONObject().put("top", a(localRect2.top, (DisplayMetrics)localObject5)).put("bottom", a(localRect2.bottom, (DisplayMetrics)localObject5)).put("left", a(localRect2.left, (DisplayMetrics)localObject5)).put("right", a(localRect2.right, (DisplayMetrics)localObject5))).put("localVisibleBox", new JSONObject().put("top", a(localRect3.top, (DisplayMetrics)localObject5)).put("bottom", a(localRect3.bottom, (DisplayMetrics)localObject5)).put("left", a(localRect3.left, (DisplayMetrics)localObject5)).put("right", a(localRect3.right, (DisplayMetrics)localObject5))).put("screenDensity", ((DisplayMetrics)localObject5).density);
        if ((((View)localObject3).getVisibility() != 0) || (!paramBoolean) || (!((View)localObject3).isShown()) || (!this.j.isScreenOn()) || (this.k.inKeyguardRestrictedInputMode())) {
          break label775;
        }
        paramBoolean = true;
        ((JSONObject)localObject5).put("isVisible", paramBoolean);
        a((JSONObject)localObject4);
      }
      catch (JSONException localJSONException)
      {
        aa.a("Active view update failed.", localJSONException);
        continue;
      }
      localObject4 = (View)this.d.get();
      if (localObject4 != null)
      {
        localObject3 = (ViewTreeObserver)this.c.get();
        localObject4 = ((View)localObject4).getViewTreeObserver();
        if (localObject4 != localObject3)
        {
          this.c = new WeakReference(localObject4);
          ((ViewTreeObserver)localObject4).addOnScrollChangedListener(this);
          ((ViewTreeObserver)localObject4).addOnGlobalLayoutListener(this);
        }
      }
      e();
      return;
      label770:
      i1 = 1;
      break;
      label775:
      paramBoolean = false;
    }
  }
  
  protected final void c()
  {
    b(false);
  }
  
  public final boolean d()
  {
    synchronized (this.a)
    {
      boolean bool = this.o;
      return bool;
    }
  }
  
  public final void onGlobalLayout()
  {
    b(false);
  }
  
  public final void onScrollChanged()
  {
    b(true);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */