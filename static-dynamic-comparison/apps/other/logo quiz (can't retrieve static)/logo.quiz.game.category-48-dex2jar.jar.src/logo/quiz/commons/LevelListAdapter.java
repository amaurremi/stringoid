package logo.quiz.commons;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import logo.quiz.commons.utils.image.AsyncBitmapDrawable;
import logo.quiz.commons.utils.image.BitmapDrawableWorkerTask;
import logo.quiz.commons.utils.image.ImageUtils;
import logo.quiz.commons.utils.score.ScoreService;

public class LevelListAdapter
  extends BaseAdapter
{
  private LevelsActivityCommons activity;
  protected Context context;
  private int imageCompressSize;
  private LevelInterface[] levels;
  private LevelInterface[] levelsInfo;
  protected String logosListActivityName = "LogosListActivity";
  private LayoutInflater mInflater;
  private OnLevelClickListener onLevelClickListener;
  private ScoreService scoreService;
  private ScoreUtilProvider scoreUtilProvider;
  
  public LevelListAdapter(LevelsActivityCommons paramLevelsActivityCommons, String paramString, ScoreUtilProvider paramScoreUtilProvider, OnLevelClickListener paramOnLevelClickListener)
  {
    this.activity = paramLevelsActivityCommons;
    this.context = paramLevelsActivityCommons.getApplicationContext();
    this.mInflater = LayoutInflater.from(this.context);
    this.levels = paramScoreUtilProvider.getLevelsInfo(this.context);
    this.scoreUtilProvider = paramScoreUtilProvider;
    this.levelsInfo = paramScoreUtilProvider.getLevelsInfo(paramLevelsActivityCommons.getApplicationContext());
    this.logosListActivityName = paramString;
    this.onLevelClickListener = paramOnLevelClickListener;
    this.imageCompressSize = DeviceUtilCommons.getDeviceSize(this.context).x;
    this.scoreService = paramLevelsActivityCommons.getScoreService();
  }
  
  public static String getLogoText(int paramInt, Context paramContext)
  {
    if (paramInt > 4) {
      return paramContext.getString(R.string.logos_more_than_4);
    }
    if (paramInt == 1) {
      return paramContext.getString(R.string.logo);
    }
    return paramContext.getString(R.string.logos);
  }
  
  private void loadBitmap(View paramView, int paramInt1, int paramInt2)
  {
    Object localObject = ImageUtils.getLevelImageFromCache(paramInt1);
    if (localObject != null) {
      paramView.setBackgroundDrawable((Drawable)localObject);
    }
    while (!BitmapDrawableWorkerTask.cancelPotentialWork(paramInt1, paramView)) {
      return;
    }
    localObject = new BitmapDrawableWorkerTask(paramView, this.imageCompressSize, this.context.getResources(), this.context);
    paramView.setBackgroundDrawable(new AsyncBitmapDrawable(this.context.getResources(), paramInt2, (BitmapDrawableWorkerTask)localObject));
    paramView = new String[2];
    paramView[0] = String.valueOf(paramInt1);
    ((BitmapDrawableWorkerTask)localObject).execute(paramView);
  }
  
  private void playLevel(int paramInt, ViewGroup paramViewGroup)
  {
    if (paramInt == 1) {
      startLevel(paramInt, paramViewGroup);
    }
    do
    {
      return;
      if (this.scoreService.getCompletedLogosCount(this.activity.getApplicationContext()) >= this.levelsInfo[(paramInt - 1)].getUnlockLimit())
      {
        startLevel(paramInt, paramViewGroup);
        return;
      }
      paramViewGroup.startAnimation(AnimationUtils.loadAnimation(this.context, R.anim.shake));
    } while (!PreferenceManager.getDefaultSharedPreferences(this.context).getBoolean("SOUND", true));
    DeviceUtilCommons.playSound(this.context, R.raw.wrong);
  }
  
  private void startLevel(int paramInt, View paramView)
  {
    this.onLevelClickListener.onClick(paramInt, paramView);
  }
  
  public int getCount()
  {
    return this.levels.length;
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  protected String getLogoText(int paramInt)
  {
    return getLogoText(paramInt, this.context);
  }
  
  public View getView(int paramInt, final View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.mInflater.inflate(R.layout.level1, null);
      if (this.activity.getResources().getBoolean(R.bool.isPoints)) {}
    }
    try
    {
      paramView.findViewById(R.id.level_elem_points).setVisibility(8);
      paramViewGroup = new ViewHolder();
      paramViewGroup.setLevelLayout(paramView.findViewById(R.id.levelLayout));
      try
      {
        paramViewGroup.setLevelLayoutInner(paramView.findViewById(R.id.levelLayoutInner));
        if (this.activity.getLevelBg() != -1) {
          paramViewGroup.getLevelLayoutInner().setBackgroundResource(this.activity.getLevelBg());
        }
        try
        {
          paramViewGroup.setLevelScoreTextView((TextView)paramView.findViewById(R.id.levelScore));
          paramViewGroup.setLevelLogosCountTextView((TextView)paramView.findViewById(R.id.levelLogosCount));
          paramViewGroup.setLevelProgressBarlevel((RoundProgress)paramView.findViewById(R.id.progressBarlevel));
          paramViewGroup.setLevelProgressBarPercent((TextView)paramView.findViewById(R.id.progressBarPercentlevel));
          paramViewGroup.setLevel((TextView)paramView.findViewById(R.id.level));
          try
          {
            paramViewGroup.setLevelSubCategory((TextView)paramView.findViewById(R.id.levelSubCategory));
            try
            {
              paramViewGroup.setImg((ImageView)paramView.findViewById(this.context.getResources().getIdentifier("levelIcon", "id", this.context.getPackageName())));
              paramViewGroup.setLocklevel((ImageView)paramView.findViewById(R.id.locklevel));
              paramViewGroup.setLevelLayoutOnClick((RelativeLayout)paramView.findViewById(R.id.levelLayoutOnClick));
              try
              {
                paramViewGroup.setButtonLevel((Button)paramView.findViewById(R.id.buttonLevel));
                try
                {
                  paramViewGroup.setUnlockedLevelContainer(paramView.findViewById(R.id.unlockedLevelContainer));
                  try
                  {
                    paramViewGroup.setLockedLevelContainer((TextView)paramView.findViewById(R.id.lockedLevelContainer));
                    final Object localObject1 = paramViewGroup.getButtonLevel();
                    if (localObject1 != null) {
                      paramViewGroup.getLevelLayout().post(new Runnable()
                      {
                        public void run()
                        {
                          Object localObject = new Rect();
                          Button localButton = localObject1;
                          localButton.getHitRect((Rect)localObject);
                          ((Rect)localObject).left -= 600;
                          ((Rect)localObject).right += 600;
                          localObject = new TouchDelegate((Rect)localObject, localButton);
                          if (View.class.isInstance(localButton.getParent())) {
                            ((View)localButton.getParent()).setTouchDelegate((TouchDelegate)localObject);
                          }
                        }
                      });
                    }
                    paramView.setTag(paramViewGroup);
                    localObject1 = this.levels[paramInt];
                    paramInt = this.scoreService.getCompletedLogosCount(this.activity.getApplicationContext());
                    int j = this.levelsInfo[(localObject1.getId() - 1)].getUnlockLimit();
                    int i = j - paramInt;
                    label378:
                    Object localObject2;
                    if (paramInt >= j)
                    {
                      paramInt = 1;
                      if (paramInt == 0) {
                        break label868;
                      }
                      if (paramViewGroup.getLockedLevelContainer() != null) {
                        paramViewGroup.getLockedLevelContainer().setVisibility(8);
                      }
                      if (paramViewGroup.getUnlockedLevelContainer() != null) {
                        paramViewGroup.getUnlockedLevelContainer().setVisibility(0);
                      }
                      localObject2 = this.scoreService.getPointsInfo(this.context, ((LevelInterface)localObject1).getId());
                      paramInt = ((PointsCounter)localObject2).getCompletedLogosCount();
                      i = ((PointsCounter)localObject2).getCompletedPoints();
                      j = this.levelsInfo[(localObject1.getId() - 1)].getLogosCount();
                      if (paramViewGroup.getLevelScoreTextView() != null) {
                        paramViewGroup.getLevelScoreTextView().setText("" + i);
                      }
                      if (paramViewGroup.getLevelLogosCountTextView() != null)
                      {
                        paramViewGroup.getLevelLogosCountTextView().setText(paramInt + "/" + j);
                        paramViewGroup.getLevelLogosCountTextView().setVisibility(0);
                      }
                      paramViewGroup.getLevelProgressBarlevel().setMax(j);
                      paramViewGroup.getLevelProgressBarlevel().setProgress(paramInt);
                      paramInt = Math.round(Integer.valueOf(paramInt).floatValue() / Integer.valueOf(j).floatValue() * 100.0F);
                      paramViewGroup.getLevelProgressBarPercent().setText(paramInt + "%");
                      paramViewGroup.getLocklevel().setVisibility(8);
                      label629:
                      if (!((LevelInterface)localObject1).isLevelBackgroundColor()) {
                        break label975;
                      }
                      paramViewGroup.getLevelLayout().setBackgroundColor(((LevelInterface)localObject1).getLevelBackgroundResource());
                      label653:
                      if (((LevelInterface)localObject1).getTo() == -1) {
                        break label1039;
                      }
                      paramViewGroup.getLevel().setText(this.activity.getResources().getString(R.string.level) + " " + ((LevelInterface)localObject1).getId());
                    }
                    for (;;)
                    {
                      if (this.context.getResources().getString(R.string.type).equals("logo-quiz-ultimate"))
                      {
                        paramViewGroup.getLevelLayoutInner().setPadding(DeviceUtilCommons.getDeviceSize(this.context).x / 4, 0, 0, 0);
                        paramViewGroup.getLevelLayoutInner().setBackgroundDrawable(null);
                        paramViewGroup.getLevel().setText("");
                      }
                      localObject2 = new View.OnClickListener()
                      {
                        public void onClick(View paramAnonymousView)
                        {
                          LevelListAdapter.this.playLevel(localObject1.getId(), (ViewGroup)paramView);
                        }
                      };
                      paramViewGroup.getLevelLayoutOnClick().setOnClickListener((View.OnClickListener)localObject2);
                      if (paramViewGroup.getButtonLevel() != null) {
                        paramViewGroup.getButtonLevel().setOnClickListener((View.OnClickListener)localObject2);
                      }
                      if (paramViewGroup.getLockedLevelContainer() != null) {
                        paramViewGroup.getLockedLevelContainer().setOnClickListener((View.OnClickListener)localObject2);
                      }
                      if (paramViewGroup.getImg() != null) {
                        paramViewGroup.getImg().setImageResource(((LevelInterface)localObject1).getLevelImageResource());
                      }
                      return paramView;
                      paramViewGroup = (ViewHolder)paramView.getTag();
                      break;
                      paramInt = 0;
                      break label378;
                      label868:
                      if (paramViewGroup.getLockedLevelContainer() != null) {
                        paramViewGroup.getLockedLevelContainer().setVisibility(0);
                      }
                      if (paramViewGroup.getLevelLogosCountTextView() != null) {
                        paramViewGroup.getLevelLogosCountTextView().setVisibility(8);
                      }
                      localObject2 = getLogoText(i);
                      if (paramViewGroup.getLockedLevelContainer() != null) {
                        paramViewGroup.getLockedLevelContainer().setText(this.activity.getString(R.string.answer_x_logos_to_unlock, new Object[] { Integer.valueOf(i), localObject2 }));
                      }
                      if (paramViewGroup.getUnlockedLevelContainer() != null) {
                        paramViewGroup.getUnlockedLevelContainer().setVisibility(8);
                      }
                      paramViewGroup.getLocklevel().setVisibility(0);
                      break label629;
                      label975:
                      if (this.context.getResources().getString(R.string.type).equals("logo-quiz-ultimate"))
                      {
                        loadBitmap(paramViewGroup.getLevelLayout(), ((LevelInterface)localObject1).getLevelImageResource(), ((LevelInterface)localObject1).getLevelBackgroundResource());
                        break label653;
                      }
                      paramViewGroup.getLevelLayout().setBackgroundResource(((LevelInterface)localObject1).getLevelBackgroundResource());
                      break label653;
                      label1039:
                      paramViewGroup.getLevel().setText(((LevelInterface)localObject1).getCategory());
                      if (paramViewGroup.getLevelSubCategory() != null) {
                        if (((LevelInterface)localObject1).getSubCategory() != null)
                        {
                          paramViewGroup.getLevelSubCategory().setText(((LevelInterface)localObject1).getSubCategory());
                          paramViewGroup.getLevelSubCategory().setVisibility(0);
                        }
                        else
                        {
                          paramViewGroup.getLevelSubCategory().setVisibility(8);
                        }
                      }
                    }
                  }
                  catch (NoSuchFieldError localNoSuchFieldError1)
                  {
                    for (;;) {}
                  }
                }
                catch (NoSuchFieldError localNoSuchFieldError2)
                {
                  for (;;) {}
                }
              }
              catch (NoSuchFieldError localNoSuchFieldError3)
              {
                for (;;) {}
              }
            }
            catch (NoSuchFieldError localNoSuchFieldError4)
            {
              for (;;) {}
            }
          }
          catch (NoSuchFieldError localNoSuchFieldError5)
          {
            for (;;) {}
          }
        }
        catch (NoSuchFieldError localNoSuchFieldError6)
        {
          for (;;) {}
        }
      }
      catch (NoSuchFieldError localNoSuchFieldError7)
      {
        for (;;) {}
      }
    }
    catch (NoSuchFieldError paramViewGroup)
    {
      for (;;) {}
    }
  }
  
  static class ViewHolder
  {
    private ImageView bigLocklevel;
    private Button buttonLevel;
    private ImageView img;
    private TextView level;
    private View levelLayout;
    private View levelLayoutInner;
    private RelativeLayout levelLayoutOnClick;
    private TextView levelLogosCountTextView;
    private TextView levelProgressBarPercent;
    private RoundProgress levelProgressBarlevel;
    private TextView levelScoreTextView;
    private TextView levelSubCategory;
    private TextView lockedLevelContainer;
    private ImageView locklevel;
    private View unlockedLevelContainer;
    
    public ImageView getBigLocklevel()
    {
      return this.bigLocklevel;
    }
    
    public Button getButtonLevel()
    {
      return this.buttonLevel;
    }
    
    public ImageView getImg()
    {
      return this.img;
    }
    
    public TextView getLevel()
    {
      return this.level;
    }
    
    public View getLevelLayout()
    {
      return this.levelLayout;
    }
    
    public View getLevelLayoutInner()
    {
      return this.levelLayoutInner;
    }
    
    public RelativeLayout getLevelLayoutOnClick()
    {
      return this.levelLayoutOnClick;
    }
    
    public TextView getLevelLogosCountTextView()
    {
      return this.levelLogosCountTextView;
    }
    
    public TextView getLevelProgressBarPercent()
    {
      return this.levelProgressBarPercent;
    }
    
    public RoundProgress getLevelProgressBarlevel()
    {
      return this.levelProgressBarlevel;
    }
    
    public TextView getLevelScoreTextView()
    {
      return this.levelScoreTextView;
    }
    
    public TextView getLevelSubCategory()
    {
      return this.levelSubCategory;
    }
    
    public TextView getLockedLevelContainer()
    {
      return this.lockedLevelContainer;
    }
    
    public ImageView getLocklevel()
    {
      return this.locklevel;
    }
    
    public View getUnlockedLevelContainer()
    {
      return this.unlockedLevelContainer;
    }
    
    public void setBigLocklevel(ImageView paramImageView)
    {
      this.bigLocklevel = paramImageView;
    }
    
    public void setButtonLevel(Button paramButton)
    {
      this.buttonLevel = paramButton;
    }
    
    public void setImg(ImageView paramImageView)
    {
      this.img = paramImageView;
    }
    
    public void setLevel(TextView paramTextView)
    {
      this.level = paramTextView;
    }
    
    public void setLevelLayout(View paramView)
    {
      this.levelLayout = paramView;
    }
    
    public void setLevelLayoutInner(View paramView)
    {
      this.levelLayoutInner = paramView;
    }
    
    public void setLevelLayoutOnClick(RelativeLayout paramRelativeLayout)
    {
      this.levelLayoutOnClick = paramRelativeLayout;
    }
    
    public void setLevelLogosCountTextView(TextView paramTextView)
    {
      this.levelLogosCountTextView = paramTextView;
    }
    
    public void setLevelProgressBarPercent(TextView paramTextView)
    {
      this.levelProgressBarPercent = paramTextView;
    }
    
    public void setLevelProgressBarlevel(RoundProgress paramRoundProgress)
    {
      this.levelProgressBarlevel = paramRoundProgress;
    }
    
    public void setLevelScoreTextView(TextView paramTextView)
    {
      this.levelScoreTextView = paramTextView;
    }
    
    public void setLevelSubCategory(TextView paramTextView)
    {
      this.levelSubCategory = paramTextView;
    }
    
    public void setLockedLevelContainer(TextView paramTextView)
    {
      this.lockedLevelContainer = paramTextView;
    }
    
    public void setLocklevel(ImageView paramImageView)
    {
      this.locklevel = paramImageView;
    }
    
    public void setUnlockedLevelContainer(View paramView)
    {
      this.unlockedLevelContainer = paramView;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/LevelListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */