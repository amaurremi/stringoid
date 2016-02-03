package com.google.android.gms.games.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Display;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import com.google.android.gms.internal.gr;
import java.lang.ref.WeakReference;

public class PopupManager
{
  protected GamesClientImpl JK;
  protected PopupLocationInfo JL;
  
  private PopupManager(GamesClientImpl paramGamesClientImpl, int paramInt)
  {
    this.JK = paramGamesClientImpl;
    bc(paramInt);
  }
  
  public static PopupManager a(GamesClientImpl paramGamesClientImpl, int paramInt)
  {
    if (gr.fv()) {
      return new PopupManagerHCMR1(paramGamesClientImpl, paramInt);
    }
    return new PopupManager(paramGamesClientImpl, paramInt);
  }
  
  protected void bc(int paramInt)
  {
    this.JL = new PopupLocationInfo(paramInt, new Binder(), null);
  }
  
  public void g(View paramView) {}
  
  public void gS()
  {
    this.JK.a(this.JL.JM, this.JL.gV());
  }
  
  public Bundle gT()
  {
    return this.JL.gV();
  }
  
  public IBinder gU()
  {
    return this.JL.JM;
  }
  
  public void setGravity(int paramInt)
  {
    this.JL.gravity = paramInt;
  }
  
  public static final class PopupLocationInfo
  {
    public IBinder JM;
    public int JN = -1;
    public int bottom = 0;
    public int gravity;
    public int left = 0;
    public int right = 0;
    public int top = 0;
    
    private PopupLocationInfo(int paramInt, IBinder paramIBinder)
    {
      this.gravity = paramInt;
      this.JM = paramIBinder;
    }
    
    public Bundle gV()
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("popupLocationInfo.gravity", this.gravity);
      localBundle.putInt("popupLocationInfo.displayId", this.JN);
      localBundle.putInt("popupLocationInfo.left", this.left);
      localBundle.putInt("popupLocationInfo.top", this.top);
      localBundle.putInt("popupLocationInfo.right", this.right);
      localBundle.putInt("popupLocationInfo.bottom", this.bottom);
      return localBundle;
    }
  }
  
  private static final class PopupManagerHCMR1
    extends PopupManager
    implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener
  {
    private boolean Iz = false;
    private WeakReference<View> JO;
    
    protected PopupManagerHCMR1(GamesClientImpl paramGamesClientImpl, int paramInt)
    {
      super(paramInt, null);
    }
    
    private void h(View paramView)
    {
      int j = -1;
      int i = j;
      if (gr.fz())
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
      this.JL.JN = i;
      this.JL.JM = ((IBinder)localObject);
      this.JL.left = arrayOfInt[0];
      this.JL.top = arrayOfInt[1];
      this.JL.right = (arrayOfInt[0] + j);
      this.JL.bottom = (arrayOfInt[1] + k);
      if (this.Iz)
      {
        gS();
        this.Iz = false;
      }
    }
    
    protected void bc(int paramInt)
    {
      this.JL = new PopupManager.PopupLocationInfo(paramInt, null, null);
    }
    
    public void g(View paramView)
    {
      this.JK.gF();
      Object localObject2;
      Object localObject1;
      if (this.JO != null)
      {
        localObject2 = (View)this.JO.get();
        Context localContext = this.JK.getContext();
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
          if (!gr.fy()) {
            break label186;
          }
          ((ViewTreeObserver)localObject1).removeOnGlobalLayoutListener(this);
        }
      }
      for (;;)
      {
        this.JO = null;
        localObject2 = this.JK.getContext();
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
            GamesLog.g("PopupManager", "You have not specified a View to use as content view for popups. Falling back to the Activity content view which may not work properly in future versions of the API. Use setViewForPopups() to set your content view.");
            localObject1 = paramView;
          }
        }
        if (localObject1 == null) {
          break;
        }
        h((View)localObject1);
        this.JO = new WeakReference(localObject1);
        ((View)localObject1).addOnAttachStateChangeListener(this);
        ((View)localObject1).getViewTreeObserver().addOnGlobalLayoutListener(this);
        return;
        label186:
        ((ViewTreeObserver)localObject1).removeGlobalOnLayoutListener(this);
      }
      GamesLog.h("PopupManager", "No content view usable to display popups. Popups will not be displayed in response to this client's calls. Use setViewForPopups() to set your content view.");
    }
    
    public void gS()
    {
      if (this.JL.JM != null)
      {
        super.gS();
        return;
      }
      if (this.JO != null) {}
      for (boolean bool = true;; bool = false)
      {
        this.Iz = bool;
        return;
      }
    }
    
    public void onGlobalLayout()
    {
      if (this.JO == null) {}
      View localView;
      do
      {
        return;
        localView = (View)this.JO.get();
      } while (localView == null);
      h(localView);
    }
    
    public void onViewAttachedToWindow(View paramView)
    {
      h(paramView);
    }
    
    public void onViewDetachedFromWindow(View paramView)
    {
      this.JK.gF();
      paramView.removeOnAttachStateChangeListener(this);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/games/internal/PopupManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */