package test.uk.ac.ncl.Z_Wu.Car_Rental_System; 

import org.junit.Ignore;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import uk.ac.ncl.Z_Wu.Car_Rental_System.Customer;
import uk.ac.ncl.Z_Wu.Car_Rental_System.DrivingLicence;
import uk.ac.ncl.Z_Wu.Car_Rental_System.Person;

import java.util.Date;

/** 
* Customer Tester.
* 
* @author <Authors name> 
* @since <pre>Ê®ÔÂ 17, 2019</pre> 
* @version 1.0 
*/ 
public class CustomerTest {


private Person person_1=new Person("philips","wang");
private Date date_1=new Date();
private final DrivingLicence drivingLicence_1=new DrivingLicence(date_1,true);
private Customer customer_1=new Customer(person_1,drivingLicence_1);
@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getFirst_component() 
* 
*/ 
@Test
public void testGetFirst_component() throws Exception { 
//TODO: Test goes here...
    System.out.println(customer_1.getFirst_component());
} 

/** 
* 
* Method: getSecond_component() 
* 
*/ 
@Test
public void testGetSecond_component() throws Exception { 
//TODO: Test goes here...
    System.out.println(customer_1.getSecond_component());
} 

/** 
* 
* Method: getThird_component() 
* 
*/ 
@Test
public void testGetThird_component() throws Exception { 
//TODO: Test goes here...
    System.out.println(customer_1.getThird_component());

} 

/** 
* 
* Method: getDrivingLicenceNumber() 
* 
*/ 
@Test
public void testGetDrivingLicenceNumber() throws Exception { 
//TODO: Test goes here...
    System.out.println(customer_1.getDrivingLicenceNumber());
    System.out.println(customer_1.getThird_component());
} 

/** 
* 
* Method: isFullLicence() 
* 
*/ 
@Test
public void testIsFullLicence() throws Exception { 
//TODO: Test goes here...
    System.out.println(customer_1.isFullLicence());
} 

/** 
* 
* Method: getDrivingLicenceIssueDate()
* 
*/ 
@Test
public void testGetDrivingLicenceIssuedate() throws Exception { 
//TODO: Test goes here...
    System.out.println(customer_1.getDrivingLicenceIssueDate());
} 

/** 
* 
* Method: getCustomersName() 
* 
*/ 
@Test
public void testGetCustomersName() throws Exception { 
//TODO: Test goes here...
    System.out.println(customer_1.getCustomersName());
} 

/** 
* 
* Method: getCustomersDob() 
* 
*/ 
@Test
public void testGetCustomersDob() throws Exception { 
//TODO: Test goes here...
    System.out.println(customer_1.getCustomersDob());
} 


/** 
* 
* Method: setFirst_component() 
* 
*/ 
@Ignore
public void testSetFirst_component() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = Customer.getClass().getMethod("setFirst_component");
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: setSecond_component() 
* 
*/ 
@Ignore
public void testSetSecond_component() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = Customer.getClass().getMethod("setSecond_component");
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: setThird_component() 
* 
*/ 
@Ignore
public void testSetThird_component() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = Customer.getClass().getMethod("setThird_component");
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
