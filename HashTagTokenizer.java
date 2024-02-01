

public class HashTagTokenizer {

	public static void main(String[] args) {

		String hashTag = args[0];
		String []dictionary = readDictionary("dictionary.txt");
	//	System.out.println(existInDictionary(hashTag , dictionary));
     // hashTag= hashTag.toLowerCase();
		breakHashTag(hashTag, dictionary);
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

	public static boolean existInDictionary(String word, String []dictionary) 
	{
		boolean find = false; 
		for ( int i = 0; i < 3000; i ++)
		{
			if (dictionary[i].equals(word))
			{
				find =  true; 
			}
		}
        return find; 
	}

	public static void breakHashTag(String hashtag, String[] dictionary)
	 {

        if (hashtag.isEmpty()) 
		{
            return;
        }
		
        hashtag = hashtag.toLowerCase(); 
        int N = hashtag.length();
		
        for (int i = 1; i <= N; i++) 
		{	
			String hasNew = hashtag.substring(0,i);
			
            if (existInDictionary(hasNew, dictionary) == true)
			{
				System.out.println(hasNew);
				breakHashTag(hashtag.substring(i), dictionary);
				return;
			}							
        }
		
    }

}
