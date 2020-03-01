
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
import java.util.ArrayList;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPopupMenu;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import com.jgoodies.forms.factories.DefaultComponentFactory;


@SuppressWarnings("serial")
public class CoverF extends JFrame  {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;
	private JButton btnNewButton_1;
	private JTextField textField_1;
	

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
		gbc_btnNewButton.gridy = 1;
		contentPane.add(btnNewButton, gbc_btnNewButton);
				//검색 버튼 끝
		
		
//도서 검색 텍스트 창
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
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
			//도서 검색 텍스트 창 끝
		
		
//도서검색창 프레임
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		textField.setText("도서명을 입력해주세요.");
		
		btnNewButton_1 = new JButton("\uB300\uCD9C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				JLabel jib = new JLabel("");
				
			}//대출 버튼
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 2;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
			//텍스트 창 끝
		
		
//대출 시 개인정보 입력 창
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) 
			{ //학번만 받음.
				/*String input = textField_1.getText();
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					//checkOutF start = new checkOutF();
					
				}*/
			}
		});
		textField_1.setText("\uD559\uBC88, \uC774\uB984, \uBC88\uD638\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694.");
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 2;
		contentPane.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
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
