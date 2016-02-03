package com.google.android.gms.dynamic;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public final class b
  extends c.a
{
  private Fragment Mj;
  
  private b(Fragment paramFragment)
  {
    this.Mj = paramFragment;
  }
  
  public static b a(Fragment paramFragment)
  {
    if (paramFragment != null) {
      return new b(paramFragment);
    }
    return null;
  }
  
  public void c(d paramd)
  {
    paramd = (View)e.e(paramd);
    this.Mj.registerForContextMenu(paramd);
  }
  
  public void d(d paramd)
  {
    paramd = (View)e.e(paramd);
    this.Mj.unregisterForContextMenu(paramd);
  }
  
  public d gI()
  {
    return e.h(this.Mj.getActivity());
  }
  
  public c gJ()
  {
    return a(this.Mj.getParentFragment());
  }
  
  public d gK()
  {
    return e.h(this.Mj.getResources());
  }
  
  public c gL()
  {
    return a(this.Mj.getTargetFragment());
  }
  
  public Bundle getArguments()
  {
    return this.Mj.getArguments();
  }
  
  public int getId()
  {
    return this.Mj.getId();
  }
  
  public boolean getRetainInstance()
  {
    return this.Mj.getRetainInstance();
  }
  
  public String getTag()
  {
    return this.Mj.getTag();
  }
  
  public int getTargetRequestCode()
  {
    return this.Mj.getTargetRequestCode();
  }
  
  public boolean getUserVisibleHint()
  {
    return this.Mj.getUserVisibleHint();
  }
  
  public d getView()
  {
    return e.h(this.Mj.getView());
  }
  
  public boolean isAdded()
  {
    return this.Mj.isAdded();
  }
  
  public boolean isDetached()
  {
    return this.Mj.isDetached();
  }
  
  public boolean isHidden()
  {
    return this.Mj.isHidden();
  }
  
  public boolean isInLayout()
  {
    return this.Mj.isInLayout();
  }
  
  public boolean isRemoving()
  {
    return this.Mj.isRemoving();
  }
  
  public boolean isResumed()
  {
    return this.Mj.isResumed();
  }
  
  public boolean isVisible()
  {
    return this.Mj.isVisible();
  }
  
  public void setHasOptionsMenu(boolean paramBoolean)
  {
    this.Mj.setHasOptionsMenu(paramBoolean);
  }
  
  public void setMenuVisibility(boolean paramBoolean)
  {
    this.Mj.setMenuVisibility(paramBoolean);
  }
  
  public void setRetainInstance(boolean paramBoolean)
  {
    this.Mj.setRetainInstance(paramBoolean);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    this.Mj.setUserVisibleHint(paramBoolean);
  }
  
  public void startActivity(Intent paramIntent)
  {
    this.Mj.startActivity(paramIntent);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    this.Mj.startActivityForResult(paramIntent, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/dynamic/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */