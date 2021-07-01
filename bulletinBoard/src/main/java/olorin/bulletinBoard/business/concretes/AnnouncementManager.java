package olorin.bulletinBoard.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import olorin.bulletinBoard.business.abstracts.AnnouncementService;
import olorin.bulletinBoard.core.utilities.results.DataResult;
import olorin.bulletinBoard.core.utilities.results.Result;
import olorin.bulletinBoard.core.utilities.results.SuccessDataResult;
import olorin.bulletinBoard.core.utilities.results.SuccessResult;
import olorin.bulletinBoard.dataAccess.abstracts.AnnouncementDao;
import olorin.bulletinBoard.entities.concretes.Announcement;
import olorin.bulletinBoard.entities.dtos.AnnouncementWithCategoryDto;

@Service
public class AnnouncementManager implements AnnouncementService{

	private AnnouncementDao announcementDao;
	
	@Autowired
	public AnnouncementManager(AnnouncementDao announcementDao) {
		super();
		this.announcementDao = announcementDao;
	}

	@Override
	public DataResult<List<Announcement>> getAll() {
		
		return new SuccessDataResult<List<Announcement>>(announcementDao.findAll(),"Duyurular listelendi.");
	}

	@Override
	public Result add(Announcement announcement) {
		this.announcementDao.save(announcement);
		return new SuccessResult("Duyuru eklendi.") ;
	}

	@Override
	public DataResult<List<Announcement>> getByAnnouncementTitleContains(String announcementTitle) {
		
		return new SuccessDataResult<List<Announcement>>(this.announcementDao.getByAnnouncementTitleContains(announcementTitle),
				"Duyuru başlığına göre arama sonuçlerı listelendi.");
	}

	@Override
	public DataResult<List<Announcement>> getByCategory(int categoryId) {
		
		return new SuccessDataResult<List<Announcement>>(this.announcementDao.getByCategory_CategoryId(categoryId));
	}

	@Override
	public DataResult<List<AnnouncementWithCategoryDto>> getAnnouncementDetails() {
		
		return new SuccessDataResult<List<AnnouncementWithCategoryDto>>
		(this.announcementDao.getAnnouncementDetails(),"Duyuru ayrıntıları listelendi");
	}

}
