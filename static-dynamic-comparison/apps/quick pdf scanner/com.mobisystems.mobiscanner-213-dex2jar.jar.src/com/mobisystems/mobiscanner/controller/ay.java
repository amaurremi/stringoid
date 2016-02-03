package com.mobisystems.mobiscanner.controller;

import android.os.Bundle;
import android.view.View;
import com.mobisystems.mobiscanner.common.OperationStatus;
import com.mobisystems.mobiscanner.model.b;

public class ay
  extends bd
{
  private long[] aDR;
  private b axZ;
  
  private void HD()
  {
    if (this.aGj == null)
    {
      Bundle localBundle = new Bundle();
      this.axZ.p(localBundle);
      localBundle.putLongArray("PAGES", this.aDR);
      this.aGj = new az(getActivity(), this, getTag(), localBundle);
      this.aGj.execute(new Void[0]);
    }
  }
  
  protected void Fa()
  {
    super.Fa();
    HD();
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
  
  public void a(OperationStatus paramOperationStatus, Bundle paramBundle)
  {
    if (this.axJ != null) {
      this.axJ.onDialogPositiveAction(getTag(), paramBundle);
    }
    dismiss();
  }
  
  protected void init()
  {
    this.mDialogResId = 2130903104;
    this.app = 2131296730;
    this.aGh = 2131296798;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */