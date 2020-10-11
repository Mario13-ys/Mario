package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import vo.User;

public class UserDao {
	public User get(String userName) {
		User user = null ;
		try {
			// 1.加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 2.建立与数据库的连接
			Connection con=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/excise?useunicode=true&character=utf-8",
					"root","123456");
			// 3.创建语句
			String sql="select * from t_user where username=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst. setString(1, userName);
			// 4.执行语句
			ResultSet rs=pst.executeQuery();
			// 5.结果处理
			if(rs.next()){
				user=new User(rs.getString("userName"),
						rs.getString("password")
						,rs.getString("chrName"),rs.getString("role"));
			}
			// 6.关闭连接
			con.close();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e. printStackTrace();
		}
		return user;
	}
}
