package Init;

import user_data.UserDate_Object;

import javax.swing.*;

public class M_CoverF_secon
{
    public static void initCheckOutAndSaveUserData(JTextField... textField)
    {
//        Get value each file.
        final int TEXTFIELD= 0, TEXTFIELD_1= 1, TEXTFIELD_2= 2, TEXTFIELD_3= 3;

        String personData = textField[TEXTFIELD].getText();
        String name =       textField[TEXTFIELD_1].getText();
        String PHData =     textField[TEXTFIELD_2].getText();
        String bookTitle =  textField[TEXTFIELD_3].getText();

        UserDate_Object obj= new UserDate_Object(personData,name,PHData,bookTitle);
        int index= obj.getCount();
        obj.getInfo().get(index);

        JOptionPane.showMessageDialog(null, "Complete Check out. Enjoy.");

//				Reset Values
        resetJTextFieldValues(textField);
        textField.setText("");
        textField_1.setText("");
        textField_2.setText("");
        textField_3.setText("");
    }

    private static void resetJTextFieldValues(JTextField obj) { obj.setText(""); }
}
