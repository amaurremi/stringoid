package com.mobisystems.mobiscanner.controller;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextPaint;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.TextView;
import com.actionbarsherlock.app.SherlockDialogFragment;
import com.mobisystems.mobiscanner.common.CameraPreferences;
import com.mobisystems.mobiscanner.common.CameraPreferences.b;
import com.mobisystems.mobiscanner.common.CameraPreferences.e;
import com.mobisystems.mobiscanner.common.CameraPreferences.g;
import com.mobisystems.mobiscanner.common.CameraPreferences.m;
import com.mobisystems.mobiscanner.common.c;

public class e
  extends SherlockDialogFragment
  implements View.OnClickListener, SeekBar.OnSeekBarChangeListener
{
  protected k axJ = null;
  protected Button azt;
  protected Button azu;
  protected ViewGroup azv;
  private final c mLog = new c(this);
  
  private void Fc()
  {
    int j = this.azv.getChildCount();
    int i = 0;
    if (i < j)
    {
      Object localObject2 = this.azv.getChildAt(i);
      Object localObject1 = ((View)localObject2).getTag();
      if (CameraPreferences.g.class.isInstance(localObject1))
      {
        localObject2 = (Spinner)((View)localObject2).findViewById(2131165525);
        ((CameraPreferences.g)localObject1).fQ(((Spinner)localObject2).getSelectedItemPosition());
      }
      for (;;)
      {
        i += 1;
        break;
        if (CameraPreferences.e.class.isInstance(localObject1))
        {
          localObject2 = (SeekBar)((View)localObject2).findViewById(2131165520);
          localObject1 = (CameraPreferences.e)localObject1;
          ((CameraPreferences.e)localObject1).fO(((SeekBar)localObject2).getProgress() + ((CameraPreferences.e)localObject1).getMinValue());
        }
        else if (CameraPreferences.b.class.isInstance(localObject1))
        {
          localObject2 = (CheckBox)((View)localObject2).findViewById(2131165516);
          ((CameraPreferences.b)localObject1).aR(((CheckBox)localObject2).isChecked());
        }
      }
    }
  }
  
  private Context Fd()
  {
    return new ContextThemeWrapper(getActivity(), 2131361880);
  }
  
  private void a(ViewGroup paramViewGroup, CameraPreferences.b paramb)
  {
    ViewGroup localViewGroup = (ViewGroup)getLayoutInflater().inflate(2130903145, paramViewGroup, false);
    localViewGroup.setTag(paramb);
    ((TextView)localViewGroup.findViewById(2131165515)).setText(getActivity().getResources().getString(paramb.Dj()));
    ((CheckBox)localViewGroup.findViewById(2131165516)).setChecked(paramb.Da());
    paramViewGroup.addView(localViewGroup);
  }
  
  private void a(ViewGroup paramViewGroup, CameraPreferences.e parame)
  {
    ViewGroup localViewGroup = (ViewGroup)getLayoutInflater().inflate(2130903146, paramViewGroup, false);
    localViewGroup.setTag(parame);
    ((TextView)localViewGroup.findViewById(2131165518)).setText(getActivity().getResources().getString(parame.Dj()));
    SeekBar localSeekBar = (SeekBar)localViewGroup.findViewById(2131165520);
    localSeekBar.setMax(parame.getMaxValue() - parame.getMinValue());
    localSeekBar.setProgress(parame.Db() - parame.getMinValue());
    ((TextView)localViewGroup.findViewById(2131165521)).setText(String.valueOf(parame.getMinValue()));
    ((TextView)localViewGroup.findViewById(2131165523)).setText(String.valueOf(parame.getMaxValue()));
    ((TextView)localViewGroup.findViewById(2131165522)).setText(String.valueOf((parame.getMaxValue() + parame.getMinValue()) / 2));
    TextView localTextView = (TextView)localViewGroup.findViewById(2131165519);
    float f1 = localTextView.getPaint().measureText(String.valueOf(parame.getMaxValue()));
    float f2 = localTextView.getPaint().measureText(String.valueOf(parame.getMinValue()));
    int i = localTextView.getPaddingLeft();
    localTextView.setWidth((int)Math.max(f1, f2) + i + localTextView.getPaddingRight());
    localTextView.setText(String.valueOf(parame.Db()));
    localSeekBar.setOnSeekBarChangeListener(this);
    localSeekBar.setTag(localTextView);
    paramViewGroup.addView(localViewGroup);
  }
  
  private void a(ViewGroup paramViewGroup, CameraPreferences.g paramg)
  {
    ViewGroup localViewGroup = (ViewGroup)getLayoutInflater().inflate(2130903147, paramViewGroup, false);
    localViewGroup.setTag(paramg);
    ((TextView)localViewGroup.findViewById(2131165524)).setText(getActivity().getResources().getString(paramg.Dj()));
    Spinner localSpinner = (Spinner)localViewGroup.findViewById(2131165525);
    ArrayAdapter localArrayAdapter = new ArrayAdapter(Fd(), 17367048, paramg.Dc());
    localArrayAdapter.setDropDownViewResource(17367049);
    localSpinner.setAdapter(localArrayAdapter);
    localSpinner.setSelection(paramg.Dd());
    paramViewGroup.addView(localViewGroup);
  }
  
  private LayoutInflater getLayoutInflater()
  {
    return LayoutInflater.from(Fd());
  }
  
  protected void Fa()
  {
    if (this.axJ != null)
    {
      Fc();
      CameraPreferences.CX();
      Bundle localBundle = getArguments();
      this.axJ.onDialogPositiveAction(getTag(), localBundle);
    }
  }
  
  protected void Fb()
  {
    if (this.axJ != null)
    {
      Bundle localBundle = getArguments();
      this.axJ.onDialogNegativeAction(getTag(), localBundle);
    }
  }
  
  protected void R(View paramView)
  {
    paramView = CameraPreferences.values();
    int j = paramView.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = paramView[i];
      CameraPreferences.m localm = ((CameraPreferences)localObject).CW();
      if ((((CameraPreferences)localObject).CV()) && (localm != null))
      {
        if (!CameraPreferences.g.class.isInstance(localm)) {
          break label69;
        }
        a(this.azv, (CameraPreferences.g)localm);
      }
      for (;;)
      {
        i += 1;
        break;
        label69:
        if (CameraPreferences.e.class.isInstance(localm)) {
          a(this.azv, (CameraPreferences.e)localm);
        } else if (CameraPreferences.b.class.isInstance(localm)) {
          a(this.azv, (CameraPreferences.b)localm);
        }
      }
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    try
    {
      this.axJ = ((k)paramActivity);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      this.mLog.A(paramActivity.toString() + " must implement DialogListener");
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    Fb();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131165412: 
      Fa();
      dismiss();
      return;
    }
    Fb();
    dismiss();
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = new AlertDialog.Builder(Fd());
    paramBundle.setTitle(getResources().getString(2131296736));
    View localView = getLayoutInflater().inflate(2130903080, null);
    this.azt = ((Button)localView.findViewById(2131165412));
    if (this.azt != null) {
      this.azt.setOnClickListener(this);
    }
    this.azu = ((Button)localView.findViewById(2131165365));
    if (this.azu != null) {
      this.azu.setOnClickListener(this);
    }
    this.azv = ((ViewGroup)localView.findViewById(2131165364));
    R(localView);
    paramBundle.setView(localView);
    return paramBundle.create();
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.axJ = null;
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ViewGroup localViewGroup = (ViewGroup)paramSeekBar.getParent();
      ((TextView)paramSeekBar.getTag()).setText(String.valueOf(((CameraPreferences.e)localViewGroup.getTag()).getMinValue() + paramInt));
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */