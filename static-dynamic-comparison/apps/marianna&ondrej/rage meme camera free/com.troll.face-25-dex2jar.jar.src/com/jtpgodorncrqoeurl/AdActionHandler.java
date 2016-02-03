package com.jtpgodorncrqoeurl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class AdActionHandler
  extends Activity
{
  private HashMap a = new HashMap();
  private RelativeLayout b;
  
  private AdPlayer a(Bundle paramBundle, AdView.ACTION paramACTION)
  {
    AdController.PlayerProperties localPlayerProperties = (AdController.PlayerProperties)paramBundle.getParcelable("player_properties");
    AdController.Dimensions localDimensions = (AdController.Dimensions)paramBundle.getParcelable("expand_dimensions");
    AdPlayer localAdPlayer = new AdPlayer(this);
    localAdPlayer.setPlayData(localPlayerProperties, AdUtils.getData("expand_url", paramBundle));
    if (localDimensions == null)
    {
      paramBundle = new RelativeLayout.LayoutParams(-1, -1);
      paramBundle.addRule(13);
    }
    for (;;)
    {
      localAdPlayer.setLayoutParams(paramBundle);
      this.b.addView(localAdPlayer);
      this.a.put(paramACTION, localAdPlayer);
      localAdPlayer.setListener(new a(this));
      return localAdPlayer;
      paramBundle = new RelativeLayout.LayoutParams(localDimensions.width, localDimensions.height);
      paramBundle.topMargin = localDimensions.y;
      paramBundle.leftMargin = localDimensions.x;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent().getExtras();
    this.b = new RelativeLayout(this);
    this.b.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    setContentView(this.b);
    Object localObject = paramBundle.getString("action");
    if (localObject != null) {
      localObject = AdView.ACTION.valueOf((String)localObject);
    }
    switch (b.a[localObject.ordinal()])
    {
    default: 
      return;
    case 1: 
      a(paramBundle, (AdView.ACTION)localObject).playAudio();
      return;
    }
    a(paramBundle, (AdView.ACTION)localObject).playVideo();
  }
  
  protected void onStop()
  {
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      switch (b.a[((AdView.ACTION)localEntry.getKey()).ordinal()])
      {
      default: 
        break;
      case 1: 
      case 2: 
        ((AdPlayer)localEntry.getValue()).releasePlayer();
      }
    }
    super.onStop();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/jtpgodorncrqoeurl/AdActionHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */