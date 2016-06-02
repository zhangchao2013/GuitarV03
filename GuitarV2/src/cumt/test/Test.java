package cumt.test;

import java.util.List;

import cumt.dao.GuitarDao;
import cumt.pojo.Guitar;

public class Test {

	public static void main(String[] args) {
		GuitarDao gt=new GuitarDao();
		Guitar guitar=new Guitar("assdfssd",11.2,"gfg","sdf","sdf","sdf","fgsd");
		List<Guitar> list=gt.search("1");
	
			System.out.println(list.size());
		
		
		
	}
}
