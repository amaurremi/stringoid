package com.mobisystems.mobiscanner.controller;

import android.os.Bundle;
import android.view.View;
import com.mobisystems.mobiscanner.model.b;

public class an
  extends bd
{
  private long[] aDR;
  private b axZ;
  
  private void Gs()
  {
    if (this.aGj == null)
    {
      Bundle localBundle = new Bundle();
      this.axZ.p(localBundle);
      localBundle.putLongArray("PAGES", this.aDR);
      this.aGj = new ao(getActivity(), this, getTag(), localBundle);
      this.aGj.execute(new Void[0]);
    }
  }
  
  protected void Fa()
  {
    super.Fa();
    Gs();
  }
  
  protected void L(int paramInt1, int paramInt2) {}
  
  protected void R(View paramView)
  {
    super.R(paramView);
    paramView = getArguments();
    this.axZ = new b(paramView);
    this.aDR = paramView.getLongArray("PAGES");
    gs(this.aDR.length);
  }
  
  protected void init()
  {
    this.mDialogResId = 2130903100;
    this.app = 2131296729;
    this.aGh = 2131296797;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */