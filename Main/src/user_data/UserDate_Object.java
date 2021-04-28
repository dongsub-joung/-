package user_data;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NavigableMap;

public class UserDate_Object
{
    private static int count= 0;
    private static HashMap info;

    public UserDate_Object(){}
    public UserDate_Object(String ID, String name, String PH, String bookName)
    {
        String[] list= {ID, name, PH, bookName};

        info= new HashMap();
        info.put(++count, list);
    }

    //	Getter

    public static HashMap getInfo() { return info; }
}