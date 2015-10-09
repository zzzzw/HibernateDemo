package test;

import java.util.List;

import junit.framework.TestCase;
import dao.StationDAO;
import entity.Station;

public class TestStation extends TestCase {

	StationDAO dao = new StationDAO();

	public void testSave() {
		Station s = new Station();

		s.setCzmc("广州东");
		s.setDj("一级");

		dao.save(s);

		System.out.println("保存成功");

	}

	public void testUpdate() {
		fail("Not yet implemented");
	}

	public void testDelete() {
		fail("Not yet implemented");
	}

	public void testGet() {
		fail("Not yet implemented");
	}

	public void testListall() {
		fail("Not yet implemented");
	}

	public void testfindByproperty() {

		List<Station> list = dao.findByproperty("京");

		for (Station s : list) {
			System.out.println(s);
		}
	}

	public void testfindByKey() {

		List<Station> list = dao.findByKey("京", "一级");

		for (Station s : list) {
			System.out.println(s);
		}

	}

	public void testSearch() {
		Station s = new Station();

		s.setCzdm(-1);
		s.setDj("一级");

		List<Station> result = dao.find(s);

		for (Station st : result) {
			System.out.println(st);
		}
	}

	public void testfindonebydj() {
		String dj = "一";
		List<String> list = dao.findonebydj(dj);

		for (String o : list) {
 
			System.out.println(o);
		}

	}

	public void testfindManybydj() {
		String dj = "一";
		List<String[]> list = dao.findmanybydj(dj);

		//第一种遍历方式
		for (String[] o : list) {
			System.out.println(o[0].toString() + "," + o[1].toString());

		}

		System.out.println();

		//第二种遍历方式
		for (String[] o : list) {
			for (int i = 0; i < o.length; i++) {
				System.out.print(o[i] + ",");

			}
			System.out.println();
		}

	}

	public void testfindManysbydj() {
		String dj = "广州东";
		List<String[]> list = dao.findmanysbydj(dj);

		for (String[] o : list) {
			System.out.println(o[0].toString() + "," + o[1].toString() + ","
					+ o[2].toString() + "," + o[3].toString());

		}

		System.out.println();

	}

	public void testexcuteFzDelete() {
		Integer id = 2;

		Integer result = dao.excuteFzDelete(id);

		System.out.println("删除结果为：" + result);
	}
	
	public void testexcuteFzUpdate()
	{
		
		Integer id=10;
		int a=dao.excuteFzUpdate(id);
		
		System.out.println("更新结果为：" + a);
		
		
	}
	
	public void testsearchLineByStation()
	{
		String czmc="北京";
		List<String> list = dao.searchLineByStation(czmc);

		for (String o : list) {
 
			System.out.println(o);
		}
	}
	
	public void testsearchStationByLine()
	{
		String xlmc="京广线";
		List<String[]> list=dao.searchStationByLine(xlmc);
		for(String[] l:list)
		{
			System.out.println(l[0]+","+l[1]+","+l[2]);
		}
	}

}
