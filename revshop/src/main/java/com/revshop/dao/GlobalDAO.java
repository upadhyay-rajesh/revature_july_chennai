package com.revshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.revshop.entity.Buyer;
import com.revshop.utility.DatabaseConnection;

public class GlobalDAO implements GlobalDAOInterface {

	@Override
	public Buyer signInDAO(Buyer user) {
		Buyer b=null;
		try {
		   Connection con=	DatabaseConnection.getConnection();
		   PreparedStatement ps=con.prepareStatement("select * from buyer where email=? and password=?");
			ps.setString(1,user.getEmail() );
			ps.setString(2, user.getPassword());
			ResultSet i=ps.executeQuery();
			if(i.next()) {
				b=new Buyer();
				b.setUserType(i.getString("userType"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return b;
	}

}
