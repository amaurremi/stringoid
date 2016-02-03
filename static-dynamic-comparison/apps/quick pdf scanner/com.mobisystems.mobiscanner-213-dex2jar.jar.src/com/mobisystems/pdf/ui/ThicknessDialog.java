package com.mobisystems.pdf.ui;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.mobisystems.pdf.simpleViewer.R.id;
import com.mobisystems.pdf.simpleViewer.R.layout;
import com.mobisystems.pdf.simpleViewer.R.string;

public class ThicknessDialog
  extends DialogFragment
{
  private TextView preview;
  private SeekBar seekBar;
  private float thickness;
  
  private float getThickness()
  {
    return this.thickness;
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = getActivity().getLayoutInflater().inflate(R.layout.pdf_thickness_dialog, null);
    this.preview = ((TextView)paramBundle.findViewById(R.id.thickness_text));
    setTextViewContents();
    this.seekBar = ((SeekBar)paramBundle.findViewById(R.id.thickness_seekbar));
    this.seekBar.setProgress((int)this.thickness - 1);
    this.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
    {
      public void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        if (!paramAnonymousBoolean) {
          return;
        }
        ThicknessDialog.access$002(ThicknessDialog.this, paramAnonymousInt + 1.0F);
        ThicknessDialog.this.setTextViewContents();
      }
      
      public void onStartTrackingTouch(SeekBar paramAnonymousSeekBar) {}
      
      public void onStopTrackingTouch(SeekBar paramAnonymousSeekBar) {}
    });
    new AlertDialog.Builder(getActivity()).setTitle(R.string.pdf_edit_thickness).setView(paramBundle).setPositiveButton(17039370, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        ((ThicknessDialog.ThicknessChangedListener)ThicknessDialog.this.getActivity()).onThicknessChanged(ThicknessDialog.this.getThickness());
      }
    }).setNegativeButton(17039360, null).create();
  }
  
  public void setTextViewContents()
  {
    this.preview.setText(getActivity().getResources().getString(R.string.pdf_edit_thickness_pt, new Object[] { Integer.valueOf((int)this.thickness) }));
  }
  
  public void setThickness(float paramFloat)
  {
    this.thickness = Math.max(1.0F, paramFloat);
  }
  
  public static abstract interface ThicknessChangedListener
  {
    public abstract void onThicknessChanged(float paramFloat);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/ui/ThicknessDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */