package com.pocket.list.widget.a;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.ideashower.readitlater.db.operation.j;
import com.ideashower.readitlater.util.u;

class e
  extends j
{
  private final int[] p;
  private final int[] q;
  
  private e(c paramc, int[] paramArrayOfInt)
  {
    this.p = paramArrayOfInt;
    this.q = new int[paramArrayOfInt.length];
  }
  
  protected void c_()
  {
    int j = 0;
    Object localObject = u.a();
    ((StringBuilder)localObject).append("SELECT unique_id FROM items WHERE ");
    ((StringBuilder)localObject).append("(");
    int k = this.p.length;
    String[] arrayOfString = g(k);
    int i = 0;
    while (i < k)
    {
      if (i > 0) {
        ((StringBuilder)localObject).append(" OR ");
      }
      ((StringBuilder)localObject).append("unique_id = ? ");
      arrayOfString[i] = String.valueOf(this.p[i]);
      i += 1;
    }
    ((StringBuilder)localObject).append(") AND ").append("status").append(" != ").append(0);
    localObject = this.h.rawQuery(((StringBuilder)localObject).toString(), arrayOfString);
    i = j;
    while (((Cursor)localObject).moveToNext())
    {
      this.q[i] = ((Cursor)localObject).getInt(((Cursor)localObject).getColumnIndexOrThrow("unique_id"));
      i += 1;
    }
    ((Cursor)localObject).close();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/list/widget/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */