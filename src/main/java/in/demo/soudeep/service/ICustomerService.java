package in.demo.soudeep.service;

import in.demo.soudeep.beans.CustomerBo;
import in.demo.soudeep.beans.CustomerDto;

public interface ICustomerService {
	public String insertCustomerDetails(CustomerDto customer) throws Exception;
	public CustomerBo displayCustomerDetails(Integer cid) throws Exception;
	public String updateCustomerDetails(CustomerDto customer) throws Exception;
	public String deleteCustomerDetails(Integer cid) throws Exception;
}
