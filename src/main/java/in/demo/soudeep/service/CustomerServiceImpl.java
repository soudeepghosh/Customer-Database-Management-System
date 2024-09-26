package in.demo.soudeep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.demo.soudeep.beans.CustomerBo;
import in.demo.soudeep.beans.CustomerDto;
import in.demo.soudeep.beans.CustomerVo;
import in.demo.soudeep.dao.ICustomerDao;

@Component("service")
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	private ICustomerDao dao;
	
	@Override
	public String insertCustomerDetails(CustomerDto customerDto) throws Exception{
		CustomerBo customerBo = new CustomerBo();
		customerBo.setCname(customerDto.getCname());
		customerBo.setCaddr(customerDto.getCaddress());
		customerBo.setPamt(customerDto.getPamt());
		customerBo.setRate(customerDto.getRate());
		customerBo.setTime(customerDto.getTime());
		// setting Simple Interest
		customerBo.setSi((customerDto.getPamt()*customerDto.getRate()*customerDto.getTime())/100);
		
		return dao.insertCustomerDetails(customerBo);
	}

	@Override
	public CustomerBo displayCustomerDetails(Integer cid) throws Exception {
		return dao.displayCustomerDetails(cid);
	}

	@Override
	public String updateCustomerDetails(CustomerDto customerDto) throws Exception {
		CustomerBo customerBo = new CustomerBo();
		customerBo.setCid(customerDto.getCid());
		customerBo.setCname(customerDto.getCname());
		customerBo.setCaddr(customerDto.getCaddress());
		customerBo.setPamt(customerDto.getPamt());
		customerBo.setRate(customerDto.getRate());
		customerBo.setTime(customerDto.getTime());
		// setting Simple Interest
		customerBo.setSi((customerDto.getPamt()*customerDto.getRate()*customerDto.getTime())/100);
		return dao.updateCustomerDetails(customerBo);
	}

	@Override
	public String deleteCustomerDetails(Integer cid) throws Exception {
		return dao.deleteCustomerDetails(cid);
	}

}
