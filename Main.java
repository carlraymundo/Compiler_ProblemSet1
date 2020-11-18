import java.io.FileInputStream;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		
          try {
                FileInputStream inputStream = new FileInputStream("input.txt");	
                char[] byteArray = new char[inputStream.available()];
                String word = new String();
                ArrayList<String> wordList = new ArrayList<String>();

                //reading text file and adding to char array
                for(int j = 0; j < byteArray.length;j++)
                {
                  char byteInput = (char) inputStream.read();
                  //System.out.print(test);
                  byteArray[j] = byteInput;
                }


                //close input stream
                inputStream.close();

          //			//test
          //			System.out.println("Byte Array Size: " + byteArray.length);
          //			System.out.println("BYTE Array: ");
          //			for (int j=0; j < byteArray.length;j++) {
          //				System.out.print(byteArray[j]);
          //			}
          //			System.out.println("\n");
          //			
          //			if(byteArray[15] == '\r') {
          //				System.out.println("dashr");
          //			}


                //concat characters into strings and store into String Array (wordList)
                System.out.println("Data read from the file: ");
                for(int k = 0; k < byteArray.length;k++)
                {	
          //				System.out.print(byteArray[k]);
                  if(byteArray[k] ==' ' || byteArray[k]==',' || byteArray[k]=='\n' || byteArray[k] == '\r')
                  {
                    if(!(word.equals(""))){
                      wordList.add(word);
                    }
                    if (byteArray[k] == '\n') {
                      wordList.add('\n' + "");
                    }
                    word = "";
                  }
                  else
                  {
                    word = word.concat(byteArray[k]+"");
                    if(k == (byteArray.length - 1) && !(word.equals("")))
                    {
                      wordList.add(word);
                    }
                  }
                }

          //			System.out.println("Wordlist contents:");
          //			for(int m=0;m < wordList.size(); m++) {	
          //				System.out.println(wordList.get(m));
          //			}


                //output stream


                //DFA
                DFA dfa = new DFA();
                for(int a=0; a < wordList.size(); a++) {
                  dfa.reset();
                  int result = dfa.process(wordList.get(a));
                  System.out.print(dfa.accepted(result)); //write to text file
                }

                //close file

            }
            catch (Exception e){
              e.getStackTrace();
            }
	}
}
