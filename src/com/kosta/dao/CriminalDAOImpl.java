package com.kosta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kosta.dto.CriminalDTO;
import com.kosta.util.DbUtil;

public class CriminalDAOImpl implements CriminalDAO {

	@Override
	public List<CriminalDTO> getSelectAll() throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<CriminalDTO> list = new ArrayList<CriminalDTO>();
		String sql="select ID, SUPERCRIME, MIDCRIME, OCCUR_NO, ARREST_NO from CRIMEINFO join IDNAME using(ID)";
		try {
			con = DbUtil.getConnection();
			ps =con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				CriminalDTO dto = 
				new CriminalDTO(rs.getString("id"), 
						rs.getString("supercrime"),
						rs.getString("midcrime"),
						rs.getInt("occur_no"),
						rs.getInt("arrest_no"));
				list.add(dto);		
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
		
	}
	
	@Override
	public List<CriminalDTO> CallMidCrime(String str) throws SQLException {
		Connection con=null;
		PreparedStatement ps= null;
		ResultSet rs=null;
		List<CriminalDTO> list = new ArrayList<CriminalDTO>();
		String sql="select MIDCRIME from IDNAME where upper(ID) like ?";
		try {
			con = DbUtil.getConnection();
		    ps=con.prepareStatement(sql);
		    ps.setString(1, "'" + str + "-%'");
			rs=ps.executeQuery();
			
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}



	
	@Override
	public int SearchOccur(int number) throws SQLException {
		Connection con=null;
		PreparedStatement ps= null;
		ResultSet rs=null;
		int result=0;
		String sql="select occur from seouloccurence where supercrime = ?";
		try {
			con = DbUtil.getConnection();
		    ps=con.prepareStatement(sql);
		    ps.setString(1, supercrime);
			rs=ps.executeQuery();
			
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return result;
	}


	@Override
	public int SearchArrest(String midcrime) throws SQLException {
		Connection con=null;
		PreparedStatement ps= null;
		ResultSet rs=null;
		int result=0;
		String sql="select arrest from seouloccurence where midcrime = ?";
		try {
			con = DbUtil.getConnection();
		    ps=con.prepareStatement(sql);
		    ps.setString(1, midcrime);
			rs=ps.executeQuery();
			
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return result;
	}

	@Override
	public int managerUpdate(CriminalDTO criminalDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "update seouloccurence set comment =? where code = ?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, criminalDTO.getComment());
			ps.setInt(2, criminalDTO.getCrimecode());
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int managerDelete(int code) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "delete comment from seouloccurence where code = ?";
		try {
			
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1,code);
			result = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;	
	}

	@Override
	public int managerDelete(String id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
}



 
