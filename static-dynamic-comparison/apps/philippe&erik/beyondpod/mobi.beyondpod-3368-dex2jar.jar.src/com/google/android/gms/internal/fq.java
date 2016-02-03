package com.google.android.gms.internal;

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
import java.lang.ref.WeakReference;

public class fq
{
  protected fl te;
  protected a uI;
  
  private fq(fl paramfl, int paramInt)
  {
    this.te = paramfl;
    aF(paramInt);
  }
  
  public static fq a(fl paramfl, int paramInt)
  {
    if (fg.cE()) {
      return new b(paramfl, paramInt);
    }
    return new fq(paramfl, paramInt);
  }
  
  protected void aF(int paramInt)
  {
    this.uI = new a(paramInt, new Binder(), null);
  }
  
  public void dl()
  {
    this.te.a(this.uI.uJ, this.uI.jdMethod_do());
  }
  
  public Bundle dm()
  {
    return this.uI.jdMethod_do();
  }
  
  public IBinder dn()
  {
    return this.uI.uJ;
  }
  
  public void e(View paramView) {}
  
  public void setGravity(int paramInt)
  {
    this.uI.gravity = paramInt;
  }
  
  public static final class a
  {
    public int bottom = 0;
    public int gravity;
    public int left = 0;
    public int right = 0;
    public int top = 0;
    public IBinder uJ;
    public int uK = -1;
    
    private a(int paramInt, IBinder paramIBinder)
    {
      this.gravity = paramInt;
      this.uJ = paramIBinder;
    }
    
    public Bundle jdMethod_do()
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("popupLocationInfo.gravity", this.gravity);
      localBundle.putInt("popupLocationInfo.displayId", this.uK);
      localBundle.putInt("popupLocationInfo.left", this.left);
      localBundle.putInt("popupLocationInfo.top", this.top);
      localBundle.putInt("popupLocationInfo.right", this.right);
      localBundle.putInt("popupLocationInfo.bottom", this.bottom);
      return localBundle;
    }
  }
  
  private static final class b
    extends fq
    implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener
  {
    private boolean tT = false;
    private WeakReference<View> uL;
    
    protected b(fl paramfl, int paramInt)
    {
      super(paramInt, null);
    }
    
    private void f(View paramView)
    {
      int j = -1;
      int i = j;
      if (fg.cI())
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
      this.uI.uK = i;
      this.uI.uJ = ((IBinder)localObject);
      this.uI.left = arrayOfInt[0];
      this.uI.top = arrayOfInt[1];
      this.uI.right = (arrayOfInt[0] + j);
      this.uI.bottom = (arrayOfInt[1] + k);
      if (this.tT)
      {
        dl();
        this.tT = false;
      }
    }
    
    protected void aF(int paramInt)
    {
      this.uI = new fq.a(paramInt, null, null);
    }
    
    public void dl()
    {
      if (this.uI.uJ != null)
      {
        super.dl();
        return;
      }
      if (this.uL != null) {}
      for (boolean bool = true;; bool = false)
      {
        this.tT = bool;
        return;
      }
    }
    
    public void e(View paramView)
    {
      this.te.df();
      Object localObject2;
      Object localObject1;
      if (this.uL != null)
      {
        localObject2 = (View)this.uL.get();
        Context localContext = this.te.getContext();
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
          if (!fg.cH()) {
            break label186;
          }
          ((ViewTreeObserver)localObject1).removeOnGlobalLayoutListener(this);
        }
      }
      for (;;)
      {
        this.uL = null;
        localObject2 = this.te.getContext();
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
            fn.c("PopupManager", "You have not specified a View to use as content view for popups. Falling back to the Activity content view which may not work properly in future versions of the API. Use setViewForPopups() to set your content view.");
            localObject1 = paramView;
          }
        }
        if (localObject1 == null) {
          break;
        }
        f((View)localObject1);
        this.uL = new WeakReference(localObject1);
        ((View)localObject1).addOnAttachStateChangeListener(this);
        ((View)localObject1).getViewTreeObserver().addOnGlobalLayoutListener(this);
        return;
        label186:
        ((ViewTreeObserver)localObject1).removeGlobalOnLayoutListener(this);
      }
      fn.d("PopupManager", "No content view usable to display popups. Popups will not be displayed in response to this client's calls. Use setViewForPopups() to set your content view.");
    }
    
    public void onGlobalLayout()
    {
      if (this.uL == null) {}
      View localView;
      do
      {
        return;
        localView = (View)this.uL.get();
      } while (localView == null);
      f(localView);
    }
    
    public void onViewAttachedToWindow(View paramView)
    {
      f(paramView);
    }
    
    public void onViewDetachedFromWindow(View paramView)
    {
      this.te.df();
      paramView.removeOnAttachStateChangeListener(this);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/fq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */