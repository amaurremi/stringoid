package com.ideashower.readitlater.db.operation;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.SparseArray;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.a.m;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.a.c.k;

public abstract class w
  extends c
{
  private static SparseArray a;
  private static SparseArray b;
  private static HashMap c = new HashMap();
  private final SQLiteDatabase d = d.f();
  protected final long f = System.currentTimeMillis() / 1000L;
  protected boolean g = false;
  protected SQLiteDatabase h;
  
  public static void C()
  {
    c.clear();
  }
  
  public static StringBuilder a(StringBuilder paramStringBuilder, String paramString)
  {
    if (k.c(paramString)) {
      return paramStringBuilder;
    }
    if (paramStringBuilder == null)
    {
      paramStringBuilder = new StringBuilder();
      paramStringBuilder.append(" WHERE ");
    }
    for (;;)
    {
      paramStringBuilder.append(" (").append(paramString).append(") ");
      return paramStringBuilder;
      paramStringBuilder.append(" AND ");
    }
  }
  
  protected static Object[] f(int paramInt)
  {
    if (a == null) {
      a = new SparseArray();
    }
    Object[] arrayOfObject = (Object[])a.get(paramInt);
    if (arrayOfObject == null)
    {
      arrayOfObject = new Object[paramInt];
      a.put(paramInt, arrayOfObject);
      return arrayOfObject;
    }
    Arrays.fill(arrayOfObject, null);
    return arrayOfObject;
  }
  
  protected static String[] g(int paramInt)
  {
    if (b == null) {
      b = new SparseArray();
    }
    String[] arrayOfString = (String[])b.get(paramInt);
    if (arrayOfString == null)
    {
      arrayOfString = new String[paramInt];
      b.put(paramInt, arrayOfString);
      return arrayOfString;
    }
    Arrays.fill(arrayOfString, null);
    return arrayOfString;
  }
  
  protected void B() {}
  
  protected void a()
  {
    try
    {
      B();
      if (!this.g)
      {
        this.d.beginTransaction();
        try
        {
          this.h = this.d;
          c_();
          i();
          if ((this.j.get() >= 0) && (!this.g)) {
            this.h.setTransactionSuccessful();
          }
          return;
        }
        finally
        {
          this.h = null;
          this.d.endTransaction();
        }
      }
      return;
    }
    catch (SQLException localSQLException)
    {
      g.s().a(localSQLException);
      throw localSQLException;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      g.s().a(localIllegalStateException);
      throw localIllegalStateException;
    }
    catch (IOException localIOException)
    {
      g.s().a(localIOException, 4);
      throw localIOException;
    }
  }
  
  protected void b(boolean paramBoolean, Throwable paramThrowable) {}
  
  protected abstract void c_();
  
  public x g(String paramString)
  {
    x localx2 = (x)c.get(paramString);
    x localx1 = localx2;
    if (localx2 == null)
    {
      localx1 = new x(this.h.compileStatement(paramString), null);
      c.put(paramString, localx1);
    }
    localx1.a();
    return localx1;
  }
  
  protected void i() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/db/operation/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */