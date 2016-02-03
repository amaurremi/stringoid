package org.jsoup.select;

import org.jsoup.nodes.Element;

public final class Evaluator$AttributeWithValueContaining
  extends Evaluator.AttributeKeyPair
{
  public Evaluator$AttributeWithValueContaining(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public boolean matches(Element paramElement1, Element paramElement2)
  {
    return (paramElement2.hasAttr(this.key)) && (paramElement2.attr(this.key).toLowerCase().contains(this.value));
  }
  
  public String toString()
  {
    return String.format("[%s*=%s]", new Object[] { this.key, this.value });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/select/Evaluator$AttributeWithValueContaining.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */