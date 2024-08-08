package com.linkdin.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.linkdin.entity.LinkdinUser;
import com.linkdin.utility.DatabaseConnection;

public class LinkdinDAO implements LinkdinDAOInterface {

	@Override
	public int createProfileDAO(LinkdinUser lu) {
		int i = 0;
		try {
			// step 1 load driver
			Class.forName("com.mysql.jdbc.Driver");

			// step 2 create database connection
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://revaturechennaiaws.cdu6wesuaymd.us-east-2.rds.amazonaws.com:3306/revaturechennaiaws",
					"admin", "admin123");

			// step 3 create dynamic query
			PreparedStatement ps = con.prepareStatement("insert into linkdinuser values(?,?,?,?)");
			// ? is known as place holder for the value
			// how to replace place holder (? ) with value?
			ps.setString(1, lu.getName());
			ps.setString(2, lu.getPassword());
			ps.setString(3, lu.getEmail());
			ps.setString(4, lu.getAddress());

			// step 4 execute query
			// for insert, delete and update we will use executeUpdate() method.
			// executeUpdate() method return type will be int, it will indicate no of rows
			// affected by query.
			// for select query we will use executeQuery() method
			// executeQuery() method return type will be ResultSet
			i = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public LinkdinUser viewProfileDAO(LinkdinUser lu) {
		LinkdinUser l2 = null;
		try {
			Connection con = DatabaseConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from linkdinuser where email=?");
			ps.setString(1, lu.getEmail());

			ResultSet res = ps.executeQuery();
			if (res.next()) {
				String n = res.getString(1);
				String p = res.getString(2);
				String e = res.getString(3);
				String a = res.getString(4);

				l2 = new LinkdinUser();
				l2.setName(n);
				l2.setPassword(p);
				l2.setEmail(e);
				l2.setAddress(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l2;
	}

	@Override
	public List<LinkdinUser> viewAllProfileDAO() {

		List<LinkdinUser> ll = new ArrayList<LinkdinUser>();

		try {
			Connection con = DatabaseConnection.getConnection();
			//PreparedStatement ps = con.prepareStatement("select * from linkdinuser");
			//ResultSet res = ps.executeQuery();
			
			//Statement ps=con.createStatement();
			//ResultSet res = ps.executeQuery("select * from linkdinuser");
			
			CallableStatement ps=con.prepareCall("{call anusha}");
			ResultSet res = ps.executeQuery();
			
			while (res.next()) {
				String n = res.getString(1);
				String p = res.getString(2);
				String e = res.getString(3);
				String a = res.getString(4);

				LinkdinUser l1 = new LinkdinUser();
				l1.setName(n);
				l1.setPassword(p);
				l1.setEmail(e);
				l1.setAddress(a);

				ll.add(l1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ll;
	}

	@Override
	public int editProfileDAO(LinkdinUser lu) {
		int i = 0;
		try {
			Connection con = DatabaseConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("update linkdinuser set password=?, address=? where email=?");
			ps.setString(1, lu.getPassword());
			ps.setString(2, lu.getAddress());
			ps.setString(3, lu.getEmail());
			i = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int deleteProfileDAO(LinkdinUser lu) {
		int i = 0;
		try {
			Connection con = DatabaseConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from linkdinuser where email=?");

			ps.setString(1, lu.getEmail());
			i = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

}
