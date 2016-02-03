package com.chartboost.sdk.Libraries;

import android.app.Activity;
import android.content.Context;
import com.chartboost.sdk.Chartboost;
import java.lang.ref.WeakReference;

public final class h
  extends WeakReference<Activity>
{
  private static h b;
  private int a;
  
  private h(Activity paramActivity)
  {
    super(paramActivity);
    this.a = paramActivity.hashCode();
  }
  
  public static h a(Activity paramActivity)
  {
    if ((b == null) || (b.a != paramActivity.hashCode())) {
      b = new h(paramActivity);
    }
    return b;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public boolean a(h paramh)
  {
    if (paramh == null) {}
    while (paramh.a() != this.a) {
      return false;
    }
    return true;
  }
  
  public Context b()
  {
    Context localContext2 = (Context)get();
    Context localContext1 = localContext2;
    if (localContext2 == null) {
      localContext1 = Chartboost.sharedChartboost().getContext();
    }
    return localContext1;
  }
  
  public boolean b(Activity paramActivity)
  {
    if (paramActivity == null) {}
    while (paramActivity.hashCode() != this.a) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    return a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/Libraries/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */