package logo.quiz.commons;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.text.TextPaint;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bluebird.mobile.tools.activities.ActivityAction;
import com.bubble.adserwer.HouseAd;
import com.bubble.bugsense.BugSense;
import com.bubble.play.services.PlayServicesActionHelper;
import com.chartboost.sdk.Chartboost;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import logo.quiz.commons.cloud.save.SameGameState;
import logo.quiz.commons.cloud.save.SaveGame;
import logo.quiz.commons.gesture.listener.LogoFormGestureListener;
import logo.quiz.commons.gesture.listener.LogoFormOnGestureDetector;
import logo.quiz.commons.image.loader.LogoImageLoaderListener;
import logo.quiz.commons.image.loader.PicassoOwnCache;
import logo.quiz.commons.popup.PopUp;
import logo.quiz.commons.popup.PopUp.Callback.EarnHintsCallback;
import logo.quiz.commons.utils.Animations;
import logo.quiz.commons.utils.Base64;
import logo.quiz.commons.utils.flowtextview.FlowTextView;
import logo.quiz.commons.utils.hints.HintsService;
import logo.quiz.commons.utils.hints.HintsServiceFactory;
import logo.quiz.commons.utils.menu.MenuService;
import logo.quiz.commons.utils.score.ScoreService;

public abstract class FormOldActivityCommons
  extends LogoQuizAbstractActivity
{
  private AdView adViewReadMore;
  boolean complete = false;
  private Dialog dialog = null;
  private GestureDetector gestureDetector;
  char[] hintChars = null;
  private boolean isCompleteLogo = false;
  boolean isZoomBlocked = true;
  private int logoSize;
  protected String logosListActivityName = "LogosListActivity";
  Activity myActivity;
  BrandTO nextBrandTO = null;
  protected PlayServicesActionHelper playServicesActionHelper;
  BrandTO prevBrandTO = null;
  private Dialog readMoreDialog = null;
  private Button tapjoyOfferButton = null;
  protected int[] winnerColors;
  
  private int availibleHints(List<Hint> paramList)
  {
    int i = 0;
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (!((Hint)paramList.next()).isUsed()) {
        i += 1;
      }
    }
    return i;
  }
  
  private void closeHint()
  {
    View localView = findViewById(R.id.hint_body_container);
    if ((localView != null) && (localView.getVisibility() == 0))
    {
      localView.setVisibility(8);
      localView.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.exit_anim_slide_down));
    }
  }
  
  private void correctSound()
  {
    if (PreferenceManager.getDefaultSharedPreferences(this).getBoolean("SOUND", true)) {
      DeviceUtilCommons.playSound(getApplicationContext(), R.raw.correct);
    }
  }
  
  private void disableButton(Button paramButton) {}
  
  private boolean hasEnoughHints(int paramInt)
  {
    boolean bool = true;
    if (PreferenceManager.getDefaultSharedPreferences(this).getInt("allHints", 0) < paramInt)
    {
      bool = false;
      new AlertDialog.Builder(this).setIcon(17301619).setTitle(getString(R.string.form_running_out_of_hints)).setMessage(getString(R.string.form_visit_out_store)).setNegativeButton(17039360, null).setPositiveButton(17039370, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          FormOldActivityCommons.this.getFreeHints(null);
        }
      }).show();
    }
    return bool;
  }
  
  private void initHintsImages()
  {
    int i = 0;
    while (i < 5)
    {
      Hint localHint = HintsUtil.getHintById(i + 1, (BrandTO)getIntent().getSerializableExtra("brandTO"), getScoreUtilProvider().getGameModeName(), getApplicationContext());
      if (localHint.isUsed()) {
        ((ImageView)findViewById(localHint.getImageViewId())).setImageResource(localHint.getDrawableOff());
      }
      i += 1;
    }
  }
  
  private void nextPrevBrands()
  {
    this.prevBrandTO = null;
    this.nextBrandTO = null;
    Integer localInteger = (Integer)getIntent().getExtras().get("position");
    BrandTO[] arrayOfBrandTO = getScoreUtilProvider().getBrands(getApplicationContext(), LevelUtil.getActiveLevel());
    if (arrayOfBrandTO.length > localInteger.intValue() + 1) {}
    try
    {
      this.nextBrandTO = arrayOfBrandTO[(localInteger.intValue() + 1)];
      if (localInteger.intValue() > 0) {}
      try
      {
        this.prevBrandTO = arrayOfBrandTO[(localInteger.intValue() - 1)];
        return;
      }
      catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException1) {}
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException2)
    {
      for (;;) {}
    }
  }
  
  private void rotateView(View paramView)
  {
    paramView.startAnimation(AnimationUtils.loadAnimation(this, R.anim.rotation));
  }
  
  private void shakeView(View paramView)
  {
    paramView.startAnimation(AnimationUtils.loadAnimation(this, R.anim.shake));
  }
  
  private void showClue(Hint paramHint)
  {
    if (findViewById(R.id.hintClue) == null) {
      ((ViewStub)findViewById(R.id.hintClueStub)).inflate();
    }
    findViewById(R.id.hint_clue_body).setVisibility(0);
    findViewById(R.id.hint_clue_body_plates).setVisibility(8);
    ((TextView)findViewById(R.id.hint_clue_body)).setText(paramHint.getHint());
    ((TextView)findViewById(R.id.hint_header)).setText(getString(R.string.form_clue_sentense));
    showHint();
  }
  
  private void showClueWithCheck(final Hint paramHint)
  {
    if (findViewById(R.id.hint_body_container) == null) {
      ((ViewStub)findViewById(R.id.hint_body_container_stub)).inflate();
    }
    Object localObject = (BrandTO)getIntent().getSerializableExtra("brandTO");
    if ((this.isCompleteLogo) || (paramHint.isUsed()) || (((BrandTO)localObject).isComplete())) {
      showClue(paramHint);
    }
    while (!hasEnoughHints(paramHint.getOldHintCost())) {
      return;
    }
    localObject = getString(R.string.hint_show_clue1, new Object[] { Integer.valueOf(paramHint.getOldHintCost()) });
    if (paramHint.getId() == 2) {
      localObject = getString(R.string.hint_show_clue2, new Object[] { Integer.valueOf(paramHint.getOldHintCost()) });
    }
    new AlertDialog.Builder(this).setIcon(17301516).setMessage((CharSequence)localObject).setNegativeButton(17039360, null).setPositiveButton(17039370, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        FormOldActivityCommons.this.useHint(paramHint);
        FormOldActivityCommons.this.showClue(paramHint);
      }
    }).show();
  }
  
  private void showFbTwitterWithCheck()
  {
    final Object localObject1 = (BrandTO)getIntent().getSerializableExtra("brandTO");
    final String str7 = getResources().getString(R.string.facebookAppId);
    final String str8 = getResources().getString(R.string.app_name).replace(' ', '+');
    String str6 = getResources().getString(R.string.app_type);
    localObject3 = getResources().getString(R.string.app_url);
    final Object localObject2 = "";
    String str2 = "";
    String str4 = "";
    str5 = "";
    String str9 = new String(Base64.encode(Base64.encodeToString(((BrandTO)localObject1).getImgName().getBytes(), 0).replaceAll("\n", "").getBytes(), 0)).replaceAll("=", "").replaceAll("\n", "");
    final String str1 = str2;
    localObject1 = str4;
    try
    {
      String str3 = URLEncoder.encode("http://logos-quiz.com/index.php?logo=" + str9 + "&type=" + str6, "UTF-8");
      str1 = str2;
      localObject1 = str4;
      localObject2 = str3;
      str2 = URLEncoder.encode(URLEncoder.encode("http://logos-quiz.com/index.php?logo=" + str9 + "&type=" + str6, "UTF-8"));
      str1 = str2;
      localObject1 = str4;
      localObject2 = str3;
      str4 = URLEncoder.encode((String)localObject3, "UTF-8");
      str1 = str2;
      localObject1 = str4;
      localObject2 = str3;
      StringBuilder localStringBuilder = new StringBuilder().append("http://logos-quiz.com/img/");
      localObject3 = str6;
      str1 = str2;
      localObject1 = str4;
      localObject2 = str3;
      if (str6.equals("logo-quiz-ultimate")) {
        localObject3 = "logo-quiz";
      }
      str1 = str2;
      localObject1 = str4;
      localObject2 = str3;
      localObject3 = URLEncoder.encode((String)localObject3 + "/" + str9 + ".png", "UTF-8");
      localObject2 = str3;
      localObject1 = str4;
      str1 = str2;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
        localObject3 = str5;
      }
    }
    new AlertDialog.Builder(this).setIcon(17301516).setMessage(getString(R.string.form_ask_friends)).setNeutralButton("Facebook", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface = new Intent("android.intent.action.VIEW", Uri.parse("https://m.facebook.com/dialog/feed?app_id=" + str7 + "&" + "link=" + localObject2 + "&" + "picture=" + localObject3 + "&" + "name=" + FormOldActivityCommons.this.getString(R.string.form_who_knows_this_logo).replaceAll(" ", "+") + "+%3F&caption=" + FormOldActivityCommons.this.getString(R.string.form_enjoy_game, new Object[] { str8 }).replaceAll(" ", "+") + "%21&" + "description=" + localObject1 + "&" + "redirect_uri=http%3A%2F%2Fwww.facebook.com"));
        paramAnonymousDialogInterface.addFlags(1073741824);
        paramAnonymousDialogInterface.addFlags(268435456);
        FormOldActivityCommons.this.startActivity(paramAnonymousDialogInterface);
      }
    }).setNegativeButton(17039360, null).setPositiveButton("Twitter", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface = new Intent("android.intent.action.VIEW", Uri.parse("https://twitter.com/intent/session?return_to=%2Fintent%2Ftweet%3Fbutton_hashtag%3Dlogoquiz%26text%3D" + FormOldActivityCommons.this.getString(R.string.form_who_knows_this_logo).replaceAll(" ", "%2520") + "%253F%2520" + str1 + "&" + "text=" + FormOldActivityCommons.this.getString(R.string.form_who_knows_this_logo).replaceAll(" ", "+") + "%3F+" + localObject2));
        paramAnonymousDialogInterface.addFlags(1073741824);
        paramAnonymousDialogInterface.addFlags(268435456);
        FormOldActivityCommons.this.startActivity(paramAnonymousDialogInterface);
      }
    }).show();
  }
  
  private void showFullAnswer(Hint paramHint)
  {
    closeHint();
    ((EditText)findViewById(R.id.editTextLogo)).setText(paramHint.getHint());
    ((Button)findViewById(R.id.buttonCheck)).performClick();
  }
  
  private void showHint()
  {
    if (findViewById(R.id.hint_body_container) == null) {
      ((ViewStub)findViewById(R.id.hint_body_container_stub)).inflate();
    }
    View localView = findViewById(R.id.hint_body_container);
    if (localView.getVisibility() == 8)
    {
      localView.setVisibility(0);
      localView.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.enter_anim_slide_up));
    }
  }
  
  private void showOnlyUsedLetters(Hint paramHint)
  {
    if (findViewById(R.id.hintClue) == null) {
      ((ViewStub)findViewById(R.id.hintClueStub)).inflate();
    }
    LinearLayout localLinearLayout = (LinearLayout)findViewById(R.id.hint_clue_body_plates);
    localLinearLayout.setVisibility(0);
    findViewById(R.id.hint_clue_body).setVisibility(8);
    ((TextView)findViewById(R.id.hint_header)).setText("Used letters");
    localLinearLayout.removeAllViews();
    Object localObject = new LinearLayout(getApplicationContext());
    int k = 0;
    int n = 1;
    if (this.hintChars == null) {
      this.hintChars = StringUtils.removeWhiteSpaces(paramHint.getHint()).toUpperCase().toCharArray();
    }
    char[] arrayOfChar = this.hintChars;
    int i1 = arrayOfChar.length;
    int m = 0;
    paramHint = (Hint)localObject;
    if (m < i1)
    {
      char c = arrayOfChar[m];
      int j = k;
      int i = n;
      if (k % 4 == 0)
      {
        paramHint = new LinearLayout(getApplicationContext());
        paramHint.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        paramHint.setGravity(1);
        paramHint.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            FormOldActivityCommons.this.toggleHint(null);
          }
        });
        localLinearLayout.addView(paramHint);
        if (n != 0)
        {
          i = 0;
          j = 1;
        }
      }
      else
      {
        label221:
        localObject = new Button(getApplicationContext());
        ((Button)localObject).setTextColor(Color.parseColor("#cc000000"));
        ((Button)localObject).setTypeface(null, 1);
        if (j % 2 != 0) {
          break label325;
        }
      }
      label325:
      for (k = R.drawable.plate_used_letters_right;; k = R.drawable.plate_used_letters_left)
      {
        ((Button)localObject).setBackgroundResource(k);
        ((Button)localObject).setText(String.valueOf(c));
        ((Button)localObject).setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            FormOldActivityCommons.this.toggleHint(null);
          }
        });
        paramHint.addView((View)localObject);
        k = j + 1;
        m += 1;
        n = i;
        break;
        i = 1;
        j = 0;
        break label221;
      }
    }
    showHint();
  }
  
  private void showSomeLettersInOrder(Hint paramHint)
  {
    if (findViewById(R.id.hintClue) == null) {
      ((ViewStub)findViewById(R.id.hintClueStub)).inflate();
    }
    LinearLayout localLinearLayout = (LinearLayout)findViewById(R.id.hint_clue_body_plates);
    localLinearLayout.setVisibility(0);
    findViewById(R.id.hint_clue_body).setVisibility(8);
    ((TextView)findViewById(R.id.hint_header)).setText("Letters in order");
    localLinearLayout.removeAllViews();
    String[] arrayOfString = paramHint.getHint().split(" ");
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    int m = arrayOfString.length;
    int i = 0;
    while (i < m)
    {
      String str = arrayOfString[i];
      paramHint = new LinearLayout(getApplicationContext());
      paramHint.setLayoutParams(localLayoutParams);
      paramHint.setGravity(1);
      paramHint.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          FormOldActivityCommons.this.toggleHint(null);
        }
      });
      int k = 0;
      char[] arrayOfChar = str.toUpperCase().toCharArray();
      int n = arrayOfChar.length;
      int j = 0;
      while (j < n)
      {
        char c = arrayOfChar[j];
        Object localObject;
        if (k != 0)
        {
          localObject = paramHint;
          if (k % 6 == 0)
          {
            localObject = paramHint;
            if (str.length() == k + 1) {}
          }
        }
        else
        {
          if (k > 0)
          {
            localObject = new ImageView(getApplicationContext());
            ((ImageView)localObject).setImageResource(R.drawable.plate_sep);
            paramHint.addView((View)localObject);
          }
          localObject = new LinearLayout(getApplicationContext());
          ((LinearLayout)localObject).setLayoutParams(localLayoutParams);
          ((LinearLayout)localObject).setGravity(1);
          ((LinearLayout)localObject).setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymousView)
            {
              FormOldActivityCommons.this.toggleHint(null);
            }
          });
          localLinearLayout.addView((View)localObject);
        }
        paramHint = new Button(getApplicationContext());
        paramHint.setTextColor(Color.parseColor("#cc000000"));
        paramHint.setTypeface(null, 1);
        paramHint.setBackgroundResource(R.drawable.plate);
        paramHint.setText(String.valueOf(c));
        paramHint.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            FormOldActivityCommons.this.toggleHint(null);
          }
        });
        ((LinearLayout)localObject).addView(paramHint);
        k += 1;
        j += 1;
        paramHint = (Hint)localObject;
      }
      i += 1;
    }
    showHint();
  }
  
  private void useHint(Hint paramHint)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    localEditor.putInt("allHints", localSharedPreferences.getInt("allHints", 0) - paramHint.getOldHintCost());
    localEditor.putBoolean("isUsedHint" + paramHint.getId() + "Brand" + paramHint.getBrandId() + getScoreUtilProvider().getGameModeName(), true);
    localEditor.commit();
    HintsUtil.addUsedHints(paramHint.getOldHintCost(), getApplicationContext());
    ((ImageView)findViewById(paramHint.getImageViewId())).setImageResource(paramHint.getDrawableOff());
    getMenuService().refreshScore(this);
  }
  
  private int usedHints(List<Hint> paramList)
  {
    int i = 0;
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((Hint)paramList.next()).isUsed()) {
        i += 1;
      }
    }
    return i;
  }
  
  private void vibrateNegative()
  {
    if (PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getBoolean("VIBRATE", true)) {
      ((Vibrator)getSystemService("vibrator")).vibrate(new long[] { 0L, 150L, 100L, 150L }, -1);
    }
  }
  
  private void vibratePositive()
  {
    if (PreferenceManager.getDefaultSharedPreferences(this).getBoolean("VIBRATE", true)) {
      ((Vibrator)getSystemService("vibrator")).vibrate(500L);
    }
  }
  
  private void wrongSound()
  {
    if (PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getBoolean("SOUND", true)) {
      DeviceUtilCommons.playSound(getApplicationContext(), R.raw.wrong);
    }
  }
  
  protected void animateWinner(BrandTO paramBrandTO)
  {
    Animations.animateZoomInAlpha(R.id.editWinLogo, 0, this);
    findViewById(R.id.adContainer).setBackgroundResource(R.drawable.bg_winner_repeat);
    Animations.animateZoomInAlpha(R.id.adContainer, 0, this);
    Animations.animateZoomIn(R.id.gratulationsHeader, 0, this);
    Animations.animateZoomIn(R.id.completeLogoName, 0, this);
    if (!DeviceUtilCommons.isSmallScreen(getApplicationContext())) {
      Animations.animateZoomIn(R.id.scoreId, 250, this);
    }
    Animations.animateZoomIn(R.id.closeButtonId, 500, this);
    if (this.nextBrandTO != null) {
      Animations.animateZoomIn(R.id.nextButtonId, 500, this);
    }
    if (this.prevBrandTO != null) {
      Animations.animateZoomIn(R.id.prevButtonId, 500, this);
    }
    Animations.animateZoomIn(R.id.short_read_more, 800, this);
  }
  
  public void back(View paramView)
  {
    paramView = new Intent(getApplicationContext(), DeviceUtilCommons.getClassByName(getApplicationContext(), "LogosListActivity"));
    paramView.setFlags(603979776);
    startActivity(paramView);
    finish();
  }
  
  public void ckeck(View paramView)
  {
    ckeck();
  }
  
  public boolean ckeck()
  {
    boolean bool3 = false;
    boolean bool2 = false;
    Object localObject1 = (EditText)findViewById(R.id.editTextLogo);
    boolean bool1 = bool3;
    String[] arrayOfString;
    SharedPreferences.Editor localEditor;
    Integer localInteger;
    if (localObject1 != null)
    {
      bool1 = bool3;
      if (((EditText)localObject1).getText() != null)
      {
        localObject1 = ((EditText)localObject1).getText().toString().toLowerCase().trim();
        arrayOfString = (String[])getIntent().getExtras().get("brandNames");
        bool1 = StringUtils.isLogoNameCorrect((String)localObject1, arrayOfString);
        localObject2 = PreferenceManager.getDefaultSharedPreferences(this);
        localEditor = ((SharedPreferences)localObject2).edit();
        localInteger = (Integer)getIntent().getExtras().get("brandPosition");
        localEditor.putInt("guessTries", ((SharedPreferences)localObject2).getInt("guessTries", 0) + 1);
        i = ((SharedPreferences)localObject2).getInt("perfectGuessBrand" + localInteger + getScoreUtilProvider().getGameModeName(), 0);
        if (!bool1) {
          break label224;
        }
        bool1 = true;
        correctAnswer((SharedPreferences)localObject2, localEditor, localInteger, i);
        localEditor.commit();
        getMenuService().refreshScore(this);
      }
    }
    return bool1;
    label224:
    if (i == 0) {
      localEditor.putInt("perfectGuessBrand" + localInteger + getScoreUtilProvider().getGameModeName(), -1);
    }
    Object localObject2 = arrayOfString[0].toLowerCase();
    int j = 0;
    int i = 0;
    while (i < ((String)localObject2).length())
    {
      int k = j;
      if (i < ((String)localObject1).length())
      {
        k = j;
        if (((String)localObject2).charAt(i) == ((String)localObject1).toLowerCase().charAt(i)) {
          k = j + 1;
        }
      }
      i += 1;
      j = k;
    }
    if (StringUtils.isAlmostGood((String)localObject1, arrayOfString)) {
      DeviceUtilCommons.showShortToast(getString(R.string.form_almost_good), getApplicationContext());
    }
    for (;;)
    {
      wrongSound();
      vibrateNegative();
      shakeView((ImageView)findViewById(R.id.imageBrand));
      bool1 = bool2;
      break;
      DeviceUtilCommons.showShortToast(getString(R.string.form_wrong_answer), getApplicationContext());
    }
  }
  
  public void close(View paramView)
  {
    paramView = new Intent(getApplicationContext(), DeviceUtilCommons.getClassByName(getApplicationContext(), getLogosListActivityName()));
    paramView.setFlags(603979776);
    startActivity(paramView);
    finish();
  }
  
  protected void correctAnswer(SharedPreferences paramSharedPreferences, SharedPreferences.Editor paramEditor, Integer paramInteger, int paramInt)
  {
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(((TextView)findViewById(R.id.editTextLogo)).getWindowToken(), 0);
    Object localObject = findViewById(R.id.hint_body_container);
    if ((localObject != null) && (((View)localObject).getVisibility() == 0)) {
      closeHint();
    }
    localObject = (ViewGroup)findViewById(R.id.centerPartContainer);
    ((ViewGroup)localObject).removeAllViews();
    getLayoutInflater().inflate(R.layout.logos_form_old_read_more, (ViewGroup)localObject, true);
    if (paramInt == 0)
    {
      paramEditor.putInt("perfectGuessBrand" + paramInteger + getScoreUtilProvider().getGameModeName(), 1);
      paramEditor.putInt("perfectGuess", paramSharedPreferences.getInt("perfectGuess", 0) + 1);
    }
    for (;;)
    {
      correctSound();
      vibratePositive();
      ((TextView)findViewById(R.id.menuInfo)).setText("");
      localObject = (Integer)getIntent().getExtras().get("position");
      paramInt = LevelUtil.getActiveLevel();
      paramInteger = getScoreUtilProvider().getBrands(getApplicationContext(), paramInt);
      try
      {
        paramInteger = paramInteger[localObject.intValue()];
        paramInteger.setComplete(true);
        getIntent().putExtra("brandTO", paramInteger);
        getScoreService().setComplete(paramInteger.getBrandPosition(), paramInteger.getLevel(getApplicationContext()), this);
        paramEditor.putInt("complete_position", ((Integer)localObject).intValue());
        paramEditor.commit();
        this.complete = true;
        if (findViewById(R.id.editWinLogo) == null) {
          ((ViewStub)findViewById(R.id.winnerViewStub)).inflate();
        }
        animateWinner(paramInteger);
        showWinnerScreen(paramInteger, true);
        paramInteger = findViewById(R.id.leftHints);
        localObject = findViewById(R.id.rightHints);
        paramInteger.setVisibility(8);
        ((View)localObject).setVisibility(8);
        paramInt = paramSharedPreferences.getInt("allHints", 0);
        boolean bool = isLevelUnlocked();
        int i = getScoreService().getCompletedLogosCount(this.myActivity.getApplicationContext());
        if ((!bool) && (i % 3 == 0))
        {
          DeviceUtilCommons.showLongToast(getString(R.string.adserwer_nice_get_new_hint), getApplicationContext());
          paramEditor.putInt("allHints", paramInt + 1);
          paramEditor.commit();
        }
        this.isCompleteLogo = true;
        saveGameStateToCloud();
        return;
        paramEditor.putInt("perfectGuessBrand" + paramInteger + getScoreUtilProvider().getGameModeName(), 2);
      }
      catch (Exception paramInteger)
      {
        for (;;)
        {
          paramInteger = (BrandTO)getIntent().getSerializableExtra("brandTO");
        }
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    this.gestureDetector.onTouchEvent(paramMotionEvent);
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected abstract int getAvailibleHintsCount(Activity paramActivity);
  
  protected abstract ConstantsProvider getConstants();
  
  public void getFreeHints(View paramView)
  {
    try
    {
      paramView = new Intent(getApplicationContext(), DeviceUtilCommons.getClassByName(getApplicationContext(), "GetHintsActivity"));
      paramView.setFlags(872415232);
      startActivity(paramView);
      return;
    }
    catch (ClassNotFoundRuntimeException paramView)
    {
      for (;;)
      {
        paramView = new Intent(getApplicationContext(), DeviceUtilCommons.getClassByName(getApplicationContext(), "FreeHintsActivity"));
      }
    }
  }
  
  protected int[] getGratulationsColors()
  {
    return new int[] { -1338738176, -1330249728, -1342151754, -2135555929, -472809472, -1334210816, -1340713773, -4277248, -1342137751, -1331167133, -1337130836, -1333118464 };
  }
  
  public String getLogosListActivityName()
  {
    return this.logosListActivityName;
  }
  
  protected SameGameState getSaveGame()
  {
    return new SaveGame(HintsServiceFactory.getInstance().getAvailibleHintsCount(getApplicationContext()), getScoreUtilProvider(), getScoreService(), getApplicationContext());
  }
  
  protected abstract ScoreUtilProvider getScoreUtilProvider();
  
  protected String getTapJoyPayPerActionCode()
  {
    return null;
  }
  
  public void hintClue1(View paramView)
  {
    showClueWithCheck(HintsUtil.getHintById(1, (BrandTO)getIntent().getSerializableExtra("brandTO"), getScoreUtilProvider().getGameModeName(), getApplicationContext()));
  }
  
  public void hintClue2(View paramView)
  {
    showClueWithCheck(HintsUtil.getHintById(2, (BrandTO)getIntent().getSerializableExtra("brandTO"), getScoreUtilProvider().getGameModeName(), getApplicationContext()));
  }
  
  public void hintFbTwitter(View paramView)
  {
    showFbTwitterWithCheck();
  }
  
  public void hintFullAnswer(final View paramView)
  {
    paramView = HintsUtil.getHintById(5, (BrandTO)getIntent().getSerializableExtra("brandTO"), getScoreUtilProvider().getGameModeName(), getApplicationContext());
    BrandTO localBrandTO = (BrandTO)getIntent().getSerializableExtra("brandTO");
    if ((this.isCompleteLogo) || (paramView.isUsed()) || (localBrandTO.isComplete())) {
      showFullAnswer(paramView);
    }
    while (!hasEnoughHints(paramView.getOldHintCost())) {
      return;
    }
    new AlertDialog.Builder(this).setIcon(17301618).setMessage(getString(R.string.form_answer_the_question, new Object[] { Integer.valueOf(paramView.getOldHintCost()) })).setNegativeButton(17039360, null).setPositiveButton(17039370, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        FormOldActivityCommons.this.useHint(paramView);
        FormOldActivityCommons.this.showFullAnswer(paramView);
      }
    }).show();
  }
  
  public void hintsOnlyUsedLetters(View paramView)
  {
    if (findViewById(R.id.hint_body_container) == null) {
      ((ViewStub)findViewById(R.id.hint_body_container_stub)).inflate();
    }
    paramView = (BrandTO)getIntent().getSerializableExtra("brandTO");
    final Hint localHint = HintsUtil.getHintById(3, (BrandTO)getIntent().getSerializableExtra("brandTO"), getScoreUtilProvider().getGameModeName(), getApplicationContext());
    if ((this.isCompleteLogo) || (localHint.isUsed()) || (paramView.isComplete())) {
      showOnlyUsedLetters(localHint);
    }
    while (!hasEnoughHints(localHint.getOldHintCost())) {
      return;
    }
    new AlertDialog.Builder(this).setIcon(17301516).setMessage(getString(R.string.form_show_used_letters_text, new Object[] { Integer.valueOf(localHint.getOldHintCost()) })).setNegativeButton(17039360, null).setPositiveButton(17039370, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        FormOldActivityCommons.this.useHint(localHint);
        FormOldActivityCommons.this.showOnlyUsedLetters(localHint);
      }
    }).show();
  }
  
  protected boolean isCategoryHint()
  {
    return true;
  }
  
  protected boolean isLevelUnlocked()
  {
    int m = getScoreService().getCompletedLogosCount(getApplicationContext());
    final Object localObject1 = getScoreUtilProvider().getLevelsInfo(getApplicationContext());
    final int j = -1;
    int n = localObject1.length;
    int i = 0;
    while (i < n)
    {
      Object localObject2 = localObject1[i];
      int k = j;
      if (m == ((LevelInterface)localObject2).getUnlockLimit())
      {
        k = j;
        if (((LevelInterface)localObject2).getId() < localObject1.length) {
          k = ((LevelInterface)localObject2).getId();
        }
      }
      i += 1;
      j = k;
    }
    boolean bool1;
    if (j != -1)
    {
      bool1 = true;
      if (bool1)
      {
        localObject1 = new PopUp(this).setTextHeader1(getString(R.string.pop_up_level_up)).setTextHeader2(getString(R.string.pop_up_level_unlocked, new Object[] { Integer.valueOf(j) })).setTextParagraph2(getString(R.string.pop_up_congratulations_get_hints));
        ((PopUp)localObject1).setOnClickGoToListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            FormOldActivityCommons.this.startActivity(FormOldActivityCommons.this.popupLevelUnlockIntentBuild(j));
            localObject1.hide();
          }
        });
        if (j < 3) {
          break label215;
        }
      }
    }
    label215:
    for (boolean bool2 = true;; bool2 = false)
    {
      ((PopUp)localObject1).show(new PopUp.Callback.EarnHintsCallback(2, bool2, this.cb, this));
      return bool1;
      bool1 = false;
      break;
    }
  }
  
  public void next(View paramView)
  {
    if (this.nextBrandTO != null)
    {
      paramView = (Integer)getIntent().getExtras().get("position");
      Intent localIntent = new Intent(getApplicationContext(), DeviceUtilCommons.getClassByName(getApplicationContext(), "LogosFormOldActivity"));
      localIntent.putExtra("position", paramView.intValue() + 1);
      localIntent.putExtra("brandPosition", this.nextBrandTO.getBrandPosition());
      localIntent.putExtra("brandNames", this.nextBrandTO.getNames());
      localIntent.putExtra("brandDrawable", this.nextBrandTO.getDrawable());
      localIntent.putExtra("brandTO", this.nextBrandTO);
      finish();
      startActivityForResult(localIntent, paramView.intValue() + 1);
      return;
    }
    back(null);
  }
  
  public void onBackPressed()
  {
    back(null);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    overridePendingTransition(0, 0);
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
    super.onCreate(paramBundle, R.layout.logos_form);
    this.myActivity = this;
    setTheme(16973934);
    this.isZoomBlocked = true;
    this.winnerColors = getGratulationsColors();
    this.playServicesActionHelper = new PlayServicesActionHelper(this);
    addActivityActions(new ActivityAction[] { this.playServicesActionHelper });
    Object localObject1 = (RelativeLayout)findViewById(R.id.mainLayout);
    getLayoutInflater().inflate(R.layout.logo, (ViewGroup)localObject1, true);
    nextPrevBrands();
    this.logoSize = DeviceUtilCommons.getLogoSize(getApplicationContext());
    paramBundle = (BrandTO)getIntent().getSerializableExtra("brandTO");
    Object localObject2 = (ViewGroup)findViewById(R.id.centerPartContainer);
    if (paramBundle.isComplete())
    {
      getLayoutInflater().inflate(R.layout.logos_form_old_read_more, (ViewGroup)localObject2, true);
      findViewById(R.id.adContainer).setBackgroundResource(R.drawable.bg_winner_repeat);
      if (findViewById(R.id.editWinLogo) == null) {
        ((ViewStub)findViewById(R.id.winnerViewStub)).inflate();
      }
      showWinnerScreen(paramBundle, false);
      setLogoImage(paramBundle, R.id.imageBrand, null, 0);
      ((TextView)findViewById(R.id.hintsLabelLevel)).setText(getResources().getString(R.string.hints));
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          FormOldActivityCommons.this.isZoomBlocked = false;
        }
      }, 800L);
      this.cb = Chartboost.sharedChartboost();
      this.cb.onCreate(this, getConstants().getChartboostAppId(), getConstants().getChartboostAppSignature(), null);
      this.cb.startSession();
      this.gestureDetector = new LogoFormOnGestureDetector(getApplicationContext(), new LogoFormGestureListener()
      {
        public void onSwipeLeft()
        {
          FormOldActivityCommons.this.next(null);
        }
        
        public void onSwipeRight()
        {
          FormOldActivityCommons.this.prev(null);
        }
      });
      return;
    }
    findViewById(R.id.adContainer).setVisibility(8);
    getLayoutInflater().inflate(R.layout.hints_left, (ViewGroup)localObject1, true);
    getLayoutInflater().inflate(R.layout.hints_right, (ViewGroup)localObject1, true);
    getLayoutInflater().inflate(R.layout.logos_form_old_edit_text, (ViewGroup)localObject2, true);
    if (findViewById(R.id.editWinLogo) != null) {
      findViewById(R.id.editWinLogo).setVisibility(4);
    }
    localObject1 = (LinearLayout)findViewById(R.id.leftHints);
    localObject2 = findViewById(R.id.rightHints);
    Object localObject3 = findViewById(R.id.hintsClueSentense1);
    if ((paramBundle.getHint1() == null) || (paramBundle.getHint1().trim().equals("")))
    {
      if (localObject3 != null) {
        ((View)localObject3).setVisibility(8);
      }
      label467:
      localObject3 = findViewById(R.id.hintsClueSentense2);
      if ((paramBundle.getHint2() != null) && (!paramBundle.getHint2().trim().equals(""))) {
        break label660;
      }
      if (localObject3 != null) {
        ((View)localObject3).setVisibility(8);
      }
    }
    for (;;)
    {
      localObject3 = AnimationUtils.loadAnimation(this.myActivity, R.anim.fadein);
      ((LinearLayout)localObject1).setVisibility(0);
      ((View)localObject2).setVisibility(0);
      ((LinearLayout)localObject1).startAnimation((Animation)localObject3);
      ((View)localObject2).startAnimation((Animation)localObject3);
      localObject1 = getScoreUtilProvider().getCaterogies();
      if (localObject1 != null)
      {
        localObject1 = getScoreUtilProvider().getLevelsInfo(getApplicationContext())[((Integer)localObject1.get(paramBundle.getCategory())).intValue()];
        if (((LevelInterface)localObject1).getWhatIsThisLabel() != null) {
          ((TextView)findViewById(R.id.menuInfo)).setText(((LevelInterface)localObject1).getWhatIsThisLabel());
        }
      }
      initHintsImages();
      ((EditText)findViewById(R.id.editTextLogo)).setOnKeyListener(new View.OnKeyListener()
      {
        public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          boolean bool2 = false;
          boolean bool1 = bool2;
          if (paramAnonymousKeyEvent != null)
          {
            bool1 = bool2;
            if (paramAnonymousKeyEvent.getAction() == 0)
            {
              bool1 = bool2;
              if ((paramAnonymousInt == 66) && (FormOldActivityCommons.this.ckeck())) {}
            }
          }
          try
          {
            ((InputMethodManager)FormOldActivityCommons.this.getSystemService("input_method")).hideSoftInputFromWindow(((EditText)FormOldActivityCommons.this.findViewById(R.id.editTextLogo)).getWindowToken(), 0);
            bool1 = true;
            return bool1;
          }
          catch (Exception paramAnonymousView)
          {
            for (;;) {}
          }
        }
      });
      break;
      if (localObject3 == null) {
        break label467;
      }
      ((View)localObject3).setVisibility(0);
      break label467;
      label660:
      if (localObject3 != null) {
        ((View)localObject3).setVisibility(0);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.adViewReadMore != null) {
      this.adViewReadMore.destroy();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.adViewReadMore != null) {
      this.adViewReadMore.pause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.bugSense.addCrashExtraData("activity", getClass().getSimpleName());
    getMenuService().refreshScore(this);
    if (this.adViewReadMore != null) {
      this.adViewReadMore.resume();
    }
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  protected Intent popupLevelUnlockIntentBuild(int paramInt)
  {
    LevelUtil.setActiveLevel(getApplicationContext(), paramInt);
    Intent localIntent = new Intent(getApplicationContext(), DeviceUtilCommons.getClassByName(getApplicationContext(), this.logosListActivityName));
    localIntent.setFlags(335544320);
    localIntent.putExtra("LOGOS_LIST_ACTIVITY_NAME", this.logosListActivityName);
    return localIntent;
  }
  
  public void prev(View paramView)
  {
    if (this.prevBrandTO != null)
    {
      paramView = (Integer)getIntent().getExtras().get("position");
      Intent localIntent = new Intent(getApplicationContext(), DeviceUtilCommons.getClassByName(getApplicationContext(), "LogosFormOldActivity"));
      localIntent.putExtra("position", paramView.intValue() - 1);
      localIntent.putExtra("brandPosition", this.prevBrandTO.getBrandPosition());
      localIntent.putExtra("brandNames", this.prevBrandTO.getNames());
      localIntent.putExtra("brandDrawable", this.prevBrandTO.getDrawable());
      localIntent.putExtra("brandTO", this.prevBrandTO);
      finish();
      startActivityForResult(localIntent, paramView.intValue() - 1);
      return;
    }
    back(null);
  }
  
  public void readMore(View paramView)
  {
    if (DeviceUtilCommons.isOnline(getApplicationContext()))
    {
      this.readMoreDialog = new Dialog(this, R.style.Dialog_Fullscreen);
      this.readMoreDialog.requestWindowFeature(1);
      this.readMoreDialog.setContentView(R.layout.read_more);
      this.readMoreDialog.setCancelable(true);
      this.readMoreDialog.show();
      paramView = (BrandTO)getIntent().getSerializableExtra("brandTO");
      new HouseAd(this.adserwer, this).showAdForHints();
      Object localObject1 = (ViewGroup)this.readMoreDialog.findViewById(R.id.adContainer);
      this.adViewReadMore = AdserwerCommons.getAdmob(this, getConstants().getAdmobPubId(), new AdListener() {});
      ((ViewGroup)localObject1).addView(this.adViewReadMore);
      localObject1 = (TextView)this.readMoreDialog.findViewById(R.id.brandNameReadMore);
      Object localObject2 = Shader.TileMode.CLAMP;
      localObject2 = new LinearGradient(0.0F, 0.0F, 0.0F, 50.0F, new int[] { -4408132, -7303024 }, new float[] { 0.0F, 1.0F }, (Shader.TileMode)localObject2);
      ((TextView)localObject1).getPaint().setShader((Shader)localObject2);
      ((TextView)localObject1).setText(paramView.getbrandName().toUpperCase());
      localObject1 = (WebView)this.readMoreDialog.findViewById(R.id.webBrandInfoReadMore);
      ((WebView)localObject1).getSettings().setJavaScriptEnabled(true);
      ((WebView)localObject1).setWebViewClient(new MyWebViewClient(null));
      ((WebView)localObject1).loadUrl(paramView.getWikipediaLink());
      ((ImageButton)this.readMoreDialog.findViewById(R.id.backButton)).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          FormOldActivityCommons.this.readMoreDialog.dismiss();
        }
      });
      return;
    }
    DeviceUtilCommons.showLongToast(getString(R.string.you_have_to_be_online), getApplicationContext());
  }
  
  protected void saveGameStateToCloud()
  {
    this.playServicesActionHelper.setLoginCheck(false);
    this.playServicesActionHelper.updateCloud(0, getSaveGame().getBytes());
    this.playServicesActionHelper.setLoginCheck(true);
  }
  
  public void selectLetterToShow(View paramView)
  {
    if (findViewById(R.id.hint_body_container) == null) {
      ((ViewStub)findViewById(R.id.hint_body_container_stub)).inflate();
    }
    paramView = (BrandTO)getIntent().getSerializableExtra("brandTO");
    final Hint localHint = HintsUtil.getHintById(4, (BrandTO)getIntent().getSerializableExtra("brandTO"), getScoreUtilProvider().getGameModeName(), getApplicationContext());
    if ((this.isCompleteLogo) || (localHint.isUsed()) || (paramView.isComplete())) {
      showSomeLettersInOrder(localHint);
    }
    while (!hasEnoughHints(localHint.getOldHintCost())) {
      return;
    }
    new AlertDialog.Builder(this).setIcon(17301516).setMessage(getString(R.string.form_some_letters_in_order_text, new Object[] { Integer.valueOf(localHint.getOldHintCost()) })).setNegativeButton(17039360, null).setPositiveButton(17039370, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        FormOldActivityCommons.this.useHint(localHint);
        FormOldActivityCommons.this.showSomeLettersInOrder(localHint);
      }
    }).show();
  }
  
  protected void setLogoImage(BrandTO paramBrandTO, int paramInt1, LogoImageLoaderListener paramLogoImageLoaderListener, int paramInt2)
  {
    paramLogoImageLoaderListener = PicassoOwnCache.with(getApplicationContext());
    if (paramBrandTO.getDrawable() == -1)
    {
      paramBrandTO = paramLogoImageLoaderListener.load(paramBrandTO.getDrawableString()).placeholder(R.drawable.loading_logo).error(R.drawable.no_internet);
      if (paramInt2 <= 0) {
        break label75;
      }
      paramBrandTO.fit();
    }
    for (;;)
    {
      paramBrandTO.into((ImageView)findViewById(paramInt1));
      return;
      paramBrandTO = paramLogoImageLoaderListener.load(Integer.parseInt(paramBrandTO.getDrawableString()));
      break;
      label75:
      paramBrandTO.skipMemoryCache();
    }
  }
  
  protected void setZoomedLogo(BrandTO paramBrandTO)
  {
    setLogoImage(paramBrandTO, R.id.zoomLogo, null, 0);
  }
  
  protected void showWinnerScreen(BrandTO paramBrandTO, boolean paramBoolean)
  {
    findViewById(R.id.adContainer).setVisibility(0);
    ((TextView)findViewById(R.id.completeLogoName)).setText(paramBrandTO.getbrandName().toUpperCase());
    FlowTextView localFlowTextView = (FlowTextView)findViewById(R.id.short_read_more);
    localFlowTextView.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf"));
    Object localObject = findViewById(R.id.readMoreButton);
    int i;
    if (paramBrandTO.hasWikipediaLink())
    {
      ((View)localObject).setVisibility(0);
      localFlowTextView.setVisibility(0);
      String str = ". ";
      localObject = str;
      if (paramBrandTO.getHint1() != null)
      {
        localObject = str;
        if (!paramBrandTO.getHint1().trim().equals(""))
        {
          localObject = str;
          if (paramBrandTO.getHint1().trim().substring(paramBrandTO.getHint1().trim().length() - 1).equals(".")) {
            localObject = " ";
          }
        }
      }
      localFlowTextView.setText(paramBrandTO.getHint1() + (String)localObject + paramBrandTO.getHint2());
      if (com.bubble.adserwer.utils.DeviceUtils.isTablet(getApplicationContext()))
      {
        i = 18;
        localFlowTextView.setTextSize(DeviceUtilCommons.dip(logo.quiz.commons.utils.DeviceUtils.deviceScale(i, this), this));
        localFlowTextView.setColor(getResources().getColor(R.color.read_more_color));
        label239:
        findViewById(R.id.editWinLogo).setVisibility(0);
        findViewById(R.id.closeButtonId).requestFocus();
        localObject = (TextView)findViewById(R.id.scoreId);
        if (DeviceUtilCommons.isSmallScreen(getApplicationContext())) {
          break label453;
        }
        ((TextView)localObject).setText(getString(R.string.winner_view_points) + paramBrandTO.getLevel(getApplicationContext()));
        label319:
        findViewById(R.id.prevButtonId).setVisibility(0);
        findViewById(R.id.nextButtonId).setVisibility(0);
        if (this.nextBrandTO != null) {
          break label463;
        }
        findViewById(R.id.nextButtonId).setVisibility(8);
        label360:
        if (this.prevBrandTO != null) {
          break label482;
        }
        findViewById(R.id.prevButtonId).setVisibility(8);
      }
    }
    for (;;)
    {
      localObject = (TextView)findViewById(R.id.gratulationsHeader);
      i = paramBrandTO.getBrandPosition() % FormActivityCommons.winnerMessages.length;
      ((TextView)localObject).setText(getResources().getString(FormActivityCommons.winnerMessages[i]));
      ((TextView)localObject).setTextColor(this.winnerColors[i]);
      return;
      i = 16;
      break;
      ((View)localObject).setVisibility(8);
      localFlowTextView.setVisibility(8);
      break label239;
      label453:
      ((TextView)localObject).setVisibility(8);
      break label319;
      label463:
      setLogoImage(this.nextBrandTO, R.id.nextButtonImage, null, this.logoSize);
      break label360;
      label482:
      setLogoImage(this.prevBrandTO, R.id.prevButtonImage, null, this.logoSize);
    }
  }
  
  public void toggleHint(View paramView)
  {
    if (findViewById(R.id.hint_body_container) == null) {
      ((ViewStub)findViewById(R.id.hint_body_container_stub)).inflate();
    }
    if (findViewById(R.id.hint_body_container).getVisibility() == 8)
    {
      showHint();
      return;
    }
    closeHint();
  }
  
  public void zoomLogo(View paramView)
  {
    if (!this.isZoomBlocked)
    {
      paramView = (RelativeLayout)findViewById(R.id.zoomLogoContainer);
      if (paramView != null) {
        break label87;
      }
      ((ViewStub)findViewById(R.id.zoomLogoContainerStub)).inflate();
      if (findViewById(R.id.closeZoom) != null) {
        ((Button)findViewById(R.id.closeZoom)).setTypeface(Typeface.createFromAsset(getAssets(), "fonts/arial_black.ttf"));
      }
    }
    for (;;)
    {
      setZoomedLogo((BrandTO)getIntent().getSerializableExtra("brandTO"));
      return;
      label87:
      paramView.setVisibility(0);
    }
  }
  
  public void zoomOutLogo(View paramView)
  {
    findViewById(R.id.zoomLogoContainer).setVisibility(8);
  }
  
  private class MyWebViewClient
    extends WebViewClient
  {
    private MyWebViewClient() {}
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      if (FormOldActivityCommons.this.readMoreDialog != null) {
        FormOldActivityCommons.this.readMoreDialog.findViewById(R.id.webViewLoading).setVisibility(8);
      }
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      paramWebView.loadUrl(paramString);
      return true;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/FormOldActivityCommons.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */