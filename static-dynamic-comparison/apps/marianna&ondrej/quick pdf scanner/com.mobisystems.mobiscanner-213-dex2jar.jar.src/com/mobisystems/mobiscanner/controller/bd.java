package com.mobisystems.mobiscanner.controller;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.AsyncTask.Status;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.app.SherlockDialogFragment;
import com.mobisystems.mobiscanner.common.OperationStatus;
import com.mobisystems.mobiscanner.common.c;

public abstract class bd
  extends SherlockDialogFragment
  implements View.OnClickListener, bc<Bundle>
{
  protected static final c apd = new c();
  protected TextView aGf;
  protected ProgressBar aGg;
  protected int aGh;
  protected int aGi = 0;
  protected bb aGj = null;
  protected int app;
  protected k axJ = null;
  protected Button azt;
  protected Button azu;
  protected int mDialogResId;
  protected final c mLog = new c(this);
  protected boolean mStateSaved = false;
  protected Context mThemedContext;
  
  protected void Fa()
  {
    if (this.axJ != null) {
      S(getDialog().getWindow().getDecorView());
    }
  }
  
  protected void L(int paramInt1, int paramInt2)
  {
    if (this.axJ != null)
    {
      String str = getResources().getString(this.aGh);
      this.aGf.setText(str + " " + paramInt1 + "/" + paramInt2);
    }
  }
  
  protected void R(View paramView)
  {
    if (this.aGj != null) {
      S(paramView);
    }
  }
  
  protected void S(View paramView)
  {
    e(paramView.findViewById(2131165363), false);
    if (this.aGg != null) {
      this.aGg.setVisibility(0);
    }
    if (this.azt != null) {
      this.azt.setEnabled(false);
    }
  }
  
  public void a(OperationStatus paramOperationStatus, Bundle paramBundle)
  {
    this.mLog.dl("onTaskFinished, status=" + paramOperationStatus);
    if (getActivity() != null)
    {
      if (!paramOperationStatus.equals(OperationStatus.avC)) {
        break label78;
      }
      this.mLog.dl("Operation finished");
    }
    for (;;)
    {
      if (this.axJ != null) {
        this.axJ.onDialogPositiveAction(getTag(), paramBundle);
      }
      dismiss();
      return;
      label78:
      this.mLog.dl("Operation failed");
      Toast.makeText(getActivity(), paramOperationStatus.Ds(), 0).show();
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
  
  protected void e(View paramView, boolean paramBoolean)
  {
    if ((this.axJ != null) && (paramView != null))
    {
      paramView.setEnabled(paramBoolean);
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        int i = 0;
        while (i < paramView.getChildCount())
        {
          e(paramView.getChildAt(i), paramBoolean);
          i += 1;
        }
      }
    }
  }
  
  public void gi(int paramInt)
  {
    this.aGi = paramInt;
  }
  
  public void gj(int paramInt)
  {
    L(paramInt, this.aGi);
  }
  
  public void gk(int paramInt)
  {
    this.aGg.setMax(paramInt);
  }
  
  public void gl(int paramInt)
  {
    this.aGg.setProgress(paramInt);
  }
  
  protected void gs(int paramInt)
  {
    if (this.axJ != null)
    {
      String str = String.format(getResources().getString(this.aGh), new Object[] { Integer.valueOf(paramInt) });
      this.aGf.setText(str);
    }
  }
  
  protected abstract void init();
  
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
      this.mThemedContext = new ContextThemeWrapper(paramActivity, 2131361880);
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
    if (this.aGj == null) {
      if (this.axJ != null)
      {
        paramDialogInterface = getArguments();
        this.axJ.onDialogNegativeAction(getTag(), paramDialogInterface);
      }
    }
    while ((this.aGj.isCancelled()) || (this.aGj.getStatus() == AsyncTask.Status.FINISHED)) {
      return;
    }
    this.aGj.cancel(false);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        return;
        Fa();
        return;
        if (this.aGj == null)
        {
          if (this.axJ != null)
          {
            paramView = getArguments();
            this.axJ.onDialogNegativeAction(getTag(), paramView);
          }
          dismiss();
          return;
        }
      } while ((this.aGj.isCancelled()) || (this.aGj.getStatus() == AsyncTask.Status.FINISHED));
      this.aGj.cancel(false);
      if (this.aGf != null)
      {
        paramView = getResources().getString(2131296803);
        this.aGf.setText(paramView);
      }
    } while (this.azu == null);
    this.azu.setEnabled(false);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mLog.dl("onCreate");
    super.onCreate(paramBundle);
    init();
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
    this.azt = ((Button)localView.findViewById(2131165412));
    if (this.azt != null) {
      this.azt.setOnClickListener(this);
    }
    this.azu = ((Button)localView.findViewById(2131165365));
    if (this.azu != null) {
      this.azu.setOnClickListener(this);
    }
    this.aGg = ((ProgressBar)localView.findViewById(2131165406));
    if (this.aGg != null) {
      this.aGg.setVisibility(4);
    }
    if (this.aGh >= 0)
    {
      String str = getResources().getString(this.aGh);
      this.aGf = ((TextView)localView.findViewById(2131165361));
      this.aGf.setText(str);
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
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    this.mLog.dl("onSaveInstanceState");
    super.onSaveInstanceState(paramBundle);
    this.mStateSaved = true;
  }
  
  public void q(Bundle paramBundle)
  {
    this.mLog.dl("onTaskCancelled");
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      Toast.makeText(localFragmentActivity, OperationStatus.avD.Ds(), 0).show();
    }
    if (this.axJ != null) {
      this.axJ.onDialogPositiveAction(getTag(), paramBundle);
    }
    dismiss();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */