package olorin.bulletinBoard.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnnouncementWithCategoryDto {

	private int announcementId;
	private String categoryName;
	private String announcementTitle;
	private String announcementText;

}
