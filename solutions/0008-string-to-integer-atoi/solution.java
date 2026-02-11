class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        } 
        int value = 0, state = 0, sign = 1;
                
        loop: for (char c : s.toCharArray()) {
            switch (state) {
                // STATE 0: last processed: whitespace (OR processing just started)
                case 0 :
                    if (c == ' ')
                        state = 0;
                    else if (c == '+' || c == '-') {
                        state = 1;                   
                        sign = c == '-' ? -1 : 1;
                    }
                    else if (Character.isDigit(c)) {
                        state = 2;
                        value = value * 10 + (c - '0');
                    }
                    else
                        return 0;
                    break;
                    
                // STATE 1: last processed: '+' or '-' sign
                case 1 :
                    if (Character.isDigit(c)) {
                        state = 2;
                        value = value * 10 + (c - '0');
                    }
                    else
                        return 0;
                    break;
                    
                // STATE 2: last processed: number
                case 2 :
                    if (Character.isDigit(c)) {
                        state = 2;
                        if (value > Integer.MAX_VALUE / 10 
                            || (value == Integer.MAX_VALUE / 10 
                                && c - '0' > Integer.MAX_VALUE % 10)) {
                            return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                        }
                        value = value * 10 + (c - '0');
                    }
                    else
                        break loop;
                    break;  
            }                        
        }
        
        return sign * value;
    }
}
