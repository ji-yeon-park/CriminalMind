package com.kosta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kosta.dto.ArrestDayDTO;
import com.kosta.dto.CrimeInfoDTO;
import com.kosta.util.DbUtil;

public class CriminalDAOImpl implements CriminalDAO {

	@Override
	public List<CrimeInfoDTO> getSelectAll() throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<CrimeInfoDTO> list = new ArrayList<CrimeInfoDTO>();
		String sql="select SUPERCRIME, OCCUR_NO, ARREST_NO from CRIMEINFO join IDNAME using(ID)";
		try {
			con = DbUtil.getConnection();
			ps =con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				CrimeInfoDTO dto = 
				new CrimeInfoDTO(
						rs.getString("supercrime"),
						rs.getInt("occur_no"),
						rs.getInt("arrest_no"),null);
				list.add(dto);		
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
		
	}
	
	@Override
	public List<ArrestDayDTO> getSelectAll2() throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<ArrestDayDTO> list = new ArrayList<ArrestDayDTO>();
		String sql="select supercrime, MIDCRIME, ONE_D, ONE_M,ONE_Y,YS  from ARREST_DAY join IDNAME using(ID)";
		try {
			con = DbUtil.getConnection();
			ps =con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				ArrestDayDTO dto =new ArrestDayDTO(
						rs.getString("supercrime"),
						rs.getString("midcrime"),
						rs.getInt("one_D"),
						rs.getInt("one_M"),
						rs.getInt("one_Y"),
						rs.getInt("YS"),
						null );
				list.add(dto);		
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}
	
	@Override
	public List<String> CallMidCrime(String str) throws SQLException {
		Connection con=null;
		PreparedStatement ps= null;
		ResultSet rs=null;
		List<String> list = new ArrayList<String>();
		String sql="select MIDCRIME from IDNAME where upper(ID) like upper(?)";
		try {
			con = DbUtil.getConnection();
		    ps=con.prepareStatement(sql);
		    ps.setString(1, str + "-%");

			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(rs.getString(1));
			}

		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}
	
	@Override
	public CrimeInfoDTO SearchOccur(String str) throws SQLException {
		Connection con=null;
		PreparedStatement ps= null;
		ResultSet rs=null;
		CrimeInfoDTO dto = null;
		String sql="select supercrime, occur_no, arrest_no,comments "
				+ "from crimeinfo join IDNAME using(ID) where id = upper(?)";
		try {
			con = DbUtil.getConnection();
		    ps=con.prepareStatement(sql);
		    ps.setString(1, str);
			rs=ps.executeQuery();
			if(rs.next()) dto = new CrimeInfoDTO(rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getString(4));
			
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return dto;
	}


	@Override
	public ArrestDayDTO SearchArrest(String str) throws SQLException {
		Connection con=null;
		PreparedStatement ps= null;
		ResultSet rs=null;
		String sql="select supercrime,midcrime, one_d,one_m,one_y,ys,comments "
				+ "from arrest_day join IDNAME using(ID) where id = upper(?)";
		ArrestDayDTO dto = null;
		
		try {
			con = DbUtil.getConnection();
		    ps=con.prepareStatement(sql);
		    ps.setString(1, str);
			rs=ps.executeQuery();
			if(rs.next()) dto = new ArrestDayDTO(rs.getString(1),rs.getString(2),rs.getInt(3),
					rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getString(7));
			
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return dto;
	}

	@Override
	public int managerUpdate(String name, String comments) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "update crimeinfo set comments =? where id = upper(?)";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, comments);
			ps.setString(2, name);
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}
	
	@Override
	public int managerUpdate2(String name, String comments) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "update arrest_day set comments =? where id = upper(?)";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, comments);
			ps.setString(2, name);
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

}



 
