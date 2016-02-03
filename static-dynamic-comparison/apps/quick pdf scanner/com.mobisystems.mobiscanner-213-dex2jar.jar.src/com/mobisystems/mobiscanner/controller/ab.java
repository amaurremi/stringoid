package com.mobisystems.mobiscanner.controller;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class ab
  extends bd
  implements AdapterView.OnItemSelectedListener, TextView.OnEditorActionListener
{
  private String axs;
  private String hO;
  
  protected void Fa()
  {
    dismiss();
    if (this.axJ != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("GET_FROM_MARKET_PACKAGE_NAME", this.axs);
      this.axJ.onDialogPositiveAction(getTag(), localBundle);
    }
  }
  
  protected void L(int paramInt1, int paramInt2) {}
  
  protected void R(View paramView)
  {
    super.R(paramView);
    Object localObject = getArguments();
    this.hO = ((Bundle)localObject).getString("GET_FROM_MARKET_APP_NAME");
    this.axs = ((Bundle)localObject).getString("GET_FROM_MARKET_PACKAGE_NAME");
    localObject = String.format(getResources().getString(2131296816), new Object[] { this.hO });
    ((TextView)paramView.findViewById(2131165416)).setText((CharSequence)localObject);
  }
  
  protected void init()
  {
    this.mDialogResId = 2130903091;
    this.app = 2131296748;
    this.aGh = -1;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.mThemedContext = paramActivity;
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = super.onCreateDialog(paramBundle);
    paramBundle.setTitle(String.format(getResources().getString(this.app), new Object[] { this.hO }));
    return paramBundle;
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (6 == paramInt)
    {
      Fa();
      return true;
    }
    return false;
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */