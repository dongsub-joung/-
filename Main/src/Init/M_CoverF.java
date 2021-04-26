package Init;

import books_data.searchF_other;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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
    static searchF_bookName search_book = new searchF_bookName();

    private static String checkAmount(String amount)
    {
        if(amount == "nell") return "1";
        else return amount;
    }
    public static void SearchEvent(JTextField textField, JTextField textField_1, JTextArea textArea)
    {
//        Get input TEXT
        String input = textField.getText();

        int index = search_book.return_ResultIndex(input);
        searchF_other other = new searchF_other(index);

        String bookName = search_book.return_bookName(index) + System.lineSeparator();;
        String author = other.retunr_author() + System.lineSeparator();
        String translator= other.retunr_translator() + System.lineSeparator();
        String publishingCompany = other.retunr_publishing() + System.lineSeparator();
        String amount = other.retunr_amount();
        final String RESULT= "Title: " + bookName + "Author: "+author + "translator: " + translator + "PublishingCompany: "+ publishingCompany;

        textField_1.setText(checkAmount(amount));
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
        catch (Exception e) {
            System.out.println("Fail Saving user data.");
            e.printStackTrace();
        }
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
