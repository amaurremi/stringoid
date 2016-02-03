package com.mobisystems.mobiscanner.controller;

import android.database.Cursor;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.h;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Spinner;
import com.mobisystems.mobiscanner.common.c;
import com.mobisystems.mobiscanner.model.DocumentModel;
import com.mobisystems.mobiscanner.model.DocumentModel.DocListSortBy;
import com.mobisystems.mobiscanner.model.DocumentModel.SortOrder;
import com.mobisystems.mobiscanner.model.b;

public abstract class y
  extends bd
  implements RadioGroup.OnCheckedChangeListener
{
  protected h aBv;
  protected RadioGroup aCC;
  protected Spinner aCD;
  protected Cursor aCE;
  protected int aCF = -1;
  protected int aCG = -1;
  protected boolean mDestroyed = false;
  
  private void bb(boolean paramBoolean)
  {
    this.aCD.setEnabled(paramBoolean);
    View localView = this.aCD.getSelectedView();
    if (localView != null) {
      localView.setEnabled(paramBoolean);
    }
  }
  
  protected void Ge()
  {
    this.aCD.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
    {
      public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        y.a(y.this, false);
        y.this.aCD.setOnItemSelectedListener(null);
      }
      
      public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
    });
    this.aBv = new h(getActivity().getApplicationContext(), 17367048, null, new String[] { "doc_name" }, new int[] { 16908308 }, 0);
    this.aBv.setDropDownViewResource(17367049);
    this.aCD.setAdapter(this.aBv);
    if (this.aCE == null)
    {
      new a().execute(new Void[0]);
      return;
    }
    Cursor localCursor = this.aBv.swapCursor(this.aCE);
    if (localCursor != null) {
      localCursor.close();
    }
    this.aCD.setSelection(this.aCG);
  }
  
  protected b Gf()
  {
    switch (this.aCC.getCheckedRadioButtonId())
    {
    default: 
      return null;
    case 2131165408: 
      return new b(getArguments());
    }
    int i = this.aCD.getSelectedItemPosition();
    Cursor localCursor = this.aBv.getCursor();
    if ((localCursor != null) && (localCursor.moveToPosition(i))) {
      return new b(localCursor);
    }
    return new b();
  }
  
  protected void R(View paramView)
  {
    super.R(paramView);
    this.mLog.dl("onSetDialogView");
    this.aCD = ((Spinner)paramView.findViewById(2131165410));
    Ge();
    this.aCC = ((RadioGroup)paramView.findViewById(2131165407));
    this.aCC.setOnCheckedChangeListener(this);
    if (this.aCF < 0)
    {
      this.aCC.check(2131165408);
      return;
    }
    this.aCC.check(this.aCF);
  }
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2131165408: 
      bb(false);
      return;
    }
    if (this.aBv.getCount() == 0)
    {
      this.aCC.check(2131165408);
      return;
    }
    bb(true);
  }
  
  public void onDestroy()
  {
    this.mLog.dl("onDestroy");
    if (this.aCE != null)
    {
      this.aCE.close();
      this.aCE = null;
    }
    this.mDestroyed = true;
    super.onDestroy();
  }
  
  public void onDetach()
  {
    this.mLog.dl("onDetach");
    if ((this.aBv != null) && (this.aCD != null))
    {
      this.aCG = this.aCD.getSelectedItemPosition();
      this.aCE = this.aBv.swapCursor(null);
    }
    if (this.aCC != null) {
      this.aCF = this.aCC.getCheckedRadioButtonId();
    }
    if ((this.mDestroyed) && (this.aCE != null))
    {
      this.aCE.close();
      this.aCE = null;
    }
    this.aBv = null;
    this.aCD = null;
    this.aCC = null;
    super.onDetach();
  }
  
  protected class a
    extends AsyncTask<Void, Void, Cursor>
  {
    public a() {}
    
    public void b(Cursor paramCursor)
    {
      paramCursor = y.this.aBv.swapCursor(paramCursor);
      if (paramCursor != null) {
        paramCursor.close();
      }
      if (y.this.aBv.getCount() == 0) {
        y.this.aCC.check(2131165408);
      }
    }
    
    public Cursor e(Void... paramVarArgs)
    {
      return new DocumentModel().a("", DocumentModel.DocListSortBy.aIL, DocumentModel.SortOrder.aIQ, 0, -1);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */