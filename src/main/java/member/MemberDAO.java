package member;

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
				dto.setEmail(rs.getString(4));
				dto.setPhone(rs.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

  //회원가입
    public int setJoin(String id, String pass, String name,String email, String phone) {
    	MemberDTO dto = new MemberDTO();
    	int result = 0;
    	
    	String qur = "select count(*) from member where id = ?";
    	try {
    		psmt = con.prepareStatement(qur);
    		psmt.setString(1, id);
    		rs = psmt.executeQuery();
    		rs.next();
    		if(rs.getInt(1)!=1) {
    			String query = "insert into member (id, pass, name, email, phone) values(?, ?,?,?,?)";
    	    	try {
    	    		psmt = con.prepareStatement(query);
    	    		psmt.setString(1, id);
    	    		psmt.setString(2, pass);
    	    		psmt.setString(3, name);
    	    		psmt.setString(4, email);;
    	    		psmt.setString(5, phone);
    	    		result = psmt.executeUpdate();
    	    	}catch(Exception e) {
    	    		e.printStackTrace();
    	    		result = 100;
    	    	}
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    
    	return result;
    }
    //회원정보 불러오기
    public MemberDTO getMemInfo(String id) {
    	MemberDTO dto = new MemberDTO();
    	String query = "select * from member where id = ?";
    	try {
    		psmt = con.prepareStatement(query);
    		psmt.setString(1, id);
    		rs = psmt.executeQuery();
    		rs.next();
    		dto.setId(rs.getString(1));
    		dto.setPass(rs.getString(2));
    		dto.setName(rs.getString(3));
    		dto.setEmail(rs.getString(4));
    		dto.setPhone(rs.getString(5));
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    
    	return dto;
    }
    //회원정보수정
    public int updateJoin(String id, String pass, String name ,String email ,String phone) {
    	MemberDTO dto = new MemberDTO();
    	int result = 0;
    	String query = "update member set   pass = ?, name =? , email=? , phone=?  where id = ? ";
    	try {
    		psmt = con.prepareStatement(query);
    		psmt.setString(5, id);
    		psmt.setString(1, pass);
    		psmt.setString(2, name);
    		psmt.setString(3, email);
    		psmt.setString(4, phone);
    		result = psmt.executeUpdate();
    		System.out.println("업데이트 성공");
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return result;
    }
    //회원탈퇴
    public int deleteJoin(String id) {
    	int result = 2;
    	String query = "delete from member where id = ?";
    	try {
    		psmt = con.prepareStatement(query);
    		psmt.setString(1, id);
    		result =psmt.executeUpdate();
    		if(result==1)result=3;
    	}catch(Exception e ) {
    		e.printStackTrace();
    	}
    	return result;
    }
    //게시물 작성여부
    public int writeListYn(String id) {
    	int result = 0 ;
    	String query = "select count(*) from board where id = ?";
    	try {
    		psmt = con.prepareStatement(query);
    		psmt.setString(1, id);
    		rs = psmt.executeQuery();
    		rs.next();
    		result = rs.getInt(1);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return result;
    }
    
}