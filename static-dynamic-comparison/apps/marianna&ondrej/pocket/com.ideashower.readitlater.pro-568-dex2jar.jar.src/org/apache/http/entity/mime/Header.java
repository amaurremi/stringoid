package org.apache.http.entity.mime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Header
  implements Iterable
{
  private final Map fieldMap = new HashMap();
  private final List fields = new LinkedList();
  
  public void addField(MinimalField paramMinimalField)
  {
    if (paramMinimalField == null) {
      return;
    }
    String str = paramMinimalField.getName().toLowerCase(Locale.US);
    List localList = (List)this.fieldMap.get(str);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new LinkedList();
      this.fieldMap.put(str, localObject);
    }
    ((List)localObject).add(paramMinimalField);
    this.fields.add(paramMinimalField);
  }
  
  public MinimalField getField(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = paramString.toLowerCase(Locale.US);
    paramString = (List)this.fieldMap.get(paramString);
    if ((paramString != null) && (!paramString.isEmpty())) {
      return (MinimalField)paramString.get(0);
    }
    return null;
  }
  
  public List getFields()
  {
    return new ArrayList(this.fields);
  }
  
  public List getFields(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = paramString.toLowerCase(Locale.US);
    paramString = (List)this.fieldMap.get(paramString);
    if ((paramString == null) || (paramString.isEmpty())) {
      return Collections.emptyList();
    }
    return new ArrayList(paramString);
  }
  
  public Iterator iterator()
  {
    return Collections.unmodifiableList(this.fields).iterator();
  }
  
  public int removeFields(String paramString)
  {
    if (paramString == null) {
      return 0;
    }
    paramString = paramString.toLowerCase(Locale.US);
    paramString = (List)this.fieldMap.remove(paramString);
    if ((paramString == null) || (paramString.isEmpty())) {
      return 0;
    }
    this.fields.removeAll(paramString);
    return paramString.size();
  }
  
  public void setField(MinimalField paramMinimalField)
  {
    if (paramMinimalField == null) {
      return;
    }
    Object localObject = paramMinimalField.getName().toLowerCase(Locale.US);
    localObject = (List)this.fieldMap.get(localObject);
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      addField(paramMinimalField);
      return;
    }
    ((List)localObject).clear();
    ((List)localObject).add(paramMinimalField);
    localObject = this.fields.iterator();
    int i = 0;
    int k;
    for (int j = -1; ((Iterator)localObject).hasNext(); j = k)
    {
      k = j;
      if (((MinimalField)((Iterator)localObject).next()).getName().equalsIgnoreCase(paramMinimalField.getName()))
      {
        ((Iterator)localObject).remove();
        k = j;
        if (j == -1) {
          k = i;
        }
      }
      i += 1;
    }
    this.fields.add(j, paramMinimalField);
  }
  
  public String toString()
  {
    return this.fields.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/apache/http/entity/mime/Header.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */