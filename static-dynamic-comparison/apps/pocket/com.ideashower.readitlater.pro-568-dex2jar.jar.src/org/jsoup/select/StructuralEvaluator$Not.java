package org.jsoup.select;

import org.jsoup.nodes.Element;

class StructuralEvaluator$Not
  extends StructuralEvaluator
{
  public StructuralEvaluator$Not(Evaluator paramEvaluator)
  {
    this.evaluator = paramEvaluator;
  }
  
  public boolean matches(Element paramElement1, Element paramElement2)
  {
    return !this.evaluator.matches(paramElement1, paramElement2);
  }
  
  public String toString()
  {
    return String.format(":not%s", new Object[] { this.evaluator });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/select/StructuralEvaluator$Not.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */