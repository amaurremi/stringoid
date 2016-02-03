package org.jsoup.select;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public abstract class Evaluator$CssNthEvaluator
  extends Evaluator
{
  protected final int a;
  protected final int b;
  
  public Evaluator$CssNthEvaluator(int paramInt)
  {
    this(0, paramInt);
  }
  
  public Evaluator$CssNthEvaluator(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  protected abstract int calculatePosition(Element paramElement1, Element paramElement2);
  
  protected abstract String getPseudoClass();
  
  public boolean matches(Element paramElement1, Element paramElement2)
  {
    boolean bool = true;
    Element localElement = paramElement2.parent();
    if ((localElement == null) || ((localElement instanceof Document))) {
      bool = false;
    }
    int i;
    do
    {
      do
      {
        return bool;
        i = calculatePosition(paramElement1, paramElement2);
        if (this.a != 0) {
          break;
        }
      } while (i == this.b);
      return false;
    } while (((i - this.b) * this.a >= 0) && ((i - this.b) % this.a == 0));
    return false;
  }
  
  public String toString()
  {
    if (this.a == 0) {
      return String.format(":%s(%d)", new Object[] { getPseudoClass(), Integer.valueOf(this.b) });
    }
    if (this.b == 0) {
      return String.format(":%s(%dn)", new Object[] { getPseudoClass(), Integer.valueOf(this.a) });
    }
    return String.format(":%s(%dn%+d)", new Object[] { getPseudoClass(), Integer.valueOf(this.a), Integer.valueOf(this.b) });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/select/Evaluator$CssNthEvaluator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */