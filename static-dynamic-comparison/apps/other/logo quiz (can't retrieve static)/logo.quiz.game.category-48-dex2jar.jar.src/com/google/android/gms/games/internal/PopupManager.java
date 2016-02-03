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
import com.google.android.gms.internal.kc;
import java.lang.ref.WeakReference;

public class PopupManager
{
  protected GamesClientImpl XO;
  protected PopupLocationInfo XP;
  
  private PopupManager(GamesClientImpl paramGamesClientImpl, int paramInt)
  {
    this.XO = paramGamesClientImpl;
    dG(paramInt);
  }
  
  public static PopupManager a(GamesClientImpl paramGamesClientImpl, int paramInt)
  {
    if (kc.hC()) {
      return new PopupManagerHCMR1(paramGamesClientImpl, paramInt);
    }
    return new PopupManager(paramGamesClientImpl, paramInt);
  }
  
  protected void dG(int paramInt)
  {
    this.XP = new PopupLocationInfo(paramInt, new Binder(), null);
  }
  
  public void kJ()
  {
    this.XO.a(this.XP.XQ, this.XP.kM());
  }
  
  public Bundle kK()
  {
    return this.XP.kM();
  }
  
  public IBinder kL()
  {
    return this.XP.XQ;
  }
  
  public void l(View paramView) {}
  
  public void setGravity(int paramInt)
  {
    this.XP.gravity = paramInt;
  }
  
  public static final class PopupLocationInfo
  {
    public IBinder XQ;
    public int XR = -1;
    public int bottom = 0;
    public int gravity;
    public int left = 0;
    public int right = 0;
    public int top = 0;
    
    private PopupLocationInfo(int paramInt, IBinder paramIBinder)
    {
      this.gravity = paramInt;
      this.XQ = paramIBinder;
    }
    
    public Bundle kM()
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("popupLocationInfo.gravity", this.gravity);
      localBundle.putInt("popupLocationInfo.displayId", this.XR);
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
    private boolean Wn = false;
    private WeakReference<View> XS;
    
    protected PopupManagerHCMR1(GamesClientImpl paramGamesClientImpl, int paramInt)
    {
      super(paramInt, null);
    }
    
    private void m(View paramView)
    {
      int j = -1;
      int i = j;
      if (kc.hG())
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
      this.XP.XR = i;
      this.XP.XQ = ((IBinder)localObject);
      this.XP.left = arrayOfInt[0];
      this.XP.top = arrayOfInt[1];
      this.XP.right = (arrayOfInt[0] + j);
      this.XP.bottom = (arrayOfInt[1] + k);
      if (this.Wn)
      {
        kJ();
        this.Wn = false;
      }
    }
    
    protected void dG(int paramInt)
    {
      this.XP = new PopupManager.PopupLocationInfo(paramInt, null, null);
    }
    
    public void kJ()
    {
      if (this.XP.XQ != null)
      {
        super.kJ();
        return;
      }
      if (this.XS != null) {}
      for (boolean bool = true;; bool = false)
      {
        this.Wn = bool;
        return;
      }
    }
    
    public void l(View paramView)
    {
      this.XO.ku();
      Object localObject2;
      Object localObject1;
      if (this.XS != null)
      {
        localObject2 = (View)this.XS.get();
        Context localContext = this.XO.getContext();
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
          if (!kc.hF()) {
            break label186;
          }
          ((ViewTreeObserver)localObject1).removeOnGlobalLayoutListener(this);
        }
      }
      for (;;)
      {
        this.XS = null;
        localObject2 = this.XO.getContext();
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
            GamesLog.p("PopupManager", "You have not specified a View to use as content view for popups. Falling back to the Activity content view which may not work properly in future versions of the API. Use setViewForPopups() to set your content view.");
            localObject1 = paramView;
          }
        }
        if (localObject1 == null) {
          break;
        }
        m((View)localObject1);
        this.XS = new WeakReference(localObject1);
        ((View)localObject1).addOnAttachStateChangeListener(this);
        ((View)localObject1).getViewTreeObserver().addOnGlobalLayoutListener(this);
        return;
        label186:
        ((ViewTreeObserver)localObject1).removeGlobalOnLayoutListener(this);
      }
      GamesLog.q("PopupManager", "No content view usable to display popups. Popups will not be displayed in response to this client's calls. Use setViewForPopups() to set your content view.");
    }
    
    public void onGlobalLayout()
    {
      if (this.XS == null) {}
      View localView;
      do
      {
        return;
        localView = (View)this.XS.get();
      } while (localView == null);
      m(localView);
    }
    
    public void onViewAttachedToWindow(View paramView)
    {
      m(paramView);
    }
    
    public void onViewDetachedFromWindow(View paramView)
    {
      this.XO.ku();
      paramView.removeOnAttachStateChangeListener(this);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/games/internal/PopupManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */