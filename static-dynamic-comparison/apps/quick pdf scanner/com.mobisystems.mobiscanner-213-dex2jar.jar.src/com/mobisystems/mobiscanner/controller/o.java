package com.mobisystems.mobiscanner.controller;

import android.os.Bundle;
import android.view.View;

public class o
  extends bd
{
  private long[] aAd;
  
  private void Fg()
  {
    if (this.aGj == null)
    {
      this.aGj = new p(getActivity(), this, getTag(), getArguments());
      this.aGj.execute(new Void[0]);
    }
  }
  
  protected void Fa()
  {
    super.Fa();
    Fg();
  }
  
  protected void R(View paramView)
  {
    super.R(paramView);
    this.aAd = getArguments().getLongArray("DOCUMENTS");
    gs(this.aAd.length);
  }
  
  protected void S(View paramView)
  {
    super.S(paramView);
    this.aGh = 2131296793;
  }
  
  protected void init()
  {
    this.mDialogResId = 2130903084;
    this.app = 2131296714;
    this.aGh = 2131296792;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */