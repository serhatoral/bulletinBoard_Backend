package olorin.bulletinBoard.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name="Announcements")
@AllArgsConstructor
@NoArgsConstructor
public class Announcement { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="announcement_id")
	private int announcementId;
			
	@Column(name="announcement_title")
	private String announcementTitle;
	
	@Column(name="announcement_text")
	private String announcementText;
	
	@Column(name="announcement_date")
    private java.sql.Date announcementDate;
	
	@ManyToOne()
	@JoinColumn(name = "category_id")
	private Category category;

}
