package com.mobisystems.mobiscanner.controller;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.mobisystems.mobiscanner.common.c;
import com.mobisystems.mobiscanner.model.b;

public class aj
  extends bd
{
  private long[] aDR;
  private int aDS;
  private int aDT;
  private b axZ;
  
  private void Gq()
  {
    ((PageGridActivity)getActivity()).Z(this.aDR[this.aDT]);
    b(new as(), "PAGE_EXPORT_FOR_BATCH_EDIT");
  }
  
  private void b(bd parambd, String paramString)
  {
    long[] arrayOfLong = new long[1];
    arrayOfLong[0] = this.aDR[this.aDT];
    if ((arrayOfLong != null) && (arrayOfLong.length > 0))
    {
      this.mLog.dl("startPageProgressTask: action=" + paramString + ", number of selected positions=" + arrayOfLong.length);
      Bundle localBundle = new Bundle();
      localBundle.putLong("doc_id", this.axZ.getId());
      localBundle.putLongArray("PAGES", arrayOfLong);
      parambd.setArguments(localBundle);
      parambd.show(getActivity().getSupportFragmentManager(), paramString);
    }
  }
  
  protected void Fa()
  {
    Gq();
  }
  
  public void Gr()
  {
    this.aDT += 1;
    if (this.aDT < this.aDS)
    {
      Gq();
      return;
    }
    if (this.axJ != null) {
      this.axJ.onDialogPositiveAction(getTag(), null);
    }
    dismiss();
  }
  
  protected void L(int paramInt1, int paramInt2) {}
  
  protected void R(View paramView)
  {
    super.R(paramView);
    paramView = getArguments();
    this.axZ = new b(paramView);
    this.aDR = paramView.getLongArray("PAGES");
    this.aDS = this.aDR.length;
    this.aDT = 0;
    gs(this.aDR.length);
  }
  
  protected void init()
  {
    this.mDialogResId = 2130903097;
    this.app = 2131296731;
    this.aGh = 2131296799;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */