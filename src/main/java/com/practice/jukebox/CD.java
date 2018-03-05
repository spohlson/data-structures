package com.practice.jukebox;

public class CD {

	private String album;
	private Song[] songs;

	public CD(String album, Song[] songs) {
		this.album = album;
		this.songs = songs;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public Song[] getSongs() {
		return songs;
	}

	public void setSongs(Song[] songs) {
		this.songs = songs;
	}

}
