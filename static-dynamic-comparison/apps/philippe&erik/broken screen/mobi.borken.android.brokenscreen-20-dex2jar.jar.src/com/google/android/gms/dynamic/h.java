package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

public final class h
  extends c.a
{
  private Fragment FS;
  
  private h(Fragment paramFragment)
  {
    this.FS = paramFragment;
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
    this.FS.registerForContextMenu(paramd);
  }
  
  public void d(d paramd)
  {
    paramd = (View)e.e(paramd);
    this.FS.unregisterForContextMenu(paramd);
  }
  
  public d gD()
  {
    return e.h(this.FS.getActivity());
  }
  
  public c gE()
  {
    return a(this.FS.getParentFragment());
  }
  
  public d gF()
  {
    return e.h(this.FS.getResources());
  }
  
  public c gG()
  {
    return a(this.FS.getTargetFragment());
  }
  
  public Bundle getArguments()
  {
    return this.FS.getArguments();
  }
  
  public int getId()
  {
    return this.FS.getId();
  }
  
  public boolean getRetainInstance()
  {
    return this.FS.getRetainInstance();
  }
  
  public String getTag()
  {
    return this.FS.getTag();
  }
  
  public int getTargetRequestCode()
  {
    return this.FS.getTargetRequestCode();
  }
  
  public boolean getUserVisibleHint()
  {
    return this.FS.getUserVisibleHint();
  }
  
  public d getView()
  {
    return e.h(this.FS.getView());
  }
  
  public boolean isAdded()
  {
    return this.FS.isAdded();
  }
  
  public boolean isDetached()
  {
    return this.FS.isDetached();
  }
  
  public boolean isHidden()
  {
    return this.FS.isHidden();
  }
  
  public boolean isInLayout()
  {
    return this.FS.isInLayout();
  }
  
  public boolean isRemoving()
  {
    return this.FS.isRemoving();
  }
  
  public boolean isResumed()
  {
    return this.FS.isResumed();
  }
  
  public boolean isVisible()
  {
    return this.FS.isVisible();
  }
  
  public void setHasOptionsMenu(boolean paramBoolean)
  {
    this.FS.setHasOptionsMenu(paramBoolean);
  }
  
  public void setMenuVisibility(boolean paramBoolean)
  {
    this.FS.setMenuVisibility(paramBoolean);
  }
  
  public void setRetainInstance(boolean paramBoolean)
  {
    this.FS.setRetainInstance(paramBoolean);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    this.FS.setUserVisibleHint(paramBoolean);
  }
  
  public void startActivity(Intent paramIntent)
  {
    this.FS.startActivity(paramIntent);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    this.FS.startActivityForResult(paramIntent, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/dynamic/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */