package mobi.beyondpod.ui.core.volley;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.HttpStack;
import java.util.Collections;

public class NetworkTrack
  extends BasicNetwork
{
  NetworkResponse _NoResponse = new NetworkResponse(404, null, Collections.emptyMap(), false);
  
  public NetworkTrack(HttpStack paramHttpStack)
  {
    super(paramHttpStack);
  }
  
  public NetworkResponse performRequest(Request<?> paramRequest)
    throws VolleyError
  {
    if ((paramRequest.getUrl().startsWith("file://")) || (paramRequest.getUrl().startsWith("episode://"))) {
      return this._NoResponse;
    }
    return super.performRequest(paramRequest);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/volley/NetworkTrack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */