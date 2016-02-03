package org.jsoup.select;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public final class Evaluator$IsFirstChild
  extends Evaluator
{
  public boolean matches(Element paramElement1, Element paramElement2)
  {
    paramElement1 = paramElement2.parent();
    return (paramElement1 != null) && (!(paramElement1 instanceof Document)) && (paramElement2.elementSiblingIndex().intValue() == 0);
  }
  
  public String toString()
  {
    return ":first-child";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/select/Evaluator$IsFirstChild.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */