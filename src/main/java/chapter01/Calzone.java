package chapter01;

public class Calzone extends Pizza {
	private final boolean sauceInside;
	
	public static class Builder extends Pizza.Builder<Builder> {
	  private boolean sauceInside = false;
	  
	  public Builder(Dough dough) {
	    super(dough);
	  }
	  
	  public Builder sauceInside() {
	    sauceInside = true;
	    return this;
	  }

		@Override
		protected Builder self() {
			return this;
		}

		@Override
		public Calzone build() {
			return new Calzone(this);
		}
		
	}

	Calzone(Builder builder) {
		super(builder);
		this.sauceInside = true;
	}

}
