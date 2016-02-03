package com.scoreloop.client.android.core.controller;

import com.scoreloop.client.android.core.model.Game;
import com.scoreloop.client.android.core.model.Session;
import com.scoreloop.client.android.core.server.Request;
import com.scoreloop.client.android.core.server.Response;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class GamesController
  extends RequestController
{
  private d<Game> b = new d();
  
  public GamesController(Session paramSession, RequestControllerObserver paramRequestControllerObserver)
  {
    super(paramSession, paramRequestControllerObserver);
  }
  
  boolean a(Request paramRequest, Response paramResponse)
    throws Exception
  {
    if ((paramResponse.f() == 200) && (paramResponse.d() != null))
    {
      paramRequest = new ArrayList();
      paramResponse = paramResponse.d();
      int i = 0;
      while (i < paramResponse.length())
      {
        paramRequest.add(new Game(paramResponse.getJSONObject(i).getJSONObject("game")));
        i += 1;
      }
      this.b.a(paramRequest);
      return true;
    }
    throw new Exception("Request failed");
  }
  
  boolean g()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/controller/GamesController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */