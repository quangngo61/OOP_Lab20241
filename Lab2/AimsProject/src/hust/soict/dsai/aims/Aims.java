package hust.soict.dsai.aims;

import hust.soict.dsai.cart.Cart;
import hust.soict.dsai.disc.DigitalVideoDisc;

public class Aims {
	public static void main(String[] args) {
		/*Cart anOrder = new Cart();
        
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd1);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

		System.out.println("Total cost is: ");
		System.out.println(anOrder.totalCost());
		
	    anOrder.removeDigitalVideoDisc(dvd2);
	    System.out.println("Total cost is: " + anOrder.totalCost())*/
		
		Cart cart = new Cart();

        // Create DVD objects
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Frozen", "Animation", 22.99f);

        // Add DVDs using different methods
        cart.addDigitalVideoDisc(dvd1); // Single DVD
        //cart.addDigitalVideoDisc(new DigitalVideoDisc[]{dvd2, dvd3}); // Array of DVDs
        cart.addDigitalVideoDisc(dvd4, dvd1, dvd3); // Varargs

        // Print total cost
        System.out.println("Total cost: " + cart.totalCost());
	}
}
