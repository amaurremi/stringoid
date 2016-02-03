package com.ideashower.readitlater.db.operation;

import android.database.sqlite.SQLiteDatabase;

public class z
  extends j
{
  private final int e;
  private final int p;
  private final int q;
  private final int r;
  
  public z(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.e = paramInt1;
    this.p = paramInt2;
    this.q = paramInt3;
    this.r = paramInt4;
  }
  
  protected void c_()
  {
    Object[] arrayOfObject = f(4);
    arrayOfObject[0] = Integer.valueOf(this.q);
    arrayOfObject[1] = Integer.valueOf(this.r);
    arrayOfObject[2] = Integer.valueOf(this.e);
    arrayOfObject[3] = Integer.valueOf(this.p);
    this.h.execSQL("UPDATE item_images SET width = ?, height = ? WHERE unique_id = ? AND image_id = ?", arrayOfObject);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/db/operation/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */