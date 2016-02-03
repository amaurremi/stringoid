package mobi.beyondpod.aggregators.feedly;

import com.google.gson.stream.JsonReader;
import java.io.IOException;
import mobi.beyondpod.aggregators.GDataObject;
import mobi.beyondpod.aggregators.GDataObjectList;

public class FeedlySubscriptionsParser
{
  static GDataObject ParseSubscriptions(JsonReader paramJsonReader)
    throws IOException
  {
    GDataObject localGDataObject = new GDataObject();
    localGDataObject.List = new GDataObjectList();
    localGDataObject.List.Name = "User Subscriptions";
    paramJsonReader.beginArray();
    for (;;)
    {
      if (!paramJsonReader.hasNext())
      {
        paramJsonReader.endArray();
        return localGDataObject;
      }
      localGDataObject.List.add(readSubscription(paramJsonReader));
    }
  }
  
  static void readCategories(JsonReader paramJsonReader, GDataObject paramGDataObject)
    throws IOException
  {
    if (paramGDataObject.List == null) {
      paramGDataObject.List = new GDataObjectList();
    }
    paramGDataObject.List.Name = "Categories";
    paramJsonReader.beginArray();
    for (;;)
    {
      if (!paramJsonReader.hasNext())
      {
        paramJsonReader.endArray();
        return;
      }
      paramGDataObject.List.add(readCategory(paramJsonReader));
    }
  }
  
  private static GDataObject readCategory(JsonReader paramJsonReader)
    throws IOException
  {
    GDataObject localGDataObject = new GDataObject();
    paramJsonReader.beginObject();
    for (;;)
    {
      if (!paramJsonReader.hasNext())
      {
        paramJsonReader.endObject();
        return localGDataObject;
      }
      String str = paramJsonReader.nextName();
      if (str.equals("id")) {
        localGDataObject.ID = paramJsonReader.nextString();
      } else if (str.equals("label")) {
        localGDataObject.Label = paramJsonReader.nextString();
      } else {
        paramJsonReader.skipValue();
      }
    }
  }
  
  private static GDataObject readSubscription(JsonReader paramJsonReader)
    throws IOException
  {
    GDataObject localGDataObject = new GDataObject();
    paramJsonReader.beginObject();
    for (;;)
    {
      if (!paramJsonReader.hasNext())
      {
        paramJsonReader.endObject();
        return localGDataObject;
      }
      String str = paramJsonReader.nextName();
      if (str.equals("id")) {
        localGDataObject.ID = paramJsonReader.nextString();
      } else if (str.equals("title")) {
        localGDataObject.Title = paramJsonReader.nextString();
      } else if (str.equals("categories")) {
        readCategories(paramJsonReader, localGDataObject);
      } else {
        paramJsonReader.skipValue();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/aggregators/feedly/FeedlySubscriptionsParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */