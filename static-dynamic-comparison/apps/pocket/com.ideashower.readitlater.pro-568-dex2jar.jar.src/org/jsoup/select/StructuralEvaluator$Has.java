package org.jsoup.select;

import java.util.Iterator;
import org.jsoup.nodes.Element;

class StructuralEvaluator$Has
  extends StructuralEvaluator
{
  public StructuralEvaluator$Has(Evaluator paramEvaluator)
  {
    this.evaluator = paramEvaluator;
  }
  
  public boolean matches(Element paramElement1, Element paramElement2)
  {
    Iterator localIterator = paramElement2.getAllElements().iterator();
    while (localIterator.hasNext())
    {
      Element localElement = (Element)localIterator.next();
      if ((localElement != paramElement2) && (this.evaluator.matches(paramElement1, localElement))) {
        return true;
      }
    }
    return false;
  }
  
  public String toString()
  {
    return String.format(":has(%s)", new Object[] { this.evaluator });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/select/StructuralEvaluator$Has.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */