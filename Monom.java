 

public class Monom {

	private int exp;
	private double coeff;
	
	public Monom(int exp, double coeff) {
		this.exp = exp;
		this.coeff = coeff;
	}

	public int getExp() {
		return this.exp;
	}
	
	public double setCoeff(double x){
		return this.coeff = x;
	}

	public double getCoeff() {
		return this.coeff;
	}

	
	public Monom add (Monom m){
		if (this.exp!=m.getExp())
			return null;
		this.setCoeff(this.coeff+m.getCoeff());
		return this;
	 }
	
	public Monom sub (Monom m){
		if(this.exp!=m.getExp())
			return null;
		this.setCoeff(this.coeff-m.getCoeff());
		return this;
	}
	
	
	
/*	
	 public Monom sub (Monom m1, Monom m2){

	 }
	
	 public Monom der(Monom m){
	 int x = m.coeff.intValue() * m.exp;
	 m.coeff = x;
	 x = m.coeff.intValue() - 1;
	 m.coeff = x;
	 return m;
	 }
	
	 public Monom intgr(Monom m){
	 m.exp = m.exp + 1;
	 double x = m.coeff.doubleValue() / m.exp;
	 m.coeff = x;
	 return m;
	 }	
	*/
}
