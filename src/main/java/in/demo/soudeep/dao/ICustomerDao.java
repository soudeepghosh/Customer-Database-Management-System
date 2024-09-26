package in.demo.soudeep.dao;

import in.demo.soudeep.beans.CustomerBo;

public interface ICustomerDao {
	public String insertCustomerDetails(CustomerBo customer) throws Exception;
	public CustomerBo displayCustomerDetails(Integer cid) throws Exception;
	public String updateCustomerDetails(CustomerBo customer) throws Exception;
	public String deleteCustomerDetails(Integer cid) throws Exception;
}
