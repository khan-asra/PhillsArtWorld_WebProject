package ca.sheridancollege.khanasr;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootTest
class PhillsArtsWorldSpringBootAndAngularTests {

	@Test
	void contextLoads() {
	}
	
	
//	public 
//	
//    @GetMapping({"/forAdmin"})
//    @PreAuthorize("hasAnyRole('Admin','User')")
//    public String forAdmin(){
//        return "This URL is only accessible to the admin";
//    }
//	
//	
//	@Test
//
//    void testSortData() {
//
//        String first[] = { "d", "a", "b", "c" };
//
//        String second[] = TestSort.sortByName(first);
//
//        String result[] = { "a", "b", "c", "d" };
//
//        boolean match = true;
//
//        for (int i = 0; i < result.length; i++) {
//
//            if (!(second[i] == result[i])) {
//
//                match = false;
//
//            }
//
//        }
//
//
//
//        assertTrue("The Arrays were not sorted properly", match);
//
//    }

}
