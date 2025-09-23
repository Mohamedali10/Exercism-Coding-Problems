public class LogLevels {
    
    
    public static String message(String logLine) {
        String[] splitted = logLine.split(":");
        return(splitted[1].trim());
    }

    public static String logLevel(String logLine) {
                String[] splitted = logLine.split(":");

        StringBuilder str = new StringBuilder();
        String logLev = splitted[0];
        for(int i=0; i< logLev.length() ; i++) {
            if (logLev.charAt(i) != ']'
 && logLev.charAt(i) != '[') {
                str.append(logLev.charAt(i));
            }
        }
        return str.toString().toLowerCase();
        
    }

    public static String reformat(String logLine) {
     return message(logLine)+" " + '(' + logLevel(logLine) + ')';
    }
}
