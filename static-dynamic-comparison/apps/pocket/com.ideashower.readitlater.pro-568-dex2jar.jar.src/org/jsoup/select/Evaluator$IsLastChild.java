package org.jsoup.select;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public final class Evaluator$IsLastChild
  extends Evaluator
{
  public boolean matches(Element paramElement1, Element paramElement2)
  {
    paramElement1 = paramElement2.parent();
    return (paramElement1 != null) && (!(paramElement1 instanceof Document)) && (paramElement2.elementSiblingIndex().intValue() == paramElement1.children().size() - 1);
  }
  
  public String toString()
  {
    return ":last-child";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/select/Evaluator$IsLastChild.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */