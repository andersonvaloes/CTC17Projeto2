package trabalho;

import java.util.Random;

public class MaxGlobal {
	public double functionMax(double x, double y) {
		return 4*Math.exp(-(x*x+y*y)) 
				+ Math.exp(-((x-5.0)*(x-5.0)+(y-5.0)*(y-5.0)))
				+ Math.exp(-((x+5.0)*(x+5.0)+(y-5.0)*(y-5.0)))
				+ Math.exp(-((x-5.0)*(x-5.0)+(y+5.0)*(y+5.0)))
				+ Math.exp(-((x+5.0)*(x+5.0)+(y+5.0)*(y+5.0)));
	}
	
	public static void main(String[] args) {
		MaxGlobal m = new MaxGlobal();
		Random g = new Random();
		double T = 1;
		double i = 10, j = 1, ia, ja;
		double cur = m.functionMax(i, j);
		double next;
		double dif;
		while(true) {
			if(T < 0.0000000000000000000000000001) break;
			ia = i;
			ja = j;
			i = 100*(g.nextDouble()-0.5);
			j = 100*(g.nextDouble()-0.5);
			next = m.functionMax(i, j);
			dif = m.functionMax(i, j) - m.functionMax(ia, ja);
			if(dif > 0) {
				cur = next;
			}else {
				if(g.nextDouble() < Math.exp(dif/T)) {
					cur = next;
				}else {
					i = ia;
					j = ja;
				}
			}
			T = T*0.999999;
		}
		
		System.out.println("Atual : " + cur);
		System.out.println("T : " + T);
		System.out.println("i j : " + i + " " + j);
	}
}
