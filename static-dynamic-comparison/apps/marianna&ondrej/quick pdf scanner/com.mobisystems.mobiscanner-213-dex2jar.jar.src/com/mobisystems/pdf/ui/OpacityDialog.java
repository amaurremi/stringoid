package com.mobisystems.pdf.ui;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.mobisystems.pdf.simpleViewer.R.id;
import com.mobisystems.pdf.simpleViewer.R.layout;
import com.mobisystems.pdf.simpleViewer.R.string;

public class OpacityDialog
  extends DialogFragment
{
  private OpacityPreviewView preview;
  private int previewColor;
  private SeekBar seekBar;
  
  private int getOpacity()
  {
    return Color.alpha(this.preview.previewedColor);
  }
  
  private void setOpacity(int paramInt)
  {
    int i = this.preview.previewedColor;
    this.preview.previewedColor = Color.argb(paramInt, Color.red(i), Color.green(i), Color.blue(i));
    this.preview.invalidate();
    this.seekBar.setProgress(paramInt);
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = getActivity().getLayoutInflater().inflate(R.layout.pdf_opacity_dialog, null);
    this.preview = ((OpacityPreviewView)paramBundle.findViewById(R.id.opacity_preview));
    this.preview.previewedColor = this.previewColor;
    this.seekBar = ((SeekBar)paramBundle.findViewById(R.id.opacity_seekbar));
    this.seekBar.setProgress(Color.alpha(this.previewColor));
    this.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
    {
      public void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        if (!paramAnonymousBoolean) {
          return;
        }
        OpacityDialog.this.setOpacity(paramAnonymousInt);
      }
      
      public void onStartTrackingTouch(SeekBar paramAnonymousSeekBar) {}
      
      public void onStopTrackingTouch(SeekBar paramAnonymousSeekBar) {}
    });
    new AlertDialog.Builder(getActivity()).setTitle(R.string.pdf_edit_opacity).setView(paramBundle).setPositiveButton(17039370, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        ((OpacityDialog.OnOpacityChangedListener)OpacityDialog.this.getActivity()).onOpacityChanged(OpacityDialog.this.getOpacity());
      }
    }).setNegativeButton(17039360, null).create();
  }
  
  public void setColor(int paramInt1, int paramInt2)
  {
    this.previewColor = Color.argb(paramInt2, Color.red(paramInt1), Color.green(paramInt1), Color.blue(paramInt1));
  }
  
  public static abstract interface OnOpacityChangedListener
  {
    public abstract void onOpacityChanged(int paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/ui/OpacityDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */