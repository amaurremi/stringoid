package com.mobisystems.mobiscanner.controller;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import com.actionbarsherlock.app.SherlockDialogFragment;
import com.mobisystems.mobiscanner.common.c;

public class a
  extends SherlockDialogFragment
  implements View.OnClickListener
{
  protected static final c apd = new c();
  protected int app = 2131296740;
  protected k axJ = null;
  protected int mDialogResId = 2130903089;
  protected final c mLog = new c(this);
  private boolean mStateSaved = false;
  protected Context mThemedContext;
  
  public static void a(FragmentManager paramFragmentManager)
  {
    apd.dl("showEULA: ");
    if (paramFragmentManager.findFragmentByTag("ACCEPT_EULA") == null)
    {
      Bundle localBundle = new Bundle();
      a locala = new a();
      locala.setArguments(localBundle);
      locala.show(paramFragmentManager, "ACCEPT_EULA");
    }
  }
  
  protected void R(View paramView)
  {
    paramView = (WebView)paramView.findViewById(2131165413);
    if (paramView != null) {
      paramView.loadUrl("file:///android_asset/about/eula.html");
    }
  }
  
  public void dismiss()
  {
    this.mLog.dl("dismiss");
    if (!this.mStateSaved)
    {
      super.dismiss();
      return;
    }
    super.dismissAllowingStateLoss();
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    this.mLog.dl("onActivityCreated");
    super.onActivityCreated(paramBundle);
    this.mStateSaved = false;
  }
  
  public void onAttach(Activity paramActivity)
  {
    this.mLog.dl("onAttach");
    super.onAttach(paramActivity);
    try
    {
      this.axJ = ((k)paramActivity);
      this.mThemedContext = new ContextThemeWrapper(paramActivity, 2131361881);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      for (;;)
      {
        this.mLog.A(paramActivity.toString() + " must implement DialogListener");
      }
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.mLog.dl("onCancel");
    if (this.axJ != null)
    {
      paramDialogInterface = getArguments();
      this.axJ.onDialogNegativeAction(getTag(), paramDialogInterface);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131165412: 
      this.axJ.onDialogPositiveAction(getTag(), null);
      dismiss();
      return;
    }
    if (this.axJ != null)
    {
      paramView = getArguments();
      this.axJ.onDialogNegativeAction(getTag(), paramView);
    }
    dismiss();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mLog.dl("onCreate");
    super.onCreate(paramBundle);
    setRetainInstance(true);
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    this.mLog.dl("onCreateDialog");
    paramBundle = new AlertDialog.Builder(this.mThemedContext);
    if (this.app >= 0) {
      paramBundle.setTitle(getResources().getString(this.app));
    }
    View localView = LayoutInflater.from(this.mThemedContext).inflate(this.mDialogResId, null);
    Button localButton = (Button)localView.findViewById(2131165412);
    if (localButton != null) {
      localButton.setOnClickListener(this);
    }
    localButton = (Button)localView.findViewById(2131165365);
    if (localButton != null) {
      localButton.setOnClickListener(this);
    }
    R(localView);
    paramBundle.setView(localView);
    return paramBundle.create();
  }
  
  public void onDestroyView()
  {
    this.mLog.dl("onDestroyView");
    Dialog localDialog = getDialog();
    if ((localDialog != null) && (getRetainInstance())) {
      localDialog.setDismissMessage(null);
    }
    super.onDestroyView();
  }
  
  public void onDetach()
  {
    this.mLog.dl("onDetach");
    super.onDetach();
    this.axJ = null;
  }
  
  public void onPause()
  {
    this.mLog.dl("onPause called");
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    this.mLog.dl("onSaveInstanceState");
    super.onSaveInstanceState(paramBundle);
    this.mStateSaved = true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */