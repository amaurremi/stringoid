package org.jsoup.select;

import java.util.List;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.DocumentType;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.XmlDeclaration;

public final class Evaluator$IsEmpty
  extends Evaluator
{
  public boolean matches(Element paramElement1, Element paramElement2)
  {
    paramElement1 = paramElement2.childNodes();
    int i = 0;
    while (i < paramElement1.size())
    {
      paramElement2 = (Node)paramElement1.get(i);
      if ((!(paramElement2 instanceof Comment)) && (!(paramElement2 instanceof XmlDeclaration)) && (!(paramElement2 instanceof DocumentType))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public String toString()
  {
    return ":empty";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/select/Evaluator$IsEmpty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */