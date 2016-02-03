package mobi.beyondpod.ui.views.impexp;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FeedSearchResult
  implements Parcelable
{
  public static final Parcelable.Creator<FeedSearchResult> CREATOR = new Parcelable.Creator()
  {
    public FeedSearchResult createFromParcel(Parcel paramAnonymousParcel)
    {
      return new FeedSearchResult(paramAnonymousParcel);
    }
    
    public FeedSearchResult[] newArray(int paramAnonymousInt)
    {
      return new FeedSearchResult[paramAnonymousInt];
    }
  };
  private String _Description;
  private String _EpisodeUrl;
  private String _ImageUrl;
  private String _Language;
  private String _Link;
  private String _OriginatingFeed;
  private String _Title;
  private String _TotalTime;
  private String _Type;
  
  public FeedSearchResult(Parcel paramParcel)
  {
    this._Title = paramParcel.readString();
    this._Type = paramParcel.readString();
    this._Link = paramParcel.readString();
    this._ImageUrl = paramParcel.readString();
    this._Description = paramParcel.readString();
    this._OriginatingFeed = paramParcel.readString();
    this._EpisodeUrl = paramParcel.readString();
    this._Language = paramParcel.readString();
    this._TotalTime = paramParcel.readString();
  }
  
  public FeedSearchResult(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    this._Title = paramString1;
    this._Type = paramString5;
    this._Link = paramString3;
    this._ImageUrl = paramString4;
    this._Description = paramString2;
    this._OriginatingFeed = paramString6;
    this._EpisodeUrl = paramString7;
    this._Language = paramString8;
    this._TotalTime = paramString9;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getDescription()
  {
    return this._Description;
  }
  
  public String getEpisodeUrl()
  {
    return this._EpisodeUrl;
  }
  
  public String getImageUrl()
  {
    return this._ImageUrl;
  }
  
  public String getLanguage()
  {
    return this._Language;
  }
  
  public String getLink()
  {
    return this._Link;
  }
  
  public String getOriginatingFeed()
  {
    return this._OriginatingFeed;
  }
  
  public String getTitle()
  {
    return this._Title;
  }
  
  public String getTotalTime()
  {
    return this._TotalTime;
  }
  
  public String getType()
  {
    return this._Type;
  }
  
  public void setDescription(String paramString)
  {
    this._Description = paramString;
  }
  
  public void setEpisodeUrl(String paramString)
  {
    this._EpisodeUrl = paramString;
  }
  
  public void setImageUrl(String paramString)
  {
    this._ImageUrl = paramString;
  }
  
  public void setLanguage(String paramString)
  {
    this._Language = paramString;
  }
  
  public void setLink(String paramString)
  {
    this._Link = paramString;
  }
  
  public void setOriginatingFeed(String paramString)
  {
    this._OriginatingFeed = paramString;
  }
  
  public void setTitle(String paramString)
  {
    this._Title = paramString;
  }
  
  public void setTotalTime(String paramString)
  {
    this._TotalTime = paramString;
  }
  
  public void setType(String paramString)
  {
    this._Type = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this._Title);
    paramParcel.writeString(this._Type);
    paramParcel.writeString(this._Link);
    paramParcel.writeString(this._ImageUrl);
    paramParcel.writeString(this._Description);
    paramParcel.writeString(this._OriginatingFeed);
    paramParcel.writeString(this._EpisodeUrl);
    paramParcel.writeString(this._Language);
    paramParcel.writeString(this._TotalTime);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/impexp/FeedSearchResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */