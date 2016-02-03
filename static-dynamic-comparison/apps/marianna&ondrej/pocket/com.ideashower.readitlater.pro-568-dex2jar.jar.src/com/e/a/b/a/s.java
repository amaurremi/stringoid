package com.e.a.b.a;

import com.e.a.b.q;
import java.io.InputStream;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public final class s
{
  private static final Comparator a = new Comparator()
  {
    public int a(String paramAnonymousString1, String paramAnonymousString2)
    {
      if (paramAnonymousString1 == paramAnonymousString2) {
        return 0;
      }
      if (paramAnonymousString1 == null) {
        return -1;
      }
      if (paramAnonymousString2 == null) {
        return 1;
      }
      return String.CASE_INSENSITIVE_ORDER.compare(paramAnonymousString1, paramAnonymousString2);
    }
  };
  private final List b = new ArrayList(20);
  private String c;
  private String d;
  private int e = 1;
  private int f = -1;
  private String g;
  
  public s() {}
  
  public s(s params)
  {
    this.b.addAll(params.b);
    this.c = params.c;
    this.d = params.d;
    this.e = params.e;
    this.f = params.f;
    this.g = params.g;
  }
  
  public static s a(InputStream paramInputStream)
  {
    s locals;
    do
    {
      locals = new s();
      locals.b(q.c(paramInputStream));
      a(paramInputStream, locals);
    } while (locals.c() == 100);
    return locals;
  }
  
  public static s a(List paramList)
  {
    Object localObject2 = null;
    if (paramList.size() % 2 != 0) {
      throw new IllegalArgumentException("Unexpected name value block: " + paramList);
    }
    s locals = new s();
    int i = 0;
    Object localObject1 = null;
    while (i < paramList.size())
    {
      String str2 = (String)paramList.get(i);
      String str3 = (String)paramList.get(i + 1);
      int j = 0;
      if (j < str3.length())
      {
        int m = str3.indexOf(0, j);
        int k = m;
        if (m == -1) {
          k = str3.length();
        }
        String str1 = str3.substring(j, k);
        if (":status".equals(str2)) {
          localObject1 = str1;
        }
        for (;;)
        {
          j = k + 1;
          break;
          if (":version".equals(str2))
          {
            localObject2 = str1;
          }
          else
          {
            locals.b.add(str2);
            locals.b.add(str1);
          }
        }
      }
      i += 2;
    }
    if (localObject1 == null) {
      throw new ProtocolException("Expected ':status' header not present");
    }
    if (localObject2 == null) {
      throw new ProtocolException("Expected ':version' header not present");
    }
    locals.b((String)localObject2 + " " + (String)localObject1);
    return locals;
  }
  
  public static s a(Map paramMap, boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new UnsupportedOperationException();
    }
    s locals = new s();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (List)((Map.Entry)localObject).getValue();
      if (str != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          locals.c(str, (String)((Iterator)localObject).next());
        }
      }
      else if (!((List)localObject).isEmpty())
      {
        locals.b((String)((List)localObject).get(((List)localObject).size() - 1));
      }
    }
    return locals;
  }
  
  public static void a(InputStream paramInputStream, s params)
  {
    for (;;)
    {
      String str = q.c(paramInputStream);
      if (str.length() == 0) {
        break;
      }
      params.c(str);
    }
  }
  
  private void c(String paramString1, String paramString2)
  {
    this.b.add(paramString1);
    this.b.add(paramString2.trim());
  }
  
  public s a(Set paramSet)
  {
    s locals = new s();
    int i = 0;
    while (i < this.b.size())
    {
      String str = (String)this.b.get(i);
      if (paramSet.contains(str)) {
        locals.a(str, (String)this.b.get(i + 1));
      }
      i += 2;
    }
    return locals;
  }
  
  public String a()
  {
    return this.d;
  }
  
  public String a(int paramInt)
  {
    paramInt *= 2;
    if ((paramInt < 0) || (paramInt >= this.b.size())) {
      return null;
    }
    return (String)this.b.get(paramInt);
  }
  
  public Map a(boolean paramBoolean)
  {
    TreeMap localTreeMap = new TreeMap(a);
    int i = 0;
    while (i < this.b.size())
    {
      String str1 = (String)this.b.get(i);
      String str2 = (String)this.b.get(i + 1);
      ArrayList localArrayList = new ArrayList();
      List localList = (List)localTreeMap.get(str1);
      if (localList != null) {
        localArrayList.addAll(localList);
      }
      localArrayList.add(str2);
      localTreeMap.put(str1, Collections.unmodifiableList(localArrayList));
      i += 2;
    }
    if ((paramBoolean) && (this.d != null)) {
      localTreeMap.put(null, Collections.unmodifiableList(Collections.singletonList(this.d)));
    }
    for (;;)
    {
      return Collections.unmodifiableMap(localTreeMap);
      if (this.c != null) {
        localTreeMap.put(null, Collections.unmodifiableList(Collections.singletonList(this.c)));
      }
    }
  }
  
  public void a(String paramString)
  {
    this.c = paramString.trim();
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("fieldname == null");
    }
    if (paramString2 == null) {
      throw new IllegalArgumentException("value == null");
    }
    if ((paramString1.length() == 0) || (paramString1.indexOf(0) != -1) || (paramString2.indexOf(0) != -1)) {
      throw new IllegalArgumentException("Unexpected header: " + paramString1 + ": " + paramString2);
    }
    c(paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    a(":method", paramString1);
    a(":scheme", paramString5);
    a(":path", paramString2);
    a(":version", paramString3);
    a(":host", paramString4);
  }
  
  public void a(String paramString, List paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a(paramString, (String)paramList.next());
    }
  }
  
  public int b()
  {
    if (this.e != -1) {
      return this.e;
    }
    return 1;
  }
  
  public String b(int paramInt)
  {
    paramInt = paramInt * 2 + 1;
    if ((paramInt < 0) || (paramInt >= this.b.size())) {
      return null;
    }
    return (String)this.b.get(paramInt);
  }
  
  public void b(String paramString)
  {
    if (this.g != null) {
      throw new IllegalStateException("statusLine is already set");
    }
    if (paramString.length() > 13) {}
    for (int i = 1; (!paramString.startsWith("HTTP/1.")) || (paramString.length() < 12) || (paramString.charAt(8) != ' ') || ((i != 0) && (paramString.charAt(12) != ' ')); i = 0) {
      throw new ProtocolException("Unexpected status line: " + paramString);
    }
    int j = paramString.charAt(7) - '0';
    if ((j < 0) || (j > 9)) {
      throw new ProtocolException("Unexpected status line: " + paramString);
    }
    for (;;)
    {
      try
      {
        int k = Integer.parseInt(paramString.substring(9, 12));
        if (i != 0)
        {
          String str1 = paramString.substring(13);
          this.g = str1;
          this.f = k;
          this.d = paramString;
          this.e = j;
          return;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new ProtocolException("Unexpected status line: " + paramString);
      }
      String str2 = "";
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    d(paramString1);
    a(paramString1, paramString2);
  }
  
  public int c()
  {
    return this.f;
  }
  
  public void c(String paramString)
  {
    int i = paramString.indexOf(":");
    if (i == -1)
    {
      c("", paramString);
      return;
    }
    c(paramString.substring(0, i), paramString.substring(i + 1));
  }
  
  public String d()
  {
    return this.g;
  }
  
  public void d(String paramString)
  {
    int i = 0;
    while (i < this.b.size())
    {
      if (paramString.equalsIgnoreCase((String)this.b.get(i)))
      {
        this.b.remove(i);
        this.b.remove(i);
      }
      i += 2;
    }
  }
  
  public int e()
  {
    return this.b.size() / 2;
  }
  
  public String e(String paramString)
  {
    int i = this.b.size() - 2;
    while (i >= 0)
    {
      if (paramString.equalsIgnoreCase((String)this.b.get(i))) {
        return (String)this.b.get(i + 1);
      }
      i -= 2;
    }
    return null;
  }
  
  public byte[] f()
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append(this.c).append("\r\n");
    int i = 0;
    while (i < this.b.size())
    {
      localStringBuilder.append((String)this.b.get(i)).append(": ").append((String)this.b.get(i + 1)).append("\r\n");
      i += 2;
    }
    localStringBuilder.append("\r\n");
    return localStringBuilder.toString().getBytes("ISO-8859-1");
  }
  
  public List g()
  {
    HashSet localHashSet = new HashSet();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < this.b.size())
    {
      String str1 = ((String)this.b.get(i)).toLowerCase(Locale.US);
      String str2 = (String)this.b.get(i + 1);
      if ((str1.equals("connection")) || (str1.equals("host")) || (str1.equals("keep-alive")) || (str1.equals("proxy-connection")) || (str1.equals("transfer-encoding"))) {}
      label251:
      for (;;)
      {
        i += 2;
        break;
        if (localHashSet.add(str1))
        {
          localArrayList.add(str1);
          localArrayList.add(str2);
        }
        else
        {
          int j = 0;
          for (;;)
          {
            if (j >= localArrayList.size()) {
              break label251;
            }
            if (str1.equals(localArrayList.get(j)))
            {
              localArrayList.set(j + 1, (String)localArrayList.get(j + 1) + "\000" + str2);
              break;
            }
            j += 2;
          }
        }
      }
    }
    return localArrayList;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/b/a/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */