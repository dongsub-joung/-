package books_data;

import java.util.ArrayList;

public class DataArray
{
    private String bookName
            , publishingCompany
            , author
            , translator
            , amount
            , location;

    private static ArrayList<String> bookNames= new ArrayList<>()
            , authors= new ArrayList<>()
            , publishingCompanys= new ArrayList<>()
            , translators= new ArrayList<>()
            , amounts= new ArrayList<>()
            , locations = new ArrayList<>();

    { bookName= ""; publishingCompany= ""; author=""; translator= ""; amount= ""; location= ""; }


    //	Getter ArrayList static classValuable:
    public static ArrayList<String> getBookNames(){ return bookNames; }
    public static ArrayList<String> getAuthors(){ return authors; }
    public static ArrayList<String> getPublishingCompanys(){ return publishingCompanys; }
    public static ArrayList<String> getTranslators(){ return translators; }
    public static ArrayList<String> getAmounts(){ return amounts; }
    public static ArrayList<String> getLocations() { return locations; }

    public String getBookName() {
        return bookName;
    }
    public String getPublishingCompany() {
        return publishingCompany;
    }
    public String getAuthor() {
        return author;
    }
    public String getTranslator() {
        return translator;
    }
    public String getAmount() {
        return amount;
    }
    public String getLocation() {
        return location;
    }

    //	Getter Single String classValuable
    public String getSingleValue(String type, int index)
    {
        String result= "";
        switch(type)
        {
            case "bookName":
                result= getBookNames().get(index);
                break;
            case "author":
                result= getAuthors().get(index);
                break;
            case "publishingCompany":
                result= getPublishingCompanys().get(index);
                break;
            case "translator":
                result= getTranslators().get(index);
                break;
            case "amount":
                result= getAmounts().get(index);
                break;
            case "location":
                result= getLocations().get(index);
                break;
            default:
                result= " Null ";
                break;
        }
        return result;
    }



//    public String getBookName() { return bookName; }
//    public String retunr_author() { return author; }
//    public String retunr_publishing() { return publishingCompany; }
//    public String retunr_translator() { return translator; }
//    public String retunr_amount() { return amount; }
}
