package org.jsoup.select;

import org.jsoup.nodes.Element;

public final class Evaluator$IsNthChild
  extends Evaluator.CssNthEvaluator
{
  public Evaluator$IsNthChild(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  protected int calculatePosition(Element paramElement1, Element paramElement2)
  {
    return paramElement2.elementSiblingIndex().intValue() + 1;
  }
  
  protected String getPseudoClass()
  {
    return "nth-child";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/select/Evaluator$IsNthChild.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */