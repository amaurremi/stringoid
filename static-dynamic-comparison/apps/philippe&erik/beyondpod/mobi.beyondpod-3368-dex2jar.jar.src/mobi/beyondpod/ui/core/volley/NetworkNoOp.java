package mobi.beyondpod.ui.core.volley;

import com.android.volley.Network;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import java.util.Collections;

public class NetworkNoOp
  implements Network
{
  NetworkResponse _NoResponse = new NetworkResponse(404, null, Collections.emptyMap(), false);
  
  public NetworkResponse performRequest(Request<?> paramRequest)
    throws VolleyError
  {
    return this._NoResponse;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/volley/NetworkNoOp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */