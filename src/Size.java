public class Size {
    static String Four = "4\"";
    static String Eight = "8\"";
    static String Twelve = "12\"";

  public static String fromInt(int i){
      switch (i){
          case 4:
              return Four;
          case 8:
              return Eight;
          case 12:
              return Twelve;
          default:
              throw new IllegalArgumentException("Invalid size.");
      }
  }
}
