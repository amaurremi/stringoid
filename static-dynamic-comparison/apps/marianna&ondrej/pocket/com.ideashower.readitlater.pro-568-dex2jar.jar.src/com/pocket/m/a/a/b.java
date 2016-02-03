package com.pocket.m.a.a;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.ideashower.readitlater.db.operation.n;
import com.ideashower.readitlater.e.g;
import com.ideashower.readitlater.e.k;
import com.pocket.m.a.l;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class b
  extends n
{
  private final com.pocket.m.a.c p = l.c();
  
  private void J()
  {
    com.pocket.m.a.d locald = com.pocket.m.a.d.b();
    Object localObject1 = k.a().b();
    if (localObject1 == null) {
      label15:
      return;
    } else {
      localObject1 = ((ArrayList)localObject1).iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label15;
      }
      Object localObject2 = ((g)((Iterator)localObject1).next()).c();
      if (localObject2 == null) {
        break;
      }
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        com.pocket.m.a.a locala = com.pocket.m.a.a.a((String)((Iterator)localObject2).next());
        if ((locala != null) && (locala.j())) {
          c(locala.c(), locald);
        }
      }
    }
  }
  
  private int K()
  {
    int i = 0;
    Cursor localCursor = this.h.rawQuery(" SELECT unique_id FROM items ORDER BY unique_id DESC LIMIT 1", null);
    if (localCursor.moveToNext()) {
      i = localCursor.getInt(localCursor.getColumnIndexOrThrow("unique_id"));
    }
    localCursor.close();
    return i;
  }
  
  private void a(int paramInt, String paramString, com.pocket.m.a.d paramd)
  {
    String str = this.p.b(paramInt);
    paramString = c(str, paramString);
    if (paramString == null) {
      return;
    }
    c(str, paramd);
    a(paramString, paramd, new HashSet(), paramInt);
  }
  
  private void a(int paramInt, String paramString1, String paramString2, boolean paramBoolean, com.pocket.m.a.d paramd) {}
  
  private void a(com.pocket.m.d.b paramb, String paramString, com.pocket.m.a.d paramd, HashSet paramHashSet, int paramInt)
  {
    for (;;)
    {
      try
      {
        paramString = paramb.a.matcher(paramString);
        if ((a_()) || (!paramString.find())) {
          break;
        }
        if (i(paramInt)) {
          return;
        }
        String str = paramString.group(paramb.c);
        if (paramHashSet.contains(str)) {
          continue;
        }
        paramHashSet.add(str);
        str = h(str);
        if (str == null) {
          continue;
        }
        c(str, paramd);
        if (paramb.f == 2)
        {
          b(str, paramd, paramHashSet, paramInt);
          continue;
        }
        i = paramb.f;
      }
      catch (Throwable paramb)
      {
        com.ideashower.readitlater.util.e.a(paramb);
        return;
      }
      int i;
      if (i != 1) {}
    }
  }
  
  private void a(String paramString, com.pocket.m.a.d paramd, HashSet paramHashSet, int paramInt)
  {
    a(com.pocket.m.d.a.b, paramString, paramd, paramHashSet, paramInt);
    a(com.pocket.m.d.a.a, paramString, paramd, paramHashSet, paramInt);
    a(com.pocket.m.d.a.c, paramString, paramd, paramHashSet, paramInt);
    a(com.pocket.m.d.a.d, paramString, paramd, paramHashSet, paramInt);
  }
  
  private void b(String paramString, com.pocket.m.a.d paramd)
  {
    paramString = com.pocket.m.a.a.a(paramString);
    if ((paramString != null) && (paramString.j())) {
      c(paramString.c(), paramd);
    }
  }
  
  private void b(String paramString, com.pocket.m.a.d paramd, HashSet paramHashSet, int paramInt)
  {
    paramd = c(paramString, "UTF-8");
    if (paramd == null) {
      return;
    }
    paramString = com.pocket.m.a.d.a(paramString);
    a(com.pocket.m.d.a.b, paramd, paramString, paramHashSet, paramInt);
    a(com.pocket.m.d.a.d, paramd, paramString, paramHashSet, paramInt);
  }
  
  private static String c(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new File(paramString1);
      if (paramString2 != null) {}
      for (;;)
      {
        return org.apache.a.b.b.a(paramString1, Charset.forName(paramString2));
        paramString2 = "UTF-8";
      }
      return null;
    }
    catch (Throwable paramString1)
    {
      com.ideashower.readitlater.util.e.a(paramString1);
    }
  }
  
  private void c(String paramString, com.pocket.m.a.d paramd)
  {
    com.pocket.m.a.e.a(paramString, paramd, this);
    try
    {
      a(com.ideashower.readitlater.objects.d.a(paramString), org.apache.a.b.b.h(new File(paramString)));
      return;
    }
    catch (Throwable paramString) {}
  }
  
  private String h(String paramString)
  {
    while (paramString.startsWith("../")) {
      paramString = paramString.substring("../".length());
    }
    if (paramString.startsWith("RIL_assets"))
    {
      paramString = paramString.substring("RIL_assets".length());
      return this.p.c() + paramString;
    }
    return null;
  }
  
  private boolean i(int paramInt)
  {
    if ((e()) || (a_()))
    {
      c.a(paramInt);
      return true;
    }
    return false;
  }
  
  protected void A() {}
  
  protected n a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return new b();
    }
    return null;
  }
  
  protected boolean z()
  {
    boolean bool3 = true;
    int j = c.e();
    int i = j;
    if (j == -1)
    {
      i = K();
      J();
      c.a(i);
    }
    if (c.f())
    {
      bool1 = false;
      return bool1;
    }
    Cursor localCursor = this.h.rawQuery(" SELECT unique_id, given_url, image, offline_web, offline_text, encoding, mime, src FROM items LEFT OUTER JOIN item_images USING (unique_id) WHERE unique_id <=" + i + " ORDER BY " + "unique_id" + " DESC" + " LIMIT " + 400, null);
    i = 0;
    boolean bool1 = false;
    label103:
    if (localCursor.moveToNext())
    {
      int n = localCursor.getInt(localCursor.getColumnIndexOrThrow("unique_id"));
      String str1 = localCursor.getString(localCursor.getColumnIndexOrThrow("given_url"));
      label173:
      int k;
      label196:
      String str2;
      String str3;
      if (localCursor.getInt(localCursor.getColumnIndexOrThrow("offline_text")) == 1)
      {
        j = 1;
        if (localCursor.getInt(localCursor.getColumnIndexOrThrow("offline_web")) != 1) {
          break label410;
        }
        k = 1;
        str2 = localCursor.getString(localCursor.getColumnIndexOrThrow("encoding"));
        str3 = localCursor.getString(localCursor.getColumnIndexOrThrow("mime"));
        if (localCursor.getInt(localCursor.getColumnIndexOrThrow("image")) != 2) {
          break label415;
        }
      }
      label410:
      label415:
      for (boolean bool2 = true;; bool2 = false)
      {
        String str4 = localCursor.getString(localCursor.getColumnIndexOrThrow("src"));
        com.pocket.m.a.d locald = com.pocket.m.a.d.a(n);
        bool1 = bool3;
        if (i(n)) {
          break;
        }
        int m = i;
        if (i != n)
        {
          if (k != 0)
          {
            a(n, str1, str3, bool2, locald);
            a(n, str2, locald);
          }
          if (j != 0) {
            c(this.p.d(n), locald);
          }
          m = n;
        }
        bool1 = bool3;
        if (i(n)) {
          break;
        }
        if (str4 != null) {
          b(str4, locald);
        }
        bool1 = bool3;
        if (i(n)) {
          break;
        }
        bool1 = true;
        i = m;
        break label103;
        j = 0;
        break label173;
        k = 0;
        break label196;
      }
    }
    c.a(i - 1);
    return bool1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/m/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */