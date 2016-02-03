package com.mobisystems.mobiscanner.controller;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.actionbarsherlock.app.SherlockDialogFragment;
import com.mobisystems.mobiscanner.common.d;
import com.mobisystems.mobiscanner.model.DocumentModel;

public class ak
  extends SherlockDialogFragment
  implements View.OnClickListener
{
  private long aAa;
  private au aDU;
  private int aDV;
  private long axO;
  private Activity mActivity;
  protected final com.mobisystems.mobiscanner.common.c mLog = new com.mobisystems.mobiscanner.common.c(this);
  
  private void b(bd parambd, String paramString)
  {
    long[] arrayOfLong = new long[1];
    arrayOfLong[0] = this.axO;
    if ((arrayOfLong != null) && (arrayOfLong.length > 0))
    {
      this.mLog.dl("startPageProgressTask: action=" + paramString + ", number of selected positions=" + arrayOfLong.length);
      Bundle localBundle = new Bundle();
      localBundle.putLong("doc_id", this.aAa);
      localBundle.putLongArray("PAGES", arrayOfLong);
      parambd.setArguments(localBundle);
      parambd.show(((PageGridActivity)this.mActivity).getSupportFragmentManager(), paramString);
    }
  }
  
  public void a(au paramau)
  {
    this.aDU = paramau;
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
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131165420: 
      dismiss();
      this.aDU.gf(this.aDV);
      return;
    case 2131165421: 
      dismiss();
      b(new as(), "PAGE_SHARE");
      return;
    case 2131165422: 
      dismiss();
      b(new as(), "PAGE_EXPORT_FOR_EDIT");
      return;
    case 2131165423: 
      dismiss();
      b(new ay(), "PAGE_RESET");
      return;
    case 2131165424: 
      dismiss();
      this.aDU.ab(this.axO);
      return;
    case 2131165425: 
      dismiss();
      b(new aw(), "PAGE_PROPERTIES");
      return;
    }
    dismiss();
    b(new an(), "PAGE_DELETE");
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
    this.aAa = getArguments().getLong("doc_id", -1L);
    this.axO = getArguments().getLong("PAGE_CONTEXT_ID", -1L);
    this.aDV = getArguments().getInt("PAGE_CONTEXT_POSITION", -1);
    paramBundle = new AlertDialog.Builder(this.mActivity);
    paramBundle.setTitle(2131296742);
    ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from(this.mActivity).inflate(2130903098, null);
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
    if (d.DE()) {
      localViewGroup.findViewById(2131165422).setVisibility(8);
    }
    paramBundle.setView(localViewGroup);
    new a(localViewGroup.findViewById(2131165423)).execute(new Long[] { Long.valueOf(this.axO) });
    paramBundle = paramBundle.create();
    paramBundle.setCanceledOnTouchOutside(true);
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
    extends AsyncTask<Long, Void, com.mobisystems.mobiscanner.model.c>
  {
    private View mView;
    
    public a(View paramView)
    {
      this.mView = paramView;
    }
    
    public void b(com.mobisystems.mobiscanner.model.c paramc)
    {
      if (paramc.Jc() != -1L) {}
      for (boolean bool = true;; bool = false)
      {
        this.mView.setEnabled(bool);
        return;
      }
    }
    
    public com.mobisystems.mobiscanner.model.c c(Long... paramVarArgs)
    {
      long l = paramVarArgs[0].longValue();
      com.mobisystems.mobiscanner.model.c localc = new DocumentModel().aj(l);
      paramVarArgs = localc;
      if (localc == null) {
        paramVarArgs = new com.mobisystems.mobiscanner.model.c();
      }
      return paramVarArgs;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */