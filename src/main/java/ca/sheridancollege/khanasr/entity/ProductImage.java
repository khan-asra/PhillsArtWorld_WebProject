package ca.sheridancollege.khanasr.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import lombok.Data;

@Entity
@Data
@Table(name ="image")
@AllArgsConstructor
@NoArgsConstructor
public class ProductImage {

	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long imageId;
	public String imageName;
	public String imageType;
	
	@Column(length=7000000)
	public byte[] imageByte;
	
	
public ProductImage(String originalFilename, String contentType, byte[] bytes) {
		this.imageByte=bytes;
		this.imageName=originalFilename;
		this.imageType= contentType;
	}
	
}
