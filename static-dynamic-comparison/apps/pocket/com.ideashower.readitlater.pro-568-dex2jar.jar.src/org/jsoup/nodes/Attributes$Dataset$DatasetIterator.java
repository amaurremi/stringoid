package org.jsoup.nodes;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

class Attributes$Dataset$DatasetIterator
  implements Iterator
{
  private Attribute attr;
  private Iterator attrIter = Attributes.access$100(this.this$1.this$0).values().iterator();
  
  private Attributes$Dataset$DatasetIterator(Attributes.Dataset paramDataset) {}
  
  public boolean hasNext()
  {
    while (this.attrIter.hasNext())
    {
      this.attr = ((Attribute)this.attrIter.next());
      if (this.attr.isDataAttribute()) {
        return true;
      }
    }
    return false;
  }
  
  public Map.Entry next()
  {
    return new Attribute(this.attr.getKey().substring("data-".length()), this.attr.getValue());
  }
  
  public void remove()
  {
    Attributes.access$100(this.this$1.this$0).remove(this.attr.getKey());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/nodes/Attributes$Dataset$DatasetIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */