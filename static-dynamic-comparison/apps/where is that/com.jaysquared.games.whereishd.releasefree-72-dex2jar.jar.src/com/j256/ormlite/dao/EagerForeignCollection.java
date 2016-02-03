package com.j256.ormlite.dao;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.support.DatabaseResults;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class EagerForeignCollection<T, ID>
  extends BaseForeignCollection<T, ID>
  implements ForeignCollection<T>, CloseableWrappedIterable<T>, Serializable
{
  private static final long serialVersionUID = -2523335606983317721L;
  private List<T> results;
  
  public EagerForeignCollection(Dao<T, ID> paramDao, Object paramObject1, Object paramObject2, FieldType paramFieldType, String paramString, boolean paramBoolean)
    throws SQLException
  {
    super(paramDao, paramObject1, paramObject2, paramFieldType, paramString, paramBoolean);
    if (paramObject2 == null)
    {
      this.results = new ArrayList();
      return;
    }
    this.results = paramDao.query(getPreparedQuery());
  }
  
  public boolean add(T paramT)
  {
    if (this.results.add(paramT)) {
      return super.add(paramT);
    }
    return false;
  }
  
  public boolean addAll(Collection<? extends T> paramCollection)
  {
    if (this.results.addAll(paramCollection)) {
      return super.addAll(paramCollection);
    }
    return false;
  }
  
  public void close() {}
  
  public void closeLastIterator() {}
  
  public CloseableIterator<T> closeableIterator()
  {
    return iteratorThrow(-1);
  }
  
  public CloseableIterator<T> closeableIterator(int paramInt)
  {
    return iteratorThrow(-1);
  }
  
  public boolean contains(Object paramObject)
  {
    return this.results.contains(paramObject);
  }
  
  public boolean containsAll(Collection<?> paramCollection)
  {
    return this.results.containsAll(paramCollection);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof EagerForeignCollection)) {
      return false;
    }
    paramObject = (EagerForeignCollection)paramObject;
    return this.results.equals(((EagerForeignCollection)paramObject).results);
  }
  
  public CloseableWrappedIterable<T> getWrappedIterable()
  {
    return this;
  }
  
  public CloseableWrappedIterable<T> getWrappedIterable(int paramInt)
  {
    return this;
  }
  
  public int hashCode()
  {
    return this.results.hashCode();
  }
  
  public boolean isEager()
  {
    return true;
  }
  
  public boolean isEmpty()
  {
    return this.results.isEmpty();
  }
  
  public CloseableIterator<T> iterator()
  {
    return iteratorThrow(-1);
  }
  
  public CloseableIterator<T> iterator(int paramInt)
  {
    return iteratorThrow(paramInt);
  }
  
  public CloseableIterator<T> iteratorThrow()
  {
    return iteratorThrow(-1);
  }
  
  public CloseableIterator<T> iteratorThrow(int paramInt)
  {
    new CloseableIterator()
    {
      private int offset = -1;
      
      public void close() {}
      
      public void closeQuietly() {}
      
      public T current()
      {
        if (this.offset < 0) {
          this.offset = 0;
        }
        if (this.offset >= EagerForeignCollection.this.results.size()) {
          return null;
        }
        return (T)EagerForeignCollection.this.results.get(this.offset);
      }
      
      public T first()
      {
        this.offset = 0;
        if (this.offset >= EagerForeignCollection.this.results.size()) {
          return null;
        }
        return (T)EagerForeignCollection.this.results.get(0);
      }
      
      public DatabaseResults getRawResults()
      {
        return null;
      }
      
      public boolean hasNext()
      {
        return this.offset + 1 < EagerForeignCollection.this.results.size();
      }
      
      public T moveRelative(int paramAnonymousInt)
      {
        this.offset += paramAnonymousInt;
        if ((this.offset < 0) || (this.offset >= EagerForeignCollection.this.results.size())) {
          return null;
        }
        return (T)EagerForeignCollection.this.results.get(this.offset);
      }
      
      public void moveToNext()
      {
        this.offset += 1;
      }
      
      public T next()
      {
        this.offset += 1;
        return (T)EagerForeignCollection.this.results.get(this.offset);
      }
      
      public T nextThrow()
      {
        this.offset += 1;
        if (this.offset >= EagerForeignCollection.this.results.size()) {
          return null;
        }
        return (T)EagerForeignCollection.this.results.get(this.offset);
      }
      
      public T previous()
      {
        this.offset -= 1;
        if ((this.offset < 0) || (this.offset >= EagerForeignCollection.this.results.size())) {
          return null;
        }
        return (T)EagerForeignCollection.this.results.get(this.offset);
      }
      
      public void remove()
      {
        if (this.offset < 0) {
          throw new IllegalStateException("next() must be called before remove()");
        }
        if (this.offset >= EagerForeignCollection.this.results.size()) {
          throw new IllegalStateException("current results position (" + this.offset + ") is out of bounds");
        }
        Object localObject = EagerForeignCollection.this.results.remove(this.offset);
        this.offset -= 1;
        if (EagerForeignCollection.this.dao != null) {}
        try
        {
          EagerForeignCollection.this.dao.delete(localObject);
          return;
        }
        catch (SQLException localSQLException)
        {
          throw new RuntimeException(localSQLException);
        }
      }
    };
  }
  
  public int refreshAll()
    throws SQLException
  {
    int i = 0;
    Iterator localIterator = this.results.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      i += this.dao.refresh(localObject);
    }
    return i;
  }
  
  public int refreshCollection()
    throws SQLException
  {
    this.results = this.dao.query(getPreparedQuery());
    return this.results.size();
  }
  
  public boolean remove(Object paramObject)
  {
    boolean bool = true;
    if ((!this.results.remove(paramObject)) || (this.dao == null)) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        int i = this.dao.delete(paramObject);
        if (i == 1) {
          continue;
        }
        return false;
      }
      catch (SQLException paramObject)
      {
        throw new IllegalStateException("Could not delete data element from dao", (Throwable)paramObject);
      }
    }
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    boolean bool = false;
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (remove(paramCollection.next())) {
        bool = true;
      }
    }
    return bool;
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    return super.retainAll(paramCollection);
  }
  
  public int size()
  {
    return this.results.size();
  }
  
  public Object[] toArray()
  {
    return this.results.toArray();
  }
  
  public <E> E[] toArray(E[] paramArrayOfE)
  {
    return this.results.toArray(paramArrayOfE);
  }
  
  public int updateAll()
    throws SQLException
  {
    int i = 0;
    Iterator localIterator = this.results.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      i += this.dao.update(localObject);
    }
    return i;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/dao/EagerForeignCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */