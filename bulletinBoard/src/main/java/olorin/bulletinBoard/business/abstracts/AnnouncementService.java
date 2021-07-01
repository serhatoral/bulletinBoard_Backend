package olorin.bulletinBoard.business.abstracts;

import java.util.List;
import olorin.bulletinBoard.core.utilities.results.DataResult;
import olorin.bulletinBoard.core.utilities.results.Result;
import olorin.bulletinBoard.entities.concretes.Announcement;
import olorin.bulletinBoard.entities.dtos.AnnouncementWithCategoryDto;

public interface AnnouncementService {

	DataResult<List<Announcement>> getAll();
	Result add(Announcement announcement);
	DataResult<List<Announcement>> getByAnnouncementTitleContains(String announcementTitle);
	DataResult<List<Announcement>> getByCategory(int categoryId);
	DataResult<List<AnnouncementWithCategoryDto>> getAnnouncementDetails();
}
