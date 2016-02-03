package com.scoreloop.client.android.core.model;

import com.scoreloop.client.android.core.PublishedFor__1_0_0;
import com.scoreloop.client.android.core.utils.Formats;
import com.scoreloop.client.android.core.utils.JSONUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class Challenge
  implements MessageTarget
{
  private Date a;
  private User b;
  private Score c;
  private Integer d;
  private User e;
  private Score f;
  private Integer g;
  private Map<String, Object> h;
  private Date i;
  private String j;
  private String k;
  private Integer l;
  private User m;
  private Integer n;
  private Money o;
  private Money p;
  private Money q;
  private Money r;
  private Money s;
  private String t;
  private User u;
  
  @PublishedFor__1_0_0
  public Challenge(Money paramMoney)
  {
    a(paramMoney);
    this.t = "created";
  }
  
  public Challenge(JSONObject paramJSONObject)
    throws JSONException
  {
    a(paramJSONObject);
  }
  
  private void a(Money paramMoney)
  {
    this.q = paramMoney;
  }
  
  private String c()
  {
    return this.t;
  }
  
  public JSONObject a()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("id", this.k);
    localJSONObject.put("state", this.t);
    localJSONObject.put("level", this.l);
    localJSONObject.put("mode", this.n);
    localJSONObject.put("game_id", this.j);
    if (this.b != null) {
      localJSONObject.put("contender_id", this.b.getIdentifier());
    }
    if (this.u != null) {
      localJSONObject.put("winner_id", this.u.getIdentifier());
    }
    if (this.m != null) {
      localJSONObject.put("looser_id", this.m.getIdentifier());
    }
    if (this.q != null) {
      localJSONObject.put("stake", this.q.c());
    }
    String str;
    if (this.e != null)
    {
      str = this.e.getIdentifier();
      if (str != null) {
        localJSONObject.put("contestant_id", str);
      }
    }
    else
    {
      if (this.f != null)
      {
        str = this.f.getIdentifier();
        if (str == null) {
          break label268;
        }
        localJSONObject.put("contestant_score_id", str);
      }
      label201:
      if (this.c != null)
      {
        str = this.c.getIdentifier();
        if (str == null) {
          break label285;
        }
        localJSONObject.put("contender_score_id", str);
      }
    }
    for (;;)
    {
      if (this.h != null) {
        localJSONObject.put("context", JSONUtils.a(this.h));
      }
      return localJSONObject;
      localJSONObject.put("contestant", this.e.d());
      break;
      label268:
      localJSONObject.put("contestant_score", this.f.c());
      break label201;
      label285:
      localJSONObject.put("contender_score", this.c.c());
    }
  }
  
  public void a(Score paramScore)
  {
    if ((this.b == null) || (this.b.equals(paramScore.getUser())))
    {
      if (isOpen()) {
        throw new IllegalStateException("Can not modify a already open challenge");
      }
      if (isComplete()) {
        throw new IllegalStateException("Can not modify a already completed challenge");
      }
      this.b = paramScore.getUser();
      this.c = paramScore;
      this.t = "open";
      return;
    }
    if ((this.e == null) || (this.e.equals(paramScore.getUser())))
    {
      if ((!isCreated()) && (!isOpen()) && (!isAccepted())) {
        throw new IllegalStateException("Can not submit a score for a non-open challenge");
      }
      this.e = paramScore.getUser();
      this.f = paramScore;
      this.t = "complete";
      return;
    }
    throw new IllegalStateException("Can not change already assigned contender or contestant");
  }
  
  public void a(User paramUser, boolean paramBoolean)
  {
    if ((!isOpen()) && (!isAssigned()))
    {
      if ((isAccepted()) && ((!isAccepted()) || (!paramBoolean))) {
        throw new IllegalStateException("Can not accept a rejected challenge");
      }
      if ((isRejected()) && ((!isRejected()) || (paramBoolean))) {
        throw new IllegalStateException("Can not reject a accepted challenge");
      }
    }
    setContestant(paramUser);
    if (paramBoolean) {}
    for (paramUser = "accepted";; paramUser = "rejected")
    {
      a(paramUser);
      return;
    }
  }
  
  void a(String paramString)
  {
    this.t = paramString;
  }
  
  public void a(JSONObject paramJSONObject)
    throws JSONException
  {
    if (paramJSONObject.has("id")) {
      this.k = paramJSONObject.getString("id");
    }
    if (paramJSONObject.has("state")) {
      this.t = paramJSONObject.getString("state");
    }
    if (paramJSONObject.has("level")) {
      this.l = Integer.valueOf(paramJSONObject.getInt("level"));
    }
    if (paramJSONObject.has("mode")) {
      this.n = Integer.valueOf(paramJSONObject.getInt("mode"));
    }
    if (paramJSONObject.has("game_id")) {
      this.j = paramJSONObject.getString("game_id");
    }
    if (paramJSONObject.has("contender_id"))
    {
      this.b = new User();
      this.b.d(paramJSONObject.getString("contender_id"));
    }
    if (paramJSONObject.has("contender")) {
      this.b = new User(paramJSONObject.getJSONObject("contender"));
    }
    if (paramJSONObject.has("contestant_id"))
    {
      this.e = new User();
      this.e.d(paramJSONObject.getString("contestant_id"));
    }
    if (paramJSONObject.has("contestant")) {
      this.e = new User(paramJSONObject.getJSONObject("contestant"));
    }
    if (paramJSONObject.has("winner"))
    {
      if ((this.b == null) || (this.e == null)) {
        throw new JSONException("winner present but missing contender or contestant");
      }
      if (paramJSONObject.getJSONObject("winner").getString("id").equals(this.b.getIdentifier()))
      {
        this.u = this.b;
        this.m = this.e;
      }
    }
    else
    {
      if (paramJSONObject.has("contender_score")) {
        this.c = new Score(paramJSONObject.getJSONObject("contender_score"));
      }
      if (paramJSONObject.has("contestant_score")) {
        this.f = new Score(paramJSONObject.getJSONObject("contestant_score"));
      }
      if (paramJSONObject.has("contender_skill_value")) {
        this.d = Integer.valueOf(paramJSONObject.getInt("contender_skill_value"));
      }
      if (paramJSONObject.has("contestant_skill_value")) {
        this.g = Integer.valueOf(paramJSONObject.getInt("contestant_skill_value"));
      }
      if (paramJSONObject.has("stake")) {
        this.q = new Money(paramJSONObject.getJSONObject("stake"));
      }
      if (paramJSONObject.has("price")) {
        this.o = new Money(paramJSONObject.getJSONObject("price"));
      }
      if (!paramJSONObject.has("stake_in_local_currency")) {
        break label627;
      }
      this.s = new Money(paramJSONObject.getJSONObject("stake_in_local_currency"));
    }
    for (;;)
    {
      if (paramJSONObject.has("stake_in_contestant_currency")) {
        this.r = new Money(paramJSONObject.getJSONObject("stake_in_contestant_currency"));
      }
      if (paramJSONObject.has("price_in_contestant_currency")) {
        this.p = new Money(paramJSONObject.getJSONObject("price_in_contestant_currency"));
      }
      if (paramJSONObject.has("created_at")) {}
      for (;;)
      {
        try
        {
          this.i = Formats.a.parse(paramJSONObject.getString("created_at"));
          if (!paramJSONObject.has("completed_at")) {}
        }
        catch (ParseException paramJSONObject)
        {
          label627:
          throw new JSONException("Invalid format of creation date");
        }
        try
        {
          this.a = Formats.a.parse(paramJSONObject.getString("completed_at"));
          if ((paramJSONObject.has("context")) && (!paramJSONObject.isNull("context"))) {
            this.h = JSONUtils.a(paramJSONObject.getJSONObject("context"));
          }
          return;
        }
        catch (ParseException paramJSONObject)
        {
          throw new JSONException("Invalid format of completion date");
        }
      }
      this.u = this.e;
      this.m = this.b;
      break;
      if (this.q != null) {
        this.s = this.q.b();
      } else {
        this.q = null;
      }
    }
  }
  
  public String b()
  {
    return "challenge";
  }
  
  @PublishedFor__1_0_0
  public Date getCompletedAt()
  {
    return this.a;
  }
  
  @PublishedFor__1_0_0
  public User getContender()
  {
    return this.b;
  }
  
  @PublishedFor__1_0_0
  public Score getContenderScore()
  {
    return this.c;
  }
  
  @PublishedFor__1_0_0
  public Integer getContenderSkill()
  {
    return this.d;
  }
  
  @PublishedFor__1_0_0
  public User getContestant()
  {
    return this.e;
  }
  
  @PublishedFor__1_0_0
  public Score getContestantScore()
  {
    return this.f;
  }
  
  @PublishedFor__1_0_0
  public Integer getContestantSkill()
  {
    return this.g;
  }
  
  @PublishedFor__1_0_0
  public Map<String, Object> getContext()
  {
    return this.h;
  }
  
  @PublishedFor__1_0_0
  public Date getCreatedAt()
  {
    return this.i;
  }
  
  @PublishedFor__1_0_0
  public String getIdentifier()
  {
    return this.k;
  }
  
  @PublishedFor__1_0_0
  public Integer getLevel()
  {
    return this.l;
  }
  
  @PublishedFor__1_0_0
  public User getLoser()
  {
    return this.m;
  }
  
  @PublishedFor__1_0_0
  public Integer getMode()
  {
    return this.n;
  }
  
  @PublishedFor__1_0_0
  public Money getPrize()
  {
    return this.o;
  }
  
  @PublishedFor__1_0_0
  public Money getStake()
  {
    return this.q;
  }
  
  @PublishedFor__1_0_0
  public User getWinner()
  {
    return this.u;
  }
  
  @PublishedFor__1_0_0
  public boolean isAccepted()
  {
    return "accepted".equalsIgnoreCase(c());
  }
  
  @PublishedFor__1_0_0
  public boolean isAssigned()
  {
    return "assigned".equalsIgnoreCase(c());
  }
  
  @PublishedFor__1_0_0
  public boolean isCancelled()
  {
    return "cancelled".equalsIgnoreCase(c());
  }
  
  @PublishedFor__1_0_0
  public boolean isComplete()
  {
    return "complete".equalsIgnoreCase(c());
  }
  
  @PublishedFor__1_0_0
  public boolean isCreated()
  {
    return "created".equalsIgnoreCase(c());
  }
  
  @PublishedFor__1_0_0
  public boolean isDone()
  {
    return "done".equalsIgnoreCase(c());
  }
  
  @PublishedFor__1_0_0
  public boolean isInvalid()
  {
    return "invalid".equalsIgnoreCase(c());
  }
  
  @PublishedFor__1_0_0
  public boolean isInvited()
  {
    return "invited".equalsIgnoreCase(c());
  }
  
  @PublishedFor__1_0_0
  public boolean isOpen()
  {
    return "open".equalsIgnoreCase(c());
  }
  
  @PublishedFor__1_0_0
  public boolean isPlayableForUser(User paramUser)
  {
    return (getIdentifier() == null) || (((isOpen()) || (isAssigned())) && (!getContender().equals(paramUser)));
  }
  
  @PublishedFor__1_0_0
  public boolean isRejected()
  {
    return "rejected".equalsIgnoreCase(c());
  }
  
  @PublishedFor__1_0_0
  public boolean isWinner(User paramUser)
  {
    if (paramUser == null) {
      throw new IllegalArgumentException();
    }
    return paramUser.equals(getWinner());
  }
  
  @PublishedFor__1_0_0
  public void setContender(User paramUser)
  {
    this.b = paramUser;
  }
  
  @PublishedFor__1_0_0
  public void setContenderScore(Score paramScore)
  {
    this.c = paramScore;
  }
  
  @PublishedFor__1_0_0
  public void setContestant(User paramUser)
  {
    this.e = paramUser;
  }
  
  @PublishedFor__1_0_0
  public void setContestantScore(Score paramScore)
  {
    this.f = paramScore;
  }
  
  @PublishedFor__1_0_0
  public void setContext(Map<String, Object> paramMap)
  {
    this.h = paramMap;
  }
  
  @PublishedFor__1_0_0
  public void setLevel(Integer paramInteger)
  {
    this.l = paramInteger;
  }
  
  @PublishedFor__1_0_0
  public void setMode(Integer paramInteger)
  {
    this.n = paramInteger;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/model/Challenge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */