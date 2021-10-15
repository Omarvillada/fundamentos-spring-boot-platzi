package com.fundamentosplatzi.springboot.fundamentos;

import com.fundamentosplatzi.springboot.fundamentos.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.fundamentos.component.ComponentDependency;
import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import com.fundamentosplatzi.springboot.fundamentos.pojo.UserPojo;
import com.fundamentosplatzi.springboot.fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	//Inyeccion de dependencia
	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;
	private UserRepository userRepository;


	//Se inyecta dependencia
	//Qualifier llamamos la dependencia que queremos segregar
	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo, UserRepository userRepository){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}

	//Este metodo inicializa toda la arquitectuta y la configuracion del proyecto springcboot aplicacion
	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//ejemplosAnteriores();
		//saveUsersInDataBase();
	}

	private void saveUsersInDataBase(){
		User user1 = new User("omar", "olvillada@gmail.com", LocalDate.of(2021,1,20));
		User user2 = new User("andres", "andres@gmail.com", LocalDate.of(2022,2,19));
		User user3 = new User("daniela", "daniela@gmail.com", LocalDate.of(2021,3,23));
		User user4 = new User("felipe", "felipe@gmail.com", LocalDate.of(2021,4,30));
		User user5 = new User("carlos", "carlos@gmail.com", LocalDate.of(2021,5,10));
		User user6 = new User("user6", "user6@gmail.com", LocalDate.of(2021,6,11));
		User user7 = new User("user7", "user7@gmail.com", LocalDate.of(2021,7,11));
		User user8 = new User("user8", "user8@gmail.com", LocalDate.of(2021,8,12));
		User user9 = new User("user9", "user9@gmail.com", LocalDate.of(2021,9,8));
		User user10 = new User("user10", "user10@gmail.com", LocalDate.of(2021,10,19));
		User user11 = new User("user11", "user11@gmail.com", LocalDate.of(2021,11,27));
		List<User> list = Arrays.asList(user1,user2,user3,user3,user4,user5,user6,user7,user8,user9,user10,user11);
		list.stream().forEach(userRepository::save);


	}

	private void ejemplosAnteriores(){
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getEmail()+"-"+userPojo.getPassword());
		try {
			int value = 10/0;
			LOGGER.info("Mi valor: "+value);
		}catch (Exception e){
			LOGGER.error("Esto es un error al dividir por cero" + e.getMessage());
		}
		LOGGER.error("Esto es un error de la aplicacion");
	}
}
