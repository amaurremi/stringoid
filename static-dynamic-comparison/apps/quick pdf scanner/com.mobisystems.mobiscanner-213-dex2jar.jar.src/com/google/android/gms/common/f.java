package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import com.google.android.gms.internal.dc;

public class f
  extends DialogFragment
{
  private Dialog mDialog = null;
  private DialogInterface.OnCancelListener qy = null;
  
  public static f b(Dialog paramDialog, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    f localf = new f();
    paramDialog = (Dialog)dc.e(paramDialog, "Cannot display null dialog");
    paramDialog.setOnCancelListener(null);
    paramDialog.setOnDismissListener(null);
    localf.mDialog = paramDialog;
    if (paramOnCancelListener != null) {
      localf.qy = paramOnCancelListener;
    }
    return localf;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.qy != null) {
      this.qy.onCancel(paramDialogInterface);
    }
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    return this.mDialog;
  }
  
  public void show(FragmentManager paramFragmentManager, String paramString)
  {
    super.show(paramFragmentManager, paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/common/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */