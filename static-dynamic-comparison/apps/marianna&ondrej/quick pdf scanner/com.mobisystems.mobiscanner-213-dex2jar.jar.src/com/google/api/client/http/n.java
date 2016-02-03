package com.google.api.client.http;

import com.google.api.client.util.GenericData;
import com.google.api.client.util.GenericData.Flags;
import com.google.api.client.util.ab;
import com.google.api.client.util.ad;
import com.google.api.client.util.ae;
import com.google.api.client.util.b;
import com.google.api.client.util.h;
import com.google.api.client.util.i;
import com.google.api.client.util.l;
import com.google.api.client.util.o;
import com.google.api.client.util.x;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class n
  extends GenericData
{
  @o(yS="Accept")
  private List<String> accept;
  @o(yS="Accept-Encoding")
  private List<String> acceptEncoding = new ArrayList(Collections.singleton("gzip"));
  @o(yS="Age")
  private List<Long> age;
  @o(yS="WWW-Authenticate")
  private List<String> authenticate;
  @o(yS="Authorization")
  private List<String> authorization;
  @o(yS="Cache-Control")
  private List<String> cacheControl;
  @o(yS="Content-Encoding")
  private List<String> contentEncoding;
  @o(yS="Content-Length")
  private List<Long> contentLength;
  @o(yS="Content-MD5")
  private List<String> contentMD5;
  @o(yS="Content-Range")
  private List<String> contentRange;
  @o(yS="Content-Type")
  private List<String> contentType;
  @o(yS="Cookie")
  private List<String> cookie;
  @o(yS="Date")
  private List<String> date;
  @o(yS="ETag")
  private List<String> etag;
  @o(yS="Expires")
  private List<String> expires;
  @o(yS="If-Match")
  private List<String> ifMatch;
  @o(yS="If-Modified-Since")
  private List<String> ifModifiedSince;
  @o(yS="If-None-Match")
  private List<String> ifNoneMatch;
  @o(yS="If-Range")
  private List<String> ifRange;
  @o(yS="If-Unmodified-Since")
  private List<String> ifUnmodifiedSince;
  @o(yS="Last-Modified")
  private List<String> lastModified;
  @o(yS="Location")
  private List<String> location;
  @o(yS="MIME-Version")
  private List<String> mimeVersion;
  @o(yS="Range")
  private List<String> range;
  @o(yS="Retry-After")
  private List<String> retryAfter;
  @o(yS="User-Agent")
  private List<String> userAgent;
  
  public n()
  {
    super(EnumSet.of(GenericData.Flags.adV));
  }
  
  private static String W(Object paramObject)
  {
    if ((paramObject instanceof Enum)) {
      return l.a((Enum)paramObject).getName();
    }
    return paramObject.toString();
  }
  
  private <T> List<T> X(T paramT)
  {
    if (paramT == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramT);
    return localArrayList;
  }
  
  private static Object a(Type paramType, List<Type> paramList, String paramString)
  {
    return i.a(i.a(paramList, paramType), paramString);
  }
  
  static void a(n paramn, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, Logger paramLogger, z paramz)
  {
    a(paramn, paramStringBuilder1, paramStringBuilder2, paramLogger, paramz, null);
  }
  
  static void a(n paramn, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, Logger paramLogger, z paramz, Writer paramWriter)
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramn.entrySet().iterator();
    Object localObject1;
    String str;
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject1 = (Map.Entry)localIterator.next();
      str = (String)((Map.Entry)localObject1).getKey();
      x.b(localHashSet.add(str), "multiple headers of the same name (headers are case insensitive): %s", new Object[] { str });
      localObject1 = ((Map.Entry)localObject1).getValue();
      if (localObject1 != null)
      {
        localObject2 = paramn.getClassInfo().cs(str);
        if (localObject2 == null) {
          break label207;
        }
        str = ((l)localObject2).getName();
      }
    }
    label207:
    for (;;)
    {
      localObject2 = localObject1.getClass();
      if (((localObject1 instanceof Iterable)) || (((Class)localObject2).isArray()))
      {
        localObject1 = ae.ak(localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          a(paramLogger, paramStringBuilder1, paramStringBuilder2, paramz, str, ((Iterator)localObject1).next(), paramWriter);
        }
        break;
      }
      a(paramLogger, paramStringBuilder1, paramStringBuilder2, paramz, str, localObject1, paramWriter);
      break;
      if (paramWriter != null) {
        paramWriter.flush();
      }
      return;
    }
  }
  
  public static void a(n paramn, StringBuilder paramStringBuilder, Logger paramLogger, Writer paramWriter)
  {
    a(paramn, paramStringBuilder, null, paramLogger, null, paramWriter);
  }
  
  private static void a(Logger paramLogger, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, z paramz, String paramString, Object paramObject, Writer paramWriter)
  {
    if ((paramObject == null) || (i.ag(paramObject))) {
      return;
    }
    paramObject = W(paramObject);
    if ((("Authorization".equalsIgnoreCase(paramString)) || ("Cookie".equalsIgnoreCase(paramString))) && ((paramLogger == null) || (!paramLogger.isLoggable(Level.ALL)))) {}
    for (paramLogger = "<Not Logged>";; paramLogger = (Logger)paramObject)
    {
      if (paramStringBuilder1 != null)
      {
        paramStringBuilder1.append(paramString).append(": ");
        paramStringBuilder1.append(paramLogger);
        paramStringBuilder1.append(ab.aeg);
      }
      if (paramStringBuilder2 != null) {
        paramStringBuilder2.append(" -H '").append(paramString).append(": ").append(paramLogger).append("'");
      }
      if (paramz != null) {
        paramz.addHeader(paramString, (String)paramObject);
      }
      if (paramWriter == null) {
        break;
      }
      paramWriter.write(paramString);
      paramWriter.write(": ");
      paramWriter.write((String)paramObject);
      paramWriter.write("\r\n");
      return;
    }
  }
  
  private <T> T i(List<T> paramList)
  {
    if (paramList == null) {
      return null;
    }
    return (T)paramList.get(0);
  }
  
  public n a(Long paramLong)
  {
    this.contentLength = X(paramLong);
    return this;
  }
  
  public final void a(aa paramaa, StringBuilder paramStringBuilder)
  {
    clear();
    paramStringBuilder = new b(this, paramStringBuilder);
    int j = paramaa.xW();
    int i = 0;
    while (i < j)
    {
      a(paramaa.eI(i), paramaa.eJ(i), paramStringBuilder);
      i += 1;
    }
    paramStringBuilder.finish();
  }
  
  void a(String paramString1, String paramString2, b paramb)
  {
    Object localObject1 = paramb.abg;
    Object localObject2 = paramb.abf;
    b localb = paramb.abd;
    paramb = paramb.abe;
    if (paramb != null) {
      paramb.append(paramString1 + ": " + paramString2).append(ab.aeg);
    }
    localObject2 = ((h)localObject2).cs(paramString1);
    if (localObject2 != null)
    {
      Type localType = i.a((List)localObject1, ((l)localObject2).getGenericType());
      if (ae.c(localType))
      {
        paramString1 = ae.b((List)localObject1, ae.d(localType));
        localb.a(((l)localObject2).yP(), paramString1, a(paramString1, (List)localObject1, paramString2));
        return;
      }
      if (ae.a(ae.b((List)localObject1, localType), Iterable.class))
      {
        paramb = (Collection)((l)localObject2).aj(this);
        paramString1 = paramb;
        if (paramb == null)
        {
          paramString1 = i.b(localType);
          ((l)localObject2).j(this, paramString1);
        }
        if (localType == Object.class) {}
        for (paramb = null;; paramb = ae.e(localType))
        {
          paramString1.add(a(paramb, (List)localObject1, paramString2));
          return;
        }
      }
      ((l)localObject2).j(this, a(localType, (List)localObject1, paramString2));
      return;
    }
    localObject1 = (ArrayList)get(paramString1);
    paramb = (b)localObject1;
    if (localObject1 == null)
    {
      paramb = new ArrayList();
      h(paramString1, paramb);
    }
    paramb.add(paramString2);
  }
  
  public final void b(n paramn)
  {
    try
    {
      b localb = new b(this, null);
      a(paramn, null, null, null, new a(this, localb));
      localb.finish();
      return;
    }
    catch (IOException paramn)
    {
      throw ad.f(paramn);
    }
  }
  
  public n bO(String paramString)
  {
    this.acceptEncoding = X(paramString);
    return this;
  }
  
  public n bP(String paramString)
  {
    return h(X(paramString));
  }
  
  public n bQ(String paramString)
  {
    this.contentEncoding = X(paramString);
    return this;
  }
  
  public n bR(String paramString)
  {
    this.contentRange = X(paramString);
    return this;
  }
  
  public n bS(String paramString)
  {
    this.contentType = X(paramString);
    return this;
  }
  
  public n bT(String paramString)
  {
    this.ifModifiedSince = X(paramString);
    return this;
  }
  
  public n bU(String paramString)
  {
    this.ifMatch = X(paramString);
    return this;
  }
  
  public n bV(String paramString)
  {
    this.ifNoneMatch = X(paramString);
    return this;
  }
  
  public n bW(String paramString)
  {
    this.ifUnmodifiedSince = X(paramString);
    return this;
  }
  
  public n bX(String paramString)
  {
    this.ifRange = X(paramString);
    return this;
  }
  
  public n bY(String paramString)
  {
    this.userAgent = X(paramString);
    return this;
  }
  
  public final String getContentType()
  {
    return (String)i(this.contentType);
  }
  
  public final String getLocation()
  {
    return (String)i(this.location);
  }
  
  public n h(String paramString, Object paramObject)
  {
    return (n)super.set(paramString, paramObject);
  }
  
  public n h(List<String> paramList)
  {
    this.authorization = paramList;
    return this;
  }
  
  public n xr()
  {
    return (n)super.clone();
  }
  
  public final String xs()
  {
    return (String)i(this.range);
  }
  
  public final String xt()
  {
    return (String)i(this.userAgent);
  }
  
  private static class a
    extends z
  {
    private final n abb;
    private final n.b abc;
    
    a(n paramn, n.b paramb)
    {
      this.abb = paramn;
      this.abc = paramb;
    }
    
    public void addHeader(String paramString1, String paramString2)
    {
      this.abb.a(paramString1, paramString2, this.abc);
    }
    
    public aa xu()
    {
      throw new UnsupportedOperationException();
    }
  }
  
  private static final class b
  {
    final b abd;
    final StringBuilder abe;
    final h abf;
    final List<Type> abg;
    
    public b(n paramn, StringBuilder paramStringBuilder)
    {
      Class localClass = paramn.getClass();
      this.abg = Arrays.asList(new Type[] { localClass });
      this.abf = h.a(localClass, true);
      this.abe = paramStringBuilder;
      this.abd = new b(paramn);
    }
    
    void finish()
    {
      this.abd.yE();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/http/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */