

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
		/* very bad to use here 3000!
  		you understand that your function is now limited to dictionaries of size 3000?
    		if i will give you size 2999 it will fail, and 3001 won't go threw everything
      		always try to use variables and not the number itself
		use dictionary.length - you are running over the dictionary it is more readable also.
			*/
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
