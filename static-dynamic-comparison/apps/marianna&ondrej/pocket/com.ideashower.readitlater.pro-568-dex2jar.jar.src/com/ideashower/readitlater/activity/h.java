package com.ideashower.readitlater.activity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.a.a.a.a;
import com.ideashower.readitlater.views.RilButton;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;
import com.ideashower.readitlater.views.toolbars.ToolbarLayout;
import com.pocket.q.a.n;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class h
  extends f
  implements SharedPreferences.OnSharedPreferenceChangeListener
{
  protected ToolbarLayout Y;
  protected StyledToolbar Z;
  protected ListView aa;
  protected RilButton ab;
  protected i ac;
  protected a ad;
  protected View ae;
  protected boolean af;
  private final ArrayList ag = new ArrayList();
  
  public int U()
  {
    return 4;
  }
  
  public boolean V()
  {
    return true;
  }
  
  protected abstract int Y();
  
  protected abstract View Z();
  
  protected abstract void a(ArrayList paramArrayList);
  
  protected void aa()
  {
    this.ag.clear();
    a(this.ag);
    this.ac.notifyDataSetChanged();
  }
  
  public void b(int paramInt)
  {
    super.b(paramInt);
    i.a(this.ac);
  }
  
  protected View c(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903063, paramViewGroup, false);
  }
  
  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    com.ideashower.readitlater.h.i.a(this);
    this.Y = ((ToolbarLayout)c(2131230729));
    this.Z = ((StyledToolbar)this.Y.getTopToolbar());
    this.Z.a(true, this);
    if (Y() != 0) {
      this.Z.setTitle(Y());
    }
    this.Z.setIsRainbowified(true);
    a(this.ag);
    this.ac = new i(this);
    this.aa = ((ListView)c(2131230730));
    this.ab = ((RilButton)c(2131230743));
    this.ae = Z();
    if ((this.ae != null) && (this.af))
    {
      this.ad = new a();
      this.ad.a(this.ae);
      this.ad.a(this.ac);
      this.aa.setAdapter(this.ad);
    }
    for (;;)
    {
      this.aa.setDividerHeight(0);
      this.aa.setSelector(new ColorDrawable(0));
      return;
      this.aa.setAdapter(this.ac);
    }
  }
  
  public void g(boolean paramBoolean)
  {
    Iterator localIterator = this.ag.iterator();
    while (localIterator.hasNext()) {
      if (((n)localIterator.next()).a()) {
        paramBoolean = true;
      }
    }
    if (paramBoolean) {
      this.ac.notifyDataSetChanged();
    }
  }
  
  public void h(boolean paramBoolean)
  {
    this.af = paramBoolean;
    if ((this.ad != null) && (this.ae != null)) {
      this.ad.b(this.ae, paramBoolean);
    }
  }
  
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    g(false);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */