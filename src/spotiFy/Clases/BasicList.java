package spotiFy.Clases;

import spotiFy.Song;

import java.util.HashMap;

public abstract class BasicList {
	
	private HashMap<String, Song> basicList =new HashMap<>();

	public BasicList(HashMap<String, Song> basicList)
	{
		
		this.basicList = basicList;
	}

	
	public void play() {
		
		
		
	}
}
