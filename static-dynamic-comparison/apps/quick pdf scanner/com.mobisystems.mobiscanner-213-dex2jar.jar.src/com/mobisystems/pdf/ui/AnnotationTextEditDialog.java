package com.mobisystems.pdf.ui;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import com.mobisystems.pdf.R.id;
import com.mobisystems.pdf.R.layout;
import com.mobisystems.pdf.R.string;
import com.mobisystems.pdf.UtilsSE;
import com.mobisystems.pdf.annotation.Annotation;
import java.util.Date;

public class AnnotationTextEditDialog
  extends DialogFragment
{
  private EditText _edit;
  private String _modificationDate;
  private String _textValue;
  
  public static AnnotationTextEditDialog newInstance(Annotation paramAnnotation)
  {
    AnnotationTextEditDialog localAnnotationTextEditDialog = new AnnotationTextEditDialog();
    localAnnotationTextEditDialog._textValue = paramAnnotation.getContents();
    localAnnotationTextEditDialog._modificationDate = paramAnnotation.getModificationDate();
    return localAnnotationTextEditDialog;
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = getActivity().getLayoutInflater().inflate(R.layout.pdf_annotation_text_edit_dialog, null);
    this._edit = ((EditText)paramBundle.findViewById(R.id.annotation_text_edit));
    if (this._textValue != null)
    {
      this._edit.setText(this._textValue);
      this._edit.setSelection(this._textValue.length());
    }
    TextView localTextView = (TextView)paramBundle.findViewById(R.id.date_modified_static_text);
    if (this._modificationDate != null)
    {
      Date localDate = UtilsSE.parsePdfDateString(this._modificationDate);
      if (localDate != null) {
        localTextView.setText(android.text.format.DateFormat.getDateFormat(getActivity()).format(localDate));
      }
    }
    paramBundle = new AlertDialog.Builder(getActivity()).setTitle(R.string.pdf_edit_text).setView(paramBundle).setPositiveButton(17039370, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface = AnnotationTextEditDialog.this._edit.getText().toString();
        if ((AnnotationTextEditDialog.this._textValue == null) || (!AnnotationTextEditDialog.this._textValue.equals(paramAnonymousDialogInterface))) {
          ((AnnotationTextEditDialog.OnAnnotationTextChangedListener)AnnotationTextEditDialog.this.getActivity()).onAnnotationTextChanged(paramAnonymousDialogInterface);
        }
      }
    }).setNegativeButton(17039360, null).create();
    paramBundle.getWindow().setSoftInputMode(2);
    return paramBundle;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    super.onDismiss(paramDialogInterface);
    ((OnAnnotationTextChangedListener)getActivity()).onAnnotationTextDialogDismiss();
  }
  
  public static abstract interface OnAnnotationTextChangedListener
  {
    public abstract void onAnnotationTextChanged(String paramString);
    
    public abstract void onAnnotationTextDialogDismiss();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/ui/AnnotationTextEditDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */