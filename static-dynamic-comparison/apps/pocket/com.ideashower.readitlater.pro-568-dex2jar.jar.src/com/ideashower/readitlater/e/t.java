package com.ideashower.readitlater.e;

import android.util.SparseArray;
import com.ideashower.readitlater.util.l;
import java.util.ArrayList;
import java.util.Iterator;
import org.codehaus.jackson.node.ObjectNode;

public class t
  extends s
{
  public static ObjectNode a(SparseArray paramSparseArray)
  {
    ObjectNode localObjectNode = l.b();
    if ((paramSparseArray == null) || (paramSparseArray.size() == 0)) {
      return localObjectNode;
    }
    int j = paramSparseArray.size();
    int i = 0;
    while (i < j)
    {
      b localb = (b)paramSparseArray.valueAt(i);
      localObjectNode.put(String.valueOf(localb.b()), localb.i());
      i += 1;
    }
    return localObjectNode;
  }
  
  public static ObjectNode a(o paramo)
  {
    return b(paramo, a(paramo, l.b()));
  }
  
  private static ObjectNode a(o paramo, ObjectNode paramObjectNode)
  {
    paramObjectNode.put("unique_id", paramo.f());
    paramObjectNode.put("item_id", paramo.c());
    paramObjectNode.put("given_url", paramo.i());
    if (paramo.ae()) {}
    for (Object localObject = "1";; localObject = "0")
    {
      paramObjectNode.put("favorite", (String)localObject);
      paramObjectNode.put("status", paramo.al());
      paramObjectNode.put("time_added", paramo.u());
      paramObjectNode.put("offline_web", paramo.O());
      paramObjectNode.put("offline_text", paramo.P());
      localObject = paramo.z();
      if (localObject != null) {
        paramObjectNode.put("badge_group_id", ((g)localObject).a());
      }
      if (paramo.A() != null) {
        paramObjectNode.put("carousel_info", f(paramo));
      }
      if (paramo.v() > 0) {
        paramObjectNode.put("tags", e(paramo));
      }
      if (paramo.an() > 0) {
        paramObjectNode.put("positions", g(paramo));
      }
      if (paramo.ap() > 0) {
        paramObjectNode.put("shares", h(paramo));
      }
      return paramObjectNode;
    }
  }
  
  public static ObjectNode a(v paramv)
  {
    ObjectNode localObjectNode = l.b();
    a(localObjectNode, "view", paramv.a());
    a(localObjectNode, "section", paramv.b());
    a(localObjectNode, "page", paramv.c());
    a(localObjectNode, "node_index", paramv.d());
    a(localObjectNode, "percent", paramv.e());
    a(localObjectNode, "time_updated", paramv.f());
    return localObjectNode;
  }
  
  public static ObjectNode a(x paramx)
  {
    ObjectNode localObjectNode = l.b();
    a(localObjectNode, "share_id", paramx.b());
    a(localObjectNode, "time_shared", paramx.f());
    localObjectNode.put("comment", paramx.d());
    localObjectNode.put("quote", paramx.e());
    a(localObjectNode, "status", paramx.g());
    return localObjectNode;
  }
  
  public static ObjectNode a(ArrayList paramArrayList)
  {
    ObjectNode localObjectNode = l.b();
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return localObjectNode;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      d locald = (d)paramArrayList.next();
      localObjectNode.put(String.valueOf(locald.a()), locald.d());
    }
    return localObjectNode;
  }
  
  private static void a(ObjectNode paramObjectNode, String paramString, int paramInt)
  {
    paramObjectNode.put(paramString, String.valueOf(paramInt));
  }
  
  private static void a(ObjectNode paramObjectNode, String paramString, long paramLong)
  {
    paramObjectNode.put(paramString, String.valueOf(paramLong));
  }
  
  public static ObjectNode b(SparseArray paramSparseArray)
  {
    ObjectNode localObjectNode = l.b();
    if ((paramSparseArray == null) || (paramSparseArray.size() == 0)) {
      return localObjectNode;
    }
    int j = paramSparseArray.size();
    int i = 0;
    while (i < j)
    {
      a locala = (a)paramSparseArray.valueAt(i);
      localObjectNode.put(String.valueOf(locala.b()), locala.g());
      i += 1;
    }
    return localObjectNode;
  }
  
  public static ObjectNode b(o paramo)
  {
    return a(paramo.V());
  }
  
  private static ObjectNode b(o paramo, ObjectNode paramObjectNode)
  {
    if (!paramo.M()) {
      return paramObjectNode;
    }
    paramObjectNode.put("resolved_id", paramo.d());
    paramObjectNode.put("resolved_url", paramo.l());
    paramObjectNode.put("title", paramo.q());
    paramObjectNode.put("excerpt", paramo.r());
    if (paramo.d(false)) {}
    for (String str = "1";; str = "0")
    {
      paramObjectNode.put("is_article", str);
      paramObjectNode.put("has_image", paramo.I());
      paramObjectNode.put("has_video", paramo.K());
      paramObjectNode.put("favicon", "http://" + paramo.n() + "/favicon.ico");
      paramObjectNode.put("mime_type", paramo.E());
      paramObjectNode.put("encoding", paramo.F());
      if (paramo.ak() > 0) {
        paramObjectNode.put("videos", b(paramo));
      }
      if (paramo.am() > 0) {
        paramObjectNode.put("images", c(paramo));
      }
      if (paramo.ao() <= 0) {
        break;
      }
      paramObjectNode.put("authors", d(paramo));
      return paramObjectNode;
    }
  }
  
  public static ObjectNode b(ArrayList paramArrayList)
  {
    ObjectNode localObjectNode = l.b();
    if (paramArrayList == null) {
      return localObjectNode;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      x localx = (x)paramArrayList.next();
      localObjectNode.put(String.valueOf(localx.b()), a(localx));
    }
    return localObjectNode;
  }
  
  public static ObjectNode c(SparseArray paramSparseArray)
  {
    ObjectNode localObjectNode = l.b();
    if (paramSparseArray == null) {
      return localObjectNode;
    }
    int j = paramSparseArray.size();
    int i = 0;
    while (i < j)
    {
      v localv = (v)paramSparseArray.valueAt(i);
      localObjectNode.put(String.valueOf(localv.a()), a(localv));
      i += 1;
    }
    return localObjectNode;
  }
  
  public static ObjectNode c(o paramo)
  {
    return b(paramo.W());
  }
  
  public static ObjectNode d(o paramo)
  {
    return a(paramo.af());
  }
  
  public static ObjectNode e(o paramo)
  {
    int i = paramo.f();
    Object localObject = paramo.w();
    paramo = l.b();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      ObjectNode localObjectNode = l.b();
      localObjectNode.put("unique_id", i);
      localObjectNode.put("tag", str);
      paramo.put(str, localObjectNode);
    }
    return paramo;
  }
  
  public static ObjectNode f(o paramo)
  {
    paramo = paramo.A();
    ObjectNode localObjectNode = l.b();
    localObjectNode.put("sort", paramo.b());
    localObjectNode.put("group_id", paramo.a().a());
    return localObjectNode;
  }
  
  public static ObjectNode g(o paramo)
  {
    return c(paramo.C());
  }
  
  public static ObjectNode h(o paramo)
  {
    return b(paramo.T());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/e/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */