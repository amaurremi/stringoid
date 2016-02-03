package com.google.api.client.b.a.a.a.a;

import java.io.IOException;
import java.util.Iterator;

public class a
{
  private final String separator;
  
  private a(String paramString)
  {
    this.separator = ((String)c.ad(paramString));
  }
  
  public static a a(char paramChar)
  {
    return new a(String.valueOf(paramChar));
  }
  
  public <A extends Appendable> A a(A paramA, Iterator<?> paramIterator)
  {
    c.ad(paramA);
    if (paramIterator.hasNext())
    {
      paramA.append(ac(paramIterator.next()));
      while (paramIterator.hasNext())
      {
        paramA.append(this.separator);
        paramA.append(ac(paramIterator.next()));
      }
    }
    return paramA;
  }
  
  public final String a(Iterable<?> paramIterable)
  {
    return a(paramIterable.iterator());
  }
  
  public final String a(Iterator<?> paramIterator)
  {
    return a(new StringBuilder(), paramIterator).toString();
  }
  
  public final StringBuilder a(StringBuilder paramStringBuilder, Iterator<?> paramIterator)
  {
    try
    {
      a(paramStringBuilder, paramIterator);
      return paramStringBuilder;
    }
    catch (IOException paramStringBuilder)
    {
      throw new AssertionError(paramStringBuilder);
    }
  }
  
  CharSequence ac(Object paramObject)
  {
    c.ad(paramObject);
    if ((paramObject instanceof CharSequence)) {
      return (CharSequence)paramObject;
    }
    return paramObject.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/b/a/a/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */