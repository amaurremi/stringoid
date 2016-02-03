package com.ideashower.readitlater.db.operation;

import android.database.sqlite.SQLiteDatabase;
import com.ideashower.readitlater.e.n;

public class l
{
  private n b;
  private n c;
  
  protected l(j paramj) {}
  
  public void a(SQLiteDatabase paramSQLiteDatabase)
  {
    if (this.b != null) {
      this.b.a(paramSQLiteDatabase);
    }
    if (this.c != null) {
      this.c.a(paramSQLiteDatabase);
    }
  }
  
  protected n b(SQLiteDatabase paramSQLiteDatabase)
  {
    if (this.b == null) {
      this.b = new n(paramSQLiteDatabase, "unique_id", 100000);
    }
    return this.b;
  }
  
  protected n c(SQLiteDatabase paramSQLiteDatabase)
  {
    if (this.c == null) {
      this.c = new n(paramSQLiteDatabase, "local_friend_id", 2);
    }
    return this.c;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/db/operation/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */