package com.android.ex.chips;

import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.Data;
import com.ideashower.readitlater.a.o;
import com.ideashower.readitlater.db.operation.f;
import com.ideashower.readitlater.util.a;

public class m
{
  public final String a;
  public final String b;
  public final long c;
  public final long d;
  public final String e;
  public final f f;
  
  public m(Cursor paramCursor, boolean paramBoolean)
  {
    this.a = paramCursor.getString(0);
    this.b = paramCursor.getString(1);
    this.c = paramCursor.getLong(4);
    this.d = paramCursor.getLong(5);
    if (a.e())
    {
      this.e = paramCursor.getString(7);
      if (!paramBoolean) {
        break label112;
      }
    }
    label112:
    for (paramCursor = o.c().a(this.b);; paramCursor = null)
    {
      this.f = paramCursor;
      return;
      this.e = ContentUris.withAppendedId(ContactsContract.Data.CONTENT_URI, paramCursor.getInt(7)).toString();
      break;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/android/ex/chips/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */