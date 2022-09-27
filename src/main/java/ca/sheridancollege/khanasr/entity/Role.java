
package ca.sheridancollege.khanasr.entity;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;




/**
 * @author asra.k
 * Aug. 27, 2022
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity


public class Role {

	
    @Id
    private String roleName;
    private String roleDescription;

}

