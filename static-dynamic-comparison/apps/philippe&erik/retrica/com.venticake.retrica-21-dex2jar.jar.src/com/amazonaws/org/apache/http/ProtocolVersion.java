package com.amazonaws.org.apache.http;

import java.io.Serializable;
import org.apache.http.annotation.Immutable;

@Immutable
public class ProtocolVersion
  implements Serializable, Cloneable
{
  protected final int major;
  protected final int minor;
  protected final String protocol;
  
  public ProtocolVersion(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Protocol name must not be null.");
    }
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("Protocol major version number must not be negative.");
    }
    if (paramInt2 < 0) {
      throw new IllegalArgumentException("Protocol minor version number may not be negative");
    }
    this.protocol = paramString;
    this.major = paramInt1;
    this.minor = paramInt2;
  }
  
  public Object clone()
  {
    return super.clone();
  }
  
  public int compareToVersion(ProtocolVersion paramProtocolVersion)
  {
    if (paramProtocolVersion == null) {
      throw new IllegalArgumentException("Protocol version must not be null.");
    }
    if (!this.protocol.equals(paramProtocolVersion.protocol)) {
      throw new IllegalArgumentException("Versions for different protocols cannot be compared. " + this + " " + paramProtocolVersion);
    }
    int j = getMajor() - paramProtocolVersion.getMajor();
    int i = j;
    if (j == 0) {
      i = getMinor() - paramProtocolVersion.getMinor();
    }
    return i;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof ProtocolVersion)) {
        return false;
      }
      paramObject = (ProtocolVersion)paramObject;
    } while ((this.protocol.equals(((ProtocolVersion)paramObject).protocol)) && (this.major == ((ProtocolVersion)paramObject).major) && (this.minor == ((ProtocolVersion)paramObject).minor));
    return false;
  }
  
  public ProtocolVersion forVersion(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == this.major) && (paramInt2 == this.minor)) {
      return this;
    }
    return new ProtocolVersion(this.protocol, paramInt1, paramInt2);
  }
  
  public final int getMajor()
  {
    return this.major;
  }
  
  public final int getMinor()
  {
    return this.minor;
  }
  
  public final String getProtocol()
  {
    return this.protocol;
  }
  
  public final int hashCode()
  {
    return this.protocol.hashCode() ^ this.major * 100000 ^ this.minor;
  }
  
  public boolean isComparable(ProtocolVersion paramProtocolVersion)
  {
    return (paramProtocolVersion != null) && (this.protocol.equals(paramProtocolVersion.protocol));
  }
  
  public final boolean lessEquals(ProtocolVersion paramProtocolVersion)
  {
    return (isComparable(paramProtocolVersion)) && (compareToVersion(paramProtocolVersion) <= 0);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.protocol);
    localStringBuilder.append('/');
    localStringBuilder.append(Integer.toString(this.major));
    localStringBuilder.append('.');
    localStringBuilder.append(Integer.toString(this.minor));
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/ProtocolVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */