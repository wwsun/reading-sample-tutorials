package ch9;

import java.util.Iterator;

public class DinerMenu {
	static final int MAX_ITEMS = 6;
	int numberOfItems = 0;
	MenuItem[] menuItems;
	
	public Iterator createIterator() {
		return new DinerMenuIterator(menuItems);
	}
}
