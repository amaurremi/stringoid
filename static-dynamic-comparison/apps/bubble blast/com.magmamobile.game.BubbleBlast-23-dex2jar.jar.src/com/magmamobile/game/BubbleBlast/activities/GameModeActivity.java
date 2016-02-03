package com.magmamobile.game.BubbleBlast.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import com.google.ads.AdView;
import com.magmamobile.game.BubbleBlast.activities.adapters.CustomItemList;
import com.magmamobile.game.BubbleBlast.activities.adapters.OptionsAdapter;
import com.magmamobile.game.BubbleBlast.engine.Enums.enumGameMode;
import com.magmamobile.game.BubbleBlast.modCommon;
import com.magmamobile.game.BubbleBlast.modPreferences;
import com.magmamobile.game.BubbleBlast.stages.StageGame;
import com.magmamobile.game.BubbleBlast.utils.GoogleAnalytics;
import java.util.ArrayList;

public class GameModeActivity
  extends Activity
  implements View.OnClickListener
{
  private Button BtnHighScore;
  private AdView adView;
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    paramView = new AlertDialog.Builder(this);
    paramView.setTitle(getString(2131034142));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new CustomItemList(getString(2131034148), BitmapFactory.decodeResource(getResources(), 2130837518), "puzzle"));
    localArrayList.add(new CustomItemList(getString(2131034149), BitmapFactory.decodeResource(getResources(), 2130837518), "arcade"));
    ListView localListView = new ListView(this);
    OptionsAdapter localOptionsAdapter = new OptionsAdapter(this);
    localOptionsAdapter.myDatas = localArrayList;
    try
    {
      localListView.setAdapter(localOptionsAdapter);
      localListView.setBackgroundColor(-1);
      paramView.setView(localListView);
      localListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          paramAnonymousAdapterView = ((CustomItemList)((Adapter)paramAnonymousAdapterView.getAdapter()).getItem(paramAnonymousInt)).tag;
          if (paramAnonymousAdapterView.equals("arcade"))
          {
            paramAnonymousAdapterView = new Intent(GameModeActivity.this, HighScoresActivity.class);
            paramAnonymousAdapterView.putExtra("mode", Enums.enumGameMode.arcade.toString());
            GameModeActivity.this.startActivity(paramAnonymousAdapterView);
            GoogleAnalytics.trackAndDispatch("HighScores/" + Enums.enumGameMode.arcade.toString());
          }
          for (;;)
          {
            this.val$alertDiag.dismiss();
            return;
            if (paramAnonymousAdapterView.equals("puzzle")) {
              GameModeActivity.this.puzzleHighscoreChoose();
            }
          }
        }
      });
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        localIllegalStateException.printStackTrace();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903044);
    modPreferences.LoadPreferences(this);
    com.magmamobile.game.BubbleBlast.App.running = false;
    this.adView = ((AdView)findViewById(2131099693));
    this.BtnHighScore = ((Button)findViewById(2131099684));
    this.BtnHighScore.setOnClickListener(this);
    setButtons();
    GoogleAnalytics.trackAndDispatch("Modes/");
  }
  
  protected void onDestroy()
  {
    int i;
    if (this.adView != null)
    {
      modCommon.Log_d("Adsense adView Found onDestroy");
      i = 0;
      if (i >= this.adView.getChildCount()) {
        this.adView = null;
      }
    }
    else
    {
      super.onDestroy();
      return;
    }
    ViewGroup localViewGroup;
    int j;
    if ((this.adView.getChildAt(i) instanceof ViewGroup))
    {
      modCommon.Log_d("ViewGroup Inside Adsense onDestroy");
      localViewGroup = (ViewGroup)this.adView.getChildAt(i);
      j = 0;
    }
    for (;;)
    {
      if (j >= localViewGroup.getChildCount())
      {
        if ((this.adView.getChildAt(i) instanceof WebView)) {
          ((WebView)this.adView.getChildAt(i)).destroy();
        }
        i += 1;
        break;
      }
      if ((localViewGroup.getChildAt(j) instanceof WebView))
      {
        modCommon.Log_e("Destroy Adsense WebView onDestroy");
        ((WebView)localViewGroup.getChildAt(j)).destroy();
      }
      j += 1;
    }
  }
  
  protected void onResume()
  {
    setButtons();
    super.onResume();
  }
  
  public void puzzleChoose()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    localBuilder.setTitle(getString(2131034191));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new CustomItemList(getString(2131034192), BitmapFactory.decodeResource(getResources(), 2130837529), "1"));
    if (modPreferences.prefPuzzleLevel002Unlocked) {
      localArrayList.add(new CustomItemList(getString(2131034193), BitmapFactory.decodeResource(getResources(), 2130837529), "2"));
    }
    for (;;)
    {
      label127:
      label162:
      label198:
      label235:
      label272:
      label309:
      label346:
      label383:
      label420:
      label457:
      label494:
      label531:
      label568:
      label605:
      label642:
      label679:
      label716:
      label753:
      label790:
      ListView localListView;
      OptionsAdapter localOptionsAdapter;
      if (modPreferences.prefPuzzleLevel003Unlocked)
      {
        localArrayList.add(new CustomItemList(getString(2131034195), BitmapFactory.decodeResource(getResources(), 2130837529), "3"));
        if (!modPreferences.prefPuzzleLevel004Unlocked) {
          break label957;
        }
        localArrayList.add(new CustomItemList(getString(2131034197), BitmapFactory.decodeResource(getResources(), 2130837529), "4"));
        if (!modPreferences.prefPuzzleLevel005Unlocked) {
          break label990;
        }
        localArrayList.add(new CustomItemList(getString(2131034199), BitmapFactory.decodeResource(getResources(), 2130837529), "5"));
        if (!modPreferences.prefPuzzleLevel006Unlocked) {
          break label1024;
        }
        localArrayList.add(new CustomItemList(getString(2131034201), BitmapFactory.decodeResource(getResources(), 2130837529), "6"));
        if (!modPreferences.prefPuzzleLevel007Unlocked) {
          break label1059;
        }
        localArrayList.add(new CustomItemList(getString(2131034203), BitmapFactory.decodeResource(getResources(), 2130837529), "7"));
        if (!modPreferences.prefPuzzleLevel008Unlocked) {
          break label1094;
        }
        localArrayList.add(new CustomItemList(getString(2131034205), BitmapFactory.decodeResource(getResources(), 2130837529), "8"));
        if (!modPreferences.prefPuzzleLevel009Unlocked) {
          break label1129;
        }
        localArrayList.add(new CustomItemList(getString(2131034207), BitmapFactory.decodeResource(getResources(), 2130837529), "9"));
        if (!modPreferences.prefPuzzleLevel010Unlocked) {
          break label1164;
        }
        localArrayList.add(new CustomItemList(getString(2131034209), BitmapFactory.decodeResource(getResources(), 2130837529), "10"));
        if (!modPreferences.prefPuzzleLevel011Unlocked) {
          break label1199;
        }
        localArrayList.add(new CustomItemList(getString(2131034211), BitmapFactory.decodeResource(getResources(), 2130837529), "11"));
        if (!modPreferences.prefPuzzleLevel012Unlocked) {
          break label1234;
        }
        localArrayList.add(new CustomItemList(getString(2131034213), BitmapFactory.decodeResource(getResources(), 2130837529), "12"));
        if (!modPreferences.prefPuzzleLevel013Unlocked) {
          break label1269;
        }
        localArrayList.add(new CustomItemList(getString(2131034215), BitmapFactory.decodeResource(getResources(), 2130837529), "13"));
        if (!modPreferences.prefPuzzleLevel014Unlocked) {
          break label1304;
        }
        localArrayList.add(new CustomItemList(getString(2131034217), BitmapFactory.decodeResource(getResources(), 2130837529), "14"));
        if (!modPreferences.prefPuzzleLevel015Unlocked) {
          break label1339;
        }
        localArrayList.add(new CustomItemList(getString(2131034219), BitmapFactory.decodeResource(getResources(), 2130837529), "15"));
        if (!modPreferences.prefPuzzleLevel016Unlocked) {
          break label1374;
        }
        localArrayList.add(new CustomItemList(getString(2131034221), BitmapFactory.decodeResource(getResources(), 2130837529), "16"));
        if (!modPreferences.prefPuzzleLevel017Unlocked) {
          break label1409;
        }
        localArrayList.add(new CustomItemList(getString(2131034223), BitmapFactory.decodeResource(getResources(), 2130837529), "17"));
        if (!modPreferences.prefPuzzleLevel018Unlocked) {
          break label1444;
        }
        localArrayList.add(new CustomItemList(getString(2131034225), BitmapFactory.decodeResource(getResources(), 2130837529), "18"));
        if (!modPreferences.prefPuzzleLevel019Unlocked) {
          break label1479;
        }
        localArrayList.add(new CustomItemList(getString(2131034227), BitmapFactory.decodeResource(getResources(), 2130837529), "19"));
        if (!modPreferences.prefPuzzleLevel020Unlocked) {
          break label1514;
        }
        localArrayList.add(new CustomItemList(getString(2131034229), BitmapFactory.decodeResource(getResources(), 2130837529), "20"));
        if (!modPreferences.prefPuzzleLevel021Unlocked) {
          break label1549;
        }
        localArrayList.add(new CustomItemList(getString(2131034231), BitmapFactory.decodeResource(getResources(), 2130837529), "21"));
        if (!modPreferences.prefPuzzleLevel022Unlocked) {
          break label1584;
        }
        localArrayList.add(new CustomItemList(getString(2131034233), BitmapFactory.decodeResource(getResources(), 2130837529), "22"));
        localListView = new ListView(this);
        localOptionsAdapter = new OptionsAdapter(this);
        localOptionsAdapter.myDatas = localArrayList;
      }
      try
      {
        localListView.setAdapter(localOptionsAdapter);
        localListView.setBackgroundColor(-1);
        localListView.setCacheColorHint(-1);
        localBuilder.setView(localListView);
        localListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            paramAnonymousAdapterView = ((CustomItemList)((Adapter)paramAnonymousAdapterView.getAdapter()).getItem(paramAnonymousInt)).tag;
            if (paramAnonymousAdapterView.equals("1")) {
              if (modPreferences.prefLastPuzzleLevel == 0)
              {
                modPreferences.prefGameCount += 1;
                modPreferences.savePreferences(GameModeActivity.this);
                com.magmamobile.game.BubbleBlast.App.running = false;
                paramAnonymousAdapterView = new Intent(GameModeActivity.this, GameActivity.class);
                StageGame.setGameMode(Enums.enumGameMode.puzzle, 1);
                GameModeActivity.this.startActivityForResult(paramAnonymousAdapterView, 1000);
                GoogleAnalytics.trackAndDispatch("Mode/" + Enums.enumGameMode.puzzle.toString() + "/Pack1/");
                this.val$alertDiag.dismiss();
              }
            }
            do
            {
              return;
              paramAnonymousAdapterView = new AlertDialog.Builder(GameModeActivity.this);
              paramAnonymousAdapterView.setCancelable(true);
              paramAnonymousAdapterView.setIcon(2130837518);
              paramAnonymousAdapterView.setTitle(GameModeActivity.this.getString(2131034176));
              paramAnonymousAdapterView.setPositiveButton(GameModeActivity.this.getString(2131034113), new DialogInterface.OnClickListener()
              {
                public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  modPreferences.prefGameCount += 1;
                  modPreferences.savePreferences(GameModeActivity.this);
                  com.magmamobile.game.BubbleBlast.App.running = false;
                  paramAnonymous2DialogInterface = new Intent(GameModeActivity.this, GameActivity.class);
                  StageGame.setGameMode(Enums.enumGameMode.puzzle, 1);
                  StageGame.setPuzzleGameResume(modPreferences.prefLastPuzzleLevel, modPreferences.prefLastPuzzleScore);
                  GameModeActivity.this.startActivityForResult(paramAnonymous2DialogInterface, 1000);
                  GoogleAnalytics.trackAndDispatch("Mode/" + Enums.enumGameMode.puzzle.toString() + "/Pack1/Resume");
                }
              });
              paramAnonymousAdapterView.setNegativeButton(GameModeActivity.this.getString(2131034177), new DialogInterface.OnClickListener()
              {
                public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  modPreferences.prefGameCount += 1;
                  modPreferences.savePreferences(GameModeActivity.this);
                  com.magmamobile.game.BubbleBlast.App.running = false;
                  paramAnonymous2DialogInterface = new Intent(GameModeActivity.this, GameActivity.class);
                  StageGame.setGameMode(Enums.enumGameMode.puzzle, 1);
                  GameModeActivity.this.startActivityForResult(paramAnonymous2DialogInterface, 1000);
                  GoogleAnalytics.trackAndDispatch("Mode/" + Enums.enumGameMode.puzzle.toString() + "/Pack1/Reset");
                }
              });
              paramAnonymousAdapterView.show();
              this.val$alertDiag.dismiss();
              return;
              if (paramAnonymousAdapterView.equals("2"))
              {
                if (!modPreferences.prefPuzzleLevel002Unlocked)
                {
                  Toast.makeText(GameModeActivity.this, GameModeActivity.this.getString(2131034194), 1).show();
                  return;
                }
                if (modPreferences.prefLastPuzzleLevel002 == 0)
                {
                  modPreferences.prefGameCount += 1;
                  modPreferences.savePreferences(GameModeActivity.this);
                  com.magmamobile.game.BubbleBlast.App.running = false;
                  paramAnonymousAdapterView = new Intent(GameModeActivity.this, GameActivity.class);
                  StageGame.setGameMode(Enums.enumGameMode.puzzle, 2);
                  GameModeActivity.this.startActivityForResult(paramAnonymousAdapterView, 1000);
                  GoogleAnalytics.trackAndDispatch("Mode/" + Enums.enumGameMode.puzzle.toString() + "/Pack2/");
                  this.val$alertDiag.dismiss();
                  return;
                }
                paramAnonymousAdapterView = new AlertDialog.Builder(GameModeActivity.this);
                paramAnonymousAdapterView.setCancelable(true);
                paramAnonymousAdapterView.setIcon(2130837518);
                paramAnonymousAdapterView.setTitle(GameModeActivity.this.getString(2131034176));
                paramAnonymousAdapterView.setPositiveButton(GameModeActivity.this.getString(2131034113), new DialogInterface.OnClickListener()
                {
                  public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    modPreferences.prefGameCount += 1;
                    modPreferences.savePreferences(GameModeActivity.this);
                    com.magmamobile.game.BubbleBlast.App.running = false;
                    paramAnonymous2DialogInterface = new Intent(GameModeActivity.this, GameActivity.class);
                    StageGame.setGameMode(Enums.enumGameMode.puzzle, 2);
                    StageGame.setPuzzleGameResume(modPreferences.prefLastPuzzleLevel002, modPreferences.prefLastPuzzleScore002);
                    GameModeActivity.this.startActivityForResult(paramAnonymous2DialogInterface, 1000);
                    GoogleAnalytics.trackAndDispatch("Mode/" + Enums.enumGameMode.puzzle.toString() + "/Pack2/Resume");
                  }
                });
                paramAnonymousAdapterView.setNegativeButton(GameModeActivity.this.getString(2131034177), new DialogInterface.OnClickListener()
                {
                  public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    modPreferences.prefGameCount += 1;
                    modPreferences.savePreferences(GameModeActivity.this);
                    com.magmamobile.game.BubbleBlast.App.running = false;
                    paramAnonymous2DialogInterface = new Intent(GameModeActivity.this, GameActivity.class);
                    StageGame.setGameMode(Enums.enumGameMode.puzzle, 2);
                    GameModeActivity.this.startActivityForResult(paramAnonymous2DialogInterface, 1000);
                    GoogleAnalytics.trackAndDispatch("Mode/" + Enums.enumGameMode.puzzle.toString() + "/Pack2/Reset");
                  }
                });
                paramAnonymousAdapterView.show();
                this.val$alertDiag.dismiss();
                return;
              }
              if (paramAnonymousAdapterView.equals("3"))
              {
                if (!modPreferences.prefPuzzleLevel003Unlocked)
                {
                  Toast.makeText(GameModeActivity.this, GameModeActivity.this.getString(2131034196), 1).show();
                  return;
                }
                if (modPreferences.prefLastPuzzleLevel003 == 0)
                {
                  modPreferences.prefGameCount += 1;
                  modPreferences.savePreferences(GameModeActivity.this);
                  com.magmamobile.game.BubbleBlast.App.running = false;
                  paramAnonymousAdapterView = new Intent(GameModeActivity.this, GameActivity.class);
                  StageGame.setGameMode(Enums.enumGameMode.puzzle, 3);
                  GameModeActivity.this.startActivityForResult(paramAnonymousAdapterView, 1000);
                  GoogleAnalytics.trackAndDispatch("Mode/" + Enums.enumGameMode.puzzle.toString() + "/Pack3/");
                  this.val$alertDiag.dismiss();
                  return;
                }
                paramAnonymousAdapterView = new AlertDialog.Builder(GameModeActivity.this);
                paramAnonymousAdapterView.setCancelable(true);
                paramAnonymousAdapterView.setIcon(2130837518);
                paramAnonymousAdapterView.setTitle(GameModeActivity.this.getString(2131034176));
                paramAnonymousAdapterView.setPositiveButton(GameModeActivity.this.getString(2131034113), new DialogInterface.OnClickListener()
                {
                  public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    modPreferences.prefGameCount += 1;
                    modPreferences.savePreferences(GameModeActivity.this);
                    com.magmamobile.game.BubbleBlast.App.running = false;
                    paramAnonymous2DialogInterface = new Intent(GameModeActivity.this, GameActivity.class);
                    StageGame.setGameMode(Enums.enumGameMode.puzzle, 3);
                    StageGame.setPuzzleGameResume(modPreferences.prefLastPuzzleLevel003, modPreferences.prefLastPuzzleScore003);
                    GameModeActivity.this.startActivityForResult(paramAnonymous2DialogInterface, 1000);
                    GoogleAnalytics.trackAndDispatch("Mode/" + Enums.enumGameMode.puzzle.toString() + "/Pack3/Resume");
                  }
                });
                paramAnonymousAdapterView.setNegativeButton(GameModeActivity.this.getString(2131034177), new DialogInterface.OnClickListener()
                {
                  public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    modPreferences.prefGameCount += 1;
                    modPreferences.savePreferences(GameModeActivity.this);
                    com.magmamobile.game.BubbleBlast.App.running = false;
                    paramAnonymous2DialogInterface = new Intent(GameModeActivity.this, GameActivity.class);
                    StageGame.setGameMode(Enums.enumGameMode.puzzle, 3);
                    GameModeActivity.this.startActivityForResult(paramAnonymous2DialogInterface, 1000);
                    GoogleAnalytics.trackAndDispatch("Mode/" + Enums.enumGameMode.puzzle.toString() + "/Pack3/Reset");
                  }
                });
                paramAnonymousAdapterView.show();
                this.val$alertDiag.dismiss();
                return;
              }
              if (paramAnonymousAdapterView.equals("4"))
              {
                if (!modPreferences.prefPuzzleLevel004Unlocked)
                {
                  Toast.makeText(GameModeActivity.this, GameModeActivity.this.getString(2131034198), 1).show();
                  return;
                }
                if (modPreferences.prefLastPuzzleLevel004 == 0)
                {
                  modPreferences.prefGameCount += 1;
                  modPreferences.savePreferences(GameModeActivity.this);
                  com.magmamobile.game.BubbleBlast.App.running = false;
                  paramAnonymousAdapterView = new Intent(GameModeActivity.this, GameActivity.class);
                  StageGame.setGameMode(Enums.enumGameMode.puzzle, 4);
                  GameModeActivity.this.startActivityForResult(paramAnonymousAdapterView, 1000);
                  GoogleAnalytics.trackAndDispatch("Mode/" + Enums.enumGameMode.puzzle.toString() + "/Pack4/");
                  this.val$alertDiag.dismiss();
                  return;
                }
                paramAnonymousAdapterView = new AlertDialog.Builder(GameModeActivity.this);
                paramAnonymousAdapterView.setCancelable(true);
                paramAnonymousAdapterView.setIcon(2130837518);
                paramAnonymousAdapterView.setTitle(GameModeActivity.this.getString(2131034176));
                paramAnonymousAdapterView.setPositiveButton(GameModeActivity.this.getString(2131034113), new DialogInterface.OnClickListener()
                {
                  public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    modPreferences.prefGameCount += 1;
                    modPreferences.savePreferences(GameModeActivity.this);
                    com.magmamobile.game.BubbleBlast.App.running = false;
                    paramAnonymous2DialogInterface = new Intent(GameModeActivity.this, GameActivity.class);
                    StageGame.setGameMode(Enums.enumGameMode.puzzle, 4);
                    StageGame.setPuzzleGameResume(modPreferences.prefLastPuzzleLevel004, modPreferences.prefLastPuzzleScore004);
                    GameModeActivity.this.startActivityForResult(paramAnonymous2DialogInterface, 1000);
                    GoogleAnalytics.trackAndDispatch("Mode/" + Enums.enumGameMode.puzzle.toString() + "/Pack4/Resume");
                  }
                });
                paramAnonymousAdapterView.setNegativeButton(GameModeActivity.this.getString(2131034177), new DialogInterface.OnClickListener()
                {
                  public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    modPreferences.prefGameCount += 1;
                    modPreferences.savePreferences(GameModeActivity.this);
                    com.magmamobile.game.BubbleBlast.App.running = false;
                    paramAnonymous2DialogInterface = new Intent(GameModeActivity.this, GameActivity.class);
                    StageGame.setGameMode(Enums.enumGameMode.puzzle, 4);
                    GameModeActivity.this.startActivityForResult(paramAnonymous2DialogInterface, 1000);
                    GoogleAnalytics.trackAndDispatch("Mode/" + Enums.enumGameMode.puzzle.toString() + "/Pack4/Reset");
                  }
                });
                paramAnonymousAdapterView.show();
                this.val$alertDiag.dismiss();
                return;
              }
              if (paramAnonymousAdapterView.equals("5"))
              {
                if (!modPreferences.prefPuzzleLevel005Unlocked)
                {
                  Toast.makeText(GameModeActivity.this, GameModeActivity.this.getString(2131034200), 1).show();
                  return;
                }
                if (modPreferences.prefLastPuzzleLevel005 == 0)
                {
                  modPreferences.prefGameCount += 1;
                  modPreferences.savePreferences(GameModeActivity.this);
                  com.magmamobile.game.BubbleBlast.App.running = false;
                  paramAnonymousAdapterView = new Intent(GameModeActivity.this, GameActivity.class);
                  StageGame.setGameMode(Enums.enumGameMode.puzzle, 5);
                  GameModeActivity.this.startActivityForResult(paramAnonymousAdapterView, 1000);
                  GoogleAnalytics.trackAndDispatch("Mode/" + Enums.enumGameMode.puzzle.toString() + "/Pack5/");
                  this.val$alertDiag.dismiss();
                  return;
                }
                paramAnonymousAdapterView = new AlertDialog.Builder(GameModeActivity.this);
                paramAnonymousAdapterView.setCancelable(true);
                paramAnonymousAdapterView.setIcon(2130837518);
                paramAnonymousAdapterView.setTitle(GameModeActivity.this.getString(2131034176));
                paramAnonymousAdapterView.setPositiveButton(GameModeActivity.this.getString(2131034113), new DialogInterface.OnClickListener()
                {
                  public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    modPreferences.prefGameCount += 1;
                    modPreferences.savePreferences(GameModeActivity.this);
                    com.magmamobile.game.BubbleBlast.App.running = false;
                    paramAnonymous2DialogInterface = new Intent(GameModeActivity.this, GameActivity.class);
                    StageGame.setGameMode(Enums.enumGameMode.puzzle, 5);
                    StageGame.setPuzzleGameResume(modPreferences.prefLastPuzzleLevel005, modPreferences.prefLastPuzzleScore005);
                    GameModeActivity.this.startActivityForResult(paramAnonymous2DialogInterface, 1000);
                    GoogleAnalytics.trackAndDispatch("Mode/" + Enums.enumGameMode.puzzle.toString() + "/Pack5/Resume");
                  }
                });
                paramAnonymousAdapterView.setNegativeButton(GameModeActivity.this.getString(2131034177), new DialogInterface.OnClickListener()
                {
                  public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    modPreferences.prefGameCount += 1;
                    modPreferences.savePreferences(GameModeActivity.this);
                    com.magmamobile.game.BubbleBlast.App.running = false;
                    paramAnonymous2DialogInterface = new Intent(GameModeActivity.this, GameActivity.class);
                    StageGame.setGameMode(Enums.enumGameMode.puzzle, 5);
                    GameModeActivity.this.startActivityForResult(paramAnonymous2DialogInterface, 1000);
                    GoogleAnalytics.trackAndDispatch("Mode/" + Enums.enumGameMode.puzzle.toString() + "/Pack5/Reset");
                  }
                });
                paramAnonymousAdapterView.show();
                this.val$alertDiag.dismiss();
                return;
              }
              if (paramAnonymousAdapterView.equals("6"))
              {
                if (!modPreferences.prefPuzzleLevel006Unlocked)
                {
                  Toast.makeText(GameModeActivity.this, GameModeActivity.this.getString(2131034202), 1).show();
                  return;
                }
                GameModeActivity.this.puzzleResumeOrNot(modPreferences.prefLastPuzzleLevel006, modPreferences.prefLastPuzzleScore006, 6, this.val$alertDiag);
                return;
              }
              if (paramAnonymousAdapterView.equals("7"))
              {
                if (!modPreferences.prefPuzzleLevel007Unlocked)
                {
                  Toast.makeText(GameModeActivity.this, GameModeActivity.this.getString(2131034204), 1).show();
                  return;
                }
                GameModeActivity.this.puzzleResumeOrNot(modPreferences.prefLastPuzzleLevel007, modPreferences.prefLastPuzzleScore007, 7, this.val$alertDiag);
                return;
              }
              if (paramAnonymousAdapterView.equals("8"))
              {
                if (!modPreferences.prefPuzzleLevel008Unlocked)
                {
                  Toast.makeText(GameModeActivity.this, GameModeActivity.this.getString(2131034206), 1).show();
                  return;
                }
                GameModeActivity.this.puzzleResumeOrNot(modPreferences.prefLastPuzzleLevel008, modPreferences.prefLastPuzzleScore008, 8, this.val$alertDiag);
                return;
              }
              if (paramAnonymousAdapterView.equals("9"))
              {
                if (!modPreferences.prefPuzzleLevel009Unlocked)
                {
                  Toast.makeText(GameModeActivity.this, GameModeActivity.this.getString(2131034208), 1).show();
                  return;
                }
                GameModeActivity.this.puzzleResumeOrNot(modPreferences.prefLastPuzzleLevel009, modPreferences.prefLastPuzzleScore009, 9, this.val$alertDiag);
                return;
              }
              if (paramAnonymousAdapterView.equals("10"))
              {
                if (!modPreferences.prefPuzzleLevel010Unlocked)
                {
                  Toast.makeText(GameModeActivity.this, GameModeActivity.this.getString(2131034210), 1).show();
                  return;
                }
                GameModeActivity.this.puzzleResumeOrNot(modPreferences.prefLastPuzzleLevel010, modPreferences.prefLastPuzzleScore010, 10, this.val$alertDiag);
                return;
              }
              if (paramAnonymousAdapterView.equals("11"))
              {
                if (!modPreferences.prefPuzzleLevel011Unlocked)
                {
                  Toast.makeText(GameModeActivity.this, GameModeActivity.this.getString(2131034212), 1).show();
                  return;
                }
                GameModeActivity.this.puzzleResumeOrNot(modPreferences.prefLastPuzzleLevel011, modPreferences.prefLastPuzzleScore011, 11, this.val$alertDiag);
                return;
              }
              if (paramAnonymousAdapterView.equals("12"))
              {
                if (!modPreferences.prefPuzzleLevel012Unlocked)
                {
                  Toast.makeText(GameModeActivity.this, GameModeActivity.this.getString(2131034214), 1).show();
                  return;
                }
                GameModeActivity.this.puzzleResumeOrNot(modPreferences.prefLastPuzzleLevel012, modPreferences.prefLastPuzzleScore012, 12, this.val$alertDiag);
                return;
              }
              if (paramAnonymousAdapterView.equals("13"))
              {
                if (!modPreferences.prefPuzzleLevel013Unlocked)
                {
                  Toast.makeText(GameModeActivity.this, GameModeActivity.this.getString(2131034216), 1).show();
                  return;
                }
                GameModeActivity.this.puzzleResumeOrNot(modPreferences.prefLastPuzzleLevel013, modPreferences.prefLastPuzzleScore013, 13, this.val$alertDiag);
                return;
              }
              if (paramAnonymousAdapterView.equals("14"))
              {
                if (!modPreferences.prefPuzzleLevel014Unlocked)
                {
                  Toast.makeText(GameModeActivity.this, GameModeActivity.this.getString(2131034218), 1).show();
                  return;
                }
                GameModeActivity.this.puzzleResumeOrNot(modPreferences.prefLastPuzzleLevel014, modPreferences.prefLastPuzzleScore014, 14, this.val$alertDiag);
                return;
              }
              if (paramAnonymousAdapterView.equals("15"))
              {
                if (!modPreferences.prefPuzzleLevel015Unlocked)
                {
                  Toast.makeText(GameModeActivity.this, GameModeActivity.this.getString(2131034220), 1).show();
                  return;
                }
                GameModeActivity.this.puzzleResumeOrNot(modPreferences.prefLastPuzzleLevel015, modPreferences.prefLastPuzzleScore015, 15, this.val$alertDiag);
                return;
              }
              if (paramAnonymousAdapterView.equals("16"))
              {
                if (!modPreferences.prefPuzzleLevel016Unlocked)
                {
                  Toast.makeText(GameModeActivity.this, GameModeActivity.this.getString(2131034222), 1).show();
                  return;
                }
                GameModeActivity.this.puzzleResumeOrNot(modPreferences.prefLastPuzzleLevel016, modPreferences.prefLastPuzzleScore016, 16, this.val$alertDiag);
                return;
              }
              if (paramAnonymousAdapterView.equals("17"))
              {
                if (!modPreferences.prefPuzzleLevel017Unlocked)
                {
                  Toast.makeText(GameModeActivity.this, GameModeActivity.this.getString(2131034224), 1).show();
                  return;
                }
                GameModeActivity.this.puzzleResumeOrNot(modPreferences.prefLastPuzzleLevel017, modPreferences.prefLastPuzzleScore017, 17, this.val$alertDiag);
                return;
              }
              if (paramAnonymousAdapterView.equals("18"))
              {
                if (!modPreferences.prefPuzzleLevel018Unlocked)
                {
                  Toast.makeText(GameModeActivity.this, GameModeActivity.this.getString(2131034226), 1).show();
                  return;
                }
                GameModeActivity.this.puzzleResumeOrNot(modPreferences.prefLastPuzzleLevel018, modPreferences.prefLastPuzzleScore018, 18, this.val$alertDiag);
                return;
              }
              if (paramAnonymousAdapterView.equals("19"))
              {
                if (!modPreferences.prefPuzzleLevel019Unlocked)
                {
                  Toast.makeText(GameModeActivity.this, GameModeActivity.this.getString(2131034228), 1).show();
                  return;
                }
                GameModeActivity.this.puzzleResumeOrNot(modPreferences.prefLastPuzzleLevel019, modPreferences.prefLastPuzzleScore019, 19, this.val$alertDiag);
                return;
              }
              if (paramAnonymousAdapterView.equals("20"))
              {
                if (!modPreferences.prefPuzzleLevel020Unlocked)
                {
                  Toast.makeText(GameModeActivity.this, GameModeActivity.this.getString(2131034230), 1).show();
                  return;
                }
                GameModeActivity.this.puzzleResumeOrNot(modPreferences.prefLastPuzzleLevel020, modPreferences.prefLastPuzzleScore020, 20, this.val$alertDiag);
                return;
              }
              if (paramAnonymousAdapterView.equals("21"))
              {
                if (!modPreferences.prefPuzzleLevel021Unlocked)
                {
                  Toast.makeText(GameModeActivity.this, GameModeActivity.this.getString(2131034232), 1).show();
                  return;
                }
                GameModeActivity.this.puzzleResumeOrNot(modPreferences.prefLastPuzzleLevel021, modPreferences.prefLastPuzzleScore021, 21, this.val$alertDiag);
                return;
              }
            } while (!paramAnonymousAdapterView.equals("22"));
            if (!modPreferences.prefPuzzleLevel022Unlocked)
            {
              Toast.makeText(GameModeActivity.this, GameModeActivity.this.getString(2131034247), 1).show();
              return;
            }
            GameModeActivity.this.puzzleResumeOrNot(modPreferences.prefLastPuzzleLevel022, modPreferences.prefLastPuzzleScore022, 22, this.val$alertDiag);
          }
        });
        return;
        localArrayList.add(new CustomItemList(getString(2131034193), BitmapFactory.decodeResource(getResources(), 2130837521), "2"));
        continue;
        localArrayList.add(new CustomItemList(getString(2131034195), BitmapFactory.decodeResource(getResources(), 2130837521), "3"));
        break label127;
        label957:
        localArrayList.add(new CustomItemList(getString(2131034197), BitmapFactory.decodeResource(getResources(), 2130837521), "4"));
        break label162;
        label990:
        localArrayList.add(new CustomItemList(getString(2131034199), BitmapFactory.decodeResource(getResources(), 2130837521), "5"));
        break label198;
        label1024:
        localArrayList.add(new CustomItemList(getString(2131034201), BitmapFactory.decodeResource(getResources(), 2130837521), "6"));
        break label235;
        label1059:
        localArrayList.add(new CustomItemList(getString(2131034203), BitmapFactory.decodeResource(getResources(), 2130837521), "7"));
        break label272;
        label1094:
        localArrayList.add(new CustomItemList(getString(2131034205), BitmapFactory.decodeResource(getResources(), 2130837521), "8"));
        break label309;
        label1129:
        localArrayList.add(new CustomItemList(getString(2131034207), BitmapFactory.decodeResource(getResources(), 2130837521), "9"));
        break label346;
        label1164:
        localArrayList.add(new CustomItemList(getString(2131034209), BitmapFactory.decodeResource(getResources(), 2130837521), "10"));
        break label383;
        label1199:
        localArrayList.add(new CustomItemList(getString(2131034211), BitmapFactory.decodeResource(getResources(), 2130837521), "11"));
        break label420;
        label1234:
        localArrayList.add(new CustomItemList(getString(2131034213), BitmapFactory.decodeResource(getResources(), 2130837521), "12"));
        break label457;
        label1269:
        localArrayList.add(new CustomItemList(getString(2131034215), BitmapFactory.decodeResource(getResources(), 2130837521), "13"));
        break label494;
        label1304:
        localArrayList.add(new CustomItemList(getString(2131034217), BitmapFactory.decodeResource(getResources(), 2130837521), "14"));
        break label531;
        label1339:
        localArrayList.add(new CustomItemList(getString(2131034219), BitmapFactory.decodeResource(getResources(), 2130837521), "15"));
        break label568;
        label1374:
        localArrayList.add(new CustomItemList(getString(2131034221), BitmapFactory.decodeResource(getResources(), 2130837521), "16"));
        break label605;
        label1409:
        localArrayList.add(new CustomItemList(getString(2131034223), BitmapFactory.decodeResource(getResources(), 2130837521), "17"));
        break label642;
        label1444:
        localArrayList.add(new CustomItemList(getString(2131034225), BitmapFactory.decodeResource(getResources(), 2130837521), "18"));
        break label679;
        label1479:
        localArrayList.add(new CustomItemList(getString(2131034227), BitmapFactory.decodeResource(getResources(), 2130837521), "19"));
        break label716;
        label1514:
        localArrayList.add(new CustomItemList(getString(2131034229), BitmapFactory.decodeResource(getResources(), 2130837521), "20"));
        break label753;
        label1549:
        localArrayList.add(new CustomItemList(getString(2131034231), BitmapFactory.decodeResource(getResources(), 2130837521), "21"));
        break label790;
        label1584:
        localArrayList.add(new CustomItemList(getString(2131034233), BitmapFactory.decodeResource(getResources(), 2130837521), "22"));
      }
      catch (IllegalStateException localIllegalStateException)
      {
        for (;;)
        {
          localIllegalStateException.printStackTrace();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public void puzzleHighscoreChoose()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    localBuilder.setTitle(getString(2131034191));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new CustomItemList(getString(2131034192), BitmapFactory.decodeResource(getResources(), 2130837529), "1"));
    localArrayList.add(new CustomItemList(getString(2131034193), BitmapFactory.decodeResource(getResources(), 2130837529), "2"));
    localArrayList.add(new CustomItemList(getString(2131034195), BitmapFactory.decodeResource(getResources(), 2130837529), "3"));
    localArrayList.add(new CustomItemList(getString(2131034197), BitmapFactory.decodeResource(getResources(), 2130837529), "4"));
    localArrayList.add(new CustomItemList(getString(2131034199), BitmapFactory.decodeResource(getResources(), 2130837529), "5"));
    localArrayList.add(new CustomItemList(getString(2131034201), BitmapFactory.decodeResource(getResources(), 2130837529), "6"));
    localArrayList.add(new CustomItemList(getString(2131034203), BitmapFactory.decodeResource(getResources(), 2130837529), "7"));
    localArrayList.add(new CustomItemList(getString(2131034205), BitmapFactory.decodeResource(getResources(), 2130837529), "8"));
    localArrayList.add(new CustomItemList(getString(2131034207), BitmapFactory.decodeResource(getResources(), 2130837529), "9"));
    localArrayList.add(new CustomItemList(getString(2131034209), BitmapFactory.decodeResource(getResources(), 2130837529), "10"));
    localArrayList.add(new CustomItemList(getString(2131034211), BitmapFactory.decodeResource(getResources(), 2130837529), "11"));
    localArrayList.add(new CustomItemList(getString(2131034213), BitmapFactory.decodeResource(getResources(), 2130837529), "12"));
    localArrayList.add(new CustomItemList(getString(2131034215), BitmapFactory.decodeResource(getResources(), 2130837529), "13"));
    localArrayList.add(new CustomItemList(getString(2131034217), BitmapFactory.decodeResource(getResources(), 2130837529), "14"));
    localArrayList.add(new CustomItemList(getString(2131034219), BitmapFactory.decodeResource(getResources(), 2130837529), "15"));
    localArrayList.add(new CustomItemList(getString(2131034221), BitmapFactory.decodeResource(getResources(), 2130837529), "16"));
    localArrayList.add(new CustomItemList(getString(2131034223), BitmapFactory.decodeResource(getResources(), 2130837529), "17"));
    localArrayList.add(new CustomItemList(getString(2131034225), BitmapFactory.decodeResource(getResources(), 2130837529), "18"));
    localArrayList.add(new CustomItemList(getString(2131034227), BitmapFactory.decodeResource(getResources(), 2130837529), "19"));
    localArrayList.add(new CustomItemList(getString(2131034229), BitmapFactory.decodeResource(getResources(), 2130837529), "20"));
    localArrayList.add(new CustomItemList(getString(2131034231), BitmapFactory.decodeResource(getResources(), 2130837529), "21"));
    localArrayList.add(new CustomItemList(getString(2131034233), BitmapFactory.decodeResource(getResources(), 2130837529), "22"));
    ListView localListView = new ListView(this);
    OptionsAdapter localOptionsAdapter = new OptionsAdapter(this);
    localOptionsAdapter.myDatas = localArrayList;
    try
    {
      localListView.setAdapter(localOptionsAdapter);
      localListView.setBackgroundColor(-1);
      localListView.setCacheColorHint(-1);
      localBuilder.setView(localListView);
      localListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          paramAnonymousAdapterView = ((CustomItemList)((Adapter)paramAnonymousAdapterView.getAdapter()).getItem(paramAnonymousInt)).tag;
          if (paramAnonymousAdapterView.equals("1"))
          {
            paramAnonymousAdapterView = new Intent(GameModeActivity.this, HighScoresActivity.class);
            paramAnonymousAdapterView.putExtra("mode", Enums.enumGameMode.puzzle.toString());
            paramAnonymousAdapterView.putExtra("levelpack", 1);
            GameModeActivity.this.startActivity(paramAnonymousAdapterView);
            GoogleAnalytics.trackAndDispatch("HighScores/" + Enums.enumGameMode.puzzle.toString() + "/Pack1");
            this.val$alertDiag.dismiss();
          }
          do
          {
            return;
            if (paramAnonymousAdapterView.equals("2"))
            {
              paramAnonymousAdapterView = new Intent(GameModeActivity.this, HighScoresActivity.class);
              paramAnonymousAdapterView.putExtra("mode", Enums.enumGameMode.puzzle.toString());
              paramAnonymousAdapterView.putExtra("levelpack", 2);
              GameModeActivity.this.startActivity(paramAnonymousAdapterView);
              GoogleAnalytics.trackAndDispatch("HighScores/" + Enums.enumGameMode.puzzle.toString() + "/Pack2");
              this.val$alertDiag.dismiss();
              return;
            }
            if (paramAnonymousAdapterView.equals("3"))
            {
              paramAnonymousAdapterView = new Intent(GameModeActivity.this, HighScoresActivity.class);
              paramAnonymousAdapterView.putExtra("mode", Enums.enumGameMode.puzzle.toString());
              paramAnonymousAdapterView.putExtra("levelpack", 3);
              GameModeActivity.this.startActivity(paramAnonymousAdapterView);
              GoogleAnalytics.trackAndDispatch("HighScores/" + Enums.enumGameMode.puzzle.toString() + "/Pack3");
              this.val$alertDiag.dismiss();
              return;
            }
            if (paramAnonymousAdapterView.equals("4"))
            {
              paramAnonymousAdapterView = new Intent(GameModeActivity.this, HighScoresActivity.class);
              paramAnonymousAdapterView.putExtra("mode", Enums.enumGameMode.puzzle.toString());
              paramAnonymousAdapterView.putExtra("levelpack", 4);
              GameModeActivity.this.startActivity(paramAnonymousAdapterView);
              GoogleAnalytics.trackAndDispatch("HighScores/" + Enums.enumGameMode.puzzle.toString() + "/Pack4");
              this.val$alertDiag.dismiss();
              return;
            }
            if (paramAnonymousAdapterView.equals("5"))
            {
              paramAnonymousAdapterView = new Intent(GameModeActivity.this, HighScoresActivity.class);
              paramAnonymousAdapterView.putExtra("mode", Enums.enumGameMode.puzzle.toString());
              paramAnonymousAdapterView.putExtra("levelpack", 5);
              GameModeActivity.this.startActivity(paramAnonymousAdapterView);
              GoogleAnalytics.trackAndDispatch("HighScores/" + Enums.enumGameMode.puzzle.toString() + "/Pack5");
              this.val$alertDiag.dismiss();
              return;
            }
            if (paramAnonymousAdapterView.equals("6"))
            {
              paramAnonymousAdapterView = new Intent(GameModeActivity.this, HighScoresActivity.class);
              paramAnonymousAdapterView.putExtra("mode", Enums.enumGameMode.puzzle.toString());
              paramAnonymousAdapterView.putExtra("levelpack", 6);
              GameModeActivity.this.startActivity(paramAnonymousAdapterView);
              GoogleAnalytics.trackAndDispatch("HighScores/" + Enums.enumGameMode.puzzle.toString() + "/Pack6");
              this.val$alertDiag.dismiss();
              return;
            }
            if (paramAnonymousAdapterView.equals("7"))
            {
              paramAnonymousAdapterView = new Intent(GameModeActivity.this, HighScoresActivity.class);
              paramAnonymousAdapterView.putExtra("mode", Enums.enumGameMode.puzzle.toString());
              paramAnonymousAdapterView.putExtra("levelpack", 7);
              GameModeActivity.this.startActivity(paramAnonymousAdapterView);
              GoogleAnalytics.trackAndDispatch("HighScores/" + Enums.enumGameMode.puzzle.toString() + "/Pack7");
              this.val$alertDiag.dismiss();
              return;
            }
            if (paramAnonymousAdapterView.equals("8"))
            {
              paramAnonymousAdapterView = new Intent(GameModeActivity.this, HighScoresActivity.class);
              paramAnonymousAdapterView.putExtra("mode", Enums.enumGameMode.puzzle.toString());
              paramAnonymousAdapterView.putExtra("levelpack", 8);
              GameModeActivity.this.startActivity(paramAnonymousAdapterView);
              GoogleAnalytics.trackAndDispatch("HighScores/" + Enums.enumGameMode.puzzle.toString() + "/Pack8");
              this.val$alertDiag.dismiss();
              return;
            }
            if (paramAnonymousAdapterView.equals("9"))
            {
              paramAnonymousAdapterView = new Intent(GameModeActivity.this, HighScoresActivity.class);
              paramAnonymousAdapterView.putExtra("mode", Enums.enumGameMode.puzzle.toString());
              paramAnonymousAdapterView.putExtra("levelpack", 9);
              GameModeActivity.this.startActivity(paramAnonymousAdapterView);
              GoogleAnalytics.trackAndDispatch("HighScores/" + Enums.enumGameMode.puzzle.toString() + "/Pack9");
              this.val$alertDiag.dismiss();
              return;
            }
            if (paramAnonymousAdapterView.equals("10"))
            {
              paramAnonymousAdapterView = new Intent(GameModeActivity.this, HighScoresActivity.class);
              paramAnonymousAdapterView.putExtra("mode", Enums.enumGameMode.puzzle.toString());
              paramAnonymousAdapterView.putExtra("levelpack", 10);
              GameModeActivity.this.startActivity(paramAnonymousAdapterView);
              GoogleAnalytics.trackAndDispatch("HighScores/" + Enums.enumGameMode.puzzle.toString() + "/Pack10");
              this.val$alertDiag.dismiss();
              return;
            }
            if (paramAnonymousAdapterView.equals("11"))
            {
              paramAnonymousAdapterView = new Intent(GameModeActivity.this, HighScoresActivity.class);
              paramAnonymousAdapterView.putExtra("mode", Enums.enumGameMode.puzzle.toString());
              paramAnonymousAdapterView.putExtra("levelpack", 11);
              GameModeActivity.this.startActivity(paramAnonymousAdapterView);
              GoogleAnalytics.trackAndDispatch("HighScores/" + Enums.enumGameMode.puzzle.toString() + "/Pack11");
              this.val$alertDiag.dismiss();
              return;
            }
            if (paramAnonymousAdapterView.equals("12"))
            {
              paramAnonymousAdapterView = new Intent(GameModeActivity.this, HighScoresActivity.class);
              paramAnonymousAdapterView.putExtra("mode", Enums.enumGameMode.puzzle.toString());
              paramAnonymousAdapterView.putExtra("levelpack", 12);
              GameModeActivity.this.startActivity(paramAnonymousAdapterView);
              GoogleAnalytics.trackAndDispatch("HighScores/" + Enums.enumGameMode.puzzle.toString() + "/Pack12");
              this.val$alertDiag.dismiss();
              return;
            }
            if (paramAnonymousAdapterView.equals("13"))
            {
              paramAnonymousAdapterView = new Intent(GameModeActivity.this, HighScoresActivity.class);
              paramAnonymousAdapterView.putExtra("mode", Enums.enumGameMode.puzzle.toString());
              paramAnonymousAdapterView.putExtra("levelpack", 13);
              GameModeActivity.this.startActivity(paramAnonymousAdapterView);
              GoogleAnalytics.trackAndDispatch("HighScores/" + Enums.enumGameMode.puzzle.toString() + "/Pack13");
              this.val$alertDiag.dismiss();
              return;
            }
            if (paramAnonymousAdapterView.equals("14"))
            {
              paramAnonymousAdapterView = new Intent(GameModeActivity.this, HighScoresActivity.class);
              paramAnonymousAdapterView.putExtra("mode", Enums.enumGameMode.puzzle.toString());
              paramAnonymousAdapterView.putExtra("levelpack", 14);
              GameModeActivity.this.startActivity(paramAnonymousAdapterView);
              GoogleAnalytics.trackAndDispatch("HighScores/" + Enums.enumGameMode.puzzle.toString() + "/Pack14");
              this.val$alertDiag.dismiss();
              return;
            }
            if (paramAnonymousAdapterView.equals("15"))
            {
              paramAnonymousAdapterView = new Intent(GameModeActivity.this, HighScoresActivity.class);
              paramAnonymousAdapterView.putExtra("mode", Enums.enumGameMode.puzzle.toString());
              paramAnonymousAdapterView.putExtra("levelpack", 15);
              GameModeActivity.this.startActivity(paramAnonymousAdapterView);
              GoogleAnalytics.trackAndDispatch("HighScores/" + Enums.enumGameMode.puzzle.toString() + "/Pack15");
              this.val$alertDiag.dismiss();
              return;
            }
            if (paramAnonymousAdapterView.equals("16"))
            {
              paramAnonymousAdapterView = new Intent(GameModeActivity.this, HighScoresActivity.class);
              paramAnonymousAdapterView.putExtra("mode", Enums.enumGameMode.puzzle.toString());
              paramAnonymousAdapterView.putExtra("levelpack", 16);
              GameModeActivity.this.startActivity(paramAnonymousAdapterView);
              GoogleAnalytics.trackAndDispatch("HighScores/" + Enums.enumGameMode.puzzle.toString() + "/Pack16");
              this.val$alertDiag.dismiss();
              return;
            }
            if (paramAnonymousAdapterView.equals("17"))
            {
              paramAnonymousAdapterView = new Intent(GameModeActivity.this, HighScoresActivity.class);
              paramAnonymousAdapterView.putExtra("mode", Enums.enumGameMode.puzzle.toString());
              paramAnonymousAdapterView.putExtra("levelpack", 17);
              GameModeActivity.this.startActivity(paramAnonymousAdapterView);
              GoogleAnalytics.trackAndDispatch("HighScores/" + Enums.enumGameMode.puzzle.toString() + "/Pack17");
              this.val$alertDiag.dismiss();
              return;
            }
            if (paramAnonymousAdapterView.equals("18"))
            {
              paramAnonymousAdapterView = new Intent(GameModeActivity.this, HighScoresActivity.class);
              paramAnonymousAdapterView.putExtra("mode", Enums.enumGameMode.puzzle.toString());
              paramAnonymousAdapterView.putExtra("levelpack", 18);
              GameModeActivity.this.startActivity(paramAnonymousAdapterView);
              GoogleAnalytics.trackAndDispatch("HighScores/" + Enums.enumGameMode.puzzle.toString() + "/Pack18");
              this.val$alertDiag.dismiss();
              return;
            }
            if (paramAnonymousAdapterView.equals("19"))
            {
              paramAnonymousAdapterView = new Intent(GameModeActivity.this, HighScoresActivity.class);
              paramAnonymousAdapterView.putExtra("mode", Enums.enumGameMode.puzzle.toString());
              paramAnonymousAdapterView.putExtra("levelpack", 19);
              GameModeActivity.this.startActivity(paramAnonymousAdapterView);
              GoogleAnalytics.trackAndDispatch("HighScores/" + Enums.enumGameMode.puzzle.toString() + "/Pack19");
              this.val$alertDiag.dismiss();
              return;
            }
            if (paramAnonymousAdapterView.equals("20"))
            {
              paramAnonymousAdapterView = new Intent(GameModeActivity.this, HighScoresActivity.class);
              paramAnonymousAdapterView.putExtra("mode", Enums.enumGameMode.puzzle.toString());
              paramAnonymousAdapterView.putExtra("levelpack", 20);
              GameModeActivity.this.startActivity(paramAnonymousAdapterView);
              GoogleAnalytics.trackAndDispatch("HighScores/" + Enums.enumGameMode.puzzle.toString() + "/Pack20");
              this.val$alertDiag.dismiss();
              return;
            }
            if (paramAnonymousAdapterView.equals("21"))
            {
              paramAnonymousAdapterView = new Intent(GameModeActivity.this, HighScoresActivity.class);
              paramAnonymousAdapterView.putExtra("mode", Enums.enumGameMode.puzzle.toString());
              paramAnonymousAdapterView.putExtra("levelpack", 21);
              GameModeActivity.this.startActivity(paramAnonymousAdapterView);
              GoogleAnalytics.trackAndDispatch("HighScores/" + Enums.enumGameMode.puzzle.toString() + "/Pack21");
              this.val$alertDiag.dismiss();
              return;
            }
          } while (!paramAnonymousAdapterView.equals("22"));
          paramAnonymousAdapterView = new Intent(GameModeActivity.this, HighScoresActivity.class);
          paramAnonymousAdapterView.putExtra("mode", Enums.enumGameMode.puzzle.toString());
          paramAnonymousAdapterView.putExtra("levelpack", 22);
          GameModeActivity.this.startActivity(paramAnonymousAdapterView);
          GoogleAnalytics.trackAndDispatch("HighScores/" + Enums.enumGameMode.puzzle.toString() + "/Pack22");
          this.val$alertDiag.dismiss();
        }
      });
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        localIllegalStateException.printStackTrace();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void puzzleResumeOrNot(final int paramInt1, final int paramInt2, final int paramInt3, AlertDialog paramAlertDialog)
  {
    if (paramInt1 == 0)
    {
      modPreferences.prefGameCount += 1;
      modPreferences.savePreferences(this);
      com.magmamobile.game.BubbleBlast.App.running = false;
      localObject = new Intent(this, GameActivity.class);
      StageGame.setGameMode(Enums.enumGameMode.puzzle, paramInt3);
      startActivityForResult((Intent)localObject, 1000);
      GoogleAnalytics.trackAndDispatch("Mode/" + Enums.enumGameMode.puzzle.toString() + "/Pack" + paramInt3 + "/");
      paramAlertDialog.dismiss();
      return;
    }
    Object localObject = new AlertDialog.Builder(this);
    ((AlertDialog.Builder)localObject).setCancelable(true);
    ((AlertDialog.Builder)localObject).setIcon(2130837518);
    ((AlertDialog.Builder)localObject).setTitle(getString(2131034176));
    ((AlertDialog.Builder)localObject).setPositiveButton(getString(2131034113), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        modPreferences.prefGameCount += 1;
        modPreferences.savePreferences(GameModeActivity.this);
        com.magmamobile.game.BubbleBlast.App.running = false;
        paramAnonymousDialogInterface = new Intent(GameModeActivity.this, GameActivity.class);
        StageGame.setGameMode(Enums.enumGameMode.puzzle, paramInt3);
        StageGame.setPuzzleGameResume(paramInt1, paramInt2);
        GameModeActivity.this.startActivityForResult(paramAnonymousDialogInterface, 1000);
        GoogleAnalytics.trackAndDispatch("Mode/" + Enums.enumGameMode.puzzle.toString() + "/Pack" + paramInt3 + "/Resume");
      }
    });
    ((AlertDialog.Builder)localObject).setNegativeButton(getString(2131034177), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        modPreferences.prefGameCount += 1;
        modPreferences.savePreferences(GameModeActivity.this);
        com.magmamobile.game.BubbleBlast.App.running = false;
        paramAnonymousDialogInterface = new Intent(GameModeActivity.this, GameActivity.class);
        StageGame.setGameMode(Enums.enumGameMode.puzzle, paramInt3);
        GameModeActivity.this.startActivityForResult(paramAnonymousDialogInterface, 1000);
        GoogleAnalytics.trackAndDispatch("Mode/" + Enums.enumGameMode.puzzle.toString() + "/Pack" + paramInt3 + "/Reset");
      }
    });
    ((AlertDialog.Builder)localObject).show();
    paramAlertDialog.dismiss();
  }
  
  public void setButtons()
  {
    ((Button)findViewById(2131099684)).setCompoundDrawablesWithIntrinsicBounds(2130837532, 0, 0, 0);
    ((Button)findViewById(2131099682)).setCompoundDrawablesWithIntrinsicBounds(2130837529, 0, 0, 0);
    ((Button)findViewById(2131099682)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        GameModeActivity.this.puzzleChoose();
      }
    });
    if (!modPreferences.prefArcadeUnlocked)
    {
      ((Button)findViewById(2131099683)).setCompoundDrawablesWithIntrinsicBounds(2130837521, 0, 0, 0);
      ((Button)findViewById(2131099683)).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          Toast.makeText(GameModeActivity.this, GameModeActivity.this.getString(2131034153), 1).show();
        }
      });
      return;
    }
    ((Button)findViewById(2131099683)).setCompoundDrawablesWithIntrinsicBounds(2130837520, 0, 0, 0);
    ((Button)findViewById(2131099683)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        com.magmamobile.game.BubbleBlast.App.running = false;
        paramAnonymousView = new Intent(GameModeActivity.this, GameActivity.class);
        StageGame.setGameMode(Enums.enumGameMode.arcade, 0);
        GameModeActivity.this.startActivityForResult(paramAnonymousView, 1000);
        GoogleAnalytics.trackAndDispatch("Mode/" + Enums.enumGameMode.arcade.toString() + "/");
      }
    });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/BubbleBlast/activities/GameModeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */