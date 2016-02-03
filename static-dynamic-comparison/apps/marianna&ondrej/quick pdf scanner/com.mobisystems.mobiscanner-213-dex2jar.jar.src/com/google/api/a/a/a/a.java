package com.google.api.a.a.a;

import com.google.api.client.json.b;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.o;
import java.util.List;
import java.util.Map;

public final class a
  extends b
{
  @o
  private String alternateLink;
  @o
  private Boolean appDataContents;
  @o
  private Boolean copyable;
  @o
  private DateTime createdDate;
  @o
  private String defaultOpenWithLink;
  @o
  private String description;
  @o
  private String downloadUrl;
  @o
  private Boolean editable;
  @o
  private String embedLink;
  @o
  private String etag;
  @o
  private Boolean explicitlyTrashed;
  @o
  private Map<String, String> exportLinks;
  @o
  private String fileExtension;
  @com.google.api.client.json.i
  @o
  private Long fileSize;
  @o
  private String headRevisionId;
  @o
  private String iconLink;
  @o
  private String id;
  @o
  private a imageMediaMetadata;
  @o
  private b indexableText;
  @o
  private String kind;
  @o
  private c labels;
  @o
  private f lastModifyingUser;
  @o
  private String lastModifyingUserName;
  @o
  private DateTime lastViewedByMeDate;
  @o
  private String md5Checksum;
  @o
  private String mimeType;
  @o
  private DateTime modifiedByMeDate;
  @o
  private DateTime modifiedDate;
  @o
  private Map<String, String> openWithLinks;
  @o
  private String originalFilename;
  @o
  private List<String> ownerNames;
  @o
  private List<f> owners;
  @o
  private List<c> parents;
  @o
  private List<e> properties;
  @com.google.api.client.json.i
  @o
  private Long quotaBytesUsed;
  @o
  private String selfLink;
  @o
  private Boolean shared;
  @o
  private DateTime sharedWithMeDate;
  @o
  private d thumbnail;
  @o
  private String thumbnailLink;
  @o
  private String title;
  @o
  private d userPermission;
  @o
  private String webContentLink;
  @o
  private String webViewLink;
  @o
  private Boolean writersCanShare;
  
  static
  {
    com.google.api.client.util.i.j(f.class);
    com.google.api.client.util.i.j(c.class);
    com.google.api.client.util.i.j(e.class);
  }
  
  public a cG(String paramString)
  {
    this.mimeType = paramString;
    return this;
  }
  
  public a cH(String paramString)
  {
    this.title = paramString;
    return this;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public a n(String paramString, Object paramObject)
  {
    return (a)super.set(paramString, paramObject);
  }
  
  public Map<String, String> zb()
  {
    return this.exportLinks;
  }
  
  public a zc()
  {
    return (a)super.clone();
  }
  
  public static final class a
    extends b
  {
    @o
    private Float aperture;
    @o
    private String cameraMake;
    @o
    private String cameraModel;
    @o
    private String colorSpace;
    @o
    private String date;
    @o
    private Float exposureBias;
    @o
    private String exposureMode;
    @o
    private Float exposureTime;
    @o
    private Boolean flashUsed;
    @o
    private Float focalLength;
    @o
    private Integer height;
    @o
    private Integer isoSpeed;
    @o
    private String lens;
    @o
    private a location;
    @o
    private Float maxApertureValue;
    @o
    private String meteringMode;
    @o
    private Integer rotation;
    @o
    private String sensor;
    @o
    private Integer subjectDistance;
    @o
    private String whiteBalance;
    @o
    private Integer width;
    
    public a o(String paramString, Object paramObject)
    {
      return (a)super.set(paramString, paramObject);
    }
    
    public a zd()
    {
      return (a)super.clone();
    }
    
    public static final class a
      extends b
    {
      @o
      private Double altitude;
      @o
      private Double latitude;
      @o
      private Double longitude;
      
      public a p(String paramString, Object paramObject)
      {
        return (a)super.set(paramString, paramObject);
      }
      
      public a ze()
      {
        return (a)super.clone();
      }
    }
  }
  
  public static final class b
    extends b
  {
    @o
    private String text;
    
    public b q(String paramString, Object paramObject)
    {
      return (b)super.set(paramString, paramObject);
    }
    
    public b zf()
    {
      return (b)super.clone();
    }
  }
  
  public static final class c
    extends b
  {
    @o
    private Boolean hidden;
    @o
    private Boolean restricted;
    @o
    private Boolean starred;
    @o
    private Boolean trashed;
    @o
    private Boolean viewed;
    
    public c clone()
    {
      return (c)super.clone();
    }
    
    public Boolean getHidden()
    {
      return this.hidden;
    }
    
    public Boolean getRestricted()
    {
      return this.restricted;
    }
    
    public Boolean getStarred()
    {
      return this.starred;
    }
    
    public Boolean getTrashed()
    {
      return this.trashed;
    }
    
    public Boolean getViewed()
    {
      return this.viewed;
    }
    
    public c set(String paramString, Object paramObject)
    {
      return (c)super.set(paramString, paramObject);
    }
    
    public c setHidden(Boolean paramBoolean)
    {
      this.hidden = paramBoolean;
      return this;
    }
    
    public c setRestricted(Boolean paramBoolean)
    {
      this.restricted = paramBoolean;
      return this;
    }
    
    public c setStarred(Boolean paramBoolean)
    {
      this.starred = paramBoolean;
      return this;
    }
    
    public c setTrashed(Boolean paramBoolean)
    {
      this.trashed = paramBoolean;
      return this;
    }
    
    public c setViewed(Boolean paramBoolean)
    {
      this.viewed = paramBoolean;
      return this;
    }
  }
  
  public static final class d
    extends b
  {
    @o
    private String image;
    @o
    private String mimeType;
    
    public d r(String paramString, Object paramObject)
    {
      return (d)super.set(paramString, paramObject);
    }
    
    public d zg()
    {
      return (d)super.clone();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/a/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */