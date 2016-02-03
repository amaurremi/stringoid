package org.jsoup.select;

import org.jsoup.nodes.Element;

class StructuralEvaluator$ImmediateParent
  extends StructuralEvaluator
{
  public StructuralEvaluator$ImmediateParent(Evaluator paramEvaluator)
  {
    this.evaluator = paramEvaluator;
  }
  
  public boolean matches(Element paramElement1, Element paramElement2)
  {
    if (paramElement1 == paramElement2) {}
    do
    {
      return false;
      paramElement2 = paramElement2.parent();
    } while ((paramElement2 == null) || (!this.evaluator.matches(paramElement1, paramElement2)));
    return true;
  }
  
  public String toString()
  {
    return String.format(":ImmediateParent%s", new Object[] { this.evaluator });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/select/StructuralEvaluator$ImmediateParent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */