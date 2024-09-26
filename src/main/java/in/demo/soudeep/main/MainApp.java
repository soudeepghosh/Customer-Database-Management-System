package in.demo.soudeep.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import in.demo.soudeep.beans.CustomerBo;
import in.demo.soudeep.beans.CustomerVo;
import in.demo.soudeep.config.AppConfig;
import in.demo.soudeep.controller.CustomerControllerImpl;

public class MainApp {
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		CustomerControllerImpl controller = context.getBean("controller", CustomerControllerImpl.class);
		
		try (Scanner scanner = new Scanner(System.in);){
			while(true) {
				System.out.println();
				System.out.println("---------------------------------");
				System.out.println("\t| HCFDI BANK |");
				System.out.println("---------------------------------");
				System.out.println("\tCustomer Database");
				System.out.println("---------------------------------");
				
				System.out.println("\t1. Display");
				System.out.println("\t2. Insertion");
				System.out.println("\t3. Updation");
				System.out.println("\t4. Deletion");
				System.out.println("\t0. Exit");
				
				System.out.println("---------------------------------");
				System.out.println("Enter your choice :: ");
				int choice = scanner.nextInt();
				
				switch (choice) {
					// Display
					case 1: {
						System.out.println("---------------------------------");
						System.out.println("\tCustomer Details");
						System.out.println("---------------------------------");
						System.out.println("Enter Customer ID to see Customer Details :: ");
						Integer cid = scanner.nextInt();
						
						CustomerBo customerDetails = controller.displayCustomerDetails(cid);
						
						System.out.println(customerDetails);
						
						break;
						
					}
					
					// Insertion
					case 2: {
						System.out.println("---------------------------------");
						System.out.println("\tInsert Records");
						System.out.println("---------------------------------");
						
						// Reading inputs from the user
						System.out.print("Enter the Customer Name :: ");
						String name = scanner.next();

						System.out.print("Enter the Customer Address :: ");
						String address = scanner.next();

						System.out.print("Enter the Principal Amount :: ");
						String pamt = scanner.next();

						System.out.print("Enter the rate of interest :: ");
						String rate = scanner.next();

						System.out.print("Enter the time period (in year) :: ");
						String time = scanner.next();		
						
						try {
							CustomerVo customer = new CustomerVo();
							customer.setCname(name);
							customer.setCaddress(address);
							customer.setPamt(pamt);
							customer.setRate(rate);
							customer.setTime(time);
							
							String msg = controller.insertCustomerDetails(customer);
							System.out.println(msg);
						} catch (Exception e) {
							e.printStackTrace();
							System.out.println("Some internal problem occured ---> Try again :: " + e.getMessage());
						}
						
						break;
					}
					
					// Updation
					case 3: {
						System.out.println("---------------------------------");
						System.out.println("\tUpdate Records");
						System.out.println("---------------------------------");
						String name = null;
						String address = null;
						String pamt = null;
						String rate = null;
						String time = null;
						
						System.out.print("For updation, please enter the Customer ID :: ");
						Integer cid = scanner.nextInt();
						CustomerBo exitingCustomerObj = controller.displayCustomerDetails(cid);
						
						System.out.print("Customer Name :: "+exitingCustomerObj.getCname()+"\nDo you want to update the Customer Name [Yes/No] :: ");
						String isYes = scanner.next();
						if(isYes.equalsIgnoreCase("yes")) {
							System.out.print("Enter the Customer Name :: ");
							name = scanner.next();
						}
						
						System.out.println("Customer Address :: "+exitingCustomerObj.getCaddr()+"\nDo you want to update the Customer Address [Yes/No] :: ");
						isYes = scanner.next();
						if(isYes.equalsIgnoreCase("yes")) {
							System.out.print("Enter the Customer Address :: ");
							address = scanner.next();
						}
						
						System.out.println("Principal Amount :: "+exitingCustomerObj.getPamt()+"\nDo you want to update the Principal Amount [Yes/No] :: ");
						isYes = scanner.next();
						if(isYes.equalsIgnoreCase("yes")) {
							System.out.print("Enter the Principal Amount :: ");
							pamt = scanner.next();
						}
						
						System.out.println("Rate of Interest :: "+exitingCustomerObj.getRate()+"\nDo you want to update the rate of interest [Yes/No] :: ");
						isYes = scanner.next();
						if(isYes.equalsIgnoreCase("yes")) {
							System.out.print("Enter the rate of interest :: ");
							rate = scanner.next();
						}

						System.out.println("Time Periods (in year):: "+exitingCustomerObj.getTime()+"\nDo you want to update the time period [Yes/No] :: ");
						isYes = scanner.next();
						if(isYes.equalsIgnoreCase("yes")) {
							System.out.print("Enter the time period (in year) :: ");
							time = scanner.next();	
						}
							
						CustomerVo customerVo = new CustomerVo();
						customerVo.setCid(cid.toString());
						if (name!=null) {
							customerVo.setCname(name);
						} else {
							customerVo.setCname(exitingCustomerObj.getCname());
						}
						
						if (address!=null) {
							customerVo.setCaddress(address);
						} else {
							customerVo.setCaddress(exitingCustomerObj.getCaddr());
						}
						
						if (pamt!=null) {
							customerVo.setPamt(pamt);
						} else {
							customerVo.setPamt(exitingCustomerObj.getPamt()+"");
						}
						
						if (rate!=null) {
							customerVo.setRate(rate);
						} else {
							customerVo.setRate(exitingCustomerObj.getRate()+"");
						}
						
						if (time!=null) {
							customerVo.setTime(time);
						} else {
							customerVo.setTime(exitingCustomerObj.getTime()+"");
						}
						
						String msg = controller.updateCustomerDetails(customerVo);
						System.out.println(msg);
						
						break;
						
					}
					
					// Deletion
					case 4:{
						System.out.println("---------------------------------");
						System.out.println("\tDelete Record");
						System.out.println("---------------------------------");
						System.out.println("Enter Customer ID to delete record :: ");
						Integer cid = scanner.nextInt();
						String msg = controller.deleteCustomerDetails(cid);
						System.out.println(msg);
						
					}
					
					// Exit
					case 0: {
						System.exit(0);
					}
					
					// default case
					default :
						System.out.println("Please enter a valid choice...");
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		((AbstractApplicationContext) context).close();
	}

}
