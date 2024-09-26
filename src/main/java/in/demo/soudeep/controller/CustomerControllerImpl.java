package in.demo.soudeep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.demo.soudeep.beans.CustomerBo;
import in.demo.soudeep.beans.CustomerDto;
import in.demo.soudeep.beans.CustomerVo;
import in.demo.soudeep.service.ICustomerService;

@Component("controller")
public class CustomerControllerImpl implements ICustomerController {
	@Autowired
	private ICustomerService service;

	@Override
	public String insertCustomerDetails(CustomerVo customerVo) throws Exception{
		CustomerDto customerDto = new CustomerDto();
		customerDto.setCname(customerVo.getCname());
		customerDto.setCaddress(customerVo.getCaddress());
		customerDto.setPamt(Float.parseFloat(customerVo.getPamt()));
		customerDto.setRate(Float.parseFloat(customerVo.getRate()));
		customerDto.setTime(Float.parseFloat(customerVo.getTime()));
		
		return service.insertCustomerDetails(customerDto);
	}

	@Override
	public CustomerBo displayCustomerDetails(Integer cid) throws Exception {
		return service.displayCustomerDetails(cid);
	}

	@Override
	public String updateCustomerDetails(CustomerVo customerVo) throws Exception {
		CustomerDto customerDto = new CustomerDto();
		customerDto.setCid(Integer.parseInt(customerVo.getCid()));
		customerDto.setCname(customerVo.getCname());
		customerDto.setCaddress(customerVo.getCaddress());
		customerDto.setPamt(Float.parseFloat(customerVo.getPamt()));
		customerDto.setRate(Float.parseFloat(customerVo.getRate()));
		customerDto.setTime(Float.parseFloat(customerVo.getTime()));
		return service.updateCustomerDetails(customerDto);
	}

	@Override
	public String deleteCustomerDetails(Integer cid) throws Exception {
		return service.deleteCustomerDetails(cid);
	}

}
