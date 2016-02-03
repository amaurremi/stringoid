package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

public final class h
  extends c.a
{
  private Fragment Ll;
  
  private h(Fragment paramFragment)
  {
    this.Ll = paramFragment;
  }
  
  public static h a(Fragment paramFragment)
  {
    if (paramFragment != null) {
      return new h(paramFragment);
    }
    return null;
  }
  
  public void d(d paramd)
  {
    paramd = (View)e.f(paramd);
    this.Ll.registerForContextMenu(paramd);
  }
  
  public void e(d paramd)
  {
    paramd = (View)e.f(paramd);
    this.Ll.unregisterForContextMenu(paramd);
  }
  
  public Bundle getArguments()
  {
    return this.Ll.getArguments();
  }
  
  public int getId()
  {
    return this.Ll.getId();
  }
  
  public boolean getRetainInstance()
  {
    return this.Ll.getRetainInstance();
  }
  
  public String getTag()
  {
    return this.Ll.getTag();
  }
  
  public int getTargetRequestCode()
  {
    return this.Ll.getTargetRequestCode();
  }
  
  public boolean getUserVisibleHint()
  {
    return this.Ll.getUserVisibleHint();
  }
  
  public d getView()
  {
    return e.k(this.Ll.getView());
  }
  
  public boolean isAdded()
  {
    return this.Ll.isAdded();
  }
  
  public boolean isDetached()
  {
    return this.Ll.isDetached();
  }
  
  public boolean isHidden()
  {
    return this.Ll.isHidden();
  }
  
  public boolean isInLayout()
  {
    return this.Ll.isInLayout();
  }
  
  public boolean isRemoving()
  {
    return this.Ll.isRemoving();
  }
  
  public boolean isResumed()
  {
    return this.Ll.isResumed();
  }
  
  public boolean isVisible()
  {
    return this.Ll.isVisible();
  }
  
  public d iu()
  {
    return e.k(this.Ll.getActivity());
  }
  
  public c iv()
  {
    return a(this.Ll.getParentFragment());
  }
  
  public d iw()
  {
    return e.k(this.Ll.getResources());
  }
  
  public c ix()
  {
    return a(this.Ll.getTargetFragment());
  }
  
  public void setHasOptionsMenu(boolean paramBoolean)
  {
    this.Ll.setHasOptionsMenu(paramBoolean);
  }
  
  public void setMenuVisibility(boolean paramBoolean)
  {
    this.Ll.setMenuVisibility(paramBoolean);
  }
  
  public void setRetainInstance(boolean paramBoolean)
  {
    this.Ll.setRetainInstance(paramBoolean);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    this.Ll.setUserVisibleHint(paramBoolean);
  }
  
  public void startActivity(Intent paramIntent)
  {
    this.Ll.startActivity(paramIntent);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    this.Ll.startActivityForResult(paramIntent, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/dynamic/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */