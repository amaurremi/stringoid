package mobi.beyondpod.aggregators;

public class GDataObject
{
  public String ID;
  public String Label;
  public GDataObjectList List;
  public String Title;
  
  public String GetIDAsUrl()
  {
    if (this.ID.length() > 5) {
      return this.ID.substring(5);
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/aggregators/GDataObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */