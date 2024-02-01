
public class SpellChecker {


	public static void main(String[] args) {
		String word = args[0];
		int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		String correction = spellChecker(word, threshold, dictionary);
		System.out.println(correction);
        // String str = "inbar" ;
		// System.out.println(tail(str));
		// String str1 = "love";
		// String str2 = "i";
		// System.out.println(levenshtein(str1,str2));

	}

	public static String tail(String str)
	 {
		if (str.length() == 1)
		{
           return null ;
		}
		String strNew = "";
		for ( int i =1; i < str.length(); i ++ )
		{
			strNew = strNew + str.charAt(i) ; 
		}
         return strNew ; 
	}

	public static int levenshtein(String word1, String word2) 
	{   
        if ( word1 == null)
		{
           return (word2 != null) ? word2.length() : 0 ; 
		}

		if (word2 == null)
		{
			return word1.length();
		}

		word1 = word1.toLowerCase(); 
		word2 = word2.toLowerCase();

		if ( word1.length() == 0 )
		{
			return word2.length(); 
		}
        if (word2.length() == 0)
		{
			return word1.length();
		}
		if (word1.charAt(0) == word2.charAt(0))
		{
			return levenshtein(tail(word1), tail(word2));
		}
		
	    int case1 = levenshtein(tail(word1), word2);
		int case2 = levenshtein(word1, tail(word2));
		int case3 = levenshtein(tail(word1), tail(word2));

        return (1 + (Math.min(Math.min(case1, case2), case3))) ;
			

	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];
		In in = new In(fileName);

		for ( int i =0; i < 3000 ; i ++)
		{
			dictionary[i]= in.readLine();
		}

		return dictionary;
	}

	public static String spellChecker(String word, int threshold, String[] dictionary)
    {
		String similar = ""; 
		int min = threshold;
		String similar2 = ""; 
		boolean find = false;
		for (int i =0; i < dictionary.length ; i ++)
		{
			if (levenshtein(dictionary[i], word) <= threshold)
			{   
				int destanse = levenshtein(dictionary[i], word);
                similar2 = dictionary[i]; 
				
                if (destanse < min || find == false)
				{
					similar = dictionary[i]; 
					min = destanse;
					find = true;
					
				}
			}
		}
		if (similar2 == "")
		{
			return word;
		}
		if (similar == "")
		{
           return similar2; 
		}
		else 
		{
			return similar; 
		}

		
	}

}
