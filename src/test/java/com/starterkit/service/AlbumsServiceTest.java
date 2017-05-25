package com.starterkit.service;
/**
 * 
 */

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.starterkit.Application;
import com.starterkit.domain.Album;
import com.starterkit.repositories.JpaAlbumRepository;
import com.starterkit.service.AlbumService;

/**
 * @author narendra.gurram@cognizant.com
 *
 */
@SpringBootTest(classes = Application.class)   
public class AlbumsServiceTest {

		@Mock
		private JpaAlbumRepository jpaAlbumRepository;

		@InjectMocks
		private AlbumService albumsService;
		
		
		@Before
		public void setUp() {
			MockitoAnnotations.initMocks(this);
		}
		 @Test
		 public void saveAlbumTest(){
			 Album album = new Album("yalini", "narendra", "1989");
			 album.setId("1");
			 when(jpaAlbumRepository.save(any(Album.class))).thenReturn(album);
			 boolean flag=albumsService.saveAlbum("yalini", "narendra", "1989");
			 Assert.assertTrue(flag);
		 }
		  @Test
		 public void getAlbumListTest(){
			 Album yaliniAlbum = new Album("Yalini", "narendra", "1989");
			 yaliniAlbum.setId("1");
			 Album azhahiAlbum = new Album("Azhahi", "narendra", "1989");
			 azhahiAlbum.setId("1");
		     List<Album> albumList=new ArrayList<Album>();
		     albumList.add(azhahiAlbum);
		     albumList.add(yaliniAlbum);
			 when(jpaAlbumRepository.findAll()).thenReturn(albumList);
			 Assert.assertArrayEquals(albumsService.getAlbumList().toArray(), albumList.toArray());
		 }
		 
		 @Test
		 public void editTasktest(){
			 Album yaliniAlbum = new Album("Yalini", "narendra", "1989");
			 yaliniAlbum.setId("1"); 
			 when(jpaAlbumRepository.save(any(Album.class))).thenReturn(yaliniAlbum);
			 boolean flag=albumsService.editAlbum("1", "Yalini", "narendra","1989");
			 Assert.assertTrue(flag);
		 }
		
		
		 
	}
