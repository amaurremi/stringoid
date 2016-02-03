package com.mobisystems.mobiscanner.controller;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;
import com.mobisystems.mobiscanner.common.OperationStatus;
import com.mobisystems.mobiscanner.common.c;
import com.mobisystems.mobiscanner.model.b;

public class al
  extends y
{
  private CheckBox aAe;
  private boolean aAf;
  private long[] aDR;
  private b axZ;
  
  private void c(b paramb, boolean paramBoolean)
  {
    if (this.aGj == null)
    {
      Bundle localBundle = getArguments();
      localBundle.putLong("doc_id", this.axZ.getId());
      localBundle.putLong("NEW_DOC_ID", paramb.getId());
      localBundle.putBoolean("COPY_FLAG", paramBoolean);
      this.aGj = new am(getActivity(), this, getTag(), localBundle);
      this.aGj.execute(new Void[0]);
    }
  }
  
  protected void Fa()
  {
    super.Fa();
    this.aAf = this.aAe.isChecked();
    c(Gf(), this.aAf);
  }
  
  protected void L(int paramInt1, int paramInt2) {}
  
  protected void R(View paramView)
  {
    super.R(paramView);
    Bundle localBundle = getArguments();
    this.axZ = new b(localBundle);
    this.aDR = localBundle.getLongArray("PAGES");
    gs(this.aDR.length);
    this.aAe = ((CheckBox)paramView.findViewById(2131165428));
    this.aAe.setChecked(true);
  }
  
  public void a(OperationStatus paramOperationStatus, Bundle paramBundle)
  {
    if (getActivity() != null)
    {
      if ((!paramOperationStatus.equals(OperationStatus.awp)) && (!paramOperationStatus.equals(OperationStatus.awq))) {
        break label104;
      }
      this.mLog.dl("Page copy/move finished");
      String str = paramBundle.getString("NEW_DOC_NAME");
      paramOperationStatus = String.format(getResources().getString(paramOperationStatus.Ds()), new Object[] { str });
      Toast.makeText(getActivity(), paramOperationStatus, 0).show();
    }
    for (;;)
    {
      if (this.axJ != null) {
        this.axJ.onDialogPositiveAction(getTag(), paramBundle);
      }
      dismiss();
      return;
      label104:
      this.mLog.dl("Page copy failed");
      Toast.makeText(getActivity(), paramOperationStatus.Ds(), 0).show();
    }
  }
  
  protected void init()
  {
    this.mDialogResId = 2130903099;
    this.app = 2131296732;
    this.aGh = 2131296800;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */