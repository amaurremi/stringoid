package com.google.android.gms.dynamic;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public final class b
  extends c.a
{
  private Fragment Sb;
  
  private b(Fragment paramFragment)
  {
    this.Sb = paramFragment;
  }
  
  public static b a(Fragment paramFragment)
  {
    if (paramFragment != null) {
      return new b(paramFragment);
    }
    return null;
  }
  
  public void d(d paramd)
  {
    paramd = (View)e.f(paramd);
    this.Sb.registerForContextMenu(paramd);
  }
  
  public void e(d paramd)
  {
    paramd = (View)e.f(paramd);
    this.Sb.unregisterForContextMenu(paramd);
  }
  
  public Bundle getArguments()
  {
    return this.Sb.getArguments();
  }
  
  public int getId()
  {
    return this.Sb.getId();
  }
  
  public boolean getRetainInstance()
  {
    return this.Sb.getRetainInstance();
  }
  
  public String getTag()
  {
    return this.Sb.getTag();
  }
  
  public int getTargetRequestCode()
  {
    return this.Sb.getTargetRequestCode();
  }
  
  public boolean getUserVisibleHint()
  {
    return this.Sb.getUserVisibleHint();
  }
  
  public d getView()
  {
    return e.k(this.Sb.getView());
  }
  
  public boolean isAdded()
  {
    return this.Sb.isAdded();
  }
  
  public boolean isDetached()
  {
    return this.Sb.isDetached();
  }
  
  public boolean isHidden()
  {
    return this.Sb.isHidden();
  }
  
  public boolean isInLayout()
  {
    return this.Sb.isInLayout();
  }
  
  public boolean isRemoving()
  {
    return this.Sb.isRemoving();
  }
  
  public boolean isResumed()
  {
    return this.Sb.isResumed();
  }
  
  public boolean isVisible()
  {
    return this.Sb.isVisible();
  }
  
  public d iu()
  {
    return e.k(this.Sb.getActivity());
  }
  
  public c iv()
  {
    return a(this.Sb.getParentFragment());
  }
  
  public d iw()
  {
    return e.k(this.Sb.getResources());
  }
  
  public c ix()
  {
    return a(this.Sb.getTargetFragment());
  }
  
  public void setHasOptionsMenu(boolean paramBoolean)
  {
    this.Sb.setHasOptionsMenu(paramBoolean);
  }
  
  public void setMenuVisibility(boolean paramBoolean)
  {
    this.Sb.setMenuVisibility(paramBoolean);
  }
  
  public void setRetainInstance(boolean paramBoolean)
  {
    this.Sb.setRetainInstance(paramBoolean);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    this.Sb.setUserVisibleHint(paramBoolean);
  }
  
  public void startActivity(Intent paramIntent)
  {
    this.Sb.startActivity(paramIntent);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    this.Sb.startActivityForResult(paramIntent, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/dynamic/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */