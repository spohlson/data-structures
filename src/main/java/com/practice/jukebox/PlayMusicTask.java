package com.practice.jukebox;

import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlayMusicTask implements Runnable {

	private static final Logger LOG = LoggerFactory.getLogger(PlayMusicTask.class);

	private LinkedList<PlayDetails> queue;
	private CD[] cds;
	private boolean running;

	public PlayMusicTask(CD[] cds, LinkedList<PlayDetails> queue) {
		this.cds = cds;
		this.queue = queue;
	}

	public void terminate() {
		LOG.info("Stopping music");
		running = false;
	}

	@Override
	public void run() {
		LOG.info("Starting music");

		running = true;

		while (running) {

			if (!queue.isEmpty()) {
				PlayDetails details = upNext();

				CD cd = cds[details.getCdIndex()];
				Song song = cd.getSongs()[details.getSongIndex()];

				playSong(cd, song);
			}
		}
	}

	private synchronized PlayDetails upNext() {
		PlayDetails upNext = queue.removeFirst();
		return upNext;
	}

	private void playSong(CD cd, Song song) {
		String title = song.getTitle();
		String artist = song.getArtist();
		long length = song.getLengthInSeconds();
		String album = cd.getAlbum();

		String displayDetails = "Song - " + title + ", Artist - " + artist + ", Album - " + album;

		LOG.info("Playing: {}" + displayDetails);

		try {
			Thread.sleep(length);
		} catch (InterruptedException e) {
			LOG.error("Failed to play: {}", displayDetails, e);
		}
	}

}
