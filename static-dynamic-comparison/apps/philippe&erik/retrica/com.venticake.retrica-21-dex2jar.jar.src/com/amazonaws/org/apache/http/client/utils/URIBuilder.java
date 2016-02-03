package com.amazonaws.org.apache.http.client.utils;

import com.amazonaws.org.apache.http.Consts;
import com.amazonaws.org.apache.http.NameValuePair;
import com.amazonaws.org.apache.http.conn.util.InetAddressUtils;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.List;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class URIBuilder
{
  private String encodedAuthority;
  private String encodedFragment;
  private String encodedPath;
  private String encodedQuery;
  private String encodedSchemeSpecificPart;
  private String encodedUserInfo;
  private String fragment;
  private String host;
  private String path;
  private int port;
  private List<NameValuePair> queryParams;
  private String scheme;
  private String userInfo;
  
  public URIBuilder()
  {
    this.port = -1;
  }
  
  public URIBuilder(URI paramURI)
  {
    digestURI(paramURI);
  }
  
  private String buildString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.scheme != null) {
      localStringBuilder.append(this.scheme).append(':');
    }
    if (this.encodedSchemeSpecificPart != null)
    {
      localStringBuilder.append(this.encodedSchemeSpecificPart);
      if (this.encodedFragment == null) {
        break label317;
      }
      localStringBuilder.append("#").append(this.encodedFragment);
    }
    for (;;)
    {
      return localStringBuilder.toString();
      if (this.encodedAuthority != null)
      {
        localStringBuilder.append("//").append(this.encodedAuthority);
        label92:
        if (this.encodedPath == null) {
          break label263;
        }
        localStringBuilder.append(normalizePath(this.encodedPath));
      }
      for (;;)
      {
        if (this.encodedQuery == null) {
          break label289;
        }
        localStringBuilder.append("?").append(this.encodedQuery);
        break;
        if (this.host == null) {
          break label92;
        }
        localStringBuilder.append("//");
        if (this.encodedUserInfo != null)
        {
          localStringBuilder.append(this.encodedUserInfo).append("@");
          label170:
          if (!InetAddressUtils.isIPv6Address(this.host)) {
            break label251;
          }
          localStringBuilder.append("[").append(this.host).append("]");
        }
        for (;;)
        {
          if (this.port < 0) {
            break label261;
          }
          localStringBuilder.append(":").append(this.port);
          break;
          if (this.userInfo == null) {
            break label170;
          }
          localStringBuilder.append(encodeUserInfo(this.userInfo)).append("@");
          break label170;
          label251:
          localStringBuilder.append(this.host);
        }
        label261:
        break label92;
        label263:
        if (this.path != null) {
          localStringBuilder.append(encodePath(normalizePath(this.path)));
        }
      }
      label289:
      if (this.queryParams == null) {
        break;
      }
      localStringBuilder.append("?").append(encodeQuery(this.queryParams));
      break;
      label317:
      if (this.fragment != null) {
        localStringBuilder.append("#").append(encodeFragment(this.fragment));
      }
    }
  }
  
  private void digestURI(URI paramURI)
  {
    this.scheme = paramURI.getScheme();
    this.encodedSchemeSpecificPart = paramURI.getRawSchemeSpecificPart();
    this.encodedAuthority = paramURI.getRawAuthority();
    this.host = paramURI.getHost();
    this.port = paramURI.getPort();
    this.encodedUserInfo = paramURI.getRawUserInfo();
    this.userInfo = paramURI.getUserInfo();
    this.encodedPath = paramURI.getRawPath();
    this.path = paramURI.getPath();
    this.encodedQuery = paramURI.getRawQuery();
    this.queryParams = parseQuery(paramURI.getRawQuery(), Consts.UTF_8);
    this.encodedFragment = paramURI.getRawFragment();
    this.fragment = paramURI.getFragment();
  }
  
  private String encodeFragment(String paramString)
  {
    return URLEncodedUtils.encFragment(paramString, Consts.UTF_8);
  }
  
  private String encodePath(String paramString)
  {
    return URLEncodedUtils.encPath(paramString, Consts.UTF_8);
  }
  
  private String encodeQuery(List<NameValuePair> paramList)
  {
    return URLEncodedUtils.format(paramList, Consts.UTF_8);
  }
  
  private String encodeUserInfo(String paramString)
  {
    return URLEncodedUtils.encUserInfo(paramString, Consts.UTF_8);
  }
  
  private static String normalizePath(String paramString)
  {
    String str;
    if (paramString == null)
    {
      str = null;
      return str;
    }
    int i = 0;
    for (;;)
    {
      if ((i >= paramString.length()) || (paramString.charAt(i) != '/'))
      {
        str = paramString;
        if (i <= 1) {
          break;
        }
        return paramString.substring(i - 1);
      }
      i += 1;
    }
  }
  
  private List<NameValuePair> parseQuery(String paramString, Charset paramCharset)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      return URLEncodedUtils.parse(paramString, paramCharset);
    }
    return null;
  }
  
  public URI build()
  {
    return new URI(buildString());
  }
  
  public String getPath()
  {
    return this.path;
  }
  
  public URIBuilder setFragment(String paramString)
  {
    this.fragment = paramString;
    this.encodedFragment = null;
    return this;
  }
  
  public URIBuilder setHost(String paramString)
  {
    this.host = paramString;
    this.encodedSchemeSpecificPart = null;
    this.encodedAuthority = null;
    return this;
  }
  
  public URIBuilder setPath(String paramString)
  {
    this.path = paramString;
    this.encodedSchemeSpecificPart = null;
    this.encodedPath = null;
    return this;
  }
  
  public URIBuilder setPort(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = -1;
    }
    this.port = i;
    this.encodedSchemeSpecificPart = null;
    this.encodedAuthority = null;
    return this;
  }
  
  public URIBuilder setScheme(String paramString)
  {
    this.scheme = paramString;
    return this;
  }
  
  public URIBuilder setUserInfo(String paramString)
  {
    this.userInfo = paramString;
    this.encodedSchemeSpecificPart = null;
    this.encodedAuthority = null;
    this.encodedUserInfo = null;
    return this;
  }
  
  public String toString()
  {
    return buildString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/client/utils/URIBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */