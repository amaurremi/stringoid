package org.jsoup.select;

import org.jsoup.nodes.Element;

public final class Evaluator$IsNthLastChild
  extends Evaluator.CssNthEvaluator
{
  public Evaluator$IsNthLastChild(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  protected int calculatePosition(Element paramElement1, Element paramElement2)
  {
    return paramElement2.parent().children().size() - paramElement2.elementSiblingIndex().intValue();
  }
  
  protected String getPseudoClass()
  {
    return "nth-last-child";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/select/Evaluator$IsNthLastChild.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */