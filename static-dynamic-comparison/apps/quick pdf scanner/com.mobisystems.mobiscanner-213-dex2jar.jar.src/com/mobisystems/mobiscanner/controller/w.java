package com.mobisystems.mobiscanner.controller;

import android.app.Activity;
import android.app.Dialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.mobisystems.mobiscanner.common.OperationStatus;
import com.mobisystems.mobiscanner.model.DocumentModel;
import com.mobisystems.mobiscanner.model.b;

public class w
  extends bd
  implements AdapterView.OnItemSelectedListener, TextView.OnEditorActionListener
{
  private long[] aAd;
  
  private boolean Y(View paramView)
  {
    if (aa(paramView).length() == 0)
    {
      Toast.makeText(getActivity(), OperationStatus.avV.Ds(), 0).show();
      return false;
    }
    return true;
  }
  
  private void a(View paramView, int paramInt, String paramString)
  {
    paramView = (EditText)paramView.findViewById(paramInt);
    paramView.setText(paramString);
    paramView.setOnEditorActionListener(this);
    paramView.setEnabled(true);
    if (paramView.requestFocus()) {
      ((InputMethodManager)getActivity().getSystemService("input_method")).showSoftInput(paramView, 1);
    }
  }
  
  private String aa(View paramView)
  {
    return ((EditText)paramView.findViewById(2131165373)).getText().toString();
  }
  
  private void b(View paramView, String paramString)
  {
    a(paramView, 2131165373, paramString);
  }
  
  private void dE(String paramString)
  {
    if (this.aGj == null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("DOC_NEW_NAME", paramString);
      localBundle.putLong("DOC_CONTEXT_ID", this.aAd[0]);
      this.aGj = new x(getActivity(), this, getTag(), localBundle);
      this.aGj.execute(new Void[0]);
    }
  }
  
  protected void Fa()
  {
    View localView = getDialog().getWindow().getDecorView();
    if (Y(localView))
    {
      super.Fa();
      dE(aa(localView));
    }
  }
  
  protected void L(int paramInt1, int paramInt2) {}
  
  protected void R(View paramView)
  {
    super.R(paramView);
    this.aAd = getArguments().getLongArray("DOCUMENTS");
    final EditText localEditText = (EditText)paramView.findViewById(2131165373);
    localEditText.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          ((InputMethodManager)w.this.getActivity().getSystemService("input_method")).showSoftInput(localEditText, 1);
        }
      }
    });
    new a(paramView).execute(new Long[] { Long.valueOf(this.aAd[0]) });
  }
  
  protected void init()
  {
    this.mDialogResId = 2130903087;
    this.app = 2131296743;
    this.aGh = -1;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.mThemedContext = paramActivity;
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (6 == paramInt)
    {
      Fa();
      return true;
    }
    return false;
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
  
  private class a
    extends AsyncTask<Long, Void, String>
  {
    private View aCx;
    
    public a(View paramView)
    {
      this.aCx = paramView;
    }
    
    public String b(Long... paramVarArgs)
    {
      long l = paramVarArgs[0].longValue();
      b localb = new DocumentModel().ae(l);
      paramVarArgs = localb;
      if (localb == null) {
        paramVarArgs = new b();
      }
      return paramVarArgs.getName();
    }
    
    public void dF(String paramString)
    {
      w.a(w.this, this.aCx, paramString);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */