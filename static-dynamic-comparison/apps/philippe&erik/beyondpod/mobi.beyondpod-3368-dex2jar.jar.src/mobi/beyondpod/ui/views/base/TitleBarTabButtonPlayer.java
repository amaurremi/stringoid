package mobi.beyondpod.ui.views.base;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.R.styleable;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.CoreHelper.TrackSizeInfo;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.services.player.PlayList;
import mobi.beyondpod.ui.commands.CommandManager;

public class TitleBarTabButtonPlayer
  extends FrameLayout
  implements TitleBarBase.ISelectableTab
{
  ImageView _DropDownIndicator;
  float _DropDownOffest;
  boolean _IsActive = false;
  TextView _NumPlaylist;
  private Animation _PlayListChangedAnimation;
  View.OnClickListener _PlayerActiveClickListener;
  ImageView _PlayerButtonImage;
  TextView _PlayerButtonText;
  View.OnClickListener _PlayerClickListener;
  View.OnLongClickListener _PlayerLongClickListener = new View.OnLongClickListener()
  {
    public boolean onLongClick(View paramAnonymousView)
    {
      CommandManager.CmdOpenManagePlaylistView(false);
      return true;
    }
  };
  float _PlaylistImageOffest;
  Drawable _RightBackground;
  Drawable _RightBackgroundSelected;
  TextView _SubTitle;
  float _SubTitleBottomMargin;
  TextView _Title;
  float _TitleBottomMargin;
  TextView _TitleLabel;
  
  public TitleBarTabButtonPlayer(Context paramContext)
  {
    super(paramContext);
  }
  
  public TitleBarTabButtonPlayer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void HideTtitleLabel()
  {
    FrameLayout.LayoutParams localLayoutParams1 = (FrameLayout.LayoutParams)this._SubTitle.getLayoutParams();
    FrameLayout.LayoutParams localLayoutParams2 = (FrameLayout.LayoutParams)this._Title.getLayoutParams();
    localLayoutParams1.gravity = 16;
    localLayoutParams1.bottomMargin = 0;
    localLayoutParams2.gravity = 16;
    localLayoutParams2.bottomMargin = 0;
    this._TitleLabel.setVisibility(8);
  }
  
  private void ShowTtitleLabel()
  {
    FrameLayout.LayoutParams localLayoutParams1 = (FrameLayout.LayoutParams)this._SubTitle.getLayoutParams();
    FrameLayout.LayoutParams localLayoutParams2 = (FrameLayout.LayoutParams)this._Title.getLayoutParams();
    localLayoutParams1.gravity = 80;
    localLayoutParams1.bottomMargin = ((int)this._SubTitleBottomMargin);
    localLayoutParams2.gravity = 80;
    localLayoutParams2.bottomMargin = ((int)this._TitleBottomMargin);
    this._TitleLabel.setVisibility(0);
  }
  
  private void UpdatePlayerButton()
  {
    int j = 0;
    Object localObject = Integer.toString(BeyondPodApplication.GetInstance().PlayList().PlaylistSize());
    String str = this._NumPlaylist.getText().toString();
    if ((!StringUtils.IsNullOrEmpty(str)) && (!StringUtils.Equals("0", str)) && (!StringUtils.Equals(str, (String)localObject)))
    {
      i = 1;
      this._NumPlaylist.setText((CharSequence)localObject);
      if (!this._IsActive) {
        break label150;
      }
      this._PlayerButtonText.setVisibility(8);
      this._PlayerButtonImage.setVisibility(8);
      this._NumPlaylist.setPadding(0, 0, 0, 0);
      this._NumPlaylist.setVisibility(8);
      localObject = this._SubTitle;
      if (PlayList.IsEmpty()) {
        break label144;
      }
    }
    label144:
    for (int i = j;; i = 8)
    {
      ((TextView)localObject).setVisibility(i);
      UpdateTitleLabel();
      return;
      i = 0;
      break;
    }
    label150:
    if (PlayList.IsEmpty())
    {
      j = 0;
      label158:
      this._SubTitle.setVisibility(8);
      localObject = this._NumPlaylist;
      if (j == 0) {
        break label294;
      }
      k = 0;
      label179:
      ((TextView)localObject).setVisibility(k);
      localObject = this._PlayerButtonImage;
      if (j == 0) {
        break label300;
      }
      k = 0;
      label197:
      ((ImageView)localObject).setVisibility(k);
      localObject = this._PlayerButtonText;
      if (j == 0) {
        break label306;
      }
    }
    label294:
    label300:
    label306:
    for (int k = 8;; k = 0)
    {
      ((TextView)localObject).setVisibility(k);
      if (j == 0) {
        break;
      }
      positionPlaylist(17);
      this._PlayerButtonImage.setPadding(0, 0, 0, 0);
      this._PlayerButtonImage.setVisibility(8);
      this._NumPlaylist.setPadding(0, 0, 0, 0);
      if (i == 0) {
        break;
      }
      this._NumPlaylist.postDelayed(new Runnable()
      {
        public void run()
        {
          TitleBarTabButtonPlayer.this._NumPlaylist.startAnimation(TitleBarTabButtonPlayer.this._PlayListChangedAnimation);
        }
      }, 100L);
      break;
      j = 1;
      break label158;
      k = 8;
      break label179;
      k = 8;
      break label197;
    }
  }
  
  private void UpdateTitleLabel()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this._IsActive)
    {
      CoreHelper.TrackSizeInfo localTrackSizeInfo = BeyondPodApplication.GetInstance().PlayList().PlaylistTotalTime();
      localObject1 = localObject2;
      if (localTrackSizeInfo.TotalTime > 0L) {
        if (localTrackSizeInfo.TotalTimeIsApproximate)
        {
          localObject1 = localObject2;
          if (localTrackSizeInfo.TotalTime <= 200L) {}
        }
        else
        {
          if (!localTrackSizeInfo.TotalTimeIsApproximate) {
            break label113;
          }
          localObject1 = "~";
          localObject1 = String.format("%s%s", new Object[] { localObject1, CoreHelper.GetApproximateTimeDurationAsString(localTrackSizeInfo.TotalTime * 1000L, false) });
        }
      }
    }
    if (StringUtils.IsNullOrEmpty((String)localObject1)) {
      if (this._TitleLabel.getVisibility() == 0) {
        HideTtitleLabel();
      }
    }
    label113:
    do
    {
      return;
      localObject1 = "";
      break;
      this._TitleLabel.setText((CharSequence)localObject1);
    } while (this._TitleLabel.getVisibility() == 0);
    ShowTtitleLabel();
  }
  
  private void positionPlaylist(int paramInt)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this._NumPlaylist.getLayoutParams();
    localLayoutParams.gravity = paramInt;
    this._NumPlaylist.setLayoutParams(localLayoutParams);
  }
  
  public void Initialize()
  {
    this._PlayerButtonImage = ((ImageView)findViewById(2131230878));
    this._PlayerButtonText = ((TextView)findViewById(2131230877));
    this._Title = ((TextView)findViewById(2131230880));
    this._SubTitle = ((TextView)findViewById(2131230873));
    this._TitleLabel = ((TextView)findViewById(2131230872));
    this._NumPlaylist = ((TextView)findViewById(2131230879));
    this._DropDownIndicator = ((ImageView)findViewById(2131230874));
    this._PlayListChangedAnimation = AnimationUtils.loadAnimation(getContext(), 2130968589);
    this._DropDownOffest = TypedValue.applyDimension(1, 5.0F, getResources().getDisplayMetrics());
    this._PlaylistImageOffest = TypedValue.applyDimension(1, 23.0F, getResources().getDisplayMetrics());
    TypedArray localTypedArray = getContext().obtainStyledAttributes(R.styleable.TitleButtons);
    this._RightBackground = localTypedArray.getDrawable(8);
    this._RightBackgroundSelected = localTypedArray.getDrawable(10);
    localTypedArray.recycle();
    setOnLongClickListener(this._PlayerLongClickListener);
    this._TitleBottomMargin = getResources().getDimension(2131492917);
    this._SubTitleBottomMargin = getResources().getDimension(2131492918);
    ((FrameLayout.LayoutParams)this._DropDownIndicator.getLayoutParams()).bottomMargin = ((int)(this._SubTitleBottomMargin * 0.7D));
    setActive(false);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    Initialize();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = Math.min(getWidth() - this._SubTitle.getWidth() - 15, this._Title.getRight());
    this._Title.layout(this._Title.getLeft(), this._Title.getTop(), paramInt1, this._Title.getBottom());
    this._SubTitle.layout(paramInt1, this._SubTitle.getTop(), this._SubTitle.getWidth() + paramInt1, this._SubTitle.getBottom());
  }
  
  public void refresh()
  {
    UpdatePlayerButton();
  }
  
  public void setActive(boolean paramBoolean)
  {
    this._IsActive = paramBoolean;
    if (paramBoolean)
    {
      this._Title.setVisibility(0);
      if (this._DropDownIndicator.getVisibility() == 8) {
        this._DropDownIndicator.postDelayed(new Runnable()
        {
          public void run()
          {
            TitleBarTabButtonPlayer.this._DropDownIndicator.setVisibility(0);
          }
        }, 250L);
      }
      setOnClickListener(this._PlayerActiveClickListener);
      setBackgroundDrawable(this._RightBackgroundSelected);
    }
    for (;;)
    {
      UpdatePlayerButton();
      return;
      this._Title.setVisibility(8);
      this._DropDownIndicator.setVisibility(8);
      setOnClickListener(this._PlayerClickListener);
      setBackgroundDrawable(this._RightBackground);
    }
  }
  
  public void setActiveOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this._PlayerActiveClickListener = paramOnClickListener;
  }
  
  public void setInactiveOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this._PlayerClickListener = paramOnClickListener;
  }
  
  public void setReadOnly(boolean paramBoolean) {}
  
  public void setTitle(TitleBarBase.TitleInfo paramTitleInfo)
  {
    TextView localTextView = this._Title;
    Object localObject;
    if (paramTitleInfo.PrimaryTitle != null)
    {
      localObject = paramTitleInfo.PrimaryTitle;
      localTextView.setText((CharSequence)localObject);
      localObject = this._SubTitle;
      if (paramTitleInfo.SubTitle == null) {
        break label51;
      }
    }
    label51:
    for (paramTitleInfo = paramTitleInfo.SubTitle;; paramTitleInfo = "")
    {
      ((TextView)localObject).setText(paramTitleInfo);
      return;
      localObject = "";
      break;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/base/TitleBarTabButtonPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */