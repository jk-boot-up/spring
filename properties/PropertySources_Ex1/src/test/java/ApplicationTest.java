import com.explore.jk.spring.config.AppConfig;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
//@TestPropertySource("classpath:test.properties")
public class ApplicationTest {


    @Test
    //@Ignore
    public void testReportSubscriber() {

    }
}
