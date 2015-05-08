package interloper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citc.messenger.interloper.InterloperApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = InterloperApplication.class)
@WebAppConfiguration
public class InterloperApplicationTests {

	@Test
	public void contextLoads() {
	}

}
