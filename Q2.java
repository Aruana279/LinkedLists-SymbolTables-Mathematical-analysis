package akoshkarova.hw2;

/**
 * Building from Question 1, there are different questions to answer.
 * 
 * 1. What is the most frequently used word in the entire book?
 * 2. What are the top-ten most frequently used words in the entire book?
 * 3. How many words occur exactly once in the book?
 */
public class Q2 {

	static void mostFrequent() throws java.io.IOException {
		
		WordSymbolTable mostFrequentWST= new WordSymbolTable();
		int topTen=-1;
		
		for (int currChapter=1; currChapter<=45; currChapter++) {
			TaleOfTwoCitiesExtractor extractor= new TaleOfTwoCitiesExtractor(currChapter);
			
			while(extractor.hasNext()) {
				mostFrequentWST.increment(extractor.next());
			}
		}
		int totalNum=mostFrequentWST.totalCounts();
		double percentageNum= (double)(mostFrequentWST.count(mostFrequentWST.mostFrequent()))/totalNum;
		
		System.out.println(
				String.format("\"%s\" is the most frequent word, used %d times out of %d total words (%.2f%%)",
						mostFrequentWST.mostFrequent(), mostFrequentWST.count(mostFrequentWST.mostFrequent()), totalNum, percentageNum*100));

		
		System.out.println("The Top Ten words by frequency are:");
		
		int i=1;
		while(i<=10) {
			System.out.println(String.format("%2d. %s (%d)", i, mostFrequentWST.mostFrequent(), mostFrequentWST.count(mostFrequentWST.mostFrequent())));
			topTen+= mostFrequentWST.count(mostFrequentWST.mostFrequent());
			mostFrequentWST.remove(mostFrequentWST.mostFrequent());
			i++;
			
		}
		double topTenPercent=(double)(topTen)/totalNum;
		System.out.println(String.format("These ten words represent %.2f%% of the total words in the book", topTenPercent));

	}

	static void wordsUsedOnce() throws java.io.IOException {
		int numSingle = 0;
		int longest = 999;
		
		WordSymbolTable mostFrequentWST= new WordSymbolTable();
		for (int currChapter=1; currChapter<=45; currChapter++) {
			TaleOfTwoCitiesExtractor extractor= new TaleOfTwoCitiesExtractor(currChapter);
			
			while(extractor.hasNext()) {
				mostFrequentWST.increment(extractor.next());
			}
		}
		
		for (int currChapter=1; currChapter<=45; currChapter++) {
			TaleOfTwoCitiesExtractor extractor= new TaleOfTwoCitiesExtractor(currChapter);
			
			while(extractor.hasNext()) {
				if(mostFrequentWST.count(extractor.next())==1) {
					numSingle++;
				}
			}
		}
		
//			WordSymbolTable.Node n=mostFrequentWST.first;
//			int uniqueWords=0;
//			while(n!=null) {
//
//				if(n.count==1) {
//					uniqueWords+=1;
//				}
//				if(longest.lenght()<n.word.length()) {
//					longest=n.word;
//				}
//				n=n.next;
//			}
		//}
		// TODO
		
		System.out.println(String.format("%d words are used exactly once (longest is \"%s\")", numSingle, longest));
	}

	public static void main(String[] args) throws java.io.IOException {
		mostFrequent();
		wordsUsedOnce();
	}
}
