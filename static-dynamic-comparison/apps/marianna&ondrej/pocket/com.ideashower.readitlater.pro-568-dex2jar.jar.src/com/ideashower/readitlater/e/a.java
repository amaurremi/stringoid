package com.ideashower.readitlater.e;

import com.ideashower.readitlater.util.l;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;

public class a
{
  private final String a;
  private final int b;
  private final String c;
  private final String d;
  private final int e;
  private final int f;
  
  public a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3)
  {
    this.a = paramString1;
    this.b = paramInt1;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramInt2;
    this.f = paramInt3;
  }
  
  public static a a(JsonNode paramJsonNode)
  {
    return new a(paramJsonNode.get("src").getTextValue(), paramJsonNode.get("image_id").getIntValue(), paramJsonNode.get("credit").getTextValue(), paramJsonNode.get("caption").getTextValue(), paramJsonNode.get("width").getIntValue(), paramJsonNode.get("height").getIntValue());
  }
  
  public String a()
  {
    return this.a;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.d;
  }
  
  public String d()
  {
    return this.c;
  }
  
  public int e()
  {
    return this.e;
  }
  
  public int f()
  {
    return this.f;
  }
  
  public ObjectNode g()
  {
    ObjectNode localObjectNode = l.b();
    localObjectNode.put("src", this.a);
    localObjectNode.put("image_id", this.b);
    localObjectNode.put("credit", this.d);
    localObjectNode.put("caption", this.c);
    localObjectNode.put("width", this.e);
    localObjectNode.put("height", this.f);
    return localObjectNode;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */