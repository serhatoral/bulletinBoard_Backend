package olorin.bulletinBoard.dataAccess.abstracts;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import olorin.bulletinBoard.entities.concretes.Announcement;
import olorin.bulletinBoard.entities.dtos.AnnouncementWithCategoryDto;

public interface AnnouncementDao extends JpaRepository<Announcement,Integer>{
	
	List<Announcement> getByAnnouncementTitleContains(String announcementTitle);
	List<Announcement> getByCategory_CategoryId(int categoryId);
	
	@Query("Select new olorin.bulletinBoard.entities.dtos.AnnouncementWithCategoryDto"
			+ "(a.announcementId, c.categoryName, a.announcementTitle, a.announcementText) "
			+ "From Category c Inner Join c.announcement a")
	List<AnnouncementWithCategoryDto> getAnnouncementDetails();
	
}
