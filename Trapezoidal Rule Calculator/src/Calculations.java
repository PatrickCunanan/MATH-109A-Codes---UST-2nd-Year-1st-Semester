import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

public class Calculations extends Main {
	
	static String convertFrac(float ans) {
	    double tolerance = 1.0E-6;
	    double h1=1; 
	    double h2=0;
	    double k1=0; 
	    double k2=1;
	    double b = ans;
	    do {
	        double a = Math.floor(b);
	        double aux = h1; 
	        h1 = a * h1 + h2; 
	        h2 = aux;
	        aux = k1; 
	        k1 = a * k1 + k2; 
	        k2 = aux;
	        b = 1/(b-a);
	    } while (Math.abs(ans - h1 / k1) > ans * tolerance);
	    DecimalFormat nF = new DecimalFormat ("#");
	    String x = String.valueOf(nF.format(h1));
	    String y = String.valueOf(nF.format(k1));
	    return x + "/" + y;
	}
	
	static void c (ActionEvent ae) throws Exception {
		
		String e;
        float h, a, n, b, sum = 0, ya, yb;
        e = textField.getText();
        e = Functions.infixToPrefix(e);
        a = Float.parseFloat(textField_1.getText());
        b = Float.parseFloat(textField_2.getText());
        n = Float.parseFloat(textField_4.getText());
        if(a > b){
            h = a;
            a = b;
            b = h;
        }
        h = (b - a)/n;
        for(double i = a; i <= b; i+=h){
            sum += Float.parseFloat(Functions.evalPrefix(e, i));
        }
        ya = Float.parseFloat(Functions.evalPrefix(e, a));
        yb = Float.parseFloat(Functions.evalPrefix(e, b));
        float finalans = (h / 2) * (ya + yb + (2 * sum));
        DecimalFormat nF = new DecimalFormat ("#.000"); 
		String Y = String.valueOf(nF.format(finalans));
		String frac = convertFrac(finalans);
		textField_5.setText(frac);
        textField_3.setText(Y);
        
        
	}
}
