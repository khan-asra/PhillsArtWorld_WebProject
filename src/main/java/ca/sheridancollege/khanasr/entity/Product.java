package ca.sheridancollege.khanasr.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinTable;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder 
public class Product {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		public Long productId;
		public String productName;
		public Double price;
		
		@ManyToMany(fetch =FetchType.EAGER, cascade =CascadeType.ALL)
		@JoinTable( name = "product_images",
			joinColumns = {
				@JoinColumn(name="product_id")	
			},
			inverseJoinColumns = {
					@JoinColumn(name="image_id")
		
			}
		)
		public Set <ProductImage> productImages;
		public String description;
		
	}
