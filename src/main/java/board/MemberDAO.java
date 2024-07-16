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
    public MemberDTO getMember(String uid, String upass) {
		MemberDTO dto = new MemberDTO();
		String query = "select * from member where id=? and pass=?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, uid);
			psmt.setString(2, upass);
			rs = psmt.executeQuery();

			if (rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setRegidate(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

  
    
}