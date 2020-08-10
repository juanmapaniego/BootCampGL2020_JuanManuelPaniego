package hibernate.example;

import hibernate.example.dao.MenuDao;
import hibernate.example.model.Menu;

public class MenuApplication {

	public static void main(String[] args) {
		Menu milanesa = new Menu();
		milanesa.setId(1L);
		milanesa.setNombre("Milanesa clasica");
		milanesa.setDescripcion("una delicada milanesa con crocantes papas fritas finamente seleccionadas");
		milanesa.setPrecio(500.0);
		
		Menu lomo = new Menu();
		lomo.setId(2L);
		lomo.setNombre("Lomo a la piedra");
		lomo.setDescripcion("un curioso plato donde se utilizan piedras calentadas al rojo vivo para cocinar el\n" + 
				"lomo junto a especias orientales y sudamericanas logrando un elixir entre la textura y el sabor.");
		lomo.setPrecio(750.0);
		
		//Create Menu
		MenuDao menuDao = new MenuDao();
		menuDao.createMenu(lomo);
		menuDao.createMenu(milanesa);
		
		//List
		System.out.println("menu:");
		for (Menu menu : menuDao.getMenues()) {
			System.out.println("- plato:\n");
			System.out.println(menu);
		}
	}

}
