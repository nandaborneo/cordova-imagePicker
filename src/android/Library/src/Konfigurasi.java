package com.synconset;

public class Konfigurasi {

  // color section for imagepicker
  // if u want to adding color add the value at folder res/values/colors.xml
  public static String selectedColor = "bootstrap_brand_info";

  public static String numberSelectedColor = "bootstrap_brand_danger";
  public static String numberBorderSelectedColor = "bootstrap_gray_lightest";
  public static String numberTextColor = "bootstrap_brand_text_black";
  // value from 0 to 100 as percentage
  public static int numberTextOpacity = 100;

  //stroke size border number value using density pixel
  public static int borderSize = 2;

  //font size using scale-independent pixels for responsive font size when different screen size
  public static int fontSize = 14;

  //change font style
  // the value based the file on res/font without .tff extention ex : myfont.tff then the value myfont
  // the filename custom font only allowed lowercase a-z number 0-9 and underscores without space
  public static String fontType = "myfont";
}
