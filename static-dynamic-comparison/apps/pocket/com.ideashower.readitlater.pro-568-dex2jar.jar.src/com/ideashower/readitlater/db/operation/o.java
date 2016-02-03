package com.ideashower.readitlater.db.operation;

import android.database.sqlite.SQLiteDatabase;
import com.ideashower.readitlater.a.aa;

public class o
  extends j
{
  private final int[] e;
  private final int[] p;
  
  public o(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    this.e = paramArrayOfInt1;
    this.p = paramArrayOfInt2;
  }
  
  protected void c_()
  {
    int j = 0;
    Object localObject = f(2);
    int[] arrayOfInt = this.e;
    int k = arrayOfInt.length;
    int i = 0;
    while (i < k)
    {
      int m = arrayOfInt[i];
      localObject[0] = Integer.valueOf(1);
      localObject[1] = Integer.valueOf(m);
      this.h.execSQL("UPDATE shared_items SET viewed = ? WHERE share_id = ?", (Object[])localObject);
      i += 1;
    }
    localObject = this.p;
    k = localObject.length;
    i = j;
    while (i < k)
    {
      aa.b(localObject[i]);
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/db/operation/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */