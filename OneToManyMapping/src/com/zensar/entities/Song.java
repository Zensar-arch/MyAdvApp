package com.zensar.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Susmita Basak
 * @creation_date 27th Sept 2019 4.44pm
 * @modification_date 27th sept 2019 4.44pm
 * @version 2.0
 * @copyright Zensar Technologies.All rights reserved
 * @description It is a Song Class.
 *
 */
@Entity
public class Song {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int songId;
	private String songName;
	@ManyToOne
	@JoinColumn(name = "movie_Id")
	private Movie movie;
	
	public Song() {
		// TODO Auto-generated constructor stub
	}


	
	public Song(String songName) {
		super();
		this.songName = songName;
	}



	public int getSongId() {
		return songId;
	}

	public void setSongId(int songId) {
		this.songId = songId;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "Song [songId=" + songId + ", songName=" + songName + "]";
	}
	
	

}
