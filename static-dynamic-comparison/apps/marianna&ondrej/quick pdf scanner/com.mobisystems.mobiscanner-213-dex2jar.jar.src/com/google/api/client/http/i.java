package com.google.api.client.http;

import com.google.api.client.util.GenericData;
import com.google.api.client.util.a.a;
import com.google.api.client.util.a.b;
import com.google.api.client.util.a.c;
import com.google.api.client.util.x;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class i
  extends GenericData
{
  private static final b aaU = new c("=&-_.!~*'()@:$,;/?:", false);
  private String aaV;
  private String aaW;
  private String aaX;
  private List<String> aaY;
  private String fragment;
  private int port = -1;
  
  public i() {}
  
  public i(String paramString)
  {
    this(bN(paramString));
  }
  
  private i(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.aaV = paramString1.toLowerCase();
    this.aaW = paramString2;
    this.port = paramInt;
    this.aaY = bM(paramString3);
    if (paramString4 != null) {}
    for (paramString1 = a.cv(paramString4);; paramString1 = null)
    {
      this.fragment = paramString1;
      if (paramString5 != null) {
        ad.i(paramString5, this);
      }
      paramString1 = (String)localObject;
      if (paramString6 != null) {
        paramString1 = a.cv(paramString6);
      }
      this.aaX = paramString1;
      return;
    }
  }
  
  public i(URI paramURI)
  {
    this(paramURI.getScheme(), paramURI.getHost(), paramURI.getPort(), paramURI.getRawPath(), paramURI.getRawFragment(), paramURI.getRawQuery(), paramURI.getRawUserInfo());
  }
  
  public i(URL paramURL)
  {
    this(paramURL.getProtocol(), paramURL.getHost(), paramURL.getPort(), paramURL.getPath(), paramURL.getRef(), paramURL.getQuery(), paramURL.getUserInfo());
  }
  
  private void a(StringBuilder paramStringBuilder)
  {
    int j = this.aaY.size();
    int i = 0;
    while (i < j)
    {
      String str = (String)this.aaY.get(i);
      if (i != 0) {
        paramStringBuilder.append('/');
      }
      if (str.length() != 0) {
        paramStringBuilder.append(a.cw(str));
      }
      i += 1;
    }
  }
  
  static void a(Set<Map.Entry<String, Object>> paramSet, StringBuilder paramStringBuilder)
  {
    paramSet = paramSet.iterator();
    boolean bool = true;
    Object localObject2;
    Object localObject1;
    if (paramSet.hasNext())
    {
      localObject2 = (Map.Entry)paramSet.next();
      localObject1 = ((Map.Entry)localObject2).getValue();
      if (localObject1 == null) {
        break label115;
      }
      localObject2 = a.cy((String)((Map.Entry)localObject2).getKey());
      if ((localObject1 instanceof Collection))
      {
        localObject1 = ((Collection)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          bool = a(bool, paramStringBuilder, (String)localObject2, ((Iterator)localObject1).next());
        }
      }
    }
    label115:
    for (;;)
    {
      break;
      bool = a(bool, paramStringBuilder, (String)localObject2, localObject1);
      continue;
      return;
    }
  }
  
  private static boolean a(boolean paramBoolean, StringBuilder paramStringBuilder, String paramString, Object paramObject)
  {
    if (paramBoolean)
    {
      paramBoolean = false;
      paramStringBuilder.append('?');
    }
    for (;;)
    {
      paramStringBuilder.append(paramString);
      paramString = a.cy(paramObject.toString());
      if (paramString.length() != 0) {
        paramStringBuilder.append('=').append(paramString);
      }
      return paramBoolean;
      paramStringBuilder.append('&');
    }
  }
  
  public static List<String> bM(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 1;
    int j = 0;
    if (i != 0)
    {
      int k = paramString.indexOf('/', j);
      if (k != -1)
      {
        i = 1;
        label45:
        if (i == 0) {
          break label82;
        }
      }
      label82:
      for (String str = paramString.substring(j, k);; str = paramString.substring(j))
      {
        localArrayList.add(a.cv(str));
        j = k + 1;
        break;
        i = 0;
        break label45;
      }
    }
    return localArrayList;
  }
  
  private static URI bN(String paramString)
  {
    try
    {
      paramString = new URI(paramString);
      return paramString;
    }
    catch (URISyntaxException paramString)
    {
      throw new IllegalArgumentException(paramString);
    }
  }
  
  public final URL bK(String paramString)
  {
    try
    {
      paramString = new URL(toURL(), paramString);
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      throw new IllegalArgumentException(paramString);
    }
  }
  
  public void bL(String paramString)
  {
    this.aaY = bM(paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((!super.equals(paramObject)) || (!(paramObject instanceof i))) {
      return false;
    }
    paramObject = (i)paramObject;
    return xo().equals(((i)paramObject).toString());
  }
  
  public i g(String paramString, Object paramObject)
  {
    return (i)super.set(paramString, paramObject);
  }
  
  public int hashCode()
  {
    return xo().hashCode();
  }
  
  public String toString()
  {
    return xo();
  }
  
  public final URL toURL()
  {
    try
    {
      URL localURL = new URL(xo());
      return localURL;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      throw new IllegalArgumentException(localMalformedURLException);
    }
  }
  
  public i xn()
  {
    i locali = (i)super.clone();
    if (this.aaY != null) {
      locali.aaY = new ArrayList(this.aaY);
    }
    return locali;
  }
  
  public final String xo()
  {
    return xp() + xq();
  }
  
  public final String xp()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)x.ad(this.aaV));
    localStringBuilder.append("://");
    if (this.aaX != null) {
      localStringBuilder.append(a.cx(this.aaX)).append('@');
    }
    localStringBuilder.append((String)x.ad(this.aaW));
    int i = this.port;
    if (i != -1) {
      localStringBuilder.append(':').append(i);
    }
    return localStringBuilder.toString();
  }
  
  public final String xq()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.aaY != null) {
      a(localStringBuilder);
    }
    a(entrySet(), localStringBuilder);
    String str = this.fragment;
    if (str != null) {
      localStringBuilder.append('#').append(aaU.cz(str));
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/http/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */