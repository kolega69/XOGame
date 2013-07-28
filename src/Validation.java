
public class Validation {

    private int[][] validationBoard;

    public Validation(int[][] vBoard) {
        validationBoard = vBoard;
    }

    public boolean isEmpty(int chip) {

       return  (chip == 0);

    }

}
