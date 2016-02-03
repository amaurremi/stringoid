package com.amazonaws.org.apache.http.conn.scheme;

import com.amazonaws.org.apache.http.util.LangUtils;
import java.util.Locale;
import org.apache.http.annotation.Immutable;

@Immutable
public final class Scheme
{
  private final int defaultPort;
  private final boolean layered;
  private final String name;
  private final SchemeSocketFactory socketFactory;
  private String stringRep;
  
  public Scheme(String paramString, int paramInt, SchemeSocketFactory paramSchemeSocketFactory)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Scheme name may not be null");
    }
    if ((paramInt <= 0) || (paramInt > 65535)) {
      throw new IllegalArgumentException("Port is invalid: " + paramInt);
    }
    if (paramSchemeSocketFactory == null) {
      throw new IllegalArgumentException("Socket factory may not be null");
    }
    this.name = paramString.toLowerCase(Locale.ENGLISH);
    this.defaultPort = paramInt;
    if ((paramSchemeSocketFactory instanceof SchemeLayeredSocketFactory))
    {
      this.layered = true;
      this.socketFactory = paramSchemeSocketFactory;
      return;
    }
    if ((paramSchemeSocketFactory instanceof LayeredSchemeSocketFactory))
    {
      this.layered = true;
      this.socketFactory = new SchemeLayeredSocketFactoryAdaptor2((LayeredSchemeSocketFactory)paramSchemeSocketFactory);
      return;
    }
    this.layered = false;
    this.socketFactory = paramSchemeSocketFactory;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof Scheme)) {
        break;
      }
      paramObject = (Scheme)paramObject;
    } while ((this.name.equals(((Scheme)paramObject).name)) && (this.defaultPort == ((Scheme)paramObject).defaultPort) && (this.layered == ((Scheme)paramObject).layered));
    return false;
    return false;
  }
  
  public final int getDefaultPort()
  {
    return this.defaultPort;
  }
  
  public final String getName()
  {
    return this.name;
  }
  
  public final SchemeSocketFactory getSchemeSocketFactory()
  {
    return this.socketFactory;
  }
  
  public int hashCode()
  {
    return LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(17, this.defaultPort), this.name), this.layered);
  }
  
  public final boolean isLayered()
  {
    return this.layered;
  }
  
  public final int resolvePort(int paramInt)
  {
    int i = paramInt;
    if (paramInt <= 0) {
      i = this.defaultPort;
    }
    return i;
  }
  
  public final String toString()
  {
    if (this.stringRep == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.name);
      localStringBuilder.append(':');
      localStringBuilder.append(Integer.toString(this.defaultPort));
      this.stringRep = localStringBuilder.toString();
    }
    return this.stringRep;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/conn/scheme/Scheme.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */