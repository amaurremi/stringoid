package com.tapjoy.mraid.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tapjoy.mraid.controller.Abstract.Dimensions;
import com.tapjoy.mraid.controller.Abstract.PlayerProperties;
import com.tapjoy.mraid.listener.Player;
import com.tapjoy.mraid.util.MraidPlayer;
import com.tapjoy.mraid.util.Utils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class ActionHandler
  extends Activity
{
  private static final String TAG = "MRAID Action Handler";
  private HashMap<MraidView.Action, Object> actionData = new HashMap();
  private RelativeLayout layout;
  
  private void doAction(Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("action");
    if (localObject == null) {
      return;
    }
    localObject = MraidView.Action.valueOf((String)localObject);
    switch (localObject)
    {
    default: 
      return;
    case ???: 
      initPlayer(paramBundle, (MraidView.Action)localObject).playAudio();
      return;
    }
    initPlayer(paramBundle, (MraidView.Action)localObject).playVideo();
  }
  
  private void setPlayerListener(MraidPlayer paramMraidPlayer)
  {
    paramMraidPlayer.setListener(new Player()
    {
      public void onComplete()
      {
        ActionHandler.this.finish();
      }
      
      public void onError()
      {
        ActionHandler.this.finish();
      }
      
      public void onPrepared() {}
    });
  }
  
  MraidPlayer initPlayer(Bundle paramBundle, MraidView.Action paramAction)
  {
    Abstract.PlayerProperties localPlayerProperties = (Abstract.PlayerProperties)paramBundle.getParcelable("player_properties");
    Abstract.Dimensions localDimensions = (Abstract.Dimensions)paramBundle.getParcelable("expand_dimensions");
    MraidPlayer localMraidPlayer = new MraidPlayer(this);
    localMraidPlayer.setPlayData(localPlayerProperties, Utils.getData("expand_url", paramBundle));
    if ((!localPlayerProperties.inline) && (localPlayerProperties.startStyle.equals("fullscreen")))
    {
      getWindow().setFlags(1024, 1024);
      getWindow().setFlags(16777216, 16777216);
      paramBundle = new RelativeLayout.LayoutParams(-1, -1);
      paramBundle.addRule(13);
    }
    for (;;)
    {
      localMraidPlayer.setLayoutParams(paramBundle);
      this.layout.addView(localMraidPlayer);
      this.actionData.put(paramAction, localMraidPlayer);
      setPlayerListener(localMraidPlayer);
      return localMraidPlayer;
      paramBundle = new RelativeLayout.LayoutParams(localDimensions.width, localDimensions.height);
      paramBundle.topMargin = localDimensions.y;
      paramBundle.leftMargin = localDimensions.x;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    paramBundle = getIntent().getExtras();
    this.layout = new RelativeLayout(this);
    this.layout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.layout.setBackgroundColor(-16777216);
    setContentView(this.layout);
    doAction(paramBundle);
  }
  
  protected void onStop()
  {
    Iterator localIterator = this.actionData.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      switch ((MraidView.Action)localEntry.getKey())
      {
      default: 
        break;
      case ???: 
      case ???: 
        ((MraidPlayer)localEntry.getValue()).releasePlayer();
      }
    }
    super.onStop();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/tapjoy/mraid/view/ActionHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */