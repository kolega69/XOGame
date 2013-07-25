public class Chip {

	private char[][] chipXx;
	private char[][] chipOo;

    public Chip(){
        chipXx = new char[][] {
		        {'\\', ' ', '/'},
                {' ', 'X', ' '},
                {'/', ' ', '\\'}
        };
	    chipOo = new char[][] {
			    {'/', ' ', '\\'},
                {'|', ' ', '|'},
                {'\\', ' ', '/'}
        };
    }

	public char[][] getChipXx(){
		return chipXx;
	}
	public char[][] getChipOo(){
		return chipOo;
	}

}
