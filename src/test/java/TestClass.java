import java.io.IOException;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.serviceId.Address;
import com.serviceId.Customer;
import com.serviceId.controller.AddressController;
import com.serviceId.service.AddressService;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.expression.Type;


public class TestClass {

	public static void main(String[] args) {
		BeanFactory factory=new  ClassPathXmlApplicationContext("spring-config.xml");
		AddressController addressController=(AddressController)factory.getBean(AddressController.class);
		Address address=addressController.getAddress(100L);
		printObject(address);
//		printObject(personService.list(null));
//		Customer customer=new Customer();
//		customer.setPId(1L);
//		QueryFilter filter=new QueryFilter("PId", 1l, Type.EQUALS);
//		QueryFilter filter=new QueryFilter("customer", Customer.class, customer, Type.EQUALS);
		
//		QueryFilter filter=new QueryFilter("city", "New York3", Type.EQUALS);
		
		
//		QueryFilter[] queryFilters=new QueryFilter[]{filter};
		
//		Page<Address> addresses=addressService.list(queryFilters, null);
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
//		printObject(addresses);
//		System.out.println(getFieledFromGetter("getFirst_name"));

	}
	
	private static void printObject(Object obj) {

		ObjectMapper mapper = new ObjectMapper();
		try {
			System.out.println(mapper.writeValueAsString(obj));
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
}
