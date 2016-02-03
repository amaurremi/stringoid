package com.ideashower.readitlater.db.operation;

import android.database.sqlite.SQLiteDatabase;
import com.ideashower.readitlater.e.o;

public class aa
  extends j
{
  private final o e;
  private final int p;
  private final int q;
  private final String r;
  private final String s;
  
  public aa(o paramo, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this.e = paramo;
    this.p = paramInt1;
    this.q = paramInt2;
    if (paramString1 != null)
    {
      this.r = paramString1;
      if (paramString2 == null) {
        break label51;
      }
    }
    for (;;)
    {
      this.s = paramString2;
      return;
      paramString1 = paramo.E();
      break;
      label51:
      paramString2 = paramo.F();
    }
  }
  
  protected void c_()
  {
    Object[] arrayOfObject = f(4);
    arrayOfObject[0] = Integer.valueOf(this.q);
    arrayOfObject[1] = this.r;
    arrayOfObject[2] = this.s;
    arrayOfObject[3] = Integer.valueOf(this.e.f());
    switch (this.p)
    {
    }
    for (;;)
    {
      this.e.g(this.r);
      this.e.f(this.s);
      com.ideashower.readitlater.a.aa.b(this.e.f());
      return;
      this.e.h(this.q);
      this.h.execSQL("UPDATE items SET offline_web = ?, mime = ?, encoding = ? WHERE unique_id = ?", arrayOfObject);
      continue;
      this.e.i(this.q);
      this.h.execSQL("UPDATE items SET offline_text = ?, mime = ?, encoding = ? WHERE unique_id = ?", arrayOfObject);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/db/operation/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */