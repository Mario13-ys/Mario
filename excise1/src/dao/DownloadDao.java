package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

import vo.Download;

public class DownloadDao {
	//查询t_ downloadList表的所有记录， 查询结果存放在集合中，集合中元素类型是Download对象
	public ArrayList<Download> query() {
		ArrayList<Download> list = new ArrayList<Download>();
		try {
			// 1.加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 2. 建立与数据库的连接
			Connection con = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/excise?useunicode=true&character=utf-8",
							"root", "123456");
			//3.创建语句
			String sql = "select * from t_downloadlist";
			PreparedStatement pst = con.prepareStatement(sql);
			// 4.执行语句
			ResultSet rs = pst.executeQuery();
			//5.结果处理 
			while (rs.next()) {
				Download download = new Download() ;
				download.setId(rs.getInt("id")); //资源id
				download.setName(rs.getString("name")); //资源名称
				download.setPath(rs.getString("path")); //资源存放相对路径
				download.setDescription(rs.getString("description")); //资源描述
				long size=rs.getLong("size"); //资源大小
				String sizeStr=fileSizeTransfer(size); //转换为B，KB，MB，GB等形式
				download.setSizeStr(sizeStr);
				download.setStar(rs.getInt("star")); //星级
				download.setImage(rs.getString("image")); //资源图像 存放相对路径
				download.setTime(rs.getString("time")); //资源上传时间
				list.add(download); //将对象存放于集合中.
			}
			//6.关闭连接
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//根据资源id查询记录，将记录转换为download对象进行返回
	public Download get(int id) {
		Download download = null;
		try {
			// 1.加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 2. 建立与数据库的连接
			Connection con = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/excise?useunicode=true&character=utf-8",
							"root", "123456");
			//3.创建语句
			String sql = "select * from t_downloadlist where id=? ";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1,id);
			// 4.执行语句
			ResultSet rs = pst.executeQuery(); 
			//5.结果处理 
			if (rs.next()) {
				download = new Download();
				download.setId(rs.getInt("id"));
				download.setName( rs.getString("name"));
				download.setPath( rs.getString("path"));
				download.setDescription(rs.getString("description"));
				long size=rs.getLong("size") ;
				String sizeStr=fileSizeTransfer(size);
				download.setStar(rs.getInt("star"));
				download.setImage(rs.getString("image"));
				download.setTime(rs.getString("time"));
				download.setSizeStr(sizeStr);
			}
			//6.关闭连接
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return download ;
	}
	//自定义方法，将资源大小转换为***G, **MB , **KB, ** B等形式的字符串
	public String fileSizeTransfer(long fileSize) {
		String mFileSize;
		DecimalFormat df = new DecimalFormat ( "######0.00") ;
		double size = (double) fileSize;
		if (size > 1024 * 1024 * 1024) {
			size = size / (1024
					* 1024 * 1024);
			mFileSize = df.format(size) + "G";
		} else if (size > 1024 * 1024) {
			size = size / (1024 * 1024) ;
			mFileSize = df.format(size) + "MB";
		} else if (size > 1024) {
			size = size / 1024;
			mFileSize = df.format(size) + "KB";
		}else{
			mFileSize = df.format(size) + "B";
		}
		return mFileSize ;
	}
}