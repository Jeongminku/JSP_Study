package ch08;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class RegistService {
	Map<String, Regist> regists = new HashMap<>();
	
	public RegistService() {
		Regist r = new Regist("101","김지우","서울시","silver","010-1111-1111","(일반)");
		regists.put("101", r);

		r = new Regist("102","홍길동","인천시","gold","010-2222-2222","(중간)");
		regists.put("102", r);
		
		r = new Regist("103","율곡","김포시","vip","010-3333-3333","(최상)");
		regists.put("103", r);
		
	}
	
	public List<Regist> findAll(){
		return new ArrayList<>(regists.values()); //Returns a Collection view of the values contained in this map. 
	}
	
	//name으로 원하는 상품을 가져오는 메소드입니다.(select * from where name= xxx)
	public Regist find(String id) {
		return regists.get(id);
	}
	
	
}
