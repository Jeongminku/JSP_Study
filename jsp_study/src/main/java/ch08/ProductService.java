package ch08;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

//데이터 샘플을 제공해주는 클래스.
public class ProductService { //HashMap은 "키","값"을 저장할 수 있음.
	Map<String, Product> products = new HashMap<>();
	
	public ProductService() {
		Product p = new Product("101", "사과폰12", "애플", 1200000, "2020.12.12");
		products.put("101", p);
		
		p = new Product("102", "우주폰22", "삼성전자", 1300000, "2021.12.12");
		products.put("102", p);
	
		p = new Product("103", "키폰33", "노키아", 1400000, "2022.12.12");
		products.put("103", p);
	}
	
	//모든 상품 데이터를 가져오는 메소드입니다.(select * from 같은 느낌.)
	public List<Product> findAll(){
		return new ArrayList<>(products.values()); //Returns a Collection view of the values contained in this map. 
	}
	
	//id로 원하는 상품을 가져오는 메소드입니다.(select * from where id= xxx)
	public Product find(String id) {
		return products.get(id);
	}
	
}
