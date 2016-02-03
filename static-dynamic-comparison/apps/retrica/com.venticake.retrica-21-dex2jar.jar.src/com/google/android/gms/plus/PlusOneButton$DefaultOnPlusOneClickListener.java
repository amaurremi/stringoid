package com.google.android.gms.plus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class PlusOneButton$DefaultOnPlusOneClickListener
  implements View.OnClickListener, PlusOneButton.OnPlusOneClickListener
{
  private final PlusOneButton.OnPlusOneClickListener abF;
  
  public PlusOneButton$DefaultOnPlusOneClickListener(PlusOneButton paramPlusOneButton, PlusOneButton.OnPlusOneClickListener paramOnPlusOneClickListener)
  {
    this.abF = paramOnPlusOneClickListener;
  }
  
  public void onClick(View paramView)
  {
    paramView = (Intent)PlusOneButton.a(this.abG).getTag();
    if (this.abF != null)
    {
      this.abF.onPlusOneClick(paramView);
      return;
    }
    onPlusOneClick(paramView);
  }
  
  public void onPlusOneClick(Intent paramIntent)
  {
    Context localContext = this.abG.getContext();
    if (((localContext instanceof Activity)) && (paramIntent != null)) {
      ((Activity)localContext).startActivityForResult(paramIntent, PlusOneButton.b(this.abG));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/plus/PlusOneButton$DefaultOnPlusOneClickListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */