package com.chartboost.sdk;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBOrientation.Difference;
import com.chartboost.sdk.Libraries.g;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.chartboost.sdk.Model.a;
import com.chartboost.sdk.impl.t.a;
import org.json.JSONObject;

public abstract class c
{
  public a a = null;
  public c b = null;
  public a c = null;
  public d d = null;
  protected int e = 0;
  protected JSONObject f;
  protected a g;
  private int h;
  private int i;
  private int j;
  private b k;
  
  public c(a parama)
  {
    this.g = parama;
    this.k = null;
  }
  
  protected abstract b a(Context paramContext);
  
  public void a()
  {
    this.j += 1;
  }
  
  public void a(g paramg)
  {
    if ((paramg != null) && (paramg.d())) {
      this.h += 1;
    }
    this.i += 1;
    if ((this.i != this.e) || (b())) {
      return;
    }
    this.g.a(CBError.CBImpressionError.INTERNAL);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.i = 0;
    this.j = 0;
    this.h = 0;
    this.f = paramJSONObject.optJSONObject("assets");
    if (this.f == null) {
      this.g.a(CBError.CBImpressionError.INTERNAL);
    }
  }
  
  public boolean b()
  {
    if (this.h < this.j) {
      return false;
    }
    if (this.c != null) {
      this.c.a();
    }
    return true;
  }
  
  public CBError.CBImpressionError c()
  {
    CBError.CBImpressionError localCBImpressionError = null;
    Activity localActivity = Chartboost.sharedChartboost().c();
    if (localActivity == null)
    {
      this.k = null;
      localCBImpressionError = CBError.CBImpressionError.NO_HOST_ACTIVITY;
    }
    do
    {
      return localCBImpressionError;
      this.k = a(localActivity);
    } while (this.k.a(localActivity));
    this.k = null;
    return CBError.CBImpressionError.INTERNAL;
  }
  
  public void d()
  {
    f();
    this.c = null;
    this.d = null;
    this.b = null;
    this.a = null;
  }
  
  public b e()
  {
    return this.k;
  }
  
  public void f()
  {
    if (this.k != null) {
      this.k.c();
    }
    this.k = null;
  }
  
  public JSONObject g()
  {
    return this.f;
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
  
  public abstract class b
    extends RelativeLayout
    implements t.a
  {
    protected boolean a = false;
    
    public b(Context paramContext)
    {
      super();
      setFocusableInTouchMode(true);
      requestFocus();
      setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          return true;
        }
      });
    }
    
    private boolean b(int paramInt1, int paramInt2)
    {
      try
      {
        a(paramInt1, paramInt2);
        return true;
      }
      catch (Exception localException)
      {
        CBLogging.b("CBViewProtocol", "Exception raised while layouting Subviews", localException);
      }
      return false;
    }
    
    public void a()
    {
      a((Activity)getContext());
    }
    
    protected abstract void a(int paramInt1, int paramInt2);
    
    public boolean a(Activity paramActivity)
    {
      try
      {
        k = getWidth();
        j = getHeight();
        if (k != 0)
        {
          i = j;
          if (j != 0) {}
        }
        else
        {
          View localView = paramActivity.getWindow().findViewById(16908290);
          localObject = localView;
          if (localView == null) {
            localObject = paramActivity.getWindow().getDecorView();
          }
          k = ((View)localObject).getWidth();
          i = ((View)localObject).getHeight();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject;
          int i = 0;
          int k = 0;
          continue;
          i = j;
          int j = k;
          k = i;
        }
      }
      if (k != 0)
      {
        j = i;
        if (i != 0) {}
      }
      else
      {
        localObject = new DisplayMetrics();
        paramActivity.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
        k = ((DisplayMetrics)localObject).widthPixels;
        j = ((DisplayMetrics)localObject).heightPixels;
      }
      if (CBPreferences.getInstance().getForcedOrientationDifference().isOdd()) {
        return b(j, k);
      }
    }
    
    public View b()
    {
      return this;
    }
    
    public void c() {}
    
    protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      if (this.a) {
        return;
      }
      if (CBPreferences.getInstance().getForcedOrientationDifference().isOdd())
      {
        b(paramInt2, paramInt1);
        return;
      }
      b(paramInt1, paramInt2);
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(a parama, String paramString, JSONObject paramJSONObject);
  }
  
  public static abstract interface d
  {
    public abstract void a(CBError.CBImpressionError paramCBImpressionError);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */