package org.jsoup.select;

import org.jsoup.nodes.Element;

public final class Evaluator$Tag
  extends Evaluator
{
  private String tagName;
  
  public Evaluator$Tag(String paramString)
  {
    this.tagName = paramString;
  }
  
  public boolean matches(Element paramElement1, Element paramElement2)
  {
    return paramElement2.tagName().equals(this.tagName);
  }
  
  public String toString()
  {
    return String.format("%s", new Object[] { this.tagName });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/select/Evaluator$Tag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */