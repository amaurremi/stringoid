package com.pocket.q.a;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.SparseArray;
import android.view.View;
import com.ideashower.readitlater.activity.h;
import com.ideashower.readitlater.h.d;
import com.ideashower.readitlater.h.i;

public class l
  extends a
{
  protected final d g;
  private final m i;
  private int j;
  private final String[] k;
  
  @Deprecated
  public l(h paramh, d paramd, String paramString, SparseArray paramSparseArray, m paramm, s params)
  {
    super(paramh, paramString, paramSparseArray, null, params);
    if ((paramSparseArray == null) || (paramSparseArray.size() == 0)) {
      throw new NullPointerException("summary may not be empty");
    }
    if (paramd == null) {
      throw new NullPointerException("pref may not be null");
    }
    int n = paramSparseArray.size();
    this.k = new String[n];
    int m = 0;
    while (m < n)
    {
      this.k[m] = ((String)paramSparseArray.valueAt(m));
      m += 1;
    }
    this.g = paramd;
    this.i = paramm;
    this.j = i.a(paramd);
  }
  
  public boolean a()
  {
    int m = i.a(this.g);
    if (m != this.j)
    {
      this.j = m;
      return true;
    }
    return false;
  }
  
  public boolean a(int paramInt, DialogInterface paramDialogInterface)
  {
    if ((this.i == null) || (this.i.a(paramInt, paramDialogInterface))) {}
    for (boolean bool = true;; bool = false)
    {
      if ((bool) && (paramInt != this.j))
      {
        this.j = paramInt;
        i.b().a(this.g, paramInt).a();
        this.h.g(true);
        if (this.i != null) {
          this.i.a(paramInt);
        }
      }
      return bool;
    }
  }
  
  public boolean c()
  {
    return true;
  }
  
  public int d()
  {
    return 1;
  }
  
  public String f()
  {
    if (this.e == null) {
      return null;
    }
    return (String)this.e.get(this.j);
  }
  
  public void onClick(View paramView)
  {
    new AlertDialog.Builder(this.h.m()).setTitle(this.d).setSingleChoiceItems(this.k, this.j, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        if (l.this.a(paramAnonymousInt, paramAnonymousDialogInterface)) {
          paramAnonymousDialogInterface.dismiss();
        }
      }
    }).setNegativeButton(2131492871, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.dismiss();
      }
    }).show();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/q/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */