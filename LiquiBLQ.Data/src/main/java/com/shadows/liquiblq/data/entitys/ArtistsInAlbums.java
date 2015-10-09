// default package
// Generated 09-Oct-2015 13:21:36 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ArtistsInAlbums generated by hbm2java
 */
@Entity
@Table(name = "artists_in_albums")
public class ArtistsInAlbums implements java.io.Serializable {

	private int id;
	private Album album;
	private Artist artist;

	public ArtistsInAlbums() {
	}

	public ArtistsInAlbums(int id, Album album, Artist artist) {
		this.id = id;
		this.album = album;
		this.artist = artist;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "album", nullable = false)
	public Album getAlbum() {
		return this.album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "artist", nullable = false)
	public Artist getArtist() {
		return this.artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

}
