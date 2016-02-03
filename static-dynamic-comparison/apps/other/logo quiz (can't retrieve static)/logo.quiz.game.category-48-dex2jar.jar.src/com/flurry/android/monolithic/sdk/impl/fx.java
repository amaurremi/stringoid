package com.flurry.android.monolithic.sdk.impl;

import java.util.HashMap;

class fx
  implements hw
{
  fx(ft paramft, hw paramhw) {}
  
  public void a(hy paramhy)
  {
    this.a.a(paramhy);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (this.b.c.containsKey("APPCLOUD_USER_SESSION"))
    {
      String str = (String)this.b.c.get("APPCLOUD_USER_SESSION");
      gr.a = str;
      ft localft = new ft();
      localft.d = this.b.d;
      localft.e = this.b.e;
      localft.a = this.b.a;
      ft.a(localft);
      fy.a(this.b.a);
      fy.a(this.b.e, this.b.d, str);
      fy.b(this.b.f);
    }
    this.a.a(paramBoolean, paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/fx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */