 

import java.util.ArrayList;

public class Polynomial {

	public int maximumOrder;
	public ArrayList<Monom> monomList;

	public Polynomial() {
		monomList = new ArrayList<Monom>();
	}

	public Polynomial(int maximumOrder) {
		this.maximumOrder = maximumOrder;
		monomList = new ArrayList<Monom>();
	}

	public Polynomial(int maximumOrder, double[] coefficients) {
		// this is the Polynomial constructor
		// parameters:
		// maximumOrder - the highest power that the polynom will have
		// coefficients - a list of coefficients that the polynom will intake.
		// - if the monom has no coefficient, it will take 0.

		this(maximumOrder);

		for (int i = 0; i < maximumOrder; i++) {
			Monom m = new Monom(i, coefficients[i]);
			monomList.add(m);
		}

	}

	public Polynomial(Polynomial pol) {
		this.monomList = new ArrayList<Monom>();
		for (Monom mon : pol.monomList) {
			this.monomList.add(new Monom(mon.getExp(), mon.getCoeff()));
		}
	}

	public void addMonom(Monom m) {
		this.monomList.add(m);
	}

	public Polynomial add(Polynomial p) {
		for (Monom m : p.monomList) 
		{
			int found = 0;
			for (Monom mon : this.monomList) 
			{
				if (m.getExp() == mon.getExp()) 
				{
					found = 1;
					mon.add(m);
					break;
				}
			}
			if (found == 0)
				this.addMonom(m);
		}
		return this;
	}

	public Polynomial sub(Polynomial p) {
		int maxOrder = getMaxOrder(this, p);

		Polynomial r = new Polynomial(maxOrder);
		int i = 0;

		while (i <= maximumOrder && i <= p.maximumOrder) {
			Monom s = monomList.get(i).sub(p.monomList.get(i));
			r.monomList.add(s);
			i++;
		}

		while (i <= maximumOrder) {
			r.monomList.add(monomList.get(i));
			i++;
		}

		while (i <= p.maximumOrder) {
			r.monomList.add(p.monomList.get(i));
		}

		if (p.maximumOrder > maximumOrder) {
			for (Monom mon : this.monomList) {
				mon.setCoeff(0);
			}
		}

		return r;
	}

	public Polynomial mult(Polynomial p){
		Polynomial res=new Polynomial();
		for(Monom mon1:this.monomList)
		{
			for(Monom mon2:p.monomList)
			{
				Monom mr=new Monom(mon1.getExp()+mon2.getExp(),mon1.getCoeff()*mon2.getCoeff());
				Polynomial pr=new Polynomial();
				pr.addMonom(mr);
				res.add(pr);
			}
		}
		return res;
	}
	
	public Polynomial diff() {
		Polynomial r = new Polynomial();

		for (Monom mon : this.monomList) {
			double coeff = mon.getExp() * mon.getCoeff();
			int power = mon.getExp() - 1;
			if (power >= 0) {
				Monom m = new Monom(power, coeff);
				r.addMonom(m);
			}

		}
		return r;
	}

	public Polynomial integration() {
		Polynomial r = new Polynomial();

		for (Monom mon : this.monomList) {
			int power = mon.getExp() + 1;
			double coeff = mon.getCoeff() / mon.getExp();
			Monom m = new Monom(power, coeff);
			r.addMonom(m);
		}
		return r;
	}

	public static int getMaxOrder(Polynomial p1, Polynomial p2) {
		if (p1.maximumOrder > p2.maximumOrder)
			return p1.maximumOrder;
		return p2.maximumOrder;

	}

	public String PolynomialToString() {
		String s = "";
		for (Monom m : monomList)
			s += m.getCoeff() + "X^" + m.getExp() + " ";
		return s;
	}

	public static Polynomial createPolynomial(String line) {
		String[] tokens = line.split(" ");

		Polynomial p = new Polynomial(tokens.length - 1);
		for (int i = 0; i < tokens.length; i++) {
			p.monomList.add(new Monom(i, Double.parseDouble(tokens[i])));
		}
		return p;
	}
}
