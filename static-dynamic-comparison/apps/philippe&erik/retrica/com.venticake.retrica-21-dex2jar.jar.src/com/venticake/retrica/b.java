package com.venticake.retrica;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.widget.ImageView;
import com.venticake.retrica.util.UserInterfaceUtil;
import java.io.File;
import java.util.HashMap;

class b
  implements Runnable
{
  protected ImageView a;
  protected File b;
  protected Uri c;
  
  public b(a parama, ImageView paramImageView, File paramFile, Uri paramUri)
  {
    this.a = paramImageView;
    this.b = paramFile;
    this.c = paramUri;
    a.a(parama).put(paramImageView, this);
  }
  
  public void run()
  {
    if ((b)a.a(this.d).get(this.a) != this) {
      return;
    }
    for (;;)
    {
      String str;
      try
      {
        localObject3 = a.b(this.d).getReadableDatabase();
        str = "SELECT thumbnail_image FROM THUMBNAIL WHERE uri = '" + this.c.toString() + "'";
        Cursor localCursor = ((SQLiteDatabase)localObject3).rawQuery(str, new String[0]);
        if (!localCursor.moveToFirst()) {
          break label267;
        }
        final Object localObject1 = localCursor.getBlob(0);
        if ((localCursor != null) && (!localCursor.isClosed())) {
          localCursor.close();
        }
        if ((localCursor.getCount() > 0) && (localObject1 != null))
        {
          localObject1 = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length);
          a.d(this.d).runOnUiThread(new Runnable()
          {
            public void run()
            {
              if ((b)a.a(b.a(b.this)).get(b.this.a) != jdField_this) {
                return;
              }
              b.this.a.setImageBitmap(localObject1);
              UserInterfaceUtil.setImageViewAlpha(b.this.a, 255);
              a.a(b.a(b.this)).remove(b.this.a);
            }
          });
          return;
        }
      }
      catch (Exception localException)
      {
        a.a(this.d).remove(this.a);
        return;
      }
      a.c(this.d).a(this.b);
      Object localObject3 = ((SQLiteDatabase)localObject3).rawQuery(str, new String[0]);
      if (((Cursor)localObject3).moveToFirst()) {}
      for (Object localObject2 = ((Cursor)localObject3).getBlob(0);; localObject2 = null)
      {
        if ((localObject3 != null) && (!((Cursor)localObject3).isClosed())) {
          ((Cursor)localObject3).close();
        }
        if ((((Cursor)localObject3).getCount() > 0) && (localObject2 != null))
        {
          localObject2 = BitmapFactory.decodeByteArray((byte[])localObject2, 0, localObject2.length);
          break;
        }
        localObject2 = null;
        break;
      }
      label267:
      localObject2 = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */