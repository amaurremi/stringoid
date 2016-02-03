package com.pocket.c;

import android.database.Cursor;
import com.ideashower.readitlater.db.operation.j;
import com.ideashower.readitlater.util.l;
import java.util.ArrayList;
import org.codehaus.jackson.map.ObjectMapper;

public class ae
  extends j
{
  private int e = 0;
  private final ArrayList p = new ArrayList();
  private final ArrayList q = new ArrayList();
  private String r;
  private boolean s;
  
  public boolean A()
  {
    return this.s;
  }
  
  protected void c_()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    Cursor localCursor = o();
    ObjectMapper localObjectMapper = l.a();
    if (localCursor.moveToNext())
    {
      int j = localCursor.getInt(localCursor.getColumnIndexOrThrow("rowid"));
      int i;
      label65:
      String str;
      if (this.e < j)
      {
        i = j;
        this.e = i;
        str = localCursor.getString(localCursor.getColumnIndexOrThrow("action"));
        if (!this.s) {
          if (localCursor.getInt(localCursor.getColumnIndexOrThrow("send_asap")) != 1) {
            break label186;
          }
        }
      }
      label186:
      for (boolean bool = true;; bool = false)
      {
        this.s = bool;
        if (this.p.size() > 0) {
          localStringBuilder.append(",");
        }
        localStringBuilder.append(str);
        this.p.add(Integer.valueOf(j));
        this.q.add(localObjectMapper.readTree(str));
        break;
        i = this.e;
        break label65;
      }
    }
    localCursor.close();
    localStringBuilder.append("]");
    this.r = localStringBuilder.toString();
    e.b(m());
  }
  
  public ArrayList e()
  {
    return this.p;
  }
  
  public ArrayList g()
  {
    return this.q;
  }
  
  public String z()
  {
    return this.r;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/c/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */