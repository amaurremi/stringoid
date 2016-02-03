package com.go.weatherex.b.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.gau.go.launcherex.gowidget.billing.BillingActivity;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gau.go.launcherex.gowidget.weather.d.f;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class a
{
  private Context a;
  private boolean b = false;
  private boolean c = false;
  private HashMap d = new HashMap();
  private volatile c e;
  private String f;
  private boolean g;
  
  private void a(Activity paramActivity)
  {
    if (this.e == null) {
      this.e = b(paramActivity);
    }
    do
    {
      return;
      paramActivity = this.e.getParent();
    } while ((paramActivity == null) || (!(paramActivity instanceof ViewGroup)));
    ((ViewGroup)paramActivity).removeView(this.e);
  }
  
  private void a(Context paramContext, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(paramContext, BillingActivity.class);
    localIntent.putExtra("recommend_type", paramInt1);
    localIntent.putExtra("recommend_enterance", paramInt2);
    localIntent.addFlags(268435456);
    paramContext.startActivity(localIntent);
  }
  
  private void a(c paramc)
  {
    if (paramc != null)
    {
      com.gtp.a.a.b.c.a("admobviewholder", "destroy adview - " + paramc);
      ViewParent localViewParent = paramc.getParent();
      if ((localViewParent != null) && ((localViewParent instanceof ViewGroup))) {
        ((ViewGroup)localViewParent).removeView(paramc);
      }
      paramc.c();
    }
  }
  
  private c b(Activity paramActivity)
  {
    paramActivity = new c(paramActivity);
    paramActivity.a(new b(this));
    paramActivity.a(this.f);
    return paramActivity;
  }
  
  private c b(Activity paramActivity, ViewGroup paramViewGroup)
  {
    if (this.g)
    {
      a(paramActivity);
      return this.e;
    }
    paramActivity = b(paramActivity);
    this.d.put(paramViewGroup, paramActivity);
    return paramActivity;
  }
  
  private void e()
  {
    this.f = null;
    this.g = false;
  }
  
  public c a(Activity paramActivity, ViewGroup paramViewGroup)
  {
    try
    {
      paramActivity = a(paramActivity, paramViewGroup, false);
      return paramActivity;
    }
    finally
    {
      paramActivity = finally;
      throw paramActivity;
    }
  }
  
  /* Error */
  public c a(Activity paramActivity, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 131	com/go/weatherex/b/a/a:a	Landroid/content/Context;
    //   6: ifnonnull +18 -> 24
    //   9: aload_0
    //   10: getfield 22	com/go/weatherex/b/a/a:b	Z
    //   13: ifne +11 -> 24
    //   16: aload_0
    //   17: aload_1
    //   18: invokevirtual 137	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   21: invokevirtual 140	com/go/weatherex/b/a/a:a	(Landroid/content/Context;)V
    //   24: aload_0
    //   25: getfield 22	com/go/weatherex/b/a/a:b	Z
    //   28: ifne +25 -> 53
    //   31: aload_0
    //   32: getfield 29	com/go/weatherex/b/a/a:d	Ljava/util/HashMap;
    //   35: aload_2
    //   36: invokevirtual 144	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   39: ifne +14 -> 53
    //   42: aload_0
    //   43: aload_1
    //   44: aload_2
    //   45: invokespecial 146	com/go/weatherex/b/a/a:b	(Landroid/app/Activity;Landroid/view/ViewGroup;)Lcom/go/weatherex/b/a/c;
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: areturn
    //   53: aconst_null
    //   54: astore_1
    //   55: goto -6 -> 49
    //   58: astore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	a
    //   0	63	1	paramActivity	Activity
    //   0	63	2	paramViewGroup	ViewGroup
    //   0	63	3	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   2	24	58	finally
    //   24	49	58	finally
  }
  
  public void a()
  {
    if (this.g) {
      this.e.a();
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.d.entrySet().iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)((Map.Entry)localIterator.next()).getValue();
        if (localc != null) {
          localc.a();
        }
      }
    }
  }
  
  public void a(Context paramContext)
  {
    boolean bool = true;
    this.a = paramContext;
    this.b = false;
    String str1 = GoWidgetApplication.c(paramContext).a().getString("key_adid_location_1", "");
    String str2 = com.gau.go.launcherex.gowidget.weather.globaltheme.a.b.a.a(str1, 2);
    if (TextUtils.isEmpty(str2)) {}
    for (this.f = paramContext.getString(2131165244);; this.f = str2)
    {
      paramContext = com.gau.go.launcherex.gowidget.weather.globaltheme.a.b.a.a(str1, 5);
      if (!TextUtils.isEmpty(paramContext)) {
        break;
      }
      this.g = false;
      com.gtp.a.a.b.c.a("adid", "初始化广告请求[id]=" + this.f + "|[singleReq]=" + this.g);
      return;
    }
    if (Integer.valueOf(paramContext).intValue() == 1) {}
    for (;;)
    {
      this.g = bool;
      break;
      bool = false;
    }
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    this.c = true;
    c();
    if ((paramBoolean) && (y.h(paramContext)) && (!com.gau.go.launcherex.gowidget.weather.c.c.a(paramContext).e().a(8))) {
      a(paramContext, 0, 11);
    }
    d();
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    if (!this.b)
    {
      if ((!this.g) || (this.e == null)) {
        break label52;
      }
      paramViewGroup = this.e.getParent();
      if ((paramViewGroup != null) && ((paramViewGroup instanceof ViewGroup))) {
        ((ViewGroup)paramViewGroup).removeView(this.e);
      }
    }
    label52:
    while (this.d.isEmpty()) {
      return;
    }
    a((c)this.d.remove(paramViewGroup));
  }
  
  public void b()
  {
    if (this.g) {
      this.e.b();
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.d.entrySet().iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)((Map.Entry)localIterator.next()).getValue();
        if (localc != null) {
          localc.b();
        }
      }
    }
  }
  
  public void c()
  {
    Object localObject1;
    if ((this.g) && (this.e != null))
    {
      localObject1 = this.e.d();
      if (localObject1 != null) {
        ((d)localObject1).b();
      }
    }
    for (;;)
    {
      return;
      if ((this.d != null) && (!this.d.isEmpty()))
      {
        localObject1 = this.d.values().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (c)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            localObject2 = ((c)localObject2).d();
            if (localObject2 != null) {
              ((d)localObject2).b();
            }
          }
        }
      }
    }
  }
  
  public void d()
  {
    if (!this.b)
    {
      com.gtp.a.a.b.c.a("adid", "AdmobViewHolder destroyAllAdViews");
      this.b = true;
      this.a = null;
      if (this.e != null)
      {
        a(this.e);
        this.e = null;
      }
      if ((this.d != null) && (!this.d.isEmpty()))
      {
        Iterator localIterator = this.d.values().iterator();
        while (localIterator.hasNext()) {
          a((c)localIterator.next());
        }
        this.d.clear();
      }
      e();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/b/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */