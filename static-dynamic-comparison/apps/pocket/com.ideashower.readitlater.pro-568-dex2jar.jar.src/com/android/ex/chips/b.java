package com.android.ex.chips;

import android.widget.AutoCompleteTextView.Validator;

class b
  implements AutoCompleteTextView.Validator
{
  private AutoCompleteTextView.Validator b = null;
  
  private b(a parama) {}
  
  public void a(AutoCompleteTextView.Validator paramValidator)
  {
    this.b = paramValidator;
  }
  
  public CharSequence fixText(CharSequence paramCharSequence)
  {
    return paramCharSequence;
  }
  
  public boolean isValid(CharSequence paramCharSequence)
  {
    if (this.b != null) {
      return this.b.isValid(paramCharSequence);
    }
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/android/ex/chips/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */