package com.mobisystems.mobiscanner.controller;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;
import com.mobisystems.mobiscanner.common.OperationStatus;
import com.mobisystems.mobiscanner.common.c;
import com.mobisystems.mobiscanner.model.b;

public class m
  extends y
{
  private long[] aAd;
  private CheckBox aAe;
  private boolean aAf;
  
  private void T(View paramView)
  {
    paramView.findViewById(2131165370).setVisibility(8);
  }
  
  private void a(b paramb, boolean paramBoolean)
  {
    if (this.aGj == null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putLongArray("DOCUMENTS", this.aAd);
      localBundle.putLong("NEW_DOC_ID", paramb.getId());
      localBundle.putBoolean("COPY_FLAG", paramBoolean);
      this.aGj = new n(getActivity(), this, getTag(), localBundle);
      this.aGj.execute(new Void[0]);
    }
  }
  
  protected void Fa()
  {
    super.Fa();
    this.aAf = this.aAe.isChecked();
    a(Gf(), this.aAf);
  }
  
  protected void R(View paramView)
  {
    super.R(paramView);
    this.aAd = getArguments().getLongArray("DOCUMENTS");
    gs(this.aAd.length);
    this.aAe = ((CheckBox)paramView.findViewById(2131165371));
    this.aAe.setChecked(true);
    if (this.aGj != null) {
      T(paramView);
    }
  }
  
  protected void S(View paramView)
  {
    super.S(paramView);
    this.aGh = 2131296795;
    T(paramView);
  }
  
  public void a(OperationStatus paramOperationStatus, Bundle paramBundle)
  {
    if (getActivity() != null)
    {
      if (!paramOperationStatus.equals(OperationStatus.awo)) {
        break label99;
      }
      this.mLog.dl("Document copy/merge finished");
      b localb = new b(paramBundle);
      paramOperationStatus = String.format(getResources().getString(paramOperationStatus.Ds()), new Object[] { localb.getName() });
      Toast.makeText(getActivity(), paramOperationStatus, 0).show();
    }
    for (;;)
    {
      if (this.axJ != null) {
        this.axJ.onDialogPositiveAction(getTag(), paramBundle);
      }
      dismiss();
      return;
      label99:
      this.mLog.dl("Document copy/merge failed");
      Toast.makeText(getActivity(), paramOperationStatus.Ds(), 0).show();
    }
  }
  
  protected void init()
  {
    this.mDialogResId = 2130903083;
    this.app = 2131296715;
    this.aGh = 2131296794;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */