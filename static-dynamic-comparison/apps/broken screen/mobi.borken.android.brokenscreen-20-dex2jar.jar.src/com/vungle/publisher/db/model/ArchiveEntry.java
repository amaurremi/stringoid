package com.vungle.publisher.db.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.vungle.publisher.ar;
import com.vungle.publisher.ar.a;
import com.vungle.publisher.cl;
import com.vungle.publisher.db.DatabaseHelper;
import com.vungle.publisher.log.Logger;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

public class ArchiveEntry
  extends ar<Integer>
{
  LocalArchive a;
  String b;
  Integer c;
  @Inject
  Factory d;
  @Inject
  LocalArchive.Factory e;
  
  private Integer d()
  {
    if (this.a == null) {
      return null;
    }
    return this.a.e();
  }
  
  protected final ContentValues a(boolean paramBoolean)
  {
    ContentValues localContentValues = new ContentValues();
    if (this.n != null) {
      localContentValues.put("id", (Integer)this.n);
    }
    localContentValues.put("viewable_id", d());
    localContentValues.put("relative_path", this.b);
    localContentValues.put("size", this.c);
    return localContentValues;
  }
  
  protected final String b()
  {
    return "archive_entry";
  }
  
  public final int l()
  {
    if (this.n == null)
    {
      Integer localInteger = d();
      String str = this.b;
      Logger.d("VungleDatabase", "updating archive_entry by viewable_id " + localInteger + ", relative_path " + str);
      int i = this.o.getWritableDatabase().updateWithOnConflict("archive_entry", a(false), "viewable_id = ? AND relative_path = ?", new String[] { String.valueOf(localInteger), str }, 3);
      s();
      return i;
    }
    return super.l();
  }
  
  protected final StringBuilder n()
  {
    StringBuilder localStringBuilder = super.n();
    cl.a(localStringBuilder, "viewable_id", d());
    cl.a(localStringBuilder, "relative_path", this.b);
    cl.a(localStringBuilder, "size", this.c);
    return localStringBuilder;
  }
  
  @Singleton
  public static class Factory
    extends ar.a<ArchiveEntry, Integer>
  {
    @Inject
    Provider<ArchiveEntry> a;
    
    final int a(Integer paramInteger)
    {
      if (paramInteger == null) {
        throw new IllegalArgumentException("null viewable_id");
      }
      int i = this.b.getWritableDatabase().delete("archive_entry", "viewable_id = ?", new String[] { String.valueOf(paramInteger) });
      Logger.d("VungleDatabase", "deleted " + i + " archive_entry rows for viewable_id " + paramInteger);
      return i;
    }
    
    final ArchiveEntry a()
    {
      return (ArchiveEntry)this.a.get();
    }
    
    final ArchiveEntry[] a(LocalArchive paramLocalArchive)
    {
      if (paramLocalArchive == null) {
        throw new IllegalArgumentException("null archive");
      }
      Object localObject = paramLocalArchive.e();
      if (localObject == null) {
        throw new IllegalArgumentException("null viewable_id");
      }
      try
      {
        Logger.d("VungleDatabase", "fetching archive_entry records by viewable_id " + localObject);
        localObject = this.b.getReadableDatabase().query("archive_entry", null, "viewable_id = ?", new String[] { String.valueOf(localObject) }, null, null, null);
        ArchiveEntry[] arrayOfArchiveEntry;
        int i;
        ArchiveEntry localArchiveEntry;
        if (localObject == null) {
          break label188;
        }
      }
      finally
      {
        try
        {
          arrayOfArchiveEntry = new ArchiveEntry[((Cursor)localObject).getCount()];
          i = 0;
          while (((Cursor)localObject).moveToNext())
          {
            localArchiveEntry = a();
            b(localArchiveEntry, (Cursor)localObject, false);
            localArchiveEntry.a = paramLocalArchive;
            arrayOfArchiveEntry[i] = localArchiveEntry;
            Logger.v("VungleDatabase", "fetched " + localArchiveEntry);
            i += 1;
          }
          if (localObject != null) {
            ((Cursor)localObject).close();
          }
          return arrayOfArchiveEntry;
        }
        finally
        {
          for (;;) {}
        }
        paramLocalArchive = finally;
        localObject = null;
      }
      ((Cursor)localObject).close();
      label188:
      throw paramLocalArchive;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/model/ArchiveEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */