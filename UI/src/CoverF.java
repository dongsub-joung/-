
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

	//���� ���� ����
			static String value=""; 
			
	//������ �����͸� �������� �޼ҵ�
			public static void xcell() 
			{
			try
			{
	            FileInputStream file = new FileInputStream("C:/Users/ehdtj/OneDrive/���� ȭ��/Web/bookControl/UI/bookList.xlsx");
	            @SuppressWarnings("resource")
				XSSFWorkbook workbook = new XSSFWorkbook(file);
	            
	            //�Ű� ���� ����
	            int rowindex=0;
	            int columnindex=0;

	            //��Ʈ ������, ��Ʈ �� (ù��°���� �����ϹǷ� 0�� �ش�)
	            XSSFSheet sheet = workbook.getSheetAt(0);
	            
	            //��Ʈ ���� ���� ���� ������
	            int rows = sheet.getPhysicalNumberOfRows();
	            
	            for(rowindex=0; rowindex<rows+30; rowindex++)//�޾ƿ� �ุŭ �ݺ�
	            {	
	                //rowindex�� °�� ��Ʈ ���� �� val ������
	                XSSFRow row = sheet.getRow(rowindex);
	                if(row !=null)//val�� null�� �ƴ� ��
	                {	
	                    //���� �� �޾ƿ�
	                    int cells = row.getPhysicalNumberOfCells();
	                    
	                    for(columnindex=0; columnindex<=cells+3; columnindex++) //�޾ƿ� cloumn ��ŭ �ݺ�
	                    { 
	                        //������ �д´�
	                        XSSFCell cell = row.getCell(columnindex); //���� column val�� ������
	                        
	                        //String value=""; //����
	                        //���� ���ϰ�츦 ���� ��üũ
	                        if(cell == null) //���� cloumn val�� null�̸�
	                        { 
	                            continue;	//�ش� if,else�� Ż���ض�
	                        }
	                        
	                        else//���� cloumn val�� �����Ѵٸ�
	                        {	
	                            //Ÿ�Ժ��� ���� �б�
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
			
	//�Էµ� String ���� ���, ��ȯ
			public static String returnVal (String value) 
			{
				System.out.println(value);
				return value;
			}
			
	//�迭 ���� �ʱ�ȭ
			static String data[][];
			
	//���� �����͸� �迭ȭ
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

	//�Է¹��� ���� ã�Ƽ� �ప�� ��ȯ
			/*
			public static String serch (String input)
			{
				data.indexOf(input);
				
				
			}
			*/
			
//�����͸� �޾Ƽ� �ֿܼ� ǥ��
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
		
		//�ܺ� ������
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
				//�ܺ� ������ ��
		
		
		//���� �˻� ��ư
		JButton btnNewButton = new JButton("\uAC80\uC0C9");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�׸��� �� ���� DBMS�� ������ �˻� �õ��ϴ� �ż���
				//DBMS�� �˻������ �������� �޼���
				//textArea.setText(t);
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 1;
		contentPane.add(btnNewButton, gbc_btnNewButton);
				//�˻� ��ư ��
		
		
		//���� �˻� �ؽ�Ʈ â
		textField = new JTextField();
		textField.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent event) {
			}
			public void inputMethodTextChanged(InputMethodEvent event) {		
				textField.getText();
				//�׸��� �� ���� DBMS�� ������ �˻� �õ��ϴ� �ż���
				//DBMS�� �˻������ �������� �޼���
				//textArea.setText(t);
			}
		});
		
		
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//�Է�â�� ���� ���� �� �ؽ�Ʈ�� �ʱ�ȭ�ϴ� �̺�Ʈ
				textField.setText("");
			}
		});
		
		
		//�����˻�â ������
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		textField.setText("�������� �Է����ּ���.");
		
				//�ؽ�Ʈ â ��
		
		
		//��� ǥ��
		textArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 3;
		contentPane.add(textArea, gbc_textArea);
				//��� ǥ�� ��
				
		
	
		
		
		
	}

}
