
import java.awt.*;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.Book;
import java.util.ArrayList;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;



@SuppressWarnings("serial")
public class CoverF extends JFrame
{
	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;
	private JButton btnNewButton_1;
	static public Choice choice;
	private JButton btnNewButton_2;
	private JTextField textField_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				try
				{
					CoverF frame = new CoverF();
					frame.setVisible(true);
				} catch (Exception e) { e.printStackTrace(); }
			}
		});
	}

	
	/**
	 * Create the frame.
	 */
	public CoverF()
	{
//		Out Frame
		setTitle("\uC0AC\uD68C\uD559\uACFC \uB3C4\uC11C\uAD00\uB9AC \uD504\uB85C\uADF8\uB7A8");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

//	    START : SEARCH BTN
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
//		END : SEARCH BTN

//		Text Area : SEARCH
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyPressed(KeyEvent e) 
			{
				String input; int index;

				if (e.getKeyCode() == KeyEvent.VK_ENTER)
				{
//					Get input TEXT
					input = textField.getText();

					searchF_bookName search_book = new searchF_bookName();
					index = search_book.return_ResultIndex(input);
					String bookName = search_book.return_bookName(index) + System.lineSeparator();;
					searchF_other other = new searchF_other(index);
					
					String author = other.retunr_author() + System.lineSeparator();
					String translator= other.retunr_translator() + System.lineSeparator();
					String publishingCompany = other.retunr_publishing() + System.lineSeparator());
					String amount = other.retunr_amount();

					if(amount == "nell") amount = "1";
					textField_1.setText(amount);

					final String RESULT= "Title: " + bookName + "Author: "+author + "translator: " + translator + "PublishingCompany: "+ publishingCompany;
					textArea.setText(RESULT);
				}

			}
		});
		textField.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent event) {
			}
			public void inputMethodTextChanged(InputMethodEvent event) 
			{		
				textField.getText();
			}
		});	
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				Reset String
				textField.setText("");
			}
		});
//		END: Out Frame


//		BTN: Search book
		JButton btnNewButton = new JButton("\uAC80\uC0C9");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{	
				String input = textField.getText();

				searchF_bookName search_book = new searchF_bookName();
				int index = search_book.return_ResultIndex(input);

				String bookName = search_book.return_bookName(index) + System.lineSeparator();
				
				searchF_other other = new searchF_other(index);
				
				String author = other.retunr_author() + System.lineSeparator();
				String translator= other.retunr_translator() + System.lineSeparator();
				String publishingCompany = other.retunr_publishing() + System.lineSeparator();
				
				String amount = other.retunr_amount();
				if(amount == "nell") amount = "1";
				textField_1.setText(amount);

				final String RESULT= "Title: " + bookName + "Author: "+author + "translator: " + translator + "PublishingCompany: "+ publishingCompany;
				textArea.setText(RESULT);
			}
		});
		textField.setColumns(10);
		textField.setText("Please enter book's title");
		
		btnNewButton_1 = new JButton("\uB300\uCD9C");
		btnNewButton_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) 
			{
//				write && save Infomation
				CoverF_secon Frame2 = new CoverF_secon();
				Frame2.setVisible(isDisplayable()); 

			} // Check out btn
		});
		
		btnNewButton_2 = new JButton("\uBC18\uB0A9");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) //�ݳ� ��ư �̺�Ʈ
			{
//				Delete XMl data or check data (removed remark)

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
		});
		
		
//�����͸� �����ͼ� ǥ��
		choice = new Choice();
		choice.add("--------  Current Information  --------");
		try
		{
			checkOutF_get get = new checkOutF_get();
			ArrayList<String> ID = get.reId();
			ArrayList<String> BookName = get.reBookName();
			ArrayList<Boolean> SW = get.reSW();
			System.out.println("id"+ID);
			System.out.println("BN"+BookName);
			System.out.println("sw"+SW);
			
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
			System.out.println(e + "Fail Saving user data.");
		}
		// END: when user check out book, save it.
				

//		Show result page (Text area)
		final String FONT00= "Arial Black";
		final String FONT01=  "맑은 고딕";
		final String FONT02= "돋음";
		final String FONT03= "돋음체";

		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font(FONT01, Font.BOLD, 15));
		textArea.setForeground(Color.black); 
		textArea.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font(FONT02, Font.PLAIN, 15));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setHorizontalAlignment(JTextField.CENTER);
		textField_1.setForeground(Color.red);
		
		JLabel lblNewLabel = new JLabel("\uC218\uB7C9");
		lblNewLabel.setFont(new Font(FONT03, Font.PLAIN, 12));
		lblNewLabel.setBackground(Color.WHITE);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(btnNewButton)
					.addGap(5)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 362, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(btnNewButton_1)
					.addGap(17)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(btnNewButton_2)
					.addGap(5)
					.addComponent(choice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(67)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 362, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton_1)
							.addGap(5)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_2)
								.addComponent(choice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel)))
					.addGap(5)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
//		END: Show Result
	}


	class secF extends JDialog
	{
		JLabel jib = new JLabel("");
		public secF(String str)
		{
			getContentPane().add(jib);
			
			jib.setText(str.toString());
			
			this.setSize(200,100);
			this.setModal(true);
			this.setVisible(true);
		}
	}
}
