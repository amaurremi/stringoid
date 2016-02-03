package com.amazonaws.org.apache.http.impl.client;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class RedirectLocations
{
  private final List<URI> all = new ArrayList();
  private final Set<URI> unique = new HashSet();
  
  public void add(URI paramURI)
  {
    this.unique.add(paramURI);
    this.all.add(paramURI);
  }
  
  public boolean contains(URI paramURI)
  {
    return this.unique.contains(paramURI);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/client/RedirectLocations.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */