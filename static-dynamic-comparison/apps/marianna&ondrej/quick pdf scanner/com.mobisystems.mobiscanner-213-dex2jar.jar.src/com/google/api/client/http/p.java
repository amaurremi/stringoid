package com.google.api.client.http;

import com.google.api.client.util.x;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class p
{
  private static final Pattern abh = Pattern.compile("[\\w!#$&.+\\-\\^_]+|[*]");
  private static final Pattern abi = Pattern.compile("[\\p{ASCII}&&[^\\p{Cntrl} ;/=\\[\\]\\(\\)\\<\\>\\@\\,\\:\\\"\\?\\=]]+");
  private static final Pattern abj = Pattern.compile("\\s*(" + "[^\\s/=;\"]+" + ")/(" + "[^\\s/=;\"]+" + ")" + "\\s*(" + ";.*" + ")?", 32);
  private static final Pattern abk;
  private String abl = "octet-stream";
  private final SortedMap<String, String> abm = new TreeMap();
  private String abn;
  private String type = "application";
  
  static
  {
    String str = "\"([^\"]*)\"" + "|" + "[^\\s;\"]*";
    abk = Pattern.compile("\\s*;\\s*(" + "[^\\s/=;\"]+" + ")" + "=(" + str + ")");
  }
  
  public p(String paramString)
  {
    cb(paramString);
  }
  
  private p cb(String paramString)
  {
    paramString = abj.matcher(paramString);
    x.d(paramString.matches(), "Type must be in the 'maintype/subtype; parameter=value' format");
    bZ(paramString.group(1));
    ca(paramString.group(2));
    paramString = paramString.group(3);
    if (paramString != null)
    {
      Matcher localMatcher = abk.matcher(paramString);
      while (localMatcher.find())
      {
        String str2 = localMatcher.group(1);
        String str1 = localMatcher.group(3);
        paramString = str1;
        if (str1 == null) {
          paramString = localMatcher.group(2);
        }
        j(str2, paramString);
      }
    }
    return this;
  }
  
  static boolean cd(String paramString)
  {
    return abi.matcher(paramString).matches();
  }
  
  private static String ce(String paramString)
  {
    paramString = paramString.replace("\\", "\\\\").replace("\"", "\\\"");
    return "\"" + paramString + "\"";
  }
  
  public static boolean k(String paramString1, String paramString2)
  {
    return ((paramString1 == null) && (paramString2 == null)) || ((paramString1 != null) && (paramString2 != null) && (new p(paramString1).a(new p(paramString2))));
  }
  
  public p a(Charset paramCharset)
  {
    if (paramCharset == null) {}
    for (paramCharset = null;; paramCharset = paramCharset.name())
    {
      j("charset", paramCharset);
      return this;
    }
  }
  
  public boolean a(p paramp)
  {
    return (paramp != null) && (getType().equalsIgnoreCase(paramp.getType())) && (xv().equalsIgnoreCase(paramp.xv()));
  }
  
  public p bZ(String paramString)
  {
    x.d(abh.matcher(paramString).matches(), "Type contains reserved characters");
    this.type = paramString;
    this.abn = null;
    return this;
  }
  
  public p ca(String paramString)
  {
    x.d(abh.matcher(paramString).matches(), "Subtype contains reserved characters");
    this.abl = paramString;
    this.abn = null;
    return this;
  }
  
  public p cc(String paramString)
  {
    this.abn = null;
    this.abm.remove(paramString.toLowerCase());
    return this;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof p)) {}
    do
    {
      return false;
      paramObject = (p)paramObject;
    } while ((!a((p)paramObject)) || (!this.abm.equals(((p)paramObject).abm)));
    return true;
  }
  
  public String getParameter(String paramString)
  {
    return (String)this.abm.get(paramString.toLowerCase());
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public int hashCode()
  {
    return xo().hashCode();
  }
  
  public p j(String paramString1, String paramString2)
  {
    if (paramString2 == null)
    {
      cc(paramString1);
      return this;
    }
    x.d(abi.matcher(paramString1).matches(), "Name contains reserved characters");
    this.abn = null;
    this.abm.put(paramString1.toLowerCase(), paramString2);
    return this;
  }
  
  public String toString()
  {
    return xo();
  }
  
  public String xo()
  {
    if (this.abn != null) {
      return this.abn;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.type);
    localStringBuilder.append('/');
    localStringBuilder.append(this.abl);
    if (this.abm != null)
    {
      Iterator localIterator = this.abm.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        String str = (String)((Map.Entry)localObject).getValue();
        localStringBuilder.append("; ");
        localStringBuilder.append((String)((Map.Entry)localObject).getKey());
        localStringBuilder.append("=");
        localObject = str;
        if (!cd(str)) {
          localObject = ce(str);
        }
        localStringBuilder.append((String)localObject);
      }
    }
    this.abn = localStringBuilder.toString();
    return this.abn;
  }
  
  public String xv()
  {
    return this.abl;
  }
  
  public Charset xw()
  {
    String str = getParameter("charset");
    if (str == null) {
      return null;
    }
    return Charset.forName(str);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/http/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */