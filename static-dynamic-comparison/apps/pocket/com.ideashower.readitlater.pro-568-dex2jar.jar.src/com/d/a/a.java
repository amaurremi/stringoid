package com.d.a;

import android.content.Context;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;
import com.android.ex.chips.n;
import com.android.ex.chips.t;

public class a
{
  public static final InputFilter a = new InputFilter()
  {
    public CharSequence filter(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, Spanned paramAnonymousSpanned, int paramAnonymousInt3, int paramAnonymousInt4)
    {
      if ((paramAnonymousInt2 - paramAnonymousInt1 != 1) || (paramAnonymousCharSequence.charAt(paramAnonymousInt1) != ' ')) {
        return null;
      }
      paramAnonymousInt1 = 0;
      while (paramAnonymousInt3 > 0)
      {
        paramAnonymousInt3 -= 1;
        switch (paramAnonymousSpanned.charAt(paramAnonymousInt3))
        {
        default: 
          break;
        case ',': 
          return null;
        case '.': 
          paramAnonymousInt1 = 1;
          break;
        case '@': 
          if (paramAnonymousInt1 == 0) {
            return null;
          }
          if ((paramAnonymousCharSequence instanceof Spanned))
          {
            paramAnonymousSpanned = new SpannableStringBuilder(",");
            paramAnonymousSpanned.append(paramAnonymousCharSequence);
            return paramAnonymousSpanned;
          }
          return ", ";
        }
      }
      return null;
    }
  };
  
  public static com.android.b.a.a[] a(MultiAutoCompleteTextView paramMultiAutoCompleteTextView)
  {
    Context localContext = paramMultiAutoCompleteTextView.getContext();
    if (!b(paramMultiAutoCompleteTextView))
    {
      Toast.makeText(localContext, localContext.getString(2131493446), 1).show();
      return null;
    }
    com.android.b.a.a[] arrayOfa = a(paramMultiAutoCompleteTextView);
    if ((arrayOfa == null) || (arrayOfa.length == 0))
    {
      paramMultiAutoCompleteTextView.setError(localContext.getString(2131493447));
      Toast.makeText(localContext, localContext.getString(2131493447), 1).show();
      return null;
    }
    return arrayOfa;
  }
  
  public static com.android.b.a.a[] a(TextView paramTextView)
  {
    return com.android.b.a.a.d(paramTextView.getText().toString().trim());
  }
  
  private static boolean b(MultiAutoCompleteTextView paramMultiAutoCompleteTextView)
  {
    boolean bool = t.a();
    if (!com.android.b.a.a.c(paramMultiAutoCompleteTextView.getText().toString().trim()))
    {
      if ((!bool) || (!(paramMultiAutoCompleteTextView instanceof n))) {
        paramMultiAutoCompleteTextView.setError(paramMultiAutoCompleteTextView.getContext().getString(2131493446));
      }
      return false;
    }
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/d/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */