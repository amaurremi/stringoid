package com.amazonaws.org.apache.http.message;

import com.amazonaws.org.apache.http.Header;
import com.amazonaws.org.apache.http.HeaderIterator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class HeaderGroup
  implements Serializable, Cloneable
{
  private final List<Header> headers = new ArrayList(16);
  
  public void addHeader(Header paramHeader)
  {
    if (paramHeader == null) {
      return;
    }
    this.headers.add(paramHeader);
  }
  
  public void clear()
  {
    this.headers.clear();
  }
  
  public Object clone()
  {
    HeaderGroup localHeaderGroup = (HeaderGroup)super.clone();
    localHeaderGroup.headers.clear();
    localHeaderGroup.headers.addAll(this.headers);
    return localHeaderGroup;
  }
  
  public boolean containsHeader(String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.headers.size())
      {
        if (((Header)this.headers.get(i)).getName().equalsIgnoreCase(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public Header[] getAllHeaders()
  {
    return (Header[])this.headers.toArray(new Header[this.headers.size()]);
  }
  
  public Header getFirstHeader(String paramString)
  {
    int i = 0;
    while (i < this.headers.size())
    {
      Header localHeader = (Header)this.headers.get(i);
      if (localHeader.getName().equalsIgnoreCase(paramString)) {
        return localHeader;
      }
      i += 1;
    }
    return null;
  }
  
  public Header[] getHeaders(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.headers.size())
    {
      Header localHeader = (Header)this.headers.get(i);
      if (localHeader.getName().equalsIgnoreCase(paramString)) {
        localArrayList.add(localHeader);
      }
      i += 1;
    }
    return (Header[])localArrayList.toArray(new Header[localArrayList.size()]);
  }
  
  public HeaderIterator iterator()
  {
    return new BasicListHeaderIterator(this.headers, null);
  }
  
  public HeaderIterator iterator(String paramString)
  {
    return new BasicListHeaderIterator(this.headers, paramString);
  }
  
  public void setHeaders(Header[] paramArrayOfHeader)
  {
    clear();
    if (paramArrayOfHeader == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramArrayOfHeader.length)
      {
        this.headers.add(paramArrayOfHeader[i]);
        i += 1;
      }
    }
  }
  
  public String toString()
  {
    return this.headers.toString();
  }
  
  public void updateHeader(Header paramHeader)
  {
    if (paramHeader == null) {
      return;
    }
    int i = 0;
    while (i < this.headers.size())
    {
      if (((Header)this.headers.get(i)).getName().equalsIgnoreCase(paramHeader.getName()))
      {
        this.headers.set(i, paramHeader);
        return;
      }
      i += 1;
    }
    this.headers.add(paramHeader);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/message/HeaderGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */