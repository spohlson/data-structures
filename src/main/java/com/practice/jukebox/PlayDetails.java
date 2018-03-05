package com.practice.jukebox;


public class PlayDetails {

	private int cdIndex;
	private int songIndex;

	public PlayDetails(int cdIndex, int songIndex) {
		this.cdIndex = cdIndex;
		this.songIndex = songIndex;
	}

	public int getCdIndex() {
		return cdIndex;
	}

	public void setCdIndex(int cdIndex) {
		this.cdIndex = cdIndex;
	}

	public int getSongIndex() {
		return songIndex;
	}

	public void setSongIndex(int songIndex) {
		this.songIndex = songIndex;
	}

}
