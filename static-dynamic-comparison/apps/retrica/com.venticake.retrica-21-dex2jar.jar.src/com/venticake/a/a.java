package com.venticake.a;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.location.Location;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  private static a a = null;
  private String b = null;
  private String c = null;
  private String d = null;
  private String e = null;
  private final int f = 13;
  private String g = null;
  private String h = null;
  private String i = null;
  private int j = 0;
  private int k = 0;
  private String l = null;
  private c m = null;
  private b n = null;
  private ArrayList<com.venticake.a.a.a> o = null;
  private int p = 0;
  private com.venticake.a.a.a q = null;
  
  protected a()
  {
    d();
  }
  
  public static a a()
  {
    try
    {
      if (a == null) {
        a = new a();
      }
      a locala = a;
      return locala;
    }
    finally {}
  }
  
  private String a(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      if (paramContext == null) {
        return null;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = null;
      }
    }
    return paramContext.versionName;
  }
  
  private ArrayList<com.venticake.a.a.a> a(JSONArray paramJSONArray1, JSONArray paramJSONArray2)
  {
    if ((paramJSONArray1 == null) || (paramJSONArray1.length() < 1)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    for (;;)
    {
      if (i1 >= paramJSONArray1.length()) {
        return localArrayList;
      }
      try
      {
        com.venticake.a.a.a locala = com.venticake.a.a.a.a(paramJSONArray1.getInt(i1), paramJSONArray2);
        if (locala != null)
        {
          localArrayList.add(locala);
          Log.d("spad", "new ad added: " + locala);
          Log.d("spad", "      - rule: " + locala.a());
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      i1 += 1;
    }
  }
  
  private boolean a(String paramString)
  {
    ArrayList localArrayList = null;
    Object localObject1;
    try
    {
      localObject1 = new JSONObject(paramString);
      if (localObject1 == null)
      {
        Log.d("spad", "parse ERROR");
        return false;
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        localObject1 = null;
      }
      try
      {
        paramString = ((JSONObject)localObject1).getString("app");
        if ((paramString == null) || (!paramString.equals(this.g)))
        {
          Log.d("spad", "appId is not matched: " + paramString + ", (" + this.g + ")");
          return false;
        }
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          paramString = null;
        }
      }
    }
    for (;;)
    {
      try
      {
        paramString = ((JSONObject)localObject1).getJSONArray("aq");
        localJSONException1.printStackTrace();
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          localObject1 = ((JSONObject)localObject1).getJSONArray("ar");
          if (paramString != null) {
            localArrayList = a(paramString, (JSONArray)localObject1);
          }
          if (localArrayList == null) {
            break label156;
          }
          this.o = localArrayList;
          return true;
        }
        catch (JSONException localJSONException2)
        {
          Object localObject2;
          for (;;) {}
        }
        localJSONException1 = localJSONException1;
        paramString = null;
      }
      localObject2 = null;
      continue;
      label156:
      Log.d("spad", "ERROR - NO ad queue");
    }
  }
  
  private int b(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      if (paramContext == null) {
        return 0;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = null;
      }
    }
    return paramContext.versionCode;
  }
  
  private void d()
  {
    e();
    f();
    g();
    h();
    i();
  }
  
  private void e()
  {
    this.b = com.venticake.retrica.util.a.a(new byte[] { 62, 95, -97, -114, -50, 14, -113, -37, Byte.MAX_VALUE, -41, -122, -17, -51, -79, -83, -69, -52, 116, -54, -42, 78, -118, 68, -15, -84, -15, 88, -127, -105, -85, 61, 42 });
  }
  
  private void f()
  {
    this.c = com.venticake.retrica.util.a.a(new byte[] { 56, 31, -105, 79, 68, 23, -24, -125, -49, -61, -14, 75, 124, 40, 51, 86, -48, 117, -107, 14, -10, 104, -51, 5, 106, -125, 95, -97, 61, -36, -22, -99 });
  }
  
  private void g()
  {
    this.d = com.venticake.retrica.util.a.a(new byte[] { -18, -6, 120, 100, 15, 63, -57, -15, -123, 40, 123, -56, -45, -35, -125, 6, -72, 31, 79, -4, 32, -23, -75, -50, 70, 14, -23, -105, 76, 89, -20, 97, 23, -67, 123, -112, -84, 121, -127, 88, 115, -65, 50, 34, 92, -92, -32, 11, -103, -116, 26, -79, 38, 2, -103, 48, 28, -58, -54, -81, -6, 119, 94, 21, 34, 115, -127, 98, 88, 36, 7, -29, 83, -91, -122, -83, -94, 60, 9, 65 });
  }
  
  private void h()
  {
    this.e = com.venticake.retrica.util.a.a(new byte[] { 1, 27, -18, 50, 20, 3, -121, -8, 127, 5, -64, -1, -28, 31, 52, 115, -77, -52, -21, -12, -2, -109, -44, -18, -116, 90, -105, -7, -60, 120, -40, -87, -107, 120, 77, 77, 66, 85, -74, -53, 19, -105, -5, -48, -36, -73, 108, -57, -93, 7, 58, -9, 29, -55, 19, 57, 45, 70, -71, -19, 28, 114, -7, -41, -51, -66, 82, 79, -96, 45, 81, 62, -11, 104, -109, 60, -61, -43, -74, 25, -100, -112, -37, 91, -87, 58, 100, -60, -119, 126, -45, -67, 70, -50, -83, 59 });
  }
  
  private void i()
  {
    this.g = com.venticake.retrica.util.a.a(new byte[] { 28, 125, 9, -33, 72, -18, 85, 67, -3, Byte.MIN_VALUE, -28, 17, 33, -8, 53, -30 });
  }
  
  private String j()
  {
    String str2 = this.d;
    String str3 = this.b;
    String str4 = this.g;
    if (this.h != null) {}
    for (String str1 = this.h;; str1 = "en_US") {
      return String.format(str2, new Object[] { str3, Integer.valueOf(13), str4, str1, this.i, c(), Integer.valueOf(this.k), Integer.valueOf(this.j) });
    }
  }
  
  public void a(Activity paramActivity)
  {
    Object localObject = new StringBuilder("configureAds: ");
    int i1;
    if (this.o == null)
    {
      i1 = 0;
      Log.d("spad", i1 + " ads");
      if ((this.o != null) && (this.o.size() >= 1)) {
        break label70;
      }
    }
    for (;;)
    {
      return;
      i1 = this.o.size();
      break;
      label70:
      localObject = this.o.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.venticake.a.a.a)((Iterator)localObject).next()).a(paramActivity, this);
      }
    }
  }
  
  public void a(Context paramContext, c paramc)
  {
    Log.d("spad", "START updateAsync");
    this.i = a(paramContext);
    this.h = Locale.getDefault().toString();
    this.k = Build.VERSION.SDK_INT;
    this.j = b(paramContext);
    this.m = paramc;
    paramContext = j();
    Log.d("spad", "request URI: " + paramContext);
    try
    {
      new d(this, null).execute(new String[] { paramContext });
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public void a(b paramb)
  {
    this.n = paramb;
  }
  
  public boolean a(int paramInt)
  {
    if ((this.o == null) || (this.o.size() < 1)) {}
    for (;;)
    {
      return false;
      int i1 = 0;
      while (i1 < this.o.size())
      {
        if (((com.venticake.a.a.a)this.o.get(i1)).d() == paramInt) {
          return true;
        }
        i1 += 1;
      }
    }
  }
  
  public boolean a(Activity paramActivity, ViewGroup paramViewGroup)
  {
    return a(paramActivity, paramViewGroup, 1);
  }
  
  public boolean a(Activity paramActivity, ViewGroup paramViewGroup, int paramInt)
  {
    Log.d("spad", "displayAD: " + paramActivity);
    Log.d("spad", "displayType: " + paramInt);
    StringBuilder localStringBuilder = new StringBuilder("nextQueueIndex: ").append(this.p).append(" adQueue count: ");
    if (this.o == null) {}
    for (Object localObject = "0";; localObject = Integer.valueOf(this.o.size()))
    {
      Log.d("spad", localObject);
      e.h();
      this.q = null;
      if ((this.o != null) && (this.o.size() >= 1)) {
        break;
      }
      return false;
    }
    if ((this.p < 0) || (this.p > this.o.size() - 1))
    {
      this.p = 0;
      Log.d("spad", "nextQueueIndex: " + this.p);
    }
    int i3 = this.o.size();
    int i1 = 0;
    if (i1 >= i3)
    {
      Log.d("spad", "No ad to display");
      return false;
    }
    int i2 = this.p + i1;
    if (i2 > i3 - 1) {
      i2 -= i3;
    }
    for (;;)
    {
      try
      {
        localObject = (com.venticake.a.a.a)this.o.get(i2);
        Log.d("spad", "realIndex: " + i2 + ", ad: " + localObject.toString());
        if (((com.venticake.a.a.a)localObject).a(paramInt)) {
          continue;
        }
        Log.d("spad", "InvalidDisplayType: " + localObject);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
        if (localException.b()) {
          continue;
        }
        Log.d("spad", "Invalid ad: " + localException);
        continue;
        if (!localException.a(paramActivity, paramViewGroup)) {
          continue;
        }
        this.p = (i2 + 1);
        com.venticake.a.a.a.c();
        this.q = localException;
        return true;
        Log.d("spad", "display false : " + this.p);
        continue;
      }
      i1 += 1;
      break;
    }
  }
  
  public Location b()
  {
    if (this.n == null) {
      return null;
    }
    return this.n.a();
  }
  
  public void b(int paramInt)
  {
    this.l = String.valueOf(paramInt);
  }
  
  public void b(Activity paramActivity)
  {
    if (this.q == null) {
      return;
    }
    Log.d("spad", "releaseCurrentAD: " + this.q);
    this.q.b(paramActivity, this);
    this.q = null;
  }
  
  public void b(Activity paramActivity, ViewGroup paramViewGroup)
  {
    if (this.q == null) {
      return;
    }
    Log.d("spad", "reloadCurrentAD: " + this.q);
    this.q.b(paramActivity, paramViewGroup);
  }
  
  public String c()
  {
    if (this.l == null) {
      return "0";
    }
    return this.l;
  }
  
  public void c(Activity paramActivity)
  {
    if ((this.o == null) || (this.o.size() < 1)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.o.iterator();
      while (localIterator.hasNext()) {
        ((com.venticake.a.a.a)localIterator.next()).a(paramActivity);
      }
    }
  }
  
  public void d(Activity paramActivity)
  {
    if ((this.o == null) || (this.o.size() < 1)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.o.iterator();
      while (localIterator.hasNext()) {
        ((com.venticake.a.a.a)localIterator.next()).b(paramActivity);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */