class Badge {
    public String print(Integer id, String name, String department) {
        String printValue = "";
      if (id != null) {
          printValue = printValue +  "[" + id+"] - ";
      }
        if (name != null) {
          printValue = printValue +  name+" - ";
      }
         if (department != null) {
          printValue = printValue + department.toUpperCase();
      } else {
                      printValue = printValue + "OWNER";
 
      }
    return printValue;    
    }
}
