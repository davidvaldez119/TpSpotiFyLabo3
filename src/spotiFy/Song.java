package spotiFy;

import spotiFy.Clases.Album;
import spotiFy.Clases.Artist;
import spotiFy.Clases.Genre;

public class Song {

	private String name;
	   private Double duration;
	   private Genre genre;
	   private Artist invvitedArtist;
	   private Album album;
	public Song(String name, Double duration, Genre genre, Artist invvitedArtist, Album album) {
		
		this.name = name;
		this.duration = duration;
		this.genre = genre;
		this.invvitedArtist = invvitedArtist;
		this.album = album;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getDuration() {
		return duration;
	}
	public void setDuration(Double duration) {
		this.duration = duration;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public Artist getInvvitedArtist() {
		return invvitedArtist;
	}
	public void setInvvitedArtist(Artist invvitedArtist) {
		this.invvitedArtist = invvitedArtist;
	}
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}
	@Override
	public String toString() {
		return "Song [name=" + name + ", duration=" + duration + ", genre=" + genre + ", invvitedArtist="
				+ invvitedArtist + ", album=" + album + "]";
	}
	   
	   
}
