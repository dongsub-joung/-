package UserData;

public class UserDate
{
    private String personNum,  name, phonNum, bookTitle;;
    { personNum= ""; name= ""; phonNum= ""; bookTitle= ""; }

    UserDate(){}
    UserDate(String ID, String name, String PH, String bookName)
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