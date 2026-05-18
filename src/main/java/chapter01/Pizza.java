package chapter01;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class Pizza {
	public enum Topping { HAM, MUSHROOM, ONION, PEPPER, SAUSAGE }
	public enum Dough { PAN, THIN, NewYork }
	final Set<Topping> toppings;
	
	abstract static class Builder<T extends Builder<T>> {
		EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
		final Dough dough;
		
		public T addTopping(Topping topping) {
			toppings.add(Objects.requireNonNull(topping));
			return self();
		}
		
		protected abstract T self();
		
		abstract Pizza build();
		
		protected Builder(Dough dough) {
			this.dough = dough;
		}
	}
	
	Pizza(Builder<?> builder) {
		toppings = builder.toppings.clone();
	}
	
}
