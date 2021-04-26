
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
public class CoverF extends JFrame  {

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
			public void run() {
				try {
					//�ܺ� ������
					CoverF frame = new CoverF();
					frame.setVisible(true);
					
															
					
				} catch (Exception e) {
					e.printStackTrace();
				}
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

					String bookName = search_book.return_bookName(index);
					
					//�ش� �� ���� �����͸� ������
					searchF_other other = new searchF_other(index);
					
					String author = other.retunr_author();
					String translator= other.retunr_translator();
					String publishingCompany = other.retunr_publishing();
					
					String amount = other.retunr_amount();
					if(amount == "nell") amount = "1";
					textField_1.setText(amount);
					
					//���
					textArea.setText("å�̸�: "+bookName+System.lineSeparator()+"����: "+author+System.lineSeparator()+"������: "+translator+System.lineSeparator()+"���ǻ�: "+publishingCompany+System.lineSeparator());
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
				//�Է�â�� ���� ���� �� �ؽ�Ʈ�� �ʱ�ȭ�ϴ� �̺�Ʈ
				textField.setText("");
			}
		});
		//�ܺ� ������ ��
		
		
//���� �˻� ��ư
		JButton btnNewButton = new JButton("\uAC80\uC0C9");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{	
				//�Է°��� ������
				String input = textField.getText();

				//�˻� ��  �ش��ϴ� �� ���� ������
				searchF_bookName search_book = new searchF_bookName();
				int index = search_book.return_ResultIndex(input);

				String bookName = search_book.return_bookName(index);
				
				//�ش� �� ���� �����͸� ������
				searchF_other other = new searchF_other(index);
				
				String author = other.retunr_author();
				String translator= other.retunr_translator();
				String publishingCompany = other.retunr_publishing();
				
				String amount = other.retunr_amount();
				if(amount == "nell") amount = "1";
				textField_1.setText(amount);
				
				//���
				textArea.setText("å�̸�: "+bookName+System.lineSeparator()+"����: "+author+System.lineSeparator()+"������: "+translator+System.lineSeparator()+"���ǻ�: "+publishingCompany+System.lineSeparator());
			}
		});
		textField.setColumns(10);
		textField.setText("�������� �Է����ּ���.");
		
		btnNewButton_1 = new JButton("\uB300\uCD9C");
		btnNewButton_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) 
			{
				//�������Ͽ� �Էµ� ������ ����
				CoverF_secon Frame2 = new CoverF_secon();
				Frame2.setVisible(isDisplayable()); 

			}//���� ��ư
		});
		
		btnNewButton_2 = new JButton("\uBC18\uB0A9");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) //�ݳ� ��ư �̺�Ʈ
			{
				//��ǥ: ���� �����Ϳ��� ������ ���� Ȥ�� ǥ��
				
				//UI: ������ ���� �ҷ���
				String selectedVal = choice.getItem(choice.getSelectedIndex());
				//�����̽��� �������� string ����
				String[] String_array = selectedVal.split(" , ");
				
				//�й��� �������� DB���� �˻� �� "�ݳ�"�� ����
				//�˻��� string ����
				String studentNum = String_array[0];
				String checkOut_case = String_array[1];
				checkOutF BookCase = new checkOutF();
				//boolean sw = checkOutF.returnBook;
				//DB������ ����
				checkOutF_get get = new checkOutF_get();
				ArrayList<String> ID = get.reId();
				ArrayList<String> case_bookNum = get.reBookName();
				//�˻� ��� index = �������� ���� �� �� ����
				int indexID= ID.indexOf(studentNum);
				int indexCase = case_bookNum.indexOf(checkOut_case);
								
				if (indexID == indexCase)
				{
					BookCase.toggleCheckOutValue();
					BookCase.insertData(indexID);
					BookCase.commint();
				}

//				Remove visual list
				//choice.remove(choice.getSelectedIndex());
			}
		});
		
		
//�����͸� �����ͼ� ǥ��
		choice = new Choice();
		choice.add("--------  ���� ���� ��Ȳ  --------");
		
		//System.out.println(ID.size());
		
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
			// TODO: handle exception
		}
		
		//���� �� �������� �Է� ��
				
				
//��� ǥ��
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("���� ���", Font.BOLD, 15));
		textArea.setForeground(Color.black); 
		textArea.setAlignmentX(JPanel.CENTER_ALIGNMENT);

		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("����", Font.PLAIN, 15));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setHorizontalAlignment(JTextField.CENTER);
		textField_1.setForeground(Color.red); 
		
		
		JLabel lblNewLabel = new JLabel("\uC218\uB7C9");
		lblNewLabel.setFont(new Font("����ü", Font.PLAIN, 12));
		lblNewLabel.setBackground(Color.WHITE);
		//�˻��ߴ� å�� ������ ǥ��

		
		
		
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
				//��� ǥ�� ��	
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
