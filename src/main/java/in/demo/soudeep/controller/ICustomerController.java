package in.demo.soudeep.controller;

import in.demo.soudeep.beans.CustomerBo;
import in.demo.soudeep.beans.CustomerVo;

public interface ICustomerController {
	public String insertCustomerDetails(CustomerVo customer) throws Exception;
	public CustomerBo displayCustomerDetails(Integer cid) throws Exception;
	public String updateCustomerDetails(CustomerVo customer) throws Exception;
	public String deleteCustomerDetails(Integer cid) throws Exception;
}
