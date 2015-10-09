package test;

import java.sql.Date;
import java.util.List;

import junit.framework.TestCase;
import dao.XOrderDAO;
import entity.XOrder;

public class TestXOrder extends TestCase {

	public void testUpdate() {
		XOrderDAO d = new XOrderDAO();

		XOrder entity = new XOrder();
		entity.setId(1); // 默认是根据ID更新
		entity.setName("aaaaaaaa");

		d.update(entity);

		System.out.println("更新成功");

	}

	public void testSave() {
		XOrderDAO d = new XOrderDAO();

		XOrder entity = new XOrder();
		entity.setName("张三");
		entity.setStarttime(Date.valueOf("2015-9-9"));
		entity.setPrice(12.365f);

		d.save(entity);

		System.out.println("保存成功");
	}

	public void testDelete() {
		XOrderDAO d = new XOrderDAO();
		XOrder entity = new XOrder();
		entity.setId(1); // 默认根据ID删除

		d.delete(entity);

		System.out.println("删除成功");

	}

	public void testFindById() {
		XOrderDAO d = new XOrderDAO();

		XOrder x = d.get(4);

		System.out.println(x.getName() + "," + x.getPrice() + ","
				+ x.getStarttime());

	}

	public void testFindByProperty() {
		XOrderDAO d = new XOrderDAO();

		List<XOrder> result = d.findByProperty("name", "%g%");

		for (XOrder x : result) {
			System.out.println(x.getName() + "," + x.getPrice() + ","
					+ x.getStarttime());

		}

	}

	public void testFindAll() {
		XOrderDAO d = new XOrderDAO();

		// 泛型
		List<XOrder> result = d.listall();

		for (XOrder x : result) {
			System.out.println(x.getName() + "," + x.getPrice() + ","
					+ x.getStarttime());

		}

	}

}
