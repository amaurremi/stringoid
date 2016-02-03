package com.pocket.o.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Filter;
import android.widget.ListAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class f
  extends i
  implements View.OnClickListener
{
  protected boolean a;
  private final ArrayList b = new ArrayList();
  private final ArrayList c = new ArrayList();
  private final Filter d = new h(this, null);
  private final g e = new g(this, null);
  private CharSequence f;
  private j g;
  private final TextView[] h;
  
  public f(l paraml, k paramk, Context paramContext, TextView[] paramArrayOfTextView)
  {
    super(paraml, paramk, paramContext);
    this.h = paramArrayOfTextView;
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.a == paramBoolean) {
      return;
    }
    this.a = paramBoolean;
    TextView[] arrayOfTextView = this.h;
    int k = arrayOfTextView.length;
    int i = 0;
    label27:
    TextView localTextView;
    if (i < k)
    {
      localTextView = arrayOfTextView[i];
      if (!paramBoolean) {
        break label59;
      }
    }
    label59:
    for (int j = 2131493340;; j = 2131493262)
    {
      localTextView.setText(j);
      i += 1;
      break label27;
      break;
    }
  }
  
  private void c()
  {
    if ((this.a) || (!this.b.isEmpty())) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      return;
    }
  }
  
  private void d()
  {
    this.d.filter(this.f);
  }
  
  public ListAdapter a()
  {
    return this.e;
  }
  
  public void a(j paramj)
  {
    this.g = paramj;
  }
  
  public void a(CharSequence paramCharSequence)
  {
    if (TextUtils.isEmpty(paramCharSequence)) {
      b(false);
    }
    for (;;)
    {
      this.f = paramCharSequence;
      this.d.filter(paramCharSequence);
      c();
      return;
      b(true);
    }
  }
  
  public void a(String paramString)
  {
    d();
  }
  
  protected void a(ArrayList paramArrayList)
  {
    this.b.clear();
    this.b.addAll(paramArrayList);
    this.c.clear();
    this.c.addAll(paramArrayList);
    this.d.filter(null);
    this.g.b();
    this.g = null;
    c();
  }
  
  public View b()
  {
    return null;
  }
  
  public void b(String paramString)
  {
    d();
  }
  
  public void i(boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    paramView = ((TextView)paramView).getText().toString();
    f().a(this, paramView);
    a(paramView);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/o/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */