package test;

import java.util.List;

import dao.DdxxDAO;
import entity.Ddxx;
import junit.framework.TestCase;

public class TestDdxx extends TestCase {

	DdxxDAO ddxxDAO = new DdxxDAO();

	public void testSave() {
		Ddxx ddxx = new Ddxx();
		ddxx.setStatus("P");

		ddxxDAO.save(ddxx);
	}

	public void testDelete() {
		Ddxx ddxx = new Ddxx();
		ddxx.setId(2);

		ddxxDAO.delete(ddxx);
	}

	public void testUpdate() {
		Ddxx ddxx = new Ddxx();
		ddxx.setId(1);
		ddxx.setStatus("q");

		ddxxDAO.update(ddxx);
	}

	public void testfind() {
		String status = "p";

		List<Ddxx> list = ddxxDAO.findstatue(status);
		for (int i = 0; i < list.size(); i++) {
			Ddxx d = list.get(i);
			System.out.print(d.getId());
			System.out.print(d.getStatus());
			System.out.println();
		}

	}

	public void testlist() {

		List<Ddxx> list = ddxxDAO.listall();
		for (int i = 0; i < list.size(); i++) {
			Ddxx d = list.get(i);
			System.out.print(d.getId());
			System.out.print(d.getStatus());
			System.out.println();
		}

	}

}
