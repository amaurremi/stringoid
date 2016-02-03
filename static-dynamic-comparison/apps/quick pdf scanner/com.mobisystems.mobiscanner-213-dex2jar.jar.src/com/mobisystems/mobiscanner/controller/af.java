package com.mobisystems.mobiscanner.controller;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;
import com.actionbarsherlock.app.SherlockFragment;
import com.mobisystems.mobiscanner.common.OperationStatus;
import com.mobisystems.mobiscanner.common.c;

public class af
  extends SherlockFragment
  implements bc<Bundle>
{
  private ai aDN = null;
  private k axJ = null;
  private final c mLog = new c(this);
  
  private void EL()
  {
    if (this.aDN == null)
    {
      this.aDN = new ai(getActivity(), this, getTag(), getArguments());
      this.aDN.execute(new Void[0]);
    }
  }
  
  private void dismiss()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.getSupportFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
    }
  }
  
  public void a(OperationStatus paramOperationStatus, Bundle paramBundle)
  {
    if (getActivity() != null)
    {
      if (!paramOperationStatus.equals(OperationStatus.avC)) {
        break label52;
      }
      this.mLog.dl("Page add finished");
    }
    for (;;)
    {
      if (this.axJ != null) {
        this.axJ.onDialogPositiveAction(getTag(), paramBundle);
      }
      dismiss();
      return;
      label52:
      this.mLog.dl("Page add failed");
      Toast.makeText(getActivity(), paramOperationStatus.Ds(), 0).show();
    }
  }
  
  public void gi(int paramInt) {}
  
  public void gj(int paramInt) {}
  
  public void gk(int paramInt) {}
  
  public void gl(int paramInt) {}
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    try
    {
      this.axJ = ((k)paramActivity);
      EL();
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
  
  public void onDetach()
  {
    super.onDetach();
    this.axJ = null;
  }
  
  public void q(Bundle paramBundle)
  {
    Toast.makeText(getActivity(), OperationStatus.avD.Ds(), 0).show();
    if (this.axJ != null) {
      this.axJ.onDialogPositiveAction(getTag(), paramBundle);
    }
    dismiss();
  }
  
  public void show(FragmentManager paramFragmentManager, String paramString)
  {
    paramFragmentManager.beginTransaction().add(this, paramString).commitAllowingStateLoss();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */