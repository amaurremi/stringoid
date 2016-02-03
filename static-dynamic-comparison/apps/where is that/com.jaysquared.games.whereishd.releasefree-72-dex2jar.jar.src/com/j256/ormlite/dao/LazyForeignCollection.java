package com.j256.ormlite.dao;

import com.j256.ormlite.field.FieldType;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LazyForeignCollection<T, ID>
  extends BaseForeignCollection<T, ID>
  implements ForeignCollection<T>, Serializable
{
  private static final long serialVersionUID = -5460708106909626233L;
  private transient CloseableIterator<T> lastIterator;
  
  public LazyForeignCollection(Dao<T, ID> paramDao, Object paramObject1, Object paramObject2, FieldType paramFieldType, String paramString, boolean paramBoolean)
  {
    super(paramDao, paramObject1, paramObject2, paramFieldType, paramString, paramBoolean);
  }
  
  private CloseableIterator<T> seperateIteratorThrow(int paramInt)
    throws SQLException
  {
    if (this.dao == null) {
      throw new IllegalStateException("Internal DAO object is null.  Lazy collections cannot be used if they have been deserialized.");
    }
    return this.dao.iterator(getPreparedQuery(), paramInt);
  }
  
  public void closeLastIterator()
    throws SQLException
  {
    if (this.lastIterator != null)
    {
      this.lastIterator.close();
      this.lastIterator = null;
    }
  }
  
  public CloseableIterator<T> closeableIterator()
  {
    return closeableIterator(-1);
  }
  
  public CloseableIterator<T> closeableIterator(int paramInt)
  {
    try
    {
      CloseableIterator localCloseableIterator = iteratorThrow(paramInt);
      return localCloseableIterator;
    }
    catch (SQLException localSQLException)
    {
      throw new IllegalStateException("Could not build lazy iterator for " + this.dao.getDataClass(), localSQLException);
    }
  }
  
  /* Error */
  public boolean contains(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 101	com/j256/ormlite/dao/LazyForeignCollection:iterator	()Lcom/j256/ormlite/dao/CloseableIterator;
    //   4: astore_3
    //   5: aload_3
    //   6: invokeinterface 105 1 0
    //   11: ifeq +26 -> 37
    //   14: aload_3
    //   15: invokeinterface 109 1 0
    //   20: aload_1
    //   21: invokevirtual 114	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   24: istore_2
    //   25: iload_2
    //   26: ifeq -21 -> 5
    //   29: aload_3
    //   30: invokeinterface 65 1 0
    //   35: iconst_1
    //   36: ireturn
    //   37: aload_3
    //   38: invokeinterface 65 1 0
    //   43: iconst_0
    //   44: ireturn
    //   45: astore_1
    //   46: iconst_0
    //   47: ireturn
    //   48: astore_1
    //   49: aload_3
    //   50: invokeinterface 65 1 0
    //   55: aload_1
    //   56: athrow
    //   57: astore_1
    //   58: iconst_1
    //   59: ireturn
    //   60: astore_3
    //   61: goto -6 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	LazyForeignCollection
    //   0	64	1	paramObject	Object
    //   24	2	2	bool	boolean
    //   4	46	3	localCloseableIterator	CloseableIterator
    //   60	1	3	localSQLException	SQLException
    // Exception table:
    //   from	to	target	type
    //   37	43	45	java/sql/SQLException
    //   5	25	48	finally
    //   29	35	57	java/sql/SQLException
    //   49	55	60	java/sql/SQLException
  }
  
  public boolean containsAll(Collection<?> paramCollection)
  {
    HashSet localHashSet = new HashSet(paramCollection);
    paramCollection = iterator();
    try
    {
      while (paramCollection.hasNext()) {
        localHashSet.remove(paramCollection.next());
      }
      try
      {
        paramCollection.close();
        throw ((Throwable)localObject);
        boolean bool = ((Set)localObject).isEmpty();
        try
        {
          paramCollection.close();
          return bool;
        }
        catch (SQLException paramCollection)
        {
          return bool;
        }
      }
      catch (SQLException paramCollection)
      {
        for (;;) {}
      }
    }
    finally {}
  }
  
  public boolean equals(Object paramObject)
  {
    return super.equals(paramObject);
  }
  
  public CloseableWrappedIterable<T> getWrappedIterable()
  {
    return getWrappedIterable(-1);
  }
  
  public CloseableWrappedIterable<T> getWrappedIterable(final int paramInt)
  {
    new CloseableWrappedIterableImpl(new CloseableIterable()
    {
      public CloseableIterator<T> closeableIterator()
      {
        try
        {
          CloseableIterator localCloseableIterator = LazyForeignCollection.this.seperateIteratorThrow(paramInt);
          return localCloseableIterator;
        }
        catch (Exception localException)
        {
          throw new IllegalStateException("Could not build lazy iterator for " + LazyForeignCollection.this.dao.getDataClass(), localException);
        }
      }
      
      public CloseableIterator<T> iterator()
      {
        return closeableIterator();
      }
    });
  }
  
  public int hashCode()
  {
    return super.hashCode();
  }
  
  public boolean isEager()
  {
    return false;
  }
  
  /* Error */
  public boolean isEmpty()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 101	com/j256/ormlite/dao/LazyForeignCollection:iterator	()Lcom/j256/ormlite/dao/CloseableIterator;
    //   4: astore_3
    //   5: aload_3
    //   6: invokeinterface 105 1 0
    //   11: istore_1
    //   12: iload_1
    //   13: ifne +13 -> 26
    //   16: iconst_1
    //   17: istore_1
    //   18: aload_3
    //   19: invokeinterface 65 1 0
    //   24: iload_1
    //   25: ireturn
    //   26: iconst_0
    //   27: istore_1
    //   28: goto -10 -> 18
    //   31: astore_2
    //   32: aload_3
    //   33: invokeinterface 65 1 0
    //   38: aload_2
    //   39: athrow
    //   40: astore_2
    //   41: iload_1
    //   42: ireturn
    //   43: astore_3
    //   44: goto -6 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	LazyForeignCollection
    //   11	31	1	bool	boolean
    //   31	8	2	localObject	Object
    //   40	1	2	localSQLException1	SQLException
    //   4	29	3	localCloseableIterator	CloseableIterator
    //   43	1	3	localSQLException2	SQLException
    // Exception table:
    //   from	to	target	type
    //   5	12	31	finally
    //   18	24	40	java/sql/SQLException
    //   32	38	43	java/sql/SQLException
  }
  
  public CloseableIterator<T> iterator()
  {
    return closeableIterator(-1);
  }
  
  public CloseableIterator<T> iterator(int paramInt)
  {
    return closeableIterator(paramInt);
  }
  
  public CloseableIterator<T> iteratorThrow()
    throws SQLException
  {
    return iteratorThrow(-1);
  }
  
  public CloseableIterator<T> iteratorThrow(int paramInt)
    throws SQLException
  {
    this.lastIterator = seperateIteratorThrow(paramInt);
    return this.lastIterator;
  }
  
  public int refreshAll()
  {
    throw new UnsupportedOperationException("Cannot call updateAll() on a lazy collection.");
  }
  
  public int refreshCollection()
  {
    return 0;
  }
  
  /* Error */
  public boolean remove(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 101	com/j256/ormlite/dao/LazyForeignCollection:iterator	()Lcom/j256/ormlite/dao/CloseableIterator;
    //   4: astore_2
    //   5: aload_2
    //   6: invokeinterface 105 1 0
    //   11: ifeq +30 -> 41
    //   14: aload_2
    //   15: invokeinterface 109 1 0
    //   20: aload_1
    //   21: invokevirtual 114	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   24: ifeq -19 -> 5
    //   27: aload_2
    //   28: invokeinterface 160 1 0
    //   33: aload_2
    //   34: invokeinterface 65 1 0
    //   39: iconst_1
    //   40: ireturn
    //   41: aload_2
    //   42: invokeinterface 65 1 0
    //   47: iconst_0
    //   48: ireturn
    //   49: astore_1
    //   50: iconst_0
    //   51: ireturn
    //   52: astore_1
    //   53: aload_2
    //   54: invokeinterface 65 1 0
    //   59: aload_1
    //   60: athrow
    //   61: astore_1
    //   62: iconst_1
    //   63: ireturn
    //   64: astore_2
    //   65: goto -6 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	LazyForeignCollection
    //   0	68	1	paramObject	Object
    //   4	50	2	localCloseableIterator	CloseableIterator
    //   64	1	2	localSQLException	SQLException
    // Exception table:
    //   from	to	target	type
    //   41	47	49	java/sql/SQLException
    //   5	33	52	finally
    //   33	39	61	java/sql/SQLException
    //   53	59	64	java/sql/SQLException
  }
  
  /* Error */
  public boolean removeAll(Collection<?> paramCollection)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: invokevirtual 101	com/j256/ormlite/dao/LazyForeignCollection:iterator	()Lcom/j256/ormlite/dao/CloseableIterator;
    //   6: astore_3
    //   7: aload_3
    //   8: invokeinterface 105 1 0
    //   13: ifeq +29 -> 42
    //   16: aload_1
    //   17: aload_3
    //   18: invokeinterface 109 1 0
    //   23: invokeinterface 165 2 0
    //   28: ifeq -21 -> 7
    //   31: aload_3
    //   32: invokeinterface 160 1 0
    //   37: iconst_1
    //   38: istore_2
    //   39: goto -32 -> 7
    //   42: aload_3
    //   43: invokeinterface 65 1 0
    //   48: iload_2
    //   49: ireturn
    //   50: astore_1
    //   51: aload_3
    //   52: invokeinterface 65 1 0
    //   57: aload_1
    //   58: athrow
    //   59: astore_1
    //   60: iload_2
    //   61: ireturn
    //   62: astore_3
    //   63: goto -6 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	LazyForeignCollection
    //   0	66	1	paramCollection	Collection<?>
    //   1	60	2	bool	boolean
    //   6	46	3	localCloseableIterator	CloseableIterator
    //   62	1	3	localSQLException	SQLException
    // Exception table:
    //   from	to	target	type
    //   7	37	50	finally
    //   42	48	59	java/sql/SQLException
    //   51	57	62	java/sql/SQLException
  }
  
  /* Error */
  public int size()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 101	com/j256/ormlite/dao/LazyForeignCollection:iterator	()Lcom/j256/ormlite/dao/CloseableIterator;
    //   4: astore_3
    //   5: iconst_0
    //   6: istore_1
    //   7: aload_3
    //   8: invokeinterface 105 1 0
    //   13: ifeq +16 -> 29
    //   16: aload_3
    //   17: invokeinterface 169 1 0
    //   22: iload_1
    //   23: iconst_1
    //   24: iadd
    //   25: istore_1
    //   26: goto -19 -> 7
    //   29: aload_3
    //   30: invokeinterface 65 1 0
    //   35: iload_1
    //   36: ireturn
    //   37: astore_2
    //   38: aload_3
    //   39: invokeinterface 65 1 0
    //   44: aload_2
    //   45: athrow
    //   46: astore_2
    //   47: iload_1
    //   48: ireturn
    //   49: astore_3
    //   50: goto -6 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	LazyForeignCollection
    //   6	42	1	i	int
    //   37	8	2	localObject	Object
    //   46	1	2	localSQLException1	SQLException
    //   4	35	3	localCloseableIterator	CloseableIterator
    //   49	1	3	localSQLException2	SQLException
    // Exception table:
    //   from	to	target	type
    //   7	22	37	finally
    //   29	35	46	java/sql/SQLException
    //   38	44	49	java/sql/SQLException
  }
  
  public Object[] toArray()
  {
    ArrayList localArrayList = new ArrayList();
    localCloseableIterator = iterator();
    try
    {
      while (localCloseableIterator.hasNext()) {
        localArrayList.add(localCloseableIterator.next());
      }
      try
      {
        localCloseableIterator.close();
        throw ((Throwable)localObject);
        Object[] arrayOfObject = ((List)localObject).toArray();
        try
        {
          localCloseableIterator.close();
          return arrayOfObject;
        }
        catch (SQLException localSQLException1)
        {
          return arrayOfObject;
        }
      }
      catch (SQLException localSQLException2)
      {
        for (;;) {}
      }
    }
    finally {}
  }
  
  public <E> E[] toArray(E[] paramArrayOfE)
  {
    i = 0;
    localCloseableIterator = iterator();
    localObject1 = null;
    for (;;)
    {
      try
      {
        if (localCloseableIterator.hasNext())
        {
          localObject2 = localCloseableIterator.next();
          if (i >= paramArrayOfE.length)
          {
            if (localObject1 != null) {
              continue;
            }
            localArrayList = new ArrayList();
          }
        }
      }
      finally
      {
        try
        {
          Object localObject2;
          ArrayList localArrayList;
          int k;
          int j;
          localCloseableIterator.close();
          if (localObject1 == null)
          {
            if (i < paramArrayOfE.length - 1) {
              paramArrayOfE[i] = null;
            }
            return paramArrayOfE;
            paramArrayOfE = finally;
          }
        }
        catch (SQLException localSQLException2)
        {
          try
          {
            localCloseableIterator.close();
            throw paramArrayOfE;
            return ((List)localObject1).toArray(paramArrayOfE);
            localSQLException2 = localSQLException2;
          }
          catch (SQLException localSQLException1)
          {
            continue;
          }
        }
        continue;
      }
      try
      {
        k = paramArrayOfE.length;
        j = 0;
        localObject1 = localArrayList;
        if (j < k)
        {
          localArrayList.add(paramArrayOfE[j]);
          j += 1;
          continue;
        }
        ((List)localObject1).add(localObject2);
        i += 1;
      }
      finally
      {
        continue;
      }
      paramArrayOfE[i] = localObject2;
    }
  }
  
  public int updateAll()
  {
    throw new UnsupportedOperationException("Cannot call updateAll() on a lazy collection.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/dao/LazyForeignCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */