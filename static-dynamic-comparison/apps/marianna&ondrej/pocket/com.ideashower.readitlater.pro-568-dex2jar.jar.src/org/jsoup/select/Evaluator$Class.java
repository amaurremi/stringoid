package org.jsoup.select;

import org.jsoup.nodes.Element;

public final class Evaluator$Class
  extends Evaluator
{
  private String className;
  
  public Evaluator$Class(String paramString)
  {
    this.className = paramString;
  }
  
  public boolean matches(Element paramElement1, Element paramElement2)
  {
    return paramElement2.hasClass(this.className);
  }
  
  public String toString()
  {
    return String.format(".%s", new Object[] { this.className });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/select/Evaluator$Class.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */