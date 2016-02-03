package org.jsoup.nodes;

import java.util.AbstractSet;
import java.util.Iterator;

class Attributes$Dataset$EntrySet
  extends AbstractSet
{
  private Attributes$Dataset$EntrySet(Attributes.Dataset paramDataset) {}
  
  public Iterator iterator()
  {
    return new Attributes.Dataset.DatasetIterator(this.this$1, null);
  }
  
  public int size()
  {
    int i = 0;
    Attributes.Dataset.DatasetIterator localDatasetIterator = new Attributes.Dataset.DatasetIterator(this.this$1, null);
    while (localDatasetIterator.hasNext()) {
      i += 1;
    }
    return i;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/nodes/Attributes$Dataset$EntrySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */