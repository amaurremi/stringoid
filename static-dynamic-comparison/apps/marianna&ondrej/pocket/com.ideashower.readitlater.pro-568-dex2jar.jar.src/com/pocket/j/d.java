package com.pocket.j;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.ideashower.readitlater.db.operation.j;
import com.pocket.m.a.a;
import com.pocket.m.a.l;
import com.pocket.p.h;
import java.util.ArrayList;

class d
  extends j
{
  private final ArrayList p = new ArrayList();
  private boolean q = false;
  
  private d(b paramb) {}
  
  protected void c_()
  {
    Object localObject = g(2);
    localObject[0] = String.valueOf(280L);
    localObject[1] = localObject[0];
    Cursor localCursor = this.h.rawQuery("SELECT h.group_id, a.src, a.width, a.height, h.sort, a.unique_id FROM highlights h LEFT OUTER JOIN ( SELECT t1.group_id, t1.src, t1.width, t1.height, t1.unique_id FROM ( SELECT ih.unique_id, ih.group_id, ih.sort, src, width, height FROM item_highlights ih JOIN item_images ii ON ih.unique_id = ii.unique_id JOIN items i ON ih.unique_id = i.unique_id WHERE ii.width > ? AND ii.image_id = 1 AND i.status = 0 ) AS t1 LEFT OUTER JOIN ( SELECT ih.unique_id, ih.group_id, ih.sort, src, width, height FROM item_highlights ih JOIN item_images ii ON ih.unique_id = ii.unique_id JOIN items i ON ih.unique_id = i.unique_id WHERE ii.width > ? AND ii.image_id = 1 AND i.status = 0 ) AS t2 ON t1.group_id = t2.group_id AND (t1.sort < t2.sort OR (t1.sort = t2.sort AND t1.unique_id < t2.unique_id)) WHERE t2.group_id IS NULL ) a ON h.group_id = a.group_id ORDER BY h.sort DESC", (String[])localObject);
    if (localCursor.moveToNext())
    {
      localObject = localCursor.getString(localCursor.getColumnIndexOrThrow("src"));
      if (localObject != null) {}
      for (localObject = a.a((String)localObject, 1, l.c());; localObject = null)
      {
        this.p.add(new e(this.e, localCursor.getInt(localCursor.getColumnIndexOrThrow("group_id")), localCursor.getDouble(localCursor.getColumnIndexOrThrow("sort")), (a)localObject, localCursor.getInt(localCursor.getColumnIndexOrThrow("unique_id"))));
        break;
      }
    }
    localCursor.close();
    if (this.p.isEmpty())
    {
      if (h.a("items WHERE STATUS = 0", null, this.h) > 75) {}
      for (boolean bool = true;; bool = false)
      {
        this.q = bool;
        return;
      }
    }
    this.q = true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/j/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */