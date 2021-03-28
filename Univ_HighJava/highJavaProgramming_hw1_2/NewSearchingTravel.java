package highJavaProgramming_hw1_2;

import java.util.ArrayList;
import java.util.List;


public class NewSearchingTravel {
	public static final String COUNTRY_VIETNAM ="vietnam";
	public static final String COUNTRY_PHILLIPHINE ="philliphine";
	public static final String COUNTRY_TAILAND="tailand";
	
	private List<TravelInfoV0> travelInfoList = new ArrayList<>();
	
	public NewSearchingTravel() {
		initializeProduct();
	}
	
	// 데이터를 초기화하며 외부에서 호출하지 못하도록 private으로 선언 
	private void initializeProduct() {
		TravelInfoV0 cebu=new TravelInfoV0();
		cebu.setName("Cebu Travel");
		cebu.setCountry(COUNTRY_PHILLIPHINE);
		cebu.setCity("Cebu");
		cebu.setDays(5);
		cebu.setNights(3);
		travelInfoList.add(cebu);
		
		TravelInfoV0 boracay=new TravelInfoV0();
		boracay.setName("Boracay Travel");
		boracay.setCountry(COUNTRY_PHILLIPHINE);
		boracay.setCity("boracay");
		boracay.setDays(5);
		boracay.setNights(3);
		travelInfoList.add(boracay);
		
		TravelInfoV0 hanoi=new TravelInfoV0();
		hanoi.setName("Hanoi Travel");
		hanoi.setCountry(COUNTRY_VIETNAM);
		hanoi.setCity("hanoi");
		hanoi.setDays(3);
		hanoi.setNights(2);
		travelInfoList.add(hanoi);
		
		TravelInfoV0 danang=new TravelInfoV0();
		danang.setName("Danang Travel");
		danang.setCountry(COUNTRY_VIETNAM);
		danang.setCity("danang");
		danang.setDays(6);
		danang.setNights(4);
		travelInfoList.add(danang);
		
		TravelInfoV0 bankok=new TravelInfoV0();
		bankok.setName("Bankok Travel");
		bankok.setCountry(COUNTRY_TAILAND);
		bankok.setCity("bankok");
		bankok.setDays(5);
		bankok.setNights(3);
		travelInfoList.add(bankok);
	}
	
	//외부에서 전달된 조건으로 검색
	public List<TravelInfoV0> searchTravelInfo(TravelInfoFilter searchCondition){
		List<TravelInfoV0> returnValue =new ArrayList<>();
		
		for(TravelInfoV0 travelInfo : travelInfoList) {
			//인터페이스의 isMatched 메서드 호출 . 실제 구현에 대해서는 캡슐화 되어있다.
			if(searchCondition.isMatched(travelInfo)) {
				
				returnValue.add(travelInfo);
			}
		}
		return returnValue;
	}
	
	/*
	 * 새로 작성한 NewSeachingTravel 클래스를 실행하기 위한 예제 코드 
	 * */
	public static void main(String[] args) {
		NewSearchingTravel travelSearch = new NewSearchingTravel();
		
		//조회 조건을 외부로 분리 
		List<TravelInfoV0> searchTravel = 
				travelSearch.searchTravelInfo(new TravelInfoFilter() {
			@Override
			public boolean isMatched(TravelInfoV0 travelInfo) {
				return travelInfo.getCountry().equals("philliphine");
			}
		});
		
		/*
		List<TravelInfoV0> searchTravel = travelSearch.searchTravelInfo((TravelInfoV0 travelInfo)->travelInfo.getCity().equals("vietnam"));
		*/
		
		for(TravelInfoV0 travelInfo : searchTravel) {
			System.out.println(travelInfo);
		}
		
	}

}
