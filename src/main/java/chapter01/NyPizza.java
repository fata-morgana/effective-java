package chapter01;

import java.util.Objects;

public class NyPizza extends Pizza {
	public enum Size { SMALL, MEDIUM, LARGE }
	private final Size size;
	
	public static class Builder extends Pizza.Builder<Builder> {
		private final Size size;
		
		public Builder(Dough dough, Size size) {
		  super(dough);
			this.size = Objects.requireNonNull(size);
		}
		
		public NyPizza build() {
			return new NyPizza(this);
		}
		
		protected Builder self() {
			return this;
		}
	}
	
	private NyPizza(Builder builder) {
		super(builder);
		this.size = builder.size;
	}

	public Size getSize() {
		return size;
	}
}
