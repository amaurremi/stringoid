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
import com.google.android.gms.internal.iq;
import java.lang.ref.WeakReference;

public class PopupManager
{
  protected GamesClientImpl OV;
  protected PopupLocationInfo OW;
  
  private PopupManager(GamesClientImpl paramGamesClientImpl, int paramInt)
  {
    this.OV = paramGamesClientImpl;
    cl(paramInt);
  }
  
  public static PopupManager a(GamesClientImpl paramGamesClientImpl, int paramInt)
  {
    if (iq.fY()) {
      return new PopupManagerHCMR1(paramGamesClientImpl, paramInt);
    }
    return new PopupManager(paramGamesClientImpl, paramInt);
  }
  
  protected void cl(int paramInt)
  {
    this.OW = new PopupLocationInfo(paramInt, new Binder(), null);
  }
  
  public void g(View paramView) {}
  
  public void hG()
  {
    this.OV.a(this.OW.OX, this.OW.hJ());
  }
  
  public Bundle hH()
  {
    return this.OW.hJ();
  }
  
  public IBinder hI()
  {
    return this.OW.OX;
  }
  
  public void setGravity(int paramInt)
  {
    this.OW.gravity = paramInt;
  }
  
  public static final class PopupLocationInfo
  {
    public IBinder OX;
    public int OY = -1;
    public int bottom = 0;
    public int gravity;
    public int left = 0;
    public int right = 0;
    public int top = 0;
    
    private PopupLocationInfo(int paramInt, IBinder paramIBinder)
    {
      this.gravity = paramInt;
      this.OX = paramIBinder;
    }
    
    public Bundle hJ()
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("popupLocationInfo.gravity", this.gravity);
      localBundle.putInt("popupLocationInfo.displayId", this.OY);
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
    private boolean Ns = false;
    private WeakReference<View> OZ;
    
    protected PopupManagerHCMR1(GamesClientImpl paramGamesClientImpl, int paramInt)
    {
      super(paramInt, null);
    }
    
    private void h(View paramView)
    {
      int j = -1;
      int i = j;
      if (iq.gc())
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
      this.OW.OY = i;
      this.OW.OX = ((IBinder)localObject);
      this.OW.left = arrayOfInt[0];
      this.OW.top = arrayOfInt[1];
      this.OW.right = (arrayOfInt[0] + j);
      this.OW.bottom = (arrayOfInt[1] + k);
      if (this.Ns)
      {
        hG();
        this.Ns = false;
      }
    }
    
    protected void cl(int paramInt)
    {
      this.OW = new PopupManager.PopupLocationInfo(paramInt, null, null);
    }
    
    public void g(View paramView)
    {
      this.OV.hr();
      Object localObject2;
      Object localObject1;
      if (this.OZ != null)
      {
        localObject2 = (View)this.OZ.get();
        Context localContext = this.OV.getContext();
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
          if (!iq.gb()) {
            break label186;
          }
          ((ViewTreeObserver)localObject1).removeOnGlobalLayoutListener(this);
        }
      }
      for (;;)
      {
        this.OZ = null;
        localObject2 = this.OV.getContext();
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
        h((View)localObject1);
        this.OZ = new WeakReference(localObject1);
        ((View)localObject1).addOnAttachStateChangeListener(this);
        ((View)localObject1).getViewTreeObserver().addOnGlobalLayoutListener(this);
        return;
        label186:
        ((ViewTreeObserver)localObject1).removeGlobalOnLayoutListener(this);
      }
      GamesLog.k("PopupManager", "No content view usable to display popups. Popups will not be displayed in response to this client's calls. Use setViewForPopups() to set your content view.");
    }
    
    public void hG()
    {
      if (this.OW.OX != null)
      {
        super.hG();
        return;
      }
      if (this.OZ != null) {}
      for (boolean bool = true;; bool = false)
      {
        this.Ns = bool;
        return;
      }
    }
    
    public void onGlobalLayout()
    {
      if (this.OZ == null) {}
      View localView;
      do
      {
        return;
        localView = (View)this.OZ.get();
      } while (localView == null);
      h(localView);
    }
    
    public void onViewAttachedToWindow(View paramView)
    {
      h(paramView);
    }
    
    public void onViewDetachedFromWindow(View paramView)
    {
      this.OV.hr();
      paramView.removeOnAttachStateChangeListener(this);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/internal/PopupManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */