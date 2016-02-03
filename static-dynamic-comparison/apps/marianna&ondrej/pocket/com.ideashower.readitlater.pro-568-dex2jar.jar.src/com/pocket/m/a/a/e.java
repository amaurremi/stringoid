package com.pocket.m.a.a;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.ideashower.readitlater.db.operation.n;
import com.ideashower.readitlater.objects.d;
import com.pocket.m.a.g;
import com.pocket.m.a.l;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import org.apache.a.b.b;
import org.apache.a.c.k;

class e
  extends n
{
  private void J()
  {
    this.h.execSQL("CREATE TABLE IF NOT EXISTS temp_old_asset_cleaner (domain VARCHAR NOT NULL);");
  }
  
  private HashSet a(File paramFile)
  {
    HashSet localHashSet = new HashSet();
    paramFile = d.a(paramFile.getAbsolutePath());
    do
    {
      try
      {
        paramFile = this.h.rawQuery(" SELECT short_path FROM assets WHERE short_path LIKE '" + paramFile + "%'" + " LIMIT " + 1000, null);
        while (paramFile.moveToNext()) {
          localHashSet.add(paramFile.getString(paramFile.getColumnIndexOrThrow("short_path")));
        }
        paramFile.close();
      }
      catch (Throwable paramFile)
      {
        com.ideashower.readitlater.util.e.a(paramFile);
        paramFile = null;
        return paramFile;
      }
      paramFile = localHashSet;
    } while (localHashSet.size() < 1000);
    return null;
  }
  
  private boolean a(File paramFile, int paramInt, HashSet paramHashSet)
  {
    boolean bool2 = false;
    do
    {
      try
      {
        if (!e()) {
          continue;
        }
        return false;
      }
      catch (Throwable paramFile)
      {
        File[] arrayOfFile;
        HashSet localHashSet;
        int j;
        int i;
        com.ideashower.readitlater.util.e.a(paramFile);
        bool1 = true;
      }
      if (paramFile.isDirectory())
      {
        if ((paramInt < 3) && (e(paramFile))) {
          return true;
        }
        if (a(paramFile, paramHashSet)) {
          return true;
        }
        arrayOfFile = paramFile.listFiles();
        if ((arrayOfFile == null) || (arrayOfFile.length == 0)) {
          break;
        }
        localHashSet = paramHashSet;
        if (paramHashSet == null) {
          localHashSet = a(paramFile);
        }
        j = arrayOfFile.length;
        i = 0;
      }
      for (;;)
      {
        boolean bool1;
        if (i < j)
        {
          bool1 = bool2;
          if (a(arrayOfFile[i], paramInt + 1, localHashSet)) {
            i += 1;
          }
        }
        else
        {
          if ((paramInt >= 3) || (!c(paramFile))) {
            break;
          }
          d(paramFile);
          break;
          a(paramFile, paramHashSet);
          return true;
        }
        return bool1;
      }
    } while (paramFile != null);
    return true;
    return true;
    return true;
  }
  
  private boolean a(File paramFile, HashSet paramHashSet)
  {
    String str = d.a(paramFile.getAbsolutePath());
    boolean bool;
    if (paramHashSet != null)
    {
      paramHashSet = paramHashSet.iterator();
      while (paramHashSet.hasNext()) {
        if (((String)paramHashSet.next()).startsWith(str)) {
          bool = true;
        }
      }
    }
    for (;;)
    {
      if (!bool)
      {
        h(paramFile.getAbsolutePath());
        return true;
        bool = i(str);
      }
      else
      {
        return false;
        bool = false;
      }
    }
  }
  
  private String b(File paramFile)
  {
    if (!paramFile.isDirectory()) {
      paramFile = null;
    }
    Object localObject;
    do
    {
      return paramFile;
      localObject = d.a(paramFile.getAbsolutePath());
      paramFile = (File)localObject;
      if (((String)localObject).endsWith(File.separator)) {
        paramFile = ((String)localObject).substring(0, ((String)localObject).length() - 1);
      }
      localObject = paramFile;
      if (paramFile.startsWith(File.separator)) {
        localObject = paramFile.substring(1);
      }
      paramFile = (File)localObject;
    } while (k.d((CharSequence)localObject, File.separator) + 1 <= 3);
    return null;
  }
  
  private boolean c(File paramFile)
  {
    return b(paramFile) != null;
  }
  
  private void d(File paramFile)
  {
    Object[] arrayOfObject = f(1);
    arrayOfObject[0] = b(paramFile);
    this.h.execSQL(" DELETE FROM temp_old_asset_cleaner WHERE domain LIKE '" + arrayOfObject[0] + "%'");
    this.h.execSQL(" INSERT INTO temp_old_asset_cleaner (domain) VALUES (?)", arrayOfObject);
  }
  
  private boolean e(File paramFile)
  {
    boolean bool = false;
    paramFile = b(paramFile);
    if (paramFile != null) {
      bool = a("temp_old_asset_cleaner", "domain = ?", new String[] { paramFile });
    }
    return bool;
  }
  
  private static void h(String paramString)
  {
    try
    {
      paramString = new File(paramString);
      File localFile = paramString.getParentFile();
      b.c(paramString);
      g.a(localFile);
      return;
    }
    catch (Throwable paramString)
    {
      com.ideashower.readitlater.util.e.a(paramString);
    }
  }
  
  private boolean i(String paramString)
  {
    return a("assets", "short_path LIKE '" + paramString + "%'", new String[0]);
  }
  
  protected void A()
  {
    this.h.execSQL("DROP TABLE IF EXISTS temp_old_asset_cleaner;");
    c.h();
  }
  
  protected n a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return new e();
    }
    return null;
  }
  
  protected boolean z()
  {
    J();
    File localFile = new File(l.c().c());
    if (!localFile.exists()) {}
    while (a(localFile, 0, null)) {
      return false;
    }
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/m/a/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */