package AimsPackage;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	
	public void addDigitalVideoDisc (DigitalVideoDisc disc) {
		if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is full.");
		} else {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered ++;
			System.out.println("The disc has been added to your cart");
		}
	}
	
	public void removeDigitalVideoDisc (DigitalVideoDisc disc) {
		boolean removed = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].equals(disc)) {
                System.arraycopy(itemsOrdered, i + 1, itemsOrdered, i, qtyOrdered - i - 1);
                qtyOrdered--;
                removed = true;
                break;
            }
        }
        if (removed) {
            System.out.println("The disc has been removed.");
        } else {
            System.out.println("The disc is not in the cart.");
        }
    }

    public double totalCost() {
        double total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }
}
