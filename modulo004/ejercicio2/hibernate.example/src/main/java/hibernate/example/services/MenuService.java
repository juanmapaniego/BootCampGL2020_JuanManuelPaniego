package hibernate.example.services;

import java.util.List;

import hibernate.example.dao.MenuDao;
import hibernate.example.model.Menu;


public class MenuService {
	private MenuDao menuDao;
	
	public MenuService() {
		menuDao = MenuDao.getInstance();
	}
	
	public boolean createMenu(Menu menu) {
		return this.menuDao.createMenu(menu);
	}
	
	public List<Menu> getMenues() {
		return this.menuDao.getMenues();
	}
	
	public Menu getMenu(Long id){
		return this.menuDao.getMenu(id);
	}
	
	public boolean updateMenu(Menu menu) {
		return this.menuDao.updateMenu(menu);
	}
	
	public void removeMenu(Menu menu) {
		this.menuDao.removeMenu(menu);
	}
}
