package com.drew.metadata.d;

import java.util.HashMap;

public class b
  extends com.drew.metadata.b
{
  protected static final HashMap<Integer, String> gb = new HashMap();
  
  static
  {
    gb.put(Integer.valueOf(256), "Enveloped Record Version");
    gb.put(Integer.valueOf(261), "Destination");
    gb.put(Integer.valueOf(276), "File Format");
    gb.put(Integer.valueOf(278), "File Version");
    gb.put(Integer.valueOf(286), "Service Identifier");
    gb.put(Integer.valueOf(296), "Envelope Number");
    gb.put(Integer.valueOf(306), "Product Identifier");
    gb.put(Integer.valueOf(316), "Envelope Priority");
    gb.put(Integer.valueOf(326), "Date Sent");
    gb.put(Integer.valueOf(336), "Time Sent");
    gb.put(Integer.valueOf(346), "Coded Character Set");
    gb.put(Integer.valueOf(356), "Unique Object Name");
    gb.put(Integer.valueOf(376), "ARM Identifier");
    gb.put(Integer.valueOf(378), "ARM Version");
    gb.put(Integer.valueOf(512), "Application Record Version");
    gb.put(Integer.valueOf(515), "Object Type Reference");
    gb.put(Integer.valueOf(516), "Object Attribute Reference");
    gb.put(Integer.valueOf(517), "Object Name");
    gb.put(Integer.valueOf(519), "Edit Status");
    gb.put(Integer.valueOf(520), "Editorial Update");
    gb.put(Integer.valueOf(522), "Urgency");
    gb.put(Integer.valueOf(524), "Subject Reference");
    gb.put(Integer.valueOf(527), "Category");
    gb.put(Integer.valueOf(532), "Supplemental Category(s)");
    gb.put(Integer.valueOf(534), "Fixture Identifier");
    gb.put(Integer.valueOf(537), "Keywords");
    gb.put(Integer.valueOf(538), "Content Location Code");
    gb.put(Integer.valueOf(539), "Content Location Name");
    gb.put(Integer.valueOf(542), "Release Date");
    gb.put(Integer.valueOf(547), "Release Time");
    gb.put(Integer.valueOf(549), "Expiration Date");
    gb.put(Integer.valueOf(550), "Expiration Time");
    gb.put(Integer.valueOf(552), "Special Instructions");
    gb.put(Integer.valueOf(554), "Action Advised");
    gb.put(Integer.valueOf(557), "Reference Service");
    gb.put(Integer.valueOf(559), "Reference Date");
    gb.put(Integer.valueOf(562), "Reference Number");
    gb.put(Integer.valueOf(567), "Date Created");
    gb.put(Integer.valueOf(572), "Time Created");
    gb.put(Integer.valueOf(574), "Digital Date Created");
    gb.put(Integer.valueOf(575), "Digital Time Created");
    gb.put(Integer.valueOf(577), "Originating Program");
    gb.put(Integer.valueOf(582), "Program Version");
    gb.put(Integer.valueOf(587), "Object Cycle");
    gb.put(Integer.valueOf(592), "By-line");
    gb.put(Integer.valueOf(597), "By-line Title");
    gb.put(Integer.valueOf(602), "City");
    gb.put(Integer.valueOf(604), "Sub-location");
    gb.put(Integer.valueOf(607), "Province/State");
    gb.put(Integer.valueOf(612), "Country/Primary Location Code");
    gb.put(Integer.valueOf(613), "Country/Primary Location Name");
    gb.put(Integer.valueOf(615), "Original Transmission Reference");
    gb.put(Integer.valueOf(617), "Headline");
    gb.put(Integer.valueOf(622), "Credit");
    gb.put(Integer.valueOf(627), "Source");
    gb.put(Integer.valueOf(628), "Copyright Notice");
    gb.put(Integer.valueOf(630), "Contact");
    gb.put(Integer.valueOf(632), "Caption/Abstract");
    gb.put(Integer.valueOf(633), "Local Caption");
    gb.put(Integer.valueOf(634), "Caption Writer/Editor");
    gb.put(Integer.valueOf(637), "Rasterized Caption");
    gb.put(Integer.valueOf(642), "Image Type");
    gb.put(Integer.valueOf(643), "Image Orientation");
    gb.put(Integer.valueOf(647), "Language Identifier");
    gb.put(Integer.valueOf(662), "Audio Type");
    gb.put(Integer.valueOf(663), "Audio Sampling Rate");
    gb.put(Integer.valueOf(664), "Audio Sampling Resolution");
    gb.put(Integer.valueOf(665), "Audio Duration");
    gb.put(Integer.valueOf(666), "Audio Outcue");
    gb.put(Integer.valueOf(696), "Job Identifier");
    gb.put(Integer.valueOf(697), "Master Document Identifier");
    gb.put(Integer.valueOf(698), "Short Document Identifier");
    gb.put(Integer.valueOf(699), "Unique Document Identifier");
    gb.put(Integer.valueOf(700), "Owner Identifier");
    gb.put(Integer.valueOf(712), "Object Data Preview File Format");
    gb.put(Integer.valueOf(713), "Object Data Preview File Format Version");
    gb.put(Integer.valueOf(714), "Object Data Preview Data");
  }
  
  public b()
  {
    a(new a(this));
  }
  
  protected HashMap<Integer, String> aA()
  {
    return gb;
  }
  
  public String getName()
  {
    return "Iptc";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */