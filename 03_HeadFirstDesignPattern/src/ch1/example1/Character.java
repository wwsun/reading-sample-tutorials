package ch1.example1;

public abstract class Character {
	WeaponBehavior weapon;
	
	public abstract void fight();

	public void setWeapon(WeaponBehavior weapon) {
		this.weapon = weapon;
	}

	public void performWeaponBehavior() {
		weapon.useWeapon();
	}
	
}
