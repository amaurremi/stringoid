package com.mobisystems.pdf.ui;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import com.mobisystems.pdf.simpleViewer.R.id;
import com.mobisystems.pdf.simpleViewer.R.layout;
import com.mobisystems.pdf.simpleViewer.R.string;

public class EnterPasswordDialog
  extends DialogFragment
{
  EditText _edit;
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    getActivity().finish();
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = getActivity().getLayoutInflater().inflate(R.layout.pdf_enter_password_dialog, null);
    this._edit = ((EditText)paramBundle.findViewById(R.id.password_edit));
    new AlertDialog.Builder(getActivity()).setTitle(R.string.pdf_enter_password).setView(paramBundle).setPositiveButton(17039370, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        ((EnterPasswordDialog.SetPasswordActivity)EnterPasswordDialog.this.getActivity()).setPassword(EnterPasswordDialog.this._edit.getText().toString());
      }
    }).setNegativeButton(17039360, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.cancel();
      }
    }).create();
  }
  
  static abstract interface SetPasswordActivity
  {
    public abstract void setPassword(String paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/ui/EnterPasswordDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */