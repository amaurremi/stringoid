package com.mopub.mobileads;

class MraidPlacementTypeProperty
  extends MraidProperty
{
  private final MraidView.PlacementType mPlacementType;
  
  MraidPlacementTypeProperty(MraidView.PlacementType paramPlacementType)
  {
    this.mPlacementType = paramPlacementType;
  }
  
  public static MraidPlacementTypeProperty createWithType(MraidView.PlacementType paramPlacementType)
  {
    return new MraidPlacementTypeProperty(paramPlacementType);
  }
  
  public String toJsonPair()
  {
    return "placementType: '" + this.mPlacementType.toString().toLowerCase() + "'";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/MraidPlacementTypeProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */