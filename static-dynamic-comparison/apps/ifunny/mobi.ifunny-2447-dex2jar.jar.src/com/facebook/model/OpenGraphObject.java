package com.facebook.model;

import java.util.Date;
import java.util.List;

public abstract interface OpenGraphObject
        extends GraphObject {
    public abstract GraphObject getApplication();

    public abstract GraphObjectList<GraphObject> getAudio();

    @PropertyName("fbsdk:create_object")
    public abstract boolean getCreateObject();

    public abstract Date getCreatedTime();

    public abstract GraphObject getData();

    public abstract String getDescription();

    public abstract String getDeterminer();

    public abstract String getId();

    public abstract GraphObjectList<GraphObject> getImage();

    public abstract boolean getIsScraped();

    public abstract String getPostActionId();

    public abstract List<String> getSeeAlso();

    public abstract String getSiteName();

    public abstract String getTitle();

    public abstract String getType();

    public abstract Date getUpdatedTime();

    public abstract String getUrl();

    public abstract GraphObjectList<GraphObject> getVideo();

    public abstract void setApplication(GraphObject paramGraphObject);

    public abstract void setAudio(GraphObjectList<GraphObject> paramGraphObjectList);

    @PropertyName("fbsdk:create_object")
    public abstract void setCreateObject(boolean paramBoolean);

    public abstract void setCreatedTime(Date paramDate);

    public abstract void setData(GraphObject paramGraphObject);

    public abstract void setDescription(String paramString);

    public abstract void setDeterminer(String paramString);

    public abstract void setId(String paramString);

    public abstract void setImage(GraphObjectList<GraphObject> paramGraphObjectList);

    @CreateGraphObject("url")
    @PropertyName("image")
    public abstract void setImageUrls(List<String> paramList);

    public abstract void setIsScraped(boolean paramBoolean);

    public abstract void setPostActionId(String paramString);

    public abstract void setSeeAlso(List<String> paramList);

    public abstract void setSiteName(String paramString);

    public abstract void setTitle(String paramString);

    public abstract void setType(String paramString);

    public abstract void setUpdatedTime(Date paramDate);

    public abstract void setUrl(String paramString);

    public abstract void setVideo(GraphObjectList<GraphObject> paramGraphObjectList);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/model/OpenGraphObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */