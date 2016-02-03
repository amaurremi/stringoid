package com.google.tagmanager.protobuf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class t
  extends AbstractList<String>
  implements l, RandomAccess
{
  private final l akI;
  
  public t(l paraml)
  {
    this.akI = paraml;
  }
  
  public List<?> BZ()
  {
    return this.akI.BZ();
  }
  
  public void f(e parame)
  {
    throw new UnsupportedOperationException();
  }
  
  public String fr(int paramInt)
  {
    return (String)this.akI.get(paramInt);
  }
  
  public e ft(int paramInt)
  {
    return this.akI.ft(paramInt);
  }
  
  public Iterator<String> iterator()
  {
    new Iterator()
    {
      Iterator<String> ajJ = t.a(t.this).iterator();
      
      public boolean hasNext()
      {
        return this.ajJ.hasNext();
      }
      
      public String next()
      {
        return (String)this.ajJ.next();
      }
      
      public void remove()
      {
        throw new UnsupportedOperationException();
      }
    };
  }
  
  public ListIterator<String> listIterator(final int paramInt)
  {
    new ListIterator()
    {
      ListIterator<String> akJ = t.a(t.this).listIterator(paramInt);
      
      public String Cq()
      {
        return (String)this.akJ.previous();
      }
      
      public void cX(String paramAnonymousString)
      {
        throw new UnsupportedOperationException();
      }
      
      public void cY(String paramAnonymousString)
      {
        throw new UnsupportedOperationException();
      }
      
      public boolean hasNext()
      {
        return this.akJ.hasNext();
      }
      
      public boolean hasPrevious()
      {
        return this.akJ.hasPrevious();
      }
      
      public String next()
      {
        return (String)this.akJ.next();
      }
      
      public int nextIndex()
      {
        return this.akJ.nextIndex();
      }
      
      public int previousIndex()
      {
        return this.akJ.previousIndex();
      }
      
      public void remove()
      {
        throw new UnsupportedOperationException();
      }
    };
  }
  
  public int size()
  {
    return this.akI.size();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/tagmanager/protobuf/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */