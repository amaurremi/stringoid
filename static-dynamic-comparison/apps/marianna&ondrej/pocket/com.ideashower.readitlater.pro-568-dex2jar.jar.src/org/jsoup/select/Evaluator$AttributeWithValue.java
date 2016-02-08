package org.jsoup.select;

import org.jsoup.nodes.Element;

public final class Evaluator$AttributeWithValue
  extends Evaluator.AttributeKeyPair
{
  public Evaluator$AttributeWithValue(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public boolean matches(Element paramElement1, Element paramElement2)
  {
    return (paramElement2.hasAttr(this.key)) && (this.value.equalsIgnoreCase(paramElement2.attr(this.key)));
  }
  
  public String toString()
  {
    return String.format("[%s=%s]", new Object[] { this.key, this.value });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/select/Evaluator$AttributeWithValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */