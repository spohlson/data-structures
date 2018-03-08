package com.practice.jukebox;

import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Create a musical juke box that is a computer simulation that closely mirrors
 * physical CD jukeboxes and is free.
 */
public class JukeBox {

	/**
	 * 1. Create Jukebox
	 * 2. Create CDs & Songs
	 * 3. Create a queue for selected songs to be added to
	 * 4. Allow user to scroll through music and select song to play next
	 * 6. Insert song at end of queue
	 * 7. Play song from queue
	 */

	private static final Logger LOG = LoggerFactory.getLogger(JukeBox.class);

	private Thread thread;
	private PlayMusicTask playMusicTask;
	private LinkedList<PlayDetails> queue;
	private CD[] cds;

	public JukeBox() {
		queue = new LinkedList<PlayDetails>();
		createCDs();
		playMusicTask = new PlayMusicTask(cds, queue);
	}

	public void start() {
		thread = new Thread(playMusicTask);
		thread.start();
	}

	public void terminate() {
		if (thread != null) {
			playMusicTask.terminate();

			try {
				thread.join();
			} catch (InterruptedException e) {
				LOG.error("Failed to stop JukeBox", e);
			}
		}
	}

	private void createCDs() {
		int cdLimit = 20;
		int cdCount = 1;

		cds = new CD[cdLimit];

		int minSongs = 8;
		int maxSongs = 12;

		long minSongLength = 5L;
		long maxSongLength = 10L;

		while (cdCount != cdLimit) {
			int songLimit = minSongs + (int) (Math.random() * ((maxSongs - minSongs) + 1));

			Song[] songs = new Song[songLimit];
			String artist = "Artist " + cdCount;

			int songCount = 1;

			while (songCount != songLimit) {
				String title = "Song " + songCount;
				long lengthInSeconds = minSongLength
						+ (long) (Math.random() * ((maxSongLength - minSongLength) + 1));

				Song song = new Song(title, artist, lengthInSeconds);

				songs[songCount - 1] = song;

				songCount++;
			}

			String album = "Album " + cdCount;
			CD cd = new CD(album, songs);

			cds[cdCount - 1] = cd;

			cdCount++;
		}
	}

	public void selectSong(int cdIndex, int songIndex) {
		PlayDetails details = new PlayDetails(cdIndex, songIndex);
		queue.add(details);
	}

	public static void main(String[] args) {
		JukeBox jukeBox = new JukeBox();
		jukeBox.start();

		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			LOG.error("Failed to let JukeBox run for a minute");
		}

		jukeBox.terminate();
	}

}
