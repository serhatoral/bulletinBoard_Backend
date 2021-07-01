package olorin.bulletinBoard.api.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import olorin.bulletinBoard.business.abstracts.AnnouncementService;
import olorin.bulletinBoard.core.utilities.results.DataResult;
import olorin.bulletinBoard.core.utilities.results.Result;
import olorin.bulletinBoard.entities.concretes.Announcement;
import olorin.bulletinBoard.entities.dtos.AnnouncementWithCategoryDto;

@RestController
@RequestMapping("/api/announcements")
public class AnnouncementsController {

	private AnnouncementService announcementService;
	
	@Autowired
	public AnnouncementsController(AnnouncementService announcementService) {
		super();
		this.announcementService = announcementService;
	}

	@GetMapping("/getAll")
	public DataResult<List<Announcement>> getAll() {		
	  return this.announcementService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Announcement announcement) {
		return this.announcementService.add(announcement);
	}
	
	
	@GetMapping("/getByProductName")
	public DataResult<List<Announcement>> getByProductName(@RequestParam String announcementTitle){
		return this.announcementService.getByAnnouncementTitleContains(announcementTitle);
	}
	
	@GetMapping("/getByCategoryId")
	public DataResult<List<Announcement>> getByCategoryId(@RequestParam int categoryId){
		return this.announcementService.getByCategory(categoryId);
	}
	
	@GetMapping("/getAnnouncementDetails")
	public DataResult<List<AnnouncementWithCategoryDto>> getAnnouncementDetails(){
		return this.announcementService.getAnnouncementDetails();
	}
	
}
