package com.ideashower.readitlater.views;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

public class b
  extends RelativeLayout
{
  private ProgressBar a;
  
  public b(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  private void a()
  {
    ((Activity)getContext()).getLayoutInflater().inflate(2130903070, this, true);
    this.a = ((ProgressBar)findViewById(2131230901));
  }
  
  public int getProgress()
  {
    return this.a.getProgress();
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    super.onRestoreInstanceState(((Bundle)paramParcelable).getParcelable("superState"));
  }
  
  protected Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("superState", super.onSaveInstanceState());
    return localBundle;
  }
  
  public void setProgress(int paramInt)
  {
    this.a.setProgress(paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */