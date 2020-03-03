
import java.awt.*;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
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



@SuppressWarnings("serial")
public class CoverF extends JFrame  {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;
	private JButton btnNewButton_1;
	private Choice choice;
	private JButton btnNewButton_2;
	

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
		
		searchF search = new searchF();
		
		//checkOutF checkOut = new checkOutF();
		
//�ܺ� ������
		setTitle("\uC0AC\uD68C\uD559\uACFC \uB3C4\uC11C\uAD00\uB9AC \uD504\uB85C\uADF8\uB7A8");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 200, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
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
					//�Է°��� ����
					String input = textField.getText();
					//���� �����͸� �޾ƿ�
					search.getData();
					//��
					search.returnIndex(input);
					//�����͸� ���� ���� ����
					search.serchResult();
					
					String bookName = search.bookName;
					String author = search.author;
					String translator= search.translator;
					String publishingCompany = search.publishingCompany;
					String amount = search.amount;
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
				//�Է°��� ����
				String input = textField.getText();
				//���� �����͸� �޾ƿ�
				search.getData();
				//��
				search.returnIndex(input);
				//�����͸� ���� ���� ����
				search.serchResult();
				
				String bookName = search.bookName;
				String author = search.author;
				String translator= search.translator;
				String publishingCompany = search.publishingCompany;
				String amount = search.amount;
				textArea.setText("å�̸�: "+bookName+System.lineSeparator()+"����: "+author+System.lineSeparator()+"������: "+translator+System.lineSeparator()+"���ǻ�: "+publishingCompany+System.lineSeparator()+"����: "+amount);
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		//���� �˻� �ؽ�Ʈ â ��
		
		
//�����˻�â ������
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		contentPane.add(textField, gbc_textField);
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
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 1;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		
		btnNewButton_2 = new JButton("\uBC18\uB0A9");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) //�ݳ� ��ư �̺�Ʈ
			{
				//���� �����Ϳ��� ������ ����
				
				

			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 2;
		contentPane.add(btnNewButton_2, gbc_btnNewButton_2);
		
		choice = new Choice();
		GridBagConstraints gbc_choice = new GridBagConstraints();
		gbc_choice.anchor = GridBagConstraints.WEST;
		gbc_choice.fill = GridBagConstraints.VERTICAL;
		gbc_choice.insets = new Insets(0, 0, 5, 0);
		gbc_choice.gridx = 1;
		gbc_choice.gridy = 2;
		contentPane.add(choice, gbc_choice);
		choice.add("--���� ���� ��Ȳ--");
		//���� �� �������� �Է� ��
				
				
//��� ǥ��
		textArea = new JTextArea();
		textArea.setEditable(false);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 3;
		contentPane.add(textArea, gbc_textArea);
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
