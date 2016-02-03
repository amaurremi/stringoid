package com.mobisystems.mobiscanner.controller;

import android.app.Dialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
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

public class u
  extends bd
  implements AdapterView.OnItemSelectedListener, TextView.OnEditorActionListener
{
  private long[] aAd;
  private boolean aCw = false;
  private b axZ;
  
  private void X(View paramView)
  {
    CommonPreferences.MeasurementUnits localMeasurementUnits = CommonPreferences.MeasurementUnits.de(CommonPreferences.Keys.apw.Dl());
    a(paramView, 2131165373, this.axZ.getName());
    CommonPreferences.PageSize localPageSize = this.axZ.IB();
    a(paramView, 2131165375, CommonPreferences.PageSize.a(localMeasurementUnits), localPageSize.getPosition());
    ((Spinner)paramView.findViewById(2131165375)).setOnItemSelectedListener(this);
    a(paramView, 2131165376, localMeasurementUnits);
    a(paramView, 2131165384, CommonPreferences.PageOrientation.Dq(), this.axZ.IE().getPosition());
    a(paramView, 2131165385, localMeasurementUnits);
    a(paramView, 2131165388, this.axZ.IF(), localMeasurementUnits);
    a(paramView, 2131165391, this.axZ.IG(), localMeasurementUnits);
    a(paramView, 2131165394, this.axZ.IH(), localMeasurementUnits);
    a(paramView, 2131165397, this.axZ.II(), localMeasurementUnits);
    a(paramView, 2131165399, CommonPreferences.PDFImageQuality.Dq(), this.axZ.IJ().getPosition());
    a(paramView, 2131165401, CommonPreferences.PDFImageDensity.Dq(), this.axZ.IK().getPosition());
    a(paramView, 2131165403, CommonPreferences.OCRLanguage.Dq(), this.axZ.IQ().getPosition());
    ((Spinner)paramView.findViewById(2131165403)).setOnItemSelectedListener(this);
    a(paramView, 2131165405, CommonPreferences.OCRLanguage.Dq(), this.axZ.IR().getPosition());
    ((Spinner)paramView.findViewById(2131165405)).setOnItemSelectedListener(this);
  }
  
  private boolean Y(View paramView)
  {
    boolean bool1 = true;
    paramView = Z(paramView);
    if (paramView.getName().length() == 0)
    {
      Toast.makeText(getActivity(), OperationStatus.avV.Ds(), 0).show();
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (bool1)
    {
      CommonPreferences.PageSize localPageSize = paramView.IB();
      bool2 = bool1;
      if (localPageSize != CommonPreferences.PageSize.aui)
      {
        float f3 = paramView.IF();
        float f4 = paramView.IG();
        float f5 = paramView.IH();
        float f6 = paramView.II();
        float f2;
        if (paramView.IB() == CommonPreferences.PageSize.auj) {
          f2 = paramView.IC();
        }
        for (float f1 = paramView.ID();; f1 = localPageSize.getHeight())
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
  
  private b Z(View paramView)
  {
    CommonPreferences.MeasurementUnits localMeasurementUnits = CommonPreferences.MeasurementUnits.de(CommonPreferences.Keys.apw.Dl());
    b localb = new b();
    localb.setName(((EditText)paramView.findViewById(2131165373)).getText().toString());
    localb.b(CommonPreferences.PageSize.ga(((Spinner)paramView.findViewById(2131165375)).getSelectedItemPosition()));
    if (localb.IB() == CommonPreferences.PageSize.auj)
    {
      localb.E(CommonPreferences.MeasurementUnits.b(Float.parseFloat(((EditText)paramView.findViewById(2131165379)).getText().toString()), localMeasurementUnits));
      localb.F(CommonPreferences.MeasurementUnits.b(Float.parseFloat(((EditText)paramView.findViewById(2131165382)).getText().toString()), localMeasurementUnits));
    }
    for (;;)
    {
      localb.a(CommonPreferences.PageOrientation.fY(((Spinner)paramView.findViewById(2131165384)).getSelectedItemPosition()));
      localb.G(CommonPreferences.MeasurementUnits.b(Float.parseFloat(((EditText)paramView.findViewById(2131165388)).getText().toString()), localMeasurementUnits));
      localb.H(CommonPreferences.MeasurementUnits.b(Float.parseFloat(((EditText)paramView.findViewById(2131165391)).getText().toString()), localMeasurementUnits));
      localb.I(CommonPreferences.MeasurementUnits.b(Float.parseFloat(((EditText)paramView.findViewById(2131165394)).getText().toString()), localMeasurementUnits));
      localb.J(CommonPreferences.MeasurementUnits.b(Float.parseFloat(((EditText)paramView.findViewById(2131165397)).getText().toString()), localMeasurementUnits));
      localb.a(CommonPreferences.PDFImageQuality.fW(((Spinner)paramView.findViewById(2131165399)).getSelectedItemPosition()));
      localb.a(CommonPreferences.PDFImageDensity.fU(((Spinner)paramView.findViewById(2131165401)).getSelectedItemPosition()));
      localb.a(CommonPreferences.OCRLanguage.fS(((Spinner)paramView.findViewById(2131165403)).getSelectedItemPosition()));
      localb.b(CommonPreferences.OCRLanguage.fS(((Spinner)paramView.findViewById(2131165405)).getSelectedItemPosition()));
      return localb;
      localb.E(0.0F);
      localb.F(0.0F);
    }
  }
  
  private void a(View paramView, int paramInt, float paramFloat, CommonPreferences.MeasurementUnits paramMeasurementUnits)
  {
    a(paramView, paramInt, CommonPreferences.MeasurementUnits.z(CommonPreferences.MeasurementUnits.a(paramFloat, paramMeasurementUnits)));
  }
  
  private void a(View paramView, int paramInt, CommonPreferences.MeasurementUnits paramMeasurementUnits)
  {
    paramView = (TextView)paramView.findViewById(paramInt);
    String str = paramView.getText().toString();
    paramView.setText(str + " (" + paramMeasurementUnits.Do() + ")");
  }
  
  private void a(View paramView, int paramInt, String paramString)
  {
    paramView = (EditText)paramView.findViewById(paramInt);
    paramView.setText(paramString);
    paramView.setOnEditorActionListener(this);
    paramView.setEnabled(true);
  }
  
  private void a(View paramView, int paramInt1, String[] paramArrayOfString, int paramInt2)
  {
    paramView = (Spinner)paramView.findViewById(paramInt1);
    ArrayAdapter localArrayAdapter = new ArrayAdapter(this.mThemedContext, 17367048);
    int i = paramArrayOfString.length;
    paramInt1 = 0;
    while (paramInt1 < i)
    {
      localArrayAdapter.add(paramArrayOfString[paramInt1]);
      paramInt1 += 1;
    }
    localArrayAdapter.setDropDownViewResource(17367049);
    paramView.setAdapter(localArrayAdapter);
    paramView.setSelection(paramInt2);
  }
  
  private void a(Spinner paramSpinner, boolean paramBoolean)
  {
    paramSpinner.setEnabled(paramBoolean);
    paramSpinner = paramSpinner.getSelectedView();
    if (paramSpinner != null) {
      paramSpinner.setEnabled(paramBoolean);
    }
  }
  
  private void c(b paramb)
  {
    if (this.aGj == null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putLongArray("DOCUMENTS", this.aAd);
      paramb.p(localBundle);
      this.aGj = new v(getActivity(), this, getTag(), localBundle, this.aCw);
      this.aGj.execute(new Void[0]);
    }
  }
  
  private void j(View paramView, int paramInt)
  {
    paramView = (EditText)paramView.findViewById(paramInt);
    paramView.setText("");
    paramView.setEnabled(false);
  }
  
  protected void Fa()
  {
    View localView = getDialog().getWindow().getDecorView();
    if (Y(localView))
    {
      super.Fa();
      c(Z(localView));
    }
  }
  
  protected void L(int paramInt1, int paramInt2) {}
  
  protected void R(View paramView)
  {
    super.R(paramView);
    this.aAd = getArguments().getLongArray("DOCUMENTS");
    new a(paramView).execute(new Long[] { Long.valueOf(this.aAd[0]) });
  }
  
  protected void S(View paramView)
  {
    super.S(paramView);
    this.aGg.setIndeterminate(true);
    this.azu.setEnabled(false);
  }
  
  protected void init()
  {
    this.mDialogResId = 2130903086;
    this.app = 2131296713;
    this.aGh = -1;
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramAdapterView.getId() == 2131165375)
    {
      paramView = CommonPreferences.PageSize.ga(paramInt);
      if (paramView == CommonPreferences.PageSize.auj)
      {
        localMeasurementUnits = CommonPreferences.MeasurementUnits.de(CommonPreferences.Keys.apw.Dl());
        a(paramAdapterView.getRootView(), 2131165379, this.axZ.IC(), localMeasurementUnits);
        a(paramAdapterView.getRootView(), 2131165382, this.axZ.ID(), localMeasurementUnits);
        if (paramView != CommonPreferences.PageSize.aui) {
          break label130;
        }
        paramAdapterView = (Spinner)paramAdapterView.getRootView().findViewById(2131165384);
        paramAdapterView.setSelection(CommonPreferences.PageOrientation.aud.getPosition());
        a(paramAdapterView, false);
      }
    }
    label130:
    while ((paramAdapterView.getId() != 2131165403) && (paramAdapterView.getId() != 2131165405))
    {
      for (;;)
      {
        CommonPreferences.MeasurementUnits localMeasurementUnits;
        return;
        j(paramAdapterView.getRootView(), 2131165379);
        j(paramAdapterView.getRootView(), 2131165382);
      }
      a((Spinner)paramAdapterView.getRootView().findViewById(2131165384), true);
      return;
    }
    this.aCw = true;
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
  
  private class a
    extends AsyncTask<Long, Void, b>
  {
    private View aCx;
    
    public a(View paramView)
    {
      this.aCx = paramView;
    }
    
    public b a(Long... paramVarArgs)
    {
      long l = paramVarArgs[0].longValue();
      b localb = new DocumentModel().ae(l);
      paramVarArgs = localb;
      if (localb == null) {
        paramVarArgs = new b();
      }
      return paramVarArgs;
    }
    
    public void b(b paramb)
    {
      u.a(u.this, paramb);
      u.a(u.this, this.aCx);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */