package com.google.android.gms.plus.model.people;

import com.google.android.gms.common.data.Freezable;
import java.util.List;

public abstract interface Person
  extends Freezable<Person>
{
  public abstract String getAboutMe();
  
  public abstract Person.AgeRange getAgeRange();
  
  public abstract String getBirthday();
  
  public abstract String getBraggingRights();
  
  public abstract int getCircledByCount();
  
  public abstract Person.Cover getCover();
  
  public abstract String getCurrentLocation();
  
  public abstract String getDisplayName();
  
  public abstract int getGender();
  
  public abstract String getId();
  
  public abstract Person.Image getImage();
  
  public abstract String getLanguage();
  
  public abstract Person.Name getName();
  
  public abstract String getNickname();
  
  public abstract int getObjectType();
  
  public abstract List<Person.Organizations> getOrganizations();
  
  public abstract List<Person.PlacesLived> getPlacesLived();
  
  public abstract int getPlusOneCount();
  
  public abstract int getRelationshipStatus();
  
  public abstract String getTagline();
  
  public abstract String getUrl();
  
  public abstract List<Person.Urls> getUrls();
  
  public abstract boolean hasAboutMe();
  
  public abstract boolean hasAgeRange();
  
  public abstract boolean hasBirthday();
  
  public abstract boolean hasBraggingRights();
  
  public abstract boolean hasCircledByCount();
  
  public abstract boolean hasCover();
  
  public abstract boolean hasCurrentLocation();
  
  public abstract boolean hasDisplayName();
  
  public abstract boolean hasGender();
  
  public abstract boolean hasId();
  
  public abstract boolean hasImage();
  
  public abstract boolean hasIsPlusUser();
  
  public abstract boolean hasLanguage();
  
  public abstract boolean hasName();
  
  public abstract boolean hasNickname();
  
  public abstract boolean hasObjectType();
  
  public abstract boolean hasOrganizations();
  
  public abstract boolean hasPlacesLived();
  
  public abstract boolean hasPlusOneCount();
  
  public abstract boolean hasRelationshipStatus();
  
  public abstract boolean hasTagline();
  
  public abstract boolean hasUrl();
  
  public abstract boolean hasUrls();
  
  public abstract boolean hasVerified();
  
  public abstract boolean isPlusUser();
  
  public abstract boolean isVerified();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/plus/model/people/Person.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */