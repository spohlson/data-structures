package com.practice.jukebox;


public class Song {

	private String title;
	private String artist;
	private long lengthInSeconds;

	public Song(String title, String artist, long lengthInSeconds) {
		this.title = title;
		this.artist = artist;
		this.lengthInSeconds = lengthInSeconds;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public long getLengthInSeconds() {
		return lengthInSeconds;
	}

	public void setLengthInSeconds(long lengthInSeconds) {
		this.lengthInSeconds = lengthInSeconds;
	}

}
