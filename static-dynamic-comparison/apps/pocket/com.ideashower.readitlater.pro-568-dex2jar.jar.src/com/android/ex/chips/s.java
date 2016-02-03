package com.android.ex.chips;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.widget.MultiAutoCompleteTextView.Tokenizer;

public class s
  implements MultiAutoCompleteTextView.Tokenizer
{
  public s(n paramn) {}
  
  public int findTokenEnd(CharSequence paramCharSequence, int paramInt)
  {
    int i = paramCharSequence.length();
    while (paramInt < i)
    {
      int j = paramCharSequence.charAt(paramInt);
      if ((j == 44) || (j == 59)) {
        return paramInt;
      }
      paramInt += 1;
    }
    return i;
  }
  
  public int findTokenStart(CharSequence paramCharSequence, int paramInt)
  {
    int i;
    if (paramInt > 0)
    {
      i = paramCharSequence.charAt(paramInt - 1);
      if ((i == 44) || (i == 59)) {
        i = paramInt - 1;
      }
    }
    for (;;)
    {
      int j = i;
      if (i > 0)
      {
        int k = paramCharSequence.charAt(i - 1);
        j = i;
        if (k != 44)
        {
          j = i;
          if (k != 59)
          {
            i -= 1;
            continue;
          }
        }
      }
      while ((j < paramInt) && (paramCharSequence.charAt(j) == ' ')) {
        j += 1;
      }
      return j;
      i = paramInt;
    }
  }
  
  public CharSequence terminateToken(CharSequence paramCharSequence)
  {
    int i = paramCharSequence.length();
    while ((i > 0) && (paramCharSequence.charAt(i - 1) == ' ')) {
      i -= 1;
    }
    if (i > 0)
    {
      i = paramCharSequence.charAt(i - 1);
      if ((i == 44) || (i == 59)) {
        return paramCharSequence;
      }
    }
    Object localObject = this.a.o + " ";
    if ((paramCharSequence instanceof Spanned))
    {
      localObject = new SpannableString(paramCharSequence + (String)localObject);
      TextUtils.copySpansFrom((Spanned)paramCharSequence, 0, paramCharSequence.length(), Object.class, (Spannable)localObject, 0);
      return (CharSequence)localObject;
    }
    return paramCharSequence + (String)localObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/android/ex/chips/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */