package com.mobisystems.mobiscanner.controller;

import android.os.Bundle;
import android.view.View;
import com.mobisystems.mobiscanner.model.b;

public class ae
  extends y
{
  private void d(b paramb)
  {
    if (this.aGj == null)
    {
      Bundle localBundle = getArguments();
      paramb.p(localBundle);
      this.aGj = new ai(getActivity(), this, getTag(), localBundle);
      this.aGj.execute(new Void[0]);
    }
  }
  
  protected void Fa()
  {
    super.Fa();
    d(Gf());
  }
  
  protected void L(int paramInt1, int paramInt2) {}
  
  protected void R(View paramView)
  {
    super.R(paramView);
    gs(getArguments().getStringArray("IMAGE_IMPORT_FILES").length);
  }
  
  protected void init()
  {
    this.mDialogResId = 2130903096;
    this.app = 2131296724;
    this.aGh = 2131296802;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */