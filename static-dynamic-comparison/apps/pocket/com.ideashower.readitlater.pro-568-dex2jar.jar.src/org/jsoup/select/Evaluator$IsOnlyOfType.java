package org.jsoup.select;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;

public final class Evaluator$IsOnlyOfType
  extends Evaluator
{
  public boolean matches(Element paramElement1, Element paramElement2)
  {
    paramElement1 = paramElement2.parent();
    if ((paramElement1 == null) || ((paramElement1 instanceof Document))) {}
    int j;
    do
    {
      return false;
      paramElement1 = paramElement1.children();
      int i = 0;
      int k;
      for (j = 0; i < paramElement1.size(); j = k)
      {
        k = j;
        if (paramElement1.get(i).tag().equals(paramElement2.tag())) {
          k = j + 1;
        }
        i += 1;
      }
    } while (j != 1);
    return true;
  }
  
  public String toString()
  {
    return ":only-of-type";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/select/Evaluator$IsOnlyOfType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */