package com.centralesupelec.osy2018.myseries.models;

import java.time.ZonedDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "episode")
public class Episode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private ZonedDateTime airDate;
	private String description;
	
	@Column(name = "image_url")
	private String imageURL;
	
	@Column(name = "episode_number")
	private int episodeNumber;
	
	@ManyToOne
	@JoinColumn(name = "director_id")
	private Director director;
	
	@ManyToOne
	@JoinColumn(name = "season_id")
	private Season season;

	@OneToMany(mappedBy = "episode")
	private Set<ActorEpisode> actorepisode;

	public Episode(){
		
	}
  	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ZonedDateTime getAirDate() {
		return airDate;
	}
	public void setAirDate(ZonedDateTime airDate) {
		this.airDate = airDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
  
  public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}
	
	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public int getEpisodeNumber() {
		return episodeNumber;
	}

	public void setEpisodeNumber(int episodeNumber) {
		this.episodeNumber = episodeNumber;
	}
	
}