
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
					//외부 프레임
					CoverF frame = new CoverF();
					frame.setVisible(true);
					
															
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	//그리고 이 값을 DBMS에 보내서 검색 시도하는 매서드
	//DBMS의 검색결과를 가져오는 메서드
	//textArea.setText(t); 의 class를 만듬
	
	

	
	/**
	 * Create the frame.
	 */
	public CoverF() {
		
		searchF search = new searchF();
		
		//checkOutF checkOut = new checkOutF();
		
//외부 프레임
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
		//검색 버튼 끝
		
		
//도서 검색 텍스트 창
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyPressed(KeyEvent e) 
			{
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					//입력값을 받음
					String input = textField.getText();
					//엑셀 데이터를 받아옴
					search.getData();
					//비교
					search.returnIndex(input);
					//데이터를 전역 변수 대입
					search.serchResult();
					
					String bookName = search.bookName;
					String author = search.author;
					String translator= search.translator;
					String publishingCompany = search.publishingCompany;
					String amount = search.amount;
					textArea.setText("책이름: "+bookName+System.lineSeparator()+"저자: "+author+System.lineSeparator()+"번역가: "+translator+System.lineSeparator()+"출판사: "+publishingCompany+System.lineSeparator()+"수량: "+amount);
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
				//입력창을 선택 했을 때 텍스트를 초기화하는 이벤트
				textField.setText("");
			}
		});
		//외부 프레임 끝
		
		
//도서 검색 버튼
		JButton btnNewButton = new JButton("\uAC80\uC0C9");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//입력값을 받음
				String input = textField.getText();
				//엑셀 데이터를 받아옴
				search.getData();
				//비교
				search.returnIndex(input);
				//데이터를 전역 변수 대입
				search.serchResult();
				
				String bookName = search.bookName;
				String author = search.author;
				String translator= search.translator;
				String publishingCompany = search.publishingCompany;
				String amount = search.amount;
				textArea.setText("책이름: "+bookName+System.lineSeparator()+"저자: "+author+System.lineSeparator()+"번역가: "+translator+System.lineSeparator()+"출판사: "+publishingCompany+System.lineSeparator()+"수량: "+amount);
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		//도서 검색 텍스트 창 끝
		
		
//도서검색창 프레임
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		textField.setText("도서명을 입력해주세요.");
		
		btnNewButton_1 = new JButton("\uB300\uCD9C");
		btnNewButton_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) 
			{
				//엑셀파일에 입력된 정보를 저장
				CoverF_secon Frame2 = new CoverF_secon();
				Frame2.setVisible(isDisplayable()); 

			}//대출 버튼
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 1;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		
		btnNewButton_2 = new JButton("\uBC18\uB0A9");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) //반납 버튼 이벤트
			{
				//엑셀 데이터에서 정보를 삭제
				
				

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
		choice.add("--도서 대출 현황--");
		//대출 시 개인정보 입력 끝
				
				
//결과 표시
		textArea = new JTextArea();
		textArea.setEditable(false);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 3;
		contentPane.add(textArea, gbc_textArea);
				//결과 표시 끝	
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
