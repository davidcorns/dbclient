package core;

public class Util {

	public static boolean isFirstWordi(String first, String line) {
		return line.toUpperCase().startsWith(first.toUpperCase());
	}

	public static int countLines(String str)
	{
		if (str == null || str.length() == 0)
			return 0;
		int lines = 1;
		int len = str.length();
		for( int pos = 0; pos < len; pos++) {
			char c = str.charAt(pos);
			if( c == '\r' ) {
				lines++;
				if ( pos+1 < len && str.charAt(pos+1) == '\n' )
					pos++;
			} else if( c == '\n' ) {
				lines++;
			}
		}
		return lines;
	}

}	//class Util
