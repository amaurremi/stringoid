package com.mobisystems.mobiscanner.controller;

import android.app.Dialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.mobisystems.mobiscanner.common.CommonPreferences.Keys;
import com.mobisystems.mobiscanner.common.CommonPreferences.MeasurementUnits;
import com.mobisystems.mobiscanner.common.CommonPreferences.OCRLanguage;
import com.mobisystems.mobiscanner.common.CommonPreferences.PDFImageDensity;
import com.mobisystems.mobiscanner.common.CommonPreferences.PDFImageQuality;
import com.mobisystems.mobiscanner.common.CommonPreferences.PageOrientation;
import com.mobisystems.mobiscanner.common.CommonPreferences.PageSize;
import com.mobisystems.mobiscanner.common.OperationStatus;
import com.mobisystems.mobiscanner.model.DocumentModel;
import com.mobisystems.mobiscanner.model.b;
import com.mobisystems.mobiscanner.model.c;

public class aw
  extends bd
  implements AdapterView.OnItemSelectedListener, CompoundButton.OnCheckedChangeListener, TextView.OnEditorActionListener
{
  private long[] aDR;
  private c aEr;
  private boolean aFT = false;
  private b axZ;
  
  private void HC()
  {
    this.aEr.c(this.axZ.IB());
    this.aEr.n(this.axZ.IC());
    this.aEr.K(this.axZ.ID());
    this.aEr.b(this.axZ.IE());
    this.aEr.L(this.axZ.IF());
    this.aEr.M(this.axZ.IG());
    this.aEr.N(this.axZ.IH());
    this.aEr.O(this.axZ.II());
    this.aEr.a(this.axZ.IJ());
    this.aEr.a(this.axZ.IK());
    this.aEr.c(this.axZ.IQ());
    this.aEr.d(this.axZ.IR());
  }
  
  private void X(View paramView)
  {
    Object localObject = CommonPreferences.MeasurementUnits.de(CommonPreferences.Keys.apw.Dl());
    a(paramView, 2131165376, (CommonPreferences.MeasurementUnits)localObject);
    a(paramView, 2131165385, (CommonPreferences.MeasurementUnits)localObject);
    a(paramView, 2131165375, CommonPreferences.PageSize.a((CommonPreferences.MeasurementUnits)localObject));
    a(paramView, 2131165384, CommonPreferences.PageOrientation.Dq());
    a(paramView, 2131165399, CommonPreferences.PDFImageQuality.Dq());
    a(paramView, 2131165401, CommonPreferences.PDFImageDensity.Dq());
    a(paramView, 2131165403, CommonPreferences.OCRLanguage.Dq());
    a(paramView, 2131165405, CommonPreferences.OCRLanguage.Dq());
    localObject = this.aEr.IV();
    paramView = (CheckBox)paramView.findViewById(2131165429);
    if (localObject == CommonPreferences.PageSize.auh)
    {
      HC();
      paramView.setChecked(true);
      onCheckedChanged(paramView, true);
    }
    for (;;)
    {
      paramView.setOnCheckedChangeListener(this);
      paramView.setFocusable(true);
      paramView.setFocusableInTouchMode(true);
      paramView.requestFocus();
      return;
      paramView.setChecked(false);
      onCheckedChanged(paramView, false);
    }
  }
  
  private boolean Y(View paramView)
  {
    boolean bool3 = true;
    boolean bool1 = true;
    paramView = ab(paramView);
    CommonPreferences.PageSize localPageSize = paramView.IV();
    boolean bool2 = bool3;
    if (localPageSize != CommonPreferences.PageSize.auh)
    {
      bool2 = bool3;
      if (localPageSize != CommonPreferences.PageSize.aui)
      {
        float f3 = paramView.IX();
        float f4 = paramView.IY();
        float f5 = paramView.IZ();
        float f6 = paramView.Ja();
        float f2;
        if (paramView.IV() == CommonPreferences.PageSize.auj) {
          f2 = paramView.getWidth();
        }
        for (float f1 = paramView.getHeight();; f1 = localPageSize.getHeight())
        {
          if (f4 + f3 >= f2)
          {
            Toast.makeText(getActivity(), OperationStatus.avW.Ds(), 0).show();
            bool1 = false;
          }
          bool2 = bool1;
          if (!bool1) {
            break;
          }
          bool2 = bool1;
          if (f6 + f5 < f1) {
            break;
          }
          Toast.makeText(getActivity(), OperationStatus.avX.Ds(), 0).show();
          return false;
          f2 = localPageSize.getWidth();
        }
      }
    }
    return bool2;
  }
  
  private void a(View paramView, int paramInt, float paramFloat, CommonPreferences.MeasurementUnits paramMeasurementUnits, boolean paramBoolean)
  {
    a(paramView, paramInt, CommonPreferences.MeasurementUnits.z(CommonPreferences.MeasurementUnits.a(paramFloat, paramMeasurementUnits)), paramBoolean);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramView = (Spinner)paramView.findViewById(paramInt1);
    if (paramInt2 >= 0) {
      paramView.setSelection(paramInt2);
    }
    a(paramView, paramBoolean);
  }
  
  private void a(View paramView, int paramInt, CommonPreferences.MeasurementUnits paramMeasurementUnits)
  {
    paramView = (TextView)paramView.findViewById(paramInt);
    String str = paramView.getText().toString();
    paramView.setText(str + " (" + paramMeasurementUnits.Do() + ")");
  }
  
  private void a(View paramView, int paramInt, String paramString, boolean paramBoolean)
  {
    paramView = (EditText)paramView.findViewById(paramInt);
    paramView.setText(paramString);
    paramView.setOnEditorActionListener(this);
    paramView.setEnabled(paramBoolean);
  }
  
  private void a(View paramView, int paramInt, String[] paramArrayOfString)
  {
    paramView = (Spinner)paramView.findViewById(paramInt);
    ArrayAdapter localArrayAdapter = new ArrayAdapter(this.mThemedContext, 17367048);
    int i = paramArrayOfString.length;
    paramInt = 0;
    while (paramInt < i)
    {
      localArrayAdapter.add(paramArrayOfString[paramInt]);
      paramInt += 1;
    }
    localArrayAdapter.setDropDownViewResource(17367049);
    paramView.setAdapter(localArrayAdapter);
    a(paramView, true);
    paramView.setOnItemSelectedListener(this);
  }
  
  private void a(Spinner paramSpinner, boolean paramBoolean)
  {
    paramSpinner.setEnabled(paramBoolean);
    paramSpinner = paramSpinner.getSelectedView();
    if (paramSpinner != null) {
      paramSpinner.setEnabled(paramBoolean);
    }
  }
  
  private c ab(View paramView)
  {
    CommonPreferences.MeasurementUnits localMeasurementUnits = CommonPreferences.MeasurementUnits.de(CommonPreferences.Keys.apw.Dl());
    c localc = new c();
    if (!((CheckBox)paramView.findViewById(2131165429)).isChecked())
    {
      localc.c(CommonPreferences.PageSize.ga(((Spinner)paramView.findViewById(2131165375)).getSelectedItemPosition()));
      if (localc.IV() == CommonPreferences.PageSize.auj)
      {
        localc.n(CommonPreferences.MeasurementUnits.b(Float.parseFloat(((EditText)paramView.findViewById(2131165379)).getText().toString()), localMeasurementUnits));
        localc.K(CommonPreferences.MeasurementUnits.b(Float.parseFloat(((EditText)paramView.findViewById(2131165382)).getText().toString()), localMeasurementUnits));
      }
      localc.b(CommonPreferences.PageOrientation.fY(((Spinner)paramView.findViewById(2131165384)).getSelectedItemPosition()));
      localc.L(CommonPreferences.MeasurementUnits.b(Float.parseFloat(((EditText)paramView.findViewById(2131165388)).getText().toString()), localMeasurementUnits));
      localc.M(CommonPreferences.MeasurementUnits.b(Float.parseFloat(((EditText)paramView.findViewById(2131165391)).getText().toString()), localMeasurementUnits));
      localc.N(CommonPreferences.MeasurementUnits.b(Float.parseFloat(((EditText)paramView.findViewById(2131165394)).getText().toString()), localMeasurementUnits));
      localc.O(CommonPreferences.MeasurementUnits.b(Float.parseFloat(((EditText)paramView.findViewById(2131165397)).getText().toString()), localMeasurementUnits));
      localc.a(CommonPreferences.PDFImageQuality.fW(((Spinner)paramView.findViewById(2131165399)).getSelectedItemPosition()));
      localc.a(CommonPreferences.PDFImageDensity.fU(((Spinner)paramView.findViewById(2131165401)).getSelectedItemPosition()));
      localc.c(CommonPreferences.OCRLanguage.fS(((Spinner)paramView.findViewById(2131165403)).getSelectedItemPosition()));
      localc.d(CommonPreferences.OCRLanguage.fS(((Spinner)paramView.findViewById(2131165405)).getSelectedItemPosition()));
    }
    return localc;
  }
  
  private void e(c paramc)
  {
    if (this.aGj == null)
    {
      Bundle localBundle = new Bundle();
      paramc.p(localBundle);
      localBundle.putLongArray("PAGES", this.aDR);
      localBundle.putLong("OLD_DOC_ID", this.axZ.getId());
      this.aGj = new ax(getActivity(), this, getTag(), localBundle);
      this.aGj.execute(new Void[0]);
    }
  }
  
  protected void Fa()
  {
    Object localObject = getDialog().getWindow().getDecorView();
    if (Y((View)localObject))
    {
      super.Fa();
      localObject = ab((View)localObject);
      if (this.aFT) {
        ((c)localObject).gz(-1);
      }
      e((c)localObject);
    }
  }
  
  protected void L(int paramInt1, int paramInt2) {}
  
  protected void R(View paramView)
  {
    super.R(paramView);
    Bundle localBundle = getArguments();
    this.axZ = new b(localBundle);
    this.aDR = localBundle.getLongArray("PAGES");
    this.aEr = new c();
    new a(paramView).execute(new Long[] { Long.valueOf(this.aDR[0]) });
  }
  
  protected void S(View paramView)
  {
    super.S(paramView);
    this.aGg.setIndeterminate(true);
    this.azu.setEnabled(false);
  }
  
  protected void init()
  {
    this.mDialogResId = 2130903103;
    this.app = 2131296722;
    this.aGh = -1;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool2 = true;
    int i;
    boolean bool1;
    if (paramCompoundButton.getId() == 2131165429)
    {
      CommonPreferences.MeasurementUnits localMeasurementUnits = CommonPreferences.MeasurementUnits.de(CommonPreferences.Keys.apw.Dl());
      if (paramBoolean) {
        HC();
      }
      paramCompoundButton = (ViewGroup)paramCompoundButton.getParent();
      i = this.aEr.IV().getPosition();
      if (paramBoolean) {
        break label334;
      }
      bool1 = true;
      a(paramCompoundButton, 2131165375, i, bool1);
      i = this.aEr.IW().getPosition();
      if (paramBoolean) {
        break label340;
      }
      bool1 = true;
      label91:
      a(paramCompoundButton, 2131165384, i, bool1);
      float f = this.aEr.IX();
      if (paramBoolean) {
        break label346;
      }
      bool1 = true;
      label117:
      a(paramCompoundButton, 2131165388, f, localMeasurementUnits, bool1);
      f = this.aEr.IY();
      if (paramBoolean) {
        break label352;
      }
      bool1 = true;
      label145:
      a(paramCompoundButton, 2131165391, f, localMeasurementUnits, bool1);
      f = this.aEr.IZ();
      if (paramBoolean) {
        break label358;
      }
      bool1 = true;
      label173:
      a(paramCompoundButton, 2131165394, f, localMeasurementUnits, bool1);
      f = this.aEr.Ja();
      if (paramBoolean) {
        break label364;
      }
      bool1 = true;
      label201:
      a(paramCompoundButton, 2131165397, f, localMeasurementUnits, bool1);
      i = this.aEr.IJ().getPosition();
      if (paramBoolean) {
        break label370;
      }
      bool1 = true;
      label233:
      a(paramCompoundButton, 2131165399, i, bool1);
      i = this.aEr.IK().getPosition();
      if (paramBoolean) {
        break label376;
      }
      bool1 = true;
      label263:
      a(paramCompoundButton, 2131165401, i, bool1);
      i = this.aEr.Jt().getPosition();
      if (paramBoolean) {
        break label382;
      }
      bool1 = true;
      label293:
      a(paramCompoundButton, 2131165403, i, bool1);
      i = this.aEr.Ju().getPosition();
      if (paramBoolean) {
        break label388;
      }
    }
    label334:
    label340:
    label346:
    label352:
    label358:
    label364:
    label370:
    label376:
    label382:
    label388:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      a(paramCompoundButton, 2131165405, i, paramBoolean);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label91;
      bool1 = false;
      break label117;
      bool1 = false;
      break label145;
      bool1 = false;
      break label173;
      bool1 = false;
      break label201;
      bool1 = false;
      break label233;
      bool1 = false;
      break label263;
      bool1 = false;
      break label293;
    }
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView = (CheckBox)paramAdapterView.getRootView().findViewById(2131165429);
    Object localObject;
    if (paramAdapterView.getId() == 2131165375)
    {
      localObject = CommonPreferences.PageSize.ga(paramInt);
      if (localObject == CommonPreferences.PageSize.auj)
      {
        CommonPreferences.MeasurementUnits localMeasurementUnits = CommonPreferences.MeasurementUnits.de(CommonPreferences.Keys.apw.Dl());
        View localView = paramAdapterView.getRootView();
        float f = this.aEr.getWidth();
        if (!paramView.isChecked())
        {
          bool = true;
          a(localView, 2131165379, f, localMeasurementUnits, bool);
          localView = paramAdapterView.getRootView();
          f = this.aEr.getHeight();
          if (paramView.isChecked()) {
            break label188;
          }
          bool = true;
          label112:
          a(localView, 2131165382, f, localMeasurementUnits, bool);
          label127:
          if (localObject != CommonPreferences.PageSize.aui) {
            break label227;
          }
          a(paramAdapterView.getRootView(), 2131165384, CommonPreferences.PageOrientation.aud.getPosition(), false);
          label152:
          if ((paramAdapterView instanceof Spinner))
          {
            paramAdapterView = (Spinner)paramAdapterView;
            if (paramView.isChecked()) {
              break label289;
            }
          }
        }
      }
    }
    label188:
    label227:
    label289:
    for (boolean bool = true;; bool = false)
    {
      a(paramAdapterView, bool);
      return;
      bool = false;
      break;
      bool = false;
      break label112;
      a(paramAdapterView.getRootView(), 2131165379, "", false);
      a(paramAdapterView.getRootView(), 2131165382, "", false);
      break label127;
      localObject = paramAdapterView.getRootView();
      if (!paramView.isChecked()) {}
      for (bool = true;; bool = false)
      {
        a((View)localObject, 2131165384, -1, bool);
        break;
      }
      if ((paramAdapterView.getId() != 2131165403) && (paramAdapterView.getId() != 2131165405)) {
        break label152;
      }
      this.aFT = true;
      break label152;
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
  
  public void onStart()
  {
    super.onStart();
  }
  
  private class a
    extends AsyncTask<Long, Void, c>
  {
    private View aCx;
    
    public a(View paramView)
    {
      this.aCx = paramView;
    }
    
    public void b(c paramc)
    {
      aw.a(aw.this, paramc);
      aw.a(aw.this, this.aCx);
    }
    
    public c c(Long... paramVarArgs)
    {
      long l = paramVarArgs[0].longValue();
      c localc = new DocumentModel().aj(l);
      paramVarArgs = localc;
      if (localc == null) {
        paramVarArgs = new c();
      }
      return paramVarArgs;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */