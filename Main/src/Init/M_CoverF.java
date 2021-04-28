package Init;

import books_data.DataArray;
import books_data.SearchValueAndSave;
import books_data.volume;
import books_data.BookNameList;
import user_data.UserDate_Object;
import user_data.User;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


/*
    Components
*/
class FONTS
{
    final static String FONT00= "Arial Black";
    final static String FONT01=  "맑은 고딕";
    final static String FONT02= "돋음";
    final static String FONT03= "돋음체";
}

class AboutTextArea
{
    public static void setOption(JTextArea textArea)
    {
        textArea.setEditable(false);
        textArea.setFont(new Font(FONTS.FONT01, Font.BOLD, 15));
        textArea.setForeground(Color.black);
        textArea.setAlignmentX(JPanel.CENTER_ALIGNMENT);
    }
}

class AboutJTextField
{
    public static void setOption(JTextField textField_1)
    {
        textField_1.setFont(new Font(FONTS.FONT02, Font.PLAIN, 15));
        textField_1.setEditable(false);
        textField_1.setColumns(10);
        textField_1.setHorizontalAlignment(JTextField.CENTER);
        textField_1.setForeground(Color.red);
    }
}

class AboutJLabel
{
    public static void setOption(JLabel lblNewLabel)
    {
        lblNewLabel.setFont(new Font(FONTS.FONT03, Font.PLAIN, 12));
        lblNewLabel.setBackground(Color.WHITE);
    }
}


public class M_CoverF
{
    private static DataArray data_arrays= new DataArray();

    static int searched_index= 0;

    public static void SearchEvent(JTextField textField, JTextField textField_1, JTextArea textArea)
    {
//        Get input TEXT
        String input = textField.getText();

        searched_index = data_arrays.getBookName().indexOf(input);
        SearchValueAndSave other = new SearchValueAndSave(searched_index);



        textField_1.setText(volume.checkAmount(amount));
        textArea.setText(RESULT);
    }

    public static void setChoiceValue(Choice choice)
    {
        choice.add("--------  Current Information  --------");
        try
        {
            checkOutF_get get = new checkOutF_get();
            ArrayList<String> ID = get.reId();
            ArrayList<String> BookName = get.reBookName();
            ArrayList<Boolean> SW = get.reSW();

            for(int i=0; i<=ID.size(); i++)
            {
                String a = ID.get(i);
                String b = BookName.get(i);
                boolean sw = SW.get(i);

                choice.add(a+" , "+b);

				/*
				if(sw==false)
				{
					String a = ID.get(i);
					String b = BookName.get(i);
					System.out.println("a"+a);
					System.out.println("b"+b);

					choice.add(a+" , "+b);
				}
				else
				{
					continue;
				}
				*/
            }
        }
        catch (Exception e) { System.out.println("Fail Saving user data."); e.printStackTrace(); }
    }


//    Delete XMl data or check data (removed remark)
    public static void clickEventNewButton_2(Choice choice)
    {
        // UI: Read current value
        String selectedVal = choice.getItem(choice.getSelectedIndex());
//				Divide String
        String[] String_array = selectedVal.split(" , ");

//				DB search using student_ID
//				than, Save "returned book" String
        String studentNum = String_array[0];
        String checkOut_case = String_array[1];
        checkOutF BookCase = new checkOutF();

//				Define: DB Data
        checkOutF_get get = new checkOutF_get();
        ArrayList<String> ID = get.reId();
        ArrayList<String> case_bookNum = get.reBookName();

//				index= indicate row searched
        int indexID= ID.indexOf(studentNum);
        int indexCase = case_bookNum.indexOf(checkOut_case);

        if (indexID == indexCase)
        {
            BookCase.toggleCheckOutValue();
            BookCase.insertData(indexID);
        }

//				Remove visual list (Implement)
        //choice.remove(choice.getSelectedIndex());
    }
}
