package com.e.b;

import android.text.SpannableStringBuilder;
import java.util.Map;

abstract class e
{
  private final e a;
  private e b;
  
  protected e(e parame)
  {
    this.a = parame;
    if (parame != null) {
      parame.b = this;
    }
  }
  
  abstract int a();
  
  abstract void a(SpannableStringBuilder paramSpannableStringBuilder, Map paramMap);
  
  final int b()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.b() + this.a.a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */