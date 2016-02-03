package com.vungle.publisher;

import com.vungle.publisher.net.http.HttpRequest;
import com.vungle.publisher.net.http.HttpTransaction;
import com.vungle.publisher.protocol.TrackEventHttpRequest;
import com.vungle.publisher.protocol.TrackEventHttpRequest.Factory;
import com.vungle.publisher.protocol.TrackEventHttpTransactionFactory;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.inject.Inject;

public class bt
  extends bu
{
  @Inject
  public TrackEventHttpTransactionFactory a;
  
  protected final String a()
  {
    return VungleService.EXTERNAL_REQUEST_ACTION;
  }
  
  public final void a(Map<String, String> paramMap, String... paramVarArgs)
  {
    int i;
    String str1;
    TrackEventHttpTransactionFactory localTrackEventHttpTransactionFactory;
    Object localObject;
    if (paramVarArgs != null)
    {
      int k = paramVarArgs.length;
      i = 0;
      if (i < k)
      {
        str1 = paramVarArgs[i];
        if (str1 != null)
        {
          localTrackEventHttpTransactionFactory = this.a;
          if (paramMap == null) {
            break label216;
          }
          localObject = new StringBuilder(str1);
          Iterator localIterator = paramMap.entrySet().iterator();
          while (localIterator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            String str2 = (String)localEntry.getKey();
            int j = -1;
            j = ((StringBuilder)localObject).indexOf(str2, j);
            if (j > 0)
            {
              if (localEntry.getValue() == null) {}
              for (str1 = "";; str1 = (String)localEntry.getValue())
              {
                ((StringBuilder)localObject).replace(j, str2.length() + j, str1);
                break;
              }
            }
          }
          str1 = ((StringBuilder)localObject).toString();
        }
      }
    }
    label216:
    for (;;)
    {
      localObject = (TrackEventHttpRequest)localTrackEventHttpTransactionFactory.a.c();
      ((HttpRequest)localObject).b = str1;
      a(new HttpTransaction((HttpRequest)localObject, localTrackEventHttpTransactionFactory.b));
      i += 1;
      break;
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */