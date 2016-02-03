package com.scoreloop.client.android.core.controller;

import com.scoreloop.client.android.core.PublishedFor__1_0_0;
import com.scoreloop.client.android.core.model.Device;
import com.scoreloop.client.android.core.model.Game;
import com.scoreloop.client.android.core.model.Score;
import com.scoreloop.client.android.core.model.Session;
import com.scoreloop.client.android.core.server.Request;
import com.scoreloop.client.android.core.server.RequestCompletionCallback;
import com.scoreloop.client.android.core.server.RequestMethod;
import com.scoreloop.client.android.core.server.Response;
import com.scoreloop.client.android.core.utils.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class ScoreController
  extends RequestController
{
  private Score b;
  private boolean c = false;
  private ChallengeController d;
  
  @PublishedFor__1_0_0
  public ScoreController(RequestControllerObserver paramRequestControllerObserver)
  {
    this(null, paramRequestControllerObserver);
  }
  
  @PublishedFor__1_0_0
  public ScoreController(Session paramSession, RequestControllerObserver paramRequestControllerObserver)
  {
    super(paramSession, paramRequestControllerObserver);
  }
  
  private void a(Score paramScore)
  {
    this.b = paramScore;
  }
  
  private void j()
  {
    if (d().getChallenge() != null)
    {
      if (this.c)
      {
        if (this.d == null) {
          this.d = new ChallengeController(d(), new a(null));
        }
        this.d.submitChallengeScore(this.b);
        return;
      }
      Logger.c("It seems that a challenge is in progess. Submitted score won't get associated with that challenge. Call setShouldSubmitScoreForChallenge(true); to make this go away.");
    }
    this.b.a(e());
    b localb = new b(c(), a(), d(), this.b);
    h();
    a(localb);
  }
  
  boolean a(Request paramRequest, Response paramResponse)
    throws Exception
  {
    int i = paramResponse.f();
    paramRequest = paramResponse.e().getJSONObject("score");
    if (getScore() == null)
    {
      a(new Score(paramRequest));
      if ((i != 200) && (i != 201)) {
        break label75;
      }
    }
    label75:
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        break label80;
      }
      throw new Exception("Request failed");
      getScore().a(paramRequest);
      break;
    }
    label80:
    return true;
  }
  
  boolean g()
  {
    return true;
  }
  
  @PublishedFor__1_0_0
  public Score getScore()
  {
    return this.b;
  }
  
  @PublishedFor__1_0_0
  public void setShouldSubmitScoreForChallenge(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  @PublishedFor__1_0_0
  public boolean shouldSubmitScoreForChallenge()
  {
    return this.c;
  }
  
  @PublishedFor__1_0_0
  public void submitScore(Score paramScore)
  {
    if (paramScore == null) {
      throw new IllegalArgumentException("aScore parameter cannot be null");
    }
    a(paramScore);
    j();
  }
  
  private class a
    implements ChallengeControllerObserver
  {
    private a() {}
    
    public void onCannotAcceptChallenge(ChallengeController paramChallengeController)
    {
      throw new IllegalStateException();
    }
    
    public void onCannotRejectChallenge(ChallengeController paramChallengeController)
    {
      throw new IllegalStateException();
    }
    
    public void onInsufficientBalance(ChallengeController paramChallengeController)
    {
      throw new IllegalStateException();
    }
    
    public void requestControllerDidFail(RequestController paramRequestController, Exception paramException)
    {
      ScoreController.this.b().requestControllerDidFail(ScoreController.this, paramException);
    }
    
    public void requestControllerDidReceiveResponse(RequestController paramRequestController)
    {
      ScoreController.this.b().requestControllerDidReceiveResponse(ScoreController.this);
    }
  }
  
  private static class b
    extends Request
  {
    private final Game a;
    private final Score b;
    private final Session c;
    
    public b(RequestCompletionCallback paramRequestCompletionCallback, Game paramGame, Session paramSession, Score paramScore)
    {
      super();
      if (paramGame == null) {
        throw new IllegalStateException("internal error: null game passed");
      }
      this.a = paramGame;
      this.c = paramSession;
      this.b = paramScore;
    }
    
    public String a()
    {
      return String.format("/service/games/%s/scores", new Object[] { this.a.getIdentifier() });
    }
    
    public JSONObject b()
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        this.b.a(this.c.a().a());
        localJSONObject.put("score", this.b.c());
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        throw new IllegalStateException("Invalid score data", localJSONException);
      }
    }
    
    public RequestMethod c()
    {
      return RequestMethod.POST;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/controller/ScoreController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */