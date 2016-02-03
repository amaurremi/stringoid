package com.android.ex.chips;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView.Validator;
import com.ideashower.readitlater.db.operation.f;

public abstract class a
  extends n
{
  private final b p = new b(this, null);
  
  public a(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setValidator(this.p);
  }
  
  public void a(f paramf)
  {
    paramf = aa.a(paramf);
    if (getWidth() == 0)
    {
      append(a(paramf, false));
      return;
    }
    append(paramf.toString() + ',');
  }
  
  public void setValidator(AutoCompleteTextView.Validator paramValidator)
  {
    this.p.a(paramValidator);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/android/ex/chips/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */