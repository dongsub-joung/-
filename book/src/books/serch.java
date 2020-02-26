package books;

public class serch {


	public class Method{
		/*
		public static void getName() {
			input된 string 받아옴.
			return bookName;
		}
		*/
		
		//입력받은 책 이름을 DB에서 검색 후 저장되어 있던 정보 반환
		public static void bookSerch() {
			//user로부터 책 이름을 받아옴.
			String bookName= getName();
			//SQL
			String sql= sb.append("select*from books where book_title=\""+ bookName + "\";").toString();
			stmt.execute(sql);
			
			
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}