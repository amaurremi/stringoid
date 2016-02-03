package com.vungle.publisher;

import java.util.Iterator;
import java.util.List;

public final class de
  implements cy.b
{
  public final void a(List<String> paramList)
  {
    if (paramList.isEmpty()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Errors creating object graph:");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      localStringBuilder.append("\n  ").append(str);
    }
    throw new IllegalStateException(localStringBuilder.toString());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/de.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */