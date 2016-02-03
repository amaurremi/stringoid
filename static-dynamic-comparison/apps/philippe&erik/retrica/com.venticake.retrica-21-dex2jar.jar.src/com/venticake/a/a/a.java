package com.venticake.a.a;

import android.app.Activity;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.ViewGroup;
import com.venticake.a.e;
import java.util.Date;
import org.json.JSONArray;

public abstract class a
{
  private e a;
  
  public a(int paramInt, JSONArray paramJSONArray)
  {
    a(new e(paramInt, paramJSONArray));
  }
  
  public static a a(int paramInt, JSONArray paramJSONArray)
  {
    switch (paramInt)
    {
    default: 
      Log.d("spad", "No matched ad for type: " + paramInt);
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return null;
          } while (Build.VERSION.SDK_INT < 10);
          return new c(paramJSONArray);
        } while (Build.VERSION.SDK_INT < 10);
        return new c(paramJSONArray, 1);
      } while (Build.VERSION.SDK_INT < 10);
      return new b(paramJSONArray);
    } while (Build.VERSION.SDK_INT < 10);
    return new d(paramJSONArray);
  }
  
  public static void c()
  {
    Date localDate1 = new Date();
    Date localDate2 = e.b();
    if ((localDate2 != null) && (e.a(localDate2, localDate1)))
    {
      e.d();
      Log.d("spad", "setAdDisplayed - countUpForADay");
    }
    for (;;)
    {
      e.a(localDate1);
      return;
      e.a(1);
      Log.d("spad", "setAdDisplayed - setCountForADay(1)");
    }
  }
  
  public e a()
  {
    return this.a;
  }
  
  public abstract void a(Activity paramActivity);
  
  public abstract void a(Activity paramActivity, com.venticake.a.a parama);
  
  public void a(e parame)
  {
    this.a = parame;
  }
  
  public abstract boolean a(int paramInt);
  
  public abstract boolean a(Activity paramActivity, ViewGroup paramViewGroup);
  
  public abstract void b(Activity paramActivity);
  
  public abstract void b(Activity paramActivity, com.venticake.a.a parama);
  
  public boolean b()
  {
    if (this.a == null) {
      return true;
    }
    return this.a.a();
  }
  
  public abstract boolean b(Activity paramActivity, ViewGroup paramViewGroup);
  
  public abstract int d();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */