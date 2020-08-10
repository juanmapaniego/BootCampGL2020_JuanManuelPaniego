package hibernate.example;

import hibernate.example.services.MenuService;
import hibernate.example.model.Menu;

public class MenuApplication {

	public static void main(String[] args) {
		Menu milanesa = new Menu(1L,
				"Milanesa clasica",
				"una delicada milanesa con crocantes papas fritas finamente seleccionadas",
				500.0);
		
		Menu lomo = new Menu(2L,
				"Lomo a la piedra",
				"un curioso plato donde se utilizan piedras calentadas al rojo vivo para cocinar el\n" + 
						"lomo junto a especias orientales y sudamericanas logrando un elixir entre la textura y el sabor.",
						750.0);
		
		//Create Menu
		MenuService menuService = new MenuService();
		menuService.createMenu(lomo);
		menuService.createMenu(milanesa);
		
		//List
		System.out.println("menu:");
		for (Menu menu : menuService.getMenues()) {
			System.out.println("- plato:\n");
			System.out.println(menu);
		}
	}

}
