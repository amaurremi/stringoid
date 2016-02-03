package com.google.android.gms.dynamic;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public final class b
  extends c.a
{
  private Fragment Mg;
  
  private b(Fragment paramFragment)
  {
    this.Mg = paramFragment;
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
    this.Mg.registerForContextMenu(paramd);
  }
  
  public void d(d paramd)
  {
    paramd = (View)e.e(paramd);
    this.Mg.unregisterForContextMenu(paramd);
  }
  
  public d gD()
  {
    return e.h(this.Mg.getActivity());
  }
  
  public c gE()
  {
    return a(this.Mg.getParentFragment());
  }
  
  public d gF()
  {
    return e.h(this.Mg.getResources());
  }
  
  public c gG()
  {
    return a(this.Mg.getTargetFragment());
  }
  
  public Bundle getArguments()
  {
    return this.Mg.getArguments();
  }
  
  public int getId()
  {
    return this.Mg.getId();
  }
  
  public boolean getRetainInstance()
  {
    return this.Mg.getRetainInstance();
  }
  
  public String getTag()
  {
    return this.Mg.getTag();
  }
  
  public int getTargetRequestCode()
  {
    return this.Mg.getTargetRequestCode();
  }
  
  public boolean getUserVisibleHint()
  {
    return this.Mg.getUserVisibleHint();
  }
  
  public d getView()
  {
    return e.h(this.Mg.getView());
  }
  
  public boolean isAdded()
  {
    return this.Mg.isAdded();
  }
  
  public boolean isDetached()
  {
    return this.Mg.isDetached();
  }
  
  public boolean isHidden()
  {
    return this.Mg.isHidden();
  }
  
  public boolean isInLayout()
  {
    return this.Mg.isInLayout();
  }
  
  public boolean isRemoving()
  {
    return this.Mg.isRemoving();
  }
  
  public boolean isResumed()
  {
    return this.Mg.isResumed();
  }
  
  public boolean isVisible()
  {
    return this.Mg.isVisible();
  }
  
  public void setHasOptionsMenu(boolean paramBoolean)
  {
    this.Mg.setHasOptionsMenu(paramBoolean);
  }
  
  public void setMenuVisibility(boolean paramBoolean)
  {
    this.Mg.setMenuVisibility(paramBoolean);
  }
  
  public void setRetainInstance(boolean paramBoolean)
  {
    this.Mg.setRetainInstance(paramBoolean);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    this.Mg.setUserVisibleHint(paramBoolean);
  }
  
  public void startActivity(Intent paramIntent)
  {
    this.Mg.startActivity(paramIntent);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    this.Mg.startActivityForResult(paramIntent, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/dynamic/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */