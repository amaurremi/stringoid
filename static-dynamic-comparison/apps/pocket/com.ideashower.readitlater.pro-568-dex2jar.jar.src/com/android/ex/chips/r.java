package com.android.ex.chips;

import android.text.Editable;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.AutoCompleteTextView.Validator;
import android.widget.MultiAutoCompleteTextView.Tokenizer;

class r
  implements TextWatcher
{
  private r(n paramn) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    int i = 0;
    int j;
    if (TextUtils.isEmpty(paramEditable))
    {
      paramEditable = this.a.getSpannable();
      z[] arrayOfz = (z[])paramEditable.getSpans(0, this.a.getText().length(), z.class);
      j = arrayOfz.length;
      while (i < j)
      {
        paramEditable.removeSpan(arrayOfz[i]);
        i += 1;
      }
      if (n.c(this.a) != null) {
        paramEditable.removeSpan(n.c(this.a));
      }
    }
    label92:
    label242:
    label253:
    do
    {
      do
      {
        do
        {
          break label92;
          do
          {
            return;
          } while (n.d(this.a));
          if ((this.a.f != null) && (this.a.f.c() != -1L))
          {
            this.a.setCursorVisible(true);
            this.a.setSelection(this.a.getText().length());
            n.e(this.a);
          }
        } while (paramEditable.length() <= 1);
        if (this.a.getSelectionEnd() == 0)
        {
          i = 0;
          j = this.a.length() - 1;
          if (i == j) {
            break label242;
          }
        }
        for (i = paramEditable.charAt(i);; i = paramEditable.charAt(j))
        {
          if ((i != 59) && (i != 44)) {
            break label253;
          }
          n.f(this.a);
          return;
          i = this.a.getSelectionEnd() - 1;
          break;
        }
      } while ((i != 32) || (this.a.d()));
      paramEditable = this.a.getText().toString();
      i = this.a.e.findTokenStart(paramEditable, this.a.getSelectionEnd());
      paramEditable = paramEditable.substring(i, this.a.e.findTokenEnd(paramEditable, i));
    } while ((TextUtils.isEmpty(paramEditable)) || (n.g(this.a) == null) || (!n.g(this.a).isValid(paramEditable)));
    n.f(this.a);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 > paramInt3)
    {
      paramInt1 = this.a.getSelectionStart();
      paramCharSequence = (z[])this.a.getSpannable().getSpans(paramInt1, paramInt1, z.class);
      if (paramCharSequence.length > 0)
      {
        localEditable = this.a.getText();
        paramInt3 = this.a.e.findTokenStart(localEditable, paramInt1);
        paramInt2 = this.a.e.findTokenEnd(localEditable, paramInt3) + 1;
        paramInt1 = paramInt2;
        if (paramInt2 > localEditable.length()) {
          paramInt1 = localEditable.length();
        }
        localEditable.delete(paramInt3, paramInt1);
        this.a.getSpannable().removeSpan(paramCharSequence[0]);
      }
    }
    while (paramInt3 <= paramInt2)
    {
      Editable localEditable;
      return;
    }
    n.h(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/android/ex/chips/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */