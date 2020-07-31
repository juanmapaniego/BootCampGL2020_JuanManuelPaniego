package mockito.example.services.impl;

import java.util.List;

import mockito.example.services.DataService;

public class DataServiceImpl implements DataService {

	private List<Integer> listOfNumbers;
	
	public DataServiceImpl(List<Integer> list) {
		this.listOfNumbers = list;
	}
	
	@Override
	public int[] getListOfNumbers() {
		int[] res = new int[this.listOfNumbers.size()];
		for (int i = 0; i < res.length; i++) {
			res[i] = this.listOfNumbers.get(i);
		}
		return res;
	}
	
}
