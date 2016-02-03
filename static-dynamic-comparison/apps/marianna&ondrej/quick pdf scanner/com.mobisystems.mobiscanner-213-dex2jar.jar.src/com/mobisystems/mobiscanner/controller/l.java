package com.mobisystems.mobiscanner.controller;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.actionbarsherlock.app.SherlockDialogFragment;
import com.mobisystems.mobiscanner.common.c;
import com.mobisystems.mobiscanner.model.DocumentModel;
import com.mobisystems.mobiscanner.model.b;

public class l
  extends SherlockDialogFragment
  implements View.OnClickListener
{
  private long aAa;
  private int aAb;
  private ContextThemeWrapper azY;
  private DocumentListFragment azZ;
  private Activity mActivity;
  protected final c mLog = new c(this);
  
  private void a(bd parambd, String paramString)
  {
    this.mLog.dl("startDocumentProgressTask: action=" + paramString);
    Bundle localBundle = new Bundle();
    localBundle.putLongArray("DOCUMENTS", new long[] { this.aAa });
    parambd.setArguments(localBundle);
    parambd.show(((DocumentListActivity)this.mActivity).getSupportFragmentManager(), paramString);
  }
  
  public void a(DocumentListFragment paramDocumentListFragment)
  {
    this.azZ = paramDocumentListFragment;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    this.mLog.dl("onActivityCreated");
    super.onActivityCreated(paramBundle);
  }
  
  public void onAttach(Activity paramActivity)
  {
    this.mLog.dl("onAttach");
    super.onAttach(paramActivity);
    this.mActivity = paramActivity;
    this.azY = new ContextThemeWrapper(paramActivity, 2131361881);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131165366: 
      dismiss();
      this.azZ.gf(this.aAb);
      return;
    case 2131165367: 
      dismiss();
      a(new w(), "DOCUMENT_RENAME");
      return;
    case 2131165368: 
      dismiss();
      a(new u(), "DOCUMENT_PROPERTIES");
      return;
    }
    dismiss();
    a(new o(), "DOCUMENT_DELETE");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mLog.dl("onCreate");
    super.onCreate(paramBundle);
    setRetainInstance(true);
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    this.mLog.dl("onCreateDialog");
    this.aAa = getArguments().getLong("DOC_CONTEXT_ID", -1L);
    this.aAb = getArguments().getInt("DOC_CONTEXT_POSITION", -1);
    paramBundle = new AlertDialog.Builder(this.azY);
    paramBundle.setTitle(2131296741);
    ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from(this.azY).inflate(2130903082, null);
    if (localViewGroup != null)
    {
      int j = localViewGroup.getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = localViewGroup.getChildAt(i);
        if (localView != null) {
          localView.setOnClickListener(this);
        }
        i += 1;
      }
    }
    paramBundle.setView(localViewGroup);
    paramBundle = paramBundle.create();
    paramBundle.setCanceledOnTouchOutside(true);
    new a(paramBundle).execute(new Long[] { Long.valueOf(this.aAa) });
    return paramBundle;
  }
  
  public void onDestroyView()
  {
    this.mLog.dl("onDestroyView");
    Dialog localDialog = getDialog();
    if ((localDialog != null) && (getRetainInstance())) {
      localDialog.setDismissMessage(null);
    }
    super.onDestroyView();
  }
  
  public void onDetach()
  {
    this.mLog.dl("onDetach");
    super.onDetach();
  }
  
  private class a
    extends AsyncTask<Long, Void, b>
  {
    private Dialog mDialog;
    
    public a(Dialog paramDialog)
    {
      this.mDialog = paramDialog;
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
      this.mDialog.setTitle(paramb.getName());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */