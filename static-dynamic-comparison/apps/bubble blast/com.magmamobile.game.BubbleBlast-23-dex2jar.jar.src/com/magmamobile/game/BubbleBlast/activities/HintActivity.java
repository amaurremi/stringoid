package com.magmamobile.game.BubbleBlast.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.magmamobile.game.BubbleBlast.activities.adapters.SolutionAdapter;
import com.magmamobile.game.BubbleBlast.modCommon;
import com.magmamobile.game.BubbleBlast.utils.solutions.Solution;
import com.magmamobile.game.BubbleBlast.utils.solutions.modSolution;
import com.magmamobile.game.BubbleBlast.utils.solutions.parsers.JSonBBSolution;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;

public class HintActivity
  extends Activity
  implements View.OnClickListener, Animation.AnimationListener
{
  private final int MSG_LOADERROR = 6;
  private final int MSG_LOADJSONFINISH = 5;
  private final int MSG_TOAST = 4;
  private int levelNum = 43;
  Handler messageHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 4: 
        Toast.makeText(HintActivity.this, (String)paramAnonymousMessage.obj, 1).show();
        return;
      case 5: 
        if (HintActivity.this.sol == null)
        {
          HintActivity.this.getString(2131034166);
          HintActivity.this.displayLinear(2131099670);
          return;
        }
        ((LinearLayout)HintActivity.this.findViewById(2131099663)).setVisibility(8);
        ((TextView)HintActivity.this.findViewById(2131099662)).setText(String.format(HintActivity.this.getString(2131034243), new Object[] { HintActivity.this.sol.solutionCount + " " }));
        if (HintActivity.this.sol.hasSolution)
        {
          paramAnonymousMessage = new SolutionAdapter(HintActivity.this, HintActivity.this.sol);
          ((ListView)HintActivity.this.findViewById(2131099665)).setAdapter(paramAnonymousMessage);
          return;
        }
        HintActivity.this.displayLinear(2131099670);
        return;
      case 6: 
        ((LinearLayout)HintActivity.this.findViewById(2131099663)).setVisibility(8);
        ((TextView)HintActivity.this.findViewById(2131099662)).setVisibility(8);
        return;
      }
      HintActivity.this.quit();
    }
  };
  private int packNum = 1;
  private Solution sol;
  private Typeface tf;
  
  private List<NameValuePair> buildUrlParam(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("di", modCommon.getDeviceID(paramContext)));
    localArrayList.add(new BasicNameValuePair("aid", "1"));
    localArrayList.add(new BasicNameValuePair("pn", this.packNum));
    localArrayList.add(new BasicNameValuePair("ln", this.levelNum));
    return localArrayList;
  }
  
  public void displayLinear(int paramInt)
  {
    findViewById(2131099654).setVisibility(8);
    findViewById(2131099659).setVisibility(8);
    findViewById(2131099666).setVisibility(8);
    findViewById(2131099670).setVisibility(8);
    findViewById(paramInt).setVisibility(0);
  }
  
  public void loadSolution(final Context paramContext)
  {
    new Thread()
    {
      public void run()
      {
        HintActivity.this.loadSolutionThread(paramContext);
      }
    }.start();
  }
  
  public void loadSolutionThread(Context paramContext)
  {
    try
    {
      this.sol = JSonBBSolution.loadItems("http://api.magmamobile.com/api/bbsol.ashx", buildUrlParam(this));
      if (this.sol != null) {
        if (this.sol.hasSolution) {
          modSolution.setAskedSolutionDate(this, this.packNum + "-" + this.levelNum);
        }
      }
      for (;;)
      {
        this.messageHandler.sendMessage(Message.obtain(this.messageHandler, 5));
        return;
        this.messageHandler.sendMessage(Message.obtain(this.messageHandler, 4, 0, 0, paramContext.getString(2131034166)));
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        this.messageHandler.sendMessage(Message.obtain(this.messageHandler, 4, 0, 0, paramContext.getString(2131034166)));
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    finish();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131099657: 
      displayLinear(2131099659);
      loadSolution(this);
      return;
    case 2131099658: 
      quit();
      return;
    case 2131099669: 
      quit();
      return;
    }
    quit();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903042);
    paramBundle = getIntent().getExtras();
    this.packNum = paramBundle.getInt("packNum");
    this.levelNum = paramBundle.getInt("levelNum");
    ((TextView)findViewById(2131099660)).setText(String.format(getString(2131034240), new Object[] { this.levelNum, this.packNum }));
    ((TextView)findViewById(2131099662)).setText("");
    this.tf = modCommon.getTypeFace(this, getString(2131034112));
    modCommon.useDpi(this);
    ((TextView)findViewById(2131099655)).setTypeface(this.tf);
    ((TextView)findViewById(2131099656)).setTypeface(this.tf);
    ((TextView)findViewById(2131099660)).setTypeface(this.tf);
    ((TextView)findViewById(2131099664)).setTypeface(this.tf);
    ((TextView)findViewById(2131099661)).setTypeface(this.tf);
    ((TextView)findViewById(2131099662)).setTypeface(this.tf);
    ((TextView)findViewById(2131099667)).setTypeface(this.tf);
    ((TextView)findViewById(2131099668)).setTypeface(this.tf);
    displayLinear(2131099654);
    paramBundle = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    paramBundle.setInterpolator(new DecelerateInterpolator());
    paramBundle.setFillAfter(false);
    paramBundle.setDuration(500L);
    findViewById(2131099653).startAnimation(paramBundle);
    setResult(-1);
    ((Button)findViewById(2131099657)).setOnClickListener(this);
    ((Button)findViewById(2131099658)).setOnClickListener(this);
    ((Button)findViewById(2131099669)).setOnClickListener(this);
    ((Button)findViewById(2131099672)).setOnClickListener(this);
    ((Button)findViewById(2131099657)).setTypeface(this.tf);
    ((Button)findViewById(2131099658)).setTypeface(this.tf);
    ((Button)findViewById(2131099669)).setTypeface(this.tf);
    ((Button)findViewById(2131099672)).setTypeface(this.tf);
    ((Button)findViewById(2131099657)).setCompoundDrawablesWithIntrinsicBounds(2130837525, 0, 0, 0);
    ((Button)findViewById(2131099658)).setCompoundDrawablesWithIntrinsicBounds(2130837524, 0, 0, 0);
    ((Button)findViewById(2131099669)).setCompoundDrawablesWithIntrinsicBounds(2130837524, 0, 0, 0);
    ((Button)findViewById(2131099672)).setCompoundDrawablesWithIntrinsicBounds(2130837524, 0, 0, 0);
    if (modSolution.alreadyAskedSolution(this, this.packNum + "-" + this.levelNum))
    {
      onClick(findViewById(2131099657));
      return;
    }
    if (modSolution.canAskSolution(this))
    {
      displayLinear(2131099654);
      return;
    }
    displayLinear(2131099666);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 0) && (paramInt == 4))
    {
      quit();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void quit()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    localTranslateAnimation.setInterpolator(new AccelerateInterpolator());
    localTranslateAnimation.setAnimationListener(this);
    localTranslateAnimation.setFillAfter(true);
    localTranslateAnimation.setDuration(500L);
    findViewById(2131099653).startAnimation(localTranslateAnimation);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/BubbleBlast/activities/HintActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */