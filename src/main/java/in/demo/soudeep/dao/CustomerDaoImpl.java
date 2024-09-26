package in.demo.soudeep.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.demo.soudeep.beans.CustomerBo;

@Component("dao")
public class CustomerDaoImpl implements ICustomerDao {
	private static final String SQL_INSERT_QUERY = "INSERT INTO customer(`cname`, `caddr`, `pamt`, `rate`, `time`, `si`) VALUES(?,?,?,?,?,?)";
	private static final String SQL_SELECT_QUERY = "SELECT cid, cname, caddr, pamt, rate, time, si FROM customer WHERE cid=?";
	private static final String SQL_UPDATE_QUERY = "UPDATE customer SET cname = ?, caddr = ?, pamt = ?, rate = ?, time = ?, si = ? WHERE cid = ?";
	private static final String SQL_DELETE_QUERY = "DELETE FROM customer WHERE cid = ?";
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public String insertCustomerDetails(CustomerBo customer) throws Exception {
		int rowAffected = 0;
		try (Connection connection = dataSource.getConnection()){
			PreparedStatement pstmt = connection.prepareStatement(SQL_INSERT_QUERY);
			pstmt.setString(1, customer.getCname());
			pstmt.setString(2, customer.getCaddr());
			pstmt.setFloat(3, customer.getPamt());
			pstmt.setFloat(4, customer.getRate());
			pstmt.setFloat(5, customer.getTime());
			pstmt.setFloat(6, customer.getSi());
			
			rowAffected = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return rowAffected==0 ? "insertion failure" : "New customer inserted...";
	}

	@Override
	public CustomerBo displayCustomerDetails(Integer cid) throws Exception {
		CustomerBo customer = null;
		try(Connection connection = dataSource.getConnection();) {
			PreparedStatement pstmt = connection.prepareStatement(SQL_SELECT_QUERY);
			pstmt.setInt(1, cid);
			ResultSet resultSet = pstmt.executeQuery();
			if (resultSet != null) {
				if (resultSet.next()) {
					customer = new CustomerBo();
					customer.setCid(resultSet.getInt("cid"));
					customer.setCname(resultSet.getString("cname"));
					customer.setCaddr(resultSet.getString("caddr"));
					customer.setPamt(resultSet.getFloat("pamt"));
					customer.setRate(resultSet.getFloat("rate"));
					customer.setTime(resultSet.getFloat("time"));
					customer.setSi(resultSet.getFloat("si"));
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return customer;
	}

	@Override
	public String updateCustomerDetails(CustomerBo customer) throws Exception {
		int rowAffected = 0;
		try(Connection connection = dataSource.getConnection()) {
			PreparedStatement pstmt = connection.prepareStatement(SQL_UPDATE_QUERY);
			pstmt.setString(1, customer.getCname());
			pstmt.setString(2, customer.getCaddr());
			pstmt.setFloat(3, customer.getPamt());
			pstmt.setFloat(4, customer.getRate());
			pstmt.setFloat(5, customer.getTime());
			pstmt.setFloat(6, customer.getSi());
			pstmt.setInt(7, customer.getCid());
			
			rowAffected = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return rowAffected==0 ? "Updation failure..." : "Customer details updated successfully...";
	}

	@Override
	public String deleteCustomerDetails(Integer cid) throws Exception {
		Integer id = 0;
		try(Connection connection = dataSource.getConnection()) {
			PreparedStatement pstmt = connection.prepareStatement(SQL_DELETE_QUERY);
			pstmt.setInt(1, cid);
			id = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return id != 0 ? "Record deleted successfully..."+id:"Deletion Failure...";
	}

}
