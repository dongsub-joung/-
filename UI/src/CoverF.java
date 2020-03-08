
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
	private Choice choice;
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

	
	//�׸��� �� ���� DBMS�� ������ �˻� �õ��ϴ� �ż���
	//DBMS�� �˻������ �������� �޼���
	//textArea.setText(t); �� class�� ����
	
	

	
	/**
	 * Create the frame.
	 */
	public CoverF() {
		

		
		//checkOutF checkOut = new checkOutF();
		
//�ܺ� ������
		setTitle("\uC0AC\uD68C\uD559\uACFC \uB3C4\uC11C\uAD00\uB9AC \uD504\uB85C\uADF8\uB7A8");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//�˻� ��ư ��
		
		
//���� �˻� �ؽ�Ʈ â
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyPressed(KeyEvent e) 
			{
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
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
						
					//���
					textArea.setText("å�̸�: "+bookName+System.lineSeparator()+"����: "+author+System.lineSeparator()+"������: "+translator+System.lineSeparator()+"���ǻ�: "+publishingCompany+System.lineSeparator()+"����: "+amount);
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
					
				//���
				textArea.setText("å�̸�: "+bookName+System.lineSeparator()+"����: "+author+System.lineSeparator()+"������: "+translator+System.lineSeparator()+"���ǻ�: "+publishingCompany+System.lineSeparator()+"����: "+amount);
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
				//���� �����Ϳ��� ������ ����
				
				

			}
		});
		
		choice = new Choice();
		choice.add("--���� ���� ��Ȳ--");
		//���� �� �������� �Է� ��
				
				
//��� ǥ��
		textArea = new JTextArea();
		textArea.setEnabled(false);
		textArea.setEditable(false);
		
		JButton btnNewButton_3 = new JButton("\uB3C4\uC11C \uC218\uB7C9 \uD655\uC778");
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		//�˻��ߴ� å�� ������ ǥ��
		//volum volum = new volum();
		//String a = Integer.toString(volum.book_volum);
		//textField_1.setText(a);
		
		
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
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_3)
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
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_3)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_2)
						.addComponent(choice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
