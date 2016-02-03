package com.go.weatherex.f;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

class d
  implements TextWatcher
{
  d(a parama) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.length() > 0)
    {
      a.g(this.a).setVisibility(0);
      paramEditable = a.h(this.a).getText().toString().trim();
      a.i(this.a).b(paramEditable);
      return;
    }
    a.g(this.a).setVisibility(8);
    this.a.a(1);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/f/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */