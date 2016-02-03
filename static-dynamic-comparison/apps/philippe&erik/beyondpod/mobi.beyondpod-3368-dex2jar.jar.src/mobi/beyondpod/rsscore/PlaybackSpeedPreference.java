package mobi.beyondpod.rsscore;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.preference.DialogPreference;
import android.preference.Preference.BaseSavedState;
import android.util.AttributeSet;
import android.view.View;
import mobi.beyondpod.rsscore.helpers.StringUtils;

public class PlaybackSpeedPreference
  extends DialogPreference
{
  int _DefaultSpeed;
  PlaybackSpeedControl _PlaybackSpeed;
  int _Speed;
  
  public PlaybackSpeedPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setDialogLayoutResource(2130903145);
  }
  
  public PlaybackSpeedPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setDialogLayoutResource(2130903145);
  }
  
  protected void onBindDialogView(View paramView)
  {
    super.onBindDialogView(paramView);
    this._PlaybackSpeed.initialize(this._Speed);
  }
  
  protected View onCreateDialogView()
  {
    View localView = super.onCreateDialogView();
    this._PlaybackSpeed = new PlaybackSpeedControl(localView);
    setPersistent(true);
    return localView;
  }
  
  protected void onDialogClosed(boolean paramBoolean)
  {
    super.onDialogClosed(paramBoolean);
    if (paramBoolean)
    {
      String str = String.valueOf(this._PlaybackSpeed.getSelectedSpeed() / 100.0F);
      if (callChangeListener(str))
      {
        persistString(str);
        int i = this._PlaybackSpeed.getSelectedSpeed();
        this._Speed = i;
        this._DefaultSpeed = i;
      }
      return;
    }
    this._Speed = this._DefaultSpeed;
  }
  
  protected Object onGetDefaultValue(TypedArray paramTypedArray, int paramInt)
  {
    return paramTypedArray.getString(paramInt);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable == null) || (!paramParcelable.getClass().equals(SavedState.class)))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    this._Speed = paramParcelable.value;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
  }
  
  protected Parcelable onSaveInstanceState()
  {
    Object localObject = super.onSaveInstanceState();
    if (this._PlaybackSpeed == null) {
      return (Parcelable)localObject;
    }
    localObject = new SavedState((Parcelable)localObject);
    ((SavedState)localObject).value = this._PlaybackSpeed.getSelectedSpeed();
    return (Parcelable)localObject;
  }
  
  protected void onSetInitialValue(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {}
    for (paramObject = getPersistedString((String)paramObject);; paramObject = (String)paramObject)
    {
      int i = Math.round(StringUtils.SafeParseFloat((String)paramObject, 1.0F) * 100.0F);
      this._DefaultSpeed = i;
      this._Speed = i;
      return;
    }
  }
  
  private static class SavedState
    extends Preference.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public PlaybackSpeedPreference.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new PlaybackSpeedPreference.SavedState(paramAnonymousParcel);
      }
      
      public PlaybackSpeedPreference.SavedState[] newArray(int paramAnonymousInt)
      {
        return new PlaybackSpeedPreference.SavedState[paramAnonymousInt];
      }
    };
    int value;
    
    public SavedState(Parcel paramParcel)
    {
      super();
      this.value = paramParcel.readInt();
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.value);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/PlaybackSpeedPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */