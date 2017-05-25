/**
 * 
 */
package com.starterkit.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starterkit.domain.Album;
import com.starterkit.mq.RabbitMQMessagePublisher;
import com.starterkit.repositories.JpaAlbumRepository;

/**
 * @author narendra.gurram@cognizant.com
 *
 */
@Service
public class AlbumService {

	@Autowired
	private JpaAlbumRepository jpaAlbumRepository;
	@Autowired
	private RabbitMQMessagePublisher rabbitMQMessagePublisher;
	
	/**
	 * Get all the task from 'Album' Table by calling the findAll method
	 * 
	 * @return List of Albums
	 */
	public List<Album> getAlbumList() {
		return (List<Album>) jpaAlbumRepository.findAll();
	}

	/**
	 * Remove the task from 'Album' table by calling delete method
	 * 
	 * @param albumId
	 */
	public void removeAlbum(String albumId) {
		Album album = getAlbum(albumId);
		jpaAlbumRepository.delete(albumId);
		rabbitMQMessagePublisher.publishMessage(album.toString(), UUID.randomUUID().toString().replaceAll("-", ""));

	}

	

	/**
	 * Save new task into 'Album' table by calling the save method
	 * 
	 * @param title
	 * @param artist
	 * @param releaseYear
	 * @return boolean
	 */
	public boolean saveAlbum(String title, String artist, String releaseYear) {
		Album album = new Album(title, artist, releaseYear);
		Album savedAlbum = jpaAlbumRepository.save(album);
		rabbitMQMessagePublisher.publishMessage(album.toString(), UUID.randomUUID().toString().replaceAll("-", ""));
		return album.getTitle().equalsIgnoreCase(savedAlbum.getTitle())? true : false;
	}

	/**
	 * Updated the album into 'Album' table by saving the album based on album id
	 * 
	 * @param id
	 * @param title
	 * @param artist
	 * @param releaseYear
	 * @return
	 */
	public boolean editAlbum(String id, String title, String artist, String releaseYear) {
		Album album = new Album(title, artist, releaseYear);
		album.setId(id);
		Album savedAlbum = jpaAlbumRepository.save(album);
		rabbitMQMessagePublisher.publishMessage(album.toString(), UUID.randomUUID().toString().replaceAll("-", ""));
		return album.getId().equals(savedAlbum.getId()) ? true : false;
	}

	public Album getAlbum(String id) {
	 	return jpaAlbumRepository.findOne(id);
	}
}
