
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.JTextArea;

public class bookControl {
	
}





@SuppressWarnings("serial")
public class CoverF extends JFrame  {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;

	//전역 변수 선언
			static String value=""; 
			
	//엑셀의 데이터를 가지오는 메소드
			public static void xcell() 
			{
			try
			{
	            FileInputStream file = new FileInputStream("C:/Users/ehdtj/OneDrive/바탕 화면/Web/bookControl/UI/bookList.xlsx");
	            @SuppressWarnings("resource")
				XSSFWorkbook workbook = new XSSFWorkbook(file);
	            
	            //매개 변수 선언
	            int rowindex=0;
	            int columnindex=0;

	            //시트 가져옴, 시트 수 (첫번째에만 존재하므로 0을 준다)
	            XSSFSheet sheet = workbook.getSheetAt(0);
	            
	            //시트 안의 행의 수를 가져옴
	            int rows = sheet.getPhysicalNumberOfRows();
	            
	            for(rowindex=0; rowindex<rows+30; rowindex++)//받아온 행만큼 반복
	            {	
	                //rowindex번 째의 시트 안의 행 val 가져옴
	                XSSFRow row = sheet.getRow(rowindex);
	                if(row !=null)//val이 null이 아닐 때
	                {	
	                    //셀의 수 받아옴
	                    int cells = row.getPhysicalNumberOfCells();
	                    
	                    for(columnindex=0; columnindex<=cells+3; columnindex++) //받아온 cloumn 만큼 반복
	                    { 
	                        //셀값을 읽는다
	                        XSSFCell cell = row.getCell(columnindex); //행의 column val을 가져옴
	                        
	                        //String value=""; //선언
	                        //셀이 빈값일경우를 위한 널체크
	                        if(cell == null) //행의 cloumn val가 null이면
	                        { 
	                            continue;	//해당 if,else를 탈출해라
	                        }
	                        
	                        else//행의 cloumn val가 존재한다면
	                        {	
	                            //타입별로 내용 읽기
	                            switch (cell.getCellType())
	                            {
	                            case XSSFCell.CELL_TYPE_FORMULA:
	                                value=cell.getCellFormula();
	                                break;
	                            case XSSFCell.CELL_TYPE_NUMERIC:
	                                value=cell.getNumericCellValue()+"";
	                                break;
	                            case XSSFCell.CELL_TYPE_STRING:
	                                value=cell.getStringCellValue()+"";
	                                break;
	                            case XSSFCell.CELL_TYPE_BLANK:
	                                value=cell.getBooleanCellValue()+"";
	                                break;
	                            case XSSFCell.CELL_TYPE_ERROR:
	                                value=cell.getErrorCellValue()+"";
	                                break;
	                            }
	                        }
	                   
	                        returnVal(value);
	                    }
	 
	                }
	            }
			}
			catch(Exception e) 
				{
				e.printStackTrace();
				}
			}
			
	//입력된 String 값을 출력, 반환
			public static String returnVal (String value) 
			{
				System.out.println(value);
				return value;
			}
			
	//배열 변수 초기화
			static String data[][];
			
	//엑셀 데이터를 배열화
			public static void array (String value)
			{
				int i,j;
				
				for(j=0; j<=1500; j++)
				{
					for(i=1; i<=9; i++);
					{
						data[i][j] = value;
					}
				}
				
			}

	//입력받은 값을 찾아서 행값을 반환
			/*
			public static String serch (String input)
			{
				data.indexOf(input);
				
				
			}
			*/
			
//데이터를 받아서 콘솔에 표시
			public static void serchInit()
			{
				xcell();
				returnVal(value);
			}
			
			
	
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
		
		//외부 프레임
		setTitle("\uC0AC\uD68C\uD559\uACFC \uB3C4\uC11C\uAD00\uB9AC \uD504\uB85C\uADF8\uB7A8");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
				//외부 프레임 끝
		
		
		//도서 검색 버튼
		JButton btnNewButton = new JButton("\uAC80\uC0C9");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//그리고 이 값을 DBMS에 보내서 검색 시도하는 매서드
				//DBMS의 검색결과를 가져오는 메서드
				//textArea.setText(t);
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
		textField.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent event) {
			}
			public void inputMethodTextChanged(InputMethodEvent event) {		
				textField.getText();
				//그리고 이 값을 DBMS에 보내서 검색 시도하는 매서드
				//DBMS의 검색결과를 가져오는 메서드
				//textArea.setText(t);
			}
		});
		
		
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//입력창을 선택 했을 때 텍스트를 초기화하는 이벤트
				textField.setText("");
			}
		});
		
		
		//도서검색창 프레임
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		textField.setText("도서명을 입력해주세요.");
		
				//텍스트 창 끝
		
		
		//결과 표시
		textArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 3;
		contentPane.add(textArea, gbc_textArea);
				//결과 표시 끝
				
		
	
		
		
		
	}

}
