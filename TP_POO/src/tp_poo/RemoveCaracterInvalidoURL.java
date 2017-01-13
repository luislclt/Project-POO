package tp_poo;


public class RemoveCaracterInvalidoURL {
    
    public static String RemoveCaracterInvalidoURL(String str, char x){
        StringBuilder strBuilder = new StringBuilder();
        char[] rmString = str.toCharArray();
        for(int i=0; i<rmString.length; i++){
            if(rmString[i] == x){

            } else {
                strBuilder.append(rmString[i]);
            }
        }
        return strBuilder.toString();
    }
    
}

/*
        String str = "MXy nameX iXs farXazX";
        char x = 'X';
        System.out.println(RemoveCaracterInvalidoURL(str,x));
*/