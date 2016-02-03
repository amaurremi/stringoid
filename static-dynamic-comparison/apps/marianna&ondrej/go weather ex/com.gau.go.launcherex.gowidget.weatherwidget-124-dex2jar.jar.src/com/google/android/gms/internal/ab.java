package com.google.android.gms.internal;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
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
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ab
  implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener
{
  private static final long lw = TimeUnit.MILLISECONDS.toNanos(100L);
  private HashSet<y> lA = new HashSet();
  private final Object li = new Object();
  private final WeakReference<dh> ll;
  private WeakReference<ViewTreeObserver> lm;
  private final WeakReference<View> ln;
  private final z lo;
  private final Context lp;
  private final ad lq;
  private boolean lr;
  private final WindowManager ls;
  private final PowerManager lt;
  private final KeyguardManager lu;
  private ac lv;
  private long lx = Long.MIN_VALUE;
  private boolean ly;
  private BroadcastReceiver lz;
  
  public ab(ak paramak, dh paramdh)
  {
    this(paramak, paramdh, paramdh.oj.bK(), paramdh.oj, new ae(paramdh.oj.getContext(), paramdh.oj.bK()));
  }
  
  public ab(ak paramak, dh paramdh, dx paramdx, View paramView, ad paramad)
  {
    this.ll = new WeakReference(paramdh);
    this.ln = new WeakReference(paramView);
    this.lm = new WeakReference(null);
    this.ly = true;
    this.lo = new z(Integer.toString(paramdh.hashCode()), paramdx, paramak.lS, paramdh.qs);
    this.lq = paramad;
    this.ls = ((WindowManager)paramView.getContext().getSystemService("window"));
    this.lt = ((PowerManager)paramView.getContext().getApplicationContext().getSystemService("power"));
    this.lu = ((KeyguardManager)paramView.getContext().getSystemService("keyguard"));
    this.lp = paramView.getContext().getApplicationContext();
    a(paramad);
    this.lq.a(new ad.a()
    {
      public void ay()
      {
        ab.b(ab.this, true);
        ab.this.d(false);
        ab.this.ap();
      }
    });
    b(this.lq);
    dw.x("Tracking ad unit: " + this.lo.ao());
  }
  
  protected int a(int paramInt, DisplayMetrics paramDisplayMetrics)
  {
    float f = paramDisplayMetrics.density;
    return (int)(paramInt / f);
  }
  
  public void a(ac paramac)
  {
    synchronized (this.li)
    {
      this.lv = paramac;
      return;
    }
  }
  
  protected void a(ad paramad)
  {
    paramad.d("http://googleads.g.doubleclick.net/mads/static/sdk/native/sdk-core-v40.html");
  }
  
  protected void a(dz paramdz, Map<String, String> paramMap)
  {
    d(false);
  }
  
  public void a(y paramy)
  {
    this.lA.add(paramy);
  }
  
  protected void a(JSONObject paramJSONObject)
    throws JSONException
  {
    JSONArray localJSONArray = new JSONArray();
    JSONObject localJSONObject = new JSONObject();
    localJSONArray.put(paramJSONObject);
    localJSONObject.put("units", localJSONArray);
    this.lq.a("AFMA_updateActiveView", localJSONObject);
  }
  
  protected boolean a(View paramView, boolean paramBoolean)
  {
    return (paramView.getVisibility() == 0) && (paramBoolean) && (paramView.isShown()) && (this.lt.isScreenOn()) && (!this.lu.inKeyguardRestrictedInputMode());
  }
  
  protected void ap()
  {
    synchronized (this.li)
    {
      if (this.lz != null) {
        return;
      }
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      this.lz = new BroadcastReceiver()
      {
        public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          ab.this.d(false);
        }
      };
      this.lp.registerReceiver(this.lz, localIntentFilter);
      return;
    }
  }
  
  protected void aq()
  {
    synchronized (this.li)
    {
      if (this.lz != null)
      {
        this.lp.unregisterReceiver(this.lz);
        this.lz = null;
      }
      return;
    }
  }
  
  public void ar()
  {
    synchronized (this.li)
    {
      if (this.ly)
      {
        av();
        aq();
      }
      try
      {
        a(ax());
        this.ly = false;
        as();
        dw.x("Untracked ad unit: " + this.lo.ao());
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          dw.b("JSON Failure while processing active view data.", localJSONException);
        }
      }
    }
  }
  
  protected void as()
  {
    if (this.lv != null) {
      this.lv.a(this);
    }
  }
  
  public boolean at()
  {
    synchronized (this.li)
    {
      boolean bool = this.ly;
      return bool;
    }
  }
  
  protected void au()
  {
    Object localObject = (View)this.ln.get();
    if (localObject == null) {}
    ViewTreeObserver localViewTreeObserver;
    do
    {
      return;
      localViewTreeObserver = (ViewTreeObserver)this.lm.get();
      localObject = ((View)localObject).getViewTreeObserver();
    } while (localObject == localViewTreeObserver);
    this.lm = new WeakReference(localObject);
    ((ViewTreeObserver)localObject).addOnScrollChangedListener(this);
    ((ViewTreeObserver)localObject).addOnGlobalLayoutListener(this);
  }
  
  protected void av()
  {
    ViewTreeObserver localViewTreeObserver = (ViewTreeObserver)this.lm.get();
    if ((localViewTreeObserver == null) || (!localViewTreeObserver.isAlive())) {
      return;
    }
    localViewTreeObserver.removeOnScrollChangedListener(this);
    localViewTreeObserver.removeGlobalOnLayoutListener(this);
  }
  
  protected JSONObject aw()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("afmaVersion", this.lo.am()).put("activeViewJSON", this.lo.an()).put("timestamp", TimeUnit.NANOSECONDS.toMillis(System.nanoTime())).put("adFormat", this.lo.al()).put("hashCode", this.lo.ao());
    return localJSONObject;
  }
  
  protected JSONObject ax()
    throws JSONException
  {
    JSONObject localJSONObject = aw();
    localJSONObject.put("doneReasonCode", "u");
    return localJSONObject;
  }
  
  protected void b(ad paramad)
  {
    paramad.a("/updateActiveView", new bb()
    {
      public void b(dz paramAnonymousdz, Map<String, String> paramAnonymousMap)
      {
        ab.this.a(paramAnonymousdz, paramAnonymousMap);
      }
    });
    paramad.a("/activeViewPingSent", new bb()
    {
      public void b(dz paramAnonymousdz, Map<String, String> paramAnonymousMap)
      {
        if ((paramAnonymousMap.containsKey("pingType")) && ("unloadPing".equals(paramAnonymousMap.get("pingType"))))
        {
          ab.this.c(ab.b(ab.this));
          dw.x("Unregistered GMSG handlers for: " + ab.c(ab.this).ao());
        }
      }
    });
    paramad.a("/visibilityChanged", new bb()
    {
      public void b(dz paramAnonymousdz, Map<String, String> paramAnonymousMap)
      {
        if (!paramAnonymousMap.containsKey("isVisible")) {
          return;
        }
        if (("1".equals(paramAnonymousMap.get("isVisible"))) || ("true".equals(paramAnonymousMap.get("isVisible")))) {}
        for (boolean bool = true;; bool = false)
        {
          ab.this.c(Boolean.valueOf(bool).booleanValue());
          return;
        }
      }
    });
    paramad.a("/viewabilityChanged", ba.mG);
  }
  
  protected JSONObject c(View paramView)
    throws JSONException
  {
    Object localObject2 = new int[2];
    Object localObject1 = new int[2];
    paramView.getLocationOnScreen((int[])localObject2);
    paramView.getLocationInWindow((int[])localObject1);
    localObject1 = aw();
    DisplayMetrics localDisplayMetrics = paramView.getContext().getResources().getDisplayMetrics();
    Rect localRect1 = new Rect();
    localRect1.left = localObject2[0];
    localRect1.top = localObject2[1];
    localRect1.right = (localRect1.left + paramView.getWidth());
    localRect1.bottom = (localRect1.top + paramView.getHeight());
    localObject2 = new Rect();
    ((Rect)localObject2).right = this.ls.getDefaultDisplay().getWidth();
    ((Rect)localObject2).bottom = this.ls.getDefaultDisplay().getHeight();
    Rect localRect2 = new Rect();
    boolean bool = paramView.getGlobalVisibleRect(localRect2, null);
    Rect localRect3 = new Rect();
    paramView.getLocalVisibleRect(localRect3);
    ((JSONObject)localObject1).put("viewBox", new JSONObject().put("top", a(((Rect)localObject2).top, localDisplayMetrics)).put("bottom", a(((Rect)localObject2).bottom, localDisplayMetrics)).put("left", a(((Rect)localObject2).left, localDisplayMetrics)).put("right", a(((Rect)localObject2).right, localDisplayMetrics))).put("adBox", new JSONObject().put("top", a(localRect1.top, localDisplayMetrics)).put("bottom", a(localRect1.bottom, localDisplayMetrics)).put("left", a(localRect1.left, localDisplayMetrics)).put("right", a(localRect1.right, localDisplayMetrics))).put("globalVisibleBox", new JSONObject().put("top", a(localRect2.top, localDisplayMetrics)).put("bottom", a(localRect2.bottom, localDisplayMetrics)).put("left", a(localRect2.left, localDisplayMetrics)).put("right", a(localRect2.right, localDisplayMetrics))).put("localVisibleBox", new JSONObject().put("top", a(localRect3.top, localDisplayMetrics)).put("bottom", a(localRect3.bottom, localDisplayMetrics)).put("left", a(localRect3.left, localDisplayMetrics)).put("right", a(localRect3.right, localDisplayMetrics))).put("screenDensity", localDisplayMetrics.density).put("isVisible", a(paramView, bool));
    return (JSONObject)localObject1;
  }
  
  protected void c(ad paramad)
  {
    paramad.e("/viewabilityChanged");
    paramad.e("/visibilityChanged");
    paramad.e("/activeViewPingSent");
    paramad.e("/updateActiveView");
  }
  
  protected void c(boolean paramBoolean)
  {
    Iterator localIterator = this.lA.iterator();
    while (localIterator.hasNext()) {
      ((y)localIterator.next()).a(this, paramBoolean);
    }
  }
  
  protected void d(boolean paramBoolean)
  {
    long l;
    synchronized (this.li)
    {
      if ((!this.lr) || (!this.ly)) {
        return;
      }
      l = System.nanoTime();
      if ((paramBoolean) && (this.lx + lw > l)) {
        return;
      }
    }
    this.lx = l;
    dh localdh = (dh)this.ll.get();
    View localView = (View)this.ln.get();
    if (localView != null) {
      if (localdh == null) {
        break label154;
      }
    }
    for (;;)
    {
      int i;
      if (i != 0)
      {
        ar();
        return;
        i = 0;
      }
      else
      {
        try
        {
          a(c(localView));
          au();
          as();
          return;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            dw.b("Active view update failed.", localJSONException);
          }
        }
        label154:
        i = 1;
      }
    }
  }
  
  public void onGlobalLayout()
  {
    d(false);
  }
  
  public void onScrollChanged()
  {
    d(true);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */