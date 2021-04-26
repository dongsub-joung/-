package user_data;

public class UserDate_Object
{
    private String personNum,  name, phonNum, bookTitle;;
    { personNum= ""; name= ""; phonNum= ""; bookTitle= ""; }

    public UserDate_Object(){}
    public UserDate_Object(String ID, String name, String PH, String bookName)
    {
        this.personNum = ID;
        this.name = name;
        this.phonNum = PH;
        this.bookTitle = bookName;
    }

    //	Getter
    public String getPersonNum() {
        return personNum;
    }

    public String getName() {
        return name;
    }

    public String getPhonNum() {
        return phonNum;
    }

    public String getBookTitle() {
        return bookTitle;
    }
}