package org.jsoup.nodes;

import java.util.AbstractMap;
import java.util.LinkedHashMap;
import java.util.Set;

class Attributes$Dataset
  extends AbstractMap
{
  private Attributes$Dataset(Attributes paramAttributes)
  {
    if (Attributes.access$100(paramAttributes) == null) {
      Attributes.access$102(paramAttributes, new LinkedHashMap(2));
    }
  }
  
  public Set entrySet()
  {
    return new Attributes.Dataset.EntrySet(this, null);
  }
  
  public String put(String paramString1, String paramString2)
  {
    String str = Attributes.access$300(paramString1);
    if (this.this$0.hasKey(str)) {}
    for (paramString1 = ((Attribute)Attributes.access$100(this.this$0).get(str)).getValue();; paramString1 = null)
    {
      paramString2 = new Attribute(str, paramString2);
      Attributes.access$100(this.this$0).put(str, paramString2);
      return paramString1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/nodes/Attributes$Dataset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */