package org.jsoup.select;

import org.jsoup.nodes.Element;

class StructuralEvaluator$PreviousSibling
  extends StructuralEvaluator
{
  public StructuralEvaluator$PreviousSibling(Evaluator paramEvaluator)
  {
    this.evaluator = paramEvaluator;
  }
  
  public boolean matches(Element paramElement1, Element paramElement2)
  {
    if (paramElement1 == paramElement2) {}
    for (;;)
    {
      return false;
      for (paramElement2 = paramElement2.previousElementSibling(); paramElement2 != null; paramElement2 = paramElement2.previousElementSibling()) {
        if (this.evaluator.matches(paramElement1, paramElement2)) {
          return true;
        }
      }
    }
  }
  
  public String toString()
  {
    return String.format(":prev*%s", new Object[] { this.evaluator });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/select/StructuralEvaluator$PreviousSibling.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */