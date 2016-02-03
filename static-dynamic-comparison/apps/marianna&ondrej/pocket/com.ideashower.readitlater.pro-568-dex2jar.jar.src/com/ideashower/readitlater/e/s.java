package com.ideashower.readitlater.e;

import android.util.SparseArray;
import com.ideashower.readitlater.util.e;
import com.ideashower.readitlater.util.l;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.node.ObjectNode;

public class s
  extends p
{
  protected JsonToken L;
  protected String M;
  
  public static o a(String paramString)
  {
    try
    {
      paramString = a(paramString, null);
      return paramString;
    }
    catch (JsonParseException paramString)
    {
      e.a(paramString);
      return null;
    }
    catch (IOException paramString)
    {
      e.a(paramString);
    }
    return null;
  }
  
  public static o a(String paramString, s params)
  {
    paramString = l.d().createJsonParser(paramString);
    paramString.nextToken();
    params = a(paramString, params);
    paramString.close();
    return params;
  }
  
  public static o a(JsonParser paramJsonParser, s params)
  {
    if ((paramJsonParser == null) || (paramJsonParser.getCurrentToken() != JsonToken.START_OBJECT)) {
      return null;
    }
    if (params == null) {
      params = new s();
    }
    while ((paramJsonParser.nextToken() != JsonToken.END_OBJECT) && (!paramJsonParser.isClosed()))
    {
      Object localObject = paramJsonParser.getCurrentName();
      paramJsonParser.nextToken();
      if ("item_id".equals(localObject))
      {
        params.c = paramJsonParser.getValueAsInt();
        continue;
        params.a();
      }
      else if ("resolved_id".equals(localObject))
      {
        params.e = paramJsonParser.getValueAsInt();
      }
      else if ("unique_id".equals(localObject))
      {
        params.d = paramJsonParser.getValueAsInt();
      }
      else if (("given_url".equals(localObject)) || ("url".equals(localObject)))
      {
        params.f = l.a(paramJsonParser);
      }
      else if ("normal_url".equals(localObject))
      {
        params.g = l.a(paramJsonParser);
      }
      else if ("resolved_url".equals(localObject))
      {
        params.h = l.a(paramJsonParser);
      }
      else if ("resolved_normal_url".equals(localObject))
      {
        params.i = l.a(paramJsonParser);
      }
      else if ("given_title".equals(localObject))
      {
        params.j = l.a(paramJsonParser);
      }
      else if (("resolved_title".equals(localObject)) || ("title".equals(localObject)))
      {
        params.k = l.a(paramJsonParser);
      }
      else if ("time_added".equals(localObject))
      {
        params.o = paramJsonParser.getValueAsLong();
      }
      else if ("excerpt".equals(localObject))
      {
        params.l = l.a(paramJsonParser);
      }
      else
      {
        boolean bool;
        if ("favorite".equals(localObject))
        {
          if (paramJsonParser.getValueAsInt() == 1) {}
          for (bool = true;; bool = false)
          {
            params.m = bool;
            break;
          }
        }
        if ("time_favorited".equals(localObject))
        {
          params.n = paramJsonParser.getValueAsLong();
        }
        else
        {
          if ("is_article".equals(localObject))
          {
            if (paramJsonParser.getValueAsInt() == 1) {}
            for (bool = true;; bool = false)
            {
              params.p = bool;
              break;
            }
          }
          if ("word_count".equals(localObject))
          {
            params.z = paramJsonParser.getValueAsInt();
          }
          else if ("has_image".equals(localObject))
          {
            params.q = paramJsonParser.getValueAsInt();
          }
          else if ("meta".equals(localObject))
          {
            if (paramJsonParser.getCurrentToken() == JsonToken.START_ARRAY) {
              params.L = JsonToken.END_ARRAY;
            }
            while ((paramJsonParser.nextToken() != params.L) && (!paramJsonParser.isClosed()))
            {
              if (params.L == JsonToken.END_OBJECT) {
                paramJsonParser.nextToken();
              }
              localObject = l.a(paramJsonParser);
              if (localObject != null)
              {
                params.H.add(new y(params.d, Long.valueOf((String)localObject).longValue()));
                continue;
                params.L = JsonToken.END_OBJECT;
              }
            }
          }
          else if ("has_video".equals(localObject))
          {
            params.r = paramJsonParser.getValueAsInt();
          }
          else
          {
            if ("is_index".equals(localObject))
            {
              if (paramJsonParser.getValueAsInt() == 1) {}
              for (bool = true;; bool = false)
              {
                params.v = bool;
                break;
              }
            }
            if ("offline_text".equals(localObject))
            {
              params.C = paramJsonParser.getValueAsInt();
            }
            else if ("offline_web".equals(localObject))
            {
              params.D = paramJsonParser.getValueAsInt();
            }
            else if ("mime_type".equals(localObject))
            {
              params.F = l.a(paramJsonParser);
            }
            else if ("encoding".equals(localObject))
            {
              params.E = l.a(paramJsonParser);
            }
            else
            {
              String str1;
              if ("tags".equals(localObject))
              {
                if (paramJsonParser.getCurrentToken() == JsonToken.START_ARRAY)
                {
                  params.L = JsonToken.END_ARRAY;
                  localObject = com.ideashower.readitlater.util.u.a();
                }
                label860:
                for (;;)
                {
                  if ((paramJsonParser.nextToken() == params.L) || (paramJsonParser.isClosed())) {
                    break label862;
                  }
                  if (params.L == JsonToken.END_OBJECT) {
                    paramJsonParser.nextToken();
                  }
                  for (;;)
                  {
                    if ((paramJsonParser.nextToken() == JsonToken.END_OBJECT) || (paramJsonParser.isClosed())) {
                      break label860;
                    }
                    str1 = paramJsonParser.getCurrentName();
                    paramJsonParser.nextToken();
                    if ("tag".equals(str1))
                    {
                      if (((StringBuilder)localObject).length() == 0)
                      {
                        ((StringBuilder)localObject).append(l.a(paramJsonParser));
                        continue;
                        params.L = JsonToken.END_OBJECT;
                        break;
                      }
                      ((StringBuilder)localObject).append(",").append(l.a(paramJsonParser));
                      continue;
                    }
                    paramJsonParser.skipChildren();
                  }
                }
                label862:
                params.w = ((StringBuilder)localObject).toString();
                com.ideashower.readitlater.util.u.a((StringBuilder)localObject);
              }
              else if ("status".equals(localObject))
              {
                params.b = paramJsonParser.getValueAsInt();
              }
              else
              {
                int i;
                int j;
                int k;
                int m;
                if ("positions".equals(localObject))
                {
                  if (paramJsonParser.getCurrentToken() == JsonToken.START_ARRAY) {
                    params.L = JsonToken.END_ARRAY;
                  }
                  while ((paramJsonParser.nextToken() != params.L) && (!paramJsonParser.isClosed()))
                  {
                    if (params.L == JsonToken.END_OBJECT) {
                      paramJsonParser.nextToken();
                    }
                    i = 100;
                    long l = 0L;
                    j = 0;
                    k = 0;
                    m = 0;
                    int n = 0;
                    for (;;)
                    {
                      if ((paramJsonParser.nextToken() == JsonToken.END_OBJECT) || (paramJsonParser.isClosed())) {
                        break label1158;
                      }
                      localObject = paramJsonParser.getCurrentName();
                      paramJsonParser.nextToken();
                      if (!"item_id".equals(localObject))
                      {
                        if ("view".equals(localObject))
                        {
                          n = paramJsonParser.getValueAsInt();
                          continue;
                          params.L = JsonToken.END_OBJECT;
                          break;
                        }
                        if ("section".equals(localObject)) {
                          m = paramJsonParser.getValueAsInt();
                        } else if ("page".equals(localObject)) {
                          k = paramJsonParser.getValueAsInt();
                        } else if ("node_index".equals(localObject)) {
                          j = paramJsonParser.getValueAsInt();
                        } else if ("percent".equals(localObject)) {
                          i = paramJsonParser.getValueAsInt();
                        } else if ("time_updated".equals(localObject)) {
                          l = paramJsonParser.getValueAsInt();
                        } else {
                          paramJsonParser.skipChildren();
                        }
                      }
                    }
                    label1158:
                    if ((n == 2) || (n == 1)) {
                      params.x.put(n, new v(n, m, k, j, i, l));
                    }
                  }
                }
                else
                {
                  String str2;
                  if ("authors".equals(localObject))
                  {
                    if (paramJsonParser.getCurrentToken() == JsonToken.START_ARRAY) {
                      params.L = JsonToken.END_ARRAY;
                    }
                    while ((paramJsonParser.nextToken() != params.L) && (!paramJsonParser.isClosed()))
                    {
                      if (params.L == JsonToken.END_OBJECT) {
                        paramJsonParser.nextToken();
                      }
                      str1 = null;
                      localObject = null;
                      i = 0;
                      for (;;)
                      {
                        if ((paramJsonParser.nextToken() == JsonToken.END_OBJECT) || (paramJsonParser.isClosed())) {
                          break label1376;
                        }
                        str2 = paramJsonParser.getCurrentName();
                        paramJsonParser.nextToken();
                        if ("author_id".equals(str2))
                        {
                          i = paramJsonParser.getValueAsInt();
                          continue;
                          params.L = JsonToken.END_OBJECT;
                          break;
                        }
                        if ("name".equals(str2)) {
                          localObject = l.a(paramJsonParser);
                        } else if ("url".equals(str2)) {
                          str1 = l.a(paramJsonParser);
                        } else {
                          paramJsonParser.skipChildren();
                        }
                      }
                      label1376:
                      if ((i != 0) && (localObject != null)) {
                        params.y.add(new d(i, (String)localObject, str1));
                      }
                    }
                  }
                  else if ("images".equals(localObject))
                  {
                    if (paramJsonParser.getCurrentToken() == JsonToken.START_ARRAY) {
                      params.L = JsonToken.END_ARRAY;
                    }
                    while ((paramJsonParser.nextToken() != params.L) && (!paramJsonParser.isClosed()))
                    {
                      if (params.L == JsonToken.END_OBJECT) {
                        paramJsonParser.nextToken();
                      }
                      i = 0;
                      j = 0;
                      localObject = null;
                      str1 = null;
                      str2 = null;
                      k = 0;
                      for (;;)
                      {
                        if ((paramJsonParser.nextToken() == JsonToken.END_OBJECT) || (paramJsonParser.isClosed())) {
                          break label1669;
                        }
                        params.M = paramJsonParser.getCurrentName();
                        paramJsonParser.nextToken();
                        if ("src".equals(params.M))
                        {
                          str2 = l.a(paramJsonParser);
                          continue;
                          params.L = JsonToken.END_OBJECT;
                          break;
                        }
                        if ("image_id".equals(params.M)) {
                          k = paramJsonParser.getValueAsInt();
                        } else if ("credit".equals(params.M)) {
                          localObject = l.a(paramJsonParser);
                        } else if ("caption".equals(params.M)) {
                          str1 = l.a(paramJsonParser);
                        } else if ("width".equals(params.M)) {
                          j = paramJsonParser.getValueAsInt();
                        } else if ("height".equals(params.M)) {
                          i = paramJsonParser.getValueAsInt();
                        } else {
                          paramJsonParser.skipChildren();
                        }
                      }
                      label1669:
                      if (str2 != null) {
                        params.A.put(k, new a(str2, k, str1, (String)localObject, j, i));
                      }
                    }
                  }
                  else if ("videos".equals(localObject))
                  {
                    if (paramJsonParser.getCurrentToken() == JsonToken.START_ARRAY) {
                      params.L = JsonToken.END_ARRAY;
                    }
                    while ((paramJsonParser.nextToken() != params.L) && (!paramJsonParser.isClosed()))
                    {
                      if (params.L == JsonToken.END_OBJECT) {
                        paramJsonParser.nextToken();
                      }
                      i = 0;
                      j = 0;
                      k = 0;
                      localObject = null;
                      str1 = null;
                      m = 0;
                      for (;;)
                      {
                        if ((paramJsonParser.nextToken() == JsonToken.END_OBJECT) || (paramJsonParser.isClosed())) {
                          break label1964;
                        }
                        params.M = paramJsonParser.getCurrentName();
                        paramJsonParser.nextToken();
                        if ("src".equals(params.M))
                        {
                          str1 = l.a(paramJsonParser);
                          continue;
                          params.L = JsonToken.END_OBJECT;
                          break;
                        }
                        if ("video_id".equals(params.M)) {
                          m = paramJsonParser.getValueAsInt();
                        } else if ("type".equals(params.M)) {
                          k = paramJsonParser.getValueAsInt();
                        } else if ("vid".equals(params.M)) {
                          localObject = l.a(paramJsonParser);
                        } else if ("width".equals(params.M)) {
                          j = paramJsonParser.getValueAsInt();
                        } else if ("height".equals(params.M)) {
                          i = paramJsonParser.getValueAsInt();
                        } else {
                          paramJsonParser.skipChildren();
                        }
                      }
                      label1964:
                      if (str1 != null) {
                        params.B.put(m, new b(str1, m, (String)localObject, k, j, i));
                      }
                    }
                  }
                  else if ("shares".equals(localObject))
                  {
                    a(params, paramJsonParser);
                  }
                  else if ("badge_group_id".equals(localObject))
                  {
                    params.I = paramJsonParser.getValueAsInt();
                  }
                  else if ("carousel_info".equals(localObject))
                  {
                    double d = 0.0D;
                    i = 0;
                    while ((paramJsonParser.nextToken() != JsonToken.END_OBJECT) && (!paramJsonParser.isClosed()))
                    {
                      localObject = paramJsonParser.getCurrentName();
                      paramJsonParser.nextToken();
                      if ("sort".equals(localObject)) {
                        d = paramJsonParser.getDecimalValue().doubleValue();
                      } else if ("group_id".equals(localObject)) {
                        i = paramJsonParser.getValueAsInt();
                      } else {
                        paramJsonParser.skipChildren();
                      }
                    }
                    params.J = new f(i, d);
                  }
                  else if ("sort_id".equals(localObject))
                  {
                    params.K.a.a(paramJsonParser.getValueAsInt());
                  }
                  else if ("highlights".equals(localObject))
                  {
                    a(paramJsonParser, params.K.a);
                  }
                  else
                  {
                    paramJsonParser.skipChildren();
                  }
                }
              }
            }
          }
        }
      }
    }
    return params.b();
  }
  
  public static o a(ObjectNode paramObjectNode, s params)
  {
    if (paramObjectNode == null) {
      return null;
    }
    if ((!paramObjectNode.has("time_added")) && (paramObjectNode.has("time"))) {
      paramObjectNode.put("time_added", paramObjectNode.get("time"));
    }
    return a(paramObjectNode.toString(), params);
  }
  
  protected static void a(s params, JsonParser paramJsonParser)
  {
    int m;
    int k;
    long l2;
    long l1;
    int j;
    String str;
    Object localObject1;
    int i;
    boolean bool;
    if (paramJsonParser.getCurrentToken() == JsonToken.START_ARRAY)
    {
      params.L = JsonToken.END_ARRAY;
      if ((paramJsonParser.nextToken() != params.L) && (!paramJsonParser.isClosed()))
      {
        if (params.L == JsonToken.END_OBJECT) {
          paramJsonParser.nextToken();
        }
        m = 0;
        k = 0;
        l2 = 0L;
        l1 = 0L;
        j = 0;
        str = null;
        localObject1 = null;
        i = 0;
        bool = false;
      }
    }
    else
    {
      for (;;)
      {
        if ((paramJsonParser.nextToken() == JsonToken.END_OBJECT) || (paramJsonParser.isClosed())) {
          break label309;
        }
        localObject2 = paramJsonParser.getCurrentName();
        paramJsonParser.nextToken();
        if ("share_id".equals(localObject2))
        {
          m = paramJsonParser.getValueAsInt();
          continue;
          params.L = JsonToken.END_OBJECT;
          break;
        }
        if ("from_friend_id".equals(localObject2)) {
          k = paramJsonParser.getValueAsInt();
        } else if ("time_shared".equals(localObject2)) {
          l2 = paramJsonParser.getValueAsLong();
        } else if ("time_ignored".equals(localObject2)) {
          l1 = paramJsonParser.getValueAsLong();
        } else if ("status".equals(localObject2)) {
          j = paramJsonParser.getValueAsInt();
        } else if ("comment".equals(localObject2)) {
          str = l.a(paramJsonParser);
        } else if ("quote".equals(localObject2)) {
          localObject1 = l.a(paramJsonParser);
        } else if ("viewed".equals(localObject2))
        {
          if (paramJsonParser.getValueAsInt() == 1) {
            bool = true;
          } else {
            bool = false;
          }
        }
        else if ("unique_id".equals(localObject2)) {
          i = paramJsonParser.getValueAsInt();
        } else {
          paramJsonParser.skipChildren();
        }
      }
      label309:
      Object localObject2 = params.G;
      if (i != 0) {}
      for (localObject1 = new w(m, k, str, (String)localObject1, l2, l1, j, bool, i);; localObject1 = new x(m, k, str, (String)localObject1, l2, l1, j, bool))
      {
        ((ArrayList)localObject2).add(localObject1);
        break;
      }
    }
  }
  
  private static void a(JsonParser paramJsonParser, u paramu)
  {
    while ((paramJsonParser.nextToken() != JsonToken.END_OBJECT) && (!paramJsonParser.isClosed()))
    {
      String str = paramJsonParser.getCurrentName();
      paramJsonParser.nextToken();
      if ("full_text".equals(str)) {
        paramu.a(l.a(paramJsonParser));
      } else if ("url".equals(str)) {
        paramu.b(l.a(paramJsonParser));
      } else if ("title".equals(str)) {
        paramu.c(l.a(paramJsonParser));
      } else if ("tags".equals(str)) {
        paramu.d(l.a(paramJsonParser));
      } else {
        paramJsonParser.skipChildren();
      }
    }
  }
  
  protected void a()
  {
    super.a();
    this.L = null;
    this.M = null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/e/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */