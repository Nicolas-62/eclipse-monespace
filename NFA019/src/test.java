import java.util.ArrayList;
import java.util.List;

public class test {

	public static void main(String[] args) {
		
		List<Salarie>listSalarie = new ArrayList<Salarie>();
		Salarie nico1 = new Salarie("nicolas","lourdel");
		Salarie nico2 = new Salarie("nicolas","lejardinier");
		Salarie nico3 = new Salarie("nicolas","canteloup");
		Salarie nico4 = new Salarie("nicolas","sarkozy");
		Salarie nico5 = new Salarie("nicolas","cage");
		listSalarie.add(nico1);
		listSalarie.add(nico2);
		listSalarie.add(nico3);
		listSalarie.add(nico4);
		listSalarie.add(nico5);
		
		for(Salarie salarie : listSalarie) {
			System.out.println(salarie);
		}
		
		
		
		

	}

}
