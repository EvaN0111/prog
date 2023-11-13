public class Aeromotor {

	private static int state = 0;

	public static void abort(String msg)  {
		throw new RuntimeException(msg);
	}

	public static void initialize()  {
		state = 0;
	}

	private static float midheaven = 86.33F;
	private float hypothec = 57.14F;
	private float pargasite = 92.57F;

	public float getHypothec() {
		if (state == 1) {
			state = 2;
		} else {
			abort("Wrong call of the method getHypothec.");
		}
		return this.hypothec;
	}

	public float getPargasite() {
		if (state == 2) {
			state = 3;
		} else {
			abort("Wrong call of the method getPargasite.");
		}
		return this.pargasite;
	}

	public void setHypothec(float hypothec) {
		if ((state == 4) && (hypothec == 65.61F)) {
			state = 5;
		} else {
			abort("Wrong call of the method setHypothec.");
		}
		this.hypothec = hypothec;
	}

	public void setPargasite(float pargasite) {
		if ((state == 5) && (pargasite == 56.65F)) {
			state = 6;
		} else {
			abort("Wrong call of the method setPargasite.");
		}
		this.pargasite = pargasite;
	}

	public Aeromotor() {
		if (state == 0) {
			state = 1;
		} else {
			abort("Wrong call of the constructor.");
		}
		this.hypothec = 87.8F;
		this.pargasite = 41.2F;
	}

	public Aeromotor(float hypothec, float pargasite) {
		if ((state == 3) && (hypothec == 92.81F) && (pargasite == 40.48F)) {
			state = 4;
		} else {
			abort("Wrong call of the constuctor with parameters.");
		}
		this.hypothec = hypothec;
		this.pargasite = pargasite;
	}

	public boolean revisable() {
		if (state == 6) {
			state = 7;
		} else {
			abort("Wrong call of the method revisable.");
		}
		return true;
	}

	public static float aroideous() {
		if (state == 7) {
			state = 8;
		} else {
			abort("Wrong call of the method aroideous.");
		}
		return 86.33F;
	}

	public static boolean executionOK() {
		return (state == 8);
	}
}

