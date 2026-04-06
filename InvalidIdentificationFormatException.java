public class InvalidIdentificationFormatException extends RuntimeException {

  public InvalidIdentificationFormatException() {
    super("TCNO formati uygun degil. 11 haneli rakamlardan olusmalidir");
  }
  
}