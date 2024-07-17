package board;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import common.JDBConnect;

public class MemberDAO extends JDBConnect {
    public MemberDAO() {
        super();
    }
    
  //로그인.
    public MemberDTO getMember(String id, String pass) {
		MemberDTO dto = new MemberDTO();
		String query = "select * from member where id=? and pass=?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, id);
			psmt.setString(2, pass);
			rs = psmt.executeQuery();

			if (rs.next()) {
				dto.setId(rs.getString(1));
				dto.setPass(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setRegidate(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

  //회원가입
    public int setJoin(String id, String pass, String name) {
    	MemberDTO dto = new MemberDTO();
    	int result = 0;
    	String query = "insert into member (id, pass, name, regidate) values(?, ?,?,sysdate)";
    	try {
    		psmt = con.prepareStatement(query);
    		psmt.setString(1, id);
    		psmt.setString(2, pass);
    		psmt.setString(3, name);
    		result = psmt.executeUpdate();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return result;
    }
    
    //회원정보수정
    public int updateJoin(String id, String pass, String name) {
    	MemberDTO dto = new MemberDTO();
    	int result = 0;
    	String query = "update member set   pass = ?, name =? , regidate=sysdate  where id = ? ";
    	try {
    		psmt = con.prepareStatement(query);
    		psmt.setString(3, id);
    		psmt.setString(1, pass);
    		psmt.setString(2, name);
    		result = psmt.executeUpdate();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return result;
    }
    
}