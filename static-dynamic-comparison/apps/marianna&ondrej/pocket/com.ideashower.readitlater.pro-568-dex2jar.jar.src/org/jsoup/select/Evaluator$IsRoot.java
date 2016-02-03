package org.jsoup.select;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public final class Evaluator$IsRoot
  extends Evaluator
{
  public boolean matches(Element paramElement1, Element paramElement2)
  {
    boolean bool = false;
    Element localElement = paramElement1;
    if ((paramElement1 instanceof Document)) {
      localElement = paramElement1.child(0);
    }
    if (paramElement2 == localElement) {
      bool = true;
    }
    return bool;
  }
  
  public String toString()
  {
    return ":root";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/select/Evaluator$IsRoot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */