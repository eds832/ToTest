public class UserInput {
    
    public static class TextInput {
    	public StringBuilder value = new StringBuilder();
    	public void add(char c) {
    		value.append(new Character(c).toString());
    	}
    	
    	public String getValue() {
    		return value.toString();
    	}
    }

    public static class NumericInput extends TextInput {
    	public StringBuilder numericValue = new StringBuilder();
    	@Override
    	public void add(char c) {
    		switch(c) {
    		case '0' : 
    		case '1' :
    		case '2' :
    		case '3' : 
    		case '4' :
    		case '5' :
    		case '6' : 
    		case '7' :
    		case '8' :
    		case '9' : numericValue.append(new Character(c).toString());
    		break;
    		}
    	}
    	@Override
    	public String getValue() {
    		return numericValue.toString();
    	}
    	
    } 

    public static void main(String[] args) {
        TextInput input = new NumericInput();
        input.add('1');
        input.add('a');
        input.add('0');
        System.out.println(input.getValue());
    }
}
