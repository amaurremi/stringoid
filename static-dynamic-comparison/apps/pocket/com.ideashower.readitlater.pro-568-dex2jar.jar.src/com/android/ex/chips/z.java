package com.android.ex.chips;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.ideashower.readitlater.db.operation.f;

class z
  extends ImageSpan
{
  private final CharSequence a;
  private final CharSequence b;
  private final long c;
  private final long d;
  private aa e;
  private boolean f = false;
  private CharSequence g;
  
  public z(Drawable paramDrawable, aa paramaa, int paramInt)
  {
    super(paramDrawable, 0);
    this.a = paramaa.b();
    if ((paramaa.i() != null) && (paramaa.i().m())) {}
    for (paramDrawable = paramaa.i().d();; paramDrawable = paramaa.c().trim())
    {
      this.b = paramDrawable;
      this.c = paramaa.d();
      this.d = paramaa.j();
      this.e = paramaa;
      return;
    }
  }
  
  public void a(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      str = paramString.trim();
    }
    this.g = str;
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public boolean a()
  {
    return this.f;
  }
  
  public CharSequence b()
  {
    return this.b;
  }
  
  public long c()
  {
    return this.c;
  }
  
  public long d()
  {
    return this.d;
  }
  
  public aa e()
  {
    return this.e;
  }
  
  public CharSequence f()
  {
    if (!TextUtils.isEmpty(this.g)) {
      return this.g;
    }
    return this.e.c();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/android/ex/chips/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */