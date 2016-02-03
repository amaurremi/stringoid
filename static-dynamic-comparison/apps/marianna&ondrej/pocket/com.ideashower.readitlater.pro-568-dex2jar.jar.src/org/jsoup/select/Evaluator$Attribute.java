package org.jsoup.select;

import org.jsoup.nodes.Element;

public final class Evaluator$Attribute
  extends Evaluator
{
  private String key;
  
  public Evaluator$Attribute(String paramString)
  {
    this.key = paramString;
  }
  
  public boolean matches(Element paramElement1, Element paramElement2)
  {
    return paramElement2.hasAttr(this.key);
  }
  
  public String toString()
  {
    return String.format("[%s]", new Object[] { this.key });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/select/Evaluator$Attribute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */