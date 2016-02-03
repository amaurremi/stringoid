package com.google.api.client.http;

import com.google.api.client.util.a.a;
import com.google.api.client.util.ae;
import com.google.api.client.util.l;
import com.google.api.client.util.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class UriTemplate
{
  static final Map<Character, CompositeOutput> abV = new HashMap();
  
  static
  {
    CompositeOutput.values();
  }
  
  private static Map<String, Object> Y(Object paramObject)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramObject = com.google.api.client.util.i.ah(paramObject).entrySet().iterator();
    while (((Iterator)paramObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)paramObject).next();
      Object localObject = localEntry.getValue();
      if ((localObject != null) && (!com.google.api.client.util.i.ag(localObject))) {
        localLinkedHashMap.put(localEntry.getKey(), localObject);
      }
    }
    return localLinkedHashMap;
  }
  
  public static String a(String paramString, Object paramObject, boolean paramBoolean)
  {
    Map localMap = Y(paramObject);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    int m = paramString.length();
    boolean bool;
    Object localObject;
    String str;
    do
    {
      if (i < m)
      {
        j = paramString.indexOf('{', i);
        if (j == -1)
        {
          if ((i == 0) && (!paramBoolean)) {
            return paramString;
          }
          localStringBuilder.append(paramString.substring(i));
        }
      }
      else
      {
        if (paramBoolean) {
          i.a(localMap.entrySet(), localStringBuilder);
        }
        return localStringBuilder.toString();
      }
      localStringBuilder.append(paramString.substring(i, j));
      i = paramString.indexOf('}', j + 2);
      paramObject = paramString.substring(j + 1, i);
      i += 1;
      bool = ((String)paramObject).endsWith("*");
      localObject = cl((String)paramObject);
      int n = ((CompositeOutput)localObject).yb();
      int k = ((String)paramObject).length();
      int j = k;
      if (bool) {
        j = k - 1;
      }
      str = ((String)paramObject).substring(n, j);
      paramObject = localMap.remove(str);
    } while (paramObject == null);
    if ((paramObject instanceof Iterator)) {
      paramObject = a(str, (Iterator)paramObject, bool, (CompositeOutput)localObject);
    }
    for (;;)
    {
      localStringBuilder.append(paramObject);
      break;
      if (((paramObject instanceof Iterable)) || (paramObject.getClass().isArray()))
      {
        paramObject = a(str, ae.ak(paramObject).iterator(), bool, (CompositeOutput)localObject);
      }
      else if (paramObject.getClass().isEnum())
      {
        localObject = l.a((Enum)paramObject).getName();
        if (localObject != null) {
          paramObject = a.cw((String)localObject);
        }
      }
      else if (!com.google.api.client.util.i.ai(paramObject))
      {
        paramObject = a(str, Y(paramObject), bool, (CompositeOutput)localObject);
      }
      else
      {
        paramObject = a.cw(paramObject.toString());
      }
    }
  }
  
  public static String a(String paramString1, String paramString2, Object paramObject, boolean paramBoolean)
  {
    String str;
    if (paramString2.startsWith("/"))
    {
      paramString1 = new i(paramString1);
      paramString1.bL(null);
      str = paramString1.xo() + paramString2;
    }
    for (;;)
    {
      return a(str, paramObject, paramBoolean);
      str = paramString2;
      if (!paramString2.startsWith("http://"))
      {
        str = paramString2;
        if (!paramString2.startsWith("https://")) {
          str = paramString1 + paramString2;
        }
      }
    }
  }
  
  private static String a(String paramString, Iterator<?> paramIterator, boolean paramBoolean, CompositeOutput paramCompositeOutput)
  {
    if (!paramIterator.hasNext()) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramCompositeOutput.xY());
    Object localObject;
    if (paramBoolean) {
      localObject = paramCompositeOutput.xZ();
    }
    while (paramIterator.hasNext())
    {
      if ((paramBoolean) && (paramCompositeOutput.ya()))
      {
        localStringBuilder.append(a.cw(paramString));
        localStringBuilder.append("=");
      }
      localStringBuilder.append(paramCompositeOutput.cm(paramIterator.next().toString()));
      if (paramIterator.hasNext())
      {
        localStringBuilder.append((String)localObject);
        continue;
        String str = ",";
        localObject = str;
        if (paramCompositeOutput.ya())
        {
          localStringBuilder.append(a.cw(paramString));
          localStringBuilder.append("=");
          localObject = str;
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  private static String a(String paramString, Map<String, Object> paramMap, boolean paramBoolean, CompositeOutput paramCompositeOutput)
  {
    if (paramMap.isEmpty()) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramCompositeOutput.xY());
    String str1;
    if (paramBoolean)
    {
      str1 = paramCompositeOutput.xZ();
      paramString = "=";
    }
    for (;;)
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Object localObject = (Map.Entry)paramMap.next();
        String str2 = paramCompositeOutput.cm((String)((Map.Entry)localObject).getKey());
        localObject = paramCompositeOutput.cm(((Map.Entry)localObject).getValue().toString());
        localStringBuilder.append(str2);
        localStringBuilder.append(paramString);
        localStringBuilder.append((String)localObject);
        if (paramMap.hasNext()) {
          localStringBuilder.append(str1);
        }
      }
      if (paramCompositeOutput.ya())
      {
        localStringBuilder.append(a.cw(paramString));
        localStringBuilder.append("=");
      }
      paramString = ",";
      str1 = ",";
    }
    return localStringBuilder.toString();
  }
  
  static CompositeOutput cl(String paramString)
  {
    CompositeOutput localCompositeOutput = (CompositeOutput)abV.get(Character.valueOf(paramString.charAt(0)));
    paramString = localCompositeOutput;
    if (localCompositeOutput == null) {
      paramString = CompositeOutput.acd;
    }
    return paramString;
  }
  
  private static enum CompositeOutput
  {
    private final String explodeJoiner;
    private final String outputPrefix;
    private final Character propertyPrefix;
    private final boolean requiresVarAssignment;
    private final boolean reservedExpansion;
    
    private CompositeOutput(Character paramCharacter, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.propertyPrefix = paramCharacter;
      this.outputPrefix = ((String)x.ad(paramString1));
      this.explodeJoiner = ((String)x.ad(paramString2));
      this.requiresVarAssignment = paramBoolean1;
      this.reservedExpansion = paramBoolean2;
      if (paramCharacter != null) {
        UriTemplate.abV.put(paramCharacter, this);
      }
    }
    
    String cm(String paramString)
    {
      if (this.reservedExpansion) {
        return a.cw(paramString);
      }
      return a.cu(paramString);
    }
    
    String xY()
    {
      return this.outputPrefix;
    }
    
    String xZ()
    {
      return this.explodeJoiner;
    }
    
    boolean ya()
    {
      return this.requiresVarAssignment;
    }
    
    int yb()
    {
      if (this.propertyPrefix == null) {
        return 0;
      }
      return 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/http/UriTemplate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */