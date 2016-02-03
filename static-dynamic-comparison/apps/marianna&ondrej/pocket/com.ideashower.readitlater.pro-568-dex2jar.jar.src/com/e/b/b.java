package com.e.b;

import android.text.SpannableStringBuilder;
import java.util.Map;

class b
  extends e
{
  private final String a;
  private CharSequence b;
  
  b(e parame, String paramString)
  {
    super(parame);
    this.a = paramString;
  }
  
  int a()
  {
    return this.b.length();
  }
  
  void a(SpannableStringBuilder paramSpannableStringBuilder, Map paramMap)
  {
    this.b = ((CharSequence)paramMap.get(this.a));
    int i = b();
    paramSpannableStringBuilder.replace(i, this.a.length() + i + 2, this.b);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */