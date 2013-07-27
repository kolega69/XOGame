public class Chip {

	private char[][] chipReturn;
//	private char[][] chipOo;

    public Chip(char chip){

        if (chip == 'x'){
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



