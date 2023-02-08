package com.FileReader.service;

import java.io.File;


import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.FileReader.model.Customer;
import com.FileReader.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repo;

	public void saveCustomerData() {
		File file = new File("src/main/resources/file_upload.txt");
		Scanner sc;
		try {
			sc = new Scanner(file);
			sc.nextLine();
			sc.nextLine();
			sc.nextLine();
			sc.nextLine().replaceAll("\\s", "").strip();

			while (sc.hasNextLine()) {

				// String input = ;
				String CARD_TYPE[] = sc.nextLine().split("[|]");
				Customer customer = new Customer();

				customer.setCard_type(CARD_TYPE[1]);
				customer.setTitle(CARD_TYPE[2]);
				customer.setName(CARD_TYPE[3]);
				customer.setD_o_b(CARD_TYPE[4]);
				customer.setSex(CARD_TYPE[5]);
				customer.setAdress(CARD_TYPE[6]);
				customer.setLimit_amt(CARD_TYPE[7]);
				repo.save(customer);

			}
			sc.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Customer>listAll(){
		return repo.findAll();
	}
	public Customer get (Integer id) {
		return repo.findById(id).get();
	}

}