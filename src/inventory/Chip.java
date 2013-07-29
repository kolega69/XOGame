package inventory;

public class Chip {

	private char[][] chipReturn;
//	private char[][] chipOo;

    public Chip(char chip){

        if (chip == '1'){
        chipReturn = new char[][] {
		        {'\\', ' ', '/'},
                {' ', 'X', ' '},
                {'/', ' ', '\\'}
                };
        } else {
	    chipReturn = new char[][] {
			    {'/', ' ', '\\'},
                {'|', ' ', '|'},
                {'\\', ' ', '/'}
                };
        }

   }

    public char[][] getChipReturn() {
        return chipReturn;
    }

}



