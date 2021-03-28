package highJavaProgramming_hw1;

import java.util.ArrayList;
import java.util.List;

public class SearchingTravel {
	public static final String COUNTRY_VIETNAM ="vietnam";
	public static final String COUNTRY_PHILLIPHINE ="philliphine";
	public static final String COUNTRY_TAILAND="tailand";
	
	//여행 상품 저장 
	private List<TravelInfo> travelInfoList=new ArrayList<>();
	
	public SearchingTravel() {
		initializeProduct();
	}
	
	// 데이터를 초기화하며 외부에서 호출하지 못하도록 private으로 선언 
	private void initializeProduct() {
		TravelInfo cebu=new TravelInfo();
		cebu.setName("Cebu Travel");
		cebu.setCountry(COUNTRY_PHILLIPHINE);
		cebu.setCity("Cebu");
		cebu.setDays(5);
		cebu.setNights(3);
		travelInfoList.add(cebu);
		
		TravelInfo boracay=new TravelInfo();
		cebu.setName("Boracay Travel");
		cebu.setCountry(COUNTRY_PHILLIPHINE);
		cebu.setCity("boracay");
		cebu.setDays(5);
		cebu.setNights(3);
		travelInfoList.add(boracay);
		
		TravelInfo hanoi=new TravelInfo();
		cebu.setName("Hanoi Travel");
		cebu.setCountry(COUNTRY_VIETNAM);
		cebu.setCity("hanoi");
		cebu.setDays(3);
		cebu.setNights(2);
		travelInfoList.add(hanoi);
		
		TravelInfo danang=new TravelInfo();
		cebu.setName("Danang Travel");
		cebu.setCountry(COUNTRY_VIETNAM);
		cebu.setCity("danang");
		cebu.setDays(6);
		cebu.setNights(4);
		travelInfoList.add(danang);
		
		TravelInfo bankok=new TravelInfo();
		cebu.setName("Bankok Travel");
		cebu.setCountry(COUNTRY_TAILAND);
		cebu.setCity("bankok");
		cebu.setDays(5);
		cebu.setNights(3);
		travelInfoList.add(bankok);
	}
	
	//국가 정보에 기반해서 여행 상품을 조회한다. 
	public List<TravelInfo> searchTravelInfo(String country){
		List<TravelInfo> returnValue = new ArrayList<>();
		
		for(TravelInfo travelInfo:travelInfoList) {
			if(country.equals(travelInfo.getCountry())) {
				returnValue.add(travelInfo);
			}
		}
		return returnValue;
	}
	
	/*
	 * SearchingTravel 클래스를 사용하는 예제 
	 * */
	
	public static void main(String[] args) {
		SearchingTravel travelSearch =new SearchingTravel();
		// 베트남 여행 상품 목록 조회
		List<TravelInfo> searchList=travelSearch.searchTravelInfo("tailand");
		
		for(TravelInfo searchTravel:searchList) {
			System.out.println(searchTravel);
		}

	}

}

