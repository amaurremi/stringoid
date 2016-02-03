package com.mocoplex.adlib;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AdlibManager
{
  private boolean A = false;
  private b B;
  protected int a = 20;
  protected int b = 0;
  protected Hashtable<String, Integer> c = new Hashtable();
  protected ArrayList<String> d = new ArrayList();
  protected long e = 0L;
  protected int f = -1;
  protected String g = "";
  protected String h = "";
  private AdlibVersionCheckingListener i;
  private String j = "-100";
  private String k = "-100";
  private String l = "-100";
  private AdlibAdViewContainer m = null;
  private long n = 0L;
  private long o = 0L;
  private boolean p = false;
  private ArrayList<a> q = new ArrayList();
  private Activity r = null;
  private Handler s = new Handler()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      paramAnonymousMessage = Integer.toString(paramAnonymousMessage.what);
      AdlibManager.a(AdlibManager.this, paramAnonymousMessage);
    }
  };
  private Handler t = new Handler()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      paramAnonymousMessage = Integer.toString(paramAnonymousMessage.what);
      AdlibManager.b(AdlibManager.this, paramAnonymousMessage);
    }
  };
  private ArrayList<SubAdlibAdViewCore> u = new ArrayList();
  private Hashtable<String, SubAdlibAdViewCore> v = new Hashtable();
  private int w = 0;
  private long x = 0L;
  private long y = 0L;
  private long z = 0L;
  
  private SubAdlibAdViewCore a(String paramString)
  {
    int i2 = this.u.size();
    int i1 = 0;
    for (;;)
    {
      if (i1 >= i2) {}
      do
      {
        try
        {
          paramString = (SubAdlibAdViewCore)Class.forName(paramString).getConstructor(new Class[] { Context.class }).newInstance(new Object[] { this.r });
        }
        catch (ClassNotFoundException localClassNotFoundException1)
        {
          Object localObject;
          SubAdlibAdViewCore localSubAdlibAdViewCore;
          paramString = null;
          localClassNotFoundException1.printStackTrace();
          return paramString;
        }
        catch (NoSuchMethodException localNoSuchMethodException1)
        {
          paramString = null;
          localNoSuchMethodException1.printStackTrace();
          return paramString;
        }
        catch (IllegalArgumentException localIllegalArgumentException1)
        {
          paramString = null;
          localIllegalArgumentException1.printStackTrace();
          return paramString;
        }
        catch (InstantiationException localInstantiationException1)
        {
          paramString = null;
          localInstantiationException1.printStackTrace();
          return paramString;
        }
        catch (IllegalAccessException localIllegalAccessException1)
        {
          paramString = null;
          localIllegalAccessException1.printStackTrace();
          return paramString;
        }
        catch (InvocationTargetException localInvocationTargetException1)
        {
          paramString = null;
          localInvocationTargetException1.printStackTrace();
          return paramString;
        }
        try
        {
          this.u.add(paramString);
          localObject = paramString;
          return (SubAdlibAdViewCore)localObject;
        }
        catch (InvocationTargetException localInvocationTargetException2)
        {
          break label162;
        }
        catch (IllegalAccessException localIllegalAccessException2)
        {
          break label151;
        }
        catch (InstantiationException localInstantiationException2)
        {
          break label140;
        }
        catch (IllegalArgumentException localIllegalArgumentException2)
        {
          break label129;
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
          break label118;
        }
        catch (ClassNotFoundException localClassNotFoundException2)
        {
          break;
        }
        localSubAdlibAdViewCore = (SubAdlibAdViewCore)this.u.get(i1);
        localObject = localSubAdlibAdViewCore;
      } while (localSubAdlibAdViewCore.getClass().getName().equals(paramString));
      i1 += 1;
    }
  }
  
  private boolean a(JSONArray paramJSONArray)
  {
    for (;;)
    {
      int i1;
      int i2;
      try
      {
        if (this.r == null) {
          return false;
        }
        if (paramJSONArray != null) {
          i1 = 0;
        }
      }
      finally {}
      try
      {
        i2 = paramJSONArray.length();
        if (i1 < i2) {
          break label38;
        }
      }
      catch (JSONException paramJSONArray)
      {
        label38:
        Object localObject;
        continue;
      }
      return false;
      if (paramJSONArray.getJSONObject(i1).get("name").toString().equals(this.g))
      {
        localObject = paramJSONArray.getJSONObject(i1).getJSONArray("setting");
        this.q.clear();
        i2 = 0;
        if (i2 >= ((JSONArray)localObject).length())
        {
          paramJSONArray = paramJSONArray.getJSONObject(i1).getJSONArray("maxi");
          if (paramJSONArray != null)
          {
            this.c.clear();
            i1 = 0;
          }
        }
        for (;;)
        {
          i2 = paramJSONArray.length();
          if (i1 >= i2)
          {
            return true;
            JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i2);
            a locala = new a((byte)0);
            locala.a = localJSONObject.get("aid").toString();
            locala.b = ((int)Double.parseDouble(localJSONObject.get("sec").toString()));
            this.q.add(locala);
            i2 += 1;
            break;
          }
          localObject = paramJSONArray.getJSONObject(i1);
          i2 = (int)Double.parseDouble(((JSONObject)localObject).get("aid").toString());
          int i3 = (int)Double.parseDouble(((JSONObject)localObject).get("w").toString());
          this.c.put(Integer.toString(i2), Integer.valueOf(i3));
          i1 += 1;
        }
      }
      i1 += 1;
    }
  }
  
  private SubAdlibAdViewCore b(String paramString)
  {
    if (this.v.containsKey(paramString)) {
      return (SubAdlibAdViewCore)this.v.get(paramString);
    }
    for (;;)
    {
      try
      {
        if (!paramString.equals("7")) {
          continue;
        }
        localObject = new SubAdlibAdViewRewardBanner(this.r, this);
        try
        {
          this.v.put(paramString, localObject);
          this.u.add(localObject);
          return (SubAdlibAdViewCore)localObject;
        }
        catch (Exception paramString) {}
      }
      catch (Exception paramString)
      {
        Object localObject = null;
        continue;
      }
      paramString.printStackTrace();
      return (SubAdlibAdViewCore)localObject;
      if (paramString.equals("77")) {
        localObject = new SubAdlibAdViewCrossBanner(this.r);
      } else if (paramString.equals("-1")) {
        localObject = new SubAdlibAdViewMain(this.r);
      } else {
        localObject = null;
      }
    }
  }
  
  private String c(String paramString)
  {
    try
    {
      if (this.r == null) {
        return null;
      }
      paramString = this.r.getSharedPreferences("adlibr", 0).getString(paramString, "");
      return paramString;
    }
    finally {}
  }
  
  private void d()
  {
    this.x = 0L;
    if (this.B != null)
    {
      this.B.interrupt();
      this.B = null;
    }
  }
  
  private void d(String paramString)
  {
    f.a(this.r).a(Integer.parseInt(paramString));
    f.a(this.r).b(this.h);
  }
  
  private void e()
  {
    if ((this.m != null) && (this.B == null))
    {
      this.w = 0;
      this.x = 0L;
      this.B = new b();
      this.B.start();
    }
  }
  
  private boolean e(String paramString)
  {
    int i1 = -1;
    String str = paramString.substring(0, 1);
    if (str.equals("x")) {}
    do
    {
      do
      {
        return true;
        if (str.equals("<")) {}
        try
        {
          i2 = Integer.parseInt(paramString.substring(2));
          i1 = i2;
        }
        catch (Exception paramString)
        {
          int i2;
          boolean bool;
          for (;;) {}
        }
        if (this.f <= i1) {}
        for (bool = true;; bool = false) {
          return bool;
        }
        if (!str.equals(">")) {
          break;
        }
        try
        {
          i2 = Integer.parseInt(paramString.substring(2));
          i1 = i2;
        }
        catch (Exception paramString)
        {
          for (;;) {}
        }
      } while (this.f >= i1);
      return false;
      if (!str.equals("=")) {
        break label141;
      }
      try
      {
        i2 = Integer.parseInt(paramString.substring(1));
        i1 = i2;
      }
      catch (Exception paramString)
      {
        for (;;) {}
      }
    } while (this.f == i1);
    return false;
    label141:
    return false;
  }
  
  public final void a()
  {
    this.x = (new Date().getTime() + this.y);
  }
  
  public final void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public final void a(Context paramContext, String paramString)
  {
    paramString = c.a().a(paramString);
    int i1;
    if (paramString != null) {
      i1 = 0;
    }
    for (;;)
    {
      if (i1 >= paramString.size()) {
        return;
      }
      Object localObject1 = (b)paramString.get(i1);
      Object localObject2 = ((b)localObject1).a;
      if ((e(((b)localObject1).d)) && (c.c(paramContext, (String)localObject2) < ((b)localObject1).b) && (new Random().nextInt(100) + 1 <= ((b)localObject1).c))
      {
        Object localObject3 = ((b)localObject1).a;
        localObject1 = this.r;
        if (localObject1 != null)
        {
          c.a();
          c.a((Context)localObject1, (String)localObject3);
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("did", (String)localObject3);
          localObject3 = new Intent((Context)localObject1, AdlibDialogActivity.class);
          ((Intent)localObject3).putExtras((Bundle)localObject2);
          ((Context)localObject1).startActivity((Intent)localObject3);
        }
      }
      i1 += 1;
    }
  }
  
  public final void b()
  {
    this.x = 0L;
  }
  
  public void bindAdsContainer(AdlibAdViewContainer paramAdlibAdViewContainer)
  {
    if (paramAdlibAdViewContainer == null) {
      return;
    }
    this.m = paramAdlibAdViewContainer;
    this.m.a = this.h;
    e();
  }
  
  public final void c()
  {
    this.x = 0L;
    this.z = 0L;
  }
  
  public void destroyAdsContainer()
  {
    Object localObject;
    if (this.m != null)
    {
      d();
      localObject = (ViewGroup)this.m.getParent();
      if (localObject != null) {
        ((ViewGroup)localObject).removeView(this.m);
      }
      this.m.a();
      this.m = null;
    }
    int i2 = this.u.size();
    int i1 = 0;
    for (;;)
    {
      if (i1 >= i2)
      {
        this.u.clear();
        this.v.clear();
        this.j = "-100";
        this.k = "-100";
        this.l = "-100";
        this.w = 0;
        this.x = 0L;
        this.y = 0L;
        this.z = 0L;
        return;
      }
      localObject = (SubAdlibAdViewCore)this.u.get(i1);
      if (((SubAdlibAdViewCore)localObject).b)
      {
        ViewGroup localViewGroup = (ViewGroup)((SubAdlibAdViewCore)localObject).getParent();
        if (localViewGroup != null) {
          localViewGroup.removeView((View)localObject);
        }
        ((SubAdlibAdViewCore)localObject).b = false;
      }
      ((SubAdlibAdViewCore)localObject).onDestroy();
      i1 += 1;
    }
  }
  
  public String getCurrentVersion()
  {
    String str = c("sch");
    if (str == null) {
      return "";
    }
    try
    {
      str = new JSONObject(str).getString("version");
      return str;
    }
    catch (JSONException localJSONException) {}
    return "";
  }
  
  public void onCreate(final Activity paramActivity)
  {
    for (;;)
    {
      try
      {
        this.r = paramActivity;
        this.g = ((ActivityManager.RunningTaskInfo)((ActivityManager)this.r.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName();
        int i1 = this.g.lastIndexOf(".");
        if (i1 > 0) {
          this.h = this.g.substring(i1 + 1);
        }
        Object localObject = f.a(paramActivity);
        if (((f)localObject).e())
        {
          ((f)localObject).d();
          localObject = paramActivity.getPackageManager();
          try
          {
            this.f = ((PackageManager)localObject).getPackageInfo(paramActivity.getPackageName(), 128).versionCode;
            c.a().a(new Handler()
            {
              public final void handleMessage(Message paramAnonymousMessage)
              {
                switch (paramAnonymousMessage.what)
                {
                default: 
                  return;
                }
                AdlibManager.this.a(paramActivity, AdlibManager.this.g);
                AdlibManager.this.a(paramActivity, "@start");
              }
            });
            AdlibConfig.getInstance().a(paramActivity);
            if (this.m != null) {
              this.m.onCreate();
            }
            return;
          }
          catch (Exception localException)
          {
            this.f = -1;
            continue;
          }
        }
        new Handler().postDelayed(new Runnable()
        {
          public final void run()
          {
            AdlibManager.this.a(paramActivity, AdlibManager.this.g);
          }
        }, 200L);
      }
      finally {}
    }
  }
  
  public void onDestroy(Activity paramActivity)
  {
    try
    {
      f.a(paramActivity).a(paramActivity);
      destroyAdsContainer();
      AdlibConfig.getInstance().b(paramActivity);
      this.r = null;
      if (this.m != null) {
        this.m.onDestroy();
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public void onPause()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 121	com/mocoplex/adlib/AdlibManager:u	Ljava/util/ArrayList;
    //   6: invokevirtual 158	java/util/ArrayList:size	()I
    //   9: istore_2
    //   10: iconst_0
    //   11: istore_1
    //   12: iload_1
    //   13: iload_2
    //   14: if_icmplt +74 -> 88
    //   17: aload_0
    //   18: getfield 111	com/mocoplex/adlib/AdlibManager:r	Landroid/app/Activity;
    //   21: ifnull +41 -> 62
    //   24: aload_0
    //   25: getfield 111	com/mocoplex/adlib/AdlibManager:r	Landroid/app/Activity;
    //   28: invokestatic 338	com/mocoplex/adlib/f:a	(Landroid/content/Context;)Lcom/mocoplex/adlib/f;
    //   31: invokevirtual 634	com/mocoplex/adlib/f:c	()Landroid/content/Context;
    //   34: aload_0
    //   35: getfield 111	com/mocoplex/adlib/AdlibManager:r	Landroid/app/Activity;
    //   38: if_acmpne +24 -> 62
    //   41: aload_0
    //   42: getfield 111	com/mocoplex/adlib/AdlibManager:r	Landroid/app/Activity;
    //   45: invokevirtual 637	android/app/Activity:isFinishing	()Z
    //   48: ifeq +14 -> 62
    //   51: aload_0
    //   52: aload_0
    //   53: getfield 111	com/mocoplex/adlib/AdlibManager:r	Landroid/app/Activity;
    //   56: ldc_w 639
    //   59: invokevirtual 640	com/mocoplex/adlib/AdlibManager:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   62: aload_0
    //   63: aconst_null
    //   64: putfield 111	com/mocoplex/adlib/AdlibManager:r	Landroid/app/Activity;
    //   67: aload_0
    //   68: invokespecial 536	com/mocoplex/adlib/AdlibManager:d	()V
    //   71: aload_0
    //   72: getfield 83	com/mocoplex/adlib/AdlibManager:m	Lcom/mocoplex/adlib/AdlibAdViewContainer;
    //   75: ifnull +10 -> 85
    //   78: aload_0
    //   79: getfield 83	com/mocoplex/adlib/AdlibManager:m	Lcom/mocoplex/adlib/AdlibAdViewContainer;
    //   82: invokevirtual 642	com/mocoplex/adlib/AdlibAdViewContainer:onPause	()V
    //   85: aload_0
    //   86: monitorexit
    //   87: return
    //   88: aload_0
    //   89: getfield 121	com/mocoplex/adlib/AdlibManager:u	Ljava/util/ArrayList;
    //   92: iload_1
    //   93: invokevirtual 186	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   96: checkcast 178	com/mocoplex/adlib/SubAdlibAdViewCore
    //   99: invokevirtual 643	com/mocoplex/adlib/SubAdlibAdViewCore:onPause	()V
    //   102: iload_1
    //   103: iconst_1
    //   104: iadd
    //   105: istore_1
    //   106: goto -94 -> 12
    //   109: astore_3
    //   110: aload_0
    //   111: monitorexit
    //   112: aload_3
    //   113: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	this	AdlibManager
    //   11	95	1	i1	int
    //   9	6	2	i2	int
    //   109	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	109	finally
    //   17	62	109	finally
    //   62	85	109	finally
    //   85	87	109	finally
    //   88	102	109	finally
  }
  
  /* Error */
  public void onResume(Activity paramActivity)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 121	com/mocoplex/adlib/AdlibManager:u	Ljava/util/ArrayList;
    //   6: invokevirtual 158	java/util/ArrayList:size	()I
    //   9: istore_3
    //   10: iconst_0
    //   11: istore_2
    //   12: iload_2
    //   13: iload_3
    //   14: if_icmplt +36 -> 50
    //   17: aload_0
    //   18: aload_1
    //   19: putfield 111	com/mocoplex/adlib/AdlibManager:r	Landroid/app/Activity;
    //   22: invokestatic 218	com/mocoplex/adlib/AdlibConfig:getInstance	()Lcom/mocoplex/adlib/AdlibConfig;
    //   25: aload_1
    //   26: invokevirtual 614	com/mocoplex/adlib/AdlibConfig:a	(Landroid/app/Activity;)V
    //   29: aload_0
    //   30: invokespecial 533	com/mocoplex/adlib/AdlibManager:e	()V
    //   33: aload_0
    //   34: getfield 83	com/mocoplex/adlib/AdlibManager:m	Lcom/mocoplex/adlib/AdlibAdViewContainer;
    //   37: ifnull +10 -> 47
    //   40: aload_0
    //   41: getfield 83	com/mocoplex/adlib/AdlibManager:m	Lcom/mocoplex/adlib/AdlibAdViewContainer;
    //   44: invokevirtual 646	com/mocoplex/adlib/AdlibAdViewContainer:onResume	()V
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: aload_0
    //   51: getfield 121	com/mocoplex/adlib/AdlibManager:u	Ljava/util/ArrayList;
    //   54: iload_2
    //   55: invokevirtual 186	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   58: checkcast 178	com/mocoplex/adlib/SubAdlibAdViewCore
    //   61: invokevirtual 647	com/mocoplex/adlib/SubAdlibAdViewCore:onResume	()V
    //   64: iload_2
    //   65: iconst_1
    //   66: iadd
    //   67: istore_2
    //   68: goto -56 -> 12
    //   71: astore_1
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	AdlibManager
    //   0	76	1	paramActivity	Activity
    //   11	57	2	i1	int
    //   9	6	3	i2	int
    // Exception table:
    //   from	to	target	type
    //   2	10	71	finally
    //   17	47	71	finally
    //   47	49	71	finally
    //   50	64	71	finally
  }
  
  public void setAdsContainer(int paramInt)
  {
    try
    {
      if (this.r == null) {
        return;
      }
      this.m = ((AdlibAdViewContainer)this.r.findViewById(paramInt));
      this.m.a = this.h;
      e();
      return;
    }
    finally {}
  }
  
  public void setVersionCheckingListner(AdlibVersionCheckingListener paramAdlibVersionCheckingListener)
  {
    this.i = paramAdlibVersionCheckingListener;
  }
  
  public static abstract interface AdlibVersionCheckingListener
  {
    public abstract void gotCurrentVersion(String paramString);
  }
  
  final class a
  {
    public String a = "";
    public int b = 0;
    
    private a() {}
  }
  
  final class b
    extends Thread
  {
    b() {}
    
    public final void run()
    {
      try
      {
        AdlibManager.c(AdlibManager.this, "-100");
        f.a(AdlibManager.a(AdlibManager.this)).a(AdlibManager.this.h);
        Thread.sleep(500L);
        for (;;)
        {
          boolean bool = isInterrupted();
          if (bool) {
            return;
          }
          try
          {
            AdlibManager.b(AdlibManager.this);
            if (AdlibManager.c(AdlibManager.this) != null)
            {
              AdlibManager.d(AdlibManager.this);
              AdlibManager.e(AdlibManager.this);
            }
            Thread.sleep(2000L);
          }
          catch (InterruptedException localInterruptedException1)
          {
            interrupt();
            return;
          }
        }
        return;
      }
      catch (InterruptedException localInterruptedException2)
      {
        interrupt();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mocoplex/adlib/AdlibManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */