package com.ideashower.readitlater.a;

import android.database.sqlite.SQLiteDatabase;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.ideashower.readitlater.e.e;
import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.e.r;
import com.ideashower.readitlater.i.c;
import java.lang.ref.WeakReference;

public class aa
{
  private static final SparseArray a = new SparseArray();
  private static final SparseArray b = new SparseArray();
  private static final SparseIntArray c = new SparseIntArray();
  private static boolean d;
  
  public static e a(int paramInt)
  {
    return a(a, paramInt);
  }
  
  private static e a(SparseArray paramSparseArray, int paramInt)
  {
    Object localObject = (WeakReference)paramSparseArray.get(paramInt);
    if (localObject != null)
    {
      localObject = (e)((WeakReference)localObject).get();
      if (localObject == null) {
        paramSparseArray.remove(paramInt);
      }
      return (e)localObject;
    }
    return null;
  }
  
  public static void a()
  {
    d = true;
  }
  
  public static void a(SQLiteDatabase paramSQLiteDatabase)
  {
    if (d)
    {
      j = a.size();
      i = 0;
      while (i < j)
      {
        WeakReference localWeakReference = (WeakReference)a.valueAt(i);
        if (localWeakReference != null) {
          a((e)localWeakReference.get(), paramSQLiteDatabase);
        }
        i += 1;
      }
    }
    int j = c.size();
    int i = 0;
    while (i < j)
    {
      a(a(c.keyAt(i)), paramSQLiteDatabase);
      i += 1;
    }
    d = false;
    c.clear();
  }
  
  public static void a(ab paramab)
  {
    int j = a.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = (WeakReference)a.valueAt(i);
      if (localObject != null)
      {
        localObject = (e)((WeakReference)localObject).get();
        if ((localObject != null) && (paramab.a((o)localObject)))
        {
          ((e)localObject).b(true);
          c.a((o)localObject);
        }
      }
      i += 1;
    }
  }
  
  public static void a(e parame)
  {
    if (parame.a()) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = a(parame.f());
        if (localObject == null) {
          break;
        }
      } while (!((e)localObject).b());
      ((e)localObject).a(parame);
      ((e)localObject).b(false);
      return;
      parame.a(true);
      localObject = new WeakReference(parame);
      if (parame.h()) {
        a.put(parame.f(), localObject);
      }
    } while (parame.c() <= 0);
    b.put(parame.c(), localObject);
  }
  
  private static void a(e parame, SQLiteDatabase paramSQLiteDatabase)
  {
    if (parame == null) {}
    do
    {
      return;
      int i = parame.al();
      if ((i != 0) && (i != 3) && (!parame.aq())) {
        break;
      }
      parame.b(true);
      parame = r.a(parame.f(), paramSQLiteDatabase);
    } while (parame == null);
    c.a(parame);
    return;
    c.a(parame);
  }
  
  public static void b(int paramInt)
  {
    c.put(paramInt, 1);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/a/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */