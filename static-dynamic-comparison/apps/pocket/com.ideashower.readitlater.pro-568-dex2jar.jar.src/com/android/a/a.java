package com.android.a;

import android.widget.AutoCompleteTextView.Validator;

public class a
  implements AutoCompleteTextView.Validator
{
  public CharSequence fixText(CharSequence paramCharSequence)
  {
    return "";
  }
  
  public boolean isValid(CharSequence paramCharSequence)
  {
    return com.android.b.a.a.d(paramCharSequence.toString()).length > 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/android/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */