import java.util.Stack;

public class Functions {
	   public static String evalPrefix(String e, double x){
	        String s[] = e.split(" ");
	        Stack<String> s1 = new Stack<>();
	        String A;
	        String B;
	        double C;
	        for(int i = s.length - 1; i >= 0 ; i--){
	            switch(s[i]){
	                case"%":
	                    A = s1.pop();
	                    B = s1.pop();
	                    C = Double.parseDouble(A) % Double.parseDouble(B);
	                    s1.push(C + "");
	                    break;
	                case"^":
	                    A = s1.pop();
	                    B = s1.pop();
	                    C = Math.pow(Double.parseDouble(A), Double.parseDouble(B));
	                    s1.push(C + "");
	                    break;
	                case"*":
	                    A = s1.pop();
	                    B = s1.pop();
	                    C = Double.parseDouble(A) * Double.parseDouble(B);
	                    s1.push(C + "");
	                    break;
	                case"/":
	                    A = s1.pop();
	                    B = s1.pop();
	                    C = Double.parseDouble(A) / Double.parseDouble(B);
	                    s1.push(C + "");
	                    break;
	                case"-":
	                    A = s1.pop();
	                    B = s1.pop();
	                    C = Double.parseDouble(A) - Double.parseDouble(B);
	                    s1.push(C + "");
	                    break;
	                case"+":
	                    A = s1.pop();
	                    B = s1.pop();
	                    C = Double.parseDouble(A) + Double.parseDouble(B);
	                    s1.push(C + "");
	                    break;
	                case"]":
	                    String g = "";
	                    i--;
	                    while(!s[i].equals("sqrt[") & !s[i].equals("sin[") & !s[i].equals("cos[")
	                            & !s[i].equals("tan[") & !s[i].equals("sec[") & !s[i].equals("csc[") 
	                            & !s[i].equals("cot[") & !s[i].equals("asin[") & !s[i].equals("acos[")
	                            & !s[i].equals("atan[") & !s[i].equals("asec[") & !s[i].equals("acsc[")
	                            & !s[i].equals("acot[") & !s[i].equals("abs[") & !s[i].equals("ln[")
	                            & !s[i].equals("log[")){
	                        g = s[i] + g;
	                        if(!s[i - 1].equals("sqrt[") & !s[i - 1].equals("sin[") & !s[i - 1].equals("cos[")
	                            & !s[i - 1].equals("tan[") & !s[i - 1].equals("sec[") & !s[i- 1].equals("csc[") 
	                            & !s[i - 1].equals("cot[") & !s[i - 1].equals("asin[") & !s[i - 1].equals("acos[")
	                            & !s[i - 1].equals("atan[") & !s[i - 1].equals("asec[") & !s[i- 1].equals("acsc[")
	                            & !s[i - 1].equals("acot[") & !s[i - 1].equals("abs[") & !s[i - 1].equals("ln[")
	                            & !s[i - 1].equals("log[")){
	                            g = " " + g;
	                        }
	                        i--;
	                    }
	                    switch(s[i]){
	                        case"sqrt[":
	                            s1.push(Math.sqrt(Double.parseDouble(evalPrefix(g, x))) + "");
	                            break;
	                        case"sin[":
	                            s1.push(Math.sin(Double.parseDouble(evalPrefix(g, x))) + "");
	                            break;
	                        case"cos[":
	                            s1.push(Math.cos(Double.parseDouble(evalPrefix(g, x))) + "");
	                            break;
	                        case"tan[":
	                            s1.push(Math.tan(Double.parseDouble(evalPrefix(g, x))) + "");
	                            break;
	                        case"csc[":
	                            s1.push(Math.sin(1/Double.parseDouble(evalPrefix(g, x))) + "");
	                            break;
	                        case"sec[":
	                            s1.push(Math.cos(1/Double.parseDouble(evalPrefix(g, x))) + "");
	                            break;
	                        case"cot[":
	                            s1.push(Math.tan(1/Double.parseDouble(evalPrefix(g, x))) + "");
	                            break;
	                        case"asin[":
	                            s1.push(Math.asin(Double.parseDouble(evalPrefix(g, x))) + "");
	                            break;
	                        case"acos[":
	                            s1.push(Math.acos(Double.parseDouble(evalPrefix(g, x))) + "");
	                            break;
	                        case"atan[":
	                            s1.push(Math.atan(Double.parseDouble(evalPrefix(g, x))) + "");
	                            break;
	                        case"acsc[":
	                            s1.push(Math.asin(1/Double.parseDouble(evalPrefix(g, x))) + "");
	                            break;
	                        case"asec[":
	                            s1.push(Math.asin(1/Double.parseDouble(evalPrefix(g, x))) + "");
	                            break;
	                        case"acot]":
	                            s1.push(Math.asin(1/Double.parseDouble(evalPrefix(g, x))) + "");
	                            break;
	                        case"abs[":
	                            s1.push(Math.abs(Double.parseDouble(evalPrefix(g, x))) + "");
	                            break;
	                    }
	                    break;
	                default:
	                    switch (s[i]){
	                        case"x":
	                        case"X":
	                            s1.push("" + x);
	                            break;
	                        case"e":
	                        case"E":
	                            s1.push("" + Math.E);
	                            break;
	                        case"pi":
	                        case"Pi":
	                        case"PI":
	                            s1.push("" + Math.PI);
	                            break;
	                        default:
	                            s1.push(s[i]);
	                            break;
	                    }
	                break;
	            }
	        }
	        return s1.pop();
	    }
	    
	    public static String infixToPrefix(String e){
	        String[] s = e.split(" ");
	        String pre = "";
	        Stack<String> op = new Stack<>();
	        Stack<String> eq = new Stack<>();
	        for(int i = s.length - 1; i >= 0; i--){
	            switch(s[i]){
	                case"sqrt[":
	                case"sin[":
	                case"cos[":
	                case"tan[":
	                case"asin[":
	                case"acos[":
	                case"atan[":
	                case"csc[":
	                case"sec[":
	                case"cot[":
	                case"acsc[":
	                case"asec[":
	                case"acot[":
	                case"abs[":
	                case"ln[":
	                case"log[":
	                    while(!op.isEmpty()){
	                        eq.push(op.pop());
	                    }
	                    eq.push(s[i]);
	                    break;
	                case"(":
	                case")":
	                case"^":
	                case"*":
	                case"/":
	                case"-":
	                case"+":
	                case"%":
	                    while(!op.isEmpty() && isFollowed(s[i], op.peek())){
	                        eq.push(op.pop());
	                    }
	                    if(s[i].equals("(")){
	                        op.pop();
	                    }
	                    else{
	                        op.push(s[i]);
	                    }
	                    break;
	                default:
	                    eq.push(s[i]);
	                    break;
	            }
	        }
	        while(!op.isEmpty()){
	                eq.push(op.pop());
	            }
	        while(!eq.isEmpty()){
	            pre = pre + eq.pop() + " ";
	        }
	        return pre;
	    }
	    
	    public static boolean isFollowed(String a, String b){
	        if(a.equals(")")){
	            return false;
	        }
	        if(a.equals("(")){
	            return !b.equals(")");
	        }
	        switch(a){
	            case"+":
	            case"-":
	                if(b.equals("/") || b.equals("*")){
	                    return true;
	                }
	            case"*":
	            case"/":
	                if(b.equals("%")){
	                    return true;
	                }
	            case"%":
	                if(b.equals("^") || b.equals("%")){
	                    return true;
	                }
	            case"^":
	                if(b.equals("^")){
	                    return true;
	                }
	            default:
	                return false;
	        }
	    }
}
