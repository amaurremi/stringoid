package com.go.weatherex.f;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

class w
  implements TextWatcher
{
  w(t paramt) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.toString().length() > 0)
    {
      t.i(this.a).setVisibility(0);
      paramEditable = t.j(this.a).getText().toString().trim();
      t.k(this.a).b(paramEditable);
      return;
    }
    t.i(this.a).setVisibility(8);
    t.a(this.a, 1);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/f/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */