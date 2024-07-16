package board;

/*자바빈즈 규약
1   자바빈즈는 기본( default) 패키지 이외의 패키지에 속해야 합니다. 
2  멤버 변수( 속성)의 접근 지정자는 private으로 선언합니다.
3  기본 생성자가 있어야 합니다.
4  멤버 변수에 접근할 수 있는 게터getter/세터setter 메서드가 있어야 합니다. 
5  게터/세터 메서드의 접근 지정자는 public으로 선언합니다.
*/
public class MemberDTO {
	private String id;
	private String pass;
	private String name;
	private String regidate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegidate() {
		return regidate;
	}
	public void setRegidate(String regidate) {
		this.regidate = regidate;
	}
}
