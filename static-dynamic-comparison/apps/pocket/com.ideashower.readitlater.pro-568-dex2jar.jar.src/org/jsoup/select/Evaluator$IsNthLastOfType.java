package org.jsoup.select;

import org.jsoup.nodes.Element;

public class Evaluator$IsNthLastOfType
  extends Evaluator.CssNthEvaluator
{
  public Evaluator$IsNthLastOfType(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  protected int calculatePosition(Element paramElement1, Element paramElement2)
  {
    int j = 0;
    paramElement1 = paramElement2.parent().children();
    int i = paramElement2.elementSiblingIndex().intValue();
    while (i < paramElement1.size())
    {
      int k = j;
      if (paramElement1.get(i).tag() == paramElement2.tag()) {
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  protected String getPseudoClass()
  {
    return "nth-last-of-type";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/select/Evaluator$IsNthLastOfType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */