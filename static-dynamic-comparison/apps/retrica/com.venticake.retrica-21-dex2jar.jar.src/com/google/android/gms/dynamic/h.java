package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

public final class h
  extends c.a
{
  private Fragment FV;
  
  private h(Fragment paramFragment)
  {
    this.FV = paramFragment;
  }
  
  public static h a(Fragment paramFragment)
  {
    if (paramFragment != null) {
      return new h(paramFragment);
    }
    return null;
  }
  
  public void c(d paramd)
  {
    paramd = (View)e.e(paramd);
    this.FV.registerForContextMenu(paramd);
  }
  
  public void d(d paramd)
  {
    paramd = (View)e.e(paramd);
    this.FV.unregisterForContextMenu(paramd);
  }
  
  public d gI()
  {
    return e.h(this.FV.getActivity());
  }
  
  public c gJ()
  {
    return a(this.FV.getParentFragment());
  }
  
  public d gK()
  {
    return e.h(this.FV.getResources());
  }
  
  public c gL()
  {
    return a(this.FV.getTargetFragment());
  }
  
  public Bundle getArguments()
  {
    return this.FV.getArguments();
  }
  
  public int getId()
  {
    return this.FV.getId();
  }
  
  public boolean getRetainInstance()
  {
    return this.FV.getRetainInstance();
  }
  
  public String getTag()
  {
    return this.FV.getTag();
  }
  
  public int getTargetRequestCode()
  {
    return this.FV.getTargetRequestCode();
  }
  
  public boolean getUserVisibleHint()
  {
    return this.FV.getUserVisibleHint();
  }
  
  public d getView()
  {
    return e.h(this.FV.getView());
  }
  
  public boolean isAdded()
  {
    return this.FV.isAdded();
  }
  
  public boolean isDetached()
  {
    return this.FV.isDetached();
  }
  
  public boolean isHidden()
  {
    return this.FV.isHidden();
  }
  
  public boolean isInLayout()
  {
    return this.FV.isInLayout();
  }
  
  public boolean isRemoving()
  {
    return this.FV.isRemoving();
  }
  
  public boolean isResumed()
  {
    return this.FV.isResumed();
  }
  
  public boolean isVisible()
  {
    return this.FV.isVisible();
  }
  
  public void setHasOptionsMenu(boolean paramBoolean)
  {
    this.FV.setHasOptionsMenu(paramBoolean);
  }
  
  public void setMenuVisibility(boolean paramBoolean)
  {
    this.FV.setMenuVisibility(paramBoolean);
  }
  
  public void setRetainInstance(boolean paramBoolean)
  {
    this.FV.setRetainInstance(paramBoolean);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    this.FV.setUserVisibleHint(paramBoolean);
  }
  
  public void startActivity(Intent paramIntent)
  {
    this.FV.startActivity(paramIntent);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    this.FV.startActivityForResult(paramIntent, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/dynamic/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */