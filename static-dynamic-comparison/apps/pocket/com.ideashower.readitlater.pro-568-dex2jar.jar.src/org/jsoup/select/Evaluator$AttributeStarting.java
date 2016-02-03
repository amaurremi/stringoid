package org.jsoup.select;

import java.util.Iterator;
import java.util.List;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;

public final class Evaluator$AttributeStarting
  extends Evaluator
{
  private String keyPrefix;
  
  public Evaluator$AttributeStarting(String paramString)
  {
    this.keyPrefix = paramString;
  }
  
  public boolean matches(Element paramElement1, Element paramElement2)
  {
    paramElement1 = paramElement2.attributes().asList().iterator();
    while (paramElement1.hasNext()) {
      if (((Attribute)paramElement1.next()).getKey().startsWith(this.keyPrefix)) {
        return true;
      }
    }
    return false;
  }
  
  public String toString()
  {
    return String.format("[^%s]", new Object[] { this.keyPrefix });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/select/Evaluator$AttributeStarting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */