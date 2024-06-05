package com.ty.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AllLogicalData {


	public AllLogicalData() {
		
		
		
	}

	private static String driver = "org.postgresql.Driver";
	private static String url = "jdbc:postgresql://localhost:5432/shop";
	private static String password = "root";
	private static String user = "postgres";

	public void addData() {

		Connection con = createConnection();

		if (con != null) {
			String sql = "INSERT INTO student VALUES(?,?,?)";

			Scanner scn = userData();
			System.out.println("how many column you want to enter? ");
			int n = scn.nextInt();

			for (int i = 1; i <= n; i++) {

				try {
					PreparedStatement ps = con.prepareStatement(sql);
					System.out.println("Enter id: ");
					ps.setInt(1, scn.nextInt());
					System.out.println("Enter name: ");
					ps.setString(2, scn.next());
					System.out.println("Enter marks: ");
					ps.setInt(3, scn.nextInt());

					ps.execute();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		} else {
			System.out.println("connection object does not created......");
		}

		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteData() {
		Connection con = createConnection();
		if (con != null) {
			String sql = "DELETE FROM student WHERE ID=?";

			try {
				PreparedStatement ps = con.prepareStatement(sql);

				Scanner scn = userData();
				System.out.println("Eneter Student id: ");

				ps.setInt(1, scn.nextInt());

				ps.execute();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("connection object does not created......");
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void displayData() {
		Connection con = createConnection();
		if (con != null) {
			String sql = "SELECT * FROM student";

			try {
				Statement st = con.createStatement();

				ResultSet rs = st.executeQuery(sql);

				while (rs.next()) {
					System.out.println("id is: " + rs.getInt("id"));
					System.out.println("name is: " + rs.getString("name"));
					System.out.println("marks is: " + rs.getInt("marks"));

					System.out.println("==============================");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("connection object does not created......");
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateDataBasedOnName() {
		Connection con = createConnection();
		if (con != null) {
			String sql = "UPDATE student SET name=? WHERE ID=?";

			try {
				PreparedStatement ps = con.prepareStatement(sql);
				Scanner scn = userData();
				System.out.println("Enter new name: ");
				ps.setString(1, scn.next());
				System.out.println("ENter student id: ");
				ps.setInt(2, scn.nextInt());

				ps.execute();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("connection object does not created......");
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateMarks() {
		Connection con = createConnection();
		if (con != null) {
			String sql = "UPDATE student SET marks=? WHERE ID=?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				Scanner scn = userData();
				System.out.println("Enter New marks: ");
				ps.setInt(1, scn.nextInt());
				System.out.println("Enter id: ");
				ps.setInt(2, scn.nextInt());

				ps.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("connection object does not created......");
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Connection createConnection() {
		Connection con = null;
		try {

			Class.forName(driver);

			con = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	@SuppressWarnings("resource")
	private Scanner userData() {
		Scanner scn = new Scanner(System.in);

		return scn;
	}

	public void fetchBasedOnID() {
		Connection con = getInstance();
		if (con != null) {
			Scanner scn = userData();
			System.out.println("Enter id: ");
			int id = scn.nextInt();

			String sql = "SELECT * FROM student WHERE ID=" + id;

			try {

				Statement st = con.createStatement();

				ResultSet rs = st.executeQuery(sql);

				while (rs.next()) {
					System.out.println("id: " + rs.getInt(1));
					System.out.println("name: " + rs.getString(2));
					System.out.println("marks: " + rs.getInt(3));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("connection object does not created............");
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static Connection getInstance() {
		Connection con = null;
		if (con == null) {
			try {
				Class.forName(driver);

				con = DriverManager.getConnection(url, user, password);

			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		return con;
	}
}
