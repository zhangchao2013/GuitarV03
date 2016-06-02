package cumt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import cumt.pojo.Guitar;

public class GuitarDao {
	
	public static void addGuitar(Guitar guitar){
		
		//连接数据库
		Connection conn=DBAccess.getConnection();
		
		String str="INSERT INTO guitar(serialNumber, price, builder,model, type, backWood, topWood) VALUES (?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(str);
			ps.setString(1,guitar.getSerialNumber());
			ps.setDouble(2,guitar.getPrice());
			ps.setString(3,guitar.getBuilder());
			ps.setString(4,guitar.getModel());
			ps.setString(5,guitar.getType());
			ps.setString(6,guitar.getBackWood());
			ps.setString(7,guitar.getTopWood());
			int flag=ps.executeUpdate();
			if(flag>0){
				System.out.println("fffffff");
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	public static Guitar getGuitarByNum(String Number) {
		//连接数据库
		Connection conn=DBAccess.getConnection();
		String sql="select * from guitar where serialNumber=?";
		PreparedStatement ps;
		Guitar guitar2 = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,Number);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				String serialNumber=rs.getString("serialNumber");
				Double price=rs.getDouble("price");
				String builder=rs.getString("builder");
				String model=rs.getString("model");
				String type=rs.getString("type");
				String backWood=rs.getString("backWood");
				String topWood=rs.getString("topWood");
				guitar2=new Guitar(serialNumber, price, builder, model, type, backWood, topWood);
				System.out.println("su");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return guitar2;
	}
	
	public static List<Guitar> search(String str) {
		//连接数据库
		Connection conn=DBAccess.getConnection();
		String sql="select * from guitar where serialNumber like '%"+str+"%'"
		+"or price like '%"+str+"%'"
		+"or builder like '%"+str+"%'"
		+"or model like '%"+str+"%'"
		+"or type like '%"+str+"%'"
		+"or backWood like '%"+str+"%'"
		+"or topWood like '%"+str+"%'";
		
		List<Guitar> list=new ArrayList<Guitar>();
		Guitar guitar=null;

		try {
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(sql);
						while(rs.next()){
				String serialNumber=rs.getString("serialNumber");
				Double price=rs.getDouble("price");
				String builder=rs.getString("builder");
				String model=rs.getString("model");
				String type=rs.getString("type");
				String backWood=rs.getString("backWood");
				String topWood=rs.getString("topWood");
				guitar=new Guitar(serialNumber, price, builder, model, type, backWood, topWood);
				
				list.add(guitar);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return list;
	}
}
