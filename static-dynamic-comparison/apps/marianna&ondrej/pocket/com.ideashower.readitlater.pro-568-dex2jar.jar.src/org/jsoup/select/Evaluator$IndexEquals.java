package org.jsoup.select;

import org.jsoup.nodes.Element;

public final class Evaluator$IndexEquals
  extends Evaluator.IndexEvaluator
{
  public Evaluator$IndexEquals(int paramInt)
  {
    super(paramInt);
  }
  
  public boolean matches(Element paramElement1, Element paramElement2)
  {
    return paramElement2.elementSiblingIndex().intValue() == this.index;
  }
  
  public String toString()
  {
    return String.format(":eq(%d)", new Object[] { Integer.valueOf(this.index) });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/select/Evaluator$IndexEquals.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */