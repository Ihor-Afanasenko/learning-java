package com.hillel.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper {

	private Connection cn;

	public DBHelper() throws SQLException {
		cn = ConnectorDB.getConnection();
	}

	public Statement getStatement() {
		Statement st = null;
		try {
			st = cn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return st;
	}

	public PreparedStatement getPreparedStatement(String sql) {
		PreparedStatement ps = null;
		try {
			ps = cn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	}

	public PreparedStatement insertValuesString(PreparedStatement ps, String value) {
		try {
			value = value.toUpperCase();
			ps.setString(1, "%" + value + "%");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	}

	public PreparedStatement insertValuesInt(PreparedStatement ps, int value) {
		try {
			ps.setInt(1, value);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	}
	
	public void closePreparedStatement(PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void closeConnection() {
		if (cn != null) {
			try {
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}