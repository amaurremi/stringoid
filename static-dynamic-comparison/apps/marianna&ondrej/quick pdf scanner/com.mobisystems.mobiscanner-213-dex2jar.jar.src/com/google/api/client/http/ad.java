package com.google.api.client.http;

import com.google.api.client.util.GenericData;
import com.google.api.client.util.a.a;
import com.google.api.client.util.ae;
import com.google.api.client.util.b;
import com.google.api.client.util.g;
import com.google.api.client.util.h;
import com.google.api.client.util.i;
import com.google.api.client.util.l;
import com.google.api.client.util.v;
import com.google.api.client.util.x;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ad
  implements v
{
  public static final String MEDIA_TYPE = new p("application/x-www-form-urlencoded").a(g.UTF_8).xo();
  
  private static Object a(Type paramType, List<Type> paramList, String paramString)
  {
    return i.a(i.a(paramList, paramType), paramString);
  }
  
  public static void a(Reader paramReader, Object paramObject)
  {
    Object localObject1 = paramObject.getClass();
    h localh = h.i((Class)localObject1);
    List localList = Arrays.asList(new Type[] { localObject1 });
    GenericData localGenericData;
    b localb;
    Object localObject2;
    Object localObject3;
    int i;
    Object localObject4;
    if (GenericData.class.isAssignableFrom((Class)localObject1))
    {
      localGenericData = (GenericData)paramObject;
      if (!Map.class.isAssignableFrom((Class)localObject1)) {
        break label155;
      }
      localObject1 = (Map)paramObject;
      localb = new b(paramObject);
      localObject2 = new StringWriter();
      localObject3 = new StringWriter();
      i = 1;
      localObject4 = localObject2;
      localObject2 = localObject3;
    }
    for (;;)
    {
      int j = paramReader.read();
      switch (j)
      {
      default: 
        if (i != 0)
        {
          ((StringWriter)localObject4).write(j);
          continue;
          localGenericData = null;
          break;
          localObject1 = null;
        }
        break;
      case -1: 
      case 38: 
        Object localObject5 = a.cv(((StringWriter)localObject4).toString());
        l locall;
        if (((String)localObject5).length() != 0)
        {
          localObject4 = a.cv(((StringWriter)localObject2).toString());
          locall = localh.cs((String)localObject5);
          if (locall == null) {
            break label393;
          }
          localObject5 = i.a(localList, locall.getGenericType());
          if (!ae.c((Type)localObject5)) {
            break label285;
          }
          localObject2 = ae.b(localList, ae.d((Type)localObject5));
          localb.a(locall.yP(), (Class)localObject2, a((Type)localObject2, localList, (String)localObject4));
        }
        while (localObject1 == null) {
          for (;;)
          {
            localObject4 = new StringWriter();
            localObject2 = new StringWriter();
            if (j != -1) {
              break;
            }
            localb.yE();
            return;
            if (ae.a(ae.b(localList, (Type)localObject5), Iterable.class))
            {
              localObject3 = (Collection)locall.aj(paramObject);
              localObject2 = localObject3;
              if (localObject3 == null)
              {
                localObject2 = i.b((Type)localObject5);
                locall.j(paramObject, localObject2);
              }
              if (localObject5 == Object.class) {}
              for (localObject3 = null;; localObject3 = ae.e((Type)localObject5))
              {
                ((Collection)localObject2).add(a((Type)localObject3, localList, (String)localObject4));
                break;
              }
            }
            locall.j(paramObject, a((Type)localObject5, localList, (String)localObject4));
          }
        }
        localObject3 = (ArrayList)((Map)localObject1).get(localObject5);
        localObject2 = localObject3;
        if (localObject3 == null)
        {
          localObject2 = new ArrayList();
          if (localGenericData == null) {
            break label456;
          }
          localGenericData.set((String)localObject5, localObject2);
        }
        for (;;)
        {
          ((ArrayList)localObject2).add(localObject4);
          break;
          ((Map)localObject1).put(localObject5, localObject2);
        }
      case 61: 
        label155:
        label285:
        label393:
        label456:
        i = 0;
        continue;
        ((StringWriter)localObject2).write(j);
        continue;
        i = 1;
      }
    }
  }
  
  public static void i(String paramString, Object paramObject)
  {
    if (paramString == null) {
      return;
    }
    try
    {
      a(new StringReader(paramString), paramObject);
      return;
    }
    catch (IOException paramString)
    {
      throw com.google.api.client.util.ad.f(paramString);
    }
  }
  
  public <T> T a(InputStream paramInputStream, Charset paramCharset, Class<T> paramClass)
  {
    return (T)a(new InputStreamReader(paramInputStream, paramCharset), paramClass);
  }
  
  public <T> T a(Reader paramReader, Class<T> paramClass)
  {
    return (T)a(paramReader, paramClass);
  }
  
  public Object a(Reader paramReader, Type paramType)
  {
    x.d(paramType instanceof Class, "dataType has to be of type Class<?>");
    paramType = ae.l((Class)paramType);
    a(new BufferedReader(paramReader), paramType);
    return paramType;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/http/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */