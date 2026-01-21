// class for the NoNextCellException
public class NoNextCellException extends Exception{
    /*constructor without message*/
    public NoNextCellException(){
        super();
    }
    /**constructor with message
    * @param msg the message 
    */
    public NoNextCellException(String msg){
        super(msg);
    }
}