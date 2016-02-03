package com.mobisystems.mobiscanner.controller;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.preference.ListPreference;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

public class TwoLinesListPreference
  extends ListPreference
{
  private String[] aGu;
  private String[] aGv;
  private int aGw;
  
  public TwoLinesListPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onDialogClosed(boolean paramBoolean)
  {
    Object localObject = getEntryValues();
    if ((paramBoolean) && (this.aGw >= 0) && (localObject != null))
    {
      localObject = localObject[this.aGw].toString();
      if (callChangeListener(localObject)) {
        setValue((String)localObject);
      }
    }
  }
  
  protected void onPrepareDialogBuilder(AlertDialog.Builder paramBuilder)
  {
    super.onPrepareDialogBuilder(paramBuilder);
    CharSequence[] arrayOfCharSequence = getEntries();
    if (arrayOfCharSequence == null) {
      throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
    }
    this.aGu = new String[arrayOfCharSequence.length];
    this.aGv = new String[arrayOfCharSequence.length];
    int i = 0;
    if (i < arrayOfCharSequence.length)
    {
      String str = arrayOfCharSequence[i].toString();
      int j = str.indexOf("(");
      if (j == -1)
      {
        this.aGu[i] = str;
        this.aGv[i] = "";
      }
      for (;;)
      {
        i += 1;
        break;
        this.aGu[i] = str.substring(0, j - 1);
        this.aGv[i] = str.substring(j);
      }
    }
    this.aGw = findIndexOfValue(getValue());
    paramBuilder.setAdapter(new ArrayAdapter(getContext(), 2130903157, this.aGu)new DialogInterface.OnClickListener
    {
      a aGx;
      
      public View getView(int paramAnonymousInt, View paramAnonymousView, ViewGroup paramAnonymousViewGroup)
      {
        paramAnonymousViewGroup = (LayoutInflater)getContext().getSystemService("layout_inflater");
        if (paramAnonymousView == null)
        {
          paramAnonymousView = paramAnonymousViewGroup.inflate(2130903157, null);
          this.aGx = new a();
          this.aGx.aGz = ((TextView)paramAnonymousView.findViewById(2131165551));
          this.aGx.aGA = ((TextView)paramAnonymousView.findViewById(2131165552));
          this.aGx.aGB = ((RadioButton)paramAnonymousView.findViewById(2131165553));
          paramAnonymousView.setTag(this.aGx);
          this.aGx.aGz.setText(TwoLinesListPreference.a(TwoLinesListPreference.this)[paramAnonymousInt]);
          this.aGx.aGA.setText(TwoLinesListPreference.b(TwoLinesListPreference.this)[paramAnonymousInt]);
          paramAnonymousViewGroup = this.aGx.aGB;
          if (paramAnonymousInt != TwoLinesListPreference.c(TwoLinesListPreference.this)) {
            break label175;
          }
        }
        label175:
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousViewGroup.setChecked(bool);
          return paramAnonymousView;
          this.aGx = ((a)paramAnonymousView.getTag());
          break;
        }
      }
      
      class a
      {
        TextView aGA;
        RadioButton aGB;
        TextView aGz;
        
        a() {}
      }
    }, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        TwoLinesListPreference.a(TwoLinesListPreference.this, paramAnonymousInt);
        TwoLinesListPreference.this.onClick(paramAnonymousDialogInterface, -1);
        paramAnonymousDialogInterface.dismiss();
      }
    });
    paramBuilder.setPositiveButton(null, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/TwoLinesListPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */