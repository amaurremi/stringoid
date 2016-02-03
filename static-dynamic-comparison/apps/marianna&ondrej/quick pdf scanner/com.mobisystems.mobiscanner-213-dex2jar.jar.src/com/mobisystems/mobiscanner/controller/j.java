package com.mobisystems.mobiscanner.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.actionbarsherlock.app.SherlockFragment;

public class j
  extends SherlockFragment
  implements View.OnClickListener
{
  private View.OnClickListener azX;
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.azX = paramOnClickListener;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    paramBundle = (ImageView)getView().findViewById(2131165445);
    int i = getArguments().getInt("CROP_HELP_IMAGE_RESOURCE", -1);
    if (i > -1) {
      paramBundle.setImageResource(i);
    }
    paramBundle.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
    } while (this.azX == null);
    this.azX.onClick(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setRetainInstance(true);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903110, paramViewGroup, false);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */