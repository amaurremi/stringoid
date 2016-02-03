package logo.quiz.commons;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.text.TextPaint;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bluebird.mobile.tools.activities.ActivityAction;
import com.bubble.adserwer.HouseAd;
import com.bubble.bugsense.BugSense;
import com.bubble.keyboard.AnswerListener;
import com.bubble.keyboard.Keyboard;
import com.bubble.keyboard.KeyboardClassic;
import com.bubble.keyboard.OnClickInputButtonListener;
import com.bubble.keyboard.TextField;
import com.bubble.keyboard.TextFieldWithLetters;
import com.bubble.keyboard.hints.CounterListener;
import com.bubble.keyboard.hints.KeyboardHintsWithCounter;
import com.bubble.play.services.PlayServicesActionHelper;
import com.chartboost.sdk.Chartboost;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.io.Serializable;
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
import logo.quiz.commons.utils.FormKeyboardHelper;
import logo.quiz.commons.utils.flowtextview.FlowTextView;
import logo.quiz.commons.utils.hints.HintsService;
import logo.quiz.commons.utils.hints.HintsServiceFactory;
import logo.quiz.commons.utils.menu.MenuService;
import logo.quiz.commons.utils.score.ScoreService;

public abstract class FormActivityCommons
  extends LogoQuizAbstractActivity
{
  protected static final int[] winnerMessages = { R.string.winner1, R.string.winner2, R.string.winner3, R.string.winner4, R.string.winner5, R.string.winner6, R.string.winner7, R.string.winner8, R.string.winner9, R.string.winner10, R.string.winner11, R.string.winner12 };
  private AdView adViewReadMore;
  boolean complete = false;
  protected FormKeyboardHelper formKeyboardHelper;
  private GestureDetector gestureDetector;
  protected int hintsLeftViewId = R.layout.hints_left;
  protected int hintsRightViewId = R.layout.hints_right;
  private boolean isCompleteLogo = false;
  boolean isZoomBlocked = true;
  private Keyboard keyboard;
  protected int logoViewId = R.layout.logo;
  protected String logosListActivityName = "LogosListActivity";
  private int miniLogoWidth;
  BrandTO nextBrandTO = null;
  protected PlayServicesActionHelper playServicesActionHelper;
  BrandTO prevBrandTO = null;
  private Dialog readMoreDialog = null;
  private TextField textField;
  protected int viewId = R.layout.logos_form_with_keyboard;
  protected int[] winnerColors;
  
  private void correctSound()
  {
    if (PreferenceManager.getDefaultSharedPreferences(this).getBoolean("SOUND", true)) {
      DeviceUtilCommons.playSound(getApplicationContext(), R.raw.correct);
    }
  }
  
  private String getLocaleAlphabet(BrandTO paramBrandTO, String paramString)
  {
    String str1 = paramString;
    if (paramBrandTO.getNameCode() != null)
    {
      String str2 = logo.quiz.commons.utils.DeviceUtils.getStringResourceByNameForLocale(paramBrandTO.getNameCode(), "en", getApplicationContext());
      str1 = paramString;
      if (str2 != null)
      {
        str1 = paramString;
        if (!paramBrandTO.getbrandName().equals(str2)) {
          str1 = getResources().getString(R.string.alphabet);
        }
      }
    }
    return str1;
  }
  
  private void guessTries()
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    localEditor.putInt("guessTries" + getScoreUtilProvider().getGameModeName(), localSharedPreferences.getInt("guessTries" + getScoreUtilProvider().getGameModeName(), 0) + 1);
    localEditor.commit();
  }
  
  private void initHintsImages()
  {
    Iterator localIterator = HintsUtil.getAllHintsForBrand((BrandTO)getIntent().getSerializableExtra("brandTO"), getScoreUtilProvider().getGameModeName(), getApplicationContext()).iterator();
    while (localIterator.hasNext())
    {
      Hint localHint = (Hint)localIterator.next();
      if (localHint.isUsed())
      {
        View localView = findViewById(localHint.getImageViewId());
        if (localView != null) {
          localView.setBackgroundResource(localHint.getDrawableOff());
        }
      }
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
  
  private void onWrongAnswer(String paramString)
  {
    Object localObject = PreferenceManager.getDefaultSharedPreferences(this);
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject).edit();
    BrandTO localBrandTO = (BrandTO)getIntent().getExtras().get("brandTO");
    if (((SharedPreferences)localObject).getInt("perfectGuessBrand" + localBrandTO.getId() + getScoreUtilProvider().getGameModeName(), 0) == 0) {
      localEditor.putInt("perfectGuessBrand" + localBrandTO.getId() + getScoreUtilProvider().getGameModeName(), -1);
    }
    localObject = ((String[])(String[])getIntent().getExtras().get("brandNames"))[0].toLowerCase();
    int j = 0;
    int i = 0;
    while (i < ((String)localObject).length())
    {
      int k = j;
      if (i < paramString.length())
      {
        k = j;
        if (((String)localObject).charAt(i) == paramString.toLowerCase().charAt(i)) {
          k = j + 1;
        }
      }
      i += 1;
      j = k;
    }
    vibrateNegative();
    shakeView(findViewById(R.id.imageBrand));
    localEditor.commit();
    getMenuService().refreshScore(this);
  }
  
  private void putShadowOnFont(TextView paramTextView)
  {
    Object localObject = Shader.TileMode.CLAMP;
    localObject = new LinearGradient(0.0F, 0.0F, 0.0F, 50.0F, new int[] { -4408132, -7303024 }, new float[] { 0.0F, 1.0F }, (Shader.TileMode)localObject);
    paramTextView.getPaint().setShader((Shader)localObject);
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
    BrandTO localBrandTO = (BrandTO)getIntent().getSerializableExtra("brandTO");
    if ((this.isCompleteLogo) || (paramHint.isUsed()) || (localBrandTO.isComplete())) {
      showClue(paramHint);
    }
    while (!hasEnoughHints(paramHint.getCost())) {
      return;
    }
    new AlertDialog.Builder(this).setIcon(17301516).setMessage(paramHint.getDialogMessage()).setNegativeButton(17039360, null).setPositiveButton(17039370, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        FormActivityCommons.this.useHint(paramHint);
        FormActivityCommons.this.showClue(paramHint);
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
    String str10 = new String(Base64.encode(Base64.encodeToString(((BrandTO)localObject1).getImgName().getBytes(), 0).replaceAll("\n", "").getBytes(), 0)).replaceAll("=", "").replaceAll("\n", "");
    final String str9 = "http://logos-quiz.com/index.php?logo=" + str10 + "&type=" + str6;
    final String str1 = str2;
    localObject1 = str4;
    try
    {
      String str3 = URLEncoder.encode(str9, "UTF-8");
      str1 = str2;
      localObject1 = str4;
      localObject2 = str3;
      str2 = URLEncoder.encode(URLEncoder.encode(str9, "UTF-8"));
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
      localObject3 = URLEncoder.encode((String)localObject3 + "/" + str10 + ".png", "UTF-8");
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
        paramAnonymousDialogInterface = new Intent("android.intent.action.VIEW", Uri.parse("https://m.facebook.com/dialog/feed?app_id=" + str7 + "&" + "link=" + localObject2 + "&" + "picture=" + localObject3 + "&" + "name=Who+knows+this+logo+%3F&caption=Enjoy+" + str8 + "+game%21&" + "description=" + localObject1 + "&" + "redirect_uri=http%3A%2F%2Fwww.facebook.com"));
        paramAnonymousDialogInterface.addFlags(1073741824);
        paramAnonymousDialogInterface.addFlags(268435456);
        FormActivityCommons.this.startActivity(paramAnonymousDialogInterface);
      }
    }).setNegativeButton(17039360, null).setPositiveButton("Twitter", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface = new Intent("android.intent.action.SEND");
        paramAnonymousDialogInterface.putExtra("android.intent.extra.TEXT", "Who knows this logo " + str9 + " #logoquiz");
        paramAnonymousDialogInterface.setType("image/png");
        Object localObject = (BrandTO)FormActivityCommons.this.getIntent().getSerializableExtra("brandTO");
        paramAnonymousDialogInterface.putExtra("android.intent.extra.STREAM", Uri.parse("android.resource://" + FormActivityCommons.this.getPackageName() + "/drawable/" + ((BrandTO)localObject).getDrawableString()));
        localObject = FormActivityCommons.this.getPackageManager().queryIntentActivities(paramAnonymousDialogInterface, 65536);
        int i = 0;
        localObject = ((List)localObject).iterator();
        ResolveInfo localResolveInfo;
        do
        {
          paramAnonymousInt = i;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localResolveInfo = (ResolveInfo)((Iterator)localObject).next();
        } while (!localResolveInfo.activityInfo.packageName.startsWith("com.twitter.android"));
        paramAnonymousDialogInterface.setClassName(localResolveInfo.activityInfo.packageName, localResolveInfo.activityInfo.name);
        paramAnonymousInt = 1;
        if (paramAnonymousInt != 0)
        {
          FormActivityCommons.this.startActivity(paramAnonymousDialogInterface);
          return;
        }
        paramAnonymousDialogInterface = new Intent("android.intent.action.VIEW", Uri.parse("https://twitter.com/intent/session?return_to=%2Fintent%2Ftweet%3Fbutton_hashtag%3Dlogoquiz%26text%3DWho%2520knows%2520this%2520logo%253F%2520" + str1 + "&" + "text=Who+knows+this+logo%3F+" + localObject2));
        paramAnonymousDialogInterface.addFlags(1073741824);
        paramAnonymousDialogInterface.addFlags(268435456);
        FormActivityCommons.this.startActivity(paramAnonymousDialogInterface);
      }
    }).show();
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
  
  private void useHint(Hint paramHint)
  {
    minusHints(paramHint.getCost());
    this.formKeyboardHelper.disableHint(paramHint, getScoreUtilProvider().getGameModeName());
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
  
  protected void animateWinner(BrandTO paramBrandTO)
  {
    Animations.animateZoomIn(R.id.editWinLogo, 0, this);
    Animations.animateZoomIn(R.id.gratulationsHeader, 0, this);
    Animations.animateZoomIn(R.id.scoreId, 250, this);
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
    close(null);
  }
  
  public void close(View paramView)
  {
    paramView = new Intent(getApplicationContext(), DeviceUtilCommons.getClassByName(getApplicationContext(), getLogosListActivityName()));
    paramView.setFlags(603979776);
    startActivity(paramView);
    finish();
  }
  
  protected void closeHint()
  {
    View localView = findViewById(R.id.hint_body_container);
    if ((localView != null) && (localView.getVisibility() == 0))
    {
      localView.setVisibility(8);
      localView.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.exit_anim_slide_down));
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
      paramView.setFlags(603979776);
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
  
  public int getHintsLeftViewId()
  {
    return this.hintsLeftViewId;
  }
  
  public int getHintsRightViewId()
  {
    return this.hintsRightViewId;
  }
  
  public int getLogoViewId()
  {
    return this.logoViewId;
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
  
  public int getViewId()
  {
    return this.viewId;
  }
  
  protected boolean hasEnoughHints(int paramInt)
  {
    boolean bool = true;
    if (PreferenceManager.getDefaultSharedPreferences(this).getInt("allHints", 0) < paramInt)
    {
      bool = false;
      new AlertDialog.Builder(this).setIcon(17301619).setTitle(getString(R.string.form_running_out_of_hints)).setMessage(getString(R.string.form_visit_out_store)).setNegativeButton(17039360, null).setPositiveButton(17039370, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          FormActivityCommons.this.getFreeHints(null);
        }
      }).show();
    }
    return bool;
  }
  
  public void hintClue1(View paramView)
  {
    this.formKeyboardHelper.closeSelectedLetters();
    if (findViewById(R.id.hint_body_container) == null) {
      ((ViewStub)findViewById(R.id.hint_body_container_stub)).inflate();
    }
    showClueWithCheck(HintsUtil.getHintById(1, (BrandTO)getIntent().getSerializableExtra("brandTO"), getScoreUtilProvider().getGameModeName(), getApplicationContext()));
  }
  
  public void hintClue2(View paramView)
  {
    this.formKeyboardHelper.closeSelectedLetters();
    if (findViewById(R.id.hint_body_container) == null) {
      ((ViewStub)findViewById(R.id.hint_body_container_stub)).inflate();
    }
    showClueWithCheck(HintsUtil.getHintById(2, (BrandTO)getIntent().getSerializableExtra("brandTO"), getScoreUtilProvider().getGameModeName(), getApplicationContext()));
  }
  
  public void hintFbTwitter(View paramView)
  {
    this.formKeyboardHelper.closeSelectedLetters();
    showFbTwitterWithCheck();
  }
  
  public void hintFullAnswer(View paramView)
  {
    this.formKeyboardHelper.closeSelectedLetters();
    paramView = HintsUtil.getHintById(5, (BrandTO)getIntent().getSerializableExtra("brandTO"), getScoreUtilProvider().getGameModeName(), getApplicationContext());
    if (hasEnoughHints(paramView.getCost())) {
      new AlertDialog.Builder(this).setIcon(17301618).setMessage(paramView.getDialogMessage()).setNegativeButton(17039360, null).setPositiveButton(17039370, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          new AsyncTask()
          {
            protected Void doInBackground(Void... paramAnonymous2VarArgs)
            {
              return null;
            }
            
            protected void onPostExecute(Void paramAnonymous2Void)
            {
              super.onPostExecute(paramAnonymous2Void);
              FormActivityCommons.this.closeHint();
              FormActivityCommons.this.formKeyboardHelper.skipRiddle();
            }
          }.execute(new Void[] { (Void)null });
        }
      }).show();
    }
  }
  
  public void hintsOnlyUsedLetters(final View paramView)
  {
    this.formKeyboardHelper.closeSelectedLetters();
    if (findViewById(R.id.hint_body_container) == null) {
      ((ViewStub)findViewById(R.id.hint_body_container_stub)).inflate();
    }
    paramView = (BrandTO)getIntent().getSerializableExtra("brandTO");
    Hint localHint = HintsUtil.getHintById(3, (BrandTO)getIntent().getSerializableExtra("brandTO"), getScoreUtilProvider().getGameModeName(), getApplicationContext());
    if (hasEnoughHints(localHint.getCost()))
    {
      if (!localHint.isUsed()) {
        new AlertDialog.Builder(this).setIcon(17301516).setMessage(localHint.getDialogMessage()).setNegativeButton(17039360, null).setPositiveButton(17039370, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            FormActivityCommons.this.closeHint();
            FormActivityCommons.this.formKeyboardHelper.useBomb();
            FormActivityCommons.this.formKeyboardHelper.checkBombButtonForBrand(paramView, FormActivityCommons.this.getScoreUtilProvider().getGameModeName());
          }
        }).show();
      }
    }
    else {
      return;
    }
    DeviceUtilCommons.showLongToast(getString(R.string.form_all_non_matching_letters_removed), getApplicationContext());
  }
  
  protected boolean isCategoryHint()
  {
    return true;
  }
  
  protected boolean isLevelUnlocked()
  {
    int m = getScoreService().getCompletedLogosCount(getApplicationContext());
    final Object localObject1 = getScoreUtilProvider().getLevelsInfo(getApplicationContext());
    int k = -1;
    int n = localObject1.length;
    int i = 0;
    final int j = k;
    boolean bool1;
    if (i < n)
    {
      Object localObject2 = localObject1[i];
      if ((m == ((LevelInterface)localObject2).getUnlockLimit()) && (((LevelInterface)localObject2).getId() < localObject1.length)) {
        j = ((LevelInterface)localObject2).getId();
      }
    }
    else
    {
      if (j == -1) {
        break label205;
      }
      bool1 = true;
      label94:
      if (bool1)
      {
        localObject1 = new PopUp(this).setTextHeader1(getString(R.string.pop_up_level_up)).setTextHeader2(getString(R.string.pop_up_level_unlocked, new Object[] { Integer.valueOf(j) })).setTextParagraph2(getString(R.string.pop_up_congratulations_get_hints));
        ((PopUp)localObject1).setOnClickGoToListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            FormActivityCommons.this.startActivity(FormActivityCommons.this.popupLevelUnlockIntentBuild(j));
            localObject1.hide();
          }
        });
        if (j < 3) {
          break label211;
        }
      }
    }
    label205:
    label211:
    for (boolean bool2 = true;; bool2 = false)
    {
      ((PopUp)localObject1).show(new PopUp.Callback.EarnHintsCallback(2, bool2, this.cb, this));
      return bool1;
      i += 1;
      break;
      bool1 = false;
      break label94;
    }
  }
  
  public void minusHints(int paramInt)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    localEditor.putInt("allHints", localSharedPreferences.getInt("allHints", 0) - paramInt);
    localEditor.commit();
    HintsUtil.addUsedHints(paramInt, getApplicationContext());
    getMenuService().refreshScore(this);
  }
  
  public void next(View paramView)
  {
    if (this.nextBrandTO != null)
    {
      paramView = (Integer)getIntent().getExtras().get("position");
      Intent localIntent = getIntent();
      localIntent.putExtra("position", paramView.intValue() + 1);
      localIntent.putExtra("brandPosition", this.nextBrandTO.getBrandPosition());
      localIntent.putExtra("brandNames", this.nextBrandTO.getNames());
      localIntent.putExtra("brandDrawable", this.nextBrandTO.getDrawable());
      localIntent.putExtra("brandTO", this.nextBrandTO);
      start();
      return;
    }
    back(null);
  }
  
  public void onBackPressed()
  {
    back(null);
  }
  
  protected void onCorrectAnswer()
  {
    Object localObject = findViewById(R.id.todayOfferContainer);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    int i = LevelUtil.getActiveLevel();
    localObject = getScoreUtilProvider().getBrands(getApplicationContext(), i);
    Integer localInteger = (Integer)getIntent().getExtras().get("position");
    try
    {
      localObject = localObject[localInteger.intValue()];
      if (localSharedPreferences.getInt("perfectGuessBrand" + ((BrandTO)localObject).getId() + getScoreUtilProvider().getGameModeName(), 0) == 0)
      {
        localEditor.putInt("perfectGuessBrand" + ((BrandTO)localObject).getId() + getScoreUtilProvider().getGameModeName(), 1);
        localEditor.putInt("perfectGuess" + getScoreUtilProvider().getGameModeName(), localSharedPreferences.getInt("perfectGuess" + getScoreUtilProvider().getGameModeName(), 0) + 1);
        correctSound();
        vibratePositive();
        ((TextView)findViewById(R.id.menuInfo)).setText("");
        ((BrandTO)localObject).setComplete(true);
        getIntent().putExtra("brandTO", (Serializable)localObject);
        getScoreService().setComplete(((BrandTO)localObject).getBrandPosition(), ((BrandTO)localObject).getLevel(getApplicationContext()), this);
        localEditor.putInt("complete_position", localInteger.intValue());
        localEditor.commit();
        this.complete = true;
        if (findViewById(R.id.editWinLogo) == null)
        {
          ((ViewStub)findViewById(R.id.winnerViewStub)).inflate();
          if (!getResources().getBoolean(R.bool.isPoints)) {
            findViewById(R.id.scoreId).setVisibility(8);
          }
        }
        animateWinner((BrandTO)localObject);
        showWinnerScreen((BrandTO)localObject);
        userWinHints(isLevelUnlocked(), getScoreService().getCompletedLogosCount(getApplicationContext()), (BrandTO)localObject);
        this.isCompleteLogo = true;
        localEditor.commit();
        getMenuService().refreshScore(this);
        saveGameStateToCloud();
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        BrandTO localBrandTO = (BrandTO)getIntent().getSerializableExtra("brandTO");
        continue;
        localEditor.putInt("perfectGuessBrand" + localBrandTO.getId() + getScoreUtilProvider().getGameModeName(), 2);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    overridePendingTransition(0, 0);
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
    super.onCreate(paramBundle, getViewId());
    setTheme(16973934);
    this.winnerColors = getGratulationsColors();
    this.playServicesActionHelper = new PlayServicesActionHelper(this);
    addActivityActions(new ActivityAction[] { this.playServicesActionHelper });
    paramBundle = (RelativeLayout)findViewById(R.id.mainLayout);
    getLayoutInflater().inflate(getHintsLeftViewId(), paramBundle, true);
    getLayoutInflater().inflate(getLogoViewId(), paramBundle, true);
    getLayoutInflater().inflate(getHintsRightViewId(), paramBundle, true);
    this.miniLogoWidth = DeviceUtilCommons.getLogoSize(getApplicationContext());
    this.formKeyboardHelper = new FormKeyboardHelper(this);
    paramBundle = (BrandTO)getIntent().getSerializableExtra("brandTO");
    this.textField = new TextFieldWithLetters(paramBundle.getId() + "", paramBundle.getbrandName().toCharArray(), this);
    this.keyboard = new KeyboardClassic(this.textField.getListener(), getApplicationContext());
    start();
    this.cb = Chartboost.sharedChartboost();
    this.cb.onCreate(this, getConstants().getChartboostAppId(), getConstants().getChartboostAppSignature(), null);
    this.cb.startSession();
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
      Intent localIntent = getIntent();
      localIntent.putExtra("position", paramView.intValue() - 1);
      localIntent.putExtra("brandPosition", this.prevBrandTO.getBrandPosition());
      localIntent.putExtra("brandNames", this.prevBrandTO.getNames());
      localIntent.putExtra("brandDrawable", this.prevBrandTO.getDrawable());
      localIntent.putExtra("brandTO", this.prevBrandTO);
      start();
      return;
    }
    back(null);
  }
  
  public void readMore(View paramView)
  {
    if (DeviceUtilCommons.isOnline(getApplicationContext())) {
      try
      {
        this.readMoreDialog = new Dialog(this, R.style.Dialog_Fullscreen);
        this.readMoreDialog.requestWindowFeature(1);
        this.readMoreDialog.setContentView(R.layout.read_more);
        this.readMoreDialog.setCancelable(true);
        paramView = (BrandTO)getIntent().getSerializableExtra("brandTO");
        new HouseAd(this.adserwer, this).showAdForHints();
        Object localObject = (ViewGroup)this.readMoreDialog.findViewById(R.id.adContainer);
        this.adViewReadMore = AdserwerCommons.getAdmob(this, getConstants().getAdmobPubId(), new AdListener() {});
        ((ViewGroup)localObject).addView(this.adViewReadMore);
        localObject = (TextView)this.readMoreDialog.findViewById(R.id.brandNameReadMore);
        putShadowOnFont((TextView)localObject);
        ((TextView)localObject).setText(paramView.getbrandName().toUpperCase());
        localObject = (WebView)this.readMoreDialog.findViewById(R.id.webBrandInfoReadMore);
        ((WebView)localObject).getSettings().setJavaScriptEnabled(true);
        ((WebView)localObject).setWebViewClient(new MyWebViewClient(null));
        ((WebView)localObject).loadUrl(paramView.getWikipediaLink());
        ((ImageButton)this.readMoreDialog.findViewById(R.id.backButton)).setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            FormActivityCommons.this.readMoreDialog.dismiss();
          }
        });
        this.readMoreDialog.show();
        return;
      }
      catch (Exception paramView)
      {
        this.bugSense.sendExceptionMessage("FormActivityCommons", "readMore", paramView);
        return;
      }
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
    if (!this.formKeyboardHelper.closeSelectedLetters())
    {
      if (findViewById(R.id.hint_body_container) == null) {
        ((ViewStub)findViewById(R.id.hint_body_container_stub)).inflate();
      }
      paramView = HintsUtil.getHintById(4, (BrandTO)getIntent().getSerializableExtra("brandTO"), getScoreUtilProvider().getGameModeName(), getApplicationContext());
      if (hasEnoughHints(paramView.getCost())) {
        new AlertDialog.Builder(this).setIcon(17301516).setMessage(paramView.getDialogMessage()).setNegativeButton(17039360, null).setPositiveButton(17039370, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            FormActivityCommons.this.closeHint();
            FormActivityCommons.this.formKeyboardHelper.showSelectedLetter();
          }
        }).show();
      }
    }
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
  
  protected void showWinnerScreen(BrandTO paramBrandTO)
  {
    this.textField.setInputClickable(false);
    findViewById(R.id.leftHints).setVisibility(8);
    findViewById(R.id.rightHints).setVisibility(8);
    findViewById(R.id.editWinLogo).setVisibility(0);
    FlowTextView localFlowTextView = (FlowTextView)findViewById(R.id.short_read_more);
    localFlowTextView.setVisibility(0);
    localFlowTextView.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf"));
    findViewById(R.id.prevButtonId).setVisibility(0);
    findViewById(R.id.nextButtonId).setVisibility(0);
    findViewById(R.id.editLogo).setVisibility(8);
    Object localObject = findViewById(R.id.adSep);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = findViewById(R.id.adContainer);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    ((Button)findViewById(R.id.closeButtonId)).requestFocus();
    ((TextView)findViewById(R.id.scoreId)).setText(getString(R.string.winner_view_points) + paramBrandTO.getLevel(getApplicationContext()));
    localObject = findViewById(R.id.readMoreButton);
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
        localFlowTextView.setColor(-7434610);
        label373:
        if (this.nextBrandTO != null) {
          break label481;
        }
        findViewById(R.id.nextButtonId).setVisibility(8);
        label392:
        if (this.prevBrandTO != null) {
          break label500;
        }
        findViewById(R.id.prevButtonId).setVisibility(8);
      }
    }
    for (;;)
    {
      localObject = (TextView)findViewById(R.id.gratulationsHeader);
      i = paramBrandTO.getBrandPosition() % winnerMessages.length;
      ((TextView)localObject).setText(getResources().getString(winnerMessages[i]));
      ((TextView)localObject).setTextColor(this.winnerColors[i]);
      return;
      i = 16;
      break;
      ((View)localObject).setVisibility(8);
      localFlowTextView.setVisibility(8);
      break label373;
      label481:
      setLogoImage(this.nextBrandTO, R.id.nextButtonImage, null, this.miniLogoWidth);
      break label392;
      label500:
      setLogoImage(this.prevBrandTO, R.id.prevButtonImage, null, this.miniLogoWidth);
    }
  }
  
  protected void start()
  {
    this.complete = false;
    this.isCompleteLogo = false;
    this.isZoomBlocked = true;
    final BrandTO localBrandTO = (BrandTO)getIntent().getSerializableExtra("brandTO");
    if (findViewById(R.id.editWinLogo) != null)
    {
      findViewById(R.id.prevButtonId).setVisibility(8);
      findViewById(R.id.nextButtonId).setVisibility(8);
    }
    nextPrevBrands();
    setLogoImage(localBrandTO, R.id.imageBrand, null, 0);
    ((TextView)findViewById(R.id.hintsLabelLevel)).setText(getResources().getString(R.string.hints));
    initHintsImages();
    this.textField.init(localBrandTO.getId() + getScoreUtilProvider().getGameModeName(), localBrandTO.getbrandName().toCharArray());
    this.formKeyboardHelper.setKeyboardHints(new KeyboardHintsWithCounter(this.keyboard, this.textField, new CounterListener()
    {
      public void add(int paramAnonymousInt) {}
      
      public void minus(int paramAnonymousInt)
      {
        FormActivityCommons.this.minusHints(paramAnonymousInt);
      }
    }, this));
    this.textField.setAnswerListener(new AnswerListener()
    {
      public void correctAnswer()
      {
        if (!localBrandTO.isComplete(FormActivityCommons.this, FormActivityCommons.this.getScoreUtilProvider().getGameModeName()))
        {
          FormActivityCommons.this.guessTries();
          FormActivityCommons.this.onCorrectAnswer();
        }
      }
      
      public void wrongAnswer(boolean paramAnonymousBoolean)
      {
        if (!localBrandTO.isComplete(FormActivityCommons.this, FormActivityCommons.this.getScoreUtilProvider().getGameModeName()))
        {
          FormActivityCommons.this.guessTries();
          FormActivityCommons.this.onWrongAnswer(FormActivityCommons.this.textField.getAnswerLetters());
          if (paramAnonymousBoolean) {
            DeviceUtilCommons.showShortToast(FormActivityCommons.this.getString(R.string.form_almost_good), FormActivityCommons.this);
          }
        }
        else
        {
          return;
        }
        DeviceUtilCommons.showShortToast(FormActivityCommons.this.getString(R.string.form_wrong_answer), FormActivityCommons.this);
      }
    });
    this.textField.setOnClickInputButtonListener(new OnClickInputButtonListener()
    {
      public void onClickInputButtonListener()
      {
        FormActivityCommons.this.formKeyboardHelper.checkBombButtonForBrand(localBrandTO, FormActivityCommons.this.getScoreUtilProvider().getGameModeName());
      }
    });
    Object localObject2 = (FrameLayout)findViewById(R.id.input_container);
    ((FrameLayout)localObject2).removeAllViews();
    Object localObject1 = (FrameLayout)findViewById(R.id.editLogo);
    ((FrameLayout)localObject1).removeAllViews();
    if (localBrandTO.isComplete())
    {
      ((FrameLayout)localObject2).addView(this.textField.getCompleteLayout());
      localObject1 = findViewById(R.id.todayOfferContainer);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      if (findViewById(R.id.editWinLogo) == null)
      {
        ((ViewStub)findViewById(R.id.winnerViewStub)).inflate();
        if (!getResources().getBoolean(R.bool.isPoints)) {
          findViewById(R.id.scoreId).setVisibility(8);
        }
      }
      showWinnerScreen(localBrandTO);
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          FormActivityCommons.this.isZoomBlocked = false;
        }
      }, 800L);
      this.gestureDetector = new LogoFormOnGestureDetector(getApplicationContext(), new LogoFormGestureListener()
      {
        public void onSwipeLeft()
        {
          FormActivityCommons.this.next(null);
        }
        
        public void onSwipeRight()
        {
          FormActivityCommons.this.prev(null);
        }
      });
      return;
    }
    ((FrameLayout)localObject2).addView(this.textField.getLayout());
    localObject2 = getLocaleAlphabet(localBrandTO, getResources().getString(R.string.alphabet_default));
    ((FrameLayout)localObject1).addView(this.keyboard.getLayout(localBrandTO.getbrandName(), localBrandTO.getId() + getScoreUtilProvider().getGameModeName(), (String)localObject2, getApplicationContext()));
    findViewById(R.id.editLogo).setVisibility(0);
    localObject1 = findViewById(R.id.editWinLogo);
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(8);
    }
    findViewById(R.id.short_read_more).setVisibility(8);
    localObject1 = findViewById(R.id.leftHints);
    localObject2 = findViewById(R.id.rightHints);
    Object localObject3 = findViewById(R.id.hintsClueSentense1);
    if ((localBrandTO.getHint1() == null) || (localBrandTO.getHint1().trim().equals("")))
    {
      if (localObject3 != null) {
        ((View)localObject3).setVisibility(8);
      }
      label565:
      localObject3 = findViewById(R.id.hintsClueSentense2);
      if ((localBrandTO.getHint2() != null) && (!localBrandTO.getHint2().trim().equals(""))) {
        break label830;
      }
      if (localObject3 != null) {
        ((View)localObject3).setVisibility(8);
      }
      label609:
      localObject3 = AnimationUtils.loadAnimation(this, R.anim.fadein);
      ((Animation)localObject3).setStartOffset(300L);
      ((View)localObject1).setVisibility(0);
      ((View)localObject2).setVisibility(0);
      ((View)localObject1).startAnimation((Animation)localObject3);
      ((View)localObject2).startAnimation((Animation)localObject3);
      localObject1 = getScoreUtilProvider().getCaterogies();
      if (localObject1 != null)
      {
        localObject1 = getScoreUtilProvider().getLevelsInfo(getApplicationContext())[((Integer)localObject1.get(localBrandTO.getCategory())).intValue()];
        if (((LevelInterface)localObject1).getWhatIsThisLabel() != null)
        {
          ((TextView)findViewById(R.id.menuInfo)).setText(((LevelInterface)localObject1).getWhatIsThisLabel());
          Animations.slideUp(R.id.menuInfo, 1500, this);
        }
      }
      localObject1 = findViewById(R.id.adSep);
      localObject2 = findViewById(R.id.adContainer);
      if ((localObject1 != null) && (localObject2 != null))
      {
        if (!DeviceUtilCommons.isOnline(getApplicationContext())) {
          break label844;
        }
        ((View)localObject1).setVisibility(0);
        ((View)localObject2).setVisibility(0);
      }
    }
    for (;;)
    {
      this.formKeyboardHelper.bigKeyboardHideAd(this.keyboard.getKeyboardKeysCount(), localBrandTO.isComplete());
      this.formKeyboardHelper.checkBombButtonForBrand(localBrandTO, getScoreUtilProvider().getGameModeName());
      break;
      if (localObject3 == null) {
        break label565;
      }
      ((View)localObject3).setVisibility(0);
      break label565;
      label830:
      if (localObject3 == null) {
        break label609;
      }
      ((View)localObject3).setVisibility(0);
      break label609;
      label844:
      ((View)localObject1).setVisibility(8);
      ((View)localObject2).setVisibility(8);
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
  
  protected void userWinHints(boolean paramBoolean, int paramInt, BrandTO paramBrandTO)
  {
    if ((!paramBoolean) && (paramInt % 3 == 0))
    {
      paramBrandTO = PreferenceManager.getDefaultSharedPreferences(this);
      paramInt = paramBrandTO.getInt("allHints", 0);
      paramBrandTO = paramBrandTO.edit();
      DeviceUtilCommons.showLongToast(getString(R.string.adserwer_nice_get_new_hint), getApplicationContext());
      paramBrandTO.putInt("allHints", paramInt + 1);
      paramBrandTO.commit();
    }
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
      if (FormActivityCommons.this.readMoreDialog != null) {
        FormActivityCommons.this.readMoreDialog.findViewById(R.id.webViewLoading).setVisibility(8);
      }
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      paramWebView.loadUrl(paramString);
      return true;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/FormActivityCommons.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */