package com.vungle.publisher;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.vungle.publisher.db.DatabaseHelper;
import com.vungle.publisher.log.Logger;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public abstract class ar<I>
{
  public Class<I> m;
  public I n;
  @Inject
  public DatabaseHelper o;
  
  protected static String r()
  {
    return "id";
  }
  
  public abstract ContentValues a(boolean paramBoolean);
  
  protected final void a(I paramI)
  {
    this.n = paramI;
  }
  
  public abstract <T extends ar<I>> a<T, I> a_();
  
  public abstract String b();
  
  public boolean c()
  {
    return true;
  }
  
  public int l()
  {
    Object localObject = p();
    if (localObject == null) {
      throw new IllegalArgumentException("null " + "id");
    }
    String str1 = b();
    String str2 = "id" + " " + localObject;
    int i = this.o.getWritableDatabase().updateWithOnConflict(str1, a(false), "id = ?", new String[] { localObject.toString() }, 3);
    switch (i)
    {
    default: 
      Logger.w("VungleDatabase", "updated " + i + " " + str1 + " records for " + str2);
      return i;
    case 0: 
      Logger.d("VungleDatabase", "no " + str1 + " rows updated by " + str2);
      return i;
    }
    Logger.d("VungleDatabase", "update successful " + u());
    return i;
  }
  
  public StringBuilder m()
  {
    return new StringBuilder("{").append(v()).append(":: id: ").append(p());
  }
  
  public StringBuilder n()
  {
    return m();
  }
  
  public I o()
  {
    Object localObject = p();
    if ((c()) && (localObject != null)) {
      throw new SQLException("attempt to insert with non-auto generated id " + u());
    }
    Logger.d("VungleDatabase", "inserting " + this);
    long l = this.o.getWritableDatabase().insertOrThrow(b(), null, a(true));
    if ((this.m == null) || (Integer.class.equals(this.m))) {
      this.n = Integer.valueOf((int)l);
    }
    for (;;)
    {
      Logger.v("VungleDatabase", "inserted " + this);
      return (I)p();
      if (Long.class.equals(this.m)) {
        this.n = Long.valueOf(l);
      }
    }
  }
  
  public I p()
  {
    return (I)this.n;
  }
  
  public final void s()
  {
    a_().a(this, false);
  }
  
  public final I t()
  {
    Object localObject = p();
    if (localObject == null) {
      return (I)o();
    }
    l();
    return (I)localObject;
  }
  
  public String toString()
  {
    return n() + "}";
  }
  
  public final String u()
  {
    return m() + "}";
  }
  
  public String v()
  {
    return b();
  }
  
  public static abstract class a<T extends ar<I>, I>
  {
    @Inject
    public DatabaseHelper b;
    
    public static void a(T... paramVarArgs)
    {
      if (paramVarArgs != null)
      {
        int j = paramVarArgs.length;
        int i = 0;
        while (i < j)
        {
          paramVarArgs[i].o();
          i += 1;
        }
      }
    }
    
    public int a(List<T> paramList)
    {
      int j = 0;
      if (paramList == null)
      {
        paramList = null;
        if (paramList != null) {
          break label77;
        }
      }
      Object[] arrayOfObject;
      label77:
      for (int i = 0;; i = paramList.length)
      {
        arrayOfObject = a(i);
        int k = paramList.length;
        i = 0;
        while (j < k)
        {
          arrayOfObject[i] = paramList[j].p();
          j += 1;
          i += 1;
        }
        paramList = (ar[])paramList.toArray(b(paramList.size()));
        break;
      }
      return a(arrayOfObject);
    }
    
    public final int a(I... paramVarArgs)
    {
      int k = 0;
      int i;
      ar localar;
      boolean bool;
      if (paramVarArgs == null)
      {
        i = 0;
        if (i <= 0) {
          break label266;
        }
        localar = b_();
        bool = paramVarArgs instanceof String[];
        if (!bool) {
          break label87;
        }
      }
      label87:
      for (String[] arrayOfString = (String[])paramVarArgs;; arrayOfString = new String[i])
      {
        if (bool) {
          break label96;
        }
        int m = paramVarArgs.length;
        j = 0;
        while (k < m)
        {
          arrayOfString[j] = String.valueOf(paramVarArgs[k]);
          k += 1;
          j += 1;
        }
        i = paramVarArgs.length;
        break;
      }
      label96:
      int j = this.b.getWritableDatabase().delete(localar.b(), ar.r() + " IN (" + ap.a(i) + ")", arrayOfString);
      if (j == i)
      {
        Logger.d("VungleDatabase", "deleted " + j + " " + localar.b() + " records by " + ar.r() + " " + cl.a(paramVarArgs));
        return j;
      }
      Logger.w("VungleDatabase", "deleted " + j + " of " + i + " requested records by " + ar.r() + " " + cl.a(paramVarArgs));
      return j;
      label266:
      return 0;
    }
    
    public abstract T a(T paramT, Cursor paramCursor, boolean paramBoolean);
    
    protected final T a(T paramT, boolean paramBoolean)
    {
      Object localObject1 = null;
      if (paramT == null) {
        throw new IllegalArgumentException("null model");
      }
      String str2 = ar.r();
      Object localObject2 = paramT.p();
      if (localObject2 == null) {
        throw new IllegalArgumentException("null " + str2);
      }
      String str1 = paramT.b();
      List localList = a(str1, str2 + " = ?", new String[] { localObject2.toString() }, null, paramBoolean);
      str2 = str2 + " " + localObject2;
      int i = localList.size();
      paramT = (T)localObject1;
      switch (i)
      {
      default: 
        throw new SQLException(i + " " + str1 + " records found for " + str2);
      case 1: 
        paramT = (ar)localList.get(0);
      }
      return paramT;
    }
    
    public final T a(I paramI, boolean paramBoolean)
    {
      ar localar = b_();
      localar.a(paramI);
      return a(localar, paramBoolean);
    }
    
    public final List<T> a(String paramString1, String paramString2, String[] paramArrayOfString, String paramString3)
    {
      return a(paramString1, paramString2, paramArrayOfString, paramString3, false);
    }
    
    public final List<T> a(String paramString1, String paramString2, String[] paramArrayOfString, String paramString3, boolean paramBoolean)
    {
      for (;;)
      {
        try
        {
          StringBuilder localStringBuilder = new StringBuilder("fetching ");
          if (paramString2 != null) {
            continue;
          }
          str = "all " + paramString1 + " records";
          Logger.d("VungleDatabase", str);
          paramString3 = this.b.getReadableDatabase().query(paramString1, null, paramString2, paramArrayOfString, null, null, paramString3, null);
          try
          {
            i = paramString3.getCount();
            localStringBuilder = new StringBuilder();
            if (i != 0) {
              continue;
            }
            str = "no ";
            Logger.v("VungleDatabase", str + paramString1 + " records by " + paramString2 + " " + cl.a(paramArrayOfString));
            paramString1 = new ArrayList(i);
            if (!paramString3.moveToNext()) {
              continue;
            }
            paramString1.add(b(b_(), paramString3, paramBoolean));
            continue;
            if (paramString3 == null) {
              continue;
            }
          }
          finally {}
        }
        finally
        {
          String str;
          int i;
          paramString3 = null;
          continue;
        }
        paramString3.close();
        throw paramString1;
        str = paramString1 + " records by " + paramString2 + " " + cl.a(paramArrayOfString);
        continue;
        str = "fetched " + i + " ";
      }
      if (paramString3 != null) {
        paramString3.close();
      }
      return paramString1;
    }
    
    public abstract I[] a(int paramInt);
    
    public final T b(T paramT, Cursor paramCursor, boolean paramBoolean)
    {
      a(paramT, paramCursor, paramBoolean);
      Logger.v("VungleDatabase", "fetched " + paramT);
      return paramT;
    }
    
    public abstract T[] b(int paramInt);
    
    public abstract T b_();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */