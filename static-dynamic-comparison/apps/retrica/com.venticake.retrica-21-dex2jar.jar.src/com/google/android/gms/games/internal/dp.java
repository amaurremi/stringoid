package com.google.android.gms.games.internal;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.view.Display;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import com.google.android.gms.internal.ip;
import java.lang.ref.WeakReference;

final class dp
  extends PopupManager
  implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener
{
  private WeakReference<View> a;
  private boolean b = false;
  
  protected dp(GamesClientImpl paramGamesClientImpl, int paramInt)
  {
    super(paramGamesClientImpl, paramInt, null);
  }
  
  private void a(View paramView)
  {
    int j = -1;
    int i = j;
    if (ip.gh())
    {
      localObject = paramView.getDisplay();
      i = j;
      if (localObject != null) {
        i = ((Display)localObject).getDisplayId();
      }
    }
    Object localObject = paramView.getWindowToken();
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    j = paramView.getWidth();
    int k = paramView.getHeight();
    this.OZ.Pb = i;
    this.OZ.Pa = ((IBinder)localObject);
    this.OZ.left = arrayOfInt[0];
    this.OZ.top = arrayOfInt[1];
    this.OZ.right = (arrayOfInt[0] + j);
    this.OZ.bottom = (arrayOfInt[1] + k);
    if (this.b)
    {
      hL();
      this.b = false;
    }
  }
  
  protected void cl(int paramInt)
  {
    this.OZ = new PopupManager.PopupLocationInfo(paramInt, null, null);
  }
  
  public void g(View paramView)
  {
    this.OY.hw();
    Object localObject2;
    Object localObject1;
    if (this.a != null)
    {
      localObject2 = (View)this.a.get();
      Context localContext = this.OY.getContext();
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if ((localContext instanceof Activity)) {
          localObject1 = ((Activity)localContext).getWindow().getDecorView();
        }
      }
      if (localObject1 != null)
      {
        ((View)localObject1).removeOnAttachStateChangeListener(this);
        localObject1 = ((View)localObject1).getViewTreeObserver();
        if (!ip.gg()) {
          break label186;
        }
        ((ViewTreeObserver)localObject1).removeOnGlobalLayoutListener(this);
      }
    }
    for (;;)
    {
      this.a = null;
      localObject2 = this.OY.getContext();
      localObject1 = paramView;
      if (paramView == null)
      {
        localObject1 = paramView;
        if ((localObject2 instanceof Activity))
        {
          localObject1 = ((Activity)localObject2).findViewById(16908290);
          paramView = (View)localObject1;
          if (localObject1 == null) {
            paramView = ((Activity)localObject2).getWindow().getDecorView();
          }
          GamesLog.j("PopupManager", "You have not specified a View to use as content view for popups. Falling back to the Activity content view which may not work properly in future versions of the API. Use setViewForPopups() to set your content view.");
          localObject1 = paramView;
        }
      }
      if (localObject1 == null) {
        break;
      }
      a((View)localObject1);
      this.a = new WeakReference(localObject1);
      ((View)localObject1).addOnAttachStateChangeListener(this);
      ((View)localObject1).getViewTreeObserver().addOnGlobalLayoutListener(this);
      return;
      label186:
      ((ViewTreeObserver)localObject1).removeGlobalOnLayoutListener(this);
    }
    GamesLog.k("PopupManager", "No content view usable to display popups. Popups will not be displayed in response to this client's calls. Use setViewForPopups() to set your content view.");
  }
  
  public void hL()
  {
    if (this.OZ.Pa != null)
    {
      super.hL();
      return;
    }
    if (this.a != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.b = bool;
      return;
    }
  }
  
  public void onGlobalLayout()
  {
    if (this.a == null) {}
    View localView;
    do
    {
      return;
      localView = (View)this.a.get();
    } while (localView == null);
    a(localView);
  }
  
  public void onViewAttachedToWindow(View paramView)
  {
    a(paramView);
  }
  
  public void onViewDetachedFromWindow(View paramView)
  {
    this.OY.hw();
    paramView.removeOnAttachStateChangeListener(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/dp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */