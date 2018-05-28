package com.example.wisdomoftheday;

import java.util.ArrayList;
import java.util.Random;




public class WisdomDb {

	static private Random mRandom = new Random();
	static private ArrayList<String> mWisdom = new ArrayList<String>();

	
	
	/**
	 * Initializes the database with random brainy quotes
	 */
	static void init()
	{
		mWisdom.add("Whatever you do in life, surround yourself with smart people who'll argue with you.\n-- John Wooden");
		mWisdom.add("Talent is God given. Be humble. Fame is man-given. Be grateful. Conceit is self-given. Be careful.\n-- John Woodenm");
		mWisdom.add("It is a miracle that curiosity survives formal education. \n-- Albert Einstein");
		mWisdom.add("I spent three days a week for 10 years educating myself in the public library, and it's better than college. People should educate themselves - you can get a complete education for no money. At the end of 10 years, I had read every book in the library and I'd written a thousand stories. \n-- Ray Bradbury");
		mWisdom.add("Give a man a fish and you feed him for a day; teach a man to fish and you feed him for a lifetime. \n-- Maimonides");
		mWisdom.add("You are always a student, never a master. You have to keep moving forward.\n-- Conrad Hall");
		mWisdom.add("It's not what you look at that matters, it's what you see.\n-- Henry David Thoreau");
		mWisdom.add("The pessimist complains about the wind; the optimist expects it to change; the realist adjusts the sails.\n-- William Arthur Ward");
		mWisdom.add("We are what our thoughts have made us; so take care about what you think. Words are secondary. Thoughts live; they travel far.\n-- Swami Vivekananda");
		mWisdom.add("Reality is merely an illusion, albeit a very persistent one.\n-- Albert Einstein");
		mWisdom.add("The greatest obstacle to discovery is not ignorance - it is the illusion of knowledge.\n-- Daniel J. Boorstin");
	}
	
	
	
	
	/**
	 * Picks a ramdom wisdom and returns the quote.
	 * 
	 * @return a random quote, null if empty
	 */
	static String getRandom()
	{
		if(mWisdom.isEmpty())
			return null;
		
		return mWisdom.get( mRandom.nextInt( mWisdom.size() ) );
	}
	
	
	
	/**
	 * Allows to pick a quote at a specific index
	 * 
	 * @param i	index of the element to be returned
	 * @return the quote at index i or null if index is out of bounds
	 */
	static String get( int i)
	{
		if( i<0 || i >= mWisdom.size() )
			return null;
		
		return mWisdom.get( i );
	}
}
