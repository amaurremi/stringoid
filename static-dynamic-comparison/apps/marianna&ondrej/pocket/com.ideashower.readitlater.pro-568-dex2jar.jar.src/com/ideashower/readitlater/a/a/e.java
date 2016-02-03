package com.ideashower.readitlater.a.a;

import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.util.l;
import java.util.ArrayList;
import java.util.Iterator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;

public class e
{
  private final ObjectNode a;
  
  public e(ObjectNode paramObjectNode)
  {
    this.a = paramObjectNode;
  }
  
  public String a()
  {
    return this.a.get("name").asText();
  }
  
  public String b()
  {
    return this.a.get("host").asText();
  }
  
  public String c()
  {
    return this.a.get("target").asText();
  }
  
  public String d()
  {
    return l.a(this.a, "userLabel", g.a(2131493372));
  }
  
  public String e()
  {
    return l.a(this.a, "userSelector", null);
  }
  
  public String f()
  {
    return l.a(this.a, "passSelector", null);
  }
  
  public String g()
  {
    return l.a(this.a, "rememberMeSelector", null);
  }
  
  public String h()
  {
    return l.a(this.a, "buttonSelector", null);
  }
  
  public String i()
  {
    return l.a(this.a, "token_url", null);
  }
  
  public ObjectNode j()
  {
    return l.a(this.a, "tokens");
  }
  
  public ArrayList k()
  {
    Object localObject = l.b(this.a, "forceLogins");
    if (localObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      localObject = ((ArrayNode)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(new e((ObjectNode)((Iterator)localObject).next()));
      }
      return localArrayList;
    }
    return null;
  }
  
  public String l()
  {
    return l.a(this.a, "method", null);
  }
  
  public String m()
  {
    return l.a(this.a, "checkPage", null);
  }
  
  public String n()
  {
    return l.a(this.a, "checkVar", null);
  }
  
  public String o()
  {
    return l.a(this.a, "checkVal", null);
  }
  
  public String p()
  {
    return l.a(this.a, "user", null);
  }
  
  public String q()
  {
    return l.a(this.a, "pass", null);
  }
  
  public String r()
  {
    return l.a(this.a, "url", null);
  }
  
  public String s()
  {
    return l.a(this.a, "suffix", null);
  }
  
  public boolean t()
  {
    return l.a(this.a, "skipExtend", 0) == 1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/a/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */